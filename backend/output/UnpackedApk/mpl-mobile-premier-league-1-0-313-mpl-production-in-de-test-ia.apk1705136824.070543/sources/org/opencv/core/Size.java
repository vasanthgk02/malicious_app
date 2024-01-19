package org.opencv.core;

public class Size {
    public double height;
    public double width;

    public Size(double d2, double d3) {
        this.width = d2;
        this.height = d3;
    }

    public Object clone() throws CloneNotSupportedException {
        return new Size(this.width, this.height);
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Size)) {
            return false;
        }
        Size size = (Size) obj;
        if (!(this.width == size.width && this.height == size.height)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.height);
        long doubleToLongBits2 = Double.doubleToLongBits(this.width);
        return ((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
    }

    public String toString() {
        return ((int) this.width) + "x" + ((int) this.height);
    }

    public Size() {
        this(0.0d, 0.0d);
    }
}
