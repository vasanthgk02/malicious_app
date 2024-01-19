package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;

public final class CircularDrawingDelegate extends DrawingDelegate<CircularProgressIndicatorSpec> {
    public float adjustedRadius;
    public int arcDirectionFactor = 1;
    public float displayedCornerRadius;
    public float displayedTrackThickness;

    public CircularDrawingDelegate(CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        super(circularProgressIndicatorSpec);
    }

    public void adjustCanvas(Canvas canvas, float f2) {
        S s = this.spec;
        float f3 = (((float) ((CircularProgressIndicatorSpec) s).indicatorSize) / 2.0f) + ((float) ((CircularProgressIndicatorSpec) s).indicatorInset);
        canvas.translate(f3, f3);
        canvas.rotate(-90.0f);
        float f4 = -f3;
        canvas.clipRect(f4, f4, f3, f3);
        this.arcDirectionFactor = ((CircularProgressIndicatorSpec) this.spec).indicatorDirection == 0 ? 1 : -1;
        S s2 = this.spec;
        this.displayedTrackThickness = ((float) ((CircularProgressIndicatorSpec) s2).trackThickness) * f2;
        this.displayedCornerRadius = ((float) ((CircularProgressIndicatorSpec) s2).trackCornerRadius) * f2;
        this.adjustedRadius = ((float) (((CircularProgressIndicatorSpec) s2).indicatorSize - ((CircularProgressIndicatorSpec) s2).trackThickness)) / 2.0f;
        if ((this.drawable.isShowing() && ((CircularProgressIndicatorSpec) this.spec).showAnimationBehavior == 2) || (this.drawable.isHiding() && ((CircularProgressIndicatorSpec) this.spec).hideAnimationBehavior == 1)) {
            this.adjustedRadius = (((1.0f - f2) * ((float) ((CircularProgressIndicatorSpec) this.spec).trackThickness)) / 2.0f) + this.adjustedRadius;
        } else if ((this.drawable.isShowing() && ((CircularProgressIndicatorSpec) this.spec).showAnimationBehavior == 1) || (this.drawable.isHiding() && ((CircularProgressIndicatorSpec) this.spec).hideAnimationBehavior == 2)) {
            this.adjustedRadius -= ((1.0f - f2) * ((float) ((CircularProgressIndicatorSpec) this.spec).trackThickness)) / 2.0f;
        }
    }

    public final void drawRoundedEnd(Canvas canvas, Paint paint, float f2, float f3, float f4, boolean z, RectF rectF) {
        Canvas canvas2 = canvas;
        float f5 = z ? -1.0f : 1.0f;
        canvas.save();
        canvas.rotate(f4);
        float f6 = f2 / 2.0f;
        float f7 = f5 * f3;
        Paint paint2 = paint;
        canvas.drawRect((this.adjustedRadius - f6) + f3, Math.min(0.0f, ((float) this.arcDirectionFactor) * f7), (this.adjustedRadius + f6) - f3, Math.max(0.0f, f7 * ((float) this.arcDirectionFactor)), paint2);
        canvas.translate((this.adjustedRadius - f6) + f3, 0.0f);
        RectF rectF2 = rectF;
        canvas.drawArc(rectF2, 180.0f, (-f5) * 90.0f * ((float) this.arcDirectionFactor), true, paint2);
        canvas.translate(f2 - (f3 * 2.0f), 0.0f);
        canvas.drawArc(rectF2, 0.0f, f5 * 90.0f * ((float) this.arcDirectionFactor), true, paint2);
        canvas.restore();
    }

    public void fillIndicator(Canvas canvas, Paint paint, float f2, float f3, int i) {
        if (f2 != f3) {
            paint.setStyle(Style.STROKE);
            paint.setStrokeCap(Cap.BUTT);
            paint.setAntiAlias(true);
            paint.setColor(i);
            paint.setStrokeWidth(this.displayedTrackThickness);
            float f4 = (float) this.arcDirectionFactor;
            float f5 = f2 * 360.0f * f4;
            if (f3 < f2) {
                f3 += 1.0f;
            }
            float f6 = (f3 - f2) * 360.0f * f4;
            float f7 = this.adjustedRadius;
            float f8 = -f7;
            canvas.drawArc(new RectF(f8, f8, f7, f7), f5, f6, false, paint);
            if (this.displayedCornerRadius > 0.0f && Math.abs(f6) < 360.0f) {
                paint.setStyle(Style.FILL);
                float f9 = this.displayedCornerRadius;
                float f10 = -f9;
                RectF rectF = new RectF(f10, f10, f9, f9);
                drawRoundedEnd(canvas, paint, this.displayedTrackThickness, this.displayedCornerRadius, f5, true, rectF);
                drawRoundedEnd(canvas, paint, this.displayedTrackThickness, this.displayedCornerRadius, f5 + f6, false, rectF);
            }
        }
    }

    public void fillTrack(Canvas canvas, Paint paint) {
        int compositeARGBWithAlpha = ImageOriginUtils.compositeARGBWithAlpha(((CircularProgressIndicatorSpec) this.spec).trackColor, this.drawable.totalAlpha);
        paint.setStyle(Style.STROKE);
        paint.setStrokeCap(Cap.BUTT);
        paint.setAntiAlias(true);
        paint.setColor(compositeARGBWithAlpha);
        paint.setStrokeWidth(this.displayedTrackThickness);
        float f2 = this.adjustedRadius;
        float f3 = -f2;
        canvas.drawArc(new RectF(f3, f3, f2, f2), 0.0f, 360.0f, false, paint);
    }

    public int getPreferredHeight() {
        CircularProgressIndicatorSpec circularProgressIndicatorSpec = (CircularProgressIndicatorSpec) this.spec;
        return (circularProgressIndicatorSpec.indicatorInset * 2) + circularProgressIndicatorSpec.indicatorSize;
    }

    public int getPreferredWidth() {
        CircularProgressIndicatorSpec circularProgressIndicatorSpec = (CircularProgressIndicatorSpec) this.spec;
        return (circularProgressIndicatorSpec.indicatorInset * 2) + circularProgressIndicatorSpec.indicatorSize;
    }
}
