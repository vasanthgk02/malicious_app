package com.facebook.imagepipeline.nativecode;

import android.graphics.Bitmap;
import co.hyperverge.hypersnapsdk.c.k;
import com.facebook.common.internal.DoNotStrip;

@DoNotStrip
public class NativeBlurFilter {
    static {
        NativeFiltersLoader.load();
    }

    public static void iterativeBoxBlur(Bitmap bitmap, int i, int i2) {
        if (bitmap != null) {
            boolean z = true;
            k.checkArgument(i > 0);
            if (i2 <= 0) {
                z = false;
            }
            k.checkArgument(z);
            nativeIterativeBoxBlur(bitmap, i, i2);
            return;
        }
        throw null;
    }

    @DoNotStrip
    public static native void nativeIterativeBoxBlur(Bitmap bitmap, int i, int i2);
}
