package org.jboss.netty.handler.codec.string;

import java.nio.charset.Charset;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandler.Sharable;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.oneone.OneToOneDecoder;

@Sharable
public class StringDecoder extends OneToOneDecoder {
    public final Charset charset;

    public StringDecoder() {
        this(Charset.defaultCharset());
    }

    public Object decode(ChannelHandlerContext channelHandlerContext, Channel channel, Object obj) throws Exception {
        if (!(obj instanceof ChannelBuffer)) {
            return obj;
        }
        return ((ChannelBuffer) obj).toString(this.charset);
    }

    public StringDecoder(Charset charset2) {
        if (charset2 != null) {
            this.charset = charset2;
            return;
        }
        throw new NullPointerException("charset");
    }

    @Deprecated
    public StringDecoder(String str) {
        this(Charset.forName(str));
    }
}
