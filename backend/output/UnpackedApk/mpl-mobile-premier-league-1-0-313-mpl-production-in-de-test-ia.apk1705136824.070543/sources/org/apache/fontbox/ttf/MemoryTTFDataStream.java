package org.apache.fontbox.ttf;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public class MemoryTTFDataStream extends TTFDataStream {
    public int currentPosition = 0;
    public byte[] data = null;

    public MemoryTTFDataStream(InputStream inputStream) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(inputStream.available());
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    this.data = byteArrayOutputStream.toByteArray();
                    inputStream.close();
                    return;
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
    }

    public void close() throws IOException {
        this.data = null;
    }

    public long getCurrentPosition() throws IOException {
        return (long) this.currentPosition;
    }

    public InputStream getOriginalData() throws IOException {
        return new ByteArrayInputStream(this.data);
    }

    public int read() throws IOException {
        int i = this.currentPosition;
        byte[] bArr = this.data;
        if (i >= bArr.length) {
            return -1;
        }
        byte b2 = bArr[i];
        this.currentPosition = i + 1;
        return (b2 + 256) % 256;
    }

    public long readLong() throws IOException {
        return (((long) readSignedInt()) << 32) + (((long) readSignedInt()) & 4294967295L);
    }

    public int readSignedInt() throws IOException {
        int read = read();
        int read2 = read();
        int read3 = read();
        int read4 = read();
        if ((read | read2 | read3 | read4) >= 0) {
            return (read << 24) + (read2 << 16) + (read3 << 8) + (read4 << 0);
        }
        throw new EOFException();
    }

    public short readSignedShort() throws IOException {
        int read = read();
        int read2 = read();
        if ((read | read2) >= 0) {
            return (short) ((read << 8) + (read2 << 0));
        }
        throw new EOFException();
    }

    public int readUnsignedShort() throws IOException {
        int read = read();
        int read2 = read();
        if ((read | read2) >= 0) {
            return (read << 8) + (read2 << 0);
        }
        throw new EOFException();
    }

    public void seek(long j) throws IOException {
        this.currentPosition = (int) j;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.currentPosition;
        byte[] bArr2 = this.data;
        if (i3 >= bArr2.length) {
            return -1;
        }
        int min = Math.min(i2, bArr2.length - i3);
        System.arraycopy(this.data, this.currentPosition, bArr, i, min);
        this.currentPosition += min;
        return min;
    }
}
