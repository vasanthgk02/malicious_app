package com.facebook.imagepipeline.memory;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.facebook.common.memory.MemoryTrimmableRegistry;

@TargetApi(21)
public class BucketsBitmapPool extends BasePool<Bitmap> implements BitmapPool {
    public BucketsBitmapPool(MemoryTrimmableRegistry memoryTrimmableRegistry, PoolParams poolParams, PoolStatsTracker poolStatsTracker, boolean z) {
        super(memoryTrimmableRegistry, poolParams, poolStatsTracker, z);
        initialize();
    }

    public int getBucketedSize(int i) {
        return i;
    }

    public int getSizeInBytes(int i) {
        return i;
    }

    public Bitmap alloc(int i) {
        return Bitmap.createBitmap(1, (int) Math.ceil(((double) i) / 2.0d), Config.RGB_565);
    }

    public void free(Bitmap bitmap) {
        if (bitmap != null) {
            bitmap.recycle();
            return;
        }
        throw null;
    }

    public int getBucketedSizeForValue(Bitmap bitmap) {
        if (bitmap != null) {
            return bitmap.getAllocationByteCount();
        }
        throw null;
    }

    public Bitmap getValue(Bucket<Bitmap> bucket) {
        Bitmap bitmap = (Bitmap) super.getValue(bucket);
        if (bitmap != null) {
            bitmap.eraseColor(0);
        }
        return bitmap;
    }

    public boolean isReusable(Bitmap bitmap) {
        if (bitmap != null) {
            return !bitmap.isRecycled() && bitmap.isMutable();
        }
        throw null;
    }
}
