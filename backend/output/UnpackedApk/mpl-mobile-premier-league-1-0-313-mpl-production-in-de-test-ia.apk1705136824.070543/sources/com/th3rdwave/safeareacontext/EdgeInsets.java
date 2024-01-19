package com.th3rdwave.safeareacontext;

public class EdgeInsets {
    public float bottom;
    public float left;
    public float right;
    public float top;

    public EdgeInsets(float f2, float f3, float f4, float f5) {
        this.top = f2;
        this.right = f3;
        this.bottom = f4;
        this.left = f5;
    }

    public boolean equalsToEdgeInsets(EdgeInsets edgeInsets) {
        boolean z = true;
        if (this == edgeInsets) {
            return true;
        }
        if (!(this.top == edgeInsets.top && this.right == edgeInsets.right && this.bottom == edgeInsets.bottom && this.left == edgeInsets.left)) {
            z = false;
        }
        return z;
    }
}
