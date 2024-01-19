package org.opencv.core;

import com.android.tools.r8.GeneratedOutlineSupport;

public class Range {
    public int end;
    public int start;

    public Range(int i, int i2) {
        this.start = i;
        this.end = i2;
    }

    public Object clone() throws CloneNotSupportedException {
        return new Range(this.start, this.end);
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Range)) {
            return false;
        }
        Range range = (Range) obj;
        if (!(this.start == range.start && this.end == range.end)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits((double) this.start);
        long doubleToLongBits2 = Double.doubleToLongBits((double) this.end);
        return ((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("[");
        outline73.append(this.start);
        outline73.append(", ");
        return GeneratedOutlineSupport.outline57(outline73, this.end, ")");
    }

    public Range() {
        this(0, 0);
    }
}
