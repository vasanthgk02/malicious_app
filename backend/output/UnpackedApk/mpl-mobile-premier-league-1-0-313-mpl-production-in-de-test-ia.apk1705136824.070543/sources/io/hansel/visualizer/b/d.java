package io.hansel.visualizer.b;

import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class d {

    public static final class a<E> extends AbstractList<E> implements C0086d<E> {

        /* renamed from: a  reason: collision with root package name */
        public final E f5746a;

        /* renamed from: b  reason: collision with root package name */
        public final E f5747b;

        /* renamed from: c  reason: collision with root package name */
        public final E f5748c;

        /* renamed from: d  reason: collision with root package name */
        public final E f5749d;

        /* renamed from: e  reason: collision with root package name */
        public final E f5750e;

        public a(E e2, E e3, E e4, E e5, E e6) {
            this.f5746a = e2;
            this.f5747b = e3;
            this.f5748c = e4;
            this.f5749d = e5;
            this.f5750e = e6;
        }

        public E get(int i) {
            if (i == 0) {
                return this.f5746a;
            }
            if (i == 1) {
                return this.f5747b;
            }
            if (i == 2) {
                return this.f5748c;
            }
            if (i == 3) {
                return this.f5749d;
            }
            if (i == 4) {
                return this.f5750e;
            }
            throw new IndexOutOfBoundsException();
        }

        public int size() {
            return 5;
        }
    }

    public static final class b<E> extends AbstractList<E> implements C0086d<E> {

        /* renamed from: a  reason: collision with root package name */
        public final E f5751a;

        /* renamed from: b  reason: collision with root package name */
        public final E f5752b;

        /* renamed from: c  reason: collision with root package name */
        public final E f5753c;

        /* renamed from: d  reason: collision with root package name */
        public final E f5754d;

        public b(E e2, E e3, E e4, E e5) {
            this.f5751a = e2;
            this.f5752b = e3;
            this.f5753c = e4;
            this.f5754d = e5;
        }

        public E get(int i) {
            if (i == 0) {
                return this.f5751a;
            }
            if (i == 1) {
                return this.f5752b;
            }
            if (i == 2) {
                return this.f5753c;
            }
            if (i == 3) {
                return this.f5754d;
            }
            throw new IndexOutOfBoundsException();
        }

        public int size() {
            return 4;
        }
    }

    public static final class c<E> extends AbstractList<E> implements C0086d<E> {

        /* renamed from: a  reason: collision with root package name */
        public final Object[] f5755a;

        public c(Object[] objArr) {
            this.f5755a = objArr;
        }

        public E get(int i) {
            return this.f5755a[i];
        }

        public int size() {
            return this.f5755a.length;
        }
    }

    /* renamed from: io.hansel.visualizer.b.d$d  reason: collision with other inner class name */
    public interface C0086d<E> extends List<E>, RandomAccess {
    }

    public static final class e<E> extends AbstractList<E> implements C0086d<E> {

        /* renamed from: a  reason: collision with root package name */
        public final E f5756a;

        public e(E e2) {
            this.f5756a = e2;
        }

        public E get(int i) {
            if (i == 0) {
                return this.f5756a;
            }
            throw new IndexOutOfBoundsException();
        }

        public int size() {
            return 1;
        }
    }

    public static final class f<E> extends AbstractList<E> implements C0086d<E> {

        /* renamed from: a  reason: collision with root package name */
        public final E f5757a;

        /* renamed from: b  reason: collision with root package name */
        public final E f5758b;

        /* renamed from: c  reason: collision with root package name */
        public final E f5759c;

        public f(E e2, E e3, E e4) {
            this.f5757a = e2;
            this.f5758b = e3;
            this.f5759c = e4;
        }

        public E get(int i) {
            if (i == 0) {
                return this.f5757a;
            }
            if (i == 1) {
                return this.f5758b;
            }
            if (i == 2) {
                return this.f5759c;
            }
            throw new IndexOutOfBoundsException();
        }

        public int size() {
            return 3;
        }
    }

    public static final class g<E> extends AbstractList<E> implements C0086d<E> {

        /* renamed from: a  reason: collision with root package name */
        public final E f5760a;

        /* renamed from: b  reason: collision with root package name */
        public final E f5761b;

        public g(E e2, E e3) {
            this.f5760a = e2;
            this.f5761b = e3;
        }

        public E get(int i) {
            if (i == 0) {
                return this.f5760a;
            }
            if (i == 1) {
                return this.f5761b;
            }
            throw new IndexOutOfBoundsException();
        }

        public int size() {
            return 2;
        }
    }

    public static <T> List<T> a(List<T> list) {
        if (list instanceof C0086d) {
            return list;
        }
        int size = list.size();
        if (size == 0) {
            return Collections.emptyList();
        }
        if (size == 1) {
            return new e(list.get(0));
        }
        if (size == 2) {
            return new g(list.get(0), list.get(1));
        }
        if (size == 3) {
            return new f(list.get(0), list.get(1), list.get(2));
        }
        if (size == 4) {
            return new b(list.get(0), list.get(1), list.get(2), list.get(3));
        }
        if (size != 5) {
            return new c(list.toArray());
        }
        a aVar = new a(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4));
        return aVar;
    }

    public static <T> boolean a(List<? extends T> list, List<? extends T> list2) {
        if (list == list2) {
            return true;
        }
        int size = list.size();
        if (size != list2.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (list.get(i) != list2.get(i)) {
                return false;
            }
        }
        return true;
    }
}
