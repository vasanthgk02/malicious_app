package org.jboss.netty.handler.codec.embedder;

import org.jboss.netty.buffer.ChannelBufferFactory;
import org.jboss.netty.channel.ChannelUpstreamHandler;
import org.jboss.netty.channel.Channels;

public class DecoderEmbedder<E> extends AbstractCodecEmbedder<E> {
    public DecoderEmbedder(ChannelUpstreamHandler... channelUpstreamHandlerArr) {
        super(channelUpstreamHandlerArr);
    }

    public /* bridge */ /* synthetic */ boolean finish() {
        return super.finish();
    }

    public boolean offer(Object obj) {
        Channels.fireMessageReceived(getChannel(), obj);
        return !super.isEmpty();
    }

    public DecoderEmbedder(ChannelBufferFactory channelBufferFactory, ChannelUpstreamHandler... channelUpstreamHandlerArr) {
        super(channelBufferFactory, channelUpstreamHandlerArr);
    }
}
