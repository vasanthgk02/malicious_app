package com.badlogic.gdx.utils;

import in.juspay.hypersdk.core.InflateView;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class IntMap<V> implements Iterable<Entry<V>> {
    public transient Entries entries1;
    public transient Entries entries2;
    public boolean hasZeroValue;
    public int[] keyTable;
    public final float loadFactor = 0.8f;
    public int mask;
    public int shift;
    public int size;
    public int threshold;
    public V[] valueTable;
    public V zeroValue;

    public static class Entries<V> extends MapIterator<V> implements Iterable<Entry<V>>, Iterator<Entry<V>> {
        public final Entry<V> entry = new Entry<>();

        public Entries(IntMap intMap) {
            super(intMap);
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
                IntMap<V> intMap = this.map;
                int[] iArr = intMap.keyTable;
                int i = this.nextIndex;
                if (i == -1) {
                    Entry<V> entry2 = this.entry;
                    entry2.key = 0;
                    entry2.value = intMap.zeroValue;
                } else {
                    Entry<V> entry3 = this.entry;
                    entry3.key = iArr[i];
                    entry3.value = intMap.valueTable[i];
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
        public int key;
        public V value;

        public String toString() {
            return this.key + InflateView.SETTER_EQUALS + this.value;
        }
    }

    public static class MapIterator<V> {
        public int currentIndex;
        public boolean hasNext;
        public final IntMap<V> map;
        public int nextIndex;
        public boolean valid = true;

        public MapIterator(IntMap<V> intMap) {
            this.map = intMap;
            reset();
        }

        public void findNextIndex() {
            int i;
            int[] iArr = this.map.keyTable;
            int length = iArr.length;
            do {
                i = this.nextIndex + 1;
                this.nextIndex = i;
                if (i >= length) {
                    this.hasNext = false;
                    return;
                }
            } while (iArr[i] == 0);
            this.hasNext = true;
        }

        public void remove() {
            int i = this.currentIndex;
            if (i == -1) {
                IntMap<V> intMap = this.map;
                if (intMap.hasZeroValue) {
                    intMap.hasZeroValue = false;
                    this.currentIndex = -2;
                    IntMap<V> intMap2 = this.map;
                    intMap2.size--;
                    return;
                }
            }
            if (i >= 0) {
                IntMap<V> intMap3 = this.map;
                int[] iArr = intMap3.keyTable;
                V[] vArr = intMap3.valueTable;
                int i2 = intMap3.mask;
                int i3 = i + 1;
                while (true) {
                    int i4 = i3 & i2;
                    int i5 = iArr[i4];
                    if (i5 == 0) {
                        break;
                    }
                    int place = this.map.place(i5);
                    if (((i4 - place) & i2) > ((i - place) & i2)) {
                        iArr[i] = i5;
                        vArr[i] = vArr[i4];
                        i = i4;
                    }
                    i3 = i4 + 1;
                }
                iArr[i] = 0;
                vArr[i] = null;
                if (i != this.currentIndex) {
                    this.nextIndex--;
                }
                this.currentIndex = -2;
                IntMap<V> intMap22 = this.map;
                intMap22.size--;
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

    public IntMap() {
        int tableSize = ObjectSet.tableSize(51, 0.8f);
        this.threshold = (int) (((float) tableSize) * 0.8f);
        int i = tableSize - 1;
        this.mask = i;
        this.shift = Long.numberOfLeadingZeros((long) i);
        this.keyTable = new int[tableSize];
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
        if (!(obj instanceof IntMap)) {
            return false;
        }
        IntMap intMap = (IntMap) obj;
        if (intMap.size != this.size) {
            return false;
        }
        boolean z = intMap.hasZeroValue;
        boolean z2 = this.hasZeroValue;
        if (z != z2) {
            return false;
        }
        if (z2) {
            V v = intMap.zeroValue;
            if (v == null) {
                if (this.zeroValue != null) {
                    return false;
                }
            } else if (!v.equals(this.zeroValue)) {
                return false;
            }
        }
        int[] iArr = this.keyTable;
        V[] vArr = this.valueTable;
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            int i2 = iArr[i];
            if (i2 != 0) {
                V v2 = vArr[i];
                if (v2 == null) {
                    V v3 = ObjectMap.dummy;
                    if (i2 != 0) {
                        int locateKey = intMap.locateKey(i2);
                        if (locateKey >= 0) {
                            v3 = intMap.valueTable[locateKey];
                        }
                    } else if (intMap.hasZeroValue) {
                        v3 = intMap.zeroValue;
                    }
                    if (v3 != null) {
                        return false;
                    }
                } else if (!v2.equals(intMap.get(i2))) {
                    return false;
                }
            }
        }
        return true;
    }

    public V get(int i) {
        V v = null;
        if (i == 0) {
            if (this.hasZeroValue) {
                v = this.zeroValue;
            }
            return v;
        }
        int locateKey = locateKey(i);
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
        int[] iArr = this.keyTable;
        V[] vArr = this.valueTable;
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = iArr[i2];
            if (i3 != 0) {
                int i4 = (i3 * 31) + i;
                V v2 = vArr[i2];
                i = v2 != null ? v2.hashCode() + i4 : i4;
            }
        }
        return i;
    }

    public Iterator<Entry<V>> iterator() {
        return entries();
    }

    public final int locateKey(int i) {
        int[] iArr = this.keyTable;
        int i2 = (int) ((((long) i) * -7046029254386353131L) >>> this.shift);
        while (true) {
            int i3 = iArr[i2];
            if (i3 == 0) {
                return -(i2 + 1);
            }
            if (i3 == i) {
                return i2;
            }
            i2 = (i2 + 1) & this.mask;
        }
    }

    public int place(int i) {
        return (int) ((((long) i) * -7046029254386353131L) >>> this.shift);
    }

    public V put(int i, V v) {
        if (i == 0) {
            V v2 = this.zeroValue;
            this.zeroValue = v;
            if (!this.hasZeroValue) {
                this.hasZeroValue = true;
                this.size++;
            }
            return v2;
        }
        int locateKey = locateKey(i);
        if (locateKey >= 0) {
            V[] vArr = this.valueTable;
            V v3 = vArr[locateKey];
            vArr[locateKey] = v;
            return v3;
        }
        int i2 = -(locateKey + 1);
        int[] iArr = this.keyTable;
        iArr[i2] = i;
        this.valueTable[i2] = v;
        int i3 = this.size + 1;
        this.size = i3;
        if (i3 >= this.threshold) {
            int length = iArr.length << 1;
            int length2 = iArr.length;
            this.threshold = (int) (((float) length) * this.loadFactor);
            int i4 = length - 1;
            this.mask = i4;
            this.shift = Long.numberOfLeadingZeros((long) i4);
            int[] iArr2 = this.keyTable;
            V[] vArr2 = this.valueTable;
            this.keyTable = new int[length];
            this.valueTable = new Object[length];
            if (this.size > 0) {
                for (int i5 = 0; i5 < length2; i5++) {
                    int i6 = iArr2[i5];
                    if (i6 != 0) {
                        V v4 = vArr2[i5];
                        int[] iArr3 = this.keyTable;
                        int i7 = (int) ((((long) i6) * -7046029254386353131L) >>> this.shift);
                        while (iArr3[i7] != 0) {
                            i7 = (i7 + 1) & this.mask;
                        }
                        iArr3[i7] = i6;
                        this.valueTable[i7] = v4;
                    }
                }
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0043  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toString() {
        /*
            r7 = this;
            int r0 = r7.size
            if (r0 != 0) goto L_0x0007
            java.lang.String r0 = "[]"
            return r0
        L_0x0007:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = 32
            r0.<init>(r1)
            r1 = 91
            r0.append(r1)
            int[] r1 = r7.keyTable
            V[] r2 = r7.valueTable
            int r3 = r1.length
            boolean r4 = r7.hasZeroValue
            r5 = 61
            if (r4 == 0) goto L_0x0029
            java.lang.String r4 = "0="
            r0.append(r4)
            V r4 = r7.zeroValue
            r0.append(r4)
            goto L_0x003f
        L_0x0029:
            int r4 = r3 + -1
            if (r3 <= 0) goto L_0x003e
            r3 = r1[r4]
            if (r3 != 0) goto L_0x0033
            r3 = r4
            goto L_0x0029
        L_0x0033:
            r0.append(r3)
            r0.append(r5)
            r3 = r2[r4]
            r0.append(r3)
        L_0x003e:
            r3 = r4
        L_0x003f:
            int r4 = r3 + -1
            if (r3 <= 0) goto L_0x0059
            r3 = r1[r4]
            if (r3 != 0) goto L_0x0048
            goto L_0x003e
        L_0x0048:
            java.lang.String r6 = ", "
            r0.append(r6)
            r0.append(r3)
            r0.append(r5)
            r3 = r2[r4]
            r0.append(r3)
            goto L_0x003e
        L_0x0059:
            r1 = 93
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.utils.IntMap.toString():java.lang.String");
    }
}
