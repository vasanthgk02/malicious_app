package com.badlogic.gdx.utils;

import in.juspay.hypersdk.core.InflateView;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LongMap<V> implements Iterable<Entry<V>> {
    public transient Entries entries1;
    public transient Entries entries2;
    public boolean hasZeroValue;
    public long[] keyTable;
    public final float loadFactor = 0.8f;
    public int mask;
    public int shift;
    public int size;
    public int threshold;
    public V[] valueTable;
    public transient Values values1;
    public transient Values values2;
    public V zeroValue;

    public static class Entries<V> extends MapIterator<V> implements Iterable<Entry<V>>, Iterator<Entry<V>> {
        public final Entry<V> entry = new Entry<>();

        public Entries(LongMap longMap) {
            super(longMap);
        }

        public boolean hasNext() {
            if (this.valid) {
                return this.hasNext;
            }
            throw new GdxRuntimeException((String) "#iterator() cannot be used nested.");
        }

        public Iterator<Entry<V>> iterator() {
            return this;
        }

        public Object next() {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            } else if (this.valid) {
                LongMap<V> longMap = this.map;
                long[] jArr = longMap.keyTable;
                int i = this.nextIndex;
                if (i == -1) {
                    Entry<V> entry2 = this.entry;
                    entry2.key = 0;
                    entry2.value = longMap.zeroValue;
                } else {
                    Entry<V> entry3 = this.entry;
                    entry3.key = jArr[i];
                    entry3.value = longMap.valueTable[i];
                }
                this.currentIndex = this.nextIndex;
                findNextIndex();
                return this.entry;
            } else {
                throw new GdxRuntimeException((String) "#iterator() cannot be used nested.");
            }
        }
    }

    public static class Entry<V> {
        public long key;
        public V value;

        public String toString() {
            return this.key + InflateView.SETTER_EQUALS + this.value;
        }
    }

    public static class MapIterator<V> {
        public int currentIndex;
        public boolean hasNext;
        public final LongMap<V> map;
        public int nextIndex;
        public boolean valid = true;

        public MapIterator(LongMap<V> longMap) {
            this.map = longMap;
            reset();
        }

        public void findNextIndex() {
            int i;
            long[] jArr = this.map.keyTable;
            int length = jArr.length;
            do {
                i = this.nextIndex + 1;
                this.nextIndex = i;
                if (i >= length) {
                    this.hasNext = false;
                    return;
                }
            } while (jArr[i] == 0);
            this.hasNext = true;
        }

        public void remove() {
            int i = this.currentIndex;
            if (i == -1) {
                LongMap<V> longMap = this.map;
                if (longMap.hasZeroValue) {
                    longMap.hasZeroValue = false;
                    this.currentIndex = -2;
                    LongMap<V> longMap2 = this.map;
                    longMap2.size--;
                    return;
                }
            }
            if (i >= 0) {
                LongMap<V> longMap3 = this.map;
                long[] jArr = longMap3.keyTable;
                V[] vArr = longMap3.valueTable;
                int i2 = longMap3.mask;
                int i3 = i + 1;
                while (true) {
                    int i4 = i3 & i2;
                    long j = jArr[i4];
                    if (j == 0) {
                        break;
                    }
                    int place = this.map.place(j);
                    if (((i4 - place) & i2) > ((i - place) & i2)) {
                        jArr[i] = j;
                        vArr[i] = vArr[i4];
                        i = i4;
                    }
                    i3 = i4 + 1;
                }
                jArr[i] = 0;
                vArr[i] = null;
                if (i != this.currentIndex) {
                    this.nextIndex--;
                }
                this.currentIndex = -2;
                LongMap<V> longMap22 = this.map;
                longMap22.size--;
                return;
            }
            throw new IllegalStateException("next must be called before remove.");
        }

        public void reset() {
            this.currentIndex = -2;
            this.nextIndex = -1;
            if (this.map.hasZeroValue) {
                this.hasNext = true;
            } else {
                findNextIndex();
            }
        }
    }

    public static class Values<V> extends MapIterator<V> implements Iterable<V>, Iterator<V> {
        public Values(LongMap<V> longMap) {
            super(longMap);
        }

        public boolean hasNext() {
            if (this.valid) {
                return this.hasNext;
            }
            throw new GdxRuntimeException((String) "#iterator() cannot be used nested.");
        }

        public Iterator<V> iterator() {
            return this;
        }

        public V next() {
            V v;
            if (!this.hasNext) {
                throw new NoSuchElementException();
            } else if (this.valid) {
                int i = this.nextIndex;
                if (i == -1) {
                    v = this.map.zeroValue;
                } else {
                    v = this.map.valueTable[i];
                }
                this.currentIndex = this.nextIndex;
                findNextIndex();
                return v;
            } else {
                throw new GdxRuntimeException((String) "#iterator() cannot be used nested.");
            }
        }
    }

    public LongMap() {
        int tableSize = ObjectSet.tableSize(51, 0.8f);
        this.threshold = (int) (((float) tableSize) * 0.8f);
        int i = tableSize - 1;
        this.mask = i;
        this.shift = Long.numberOfLeadingZeros((long) i);
        this.keyTable = new long[tableSize];
        this.valueTable = new Object[tableSize];
    }

    public Entries<V> entries() {
        if (this.entries1 == null) {
            this.entries1 = new Entries(this);
            this.entries2 = new Entries(this);
        }
        Entries entries = this.entries1;
        if (!entries.valid) {
            entries.reset();
            Entries<V> entries3 = this.entries1;
            entries3.valid = true;
            this.entries2.valid = false;
            return entries3;
        }
        this.entries2.reset();
        Entries<V> entries4 = this.entries2;
        entries4.valid = true;
        this.entries1.valid = false;
        return entries4;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LongMap)) {
            return false;
        }
        LongMap longMap = (LongMap) obj;
        if (longMap.size != this.size) {
            return false;
        }
        boolean z = longMap.hasZeroValue;
        boolean z2 = this.hasZeroValue;
        if (z != z2) {
            return false;
        }
        if (z2) {
            V v = longMap.zeroValue;
            if (v == null) {
                if (this.zeroValue != null) {
                    return false;
                }
            } else if (!v.equals(this.zeroValue)) {
                return false;
            }
        }
        long[] jArr = this.keyTable;
        V[] vArr = this.valueTable;
        int length = jArr.length;
        for (int i = 0; i < length; i++) {
            long j = jArr[i];
            int i2 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i2 != 0) {
                V v2 = vArr[i];
                if (v2 == null) {
                    V v3 = ObjectMap.dummy;
                    if (i2 != 0) {
                        int locateKey = longMap.locateKey(j);
                        if (locateKey >= 0) {
                            v3 = longMap.valueTable[locateKey];
                        }
                    } else if (longMap.hasZeroValue) {
                        v3 = longMap.zeroValue;
                    }
                    if (v3 != null) {
                        return false;
                    }
                } else if (!v2.equals(longMap.get(j))) {
                    return false;
                }
            }
        }
        return true;
    }

    public V get(long j) {
        V v = null;
        if (j == 0) {
            if (this.hasZeroValue) {
                v = this.zeroValue;
            }
            return v;
        }
        int locateKey = locateKey(j);
        if (locateKey >= 0) {
            v = this.valueTable[locateKey];
        }
        return v;
    }

    public int hashCode() {
        int i = this.size;
        if (this.hasZeroValue) {
            V v = this.zeroValue;
            if (v != null) {
                i += v.hashCode();
            }
        }
        long[] jArr = this.keyTable;
        V[] vArr = this.valueTable;
        int length = jArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            long j = jArr[i2];
            if (j != 0) {
                i = (int) ((j * 31) + ((long) i));
                V v2 = vArr[i2];
                if (v2 != null) {
                    i = v2.hashCode() + i;
                }
            }
        }
        return i;
    }

    public Iterator<Entry<V>> iterator() {
        return entries();
    }

    public final int locateKey(long j) {
        long[] jArr = this.keyTable;
        int place = place(j);
        while (true) {
            long j2 = jArr[place];
            if (j2 == 0) {
                return -(place + 1);
            }
            if (j2 == j) {
                return place;
            }
            place = (place + 1) & this.mask;
        }
    }

    public int place(long j) {
        return (int) (((j ^ (j >>> 32)) * -7046029254386353131L) >>> this.shift);
    }

    public V put(long j, V v) {
        if (j == 0) {
            V v2 = this.zeroValue;
            this.zeroValue = v;
            if (!this.hasZeroValue) {
                this.hasZeroValue = true;
                this.size++;
            }
            return v2;
        }
        int locateKey = locateKey(j);
        if (locateKey >= 0) {
            V[] vArr = this.valueTable;
            V v3 = vArr[locateKey];
            vArr[locateKey] = v;
            return v3;
        }
        int i = -(locateKey + 1);
        long[] jArr = this.keyTable;
        jArr[i] = j;
        this.valueTable[i] = v;
        int i2 = this.size + 1;
        this.size = i2;
        if (i2 >= this.threshold) {
            int length = jArr.length << 1;
            int length2 = jArr.length;
            this.threshold = (int) (((float) length) * this.loadFactor);
            int i3 = length - 1;
            this.mask = i3;
            this.shift = Long.numberOfLeadingZeros((long) i3);
            long[] jArr2 = this.keyTable;
            V[] vArr2 = this.valueTable;
            this.keyTable = new long[length];
            this.valueTable = new Object[length];
            if (this.size > 0) {
                for (int i4 = 0; i4 < length2; i4++) {
                    long j2 = jArr2[i4];
                    if (j2 != 0) {
                        V v4 = vArr2[i4];
                        long[] jArr3 = this.keyTable;
                        int place = place(j2);
                        while (jArr3[place] != 0) {
                            place = (place + 1) & this.mask;
                        }
                        jArr3[place] = j2;
                        this.valueTable[place] = v4;
                    }
                }
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0047  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toString() {
        /*
            r10 = this;
            int r0 = r10.size
            if (r0 != 0) goto L_0x0007
            java.lang.String r0 = "[]"
            return r0
        L_0x0007:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = 32
            r0.<init>(r1)
            r1 = 91
            r0.append(r1)
            long[] r1 = r10.keyTable
            V[] r2 = r10.valueTable
            int r3 = r1.length
            boolean r4 = r10.hasZeroValue
            r5 = 61
            r6 = 0
            if (r4 == 0) goto L_0x002b
            java.lang.String r4 = "0="
            r0.append(r4)
            V r4 = r10.zeroValue
            r0.append(r4)
            goto L_0x0043
        L_0x002b:
            int r4 = r3 + -1
            if (r3 <= 0) goto L_0x0042
            r8 = r1[r4]
            int r3 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r3 != 0) goto L_0x0037
            r3 = r4
            goto L_0x002b
        L_0x0037:
            r0.append(r8)
            r0.append(r5)
            r3 = r2[r4]
            r0.append(r3)
        L_0x0042:
            r3 = r4
        L_0x0043:
            int r4 = r3 + -1
            if (r3 <= 0) goto L_0x005f
            r8 = r1[r4]
            int r3 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r3 != 0) goto L_0x004e
            goto L_0x0042
        L_0x004e:
            java.lang.String r3 = ", "
            r0.append(r3)
            r0.append(r8)
            r0.append(r5)
            r3 = r2[r4]
            r0.append(r3)
            goto L_0x0042
        L_0x005f:
            r1 = 93
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.utils.LongMap.toString():java.lang.String");
    }
}
