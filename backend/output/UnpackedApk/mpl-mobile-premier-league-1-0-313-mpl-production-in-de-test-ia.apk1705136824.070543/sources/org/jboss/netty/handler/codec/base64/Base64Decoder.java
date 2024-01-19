package org.jboss.netty.handler.codec.base64;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandler.Sharable;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.oneone.OneToOneDecoder;
import org.jboss.netty.util.CharsetUtil;

@Sharable
public class Base64Decoder extends OneToOneDecoder {
    public final Base64Dialect dialect;

    public Base64Decoder() {
        this(Base64Dialect.STANDARD);
    }

    public Object decode(ChannelHandlerContext channelHandlerContext, Channel channel, Object obj) throws Exception {
        if (obj instanceof String) {
            obj = ChannelBuffers.copiedBuffer((CharSequence) (String) obj, CharsetUtil.US_ASCII);
        } else if (!(obj instanceof ChannelBuffer)) {
            return obj;
        }
        ChannelBuffer channelBuffer = (ChannelBuffer) obj;
        return Base64.decode(channelBuffer, channelBuffer.readerIndex(), channelBuffer.readableBytes(), this.dialect);
    }

    public Base64Decoder(Base64Dialect base64Dialect) {
        if (base64Dialect != null) {
            this.dialect = base64Dialect;
            return;
        }
        throw new NullPointerException("dialect");
    }
}
