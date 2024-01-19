package org.apache.javax.imageio.stream;

import java.io.IOException;
import java.io.OutputStream;

public class MemoryCacheImageOutputStream {
    public int bitOffset;
    public MemoryCache cache = new MemoryCache();
    public long flushedPos = 0;
    public OutputStream stream;
    public long streamPos;

    public MemoryCacheImageOutputStream(OutputStream outputStream) {
        if (outputStream != null) {
            this.stream = outputStream;
            return;
        }
        throw new IllegalArgumentException("stream == null!");
    }

    public void flush() throws IOException {
        flushBefore(this.streamPos);
    }

    public void flushBefore(long j) throws IOException {
        if (j < this.flushedPos) {
            throw new IndexOutOfBoundsException("pos < flushedPos!");
        } else if (j <= this.streamPos) {
            this.flushedPos = j;
        } else {
            throw new IndexOutOfBoundsException("pos > getStreamPosition()!");
        }
    }

    public final void flushBits() throws IOException {
        int i = this.bitOffset;
        if (i != 0) {
            int read = read();
            int i2 = 0;
            if (read < 0) {
                this.bitOffset = 0;
            } else {
                seek(this.streamPos - 1);
                i2 = read & (-1 << (8 - i));
            }
            write(i2);
        }
    }

    public int read() throws IOException {
        this.bitOffset = 0;
        int read = this.cache.read(this.streamPos);
        if (read != -1) {
            this.streamPos++;
        }
        return read;
    }

    public void seek(long j) throws IOException {
        if (j >= this.flushedPos) {
            this.streamPos = j;
            this.bitOffset = 0;
            return;
        }
        throw new IndexOutOfBoundsException("pos < flushedPos!");
    }

    public void write(int i) throws IOException {
        flushBits();
        this.cache.write(i, this.streamPos);
        this.streamPos++;
    }

    public void writeBits(long j, int i) throws IOException {
        if (i < 0 || i > 64) {
            throw new IllegalArgumentException("Bad value for numBits!");
        } else if (i != 0) {
            if (this.streamPos > 0 || this.bitOffset > 0) {
                int i2 = this.bitOffset;
                int read = read();
                if (read != -1) {
                    seek(this.streamPos - 1);
                } else {
                    read = 0;
                }
                int i3 = i + i2;
                if (i3 < 8) {
                    int i4 = 8 - i3;
                    int i5 = -1 >>> (32 - i);
                    write((int) (((j & ((long) i5)) << i4) | ((long) (read & (~(i5 << i4))))));
                    seek(this.streamPos - 1);
                    this.bitOffset = i3;
                } else {
                    int i6 = 8 - i2;
                    int i7 = -1 >>> (32 - i6);
                    write((int) (((j >> (i - i6)) & ((long) i7)) | ((long) (read & (~i7)))));
                }
            }
        }
    }
}
