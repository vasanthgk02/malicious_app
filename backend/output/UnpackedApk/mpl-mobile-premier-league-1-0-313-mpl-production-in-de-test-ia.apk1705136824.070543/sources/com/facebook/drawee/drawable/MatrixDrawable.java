package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public class MatrixDrawable extends ForwardingDrawable {
    public Matrix mDrawMatrix;
    public int mUnderlyingHeight;
    public int mUnderlyingWidth;

    public final void configureBounds() {
        Drawable drawable = this.mCurrentDelegate;
        Rect bounds = getBounds();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        this.mUnderlyingWidth = intrinsicWidth;
        int intrinsicHeight = drawable.getIntrinsicHeight();
        this.mUnderlyingHeight = intrinsicHeight;
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            drawable.setBounds(bounds);
            this.mDrawMatrix = null;
            return;
        }
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        this.mDrawMatrix = null;
    }

    public void draw(Canvas canvas) {
        if (!(this.mUnderlyingWidth == this.mCurrentDelegate.getIntrinsicWidth() && this.mUnderlyingHeight == this.mCurrentDelegate.getIntrinsicHeight())) {
            configureBounds();
        }
        if (this.mDrawMatrix != null) {
            int save = canvas.save();
            canvas.clipRect(getBounds());
            canvas.concat(this.mDrawMatrix);
            Drawable drawable = this.mCurrentDelegate;
            if (drawable != null) {
                drawable.draw(canvas);
            }
            canvas.restoreToCount(save);
            return;
        }
        Drawable drawable2 = this.mCurrentDelegate;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    public void getTransform(Matrix matrix) {
        super.getTransform(matrix);
        Matrix matrix2 = this.mDrawMatrix;
        if (matrix2 != null) {
            matrix.preConcat(matrix2);
        }
    }

    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.mCurrentDelegate;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        configureBounds();
    }

    public Drawable setCurrent(Drawable drawable) {
        Drawable current = super.setCurrent(drawable);
        configureBounds();
        return current;
    }
}
