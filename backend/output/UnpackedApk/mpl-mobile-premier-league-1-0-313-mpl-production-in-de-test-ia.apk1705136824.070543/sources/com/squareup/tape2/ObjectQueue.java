package com.squareup.tape2;

import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class ObjectQueue<T> implements Iterable<T>, Closeable {

    public interface Converter<T> {
        T from(byte[] bArr) throws IOException;

        void toStream(T t, OutputStream outputStream) throws IOException;
    }

    public static <T> ObjectQueue<T> create(QueueFile queueFile, Converter<T> converter) {
        return new FileObjectQueue(queueFile, converter);
    }

    public static <T> ObjectQueue<T> createInMemory() {
        return new InMemoryObjectQueue();
    }

    public abstract void add(T t) throws IOException;

    public List<T> asList() throws IOException {
        return peek(size());
    }

    public void clear() throws IOException {
        remove(size());
    }

    public abstract QueueFile file();

    public boolean isEmpty() {
        return size() == 0;
    }

    public abstract T peek() throws IOException;

    public List<T> peek(int i) throws IOException {
        int min = Math.min(i, size());
        ArrayList arrayList = new ArrayList(min);
        Iterator it = iterator();
        for (int i2 = 0; i2 < min; i2++) {
            arrayList.add(it.next());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public void remove() throws IOException {
        remove(1);
    }

    public abstract void remove(int i) throws IOException;

    public abstract int size();
}
