package com.facebook.imagepipeline.image;

import android.net.Uri;

public class OriginalEncodedImageInfo {
    public final Object mCallerContext;
    public final int mHeight;
    public final EncodedImageOrigin mOrigin;
    public final int mSize;
    public final Uri mUri;
    public final int mWidth;

    public OriginalEncodedImageInfo(Uri uri, EncodedImageOrigin encodedImageOrigin, Object obj, int i, int i2, int i3) {
        this.mUri = uri;
        this.mOrigin = encodedImageOrigin;
        this.mCallerContext = obj;
        this.mWidth = i;
        this.mHeight = i2;
        this.mSize = i3;
    }

    public Object getCallerContext() {
        return this.mCallerContext;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public EncodedImageOrigin getOrigin() {
        return this.mOrigin;
    }

    public int getSize() {
        return this.mSize;
    }

    public Uri getUri() {
        return this.mUri;
    }

    public int getWidth() {
        return this.mWidth;
    }
}
