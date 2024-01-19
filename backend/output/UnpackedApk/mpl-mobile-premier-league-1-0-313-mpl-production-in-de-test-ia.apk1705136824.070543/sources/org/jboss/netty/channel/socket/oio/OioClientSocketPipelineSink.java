package org.jboss.netty.channel.socket.oio;

import java.net.SocketAddress;
import java.util.concurrent.Executor;
import org.jboss.netty.channel.AbstractChannelSink;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelEvent;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelState;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.MessageEvent;

public class OioClientSocketPipelineSink extends AbstractChannelSink {
    public final Executor workerExecutor;

    /* renamed from: org.jboss.netty.channel.socket.oio.OioClientSocketPipelineSink$1  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.channel.socket.oio.OioClientSocketPipelineSink.AnonymousClass1.<clinit>():void");
        }
    }

    public OioClientSocketPipelineSink(Executor executor) {
        this.workerExecutor = executor;
    }

    private void bind(OioClientSocketChannel oioClientSocketChannel, ChannelFuture channelFuture, SocketAddress socketAddress) {
        try {
            oioClientSocketChannel.socket.bind(socketAddress);
            channelFuture.setSuccess();
            Channels.fireChannelBound((Channel) oioClientSocketChannel, (SocketAddress) oioClientSocketChannel.getLocalAddress());
        } catch (Throwable th) {
            channelFuture.setFailure(th);
            Channels.fireExceptionCaught((Channel) oioClientSocketChannel, th);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0077 A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void connect(org.jboss.netty.channel.socket.oio.OioClientSocketChannel r7, org.jboss.netty.channel.ChannelFuture r8, java.net.SocketAddress r9) {
        /*
            r6 = this;
            boolean r0 = r7.isBound()
            org.jboss.netty.channel.ChannelFutureListener r1 = org.jboss.netty.channel.ChannelFutureListener.CLOSE_ON_FAILURE
            r8.addListener(r1)
            r1 = 1
            r2 = 0
            java.net.Socket r3 = r7.socket     // Catch:{ all -> 0x006d }
            org.jboss.netty.channel.socket.SocketChannelConfig r4 = r7.getConfig()     // Catch:{ all -> 0x006d }
            int r4 = r4.getConnectTimeoutMillis()     // Catch:{ all -> 0x006d }
            r3.connect(r9, r4)     // Catch:{ all -> 0x006d }
            java.io.PushbackInputStream r9 = new java.io.PushbackInputStream     // Catch:{ all -> 0x006b }
            java.net.Socket r2 = r7.socket     // Catch:{ all -> 0x006b }
            java.io.InputStream r2 = r2.getInputStream()     // Catch:{ all -> 0x006b }
            r9.<init>(r2, r1)     // Catch:{ all -> 0x006b }
            r7.f6167in = r9     // Catch:{ all -> 0x006b }
            java.net.Socket r9 = r7.socket     // Catch:{ all -> 0x006b }
            java.io.OutputStream r9 = r9.getOutputStream()     // Catch:{ all -> 0x006b }
            r7.out = r9     // Catch:{ all -> 0x006b }
            r8.setSuccess()     // Catch:{ all -> 0x006b }
            if (r0 != 0) goto L_0x0039
            java.net.InetSocketAddress r9 = r7.getLocalAddress()     // Catch:{ all -> 0x006b }
            org.jboss.netty.channel.Channels.fireChannelBound(r7, r9)     // Catch:{ all -> 0x006b }
        L_0x0039:
            java.net.InetSocketAddress r9 = r7.getRemoteAddress()     // Catch:{ all -> 0x006b }
            org.jboss.netty.channel.Channels.fireChannelConnected(r7, r9)     // Catch:{ all -> 0x006b }
            java.util.concurrent.Executor r9 = r6.workerExecutor     // Catch:{ all -> 0x006b }
            org.jboss.netty.util.internal.IoWorkerRunnable r0 = new org.jboss.netty.util.internal.IoWorkerRunnable     // Catch:{ all -> 0x006b }
            org.jboss.netty.util.ThreadRenamingRunnable r2 = new org.jboss.netty.util.ThreadRenamingRunnable     // Catch:{ all -> 0x006b }
            org.jboss.netty.channel.socket.oio.OioWorker r3 = new org.jboss.netty.channel.socket.oio.OioWorker     // Catch:{ all -> 0x006b }
            r3.<init>(r7)     // Catch:{ all -> 0x006b }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x006b }
            r4.<init>()     // Catch:{ all -> 0x006b }
            java.lang.String r5 = "Old I/O client worker ("
            r4.append(r5)     // Catch:{ all -> 0x006b }
            r4.append(r7)     // Catch:{ all -> 0x006b }
            r5 = 41
            r4.append(r5)     // Catch:{ all -> 0x006b }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x006b }
            r2.<init>(r3, r4)     // Catch:{ all -> 0x006b }
            r0.<init>(r2)     // Catch:{ all -> 0x006b }
            r9.execute(r0)     // Catch:{ all -> 0x006b }
            goto L_0x007a
        L_0x006b:
            r9 = move-exception
            goto L_0x006f
        L_0x006d:
            r9 = move-exception
            r1 = 0
        L_0x006f:
            r8.setFailure(r9)     // Catch:{ all -> 0x007b }
            org.jboss.netty.channel.Channels.fireExceptionCaught(r7, r9)     // Catch:{ all -> 0x007b }
            if (r1 == 0) goto L_0x007a
            org.jboss.netty.channel.socket.oio.OioWorker.close(r7, r8)
        L_0x007a:
            return
        L_0x007b:
            r9 = move-exception
            if (r1 == 0) goto L_0x0081
            org.jboss.netty.channel.socket.oio.OioWorker.close(r7, r8)
        L_0x0081:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.channel.socket.oio.OioClientSocketPipelineSink.connect(org.jboss.netty.channel.socket.oio.OioClientSocketChannel, org.jboss.netty.channel.ChannelFuture, java.net.SocketAddress):void");
    }

    public void eventSunk(ChannelPipeline channelPipeline, ChannelEvent channelEvent) throws Exception {
        OioClientSocketChannel oioClientSocketChannel = (OioClientSocketChannel) channelEvent.getChannel();
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
                            OioWorker.setInterestOps(oioClientSocketChannel, future, ((Integer) value).intValue());
                        }
                    } else if (value != null) {
                        connect(oioClientSocketChannel, future, (SocketAddress) value);
                    } else {
                        OioWorker.close(oioClientSocketChannel, future);
                    }
                } else if (value != null) {
                    bind(oioClientSocketChannel, future, (SocketAddress) value);
                } else {
                    OioWorker.close(oioClientSocketChannel, future);
                }
            } else if (Boolean.FALSE.equals(value)) {
                OioWorker.close(oioClientSocketChannel, future);
            }
        } else if (channelEvent instanceof MessageEvent) {
            OioWorker.write(oioClientSocketChannel, future, ((MessageEvent) channelEvent).getMessage());
        }
    }
}
