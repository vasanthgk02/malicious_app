package com.badlogic.gdx.utils;

import com.badlogic.gdx.utils.ObjectMap.Entry;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayMap<K, V> implements Iterable<Entry<K, V>> {
    public transient Entries entries1;
    public transient Entries entries2;
    public K[] keys;
    public boolean ordered;
    public int size;
    public V[] values;

    public static class Entries<K, V> implements Iterable<Entry<K, V>>, Iterator<Entry<K, V>> {
        public Entry<K, V> entry = new Entry<>();
        public int index;
        public final ArrayMap<K, V> map;
        public boolean valid = true;

        public Entries(ArrayMap<K, V> arrayMap) {
            this.map = arrayMap;
        }

        public boolean hasNext() {
            if (this.valid) {
                return this.index < this.map.size;
            }
            throw new GdxRuntimeException((String) "#iterator() cannot be used nested.");
        }

        public Iterator<Entry<K, V>> iterator() {
            return this;
        }

        public Object next() {
            int i = this.index;
            ArrayMap<K, V> arrayMap = this.map;
            if (i >= arrayMap.size) {
                throw new NoSuchElementException(String.valueOf(this.index));
            } else if (this.valid) {
                Entry<K, V> entry2 = this.entry;
                entry2.key = arrayMap.keys[i];
                V[] vArr = arrayMap.values;
                this.index = i + 1;
                entry2.value = vArr[i];
                return entry2;
            } else {
                throw new GdxRuntimeException((String) "#iterator() cannot be used nested.");
            }
        }

        public void remove() {
            int i = this.index - 1;
            this.index = i;
            ArrayMap<K, V> arrayMap = this.map;
            int i2 = arrayMap.size;
            if (i < i2) {
                K[] kArr = arrayMap.keys;
                int i3 = i2 - 1;
                arrayMap.size = i3;
                if (arrayMap.ordered) {
                    int i4 = i + 1;
                    System.arraycopy(kArr, i4, kArr, i, i3 - i);
                    V[] vArr = arrayMap.values;
                    System.arraycopy(vArr, i4, vArr, i, arrayMap.size - i);
                } else {
                    kArr[i] = kArr[i3];
                    V[] vArr2 = arrayMap.values;
                    vArr2[i] = vArr2[i3];
                }
                int i5 = arrayMap.size;
                kArr[i5] = null;
                arrayMap.values[i5] = null;
                return;
            }
            throw new IndexOutOfBoundsException(String.valueOf(i));
        }
    }

    public ArrayMap() {
        this.ordered = true;
        this.keys = new Object[16];
        this.values = new Object[16];
    }

    public Entries<K, V> entries() {
        if (this.entries1 == null) {
            this.entries1 = new Entries(this);
            this.entries2 = new Entries(this);
        }
        Entries<K, V> entries = this.entries1;
        if (!entries.valid) {
            entries.index = 0;
            entries.valid = true;
            this.entries2.valid = false;
            return entries;
        }
        Entries<K, V> entries3 = this.entries2;
        entries3.index = 0;
        entries3.valid = true;
        entries.valid = false;
        return entries3;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ArrayMap)) {
            return false;
        }
        ArrayMap arrayMap = (ArrayMap) obj;
        int i = arrayMap.size;
        int i2 = this.size;
        if (i != i2) {
            return false;
        }
        K[] kArr = this.keys;
        V[] vArr = this.values;
        for (int i3 = 0; i3 < i2; i3++) {
            K k = kArr[i3];
            V v = vArr[i3];
            if (v == null) {
                if (arrayMap.get(k, ObjectMap.dummy) != null) {
                    return false;
                }
            } else if (!v.equals(arrayMap.get(k, null))) {
                return false;
            }
        }
        return true;
    }

    public V get(K k, V v) {
        K[] kArr = this.keys;
        int i = this.size - 1;
        if (k == null) {
            while (i >= 0) {
                if (kArr[i] == k) {
                    return this.values[i];
                }
                i--;
            }
        } else {
            while (i >= 0) {
                if (k.equals(kArr[i])) {
                    return this.values[i];
                }
                i--;
            }
        }
        return v;
    }

    public int hashCode() {
        K[] kArr = this.keys;
        V[] vArr = this.values;
        int i = this.size;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            K k = kArr[i3];
            V v = vArr[i3];
            if (k != null) {
                i2 += k.hashCode() * 31;
            }
            if (v != null) {
                i2 = v.hashCode() + i2;
            }
        }
        return i2;
    }

    public Iterator<Entry<K, V>> iterator() {
        return entries();
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int put(K r6, V r7) {
        /*
            r5 = this;
            K[] r0 = r5.keys
            r1 = 0
            r2 = -1
            if (r6 != 0) goto L_0x0012
            int r3 = r5.size
        L_0x0008:
            if (r1 >= r3) goto L_0x0022
            r4 = r0[r1]
            if (r4 != r6) goto L_0x000f
            goto L_0x0023
        L_0x000f:
            int r1 = r1 + 1
            goto L_0x0008
        L_0x0012:
            int r3 = r5.size
        L_0x0014:
            if (r1 >= r3) goto L_0x0022
            r4 = r0[r1]
            boolean r4 = r6.equals(r4)
            if (r4 == 0) goto L_0x001f
            goto L_0x0023
        L_0x001f:
            int r1 = r1 + 1
            goto L_0x0014
        L_0x0022:
            r1 = -1
        L_0x0023:
            if (r1 != r2) goto L_0x0041
            int r0 = r5.size
            K[] r1 = r5.keys
            int r1 = r1.length
            if (r0 != r1) goto L_0x003b
            r1 = 8
            float r0 = (float) r0
            r2 = 1071644672(0x3fe00000, float:1.75)
            float r0 = r0 * r2
            int r0 = (int) r0
            int r0 = java.lang.Math.max(r1, r0)
            r5.resize(r0)
        L_0x003b:
            int r1 = r5.size
            int r0 = r1 + 1
            r5.size = r0
        L_0x0041:
            K[] r0 = r5.keys
            r0[r1] = r6
            V[] r6 = r5.values
            r6[r1] = r7
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.utils.ArrayMap.put(java.lang.Object, java.lang.Object):int");
    }

    public void resize(int i) {
        K[] kArr = (Object[]) Array.newInstance(this.keys.getClass().getComponentType(), i);
        System.arraycopy(this.keys, 0, kArr, 0, Math.min(this.size, kArr.length));
        this.keys = kArr;
        V[] vArr = (Object[]) Array.newInstance(this.values.getClass().getComponentType(), i);
        System.arraycopy(this.values, 0, vArr, 0, Math.min(this.size, vArr.length));
        this.values = vArr;
    }

    public String toString() {
        if (this.size == 0) {
            return "{}";
        }
        K[] kArr = this.keys;
        V[] vArr = this.values;
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append0('{');
        stringBuilder.append((Object) kArr[0]);
        stringBuilder.append0('=');
        stringBuilder.append((Object) vArr[0]);
        for (int i = 1; i < this.size; i++) {
            stringBuilder.append0((String) ", ");
            stringBuilder.append((Object) kArr[i]);
            stringBuilder.append0('=');
            stringBuilder.append((Object) vArr[i]);
        }
        stringBuilder.append0('}');
        return stringBuilder.toString();
    }

    public ArrayMap(boolean z, int i, Class cls, Class cls2) {
        this.ordered = z;
        this.keys = (Object[]) Array.newInstance(cls, i);
        this.values = (Object[]) Array.newInstance(cls2, i);
    }
}
