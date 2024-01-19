package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;

@Deprecated
public abstract class BaseTarget<Z> implements Target<Z> {
    public void onDestroy() {
    }

    public void onLoadFailed(Drawable drawable) {
    }

    public void onStart() {
    }

    public void onStop() {
    }
}
