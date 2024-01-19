package com.visa;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class Trapezoid extends View {

    /* renamed from: a  reason: collision with root package name */
    public double f4298a;

    /* renamed from: b  reason: collision with root package name */
    public int f4299b;

    public Trapezoid(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void a(int i) {
        this.f4299b = i;
        invalidate();
        requestLayout();
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        int height = (int) (((double) getHeight()) / Math.tan(Math.toRadians(this.f4298a)));
        Path path = new Path();
        path.moveTo((float) getWidth(), 0.0f);
        path.lineTo((float) height, 0.0f);
        path.lineTo(0.0f, (float) getHeight());
        path.lineTo((float) getWidth(), (float) getHeight());
        path.lineTo((float) getWidth(), 0.0f);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(this.f4299b);
        paint.setStyle(Style.FILL);
        canvas.drawPath(path, paint);
    }
}
