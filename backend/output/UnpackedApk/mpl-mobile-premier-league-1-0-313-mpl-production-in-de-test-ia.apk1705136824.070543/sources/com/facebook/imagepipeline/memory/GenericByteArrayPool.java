package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.imagepipeline.memory.BasePool.InvalidSizeException;

public class GenericByteArrayPool extends BasePool<byte[]> implements ByteArrayPool {
    public final int[] mBucketSizes;

    public GenericByteArrayPool(MemoryTrimmableRegistry memoryTrimmableRegistry, PoolParams poolParams, PoolStatsTracker poolStatsTracker) {
        super(memoryTrimmableRegistry, poolParams, poolStatsTracker);
        SparseIntArray sparseIntArray = poolParams.bucketSizes;
        this.mBucketSizes = new int[sparseIntArray.size()];
        for (int i = 0; i < sparseIntArray.size(); i++) {
            this.mBucketSizes[i] = sparseIntArray.keyAt(i);
        }
        initialize();
    }

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

    public byte[] alloc(int i) {
        return new byte[i];
    }

    public void free(byte[] bArr) {
        if (bArr == null) {
            throw null;
        }
    }

    public int getBucketedSizeForValue(byte[] bArr) {
        if (bArr != null) {
            return bArr.length;
        }
        throw null;
    }
}
