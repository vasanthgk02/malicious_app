package org.jboss.netty.channel.socket.nio;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
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

public class NioDatagramPipelineSink extends AbstractChannelSink {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final AtomicInteger nextId = new AtomicInteger();
    public final int id = nextId.incrementAndGet();
    public final AtomicInteger workerIndex = new AtomicInteger();
    public final NioDatagramWorker[] workers;

    /* renamed from: org.jboss.netty.channel.socket.nio.NioDatagramPipelineSink$1  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.channel.socket.nio.NioDatagramPipelineSink.AnonymousClass1.<clinit>():void");
        }
    }

    public NioDatagramPipelineSink(Executor executor, int i) {
        this.workers = new NioDatagramWorker[i];
        int i2 = 0;
        while (true) {
            NioDatagramWorker[] nioDatagramWorkerArr = this.workers;
            if (i2 < nioDatagramWorkerArr.length) {
                int i3 = i2 + 1;
                nioDatagramWorkerArr[i2] = new NioDatagramWorker(this.id, i3, executor);
                i2 = i3;
            } else {
                return;
            }
        }
    }

    private void bind(NioDatagramChannel nioDatagramChannel, ChannelFuture channelFuture, InetSocketAddress inetSocketAddress) {
        boolean z = false;
        try {
            nioDatagramChannel.getDatagramChannel().socket().bind(inetSocketAddress);
            z = true;
            channelFuture.setSuccess();
            Channels.fireChannelBound((Channel) nioDatagramChannel, (SocketAddress) inetSocketAddress);
            nioDatagramChannel.worker.register(nioDatagramChannel, null);
        } catch (Throwable th) {
            if (z) {
                close(nioDatagramChannel, channelFuture);
            }
            throw th;
        }
    }

    private void close(NioDatagramChannel nioDatagramChannel, ChannelFuture channelFuture) {
        try {
            nioDatagramChannel.getDatagramChannel().socket().close();
            if (nioDatagramChannel.setClosed()) {
                channelFuture.setSuccess();
                if (nioDatagramChannel.isBound()) {
                    Channels.fireChannelUnbound((Channel) nioDatagramChannel);
                }
                Channels.fireChannelClosed((Channel) nioDatagramChannel);
                return;
            }
            channelFuture.setSuccess();
        } catch (Throwable th) {
            channelFuture.setFailure(th);
            Channels.fireExceptionCaught((Channel) nioDatagramChannel, th);
        }
    }

    private void connect(NioDatagramChannel nioDatagramChannel, ChannelFuture channelFuture, SocketAddress socketAddress) {
        boolean isBound = nioDatagramChannel.isBound();
        channelFuture.addListener(ChannelFutureListener.CLOSE_ON_FAILURE);
        nioDatagramChannel.remoteAddress = null;
        try {
            nioDatagramChannel.getDatagramChannel().connect(socketAddress);
            channelFuture.setSuccess();
            if (!isBound) {
                Channels.fireChannelBound((Channel) nioDatagramChannel, (SocketAddress) nioDatagramChannel.getLocalAddress());
            }
            Channels.fireChannelConnected((Channel) nioDatagramChannel, (SocketAddress) nioDatagramChannel.getRemoteAddress());
            if (!isBound) {
                nioDatagramChannel.worker.register(nioDatagramChannel, channelFuture);
            }
        } catch (Throwable th) {
            if (0 != 0) {
                nioDatagramChannel.worker.close(nioDatagramChannel, channelFuture);
            }
            throw th;
        }
    }

    public void eventSunk(ChannelPipeline channelPipeline, ChannelEvent channelEvent) throws Exception {
        NioDatagramChannel nioDatagramChannel = (NioDatagramChannel) channelEvent.getChannel();
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
                            nioDatagramChannel.worker.setInterestOps(nioDatagramChannel, future, ((Integer) value).intValue());
                        }
                    } else if (value != null) {
                        connect(nioDatagramChannel, future, (InetSocketAddress) value);
                    } else {
                        NioDatagramWorker.disconnect(nioDatagramChannel, future);
                    }
                } else if (value != null) {
                    bind(nioDatagramChannel, future, (InetSocketAddress) value);
                } else {
                    nioDatagramChannel.worker.close(nioDatagramChannel, future);
                }
            } else if (Boolean.FALSE.equals(value)) {
                nioDatagramChannel.worker.close(nioDatagramChannel, future);
            }
        } else if (channelEvent instanceof MessageEvent) {
            nioDatagramChannel.writeBufferQueue.offer((MessageEvent) channelEvent);
            nioDatagramChannel.worker.writeFromUserCode(nioDatagramChannel);
        }
    }

    public NioDatagramWorker nextWorker() {
        return this.workers[Math.abs(this.workerIndex.getAndIncrement() % this.workers.length)];
    }
}
