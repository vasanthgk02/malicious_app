package com.facebook.common.memory;

import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.InputStream;

public class PooledByteBufferInputStream extends InputStream {
    public int mMark = 0;
    public int mOffset = 0;
    public final PooledByteBuffer mPooledByteBuffer;

    public PooledByteBufferInputStream(PooledByteBuffer pooledByteBuffer) {
        k.checkArgument(!pooledByteBuffer.isClosed());
        this.mPooledByteBuffer = pooledByteBuffer;
    }

    public int available() {
        return this.mPooledByteBuffer.size() - this.mOffset;
    }

    public void mark(int i) {
        this.mMark = this.mOffset;
    }

    public boolean markSupported() {
        return true;
    }

    public int read() {
        if (available() <= 0) {
            return -1;
        }
        PooledByteBuffer pooledByteBuffer = this.mPooledByteBuffer;
        int i = this.mOffset;
        this.mOffset = i + 1;
        return pooledByteBuffer.read(i) & 255;
    }

    public void reset() {
        this.mOffset = this.mMark;
    }

    public long skip(long j) {
        k.checkArgument(j >= 0);
        int min = Math.min((int) j, available());
        this.mOffset += min;
        return (long) min;
    }

    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) {
        if (i < 0 || i2 < 0 || i + i2 > bArr.length) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("length=");
            outline73.append(bArr.length);
            outline73.append("; regionStart=");
            outline73.append(i);
            outline73.append("; regionLength=");
            outline73.append(i2);
            throw new ArrayIndexOutOfBoundsException(outline73.toString());
        }
        int available = available();
        if (available <= 0) {
            return -1;
        }
        if (i2 <= 0) {
            return 0;
        }
        int min = Math.min(available, i2);
        this.mPooledByteBuffer.read(this.mOffset, bArr, i, min);
        this.mOffset += min;
        return min;
    }
}
