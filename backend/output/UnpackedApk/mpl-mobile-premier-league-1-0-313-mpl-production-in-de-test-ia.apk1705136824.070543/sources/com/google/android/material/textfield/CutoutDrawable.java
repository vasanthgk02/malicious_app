package com.google.android.material.textfield;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable.Callback;
import android.view.View;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;

public class CutoutDrawable extends MaterialShapeDrawable {
    public final RectF cutoutBounds;
    public final Paint cutoutPaint;
    public int savedLayer;

    public CutoutDrawable() {
        this(null);
    }

    public void draw(Canvas canvas) {
        Callback callback = getCallback();
        if (callback instanceof View) {
            View view = (View) callback;
            if (view.getLayerType() != 2) {
                view.setLayerType(2, null);
            }
        } else {
            this.savedLayer = canvas.saveLayer(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight(), null);
        }
        super.draw(canvas);
        canvas.drawRect(this.cutoutBounds, this.cutoutPaint);
        if (!(getCallback() instanceof View)) {
            canvas.restoreToCount(this.savedLayer);
        }
    }

    public void setCutout(float f2, float f3, float f4, float f5) {
        RectF rectF = this.cutoutBounds;
        if (f2 != rectF.left || f3 != rectF.top || f4 != rectF.right || f5 != rectF.bottom) {
            this.cutoutBounds.set(f2, f3, f4, f5);
            invalidateSelf();
        }
    }

    public CutoutDrawable(ShapeAppearanceModel shapeAppearanceModel) {
        super(shapeAppearanceModel == null ? new ShapeAppearanceModel() : shapeAppearanceModel);
        Paint paint = new Paint(1);
        this.cutoutPaint = paint;
        paint.setStyle(Style.FILL_AND_STROKE);
        this.cutoutPaint.setColor(-1);
        this.cutoutPaint.setXfermode(new PorterDuffXfermode(Mode.DST_OUT));
        this.cutoutBounds = new RectF();
    }
}
