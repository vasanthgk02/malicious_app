package org.jboss.netty.channel.socket.nio;

import java.io.IOException;
import java.nio.channels.SocketChannel;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelException;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelSink;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.logging.InternalLogger;
import org.jboss.netty.logging.InternalLoggerFactory;

public final class NioClientSocketChannel extends NioSocketChannel {
    public static final InternalLogger logger = InternalLoggerFactory.getInstance(NioClientSocketChannel.class);
    public volatile boolean boundManually;
    public long connectDeadlineNanos;
    public volatile ChannelFuture connectFuture;

    public NioClientSocketChannel(ChannelFactory channelFactory, ChannelPipeline channelPipeline, ChannelSink channelSink, NioWorker nioWorker) {
        super(null, channelFactory, channelPipeline, channelSink, newSocket(), nioWorker);
        Channels.fireChannelOpen((Channel) this);
    }

    public static SocketChannel newSocket() {
        try {
            SocketChannel open = SocketChannel.open();
            try {
                open.configureBlocking(false);
                return open;
            } catch (IOException e2) {
                throw new ChannelException("Failed to enter non-blocking mode.", e2);
            } catch (Throwable th) {
                try {
                    open.close();
                } catch (IOException e3) {
                    logger.warn("Failed to close a partially initialized socket.", e3);
                }
                throw th;
            }
        } catch (IOException e4) {
            throw new ChannelException("Failed to open a socket.", e4);
        }
    }
}
