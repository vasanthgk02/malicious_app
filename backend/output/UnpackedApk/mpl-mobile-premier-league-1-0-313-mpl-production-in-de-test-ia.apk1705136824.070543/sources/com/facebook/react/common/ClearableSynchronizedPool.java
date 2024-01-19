package com.facebook.react.common;

import androidx.core.util.Pools$Pool;

public class ClearableSynchronizedPool<T> implements Pools$Pool<T> {
    public final Object[] mPool;
    public int mSize = 0;

    public ClearableSynchronizedPool(int i) {
        this.mPool = new Object[i];
    }

    public synchronized T acquire() {
        try {
            if (this.mSize == 0) {
                return null;
            }
            int i = this.mSize - 1;
            this.mSize = i;
            T t = this.mPool[i];
            this.mPool[i] = null;
            return t;
        }
    }

    public synchronized void clear() {
        for (int i = 0; i < this.mSize; i++) {
            this.mPool[i] = null;
        }
        this.mSize = 0;
    }

    public synchronized boolean release(T t) {
        if (this.mSize == this.mPool.length) {
            return false;
        }
        this.mPool[this.mSize] = t;
        this.mSize++;
        return true;
    }
}
