package org.jboss.netty.handler.codec.replay;

import org.jboss.netty.buffer.ChannelBufferFactory;
import org.jboss.netty.buffer.DynamicChannelBuffer;

public class UnsafeDynamicChannelBuffer extends DynamicChannelBuffer {
    public UnsafeDynamicChannelBuffer(ChannelBufferFactory channelBufferFactory) {
        super(channelBufferFactory.getDefaultOrder(), 256, channelBufferFactory);
    }

    public void checkReadableBytes(int i) {
    }
}
