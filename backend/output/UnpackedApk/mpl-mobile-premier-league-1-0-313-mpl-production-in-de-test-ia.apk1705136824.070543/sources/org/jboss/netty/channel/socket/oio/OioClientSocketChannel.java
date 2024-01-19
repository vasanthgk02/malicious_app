package org.jboss.netty.channel.socket.oio;

import java.io.OutputStream;
import java.io.PushbackInputStream;
import java.net.Socket;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelSink;
import org.jboss.netty.channel.Channels;

public class OioClientSocketChannel extends OioSocketChannel {

    /* renamed from: in  reason: collision with root package name */
    public volatile PushbackInputStream f6167in;
    public volatile OutputStream out;

    public OioClientSocketChannel(ChannelFactory channelFactory, ChannelPipeline channelPipeline, ChannelSink channelSink) {
        super(null, channelFactory, channelPipeline, channelSink, new Socket());
        Channels.fireChannelOpen((Channel) this);
    }

    public PushbackInputStream getInputStream() {
        return this.f6167in;
    }

    public OutputStream getOutputStream() {
        return this.out;
    }
}
