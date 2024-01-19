package com.facebook.cache.disk;

public class SettableCacheEvent {
    public static final Object RECYCLER_LOCK = new Object();
    public static SettableCacheEvent sFirstRecycledEvent;
    public static int sRecycledCount;
    public SettableCacheEvent mNextRecycledEvent;

    public static SettableCacheEvent obtain() {
        synchronized (RECYCLER_LOCK) {
            if (sFirstRecycledEvent == null) {
                return new SettableCacheEvent();
            }
            SettableCacheEvent settableCacheEvent = sFirstRecycledEvent;
            sFirstRecycledEvent = settableCacheEvent.mNextRecycledEvent;
            settableCacheEvent.mNextRecycledEvent = null;
            sRecycledCount--;
            return settableCacheEvent;
        }
    }

    public void recycle() {
        synchronized (RECYCLER_LOCK) {
            if (sRecycledCount < 5) {
                sRecycledCount++;
                if (sFirstRecycledEvent != null) {
                    this.mNextRecycledEvent = sFirstRecycledEvent;
                }
                sFirstRecycledEvent = this;
            }
        }
    }
}
