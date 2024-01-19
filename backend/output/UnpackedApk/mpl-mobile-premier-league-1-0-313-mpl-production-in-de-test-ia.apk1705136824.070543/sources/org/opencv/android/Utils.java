package org.opencv.android;

import android.graphics.Bitmap;

public class Utils {
    public static native void nBitmapToMat2(Bitmap bitmap, long j, boolean z);

    public static native void nMatToBitmap2(long j, Bitmap bitmap, boolean z);
}
