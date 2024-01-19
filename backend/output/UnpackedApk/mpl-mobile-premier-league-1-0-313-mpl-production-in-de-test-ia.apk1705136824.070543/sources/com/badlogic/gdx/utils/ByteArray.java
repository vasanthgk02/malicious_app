package com.badlogic.gdx.utils;

import com.android.tools.r8.GeneratedOutlineSupport;
import okhttp3.HttpUrl;

public class ByteArray {
    public byte[] items;
    public boolean ordered;
    public int size;

    public ByteArray() {
        this.ordered = true;
        this.items = new byte[16];
    }

    public byte[] ensureCapacity(int i) {
        if (i >= 0) {
            int i2 = i + 0;
            if (i2 > this.items.length) {
                int max = Math.max(Math.max(8, i2), (int) (((float) 0) * 1.75f));
                byte[] bArr = new byte[max];
                System.arraycopy(this.items, 0, bArr, 0, Math.min(0, max));
                this.items = bArr;
            }
            return this.items;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("additionalCapacity must be >= 0: ", i));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!this.ordered || !(obj instanceof ByteArray)) {
            return false;
        }
        ByteArray byteArray = (ByteArray) obj;
        return byteArray.ordered && byteArray.size == 0;
    }

    public int hashCode() {
        if (!this.ordered) {
            return super.hashCode();
        }
        return 1;
    }

    public String toString() {
        return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    }

    public ByteArray(int i) {
        this.ordered = true;
        this.items = new byte[i];
    }
}
