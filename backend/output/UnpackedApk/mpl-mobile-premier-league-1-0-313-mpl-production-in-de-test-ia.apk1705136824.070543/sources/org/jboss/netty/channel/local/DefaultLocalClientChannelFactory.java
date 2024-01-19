package org.jboss.netty.channel.local;

import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelSink;

public class DefaultLocalClientChannelFactory implements LocalClientChannelFactory {
    public final ChannelSink sink = new LocalClientChannelSink();

    public void releaseExternalResources() {
    }

    public LocalChannel newChannel(ChannelPipeline channelPipeline) {
        DefaultLocalChannel defaultLocalChannel = new DefaultLocalChannel(null, this, channelPipeline, this.sink, null);
        return defaultLocalChannel;
    }
}
