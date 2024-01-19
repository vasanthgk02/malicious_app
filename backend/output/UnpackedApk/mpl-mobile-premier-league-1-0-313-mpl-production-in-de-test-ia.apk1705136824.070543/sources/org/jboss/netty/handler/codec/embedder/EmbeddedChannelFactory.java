package org.jboss.netty.handler.codec.embedder;

import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.ChannelPipeline;

public class EmbeddedChannelFactory implements ChannelFactory {
    public static final ChannelFactory INSTANCE = new EmbeddedChannelFactory();

    public Channel newChannel(ChannelPipeline channelPipeline) {
        throw new UnsupportedOperationException();
    }

    public void releaseExternalResources() {
    }
}
