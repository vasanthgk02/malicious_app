package com.google.android.material.shadow;

import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import androidx.core.graphics.ColorUtils;

public class ShadowRenderer {
    public static final int[] cornerColors = new int[4];
    public static final float[] cornerPositions = {0.0f, 0.0f, 0.5f, 1.0f};
    public static final int[] edgeColors = new int[3];
    public static final float[] edgePositions = {0.0f, 0.5f, 1.0f};
    public final Paint cornerShadowPaint;
    public final Paint edgeShadowPaint;
    public final Path scratch = new Path();
    public int shadowEndColor;
    public int shadowMiddleColor;
    public final Paint shadowPaint = new Paint();
    public int shadowStartColor;
    public Paint transparentPaint = new Paint();

    public ShadowRenderer() {
        setShadowColor(-16777216);
        this.transparentPaint.setColor(0);
        Paint paint = new Paint(4);
        this.cornerShadowPaint = paint;
        paint.setStyle(Style.FILL);
        this.edgeShadowPaint = new Paint(this.cornerShadowPaint);
    }

    public void setShadowColor(int i) {
        this.shadowStartColor = ColorUtils.setAlphaComponent(i, 68);
        this.shadowMiddleColor = ColorUtils.setAlphaComponent(i, 20);
        this.shadowEndColor = ColorUtils.setAlphaComponent(i, 0);
        this.shadowPaint.setColor(this.shadowStartColor);
    }
}
