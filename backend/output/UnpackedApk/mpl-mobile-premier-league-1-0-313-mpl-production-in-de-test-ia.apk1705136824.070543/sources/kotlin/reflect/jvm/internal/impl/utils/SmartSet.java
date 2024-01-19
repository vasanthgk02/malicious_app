package kotlin.reflect.jvm.internal.impl.utils;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* compiled from: SmartSet.kt */
public final class SmartSet<T> extends AbstractSet<T> {
    public Object data;
    public int size;

    /* compiled from: SmartSet.kt */
    public static final class ArrayIterator<T> implements Iterator<T>, Object {
        public final Iterator<T> arrayIterator;

        public ArrayIterator(T[] tArr) {
            Intrinsics.checkNotNullParameter(tArr, "array");
            this.arrayIterator = TweetUtils.iterator(tArr);
        }

        public boolean hasNext() {
            return this.arrayIterator.hasNext();
        }

        public T next() {
            return this.arrayIterator.next();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* compiled from: SmartSet.kt */
    public static final class Companion {
        public static final <T> SmartSet<T> create() {
            return new SmartSet<>(null);
        }
    }

    /* compiled from: SmartSet.kt */
    public static final class SingletonIterator<T> implements Iterator<T>, Object {
        public final T element;
        public boolean hasNext = true;

        public SingletonIterator(T t) {
            this.element = t;
        }

        public boolean hasNext() {
            return this.hasNext;
        }

        public T next() {
            if (this.hasNext) {
                this.hasNext = false;
                return this.element;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public SmartSet(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public static final <T> SmartSet<T> create() {
        return new SmartSet<>(null);
    }

    public boolean add(T t) {
        Object obj;
        int i = this.size;
        if (i == 0) {
            this.data = t;
        } else if (i == 1) {
            if (Intrinsics.areEqual(this.data, t)) {
                return false;
            }
            this.data = new Object[]{this.data, t};
        } else if (i < 5) {
            Object obj2 = this.data;
            if (obj2 != null) {
                Object[] objArr = (Object[]) obj2;
                if (TweetUtils.contains(objArr, t)) {
                    return false;
                }
                int i2 = this.size;
                if (i2 == 4) {
                    int length = objArr.length;
                    Object[] objArr2 = new Object[length];
                    System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
                    Intrinsics.checkNotNullParameter(objArr2, "elements");
                    LinkedHashSet linkedHashSet = new LinkedHashSet(TweetUtils.mapCapacity(length));
                    TweetUtils.toCollection(objArr2, linkedHashSet);
                    linkedHashSet.add(t);
                    obj = linkedHashSet;
                } else {
                    Object[] copyOf = Arrays.copyOf(objArr, i2 + 1);
                    Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, newSize)");
                    copyOf[copyOf.length - 1] = t;
                    obj = copyOf;
                }
                this.data = obj;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
            }
        } else {
            Object obj3 = this.data;
            if (obj3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableSet<T of org.jetbrains.kotlin.utils.SmartSet>");
            } else if (!TypeIntrinsics.asMutableSet(obj3).add(t)) {
                return false;
            }
        }
        this.size++;
        return true;
    }

    public void clear() {
        this.data = null;
        this.size = 0;
    }

    public boolean contains(Object obj) {
        int i = this.size;
        if (i == 0) {
            return false;
        }
        if (i == 1) {
            return Intrinsics.areEqual(this.data, obj);
        }
        if (i < 5) {
            Object obj2 = this.data;
            if (obj2 != null) {
                return TweetUtils.contains((Object[]) obj2, obj);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
        }
        Object obj3 = this.data;
        if (obj3 != null) {
            return ((Set) obj3).contains(obj);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Set<T of org.jetbrains.kotlin.utils.SmartSet>");
    }

    public Iterator<T> iterator() {
        int i = this.size;
        if (i == 0) {
            return Collections.emptySet().iterator();
        }
        if (i == 1) {
            return new SingletonIterator(this.data);
        }
        if (i < 5) {
            Object obj = this.data;
            if (obj != null) {
                return new ArrayIterator((Object[]) obj);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
        }
        Object obj2 = this.data;
        if (obj2 != null) {
            return TypeIntrinsics.asMutableSet(obj2).iterator();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableSet<T of org.jetbrains.kotlin.utils.SmartSet>");
    }

    public final int size() {
        return this.size;
    }
}
