package com.badlogic.gdx.utils;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.math.MathUtils;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ObjectSet<T> implements Iterable<T> {
    public transient ObjectSetIterator iterator1;
    public transient ObjectSetIterator iterator2;
    public T[] keyTable;
    public float loadFactor;
    public int mask;
    public int shift;
    public int size;
    public int threshold;

    public static class ObjectSetIterator<K> implements Iterable<K>, Iterator<K> {
        public int currentIndex;
        public boolean hasNext;
        public int nextIndex;
        public final ObjectSet<K> set;
        public boolean valid = true;

        public ObjectSetIterator(ObjectSet<K> objectSet) {
            this.set = objectSet;
            reset();
        }

        public final void findNextIndex() {
            int i;
            T[] tArr = this.set.keyTable;
            int length = tArr.length;
            do {
                i = this.nextIndex + 1;
                this.nextIndex = i;
                if (i >= length) {
                    this.hasNext = false;
                    return;
                }
            } while (tArr[i] == null);
            this.hasNext = true;
        }

        public boolean hasNext() {
            if (this.valid) {
                return this.hasNext;
            }
            throw new GdxRuntimeException((String) "#iterator() cannot be used nested.");
        }

        public Iterator iterator() {
            return this;
        }

        public K next() {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            } else if (this.valid) {
                Object[] objArr = this.set.keyTable;
                int i = this.nextIndex;
                Object obj = objArr[i];
                this.currentIndex = i;
                findNextIndex();
                return obj;
            } else {
                throw new GdxRuntimeException((String) "#iterator() cannot be used nested.");
            }
        }

        public void remove() {
            int i = this.currentIndex;
            if (i >= 0) {
                ObjectSet<K> objectSet = this.set;
                T[] tArr = objectSet.keyTable;
                int i2 = objectSet.mask;
                int i3 = i + 1;
                while (true) {
                    int i4 = i3 & i2;
                    T t = tArr[i4];
                    if (t == null) {
                        break;
                    }
                    int place = this.set.place(t);
                    if (((i4 - place) & i2) > ((i - place) & i2)) {
                        tArr[i] = t;
                        i = i4;
                    }
                    i3 = i4 + 1;
                }
                tArr[i] = null;
                ObjectSet<K> objectSet2 = this.set;
                objectSet2.size--;
                if (i != this.currentIndex) {
                    this.nextIndex--;
                }
                this.currentIndex = -1;
                return;
            }
            throw new IllegalStateException("next must be called before remove.");
        }

        public void reset() {
            this.currentIndex = -1;
            this.nextIndex = -1;
            findNextIndex();
        }
    }

    public ObjectSet() {
        this(51, 0.8f);
    }

    public static int tableSize(int i, float f2) {
        if (i >= 0) {
            int nextPowerOfTwo = MathUtils.nextPowerOfTwo(Math.max(2, (int) Math.ceil((double) (((float) i) / f2))));
            if (nextPowerOfTwo <= 1073741824) {
                return nextPowerOfTwo;
            }
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("The required capacity is too large: ", i));
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("capacity must be >= 0: ", i));
    }

    public boolean add(T t) {
        int locateKey = locateKey(t);
        if (locateKey >= 0) {
            return false;
        }
        T[] tArr = this.keyTable;
        tArr[-(locateKey + 1)] = t;
        int i = this.size + 1;
        this.size = i;
        if (i >= this.threshold) {
            resize(tArr.length << 1);
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ObjectSet)) {
            return false;
        }
        ObjectSet objectSet = (ObjectSet) obj;
        if (objectSet.size != this.size) {
            return false;
        }
        T[] tArr = this.keyTable;
        int length = tArr.length;
        int i = 0;
        while (true) {
            boolean z = true;
            if (i >= length) {
                return true;
            }
            if (tArr[i] != null) {
                if (objectSet.locateKey(tArr[i]) < 0) {
                    z = false;
                }
                if (!z) {
                    return false;
                }
            }
            i++;
        }
    }

    public int hashCode() {
        int i = this.size;
        for (T t : this.keyTable) {
            if (t != null) {
                i = t.hashCode() + i;
            }
        }
        return i;
    }

    public int locateKey(T t) {
        if (t != null) {
            T[] tArr = this.keyTable;
            int place = place(t);
            while (true) {
                T t2 = tArr[place];
                if (t2 == null) {
                    return -(place + 1);
                }
                if (t2.equals(t)) {
                    return place;
                }
                place = (place + 1) & this.mask;
            }
        } else {
            throw new IllegalArgumentException("key cannot be null.");
        }
    }

    public int place(T t) {
        return (int) ((((long) t.hashCode()) * -7046029254386353131L) >>> this.shift);
    }

    public final void resize(int i) {
        int length = this.keyTable.length;
        this.threshold = (int) (((float) i) * this.loadFactor);
        int i2 = i - 1;
        this.mask = i2;
        this.shift = Long.numberOfLeadingZeros((long) i2);
        T[] tArr = this.keyTable;
        this.keyTable = new Object[i];
        if (this.size > 0) {
            for (int i3 = 0; i3 < length; i3++) {
                T t = tArr[i3];
                if (t != null) {
                    T[] tArr2 = this.keyTable;
                    int place = place(t);
                    while (tArr2[place] != null) {
                        place = (place + 1) & this.mask;
                    }
                    tArr2[place] = t;
                }
            }
        }
    }

    public String toString() {
        String str;
        int i;
        StringBuilder outline72 = GeneratedOutlineSupport.outline72('{');
        if (this.size == 0) {
            str = "";
        } else {
            StringBuilder sb = new StringBuilder(32);
            ObjectSet[] objectSetArr = this.keyTable;
            int length = objectSetArr.length;
            while (true) {
                i = length - 1;
                if (length <= 0) {
                    break;
                }
                ObjectSet objectSet = objectSetArr[i];
                if (objectSet == null) {
                    length = i;
                } else {
                    if (objectSet == this) {
                        objectSet = "(this)";
                    }
                    sb.append(objectSet);
                }
            }
            while (true) {
                int i2 = i - 1;
                if (i <= 0) {
                    break;
                }
                ObjectSet objectSet2 = objectSetArr[i2];
                if (objectSet2 != null) {
                    sb.append(", ");
                    if (objectSet2 == this) {
                        objectSet2 = "(this)";
                    }
                    sb.append(objectSet2);
                }
                i = i2;
            }
            str = sb.toString();
        }
        return GeneratedOutlineSupport.outline59(outline72, str, '}');
    }

    public ObjectSet(int i, float f2) {
        if (f2 <= 0.0f || f2 >= 1.0f) {
            throw new IllegalArgumentException("loadFactor must be > 0 and < 1: " + f2);
        }
        this.loadFactor = f2;
        int tableSize = tableSize(i, f2);
        this.threshold = (int) (((float) tableSize) * f2);
        int i2 = tableSize - 1;
        this.mask = i2;
        this.shift = Long.numberOfLeadingZeros((long) i2);
        this.keyTable = new Object[tableSize];
    }

    public ObjectSetIterator<T> iterator() {
        if (this.iterator1 == null) {
            this.iterator1 = new ObjectSetIterator(this);
            this.iterator2 = new ObjectSetIterator(this);
        }
        ObjectSetIterator objectSetIterator = this.iterator1;
        if (!objectSetIterator.valid) {
            objectSetIterator.reset();
            ObjectSetIterator<T> objectSetIterator2 = this.iterator1;
            objectSetIterator2.valid = true;
            this.iterator2.valid = false;
            return objectSetIterator2;
        }
        this.iterator2.reset();
        ObjectSetIterator<T> objectSetIterator3 = this.iterator2;
        objectSetIterator3.valid = true;
        this.iterator1.valid = false;
        return objectSetIterator3;
    }
}
