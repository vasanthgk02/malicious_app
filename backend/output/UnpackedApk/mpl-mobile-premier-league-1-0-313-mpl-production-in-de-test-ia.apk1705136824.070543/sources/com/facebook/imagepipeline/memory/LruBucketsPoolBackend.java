package com.facebook.imagepipeline.memory;

import java.util.HashSet;
import java.util.Set;

public abstract class LruBucketsPoolBackend<T> implements PoolBackend<T> {
    public final Set<T> mCurrentItems = new HashSet();
    public final BucketMap<T> mMap = new BucketMap<>();

    private T maybeRemoveFromCurrentItems(T t) {
        if (t != null) {
            synchronized (this) {
                this.mCurrentItems.remove(t);
            }
        }
        return t;
    }

    public T get(int i) {
        return maybeRemoveFromCurrentItems(this.mMap.acquire(i));
    }

    public T pop() {
        return maybeRemoveFromCurrentItems(this.mMap.removeFromEnd());
    }

    public void put(T t) {
        boolean add;
        synchronized (this) {
            add = this.mCurrentItems.add(t);
        }
        if (add) {
            this.mMap.release(getSize(t), t);
        }
    }

    public int valueCount() {
        return this.mMap.valueCount();
    }
}
