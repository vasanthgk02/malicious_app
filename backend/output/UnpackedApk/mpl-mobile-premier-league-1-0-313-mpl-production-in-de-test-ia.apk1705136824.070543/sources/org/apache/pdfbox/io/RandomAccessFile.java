package org.apache.pdfbox.io;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class RandomAccessFile implements RandomAccess, Closeable {
    public boolean isClosed;
    public final java.io.RandomAccessFile ras;

    public RandomAccessFile(File file, String str) throws FileNotFoundException {
        this.ras = new java.io.RandomAccessFile(file, str);
    }

    public void close() throws IOException {
        this.ras.close();
        this.isClosed = true;
    }

    public long getPosition() throws IOException {
        return this.ras.getFilePointer();
    }

    public boolean isClosed() {
        return this.isClosed;
    }

    public long length() throws IOException {
        return this.ras.length();
    }

    public int read() throws IOException {
        return this.ras.read();
    }

    public void seek(long j) throws IOException {
        this.ras.seek(j);
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.ras.write(bArr, i, i2);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        return this.ras.read(bArr, i, i2);
    }

    public void write(int i) throws IOException {
        this.ras.write(i);
    }
}
