package com.bumptech.glide.util;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class ContentLengthInputStream extends FilterInputStream {
    public final long contentLength;
    public int readSoFar;

    public ContentLengthInputStream(InputStream inputStream, long j) {
        super(inputStream);
        this.contentLength = j;
    }

    public synchronized int available() throws IOException {
        return (int) Math.max(this.contentLength - ((long) this.readSoFar), (long) this.in.available());
    }

    public final int checkReadSoFarOrThrow(int i) throws IOException {
        if (i >= 0) {
            this.readSoFar += i;
        } else if (this.contentLength - ((long) this.readSoFar) > 0) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Failed to read all expected data, expected: ");
            outline73.append(this.contentLength);
            outline73.append(", but read: ");
            outline73.append(this.readSoFar);
            throw new IOException(outline73.toString());
        }
        return i;
    }

    public synchronized int read() throws IOException {
        int read;
        read = super.read();
        checkReadSoFarOrThrow(read >= 0 ? 1 : -1);
        return read;
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public synchronized int read(byte[] bArr, int i, int i2) throws IOException {
        int read;
        read = super.read(bArr, i, i2);
        checkReadSoFarOrThrow(read);
        return read;
    }
}
