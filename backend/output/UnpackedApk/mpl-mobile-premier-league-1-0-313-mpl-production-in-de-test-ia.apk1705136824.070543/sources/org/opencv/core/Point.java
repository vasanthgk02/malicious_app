package org.opencv.core;

import com.android.tools.r8.GeneratedOutlineSupport;

public class Point {
    public double x;
    public double y;

    public Point(double d2, double d3) {
        this.x = d2;
        this.y = d3;
    }

    public Object clone() throws CloneNotSupportedException {
        return new Point(this.x, this.y);
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Point)) {
            return false;
        }
        Point point = (Point) obj;
        if (!(this.x == point.x && this.y == point.y)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.x);
        long doubleToLongBits2 = Double.doubleToLongBits(this.y);
        return ((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("{");
        outline73.append(this.x);
        outline73.append(", ");
        outline73.append(this.y);
        outline73.append("}");
        return outline73.toString();
    }

    public Point() {
        this(0.0d, 0.0d);
    }
}
