package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import co.hyperverge.hypersnapsdk.c.k;

public class ScaleTypeDrawable extends ForwardingDrawable {
    public Matrix mDrawMatrix;
    public PointF mFocusPoint = null;
    public ScalingUtils$ScaleType mScaleType;
    public Object mScaleTypeState;
    public Matrix mTempMatrix = new Matrix();
    public int mUnderlyingHeight = 0;
    public int mUnderlyingWidth = 0;

    public ScaleTypeDrawable(Drawable drawable, ScalingUtils$ScaleType scalingUtils$ScaleType) {
        super(drawable);
        this.mScaleType = scalingUtils$ScaleType;
    }

    public void configureBounds() {
        Drawable drawable = this.mCurrentDelegate;
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        this.mUnderlyingWidth = intrinsicWidth;
        int intrinsicHeight = drawable.getIntrinsicHeight();
        this.mUnderlyingHeight = intrinsicHeight;
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            drawable.setBounds(bounds);
            this.mDrawMatrix = null;
        } else if (intrinsicWidth == width && intrinsicHeight == height) {
            drawable.setBounds(bounds);
            this.mDrawMatrix = null;
        } else if (this.mScaleType == ScalingUtils$ScaleType.FIT_XY) {
            drawable.setBounds(bounds);
            this.mDrawMatrix = null;
        } else {
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            ScalingUtils$ScaleType scalingUtils$ScaleType = this.mScaleType;
            Matrix matrix = this.mTempMatrix;
            PointF pointF = this.mFocusPoint;
            float f2 = pointF != null ? pointF.x : 0.5f;
            PointF pointF2 = this.mFocusPoint;
            ((ScalingUtils$AbstractScaleType) scalingUtils$ScaleType).getTransform(matrix, bounds, intrinsicWidth, intrinsicHeight, f2, pointF2 != null ? pointF2.y : 0.5f);
            this.mDrawMatrix = this.mTempMatrix;
        }
    }

    public final void configureBoundsIfUnderlyingChanged() {
        boolean z;
        ScalingUtils$ScaleType scalingUtils$ScaleType = this.mScaleType;
        boolean z2 = true;
        if (scalingUtils$ScaleType instanceof ScalingUtils$StatefulScaleType) {
            Object state = ((ScalingUtils$StatefulScaleType) scalingUtils$ScaleType).getState();
            z = state == null || !state.equals(this.mScaleTypeState);
            this.mScaleTypeState = state;
        } else {
            z = false;
        }
        if (this.mUnderlyingWidth == this.mCurrentDelegate.getIntrinsicWidth() && this.mUnderlyingHeight == this.mCurrentDelegate.getIntrinsicHeight()) {
            z2 = false;
        }
        if (z2 || z) {
            configureBounds();
        }
    }

    public void draw(Canvas canvas) {
        configureBoundsIfUnderlyingChanged();
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
        getParentTransform(matrix);
        configureBoundsIfUnderlyingChanged();
        Matrix matrix2 = this.mDrawMatrix;
        if (matrix2 != null) {
            matrix.preConcat(matrix2);
        }
    }

    public void onBoundsChange(Rect rect) {
        configureBounds();
    }

    public Drawable setCurrent(Drawable drawable) {
        Drawable current = super.setCurrent(drawable);
        configureBounds();
        return current;
    }

    public void setScaleType(ScalingUtils$ScaleType scalingUtils$ScaleType) {
        if (!k.equal(this.mScaleType, scalingUtils$ScaleType)) {
            this.mScaleType = scalingUtils$ScaleType;
            this.mScaleTypeState = null;
            configureBounds();
            invalidateSelf();
        }
    }
}
