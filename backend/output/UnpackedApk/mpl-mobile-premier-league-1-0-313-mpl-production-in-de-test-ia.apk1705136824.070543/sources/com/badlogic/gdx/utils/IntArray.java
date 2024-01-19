package com.badlogic.gdx.utils;

import com.android.tools.r8.GeneratedOutlineSupport;
import okhttp3.HttpUrl;

public class IntArray {
    public int[] items;
    public boolean ordered;
    public int size;

    public IntArray() {
        this.ordered = true;
        this.items = new int[16];
    }

    public void add(int i) {
        int[] iArr = this.items;
        int i2 = this.size;
        if (i2 == iArr.length) {
            iArr = resize(Math.max(8, (int) (((float) i2) * 1.75f)));
        }
        int i3 = this.size;
        this.size = i3 + 1;
        iArr[i3] = i;
    }

    public int[] ensureCapacity(int i) {
        if (i >= 0) {
            int i2 = this.size + i;
            if (i2 > this.items.length) {
                resize(Math.max(Math.max(8, i2), (int) (((float) this.size) * 1.75f)));
            }
            return this.items;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("additionalCapacity must be >= 0: ", i));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!this.ordered || !(obj instanceof IntArray)) {
            return false;
        }
        IntArray intArray = (IntArray) obj;
        if (!intArray.ordered) {
            return false;
        }
        int i = this.size;
        if (i != intArray.size) {
            return false;
        }
        int[] iArr = this.items;
        int[] iArr2 = intArray.items;
        for (int i2 = 0; i2 < i; i2++) {
            if (iArr[i2] != iArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    public int get(int i) {
        if (i < this.size) {
            return this.items[i];
        }
        StringBuilder outline74 = GeneratedOutlineSupport.outline74("index can't be >= size: ", i, " >= ");
        outline74.append(this.size);
        throw new IndexOutOfBoundsException(outline74.toString());
    }

    public int hashCode() {
        if (!this.ordered) {
            return super.hashCode();
        }
        int[] iArr = this.items;
        int i = this.size;
        int i2 = 1;
        for (int i3 = 0; i3 < i; i3++) {
            i2 = (i2 * 31) + iArr[i3];
        }
        return i2;
    }

    public void insert(int i, int i2) {
        int i3 = this.size;
        if (i <= i3) {
            int[] iArr = this.items;
            if (i3 == iArr.length) {
                iArr = resize(Math.max(8, (int) (((float) i3) * 1.75f)));
            }
            if (this.ordered) {
                System.arraycopy(iArr, i, iArr, i + 1, this.size - i);
            } else {
                iArr[this.size] = iArr[i];
            }
            this.size++;
            iArr[i] = i2;
            return;
        }
        StringBuilder outline74 = GeneratedOutlineSupport.outline74("index can't be > size: ", i, " > ");
        outline74.append(this.size);
        throw new IndexOutOfBoundsException(outline74.toString());
    }

    public int pop() {
        int[] iArr = this.items;
        int i = this.size - 1;
        this.size = i;
        return iArr[i];
    }

    public int[] resize(int i) {
        int[] iArr = new int[i];
        System.arraycopy(this.items, 0, iArr, 0, Math.min(this.size, i));
        this.items = iArr;
        return iArr;
    }

    public String toString() {
        if (this.size == 0) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        int[] iArr = this.items;
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append0('[');
        stringBuilder.append(iArr[0]);
        for (int i = 1; i < this.size; i++) {
            stringBuilder.append0((String) ", ");
            stringBuilder.append(iArr[i]);
        }
        stringBuilder.append0(']');
        return stringBuilder.toString();
    }

    public IntArray(int i) {
        this.ordered = true;
        this.items = new int[i];
    }
}
