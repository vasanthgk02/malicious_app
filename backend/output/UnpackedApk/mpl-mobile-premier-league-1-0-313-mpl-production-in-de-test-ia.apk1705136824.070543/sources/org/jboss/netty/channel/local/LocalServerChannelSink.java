package org.jboss.netty.channel.local;

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

public final class LocalServerChannelSink extends AbstractChannelSink {
    public static final /* synthetic */ boolean $assertionsDisabled = false;

    /* renamed from: org.jboss.netty.channel.local.LocalServerChannelSink$1  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.channel.local.LocalServerChannelSink.AnonymousClass1.<clinit>():void");
        }
    }

    private void bind(DefaultLocalServerChannel defaultLocalServerChannel, ChannelFuture channelFuture, LocalAddress localAddress) {
        try {
            if (!LocalChannelRegistry.register(localAddress, defaultLocalServerChannel)) {
                throw new ChannelException("address already in use: " + localAddress);
            } else if (defaultLocalServerChannel.bound.compareAndSet(false, true)) {
                defaultLocalServerChannel.localAddress = localAddress;
                channelFuture.setSuccess();
                Channels.fireChannelBound((Channel) defaultLocalServerChannel, (SocketAddress) localAddress);
            } else {
                throw new ChannelException((String) "already bound");
            }
        } catch (Throwable th) {
            LocalChannelRegistry.unregister(localAddress);
            channelFuture.setFailure(th);
            Channels.fireExceptionCaught((Channel) defaultLocalServerChannel, th);
        }
    }

    private void close(DefaultLocalServerChannel defaultLocalServerChannel, ChannelFuture channelFuture) {
        try {
            if (defaultLocalServerChannel.setClosed()) {
                channelFuture.setSuccess();
                LocalAddress localAddress = defaultLocalServerChannel.localAddress;
                if (defaultLocalServerChannel.bound.compareAndSet(true, false)) {
                    defaultLocalServerChannel.localAddress = null;
                    LocalChannelRegistry.unregister(localAddress);
                    Channels.fireChannelUnbound((Channel) defaultLocalServerChannel);
                }
                Channels.fireChannelClosed((Channel) defaultLocalServerChannel);
                return;
            }
            channelFuture.setSuccess();
        } catch (Throwable th) {
            channelFuture.setFailure(th);
            Channels.fireExceptionCaught((Channel) defaultLocalServerChannel, th);
        }
    }

    private void handleAcceptedChannel(ChannelEvent channelEvent) {
        if (channelEvent instanceof ChannelStateEvent) {
            ChannelStateEvent channelStateEvent = (ChannelStateEvent) channelEvent;
            DefaultLocalChannel defaultLocalChannel = (DefaultLocalChannel) channelStateEvent.getChannel();
            ChannelFuture future = channelStateEvent.getFuture();
            ChannelState state = channelStateEvent.getState();
            Object value = channelStateEvent.getValue();
            int ordinal = state.ordinal();
            if (ordinal != 0) {
                if (ordinal == 1 || ordinal == 2) {
                    if (value == null) {
                        defaultLocalChannel.closeNow(future);
                    }
                } else if (ordinal == 3) {
                    future.setSuccess();
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

    private void handleServerChannel(ChannelEvent channelEvent) {
        if (channelEvent instanceof ChannelStateEvent) {
            ChannelStateEvent channelStateEvent = (ChannelStateEvent) channelEvent;
            DefaultLocalServerChannel defaultLocalServerChannel = (DefaultLocalServerChannel) channelStateEvent.getChannel();
            ChannelFuture future = channelStateEvent.getFuture();
            ChannelState state = channelStateEvent.getState();
            Object value = channelStateEvent.getValue();
            int ordinal = state.ordinal();
            if (ordinal != 0) {
                if (ordinal == 1) {
                    if (value != null) {
                        bind(defaultLocalServerChannel, future, (LocalAddress) value);
                    } else {
                        close(defaultLocalServerChannel, future);
                    }
                }
            } else if (Boolean.FALSE.equals(value)) {
                close(defaultLocalServerChannel, future);
            }
        }
    }

    public void eventSunk(ChannelPipeline channelPipeline, ChannelEvent channelEvent) throws Exception {
        Channel channel = channelEvent.getChannel();
        if (channel instanceof DefaultLocalServerChannel) {
            handleServerChannel(channelEvent);
        } else if (channel instanceof DefaultLocalChannel) {
            handleAcceptedChannel(channelEvent);
        }
    }
}
