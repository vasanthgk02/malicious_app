package org.opencv.core;

import com.android.tools.r8.GeneratedOutlineSupport;

public class Rect {
    public int height;
    public int width;
    public int x;
    public int y;

    public Rect(int i, int i2, int i3, int i4) {
        this.x = i;
        this.y = i2;
        this.width = i3;
        this.height = i4;
    }

    public Object clone() throws CloneNotSupportedException {
        return new Rect(this.x, this.y, this.width, this.height);
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Rect)) {
            return false;
        }
        Rect rect = (Rect) obj;
        if (!(this.x == rect.x && this.y == rect.y && this.width == rect.width && this.height == rect.height)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits((double) this.height);
        long doubleToLongBits2 = Double.doubleToLongBits((double) this.width);
        long doubleToLongBits3 = Double.doubleToLongBits((double) this.x);
        long doubleToLongBits4 = Double.doubleToLongBits((double) this.y);
        return ((((((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)))) * 31) + ((int) (doubleToLongBits4 ^ (doubleToLongBits4 >>> 32)));
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("{");
        outline73.append(this.x);
        outline73.append(", ");
        outline73.append(this.y);
        outline73.append(", ");
        outline73.append(this.width);
        outline73.append("x");
        return GeneratedOutlineSupport.outline57(outline73, this.height, "}");
    }

    public Rect() {
        this(0, 0, 0, 0);
    }
}
