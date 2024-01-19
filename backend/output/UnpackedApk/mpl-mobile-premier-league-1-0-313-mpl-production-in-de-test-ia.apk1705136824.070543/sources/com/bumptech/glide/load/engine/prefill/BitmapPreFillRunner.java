package com.bumptech.glide.load.engine.prefill;

import android.os.Handler;
import android.os.Looper;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import java.security.MessageDigest;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public final class BitmapPreFillRunner implements Runnable {
    public static final Clock DEFAULT_CLOCK = new Clock();
    public static final long MAX_BACKOFF_MS = TimeUnit.SECONDS.toMillis(1);
    public final BitmapPool bitmapPool;
    public final Clock clock;
    public long currentDelay = 40;
    public final Handler handler;
    public boolean isCancelled;
    public final MemoryCache memoryCache;
    public final Set<PreFillType> seenTypes = new HashSet();
    public final PreFillQueue toPrefill;

    public static class Clock {
    }

    public static final class UniqueKey implements Key {
        public void updateDiskCacheKey(MessageDigest messageDigest) {
            throw new UnsupportedOperationException();
        }
    }

    public BitmapPreFillRunner(BitmapPool bitmapPool2, MemoryCache memoryCache2, PreFillQueue preFillQueue) {
        Clock clock2 = DEFAULT_CLOCK;
        Handler handler2 = new Handler(Looper.getMainLooper());
        this.bitmapPool = bitmapPool2;
        this.memoryCache = memoryCache2;
        this.toPrefill = preFillQueue;
        this.clock = clock2;
        this.handler = handler2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00e9, code lost:
        if ((r11.toPrefill.bitmapsRemaining == 0) == false) goto L_0x00ed;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r11 = this;
            com.bumptech.glide.load.engine.prefill.BitmapPreFillRunner$Clock r0 = r11.clock
            r1 = 0
            if (r0 == 0) goto L_0x0103
            long r2 = android.os.SystemClock.currentThreadTimeMillis()
        L_0x0009:
            com.bumptech.glide.load.engine.prefill.PreFillQueue r0 = r11.toPrefill
            int r0 = r0.bitmapsRemaining
            r4 = 1
            r5 = 0
            if (r0 != 0) goto L_0x0013
            r0 = 1
            goto L_0x0014
        L_0x0013:
            r0 = 0
        L_0x0014:
            if (r0 != 0) goto L_0x00dc
            com.bumptech.glide.load.engine.prefill.BitmapPreFillRunner$Clock r0 = r11.clock
            if (r0 == 0) goto L_0x00db
            long r6 = android.os.SystemClock.currentThreadTimeMillis()
            long r6 = r6 - r2
            r8 = 32
            int r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r0 < 0) goto L_0x0027
            r0 = 1
            goto L_0x0028
        L_0x0027:
            r0 = 0
        L_0x0028:
            if (r0 != 0) goto L_0x00dc
            com.bumptech.glide.load.engine.prefill.PreFillQueue r0 = r11.toPrefill
            java.util.List<com.bumptech.glide.load.engine.prefill.PreFillType> r6 = r0.keyList
            int r7 = r0.keyIndex
            java.lang.Object r6 = r6.get(r7)
            com.bumptech.glide.load.engine.prefill.PreFillType r6 = (com.bumptech.glide.load.engine.prefill.PreFillType) r6
            java.util.Map<com.bumptech.glide.load.engine.prefill.PreFillType, java.lang.Integer> r7 = r0.bitmapsPerType
            java.lang.Object r7 = r7.get(r6)
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r8 = r7.intValue()
            if (r8 != r4) goto L_0x0051
            java.util.Map<com.bumptech.glide.load.engine.prefill.PreFillType, java.lang.Integer> r7 = r0.bitmapsPerType
            r7.remove(r6)
            java.util.List<com.bumptech.glide.load.engine.prefill.PreFillType> r7 = r0.keyList
            int r8 = r0.keyIndex
            r7.remove(r8)
            goto L_0x005f
        L_0x0051:
            java.util.Map<com.bumptech.glide.load.engine.prefill.PreFillType, java.lang.Integer> r8 = r0.bitmapsPerType
            int r7 = r7.intValue()
            int r7 = r7 - r4
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r8.put(r6, r7)
        L_0x005f:
            int r7 = r0.bitmapsRemaining
            int r7 = r7 - r4
            r0.bitmapsRemaining = r7
            java.util.List<com.bumptech.glide.load.engine.prefill.PreFillType> r7 = r0.keyList
            boolean r7 = r7.isEmpty()
            if (r7 == 0) goto L_0x006e
            r7 = 0
            goto L_0x0078
        L_0x006e:
            int r7 = r0.keyIndex
            int r7 = r7 + r4
            java.util.List<com.bumptech.glide.load.engine.prefill.PreFillType> r4 = r0.keyList
            int r4 = r4.size()
            int r7 = r7 % r4
        L_0x0078:
            r0.keyIndex = r7
            java.util.Set<com.bumptech.glide.load.engine.prefill.PreFillType> r0 = r11.seenTypes
            boolean r0 = r0.contains(r6)
            if (r0 != 0) goto L_0x0091
            java.util.Set<com.bumptech.glide.load.engine.prefill.PreFillType> r0 = r11.seenTypes
            r0.add(r6)
            com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool r0 = r11.bitmapPool
            if (r6 == 0) goto L_0x0090
            android.graphics.Bitmap r0 = r0.getDirty(r5, r5, r1)
            goto L_0x0097
        L_0x0090:
            throw r1
        L_0x0091:
            if (r6 == 0) goto L_0x00da
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r5, r5, r1)
        L_0x0097:
            int r4 = com.bumptech.glide.util.Util.getBitmapByteSize(r0)
            com.bumptech.glide.load.engine.cache.MemoryCache r5 = r11.memoryCache
            com.bumptech.glide.util.LruCache r5 = (com.bumptech.glide.util.LruCache) r5
            long r7 = r5.getMaxSize()
            com.bumptech.glide.load.engine.cache.MemoryCache r5 = r11.memoryCache
            com.bumptech.glide.util.LruCache r5 = (com.bumptech.glide.util.LruCache) r5
            monitor-enter(r5)
            long r9 = r5.currentSize     // Catch:{ all -> 0x00d7 }
            monitor-exit(r5)
            long r7 = r7 - r9
            long r4 = (long) r4
            int r9 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r9 < 0) goto L_0x00c4
            com.bumptech.glide.load.engine.prefill.BitmapPreFillRunner$UniqueKey r4 = new com.bumptech.glide.load.engine.prefill.BitmapPreFillRunner$UniqueKey
            r4.<init>()
            com.bumptech.glide.load.engine.cache.MemoryCache r5 = r11.memoryCache
            com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool r7 = r11.bitmapPool
            com.bumptech.glide.load.resource.bitmap.BitmapResource r0 = com.bumptech.glide.load.resource.bitmap.BitmapResource.obtain(r0, r7)
            com.bumptech.glide.load.engine.cache.LruResourceCache r5 = (com.bumptech.glide.load.engine.cache.LruResourceCache) r5
            r5.put(r4, r0)
            goto L_0x00c9
        L_0x00c4:
            com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool r4 = r11.bitmapPool
            r4.put(r0)
        L_0x00c9:
            java.lang.String r0 = "PreFillRunner"
            r4 = 3
            boolean r0 = android.util.Log.isLoggable(r0, r4)
            if (r0 == 0) goto L_0x0009
            if (r6 == 0) goto L_0x00d6
            goto L_0x0009
        L_0x00d6:
            throw r1
        L_0x00d7:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        L_0x00da:
            throw r1
        L_0x00db:
            throw r1
        L_0x00dc:
            boolean r0 = r11.isCancelled
            if (r0 != 0) goto L_0x00ec
            com.bumptech.glide.load.engine.prefill.PreFillQueue r0 = r11.toPrefill
            int r0 = r0.bitmapsRemaining
            if (r0 != 0) goto L_0x00e8
            r0 = 1
            goto L_0x00e9
        L_0x00e8:
            r0 = 0
        L_0x00e9:
            if (r0 != 0) goto L_0x00ec
            goto L_0x00ed
        L_0x00ec:
            r4 = 0
        L_0x00ed:
            if (r4 == 0) goto L_0x0102
            android.os.Handler r0 = r11.handler
            long r1 = r11.currentDelay
            r3 = 4
            long r3 = r3 * r1
            long r5 = MAX_BACKOFF_MS
            long r3 = java.lang.Math.min(r3, r5)
            r11.currentDelay = r3
            r0.postDelayed(r11, r1)
        L_0x0102:
            return
        L_0x0103:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.prefill.BitmapPreFillRunner.run():void");
    }
}
