package com.facebook.imagepipeline.platform;

import android.os.Build.VERSION;
import androidx.core.util.Pools$SynchronizedPool;
import com.facebook.imagepipeline.memory.PoolFactory;

public class PlatformDecoderFactory {
    public static PlatformDecoder buildPlatformDecoder(PoolFactory poolFactory, boolean z) {
        if (VERSION.SDK_INT >= 26) {
            int flexByteArrayPoolMaxNumThreads = poolFactory.getFlexByteArrayPoolMaxNumThreads();
            return new OreoDecoder(poolFactory.getBitmapPool(), flexByteArrayPoolMaxNumThreads, new Pools$SynchronizedPool(flexByteArrayPoolMaxNumThreads));
        }
        int flexByteArrayPoolMaxNumThreads2 = poolFactory.getFlexByteArrayPoolMaxNumThreads();
        return new ArtDecoder(poolFactory.getBitmapPool(), flexByteArrayPoolMaxNumThreads2, new Pools$SynchronizedPool(flexByteArrayPoolMaxNumThreads2));
    }
}
