package com.facebook.imagepipeline.memory;

import co.hyperverge.hypersnapsdk.c.k;
import java.io.Closeable;
import java.nio.ByteBuffer;

public class BufferMemoryChunk implements MemoryChunk, Closeable {
    public static final String TAG = "BufferMemoryChunk";
    public ByteBuffer mBuffer;
    public final long mId = ((long) System.identityHashCode(this));
    public final int mSize;

    public BufferMemoryChunk(int i) {
        this.mBuffer = ByteBuffer.allocateDirect(i);
        this.mSize = i;
    }

    private void doCopy(int i, MemoryChunk memoryChunk, int i2, int i3) {
        if (memoryChunk instanceof BufferMemoryChunk) {
            k.checkState(!isClosed());
            k.checkState(!memoryChunk.isClosed());
            MemoryChunkUtil.checkBounds(i, memoryChunk.getSize(), i2, i3, this.mSize);
            this.mBuffer.position(i);
            memoryChunk.getByteBuffer().position(i2);
            byte[] bArr = new byte[i3];
            this.mBuffer.get(bArr, 0, i3);
            memoryChunk.getByteBuffer().put(bArr, 0, i3);
            return;
        }
        throw new IllegalArgumentException("Cannot copy two incompatible MemoryChunks");
    }

    public synchronized void close() {
        this.mBuffer = null;
    }

    public void copy(int i, MemoryChunk memoryChunk, int i2, int i3) {
        if (memoryChunk != null) {
            if (memoryChunk.getUniqueId() == getUniqueId()) {
                Long.toHexString(getUniqueId());
                Long.toHexString(memoryChunk.getUniqueId());
                k.checkArgument(false);
            }
            if (memoryChunk.getUniqueId() < getUniqueId()) {
                synchronized (memoryChunk) {
                    synchronized (this) {
                        doCopy(i, memoryChunk, i2, i3);
                    }
                }
                return;
            }
            synchronized (this) {
                synchronized (memoryChunk) {
                    doCopy(i, memoryChunk, i2, i3);
                }
            }
            return;
        }
        throw null;
    }

    public synchronized ByteBuffer getByteBuffer() {
        return this.mBuffer;
    }

    public long getNativePtr() {
        throw new UnsupportedOperationException("Cannot get the pointer of a BufferMemoryChunk");
    }

    public int getSize() {
        return this.mSize;
    }

    public long getUniqueId() {
        return this.mId;
    }

    public synchronized boolean isClosed() {
        return this.mBuffer == null;
    }

    public synchronized int read(int i, byte[] bArr, int i2, int i3) {
        int adjustByteCount;
        if (bArr != null) {
            k.checkState(!isClosed());
            adjustByteCount = MemoryChunkUtil.adjustByteCount(i, i3, this.mSize);
            MemoryChunkUtil.checkBounds(i, bArr.length, i2, adjustByteCount, this.mSize);
            this.mBuffer.position(i);
            this.mBuffer.get(bArr, i2, adjustByteCount);
        } else {
            throw null;
        }
        return adjustByteCount;
    }

    public synchronized int write(int i, byte[] bArr, int i2, int i3) {
        int adjustByteCount;
        if (bArr != null) {
            k.checkState(!isClosed());
            adjustByteCount = MemoryChunkUtil.adjustByteCount(i, i3, this.mSize);
            MemoryChunkUtil.checkBounds(i, bArr.length, i2, adjustByteCount, this.mSize);
            this.mBuffer.position(i);
            this.mBuffer.put(bArr, i2, adjustByteCount);
        } else {
            throw null;
        }
        return adjustByteCount;
    }

    public synchronized byte read(int i) {
        boolean z = true;
        k.checkState(!isClosed());
        k.checkArgument(i >= 0);
        if (i >= this.mSize) {
            z = false;
        }
        k.checkArgument(z);
        return this.mBuffer.get(i);
    }
}
