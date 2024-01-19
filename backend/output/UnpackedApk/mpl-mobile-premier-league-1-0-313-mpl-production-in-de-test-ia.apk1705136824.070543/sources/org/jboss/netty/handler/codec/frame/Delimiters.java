package org.jboss.netty.handler.codec.frame;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;

public class Delimiters {
    public static ChannelBuffer[] lineDelimiter() {
        return new ChannelBuffer[]{ChannelBuffers.wrappedBuffer(new byte[]{13, 10}), ChannelBuffers.wrappedBuffer(new byte[]{10})};
    }

    public static ChannelBuffer[] nulDelimiter() {
        return new ChannelBuffer[]{ChannelBuffers.wrappedBuffer(new byte[]{0})};
    }
}
