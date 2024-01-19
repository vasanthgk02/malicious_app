package com.google.android.material.shape;

public class RoundedCornerTreatment extends CornerTreatment {
    public float radius = -1.0f;

    public void getCornerPath(ShapePath shapePath, float f2, float f3, float f4) {
        shapePath.reset(0.0f, f4 * f3, 180.0f, 180.0f - f2);
        float f5 = f4 * 2.0f * f3;
        shapePath.addArc(0.0f, 0.0f, f5, f5, 180.0f, f2);
    }
}
