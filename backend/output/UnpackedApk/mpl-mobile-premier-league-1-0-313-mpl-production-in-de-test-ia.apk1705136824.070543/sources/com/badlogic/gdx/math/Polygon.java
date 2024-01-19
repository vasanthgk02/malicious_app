package com.badlogic.gdx.math;

public class Polygon {
    public Rectangle bounds;
    public boolean dirty;
    public float[] localVertices;
    public float scaleX;
    public float scaleY;
    public float[] worldVertices;

    public Polygon() {
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
        this.dirty = true;
        this.localVertices = new float[0];
    }

    public float[] getTransformedVertices() {
        if (!this.dirty) {
            return this.worldVertices;
        }
        this.dirty = false;
        float[] fArr = this.localVertices;
        float[] fArr2 = this.worldVertices;
        if (fArr2 == null || fArr2.length != fArr.length) {
            this.worldVertices = new float[fArr.length];
        }
        float[] fArr3 = this.worldVertices;
        float f2 = this.scaleX;
        float f3 = this.scaleY;
        boolean z = (f2 == 1.0f && f3 == 1.0f) ? false : true;
        MathUtils.cosDeg(0.0f);
        MathUtils.sinDeg(0.0f);
        int length = fArr.length;
        for (int i = 0; i < length; i += 2) {
            float f4 = fArr[i] - 0.0f;
            int i2 = i + 1;
            float f5 = fArr[i2] - 0.0f;
            if (z) {
                f4 *= f2;
                f5 *= f3;
            }
            fArr3[i] = f4 + 0.0f + 0.0f;
            fArr3[i2] = f5 + 0.0f + 0.0f;
        }
        return fArr3;
    }

    public void setVertices(float[] fArr) {
        if (fArr.length >= 6) {
            this.localVertices = fArr;
            this.dirty = true;
            return;
        }
        throw new IllegalArgumentException("polygons must contain at least 3 points.");
    }

    public Polygon(float[] fArr) {
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
        this.dirty = true;
        if (fArr.length >= 6) {
            this.localVertices = fArr;
            return;
        }
        throw new IllegalArgumentException("polygons must contain at least 3 points.");
    }
}
