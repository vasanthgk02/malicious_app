package com.google.android.material.shape;

public class CutCornerTreatment extends CornerTreatment {
    public float size = -1.0f;

    public void getCornerPath(ShapePath shapePath, float f2, float f3, float f4) {
        shapePath.reset(0.0f, f4 * f3, 180.0f, 180.0f - f2);
        double d2 = (double) f4;
        double d3 = (double) f3;
        shapePath.lineTo((float) (Math.sin(Math.toRadians((double) f2)) * d2 * d3), (float) (Math.sin(Math.toRadians((double) (90.0f - f2))) * d2 * d3));
    }
}
