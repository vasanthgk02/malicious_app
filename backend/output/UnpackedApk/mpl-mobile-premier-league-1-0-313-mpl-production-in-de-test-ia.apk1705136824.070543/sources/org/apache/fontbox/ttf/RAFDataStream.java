package org.apache.fontbox.ttf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

public class RAFDataStream extends TTFDataStream {
    public RandomAccessFile raf;
    public File ttfFile;

    public RAFDataStream(String str, String str2) throws FileNotFoundException {
        this(new File(str), str2);
    }

    public void close() throws IOException {
        this.raf.close();
        this.raf = null;
    }

    public long getCurrentPosition() throws IOException {
        return this.raf.getFilePointer();
    }

    public InputStream getOriginalData() throws IOException {
        return new FileInputStream(this.ttfFile);
    }

    public int read() throws IOException {
        return this.raf.read();
    }

    public long readLong() throws IOException {
        return this.raf.readLong();
    }

    public short readSignedShort() throws IOException {
        return this.raf.readShort();
    }

    public int readUnsignedShort() throws IOException {
        return this.raf.readUnsignedShort();
    }

    public void seek(long j) throws IOException {
        this.raf.seek(j);
    }

    public RAFDataStream(File file, String str) throws FileNotFoundException {
        this.raf = null;
        this.ttfFile = null;
        this.raf = new RandomAccessFile(file, str);
        this.ttfFile = file;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        return this.raf.read(bArr, i, i2);
    }
}
