package com.facebook.imagepipeline.common;

import co.hyperverge.hypersnapsdk.c.k;

public class ResizeOptions {
    public static final float DEFAULT_ROUNDUP_FRACTION = 0.6666667f;
    public final int height;
    public final float maxBitmapSize;
    public final float roundUpFraction;
    public final int width;

    public ResizeOptions(int i, int i2) {
        this(i, i2, 2048.0f);
    }

    public static ResizeOptions forDimensions(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return null;
        }
        return new ResizeOptions(i, i2);
    }

    public static ResizeOptions forSquareSize(int i) {
        if (i <= 0) {
            return null;
        }
        return new ResizeOptions(i, i);
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResizeOptions)) {
            return false;
        }
        ResizeOptions resizeOptions = (ResizeOptions) obj;
        if (!(this.width == resizeOptions.width && this.height == resizeOptions.height)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return k.hashCode(this.width, this.height);
    }

    public String toString() {
        return String.format(null, "%dx%d", new Object[]{Integer.valueOf(this.width), Integer.valueOf(this.height)});
    }

    public ResizeOptions(int i, int i2, float f2) {
        this(i, i2, f2, 0.6666667f);
    }

    public ResizeOptions(int i, int i2, float f2, float f3) {
        boolean z = true;
        k.checkArgument(i > 0);
        k.checkArgument(i2 <= 0 ? false : z);
        this.width = i;
        this.height = i2;
        this.maxBitmapSize = f2;
        this.roundUpFraction = f3;
    }
}