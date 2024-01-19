package com.google.protobuf;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.protobuf.Internal.IntList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

public final class IntArrayList extends AbstractProtobufList<Integer> implements IntList, RandomAccess, PrimitiveNonBoxingCollection {
    public static final IntArrayList EMPTY_LIST;
    public int[] array;
    public int size;

    static {
        IntArrayList intArrayList = new IntArrayList(new int[0], 0);
        EMPTY_LIST = intArrayList;
        intArrayList.isMutable = false;
    }

    public IntArrayList() {
        this.array = new int[10];
        this.size = 0;
    }

    public void add(int i, Object obj) {
        int intValue = ((Integer) obj).intValue();
        ensureIsMutable();
        if (i >= 0) {
            int i2 = this.size;
            if (i <= i2) {
                int[] iArr = this.array;
                if (i2 < iArr.length) {
                    System.arraycopy(iArr, i, iArr, i + 1, i2 - i);
                } else {
                    int[] iArr2 = new int[GeneratedOutlineSupport.outline8(i2, 3, 2, 1)];
                    System.arraycopy(iArr, 0, iArr2, 0, i);
                    System.arraycopy(this.array, i, iArr2, i + 1, this.size - i);
                    this.array = iArr2;
                }
                this.array[i] = intValue;
                this.size++;
                this.modCount++;
                return;
            }
        }
        throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(i));
    }

    public boolean addAll(Collection<? extends Integer> collection) {
        ensureIsMutable();
        Internal.checkNotNull(collection);
        if (!(collection instanceof IntArrayList)) {
            return super.addAll(collection);
        }
        IntArrayList intArrayList = (IntArrayList) collection;
        int i = intArrayList.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            int[] iArr = this.array;
            if (i3 > iArr.length) {
                this.array = Arrays.copyOf(iArr, i3);
            }
            System.arraycopy(intArrayList.array, 0, this.array, this.size, intArrayList.size);
            this.size = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public void addInt(int i) {
        ensureIsMutable();
        int i2 = this.size;
        int[] iArr = this.array;
        if (i2 == iArr.length) {
            int[] iArr2 = new int[GeneratedOutlineSupport.outline8(i2, 3, 2, 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.array = iArr2;
        }
        int[] iArr3 = this.array;
        int i3 = this.size;
        this.size = i3 + 1;
        iArr3[i3] = i;
    }

    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void ensureIndexInRange(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(i));
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IntArrayList)) {
            return super.equals(obj);
        }
        IntArrayList intArrayList = (IntArrayList) obj;
        if (this.size != intArrayList.size) {
            return false;
        }
        int[] iArr = intArrayList.array;
        for (int i = 0; i < this.size; i++) {
            if (this.array[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    public Object get(int i) {
        ensureIndexInRange(i);
        return Integer.valueOf(this.array[i]);
    }

    public int getInt(int i) {
        ensureIndexInRange(i);
        return this.array[i];
    }

    public int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + this.array[i2];
        }
        return i;
    }

    public int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int intValue = ((Integer) obj).intValue();
        int i = this.size;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.array[i2] == intValue) {
                return i2;
            }
        }
        return -1;
    }

    public final String makeOutOfBoundsExceptionMessage(int i) {
        StringBuilder outline74 = GeneratedOutlineSupport.outline74("Index:", i, ", Size:");
        outline74.append(this.size);
        return outline74.toString();
    }

    public Object remove(int i) {
        ensureIsMutable();
        ensureIndexInRange(i);
        int[] iArr = this.array;
        int i2 = iArr[i];
        int i3 = this.size;
        if (i < i3 - 1) {
            System.arraycopy(iArr, i + 1, iArr, i, (i3 - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Integer.valueOf(i2);
    }

    public void removeRange(int i, int i2) {
        ensureIsMutable();
        if (i2 >= i) {
            int[] iArr = this.array;
            System.arraycopy(iArr, i2, iArr, i, this.size - i2);
            this.size -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public Object set(int i, Object obj) {
        int intValue = ((Integer) obj).intValue();
        ensureIsMutable();
        ensureIndexInRange(i);
        int[] iArr = this.array;
        int i2 = iArr[i];
        iArr[i] = intValue;
        return Integer.valueOf(i2);
    }

    public int size() {
        return this.size;
    }

    public IntList mutableCopyWithCapacity(int i) {
        if (i >= this.size) {
            return new IntArrayList(Arrays.copyOf(this.array, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public IntArrayList(int[] iArr, int i) {
        this.array = iArr;
        this.size = i;
    }

    public boolean add(Object obj) {
        addInt(((Integer) obj).intValue());
        return true;
    }
}
