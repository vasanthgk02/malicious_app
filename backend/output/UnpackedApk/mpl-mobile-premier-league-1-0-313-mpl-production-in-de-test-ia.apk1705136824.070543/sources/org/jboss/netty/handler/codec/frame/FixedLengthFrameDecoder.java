package org.jboss.netty.handler.codec.frame;

import com.android.tools.r8.GeneratedOutlineSupport;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;

public class FixedLengthFrameDecoder extends FrameDecoder {
    public final int frameLength;

    public FixedLengthFrameDecoder(int i) {
        if (i > 0) {
            this.frameLength = i;
            return;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("frameLength must be a positive integer: ", i));
    }

    public Object decode(ChannelHandlerContext channelHandlerContext, Channel channel, ChannelBuffer channelBuffer) throws Exception {
        int readableBytes = channelBuffer.readableBytes();
        int i = this.frameLength;
        if (readableBytes < i) {
            return null;
        }
        return channelBuffer.readBytes(i);
    }
}
