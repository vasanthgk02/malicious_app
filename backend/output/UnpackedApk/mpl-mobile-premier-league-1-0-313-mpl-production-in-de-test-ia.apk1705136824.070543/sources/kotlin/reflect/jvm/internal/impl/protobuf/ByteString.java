package kotlin.reflect.jvm.internal.impl.protobuf;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.eclipse.paho.client.mqttv3.MqttTopic;

public abstract class ByteString implements Iterable<Byte> {
    public static final ByteString EMPTY = new LiteralByteString(new byte[0]);

    public interface ByteIterator extends Iterator<Byte> {
        byte nextByte();
    }

    public static final class Output extends OutputStream {
        public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
        public byte[] buffer;
        public int bufferPos;
        public final ArrayList<ByteString> flushedBuffers;
        public int flushedBuffersTotalBytes;
        public final int initialCapacity;

        public Output(int i) {
            if (i >= 0) {
                this.initialCapacity = i;
                this.flushedBuffers = new ArrayList<>();
                this.buffer = new byte[i];
                return;
            }
            throw new IllegalArgumentException("Buffer size < 0");
        }

        public final void flushFullBuffer(int i) {
            this.flushedBuffers.add(new LiteralByteString(this.buffer));
            int length = this.flushedBuffersTotalBytes + this.buffer.length;
            this.flushedBuffersTotalBytes = length;
            this.buffer = new byte[Math.max(this.initialCapacity, Math.max(i, length >>> 1))];
            this.bufferPos = 0;
        }

        public final void flushLastBuffer() {
            int i = this.bufferPos;
            byte[] bArr = this.buffer;
            if (i >= bArr.length) {
                this.flushedBuffers.add(new LiteralByteString(this.buffer));
                this.buffer = EMPTY_BYTE_ARRAY;
            } else if (i > 0) {
                byte[] bArr2 = new byte[i];
                System.arraycopy(bArr, 0, bArr2, 0, Math.min(bArr.length, i));
                this.flushedBuffers.add(new LiteralByteString(bArr2));
            }
            this.flushedBuffersTotalBytes += this.bufferPos;
            this.bufferPos = 0;
        }

        public synchronized ByteString toByteString() {
            ByteString byteString;
            try {
                flushLastBuffer();
                ArrayList<ByteString> arrayList = this.flushedBuffers;
                if (!(arrayList instanceof Collection)) {
                    ArrayList<ByteString> arrayList2 = new ArrayList<>();
                    for (ByteString add : arrayList) {
                        arrayList2.add(add);
                    }
                    arrayList = arrayList2;
                }
                if (arrayList.isEmpty()) {
                    byteString = ByteString.EMPTY;
                } else {
                    byteString = ByteString.balancedConcat(arrayList.iterator(), arrayList.size());
                }
            }
            return byteString;
        }

        public String toString() {
            int i;
            Object[] objArr = new Object[2];
            objArr[0] = Integer.toHexString(System.identityHashCode(this));
            synchronized (this) {
                i = this.flushedBuffersTotalBytes + this.bufferPos;
            }
            objArr[1] = Integer.valueOf(i);
            return String.format("<ByteString.Output@%s size=%d>", objArr);
        }

        public synchronized void write(int i) {
            if (this.bufferPos == this.buffer.length) {
                flushFullBuffer(1);
            }
            byte[] bArr = this.buffer;
            int i2 = this.bufferPos;
            this.bufferPos = i2 + 1;
            bArr[i2] = (byte) i;
        }

        public synchronized void write(byte[] bArr, int i, int i2) {
            if (i2 <= this.buffer.length - this.bufferPos) {
                System.arraycopy(bArr, i, this.buffer, this.bufferPos, i2);
                this.bufferPos += i2;
            } else {
                int length = this.buffer.length - this.bufferPos;
                System.arraycopy(bArr, i, this.buffer, this.bufferPos, length);
                int i3 = i2 - length;
                flushFullBuffer(i3);
                System.arraycopy(bArr, i + length, this.buffer, 0, i3);
                this.bufferPos = i3;
            }
        }
    }

    static {
        Class<ByteString> cls = ByteString.class;
    }

    public static ByteString balancedConcat(Iterator<ByteString> it, int i) {
        if (i == 1) {
            return it.next();
        }
        int i2 = i >>> 1;
        return balancedConcat(it, i2).concat(balancedConcat(it, i - i2));
    }

    public static ByteString copyFrom(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new LiteralByteString(bArr2);
    }

    public static ByteString copyFromUtf8(String str) {
        try {
            return new LiteralByteString(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("UTF-8 not supported?", e2);
        }
    }

    public static Output newOutput() {
        return new Output(128);
    }

    public ByteString concat(ByteString byteString) {
        int size = size();
        int size2 = byteString.size();
        if (((long) size) + ((long) size2) < 2147483647L) {
            return RopeByteString.concatenate(this, byteString);
        }
        StringBuilder sb = new StringBuilder(53);
        sb.append("ByteString would be too long: ");
        sb.append(size);
        sb.append(MqttTopic.SINGLE_LEVEL_WILDCARD);
        sb.append(size2);
        throw new IllegalArgumentException(sb.toString());
    }

    public void copyTo(byte[] bArr, int i, int i2, int i3) {
        if (i < 0) {
            throw new IndexOutOfBoundsException(GeneratedOutlineSupport.outline31(30, "Source offset < 0: ", i));
        } else if (i2 < 0) {
            throw new IndexOutOfBoundsException(GeneratedOutlineSupport.outline31(30, "Target offset < 0: ", i2));
        } else if (i3 >= 0) {
            int i4 = i + i3;
            if (i4 <= size()) {
                int i5 = i2 + i3;
                if (i5 > bArr.length) {
                    throw new IndexOutOfBoundsException(GeneratedOutlineSupport.outline31(34, "Target end offset < 0: ", i5));
                } else if (i3 > 0) {
                    copyToInternal(bArr, i, i2, i3);
                }
            } else {
                throw new IndexOutOfBoundsException(GeneratedOutlineSupport.outline31(34, "Source end offset < 0: ", i4));
            }
        } else {
            throw new IndexOutOfBoundsException(GeneratedOutlineSupport.outline31(23, "Length < 0: ", i3));
        }
    }

    public abstract void copyToInternal(byte[] bArr, int i, int i2, int i3);

    public abstract int getTreeDepth();

    public abstract boolean isBalanced();

    public abstract boolean isValidUtf8();

    public abstract ByteIterator iterator();

    public abstract int partialHash(int i, int i2, int i3);

    public abstract int partialIsValidUtf8(int i, int i2, int i3);

    public abstract int peekCachedHashCode();

    public abstract int size();

    public String toString() {
        return String.format("<ByteString@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size())});
    }

    public abstract String toString(String str) throws UnsupportedEncodingException;

    public String toStringUtf8() {
        try {
            return toString("UTF-8");
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("UTF-8 not supported?", e2);
        }
    }

    public abstract void writeToInternal(OutputStream outputStream, int i, int i2) throws IOException;

    public static ByteString copyFrom(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return new LiteralByteString(bArr2);
    }
}
