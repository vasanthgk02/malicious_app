package com.airbnb.lottie.value;

public class ScaleXY {
    public float scaleX;
    public float scaleY;

    public ScaleXY() {
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
    }

    public String toString() {
        return this.scaleX + "x" + this.scaleY;
    }

    public ScaleXY(float f2, float f3) {
        this.scaleX = f2;
        this.scaleY = f3;
    }
}
