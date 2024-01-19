package com.badlogic.gdx.math;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;

public class Vector3 implements Serializable {
    public static final Vector3 X = new Vector3(1.0f, 0.0f, 0.0f);
    public static final Vector3 Y = new Vector3(0.0f, 1.0f, 0.0f);
    public static final Vector3 Z = new Vector3(0.0f, 0.0f, 1.0f);
    public static final long serialVersionUID = 3840054589595372522L;
    public static final Matrix4 tmpMat = new Matrix4();
    public float x;
    public float y;
    public float z;

    public Vector3() {
    }

    public static float len(float f2, float f3, float f4) {
        return (float) Math.sqrt((double) ((f4 * f4) + (f3 * f3) + (f2 * f2)));
    }

    public Vector3 add(Vector3 vector3) {
        add(vector3.x, vector3.y, vector3.z);
        return this;
    }

    public Vector3 crs(Vector3 vector3) {
        float f2 = this.y;
        float f3 = vector3.z;
        float f4 = this.z;
        float f5 = vector3.y;
        float f6 = vector3.x;
        float f7 = this.x;
        set((f2 * f3) - (f4 * f5), (f4 * f6) - (f3 * f7), (f7 * f5) - (f2 * f6));
        return this;
    }

    public float dot(Vector3 vector3) {
        return (this.z * vector3.z) + (this.y * vector3.y) + (this.x * vector3.x);
    }

    public float dst(Vector3 vector3) {
        float f2 = vector3.x - this.x;
        float f3 = vector3.y - this.y;
        float f4 = vector3.z - this.z;
        return (float) Math.sqrt((double) ((f4 * f4) + (f3 * f3) + (f2 * f2)));
    }

    public float dst2(Vector3 vector3) {
        float f2 = vector3.x - this.x;
        float f3 = vector3.y - this.y;
        float f4 = vector3.z - this.z;
        return (f4 * f4) + (f3 * f3) + (f2 * f2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Vector3.class != obj.getClass()) {
            return false;
        }
        Vector3 vector3 = (Vector3) obj;
        return Float.floatToIntBits(this.x) == Float.floatToIntBits(vector3.x) && Float.floatToIntBits(this.y) == Float.floatToIntBits(vector3.y) && Float.floatToIntBits(this.z) == Float.floatToIntBits(vector3.z);
    }

    public int hashCode() {
        return ((((Float.floatToIntBits(this.x) + 31) * 31) + Float.floatToIntBits(this.y)) * 31) + Float.floatToIntBits(this.z);
    }

    public boolean isZero() {
        return this.x == 0.0f && this.y == 0.0f && this.z == 0.0f;
    }

    public float len2() {
        float f2 = this.x;
        float f3 = this.y;
        float f4 = (f3 * f3) + (f2 * f2);
        float f5 = this.z;
        return (f5 * f5) + f4;
    }

    public Vector3 lerp(Vector3 vector3, float f2) {
        float f3 = this.x;
        this.x = GeneratedOutlineSupport.outline3(vector3.x, f3, f2, f3);
        float f4 = this.y;
        this.y = GeneratedOutlineSupport.outline3(vector3.y, f4, f2, f4);
        float f5 = this.z;
        this.z = GeneratedOutlineSupport.outline3(vector3.z, f5, f2, f5);
        return this;
    }

    public Vector3 mul(Matrix4 matrix4) {
        float[] fArr = matrix4.val;
        float f2 = this.x;
        float f3 = this.y;
        float f4 = (fArr[4] * f3) + (fArr[0] * f2);
        float f5 = this.z;
        set((fArr[8] * f5) + f4 + fArr[12], (fArr[9] * f5) + (fArr[5] * f3) + (fArr[1] * f2) + fArr[13], (f5 * fArr[10]) + (f3 * fArr[6]) + (f2 * fArr[2]) + fArr[14]);
        return this;
    }

    public Vector3 nor() {
        float len2 = len2();
        if (!(len2 == 0.0f || len2 == 1.0f)) {
            scl(1.0f / ((float) Math.sqrt((double) len2)));
        }
        return this;
    }

    public Vector3 prj(Matrix4 matrix4) {
        float[] fArr = matrix4.val;
        float f2 = this.x;
        float f3 = this.y;
        float f4 = (fArr[7] * f3) + (fArr[3] * f2);
        float f5 = this.z;
        float f6 = 1.0f / (((fArr[11] * f5) + f4) + fArr[15]);
        set(((fArr[8] * f5) + (fArr[4] * f3) + (fArr[0] * f2) + fArr[12]) * f6, ((fArr[9] * f5) + (fArr[5] * f3) + (fArr[1] * f2) + fArr[13]) * f6, ((f5 * fArr[10]) + (f3 * fArr[6]) + (f2 * fArr[2]) + fArr[14]) * f6);
        return this;
    }

    public Vector3 rot(Matrix4 matrix4) {
        float[] fArr = matrix4.val;
        float f2 = this.x;
        float f3 = this.y;
        float f4 = (fArr[4] * f3) + (fArr[0] * f2);
        float f5 = this.z;
        float f6 = (fArr[8] * f5) + f4;
        float f7 = (fArr[9] * f5) + (fArr[5] * f3) + (fArr[1] * f2);
        float f8 = f2 * fArr[2];
        set(f6, f7, (f5 * fArr[10]) + (f3 * fArr[6]) + f8);
        return this;
    }

    public Vector3 rotate(float f2, float f3, float f4, float f5) {
        Matrix4 matrix4 = tmpMat;
        if (matrix4 != null) {
            if (f2 == 0.0f) {
                matrix4.idt();
            } else {
                Quaternion quaternion = Matrix4.quat;
                quaternion.setFromAxis(f3, f4, f5, f2);
                matrix4.set(quaternion);
            }
            mul(matrix4);
            return this;
        }
        throw null;
    }

    public Vector3 scl(float f2) {
        set(this.x * f2, this.y * f2, this.z * f2);
        return this;
    }

    public Vector3 set(float f2, float f3, float f4) {
        this.x = f2;
        this.y = f3;
        this.z = f4;
        return this;
    }

    public Vector3 sub(Vector3 vector3) {
        sub(vector3.x, vector3.y, vector3.z);
        return this;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("(");
        outline73.append(this.x);
        outline73.append(",");
        outline73.append(this.y);
        outline73.append(",");
        outline73.append(this.z);
        outline73.append(")");
        return outline73.toString();
    }

    public Vector3(float f2, float f3, float f4) {
        this.x = f2;
        this.y = f3;
        this.z = f4;
    }

    public Vector3 add(float f2, float f3, float f4) {
        set(this.x + f2, this.y + f3, this.z + f4);
        return this;
    }

    public Vector3 crs(float f2, float f3, float f4) {
        float f5 = this.y;
        float f6 = this.z;
        float f7 = this.x;
        set((f5 * f4) - (f6 * f3), (f6 * f2) - (f4 * f7), (f7 * f3) - (f5 * f2));
        return this;
    }

    public float len() {
        float f2 = this.x;
        float f3 = this.y;
        float f4 = (f3 * f3) + (f2 * f2);
        float f5 = this.z;
        return (float) Math.sqrt((double) ((f5 * f5) + f4));
    }

    public Vector3 sub(float f2, float f3, float f4) {
        set(this.x - f2, this.y - f3, this.z - f4);
        return this;
    }

    public Vector3 mul(Matrix3 matrix3) {
        float[] fArr = matrix3.val;
        float f2 = this.x;
        float f3 = this.y;
        float f4 = (fArr[3] * f3) + (fArr[0] * f2);
        float f5 = this.z;
        float f6 = (fArr[6] * f5) + f4;
        float f7 = (fArr[7] * f5) + (fArr[4] * f3) + (fArr[1] * f2);
        float f8 = f2 * fArr[2];
        set(f6, f7, (f5 * fArr[8]) + (f3 * fArr[5]) + f8);
        return this;
    }

    public Vector3 set(Vector3 vector3) {
        set(vector3.x, vector3.y, vector3.z);
        return this;
    }

    public Vector3(Vector3 vector3) {
        set(vector3);
    }

    public Vector3 rotate(Vector3 vector3, float f2) {
        Matrix4 matrix4 = tmpMat;
        if (matrix4 != null) {
            if (f2 == 0.0f) {
                matrix4.idt();
            } else {
                Quaternion quaternion = Matrix4.quat;
                if (quaternion != null) {
                    quaternion.setFromAxis(vector3.x, vector3.y, vector3.z, f2);
                    matrix4.set(quaternion);
                } else {
                    throw null;
                }
            }
            mul(tmpMat);
            return this;
        }
        throw null;
    }
}
