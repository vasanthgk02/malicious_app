package com.google.crypto.tink.shaded.protobuf;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public class UnmodifiableLazyStringList extends AbstractList<String> implements LazyStringList, RandomAccess {
    public final LazyStringList list;

    public UnmodifiableLazyStringList(LazyStringList lazyStringList) {
        this.list = lazyStringList;
    }

    public void add(ByteString byteString) {
        throw new UnsupportedOperationException();
    }

    public Object get(int i) {
        return (String) this.list.get(i);
    }

    public Object getRaw(int i) {
        return this.list.getRaw(i);
    }

    public List<?> getUnderlyingElements() {
        return this.list.getUnderlyingElements();
    }

    public LazyStringList getUnmodifiableView() {
        return this;
    }

    public Iterator<String> iterator() {
        return new Iterator<String>() {
            public Iterator<String> iter = UnmodifiableLazyStringList.this.list.iterator();

            public boolean hasNext() {
                return this.iter.hasNext();
            }

            public Object next() {
                return this.iter.next();
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public ListIterator<String> listIterator(final int i) {
        return new ListIterator<String>() {
            public ListIterator<String> iter = UnmodifiableLazyStringList.this.list.listIterator(i);

            public void add(Object obj) {
                String str = (String) obj;
                throw new UnsupportedOperationException();
            }

            public boolean hasNext() {
                return this.iter.hasNext();
            }

            public boolean hasPrevious() {
                return this.iter.hasPrevious();
            }

            public Object next() {
                return this.iter.next();
            }

            public int nextIndex() {
                return this.iter.nextIndex();
            }

            public Object previous() {
                return this.iter.previous();
            }

            public int previousIndex() {
                return this.iter.previousIndex();
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }

            public void set(Object obj) {
                String str = (String) obj;
                throw new UnsupportedOperationException();
            }
        };
    }

    public int size() {
        return this.list.size();
    }
}
