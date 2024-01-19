package io.reactivex.internal.util;

public final class OpenHashSet<T> {
    public T[] keys;
    public final float loadFactor = 0.75f;
    public int mask;
    public int maxSize;
    public int size;

    public OpenHashSet() {
        int numberOfLeadingZeros = 1 << (32 - Integer.numberOfLeadingZeros(15));
        this.mask = numberOfLeadingZeros - 1;
        this.maxSize = (int) (0.75f * ((float) numberOfLeadingZeros));
        this.keys = new Object[numberOfLeadingZeros];
    }

    public static int mix(int i) {
        int i2 = i * -1640531527;
        return i2 ^ (i2 >>> 16);
    }

    public boolean add(T t) {
        T t2;
        T[] tArr = this.keys;
        int i = this.mask;
        int mix = mix(t.hashCode()) & i;
        T t3 = tArr[mix];
        if (t3 != null) {
            if (t3.equals(t)) {
                return false;
            }
            do {
                mix = (mix + 1) & i;
                t2 = tArr[mix];
                if (t2 == null) {
                }
            } while (!t2.equals(t));
            return false;
        }
        tArr[mix] = t;
        int i2 = this.size + 1;
        this.size = i2;
        if (i2 >= this.maxSize) {
            T[] tArr2 = this.keys;
            int length = tArr2.length;
            int i3 = length << 1;
            int i4 = i3 - 1;
            T[] tArr3 = new Object[i3];
            while (true) {
                int i5 = i2 - 1;
                if (i2 == 0) {
                    break;
                }
                do {
                    length--;
                } while (tArr2[length] == null);
                int mix2 = mix(tArr2[length].hashCode()) & i4;
                if (tArr3[mix2] != null) {
                    do {
                        mix2 = (mix2 + 1) & i4;
                    } while (tArr3[mix2] != null);
                }
                tArr3[mix2] = tArr2[length];
                i2 = i5;
            }
            this.mask = i4;
            this.maxSize = (int) (((float) i3) * this.loadFactor);
            this.keys = tArr3;
        }
        return true;
    }

    public boolean removeEntry(int i, T[] tArr, int i2) {
        int i3;
        T t;
        this.size--;
        while (true) {
            int i4 = i + 1;
            while (true) {
                i3 = i4 & i2;
                t = tArr[i3];
                if (t == null) {
                    tArr[i] = null;
                    return true;
                }
                int mix = mix(t.hashCode()) & i2;
                if (i <= i3) {
                    if (i >= mix || mix > i3) {
                        break;
                    }
                    i4 = i3 + 1;
                } else {
                    if (i >= mix && mix > i3) {
                        break;
                    }
                    i4 = i3 + 1;
                }
            }
            tArr[i] = t;
            i = i3;
        }
    }
}
