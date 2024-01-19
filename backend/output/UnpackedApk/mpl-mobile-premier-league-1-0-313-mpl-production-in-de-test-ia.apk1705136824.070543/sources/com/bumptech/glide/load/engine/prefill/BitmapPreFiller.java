package com.bumptech.glide.load.engine.prefill;

import android.os.Handler;
import android.os.Looper;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.prefill.PreFillType.Builder;
import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Util;
import java.util.HashMap;

public final class BitmapPreFiller {
    public final BitmapPool bitmapPool;
    public BitmapPreFillRunner current;
    public final DecodeFormat defaultFormat;
    public final Handler handler = new Handler(Looper.getMainLooper());
    public final MemoryCache memoryCache;

    public BitmapPreFiller(MemoryCache memoryCache2, BitmapPool bitmapPool2, DecodeFormat decodeFormat) {
        this.memoryCache = memoryCache2;
        this.bitmapPool = bitmapPool2;
        this.defaultFormat = decodeFormat;
    }

    public void preFill(Builder... builderArr) {
        long j;
        BitmapPreFillRunner bitmapPreFillRunner = this.current;
        if (bitmapPreFillRunner != null) {
            bitmapPreFillRunner.isCancelled = true;
        }
        int length = builderArr.length;
        PreFillType[] preFillTypeArr = new PreFillType[length];
        if (builderArr.length <= 0) {
            long maxSize = ((LruCache) this.memoryCache).getMaxSize();
            LruCache lruCache = (LruCache) this.memoryCache;
            synchronized (lruCache) {
                j = lruCache.currentSize;
            }
            long maxSize2 = this.bitmapPool.getMaxSize() + (maxSize - j);
            int i = 0;
            while (i < length) {
                if (preFillTypeArr[i] != null) {
                    i++;
                } else {
                    throw null;
                }
            }
            float f2 = (float) 0;
            float f3 = ((float) maxSize2) / f2;
            HashMap hashMap = new HashMap();
            int i2 = 0;
            while (i2 < length) {
                PreFillType preFillType = preFillTypeArr[i2];
                if (preFillType != null) {
                    hashMap.put(preFillType, Integer.valueOf(Math.round(f2 * f3) / Util.getBitmapByteSize(0, 0, null)));
                    i2++;
                } else {
                    throw null;
                }
            }
            BitmapPreFillRunner bitmapPreFillRunner2 = new BitmapPreFillRunner(this.bitmapPool, this.memoryCache, new PreFillQueue(hashMap));
            this.current = bitmapPreFillRunner2;
            this.handler.post(bitmapPreFillRunner2);
            return;
        }
        Builder builder = builderArr[0];
        throw null;
    }
}
