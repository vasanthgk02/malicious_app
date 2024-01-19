package com.bumptech.glide.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

public class ExceptionCatchingInputStream extends InputStream {
    public static final Queue<ExceptionCatchingInputStream> QUEUE = Util.createQueue(0);
    public IOException exception;
    public InputStream wrapped;

    public int available() throws IOException {
        return this.wrapped.available();
    }

    public void close() throws IOException {
        this.wrapped.close();
    }

    public void mark(int i) {
        this.wrapped.mark(i);
    }

    public boolean markSupported() {
        return this.wrapped.markSupported();
    }

    public int read(byte[] bArr) {
        try {
            return this.wrapped.read(bArr);
        } catch (IOException e2) {
            this.exception = e2;
            return -1;
        }
    }

    public void release() {
        this.exception = null;
        this.wrapped = null;
        synchronized (QUEUE) {
            QUEUE.offer(this);
        }
    }

    public synchronized void reset() throws IOException {
        this.wrapped.reset();
    }

    public long skip(long j) {
        try {
            return this.wrapped.skip(j);
        } catch (IOException e2) {
            this.exception = e2;
            return 0;
        }
    }

    public int read(byte[] bArr, int i, int i2) {
        try {
            return this.wrapped.read(bArr, i, i2);
        } catch (IOException e2) {
            this.exception = e2;
            return -1;
        }
    }

    public int read() {
        try {
            return this.wrapped.read();
        } catch (IOException e2) {
            this.exception = e2;
            return -1;
        }
    }
}
