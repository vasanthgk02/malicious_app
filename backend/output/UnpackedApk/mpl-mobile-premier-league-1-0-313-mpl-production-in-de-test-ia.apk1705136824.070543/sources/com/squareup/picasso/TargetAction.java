package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.squareup.picasso.Picasso.LoadedFrom;

public final class TargetAction extends Action<Target> {
    public TargetAction(Picasso picasso, Target target, Request request, int i, int i2, Drawable drawable, String str, Object obj, int i3) {
        super(picasso, target, request, i, i2, i3, drawable, str, obj, false);
    }

    public void complete(Bitmap bitmap, LoadedFrom loadedFrom) {
        if (bitmap != null) {
            Target target = (Target) getTarget();
            if (target != null) {
                target.onBitmapLoaded(bitmap, loadedFrom);
                if (bitmap.isRecycled()) {
                    throw new IllegalStateException("Target callback must not recycle bitmap!");
                }
                return;
            }
            return;
        }
        throw new AssertionError(String.format("Attempted to complete action with no result!\n%s", new Object[]{this}));
    }

    public void error(Exception exc) {
        Target target = (Target) getTarget();
        if (target == null) {
            return;
        }
        if (this.errorResId != 0) {
            target.onBitmapFailed(exc, this.picasso.context.getResources().getDrawable(this.errorResId));
        } else {
            target.onBitmapFailed(exc, this.errorDrawable);
        }
    }
}
