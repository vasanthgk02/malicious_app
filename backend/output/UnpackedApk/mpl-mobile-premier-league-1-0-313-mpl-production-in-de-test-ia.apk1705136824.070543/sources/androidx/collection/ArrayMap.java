package androidx.collection;

import androidx.collection.MapCollections.EntrySet;
import androidx.collection.MapCollections.KeySet;
import androidx.collection.MapCollections.ValuesCollection;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ArrayMap<K, V> extends SimpleArrayMap<K, V> implements Map<K, V> {
    public MapCollections<K, V> mCollections;

    public ArrayMap() {
    }

    public Set<Entry<K, V>> entrySet() {
        MapCollections collection = getCollection();
        if (collection.mEntrySet == null) {
            collection.mEntrySet = new EntrySet<>();
        }
        return collection.mEntrySet;
    }

    public final MapCollections<K, V> getCollection() {
        if (this.mCollections == null) {
            this.mCollections = new MapCollections<K, V>() {
                public void colClear() {
                    ArrayMap.this.clear();
                }

                public Object colGetEntry(int i, int i2) {
                    return ArrayMap.this.mArray[(i << 1) + i2];
                }

                public Map<K, V> colGetMap() {
                    return ArrayMap.this;
                }

                public int colGetSize() {
                    return ArrayMap.this.mSize;
                }

                public int colIndexOfKey(Object obj) {
                    return ArrayMap.this.indexOfKey(obj);
                }

                public int colIndexOfValue(Object obj) {
                    return ArrayMap.this.indexOfValue(obj);
                }

                public void colPut(K k, V v) {
                    ArrayMap.this.put(k, v);
                }

                public void colRemoveAt(int i) {
                    ArrayMap.this.removeAt(i);
                }

                public V colSetValue(int i, V v) {
                    return ArrayMap.this.setValueAt(i, v);
                }
            };
        }
        return this.mCollections;
    }

    public Set<K> keySet() {
        MapCollections collection = getCollection();
        if (collection.mKeySet == null) {
            collection.mKeySet = new KeySet<>();
        }
        return collection.mKeySet;
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        ensureCapacity(map.size() + this.mSize);
        for (Entry next : map.entrySet()) {
            put(next.getKey(), next.getValue());
        }
    }

    public Collection<V> values() {
        MapCollections collection = getCollection();
        if (collection.mValues == null) {
            collection.mValues = new ValuesCollection<>();
        }
        return collection.mValues;
    }

    public ArrayMap(int i) {
        super(i);
    }

    public ArrayMap(SimpleArrayMap simpleArrayMap) {
        if (simpleArrayMap != null) {
            putAll(simpleArrayMap);
        }
    }
}
