package com.google.zxing;

public final class Dimension {
    public final int height;
    public final int width;

    public boolean equals(Object obj) {
        if (obj instanceof Dimension) {
            Dimension dimension = (Dimension) obj;
            if (dimension.width == 0 && dimension.height == 0) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return "0x0";
    }
}
