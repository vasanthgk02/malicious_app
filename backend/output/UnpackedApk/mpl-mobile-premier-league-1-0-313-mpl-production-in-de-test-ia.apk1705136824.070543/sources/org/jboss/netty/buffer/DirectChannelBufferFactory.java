package org.jboss.netty.buffer;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class DirectChannelBufferFactory extends AbstractChannelBufferFactory {
    public static final DirectChannelBufferFactory INSTANCE_BE = new DirectChannelBufferFactory(ByteOrder.BIG_ENDIAN);
    public static final DirectChannelBufferFactory INSTANCE_LE = new DirectChannelBufferFactory(ByteOrder.LITTLE_ENDIAN);
    public final Object bigEndianLock;
    public final Object littleEndianLock;
    public ChannelBuffer preallocatedBigEndianBuffer;
    public int preallocatedBigEndianBufferPosition;
    public final int preallocatedBufferCapacity;
    public ChannelBuffer preallocatedLittleEndianBuffer;
    public int preallocatedLittleEndianBufferPosition;

    public DirectChannelBufferFactory() {
        this(ByteOrder.BIG_ENDIAN);
    }

    private ChannelBuffer allocateBigEndianBuffer(int i) {
        ChannelBuffer channelBuffer;
        synchronized (this.bigEndianLock) {
            if (this.preallocatedBigEndianBuffer == null) {
                ChannelBuffer directBuffer = ChannelBuffers.directBuffer(ByteOrder.BIG_ENDIAN, this.preallocatedBufferCapacity);
                this.preallocatedBigEndianBuffer = directBuffer;
                channelBuffer = directBuffer.slice(0, i);
                this.preallocatedBigEndianBufferPosition = i;
            } else if (this.preallocatedBigEndianBuffer.capacity() - this.preallocatedBigEndianBufferPosition >= i) {
                channelBuffer = this.preallocatedBigEndianBuffer.slice(this.preallocatedBigEndianBufferPosition, i);
                this.preallocatedBigEndianBufferPosition += i;
            } else {
                ChannelBuffer directBuffer2 = ChannelBuffers.directBuffer(ByteOrder.BIG_ENDIAN, this.preallocatedBufferCapacity);
                this.preallocatedBigEndianBuffer = directBuffer2;
                channelBuffer = directBuffer2.slice(0, i);
                this.preallocatedBigEndianBufferPosition = i;
            }
        }
        return channelBuffer;
    }

    private ChannelBuffer allocateLittleEndianBuffer(int i) {
        ChannelBuffer channelBuffer;
        synchronized (this.littleEndianLock) {
            if (this.preallocatedLittleEndianBuffer == null) {
                ChannelBuffer directBuffer = ChannelBuffers.directBuffer(ByteOrder.LITTLE_ENDIAN, this.preallocatedBufferCapacity);
                this.preallocatedLittleEndianBuffer = directBuffer;
                channelBuffer = directBuffer.slice(0, i);
                this.preallocatedLittleEndianBufferPosition = i;
            } else if (this.preallocatedLittleEndianBuffer.capacity() - this.preallocatedLittleEndianBufferPosition >= i) {
                channelBuffer = this.preallocatedLittleEndianBuffer.slice(this.preallocatedLittleEndianBufferPosition, i);
                this.preallocatedLittleEndianBufferPosition += i;
            } else {
                ChannelBuffer directBuffer2 = ChannelBuffers.directBuffer(ByteOrder.LITTLE_ENDIAN, this.preallocatedBufferCapacity);
                this.preallocatedLittleEndianBuffer = directBuffer2;
                channelBuffer = directBuffer2.slice(0, i);
                this.preallocatedLittleEndianBufferPosition = i;
            }
        }
        return channelBuffer;
    }

    public static ChannelBufferFactory getInstance() {
        return INSTANCE_BE;
    }

    public ChannelBuffer getBuffer(ByteOrder byteOrder, int i) {
        ChannelBuffer channelBuffer;
        if (byteOrder == null) {
            throw new NullPointerException("order");
        } else if (i < 0) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("capacity: ", i));
        } else if (i == 0) {
            return ChannelBuffers.EMPTY_BUFFER;
        } else {
            if (i >= this.preallocatedBufferCapacity) {
                return ChannelBuffers.directBuffer(byteOrder, i);
            }
            if (byteOrder == ByteOrder.BIG_ENDIAN) {
                channelBuffer = allocateBigEndianBuffer(i);
            } else {
                channelBuffer = allocateLittleEndianBuffer(i);
            }
            channelBuffer.clear();
            return channelBuffer;
        }
    }

    public DirectChannelBufferFactory(int i) {
        this(ByteOrder.BIG_ENDIAN, i);
    }

    public static ChannelBufferFactory getInstance(ByteOrder byteOrder) {
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            return INSTANCE_BE;
        }
        if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
            return INSTANCE_LE;
        }
        if (byteOrder == null) {
            throw new NullPointerException("defaultEndianness");
        }
        throw new IllegalStateException("Should not reach here");
    }

    public DirectChannelBufferFactory(ByteOrder byteOrder) {
        this(byteOrder, 1048576);
    }

    public DirectChannelBufferFactory(ByteOrder byteOrder, int i) {
        super(byteOrder);
        this.bigEndianLock = new Object();
        this.littleEndianLock = new Object();
        this.preallocatedBigEndianBuffer = null;
        this.preallocatedLittleEndianBuffer = null;
        if (i > 0) {
            this.preallocatedBufferCapacity = i;
            return;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("preallocatedBufferCapacity must be greater than 0: ", i));
    }

    public ChannelBuffer getBuffer(ByteOrder byteOrder, byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new NullPointerException("array");
        } else if (i < 0) {
            throw new IndexOutOfBoundsException(GeneratedOutlineSupport.outline41("offset: ", i));
        } else if (i2 == 0) {
            return ChannelBuffers.EMPTY_BUFFER;
        } else {
            if (i + i2 <= bArr.length) {
                ChannelBuffer buffer = getBuffer(byteOrder, i2);
                buffer.writeBytes(bArr, i, i2);
                return buffer;
            }
            throw new IndexOutOfBoundsException(GeneratedOutlineSupport.outline41("length: ", i2));
        }
    }

    public ChannelBuffer getBuffer(ByteBuffer byteBuffer) {
        if (!byteBuffer.isReadOnly() && byteBuffer.isDirect()) {
            return ChannelBuffers.wrappedBuffer(byteBuffer);
        }
        ChannelBuffer buffer = getBuffer(byteBuffer.order(), byteBuffer.remaining());
        int position = byteBuffer.position();
        buffer.writeBytes(byteBuffer);
        byteBuffer.position(position);
        return buffer;
    }
}
