package com.facebook.imagepipeline.memory;

import co.hyperverge.hypersnapsdk.c.k;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.imagepipeline.nativecode.ImagePipelineNativeLoader;
import com.facebook.soloader.nativeloader.NativeLoader;
import java.io.Closeable;
import java.nio.ByteBuffer;

@DoNotStrip
public class NativeMemoryChunk implements MemoryChunk, Closeable {
    public static final String TAG = "NativeMemoryChunk";
    public boolean mIsClosed;
    public final long mNativePtr;
    public final int mSize;

    static {
        NativeLoader.loadLibrary(ImagePipelineNativeLoader.DSO_NAME);
    }

    public NativeMemoryChunk(int i) {
        k.checkArgument(i > 0);
        this.mSize = i;
        this.mNativePtr = nativeAllocate(i);
        this.mIsClosed = false;
    }

    private void doCopy(int i, MemoryChunk memoryChunk, int i2, int i3) {
        if (memoryChunk instanceof NativeMemoryChunk) {
            k.checkState(!isClosed());
            k.checkState(!memoryChunk.isClosed());
            MemoryChunkUtil.checkBounds(i, memoryChunk.getSize(), i2, i3, this.mSize);
            nativeMemcpy(memoryChunk.getNativePtr() + ((long) i2), this.mNativePtr + ((long) i), i3);
            return;
        }
        throw new IllegalArgumentException("Cannot copy two incompatible MemoryChunks");
    }

    @DoNotStrip
    public static native long nativeAllocate(int i);

    @DoNotStrip
    public static native void nativeCopyFromByteArray(long j, byte[] bArr, int i, int i2);

    @DoNotStrip
    public static native void nativeCopyToByteArray(long j, byte[] bArr, int i, int i2);

    @DoNotStrip
    public static native void nativeFree(long j);

    @DoNotStrip
    public static native void nativeMemcpy(long j, long j2, int i);

    @DoNotStrip
    public static native byte nativeReadByte(long j);

    public synchronized void close() {
        if (!this.mIsClosed) {
            this.mIsClosed = true;
            nativeFree(this.mNativePtr);
        }
    }

    public void copy(int i, MemoryChunk memoryChunk, int i2, int i3) {
        if (memoryChunk != null) {
            if (memoryChunk.getUniqueId() == getUniqueId()) {
                Integer.toHexString(System.identityHashCode(this));
                Integer.toHexString(System.identityHashCode(memoryChunk));
                Long.toHexString(this.mNativePtr);
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

    public void finalize() throws Throwable {
        if (!isClosed()) {
            Integer.toHexString(System.identityHashCode(this));
            try {
                close();
            } finally {
                super.finalize();
            }
        }
    }

    public ByteBuffer getByteBuffer() {
        return null;
    }

    public long getNativePtr() {
        return this.mNativePtr;
    }

    public int getSize() {
        return this.mSize;
    }

    public long getUniqueId() {
        return this.mNativePtr;
    }

    public synchronized boolean isClosed() {
        return this.mIsClosed;
    }

    public synchronized int read(int i, byte[] bArr, int i2, int i3) {
        int adjustByteCount;
        if (bArr != null) {
            k.checkState(!isClosed());
            adjustByteCount = MemoryChunkUtil.adjustByteCount(i, i3, this.mSize);
            MemoryChunkUtil.checkBounds(i, bArr.length, i2, adjustByteCount, this.mSize);
            nativeCopyToByteArray(this.mNativePtr + ((long) i), bArr, i2, adjustByteCount);
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
            nativeCopyFromByteArray(this.mNativePtr + ((long) i), bArr, i2, adjustByteCount);
        } else {
            throw null;
        }
        return adjustByteCount;
    }

    public NativeMemoryChunk() {
        this.mSize = 0;
        this.mNativePtr = 0;
        this.mIsClosed = true;
    }

    public synchronized byte read(int i) {
        boolean z = true;
        k.checkState(!isClosed());
        k.checkArgument(i >= 0);
        if (i >= this.mSize) {
            z = false;
        }
        k.checkArgument(z);
        return nativeReadByte(this.mNativePtr + ((long) i));
    }
}
