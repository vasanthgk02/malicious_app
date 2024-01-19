package com.bumptech.glide.load.data;

import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import com.bumptech.glide.load.data.DataFetcher.DataCallback;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.util.ContentLengthInputStream;
import com.bumptech.glide.util.LogTime;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.util.Map.Entry;
import org.jboss.netty.handler.codec.http.HttpHeaders.Names;

public class HttpUrlFetcher implements DataFetcher<InputStream> {
    public static final HttpUrlConnectionFactory DEFAULT_CONNECTION_FACTORY = new DefaultHttpUrlConnectionFactory();
    public final HttpUrlConnectionFactory connectionFactory;
    public final GlideUrl glideUrl;
    public volatile boolean isCancelled;
    public InputStream stream;
    public final int timeout;
    public HttpURLConnection urlConnection;

    public static class DefaultHttpUrlConnectionFactory implements HttpUrlConnectionFactory {
    }

    public interface HttpUrlConnectionFactory {
    }

    public HttpUrlFetcher(GlideUrl glideUrl2, int i) {
        HttpUrlConnectionFactory httpUrlConnectionFactory = DEFAULT_CONNECTION_FACTORY;
        this.glideUrl = glideUrl2;
        this.timeout = i;
        this.connectionFactory = httpUrlConnectionFactory;
    }

    public void cancel() {
        this.isCancelled = true;
    }

    public void cleanup() {
        InputStream inputStream = this.stream;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.urlConnection;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.urlConnection = null;
    }

    public Class<InputStream> getDataClass() {
        return InputStream.class;
    }

    public DataSource getDataSource() {
        return DataSource.REMOTE;
    }

    /* JADX INFO: finally extract failed */
    public void loadData(Priority priority, DataCallback<? super InputStream> dataCallback) {
        long logTime = LogTime.getLogTime();
        try {
            GlideUrl glideUrl2 = this.glideUrl;
            if (glideUrl2.safeUrl == null) {
                glideUrl2.safeUrl = new URL(glideUrl2.getSafeStringUrl());
            }
            dataCallback.onDataReady(loadDataWithRedirects(glideUrl2.safeUrl, 0, null, this.glideUrl.headers.getHeaders()));
            if (!Log.isLoggable("HttpUrlFetcher", 2)) {
                return;
            }
        } catch (IOException e2) {
            Log.isLoggable("HttpUrlFetcher", 3);
            dataCallback.onLoadFailed(e2);
            if (!Log.isLoggable("HttpUrlFetcher", 2)) {
                return;
            }
        } catch (Throwable th) {
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                LogTime.getElapsedMillis(logTime);
            }
            throw th;
        }
        LogTime.getElapsedMillis(logTime);
    }

    public final InputStream loadDataWithRedirects(URL url, int i, URL url2, Map<String, String> map) throws IOException {
        if (i < 5) {
            if (url2 != null) {
                try {
                    if (url.toURI().equals(url2.toURI())) {
                        throw new HttpException((String) "In re-direct loop");
                    }
                } catch (URISyntaxException unused) {
                }
            }
            if (((DefaultHttpUrlConnectionFactory) this.connectionFactory) != null) {
                this.urlConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection()));
                for (Entry next : map.entrySet()) {
                    this.urlConnection.addRequestProperty((String) next.getKey(), (String) next.getValue());
                }
                this.urlConnection.setConnectTimeout(this.timeout);
                this.urlConnection.setReadTimeout(this.timeout);
                boolean z = false;
                this.urlConnection.setUseCaches(false);
                this.urlConnection.setDoInput(true);
                this.urlConnection.setInstanceFollowRedirects(false);
                this.urlConnection.connect();
                this.stream = this.urlConnection.getInputStream();
                if (this.isCancelled) {
                    return null;
                }
                int responseCode = this.urlConnection.getResponseCode();
                int i2 = responseCode / 100;
                if (i2 == 2) {
                    HttpURLConnection httpURLConnection = this.urlConnection;
                    if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
                        this.stream = new ContentLengthInputStream(httpURLConnection.getInputStream(), (long) httpURLConnection.getContentLength());
                    } else {
                        if (Log.isLoggable("HttpUrlFetcher", 3)) {
                            httpURLConnection.getContentEncoding();
                        }
                        this.stream = httpURLConnection.getInputStream();
                    }
                    return this.stream;
                }
                if (i2 == 3) {
                    z = true;
                }
                if (z) {
                    String headerField = this.urlConnection.getHeaderField(Names.LOCATION);
                    if (!TextUtils.isEmpty(headerField)) {
                        URL url3 = new URL(url, headerField);
                        cleanup();
                        return loadDataWithRedirects(url3, i + 1, url, map);
                    }
                    throw new HttpException((String) "Received empty or null redirect url");
                } else if (responseCode == -1) {
                    throw new HttpException(responseCode);
                } else {
                    throw new HttpException(this.urlConnection.getResponseMessage(), responseCode);
                }
            } else {
                throw null;
            }
        } else {
            throw new HttpException((String) "Too many (> 5) redirects!");
        }
    }
}
