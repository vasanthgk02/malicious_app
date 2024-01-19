package org.jboss.netty.channel.local;

import java.net.ConnectException;
import java.net.SocketAddress;
import org.jboss.netty.channel.AbstractChannelSink;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelEvent;
import org.jboss.netty.channel.ChannelException;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelState;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.logging.InternalLogger;
import org.jboss.netty.logging.InternalLoggerFactory;

public final class LocalClientChannelSink extends AbstractChannelSink {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final InternalLogger logger = InternalLoggerFactory.getInstance(LocalClientChannelSink.class);

    /* renamed from: org.jboss.netty.channel.local.LocalClientChannelSink$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$org$jboss$netty$channel$ChannelState;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x001d */
        static {
            /*
                org.jboss.netty.channel.ChannelState[] r0 = org.jboss.netty.channel.ChannelState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$jboss$netty$channel$ChannelState = r0
                r1 = 1
                org.jboss.netty.channel.ChannelState r2 = org.jboss.netty.channel.ChannelState.OPEN     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                int[] r2 = $SwitchMap$org$jboss$netty$channel$ChannelState     // Catch:{ NoSuchFieldError -> 0x0016 }
                org.jboss.netty.channel.ChannelState r3 = org.jboss.netty.channel.ChannelState.BOUND     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                r1 = 3
                int[] r2 = $SwitchMap$org$jboss$netty$channel$ChannelState     // Catch:{ NoSuchFieldError -> 0x001d }
                org.jboss.netty.channel.ChannelState r3 = org.jboss.netty.channel.ChannelState.CONNECTED     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$org$jboss$netty$channel$ChannelState     // Catch:{ NoSuchFieldError -> 0x0024 }
                org.jboss.netty.channel.ChannelState r2 = org.jboss.netty.channel.ChannelState.INTEREST_OPS     // Catch:{ NoSuchFieldError -> 0x0024 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0024 }
            L_0x0024:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.channel.local.LocalClientChannelSink.AnonymousClass1.<clinit>():void");
        }
    }

    private void bind(DefaultLocalChannel defaultLocalChannel, ChannelFuture channelFuture, LocalAddress localAddress) {
        try {
            if (!LocalChannelRegistry.register(localAddress, defaultLocalChannel)) {
                throw new ChannelException("address already in use: " + localAddress);
            } else if (defaultLocalChannel.bound.compareAndSet(false, true)) {
                defaultLocalChannel.localAddress = localAddress;
                channelFuture.setSuccess();
                Channels.fireChannelBound((Channel) defaultLocalChannel, (SocketAddress) localAddress);
            } else {
                throw new ChannelException((String) "already bound");
            }
        } catch (Throwable th) {
            LocalChannelRegistry.unregister(localAddress);
            channelFuture.setFailure(th);
            Channels.fireExceptionCaught((Channel) defaultLocalChannel, th);
        }
    }

    private void connect(DefaultLocalChannel defaultLocalChannel, ChannelFuture channelFuture, LocalAddress localAddress) {
        Channel channel = LocalChannelRegistry.getChannel(localAddress);
        if (!(channel instanceof DefaultLocalServerChannel)) {
            channelFuture.setFailure(new ConnectException("connection refused"));
            return;
        }
        DefaultLocalServerChannel defaultLocalServerChannel = (DefaultLocalServerChannel) channel;
        try {
            ChannelPipeline pipeline = defaultLocalServerChannel.getConfig().getPipelineFactory().getPipeline();
            channelFuture.setSuccess();
            DefaultLocalChannel defaultLocalChannel2 = new DefaultLocalChannel(defaultLocalServerChannel, defaultLocalServerChannel.getFactory(), pipeline, this, defaultLocalChannel);
            defaultLocalChannel.pairedChannel = defaultLocalChannel2;
            bind(defaultLocalChannel, Channels.succeededFuture(defaultLocalChannel), new LocalAddress((String) LocalAddress.EPHEMERAL));
            defaultLocalChannel.remoteAddress = defaultLocalServerChannel.getLocalAddress();
            Channels.fireChannelConnected((Channel) defaultLocalChannel, (SocketAddress) defaultLocalServerChannel.getLocalAddress());
            defaultLocalChannel2.localAddress = defaultLocalServerChannel.getLocalAddress();
            defaultLocalChannel2.bound.set(true);
            Channels.fireChannelBound((Channel) defaultLocalChannel2, (SocketAddress) defaultLocalChannel.getRemoteAddress());
            defaultLocalChannel2.remoteAddress = defaultLocalChannel.getLocalAddress();
            Channels.fireChannelConnected((Channel) defaultLocalChannel2, (SocketAddress) defaultLocalChannel.getLocalAddress());
            defaultLocalChannel.flushWriteBuffer();
            defaultLocalChannel2.flushWriteBuffer();
        } catch (Exception e2) {
            channelFuture.setFailure(e2);
            Channels.fireExceptionCaught((Channel) defaultLocalChannel, (Throwable) e2);
            logger.warn("Failed to initialize an accepted socket.", e2);
        }
    }

    public void eventSunk(ChannelPipeline channelPipeline, ChannelEvent channelEvent) throws Exception {
        if (channelEvent instanceof ChannelStateEvent) {
            ChannelStateEvent channelStateEvent = (ChannelStateEvent) channelEvent;
            DefaultLocalChannel defaultLocalChannel = (DefaultLocalChannel) channelStateEvent.getChannel();
            ChannelFuture future = channelStateEvent.getFuture();
            ChannelState state = channelStateEvent.getState();
            Object value = channelStateEvent.getValue();
            int ordinal = state.ordinal();
            if (ordinal != 0) {
                if (ordinal != 1) {
                    if (ordinal != 2) {
                        if (ordinal == 3) {
                            future.setSuccess();
                        }
                    } else if (value != null) {
                        connect(defaultLocalChannel, future, (LocalAddress) value);
                    } else {
                        defaultLocalChannel.closeNow(future);
                    }
                } else if (value != null) {
                    bind(defaultLocalChannel, future, (LocalAddress) value);
                } else {
                    defaultLocalChannel.closeNow(future);
                }
            } else if (Boolean.FALSE.equals(value)) {
                defaultLocalChannel.closeNow(future);
            }
        } else if (channelEvent instanceof MessageEvent) {
            MessageEvent messageEvent = (MessageEvent) channelEvent;
            DefaultLocalChannel defaultLocalChannel2 = (DefaultLocalChannel) messageEvent.getChannel();
            defaultLocalChannel2.writeBuffer.offer(messageEvent);
            defaultLocalChannel2.flushWriteBuffer();
        }
    }
}
