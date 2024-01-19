package com.facebook.imagepipeline.cache;

import co.hyperverge.hypersnapsdk.c.k;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.EncodedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StagingArea {
    public static final Class<?> TAG = StagingArea.class;
    public Map<CacheKey, EncodedImage> mMap = new HashMap();

    public static StagingArea getInstance() {
        return new StagingArea();
    }

    private synchronized void logStats() {
        FLog.v(TAG, (String) "Count = %d", (Object) Integer.valueOf(this.mMap.size()));
    }

    public void clearAll() {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.mMap.values());
            this.mMap.clear();
        }
        for (int i = 0; i < arrayList.size(); i++) {
            EncodedImage encodedImage = (EncodedImage) arrayList.get(i);
            if (encodedImage != null) {
                encodedImage.close();
            }
        }
    }

    public synchronized boolean containsKey(CacheKey cacheKey) {
        if (cacheKey != null) {
            try {
                if (!this.mMap.containsKey(cacheKey)) {
                    return false;
                }
                EncodedImage encodedImage = this.mMap.get(cacheKey);
                synchronized (encodedImage) {
                    if (EncodedImage.isValid(encodedImage)) {
                        return true;
                    }
                    this.mMap.remove(cacheKey);
                    FLog.w(TAG, (String) "Found closed reference %d for key %s (%d)", Integer.valueOf(System.identityHashCode(encodedImage)), cacheKey.getUriString(), Integer.valueOf(System.identityHashCode(cacheKey)));
                    return false;
                }
            } catch (Throwable th) {
                throw th;
            }
        } else {
            throw null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0049, code lost:
        r1 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004f, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.facebook.imagepipeline.image.EncodedImage get(com.facebook.cache.common.CacheKey r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            r0 = 0
            if (r8 == 0) goto L_0x0052
            java.util.Map<com.facebook.cache.common.CacheKey, com.facebook.imagepipeline.image.EncodedImage> r1 = r7.mMap     // Catch:{ all -> 0x0050 }
            java.lang.Object r1 = r1.get(r8)     // Catch:{ all -> 0x0050 }
            com.facebook.imagepipeline.image.EncodedImage r1 = (com.facebook.imagepipeline.image.EncodedImage) r1     // Catch:{ all -> 0x0050 }
            if (r1 == 0) goto L_0x004e
            monitor-enter(r1)     // Catch:{ all -> 0x0050 }
            boolean r2 = com.facebook.imagepipeline.image.EncodedImage.isValid(r1)     // Catch:{ all -> 0x004b }
            if (r2 != 0) goto L_0x0044
            java.util.Map<com.facebook.cache.common.CacheKey, com.facebook.imagepipeline.image.EncodedImage> r2 = r7.mMap     // Catch:{ all -> 0x004b }
            r2.remove(r8)     // Catch:{ all -> 0x004b }
            java.lang.Class<?> r2 = TAG     // Catch:{ all -> 0x004b }
            java.lang.String r3 = "Found closed reference %d for key %s (%d)"
            r4 = 3
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x004b }
            r5 = 0
            int r6 = java.lang.System.identityHashCode(r1)     // Catch:{ all -> 0x004b }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x004b }
            r4[r5] = r6     // Catch:{ all -> 0x004b }
            r5 = 1
            java.lang.String r6 = r8.getUriString()     // Catch:{ all -> 0x004b }
            r4[r5] = r6     // Catch:{ all -> 0x004b }
            r5 = 2
            int r8 = java.lang.System.identityHashCode(r8)     // Catch:{ all -> 0x004b }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x004b }
            r4[r5] = r8     // Catch:{ all -> 0x004b }
            com.facebook.common.logging.FLog.w(r2, r3, r4)     // Catch:{ all -> 0x004b }
            monitor-exit(r1)     // Catch:{ all -> 0x004b }
            monitor-exit(r7)
            return r0
        L_0x0044:
            com.facebook.imagepipeline.image.EncodedImage r8 = com.facebook.imagepipeline.image.EncodedImage.cloneOrNull(r1)     // Catch:{ all -> 0x004b }
            monitor-exit(r1)     // Catch:{ all -> 0x004b }
            r1 = r8
            goto L_0x004e
        L_0x004b:
            r8 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x004b }
            throw r8     // Catch:{ all -> 0x0050 }
        L_0x004e:
            monitor-exit(r7)
            return r1
        L_0x0050:
            r8 = move-exception
            goto L_0x0053
        L_0x0052:
            throw r0     // Catch:{ all -> 0x0050 }
        L_0x0053:
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.cache.StagingArea.get(com.facebook.cache.common.CacheKey):com.facebook.imagepipeline.image.EncodedImage");
    }

    public synchronized void put(CacheKey cacheKey, EncodedImage encodedImage) {
        if (cacheKey != null) {
            k.checkArgument(EncodedImage.isValid(encodedImage));
            EncodedImage.closeSafely(this.mMap.put(cacheKey, EncodedImage.cloneOrNull(encodedImage)));
            logStats();
        } else {
            throw null;
        }
    }

    public boolean remove(CacheKey cacheKey) {
        EncodedImage remove;
        if (cacheKey != null) {
            synchronized (this) {
                remove = this.mMap.remove(cacheKey);
            }
            if (remove == null) {
                return false;
            }
            try {
                return remove.isValid();
            } finally {
                remove.close();
            }
        } else {
            throw null;
        }
    }

    /* JADX INFO: finally extract failed */
    public synchronized boolean remove(CacheKey cacheKey, EncodedImage encodedImage) {
        if (cacheKey == null) {
            throw null;
        } else if (encodedImage != null) {
            k.checkArgument(EncodedImage.isValid(encodedImage));
            EncodedImage encodedImage2 = this.mMap.get(cacheKey);
            if (encodedImage2 == null) {
                return false;
            }
            CloseableReference<PooledByteBuffer> byteBufferRef = encodedImage2.getByteBufferRef();
            CloseableReference<PooledByteBuffer> byteBufferRef2 = encodedImage.getByteBufferRef();
            if (!(byteBufferRef == null || byteBufferRef2 == null)) {
                try {
                    if (byteBufferRef.get() == byteBufferRef2.get()) {
                        this.mMap.remove(cacheKey);
                        byteBufferRef2.close();
                        byteBufferRef.close();
                        EncodedImage.closeSafely(encodedImage2);
                        logStats();
                        return true;
                    }
                } catch (Throwable th) {
                    byteBufferRef2.close();
                    byteBufferRef.close();
                    EncodedImage.closeSafely(encodedImage2);
                    throw th;
                }
            }
            CloseableReference.closeSafely(byteBufferRef2);
            if (byteBufferRef != null) {
                byteBufferRef.close();
            }
            EncodedImage.closeSafely(encodedImage2);
            return false;
        } else {
            throw null;
        }
    }
}
