package com.facebook.imagepipeline.cache;

import com.facebook.common.internal.Predicate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class CountingLruMap<K, V> {
    public final LinkedHashMap<K, V> mMap = new LinkedHashMap<>();
    public int mSizeInBytes = 0;
    public final ValueDescriptor<V> mValueDescriptor;

    public CountingLruMap(ValueDescriptor<V> valueDescriptor) {
        this.mValueDescriptor = valueDescriptor;
    }

    private int getValueSizeInBytes(V v) {
        if (v == null) {
            return 0;
        }
        return this.mValueDescriptor.getSizeInBytes(v);
    }

    public synchronized ArrayList<V> clear() {
        ArrayList<V> arrayList;
        try {
            arrayList = new ArrayList<>(this.mMap.values());
            this.mMap.clear();
            this.mSizeInBytes = 0;
        }
        return arrayList;
    }

    public synchronized boolean contains(K k) {
        try {
        }
        return this.mMap.containsKey(k);
    }

    public synchronized V get(K k) {
        try {
        }
        return this.mMap.get(k);
    }

    public synchronized int getCount() {
        try {
        }
        return this.mMap.size();
    }

    public synchronized K getFirstKey() {
        return this.mMap.isEmpty() ? null : this.mMap.keySet().iterator().next();
    }

    public synchronized ArrayList<K> getKeys() {
        return new ArrayList<>(this.mMap.keySet());
    }

    public synchronized ArrayList<Entry<K, V>> getMatchingEntries(Predicate<K> predicate) {
        ArrayList<Entry<K, V>> arrayList;
        try {
            arrayList = new ArrayList<>(this.mMap.entrySet().size());
            for (Entry next : this.mMap.entrySet()) {
                if (predicate == null || predicate.apply(next.getKey())) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    public synchronized int getSizeInBytes() {
        try {
        }
        return this.mSizeInBytes;
    }

    public synchronized ArrayList<V> getValues() {
        return new ArrayList<>(this.mMap.values());
    }

    public synchronized V put(K k, V v) {
        V remove;
        remove = this.mMap.remove(k);
        this.mSizeInBytes -= getValueSizeInBytes(remove);
        this.mMap.put(k, v);
        this.mSizeInBytes += getValueSizeInBytes(v);
        return remove;
    }

    public synchronized V remove(K k) {
        V remove;
        try {
            remove = this.mMap.remove(k);
            this.mSizeInBytes -= getValueSizeInBytes(remove);
        }
        return remove;
    }

    public synchronized ArrayList<V> removeAll(Predicate<K> predicate) {
        ArrayList<V> arrayList;
        try {
            arrayList = new ArrayList<>();
            Iterator<Entry<K, V>> it = this.mMap.entrySet().iterator();
            while (it.hasNext()) {
                Entry next = it.next();
                if (predicate == null || predicate.apply(next.getKey())) {
                    arrayList.add(next.getValue());
                    this.mSizeInBytes -= getValueSizeInBytes(next.getValue());
                    it.remove();
                }
            }
        }
        return arrayList;
    }
}
