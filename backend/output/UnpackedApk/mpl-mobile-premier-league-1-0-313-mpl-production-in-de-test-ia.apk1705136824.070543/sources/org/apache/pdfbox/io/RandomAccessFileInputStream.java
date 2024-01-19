package org.apache.pdfbox.io;

import java.io.IOException;
import java.io.InputStream;

public class RandomAccessFileInputStream extends InputStream {
    public long currentPosition;
    public final long endPosition;
    public final RandomAccess file;

    public RandomAccessFileInputStream(RandomAccess randomAccess, long j, long j2) {
        this.file = randomAccess;
        this.currentPosition = j;
        this.endPosition = j + j2;
    }

    public int available() {
        return (int) (this.endPosition - this.currentPosition);
    }

    public void close() {
    }

    public int read() throws IOException {
        int i;
        synchronized (this.file) {
            i = -1;
            if (this.currentPosition < this.endPosition) {
                this.file.seek(this.currentPosition);
                this.currentPosition++;
                i = this.file.read();
            }
        }
        return i;
    }

    public long skip(long j) {
        long min = Math.min(j, (long) available());
        this.currentPosition += min;
        return min;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (i2 > available()) {
            i2 = available();
        }
        int i3 = -1;
        if (available() > 0) {
            synchronized (this.file) {
                this.file.seek(this.currentPosition);
                i3 = this.file.read(bArr, i, i2);
            }
        }
        if (i3 > 0) {
            this.currentPosition += (long) i3;
        }
        return i3;
    }
}
