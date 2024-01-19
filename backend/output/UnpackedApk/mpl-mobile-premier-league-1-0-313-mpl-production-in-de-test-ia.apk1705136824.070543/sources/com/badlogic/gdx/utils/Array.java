package com.badlogic.gdx.utils;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.math.MathUtils;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import okhttp3.HttpUrl;

public class Array<T> implements Iterable<T> {
    public T[] items;
    public ArrayIterable iterable;
    public boolean ordered;
    public int size;

    public static class ArrayIterable<T> implements Iterable<T> {
        public final boolean allowRemove = true;
        public final Array<T> array;
        public ArrayIterator iterator1;
        public ArrayIterator iterator2;

        public ArrayIterable(Array<T> array2) {
            this.array = array2;
        }

        public ArrayIterator<T> iterator() {
            if (this.iterator1 == null) {
                this.iterator1 = new ArrayIterator(this.array, this.allowRemove);
                this.iterator2 = new ArrayIterator(this.array, this.allowRemove);
            }
            ArrayIterator<T> arrayIterator = this.iterator1;
            if (!arrayIterator.valid) {
                arrayIterator.index = 0;
                arrayIterator.valid = true;
                this.iterator2.valid = false;
                return arrayIterator;
            }
            ArrayIterator<T> arrayIterator2 = this.iterator2;
            arrayIterator2.index = 0;
            arrayIterator2.valid = true;
            arrayIterator.valid = false;
            return arrayIterator2;
        }
    }

    public static class ArrayIterator<T> implements Iterator<T>, Iterable<T> {
        public final boolean allowRemove;
        public final Array<T> array;
        public int index;
        public boolean valid = true;

        public ArrayIterator(Array<T> array2, boolean z) {
            this.array = array2;
            this.allowRemove = z;
        }

        public boolean hasNext() {
            if (this.valid) {
                return this.index < this.array.size;
            }
            throw new GdxRuntimeException((String) "#iterator() cannot be used nested.");
        }

        public Iterator iterator() {
            return this;
        }

        public T next() {
            int i = this.index;
            Array<T> array2 = this.array;
            if (i >= array2.size) {
                throw new NoSuchElementException(String.valueOf(this.index));
            } else if (this.valid) {
                T[] tArr = array2.items;
                this.index = i + 1;
                return tArr[i];
            } else {
                throw new GdxRuntimeException((String) "#iterator() cannot be used nested.");
            }
        }

        public void remove() {
            if (this.allowRemove) {
                int i = this.index - 1;
                this.index = i;
                this.array.removeIndex(i);
                return;
            }
            throw new GdxRuntimeException((String) "Remove not allowed.");
        }
    }

    public Array() {
        this(true, 16);
    }

    public void add(T t) {
        T[] tArr = this.items;
        int i = this.size;
        if (i == tArr.length) {
            tArr = resize(Math.max(8, (int) (((float) i) * 1.75f)));
        }
        int i2 = this.size;
        this.size = i2 + 1;
        tArr[i2] = t;
    }

    public void addAll(Array<? extends T> array) {
        addAll(array.items, 0, array.size);
    }

    public void clear() {
        Arrays.fill(this.items, 0, this.size, null);
        this.size = 0;
    }

    public boolean contains(T t, boolean z) {
        T[] tArr = this.items;
        int i = this.size - 1;
        if (z || t == null) {
            while (i >= 0) {
                int i2 = i - 1;
                if (tArr[i] == t) {
                    return true;
                }
                i = i2;
            }
        } else {
            while (i >= 0) {
                int i3 = i - 1;
                if (t.equals(tArr[i])) {
                    return true;
                }
                i = i3;
            }
        }
        return false;
    }

    public T[] ensureCapacity(int i) {
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
        if (!this.ordered || !(obj instanceof Array)) {
            return false;
        }
        Array array = (Array) obj;
        if (!array.ordered) {
            return false;
        }
        int i = this.size;
        if (i != array.size) {
            return false;
        }
        T[] tArr = this.items;
        T[] tArr2 = array.items;
        int i2 = 0;
        while (i2 < i) {
            T t = tArr[i2];
            T t2 = tArr2[i2];
            if (t == null) {
                if (t2 == null) {
                    i2++;
                }
            } else if (t.equals(t2)) {
                i2++;
            }
            return false;
        }
        return true;
    }

    public T first() {
        if (this.size != 0) {
            return this.items[0];
        }
        throw new IllegalStateException("Array is empty.");
    }

    public T get(int i) {
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
        T[] tArr = this.items;
        int i = this.size;
        int i2 = 1;
        for (int i3 = 0; i3 < i; i3++) {
            i2 *= 31;
            T t = tArr[i3];
            if (t != null) {
                i2 = t.hashCode() + i2;
            }
        }
        return i2;
    }

    public int indexOf(T t, boolean z) {
        T[] tArr = this.items;
        int i = 0;
        if (z || t == null) {
            int i2 = this.size;
            while (i < i2) {
                if (tArr[i] == t) {
                    return i;
                }
                i++;
            }
        } else {
            int i3 = this.size;
            while (i < i3) {
                if (t.equals(tArr[i])) {
                    return i;
                }
                i++;
            }
        }
        return -1;
    }

    public void insert(int i, T t) {
        int i2 = this.size;
        if (i <= i2) {
            T[] tArr = this.items;
            if (i2 == tArr.length) {
                tArr = resize(Math.max(8, (int) (((float) i2) * 1.75f)));
            }
            if (this.ordered) {
                System.arraycopy(tArr, i, tArr, i + 1, this.size - i);
            } else {
                tArr[this.size] = tArr[i];
            }
            this.size++;
            tArr[i] = t;
            return;
        }
        StringBuilder outline74 = GeneratedOutlineSupport.outline74("index can't be > size: ", i, " > ");
        outline74.append(this.size);
        throw new IndexOutOfBoundsException(outline74.toString());
    }

    public T peek() {
        int i = this.size;
        if (i != 0) {
            return this.items[i - 1];
        }
        throw new IllegalStateException("Array is empty.");
    }

    public T pop() {
        int i = this.size;
        if (i != 0) {
            int i2 = i - 1;
            this.size = i2;
            T[] tArr = this.items;
            T t = tArr[i2];
            tArr[i2] = null;
            return t;
        }
        throw new IllegalStateException("Array is empty.");
    }

    public T random() {
        int i = this.size;
        if (i == 0) {
            return null;
        }
        return this.items[MathUtils.random.nextInt((i - 1) + 0 + 1) + 0];
    }

    public boolean removeAll(Array<? extends T> array, boolean z) {
        int i;
        int i2 = this.size;
        T[] tArr = this.items;
        if (z) {
            int i3 = array.size;
            i = i2;
            for (int i4 = 0; i4 < i3; i4++) {
                T t = array.get(i4);
                int i5 = 0;
                while (true) {
                    if (i5 >= i) {
                        break;
                    } else if (t == tArr[i5]) {
                        removeIndex(i5);
                        i--;
                        break;
                    } else {
                        i5++;
                    }
                }
            }
        } else {
            int i6 = array.size;
            i = i2;
            for (int i7 = 0; i7 < i6; i7++) {
                Object obj = array.get(i7);
                int i8 = 0;
                while (true) {
                    if (i8 >= i) {
                        break;
                    } else if (obj.equals(tArr[i8])) {
                        removeIndex(i8);
                        i--;
                        break;
                    } else {
                        i8++;
                    }
                }
            }
        }
        if (i != i2) {
            return true;
        }
        return false;
    }

    public T removeIndex(int i) {
        int i2 = this.size;
        if (i < i2) {
            T[] tArr = this.items;
            T t = tArr[i];
            int i3 = i2 - 1;
            this.size = i3;
            if (this.ordered) {
                System.arraycopy(tArr, i + 1, tArr, i, i3 - i);
            } else {
                tArr[i] = tArr[i3];
            }
            tArr[this.size] = null;
            return t;
        }
        StringBuilder outline74 = GeneratedOutlineSupport.outline74("index can't be >= size: ", i, " >= ");
        outline74.append(this.size);
        throw new IndexOutOfBoundsException(outline74.toString());
    }

    public void removeRange(int i, int i2) {
        int i3 = this.size;
        if (i2 >= i3) {
            StringBuilder outline74 = GeneratedOutlineSupport.outline74("end can't be >= size: ", i2, " >= ");
            outline74.append(this.size);
            throw new IndexOutOfBoundsException(outline74.toString());
        } else if (i <= i2) {
            T[] tArr = this.items;
            int i4 = (i2 - i) + 1;
            int i5 = i3 - i4;
            if (this.ordered) {
                int i6 = i4 + i;
                System.arraycopy(tArr, i6, tArr, i, i3 - i6);
            } else {
                int max = Math.max(i5, i2 + 1);
                System.arraycopy(tArr, max, tArr, i, i3 - max);
            }
            for (int i7 = i5; i7 < i3; i7++) {
                tArr[i7] = null;
            }
            this.size = i5;
        } else {
            throw new IndexOutOfBoundsException(GeneratedOutlineSupport.outline43("start can't be > end: ", i, " > ", i2));
        }
    }

    public boolean removeValue(T t, boolean z) {
        T[] tArr = this.items;
        if (z || t == null) {
            int i = this.size;
            for (int i2 = 0; i2 < i; i2++) {
                if (tArr[i2] == t) {
                    removeIndex(i2);
                    return true;
                }
            }
        } else {
            int i3 = this.size;
            for (int i4 = 0; i4 < i3; i4++) {
                if (t.equals(tArr[i4])) {
                    removeIndex(i4);
                    return true;
                }
            }
        }
        return false;
    }

    public T[] resize(int i) {
        T[] tArr = this.items;
        T[] tArr2 = (Object[]) java.lang.reflect.Array.newInstance(tArr.getClass().getComponentType(), i);
        System.arraycopy(tArr, 0, tArr2, 0, Math.min(this.size, tArr2.length));
        this.items = tArr2;
        return tArr2;
    }

    public void set(int i, T t) {
        if (i < this.size) {
            this.items[i] = t;
            return;
        }
        StringBuilder outline74 = GeneratedOutlineSupport.outline74("index can't be >= size: ", i, " >= ");
        outline74.append(this.size);
        throw new IndexOutOfBoundsException(outline74.toString());
    }

    public void sort(Comparator<? super T> comparator) {
        Sort instance = Sort.instance();
        T[] tArr = this.items;
        int i = this.size;
        if (instance.timSort == null) {
            instance.timSort = new TimSort();
        }
        instance.timSort.doSort(tArr, comparator, 0, i);
    }

    public <V> V[] toArray(Class<V> cls) {
        V[] vArr = (Object[]) java.lang.reflect.Array.newInstance(cls, this.size);
        System.arraycopy(this.items, 0, vArr, 0, this.size);
        return vArr;
    }

    public String toString() {
        if (this.size == 0) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        T[] tArr = this.items;
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append0('[');
        stringBuilder.append((Object) tArr[0]);
        for (int i = 1; i < this.size; i++) {
            stringBuilder.append0((String) ", ");
            stringBuilder.append((Object) tArr[i]);
        }
        stringBuilder.append0(']');
        return stringBuilder.toString();
    }

    public void truncate(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("newSize must be >= 0: ", i));
        } else if (this.size > i) {
            for (int i2 = i; i2 < this.size; i2++) {
                this.items[i2] = null;
            }
            this.size = i;
        }
    }

    public Array(boolean z, int i) {
        this.ordered = z;
        this.items = new Object[i];
    }

    public void addAll(T[] tArr, int i, int i2) {
        T[] tArr2 = this.items;
        int i3 = this.size + i2;
        if (i3 > tArr2.length) {
            tArr2 = resize(Math.max(Math.max(8, i3), (int) (((float) this.size) * 1.75f)));
        }
        System.arraycopy(tArr, i, tArr2, this.size, i2);
        this.size = i3;
    }

    public ArrayIterator<T> iterator() {
        if (this.iterable == null) {
            this.iterable = new ArrayIterable(this);
        }
        return this.iterable.iterator();
    }

    public Array(boolean z, int i, Class cls) {
        this.ordered = z;
        this.items = (Object[]) java.lang.reflect.Array.newInstance(cls, i);
    }

    public Array(Array<? extends T> array) {
        this(array.ordered, array.size, array.items.getClass().getComponentType());
        int i = array.size;
        this.size = i;
        System.arraycopy(array.items, 0, this.items, 0, i);
    }

    public Array(T[] tArr) {
        int length = tArr.length;
        Class<?> componentType = tArr.getClass().getComponentType();
        this.ordered = true;
        T[] tArr2 = (Object[]) java.lang.reflect.Array.newInstance(componentType, length);
        this.items = tArr2;
        this.size = length;
        System.arraycopy(tArr, 0, tArr2, 0, length);
    }
}
