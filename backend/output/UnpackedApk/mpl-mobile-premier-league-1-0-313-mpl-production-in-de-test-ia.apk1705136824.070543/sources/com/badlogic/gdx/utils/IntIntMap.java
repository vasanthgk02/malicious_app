package com.badlogic.gdx.utils;

import in.juspay.hypersdk.core.InflateView;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class IntIntMap implements Iterable<Entry> {
    public transient Entries entries1;
    public transient Entries entries2;
    public boolean hasZeroValue;
    public int[] keyTable;
    public final float loadFactor;
    public int mask;
    public int shift;
    public int size;
    public int threshold;
    public int[] valueTable;
    public int zeroValue;

    public static class Entries extends MapIterator implements Iterable<Entry>, Iterator<Entry> {
        public final Entry entry = new Entry();

        public Entries(IntIntMap intIntMap) {
            super(intIntMap);
        }

        public boolean hasNext() {
            if (this.valid) {
                return this.hasNext;
            }
            throw new GdxRuntimeException((String) "#iterator() cannot be used nested.");
        }

        public Iterator<Entry> iterator() {
            return this;
        }

        public Object next() {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            } else if (this.valid) {
                IntIntMap intIntMap = this.map;
                int[] iArr = intIntMap.keyTable;
                int i = this.nextIndex;
                if (i == -1) {
                    Entry entry2 = this.entry;
                    entry2.key = 0;
                    entry2.value = intIntMap.zeroValue;
                } else {
                    Entry entry3 = this.entry;
                    entry3.key = iArr[i];
                    entry3.value = intIntMap.valueTable[i];
                }
                this.currentIndex = this.nextIndex;
                findNextIndex();
                return this.entry;
            } else {
                throw new GdxRuntimeException((String) "#iterator() cannot be used nested.");
            }
        }
    }

    public static class Entry {
        public int key;
        public int value;

        public String toString() {
            return this.key + InflateView.SETTER_EQUALS + this.value;
        }
    }

    public static class MapIterator {
        public int currentIndex;
        public boolean hasNext;
        public final IntIntMap map;
        public int nextIndex;
        public boolean valid = true;

        public MapIterator(IntIntMap intIntMap) {
            this.map = intIntMap;
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
                IntIntMap intIntMap = this.map;
                if (intIntMap.hasZeroValue) {
                    intIntMap.hasZeroValue = false;
                    this.currentIndex = -2;
                    IntIntMap intIntMap2 = this.map;
                    intIntMap2.size--;
                    return;
                }
            }
            if (i >= 0) {
                IntIntMap intIntMap3 = this.map;
                int[] iArr = intIntMap3.keyTable;
                int[] iArr2 = intIntMap3.valueTable;
                int i2 = intIntMap3.mask;
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
                        iArr2[i] = iArr2[i4];
                        i = i4;
                    }
                    i3 = i4 + 1;
                }
                iArr[i] = 0;
                if (i != this.currentIndex) {
                    this.nextIndex--;
                }
                this.currentIndex = -2;
                IntIntMap intIntMap22 = this.map;
                intIntMap22.size--;
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

    public IntIntMap() {
        this(51, 0.8f);
    }

    public boolean containsKey(int i) {
        if (i == 0) {
            return this.hasZeroValue;
        }
        return locateKey(i) >= 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof IntIntMap)) {
            return false;
        }
        IntIntMap intIntMap = (IntIntMap) obj;
        if (intIntMap.size != this.size) {
            return false;
        }
        boolean z = intIntMap.hasZeroValue;
        boolean z2 = this.hasZeroValue;
        if (z != z2) {
            return false;
        }
        if (z2 && intIntMap.zeroValue != this.zeroValue) {
            return false;
        }
        int[] iArr = this.keyTable;
        int[] iArr2 = this.valueTable;
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            int i2 = iArr[i];
            if (i2 != 0) {
                int i3 = intIntMap.get(i2, 0);
                if ((i3 == 0 && !intIntMap.containsKey(i2)) || i3 != iArr2[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public int get(int i, int i2) {
        if (i == 0) {
            if (this.hasZeroValue) {
                i2 = this.zeroValue;
            }
            return i2;
        }
        int locateKey = locateKey(i);
        if (locateKey >= 0) {
            i2 = this.valueTable[locateKey];
        }
        return i2;
    }

    public int hashCode() {
        int i = this.size;
        if (this.hasZeroValue) {
            i += this.zeroValue;
        }
        int[] iArr = this.keyTable;
        int[] iArr2 = this.valueTable;
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = iArr[i2];
            if (i3 != 0) {
                i = (i3 * 31) + iArr2[i2] + i;
            }
        }
        return i;
    }

    public Iterator<Entry> iterator() {
        if (this.entries1 == null) {
            this.entries1 = new Entries(this);
            this.entries2 = new Entries(this);
        }
        Entries entries = this.entries1;
        if (!entries.valid) {
            entries.reset();
            Entries entries3 = this.entries1;
            entries3.valid = true;
            this.entries2.valid = false;
            return entries3;
        }
        this.entries2.reset();
        Entries entries4 = this.entries2;
        entries4.valid = true;
        this.entries1.valid = false;
        return entries4;
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

    public void put(int i, int i2) {
        if (i == 0) {
            this.zeroValue = i2;
            if (!this.hasZeroValue) {
                this.hasZeroValue = true;
                this.size++;
            }
            return;
        }
        int locateKey = locateKey(i);
        if (locateKey >= 0) {
            this.valueTable[locateKey] = i2;
            return;
        }
        int i3 = -(locateKey + 1);
        int[] iArr = this.keyTable;
        iArr[i3] = i;
        this.valueTable[i3] = i2;
        int i4 = this.size + 1;
        this.size = i4;
        if (i4 >= this.threshold) {
            resize(iArr.length << 1);
        }
    }

    public final void resize(int i) {
        int length = this.keyTable.length;
        this.threshold = (int) (((float) i) * this.loadFactor);
        int i2 = i - 1;
        this.mask = i2;
        this.shift = Long.numberOfLeadingZeros((long) i2);
        int[] iArr = this.keyTable;
        int[] iArr2 = this.valueTable;
        this.keyTable = new int[i];
        this.valueTable = new int[i];
        if (this.size > 0) {
            for (int i3 = 0; i3 < length; i3++) {
                int i4 = iArr[i3];
                if (i4 != 0) {
                    int i5 = iArr2[i3];
                    int[] iArr3 = this.keyTable;
                    int i6 = (int) ((((long) i4) * -7046029254386353131L) >>> this.shift);
                    while (iArr3[i6] != 0) {
                        i6 = (i6 + 1) & this.mask;
                    }
                    iArr3[i6] = i4;
                    this.valueTable[i6] = i5;
                }
            }
        }
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
            int[] r2 = r7.valueTable
            int r3 = r1.length
            boolean r4 = r7.hasZeroValue
            r5 = 61
            if (r4 == 0) goto L_0x0029
            java.lang.String r4 = "0="
            r0.append(r4)
            int r4 = r7.zeroValue
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
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.utils.IntIntMap.toString():java.lang.String");
    }

    public IntIntMap(int i, float f2) {
        if (f2 <= 0.0f || f2 >= 1.0f) {
            throw new IllegalArgumentException("loadFactor must be > 0 and < 1: " + f2);
        }
        this.loadFactor = f2;
        int tableSize = ObjectSet.tableSize(i, f2);
        this.threshold = (int) (((float) tableSize) * f2);
        int i2 = tableSize - 1;
        this.mask = i2;
        this.shift = Long.numberOfLeadingZeros((long) i2);
        this.keyTable = new int[tableSize];
        this.valueTable = new int[tableSize];
    }
}
