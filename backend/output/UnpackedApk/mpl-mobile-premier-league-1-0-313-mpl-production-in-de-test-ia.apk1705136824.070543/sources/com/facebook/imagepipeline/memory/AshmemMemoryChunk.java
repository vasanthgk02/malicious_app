package com.facebook.imagepipeline.memory;

import android.annotation.TargetApi;
import android.os.SharedMemory;
import android.system.ErrnoException;
import co.hyperverge.hypersnapsdk.c.k;
import java.io.Closeable;
import java.nio.ByteBuffer;

@TargetApi(27)
public class AshmemMemoryChunk implements MemoryChunk, Closeable {
    public static final String TAG = "AshmemMemoryChunk";
    public ByteBuffer mByteBuffer;
    public final long mId;
    public SharedMemory mSharedMemory;

    public AshmemMemoryChunk(int i) {
        k.checkArgument(i > 0);
        try {
            SharedMemory create = SharedMemory.create(TAG, i);
            this.mSharedMemory = create;
            this.mByteBuffer = create.mapReadWrite();
            this.mId = (long) System.identityHashCode(this);
        } catch (ErrnoException e2) {
            throw new RuntimeException("Fail to create AshmemMemory", e2);
        }
    }

    private void doCopy(int i, MemoryChunk memoryChunk, int i2, int i3) {
        if (memoryChunk instanceof AshmemMemoryChunk) {
            k.checkState(!isClosed());
            k.checkState(!memoryChunk.isClosed());
            MemoryChunkUtil.checkBounds(i, memoryChunk.getSize(), i2, i3, getSize());
            this.mByteBuffer.position(i);
            memoryChunk.getByteBuffer().position(i2);
            byte[] bArr = new byte[i3];
            this.mByteBuffer.get(bArr, 0, i3);
            memoryChunk.getByteBuffer().put(bArr, 0, i3);
            return;
        }
        throw new IllegalArgumentException("Cannot copy two incompatible MemoryChunks");
    }

    public synchronized void close() {
        if (!isClosed()) {
            SharedMemory.unmap(this.mByteBuffer);
            this.mSharedMemory.close();
            this.mByteBuffer = null;
            this.mSharedMemory = null;
        }
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

    public ByteBuffer getByteBuffer() {
        return this.mByteBuffer;
    }

    public long getNativePtr() {
        throw new UnsupportedOperationException("Cannot get the pointer of an  AshmemMemoryChunk");
    }

    public int getSize() {
        k.checkState(!isClosed());
        return this.mSharedMemory.getSize();
    }

    public long getUniqueId() {
        return this.mId;
    }

    public synchronized boolean isClosed() {
        return this.mByteBuffer == null || this.mSharedMemory == null;
    }

    public synchronized int read(int i, byte[] bArr, int i2, int i3) {
        int adjustByteCount;
        if (bArr != null) {
            k.checkState(!isClosed());
            adjustByteCount = MemoryChunkUtil.adjustByteCount(i, i3, getSize());
            MemoryChunkUtil.checkBounds(i, bArr.length, i2, adjustByteCount, getSize());
            this.mByteBuffer.position(i);
            this.mByteBuffer.get(bArr, i2, adjustByteCount);
        } else {
            throw null;
        }
        return adjustByteCount;
    }

    public synchronized int write(int i, byte[] bArr, int i2, int i3) {
        int adjustByteCount;
        if (bArr != null) {
            k.checkState(!isClosed());
            adjustByteCount = MemoryChunkUtil.adjustByteCount(i, i3, getSize());
            MemoryChunkUtil.checkBounds(i, bArr.length, i2, adjustByteCount, getSize());
            this.mByteBuffer.position(i);
            this.mByteBuffer.put(bArr, i2, adjustByteCount);
        } else {
            throw null;
        }
        return adjustByteCount;
    }

    public AshmemMemoryChunk() {
        this.mSharedMemory = null;
        this.mByteBuffer = null;
        this.mId = (long) System.identityHashCode(this);
    }

    public synchronized byte read(int i) {
        boolean z = true;
        k.checkState(!isClosed());
        k.checkArgument(i >= 0);
        if (i >= getSize()) {
            z = false;
        }
        k.checkArgument(z);
        return this.mByteBuffer.get(i);
    }
}
