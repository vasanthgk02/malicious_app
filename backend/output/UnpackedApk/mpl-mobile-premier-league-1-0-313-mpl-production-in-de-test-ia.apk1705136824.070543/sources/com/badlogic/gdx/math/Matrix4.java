package com.badlogic.gdx.math;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;

public class Matrix4 implements Serializable {
    public static final Vector3 l_vex = new Vector3();
    public static final Vector3 l_vey = new Vector3();
    public static final Vector3 l_vez = new Vector3();
    public static final Quaternion quat = new Quaternion();
    public static final long serialVersionUID = -2717655254359579617L;
    public static final Matrix4 tmpMat = new Matrix4();
    public static final Vector3 tmpVec = new Vector3();
    public final float[] val;

    static {
        new Quaternion();
    }

    public Matrix4() {
        float[] fArr = new float[16];
        this.val = fArr;
        fArr[0] = 1.0f;
        fArr[5] = 1.0f;
        fArr[10] = 1.0f;
        fArr[15] = 1.0f;
    }

    public static boolean inv(float[] fArr) {
        float f2 = (fArr[0] * fArr[5] * fArr[10] * fArr[15]) + ((((((fArr[2] * fArr[4]) * fArr[9]) * fArr[15]) + ((((fArr[1] * fArr[6]) * fArr[8]) * fArr[15]) + ((((((fArr[1] * fArr[4]) * fArr[11]) * fArr[14]) + ((((fArr[0] * fArr[7]) * fArr[9]) * fArr[14]) + ((((((fArr[3] * fArr[5]) * fArr[8]) * fArr[14]) + ((((fArr[0] * fArr[6]) * fArr[11]) * fArr[13]) + ((((((fArr[3] * fArr[4]) * fArr[10]) * fArr[13]) + ((((fArr[2] * fArr[7]) * fArr[8]) * fArr[13]) + ((((((fArr[2] * fArr[5]) * fArr[11]) * fArr[12]) + ((((fArr[1] * fArr[7]) * fArr[10]) * fArr[12]) + (((((fArr[3] * fArr[6]) * fArr[9]) * fArr[12]) - (((fArr[2] * fArr[7]) * fArr[9]) * fArr[12])) - (((fArr[3] * fArr[5]) * fArr[10]) * fArr[12])))) - (((fArr[1] * fArr[6]) * fArr[11]) * fArr[12])) - (((fArr[3] * fArr[6]) * fArr[8]) * fArr[13])))) - (((fArr[0] * fArr[7]) * fArr[10]) * fArr[13])) - (((fArr[2] * fArr[4]) * fArr[11]) * fArr[13])))) - (((fArr[1] * fArr[7]) * fArr[8]) * fArr[14])) - (((fArr[3] * fArr[4]) * fArr[9]) * fArr[14])))) - (((fArr[0] * fArr[5]) * fArr[11]) * fArr[14])) - (((fArr[2] * fArr[5]) * fArr[8]) * fArr[15])))) - (((fArr[0] * fArr[6]) * fArr[9]) * fArr[15])) - (((fArr[1] * fArr[4]) * fArr[10]) * fArr[15]));
        if (f2 == 0.0f) {
            return false;
        }
        float f3 = (fArr[5] * fArr[10] * fArr[15]) + (((((fArr[13] * fArr[6]) * fArr[11]) + (((fArr[9] * fArr[14]) * fArr[7]) - ((fArr[13] * fArr[10]) * fArr[7]))) - ((fArr[5] * fArr[14]) * fArr[11])) - ((fArr[9] * fArr[6]) * fArr[15]));
        float f4 = (((fArr[8] * fArr[6]) * fArr[15]) + (((fArr[4] * fArr[14]) * fArr[11]) + ((((fArr[12] * fArr[10]) * fArr[7]) - ((fArr[8] * fArr[14]) * fArr[7])) - ((fArr[12] * fArr[6]) * fArr[11])))) - ((fArr[4] * fArr[10]) * fArr[15]);
        float f5 = (fArr[4] * fArr[9] * fArr[15]) + (((((fArr[12] * fArr[5]) * fArr[11]) + (((fArr[8] * fArr[13]) * fArr[7]) - ((fArr[12] * fArr[9]) * fArr[7]))) - ((fArr[4] * fArr[13]) * fArr[11])) - ((fArr[8] * fArr[5]) * fArr[15]));
        float f6 = (((fArr[8] * fArr[5]) * fArr[14]) + (((fArr[4] * fArr[13]) * fArr[10]) + ((((fArr[12] * fArr[9]) * fArr[6]) - ((fArr[8] * fArr[13]) * fArr[6])) - ((fArr[12] * fArr[5]) * fArr[10])))) - ((fArr[4] * fArr[9]) * fArr[14]);
        float f7 = (((fArr[9] * fArr[2]) * fArr[15]) + (((fArr[1] * fArr[14]) * fArr[11]) + ((((fArr[13] * fArr[10]) * fArr[3]) - ((fArr[9] * fArr[14]) * fArr[3])) - ((fArr[13] * fArr[2]) * fArr[11])))) - ((fArr[1] * fArr[10]) * fArr[15]);
        float f8 = (fArr[0] * fArr[10] * fArr[15]) + (((((fArr[12] * fArr[2]) * fArr[11]) + (((fArr[8] * fArr[14]) * fArr[3]) - ((fArr[12] * fArr[10]) * fArr[3]))) - ((fArr[0] * fArr[14]) * fArr[11])) - ((fArr[8] * fArr[2]) * fArr[15]));
        float f9 = (((fArr[8] * fArr[1]) * fArr[15]) + (((fArr[0] * fArr[13]) * fArr[11]) + ((((fArr[12] * fArr[9]) * fArr[3]) - ((fArr[8] * fArr[13]) * fArr[3])) - ((fArr[12] * fArr[1]) * fArr[11])))) - ((fArr[0] * fArr[9]) * fArr[15]);
        float f10 = (fArr[0] * fArr[9] * fArr[14]) + (((((fArr[12] * fArr[1]) * fArr[10]) + (((fArr[8] * fArr[13]) * fArr[2]) - ((fArr[12] * fArr[9]) * fArr[2]))) - ((fArr[0] * fArr[13]) * fArr[10])) - ((fArr[8] * fArr[1]) * fArr[14]));
        float f11 = (fArr[1] * fArr[6] * fArr[15]) + (((((fArr[13] * fArr[2]) * fArr[7]) + (((fArr[5] * fArr[14]) * fArr[3]) - ((fArr[13] * fArr[6]) * fArr[3]))) - ((fArr[1] * fArr[14]) * fArr[7])) - ((fArr[5] * fArr[2]) * fArr[15]));
        float f12 = (((fArr[4] * fArr[2]) * fArr[15]) + (((fArr[0] * fArr[14]) * fArr[7]) + ((((fArr[12] * fArr[6]) * fArr[3]) - ((fArr[4] * fArr[14]) * fArr[3])) - ((fArr[12] * fArr[2]) * fArr[7])))) - ((fArr[0] * fArr[6]) * fArr[15]);
        float f13 = (fArr[0] * fArr[5] * fArr[15]) + (((((fArr[12] * fArr[1]) * fArr[7]) + (((fArr[4] * fArr[13]) * fArr[3]) - ((fArr[12] * fArr[5]) * fArr[3]))) - ((fArr[0] * fArr[13]) * fArr[7])) - ((fArr[4] * fArr[1]) * fArr[15]));
        float f14 = (((fArr[4] * fArr[1]) * fArr[14]) + (((fArr[0] * fArr[13]) * fArr[6]) + ((((fArr[12] * fArr[5]) * fArr[2]) - ((fArr[4] * fArr[13]) * fArr[2])) - ((fArr[12] * fArr[1]) * fArr[6])))) - ((fArr[0] * fArr[5]) * fArr[14]);
        float f15 = (((fArr[5] * fArr[2]) * fArr[11]) + (((fArr[1] * fArr[10]) * fArr[7]) + ((((fArr[9] * fArr[6]) * fArr[3]) - ((fArr[5] * fArr[10]) * fArr[3])) - ((fArr[9] * fArr[2]) * fArr[7])))) - ((fArr[1] * fArr[6]) * fArr[11]);
        float f16 = (fArr[0] * fArr[6] * fArr[11]) + (((((fArr[8] * fArr[2]) * fArr[7]) + (((fArr[4] * fArr[10]) * fArr[3]) - ((fArr[8] * fArr[6]) * fArr[3]))) - ((fArr[0] * fArr[10]) * fArr[7])) - ((fArr[4] * fArr[2]) * fArr[11]));
        float f17 = (((fArr[4] * fArr[1]) * fArr[11]) + (((fArr[0] * fArr[9]) * fArr[7]) + ((((fArr[8] * fArr[5]) * fArr[3]) - ((fArr[4] * fArr[9]) * fArr[3])) - ((fArr[8] * fArr[1]) * fArr[7])))) - ((fArr[0] * fArr[5]) * fArr[11]);
        float f18 = (fArr[0] * fArr[5] * fArr[10]) + (((((fArr[8] * fArr[1]) * fArr[6]) + (((fArr[4] * fArr[9]) * fArr[2]) - ((fArr[8] * fArr[5]) * fArr[2]))) - ((fArr[0] * fArr[9]) * fArr[6])) - ((fArr[4] * fArr[1]) * fArr[10]));
        float f19 = 1.0f / f2;
        fArr[0] = f3 * f19;
        fArr[1] = f7 * f19;
        fArr[2] = f11 * f19;
        fArr[3] = f15 * f19;
        fArr[4] = f4 * f19;
        fArr[5] = f8 * f19;
        fArr[6] = f12 * f19;
        fArr[7] = f16 * f19;
        fArr[8] = f5 * f19;
        fArr[9] = f9 * f19;
        fArr[10] = f13 * f19;
        fArr[11] = f17 * f19;
        fArr[12] = f6 * f19;
        fArr[13] = f10 * f19;
        fArr[14] = f14 * f19;
        fArr[15] = f18 * f19;
        return true;
    }

    public static native void mulVec(float[] fArr, float[] fArr2, int i, int i2, int i3);

    public static native void prj(float[] fArr, float[] fArr2, int i, int i2, int i3);

    public static native void rot(float[] fArr, float[] fArr2, int i, int i2, int i3);

    public Quaternion getRotation(Quaternion quaternion, boolean z) {
        if (quaternion != null) {
            float[] fArr = this.val;
            quaternion.setFromAxes(z, fArr[0], fArr[4], fArr[8], fArr[1], fArr[5], fArr[9], fArr[2], fArr[6], fArr[10]);
            return quaternion;
        }
        throw null;
    }

    public Vector3 getScale(Vector3 vector3) {
        float f2;
        float f3;
        float f4;
        if (!MathUtils.isZero(this.val[4]) || !MathUtils.isZero(this.val[8])) {
            float[] fArr = this.val;
            float f5 = fArr[0] * fArr[0];
            f2 = (float) Math.sqrt((double) ((fArr[8] * fArr[8]) + (fArr[4] * fArr[4]) + f5));
        } else {
            f2 = Math.abs(this.val[0]);
        }
        if (!MathUtils.isZero(this.val[1]) || !MathUtils.isZero(this.val[9])) {
            float[] fArr2 = this.val;
            float f6 = fArr2[1] * fArr2[1];
            f3 = (float) Math.sqrt((double) ((fArr2[9] * fArr2[9]) + (fArr2[5] * fArr2[5]) + f6));
        } else {
            f3 = Math.abs(this.val[5]);
        }
        if (!MathUtils.isZero(this.val[2]) || !MathUtils.isZero(this.val[6])) {
            float[] fArr3 = this.val;
            float f7 = fArr3[2] * fArr3[2];
            f4 = (float) Math.sqrt((double) ((fArr3[10] * fArr3[10]) + (fArr3[6] * fArr3[6]) + f7));
        } else {
            f4 = Math.abs(this.val[10]);
        }
        vector3.set(f2, f3, f4);
        return vector3;
    }

    public Vector3 getTranslation(Vector3 vector3) {
        float[] fArr = this.val;
        vector3.x = fArr[12];
        vector3.y = fArr[13];
        vector3.z = fArr[14];
        return vector3;
    }

    public Matrix4 idt() {
        float[] fArr = this.val;
        fArr[0] = 1.0f;
        fArr[4] = 0.0f;
        fArr[8] = 0.0f;
        fArr[12] = 0.0f;
        fArr[1] = 0.0f;
        fArr[5] = 1.0f;
        fArr[9] = 0.0f;
        fArr[13] = 0.0f;
        fArr[2] = 0.0f;
        fArr[6] = 0.0f;
        fArr[10] = 1.0f;
        fArr[14] = 0.0f;
        fArr[3] = 0.0f;
        fArr[7] = 0.0f;
        fArr[11] = 0.0f;
        fArr[15] = 1.0f;
        return this;
    }

    public Matrix4 mul(Matrix4 matrix4) {
        mul(this.val, matrix4.val);
        return this;
    }

    public Matrix4 rotate(Quaternion quaternion) {
        Quaternion quaternion2 = quaternion;
        float f2 = quaternion2.x;
        float f3 = quaternion2.y;
        float f4 = quaternion2.z;
        float f5 = quaternion2.w;
        float f6 = f2 * f2;
        float f7 = f2 * f3;
        float f8 = f2 * f4;
        float f9 = f2 * f5;
        float f10 = f3 * f3;
        float f11 = f3 * f4;
        float f12 = f3 * f5;
        float f13 = f4 * f4;
        float f14 = f4 * f5;
        float f15 = 1.0f - ((f10 + f13) * 2.0f);
        float f16 = (f7 - f14) * 2.0f;
        float f17 = (f8 + f12) * 2.0f;
        float f18 = (f7 + f14) * 2.0f;
        float f19 = 1.0f - ((f13 + f6) * 2.0f);
        float f20 = (f11 - f9) * 2.0f;
        float f21 = (f8 - f12) * 2.0f;
        float f22 = (f11 + f9) * 2.0f;
        float f23 = 1.0f - ((f6 + f10) * 2.0f);
        float[] fArr = this.val;
        float f24 = fArr[4] * f18;
        float f25 = (fArr[8] * f21) + f24 + (fArr[0] * f15);
        float f26 = (fArr[8] * f22) + (fArr[4] * f19) + (fArr[0] * f16);
        float f27 = (fArr[4] * f20) + (fArr[0] * f17);
        float f28 = fArr[5] * f18;
        float f29 = (fArr[9] * f21) + f28 + (fArr[1] * f15);
        float f30 = (fArr[9] * f22) + (fArr[5] * f19) + (fArr[1] * f16);
        float f31 = (fArr[5] * f20) + (fArr[1] * f17);
        float f32 = fArr[6] * f18;
        float f33 = (fArr[10] * f21) + f32 + (fArr[2] * f15);
        float f34 = (fArr[10] * f22) + (fArr[6] * f19) + (fArr[2] * f16);
        float f35 = (fArr[6] * f20) + (fArr[2] * f17);
        float f36 = (fArr[7] * f18) + (fArr[3] * f15);
        float f37 = fArr[3] * f16;
        float f38 = fArr[11] * f22;
        float f39 = (fArr[7] * f20) + (fArr[3] * f17);
        fArr[0] = f25;
        fArr[1] = f29;
        fArr[2] = f33;
        fArr[3] = (fArr[11] * f21) + f36;
        fArr[4] = f26;
        fArr[5] = f30;
        fArr[6] = f34;
        fArr[7] = f38 + (fArr[7] * f19) + f37;
        fArr[8] = (fArr[8] * f23) + f27;
        fArr[9] = (fArr[9] * f23) + f31;
        fArr[10] = (fArr[10] * f23) + f35;
        fArr[11] = (fArr[11] * f23) + f39;
        return this;
    }

    public Matrix4 scale(float f2, float f3, float f4) {
        float[] fArr = this.val;
        fArr[0] = fArr[0] * f2;
        fArr[4] = fArr[4] * f3;
        fArr[8] = fArr[8] * f4;
        fArr[1] = fArr[1] * f2;
        fArr[5] = fArr[5] * f3;
        fArr[9] = fArr[9] * f4;
        fArr[2] = fArr[2] * f2;
        fArr[6] = fArr[6] * f3;
        fArr[10] = fArr[10] * f4;
        fArr[3] = fArr[3] * f2;
        fArr[7] = fArr[7] * f3;
        fArr[11] = fArr[11] * f4;
        return this;
    }

    public Matrix4 set(Matrix4 matrix4) {
        float[] fArr = matrix4.val;
        float[] fArr2 = this.val;
        System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
        return this;
    }

    public Matrix4 setAsAffine(Affine2 affine2) {
        float[] fArr = this.val;
        fArr[0] = affine2.m00;
        fArr[1] = affine2.m10;
        fArr[4] = affine2.m01;
        fArr[5] = affine2.m11;
        fArr[12] = affine2.m02;
        fArr[13] = affine2.m12;
        return this;
    }

    public Matrix4 setToLookAt(Vector3 vector3, Vector3 vector32, Vector3 vector33) {
        Vector3 vector34 = tmpVec;
        vector34.set(vector32);
        vector34.sub(vector3);
        Vector3 vector35 = tmpVec;
        Vector3 vector36 = l_vez;
        vector36.set(vector35);
        vector36.nor();
        Vector3 vector37 = l_vex;
        vector37.set(vector35);
        vector37.crs(vector33);
        vector37.nor();
        Vector3 vector38 = l_vey;
        vector38.set(l_vex);
        vector38.crs(l_vez);
        vector38.nor();
        idt();
        float[] fArr = this.val;
        Vector3 vector39 = l_vex;
        fArr[0] = vector39.x;
        fArr[4] = vector39.y;
        fArr[8] = vector39.z;
        Vector3 vector310 = l_vey;
        fArr[1] = vector310.x;
        fArr[5] = vector310.y;
        fArr[9] = vector310.z;
        Vector3 vector311 = l_vez;
        fArr[2] = -vector311.x;
        fArr[6] = -vector311.y;
        fArr[10] = -vector311.z;
        Matrix4 matrix4 = tmpMat;
        matrix4.setToTranslation(-vector3.x, -vector3.y, -vector3.z);
        mul(this.val, matrix4.val);
        return this;
    }

    public Matrix4 setToOrtho(float f2, float f3, float f4, float f5, float f6, float f7) {
        float f8 = f3 - f2;
        float f9 = f5 - f4;
        float f10 = f7 - f6;
        float[] fArr = this.val;
        fArr[0] = 2.0f / f8;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = 0.0f;
        fArr[5] = 2.0f / f9;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 0.0f;
        fArr[9] = 0.0f;
        fArr[10] = -2.0f / f10;
        fArr[11] = 0.0f;
        fArr[12] = (-(f3 + f2)) / f8;
        fArr[13] = (-(f5 + f4)) / f9;
        fArr[14] = (-(f7 + f6)) / f10;
        fArr[15] = 1.0f;
        return this;
    }

    public Matrix4 setToOrtho2D(float f2, float f3, float f4, float f5) {
        setToOrtho(f2, f2 + f4, f3, f3 + f5, 0.0f, 1.0f);
        return this;
    }

    public Matrix4 setToTranslation(float f2, float f3, float f4) {
        idt();
        float[] fArr = this.val;
        fArr[12] = f2;
        fArr[13] = f3;
        fArr[14] = f4;
        return this;
    }

    public Matrix4 setTranslation(Vector3 vector3) {
        float[] fArr = this.val;
        fArr[12] = vector3.x;
        fArr[13] = vector3.y;
        fArr[14] = vector3.z;
        return this;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("[");
        outline73.append(this.val[0]);
        outline73.append("|");
        outline73.append(this.val[4]);
        outline73.append("|");
        outline73.append(this.val[8]);
        outline73.append("|");
        outline73.append(this.val[12]);
        outline73.append("]\n[");
        outline73.append(this.val[1]);
        outline73.append("|");
        outline73.append(this.val[5]);
        outline73.append("|");
        outline73.append(this.val[9]);
        outline73.append("|");
        outline73.append(this.val[13]);
        outline73.append("]\n[");
        outline73.append(this.val[2]);
        outline73.append("|");
        outline73.append(this.val[6]);
        outline73.append("|");
        outline73.append(this.val[10]);
        outline73.append("|");
        outline73.append(this.val[14]);
        outline73.append("]\n[");
        outline73.append(this.val[3]);
        outline73.append("|");
        outline73.append(this.val[7]);
        outline73.append("|");
        outline73.append(this.val[11]);
        outline73.append("|");
        outline73.append(this.val[15]);
        outline73.append("]\n");
        return outline73.toString();
    }

    public Matrix4 translate(float f2, float f3, float f4) {
        float[] fArr = this.val;
        float f5 = fArr[12];
        fArr[12] = GeneratedOutlineSupport.outline4(fArr[8], f4, (fArr[4] * f3) + (fArr[0] * f2), f5);
        float f6 = fArr[13];
        fArr[13] = GeneratedOutlineSupport.outline4(fArr[9], f4, (fArr[5] * f3) + (fArr[1] * f2), f6);
        float f7 = fArr[14];
        fArr[14] = GeneratedOutlineSupport.outline4(fArr[10], f4, (fArr[6] * f3) + (fArr[2] * f2), f7);
        float f8 = fArr[15];
        float f9 = fArr[3] * f2;
        fArr[15] = GeneratedOutlineSupport.outline4(fArr[11], f4, (fArr[7] * f3) + f9, f8);
        return this;
    }

    public static void mul(float[] fArr, float[] fArr2) {
        float f2 = fArr[4] * fArr2[1];
        float f3 = fArr[8] * fArr2[2];
        float f4 = (fArr[12] * fArr2[3]) + f3 + f2 + (fArr[0] * fArr2[0]);
        float f5 = (fArr[12] * fArr2[7]) + (fArr[8] * fArr2[6]) + (fArr[4] * fArr2[5]) + (fArr[0] * fArr2[4]);
        float f6 = (fArr[12] * fArr2[11]) + (fArr[8] * fArr2[10]) + (fArr[4] * fArr2[9]) + (fArr[0] * fArr2[8]);
        float f7 = (fArr[12] * fArr2[15]) + (fArr[8] * fArr2[14]) + (fArr[4] * fArr2[13]) + (fArr[0] * fArr2[12]);
        float f8 = (fArr[13] * fArr2[3]) + (fArr[9] * fArr2[2]) + (fArr[5] * fArr2[1]) + (fArr[1] * fArr2[0]);
        float f9 = (fArr[13] * fArr2[7]) + (fArr[9] * fArr2[6]) + (fArr[5] * fArr2[5]) + (fArr[1] * fArr2[4]);
        float f10 = (fArr[13] * fArr2[11]) + (fArr[9] * fArr2[10]) + (fArr[5] * fArr2[9]) + (fArr[1] * fArr2[8]);
        float f11 = (fArr[13] * fArr2[15]) + (fArr[9] * fArr2[14]) + (fArr[5] * fArr2[13]) + (fArr[1] * fArr2[12]);
        float f12 = (fArr[14] * fArr2[3]) + (fArr[10] * fArr2[2]) + (fArr[6] * fArr2[1]) + (fArr[2] * fArr2[0]);
        float f13 = (fArr[14] * fArr2[7]) + (fArr[10] * fArr2[6]) + (fArr[6] * fArr2[5]) + (fArr[2] * fArr2[4]);
        float f14 = (fArr[14] * fArr2[11]) + (fArr[10] * fArr2[10]) + (fArr[6] * fArr2[9]) + (fArr[2] * fArr2[8]);
        float f15 = (fArr[14] * fArr2[15]) + (fArr[10] * fArr2[14]) + (fArr[6] * fArr2[13]) + (fArr[2] * fArr2[12]);
        float f16 = (fArr[15] * fArr2[3]) + (fArr[11] * fArr2[2]) + (fArr[7] * fArr2[1]) + (fArr[3] * fArr2[0]);
        float f17 = (fArr[15] * fArr2[7]) + (fArr[11] * fArr2[6]) + (fArr[7] * fArr2[5]) + (fArr[3] * fArr2[4]);
        float f18 = (fArr[15] * fArr2[11]) + (fArr[11] * fArr2[10]) + (fArr[7] * fArr2[9]) + (fArr[3] * fArr2[8]);
        float f19 = (fArr[11] * fArr2[14]) + (fArr[7] * fArr2[13]) + (fArr[3] * fArr2[12]);
        fArr[0] = f4;
        fArr[1] = f8;
        fArr[2] = f12;
        fArr[3] = f16;
        fArr[4] = f5;
        fArr[5] = f9;
        fArr[6] = f13;
        fArr[7] = f17;
        fArr[8] = f6;
        fArr[9] = f10;
        fArr[10] = f14;
        fArr[11] = f18;
        fArr[12] = f7;
        fArr[13] = f11;
        fArr[14] = f15;
        fArr[15] = (fArr[15] * fArr2[15]) + f19;
    }

    public Matrix4(Matrix4 matrix4) {
        this.val = new float[16];
        set(matrix4);
    }

    public Matrix4 set(Quaternion quaternion) {
        float f2 = quaternion.x;
        float f3 = quaternion.y;
        float f4 = quaternion.z;
        float f5 = quaternion.w;
        float f6 = f2 * 2.0f;
        float f7 = f3 * 2.0f;
        float f8 = 2.0f * f4;
        float f9 = f5 * f6;
        float f10 = f5 * f7;
        float f11 = f5 * f8;
        float f12 = f6 * f2;
        float f13 = f2 * f7;
        float f14 = f2 * f8;
        float f15 = f7 * f3;
        float f16 = f3 * f8;
        float f17 = f8 * f4;
        float[] fArr = this.val;
        fArr[0] = 1.0f - (f15 + f17);
        fArr[4] = f13 - f11;
        fArr[8] = f14 + f10;
        fArr[12] = 0.0f;
        fArr[1] = f13 + f11;
        fArr[5] = 1.0f - (f17 + f12);
        fArr[9] = f16 - f9;
        fArr[13] = 0.0f;
        fArr[2] = f14 - f10;
        fArr[6] = f16 + f9;
        fArr[10] = 1.0f - (f12 + f15);
        fArr[14] = 0.0f;
        fArr[3] = 0.0f;
        fArr[7] = 0.0f;
        fArr[11] = 0.0f;
        fArr[15] = 1.0f;
        return this;
    }

    public Matrix4 setAsAffine(Matrix4 matrix4) {
        float[] fArr = this.val;
        float[] fArr2 = matrix4.val;
        fArr[0] = fArr2[0];
        fArr[1] = fArr2[1];
        fArr[4] = fArr2[4];
        fArr[5] = fArr2[5];
        fArr[12] = fArr2[12];
        fArr[13] = fArr2[13];
        return this;
    }

    public Matrix4 set(Vector3 vector3, Quaternion quaternion, Vector3 vector32) {
        set(vector3.x, vector3.y, vector3.z, quaternion.x, quaternion.y, quaternion.z, quaternion.w, vector32.x, vector32.y, vector32.z);
        return this;
    }

    public Matrix4 set(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11) {
        float f12 = f5 * 2.0f;
        float f13 = f6 * 2.0f;
        float f14 = 2.0f * f7;
        float f15 = f8 * f12;
        float f16 = f8 * f13;
        float f17 = f8 * f14;
        float f18 = f12 * f5;
        float f19 = f5 * f13;
        float f20 = f5 * f14;
        float f21 = f13 * f6;
        float f22 = f6 * f14;
        float f23 = f14 * f7;
        float[] fArr = this.val;
        fArr[0] = (1.0f - (f21 + f23)) * f9;
        fArr[4] = (f19 - f17) * f10;
        fArr[8] = (f20 + f16) * f11;
        fArr[12] = f2;
        fArr[1] = (f19 + f17) * f9;
        fArr[5] = (1.0f - (f23 + f18)) * f10;
        fArr[9] = (f22 - f15) * f11;
        fArr[13] = f3;
        fArr[2] = (f20 - f16) * f9;
        fArr[6] = (f22 + f15) * f10;
        fArr[10] = (1.0f - (f18 + f21)) * f11;
        fArr[14] = f4;
        fArr[3] = 0.0f;
        fArr[7] = 0.0f;
        fArr[11] = 0.0f;
        fArr[15] = 1.0f;
        return this;
    }
}
