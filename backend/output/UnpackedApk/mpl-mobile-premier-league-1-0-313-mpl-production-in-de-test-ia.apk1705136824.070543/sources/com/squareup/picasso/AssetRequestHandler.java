package com.squareup.picasso;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import com.squareup.picasso.Picasso.LoadedFrom;
import com.squareup.picasso.RequestHandler.Result;
import java.io.IOException;
import okio.Okio;

public class AssetRequestHandler extends RequestHandler {
    public static final String ANDROID_ASSET = "android_asset";
    public static final int ASSET_PREFIX_LENGTH = 22;
    public AssetManager assetManager;
    public final Context context;
    public final Object lock = new Object();

    public AssetRequestHandler(Context context2) {
        this.context = context2;
    }

    public static String getFilePath(Request request) {
        return request.uri.toString().substring(ASSET_PREFIX_LENGTH);
    }

    public boolean canHandleRequest(Request request) {
        Uri uri = request.uri;
        if (!"file".equals(uri.getScheme()) || uri.getPathSegments().isEmpty() || !ANDROID_ASSET.equals(uri.getPathSegments().get(0))) {
            return false;
        }
        return true;
    }

    public Result load(Request request, int i) throws IOException {
        if (this.assetManager == null) {
            synchronized (this.lock) {
                if (this.assetManager == null) {
                    this.assetManager = this.context.getAssets();
                }
            }
        }
        return new Result(Okio.source(this.assetManager.open(getFilePath(request))), LoadedFrom.DISK);
    }
}
