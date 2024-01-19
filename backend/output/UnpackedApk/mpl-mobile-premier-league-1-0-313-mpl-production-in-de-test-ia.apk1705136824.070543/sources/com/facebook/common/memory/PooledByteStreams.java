package com.facebook.common.memory;

import co.hyperverge.hypersnapsdk.c.k;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class PooledByteStreams {
    public final ByteArrayPool mByteArrayPool;
    public final int mTempBufSize = 16384;

    public PooledByteStreams(ByteArrayPool byteArrayPool) {
        k.checkArgument(true);
        this.mByteArrayPool = byteArrayPool;
    }

    public long copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = (byte[]) this.mByteArrayPool.get(this.mTempBufSize);
        long j = 0;
        while (true) {
            try {
                int read = inputStream.read(bArr, 0, this.mTempBufSize);
                if (read == -1) {
                    return j;
                }
                outputStream.write(bArr, 0, read);
                j += (long) read;
            } finally {
                this.mByteArrayPool.release(bArr);
            }
        }
    }
}
