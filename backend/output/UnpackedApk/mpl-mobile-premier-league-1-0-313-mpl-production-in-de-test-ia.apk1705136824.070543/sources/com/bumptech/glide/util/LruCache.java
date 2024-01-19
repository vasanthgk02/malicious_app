package com.bumptech.glide.util;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class LruCache<T, Y> {
    public final Map<T, Y> cache = new LinkedHashMap(100, 0.75f, true);
    public long currentSize;
    public final long initialMaxSize;
    public long maxSize;

    public LruCache(long j) {
        this.initialMaxSize = j;
        this.maxSize = j;
    }

    public synchronized Y get(T t) {
        try {
        }
        return this.cache.get(t);
    }

    public synchronized long getMaxSize() {
        try {
        }
        return this.maxSize;
    }

    public int getSize(Y y) {
        return 1;
    }

    public void onItemEvicted(T t, Y y) {
    }

    public synchronized Y put(T t, Y y) {
        try {
            long size = (long) getSize(y);
            if (size >= this.maxSize) {
                onItemEvicted(t, y);
                return null;
            }
            if (y != null) {
                this.currentSize += size;
            }
            Y put = this.cache.put(t, y);
            if (put != null) {
                this.currentSize -= (long) getSize(put);
                if (!put.equals(y)) {
                    onItemEvicted(t, put);
                }
            }
            trimToSize(this.maxSize);
            return put;
        }
    }

    public synchronized void trimToSize(long j) {
        while (this.currentSize > j) {
            Iterator<Entry<T, Y>> it = this.cache.entrySet().iterator();
            Entry next = it.next();
            Object value = next.getValue();
            this.currentSize -= (long) getSize(value);
            Object key = next.getKey();
            it.remove();
            onItemEvicted(key, value);
        }
    }
}
