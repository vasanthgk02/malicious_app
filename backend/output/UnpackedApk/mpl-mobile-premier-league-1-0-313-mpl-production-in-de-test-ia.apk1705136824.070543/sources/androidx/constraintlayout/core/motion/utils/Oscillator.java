package androidx.constraintlayout.core.motion.utils;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Arrays;

public class Oscillator {
    public double PI2 = 6.283185307179586d;
    public double[] mArea;
    public MonotonicCurveFit mCustomCurve;
    public String mCustomType;
    public float[] mPeriod = new float[0];
    public double[] mPosition = new double[0];
    public int mType;

    public void addPoint(double d2, float f2) {
        int length = this.mPeriod.length + 1;
        int binarySearch = Arrays.binarySearch(this.mPosition, d2);
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 1;
        }
        this.mPosition = Arrays.copyOf(this.mPosition, length);
        this.mPeriod = Arrays.copyOf(this.mPeriod, length);
        this.mArea = new double[length];
        double[] dArr = this.mPosition;
        System.arraycopy(dArr, binarySearch, dArr, binarySearch + 1, (length - binarySearch) - 1);
        this.mPosition[binarySearch] = d2;
        this.mPeriod[binarySearch] = f2;
    }

    public double getP(double d2) {
        if (d2 < 0.0d) {
            d2 = 0.0d;
        } else if (d2 > 1.0d) {
            d2 = 1.0d;
        }
        int binarySearch = Arrays.binarySearch(this.mPosition, d2);
        if (binarySearch > 0) {
            return 1.0d;
        }
        if (binarySearch == 0) {
            return 0.0d;
        }
        int i = (-binarySearch) - 1;
        float[] fArr = this.mPeriod;
        int i2 = i - 1;
        double d3 = (double) (fArr[i] - fArr[i2]);
        double[] dArr = this.mPosition;
        double d4 = d3 / (dArr[i] - dArr[i2]);
        return ((((d2 * d2) - (dArr[i2] * dArr[i2])) * d4) / 2.0d) + ((d2 - dArr[i2]) * (((double) fArr[i2]) - (dArr[i2] * d4))) + this.mArea[i2];
    }

    public double getValue(double d2, double d3) {
        double abs;
        double p = getP(d2) + d3;
        switch (this.mType) {
            case 1:
                return Math.signum(0.5d - (p % 1.0d));
            case 2:
                abs = Math.abs((((p * 4.0d) + 1.0d) % 4.0d) - 2.0d);
                break;
            case 3:
                return (((p * 2.0d) + 1.0d) % 2.0d) - 1.0d;
            case 4:
                abs = ((p * 2.0d) + 1.0d) % 2.0d;
                break;
            case 5:
                return Math.cos((d3 + p) * this.PI2);
            case 6:
                double abs2 = 1.0d - Math.abs(((p * 4.0d) % 4.0d) - 2.0d);
                abs = abs2 * abs2;
                break;
            case 7:
                return this.mCustomCurve.getPos(p % 1.0d, 0);
            default:
                return Math.sin(this.PI2 * p);
        }
        return 1.0d - abs;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("pos =");
        outline73.append(Arrays.toString(this.mPosition));
        outline73.append(" period=");
        outline73.append(Arrays.toString(this.mPeriod));
        return outline73.toString();
    }
}
