package com.badlogic.gdx.utils;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;

public final class BufferUtils {
    public static int allocatedUnsafe = 0;
    public static Array<ByteBuffer> unsafeBuffers = new Array<>();

    public static int bytesToElements(Buffer buffer, int i) {
        if (buffer instanceof ByteBuffer) {
            return i;
        }
        if (buffer instanceof ShortBuffer) {
            return i >>> 1;
        }
        if (buffer instanceof CharBuffer) {
            return i >>> 1;
        }
        if (buffer instanceof IntBuffer) {
            return i >>> 2;
        }
        if (buffer instanceof LongBuffer) {
            return i >>> 3;
        }
        if (buffer instanceof FloatBuffer) {
            return i >>> 2;
        }
        if (buffer instanceof DoubleBuffer) {
            return i >>> 3;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Can't copy to a ");
        outline73.append(buffer.getClass().getName());
        outline73.append(" instance");
        throw new GdxRuntimeException(outline73.toString());
    }

    public static native void clear(ByteBuffer byteBuffer, int i);

    public static void copy(float[] fArr, Buffer buffer, int i, int i2) {
        if (buffer instanceof ByteBuffer) {
            buffer.limit(i << 2);
        } else if (buffer instanceof FloatBuffer) {
            buffer.limit(i);
        }
        copyJni(fArr, buffer, i, i2);
        buffer.position(0);
    }

    public static native void copyJni(Buffer buffer, int i, Buffer buffer2, int i2, int i3);

    public static native void copyJni(byte[] bArr, int i, Buffer buffer, int i2, int i3);

    public static native void copyJni(char[] cArr, int i, Buffer buffer, int i2, int i3);

    public static native void copyJni(double[] dArr, int i, Buffer buffer, int i2, int i3);

    public static native void copyJni(float[] fArr, int i, Buffer buffer, int i2, int i3);

    public static native void copyJni(float[] fArr, Buffer buffer, int i, int i2);

    public static native void copyJni(int[] iArr, int i, Buffer buffer, int i2, int i3);

    public static native void copyJni(long[] jArr, int i, Buffer buffer, int i2, int i3);

    public static native void copyJni(short[] sArr, int i, Buffer buffer, int i2, int i3);

    public static void disposeUnsafeByteBuffer(ByteBuffer byteBuffer) {
        int capacity = byteBuffer.capacity();
        synchronized (unsafeBuffers) {
            if (!unsafeBuffers.removeValue(byteBuffer, true)) {
                throw new IllegalArgumentException("buffer not allocated with newUnsafeByteBuffer or already disposed");
            }
        }
        allocatedUnsafe -= capacity;
        freeMemory(byteBuffer);
    }

    public static native long find(Buffer buffer, int i, int i2, Buffer buffer2, int i3, int i4);

    public static native long find(Buffer buffer, int i, int i2, Buffer buffer2, int i3, int i4, float f2);

    public static native long find(Buffer buffer, int i, int i2, float[] fArr, int i3, int i4);

    public static native long find(Buffer buffer, int i, int i2, float[] fArr, int i3, int i4, float f2);

    public static native long find(float[] fArr, int i, int i2, Buffer buffer, int i3, int i4);

    public static native long find(float[] fArr, int i, int i2, Buffer buffer, int i3, int i4, float f2);

    public static native long find(float[] fArr, int i, int i2, float[] fArr2, int i3, int i4);

    public static native long find(float[] fArr, int i, int i2, float[] fArr2, int i3, int i4, float f2);

    public static native void freeMemory(ByteBuffer byteBuffer);

    public static native long getBufferAddress(Buffer buffer);

    public static boolean isUnsafeByteBuffer(ByteBuffer byteBuffer) {
        boolean contains;
        synchronized (unsafeBuffers) {
            contains = unsafeBuffers.contains(byteBuffer, true);
        }
        return contains;
    }

    public static ByteBuffer newByteBuffer(int i) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i);
        allocateDirect.order(ByteOrder.nativeOrder());
        return allocateDirect;
    }

    public static native ByteBuffer newDisposableByteBuffer(int i);

    public static FloatBuffer newFloatBuffer(int i) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        return allocateDirect.asFloatBuffer();
    }

    public static IntBuffer newIntBuffer(int i) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        return allocateDirect.asIntBuffer();
    }

    public static ByteBuffer newUnsafeByteBuffer(int i) {
        ByteBuffer newDisposableByteBuffer = newDisposableByteBuffer(i);
        newDisposableByteBuffer.order(ByteOrder.nativeOrder());
        allocatedUnsafe += i;
        synchronized (unsafeBuffers) {
            unsafeBuffers.add(newDisposableByteBuffer);
        }
        return newDisposableByteBuffer;
    }

    public static int positionInBytes(Buffer buffer) {
        if (buffer instanceof ByteBuffer) {
            return buffer.position();
        }
        if (buffer instanceof ShortBuffer) {
            return buffer.position() << 1;
        }
        if (buffer instanceof CharBuffer) {
            return buffer.position() << 1;
        }
        if (buffer instanceof IntBuffer) {
            return buffer.position() << 2;
        }
        if (buffer instanceof LongBuffer) {
            return buffer.position() << 3;
        }
        if (buffer instanceof FloatBuffer) {
            return buffer.position() << 2;
        }
        if (buffer instanceof DoubleBuffer) {
            return buffer.position() << 3;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Can't copy to a ");
        outline73.append(buffer.getClass().getName());
        outline73.append(" instance");
        throw new GdxRuntimeException(outline73.toString());
    }

    public static native void transformV2M3Jni(Buffer buffer, int i, int i2, float[] fArr, int i3);

    public static native void transformV2M3Jni(float[] fArr, int i, int i2, float[] fArr2, int i3);

    public static native void transformV2M4Jni(Buffer buffer, int i, int i2, float[] fArr, int i3);

    public static native void transformV2M4Jni(float[] fArr, int i, int i2, float[] fArr2, int i3);

    public static native void transformV3M3Jni(Buffer buffer, int i, int i2, float[] fArr, int i3);

    public static native void transformV3M3Jni(float[] fArr, int i, int i2, float[] fArr2, int i3);

    public static native void transformV3M4Jni(Buffer buffer, int i, int i2, float[] fArr, int i3);

    public static native void transformV3M4Jni(float[] fArr, int i, int i2, float[] fArr2, int i3);

    public static native void transformV4M4Jni(Buffer buffer, int i, int i2, float[] fArr, int i3);

    public static native void transformV4M4Jni(float[] fArr, int i, int i2, float[] fArr2, int i3);

    public static void copy(byte[] bArr, int i, Buffer buffer, int i2) {
        buffer.limit(bytesToElements(buffer, i2) + buffer.position());
        copyJni(bArr, i, buffer, positionInBytes(buffer), i2);
    }

    public static ByteBuffer newUnsafeByteBuffer(ByteBuffer byteBuffer) {
        allocatedUnsafe = byteBuffer.capacity() + allocatedUnsafe;
        synchronized (unsafeBuffers) {
            unsafeBuffers.add(byteBuffer);
        }
        return byteBuffer;
    }

    public static void copy(short[] sArr, int i, Buffer buffer, int i2) {
        int i3 = i2 << 1;
        buffer.limit(bytesToElements(buffer, i3) + buffer.position());
        copyJni(sArr, i, buffer, positionInBytes(buffer), i3);
    }

    public static void copy(float[] fArr, int i, int i2, Buffer buffer) {
        copyJni(fArr, i, buffer, positionInBytes(buffer), i2 << 2);
    }

    public static void copy(Buffer buffer, Buffer buffer2, int i) {
        if (!(buffer instanceof ByteBuffer)) {
            if (!(buffer instanceof ShortBuffer) && !(buffer instanceof CharBuffer)) {
                if (!(buffer instanceof IntBuffer)) {
                    if (!(buffer instanceof LongBuffer)) {
                        if (!(buffer instanceof FloatBuffer)) {
                            if (!(buffer instanceof DoubleBuffer)) {
                                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Can't copy to a ");
                                outline73.append(buffer.getClass().getName());
                                outline73.append(" instance");
                                throw new GdxRuntimeException(outline73.toString());
                            }
                        }
                    }
                    i <<= 3;
                }
                i <<= 2;
            } else {
                i <<= 1;
            }
        }
        buffer2.limit(bytesToElements(buffer2, i) + buffer2.position());
        copyJni(buffer, positionInBytes(buffer), buffer2, positionInBytes(buffer2), i);
    }
}
