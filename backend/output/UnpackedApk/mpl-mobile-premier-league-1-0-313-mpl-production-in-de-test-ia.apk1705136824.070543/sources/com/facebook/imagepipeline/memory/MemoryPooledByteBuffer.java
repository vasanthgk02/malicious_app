package com.facebook.imagepipeline.memory;

import co.hyperverge.hypersnapsdk.c.k;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBuffer.ClosedException;
import com.facebook.common.references.CloseableReference;
import java.nio.ByteBuffer;

public class MemoryPooledByteBuffer implements PooledByteBuffer {
    public CloseableReference<MemoryChunk> mBufRef;
    public final int mSize;

    public MemoryPooledByteBuffer(CloseableReference<MemoryChunk> closeableReference, int i) {
        if (closeableReference != null) {
            k.checkArgument(i >= 0 && i <= ((MemoryChunk) closeableReference.get()).getSize());
            this.mBufRef = closeableReference.clone();
            this.mSize = i;
            return;
        }
        throw null;
    }

    public synchronized void close() {
        CloseableReference.closeSafely(this.mBufRef);
        this.mBufRef = null;
    }

    public synchronized void ensureValid() {
        if (isClosed()) {
            throw new ClosedException();
        }
    }

    public synchronized ByteBuffer getByteBuffer() {
        return ((MemoryChunk) this.mBufRef.get()).getByteBuffer();
    }

    public CloseableReference<MemoryChunk> getCloseableReference() {
        return this.mBufRef;
    }

    public synchronized long getNativePtr() throws UnsupportedOperationException {
        ensureValid();
        return ((MemoryChunk) this.mBufRef.get()).getNativePtr();
    }

    public synchronized boolean isClosed() {
        return !CloseableReference.isValid(this.mBufRef);
    }

    public synchronized byte read(int i) {
        ensureValid();
        boolean z = true;
        k.checkArgument(i >= 0);
        if (i >= this.mSize) {
            z = false;
        }
        k.checkArgument(z);
        return ((MemoryChunk) this.mBufRef.get()).read(i);
    }

    public synchronized int size() {
        ensureValid();
        return this.mSize;
    }

    public synchronized int read(int i, byte[] bArr, int i2, int i3) {
        ensureValid();
        k.checkArgument(i + i3 <= this.mSize);
        return ((MemoryChunk) this.mBufRef.get()).read(i, bArr, i2, i3);
    }
}
