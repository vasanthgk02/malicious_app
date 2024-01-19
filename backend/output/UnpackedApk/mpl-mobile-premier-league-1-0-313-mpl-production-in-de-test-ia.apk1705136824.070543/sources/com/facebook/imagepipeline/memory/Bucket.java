package com.facebook.imagepipeline.memory;

import co.hyperverge.hypersnapsdk.c.k;
import com.facebook.common.logging.FLog;
import java.util.LinkedList;
import java.util.Queue;

public class Bucket<V> {
    public static final String TAG = "BUCKET";
    public final boolean mFixBucketsReinitialization;
    public final Queue mFreeList;
    public int mInUseLength;
    public final int mItemSize;
    public final int mMaxLength;

    public Bucket(int i, int i2, int i3, boolean z) {
        boolean z2 = true;
        k.checkState(i > 0);
        k.checkState(i2 >= 0);
        k.checkState(i3 < 0 ? false : z2);
        this.mItemSize = i;
        this.mMaxLength = i2;
        this.mFreeList = new LinkedList();
        this.mInUseLength = i3;
        this.mFixBucketsReinitialization = z;
    }

    public void addToFreeList(V v) {
        this.mFreeList.add(v);
    }

    public void decrementInUseCount() {
        k.checkState(this.mInUseLength > 0);
        this.mInUseLength--;
    }

    @Deprecated
    public V get() {
        V pop = pop();
        if (pop != null) {
            this.mInUseLength++;
        }
        return pop;
    }

    public int getFreeListSize() {
        return this.mFreeList.size();
    }

    public int getInUseCount() {
        return this.mInUseLength;
    }

    public void incrementInUseCount() {
        this.mInUseLength++;
    }

    public boolean isMaxLengthExceeded() {
        return getFreeListSize() + this.mInUseLength > this.mMaxLength;
    }

    public V pop() {
        return this.mFreeList.poll();
    }

    public void release(V v) {
        if (v != null) {
            boolean z = false;
            if (this.mFixBucketsReinitialization) {
                if (this.mInUseLength > 0) {
                    z = true;
                }
                k.checkState(z);
                this.mInUseLength--;
                addToFreeList(v);
                return;
            }
            int i = this.mInUseLength;
            if (i > 0) {
                this.mInUseLength = i - 1;
                addToFreeList(v);
                return;
            }
            FLog.e((String) TAG, (String) "Tried to release value %s from an empty bucket!", v);
            return;
        }
        throw null;
    }
}
