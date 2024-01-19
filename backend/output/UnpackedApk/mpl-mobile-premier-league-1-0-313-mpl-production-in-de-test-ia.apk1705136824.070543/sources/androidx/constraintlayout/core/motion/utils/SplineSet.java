package androidx.constraintlayout.core.motion.utils;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.Arrays;

public abstract class SplineSet {
    public int count;
    public CurveFit mCurveFit;
    public int[] mTimePoints = new int[10];
    public String mType;
    public float[] mValues = new float[10];

    public float get(float f2) {
        return (float) this.mCurveFit.getPos((double) f2, 0);
    }

    public void setPoint(int i, float f2) {
        int[] iArr = this.mTimePoints;
        if (iArr.length < this.count + 1) {
            this.mTimePoints = Arrays.copyOf(iArr, iArr.length * 2);
            float[] fArr = this.mValues;
            this.mValues = Arrays.copyOf(fArr, fArr.length * 2);
        }
        int[] iArr2 = this.mTimePoints;
        int i2 = this.count;
        iArr2[i2] = i;
        this.mValues[i2] = f2;
        this.count = i2 + 1;
    }

    public void setup(int i) {
        int i2 = this.count;
        if (i2 != 0) {
            int[] iArr = this.mTimePoints;
            float[] fArr = this.mValues;
            int[] iArr2 = new int[(iArr.length + 10)];
            iArr2[0] = i2 - 1;
            iArr2[1] = 0;
            int i3 = 2;
            while (i3 > 0) {
                int i4 = i3 - 1;
                int i5 = iArr2[i4];
                i3 = i4 - 1;
                int i6 = iArr2[i3];
                if (i5 < i6) {
                    int i7 = iArr[i6];
                    int i8 = i5;
                    int i9 = i8;
                    while (i8 < i6) {
                        if (iArr[i8] <= i7) {
                            int i10 = iArr[i9];
                            iArr[i9] = iArr[i8];
                            iArr[i8] = i10;
                            float f2 = fArr[i9];
                            fArr[i9] = fArr[i8];
                            fArr[i8] = f2;
                            i9++;
                        }
                        i8++;
                    }
                    int i11 = iArr[i9];
                    iArr[i9] = iArr[i6];
                    iArr[i6] = i11;
                    float f3 = fArr[i9];
                    fArr[i9] = fArr[i6];
                    fArr[i6] = f3;
                    int i12 = i3 + 1;
                    iArr2[i3] = i9 - 1;
                    int i13 = i12 + 1;
                    iArr2[i12] = i5;
                    int i14 = i13 + 1;
                    iArr2[i13] = i6;
                    i3 = i14 + 1;
                    iArr2[i14] = i9 + 1;
                }
            }
            int i15 = 1;
            for (int i16 = 1; i16 < this.count; i16++) {
                int[] iArr3 = this.mTimePoints;
                if (iArr3[i16 - 1] != iArr3[i16]) {
                    i15++;
                }
            }
            double[] dArr = new double[i15];
            int[] iArr4 = new int[2];
            iArr4[1] = 1;
            iArr4[0] = i15;
            double[][] dArr2 = (double[][]) Array.newInstance(double.class, iArr4);
            int i17 = 0;
            for (int i18 = 0; i18 < this.count; i18++) {
                if (i18 > 0) {
                    int[] iArr5 = this.mTimePoints;
                    if (iArr5[i18] == iArr5[i18 - 1]) {
                    }
                }
                dArr[i17] = ((double) this.mTimePoints[i18]) * 0.01d;
                dArr2[i17][0] = (double) this.mValues[i18];
                i17++;
            }
            this.mCurveFit = CurveFit.get(i, dArr, dArr2);
        }
    }

    public String toString() {
        String str = this.mType;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i = 0; i < this.count; i++) {
            StringBuilder outline78 = GeneratedOutlineSupport.outline78(str, "[");
            outline78.append(this.mTimePoints[i]);
            outline78.append(" , ");
            outline78.append(decimalFormat.format((double) this.mValues[i]));
            outline78.append("] ");
            str = outline78.toString();
        }
        return str;
    }
}
