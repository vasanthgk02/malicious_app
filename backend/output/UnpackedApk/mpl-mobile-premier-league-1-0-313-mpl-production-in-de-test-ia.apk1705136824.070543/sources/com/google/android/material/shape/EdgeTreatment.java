package com.google.android.material.shape;

public class EdgeTreatment {
    public boolean forceIntersection() {
        return false;
    }

    public void getEdgePath(float f2, float f3, float f4, ShapePath shapePath) {
        shapePath.lineTo(f2, 0.0f);
    }
}
