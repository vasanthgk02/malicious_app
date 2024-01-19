package com.bumptech.glide.util;

import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;

public final class CachedHashCodeArrayMap<K, V> extends ArrayMap<K, V> {
    public int hashCode;

    public void clear() {
        this.hashCode = 0;
        super.clear();
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = super.hashCode();
        }
        return this.hashCode;
    }

    public V put(K k, V v) {
        this.hashCode = 0;
        return super.put(k, v);
    }

    public void putAll(SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        this.hashCode = 0;
        super.putAll(simpleArrayMap);
    }

    public V removeAt(int i) {
        this.hashCode = 0;
        return super.removeAt(i);
    }

    public V setValueAt(int i, V v) {
        this.hashCode = 0;
        int i2 = (i << 1) + 1;
        V[] vArr = this.mArray;
        V v2 = vArr[i2];
        vArr[i2] = v;
        return v2;
    }
}
