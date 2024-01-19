package com.badlogic.gdx.math;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;
import org.apache.fontbox.cmap.CMapParser;

public class Quaternion implements Serializable {
    public static final long serialVersionUID = -7661875440774897168L;
    public static Quaternion tmp1 = new Quaternion(0.0f, 0.0f, 0.0f, 0.0f);
    public static Quaternion tmp2 = new Quaternion(0.0f, 0.0f, 0.0f, 0.0f);
    public float w;
    public float x;
    public float y;
    public float z;

    public Quaternion(float f2, float f3, float f4, float f5) {
        this.x = f2;
        this.y = f3;
        this.z = f4;
        this.w = f5;
    }

    public Quaternion conjugate() {
        this.x = -this.x;
        this.y = -this.y;
        this.z = -this.z;
        return this;
    }

    public boolean equals(Object obj) {
        boolean z2 = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Quaternion)) {
            return false;
        }
        Quaternion quaternion = (Quaternion) obj;
        if (!(Float.floatToRawIntBits(this.w) == Float.floatToRawIntBits(quaternion.w) && Float.floatToRawIntBits(this.x) == Float.floatToRawIntBits(quaternion.x) && Float.floatToRawIntBits(this.y) == Float.floatToRawIntBits(quaternion.y) && Float.floatToRawIntBits(this.z) == Float.floatToRawIntBits(quaternion.z))) {
            z2 = false;
        }
        return z2;
    }

    public int hashCode() {
        return ((((((Float.floatToRawIntBits(this.w) + 31) * 31) + Float.floatToRawIntBits(this.x)) * 31) + Float.floatToRawIntBits(this.y)) * 31) + Float.floatToRawIntBits(this.z);
    }

    public Quaternion idt() {
        set(0.0f, 0.0f, 0.0f, 1.0f);
        return this;
    }

    public Quaternion mul(Quaternion quaternion) {
        float f2 = this.w;
        float f3 = quaternion.x;
        float f4 = this.x;
        float f5 = quaternion.w;
        float f6 = this.y;
        float f7 = quaternion.z;
        float f8 = (f6 * f7) + (f4 * f5) + (f2 * f3);
        float f9 = this.z;
        float f10 = quaternion.y;
        this.x = f8 - (f9 * f10);
        this.y = ((f9 * f3) + ((f6 * f5) + (f2 * f10))) - (f4 * f7);
        this.z = ((f4 * f10) + ((f9 * f5) + (f2 * f7))) - (f6 * f3);
        this.w = (((f2 * f5) - (f4 * f3)) - (f6 * f10)) - (f9 * f7);
        return this;
    }

    public Quaternion mulLeft(Quaternion quaternion) {
        float f2 = quaternion.w;
        float f3 = this.x;
        float f4 = quaternion.x;
        float f5 = this.w;
        float f6 = quaternion.y;
        float f7 = this.z;
        float f8 = (f6 * f7) + (f4 * f5) + (f2 * f3);
        float f9 = quaternion.z;
        float f10 = this.y;
        this.x = f8 - (f9 * f10);
        this.y = ((f9 * f3) + ((f6 * f5) + (f2 * f10))) - (f4 * f7);
        this.z = ((f4 * f10) + ((f9 * f5) + (f2 * f7))) - (f6 * f3);
        this.w = (((f2 * f5) - (f4 * f3)) - (f6 * f10)) - (f9 * f7);
        return this;
    }

    public Quaternion nor() {
        float f2 = this.x;
        float f3 = this.y;
        float f4 = (f3 * f3) + (f2 * f2);
        float f5 = this.z;
        float f6 = (f5 * f5) + f4;
        float f7 = this.w;
        float f8 = (f7 * f7) + f6;
        if (f8 != 0.0f && !MathUtils.isEqual(f8, 1.0f)) {
            float sqrt = (float) Math.sqrt((double) f8);
            this.w /= sqrt;
            this.x /= sqrt;
            this.y /= sqrt;
            this.z /= sqrt;
        }
        return this;
    }

    public Quaternion set(float f2, float f3, float f4, float f5) {
        this.x = f2;
        this.y = f3;
        this.z = f4;
        this.w = f5;
        return this;
    }

    public Quaternion setFromAxes(boolean z2, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        if (z2) {
            float len = 1.0f / Vector3.len(f2, f3, f4);
            float len2 = 1.0f / Vector3.len(f5, f6, f7);
            float len3 = 1.0f / Vector3.len(f8, f9, f10);
            f2 *= len;
            f3 *= len;
            f4 *= len;
            f5 *= len2;
            f6 *= len2;
            f7 *= len2;
            f8 *= len3;
            f9 *= len3;
            f10 *= len3;
        }
        float f11 = f2 + f6 + f10;
        if (f11 >= 0.0f) {
            float sqrt = (float) Math.sqrt((double) (f11 + 1.0f));
            this.w = sqrt * 0.5f;
            float f12 = 0.5f / sqrt;
            this.x = (f9 - f7) * f12;
            this.y = (f4 - f8) * f12;
            this.z = (f5 - f3) * f12;
        } else if (f2 > f6 && f2 > f10) {
            float sqrt2 = (float) Math.sqrt(((((double) f2) + 1.0d) - ((double) f6)) - ((double) f10));
            this.x = sqrt2 * 0.5f;
            float f13 = 0.5f / sqrt2;
            this.y = (f5 + f3) * f13;
            this.z = (f4 + f8) * f13;
            this.w = (f9 - f7) * f13;
        } else if (f6 > f10) {
            float sqrt3 = (float) Math.sqrt(((((double) f6) + 1.0d) - ((double) f2)) - ((double) f10));
            this.y = sqrt3 * 0.5f;
            float f14 = 0.5f / sqrt3;
            this.x = (f5 + f3) * f14;
            this.z = (f9 + f7) * f14;
            this.w = (f4 - f8) * f14;
        } else {
            float sqrt4 = (float) Math.sqrt(((((double) f10) + 1.0d) - ((double) f2)) - ((double) f6));
            this.z = sqrt4 * 0.5f;
            float f15 = 0.5f / sqrt4;
            this.x = (f4 + f8) * f15;
            this.y = (f9 + f7) * f15;
            this.w = (f5 - f3) * f15;
        }
        return this;
    }

    public Quaternion setFromAxis(float f2, float f3, float f4, float f5) {
        float f6 = f5 * 0.017453292f;
        float len = Vector3.len(f2, f3, f4);
        if (len == 0.0f) {
            idt();
        } else {
            float f7 = 1.0f / len;
            double d2 = (double) ((f6 < 0.0f ? 6.2831855f - ((-f6) % 6.2831855f) : f6 % 6.2831855f) / 2.0f);
            float sin = (float) Math.sin(d2);
            set(f2 * f7 * sin, f3 * f7 * sin, f7 * f4 * sin, (float) Math.cos(d2));
            nor();
        }
        return this;
    }

    public Quaternion slerp(Quaternion quaternion, float f2) {
        float f3 = (this.w * quaternion.w) + (this.z * quaternion.z) + (this.y * quaternion.y) + (this.x * quaternion.x);
        int i = (f3 > 0.0f ? 1 : (f3 == 0.0f ? 0 : -1));
        if (i < 0) {
            f3 = -f3;
        }
        float f4 = 1.0f - f2;
        if (((double) (1.0f - f3)) > 0.1d) {
            float acos = (float) Math.acos((double) f3);
            float sin = 1.0f / ((float) Math.sin((double) acos));
            f4 = ((float) Math.sin((double) (f4 * acos))) * sin;
            f2 = ((float) Math.sin((double) (f2 * acos))) * sin;
        }
        if (i < 0) {
            f2 = -f2;
        }
        this.x = (quaternion.x * f2) + (this.x * f4);
        this.y = (quaternion.y * f2) + (this.y * f4);
        this.z = (quaternion.z * f2) + (this.z * f4);
        this.w = (f2 * quaternion.w) + (f4 * this.w);
        return this;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("[");
        outline73.append(this.x);
        outline73.append("|");
        outline73.append(this.y);
        outline73.append("|");
        outline73.append(this.z);
        outline73.append("|");
        outline73.append(this.w);
        outline73.append(CMapParser.MARK_END_OF_ARRAY);
        return outline73.toString();
    }

    public Vector3 transform(Vector3 vector3) {
        tmp2.set(this);
        tmp2.conjugate();
        Quaternion quaternion = tmp2;
        Quaternion quaternion2 = tmp1;
        quaternion2.set(vector3.x, vector3.y, vector3.z, 0.0f);
        quaternion.mulLeft(quaternion2);
        quaternion.mulLeft(this);
        Quaternion quaternion3 = tmp2;
        vector3.x = quaternion3.x;
        vector3.y = quaternion3.y;
        vector3.z = quaternion3.z;
        return vector3;
    }

    public Quaternion set(Quaternion quaternion) {
        set(quaternion.x, quaternion.y, quaternion.z, quaternion.w);
        return this;
    }

    public Quaternion() {
        idt();
    }

    public Quaternion(Quaternion quaternion) {
        set(quaternion);
    }
}
