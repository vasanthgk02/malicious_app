package com.bumptech.glide.load.engine.cache;

import android.util.Log;
import com.bumptech.glide.disklrucache.DiskLruCache;
import com.bumptech.glide.disklrucache.DiskLruCache.Value;
import com.bumptech.glide.disklrucache.Util;
import com.bumptech.glide.load.Key;
import java.io.File;
import java.io.IOException;

public class DiskLruCacheWrapper implements DiskCache {
    public final File directory;
    public DiskLruCache diskLruCache;
    public final long maxSize;
    public final SafeKeyGenerator safeKeyGenerator;
    public final DiskCacheWriteLocker writeLocker = new DiskCacheWriteLocker();

    @Deprecated
    public DiskLruCacheWrapper(File file, long j) {
        this.directory = file;
        this.maxSize = j;
        this.safeKeyGenerator = new SafeKeyGenerator();
    }

    public synchronized void clear() {
        try {
            DiskLruCache diskCache = getDiskCache();
            diskCache.close();
            Util.deleteContents(diskCache.directory);
        } catch (IOException unused) {
            try {
                Log.isLoggable("DiskLruCacheWrapper", 5);
            } catch (Throwable th) {
                resetDiskCache();
                throw th;
            }
        }
        resetDiskCache();
    }

    public File get(Key key) {
        String safeKey = this.safeKeyGenerator.getSafeKey(key);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            "Get: Obtained: " + safeKey + " for for Key: " + key;
        }
        try {
            Value value = getDiskCache().get(safeKey);
            if (value != null) {
                return value.files[0];
            }
            return null;
        } catch (IOException unused) {
            boolean isLoggable = Log.isLoggable("DiskLruCacheWrapper", 5);
            return null;
        }
    }

    public final synchronized DiskLruCache getDiskCache() throws IOException {
        if (this.diskLruCache == null) {
            this.diskLruCache = DiskLruCache.open(this.directory, 1, 1, this.maxSize);
        }
        return this.diskLruCache;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x009e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void put(com.bumptech.glide.load.Key r6, com.bumptech.glide.load.engine.cache.DiskCache.Writer r7) {
        /*
            r5 = this;
            com.bumptech.glide.load.engine.cache.SafeKeyGenerator r0 = r5.safeKeyGenerator
            java.lang.String r0 = r0.getSafeKey(r6)
            com.bumptech.glide.load.engine.cache.DiskCacheWriteLocker r1 = r5.writeLocker
            monitor-enter(r1)
            java.util.Map<java.lang.String, com.bumptech.glide.load.engine.cache.DiskCacheWriteLocker$WriteLock> r2 = r1.locks     // Catch:{ all -> 0x00c4 }
            java.lang.Object r2 = r2.get(r0)     // Catch:{ all -> 0x00c4 }
            com.bumptech.glide.load.engine.cache.DiskCacheWriteLocker$WriteLock r2 = (com.bumptech.glide.load.engine.cache.DiskCacheWriteLocker.WriteLock) r2     // Catch:{ all -> 0x00c4 }
            if (r2 != 0) goto L_0x0031
            com.bumptech.glide.load.engine.cache.DiskCacheWriteLocker$WriteLockPool r2 = r1.writeLockPool     // Catch:{ all -> 0x00c4 }
            java.util.Queue<com.bumptech.glide.load.engine.cache.DiskCacheWriteLocker$WriteLock> r3 = r2.pool     // Catch:{ all -> 0x00c4 }
            monitor-enter(r3)     // Catch:{ all -> 0x00c4 }
            java.util.Queue<com.bumptech.glide.load.engine.cache.DiskCacheWriteLocker$WriteLock> r2 = r2.pool     // Catch:{ all -> 0x002e }
            java.lang.Object r2 = r2.poll()     // Catch:{ all -> 0x002e }
            com.bumptech.glide.load.engine.cache.DiskCacheWriteLocker$WriteLock r2 = (com.bumptech.glide.load.engine.cache.DiskCacheWriteLocker.WriteLock) r2     // Catch:{ all -> 0x002e }
            monitor-exit(r3)     // Catch:{ all -> 0x002e }
            if (r2 != 0) goto L_0x0028
            com.bumptech.glide.load.engine.cache.DiskCacheWriteLocker$WriteLock r2 = new com.bumptech.glide.load.engine.cache.DiskCacheWriteLocker$WriteLock     // Catch:{ all -> 0x00c4 }
            r2.<init>()     // Catch:{ all -> 0x00c4 }
        L_0x0028:
            java.util.Map<java.lang.String, com.bumptech.glide.load.engine.cache.DiskCacheWriteLocker$WriteLock> r3 = r1.locks     // Catch:{ all -> 0x00c4 }
            r3.put(r0, r2)     // Catch:{ all -> 0x00c4 }
            goto L_0x0031
        L_0x002e:
            r6 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x002e }
            throw r6     // Catch:{ all -> 0x00c4 }
        L_0x0031:
            int r3 = r2.interestedThreads     // Catch:{ all -> 0x00c4 }
            r4 = 1
            int r3 = r3 + r4
            r2.interestedThreads = r3     // Catch:{ all -> 0x00c4 }
            monitor-exit(r1)     // Catch:{ all -> 0x00c4 }
            java.util.concurrent.locks.Lock r1 = r2.lock
            r1.lock()
            java.lang.String r1 = "DiskLruCacheWrapper"
            r2 = 2
            boolean r1 = android.util.Log.isLoggable(r1, r2)     // Catch:{ all -> 0x00bd }
            if (r1 == 0) goto L_0x005e
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00bd }
            r1.<init>()     // Catch:{ all -> 0x00bd }
            java.lang.String r2 = "Put: Obtained: "
            r1.append(r2)     // Catch:{ all -> 0x00bd }
            r1.append(r0)     // Catch:{ all -> 0x00bd }
            java.lang.String r2 = " for for Key: "
            r1.append(r2)     // Catch:{ all -> 0x00bd }
            r1.append(r6)     // Catch:{ all -> 0x00bd }
            r1.toString()     // Catch:{ all -> 0x00bd }
        L_0x005e:
            com.bumptech.glide.disklrucache.DiskLruCache r6 = r5.getDiskCache()     // Catch:{ IOException -> 0x00b6 }
            com.bumptech.glide.disklrucache.DiskLruCache$Value r1 = r6.get(r0)     // Catch:{ IOException -> 0x00b6 }
            if (r1 == 0) goto L_0x006e
        L_0x0068:
            com.bumptech.glide.load.engine.cache.DiskCacheWriteLocker r6 = r5.writeLocker
            r6.release(r0)
            return
        L_0x006e:
            com.bumptech.glide.disklrucache.DiskLruCache$Editor r6 = r6.edit(r0)     // Catch:{ IOException -> 0x00b6 }
            if (r6 == 0) goto L_0x009f
            r1 = 0
            java.io.File r1 = r6.getFile(r1)     // Catch:{ all -> 0x0096 }
            com.bumptech.glide.load.engine.DataCacheWriter r7 = (com.bumptech.glide.load.engine.DataCacheWriter) r7     // Catch:{ all -> 0x0096 }
            com.bumptech.glide.load.Encoder<DataType> r2 = r7.encoder     // Catch:{ all -> 0x0096 }
            DataType r3 = r7.data     // Catch:{ all -> 0x0096 }
            com.bumptech.glide.load.Options r7 = r7.options     // Catch:{ all -> 0x0096 }
            boolean r7 = r2.encode(r3, r1, r7)     // Catch:{ all -> 0x0096 }
            if (r7 == 0) goto L_0x008e
            com.bumptech.glide.disklrucache.DiskLruCache r7 = com.bumptech.glide.disklrucache.DiskLruCache.this     // Catch:{ all -> 0x0096 }
            com.bumptech.glide.disklrucache.DiskLruCache.access$2100(r7, r6, r4)     // Catch:{ all -> 0x0096 }
            r6.committed = r4     // Catch:{ all -> 0x0096 }
        L_0x008e:
            boolean r7 = r6.committed     // Catch:{ IOException -> 0x00b6 }
            if (r7 != 0) goto L_0x0068
            r6.abort()     // Catch:{ IOException -> 0x0068 }
            goto L_0x0068
        L_0x0096:
            r7 = move-exception
            boolean r1 = r6.committed     // Catch:{ IOException -> 0x00b6 }
            if (r1 != 0) goto L_0x009e
            r6.abort()     // Catch:{ IOException -> 0x009e }
        L_0x009e:
            throw r7     // Catch:{ IOException -> 0x00b6 }
        L_0x009f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException     // Catch:{ IOException -> 0x00b6 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00b6 }
            r7.<init>()     // Catch:{ IOException -> 0x00b6 }
            java.lang.String r1 = "Had two simultaneous puts for: "
            r7.append(r1)     // Catch:{ IOException -> 0x00b6 }
            r7.append(r0)     // Catch:{ IOException -> 0x00b6 }
            java.lang.String r7 = r7.toString()     // Catch:{ IOException -> 0x00b6 }
            r6.<init>(r7)     // Catch:{ IOException -> 0x00b6 }
            throw r6     // Catch:{ IOException -> 0x00b6 }
        L_0x00b6:
            java.lang.String r6 = "DiskLruCacheWrapper"
            r7 = 5
            android.util.Log.isLoggable(r6, r7)     // Catch:{ all -> 0x00bd }
            goto L_0x0068
        L_0x00bd:
            r6 = move-exception
            com.bumptech.glide.load.engine.cache.DiskCacheWriteLocker r7 = r5.writeLocker
            r7.release(r0)
            throw r6
        L_0x00c4:
            r6 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00c4 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.cache.DiskLruCacheWrapper.put(com.bumptech.glide.load.Key, com.bumptech.glide.load.engine.cache.DiskCache$Writer):void");
    }

    public final synchronized void resetDiskCache() {
        this.diskLruCache = null;
    }
}
