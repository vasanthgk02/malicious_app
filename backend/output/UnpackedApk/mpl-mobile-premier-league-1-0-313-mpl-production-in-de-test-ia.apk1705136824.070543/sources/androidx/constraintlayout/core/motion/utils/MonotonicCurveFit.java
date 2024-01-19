package androidx.constraintlayout.core.motion.utils;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.lang.reflect.Array;

public class MonotonicCurveFit extends CurveFit {
    public boolean mExtrapolate = true;
    public double[] mSlopeTemp;
    public double[] mT;
    public double[][] mTangent;
    public double[][] mY;

    public MonotonicCurveFit(double[] dArr, double[][] dArr2) {
        double[] dArr3 = dArr;
        double[][] dArr4 = dArr2;
        Class<double> cls = double.class;
        int length = dArr3.length;
        int length2 = dArr4[0].length;
        this.mSlopeTemp = new double[length2];
        int i = length - 1;
        int[] iArr = new int[2];
        iArr[1] = length2;
        iArr[0] = i;
        double[][] dArr5 = (double[][]) Array.newInstance(cls, iArr);
        int[] iArr2 = new int[2];
        iArr2[1] = length2;
        iArr2[0] = length;
        double[][] dArr6 = (double[][]) Array.newInstance(cls, iArr2);
        for (int i2 = 0; i2 < length2; i2++) {
            int i3 = 0;
            while (i3 < i) {
                int i4 = i3 + 1;
                dArr5[i3][i2] = (dArr4[i4][i2] - dArr4[i3][i2]) / (dArr3[i4] - dArr3[i3]);
                if (i3 == 0) {
                    dArr6[i3][i2] = dArr5[i3][i2];
                } else {
                    dArr6[i3][i2] = (dArr5[i3 - 1][i2] + dArr5[i3][i2]) * 0.5d;
                }
                i3 = i4;
            }
            dArr6[i][i2] = dArr5[length - 2][i2];
        }
        for (int i5 = 0; i5 < i; i5++) {
            for (int i6 = 0; i6 < length2; i6++) {
                if (dArr5[i5][i6] == 0.0d) {
                    dArr6[i5][i6] = 0.0d;
                    dArr6[i5 + 1][i6] = 0.0d;
                } else {
                    double d2 = dArr6[i5][i6] / dArr5[i5][i6];
                    int i7 = i5 + 1;
                    double d3 = dArr6[i7][i6] / dArr5[i5][i6];
                    double hypot = Math.hypot(d2, d3);
                    if (hypot > 9.0d) {
                        double d4 = 3.0d / hypot;
                        dArr6[i5][i6] = d2 * d4 * dArr5[i5][i6];
                        dArr6[i7][i6] = d4 * d3 * dArr5[i5][i6];
                    }
                }
            }
        }
        this.mT = dArr3;
        this.mY = dArr4;
        this.mTangent = dArr6;
    }

    public static double diff(double d2, double d3, double d4, double d5, double d6, double d7) {
        double d8 = d3 * d3;
        double d9 = d3 * 6.0d;
        double d10 = d2 * 3.0d;
        double d11 = d8;
        return (d2 * d6) + ((GeneratedOutlineSupport.outline2(d10, d6, d11, GeneratedOutlineSupport.outline2(d10, d7, d11, GeneratedOutlineSupport.outline2(d8, 6.0d, d4, (d9 * d5) + ((-6.0d * d8) * d5)) - (d9 * d4))) - (((2.0d * d2) * d7) * d3)) - (((4.0d * d2) * d6) * d3));
    }

    public static double interpolate(double d2, double d3, double d4, double d5, double d6, double d7) {
        double d8 = d3 * d3;
        double d9 = d8 * d3;
        double d10 = d8 * 3.0d;
        double d11 = (d10 * d5) + (-2.0d * d9 * d5);
        double d12 = d2 * d7;
        double d13 = d2 * d6;
        return (d13 * d3) + ((((d9 * d13) + ((d12 * d9) + ((GeneratedOutlineSupport.outline2(d9, 2.0d, d4, d11) - (d10 * d4)) + d4))) - (d12 * d8)) - (((d2 * 2.0d) * d6) * d8));
    }

    public void getPos(double d2, double[] dArr) {
        double[] dArr2 = this.mT;
        int length = dArr2.length;
        int i = 0;
        int length2 = this.mY[0].length;
        if (this.mExtrapolate) {
            if (d2 <= dArr2[0]) {
                getSlope(dArr2[0], this.mSlopeTemp);
                for (int i2 = 0; i2 < length2; i2++) {
                    dArr[i2] = ((d2 - this.mT[0]) * this.mSlopeTemp[i2]) + this.mY[0][i2];
                }
                return;
            }
            int i3 = length - 1;
            if (d2 >= dArr2[i3]) {
                getSlope(dArr2[i3], this.mSlopeTemp);
                while (i < length2) {
                    dArr[i] = ((d2 - this.mT[i3]) * this.mSlopeTemp[i]) + this.mY[i3][i];
                    i++;
                }
                return;
            }
        } else if (d2 <= dArr2[0]) {
            for (int i4 = 0; i4 < length2; i4++) {
                dArr[i4] = this.mY[0][i4];
            }
            return;
        } else {
            int i5 = length - 1;
            if (d2 >= dArr2[i5]) {
                while (i < length2) {
                    dArr[i] = this.mY[i5][i];
                    i++;
                }
                return;
            }
        }
        int i6 = 0;
        while (i6 < length - 1) {
            if (d2 == this.mT[i6]) {
                for (int i7 = 0; i7 < length2; i7++) {
                    dArr[i7] = this.mY[i6][i7];
                }
            }
            double[] dArr3 = this.mT;
            int i8 = i6 + 1;
            if (d2 < dArr3[i8]) {
                double d3 = dArr3[i8] - dArr3[i6];
                double d4 = (d2 - dArr3[i6]) / d3;
                while (i < length2) {
                    double[][] dArr4 = this.mY;
                    double d5 = dArr4[i6][i];
                    double d6 = dArr4[i8][i];
                    double[][] dArr5 = this.mTangent;
                    dArr[i] = interpolate(d3, d4, d5, d6, dArr5[i6][i], dArr5[i8][i]);
                    i++;
                }
                return;
            }
            i6 = i8;
        }
    }

    public void getSlope(double d2, double[] dArr) {
        double d3;
        double[] dArr2 = this.mT;
        int length = dArr2.length;
        int length2 = this.mY[0].length;
        if (d2 <= dArr2[0]) {
            d3 = dArr2[0];
        } else {
            int i = length - 1;
            d3 = d2 >= dArr2[i] ? dArr2[i] : d2;
        }
        int i2 = 0;
        while (i2 < length - 1) {
            double[] dArr3 = this.mT;
            int i3 = i2 + 1;
            if (d3 <= dArr3[i3]) {
                double d4 = dArr3[i3] - dArr3[i2];
                double d5 = (d3 - dArr3[i2]) / d4;
                for (int i4 = 0; i4 < length2; i4++) {
                    double[][] dArr4 = this.mY;
                    double d6 = dArr4[i2][i4];
                    double d7 = dArr4[i3][i4];
                    double[][] dArr5 = this.mTangent;
                    dArr[i4] = diff(d4, d5, d6, d7, dArr5[i2][i4], dArr5[i3][i4]) / d4;
                }
                return;
            }
            i2 = i3;
        }
    }

    public double[] getTimePoints() {
        return this.mT;
    }

    public double getSlope(double d2, int i) {
        double d3;
        double[] dArr = this.mT;
        int length = dArr.length;
        int i2 = 0;
        if (d2 < dArr[0]) {
            d3 = dArr[0];
        } else {
            int i3 = length - 1;
            d3 = d2 >= dArr[i3] ? dArr[i3] : d2;
        }
        while (i2 < length - 1) {
            double[] dArr2 = this.mT;
            int i4 = i2 + 1;
            if (d3 <= dArr2[i4]) {
                double d4 = dArr2[i4] - dArr2[i2];
                double[][] dArr3 = this.mY;
                double d5 = dArr3[i2][i];
                double d6 = dArr3[i4][i];
                double[][] dArr4 = this.mTangent;
                return diff(d4, (d3 - dArr2[i2]) / d4, d5, d6, dArr4[i2][i], dArr4[i4][i]) / d4;
            }
            i2 = i4;
        }
        return 0.0d;
    }

    public void getPos(double d2, float[] fArr) {
        double[] dArr = this.mT;
        int length = dArr.length;
        int i = 0;
        int length2 = this.mY[0].length;
        if (this.mExtrapolate) {
            if (d2 <= dArr[0]) {
                getSlope(dArr[0], this.mSlopeTemp);
                for (int i2 = 0; i2 < length2; i2++) {
                    fArr[i2] = (float) (((d2 - this.mT[0]) * this.mSlopeTemp[i2]) + this.mY[0][i2]);
                }
                return;
            }
            int i3 = length - 1;
            if (d2 >= dArr[i3]) {
                getSlope(dArr[i3], this.mSlopeTemp);
                while (i < length2) {
                    fArr[i] = (float) (((d2 - this.mT[i3]) * this.mSlopeTemp[i]) + this.mY[i3][i]);
                    i++;
                }
                return;
            }
        } else if (d2 <= dArr[0]) {
            for (int i4 = 0; i4 < length2; i4++) {
                fArr[i4] = (float) this.mY[0][i4];
            }
            return;
        } else {
            int i5 = length - 1;
            if (d2 >= dArr[i5]) {
                while (i < length2) {
                    fArr[i] = (float) this.mY[i5][i];
                    i++;
                }
                return;
            }
        }
        int i6 = 0;
        while (i6 < length - 1) {
            if (d2 == this.mT[i6]) {
                for (int i7 = 0; i7 < length2; i7++) {
                    fArr[i7] = (float) this.mY[i6][i7];
                }
            }
            double[] dArr2 = this.mT;
            int i8 = i6 + 1;
            if (d2 < dArr2[i8]) {
                double d3 = dArr2[i8] - dArr2[i6];
                double d4 = (d2 - dArr2[i6]) / d3;
                while (i < length2) {
                    double[][] dArr3 = this.mY;
                    double d5 = dArr3[i6][i];
                    double d6 = dArr3[i8][i];
                    double[][] dArr4 = this.mTangent;
                    fArr[i] = (float) interpolate(d3, d4, d5, d6, dArr4[i6][i], dArr4[i8][i]);
                    i++;
                }
                return;
            }
            i6 = i8;
        }
    }

    public double getPos(double d2, int i) {
        int i2 = i;
        double[] dArr = this.mT;
        int length = dArr.length;
        int i3 = 0;
        if (this.mExtrapolate) {
            if (d2 <= dArr[0]) {
                return (getSlope(dArr[0], i2) * (d2 - dArr[0])) + this.mY[0][i2];
            }
            int i4 = length - 1;
            if (d2 >= dArr[i4]) {
                return (getSlope(dArr[i4], i2) * (d2 - dArr[i4])) + this.mY[i4][i2];
            }
        } else if (d2 <= dArr[0]) {
            return this.mY[0][i2];
        } else {
            int i5 = length - 1;
            if (d2 >= dArr[i5]) {
                return this.mY[i5][i2];
            }
        }
        while (i3 < length - 1) {
            double[] dArr2 = this.mT;
            if (d2 == dArr2[i3]) {
                return this.mY[i3][i2];
            }
            int i6 = i3 + 1;
            if (d2 < dArr2[i6]) {
                double d3 = dArr2[i6] - dArr2[i3];
                double d4 = (d2 - dArr2[i3]) / d3;
                double[][] dArr3 = this.mY;
                double d5 = dArr3[i3][i2];
                double d6 = dArr3[i6][i2];
                double[][] dArr4 = this.mTangent;
                return interpolate(d3, d4, d5, d6, dArr4[i3][i2], dArr4[i6][i2]);
            }
            i3 = i6;
        }
        return 0.0d;
    }
}
