package com.badlogic.gdx.utils;

public class IntSet {
    public boolean hasZeroValue;
    public transient IntSetIterator iterator1;
    public transient IntSetIterator iterator2;
    public int[] keyTable;
    public final float loadFactor = 0.8f;
    public int mask;
    public int shift;
    public int size;
    public int threshold;

    public static class IntSetIterator {
        public boolean hasNext;
        public int nextIndex;
        public final IntSet set;
        public boolean valid = true;

        public IntSetIterator(IntSet intSet) {
            this.set = intSet;
            reset();
        }

        public void findNextIndex() {
            int i;
            int[] iArr = this.set.keyTable;
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

        public void reset() {
            this.nextIndex = -1;
            if (this.set.hasZeroValue) {
                this.hasNext = true;
            } else {
                findNextIndex();
            }
        }
    }

    public IntSet() {
        int tableSize = ObjectSet.tableSize(51, 0.8f);
        this.threshold = (int) (((float) tableSize) * 0.8f);
        int i = tableSize - 1;
        this.mask = i;
        this.shift = Long.numberOfLeadingZeros((long) i);
        this.keyTable = new int[tableSize];
    }

    public boolean add(int i) {
        if (i != 0) {
            int locateKey = locateKey(i);
            if (locateKey >= 0) {
                return false;
            }
            int[] iArr = this.keyTable;
            iArr[-(locateKey + 1)] = i;
            int i2 = this.size + 1;
            this.size = i2;
            if (i2 >= this.threshold) {
                int length = iArr.length << 1;
                int length2 = iArr.length;
                this.threshold = (int) (((float) length) * this.loadFactor);
                int i3 = length - 1;
                this.mask = i3;
                this.shift = Long.numberOfLeadingZeros((long) i3);
                int[] iArr2 = this.keyTable;
                this.keyTable = new int[length];
                if (this.size > 0) {
                    for (int i4 = 0; i4 < length2; i4++) {
                        int i5 = iArr2[i4];
                        if (i5 != 0) {
                            int[] iArr3 = this.keyTable;
                            int i6 = (int) ((((long) i5) * -7046029254386353131L) >>> this.shift);
                            while (iArr3[i6] != 0) {
                                i6 = (i6 + 1) & this.mask;
                            }
                            iArr3[i6] = i5;
                        }
                    }
                }
            }
            return true;
        } else if (this.hasZeroValue) {
            return false;
        } else {
            this.hasZeroValue = true;
            this.size++;
            return true;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof IntSet)) {
            return false;
        }
        IntSet intSet = (IntSet) obj;
        if (intSet.size != this.size || intSet.hasZeroValue != this.hasZeroValue) {
            return false;
        }
        int[] iArr = this.keyTable;
        int length = iArr.length;
        int i = 0;
        while (true) {
            boolean z = true;
            if (i >= length) {
                return true;
            }
            if (iArr[i] != 0) {
                int i2 = iArr[i];
                if (i2 == 0) {
                    z = intSet.hasZeroValue;
                } else if (intSet.locateKey(i2) < 0) {
                    z = false;
                }
                if (!z) {
                    return false;
                }
            }
            i++;
        }
    }

    public int hashCode() {
        int i = this.size;
        for (int i2 : this.keyTable) {
            if (i2 != 0) {
                i += i2;
            }
        }
        return i;
    }

    public IntSetIterator iterator() {
        if (this.iterator1 == null) {
            this.iterator1 = new IntSetIterator(this);
            this.iterator2 = new IntSetIterator(this);
        }
        IntSetIterator intSetIterator = this.iterator1;
        if (!intSetIterator.valid) {
            intSetIterator.reset();
            IntSetIterator intSetIterator2 = this.iterator1;
            intSetIterator2.valid = true;
            this.iterator2.valid = false;
            return intSetIterator2;
        }
        this.iterator2.reset();
        IntSetIterator intSetIterator3 = this.iterator2;
        intSetIterator3.valid = true;
        this.iterator1.valid = false;
        return intSetIterator3;
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

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0032  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toString() {
        /*
            r5 = this;
            int r0 = r5.size
            if (r0 != 0) goto L_0x0007
            java.lang.String r0 = "[]"
            return r0
        L_0x0007:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = 32
            r0.<init>(r1)
            r1 = 91
            r0.append(r1)
            int[] r1 = r5.keyTable
            int r2 = r1.length
            boolean r3 = r5.hasZeroValue
            if (r3 == 0) goto L_0x0020
            java.lang.String r3 = "0"
            r0.append(r3)
            goto L_0x002e
        L_0x0020:
            int r3 = r2 + -1
            if (r2 <= 0) goto L_0x002d
            r2 = r1[r3]
            if (r2 != 0) goto L_0x002a
            r2 = r3
            goto L_0x0020
        L_0x002a:
            r0.append(r2)
        L_0x002d:
            r2 = r3
        L_0x002e:
            int r3 = r2 + -1
            if (r2 <= 0) goto L_0x0040
            r2 = r1[r3]
            if (r2 != 0) goto L_0x0037
            goto L_0x002d
        L_0x0037:
            java.lang.String r4 = ", "
            r0.append(r4)
            r0.append(r2)
            goto L_0x002d
        L_0x0040:
            r1 = 93
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.utils.IntSet.toString():java.lang.String");
    }
}
