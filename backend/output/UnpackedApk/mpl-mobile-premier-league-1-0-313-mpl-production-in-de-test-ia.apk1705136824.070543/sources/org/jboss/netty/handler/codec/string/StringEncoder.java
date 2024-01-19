package org.jboss.netty.handler.codec.string;

import java.nio.charset.Charset;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandler.Sharable;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.oneone.OneToOneEncoder;

@Sharable
public class StringEncoder extends OneToOneEncoder {
    public final Charset charset;

    public StringEncoder() {
        this(Charset.defaultCharset());
    }

    public Object encode(ChannelHandlerContext channelHandlerContext, Channel channel, Object obj) throws Exception {
        if (!(obj instanceof String)) {
            return obj;
        }
        return ChannelBuffers.copiedBuffer((CharSequence) (String) obj, this.charset);
    }

    public StringEncoder(Charset charset2) {
        if (charset2 != null) {
            this.charset = charset2;
            return;
        }
        throw new NullPointerException("charset");
    }

    @Deprecated
    public StringEncoder(String str) {
        this(Charset.forName(str));
    }
}
