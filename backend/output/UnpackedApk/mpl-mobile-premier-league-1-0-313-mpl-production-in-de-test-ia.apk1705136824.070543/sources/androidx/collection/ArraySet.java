package androidx.collection;

import androidx.collection.MapCollections.KeySet;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class ArraySet<E> implements Collection<E>, Set<E> {
    public static final int[] INT = new int[0];
    public static final Object[] OBJECT = new Object[0];
    public static Object[] sBaseCache;
    public static int sBaseCacheSize;
    public static Object[] sTwiceBaseCache;
    public static int sTwiceBaseCacheSize;
    public Object[] mArray;
    public MapCollections<E, E> mCollections;
    public int[] mHashes;
    public int mSize;

    public ArraySet() {
        this(0);
    }

    public static void freeArrays(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (ArraySet.class) {
                if (sTwiceBaseCacheSize < 10) {
                    objArr[0] = sTwiceBaseCache;
                    objArr[1] = iArr;
                    for (int i2 = i - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    sTwiceBaseCache = objArr;
                    sTwiceBaseCacheSize++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (ArraySet.class) {
                if (sBaseCacheSize < 10) {
                    objArr[0] = sBaseCache;
                    objArr[1] = iArr;
                    for (int i3 = i - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    sBaseCache = objArr;
                    sBaseCacheSize++;
                }
            }
        }
    }

    public boolean add(E e2) {
        int i;
        int i2;
        if (e2 == null) {
            i2 = indexOfNull();
            i = 0;
        } else {
            int hashCode = e2.hashCode();
            i = hashCode;
            i2 = indexOf(e2, hashCode);
        }
        if (i2 >= 0) {
            return false;
        }
        int i3 = ~i2;
        int i4 = this.mSize;
        if (i4 >= this.mHashes.length) {
            int i5 = 4;
            if (i4 >= 8) {
                i5 = (i4 >> 1) + i4;
            } else if (i4 >= 4) {
                i5 = 8;
            }
            int[] iArr = this.mHashes;
            Object[] objArr = this.mArray;
            allocArrays(i5);
            int[] iArr2 = this.mHashes;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.mArray, 0, objArr.length);
            }
            freeArrays(iArr, objArr, this.mSize);
        }
        int i6 = this.mSize;
        if (i3 < i6) {
            int[] iArr3 = this.mHashes;
            int i7 = i3 + 1;
            System.arraycopy(iArr3, i3, iArr3, i7, i6 - i3);
            Object[] objArr2 = this.mArray;
            System.arraycopy(objArr2, i3, objArr2, i7, this.mSize - i3);
        }
        this.mHashes[i3] = i;
        this.mArray[i3] = e2;
        this.mSize++;
        return true;
    }

    public boolean addAll(Collection<? extends E> collection) {
        int size = collection.size() + this.mSize;
        int[] iArr = this.mHashes;
        boolean z = false;
        if (iArr.length < size) {
            Object[] objArr = this.mArray;
            allocArrays(size);
            int i = this.mSize;
            if (i > 0) {
                System.arraycopy(iArr, 0, this.mHashes, 0, i);
                System.arraycopy(objArr, 0, this.mArray, 0, this.mSize);
            }
            freeArrays(iArr, objArr, this.mSize);
        }
        for (Object add : collection) {
            z |= add(add);
        }
        return z;
    }

    public final void allocArrays(int i) {
        if (i == 8) {
            synchronized (ArraySet.class) {
                if (sTwiceBaseCache != null) {
                    Object[] objArr = sTwiceBaseCache;
                    this.mArray = objArr;
                    sTwiceBaseCache = (Object[]) objArr[0];
                    this.mHashes = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    sTwiceBaseCacheSize--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (ArraySet.class) {
                if (sBaseCache != null) {
                    Object[] objArr2 = sBaseCache;
                    this.mArray = objArr2;
                    sBaseCache = (Object[]) objArr2[0];
                    this.mHashes = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    sBaseCacheSize--;
                    return;
                }
            }
        }
        this.mHashes = new int[i];
        this.mArray = new Object[i];
    }

    public void clear() {
        int i = this.mSize;
        if (i != 0) {
            freeArrays(this.mHashes, this.mArray, i);
            this.mHashes = INT;
            this.mArray = OBJECT;
            this.mSize = 0;
        }
    }

    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    public boolean containsAll(Collection<?> collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (this.mSize != set.size()) {
                return false;
            }
            int i = 0;
            while (i < this.mSize) {
                try {
                    if (!set.contains(this.mArray[i])) {
                        return false;
                    }
                    i++;
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int[] iArr = this.mHashes;
        int i = this.mSize;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += iArr[i3];
        }
        return i2;
    }

    public final int indexOf(Object obj, int i) {
        int i2 = this.mSize;
        if (i2 == 0) {
            return -1;
        }
        int binarySearch = ContainerHelpers.binarySearch(this.mHashes, i2, i);
        if (binarySearch < 0 || obj.equals(this.mArray[binarySearch])) {
            return binarySearch;
        }
        int i3 = binarySearch + 1;
        while (i3 < i2 && this.mHashes[i3] == i) {
            if (obj.equals(this.mArray[i3])) {
                return i3;
            }
            i3++;
        }
        int i4 = binarySearch - 1;
        while (i4 >= 0 && this.mHashes[i4] == i) {
            if (obj.equals(this.mArray[i4])) {
                return i4;
            }
            i4--;
        }
        return ~i3;
    }

    public final int indexOfNull() {
        int i = this.mSize;
        if (i == 0) {
            return -1;
        }
        int binarySearch = ContainerHelpers.binarySearch(this.mHashes, i, 0);
        if (binarySearch < 0 || this.mArray[binarySearch] == null) {
            return binarySearch;
        }
        int i2 = binarySearch + 1;
        while (i2 < i && this.mHashes[i2] == 0) {
            if (this.mArray[i2] == null) {
                return i2;
            }
            i2++;
        }
        int i3 = binarySearch - 1;
        while (i3 >= 0 && this.mHashes[i3] == 0) {
            if (this.mArray[i3] == null) {
                return i3;
            }
            i3--;
        }
        return ~i2;
    }

    public boolean isEmpty() {
        return this.mSize <= 0;
    }

    public Iterator<E> iterator() {
        if (this.mCollections == null) {
            this.mCollections = new MapCollections<E, E>() {
                public void colClear() {
                    ArraySet.this.clear();
                }

                public Object colGetEntry(int i, int i2) {
                    return ArraySet.this.mArray[i];
                }

                public Map<E, E> colGetMap() {
                    throw new UnsupportedOperationException("not a map");
                }

                public int colGetSize() {
                    return ArraySet.this.mSize;
                }

                public int colIndexOfKey(Object obj) {
                    return ArraySet.this.indexOf(obj);
                }

                public int colIndexOfValue(Object obj) {
                    return ArraySet.this.indexOf(obj);
                }

                public void colPut(E e2, E e3) {
                    ArraySet.this.add(e2);
                }

                public void colRemoveAt(int i) {
                    ArraySet.this.removeAt(i);
                }

                public E colSetValue(int i, E e2) {
                    throw new UnsupportedOperationException("not a map");
                }
            };
        }
        MapCollections<E, E> mapCollections = this.mCollections;
        if (mapCollections.mKeySet == null) {
            mapCollections.mKeySet = new KeySet<>();
        }
        return mapCollections.mKeySet.iterator();
    }

    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf < 0) {
            return false;
        }
        removeAt(indexOf);
        return true;
    }

    public boolean removeAll(Collection<?> collection) {
        boolean z = false;
        for (Object remove : collection) {
            z |= remove(remove);
        }
        return z;
    }

    public E removeAt(int i) {
        E[] eArr = this.mArray;
        E e2 = eArr[i];
        int i2 = this.mSize;
        if (i2 <= 1) {
            freeArrays(this.mHashes, eArr, i2);
            this.mHashes = INT;
            this.mArray = OBJECT;
            this.mSize = 0;
        } else {
            int[] iArr = this.mHashes;
            int i3 = 8;
            if (iArr.length <= 8 || i2 >= iArr.length / 3) {
                int i4 = this.mSize - 1;
                this.mSize = i4;
                if (i < i4) {
                    int[] iArr2 = this.mHashes;
                    int i5 = i + 1;
                    System.arraycopy(iArr2, i5, iArr2, i, i4 - i);
                    Object[] objArr = this.mArray;
                    System.arraycopy(objArr, i5, objArr, i, this.mSize - i);
                }
                this.mArray[this.mSize] = null;
            } else {
                if (i2 > 8) {
                    i3 = i2 + (i2 >> 1);
                }
                int[] iArr3 = this.mHashes;
                Object[] objArr2 = this.mArray;
                allocArrays(i3);
                this.mSize--;
                if (i > 0) {
                    System.arraycopy(iArr3, 0, this.mHashes, 0, i);
                    System.arraycopy(objArr2, 0, this.mArray, 0, i);
                }
                int i6 = this.mSize;
                if (i < i6) {
                    int i7 = i + 1;
                    System.arraycopy(iArr3, i7, this.mHashes, i, i6 - i);
                    System.arraycopy(objArr2, i7, this.mArray, i, this.mSize - i);
                }
            }
        }
        return e2;
    }

    public boolean retainAll(Collection<?> collection) {
        boolean z = false;
        for (int i = this.mSize - 1; i >= 0; i--) {
            if (!collection.contains(this.mArray[i])) {
                removeAt(i);
                z = true;
            }
        }
        return z;
    }

    public int size() {
        return this.mSize;
    }

    public Object[] toArray() {
        int i = this.mSize;
        Object[] objArr = new Object[i];
        System.arraycopy(this.mArray, 0, objArr, 0, i);
        return objArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.mSize * 14);
        sb.append('{');
        for (int i = 0; i < this.mSize; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            Object obj = this.mArray[i];
            if (obj != this) {
                sb.append(obj);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public ArraySet(int i) {
        if (i == 0) {
            this.mHashes = INT;
            this.mArray = OBJECT;
        } else {
            allocArrays(i);
        }
        this.mSize = 0;
    }

    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.mSize) {
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.mSize);
        }
        System.arraycopy(this.mArray, 0, tArr, 0, this.mSize);
        int length = tArr.length;
        int i = this.mSize;
        if (length > i) {
            tArr[i] = null;
        }
        return tArr;
    }

    public int indexOf(Object obj) {
        return obj == null ? indexOfNull() : indexOf(obj, obj.hashCode());
    }
}
