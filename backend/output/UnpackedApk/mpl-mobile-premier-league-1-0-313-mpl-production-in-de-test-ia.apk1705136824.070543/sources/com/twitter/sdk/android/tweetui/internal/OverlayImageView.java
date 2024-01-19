package com.twitter.sdk.android.tweetui.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class OverlayImageView extends ImageView {
    public Overlay overlay = new Overlay(null);

    public static class Overlay {
        public final Drawable drawable;

        public Overlay(Drawable drawable2) {
            this.drawable = drawable2;
        }
    }

    public OverlayImageView(Context context) {
        super(context);
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        Overlay overlay2 = this.overlay;
        int[] drawableState = getDrawableState();
        Drawable drawable = overlay2.drawable;
        if (drawable != null && drawable.isStateful()) {
            overlay2.drawable.setState(drawableState);
        }
    }

    public void invalidateDrawable(Drawable drawable) {
        if (drawable == this.overlay.drawable) {
            invalidate();
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Drawable drawable = this.overlay.drawable;
        if (drawable != null) {
            drawable.draw(canvas);
        }
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        Overlay overlay2 = this.overlay;
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        Drawable drawable = overlay2.drawable;
        if (drawable != null) {
            drawable.setBounds(0, 0, measuredWidth, measuredHeight);
        }
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Drawable drawable = this.overlay.drawable;
        if (drawable != null) {
            drawable.setBounds(0, 0, i, i2);
        }
    }

    public void setOverlayDrawable(Drawable drawable) {
        Overlay overlay2 = this.overlay;
        Drawable drawable2 = overlay2.drawable;
        if (drawable != drawable2) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
                unscheduleDrawable(overlay2.drawable);
            }
            if (drawable != null) {
                drawable.setCallback(this);
            }
            Overlay overlay3 = new Overlay(drawable);
            this.overlay = overlay3;
            int[] drawableState = getDrawableState();
            Drawable drawable3 = overlay3.drawable;
            if (drawable3 != null && drawable3.isStateful()) {
                overlay3.drawable.setState(drawableState);
            }
            requestLayout();
        }
    }

    public OverlayImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
