package com.facebook.common.streams;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class TailAppendingInputStream extends FilterInputStream {
    public int mMarkedTailOffset;
    public final byte[] mTail;
    public int mTailOffset;

    public TailAppendingInputStream(InputStream inputStream, byte[] bArr) {
        super(inputStream);
        if (bArr != null) {
            this.mTail = bArr;
            return;
        }
        throw null;
    }

    public void mark(int i) {
        if (this.in.markSupported()) {
            super.mark(i);
            this.mMarkedTailOffset = this.mTailOffset;
        }
    }

    public int read() throws IOException {
        int read = this.in.read();
        if (read != -1) {
            return read;
        }
        return readNextTailByte();
    }

    public final int readNextTailByte() {
        int i = this.mTailOffset;
        byte[] bArr = this.mTail;
        if (i >= bArr.length) {
            return -1;
        }
        this.mTailOffset = i + 1;
        return bArr[i] & 255;
    }

    public void reset() throws IOException {
        if (this.in.markSupported()) {
            this.in.reset();
            this.mTailOffset = this.mMarkedTailOffset;
            return;
        }
        throw new IOException("mark is not supported");
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read = this.in.read(bArr, i, i2);
        int i3 = -1;
        if (read != -1) {
            return read;
        }
        int i4 = 0;
        if (i2 == 0) {
            return 0;
        }
        while (i4 < i2) {
            int readNextTailByte = readNextTailByte();
            if (readNextTailByte == -1) {
                break;
            }
            bArr[i + i4] = (byte) readNextTailByte;
            i4++;
        }
        if (i4 > 0) {
            i3 = i4;
        }
        return i3;
    }
}
