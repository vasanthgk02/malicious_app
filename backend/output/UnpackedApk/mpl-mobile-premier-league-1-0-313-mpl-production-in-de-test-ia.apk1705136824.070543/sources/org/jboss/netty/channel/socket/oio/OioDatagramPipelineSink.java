package org.jboss.netty.channel.socket.oio;

import java.net.SocketAddress;
import java.util.concurrent.Executor;
import org.jboss.netty.channel.AbstractChannelSink;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelEvent;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelFutureListener;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelState;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.util.ThreadRenamingRunnable;
import org.jboss.netty.util.internal.IoWorkerRunnable;

public class OioDatagramPipelineSink extends AbstractChannelSink {
    public final Executor workerExecutor;

    /* renamed from: org.jboss.netty.channel.socket.oio.OioDatagramPipelineSink$1  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.channel.socket.oio.OioDatagramPipelineSink.AnonymousClass1.<clinit>():void");
        }
    }

    public OioDatagramPipelineSink(Executor executor) {
        this.workerExecutor = executor;
    }

    private void bind(OioDatagramChannel oioDatagramChannel, ChannelFuture channelFuture, SocketAddress socketAddress) {
        boolean z = false;
        try {
            oioDatagramChannel.socket.bind(socketAddress);
            z = true;
            channelFuture.setSuccess();
            Channels.fireChannelBound((Channel) oioDatagramChannel, (SocketAddress) oioDatagramChannel.getLocalAddress());
            Executor executor = this.workerExecutor;
            OioDatagramWorker oioDatagramWorker = new OioDatagramWorker(oioDatagramChannel);
            executor.execute(new IoWorkerRunnable(new ThreadRenamingRunnable(oioDatagramWorker, "Old I/O datagram worker (" + oioDatagramChannel + ')')));
        } catch (Throwable th) {
            if (z) {
                OioDatagramWorker.close(oioDatagramChannel, channelFuture);
            }
            throw th;
        }
    }

    private void connect(OioDatagramChannel oioDatagramChannel, ChannelFuture channelFuture, SocketAddress socketAddress) {
        boolean isBound = oioDatagramChannel.isBound();
        channelFuture.addListener(ChannelFutureListener.CLOSE_ON_FAILURE);
        oioDatagramChannel.remoteAddress = null;
        try {
            oioDatagramChannel.socket.connect(socketAddress);
            channelFuture.setSuccess();
            if (!isBound) {
                Channels.fireChannelBound((Channel) oioDatagramChannel, (SocketAddress) oioDatagramChannel.getLocalAddress());
            }
            Channels.fireChannelConnected((Channel) oioDatagramChannel, (SocketAddress) oioDatagramChannel.getRemoteAddress());
            String str = "Old I/O datagram worker (" + oioDatagramChannel + ')';
            if (!isBound) {
                this.workerExecutor.execute(new IoWorkerRunnable(new ThreadRenamingRunnable(new OioDatagramWorker(oioDatagramChannel), str)));
                return;
            }
            Thread thread = oioDatagramChannel.workerThread;
            if (thread != null) {
                try {
                    thread.setName(str);
                } catch (SecurityException unused) {
                }
            }
        } catch (Throwable th) {
            if (0 != 0) {
                OioDatagramWorker.close(oioDatagramChannel, channelFuture);
            }
            throw th;
        }
    }

    public void eventSunk(ChannelPipeline channelPipeline, ChannelEvent channelEvent) throws Exception {
        OioDatagramChannel oioDatagramChannel = (OioDatagramChannel) channelEvent.getChannel();
        ChannelFuture future = channelEvent.getFuture();
        if (channelEvent instanceof ChannelStateEvent) {
            ChannelStateEvent channelStateEvent = (ChannelStateEvent) channelEvent;
            ChannelState state = channelStateEvent.getState();
            Object value = channelStateEvent.getValue();
            int ordinal = state.ordinal();
            if (ordinal != 0) {
                if (ordinal != 1) {
                    if (ordinal != 2) {
                        if (ordinal == 3) {
                            OioDatagramWorker.setInterestOps(oioDatagramChannel, future, ((Integer) value).intValue());
                        }
                    } else if (value != null) {
                        connect(oioDatagramChannel, future, (SocketAddress) value);
                    } else {
                        OioDatagramWorker.disconnect(oioDatagramChannel, future);
                    }
                } else if (value != null) {
                    bind(oioDatagramChannel, future, (SocketAddress) value);
                } else {
                    OioDatagramWorker.close(oioDatagramChannel, future);
                }
            } else if (Boolean.FALSE.equals(value)) {
                OioDatagramWorker.close(oioDatagramChannel, future);
            }
        } else if (channelEvent instanceof MessageEvent) {
            MessageEvent messageEvent = (MessageEvent) channelEvent;
            OioDatagramWorker.write(oioDatagramChannel, future, messageEvent.getMessage(), messageEvent.getRemoteAddress());
        }
    }
}
