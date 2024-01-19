package org.apache.fontbox.ttf;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public abstract class TTFDataStream implements Closeable {
    public abstract void close() throws IOException;

    public abstract long getCurrentPosition() throws IOException;

    public abstract InputStream getOriginalData() throws IOException;

    public abstract int read() throws IOException;

    public abstract int read(byte[] bArr, int i, int i2) throws IOException;

    public byte[] read(int i) throws IOException {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int read = read(bArr, i2, i - i2);
            if (read == -1) {
                break;
            }
            i2 += read;
        }
        if (i2 == i) {
            return bArr;
        }
        throw new IOException("Unexpected end of TTF stream reached");
    }

    public float read32Fixed() throws IOException {
        return (float) ((((double) readUnsignedShort()) / 65536.0d) + ((double) ((float) readSignedShort())));
    }

    public Calendar readInternationalDate() throws IOException {
        long readLong = readLong();
        Calendar instance = GregorianCalendar.getInstance(TimeZone.getTimeZone("UTC"));
        instance.set(1904, 0, 1, 0, 0, 0);
        instance.set(14, 0);
        instance.setTimeInMillis((readLong * 1000) + instance.getTimeInMillis());
        return instance;
    }

    public abstract long readLong() throws IOException;

    public int readSignedByte() throws IOException {
        int read = read();
        return read < 127 ? read : read - 256;
    }

    public abstract short readSignedShort() throws IOException;

    public String readString(int i) throws IOException {
        return readString(i, "ISO-8859-1");
    }

    public int readUnsignedByte() throws IOException {
        int read = read();
        if (read != -1) {
            return read;
        }
        throw new EOFException("premature EOF");
    }

    public int[] readUnsignedByteArray(int i) throws IOException {
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = read();
        }
        return iArr;
    }

    public long readUnsignedInt() throws IOException {
        long read = (long) read();
        long read2 = (long) read();
        long read3 = (long) read();
        long read4 = (long) read();
        if (read4 >= 0) {
            return (read << 24) + (read2 << 16) + (read3 << 8) + (read4 << 0);
        }
        throw new EOFException();
    }

    public abstract int readUnsignedShort() throws IOException;

    public int[] readUnsignedShortArray(int i) throws IOException {
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = readUnsignedShort();
        }
        return iArr;
    }

    public abstract void seek(long j) throws IOException;

    public String readString(int i, String str) throws IOException {
        return new String(read(i), str);
    }
}
