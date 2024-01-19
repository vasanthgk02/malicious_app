package com.squareup.tape2;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public final class InMemoryObjectQueue<T> extends ObjectQueue<T> {
    public boolean closed;
    public final Deque<T> entries = new ArrayDeque();
    public int modCount = 0;

    public final class EntryIterator implements Iterator<T> {
        public final Iterator<T> delegate;
        public int expectedModCount = InMemoryObjectQueue.this.modCount;
        public int index = 0;

        public EntryIterator(Iterator<T> it) {
            this.delegate = it;
        }

        private void checkForComodification() {
            if (InMemoryObjectQueue.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        public boolean hasNext() {
            checkForComodification();
            return this.delegate.hasNext();
        }

        public T next() {
            if (!InMemoryObjectQueue.this.closed) {
                checkForComodification();
                T next = this.delegate.next();
                this.index++;
                return next;
            }
            throw new IllegalStateException("closed");
        }

        public void remove() {
            if (!InMemoryObjectQueue.this.closed) {
                checkForComodification();
                if (InMemoryObjectQueue.this.size() == 0) {
                    throw new NoSuchElementException();
                } else if (this.index == 1) {
                    InMemoryObjectQueue.this.remove();
                    this.expectedModCount = InMemoryObjectQueue.this.modCount;
                    this.index--;
                } else {
                    throw new UnsupportedOperationException("Removal is only permitted from the head.");
                }
            } else {
                throw new IllegalStateException("closed");
            }
        }
    }

    public void add(T t) {
        if (!this.closed) {
            this.modCount++;
            this.entries.addLast(t);
            return;
        }
        throw new IllegalStateException("closed");
    }

    public List<T> asList() {
        return Collections.unmodifiableList(new ArrayList(this.entries));
    }

    public void close() {
        this.closed = true;
    }

    public QueueFile file() {
        return null;
    }

    public Iterator<T> iterator() {
        return new EntryIterator(this.entries.iterator());
    }

    public T peek() {
        if (!this.closed) {
            return this.entries.peekFirst();
        }
        throw new IllegalStateException("closed");
    }

    public void remove() {
        remove(1);
    }

    public int size() {
        return this.entries.size();
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("InMemoryObjectQueue{size=");
        outline73.append(this.entries.size());
        outline73.append('}');
        return outline73.toString();
    }

    public void remove(int i) {
        if (!this.closed) {
            this.modCount++;
            for (int i2 = 0; i2 < i; i2++) {
                this.entries.removeFirst();
            }
            return;
        }
        throw new IllegalStateException("closed");
    }
}
