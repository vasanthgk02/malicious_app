package com.facebook.imagepipeline.platform;

import android.annotation.TargetApi;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.ColorSpace;
import androidx.core.util.Pools$SynchronizedPool;
import com.facebook.imagepipeline.memory.BitmapPool;
import com.facebook.imageutils.BitmapUtil;

@TargetApi(26)
public class OreoDecoder extends DefaultDecoder {
    public OreoDecoder(BitmapPool bitmapPool, int i, Pools$SynchronizedPool pools$SynchronizedPool) {
        super(bitmapPool, i, pools$SynchronizedPool);
    }

    public static boolean hasColorGamutMismatch(Options options) {
        ColorSpace colorSpace = options.outColorSpace;
        return (colorSpace == null || !colorSpace.isWideGamut() || options.inPreferredConfig == Config.RGBA_F16) ? false : true;
    }

    public int getBitmapSize(int i, int i2, Options options) {
        if (hasColorGamutMismatch(options)) {
            return i * i2 * 8;
        }
        return BitmapUtil.getSizeInByteForBitmap(i, i2, options.inPreferredConfig);
    }
}
