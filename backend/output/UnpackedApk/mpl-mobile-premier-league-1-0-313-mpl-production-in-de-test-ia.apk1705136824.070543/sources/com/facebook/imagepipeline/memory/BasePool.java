package com.facebook.imagepipeline.memory;

import android.annotation.SuppressLint;
import android.util.SparseArray;
import android.util.SparseIntArray;
import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.memory.Pool;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class BasePool<V> implements Pool<V> {
    public final Class<?> TAG;
    public boolean mAllowNewBuckets;
    public final SparseArray<Bucket<V>> mBuckets;
    public final Counter mFree;
    public boolean mIgnoreHardCap;
    public final Set<V> mInUseValues;
    public final MemoryTrimmableRegistry mMemoryTrimmableRegistry;
    public final PoolParams mPoolParams;
    public final PoolStatsTracker mPoolStatsTracker;
    public final Counter mUsed;

    public static class Counter {
        public static final String TAG = "com.facebook.imagepipeline.memory.BasePool.Counter";
        public int mCount;
        public int mNumBytes;

        public void decrement(int i) {
            int i2 = this.mNumBytes;
            if (i2 >= i) {
                int i3 = this.mCount;
                if (i3 > 0) {
                    this.mCount = i3 - 1;
                    this.mNumBytes = i2 - i;
                    return;
                }
            }
            FLog.wtf(TAG, "Unexpected decrement of %d. Current numBytes = %d, count = %d", Integer.valueOf(i), Integer.valueOf(this.mNumBytes), Integer.valueOf(this.mCount));
        }

        public void increment(int i) {
            this.mCount++;
            this.mNumBytes += i;
        }

        public void reset() {
            this.mCount = 0;
            this.mNumBytes = 0;
        }
    }

    public static class InvalidSizeException extends RuntimeException {
        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        public InvalidSizeException(Object obj) {
            // StringBuilder outline73 = GeneratedOutlineSupport.outline73("Invalid size: ");
            // outline73.append(obj.toString());
            super(outline73.toString());
        }
    }

    public static class InvalidValueException extends RuntimeException {
        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        public InvalidValueException(Object obj) {
            // StringBuilder outline73 = GeneratedOutlineSupport.outline73("Invalid value: ");
            // outline73.append(obj.toString());
            super(outline73.toString());
        }
    }

    public static class PoolSizeViolationException extends RuntimeException {
        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        public PoolSizeViolationException(int i, int i2, int i3, int i4) {
            // StringBuilder outline75 = GeneratedOutlineSupport.outline75("Pool hard cap violation? Hard cap = ", i, " Used size = ", i2, " Free size = ");
            // outline75.append(i3);
            // outline75.append(" Request size = ");
            // outline75.append(i4);
            super(outline75.toString());
        }
    }

    public static class SizeTooLargeException extends InvalidSizeException {
        public SizeTooLargeException(Object obj) {
            super(obj);
        }
    }

    public BasePool(MemoryTrimmableRegistry memoryTrimmableRegistry, PoolParams poolParams, PoolStatsTracker poolStatsTracker) {
        this.TAG = getClass();
        if (memoryTrimmableRegistry != null) {
            this.mMemoryTrimmableRegistry = memoryTrimmableRegistry;
            if (poolParams != null) {
                this.mPoolParams = poolParams;
                if (poolStatsTracker != null) {
                    this.mPoolStatsTracker = poolStatsTracker;
                    this.mBuckets = new SparseArray<>();
                    if (this.mPoolParams.fixBucketsReinitialization) {
                        initBuckets();
                    } else {
                        legacyInitBuckets(new SparseIntArray(0));
                    }
                    this.mInUseValues = Collections.newSetFromMap(new IdentityHashMap());
                    this.mFree = new Counter();
                    this.mUsed = new Counter();
                    return;
                }
                throw null;
            }
            throw null;
        }
        throw null;
    }

    private synchronized void ensurePoolSizeInvariant() {
        boolean z;
        if (isMaxSizeSoftCapExceeded()) {
            if (this.mFree.mNumBytes != 0) {
                z = false;
                k.checkState(z);
            }
        }
        z = true;
        k.checkState(z);
    }

    private void fillBuckets(SparseIntArray sparseIntArray) {
        this.mBuckets.clear();
        for (int i = 0; i < sparseIntArray.size(); i++) {
            int keyAt = sparseIntArray.keyAt(i);
            this.mBuckets.put(keyAt, new Bucket(getSizeInBytes(keyAt), sparseIntArray.valueAt(i), 0, this.mPoolParams.fixBucketsReinitialization));
        }
    }

    private synchronized Bucket<V> getBucketIfPresent(int i) {
        return this.mBuckets.get(i);
    }

    private synchronized void initBuckets() {
        SparseIntArray sparseIntArray = this.mPoolParams.bucketSizes;
        if (sparseIntArray != null) {
            fillBuckets(sparseIntArray);
            this.mAllowNewBuckets = false;
        } else {
            this.mAllowNewBuckets = true;
        }
    }

    private synchronized void legacyInitBuckets(SparseIntArray sparseIntArray) {
        if (sparseIntArray != null) {
            this.mBuckets.clear();
            SparseIntArray sparseIntArray2 = this.mPoolParams.bucketSizes;
            if (sparseIntArray2 != null) {
                for (int i = 0; i < sparseIntArray2.size(); i++) {
                    int keyAt = sparseIntArray2.keyAt(i);
                    this.mBuckets.put(keyAt, new Bucket(getSizeInBytes(keyAt), sparseIntArray2.valueAt(i), sparseIntArray.get(keyAt, 0), this.mPoolParams.fixBucketsReinitialization));
                }
                this.mAllowNewBuckets = false;
            } else {
                this.mAllowNewBuckets = true;
            }
        } else {
            throw null;
        }
    }

    @SuppressLint({"InvalidAccessToGuardedField"})
    private void logStats() {
        if (FLog.isLoggable(2)) {
            FLog.v(this.TAG, (String) "Used = (%d, %d); Free = (%d, %d)", (Object) Integer.valueOf(this.mUsed.mCount), (Object) Integer.valueOf(this.mUsed.mNumBytes), (Object) Integer.valueOf(this.mFree.mCount), (Object) Integer.valueOf(this.mFree.mNumBytes));
        }
    }

    private List<Bucket<V>> refillBuckets() {
        ArrayList arrayList = new ArrayList(this.mBuckets.size());
        int size = this.mBuckets.size();
        for (int i = 0; i < size; i++) {
            Bucket valueAt = this.mBuckets.valueAt(i);
            int i2 = valueAt.mItemSize;
            int i3 = valueAt.mMaxLength;
            int inUseCount = valueAt.getInUseCount();
            if (valueAt.getFreeListSize() > 0) {
                arrayList.add(valueAt);
            }
            this.mBuckets.setValueAt(i, new Bucket(getSizeInBytes(i2), i3, inUseCount, this.mPoolParams.fixBucketsReinitialization));
        }
        return arrayList;
    }

    public abstract V alloc(int i);

    public synchronized boolean canAllocate(int i) {
        if (this.mIgnoreHardCap) {
            return true;
        }
        int i2 = this.mPoolParams.maxSizeHardCap;
        if (i > i2 - this.mUsed.mNumBytes) {
            this.mPoolStatsTracker.onHardCapReached();
            return false;
        }
        int i3 = this.mPoolParams.maxSizeSoftCap;
        if (i > i3 - (this.mUsed.mNumBytes + this.mFree.mNumBytes)) {
            trimToSize(i3 - i);
        }
        if (i <= i2 - (this.mUsed.mNumBytes + this.mFree.mNumBytes)) {
            return true;
        }
        this.mPoolStatsTracker.onHardCapReached();
        return false;
    }

    public abstract void free(V v);

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0052, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0068, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r0 = alloc(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006e, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006f, code lost:
        monitor-enter(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        r5.mUsed.decrement(r2);
        r4 = getBucket(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0079, code lost:
        if (r4 != null) goto L_0x007b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007b, code lost:
        r4.decrementInUseCount();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x007f, code lost:
        co.hyperverge.hypersnapsdk.c.k.propagateIfPossible(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0082, code lost:
        monitor-enter(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        co.hyperverge.hypersnapsdk.c.k.checkState(r5.mInUseValues.add(r0));
        trimToSoftCap();
        r5.mPoolStatsTracker.onAlloc(r2);
        logStats();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x009b, code lost:
        if (com.facebook.common.logging.FLog.isLoggable(2) == false) goto L_0x00b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x009d, code lost:
        com.facebook.common.logging.FLog.v(r5.TAG, (java.lang.String) "get (alloc) (object, size) = (%x, %s)", (java.lang.Object) java.lang.Integer.valueOf(java.lang.System.identityHashCode(r0)), (java.lang.Object) java.lang.Integer.valueOf(r6));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b1, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public V get(int r6) {
        /*
            r5 = this;
            r5.ensurePoolSizeInvariant()
            int r6 = r5.getBucketedSize(r6)
            monitor-enter(r5)
            com.facebook.imagepipeline.memory.Bucket r0 = r5.getBucket(r6)     // Catch:{ all -> 0x00ca }
            r1 = 2
            if (r0 == 0) goto L_0x0053
            java.lang.Object r2 = r5.getValue(r0)     // Catch:{ all -> 0x00ca }
            if (r2 == 0) goto L_0x0053
            java.util.Set<V> r6 = r5.mInUseValues     // Catch:{ all -> 0x00ca }
            boolean r6 = r6.add(r2)     // Catch:{ all -> 0x00ca }
            co.hyperverge.hypersnapsdk.c.k.checkState(r6)     // Catch:{ all -> 0x00ca }
            int r6 = r5.getBucketedSizeForValue(r2)     // Catch:{ all -> 0x00ca }
            int r0 = r5.getSizeInBytes(r6)     // Catch:{ all -> 0x00ca }
            com.facebook.imagepipeline.memory.BasePool$Counter r3 = r5.mUsed     // Catch:{ all -> 0x00ca }
            r3.increment(r0)     // Catch:{ all -> 0x00ca }
            com.facebook.imagepipeline.memory.BasePool$Counter r3 = r5.mFree     // Catch:{ all -> 0x00ca }
            r3.decrement(r0)     // Catch:{ all -> 0x00ca }
            com.facebook.imagepipeline.memory.PoolStatsTracker r3 = r5.mPoolStatsTracker     // Catch:{ all -> 0x00ca }
            r3.onValueReuse(r0)     // Catch:{ all -> 0x00ca }
            r5.logStats()     // Catch:{ all -> 0x00ca }
            boolean r0 = com.facebook.common.logging.FLog.isLoggable(r1)     // Catch:{ all -> 0x00ca }
            if (r0 == 0) goto L_0x0051
            java.lang.Class<?> r0 = r5.TAG     // Catch:{ all -> 0x00ca }
            java.lang.String r1 = "get (reuse) (object, size) = (%x, %s)"
            int r3 = java.lang.System.identityHashCode(r2)     // Catch:{ all -> 0x00ca }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x00ca }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x00ca }
            com.facebook.common.logging.FLog.v(r0, r1, r3, r6)     // Catch:{ all -> 0x00ca }
        L_0x0051:
            monitor-exit(r5)     // Catch:{ all -> 0x00ca }
            return r2
        L_0x0053:
            int r2 = r5.getSizeInBytes(r6)     // Catch:{ all -> 0x00ca }
            boolean r3 = r5.canAllocate(r2)     // Catch:{ all -> 0x00ca }
            if (r3 == 0) goto L_0x00b8
            com.facebook.imagepipeline.memory.BasePool$Counter r3 = r5.mUsed     // Catch:{ all -> 0x00ca }
            r3.increment(r2)     // Catch:{ all -> 0x00ca }
            if (r0 == 0) goto L_0x0067
            r0.incrementInUseCount()     // Catch:{ all -> 0x00ca }
        L_0x0067:
            monitor-exit(r5)     // Catch:{ all -> 0x00ca }
            r0 = 0
            java.lang.Object r0 = r5.alloc(r6)     // Catch:{ all -> 0x006e }
            goto L_0x0082
        L_0x006e:
            r3 = move-exception
            monitor-enter(r5)
            com.facebook.imagepipeline.memory.BasePool$Counter r4 = r5.mUsed     // Catch:{ all -> 0x00b5 }
            r4.decrement(r2)     // Catch:{ all -> 0x00b5 }
            com.facebook.imagepipeline.memory.Bucket r4 = r5.getBucket(r6)     // Catch:{ all -> 0x00b5 }
            if (r4 == 0) goto L_0x007e
            r4.decrementInUseCount()     // Catch:{ all -> 0x00b5 }
        L_0x007e:
            monitor-exit(r5)     // Catch:{ all -> 0x00b5 }
            co.hyperverge.hypersnapsdk.c.k.propagateIfPossible(r3)
        L_0x0082:
            monitor-enter(r5)
            java.util.Set<V> r3 = r5.mInUseValues     // Catch:{ all -> 0x00b2 }
            boolean r3 = r3.add(r0)     // Catch:{ all -> 0x00b2 }
            co.hyperverge.hypersnapsdk.c.k.checkState(r3)     // Catch:{ all -> 0x00b2 }
            r5.trimToSoftCap()     // Catch:{ all -> 0x00b2 }
            com.facebook.imagepipeline.memory.PoolStatsTracker r3 = r5.mPoolStatsTracker     // Catch:{ all -> 0x00b2 }
            r3.onAlloc(r2)     // Catch:{ all -> 0x00b2 }
            r5.logStats()     // Catch:{ all -> 0x00b2 }
            boolean r1 = com.facebook.common.logging.FLog.isLoggable(r1)     // Catch:{ all -> 0x00b2 }
            if (r1 == 0) goto L_0x00b0
            java.lang.Class<?> r1 = r5.TAG     // Catch:{ all -> 0x00b2 }
            java.lang.String r2 = "get (alloc) (object, size) = (%x, %s)"
            int r3 = java.lang.System.identityHashCode(r0)     // Catch:{ all -> 0x00b2 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x00b2 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x00b2 }
            com.facebook.common.logging.FLog.v(r1, r2, r3, r6)     // Catch:{ all -> 0x00b2 }
        L_0x00b0:
            monitor-exit(r5)     // Catch:{ all -> 0x00b2 }
            return r0
        L_0x00b2:
            r6 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x00b2 }
            throw r6
        L_0x00b5:
            r6 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x00b5 }
            throw r6
        L_0x00b8:
            com.facebook.imagepipeline.memory.BasePool$PoolSizeViolationException r6 = new com.facebook.imagepipeline.memory.BasePool$PoolSizeViolationException     // Catch:{ all -> 0x00ca }
            com.facebook.imagepipeline.memory.PoolParams r0 = r5.mPoolParams     // Catch:{ all -> 0x00ca }
            int r0 = r0.maxSizeHardCap     // Catch:{ all -> 0x00ca }
            com.facebook.imagepipeline.memory.BasePool$Counter r1 = r5.mUsed     // Catch:{ all -> 0x00ca }
            int r1 = r1.mNumBytes     // Catch:{ all -> 0x00ca }
            com.facebook.imagepipeline.memory.BasePool$Counter r3 = r5.mFree     // Catch:{ all -> 0x00ca }
            int r3 = r3.mNumBytes     // Catch:{ all -> 0x00ca }
            r6.<init>(r0, r1, r3, r2)     // Catch:{ all -> 0x00ca }
            throw r6     // Catch:{ all -> 0x00ca }
        L_0x00ca:
            r6 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x00ca }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.memory.BasePool.get(int):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.facebook.imagepipeline.memory.Bucket<V> getBucket(int r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            android.util.SparseArray<com.facebook.imagepipeline.memory.Bucket<V>> r0 = r3.mBuckets     // Catch:{ all -> 0x002f }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x002f }
            com.facebook.imagepipeline.memory.Bucket r0 = (com.facebook.imagepipeline.memory.Bucket) r0     // Catch:{ all -> 0x002f }
            if (r0 != 0) goto L_0x002d
            boolean r1 = r3.mAllowNewBuckets     // Catch:{ all -> 0x002f }
            if (r1 != 0) goto L_0x0010
            goto L_0x002d
        L_0x0010:
            r0 = 2
            boolean r0 = com.facebook.common.logging.FLog.isLoggable(r0)     // Catch:{ all -> 0x002f }
            if (r0 == 0) goto L_0x0022
            java.lang.Class<?> r0 = r3.TAG     // Catch:{ all -> 0x002f }
            java.lang.String r1 = "creating new bucket %s"
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x002f }
            com.facebook.common.logging.FLog.v(r0, r1, r2)     // Catch:{ all -> 0x002f }
        L_0x0022:
            com.facebook.imagepipeline.memory.Bucket r0 = r3.newBucket(r4)     // Catch:{ all -> 0x002f }
            android.util.SparseArray<com.facebook.imagepipeline.memory.Bucket<V>> r1 = r3.mBuckets     // Catch:{ all -> 0x002f }
            r1.put(r4, r0)     // Catch:{ all -> 0x002f }
            monitor-exit(r3)
            return r0
        L_0x002d:
            monitor-exit(r3)
            return r0
        L_0x002f:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.memory.BasePool.getBucket(int):com.facebook.imagepipeline.memory.Bucket");
    }

    public abstract int getBucketedSize(int i);

    public abstract int getBucketedSizeForValue(V v);

    public abstract int getSizeInBytes(int i);

    public synchronized Map<String, Integer> getStats() {
        HashMap hashMap;
        try {
            hashMap = new HashMap();
            for (int i = 0; i < this.mBuckets.size(); i++) {
                int keyAt = this.mBuckets.keyAt(i);
                hashMap.put(PoolStatsTracker.BUCKETS_USED_PREFIX + getSizeInBytes(keyAt), Integer.valueOf(this.mBuckets.valueAt(i).getInUseCount()));
            }
            hashMap.put(PoolStatsTracker.SOFT_CAP, Integer.valueOf(this.mPoolParams.maxSizeSoftCap));
            hashMap.put(PoolStatsTracker.HARD_CAP, Integer.valueOf(this.mPoolParams.maxSizeHardCap));
            hashMap.put(PoolStatsTracker.USED_COUNT, Integer.valueOf(this.mUsed.mCount));
            hashMap.put(PoolStatsTracker.USED_BYTES, Integer.valueOf(this.mUsed.mNumBytes));
            hashMap.put(PoolStatsTracker.FREE_COUNT, Integer.valueOf(this.mFree.mCount));
            hashMap.put(PoolStatsTracker.FREE_BYTES, Integer.valueOf(this.mFree.mNumBytes));
        }
        return hashMap;
    }

    public synchronized V getValue(Bucket<V> bucket) {
        return bucket.get();
    }

    public void initialize() {
        this.mMemoryTrimmableRegistry.registerMemoryTrimmable(this);
        this.mPoolStatsTracker.setBasePool(this);
    }

    public synchronized boolean isMaxSizeSoftCapExceeded() {
        boolean z;
        z = this.mUsed.mNumBytes + this.mFree.mNumBytes > this.mPoolParams.maxSizeSoftCap;
        if (z) {
            this.mPoolStatsTracker.onSoftCapReached();
        }
        return z;
    }

    public boolean isReusable(V v) {
        if (v != null) {
            return true;
        }
        throw null;
    }

    public Bucket<V> newBucket(int i) {
        return new Bucket<>(getSizeInBytes(i), Integer.MAX_VALUE, 0, this.mPoolParams.fixBucketsReinitialization);
    }

    public void onParamsChanged() {
    }

    public void release(V v) {
        if (v != null) {
            int bucketedSizeForValue = getBucketedSizeForValue(v);
            int sizeInBytes = getSizeInBytes(bucketedSizeForValue);
            synchronized (this) {
                Bucket bucketIfPresent = getBucketIfPresent(bucketedSizeForValue);
                if (!this.mInUseValues.remove(v)) {
                    FLog.e(this.TAG, (String) "release (free, value unrecognized) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bucketedSizeForValue));
                    free(v);
                    this.mPoolStatsTracker.onFree(sizeInBytes);
                } else {
                    if (bucketIfPresent != null && !bucketIfPresent.isMaxLengthExceeded() && !isMaxSizeSoftCapExceeded()) {
                        if (isReusable(v)) {
                            bucketIfPresent.release(v);
                            this.mFree.increment(sizeInBytes);
                            this.mUsed.decrement(sizeInBytes);
                            this.mPoolStatsTracker.onValueRelease(sizeInBytes);
                            if (FLog.isLoggable(2)) {
                                FLog.v(this.TAG, (String) "release (reuse) (object, size) = (%x, %s)", (Object) Integer.valueOf(System.identityHashCode(v)), (Object) Integer.valueOf(bucketedSizeForValue));
                            }
                        }
                    }
                    if (bucketIfPresent != null) {
                        bucketIfPresent.decrementInUseCount();
                    }
                    if (FLog.isLoggable(2)) {
                        FLog.v(this.TAG, (String) "release (free) (object, size) = (%x, %s)", (Object) Integer.valueOf(System.identityHashCode(v)), (Object) Integer.valueOf(bucketedSizeForValue));
                    }
                    free(v);
                    this.mUsed.decrement(sizeInBytes);
                    this.mPoolStatsTracker.onFree(sizeInBytes);
                }
                logStats();
            }
            return;
        }
        throw null;
    }

    public void trim(MemoryTrimType memoryTrimType) {
        trimToNothing();
    }

    public void trimToNothing() {
        int i;
        List list;
        synchronized (this) {
            if (this.mPoolParams.fixBucketsReinitialization) {
                list = refillBuckets();
            } else {
                ArrayList arrayList = new ArrayList(this.mBuckets.size());
                SparseIntArray sparseIntArray = new SparseIntArray();
                for (int i2 = 0; i2 < this.mBuckets.size(); i2++) {
                    Bucket valueAt = this.mBuckets.valueAt(i2);
                    if (valueAt.getFreeListSize() > 0) {
                        arrayList.add(valueAt);
                    }
                    sparseIntArray.put(this.mBuckets.keyAt(i2), valueAt.getInUseCount());
                }
                legacyInitBuckets(sparseIntArray);
                list = arrayList;
            }
            this.mFree.reset();
            logStats();
        }
        onParamsChanged();
        for (i = 0; i < list.size(); i++) {
            Bucket bucket = (Bucket) list.get(i);
            while (true) {
                Object pop = bucket.pop();
                if (pop == null) {
                    break;
                }
                free(pop);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x008d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void trimToSize(int r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            com.facebook.imagepipeline.memory.BasePool$Counter r0 = r7.mUsed     // Catch:{ all -> 0x008e }
            int r0 = r0.mNumBytes     // Catch:{ all -> 0x008e }
            com.facebook.imagepipeline.memory.BasePool$Counter r1 = r7.mFree     // Catch:{ all -> 0x008e }
            int r1 = r1.mNumBytes     // Catch:{ all -> 0x008e }
            int r0 = r0 + r1
            int r0 = r0 - r8
            com.facebook.imagepipeline.memory.BasePool$Counter r1 = r7.mFree     // Catch:{ all -> 0x008e }
            int r1 = r1.mNumBytes     // Catch:{ all -> 0x008e }
            int r0 = java.lang.Math.min(r0, r1)     // Catch:{ all -> 0x008e }
            if (r0 > 0) goto L_0x0017
            monitor-exit(r7)
            return
        L_0x0017:
            r1 = 2
            boolean r2 = com.facebook.common.logging.FLog.isLoggable(r1)     // Catch:{ all -> 0x008e }
            if (r2 == 0) goto L_0x003a
            java.lang.Class<?> r2 = r7.TAG     // Catch:{ all -> 0x008e }
            java.lang.String r3 = "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d"
            java.lang.Integer r4 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x008e }
            com.facebook.imagepipeline.memory.BasePool$Counter r5 = r7.mUsed     // Catch:{ all -> 0x008e }
            int r5 = r5.mNumBytes     // Catch:{ all -> 0x008e }
            com.facebook.imagepipeline.memory.BasePool$Counter r6 = r7.mFree     // Catch:{ all -> 0x008e }
            int r6 = r6.mNumBytes     // Catch:{ all -> 0x008e }
            int r5 = r5 + r6
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x008e }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x008e }
            com.facebook.common.logging.FLog.v(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x008e }
        L_0x003a:
            r7.logStats()     // Catch:{ all -> 0x008e }
            r2 = 0
        L_0x003e:
            android.util.SparseArray<com.facebook.imagepipeline.memory.Bucket<V>> r3 = r7.mBuckets     // Catch:{ all -> 0x008e }
            int r3 = r3.size()     // Catch:{ all -> 0x008e }
            if (r2 >= r3) goto L_0x006b
            if (r0 > 0) goto L_0x0049
            goto L_0x006b
        L_0x0049:
            android.util.SparseArray<com.facebook.imagepipeline.memory.Bucket<V>> r3 = r7.mBuckets     // Catch:{ all -> 0x008e }
            java.lang.Object r3 = r3.valueAt(r2)     // Catch:{ all -> 0x008e }
            com.facebook.imagepipeline.memory.Bucket r3 = (com.facebook.imagepipeline.memory.Bucket) r3     // Catch:{ all -> 0x008e }
        L_0x0051:
            if (r0 <= 0) goto L_0x0068
            java.lang.Object r4 = r3.pop()     // Catch:{ all -> 0x008e }
            if (r4 != 0) goto L_0x005a
            goto L_0x0068
        L_0x005a:
            r7.free(r4)     // Catch:{ all -> 0x008e }
            int r4 = r3.mItemSize     // Catch:{ all -> 0x008e }
            int r0 = r0 - r4
            com.facebook.imagepipeline.memory.BasePool$Counter r4 = r7.mFree     // Catch:{ all -> 0x008e }
            int r5 = r3.mItemSize     // Catch:{ all -> 0x008e }
            r4.decrement(r5)     // Catch:{ all -> 0x008e }
            goto L_0x0051
        L_0x0068:
            int r2 = r2 + 1
            goto L_0x003e
        L_0x006b:
            r7.logStats()     // Catch:{ all -> 0x008e }
            boolean r0 = com.facebook.common.logging.FLog.isLoggable(r1)     // Catch:{ all -> 0x008e }
            if (r0 == 0) goto L_0x008c
            java.lang.Class<?> r0 = r7.TAG     // Catch:{ all -> 0x008e }
            java.lang.String r1 = "trimToSize: TargetSize = %d; Final Size = %d"
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x008e }
            com.facebook.imagepipeline.memory.BasePool$Counter r2 = r7.mUsed     // Catch:{ all -> 0x008e }
            int r2 = r2.mNumBytes     // Catch:{ all -> 0x008e }
            com.facebook.imagepipeline.memory.BasePool$Counter r3 = r7.mFree     // Catch:{ all -> 0x008e }
            int r3 = r3.mNumBytes     // Catch:{ all -> 0x008e }
            int r2 = r2 + r3
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x008e }
            com.facebook.common.logging.FLog.v(r0, r1, r8, r2)     // Catch:{ all -> 0x008e }
        L_0x008c:
            monitor-exit(r7)
            return
        L_0x008e:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.memory.BasePool.trimToSize(int):void");
    }

    public synchronized void trimToSoftCap() {
        if (isMaxSizeSoftCapExceeded()) {
            trimToSize(this.mPoolParams.maxSizeSoftCap);
        }
    }

    public BasePool(MemoryTrimmableRegistry memoryTrimmableRegistry, PoolParams poolParams, PoolStatsTracker poolStatsTracker, boolean z) {
        this(memoryTrimmableRegistry, poolParams, poolStatsTracker);
        this.mIgnoreHardCap = z;
    }
}