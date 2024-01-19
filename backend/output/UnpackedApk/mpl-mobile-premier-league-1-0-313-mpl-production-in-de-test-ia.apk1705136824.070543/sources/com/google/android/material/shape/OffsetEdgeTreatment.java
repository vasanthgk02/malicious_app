package com.google.android.material.shape;

public final class OffsetEdgeTreatment extends EdgeTreatment {
    public final float offset;
    public final EdgeTreatment other;

    public OffsetEdgeTreatment(EdgeTreatment edgeTreatment, float f2) {
        this.other = edgeTreatment;
        this.offset = f2;
    }

    public boolean forceIntersection() {
        return this.other.forceIntersection();
    }

    public void getEdgePath(float f2, float f3, float f4, ShapePath shapePath) {
        this.other.getEdgePath(f2, f3 - this.offset, f4, shapePath);
    }
}
