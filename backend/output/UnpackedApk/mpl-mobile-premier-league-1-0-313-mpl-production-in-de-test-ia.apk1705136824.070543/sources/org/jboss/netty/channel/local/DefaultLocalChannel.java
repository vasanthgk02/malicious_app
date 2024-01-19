package org.jboss.netty.channel.local;

import java.nio.channels.ClosedChannelException;
import java.nio.channels.NotYetConnectedException;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jboss.netty.channel.AbstractChannel;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelConfig;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelSink;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.DefaultChannelConfig;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.util.internal.LinkedTransferQueue;
import org.jboss.netty.util.internal.ThreadLocalBoolean;

public final class DefaultLocalChannel extends AbstractChannel implements LocalChannel {
    public final AtomicBoolean bound = new AtomicBoolean();
    public final ChannelConfig config;
    public final ThreadLocalBoolean delivering = new ThreadLocalBoolean();
    public volatile LocalAddress localAddress;
    public volatile DefaultLocalChannel pairedChannel;
    public volatile LocalAddress remoteAddress;
    public final Queue<MessageEvent> writeBuffer = new LinkedTransferQueue();

    public DefaultLocalChannel(LocalServerChannel localServerChannel, ChannelFactory channelFactory, ChannelPipeline channelPipeline, ChannelSink channelSink, DefaultLocalChannel defaultLocalChannel) {
        super(localServerChannel, channelFactory, channelPipeline, channelSink);
        this.pairedChannel = defaultLocalChannel;
        this.config = new DefaultChannelConfig();
        Channels.fireChannelOpen((Channel) this);
    }

    public void closeNow(ChannelFuture channelFuture) {
        LocalAddress localAddress2 = this.localAddress;
        try {
            if (setClosed()) {
                DefaultLocalChannel defaultLocalChannel = this.pairedChannel;
                if (defaultLocalChannel != null) {
                    this.pairedChannel = null;
                    Channels.fireChannelDisconnected((Channel) this);
                    Channels.fireChannelUnbound((Channel) this);
                }
                Channels.fireChannelClosed((Channel) this);
                if (defaultLocalChannel != null) {
                    if (defaultLocalChannel.setClosed()) {
                        if (defaultLocalChannel.pairedChannel != null) {
                            defaultLocalChannel.pairedChannel = null;
                            Channels.fireChannelDisconnected((Channel) defaultLocalChannel);
                            Channels.fireChannelUnbound((Channel) defaultLocalChannel);
                        }
                        Channels.fireChannelClosed((Channel) defaultLocalChannel);
                        channelFuture.setSuccess();
                        if (localAddress2 != null && getParent() == null) {
                            LocalChannelRegistry.unregister(localAddress2);
                        }
                        return;
                    }
                }
                channelFuture.setSuccess();
                if (localAddress2 != null && getParent() == null) {
                    LocalChannelRegistry.unregister(localAddress2);
                }
            }
        } finally {
            channelFuture.setSuccess();
            if (localAddress2 != null && getParent() == null) {
                LocalChannelRegistry.unregister(localAddress2);
            }
        }
    }

    public void flushWriteBuffer() {
        Throwable th;
        DefaultLocalChannel defaultLocalChannel = this.pairedChannel;
        if (defaultLocalChannel == null) {
            if (isOpen()) {
                th = new NotYetConnectedException();
            } else {
                th = new ClosedChannelException();
            }
            while (true) {
                MessageEvent poll = this.writeBuffer.poll();
                if (poll != null) {
                    poll.getFuture().setFailure(th);
                    Channels.fireExceptionCaught((Channel) this, th);
                } else {
                    return;
                }
            }
        } else if (defaultLocalChannel.isConnected() && !((Boolean) this.delivering.get()).booleanValue()) {
            this.delivering.set(Boolean.TRUE);
            while (true) {
                try {
                    MessageEvent poll2 = this.writeBuffer.poll();
                    if (poll2 != null) {
                        poll2.getFuture().setSuccess();
                        Channels.fireMessageReceived((Channel) defaultLocalChannel, poll2.getMessage());
                        Channels.fireWriteComplete((Channel) this, 1);
                    } else {
                        return;
                    }
                } finally {
                    this.delivering.set(Boolean.FALSE);
                }
            }
        }
    }

    public ChannelConfig getConfig() {
        return this.config;
    }

    public boolean isBound() {
        return this.bound.get() && isOpen();
    }

    public boolean isConnected() {
        return this.pairedChannel != null && isOpen();
    }

    public LocalAddress getLocalAddress() {
        return this.localAddress;
    }

    public LocalAddress getRemoteAddress() {
        return this.remoteAddress;
    }
}
