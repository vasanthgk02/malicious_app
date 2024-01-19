package org.jboss.netty.channel.socket.http;

import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelSink;
import org.jboss.netty.channel.socket.ClientSocketChannelFactory;
import org.jboss.netty.channel.socket.SocketChannel;

public class HttpTunnelingClientSocketChannelFactory implements ClientSocketChannelFactory {
    public final ClientSocketChannelFactory clientSocketChannelFactory;
    public final ChannelSink sink = new HttpTunnelingClientSocketPipelineSink();

    public HttpTunnelingClientSocketChannelFactory(ClientSocketChannelFactory clientSocketChannelFactory2) {
        this.clientSocketChannelFactory = clientSocketChannelFactory2;
    }

    public void releaseExternalResources() {
        this.clientSocketChannelFactory.releaseExternalResources();
    }

    public SocketChannel newChannel(ChannelPipeline channelPipeline) {
        return new HttpTunnelingClientSocketChannel(this, channelPipeline, this.sink, this.clientSocketChannelFactory);
    }
}
