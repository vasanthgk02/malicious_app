package com.squareup.picasso;

import android.net.NetworkInfo;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.squareup.picasso.Picasso.LoadedFrom;
import com.squareup.picasso.RequestHandler.Result;
import java.io.IOException;
import okhttp3.CacheControl;
import okhttp3.CacheControl.Builder;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Source;

public class NetworkRequestHandler extends RequestHandler {
    public static final String SCHEME_HTTP = "http";
    public static final String SCHEME_HTTPS = "https";
    public final Downloader downloader;
    public final Stats stats;

    public static class ContentLengthException extends IOException {
        public ContentLengthException(String str) {
            super(str);
        }
    }

    public static final class ResponseException extends IOException {
        public final int code;
        public final int networkPolicy;

        public ResponseException(int i, int i2) {
            super(GeneratedOutlineSupport.outline41("HTTP ", i));
            this.code = i;
            this.networkPolicy = i2;
        }
    }

    public NetworkRequestHandler(Downloader downloader2, Stats stats2) {
        this.downloader = downloader2;
        this.stats = stats2;
    }

    public static Request createRequest(Request request, int i) {
        CacheControl cacheControl;
        if (i == 0) {
            cacheControl = null;
        } else if (NetworkPolicy.isOfflineOnly(i)) {
            cacheControl = CacheControl.FORCE_CACHE;
        } else {
            Builder builder = new Builder();
            if (!NetworkPolicy.shouldReadFromDiskCache(i)) {
                builder.noCache();
            }
            if (!NetworkPolicy.shouldWriteToDiskCache(i)) {
                builder.noStore();
            }
            cacheControl = builder.build();
        }
        Request.Builder url = new Request.Builder().url(request.uri.toString());
        if (cacheControl != null) {
            url.cacheControl(cacheControl);
        }
        return url.build();
    }

    public boolean canHandleRequest(Request request) {
        String scheme = request.uri.getScheme();
        return SCHEME_HTTP.equals(scheme) || SCHEME_HTTPS.equals(scheme);
    }

    public int getRetryCount() {
        return 2;
    }

    public Result load(Request request, int i) throws IOException {
        Response load = this.downloader.load(createRequest(request, i));
        ResponseBody body = load.body();
        if (load.isSuccessful()) {
            LoadedFrom loadedFrom = load.cacheResponse() == null ? LoadedFrom.NETWORK : LoadedFrom.DISK;
            if (loadedFrom == LoadedFrom.DISK && body.contentLength() == 0) {
                body.close();
                throw new ContentLengthException("Received response with 0 content-length header.");
            }
            if (loadedFrom == LoadedFrom.NETWORK && body.contentLength() > 0) {
                this.stats.dispatchDownloadFinished(body.contentLength());
            }
            return new Result((Source) body.source(), loadedFrom);
        }
        body.close();
        throw new ResponseException(load.code(), request.networkPolicy);
    }

    public boolean shouldRetry(boolean z, NetworkInfo networkInfo) {
        return networkInfo == null || networkInfo.isConnected();
    }

    public boolean supportsReplay() {
        return true;
    }
}
