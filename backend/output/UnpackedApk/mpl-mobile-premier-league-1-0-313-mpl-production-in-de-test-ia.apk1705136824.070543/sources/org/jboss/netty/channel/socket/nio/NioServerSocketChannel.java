package org.jboss.netty.channel.socket.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.Selector;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.jboss.netty.channel.AbstractServerChannel;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelException;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelSink;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.socket.DefaultServerSocketChannelConfig;
import org.jboss.netty.channel.socket.ServerSocketChannel;
import org.jboss.netty.channel.socket.ServerSocketChannelConfig;
import org.jboss.netty.logging.InternalLogger;
import org.jboss.netty.logging.InternalLoggerFactory;

public class NioServerSocketChannel extends AbstractServerChannel implements ServerSocketChannel {
    public static final InternalLogger logger = InternalLoggerFactory.getInstance(NioServerSocketChannel.class);
    public final ServerSocketChannelConfig config;
    public volatile Selector selector;
    public final Lock shutdownLock = new ReentrantLock();
    public final java.nio.channels.ServerSocketChannel socket;

    public NioServerSocketChannel(ChannelFactory channelFactory, ChannelPipeline channelPipeline, ChannelSink channelSink) {
        super(channelFactory, channelPipeline, channelSink);
        try {
            java.nio.channels.ServerSocketChannel open = java.nio.channels.ServerSocketChannel.open();
            this.socket = open;
            try {
                open.configureBlocking(false);
                this.config = new DefaultServerSocketChannelConfig(this.socket.socket());
                Channels.fireChannelOpen((Channel) this);
            } catch (IOException e2) {
                try {
                    this.socket.close();
                } catch (IOException e3) {
                    logger.warn("Failed to close a partially initialized socket.", e3);
                }
                throw new ChannelException("Failed to enter non-blocking mode.", e2);
            }
        } catch (IOException e4) {
            throw new ChannelException("Failed to open a server socket.", e4);
        }
    }

    public InetSocketAddress getRemoteAddress() {
        return null;
    }

    public boolean isBound() {
        return isOpen() && this.socket.socket().isBound();
    }

    public boolean setClosed() {
        return super.setClosed();
    }

    public ServerSocketChannelConfig getConfig() {
        return this.config;
    }

    public InetSocketAddress getLocalAddress() {
        return (InetSocketAddress) this.socket.socket().getLocalSocketAddress();
    }
}
