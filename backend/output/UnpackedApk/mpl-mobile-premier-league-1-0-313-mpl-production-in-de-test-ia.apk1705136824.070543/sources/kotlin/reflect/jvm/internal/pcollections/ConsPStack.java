package kotlin.reflect.jvm.internal.pcollections;

import java.util.Iterator;

public final class ConsPStack<E> implements Iterable<E> {
    public static final ConsPStack<Object> EMPTY = new ConsPStack<>();
    public final E first;
    public final ConsPStack<E> rest;
    public final int size;

    public static class Itr<E> implements Iterator<E> {
        public ConsPStack<E> next;

        public Itr(ConsPStack<E> consPStack) {
            this.next = consPStack;
        }

        public boolean hasNext() {
            return this.next.size > 0;
        }

        public E next() {
            ConsPStack<E> consPStack = this.next;
            E e2 = consPStack.first;
            this.next = consPStack.rest;
            return e2;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public ConsPStack() {
        this.size = 0;
        this.first = null;
        this.rest = null;
    }

    public Iterator<E> iterator() {
        return new Itr(subList(0));
    }

    public final ConsPStack<E> minus(Object obj) {
        if (this.size == 0) {
            return this;
        }
        if (this.first.equals(obj)) {
            return this.rest;
        }
        ConsPStack<E> minus = this.rest.minus(obj);
        if (minus == this.rest) {
            return this;
        }
        return new ConsPStack<>(this.first, minus);
    }

    public final ConsPStack<E> subList(int i) {
        if (i < 0 || i > this.size) {
            throw new IndexOutOfBoundsException();
        } else if (i == 0) {
            return this;
        } else {
            return this.rest.subList(i - 1);
        }
    }

    public ConsPStack(E e2, ConsPStack<E> consPStack) {
        this.first = e2;
        this.rest = consPStack;
        this.size = consPStack.size + 1;
    }
}
