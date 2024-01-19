package org.jboss.netty.bootstrap;

import java.net.SocketAddress;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelException;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelPipelineException;

public class ConnectionlessBootstrap extends Bootstrap {
    public ConnectionlessBootstrap() {
    }

    public Channel bind() {
        SocketAddress socketAddress = (SocketAddress) getOption("localAddress");
        if (socketAddress != null) {
            return bind(socketAddress);
        }
        throw new IllegalStateException("localAddress option is not set.");
    }

    public ChannelFuture connect() {
        SocketAddress socketAddress = (SocketAddress) getOption("remoteAddress");
        if (socketAddress != null) {
            return connect(socketAddress);
        }
        throw new IllegalStateException("remoteAddress option is not set.");
    }

    public ConnectionlessBootstrap(ChannelFactory channelFactory) {
        super(channelFactory);
    }

    public Channel bind(SocketAddress socketAddress) {
        if (socketAddress != null) {
            try {
                Channel newChannel = getFactory().newChannel(getPipelineFactory().getPipeline());
                newChannel.getConfig().setPipelineFactory(getPipelineFactory());
                newChannel.getConfig().setOptions(getOptions());
                ChannelFuture bind = newChannel.bind(socketAddress);
                bind.awaitUninterruptibly();
                if (bind.isSuccess()) {
                    return newChannel;
                }
                bind.getChannel().close().awaitUninterruptibly();
                throw new ChannelException("Failed to bind to: " + socketAddress, bind.getCause());
            } catch (Exception e2) {
                throw new ChannelPipelineException("Failed to initialize a pipeline.", e2);
            }
        } else {
            throw new NullPointerException("localAddress");
        }
    }

    public ChannelFuture connect(SocketAddress socketAddress) {
        if (socketAddress != null) {
            return connect(socketAddress, (SocketAddress) getOption("localAddress"));
        }
        throw new NullPointerException("remotedAddress");
    }

    public ChannelFuture connect(SocketAddress socketAddress, SocketAddress socketAddress2) {
        if (socketAddress != null) {
            try {
                Channel newChannel = getFactory().newChannel(getPipelineFactory().getPipeline());
                newChannel.getConfig().setOptions(getOptions());
                if (socketAddress2 != null) {
                    newChannel.bind(socketAddress2);
                }
                return newChannel.connect(socketAddress);
            } catch (Exception e2) {
                throw new ChannelPipelineException("Failed to initialize a pipeline.", e2);
            }
        } else {
            throw new NullPointerException("remoteAddress");
        }
    }
}
