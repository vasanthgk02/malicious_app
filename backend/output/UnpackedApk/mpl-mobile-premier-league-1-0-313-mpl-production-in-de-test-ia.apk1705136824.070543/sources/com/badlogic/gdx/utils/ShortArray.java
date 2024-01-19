package com.badlogic.gdx.utils;

import com.android.tools.r8.GeneratedOutlineSupport;
import okhttp3.HttpUrl;

public class ShortArray {
    public short[] items = new short[16];
    public boolean ordered = true;
    public int size;

    public void add(short s) {
        short[] sArr = this.items;
        int i = this.size;
        if (i == sArr.length) {
            int max = Math.max(8, (int) (((float) i) * 1.75f));
            short[] sArr2 = new short[max];
            System.arraycopy(this.items, 0, sArr2, 0, Math.min(this.size, max));
            this.items = sArr2;
            sArr = sArr2;
        }
        int i2 = this.size;
        this.size = i2 + 1;
        sArr[i2] = s;
    }

    public short[] ensureCapacity(int i) {
        if (i >= 0) {
            int i2 = this.size + i;
            if (i2 > this.items.length) {
                int max = Math.max(Math.max(8, i2), (int) (((float) this.size) * 1.75f));
                short[] sArr = new short[max];
                System.arraycopy(this.items, 0, sArr, 0, Math.min(this.size, max));
                this.items = sArr;
            }
            return this.items;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("additionalCapacity must be >= 0: ", i));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!this.ordered || !(obj instanceof ShortArray)) {
            return false;
        }
        ShortArray shortArray = (ShortArray) obj;
        if (!shortArray.ordered) {
            return false;
        }
        int i = this.size;
        if (i != shortArray.size) {
            return false;
        }
        short[] sArr = this.items;
        short[] sArr2 = shortArray.items;
        for (int i2 = 0; i2 < i; i2++) {
            if (sArr[i2] != sArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    public short get(int i) {
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
        short[] sArr = this.items;
        int i = this.size;
        int i2 = 1;
        for (int i3 = 0; i3 < i; i3++) {
            i2 = (i2 * 31) + sArr[i3];
        }
        return i2;
    }

    public String toString() {
        if (this.size == 0) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        short[] sArr = this.items;
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append0('[');
        stringBuilder.append((int) sArr[0]);
        for (int i = 1; i < this.size; i++) {
            stringBuilder.append0((String) ", ");
            stringBuilder.append((int) sArr[i]);
        }
        stringBuilder.append0(']');
        return stringBuilder.toString();
    }
}
