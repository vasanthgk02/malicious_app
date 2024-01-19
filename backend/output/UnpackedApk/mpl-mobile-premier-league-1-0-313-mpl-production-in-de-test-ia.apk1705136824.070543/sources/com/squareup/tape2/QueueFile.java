package com.squareup.tape2;

import android.support.v4.media.session.PlaybackStateCompat;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.apache.fontbox.cmap.CMapParser;
import org.apache.fontbox.ttf.GlyfDescript;

public final class QueueFile implements Closeable, Iterable<byte[]> {
    public static final int INITIAL_LENGTH = 4096;
    public static final int VERSIONED_HEADER = -2147483647;
    public static final byte[] ZEROES = new byte[4096];
    public final byte[] buffer = new byte[32];
    public boolean closed;
    public int elementCount;
    public final File file;
    public long fileLength;
    public Element first;
    public final int headerLength;
    public Element last;
    public int modCount = 0;
    public final RandomAccessFile raf;
    public final boolean versioned;
    public final boolean zero;

    public static final class Builder {
        public final File file;
        public boolean forceLegacy = false;
        public boolean zero = true;

        public Builder(File file2) {
            if (file2 != null) {
                this.file = file2;
                return;
            }
            throw new NullPointerException("file == null");
        }

        public QueueFile build() throws IOException {
            RandomAccessFile initializeFromFile = QueueFile.initializeFromFile(this.file, this.forceLegacy);
            try {
                return new QueueFile(this.file, initializeFromFile, this.zero, this.forceLegacy);
            } catch (Throwable th) {
                initializeFromFile.close();
                throw th;
            }
        }

        public Builder forceLegacy(boolean z) {
            this.forceLegacy = z;
            return this;
        }

        public Builder zero(boolean z) {
            this.zero = z;
            return this;
        }
    }

    public static class Element {
        public static final int HEADER_LENGTH = 4;
        public static final Element NULL = new Element(0, 0);
        public final int length;
        public final long position;

        public Element(long j, int i) {
            this.position = j;
            this.length = i;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(Element.class.getSimpleName());
            sb.append("[position=");
            sb.append(this.position);
            sb.append(", length=");
            return GeneratedOutlineSupport.outline57(sb, this.length, CMapParser.MARK_END_OF_ARRAY);
        }
    }

    public final class ElementIterator implements Iterator<byte[]> {
        public int expectedModCount;
        public int nextElementIndex = 0;
        public long nextElementPosition;

        public ElementIterator() {
            QueueFile queueFile = QueueFile.this;
            this.nextElementPosition = queueFile.first.position;
            this.expectedModCount = queueFile.modCount;
        }

        private void checkForComodification() {
            if (QueueFile.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        public boolean hasNext() {
            if (!QueueFile.this.closed) {
                checkForComodification();
                return this.nextElementIndex != QueueFile.this.elementCount;
            }
            throw new IllegalStateException("closed");
        }

        public void remove() {
            checkForComodification();
            if (QueueFile.this.isEmpty()) {
                throw new NoSuchElementException();
            } else if (this.nextElementIndex == 1) {
                try {
                    QueueFile.this.remove();
                    this.expectedModCount = QueueFile.this.modCount;
                    this.nextElementIndex--;
                } catch (IOException e2) {
                    throw ((Error) QueueFile.getSneakyThrowable(e2));
                }
            } else {
                throw new UnsupportedOperationException("Removal is only permitted from the head.");
            }
        }

        public byte[] next() {
            if (!QueueFile.this.closed) {
                checkForComodification();
                if (!QueueFile.this.isEmpty()) {
                    int i = this.nextElementIndex;
                    QueueFile queueFile = QueueFile.this;
                    if (i < queueFile.elementCount) {
                        try {
                            Element readElement = queueFile.readElement(this.nextElementPosition);
                            byte[] bArr = new byte[readElement.length];
                            long wrapPosition = QueueFile.this.wrapPosition(readElement.position + 4);
                            this.nextElementPosition = wrapPosition;
                            QueueFile.this.ringRead(wrapPosition, bArr, 0, readElement.length);
                            this.nextElementPosition = QueueFile.this.wrapPosition(readElement.position + 4 + ((long) readElement.length));
                            this.nextElementIndex++;
                            return bArr;
                        } catch (IOException e2) {
                            throw ((Error) QueueFile.getSneakyThrowable(e2));
                        }
                    } else {
                        throw new NoSuchElementException();
                    }
                } else {
                    throw new NoSuchElementException();
                }
            } else {
                throw new IllegalStateException("closed");
            }
        }
    }

    public QueueFile(File file2, RandomAccessFile randomAccessFile, boolean z, boolean z2) throws IOException {
        long j;
        long j2;
        this.file = file2;
        this.raf = randomAccessFile;
        this.zero = z;
        randomAccessFile.seek(0);
        randomAccessFile.readFully(this.buffer);
        boolean z3 = !z2 && (this.buffer[0] & 128) != 0;
        this.versioned = z3;
        if (z3) {
            this.headerLength = 32;
            int readInt = readInt(this.buffer, 0) & Integer.MAX_VALUE;
            if (readInt == 1) {
                this.fileLength = readLong(this.buffer, 4);
                this.elementCount = readInt(this.buffer, 12);
                j = readLong(this.buffer, 16);
                j2 = readLong(this.buffer, 24);
            } else {
                throw new IOException(GeneratedOutlineSupport.outline42("Unable to read version ", readInt, " format. Supported versions are 1 and legacy."));
            }
        } else {
            this.headerLength = 16;
            this.fileLength = (long) readInt(this.buffer, 0);
            this.elementCount = readInt(this.buffer, 4);
            j = (long) readInt(this.buffer, 8);
            j2 = (long) readInt(this.buffer, 12);
        }
        if (this.fileLength > randomAccessFile.length()) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("File is truncated. Expected length: ");
            outline73.append(this.fileLength);
            outline73.append(", Actual length: ");
            outline73.append(randomAccessFile.length());
            throw new IOException(outline73.toString());
        } else if (this.fileLength > ((long) this.headerLength)) {
            this.first = readElement(j);
            this.last = readElement(j2);
        } else {
            throw new IOException(GeneratedOutlineSupport.outline58(GeneratedOutlineSupport.outline73("File is corrupt; length stored in header ("), this.fileLength, ") is invalid."));
        }
    }

    private void expandIfNecessary(long j) throws IOException {
        long j2;
        long j3;
        long j4 = j + 4;
        long remainingBytes = remainingBytes();
        if (remainingBytes < j4) {
            long j5 = this.fileLength;
            while (true) {
                remainingBytes += j5;
                j2 = j5 << 1;
                if (remainingBytes >= j4) {
                    break;
                }
                j5 = j2;
            }
            setLength(j2);
            Element element = this.last;
            long wrapPosition = wrapPosition(element.position + 4 + ((long) element.length));
            if (wrapPosition <= this.first.position) {
                FileChannel channel = this.raf.getChannel();
                channel.position(this.fileLength);
                int i = this.headerLength;
                long j6 = wrapPosition - ((long) i);
                if (channel.transferTo((long) i, j6, channel) == j6) {
                    j3 = j6;
                } else {
                    throw new AssertionError("Copied insufficient number of bytes!");
                }
            } else {
                j3 = 0;
            }
            long j7 = this.last.position;
            long j8 = this.first.position;
            if (j7 < j8) {
                long j9 = (this.fileLength + j7) - ((long) this.headerLength);
                writeHeader(j2, this.elementCount, j8, j9);
                this.last = new Element(j9, this.last.length);
            } else {
                writeHeader(j2, this.elementCount, j8, j7);
            }
            this.fileLength = j2;
            if (this.zero) {
                ringErase((long) this.headerLength, j3);
            }
        }
    }

    public static <T extends Throwable> T getSneakyThrowable(Throwable th) throws Throwable {
        throw th;
    }

    /* JADX INFO: finally extract failed */
    public static RandomAccessFile initializeFromFile(File file2, boolean z) throws IOException {
        if (!file2.exists()) {
            File file3 = new File(file2.getPath() + ".tmp");
            RandomAccessFile open = open(file3);
            try {
                open.setLength(PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM);
                open.seek(0);
                if (z) {
                    open.writeInt(4096);
                } else {
                    open.writeInt(VERSIONED_HEADER);
                    open.writeLong(PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM);
                }
                open.close();
                if (!file3.renameTo(file2)) {
                    throw new IOException("Rename failed!");
                }
            } catch (Throwable th) {
                open.close();
                throw th;
            }
        }
        return open(file2);
    }

    public static RandomAccessFile open(File file2) throws FileNotFoundException {
        return new RandomAccessFile(file2, "rwd");
    }

    public static int readInt(byte[] bArr, int i) {
        return ((bArr[i] & 255) << 24) + ((bArr[i + 1] & 255) << GlyfDescript.X_DUAL) + ((bArr[i + 2] & 255) << 8) + (bArr[i + 3] & 255);
    }

    public static long readLong(byte[] bArr, int i) {
        return ((((long) bArr[i]) & 255) << 56) + ((((long) bArr[i + 1]) & 255) << 48) + ((((long) bArr[i + 2]) & 255) << 40) + ((((long) bArr[i + 3]) & 255) << 32) + ((((long) bArr[i + 4]) & 255) << 24) + ((((long) bArr[i + 5]) & 255) << 16) + ((((long) bArr[i + 6]) & 255) << 8) + (((long) bArr[i + 7]) & 255);
    }

    private long remainingBytes() {
        return this.fileLength - usedBytes();
    }

    private void ringErase(long j, long j2) throws IOException {
        while (j2 > 0) {
            int min = (int) Math.min(j2, (long) ZEROES.length);
            ringWrite(j, ZEROES, 0, min);
            long j3 = (long) min;
            j2 -= j3;
            j += j3;
        }
    }

    private void ringWrite(long j, byte[] bArr, int i, int i2) throws IOException {
        long wrapPosition = wrapPosition(j);
        long j2 = this.fileLength;
        if (((long) i2) + wrapPosition <= j2) {
            this.raf.seek(wrapPosition);
            this.raf.write(bArr, i, i2);
            return;
        }
        int i3 = (int) (j2 - wrapPosition);
        this.raf.seek(wrapPosition);
        this.raf.write(bArr, i, i3);
        this.raf.seek((long) this.headerLength);
        this.raf.write(bArr, i + i3, i2 - i3);
    }

    private void setLength(long j) throws IOException {
        this.raf.setLength(j);
        this.raf.getChannel().force(true);
    }

    private long usedBytes() {
        if (this.elementCount == 0) {
            return (long) this.headerLength;
        }
        Element element = this.last;
        long j = element.position;
        long j2 = this.first.position;
        if (j >= j2) {
            return (j - j2) + 4 + ((long) element.length) + ((long) this.headerLength);
        }
        return (((j + 4) + ((long) element.length)) + this.fileLength) - j2;
    }

    private void writeHeader(long j, int i, long j2, long j3) throws IOException {
        this.raf.seek(0);
        if (this.versioned) {
            writeInt(this.buffer, 0, VERSIONED_HEADER);
            writeLong(this.buffer, 4, j);
            writeInt(this.buffer, 12, i);
            writeLong(this.buffer, 16, j2);
            writeLong(this.buffer, 24, j3);
            this.raf.write(this.buffer, 0, 32);
            return;
        }
        writeInt(this.buffer, 0, (int) j);
        writeInt(this.buffer, 4, i);
        writeInt(this.buffer, 8, (int) j2);
        writeInt(this.buffer, 12, (int) j3);
        this.raf.write(this.buffer, 0, 16);
    }

    public static void writeInt(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) (i2 >> 24);
        bArr[i + 1] = (byte) (i2 >> 16);
        bArr[i + 2] = (byte) (i2 >> 8);
        bArr[i + 3] = (byte) i2;
    }

    public static void writeLong(byte[] bArr, int i, long j) {
        bArr[i] = (byte) ((int) (j >> 56));
        bArr[i + 1] = (byte) ((int) (j >> 48));
        bArr[i + 2] = (byte) ((int) (j >> 40));
        bArr[i + 3] = (byte) ((int) (j >> 32));
        bArr[i + 4] = (byte) ((int) (j >> 24));
        bArr[i + 5] = (byte) ((int) (j >> 16));
        bArr[i + 6] = (byte) ((int) (j >> 8));
        bArr[i + 7] = (byte) ((int) j);
    }

    public void add(byte[] bArr) throws IOException {
        add(bArr, 0, bArr.length);
    }

    public void clear() throws IOException {
        if (!this.closed) {
            writeHeader(PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM, 0, 0, 0);
            if (this.zero) {
                this.raf.seek((long) this.headerLength);
                this.raf.write(ZEROES, 0, 4096 - this.headerLength);
            }
            this.elementCount = 0;
            Element element = Element.NULL;
            this.first = element;
            this.last = element;
            if (this.fileLength > PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) {
                setLength(PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM);
            }
            this.fileLength = PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            this.modCount++;
            return;
        }
        throw new IllegalStateException("closed");
    }

    public void close() throws IOException {
        this.closed = true;
        this.raf.close();
    }

    public File file() {
        return this.file;
    }

    public boolean isEmpty() {
        return this.elementCount == 0;
    }

    public Iterator<byte[]> iterator() {
        return new ElementIterator();
    }

    public byte[] peek() throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        } else if (isEmpty()) {
            return null;
        } else {
            Element element = this.first;
            int i = element.length;
            byte[] bArr = new byte[i];
            ringRead(4 + element.position, bArr, 0, i);
            return bArr;
        }
    }

    public Element readElement(long j) throws IOException {
        if (j == 0) {
            return Element.NULL;
        }
        ringRead(j, this.buffer, 0, 4);
        return new Element(j, readInt(this.buffer, 0));
    }

    public void remove() throws IOException {
        remove(1);
    }

    public void ringRead(long j, byte[] bArr, int i, int i2) throws IOException {
        long wrapPosition = wrapPosition(j);
        long j2 = this.fileLength;
        if (((long) i2) + wrapPosition <= j2) {
            this.raf.seek(wrapPosition);
            this.raf.readFully(bArr, i, i2);
            return;
        }
        int i3 = (int) (j2 - wrapPosition);
        this.raf.seek(wrapPosition);
        this.raf.readFully(bArr, i, i3);
        this.raf.seek((long) this.headerLength);
        this.raf.readFully(bArr, i + i3, i2 - i3);
    }

    public int size() {
        return this.elementCount;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("QueueFile{file=");
        outline73.append(this.file);
        outline73.append(", zero=");
        outline73.append(this.zero);
        outline73.append(", versioned=");
        outline73.append(this.versioned);
        outline73.append(", length=");
        outline73.append(this.fileLength);
        outline73.append(", size=");
        outline73.append(this.elementCount);
        outline73.append(", first=");
        outline73.append(this.first);
        outline73.append(", last=");
        outline73.append(this.last);
        outline73.append('}');
        return outline73.toString();
    }

    public long wrapPosition(long j) {
        long j2 = this.fileLength;
        return j < j2 ? j : (((long) this.headerLength) + j) - j2;
    }

    public void add(byte[] bArr, int i, int i2) throws IOException {
        long j;
        byte[] bArr2 = bArr;
        int i3 = i2;
        if (bArr2 == null) {
            throw new NullPointerException("data == null");
        } else if ((i | i3) < 0 || i3 > bArr2.length - i) {
            throw new IndexOutOfBoundsException();
        } else if (!this.closed) {
            expandIfNecessary((long) i3);
            boolean isEmpty = isEmpty();
            if (isEmpty) {
                j = (long) this.headerLength;
            } else {
                Element element = this.last;
                j = wrapPosition(element.position + 4 + ((long) element.length));
            }
            Element element2 = new Element(j, i3);
            writeInt(this.buffer, 0, i3);
            ringWrite(element2.position, this.buffer, 0, 4);
            ringWrite(element2.position + 4, bArr, i, i2);
            writeHeader(this.fileLength, this.elementCount + 1, isEmpty ? element2.position : this.first.position, element2.position);
            this.last = element2;
            this.elementCount++;
            this.modCount++;
            if (isEmpty) {
                this.first = element2;
            }
        } else {
            throw new IllegalStateException("closed");
        }
    }

    public void remove(int i) throws IOException {
        int i2 = i;
        if (i2 < 0) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline42("Cannot remove negative (", i2, ") number of elements."));
        } else if (i2 != 0) {
            if (i2 == this.elementCount) {
                clear();
            } else if (isEmpty()) {
                throw new NoSuchElementException();
            } else if (i2 <= this.elementCount) {
                Element element = this.first;
                long j = element.position;
                int i3 = element.length;
                long j2 = 0;
                long j3 = j;
                int i4 = 0;
                while (i4 < i2) {
                    j2 += (long) (i3 + 4);
                    long wrapPosition = wrapPosition(j3 + 4 + ((long) i3));
                    ringRead(wrapPosition, this.buffer, 0, 4);
                    i3 = readInt(this.buffer, 0);
                    i4++;
                    j3 = wrapPosition;
                }
                writeHeader(this.fileLength, this.elementCount - i2, j3, this.last.position);
                this.elementCount -= i2;
                this.modCount++;
                this.first = new Element(j3, i3);
                if (this.zero) {
                    ringErase(j, j2);
                }
            } else {
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline57(GeneratedOutlineSupport.outline74("Cannot remove more elements (", i2, ") than present in queue ("), this.elementCount, ")."));
            }
        }
    }
}
