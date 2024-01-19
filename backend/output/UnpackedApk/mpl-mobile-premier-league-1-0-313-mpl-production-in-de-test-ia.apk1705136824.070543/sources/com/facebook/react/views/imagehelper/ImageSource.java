package com.facebook.react.views.imagehelper;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import com.dylanvann.fastimage.FastImageSource;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;

public class ImageSource {
    public boolean isResource;
    public double mSize;
    public String mSource;
    public Uri mUri;

    public ImageSource(Context context, String str, double d2, double d3) {
        this.mSource = str;
        this.mSize = d2 * d3;
        this.mUri = computeUri(context);
    }

    private Uri computeLocalUri(Context context) {
        this.isResource = true;
        int resourceDrawableId = ResourceDrawableIdHelper.getInstance().getResourceDrawableId(context, this.mSource);
        return resourceDrawableId > 0 ? new Builder().scheme(FastImageSource.LOCAL_RESOURCE_SCHEME).path(String.valueOf(resourceDrawableId)).build() : Uri.EMPTY;
    }

    private Uri computeUri(Context context) {
        try {
            Uri parse = Uri.parse(this.mSource);
            if (parse.getScheme() == null) {
                parse = computeLocalUri(context);
            }
            return parse;
        } catch (Exception unused) {
            return computeLocalUri(context);
        }
    }

    public double getSize() {
        return this.mSize;
    }

    public String getSource() {
        return this.mSource;
    }

    public Uri getUri() {
        Uri uri = this.mUri;
        ImageOriginUtils.assertNotNull(uri);
        return uri;
    }

    public boolean isResource() {
        return this.isResource;
    }

    public ImageSource(Context context, String str) {
        this(context, str, 0.0d, 0.0d);
    }
}
