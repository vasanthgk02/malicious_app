package org.jboss.netty.bootstrap;

import java.net.SocketAddress;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelPipelineException;

public class ClientBootstrap extends Bootstrap {
    public ClientBootstrap() {
    }

    public ChannelFuture connect() {
        SocketAddress socketAddress = (SocketAddress) getOption("remoteAddress");
        if (socketAddress != null) {
            return connect(socketAddress);
        }
        throw new IllegalStateException("remoteAddress option is not set.");
    }

    public ClientBootstrap(ChannelFactory channelFactory) {
        super(channelFactory);
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
