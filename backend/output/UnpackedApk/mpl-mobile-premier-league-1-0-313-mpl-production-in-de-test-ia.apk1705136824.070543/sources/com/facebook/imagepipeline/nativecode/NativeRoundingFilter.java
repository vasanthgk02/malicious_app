package com.facebook.imagepipeline.nativecode;

import android.graphics.Bitmap;
import com.facebook.common.internal.DoNotStrip;

@DoNotStrip
public class NativeRoundingFilter {
    static {
        NativeFiltersLoader.load();
    }

    public static void addRoundedCorners(Bitmap bitmap, int i, int i2, int i3, int i4) {
        nativeAddRoundedCornersFilter(bitmap, i, i2, i3, i4);
    }

    @DoNotStrip
    public static native void nativeAddRoundedCornersFilter(Bitmap bitmap, int i, int i2, int i3, int i4);

    @DoNotStrip
    public static native void nativeToCircleFastFilter(Bitmap bitmap, boolean z);

    @DoNotStrip
    public static native void nativeToCircleFilter(Bitmap bitmap, boolean z);

    @DoNotStrip
    public static native void nativeToCircleWithBorderFilter(Bitmap bitmap, int i, int i2, boolean z);

    public static void toCircle(Bitmap bitmap) {
        toCircle(bitmap, false);
    }

    public static void toCircleFast(Bitmap bitmap) {
        toCircleFast(bitmap, false);
    }

    public static void toCircleWithBorder(Bitmap bitmap, int i, int i2, boolean z) {
        if (bitmap != null) {
            nativeToCircleWithBorderFilter(bitmap, i, i2, z);
            return;
        }
        throw null;
    }

    @DoNotStrip
    public static void toCircle(Bitmap bitmap, boolean z) {
        if (bitmap != null) {
            nativeToCircleFilter(bitmap, z);
            return;
        }
        throw null;
    }

    @DoNotStrip
    public static void toCircleFast(Bitmap bitmap, boolean z) {
        if (bitmap != null) {
            nativeToCircleFastFilter(bitmap, z);
            return;
        }
        throw null;
    }
}
