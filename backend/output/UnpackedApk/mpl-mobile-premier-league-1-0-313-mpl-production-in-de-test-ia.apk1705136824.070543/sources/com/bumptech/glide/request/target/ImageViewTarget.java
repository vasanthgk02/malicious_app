package com.bumptech.glide.request.target;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.request.transition.Transition.ViewAdapter;

public abstract class ImageViewTarget<Z> extends ViewTarget<ImageView, Z> implements ViewAdapter {
    public Animatable animatable;

    public ImageViewTarget(ImageView imageView) {
        super(imageView);
    }

    public void onLoadCleared(Drawable drawable) {
        this.sizeDeterminer.clearCallbacksAndListener();
        Animatable animatable2 = this.animatable;
        if (animatable2 != null) {
            animatable2.stop();
        }
        setResourceInternal(null);
        ((ImageView) this.view).setImageDrawable(drawable);
    }

    public void onLoadFailed(Drawable drawable) {
        setResourceInternal(null);
        ((ImageView) this.view).setImageDrawable(drawable);
    }

    public void onLoadStarted(Drawable drawable) {
        setResourceInternal(null);
        ((ImageView) this.view).setImageDrawable(drawable);
    }

    public void onResourceReady(Z z, Transition<? super Z> transition) {
        if (transition == null || !transition.transition(z, this)) {
            setResourceInternal(z);
        } else if (z instanceof Animatable) {
            Animatable animatable2 = (Animatable) z;
            this.animatable = animatable2;
            animatable2.start();
        } else {
            this.animatable = null;
        }
    }

    public void onStart() {
        Animatable animatable2 = this.animatable;
        if (animatable2 != null) {
            animatable2.start();
        }
    }

    public void onStop() {
        Animatable animatable2 = this.animatable;
        if (animatable2 != null) {
            animatable2.stop();
        }
    }

    public abstract void setResource(Z z);

    public final void setResourceInternal(Z z) {
        setResource(z);
        if (z instanceof Animatable) {
            Animatable animatable2 = (Animatable) z;
            this.animatable = animatable2;
            animatable2.start();
            return;
        }
        this.animatable = null;
    }
}
