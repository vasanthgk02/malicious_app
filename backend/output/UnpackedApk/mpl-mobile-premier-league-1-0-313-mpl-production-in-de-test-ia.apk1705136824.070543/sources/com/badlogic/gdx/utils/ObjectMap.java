package com.badlogic.gdx.utils;

import in.juspay.hypersdk.core.InflateView;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ObjectMap<K, V> implements Iterable<Entry<K, V>> {
    public static final Object dummy = new Object();
    public transient Entries entries1;
    public transient Entries entries2;
    public K[] keyTable;
    public transient Keys keys1;
    public transient Keys keys2;
    public float loadFactor;
    public int mask;
    public int shift;
    public int size;
    public int threshold;
    public V[] valueTable;
    public transient Values values1;
    public transient Values values2;

    public static class Entries<K, V> extends MapIterator<K, V, Entry<K, V>> {
        public Entry<K, V> entry = new Entry<>();

        public Entries(ObjectMap<K, V> objectMap) {
            super(objectMap);
        }

        public boolean hasNext() {
            if (this.valid) {
                return this.hasNext;
            }
            throw new GdxRuntimeException((String) "#iterator() cannot be used nested.");
        }

        public Iterator iterator() {
            return this;
        }

        public Entry<K, V> next() {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            } else if (this.valid) {
                ObjectMap<K, V> objectMap = this.map;
                K[] kArr = objectMap.keyTable;
                Entry<K, V> entry2 = this.entry;
                int i = this.nextIndex;
                entry2.key = kArr[i];
                entry2.value = objectMap.valueTable[i];
                this.currentIndex = i;
                findNextIndex();
                return this.entry;
            } else {
                throw new GdxRuntimeException((String) "#iterator() cannot be used nested.");
            }
        }
    }

    public static class Entry<K, V> {
        public K key;
        public V value;

        public String toString() {
            return this.key + InflateView.SETTER_EQUALS + this.value;
        }
    }

    public static class Keys<K> extends MapIterator<K, Object, K> {
        public Keys(ObjectMap<K, ?> objectMap) {
            super(objectMap);
        }

        public boolean hasNext() {
            if (this.valid) {
                return this.hasNext;
            }
            throw new GdxRuntimeException((String) "#iterator() cannot be used nested.");
        }

        public Iterator iterator() {
            return this;
        }

        public K next() {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            } else if (this.valid) {
                K[] kArr = this.map.keyTable;
                int i = this.nextIndex;
                K k = kArr[i];
                this.currentIndex = i;
                findNextIndex();
                return k;
            } else {
                throw new GdxRuntimeException((String) "#iterator() cannot be used nested.");
            }
        }
    }

    public static abstract class MapIterator<K, V, I> implements Iterable<I>, Iterator<I> {
        public int currentIndex;
        public boolean hasNext;
        public final ObjectMap<K, V> map;
        public int nextIndex;
        public boolean valid = true;

        public MapIterator(ObjectMap<K, V> objectMap) {
            this.map = objectMap;
            reset();
        }

        public void findNextIndex() {
            int i;
            K[] kArr = this.map.keyTable;
            int length = kArr.length;
            do {
                i = this.nextIndex + 1;
                this.nextIndex = i;
                if (i >= length) {
                    this.hasNext = false;
                    return;
                }
            } while (kArr[i] == null);
            this.hasNext = true;
        }

        public void remove() {
            int i = this.currentIndex;
            if (i >= 0) {
                ObjectMap<K, V> objectMap = this.map;
                K[] kArr = objectMap.keyTable;
                V[] vArr = objectMap.valueTable;
                int i2 = objectMap.mask;
                int i3 = i + 1;
                while (true) {
                    int i4 = i3 & i2;
                    K k = kArr[i4];
                    if (k == null) {
                        break;
                    }
                    int place = this.map.place(k);
                    if (((i4 - place) & i2) > ((i - place) & i2)) {
                        kArr[i] = k;
                        vArr[i] = vArr[i4];
                        i = i4;
                    }
                    i3 = i4 + 1;
                }
                kArr[i] = null;
                vArr[i] = null;
                ObjectMap<K, V> objectMap2 = this.map;
                objectMap2.size--;
                if (i != this.currentIndex) {
                    this.nextIndex--;
                }
                this.currentIndex = -1;
                return;
            }
            throw new IllegalStateException("next must be called before remove.");
        }

        public void reset() {
            this.currentIndex = -1;
            this.nextIndex = -1;
            findNextIndex();
        }
    }

    public static class Values<V> extends MapIterator<Object, V, V> {
        public Values(ObjectMap<?, V> objectMap) {
            super(objectMap);
        }

        public boolean hasNext() {
            if (this.valid) {
                return this.hasNext;
            }
            throw new GdxRuntimeException((String) "#iterator() cannot be used nested.");
        }

        public Iterator iterator() {
            return this;
        }

        public V next() {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            } else if (this.valid) {
                V[] vArr = this.map.valueTable;
                int i = this.nextIndex;
                V v = vArr[i];
                this.currentIndex = i;
                findNextIndex();
                return v;
            } else {
                throw new GdxRuntimeException((String) "#iterator() cannot be used nested.");
            }
        }
    }

    public ObjectMap() {
        this(51, 0.8f);
    }

    public void clear() {
        if (this.size != 0) {
            this.size = 0;
            Arrays.fill(this.keyTable, null);
            Arrays.fill(this.valueTable, null);
        }
    }

    public boolean containsKey(K k) {
        return locateKey(k) >= 0;
    }

    public Entries<K, V> entries() {
        if (this.entries1 == null) {
            this.entries1 = new Entries(this);
            this.entries2 = new Entries(this);
        }
        Entries entries = this.entries1;
        if (!entries.valid) {
            entries.reset();
            Entries<K, V> entries3 = this.entries1;
            entries3.valid = true;
            this.entries2.valid = false;
            return entries3;
        }
        this.entries2.reset();
        Entries<K, V> entries4 = this.entries2;
        entries4.valid = true;
        this.entries1.valid = false;
        return entries4;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ObjectMap)) {
            return false;
        }
        ObjectMap objectMap = (ObjectMap) obj;
        if (objectMap.size != this.size) {
            return false;
        }
        K[] kArr = this.keyTable;
        V[] vArr = this.valueTable;
        int length = kArr.length;
        for (int i = 0; i < length; i++) {
            K k = kArr[i];
            if (k != null) {
                V v = vArr[i];
                if (v == null) {
                    V v2 = dummy;
                    int locateKey = objectMap.locateKey(k);
                    if (locateKey >= 0) {
                        v2 = objectMap.valueTable[locateKey];
                    }
                    if (v2 != null) {
                        return false;
                    }
                } else if (!v.equals(objectMap.get(k))) {
                    return false;
                }
            }
        }
        return true;
    }

    public <T extends K> V get(T t) {
        int locateKey = locateKey(t);
        if (locateKey < 0) {
            return null;
        }
        return this.valueTable[locateKey];
    }

    public int hashCode() {
        int i = this.size;
        K[] kArr = this.keyTable;
        V[] vArr = this.valueTable;
        int length = kArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            K k = kArr[i2];
            if (k != null) {
                int hashCode = k.hashCode() + i;
                V v = vArr[i2];
                i = v != null ? v.hashCode() + hashCode : hashCode;
            }
        }
        return i;
    }

    public Keys<K> keys() {
        if (this.keys1 == null) {
            this.keys1 = new Keys(this);
            this.keys2 = new Keys(this);
        }
        Keys keys = this.keys1;
        if (!keys.valid) {
            keys.reset();
            Keys<K> keys3 = this.keys1;
            keys3.valid = true;
            this.keys2.valid = false;
            return keys3;
        }
        this.keys2.reset();
        Keys<K> keys4 = this.keys2;
        keys4.valid = true;
        this.keys1.valid = false;
        return keys4;
    }

    public int locateKey(K k) {
        if (k != null) {
            K[] kArr = this.keyTable;
            int place = place(k);
            while (true) {
                K k2 = kArr[place];
                if (k2 == null) {
                    return -(place + 1);
                }
                if (k2.equals(k)) {
                    return place;
                }
                place = (place + 1) & this.mask;
            }
        } else {
            throw new IllegalArgumentException("key cannot be null.");
        }
    }

    public int place(K k) {
        return (int) ((((long) k.hashCode()) * -7046029254386353131L) >>> this.shift);
    }

    public V put(K k, V v) {
        int locateKey = locateKey(k);
        if (locateKey >= 0) {
            V[] vArr = this.valueTable;
            V v2 = vArr[locateKey];
            vArr[locateKey] = v;
            return v2;
        }
        int i = -(locateKey + 1);
        K[] kArr = this.keyTable;
        kArr[i] = k;
        this.valueTable[i] = v;
        int i2 = this.size + 1;
        this.size = i2;
        if (i2 >= this.threshold) {
            resize(kArr.length << 1);
        }
        return null;
    }

    public V remove(K k) {
        int locateKey = locateKey(k);
        if (locateKey < 0) {
            return null;
        }
        K[] kArr = this.keyTable;
        V[] vArr = this.valueTable;
        V v = vArr[locateKey];
        int i = this.mask;
        int i2 = locateKey + 1;
        while (true) {
            int i3 = i2 & i;
            K k2 = kArr[i3];
            if (k2 != null) {
                int place = place(k2);
                if (((i3 - place) & i) > ((locateKey - place) & i)) {
                    kArr[locateKey] = k2;
                    vArr[locateKey] = vArr[i3];
                    locateKey = i3;
                }
                i2 = i3 + 1;
            } else {
                kArr[locateKey] = null;
                vArr[locateKey] = null;
                this.size--;
                return v;
            }
        }
    }

    public final void resize(int i) {
        int length = this.keyTable.length;
        this.threshold = (int) (((float) i) * this.loadFactor);
        int i2 = i - 1;
        this.mask = i2;
        this.shift = Long.numberOfLeadingZeros((long) i2);
        K[] kArr = this.keyTable;
        V[] vArr = this.valueTable;
        this.keyTable = new Object[i];
        this.valueTable = new Object[i];
        if (this.size > 0) {
            for (int i3 = 0; i3 < length; i3++) {
                K k = kArr[i3];
                if (k != null) {
                    V v = vArr[i3];
                    K[] kArr2 = this.keyTable;
                    int place = place(k);
                    while (kArr2[place] != null) {
                        place = (place + 1) & this.mask;
                    }
                    kArr2[place] = k;
                    this.valueTable[place] = v;
                }
            }
        }
    }

    public String toString() {
        return toString(", ", true);
    }

    public Values<V> values() {
        if (this.values1 == null) {
            this.values1 = new Values(this);
            this.values2 = new Values(this);
        }
        Values values = this.values1;
        if (!values.valid) {
            values.reset();
            Values<V> values3 = this.values1;
            values3.valid = true;
            this.values2.valid = false;
            return values3;
        }
        this.values2.reset();
        Values<V> values4 = this.values2;
        values4.valid = true;
        this.values1.valid = false;
        return values4;
    }

    public ObjectMap(int i, float f2) {
        if (f2 <= 0.0f || f2 >= 1.0f) {
            throw new IllegalArgumentException("loadFactor must be > 0 and < 1: " + f2);
        }
        this.loadFactor = f2;
        int tableSize = ObjectSet.tableSize(i, f2);
        this.threshold = (int) (((float) tableSize) * f2);
        int i2 = tableSize - 1;
        this.mask = i2;
        this.shift = Long.numberOfLeadingZeros((long) i2);
        this.keyTable = new Object[tableSize];
        this.valueTable = new Object[tableSize];
    }

    public Entries<K, V> iterator() {
        return entries();
    }

    public String toString(String str, boolean z) {
        int i;
        if (this.size == 0) {
            return z ? "{}" : "";
        }
        StringBuilder sb = new StringBuilder(32);
        if (z) {
            sb.append('{');
        }
        ObjectMap[] objectMapArr = this.keyTable;
        ObjectMap[] objectMapArr2 = this.valueTable;
        int length = objectMapArr.length;
        while (true) {
            i = length - 1;
            if (length <= 0) {
                break;
            }
            ObjectMap objectMap = objectMapArr[i];
            if (objectMap == null) {
                length = i;
            } else {
                if (objectMap == this) {
                    objectMap = "(this)";
                }
                sb.append(objectMap);
                sb.append('=');
                ObjectMap objectMap2 = objectMapArr2[i];
                if (objectMap2 == this) {
                    objectMap2 = "(this)";
                }
                sb.append(objectMap2);
            }
        }
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                break;
            }
            ObjectMap objectMap3 = objectMapArr[i2];
            if (objectMap3 != null) {
                sb.append(str);
                if (objectMap3 == this) {
                    objectMap3 = "(this)";
                }
                sb.append(objectMap3);
                sb.append('=');
                ObjectMap objectMap4 = objectMapArr2[i2];
                if (objectMap4 == this) {
                    objectMap4 = "(this)";
                }
                sb.append(objectMap4);
            }
            i = i2;
        }
        if (z) {
            sb.append('}');
        }
        return sb.toString();
    }
}
