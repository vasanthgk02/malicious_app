package org.jboss.netty.channel.local;

import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelSink;

public class DefaultLocalServerChannelFactory implements LocalServerChannelFactory {
    public final ChannelSink sink = new LocalServerChannelSink();

    public void releaseExternalResources() {
    }

    public LocalServerChannel newChannel(ChannelPipeline channelPipeline) {
        return new DefaultLocalServerChannel(this, channelPipeline, this.sink);
    }
}
