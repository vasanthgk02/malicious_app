package com.badlogic.gdx.graphics.g3d.environment;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class AmbientCubemap {
    public static final int NUM_VALUES = 18;
    public final float[] data;

    public AmbientCubemap() {
        this.data = new float[18];
    }

    public static final float clamp(float f2) {
        if (f2 < 0.0f) {
            return 0.0f;
        }
        if (f2 > 1.0f) {
            return 1.0f;
        }
        return f2;
    }

    public AmbientCubemap add(float f2, float f3, float f4) {
        int i = 0;
        while (true) {
            float[] fArr = this.data;
            if (i >= fArr.length) {
                return this;
            }
            int i2 = i + 1;
            fArr[i] = fArr[i] + f2;
            int i3 = i2 + 1;
            fArr[i2] = fArr[i2] + f3;
            fArr[i3] = fArr[i3] + f4;
            i = i3 + 1;
        }
    }

    public AmbientCubemap clamp() {
        int i = 0;
        while (true) {
            float[] fArr = this.data;
            if (i >= fArr.length) {
                return this;
            }
            fArr[i] = clamp(fArr[i]);
            i++;
        }
    }

    public AmbientCubemap clear() {
        int i = 0;
        while (true) {
            float[] fArr = this.data;
            if (i >= fArr.length) {
                return this;
            }
            fArr[i] = 0.0f;
            i++;
        }
    }

    public Color getColor(Color color, int i) {
        int i2 = i * 3;
        float[] fArr = this.data;
        return color.set(fArr[i2], fArr[i2 + 1], fArr[i2 + 2], 1.0f);
    }

    public AmbientCubemap set(float[] fArr) {
        int i = 0;
        while (true) {
            float[] fArr2 = this.data;
            if (i >= fArr2.length) {
                return this;
            }
            fArr2[i] = fArr[i];
            i++;
        }
    }

    public String toString() {
        String str = "";
        for (int i = 0; i < this.data.length; i += 3) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73(str);
            outline73.append(Float.toString(this.data[i]));
            outline73.append(", ");
            outline73.append(Float.toString(this.data[i + 1]));
            outline73.append(", ");
            outline73.append(Float.toString(this.data[i + 2]));
            outline73.append("\n");
            str = outline73.toString();
        }
        return str;
    }

    public AmbientCubemap(float[] fArr) {
        if (fArr.length == 18) {
            float[] fArr2 = new float[fArr.length];
            this.data = fArr2;
            System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            return;
        }
        throw new GdxRuntimeException((String) "Incorrect array size");
    }

    public AmbientCubemap set(AmbientCubemap ambientCubemap) {
        return set(ambientCubemap.data);
    }

    public AmbientCubemap set(Color color) {
        return set(color.r, color.g, color.f3307b);
    }

    public AmbientCubemap add(Color color) {
        return add(color.r, color.g, color.f3307b);
    }

    public AmbientCubemap set(float f2, float f3, float f4) {
        for (int i = 0; i < 18; i += 3) {
            float[] fArr = this.data;
            fArr[i] = f2;
            fArr[i + 1] = f3;
            fArr[i + 2] = f4;
        }
        return this;
    }

    public AmbientCubemap add(float f2, float f3, float f4, float f5, float f6, float f7) {
        float f8 = f5 * f5;
        float f9 = f6 * f6;
        float f10 = f7 * f7;
        float f11 = f8 + f9 + f10;
        if (f11 == 0.0f) {
            return this;
        }
        float f12 = (f11 + 1.0f) * (1.0f / f11);
        float f13 = f2 * f12;
        float f14 = f3 * f12;
        float f15 = f4 * f12;
        int i = f5 > 0.0f ? 0 : 3;
        float[] fArr = this.data;
        fArr[i] = (f8 * f13) + fArr[i];
        int i2 = i + 1;
        fArr[i2] = (f8 * f14) + fArr[i2];
        int i3 = i + 2;
        fArr[i3] = (f8 * f15) + fArr[i3];
        int i4 = f6 > 0.0f ? 6 : 9;
        float[] fArr2 = this.data;
        fArr2[i4] = (f9 * f13) + fArr2[i4];
        int i5 = i4 + 1;
        fArr2[i5] = (f9 * f14) + fArr2[i5];
        int i6 = i4 + 2;
        fArr2[i6] = (f9 * f15) + fArr2[i6];
        int i7 = f7 > 0.0f ? 12 : 15;
        float[] fArr3 = this.data;
        fArr3[i7] = (f13 * f10) + fArr3[i7];
        int i8 = i7 + 1;
        fArr3[i8] = (f14 * f10) + fArr3[i8];
        int i9 = i7 + 2;
        fArr3[i9] = (f10 * f15) + fArr3[i9];
        return this;
    }

    public AmbientCubemap(AmbientCubemap ambientCubemap) {
        this(ambientCubemap.data);
    }

    public AmbientCubemap add(Color color, Vector3 vector3) {
        return add(color.r, color.g, color.f3307b, vector3.x, vector3.y, vector3.z);
    }

    public AmbientCubemap add(float f2, float f3, float f4, Vector3 vector3) {
        return add(f2, f3, f4, vector3.x, vector3.y, vector3.z);
    }

    public AmbientCubemap add(Color color, float f2, float f3, float f4) {
        return add(color.r, color.g, color.f3307b, f2, f3, f4);
    }

    public AmbientCubemap add(Color color, Vector3 vector3, Vector3 vector32) {
        return add(color.r, color.g, color.f3307b, vector32.x - vector3.x, vector32.y - vector3.y, vector32.z - vector3.z);
    }

    public AmbientCubemap add(Color color, Vector3 vector3, Vector3 vector32, float f2) {
        float dst = f2 / (vector32.dst(vector3) + 1.0f);
        return add(color.r * dst, color.g * dst, color.f3307b * dst, vector32.x - vector3.x, vector32.y - vector3.y, vector32.z - vector3.z);
    }
}
