package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import co.hyperverge.hypersnapsdk.c.k;
import java.util.Arrays;

public class RoundedCornersDrawable extends ForwardingDrawable implements Rounded {
    public int mBorderColor = 0;
    public final Path mBorderPath = new Path();
    public final float[] mBorderRadii = new float[8];
    public float mBorderWidth = 0.0f;
    public final RectF mBounds = new RectF();
    public RectF mInsideBorderBounds;
    public Matrix mInsideBorderTransform;
    public boolean mIsCircle = false;
    public int mOverlayColor = 0;
    public float mPadding = 0.0f;
    public final Paint mPaint = new Paint(1);
    public boolean mPaintFilterBitmap = false;
    public final Path mPath = new Path();
    public final float[] mRadii = new float[8];
    public boolean mScaleDownInsideBorders = false;
    public final RectF mTempRectangle = new RectF();
    public Type mType = Type.OVERLAY_COLOR;

    public enum Type {
        OVERLAY_COLOR,
        CLIPPING
    }

    public RoundedCornersDrawable(Drawable drawable) {
        super(drawable);
    }

    public void draw(Canvas canvas) {
        this.mBounds.set(getBounds());
        int ordinal = this.mType.ordinal();
        if (ordinal == 0) {
            if (this.mScaleDownInsideBorders) {
                RectF rectF = this.mInsideBorderBounds;
                if (rectF == null) {
                    this.mInsideBorderBounds = new RectF(this.mBounds);
                    this.mInsideBorderTransform = new Matrix();
                } else {
                    rectF.set(this.mBounds);
                }
                RectF rectF2 = this.mInsideBorderBounds;
                float f2 = this.mBorderWidth;
                rectF2.inset(f2, f2);
                this.mInsideBorderTransform.setRectToRect(this.mBounds, this.mInsideBorderBounds, ScaleToFit.FILL);
                int save = canvas.save();
                canvas.clipRect(this.mBounds);
                canvas.concat(this.mInsideBorderTransform);
                Drawable drawable = this.mCurrentDelegate;
                if (drawable != null) {
                    drawable.draw(canvas);
                }
                canvas.restoreToCount(save);
            } else {
                Drawable drawable2 = this.mCurrentDelegate;
                if (drawable2 != null) {
                    drawable2.draw(canvas);
                }
            }
            this.mPaint.setStyle(Style.FILL);
            this.mPaint.setColor(this.mOverlayColor);
            this.mPaint.setStrokeWidth(0.0f);
            this.mPaint.setFilterBitmap(this.mPaintFilterBitmap);
            this.mPath.setFillType(FillType.EVEN_ODD);
            canvas.drawPath(this.mPath, this.mPaint);
            if (this.mIsCircle) {
                float width = ((this.mBounds.width() - this.mBounds.height()) + this.mBorderWidth) / 2.0f;
                float height = ((this.mBounds.height() - this.mBounds.width()) + this.mBorderWidth) / 2.0f;
                if (width > 0.0f) {
                    RectF rectF3 = this.mBounds;
                    float f3 = rectF3.left;
                    Canvas canvas2 = canvas;
                    canvas2.drawRect(f3, rectF3.top, f3 + width, rectF3.bottom, this.mPaint);
                    RectF rectF4 = this.mBounds;
                    float f4 = rectF4.right;
                    canvas2.drawRect(f4 - width, rectF4.top, f4, rectF4.bottom, this.mPaint);
                }
                if (height > 0.0f) {
                    RectF rectF5 = this.mBounds;
                    float f5 = rectF5.left;
                    float f6 = rectF5.top;
                    Canvas canvas3 = canvas;
                    canvas3.drawRect(f5, f6, rectF5.right, f6 + height, this.mPaint);
                    RectF rectF6 = this.mBounds;
                    float f7 = rectF6.left;
                    float f8 = rectF6.bottom;
                    canvas3.drawRect(f7, f8 - height, rectF6.right, f8, this.mPaint);
                }
            }
        } else if (ordinal == 1) {
            int save2 = canvas.save();
            canvas.clipPath(this.mPath);
            Drawable drawable3 = this.mCurrentDelegate;
            if (drawable3 != null) {
                drawable3.draw(canvas);
            }
            canvas.restoreToCount(save2);
        }
        if (this.mBorderColor != 0) {
            this.mPaint.setStyle(Style.STROKE);
            this.mPaint.setColor(this.mBorderColor);
            this.mPaint.setStrokeWidth(this.mBorderWidth);
            this.mPath.setFillType(FillType.EVEN_ODD);
            canvas.drawPath(this.mBorderPath, this.mPaint);
        }
    }

    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.mCurrentDelegate;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        updatePath();
    }

    public void setBorder(int i, float f2) {
        this.mBorderColor = i;
        this.mBorderWidth = f2;
        updatePath();
        invalidateSelf();
    }

    public void setCircle(boolean z) {
        this.mIsCircle = z;
        updatePath();
        invalidateSelf();
    }

    public void setPadding(float f2) {
        this.mPadding = f2;
        updatePath();
        invalidateSelf();
    }

    public void setPaintFilterBitmap(boolean z) {
        if (this.mPaintFilterBitmap != z) {
            this.mPaintFilterBitmap = z;
            invalidateSelf();
        }
    }

    public void setRadii(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.mRadii, 0.0f);
        } else {
            k.checkArgument(fArr.length == 8, (Object) "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.mRadii, 0, 8);
        }
        updatePath();
        invalidateSelf();
    }

    public void setRadius(float f2) {
        Arrays.fill(this.mRadii, f2);
        updatePath();
        invalidateSelf();
    }

    public void setScaleDownInsideBorders(boolean z) {
        this.mScaleDownInsideBorders = z;
        updatePath();
        invalidateSelf();
    }

    public final void updatePath() {
        float[] fArr;
        this.mPath.reset();
        this.mBorderPath.reset();
        this.mTempRectangle.set(getBounds());
        RectF rectF = this.mTempRectangle;
        float f2 = this.mPadding;
        rectF.inset(f2, f2);
        if (this.mType == Type.OVERLAY_COLOR) {
            this.mPath.addRect(this.mTempRectangle, Direction.CW);
        }
        if (this.mIsCircle) {
            this.mPath.addCircle(this.mTempRectangle.centerX(), this.mTempRectangle.centerY(), Math.min(this.mTempRectangle.width(), this.mTempRectangle.height()) / 2.0f, Direction.CW);
        } else {
            this.mPath.addRoundRect(this.mTempRectangle, this.mRadii, Direction.CW);
        }
        RectF rectF2 = this.mTempRectangle;
        float f3 = this.mPadding;
        rectF2.inset(-f3, -f3);
        RectF rectF3 = this.mTempRectangle;
        float f4 = this.mBorderWidth;
        rectF3.inset(f4 / 2.0f, f4 / 2.0f);
        if (this.mIsCircle) {
            this.mBorderPath.addCircle(this.mTempRectangle.centerX(), this.mTempRectangle.centerY(), Math.min(this.mTempRectangle.width(), this.mTempRectangle.height()) / 2.0f, Direction.CW);
        } else {
            int i = 0;
            while (true) {
                fArr = this.mBorderRadii;
                if (i >= fArr.length) {
                    break;
                }
                fArr[i] = (this.mRadii[i] + this.mPadding) - (this.mBorderWidth / 2.0f);
                i++;
            }
            this.mBorderPath.addRoundRect(this.mTempRectangle, fArr, Direction.CW);
        }
        RectF rectF4 = this.mTempRectangle;
        float f5 = this.mBorderWidth;
        rectF4.inset((-f5) / 2.0f, (-f5) / 2.0f);
    }
}
