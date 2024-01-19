package com.facebook.imagepipeline.nativecode;

import android.graphics.Bitmap;
import co.hyperverge.hypersnapsdk.c.k;
import com.facebook.common.internal.DoNotStrip;

@DoNotStrip
public class Bitmaps {
    static {
        ImagePipelineNativeLoader.load();
    }

    @DoNotStrip
    public static void copyBitmap(Bitmap bitmap, Bitmap bitmap2) {
        boolean z = true;
        k.checkArgument(bitmap2.getConfig() == bitmap.getConfig());
        k.checkArgument(bitmap.isMutable());
        k.checkArgument(bitmap.getWidth() == bitmap2.getWidth());
        if (bitmap.getHeight() != bitmap2.getHeight()) {
            z = false;
        }
        k.checkArgument(z);
        nativeCopyBitmap(bitmap, bitmap.getRowBytes(), bitmap2, bitmap2.getRowBytes(), bitmap.getHeight());
    }

    @DoNotStrip
    public static native void nativeCopyBitmap(Bitmap bitmap, int i, Bitmap bitmap2, int i2, int i3);
}
