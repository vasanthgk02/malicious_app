package com.badlogic.gdx.utils;

import in.juspay.hypersdk.core.InflateView;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ObjectFloatMap<K> implements Iterable<Entry<K>> {
    public transient Entries entries1;
    public transient Entries entries2;
    public K[] keyTable;
    public float loadFactor = 0.8f;
    public int mask;
    public int shift;
    public int size;
    public int threshold;
    public float[] valueTable;

    public static class Entries<K> extends MapIterator<K> implements Iterable<Entry<K>>, Iterator<Entry<K>> {
        public Entry<K> entry = new Entry<>();

        public Entries(ObjectFloatMap<K> objectFloatMap) {
            super(objectFloatMap);
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

        public Object next() {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            } else if (this.valid) {
                ObjectFloatMap<K> objectFloatMap = this.map;
                K[] kArr = objectFloatMap.keyTable;
                Entry<K> entry2 = this.entry;
                int i = this.nextIndex;
                entry2.key = kArr[i];
                entry2.value = objectFloatMap.valueTable[i];
                this.currentIndex = i;
                findNextIndex();
                return this.entry;
            } else {
                throw new GdxRuntimeException((String) "#iterator() cannot be used nested.");
            }
        }
    }

    public static class Entry<K> {
        public K key;
        public float value;

        public String toString() {
            return this.key + InflateView.SETTER_EQUALS + this.value;
        }
    }

    public static class MapIterator<K> {
        public int currentIndex;
        public boolean hasNext;
        public final ObjectFloatMap<K> map;
        public int nextIndex;
        public boolean valid = true;

        public MapIterator(ObjectFloatMap<K> objectFloatMap) {
            this.map = objectFloatMap;
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
                ObjectFloatMap<K> objectFloatMap = this.map;
                K[] kArr = objectFloatMap.keyTable;
                float[] fArr = objectFloatMap.valueTable;
                int i2 = objectFloatMap.mask;
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
                        fArr[i] = fArr[i4];
                        i = i4;
                    }
                    i3 = i4 + 1;
                }
                kArr[i] = null;
                ObjectFloatMap<K> objectFloatMap2 = this.map;
                objectFloatMap2.size--;
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

    public ObjectFloatMap() {
        int tableSize = ObjectSet.tableSize(51, 0.8f);
        this.threshold = (int) (((float) tableSize) * 0.8f);
        int i = tableSize - 1;
        this.mask = i;
        this.shift = Long.numberOfLeadingZeros((long) i);
        this.keyTable = new Object[tableSize];
        this.valueTable = new float[tableSize];
    }

    public Entries<K> entries() {
        if (this.entries1 == null) {
            this.entries1 = new Entries(this);
            this.entries2 = new Entries(this);
        }
        Entries entries = this.entries1;
        if (!entries.valid) {
            entries.reset();
            Entries<K> entries3 = this.entries1;
            entries3.valid = true;
            this.entries2.valid = false;
            return entries3;
        }
        this.entries2.reset();
        Entries<K> entries4 = this.entries2;
        entries4.valid = true;
        this.entries1.valid = false;
        return entries4;
    }

    public boolean equals(Object obj) {
        float f2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ObjectFloatMap)) {
            return false;
        }
        ObjectFloatMap objectFloatMap = (ObjectFloatMap) obj;
        if (objectFloatMap.size != this.size) {
            return false;
        }
        K[] kArr = this.keyTable;
        float[] fArr = this.valueTable;
        int length = kArr.length;
        for (int i = 0; i < length; i++) {
            K k = kArr[i];
            if (k != null) {
                int locateKey = objectFloatMap.locateKey(k);
                if (locateKey < 0) {
                    f2 = 0.0f;
                } else {
                    f2 = objectFloatMap.valueTable[locateKey];
                }
                if (f2 == 0.0f) {
                    if (!(objectFloatMap.locateKey(k) >= 0)) {
                        return false;
                    }
                }
                if (f2 != fArr[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public int hashCode() {
        int i = this.size;
        K[] kArr = this.keyTable;
        float[] fArr = this.valueTable;
        int length = kArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            K k = kArr[i2];
            if (k != null) {
                i = k.hashCode() + Float.floatToRawIntBits(fArr[i2]) + i;
            }
        }
        return i;
    }

    public Iterator iterator() {
        return entries();
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

    public String toString() {
        int i;
        if (this.size == 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(32);
        sb.append('{');
        K[] kArr = this.keyTable;
        float[] fArr = this.valueTable;
        int length = kArr.length;
        while (true) {
            i = length - 1;
            if (length <= 0) {
                break;
            }
            K k = kArr[i];
            if (k != null) {
                sb.append(k);
                sb.append('=');
                sb.append(fArr[i]);
                break;
            }
            length = i;
        }
        while (true) {
            int i2 = i - 1;
            if (i > 0) {
                K k2 = kArr[i2];
                if (k2 != null) {
                    sb.append(", ");
                    sb.append(k2);
                    sb.append('=');
                    sb.append(fArr[i2]);
                }
                i = i2;
            } else {
                sb.append('}');
                return sb.toString();
            }
        }
    }
}
