package com.badlogic.gdx.math;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.io.Serializable;

public final class Affine2 implements Serializable {
    public static final long serialVersionUID = 1524569123485049187L;
    public float m00 = 1.0f;
    public float m01 = 0.0f;
    public float m02 = 0.0f;
    public float m10 = 0.0f;
    public float m11 = 1.0f;
    public float m12 = 0.0f;

    public Affine2 inv() {
        float f2 = this.m00;
        float f3 = this.m11;
        float f4 = this.m01;
        float f5 = this.m10;
        float f6 = (f2 * f3) - (f4 * f5);
        if (f6 != 0.0f) {
            float f7 = 1.0f / f6;
            float f8 = -f4;
            float f9 = this.m12;
            float f10 = this.m02;
            this.m00 = f3 * f7;
            this.m01 = f8 * f7;
            this.m02 = ((f4 * f9) - (f3 * f10)) * f7;
            this.m10 = (-f5) * f7;
            this.m11 = f2 * f7;
            this.m12 = f7 * ((f5 * f10) - (f9 * f2));
            return this;
        }
        throw new GdxRuntimeException((String) "Can't invert a singular affine matrix");
    }

    public Affine2 mul(Affine2 affine2) {
        float f2 = this.m00;
        float f3 = affine2.m00;
        float f4 = this.m01;
        float f5 = affine2.m10;
        float f6 = (f4 * f5) + (f2 * f3);
        float f7 = affine2.m01;
        float f8 = affine2.m11;
        float f9 = (f4 * f8) + (f2 * f7);
        float f10 = affine2.m02;
        float f11 = affine2.m12;
        float f12 = (f4 * f11) + (f2 * f10) + this.m02;
        float f13 = this.m10;
        float f14 = this.m11;
        float f15 = f5 * f14;
        float f16 = f8 * f14;
        this.m00 = f6;
        this.m01 = f9;
        this.m02 = f12;
        this.m10 = f15 + (f3 * f13);
        this.m11 = f16 + (f7 * f13);
        this.m12 = (f14 * f11) + (f13 * f10) + this.m12;
        return this;
    }

    public Affine2 set(Matrix4 matrix4) {
        float[] fArr = matrix4.val;
        this.m00 = fArr[0];
        this.m01 = fArr[4];
        this.m02 = fArr[12];
        this.m10 = fArr[1];
        this.m11 = fArr[5];
        this.m12 = fArr[13];
        return this;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("[");
        outline73.append(this.m00);
        outline73.append("|");
        outline73.append(this.m01);
        outline73.append("|");
        outline73.append(this.m02);
        outline73.append("]\n[");
        outline73.append(this.m10);
        outline73.append("|");
        outline73.append(this.m11);
        outline73.append("|");
        outline73.append(this.m12);
        outline73.append("]\n[0.0|0.0|0.1]");
        return outline73.toString();
    }
}
