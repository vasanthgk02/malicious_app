package org.jboss.netty.channel.socket.nio;

import java.net.SocketAddress;
import java.nio.channels.SocketChannel;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelSink;
import org.jboss.netty.channel.Channels;

public final class NioAcceptedSocketChannel extends NioSocketChannel {
    public final Thread bossThread;

    public NioAcceptedSocketChannel(ChannelFactory channelFactory, ChannelPipeline channelPipeline, Channel channel, ChannelSink channelSink, SocketChannel socketChannel, NioWorker nioWorker, Thread thread) {
        super(channel, channelFactory, channelPipeline, channelSink, socketChannel, nioWorker);
        this.bossThread = thread;
        setConnected();
        Channels.fireChannelOpen((Channel) this);
        Channels.fireChannelBound((Channel) this, (SocketAddress) getLocalAddress());
        Channels.fireChannelConnected((Channel) this, (SocketAddress) getRemoteAddress());
    }
}
