package com.squareup.tape2;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.squareup.tape2.ObjectQueue.Converter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Iterator;

public final class FileObjectQueue<T> extends ObjectQueue<T> {
    public final DirectByteArrayOutputStream bytes = new DirectByteArrayOutputStream();
    public final Converter<T> converter;
    public final QueueFile queueFile;

    public static final class DirectByteArrayOutputStream extends ByteArrayOutputStream {
        public byte[] getArray() {
            return this.buf;
        }
    }

    public final class QueueFileIterator implements Iterator<T> {
        public final Iterator<byte[]> iterator;

        public QueueFileIterator(Iterator<byte[]> it) {
            this.iterator = it;
        }

        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        public T next() {
            try {
                return FileObjectQueue.this.converter.from(this.iterator.next());
            } catch (IOException e2) {
                throw ((Error) QueueFile.getSneakyThrowable(e2));
            }
        }

        public void remove() {
            this.iterator.remove();
        }
    }

    public FileObjectQueue(QueueFile queueFile2, Converter<T> converter2) {
        this.queueFile = queueFile2;
        this.converter = converter2;
    }

    public void add(T t) throws IOException {
        this.bytes.reset();
        this.converter.toStream(t, this.bytes);
        this.queueFile.add(this.bytes.getArray(), 0, this.bytes.size());
    }

    public void clear() throws IOException {
        this.queueFile.clear();
    }

    public void close() throws IOException {
        this.queueFile.close();
    }

    public QueueFile file() {
        return this.queueFile;
    }

    public boolean isEmpty() {
        return this.queueFile.isEmpty();
    }

    public Iterator<T> iterator() {
        return new QueueFileIterator(this.queueFile.iterator());
    }

    public T peek() throws IOException {
        byte[] peek = this.queueFile.peek();
        if (peek == null) {
            return null;
        }
        return this.converter.from(peek);
    }

    public void remove() throws IOException {
        this.queueFile.remove();
    }

    public int size() {
        return this.queueFile.size();
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("FileObjectQueue{queueFile=");
        outline73.append(this.queueFile);
        outline73.append('}');
        return outline73.toString();
    }

    public void remove(int i) throws IOException {
        this.queueFile.remove(i);
    }
}
