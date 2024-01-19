package com.facebook.cache.disk;

import android.os.StatFs;
import co.hyperverge.hypersnapsdk.c.k;
import com.facebook.binaryresource.FileBinaryResource;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheErrorLogger.CacheErrorCategory;
import com.facebook.cache.common.CacheEventListener;
import com.facebook.cache.common.CacheEventListener.EvictionReason;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.MultiCacheKey;
import com.facebook.cache.common.NoOpCacheErrorLogger;
import com.facebook.cache.common.NoOpCacheEventListener;
import com.facebook.cache.common.WriterCallback;
import com.facebook.cache.disk.DefaultDiskStorage.InserterImpl;
import com.facebook.cache.disk.DiskStorage.Entry;
import com.facebook.cache.disk.DiskStorage.Inserter;
import com.facebook.common.disk.DiskTrimmableRegistry;
import com.facebook.common.logging.FLog;
import com.facebook.common.statfs.StatFsHelper;
import com.facebook.common.statfs.StatFsHelper.StorageType;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClock;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public class DiskStorageCache implements FileCache {
    public static final long FILECACHE_SIZE_UPDATE_PERIOD_MS = TimeUnit.MINUTES.toMillis(30);
    public static final long FUTURE_TIMESTAMP_THRESHOLD_MS = TimeUnit.HOURS.toMillis(2);
    public static final Class<?> TAG = DiskStorageCache.class;
    public final CacheErrorLogger mCacheErrorLogger;
    public final CacheEventListener mCacheEventListener;
    public long mCacheSizeLastUpdateTime;
    public long mCacheSizeLimit;
    public final CacheStats mCacheStats;
    public final Clock mClock;
    public final CountDownLatch mCountDownLatch;
    public final long mDefaultCacheSizeLimit;
    public final EntryEvictionComparatorSupplier mEntryEvictionComparatorSupplier;
    public final boolean mIndexPopulateAtStartupEnabled;
    public boolean mIndexReady;
    public final Object mLock = new Object();
    public final long mLowDiskSpaceCacheSizeLimit;
    public final Set<String> mResourceIndex;
    public final StatFsHelper mStatFsHelper;
    public final DiskStorage mStorage;

    public static class CacheStats {
        public long mCount = -1;
        public boolean mInitialized = false;
        public long mSize = -1;

        public synchronized long getSize() {
            return this.mSize;
        }

        public synchronized void increment(long j, long j2) {
            if (this.mInitialized) {
                this.mSize += j;
                this.mCount += j2;
            }
        }

        public synchronized void reset() {
            this.mInitialized = false;
            this.mCount = -1;
            this.mSize = -1;
        }
    }

    public static class Params {
        public final long mCacheSizeLimitMinimum;
        public final long mDefaultCacheSizeLimit;
        public final long mLowDiskSpaceCacheSizeLimit;

        public Params(long j, long j2, long j3) {
            this.mCacheSizeLimitMinimum = j;
            this.mLowDiskSpaceCacheSizeLimit = j2;
            this.mDefaultCacheSizeLimit = j3;
        }
    }

    public DiskStorageCache(DiskStorage diskStorage, EntryEvictionComparatorSupplier entryEvictionComparatorSupplier, Params params, CacheEventListener cacheEventListener, CacheErrorLogger cacheErrorLogger, DiskTrimmableRegistry diskTrimmableRegistry, Executor executor, boolean z) {
        this.mLowDiskSpaceCacheSizeLimit = params.mLowDiskSpaceCacheSizeLimit;
        long j = params.mDefaultCacheSizeLimit;
        this.mDefaultCacheSizeLimit = j;
        this.mCacheSizeLimit = j;
        this.mStatFsHelper = StatFsHelper.getInstance();
        this.mStorage = diskStorage;
        this.mEntryEvictionComparatorSupplier = entryEvictionComparatorSupplier;
        this.mCacheSizeLastUpdateTime = -1;
        this.mCacheEventListener = cacheEventListener;
        this.mCacheErrorLogger = cacheErrorLogger;
        this.mCacheStats = new CacheStats();
        this.mClock = SystemClock.INSTANCE;
        this.mIndexPopulateAtStartupEnabled = z;
        this.mResourceIndex = new HashSet();
        if (this.mIndexPopulateAtStartupEnabled) {
            this.mCountDownLatch = new CountDownLatch(1);
            executor.execute(new Runnable() {
                public void run() {
                    synchronized (DiskStorageCache.this.mLock) {
                        DiskStorageCache.this.maybeUpdateFileCacheSize();
                    }
                    DiskStorageCache diskStorageCache = DiskStorageCache.this;
                    diskStorageCache.mIndexReady = true;
                    diskStorageCache.mCountDownLatch.countDown();
                }
            });
            return;
        }
        this.mCountDownLatch = new CountDownLatch(0);
    }

    public void clearAll() {
        synchronized (this.mLock) {
            try {
                this.mStorage.clearAll();
                this.mResourceIndex.clear();
                if (((NoOpCacheEventListener) this.mCacheEventListener) != null) {
                    this.mCacheStats.reset();
                } else {
                    throw null;
                }
            } catch (IOException | NullPointerException e2) {
                CacheErrorLogger cacheErrorLogger = this.mCacheErrorLogger;
                CacheErrorCategory cacheErrorCategory = CacheErrorCategory.EVICTION;
                e2.getMessage();
                if (((NoOpCacheErrorLogger) cacheErrorLogger) == null) {
                    throw null;
                }
            }
        }
    }

    public final void evictAboveSize(long j, EvictionReason evictionReason) throws IOException {
        try {
            Collection<Entry> sortedEntries = getSortedEntries(this.mStorage.getEntries());
            long size = this.mCacheStats.getSize() - j;
            int i = 0;
            Iterator it = ((ArrayList) sortedEntries).iterator();
            long j2 = 0;
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                if (j2 > size) {
                    break;
                }
                long remove = this.mStorage.remove(entry);
                this.mResourceIndex.remove(entry.getId());
                if (remove > 0) {
                    i++;
                    j2 += remove;
                    SettableCacheEvent obtain = SettableCacheEvent.obtain();
                    entry.getId();
                    if (((NoOpCacheEventListener) this.mCacheEventListener) != null) {
                        obtain.recycle();
                    } else {
                        throw null;
                    }
                }
            }
            this.mCacheStats.increment(-j2, (long) (-i));
            this.mStorage.purgeUnexpectedResources();
        } catch (IOException e2) {
            CacheErrorLogger cacheErrorLogger = this.mCacheErrorLogger;
            CacheErrorCategory cacheErrorCategory = CacheErrorCategory.EVICTION;
            e2.getMessage();
            if (((NoOpCacheErrorLogger) cacheErrorLogger) != null) {
                throw e2;
            }
            throw null;
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x004c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.facebook.binaryresource.FileBinaryResource getResource(com.facebook.cache.common.CacheKey r9) {
        /*
            r8 = this;
            com.facebook.cache.disk.SettableCacheEvent r0 = com.facebook.cache.disk.SettableCacheEvent.obtain()
            r1 = 0
            java.lang.Object r2 = r8.mLock     // Catch:{ IOException -> 0x004c }
            monitor-enter(r2)     // Catch:{ IOException -> 0x004c }
            java.util.List r3 = co.hyperverge.hypersnapsdk.c.k.getResourceIds(r9)     // Catch:{ all -> 0x0047 }
            r4 = 0
            r5 = r1
            r6 = r5
        L_0x000f:
            int r7 = r3.size()     // Catch:{ all -> 0x0047 }
            if (r4 >= r7) goto L_0x0027
            java.lang.Object r5 = r3.get(r4)     // Catch:{ all -> 0x0047 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x0047 }
            com.facebook.cache.disk.DiskStorage r6 = r8.mStorage     // Catch:{ all -> 0x0047 }
            com.facebook.binaryresource.FileBinaryResource r6 = r6.getResource(r5, r9)     // Catch:{ all -> 0x0047 }
            if (r6 == 0) goto L_0x0024
            goto L_0x0027
        L_0x0024:
            int r4 = r4 + 1
            goto L_0x000f
        L_0x0027:
            if (r6 != 0) goto L_0x0036
            com.facebook.cache.common.CacheEventListener r9 = r8.mCacheEventListener     // Catch:{ all -> 0x0047 }
            com.facebook.cache.common.NoOpCacheEventListener r9 = (com.facebook.cache.common.NoOpCacheEventListener) r9     // Catch:{ all -> 0x0047 }
            if (r9 == 0) goto L_0x0035
            java.util.Set<java.lang.String> r9 = r8.mResourceIndex     // Catch:{ all -> 0x0047 }
            r9.remove(r5)     // Catch:{ all -> 0x0047 }
            goto L_0x0041
        L_0x0035:
            throw r1     // Catch:{ all -> 0x0047 }
        L_0x0036:
            com.facebook.cache.common.CacheEventListener r9 = r8.mCacheEventListener     // Catch:{ all -> 0x0047 }
            com.facebook.cache.common.NoOpCacheEventListener r9 = (com.facebook.cache.common.NoOpCacheEventListener) r9     // Catch:{ all -> 0x0047 }
            if (r9 == 0) goto L_0x0046
            java.util.Set<java.lang.String> r9 = r8.mResourceIndex     // Catch:{ all -> 0x0047 }
            r9.add(r5)     // Catch:{ all -> 0x0047 }
        L_0x0041:
            monitor-exit(r2)     // Catch:{ all -> 0x0047 }
            r0.recycle()
            return r6
        L_0x0046:
            throw r1     // Catch:{ all -> 0x0047 }
        L_0x0047:
            r9 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0047 }
            throw r9     // Catch:{ IOException -> 0x004c }
        L_0x004a:
            r9 = move-exception
            goto L_0x0060
        L_0x004c:
            com.facebook.cache.common.CacheErrorLogger r9 = r8.mCacheErrorLogger     // Catch:{ all -> 0x004a }
            com.facebook.cache.common.CacheErrorLogger$CacheErrorCategory r2 = com.facebook.cache.common.CacheErrorLogger.CacheErrorCategory.GENERIC_IO     // Catch:{ all -> 0x004a }
            com.facebook.cache.common.NoOpCacheErrorLogger r9 = (com.facebook.cache.common.NoOpCacheErrorLogger) r9     // Catch:{ all -> 0x004a }
            if (r9 == 0) goto L_0x005f
            com.facebook.cache.common.CacheEventListener r9 = r8.mCacheEventListener     // Catch:{ all -> 0x004a }
            com.facebook.cache.common.NoOpCacheEventListener r9 = (com.facebook.cache.common.NoOpCacheEventListener) r9     // Catch:{ all -> 0x004a }
            if (r9 == 0) goto L_0x005e
            r0.recycle()
            return r1
        L_0x005e:
            throw r1     // Catch:{ all -> 0x004a }
        L_0x005f:
            throw r1     // Catch:{ all -> 0x004a }
        L_0x0060:
            r0.recycle()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.cache.disk.DiskStorageCache.getResource(com.facebook.cache.common.CacheKey):com.facebook.binaryresource.FileBinaryResource");
    }

    public final Collection<Entry> getSortedEntries(Collection<Entry> collection) {
        if (((SystemClock) this.mClock) != null) {
            long currentTimeMillis = System.currentTimeMillis() + FUTURE_TIMESTAMP_THRESHOLD_MS;
            ArrayList arrayList = new ArrayList(collection.size());
            ArrayList arrayList2 = new ArrayList(collection.size());
            for (Entry next : collection) {
                if (next.getTimestamp() > currentTimeMillis) {
                    arrayList.add(next);
                } else {
                    arrayList2.add(next);
                }
            }
            Collections.sort(arrayList2, this.mEntryEvictionComparatorSupplier.get());
            arrayList.addAll(arrayList2);
            return arrayList;
        }
        throw null;
    }

    public boolean hasKey(CacheKey cacheKey) {
        synchronized (this.mLock) {
            if (hasKeySync(cacheKey)) {
                return true;
            }
            try {
                List<String> resourceIds = k.getResourceIds(cacheKey);
                for (int i = 0; i < resourceIds.size(); i++) {
                    String str = resourceIds.get(i);
                    if (this.mStorage.contains(str, cacheKey)) {
                        this.mResourceIndex.add(str);
                        return true;
                    }
                }
                return false;
            } catch (IOException unused) {
                return false;
            }
        }
    }

    public boolean hasKeySync(CacheKey cacheKey) {
        synchronized (this.mLock) {
            List<String> resourceIds = k.getResourceIds(cacheKey);
            for (int i = 0; i < resourceIds.size(); i++) {
                if (this.mResourceIndex.contains(resourceIds.get(i))) {
                    return true;
                }
            }
            return false;
        }
    }

    public FileBinaryResource insert(CacheKey cacheKey, WriterCallback writerCallback) throws IOException {
        String str;
        FileBinaryResource commit;
        SettableCacheEvent obtain = SettableCacheEvent.obtain();
        if (((NoOpCacheEventListener) this.mCacheEventListener) != null) {
            synchronized (this.mLock) {
                try {
                    if (cacheKey instanceof MultiCacheKey) {
                        str = k.secureHashKey(((MultiCacheKey) cacheKey).mCacheKeys.get(0));
                    } else {
                        str = k.secureHashKey(cacheKey);
                    }
                } catch (UnsupportedEncodingException e2) {
                    throw new RuntimeException(e2);
                }
            }
            try {
                InserterImpl inserterImpl = (InserterImpl) startInsert(str, cacheKey);
                try {
                    inserterImpl.writeData(writerCallback, cacheKey);
                    synchronized (this.mLock) {
                        commit = inserterImpl.commit(cacheKey);
                        this.mResourceIndex.add(str);
                        this.mCacheStats.increment(commit.size(), 1);
                    }
                    commit.size();
                    this.mCacheStats.getSize();
                    if (((NoOpCacheEventListener) this.mCacheEventListener) != null) {
                        if (!inserterImpl.cleanUp()) {
                            FLog.e(TAG, (String) "Failed to delete temp file");
                        }
                        obtain.recycle();
                        return commit;
                    }
                    throw null;
                } catch (Throwable th) {
                    if (!inserterImpl.cleanUp()) {
                        FLog.e(TAG, (String) "Failed to delete temp file");
                    }
                    throw th;
                }
            } catch (IOException e3) {
                try {
                    if (((NoOpCacheEventListener) this.mCacheEventListener) != null) {
                        FLog.e(TAG, (String) "Failed inserting a file into the cache", (Throwable) e3);
                        throw e3;
                    }
                    throw null;
                } catch (Throwable th2) {
                    obtain.recycle();
                    throw th2;
                }
            }
        } else {
            throw null;
        }
    }

    /* JADX INFO: finally extract failed */
    public final boolean maybeUpdateFileCacheSize() {
        boolean z;
        Set set;
        boolean z2;
        long j;
        long j2;
        if (((SystemClock) this.mClock) != null) {
            long currentTimeMillis = System.currentTimeMillis();
            CacheStats cacheStats = this.mCacheStats;
            synchronized (cacheStats) {
                try {
                    z = cacheStats.mInitialized;
                } catch (Throwable th) {
                    throw th;
                }
            }
            long j3 = -1;
            if (z) {
                long j4 = this.mCacheSizeLastUpdateTime;
                if (j4 != -1 && currentTimeMillis - j4 <= FILECACHE_SIZE_UPDATE_PERIOD_MS) {
                    return false;
                }
            }
            if (((SystemClock) this.mClock) != null) {
                long currentTimeMillis2 = System.currentTimeMillis();
                long j5 = FUTURE_TIMESTAMP_THRESHOLD_MS + currentTimeMillis2;
                if (!this.mIndexPopulateAtStartupEnabled || !this.mResourceIndex.isEmpty()) {
                    set = this.mIndexPopulateAtStartupEnabled ? new HashSet() : null;
                } else {
                    set = this.mResourceIndex;
                }
                try {
                    long j6 = 0;
                    boolean z3 = false;
                    int i = 0;
                    for (Entry next : this.mStorage.getEntries()) {
                        i++;
                        j6 += next.getSize();
                        if (next.getTimestamp() > j5) {
                            next.getSize();
                            j2 = j5;
                            j3 = Math.max(next.getTimestamp() - currentTimeMillis2, j3);
                            z3 = true;
                        } else {
                            j2 = j5;
                            if (this.mIndexPopulateAtStartupEnabled) {
                                set.add(next.getId());
                            }
                        }
                        j5 = j2;
                    }
                    if (z3) {
                        CacheErrorLogger cacheErrorLogger = this.mCacheErrorLogger;
                        CacheErrorCategory cacheErrorCategory = CacheErrorCategory.READ_INVALID_ENTRY;
                        if (((NoOpCacheErrorLogger) cacheErrorLogger) == null) {
                            throw null;
                        }
                    }
                    CacheStats cacheStats2 = this.mCacheStats;
                    synchronized (cacheStats2) {
                        j = cacheStats2.mCount;
                    }
                    long j7 = (long) i;
                    if (!(j == j7 && this.mCacheStats.getSize() == j6)) {
                        if (this.mIndexPopulateAtStartupEnabled && this.mResourceIndex != set) {
                            this.mResourceIndex.clear();
                            this.mResourceIndex.addAll(set);
                        }
                        CacheStats cacheStats3 = this.mCacheStats;
                        synchronized (cacheStats3) {
                            cacheStats3.mCount = j7;
                            cacheStats3.mSize = j6;
                            cacheStats3.mInitialized = true;
                        }
                    }
                    this.mCacheSizeLastUpdateTime = currentTimeMillis2;
                    z2 = true;
                } catch (IOException e2) {
                    CacheErrorLogger cacheErrorLogger2 = this.mCacheErrorLogger;
                    CacheErrorCategory cacheErrorCategory2 = CacheErrorCategory.GENERIC_IO;
                    e2.getMessage();
                    if (((NoOpCacheErrorLogger) cacheErrorLogger2) != null) {
                        z2 = false;
                    } else {
                        throw null;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
                return z2;
            }
            throw null;
        }
        throw null;
    }

    public void remove(CacheKey cacheKey) {
        synchronized (this.mLock) {
            try {
                List<String> resourceIds = k.getResourceIds(cacheKey);
                for (int i = 0; i < resourceIds.size(); i++) {
                    String str = resourceIds.get(i);
                    this.mStorage.remove(str);
                    this.mResourceIndex.remove(str);
                }
            } catch (IOException e2) {
                CacheErrorLogger cacheErrorLogger = this.mCacheErrorLogger;
                CacheErrorCategory cacheErrorCategory = CacheErrorCategory.DELETE_FILE;
                e2.getMessage();
                if (((NoOpCacheErrorLogger) cacheErrorLogger) == null) {
                    throw null;
                }
            }
        }
    }

    public final Inserter startInsert(String str, CacheKey cacheKey) throws IOException {
        synchronized (this.mLock) {
            boolean maybeUpdateFileCacheSize = maybeUpdateFileCacheSize();
            updateFileCacheSizeLimit();
            long size = this.mCacheStats.getSize();
            if (size > this.mCacheSizeLimit && !maybeUpdateFileCacheSize) {
                this.mCacheStats.reset();
                maybeUpdateFileCacheSize();
            }
            if (size > this.mCacheSizeLimit) {
                evictAboveSize((this.mCacheSizeLimit * 9) / 10, EvictionReason.CACHE_FULL);
            }
        }
        return this.mStorage.insert(str, cacheKey);
    }

    public final void updateFileCacheSizeLimit() {
        StorageType storageType = this.mStorage.isExternal() ? StorageType.EXTERNAL : StorageType.INTERNAL;
        StatFsHelper statFsHelper = this.mStatFsHelper;
        long size = this.mDefaultCacheSizeLimit - this.mCacheStats.getSize();
        statFsHelper.ensureInitialized();
        statFsHelper.ensureInitialized();
        if (statFsHelper.lock.tryLock()) {
            try {
                if (android.os.SystemClock.uptimeMillis() - statFsHelper.mLastRestatTime > StatFsHelper.RESTAT_INTERVAL_MS) {
                    statFsHelper.updateStats();
                }
            } finally {
                statFsHelper.lock.unlock();
            }
        }
        StatFs statFs = storageType == StorageType.INTERNAL ? statFsHelper.mInternalStatFs : statFsHelper.mExternalStatFs;
        long availableBlocksLong = statFs != null ? statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong() : 0;
        boolean z = true;
        if (availableBlocksLong > 0 && availableBlocksLong >= size) {
            z = false;
        }
        if (z) {
            this.mCacheSizeLimit = this.mLowDiskSpaceCacheSizeLimit;
        } else {
            this.mCacheSizeLimit = this.mDefaultCacheSizeLimit;
        }
    }
}
