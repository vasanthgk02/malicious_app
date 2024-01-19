package androidx.constraintlayout.core.motion.utils;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public abstract class KeyCycleOscillator {
    public CycleOscillator mCycleOscillator;
    public String mType;
    public int mVariesBy = 0;
    public ArrayList<WavePoint> mWavePoints = new ArrayList<>();
    public int mWaveShape = 0;
    public String mWaveString = null;

    public static class CycleOscillator {
        public CurveFit mCurveFit;
        public float[] mOffset;
        public Oscillator mOscillator;
        public float[] mPeriod;
        public float[] mPhase;
        public double[] mPosition;
        public double[] mSplineSlopeCache;
        public double[] mSplineValueCache;
        public float[] mValues;

        public CycleOscillator(int i, String str, int i2, int i3) {
            long j;
            String str2 = str;
            int i4 = i3;
            Oscillator oscillator = new Oscillator();
            this.mOscillator = oscillator;
            oscillator.mType = i;
            oscillator.mCustomType = str2;
            if (str2 != null) {
                double[] dArr = new double[(str.length() / 2)];
                int indexOf = str2.indexOf(40) + 1;
                int indexOf2 = str2.indexOf(44, indexOf);
                char c2 = 0;
                int i5 = 0;
                while (indexOf2 != -1) {
                    dArr[i5] = Double.parseDouble(str2.substring(indexOf, indexOf2).trim());
                    indexOf = indexOf2 + 1;
                    indexOf2 = str2.indexOf(44, indexOf);
                    i5++;
                }
                dArr[i5] = Double.parseDouble(str2.substring(indexOf, str2.indexOf(41, indexOf)).trim());
                double[] copyOf = Arrays.copyOf(dArr, i5 + 1);
                int length = (copyOf.length * 3) - 2;
                int length2 = copyOf.length - 1;
                double d2 = 1.0d / ((double) length2);
                int[] iArr = new int[2];
                iArr[1] = 1;
                iArr[0] = length;
                double[][] dArr2 = (double[][]) Array.newInstance(double.class, iArr);
                double[] dArr3 = new double[length];
                int i6 = 0;
                while (i6 < copyOf.length) {
                    double d3 = copyOf[i6];
                    int i7 = i6 + length2;
                    dArr2[i7][c2] = d3;
                    double d4 = ((double) i6) * d2;
                    dArr3[i7] = d4;
                    if (i6 > 0) {
                        int i8 = (length2 * 2) + i6;
                        j = 4607182418800017408L;
                        dArr2[i8][0] = d3 + 1.0d;
                        dArr3[i8] = d4 + 1.0d;
                        int i9 = i6 - 1;
                        dArr2[i9][0] = (d3 - 1.0d) - d2;
                        dArr3[i9] = (d4 - 4.0d) - d2;
                    } else {
                        j = 4607182418800017408L;
                    }
                    i6++;
                    long j2 = j;
                    c2 = 0;
                }
                oscillator.mCustomCurve = new MonotonicCurveFit(dArr3, dArr2);
            }
            this.mValues = new float[i4];
            this.mPosition = new double[i4];
            this.mPeriod = new float[i4];
            this.mOffset = new float[i4];
            this.mPhase = new float[i4];
            float[] fArr = new float[i4];
        }
    }

    public static class WavePoint {
        public float mOffset;
        public float mPeriod;
        public float mPhase;
        public int mPosition;
        public float mValue;

        public WavePoint(int i, float f2, float f3, float f4, float f5) {
            this.mPosition = i;
            this.mValue = f5;
            this.mOffset = f3;
            this.mPeriod = f2;
            this.mPhase = f4;
        }
    }

    public float get(float f2) {
        CycleOscillator cycleOscillator = this.mCycleOscillator;
        CurveFit curveFit = cycleOscillator.mCurveFit;
        if (curveFit != null) {
            curveFit.getPos((double) f2, cycleOscillator.mSplineValueCache);
        } else {
            double[] dArr = cycleOscillator.mSplineValueCache;
            dArr[0] = (double) cycleOscillator.mOffset[0];
            dArr[1] = (double) cycleOscillator.mPhase[0];
            dArr[2] = (double) cycleOscillator.mValues[0];
        }
        double[] dArr2 = cycleOscillator.mSplineValueCache;
        return (float) ((cycleOscillator.mOscillator.getValue((double) f2, dArr2[1]) * cycleOscillator.mSplineValueCache[2]) + dArr2[0]);
    }

    public float getSlope(float f2) {
        double d2;
        double d3;
        double d4;
        double signum;
        float f3 = f2;
        CycleOscillator cycleOscillator = this.mCycleOscillator;
        CurveFit curveFit = cycleOscillator.mCurveFit;
        if (curveFit != null) {
            double d5 = (double) f3;
            curveFit.getSlope(d5, cycleOscillator.mSplineSlopeCache);
            cycleOscillator.mCurveFit.getPos(d5, cycleOscillator.mSplineValueCache);
        } else {
            double[] dArr = cycleOscillator.mSplineSlopeCache;
            dArr[0] = 0.0d;
            dArr[1] = 0.0d;
            dArr[2] = 0.0d;
        }
        double d6 = (double) f3;
        double value = cycleOscillator.mOscillator.getValue(d6, cycleOscillator.mSplineValueCache[1]);
        Oscillator oscillator = cycleOscillator.mOscillator;
        double d7 = cycleOscillator.mSplineValueCache[1];
        double d8 = cycleOscillator.mSplineSlopeCache[1];
        double p = oscillator.getP(d6) + d7;
        if (d6 <= 0.0d) {
            d6 = 1.0E-5d;
        } else if (d6 >= 1.0d) {
            d6 = 0.999999d;
        }
        int binarySearch = Arrays.binarySearch(oscillator.mPosition, d6);
        if (binarySearch <= 0 && binarySearch != 0) {
            int i = (-binarySearch) - 1;
            float[] fArr = oscillator.mPeriod;
            int i2 = i - 1;
            double d9 = (double) (fArr[i] - fArr[i2]);
            double[] dArr2 = oscillator.mPosition;
            double d10 = d9 / (dArr2[i] - dArr2[i2]);
            d2 = (((double) fArr[i2]) - (d10 * dArr2[i2])) + (d6 * d10);
        } else {
            d2 = 0.0d;
        }
        double d11 = d2 + d8;
        switch (oscillator.mType) {
            case 1:
                d3 = 0.0d;
                break;
            case 2:
                d4 = d11 * 4.0d;
                signum = Math.signum((((p * 4.0d) + 3.0d) % 4.0d) - 2.0d);
                break;
            case 3:
                d3 = d11 * 2.0d;
                break;
            case 4:
                d3 = (-d11) * 2.0d;
                break;
            case 5:
                double d12 = oscillator.PI2;
                d3 = Math.sin(d12 * p) * (-d12) * d11;
                break;
            case 6:
                d4 = d11 * 4.0d;
                signum = (((p * 4.0d) + 2.0d) % 4.0d) - 2.0d;
                break;
            case 7:
                d3 = oscillator.mCustomCurve.getSlope(p % 1.0d, 0);
                break;
            default:
                double d13 = oscillator.PI2;
                d4 = d11 * d13;
                signum = Math.cos(d13 * p);
                break;
        }
        d3 = d4 * signum;
        double[] dArr3 = cycleOscillator.mSplineSlopeCache;
        return (float) ((d3 * cycleOscillator.mSplineValueCache[2]) + (value * dArr3[2]) + dArr3[0]);
    }

    public void setCustom(Object obj) {
    }

    public void setup(float f2) {
        int i;
        Class<double> cls = double.class;
        int size = this.mWavePoints.size();
        if (size != 0) {
            Collections.sort(this.mWavePoints, new Comparator<WavePoint>(this) {
                public int compare(Object obj, Object obj2) {
                    return Integer.compare(((WavePoint) obj).mPosition, ((WavePoint) obj2).mPosition);
                }
            });
            double[] dArr = new double[size];
            char c2 = 2;
            int[] iArr = new int[2];
            iArr[1] = 3;
            char c3 = 0;
            iArr[0] = size;
            double[][] dArr2 = (double[][]) Array.newInstance(cls, iArr);
            this.mCycleOscillator = new CycleOscillator(this.mWaveShape, this.mWaveString, this.mVariesBy, size);
            Iterator<WavePoint> it = this.mWavePoints.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                WavePoint next = it.next();
                float f3 = next.mPeriod;
                dArr[i2] = ((double) f3) * 0.01d;
                double[] dArr3 = dArr2[i2];
                float f4 = next.mValue;
                dArr3[c3] = (double) f4;
                double[] dArr4 = dArr2[i2];
                float f5 = next.mOffset;
                dArr4[1] = (double) f5;
                double[] dArr5 = dArr2[i2];
                float f6 = next.mPhase;
                Iterator<WavePoint> it2 = it;
                dArr5[c2] = (double) f6;
                CycleOscillator cycleOscillator = this.mCycleOscillator;
                cycleOscillator.mPosition[i2] = ((double) next.mPosition) / 100.0d;
                cycleOscillator.mPeriod[i2] = f3;
                cycleOscillator.mOffset[i2] = f5;
                cycleOscillator.mPhase[i2] = f6;
                cycleOscillator.mValues[i2] = f4;
                i2++;
                dArr = dArr;
                it = it2;
                dArr2 = dArr2;
                c2 = 2;
                c3 = 0;
            }
            double[] dArr6 = dArr;
            double[][] dArr7 = dArr2;
            CycleOscillator cycleOscillator2 = this.mCycleOscillator;
            int length = cycleOscillator2.mPosition.length;
            int[] iArr2 = new int[2];
            iArr2[1] = 3;
            iArr2[0] = length;
            double[][] dArr8 = (double[][]) Array.newInstance(cls, iArr2);
            float[] fArr = cycleOscillator2.mValues;
            cycleOscillator2.mSplineValueCache = new double[(fArr.length + 2)];
            cycleOscillator2.mSplineSlopeCache = new double[(fArr.length + 2)];
            if (cycleOscillator2.mPosition[0] > 0.0d) {
                cycleOscillator2.mOscillator.addPoint(0.0d, cycleOscillator2.mPeriod[0]);
            }
            double[] dArr9 = cycleOscillator2.mPosition;
            int length2 = dArr9.length - 1;
            if (dArr9[length2] < 1.0d) {
                cycleOscillator2.mOscillator.addPoint(1.0d, cycleOscillator2.mPeriod[length2]);
            }
            for (int i3 = 0; i3 < dArr8.length; i3++) {
                dArr8[i3][0] = (double) cycleOscillator2.mOffset[i3];
                dArr8[i3][1] = (double) cycleOscillator2.mPhase[i3];
                dArr8[i3][2] = (double) cycleOscillator2.mValues[i3];
                cycleOscillator2.mOscillator.addPoint(cycleOscillator2.mPosition[i3], cycleOscillator2.mPeriod[i3]);
            }
            Oscillator oscillator = cycleOscillator2.mOscillator;
            double d2 = 0.0d;
            int i4 = 0;
            while (true) {
                float[] fArr2 = oscillator.mPeriod;
                if (i4 >= fArr2.length) {
                    break;
                }
                d2 += (double) fArr2[i4];
                i4++;
            }
            double d3 = 0.0d;
            int i5 = 1;
            while (true) {
                float[] fArr3 = oscillator.mPeriod;
                if (i5 >= fArr3.length) {
                    break;
                }
                int i6 = i5 - 1;
                float f7 = (fArr3[i6] + fArr3[i5]) / 2.0f;
                double[] dArr10 = oscillator.mPosition;
                d3 = ((dArr10[i5] - dArr10[i6]) * ((double) f7)) + d3;
                i5++;
            }
            int i7 = 0;
            while (true) {
                float[] fArr4 = oscillator.mPeriod;
                if (i7 >= fArr4.length) {
                    break;
                }
                fArr4[i7] = (float) (((double) fArr4[i7]) * (d2 / d3));
                i7++;
            }
            oscillator.mArea[0] = 0.0d;
            int i8 = 1;
            while (true) {
                float[] fArr5 = oscillator.mPeriod;
                if (i8 >= fArr5.length) {
                    break;
                }
                int i9 = i8 - 1;
                double[] dArr11 = oscillator.mPosition;
                double d4 = dArr11[i8] - dArr11[i9];
                double[] dArr12 = oscillator.mArea;
                dArr12[i8] = (d4 * ((double) ((fArr5[i9] + fArr5[i8]) / 2.0f))) + dArr12[i9];
                i8++;
            }
            double[] dArr13 = cycleOscillator2.mPosition;
            if (dArr13.length > 1) {
                i = 0;
                cycleOscillator2.mCurveFit = CurveFit.get(0, dArr13, dArr8);
            } else {
                i = 0;
                cycleOscillator2.mCurveFit = null;
            }
            CurveFit.get(i, dArr6, dArr7);
        }
    }

    public String toString() {
        String str = this.mType;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        Iterator<WavePoint> it = this.mWavePoints.iterator();
        while (it.hasNext()) {
            WavePoint next = it.next();
            StringBuilder outline78 = GeneratedOutlineSupport.outline78(str, "[");
            outline78.append(next.mPosition);
            outline78.append(" , ");
            outline78.append(decimalFormat.format((double) next.mValue));
            outline78.append("] ");
            str = outline78.toString();
        }
        return str;
    }
}
