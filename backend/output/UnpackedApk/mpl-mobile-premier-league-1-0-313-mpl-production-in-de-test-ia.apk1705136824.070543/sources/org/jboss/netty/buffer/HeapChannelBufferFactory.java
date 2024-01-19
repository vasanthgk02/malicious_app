package org.jboss.netty.buffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class HeapChannelBufferFactory extends AbstractChannelBufferFactory {
    public static final HeapChannelBufferFactory INSTANCE_BE = new HeapChannelBufferFactory(ByteOrder.BIG_ENDIAN);
    public static final HeapChannelBufferFactory INSTANCE_LE = new HeapChannelBufferFactory(ByteOrder.LITTLE_ENDIAN);

    public HeapChannelBufferFactory() {
    }

    public static ChannelBufferFactory getInstance() {
        return INSTANCE_BE;
    }

    public ChannelBuffer getBuffer(ByteOrder byteOrder, int i) {
        return ChannelBuffers.buffer(byteOrder, i);
    }

    public HeapChannelBufferFactory(ByteOrder byteOrder) {
        super(byteOrder);
    }

    public static ChannelBufferFactory getInstance(ByteOrder byteOrder) {
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            return INSTANCE_BE;
        }
        if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
            return INSTANCE_LE;
        }
        if (byteOrder == null) {
            throw new NullPointerException("endianness");
        }
        throw new IllegalStateException("Should not reach here");
    }

    public ChannelBuffer getBuffer(ByteOrder byteOrder, byte[] bArr, int i, int i2) {
        return ChannelBuffers.wrappedBuffer(byteOrder, bArr, i, i2);
    }

    public ChannelBuffer getBuffer(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            return ChannelBuffers.wrappedBuffer(byteBuffer);
        }
        ChannelBuffer buffer = getBuffer(byteBuffer.order(), byteBuffer.remaining());
        int position = byteBuffer.position();
        buffer.writeBytes(byteBuffer);
        byteBuffer.position(position);
        return buffer;
    }
}
