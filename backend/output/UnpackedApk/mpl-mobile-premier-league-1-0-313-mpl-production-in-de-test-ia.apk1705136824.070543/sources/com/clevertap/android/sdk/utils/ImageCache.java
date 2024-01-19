package com.clevertap.android.sdk.utils;

import android.graphics.Bitmap;
import android.util.LruCache;
import com.clevertap.android.sdk.Logger;

public class ImageCache {
    public static final int cacheSize;
    public static final int maxMemory;
    public static LruCache<String, Bitmap> memoryCache;

    static {
        int maxMemory2 = ((int) Runtime.getRuntime().maxMemory()) / 1024;
        maxMemory = maxMemory2;
        cacheSize = Math.max(maxMemory2 / 32, 20480);
    }

    public static int getAvailableMemory() {
        int size;
        synchronized (ImageCache.class) {
            try {
                size = memoryCache == null ? 0 : cacheSize - memoryCache.size();
            }
        }
        return size;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0015, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap getBitmap(java.lang.String r3) {
        /*
            java.lang.Class<com.clevertap.android.sdk.utils.ImageCache> r0 = com.clevertap.android.sdk.utils.ImageCache.class
            monitor-enter(r0)
            r1 = 0
            if (r3 == 0) goto L_0x0016
            android.util.LruCache<java.lang.String, android.graphics.Bitmap> r2 = memoryCache     // Catch:{ all -> 0x0018 }
            if (r2 != 0) goto L_0x000b
            goto L_0x0014
        L_0x000b:
            android.util.LruCache<java.lang.String, android.graphics.Bitmap> r1 = memoryCache     // Catch:{ all -> 0x0018 }
            java.lang.Object r3 = r1.get(r3)     // Catch:{ all -> 0x0018 }
            r1 = r3
            android.graphics.Bitmap r1 = (android.graphics.Bitmap) r1     // Catch:{ all -> 0x0018 }
        L_0x0014:
            monitor-exit(r0)     // Catch:{ all -> 0x0018 }
            return r1
        L_0x0016:
            monitor-exit(r0)     // Catch:{ all -> 0x0018 }
            return r1
        L_0x0018:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0018 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.utils.ImageCache.getBitmap(java.lang.String):android.graphics.Bitmap");
    }

    public static void init() {
        synchronized (ImageCache.class) {
            if (memoryCache == null) {
                Logger.v("CleverTap.ImageCache: init with max device memory: " + maxMemory + "KB and allocated cache size: " + cacheSize + "KB");
                try {
                    memoryCache = new LruCache<String, Bitmap>(cacheSize) {
                        public int sizeOf(Object obj, Object obj2) {
                            int byteCount = ((Bitmap) obj2).getByteCount() / 1024;
                            Logger.v("CleverTap.ImageCache: have image of size: " + byteCount + "KB for key: " + ((String) obj));
                            return byteCount;
                        }
                    };
                } catch (Throwable th) {
                    Logger.v((String) "CleverTap.ImageCache: unable to initialize cache: ", th.getCause());
                }
            }
        }
    }

    public static void removeBitmap(String str, boolean z) {
        boolean z2;
        Class<ImageCache> cls = ImageCache.class;
        synchronized (cls) {
            if (memoryCache != null) {
                memoryCache.remove(str);
                Logger.v("CleverTap.ImageCache: removed image for key: " + str);
                synchronized (cls) {
                    synchronized (cls) {
                        z2 = memoryCache.size() <= 0;
                    }
                }
                if (z2) {
                    Logger.v("CTInAppNotification.ImageCache: cache is empty, removing it");
                    memoryCache = null;
                }
            }
        }
    }
}
