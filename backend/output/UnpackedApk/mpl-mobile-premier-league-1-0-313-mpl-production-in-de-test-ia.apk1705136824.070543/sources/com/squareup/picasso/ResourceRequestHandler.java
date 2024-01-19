package com.squareup.picasso;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.dylanvann.fastimage.FastImageSource;
import com.squareup.picasso.Picasso.LoadedFrom;
import com.squareup.picasso.RequestHandler.Result;
import java.io.IOException;

public class ResourceRequestHandler extends RequestHandler {
    public final Context context;

    public ResourceRequestHandler(Context context2) {
        this.context = context2;
    }

    public static Bitmap decodeResource(Resources resources, int i, Request request) {
        Options createBitmapOptions = RequestHandler.createBitmapOptions(request);
        if (RequestHandler.requiresInSampleSize(createBitmapOptions)) {
            BitmapFactory.decodeResource(resources, i, createBitmapOptions);
            RequestHandler.calculateInSampleSize(request.targetWidth, request.targetHeight, createBitmapOptions, request);
        }
        return BitmapFactory.decodeResource(resources, i, createBitmapOptions);
    }

    public boolean canHandleRequest(Request request) {
        if (request.resourceId != 0) {
            return true;
        }
        return FastImageSource.ANDROID_RESOURCE_SCHEME.equals(request.uri.getScheme());
    }

    public Result load(Request request, int i) throws IOException {
        Resources resources = Utils.getResources(this.context, request);
        return new Result(decodeResource(resources, Utils.getResourceId(resources, request), request), LoadedFrom.DISK);
    }
}
