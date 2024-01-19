package org.apache.javax.imageio.stream;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public class MemoryCacheImageInputStream {
    public int bitOffset;
    public MemoryCache cache = new MemoryCache();
    public long flushedPos = 0;
    public InputStream stream;
    public long streamPos;

    public MemoryCacheImageInputStream(InputStream inputStream) {
        if (inputStream != null) {
            this.stream = inputStream;
            return;
        }
        throw new IllegalArgumentException("stream == null!");
    }

    public int read() throws IOException {
        this.bitOffset = 0;
        long loadFromStream = this.cache.loadFromStream(this.stream, this.streamPos + 1);
        long j = this.streamPos;
        if (loadFromStream < j + 1) {
            return -1;
        }
        MemoryCache memoryCache = this.cache;
        this.streamPos = 1 + j;
        return memoryCache.read(j);
    }

    public long readBits(int i) throws IOException {
        if (i < 0 || i > 64) {
            throw new IllegalArgumentException();
        }
        long j = 0;
        if (i == 0) {
            return 0;
        }
        int i2 = this.bitOffset;
        int i3 = i + i2;
        int i4 = (i2 + i) & 7;
        while (i3 > 0) {
            int read = read();
            if (read != -1) {
                j = (j << 8) | ((long) read);
                i3 -= 8;
            } else {
                throw new EOFException();
            }
        }
        if (i4 != 0) {
            seek(this.streamPos - 1);
        }
        this.bitOffset = i4;
        return (j >>> (-i3)) & (-1 >>> (64 - i));
    }

    public void seek(long j) throws IOException {
        if (j >= this.flushedPos) {
            this.streamPos = j;
            this.bitOffset = 0;
            return;
        }
        throw new IndexOutOfBoundsException("pos < flushedPos!");
    }
}
