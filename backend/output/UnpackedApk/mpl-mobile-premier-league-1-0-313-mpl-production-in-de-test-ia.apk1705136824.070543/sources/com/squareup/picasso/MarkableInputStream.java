package com.squareup.picasso;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class MarkableInputStream extends InputStream {
    public static final int DEFAULT_BUFFER_SIZE = 4096;
    public static final int DEFAULT_LIMIT_INCREMENT = 1024;
    public boolean allowExpire;
    public long defaultMark;

    /* renamed from: in  reason: collision with root package name */
    public final InputStream f1693in;
    public long limit;
    public int limitIncrement;
    public long offset;
    public long reset;

    public MarkableInputStream(InputStream inputStream) {
        this(inputStream, 4096);
    }

    private void setLimit(long j) {
        try {
            if (this.reset >= this.offset || this.offset > this.limit) {
                this.reset = this.offset;
                this.f1693in.mark((int) (j - this.offset));
            } else {
                this.f1693in.reset();
                this.f1693in.mark((int) (j - this.reset));
                skip(this.reset, this.offset);
            }
            this.limit = j;
        } catch (IOException e2) {
            throw new IllegalStateException("Unable to mark: " + e2);
        }
    }

    private void skip(long j, long j2) throws IOException {
        while (j < j2) {
            long skip = this.f1693in.skip(j2 - j);
            if (skip == 0) {
                if (read() != -1) {
                    skip = 1;
                } else {
                    return;
                }
            }
            j += skip;
        }
    }

    public void allowMarksToExpire(boolean z) {
        this.allowExpire = z;
    }

    public int available() throws IOException {
        return this.f1693in.available();
    }

    public void close() throws IOException {
        this.f1693in.close();
    }

    public void mark(int i) {
        this.defaultMark = savePosition(i);
    }

    public boolean markSupported() {
        return this.f1693in.markSupported();
    }

    public int read() throws IOException {
        if (!this.allowExpire) {
            long j = this.limit;
            if (this.offset + 1 > j) {
                setLimit(j + ((long) this.limitIncrement));
            }
        }
        int read = this.f1693in.read();
        if (read != -1) {
            this.offset++;
        }
        return read;
    }

    public void reset() throws IOException {
        reset(this.defaultMark);
    }

    public long savePosition(int i) {
        long j = this.offset + ((long) i);
        if (this.limit < j) {
            setLimit(j);
        }
        return this.offset;
    }

    public MarkableInputStream(InputStream inputStream, int i) {
        this(inputStream, i, 1024);
    }

    public void reset(long j) throws IOException {
        if (this.offset > this.limit || j < this.reset) {
            throw new IOException("Cannot reset");
        }
        this.f1693in.reset();
        skip(this.reset, j);
        this.offset = j;
    }

    public MarkableInputStream(InputStream inputStream, int i, int i2) {
        this.defaultMark = -1;
        this.allowExpire = true;
        this.limitIncrement = -1;
        this.f1693in = !inputStream.markSupported() ? new BufferedInputStream(inputStream, i) : inputStream;
        this.limitIncrement = i2;
    }

    public long skip(long j) throws IOException {
        if (!this.allowExpire) {
            long j2 = this.offset;
            if (j2 + j > this.limit) {
                setLimit(j2 + j + ((long) this.limitIncrement));
            }
        }
        long skip = this.f1693in.skip(j);
        this.offset += skip;
        return skip;
    }

    public int read(byte[] bArr) throws IOException {
        if (!this.allowExpire) {
            long j = this.offset;
            if (((long) bArr.length) + j > this.limit) {
                setLimit(j + ((long) bArr.length) + ((long) this.limitIncrement));
            }
        }
        int read = this.f1693in.read(bArr);
        if (read != -1) {
            this.offset += (long) read;
        }
        return read;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (!this.allowExpire) {
            long j = this.offset;
            long j2 = (long) i2;
            if (j + j2 > this.limit) {
                setLimit(j + j2 + ((long) this.limitIncrement));
            }
        }
        int read = this.f1693in.read(bArr, i, i2);
        if (read != -1) {
            this.offset += (long) read;
        }
        return read;
    }
}
