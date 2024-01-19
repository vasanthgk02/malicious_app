package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;

public final class LinearDrawingDelegate extends DrawingDelegate<LinearProgressIndicatorSpec> {
    public float displayedCornerRadius;
    public float displayedTrackThickness;
    public float trackLength = 300.0f;

    public LinearDrawingDelegate(LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(linearProgressIndicatorSpec);
    }

    public static void drawRoundedEnd(Canvas canvas, Paint paint, float f2, float f3, float f4, boolean z, RectF rectF) {
        Canvas canvas2 = canvas;
        float f5 = f2;
        float f6 = f3;
        canvas.save();
        float f7 = f4;
        canvas.translate(f4, 0.0f);
        if (!z) {
            canvas.rotate(180.0f);
        }
        float f8 = ((-f5) / 2.0f) + f6;
        float f9 = (f5 / 2.0f) - f6;
        Canvas canvas3 = canvas;
        Paint paint2 = paint;
        canvas3.drawRect(-f6, f8, 0.0f, f9, paint2);
        canvas.save();
        canvas.translate(0.0f, f8);
        RectF rectF2 = rectF;
        canvas3.drawArc(rectF2, 180.0f, 90.0f, true, paint2);
        canvas.restore();
        canvas.translate(0.0f, f9);
        canvas3.drawArc(rectF2, 180.0f, -90.0f, true, paint2);
        canvas.restore();
    }

    public void adjustCanvas(Canvas canvas, float f2) {
        Rect clipBounds = canvas.getClipBounds();
        this.trackLength = (float) clipBounds.width();
        float f3 = (float) ((LinearProgressIndicatorSpec) this.spec).trackThickness;
        canvas.translate((((float) clipBounds.width()) / 2.0f) + ((float) clipBounds.left), Math.max(0.0f, ((float) (clipBounds.height() - ((LinearProgressIndicatorSpec) this.spec).trackThickness)) / 2.0f) + (((float) clipBounds.height()) / 2.0f) + ((float) clipBounds.top));
        if (((LinearProgressIndicatorSpec) this.spec).drawHorizontallyInverse) {
            canvas.scale(-1.0f, 1.0f);
        }
        if ((this.drawable.isShowing() && ((LinearProgressIndicatorSpec) this.spec).showAnimationBehavior == 1) || (this.drawable.isHiding() && ((LinearProgressIndicatorSpec) this.spec).hideAnimationBehavior == 2)) {
            canvas.scale(1.0f, -1.0f);
        }
        if (this.drawable.isShowing() || this.drawable.isHiding()) {
            canvas.translate(0.0f, ((f2 - 1.0f) * ((float) ((LinearProgressIndicatorSpec) this.spec).trackThickness)) / 2.0f);
        }
        float f4 = this.trackLength;
        canvas.clipRect((-f4) / 2.0f, (-f3) / 2.0f, f4 / 2.0f, f3 / 2.0f);
        S s = this.spec;
        this.displayedTrackThickness = ((float) ((LinearProgressIndicatorSpec) s).trackThickness) * f2;
        this.displayedCornerRadius = ((float) ((LinearProgressIndicatorSpec) s).trackCornerRadius) * f2;
    }

    public void fillIndicator(Canvas canvas, Paint paint, float f2, float f3, int i) {
        if (f2 != f3) {
            float f4 = this.trackLength;
            float f5 = this.displayedCornerRadius;
            float f6 = ((-f4) / 2.0f) + f5;
            float f7 = f4 - (f5 * 2.0f);
            float f8 = (f2 * f7) + f6;
            float f9 = (f7 * f3) + f6;
            paint.setStyle(Style.FILL);
            paint.setAntiAlias(true);
            paint.setColor(i);
            float f10 = this.displayedTrackThickness;
            Canvas canvas2 = canvas;
            canvas2.drawRect(f8, (-f10) / 2.0f, f9, f10 / 2.0f, paint);
            float f11 = this.displayedCornerRadius;
            float f12 = -f11;
            Paint paint2 = paint;
            RectF rectF = new RectF(f12, f12, f11, f11);
            drawRoundedEnd(canvas2, paint2, this.displayedTrackThickness, this.displayedCornerRadius, f8, true, rectF);
            drawRoundedEnd(canvas2, paint2, this.displayedTrackThickness, this.displayedCornerRadius, f9, false, rectF);
        }
    }

    public void fillTrack(Canvas canvas, Paint paint) {
        int compositeARGBWithAlpha = ImageOriginUtils.compositeARGBWithAlpha(((LinearProgressIndicatorSpec) this.spec).trackColor, this.drawable.totalAlpha);
        float f2 = ((-this.trackLength) / 2.0f) + this.displayedCornerRadius;
        float f3 = -f2;
        paint.setStyle(Style.FILL);
        paint.setAntiAlias(true);
        paint.setColor(compositeARGBWithAlpha);
        float f4 = this.displayedTrackThickness;
        Canvas canvas2 = canvas;
        canvas2.drawRect(f2, (-f4) / 2.0f, f3, f4 / 2.0f, paint);
        float f5 = this.displayedCornerRadius;
        float f6 = -f5;
        RectF rectF = new RectF(f6, f6, f5, f5);
        drawRoundedEnd(canvas2, paint, this.displayedTrackThickness, this.displayedCornerRadius, f2, true, rectF);
        drawRoundedEnd(canvas, paint, this.displayedTrackThickness, this.displayedCornerRadius, f3, false, rectF);
    }

    public int getPreferredHeight() {
        return ((LinearProgressIndicatorSpec) this.spec).trackThickness;
    }

    public int getPreferredWidth() {
        return -1;
    }
}
