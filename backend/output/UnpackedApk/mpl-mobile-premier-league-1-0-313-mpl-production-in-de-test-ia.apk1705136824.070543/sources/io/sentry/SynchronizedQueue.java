package io.sentry;

import java.util.Queue;

public final class SynchronizedQueue<E> extends SynchronizedCollection<E> implements Queue<E> {
    public static final long serialVersionUID = 1;

    public SynchronizedQueue(Queue<E> queue) {
        super(queue);
    }

    public static <E> SynchronizedQueue<E> synchronizedQueue(Queue<E> queue) {
        return new SynchronizedQueue<>(queue);
    }

    public E element() {
        E element;
        synchronized (this.lock) {
            element = decorated().element();
        }
        return element;
    }

    public boolean equals(Object obj) {
        boolean equals;
        if (obj == this) {
            return true;
        }
        synchronized (this.lock) {
            equals = decorated().equals(obj);
        }
        return equals;
    }

    public int hashCode() {
        int hashCode;
        synchronized (this.lock) {
            hashCode = decorated().hashCode();
        }
        return hashCode;
    }

    public boolean offer(E e2) {
        boolean offer;
        synchronized (this.lock) {
            offer = decorated().offer(e2);
        }
        return offer;
    }

    public E peek() {
        E peek;
        synchronized (this.lock) {
            peek = decorated().peek();
        }
        return peek;
    }

    public E poll() {
        E poll;
        synchronized (this.lock) {
            poll = decorated().poll();
        }
        return poll;
    }

    public E remove() {
        E remove;
        synchronized (this.lock) {
            remove = decorated().remove();
        }
        return remove;
    }

    public SynchronizedQueue(Queue<E> queue, Object obj) {
        super(queue, obj);
    }

    public Queue<E> decorated() {
        return (Queue) super.decorated();
    }
}
