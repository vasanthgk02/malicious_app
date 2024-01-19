package com.badlogic.gdx.math;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.io.Serializable;
import org.apache.fontbox.cmap.CMapParser;

public class Matrix3 implements Serializable {
    public static final long serialVersionUID = 7907569533774959788L;
    public float[] tmp = new float[9];
    public float[] val = new float[9];

    public Matrix3() {
        idt();
    }

    public Matrix3 idt() {
        float[] fArr = this.val;
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = 1.0f;
        fArr[5] = 0.0f;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 1.0f;
        return this;
    }

    public Matrix3 inv() {
        float[] fArr = this.val;
        float f2 = fArr[3] * fArr[7] * fArr[2];
        float f3 = (((((fArr[6] * fArr[1]) * fArr[5]) + (f2 + ((fArr[0] * fArr[4]) * fArr[8]))) - ((fArr[0] * fArr[7]) * fArr[5])) - ((fArr[3] * fArr[1]) * fArr[8])) - ((fArr[6] * fArr[4]) * fArr[2]);
        if (f3 != 0.0f) {
            float f4 = 1.0f / f3;
            float[] fArr2 = this.tmp;
            fArr2[0] = (fArr[4] * fArr[8]) - (fArr[5] * fArr[7]);
            fArr2[1] = (fArr[2] * fArr[7]) - (fArr[1] * fArr[8]);
            fArr2[2] = (fArr[1] * fArr[5]) - (fArr[2] * fArr[4]);
            fArr2[3] = (fArr[5] * fArr[6]) - (fArr[3] * fArr[8]);
            fArr2[4] = (fArr[0] * fArr[8]) - (fArr[2] * fArr[6]);
            fArr2[5] = (fArr[2] * fArr[3]) - (fArr[0] * fArr[5]);
            fArr2[6] = (fArr[3] * fArr[7]) - (fArr[4] * fArr[6]);
            fArr2[7] = (fArr[1] * fArr[6]) - (fArr[0] * fArr[7]);
            fArr2[8] = (fArr[0] * fArr[4]) - (fArr[1] * fArr[3]);
            fArr[0] = fArr2[0] * f4;
            fArr[1] = fArr2[1] * f4;
            fArr[2] = fArr2[2] * f4;
            fArr[3] = fArr2[3] * f4;
            fArr[4] = fArr2[4] * f4;
            fArr[5] = fArr2[5] * f4;
            fArr[6] = fArr2[6] * f4;
            fArr[7] = fArr2[7] * f4;
            fArr[8] = f4 * fArr2[8];
            return this;
        }
        throw new GdxRuntimeException((String) "Can't invert a singular matrix");
    }

    public Matrix3 set(Matrix4 matrix4) {
        float[] fArr = this.val;
        float[] fArr2 = matrix4.val;
        fArr[0] = fArr2[0];
        fArr[1] = fArr2[1];
        fArr[2] = fArr2[2];
        fArr[3] = fArr2[4];
        fArr[4] = fArr2[5];
        fArr[5] = fArr2[6];
        fArr[6] = fArr2[8];
        fArr[7] = fArr2[9];
        fArr[8] = fArr2[10];
        return this;
    }

    public Matrix3 setToRotation(Vector3 vector3, float f2, float f3) {
        float[] fArr = this.val;
        float f4 = 1.0f - f2;
        float f5 = vector3.x;
        float f6 = f4 * f5;
        fArr[0] = (f6 * f5) + f2;
        float f7 = vector3.y;
        float f8 = f6 * f7;
        float f9 = vector3.z;
        float f10 = f9 * f3;
        fArr[3] = f8 - f10;
        float f11 = f4 * f9;
        float f12 = f11 * f5;
        float f13 = f7 * f3;
        fArr[6] = f13 + f12;
        fArr[1] = f10 + f8;
        float f14 = f4 * f7;
        fArr[4] = (f7 * f14) + f2;
        float f15 = f14 * f9;
        float f16 = f5 * f3;
        fArr[7] = f15 - f16;
        fArr[2] = f12 - f13;
        fArr[5] = f16 + f15;
        fArr[8] = (f11 * f9) + f2;
        return this;
    }

    public String toString() {
        float[] fArr = this.val;
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("[");
        outline73.append(fArr[0]);
        outline73.append("|");
        outline73.append(fArr[3]);
        outline73.append("|");
        outline73.append(fArr[6]);
        outline73.append("]\n[");
        outline73.append(fArr[1]);
        outline73.append("|");
        outline73.append(fArr[4]);
        outline73.append("|");
        outline73.append(fArr[7]);
        outline73.append("]\n[");
        outline73.append(fArr[2]);
        outline73.append("|");
        outline73.append(fArr[5]);
        outline73.append("|");
        outline73.append(fArr[8]);
        outline73.append(CMapParser.MARK_END_OF_ARRAY);
        return outline73.toString();
    }

    public Matrix3 transpose() {
        float[] fArr = this.val;
        float f2 = fArr[1];
        float f3 = fArr[2];
        float f4 = fArr[3];
        float f5 = fArr[5];
        float f6 = fArr[6];
        float f7 = fArr[7];
        fArr[3] = f2;
        fArr[6] = f3;
        fArr[1] = f4;
        fArr[7] = f5;
        fArr[2] = f6;
        fArr[5] = f7;
        return this;
    }
}
