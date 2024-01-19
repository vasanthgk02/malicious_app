package org.jboss.netty.channel.socket.oio;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PushbackInputStream;
import java.net.Socket;
import java.net.SocketAddress;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelException;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelSink;
import org.jboss.netty.channel.Channels;

public class OioAcceptedSocketChannel extends OioSocketChannel {

    /* renamed from: in  reason: collision with root package name */
    public final PushbackInputStream f6166in;
    public final OutputStream out;

    public OioAcceptedSocketChannel(Channel channel, ChannelFactory channelFactory, ChannelPipeline channelPipeline, ChannelSink channelSink, Socket socket) {
        super(channel, channelFactory, channelPipeline, channelSink, socket);
        try {
            this.f6166in = new PushbackInputStream(socket.getInputStream(), 1);
            try {
                this.out = socket.getOutputStream();
                Channels.fireChannelOpen((Channel) this);
                Channels.fireChannelBound((Channel) this, (SocketAddress) getLocalAddress());
                Channels.fireChannelConnected((Channel) this, (SocketAddress) getRemoteAddress());
            } catch (IOException e2) {
                throw new ChannelException("Failed to obtain an OutputStream.", e2);
            }
        } catch (IOException e3) {
            throw new ChannelException("Failed to obtain an InputStream.", e3);
        }
    }

    public PushbackInputStream getInputStream() {
        return this.f6166in;
    }

    public OutputStream getOutputStream() {
        return this.out;
    }
}
