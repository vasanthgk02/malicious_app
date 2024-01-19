package org.jboss.netty.handler.codec.protobuf;

import com.google.protobuf.MessageLite;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandler.Sharable;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.oneone.OneToOneEncoder;

@Sharable
public class ProtobufEncoder extends OneToOneEncoder {
    public Object encode(ChannelHandlerContext channelHandlerContext, Channel channel, Object obj) throws Exception {
        if (!(obj instanceof MessageLite)) {
            return obj;
        }
        return ChannelBuffers.wrappedBuffer(((MessageLite) obj).toByteArray());
    }
}
