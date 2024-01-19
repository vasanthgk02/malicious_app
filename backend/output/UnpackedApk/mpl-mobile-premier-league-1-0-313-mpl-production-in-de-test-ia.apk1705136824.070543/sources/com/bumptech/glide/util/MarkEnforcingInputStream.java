package com.bumptech.glide.util;

import androidx.recyclerview.widget.LinearLayoutManager;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MarkEnforcingInputStream extends FilterInputStream {
    public int availableBytes = LinearLayoutManager.INVALID_OFFSET;

    public MarkEnforcingInputStream(InputStream inputStream) {
        super(inputStream);
    }

    public int available() throws IOException {
        int i = this.availableBytes;
        if (i == Integer.MIN_VALUE) {
            return super.available();
        }
        return Math.min(i, super.available());
    }

    public final long getBytesToRead(long j) {
        int i = this.availableBytes;
        if (i == 0) {
            return -1;
        }
        if (i != Integer.MIN_VALUE && j > ((long) i)) {
            j = (long) i;
        }
        return j;
    }

    public synchronized void mark(int i) {
        super.mark(i);
        this.availableBytes = i;
    }

    public int read() throws IOException {
        if (getBytesToRead(1) == -1) {
            return -1;
        }
        int read = super.read();
        updateAvailableBytesAfterRead(1);
        return read;
    }

    public synchronized void reset() throws IOException {
        super.reset();
        this.availableBytes = LinearLayoutManager.INVALID_OFFSET;
    }

    public long skip(long j) throws IOException {
        long bytesToRead = getBytesToRead(j);
        if (bytesToRead == -1) {
            return 0;
        }
        long skip = super.skip(bytesToRead);
        updateAvailableBytesAfterRead(skip);
        return skip;
    }

    public final void updateAvailableBytesAfterRead(long j) {
        int i = this.availableBytes;
        if (i != Integer.MIN_VALUE && j != -1) {
            this.availableBytes = (int) (((long) i) - j);
        }
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int bytesToRead = (int) getBytesToRead((long) i2);
        if (bytesToRead == -1) {
            return -1;
        }
        int read = super.read(bArr, i, bytesToRead);
        updateAvailableBytesAfterRead((long) read);
        return read;
    }
}
