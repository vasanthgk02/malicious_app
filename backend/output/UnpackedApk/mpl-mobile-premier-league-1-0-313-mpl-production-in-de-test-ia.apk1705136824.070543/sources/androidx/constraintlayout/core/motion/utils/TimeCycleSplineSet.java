package androidx.constraintlayout.core.motion.utils;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.text.DecimalFormat;

public abstract class TimeCycleSplineSet {
    public int count;
    public float last_cycle = Float.NaN;
    public long last_time;
    public float[] mCache = new float[3];
    public boolean mContinue = false;
    public CurveFit mCurveFit;
    public int[] mTimePoints = new int[10];
    public String mType;
    public float[][] mValues = ((float[][]) Array.newInstance(float.class, new int[]{10, 3}));
    public int mWaveShape = 0;

    public float calcWave(float f2) {
        float f3;
        switch (this.mWaveShape) {
            case 1:
                return Math.signum(f2 * 6.2831855f);
            case 2:
                f3 = Math.abs(f2);
                break;
            case 3:
                return (((f2 * 2.0f) + 1.0f) % 2.0f) - 1.0f;
            case 4:
                f3 = ((f2 * 2.0f) + 1.0f) % 2.0f;
                break;
            case 5:
                return (float) Math.cos((double) (f2 * 6.2831855f));
            case 6:
                float abs = 1.0f - Math.abs(((f2 * 4.0f) % 4.0f) - 2.0f);
                f3 = abs * abs;
                break;
            default:
                return (float) Math.sin((double) (f2 * 6.2831855f));
        }
        return 1.0f - f3;
    }

    public void setPoint(int i, float f2, float f3, int i2, float f4) {
        int[] iArr = this.mTimePoints;
        int i3 = this.count;
        iArr[i3] = i;
        float[][] fArr = this.mValues;
        fArr[i3][0] = f2;
        fArr[i3][1] = f3;
        fArr[i3][2] = f4;
        this.mWaveShape = Math.max(this.mWaveShape, i2);
        this.count++;
    }

    public void setup(int i) {
        int i2 = this.count;
        if (i2 == 0) {
            PrintStream printStream = System.err;
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Error no points added to ");
            outline73.append(this.mType);
            printStream.println(outline73.toString());
            return;
        }
        int[] iArr = this.mTimePoints;
        float[][] fArr = this.mValues;
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
                        float[] fArr2 = fArr[i9];
                        fArr[i9] = fArr[i8];
                        fArr[i8] = fArr2;
                        i9++;
                    }
                    i8++;
                }
                int i11 = iArr[i9];
                iArr[i9] = iArr[i6];
                iArr[i6] = i11;
                float[] fArr3 = fArr[i9];
                fArr[i9] = fArr[i6];
                fArr[i6] = fArr3;
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
        int i16 = 0;
        while (true) {
            int[] iArr3 = this.mTimePoints;
            if (i15 >= iArr3.length) {
                break;
            }
            if (iArr3[i15] != iArr3[i15 - 1]) {
                i16++;
            }
            i15++;
        }
        if (i16 == 0) {
            i16 = 1;
        }
        double[] dArr = new double[i16];
        int[] iArr4 = new int[2];
        iArr4[1] = 3;
        iArr4[0] = i16;
        double[][] dArr2 = (double[][]) Array.newInstance(double.class, iArr4);
        int i17 = 0;
        for (int i18 = 0; i18 < this.count; i18++) {
            if (i18 > 0) {
                int[] iArr5 = this.mTimePoints;
                if (iArr5[i18] == iArr5[i18 - 1]) {
                }
            }
            dArr[i17] = ((double) this.mTimePoints[i18]) * 0.01d;
            double[] dArr3 = dArr2[i17];
            float[][] fArr4 = this.mValues;
            dArr3[0] = (double) fArr4[i18][0];
            dArr2[i17][1] = (double) fArr4[i18][1];
            dArr2[i17][2] = (double) fArr4[i18][2];
            i17++;
        }
        this.mCurveFit = CurveFit.get(i, dArr, dArr2);
    }

    public String toString() {
        String str = this.mType;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i = 0; i < this.count; i++) {
            StringBuilder outline78 = GeneratedOutlineSupport.outline78(str, "[");
            outline78.append(this.mTimePoints[i]);
            outline78.append(" , ");
            outline78.append(decimalFormat.format(this.mValues[i]));
            outline78.append("] ");
            str = outline78.toString();
        }
        return str;
    }
}
