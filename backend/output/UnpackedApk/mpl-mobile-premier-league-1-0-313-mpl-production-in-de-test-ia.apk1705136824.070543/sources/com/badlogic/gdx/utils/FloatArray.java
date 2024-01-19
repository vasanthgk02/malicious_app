package com.badlogic.gdx.utils;

import com.android.tools.r8.GeneratedOutlineSupport;
import okhttp3.HttpUrl;

public class FloatArray {
    public float[] items;
    public boolean ordered;
    public int size;

    public FloatArray() {
        this.ordered = true;
        this.items = new float[16];
    }

    public void add(float f2) {
        float[] fArr = this.items;
        int i = this.size;
        if (i == fArr.length) {
            fArr = resize(Math.max(8, (int) (((float) i) * 1.75f)));
        }
        int i2 = this.size;
        this.size = i2 + 1;
        fArr[i2] = f2;
    }

    public void addAll(FloatArray floatArray, int i, int i2) {
        if (i + i2 <= floatArray.size) {
            addAll(floatArray.items, i, i2);
            return;
        }
        StringBuilder outline75 = GeneratedOutlineSupport.outline75("offset + length must be <= size: ", i, " + ", i2, " <= ");
        outline75.append(floatArray.size);
        throw new IllegalArgumentException(outline75.toString());
    }

    public float[] ensureCapacity(int i) {
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
        if (!this.ordered || !(obj instanceof FloatArray)) {
            return false;
        }
        FloatArray floatArray = (FloatArray) obj;
        if (!floatArray.ordered) {
            return false;
        }
        int i = this.size;
        if (i != floatArray.size) {
            return false;
        }
        float[] fArr = this.items;
        float[] fArr2 = floatArray.items;
        for (int i2 = 0; i2 < i; i2++) {
            if (fArr[i2] != fArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    public float get(int i) {
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
        float[] fArr = this.items;
        int i = this.size;
        int i2 = 1;
        for (int i3 = 0; i3 < i; i3++) {
            i2 = (i2 * 31) + Float.floatToRawIntBits(fArr[i3]);
        }
        return i2;
    }

    public void removeRange(int i, int i2) {
        int i3 = this.size;
        if (i2 >= i3) {
            StringBuilder outline74 = GeneratedOutlineSupport.outline74("end can't be >= size: ", i2, " >= ");
            outline74.append(this.size);
            throw new IndexOutOfBoundsException(outline74.toString());
        } else if (i <= i2) {
            int i4 = (i2 - i) + 1;
            int i5 = i3 - i4;
            if (this.ordered) {
                float[] fArr = this.items;
                int i6 = i4 + i;
                System.arraycopy(fArr, i6, fArr, i, i3 - i6);
            } else {
                int max = Math.max(i5, i2 + 1);
                float[] fArr2 = this.items;
                System.arraycopy(fArr2, max, fArr2, i, i3 - max);
            }
            this.size = i5;
        } else {
            throw new IndexOutOfBoundsException(GeneratedOutlineSupport.outline43("start can't be > end: ", i, " > ", i2));
        }
    }

    public float[] resize(int i) {
        float[] fArr = new float[i];
        System.arraycopy(this.items, 0, fArr, 0, Math.min(this.size, i));
        this.items = fArr;
        return fArr;
    }

    public String toString() {
        if (this.size == 0) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        float[] fArr = this.items;
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append0('[');
        stringBuilder.append0(Float.toString(fArr[0]));
        for (int i = 1; i < this.size; i++) {
            stringBuilder.append0((String) ", ");
            stringBuilder.append0(Float.toString(fArr[i]));
        }
        stringBuilder.append0(']');
        return stringBuilder.toString();
    }

    public void truncate(int i) {
        if (this.size > i) {
            this.size = i;
        }
    }

    public FloatArray(int i) {
        this.ordered = true;
        this.items = new float[i];
    }

    public void addAll(float[] fArr, int i, int i2) {
        float[] fArr2 = this.items;
        int i3 = this.size + i2;
        if (i3 > fArr2.length) {
            fArr2 = resize(Math.max(Math.max(8, i3), (int) (((float) this.size) * 1.75f)));
        }
        System.arraycopy(fArr, i, fArr2, this.size, i2);
        this.size += i2;
    }
}
