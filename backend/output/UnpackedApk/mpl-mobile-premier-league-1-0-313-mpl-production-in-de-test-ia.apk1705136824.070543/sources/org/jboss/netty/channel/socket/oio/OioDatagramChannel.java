package org.jboss.netty.channel.socket.oio;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.net.SocketAddress;
import java.net.SocketException;
import org.jboss.netty.channel.AbstractChannel;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelException;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelSink;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.socket.DatagramChannel;
import org.jboss.netty.channel.socket.DatagramChannelConfig;
import org.jboss.netty.channel.socket.DefaultDatagramChannelConfig;

public final class OioDatagramChannel extends AbstractChannel implements DatagramChannel {
    public final DatagramChannelConfig config;
    public final Object interestOpsLock = new Object();
    public volatile InetSocketAddress localAddress;
    public volatile InetSocketAddress remoteAddress;
    public final MulticastSocket socket;
    public volatile Thread workerThread;

    public OioDatagramChannel(ChannelFactory channelFactory, ChannelPipeline channelPipeline, ChannelSink channelSink) {
        super(null, channelFactory, channelPipeline, channelSink);
        try {
            MulticastSocket multicastSocket = new MulticastSocket(null);
            this.socket = multicastSocket;
            try {
                multicastSocket.setSoTimeout(10);
                this.socket.setBroadcast(false);
                this.config = new DefaultDatagramChannelConfig(this.socket);
                Channels.fireChannelOpen((Channel) this);
            } catch (SocketException e2) {
                throw new ChannelException("Failed to configure the datagram socket timeout.", e2);
            }
        } catch (IOException e3) {
            throw new ChannelException("Failed to open a datagram socket.", e3);
        }
    }

    private void ensureBound() {
        if (!isBound()) {
            throw new IllegalStateException(GeneratedOutlineSupport.outline36(DatagramChannel.class, new StringBuilder(), " must be bound to join a group."));
        }
    }

    public boolean isBound() {
        return isOpen() && this.socket.isBound();
    }

    public boolean isConnected() {
        return isOpen() && this.socket.isConnected();
    }

    public void joinGroup(InetAddress inetAddress) {
        ensureBound();
        try {
            this.socket.joinGroup(inetAddress);
        } catch (IOException e2) {
            throw new ChannelException((Throwable) e2);
        }
    }

    public void leaveGroup(InetAddress inetAddress) {
        try {
            this.socket.leaveGroup(inetAddress);
        } catch (IOException e2) {
            throw new ChannelException((Throwable) e2);
        }
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
        return super.write(obj, socketAddress);
    }

    public DatagramChannelConfig getConfig() {
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

    public void leaveGroup(InetSocketAddress inetSocketAddress, NetworkInterface networkInterface) {
        try {
            this.socket.leaveGroup(inetSocketAddress, networkInterface);
        } catch (IOException e2) {
            throw new ChannelException((Throwable) e2);
        }
    }

    public void joinGroup(InetSocketAddress inetSocketAddress, NetworkInterface networkInterface) {
        ensureBound();
        try {
            this.socket.joinGroup(inetSocketAddress, networkInterface);
        } catch (IOException e2) {
            throw new ChannelException((Throwable) e2);
        }
    }
}
