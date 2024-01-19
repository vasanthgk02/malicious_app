package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;
import co.hyperverge.hypersnapsdk.c.k;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.imageutils.BitmapUtil;

public class BitmapCounter {
    public int mCount;
    public final int mMaxCount;
    public final int mMaxSize;
    public long mSize;
    public final ResourceReleaser<Bitmap> mUnpooledBitmapsReleaser;

    public BitmapCounter(int i, int i2) {
        boolean z = true;
        k.checkArgument(i > 0);
        k.checkArgument(i2 <= 0 ? false : z);
        this.mMaxCount = i;
        this.mMaxSize = i2;
        this.mUnpooledBitmapsReleaser = new ResourceReleaser<Bitmap>() {
            public void release(Bitmap bitmap) {
                try {
                    BitmapCounter.this.decrease(bitmap);
                } finally {
                    bitmap.recycle();
                }
            }
        };
    }

    public synchronized void decrease(Bitmap bitmap) {
        int sizeInBytes = BitmapUtil.getSizeInBytes(bitmap);
        k.checkArgument(this.mCount > 0, (Object) "No bitmaps registered.");
        long j = (long) sizeInBytes;
        boolean z = j <= this.mSize;
        Object[] objArr = {Integer.valueOf(sizeInBytes), Long.valueOf(this.mSize)};
        if (z) {
            this.mSize -= j;
            this.mCount--;
        } else {
            throw new IllegalArgumentException(k.format("Bitmap size bigger than the total registered size: %d, %d", objArr));
        }
    }

    public synchronized int getCount() {
        return this.mCount;
    }

    public synchronized int getMaxCount() {
        return this.mMaxCount;
    }

    public synchronized int getMaxSize() {
        return this.mMaxSize;
    }

    public ResourceReleaser<Bitmap> getReleaser() {
        return this.mUnpooledBitmapsReleaser;
    }

    public synchronized long getSize() {
        return this.mSize;
    }

    public synchronized boolean increase(Bitmap bitmap) {
        int sizeInBytes = BitmapUtil.getSizeInBytes(bitmap);
        if (this.mCount < this.mMaxCount) {
            long j = (long) sizeInBytes;
            if (this.mSize + j <= ((long) this.mMaxSize)) {
                this.mCount++;
                this.mSize += j;
                return true;
            }
        }
        return false;
    }
}
