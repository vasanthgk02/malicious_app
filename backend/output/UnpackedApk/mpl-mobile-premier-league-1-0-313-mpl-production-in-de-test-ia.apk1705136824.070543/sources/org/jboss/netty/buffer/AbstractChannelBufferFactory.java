package org.jboss.netty.buffer;

import java.nio.ByteOrder;

public abstract class AbstractChannelBufferFactory implements ChannelBufferFactory {
    public final ByteOrder defaultOrder;

    public AbstractChannelBufferFactory() {
        this(ByteOrder.BIG_ENDIAN);
    }

    public ChannelBuffer getBuffer(int i) {
        return getBuffer(getDefaultOrder(), i);
    }

    public ByteOrder getDefaultOrder() {
        return this.defaultOrder;
    }

    public AbstractChannelBufferFactory(ByteOrder byteOrder) {
        if (byteOrder != null) {
            this.defaultOrder = byteOrder;
            return;
        }
        throw new NullPointerException("defaultOrder");
    }

    public ChannelBuffer getBuffer(byte[] bArr, int i, int i2) {
        return getBuffer(getDefaultOrder(), bArr, i, i2);
    }
}
