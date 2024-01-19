package com.google.zxing;

public class ResultPoint {
    public final float x;
    public final float y;

    public ResultPoint(float f2, float f3) {
        this.x = f2;
        this.y = f3;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ResultPoint) {
            ResultPoint resultPoint = (ResultPoint) obj;
            if (this.x == resultPoint.x && this.y == resultPoint.y) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Float.floatToIntBits(this.y) + (Float.floatToIntBits(this.x) * 31);
    }

    public final String toString() {
        return "(" + this.x + ',' + this.y + ')';
    }
}
