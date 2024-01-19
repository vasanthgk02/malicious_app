package com.facebook.imagepipeline.platform;

import android.annotation.TargetApi;
import android.graphics.BitmapFactory.Options;
import androidx.core.util.Pools$SynchronizedPool;
import com.facebook.imagepipeline.memory.BitmapPool;
import com.facebook.imageutils.BitmapUtil;

@TargetApi(21)
public class ArtDecoder extends DefaultDecoder {
    public ArtDecoder(BitmapPool bitmapPool, int i, Pools$SynchronizedPool pools$SynchronizedPool) {
        super(bitmapPool, i, pools$SynchronizedPool);
    }

    public int getBitmapSize(int i, int i2, Options options) {
        return BitmapUtil.getSizeInByteForBitmap(i, i2, options.inPreferredConfig);
    }
}
