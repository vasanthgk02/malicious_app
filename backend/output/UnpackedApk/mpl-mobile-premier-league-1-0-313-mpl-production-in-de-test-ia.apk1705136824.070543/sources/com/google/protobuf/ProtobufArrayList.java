package com.google.protobuf;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.protobuf.Internal.ProtobufList;
import java.util.Arrays;
import java.util.RandomAccess;

public final class ProtobufArrayList<E> extends AbstractProtobufList<E> implements RandomAccess {
    public static final ProtobufArrayList<Object> EMPTY_LIST;
    public E[] array;
    public int size;

    static {
        ProtobufArrayList<Object> protobufArrayList = new ProtobufArrayList<>(new Object[0], 0);
        EMPTY_LIST = protobufArrayList;
        protobufArrayList.isMutable = false;
    }

    public ProtobufArrayList(E[] eArr, int i) {
        this.array = eArr;
        this.size = i;
    }

    public boolean add(E e2) {
        ensureIsMutable();
        int i = this.size;
        E[] eArr = this.array;
        if (i == eArr.length) {
            this.array = Arrays.copyOf(eArr, ((i * 3) / 2) + 1);
        }
        E[] eArr2 = this.array;
        int i2 = this.size;
        this.size = i2 + 1;
        eArr2[i2] = e2;
        this.modCount++;
        return true;
    }

    public final void ensureIndexInRange(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(i));
        }
    }

    public E get(int i) {
        ensureIndexInRange(i);
        return this.array[i];
    }

    public final String makeOutOfBoundsExceptionMessage(int i) {
        StringBuilder outline74 = GeneratedOutlineSupport.outline74("Index:", i, ", Size:");
        outline74.append(this.size);
        return outline74.toString();
    }

    public ProtobufList mutableCopyWithCapacity(int i) {
        if (i >= this.size) {
            return new ProtobufArrayList(Arrays.copyOf(this.array, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public E remove(int i) {
        ensureIsMutable();
        ensureIndexInRange(i);
        E[] eArr = this.array;
        E e2 = eArr[i];
        int i2 = this.size;
        if (i < i2 - 1) {
            System.arraycopy(eArr, i + 1, eArr, i, (i2 - i) - 1);
        }
        this.size--;
        this.modCount++;
        return e2;
    }

    public E set(int i, E e2) {
        ensureIsMutable();
        ensureIndexInRange(i);
        E[] eArr = this.array;
        E e3 = eArr[i];
        eArr[i] = e2;
        this.modCount++;
        return e3;
    }

    public int size() {
        return this.size;
    }

    public void add(int i, E e2) {
        ensureIsMutable();
        if (i >= 0) {
            int i2 = this.size;
            if (i <= i2) {
                E[] eArr = this.array;
                if (i2 < eArr.length) {
                    System.arraycopy(eArr, i, eArr, i + 1, i2 - i);
                } else {
                    E[] eArr2 = new Object[GeneratedOutlineSupport.outline8(i2, 3, 2, 1)];
                    System.arraycopy(eArr, 0, eArr2, 0, i);
                    System.arraycopy(this.array, i, eArr2, i + 1, this.size - i);
                    this.array = eArr2;
                }
                this.array[i] = e2;
                this.size++;
                this.modCount++;
                return;
            }
        }
        throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(i));
    }
}
