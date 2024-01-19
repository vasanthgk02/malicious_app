package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.Drawable;

public final class NonOwnedDrawableResource extends DrawableResource<Drawable> {
    public NonOwnedDrawableResource(Drawable drawable) {
        super(drawable);
    }

    public Class<Drawable> getResourceClass() {
        return this.drawable.getClass();
    }

    public int getSize() {
        return Math.max(1, this.drawable.getIntrinsicHeight() * this.drawable.getIntrinsicWidth() * 4);
    }

    public void recycle() {
    }
}
