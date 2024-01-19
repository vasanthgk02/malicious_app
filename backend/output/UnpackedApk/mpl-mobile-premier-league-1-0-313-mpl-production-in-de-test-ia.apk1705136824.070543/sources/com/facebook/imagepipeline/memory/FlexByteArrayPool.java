package com.facebook.imagepipeline.memory;

import co.hyperverge.hypersnapsdk.c.k;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import java.util.Map;

public class FlexByteArrayPool {
    public final SoftRefByteArrayPool mDelegatePool;
    public final ResourceReleaser<byte[]> mResourceReleaser;

    public static class SoftRefByteArrayPool extends GenericByteArrayPool {
        public SoftRefByteArrayPool(MemoryTrimmableRegistry memoryTrimmableRegistry, PoolParams poolParams, PoolStatsTracker poolStatsTracker) {
            super(memoryTrimmableRegistry, poolParams, poolStatsTracker);
        }

        public Bucket<byte[]> newBucket(int i) {
            return new OOMSoftReferenceBucket(getSizeInBytes(i), this.mPoolParams.maxNumThreads, 0);
        }
    }

    public FlexByteArrayPool(MemoryTrimmableRegistry memoryTrimmableRegistry, PoolParams poolParams) {
        k.checkArgument(poolParams.maxNumThreads > 0);
        this.mDelegatePool = new SoftRefByteArrayPool(memoryTrimmableRegistry, poolParams, NoOpPoolStatsTracker.getInstance());
        this.mResourceReleaser = new ResourceReleaser<byte[]>() {
            public void release(byte[] bArr) {
                FlexByteArrayPool.this.release(bArr);
            }
        };
    }

    public CloseableReference<byte[]> get(int i) {
        return CloseableReference.of(this.mDelegatePool.get(i), this.mResourceReleaser);
    }

    public int getMinBufferSize() {
        return this.mDelegatePool.getMinBufferSize();
    }

    public Map<String, Integer> getStats() {
        return this.mDelegatePool.getStats();
    }

    public void release(byte[] bArr) {
        this.mDelegatePool.release(bArr);
    }
}
