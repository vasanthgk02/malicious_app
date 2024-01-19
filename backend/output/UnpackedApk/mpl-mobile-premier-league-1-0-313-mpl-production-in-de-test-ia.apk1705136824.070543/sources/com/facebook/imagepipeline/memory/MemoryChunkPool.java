package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.imagepipeline.memory.BasePool.InvalidSizeException;

public abstract class MemoryChunkPool extends BasePool<MemoryChunk> {
    public final int[] mBucketSizes;

    public MemoryChunkPool(MemoryTrimmableRegistry memoryTrimmableRegistry, PoolParams poolParams, PoolStatsTracker poolStatsTracker) {
        super(memoryTrimmableRegistry, poolParams, poolStatsTracker);
        SparseIntArray sparseIntArray = poolParams.bucketSizes;
        this.mBucketSizes = new int[sparseIntArray.size()];
        int i = 0;
        while (true) {
            int[] iArr = this.mBucketSizes;
            if (i < iArr.length) {
                iArr[i] = sparseIntArray.keyAt(i);
                i++;
            } else {
                initialize();
                return;
            }
        }
    }

    public abstract MemoryChunk alloc(int i);

    public int getBucketedSize(int i) {
        if (i > 0) {
            for (int i2 : this.mBucketSizes) {
                if (i2 >= i) {
                    return i2;
                }
            }
            return i;
        }
        throw new InvalidSizeException(Integer.valueOf(i));
    }

    public int getMinBufferSize() {
        return this.mBucketSizes[0];
    }

    public int getSizeInBytes(int i) {
        return i;
    }

    public void free(MemoryChunk memoryChunk) {
        if (memoryChunk != null) {
            memoryChunk.close();
            return;
        }
        throw null;
    }

    public int getBucketedSizeForValue(MemoryChunk memoryChunk) {
        if (memoryChunk != null) {
            return memoryChunk.getSize();
        }
        throw null;
    }

    public boolean isReusable(MemoryChunk memoryChunk) {
        if (memoryChunk != null) {
            return !memoryChunk.isClosed();
        }
        throw null;
    }
}
