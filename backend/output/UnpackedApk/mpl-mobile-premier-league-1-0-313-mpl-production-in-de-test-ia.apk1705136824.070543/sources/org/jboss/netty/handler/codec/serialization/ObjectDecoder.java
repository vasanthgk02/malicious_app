package org.jboss.netty.handler.codec.serialization;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBufferInputStream;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.frame.LengthFieldBasedFrameDecoder;

public class ObjectDecoder extends LengthFieldBasedFrameDecoder {
    public final ClassLoader classLoader;

    public ObjectDecoder() {
        this(1048576);
    }

    public Object decode(ChannelHandlerContext channelHandlerContext, Channel channel, ChannelBuffer channelBuffer) throws Exception {
        ChannelBuffer channelBuffer2 = (ChannelBuffer) super.decode(channelHandlerContext, channel, channelBuffer);
        if (channelBuffer2 == null) {
            return null;
        }
        return new CompactObjectInputStream(new ChannelBufferInputStream(channelBuffer2), this.classLoader).readObject();
    }

    public ChannelBuffer extractFrame(ChannelBuffer channelBuffer, int i, int i2) {
        return channelBuffer.slice(i, i2);
    }

    public ObjectDecoder(int i) {
        this(i, null);
    }

    public ObjectDecoder(int i, ClassLoader classLoader2) {
        super(i, 0, 4, 0, 4);
        this.classLoader = classLoader2;
    }
}
