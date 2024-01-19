package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import co.hyperverge.hypersnapsdk.c.k;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import java.util.Arrays;
import sfs2x.client.entities.invitation.InvitationReply;

public class RoundedColorDrawable extends Drawable implements Rounded {
    public int mAlpha = InvitationReply.EXPIRED;
    public int mBorderColor = 0;
    public final Path mBorderPath = new Path();
    public final float[] mBorderRadii = new float[8];
    public float mBorderWidth = 0.0f;
    public int mColor = 0;
    public float[] mInsideBorderRadii;
    public boolean mIsCircle = false;
    public float mPadding = 0.0f;
    public final Paint mPaint = new Paint(1);
    public boolean mPaintFilterBitmap = false;
    public final Path mPath = new Path();
    public final float[] mRadii = new float[8];
    public boolean mScaleDownInsideBorders = false;
    public final RectF mTempRect = new RectF();

    public RoundedColorDrawable(int i) {
        if (this.mColor != i) {
            this.mColor = i;
            invalidateSelf();
        }
    }

    public void draw(Canvas canvas) {
        this.mPaint.setColor(ImageOriginUtils.multiplyColorAlpha(this.mColor, this.mAlpha));
        this.mPaint.setStyle(Style.FILL);
        this.mPaint.setFilterBitmap(this.mPaintFilterBitmap);
        canvas.drawPath(this.mPath, this.mPaint);
        if (this.mBorderWidth != 0.0f) {
            this.mPaint.setColor(ImageOriginUtils.multiplyColorAlpha(this.mBorderColor, this.mAlpha));
            this.mPaint.setStyle(Style.STROKE);
            this.mPaint.setStrokeWidth(this.mBorderWidth);
            canvas.drawPath(this.mBorderPath, this.mPaint);
        }
    }

    public int getAlpha() {
        return this.mAlpha;
    }

    public int getOpacity() {
        int multiplyColorAlpha = ImageOriginUtils.multiplyColorAlpha(this.mColor, this.mAlpha) >>> 24;
        if (multiplyColorAlpha == 255) {
            return -1;
        }
        return multiplyColorAlpha == 0 ? -2 : -3;
    }

    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        updatePath();
    }

    public void setAlpha(int i) {
        if (i != this.mAlpha) {
            this.mAlpha = i;
            invalidateSelf();
        }
    }

    public void setBorder(int i, float f2) {
        if (this.mBorderColor != i) {
            this.mBorderColor = i;
            invalidateSelf();
        }
        if (this.mBorderWidth != f2) {
            this.mBorderWidth = f2;
            updatePath();
            invalidateSelf();
        }
    }

    public void setCircle(boolean z) {
        this.mIsCircle = z;
        updatePath();
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public void setPadding(float f2) {
        if (this.mPadding != f2) {
            this.mPadding = f2;
            updatePath();
            invalidateSelf();
        }
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
        k.checkArgument(f2 >= 0.0f, (Object) "radius should be non negative");
        Arrays.fill(this.mRadii, f2);
        updatePath();
        invalidateSelf();
    }

    public void setScaleDownInsideBorders(boolean z) {
        if (this.mScaleDownInsideBorders != z) {
            this.mScaleDownInsideBorders = z;
            updatePath();
            invalidateSelf();
        }
    }

    public final void updatePath() {
        float[] fArr;
        float[] fArr2;
        this.mPath.reset();
        this.mBorderPath.reset();
        this.mTempRect.set(getBounds());
        RectF rectF = this.mTempRect;
        float f2 = this.mBorderWidth;
        rectF.inset(f2 / 2.0f, f2 / 2.0f);
        int i = 0;
        if (this.mIsCircle) {
            this.mBorderPath.addCircle(this.mTempRect.centerX(), this.mTempRect.centerY(), Math.min(this.mTempRect.width(), this.mTempRect.height()) / 2.0f, Direction.CW);
        } else {
            int i2 = 0;
            while (true) {
                fArr2 = this.mBorderRadii;
                if (i2 >= fArr2.length) {
                    break;
                }
                fArr2[i2] = (this.mRadii[i2] + this.mPadding) - (this.mBorderWidth / 2.0f);
                i2++;
            }
            this.mBorderPath.addRoundRect(this.mTempRect, fArr2, Direction.CW);
        }
        RectF rectF2 = this.mTempRect;
        float f3 = this.mBorderWidth;
        rectF2.inset((-f3) / 2.0f, (-f3) / 2.0f);
        float f4 = this.mPadding + (this.mScaleDownInsideBorders ? this.mBorderWidth : 0.0f);
        this.mTempRect.inset(f4, f4);
        if (this.mIsCircle) {
            this.mPath.addCircle(this.mTempRect.centerX(), this.mTempRect.centerY(), Math.min(this.mTempRect.width(), this.mTempRect.height()) / 2.0f, Direction.CW);
        } else if (this.mScaleDownInsideBorders) {
            if (this.mInsideBorderRadii == null) {
                this.mInsideBorderRadii = new float[8];
            }
            while (true) {
                fArr = this.mInsideBorderRadii;
                if (i >= fArr.length) {
                    break;
                }
                fArr[i] = this.mRadii[i] - this.mBorderWidth;
                i++;
            }
            this.mPath.addRoundRect(this.mTempRect, fArr, Direction.CW);
        } else {
            this.mPath.addRoundRect(this.mTempRect, this.mRadii, Direction.CW);
        }
        float f5 = -f4;
        this.mTempRect.inset(f5, f5);
    }
}
