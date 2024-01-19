package com.facebook.imagepipeline.memory;

import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.common.memory.PooledByteBufferOutputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import java.io.IOException;

public class MemoryPooledByteBufferOutputStream extends PooledByteBufferOutputStream {
    public CloseableReference<MemoryChunk> mBufRef;
    public int mCount;
    public final MemoryChunkPool mPool;

    public static class InvalidStreamException extends RuntimeException {
        public InvalidStreamException() {
            super("OutputStream no longer valid");
        }
    }

    public MemoryPooledByteBufferOutputStream(MemoryChunkPool memoryChunkPool) {
        this(memoryChunkPool, memoryChunkPool.getMinBufferSize());
    }

    private void ensureValid() {
        if (!CloseableReference.isValid(this.mBufRef)) {
            throw new InvalidStreamException();
        }
    }

    public void close() {
        CloseableReference.closeSafely(this.mBufRef);
        this.mBufRef = null;
        this.mCount = -1;
        super.close();
    }

    public void realloc(int i) {
        ensureValid();
        if (i > ((MemoryChunk) this.mBufRef.get()).getSize()) {
            MemoryChunk memoryChunk = (MemoryChunk) this.mPool.get(i);
            ((MemoryChunk) this.mBufRef.get()).copy(0, memoryChunk, 0, this.mCount);
            this.mBufRef.close();
            this.mBufRef = CloseableReference.of(memoryChunk, (ResourceReleaser<T>) this.mPool);
        }
    }

    public int size() {
        return this.mCount;
    }

    public void write(int i) throws IOException {
        write(new byte[]{(byte) i});
    }

    public MemoryPooledByteBufferOutputStream(MemoryChunkPool memoryChunkPool, int i) {
        k.checkArgument(i > 0);
        if (memoryChunkPool != null) {
            this.mPool = memoryChunkPool;
            this.mCount = 0;
            this.mBufRef = CloseableReference.of(memoryChunkPool.get(i), (ResourceReleaser<T>) this.mPool);
            return;
        }
        throw null;
    }

    public MemoryPooledByteBuffer toByteBuffer() {
        ensureValid();
        return new MemoryPooledByteBuffer(this.mBufRef, this.mCount);
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        if (i < 0 || i2 < 0 || i + i2 > bArr.length) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("length=");
            outline73.append(bArr.length);
            outline73.append("; regionStart=");
            outline73.append(i);
            outline73.append("; regionLength=");
            outline73.append(i2);
            throw new ArrayIndexOutOfBoundsException(outline73.toString());
        }
        ensureValid();
        realloc(this.mCount + i2);
        ((MemoryChunk) this.mBufRef.get()).write(this.mCount, bArr, i, i2);
        this.mCount += i2;
    }
}
