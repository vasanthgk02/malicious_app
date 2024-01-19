package org.jboss.netty.channel.socket.oio;

import java.io.OutputStream;
import java.io.PushbackInputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import org.jboss.netty.channel.AbstractChannel;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelSink;
import org.jboss.netty.channel.socket.DefaultSocketChannelConfig;
import org.jboss.netty.channel.socket.SocketChannel;
import org.jboss.netty.channel.socket.SocketChannelConfig;

public abstract class OioSocketChannel extends AbstractChannel implements SocketChannel {
    public final SocketChannelConfig config;
    public final Object interestOpsLock = new Object();
    public volatile InetSocketAddress localAddress;
    public volatile InetSocketAddress remoteAddress;
    public final Socket socket;
    public volatile Thread workerThread;

    public OioSocketChannel(Channel channel, ChannelFactory channelFactory, ChannelPipeline channelPipeline, ChannelSink channelSink, Socket socket2) {
        super(channel, channelFactory, channelPipeline, channelSink);
        this.socket = socket2;
        this.config = new DefaultSocketChannelConfig(socket2);
    }

    public abstract PushbackInputStream getInputStream();

    public abstract OutputStream getOutputStream();

    public boolean isBound() {
        return isOpen() && this.socket.isBound();
    }

    public boolean isConnected() {
        return isOpen() && this.socket.isConnected();
    }

    public boolean setClosed() {
        return super.setClosed();
    }

    public void setInterestOpsNow(int i) {
        super.setInterestOpsNow(i);
    }

    public ChannelFuture write(Object obj, SocketAddress socketAddress) {
        if (socketAddress == null || socketAddress.equals(getRemoteAddress())) {
            return super.write(obj, null);
        }
        return getUnsupportedOperationFuture();
    }

    public SocketChannelConfig getConfig() {
        return this.config;
    }

    public InetSocketAddress getLocalAddress() {
        InetSocketAddress inetSocketAddress = this.localAddress;
        if (inetSocketAddress != null) {
            return inetSocketAddress;
        }
        try {
            InetSocketAddress inetSocketAddress2 = (InetSocketAddress) this.socket.getLocalSocketAddress();
            this.localAddress = inetSocketAddress2;
            return inetSocketAddress2;
        } catch (Throwable unused) {
            return null;
        }
    }

    public InetSocketAddress getRemoteAddress() {
        InetSocketAddress inetSocketAddress = this.remoteAddress;
        if (inetSocketAddress != null) {
            return inetSocketAddress;
        }
        try {
            InetSocketAddress inetSocketAddress2 = (InetSocketAddress) this.socket.getRemoteSocketAddress();
            this.remoteAddress = inetSocketAddress2;
            return inetSocketAddress2;
        } catch (Throwable unused) {
            return null;
        }
    }
}
