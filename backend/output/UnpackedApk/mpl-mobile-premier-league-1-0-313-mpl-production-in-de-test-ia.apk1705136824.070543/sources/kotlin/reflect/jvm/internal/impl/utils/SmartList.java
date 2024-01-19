package kotlin.reflect.jvm.internal.impl.utils;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

public class SmartList<E> extends AbstractList<E> implements RandomAccess {
    public Object myElem;
    public int mySize;

    public static class EmptyIterator<T> implements Iterator<T> {
        public static final EmptyIterator INSTANCE = new EmptyIterator();

        public boolean hasNext() {
            return false;
        }

        public T next() {
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new IllegalStateException();
        }
    }

    public class SingletonIterator extends SingletonIteratorBase<E> {
        public final int myInitialModCount;

        public SingletonIterator() {
            super(null);
            this.myInitialModCount = SmartList.this.modCount;
        }

        public void checkCoModification() {
            if (SmartList.this.modCount != this.myInitialModCount) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("ModCount: ");
                outline73.append(SmartList.this.modCount);
                outline73.append("; expected: ");
                outline73.append(this.myInitialModCount);
                throw new ConcurrentModificationException(outline73.toString());
            }
        }

        public void remove() {
            checkCoModification();
            SmartList.this.clear();
        }
    }

    public static abstract class SingletonIteratorBase<T> implements Iterator<T> {
        public boolean myVisited;

        public SingletonIteratorBase(AnonymousClass1 r1) {
        }

        public abstract void checkCoModification();

        public final boolean hasNext() {
            return !this.myVisited;
        }

        public final T next() {
            if (!this.myVisited) {
                this.myVisited = true;
                checkCoModification();
                return SmartList.this.myElem;
            }
            throw new NoSuchElementException();
        }
    }

    public static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str = (i == 2 || i == 3 || i == 5 || i == 6 || i == 7) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i == 2 || i == 3 || i == 5 || i == 6 || i == 7) ? 2 : 3)];
        switch (i) {
            case 2:
            case 3:
            case 5:
            case 6:
            case 7:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/utils/SmartList";
                break;
            case 4:
                objArr[0] = "a";
                break;
            default:
                objArr[0] = "elements";
                break;
        }
        if (i == 2 || i == 3) {
            objArr[1] = "iterator";
        } else if (i == 5 || i == 6 || i == 7) {
            objArr[1] = "toArray";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/SmartList";
        }
        switch (i) {
            case 2:
            case 3:
            case 5:
            case 6:
            case 7:
                break;
            case 4:
                objArr[2] = "toArray";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        throw ((i == 2 || i == 3 || i == 5 || i == 6 || i == 7) ? new IllegalStateException(format) : new IllegalArgumentException(format));
    }

    public boolean add(E e2) {
        int i = this.mySize;
        if (i == 0) {
            this.myElem = e2;
        } else if (i == 1) {
            this.myElem = new Object[]{this.myElem, e2};
        } else {
            Object[] objArr = (Object[]) this.myElem;
            int length = objArr.length;
            if (i >= length) {
                int outline8 = GeneratedOutlineSupport.outline8(length, 3, 2, 1);
                int i2 = i + 1;
                if (outline8 < i2) {
                    outline8 = i2;
                }
                Object[] objArr2 = new Object[outline8];
                this.myElem = objArr2;
                System.arraycopy(objArr, 0, objArr2, 0, length);
                objArr = objArr2;
            }
            objArr[this.mySize] = e2;
        }
        this.mySize++;
        this.modCount++;
        return true;
    }

    public void clear() {
        this.myElem = null;
        this.mySize = 0;
        this.modCount++;
    }

    public E get(int i) {
        if (i >= 0) {
            int i2 = this.mySize;
            if (i < i2) {
                if (i2 == 1) {
                    return this.myElem;
                }
                return ((Object[]) this.myElem)[i];
            }
        }
        StringBuilder outline74 = GeneratedOutlineSupport.outline74("Index: ", i, ", Size: ");
        outline74.append(this.mySize);
        throw new IndexOutOfBoundsException(outline74.toString());
    }

    public Iterator<E> iterator() {
        int i = this.mySize;
        if (i == 0) {
            return EmptyIterator.INSTANCE;
        }
        if (i == 1) {
            return new SingletonIterator();
        }
        Iterator<E> it = super.iterator();
        if (it != null) {
            return it;
        }
        $$$reportNull$$$0(3);
        throw null;
    }

    public E remove(int i) {
        E e2;
        if (i >= 0) {
            int i2 = this.mySize;
            if (i < i2) {
                if (i2 == 1) {
                    e2 = this.myElem;
                    this.myElem = null;
                } else {
                    E[] eArr = (Object[]) this.myElem;
                    E e3 = eArr[i];
                    if (i2 == 2) {
                        this.myElem = eArr[1 - i];
                    } else {
                        int i3 = (i2 - i) - 1;
                        if (i3 > 0) {
                            System.arraycopy(eArr, i + 1, eArr, i, i3);
                        }
                        eArr[this.mySize - 1] = null;
                    }
                    e2 = e3;
                }
                this.mySize--;
                this.modCount++;
                return e2;
            }
        }
        StringBuilder outline74 = GeneratedOutlineSupport.outline74("Index: ", i, ", Size: ");
        outline74.append(this.mySize);
        throw new IndexOutOfBoundsException(outline74.toString());
    }

    public E set(int i, E e2) {
        if (i >= 0) {
            int i2 = this.mySize;
            if (i < i2) {
                if (i2 == 1) {
                    E e3 = this.myElem;
                    this.myElem = e2;
                    return e3;
                }
                Object[] objArr = (Object[]) this.myElem;
                Object obj = objArr[i];
                objArr[i] = e2;
                return obj;
            }
        }
        StringBuilder outline74 = GeneratedOutlineSupport.outline74("Index: ", i, ", Size: ");
        outline74.append(this.mySize);
        throw new IndexOutOfBoundsException(outline74.toString());
    }

    public int size() {
        return this.mySize;
    }

    public <T> T[] toArray(T[] tArr) {
        if (tArr != null) {
            int length = tArr.length;
            int i = this.mySize;
            if (i == 1) {
                if (length != 0) {
                    tArr[0] = this.myElem;
                } else {
                    T[] tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), 1);
                    tArr2[0] = this.myElem;
                    return tArr2;
                }
            } else if (length < i) {
                T[] copyOf = Arrays.copyOf((Object[]) this.myElem, i, tArr.getClass());
                if (copyOf != null) {
                    return copyOf;
                }
                $$$reportNull$$$0(6);
                throw null;
            } else if (i != 0) {
                System.arraycopy(this.myElem, 0, tArr, 0, i);
            }
            int i2 = this.mySize;
            if (length > i2) {
                tArr[i2] = null;
            }
            return tArr;
        }
        $$$reportNull$$$0(4);
        throw null;
    }

    public void add(int i, E e2) {
        if (i >= 0) {
            int i2 = this.mySize;
            if (i <= i2) {
                if (i2 == 0) {
                    this.myElem = e2;
                } else if (i2 == 1 && i == 0) {
                    this.myElem = new Object[]{e2, this.myElem};
                } else {
                    int i3 = this.mySize;
                    Object[] objArr = new Object[(i3 + 1)];
                    if (i3 == 1) {
                        objArr[0] = this.myElem;
                    } else {
                        Object[] objArr2 = (Object[]) this.myElem;
                        System.arraycopy(objArr2, 0, objArr, 0, i);
                        System.arraycopy(objArr2, i, objArr, i + 1, this.mySize - i);
                    }
                    objArr[i] = e2;
                    this.myElem = objArr;
                }
                this.mySize++;
                this.modCount++;
                return;
            }
        }
        StringBuilder outline74 = GeneratedOutlineSupport.outline74("Index: ", i, ", Size: ");
        outline74.append(this.mySize);
        throw new IndexOutOfBoundsException(outline74.toString());
    }
}
