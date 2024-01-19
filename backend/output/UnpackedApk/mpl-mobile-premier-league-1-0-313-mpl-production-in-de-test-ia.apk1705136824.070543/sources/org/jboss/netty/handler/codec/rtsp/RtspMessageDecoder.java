package org.jboss.netty.handler.codec.rtsp;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.embedder.DecoderEmbedder;
import org.jboss.netty.handler.codec.http.HttpChunkAggregator;
import org.jboss.netty.handler.codec.http.HttpMessage;
import org.jboss.netty.handler.codec.http.HttpMessageDecoder;
import org.jboss.netty.handler.codec.http.HttpMessageDecoder.State;

public abstract class RtspMessageDecoder extends HttpMessageDecoder {
    public final DecoderEmbedder<HttpMessage> aggregator;

    public RtspMessageDecoder() {
        this(4096, 8192, 8192);
    }

    public boolean isContentAlwaysEmpty(HttpMessage httpMessage) {
        boolean isContentAlwaysEmpty = super.isContentAlwaysEmpty(httpMessage);
        if (!isContentAlwaysEmpty && httpMessage.containsHeader("Content-Length")) {
            return isContentAlwaysEmpty;
        }
        return true;
    }

    public RtspMessageDecoder(int i, int i2, int i3) {
        super(i, i2, i3 * 2);
        this.aggregator = new DecoderEmbedder<>(new HttpChunkAggregator(i3));
    }

    public Object decode(ChannelHandlerContext channelHandlerContext, Channel channel, ChannelBuffer channelBuffer, State state) throws Exception {
        Object decode = super.decode(channelHandlerContext, channel, channelBuffer, state);
        if (decode == null || !this.aggregator.offer(decode)) {
            return null;
        }
        return this.aggregator.poll();
    }
}