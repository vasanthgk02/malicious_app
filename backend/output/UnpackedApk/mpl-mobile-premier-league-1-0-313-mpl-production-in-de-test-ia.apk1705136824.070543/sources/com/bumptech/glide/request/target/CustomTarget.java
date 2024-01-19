package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.util.Util;

public abstract class CustomTarget<T> implements Target<T> {
    public final int height;
    public Request request;
    public final int width;

    public CustomTarget(int i, int i2) {
        if (Util.isValidDimensions(i, i2)) {
            this.width = i;
            this.height = i2;
            return;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline43("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: ", i, " and height: ", i2));
    }

    public final Request getRequest() {
        return this.request;
    }

    public final void getSize(SizeReadyCallback sizeReadyCallback) {
        sizeReadyCallback.onSizeReady(this.width, this.height);
    }

    public void onDestroy() {
    }

    public void onLoadFailed(Drawable drawable) {
    }

    public void onLoadStarted(Drawable drawable) {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public final void removeCallback(SizeReadyCallback sizeReadyCallback) {
    }

    public final void setRequest(Request request2) {
        this.request = request2;
    }
}
