package org.jboss.netty.channel.group;

import java.util.Iterator;
import java.util.NoSuchElementException;

public final class CombinedIterator<E> implements Iterator<E> {
    public Iterator<E> currentIterator;
    public final Iterator<E> i1;
    public final Iterator<E> i2;

    public CombinedIterator(Iterator<E> it, Iterator<E> it2) {
        if (it == null) {
            throw new NullPointerException("i1");
        } else if (it2 != null) {
            this.i1 = it;
            this.i2 = it2;
            this.currentIterator = it;
        } else {
            throw new NullPointerException("i2");
        }
    }

    public boolean hasNext() {
        if (this.currentIterator.hasNext()) {
            return true;
        }
        if (this.currentIterator != this.i1) {
            return false;
        }
        this.currentIterator = this.i2;
        return hasNext();
    }

    public E next() {
        try {
            return this.currentIterator.next();
        } catch (NoSuchElementException e2) {
            if (this.currentIterator == this.i1) {
                this.currentIterator = this.i2;
                return next();
            }
            throw e2;
        }
    }

    public void remove() {
        this.currentIterator.remove();
    }
}
