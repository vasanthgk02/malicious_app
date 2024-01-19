package com.facebook.imagepipeline.memory;

import co.hyperverge.hypersnapsdk.c.k;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.memory.MemoryTrimmable;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.OOMSoftReference;
import com.facebook.common.references.ResourceReleaser;
import java.lang.ref.SoftReference;
import java.util.concurrent.Semaphore;

public class SharedByteArray implements MemoryTrimmable {
    public final OOMSoftReference<byte[]> mByteArraySoftRef;
    public final int mMaxByteArraySize;
    public final int mMinByteArraySize;
    public final ResourceReleaser<byte[]> mResourceReleaser;
    public final Semaphore mSemaphore;

    public SharedByteArray(MemoryTrimmableRegistry memoryTrimmableRegistry, PoolParams poolParams) {
        if (memoryTrimmableRegistry != null) {
            boolean z = false;
            k.checkArgument(poolParams.minBucketSize > 0);
            k.checkArgument(poolParams.maxBucketSize >= poolParams.minBucketSize ? true : z);
            this.mMaxByteArraySize = poolParams.maxBucketSize;
            this.mMinByteArraySize = poolParams.minBucketSize;
            this.mByteArraySoftRef = new OOMSoftReference<>();
            this.mSemaphore = new Semaphore(1);
            this.mResourceReleaser = new ResourceReleaser<byte[]>() {
                public void release(byte[] bArr) {
                    SharedByteArray.this.mSemaphore.release();
                }
            };
            memoryTrimmableRegistry.registerMemoryTrimmable(this);
            return;
        }
        throw null;
    }

    private synchronized byte[] allocateByteArray(int i) {
        byte[] bArr;
        this.mByteArraySoftRef.clear();
        bArr = new byte[i];
        OOMSoftReference<byte[]> oOMSoftReference = this.mByteArraySoftRef;
        if (oOMSoftReference != null) {
            oOMSoftReference.softRef1 = new SoftReference<>(bArr);
            oOMSoftReference.softRef2 = new SoftReference<>(bArr);
            oOMSoftReference.softRef3 = new SoftReference<>(bArr);
        } else {
            throw null;
        }
        return bArr;
    }

    private byte[] getByteArray(int i) {
        int bucketedSize = getBucketedSize(i);
        SoftReference<T> softReference = this.mByteArraySoftRef.softRef1;
        byte[] bArr = (byte[]) (softReference == null ? null : softReference.get());
        return (bArr == null || bArr.length < bucketedSize) ? allocateByteArray(bucketedSize) : bArr;
    }

    public CloseableReference<byte[]> get(int i) {
        boolean z = true;
        k.checkArgument(i > 0, (Object) "Size must be greater than zero");
        if (i > this.mMaxByteArraySize) {
            z = false;
        }
        k.checkArgument(z, (Object) "Requested size is too big");
        this.mSemaphore.acquireUninterruptibly();
        try {
            return CloseableReference.of(getByteArray(i), this.mResourceReleaser);
        } catch (Throwable th) {
            this.mSemaphore.release();
            k.propagateIfPossible(th);
            throw new RuntimeException(th);
        }
    }

    public int getBucketedSize(int i) {
        return Integer.highestOneBit(Math.max(i, this.mMinByteArraySize) - 1) * 2;
    }

    public void trim(MemoryTrimType memoryTrimType) {
        if (this.mSemaphore.tryAcquire()) {
            try {
                this.mByteArraySoftRef.clear();
            } finally {
                this.mSemaphore.release();
            }
        }
    }
}
