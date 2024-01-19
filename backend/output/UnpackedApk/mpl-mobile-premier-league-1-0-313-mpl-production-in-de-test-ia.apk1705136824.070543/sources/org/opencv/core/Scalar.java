package org.opencv.core;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Arrays;
import org.apache.fontbox.cmap.CMapParser;

public class Scalar {
    public double[] val;

    public Scalar(double d2, double d3, double d4, double d5) {
        this.val = new double[]{d2, d3, d4, d5};
    }

    public Object clone() throws CloneNotSupportedException {
        return new Scalar(this.val);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Scalar) && Arrays.equals(this.val, ((Scalar) obj).val);
    }

    public int hashCode() {
        return Arrays.hashCode(this.val) + 31;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("[");
        outline73.append(this.val[0]);
        outline73.append(", ");
        outline73.append(this.val[1]);
        outline73.append(", ");
        outline73.append(this.val[2]);
        outline73.append(", ");
        outline73.append(this.val[3]);
        outline73.append(CMapParser.MARK_END_OF_ARRAY);
        return outline73.toString();
    }

    public Scalar(double[] dArr) {
        if (dArr == null || dArr.length != 4) {
            double[] dArr2 = new double[4];
            this.val = dArr2;
            double d2 = 0.0d;
            if (dArr != null) {
                dArr2[0] = dArr.length > 0 ? dArr[0] : 0.0d;
                this.val[1] = dArr.length > 1 ? dArr[1] : 0.0d;
                this.val[2] = dArr.length > 2 ? dArr[2] : 0.0d;
                this.val[3] = dArr.length > 3 ? dArr[3] : d2;
                return;
            }
            dArr2[3] = 0.0d;
            dArr2[2] = 0.0d;
            dArr2[1] = 0.0d;
            dArr2[0] = 0.0d;
            return;
        }
        this.val = (double[]) dArr.clone();
    }
}
