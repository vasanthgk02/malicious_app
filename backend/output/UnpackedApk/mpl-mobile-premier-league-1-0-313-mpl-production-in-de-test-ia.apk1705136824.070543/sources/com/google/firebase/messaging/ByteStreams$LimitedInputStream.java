package com.google.firebase.messaging;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class ByteStreams$LimitedInputStream extends FilterInputStream {
    public long left;
    public long mark = -1;

    public ByteStreams$LimitedInputStream(InputStream inputStream, long j) {
        super(inputStream);
        this.left = j;
    }

    public int available() throws IOException {
        return (int) Math.min((long) this.in.available(), this.left);
    }

    public synchronized void mark(int i) {
        this.in.mark(i);
        this.mark = this.left;
    }

    public int read() throws IOException {
        if (this.left == 0) {
            return -1;
        }
        int read = this.in.read();
        if (read != -1) {
            this.left--;
        }
        return read;
    }

    public synchronized void reset() throws IOException {
        if (!this.in.markSupported()) {
            throw new IOException("Mark not supported");
        } else if (this.mark != -1) {
            this.in.reset();
            this.left = this.mark;
        } else {
            throw new IOException("Mark not set");
        }
    }

    public long skip(long j) throws IOException {
        long skip = this.in.skip(Math.min(j, this.left));
        this.left -= skip;
        return skip;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        long j = this.left;
        if (j == 0) {
            return -1;
        }
        int read = this.in.read(bArr, i, (int) Math.min((long) i2, j));
        if (read != -1) {
            this.left -= (long) read;
        }
        return read;
    }
}
