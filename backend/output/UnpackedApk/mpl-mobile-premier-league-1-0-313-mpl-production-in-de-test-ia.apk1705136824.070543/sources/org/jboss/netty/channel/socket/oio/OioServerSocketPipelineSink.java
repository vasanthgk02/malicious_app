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
import org.jboss.netty.logging.InternalLogger;
import org.jboss.netty.logging.InternalLoggerFactory;
import org.jboss.netty.util.ThreadRenamingRunnable;
import org.jboss.netty.util.internal.IoWorkerRunnable;

public class OioServerSocketPipelineSink extends AbstractChannelSink {
    public static final InternalLogger logger = InternalLoggerFactory.getInstance(OioServerSocketPipelineSink.class);
    public final Executor workerExecutor;

    /* renamed from: org.jboss.netty.channel.socket.oio.OioServerSocketPipelineSink$1  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.channel.socket.oio.OioServerSocketPipelineSink.AnonymousClass1.<clinit>():void");
        }
    }

    public final class Boss implements Runnable {
        public final OioServerSocketChannel channel;

        public Boss(OioServerSocketChannel oioServerSocketChannel) {
            this.channel = oioServerSocketChannel;
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(3:1|2|(6:4|5|6|7|36|32)(1:33)) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x007f, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
            org.jboss.netty.channel.socket.oio.OioServerSocketPipelineSink.logger.warn("Failed to close a partially accepted socket.", r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0089, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0092, code lost:
            if (r8.channel.socket.isBound() == false) goto L_0x00ad;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x009c, code lost:
            if (r8.channel.socket.isClosed() != false) goto L_0x009e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x009f, code lost:
            org.jboss.netty.channel.socket.oio.OioServerSocketPipelineSink.logger.warn("Failed to accept a connection.", r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
            java.lang.Thread.sleep(1000);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x00b5, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b6, code lost:
            r8.channel.shutdownLock.unlock();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x00bd, code lost:
            throw r0;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:1:0x0007 */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x0089 A[ExcHandler: all (r0v7 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:4:0x000f] */
        /* JADX WARNING: Removed duplicated region for block: B:1:0x0007 A[LOOP:0: B:1:0x0007->B:32:0x0007, LOOP_START, SYNTHETIC, Splitter:B:1:0x0007] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r8 = this;
                org.jboss.netty.channel.socket.oio.OioServerSocketChannel r0 = r8.channel
                java.util.concurrent.locks.Lock r0 = r0.shutdownLock
                r0.lock()
            L_0x0007:
                org.jboss.netty.channel.socket.oio.OioServerSocketChannel r0 = r8.channel     // Catch:{ all -> 0x00b5 }
                boolean r0 = r0.isBound()     // Catch:{ all -> 0x00b5 }
                if (r0 == 0) goto L_0x00ad
                org.jboss.netty.channel.socket.oio.OioServerSocketChannel r0 = r8.channel     // Catch:{ all -> 0x0089 }
                java.net.ServerSocket r0 = r0.socket     // Catch:{ all -> 0x0089 }
                java.net.Socket r0 = r0.accept()     // Catch:{ all -> 0x0089 }
                org.jboss.netty.channel.socket.oio.OioServerSocketChannel r1 = r8.channel     // Catch:{ Exception -> 0x0073, all -> 0x0089 }
                org.jboss.netty.channel.socket.ServerSocketChannelConfig r1 = r1.getConfig()     // Catch:{ Exception -> 0x0073, all -> 0x0089 }
                org.jboss.netty.channel.ChannelPipelineFactory r1 = r1.getPipelineFactory()     // Catch:{ Exception -> 0x0073, all -> 0x0089 }
                org.jboss.netty.channel.ChannelPipeline r4 = r1.getPipeline()     // Catch:{ Exception -> 0x0073, all -> 0x0089 }
                org.jboss.netty.channel.socket.oio.OioAcceptedSocketChannel r7 = new org.jboss.netty.channel.socket.oio.OioAcceptedSocketChannel     // Catch:{ Exception -> 0x0073, all -> 0x0089 }
                org.jboss.netty.channel.socket.oio.OioServerSocketChannel r2 = r8.channel     // Catch:{ Exception -> 0x0073, all -> 0x0089 }
                org.jboss.netty.channel.socket.oio.OioServerSocketChannel r1 = r8.channel     // Catch:{ Exception -> 0x0073, all -> 0x0089 }
                org.jboss.netty.channel.ChannelFactory r3 = r1.getFactory()     // Catch:{ Exception -> 0x0073, all -> 0x0089 }
                org.jboss.netty.channel.socket.oio.OioServerSocketPipelineSink r5 = org.jboss.netty.channel.socket.oio.OioServerSocketPipelineSink.this     // Catch:{ Exception -> 0x0073, all -> 0x0089 }
                r1 = r7
                r6 = r0
                r1.<init>(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x0073, all -> 0x0089 }
                org.jboss.netty.channel.socket.oio.OioServerSocketPipelineSink r1 = org.jboss.netty.channel.socket.oio.OioServerSocketPipelineSink.this     // Catch:{ Exception -> 0x0073, all -> 0x0089 }
                java.util.concurrent.Executor r1 = r1.workerExecutor     // Catch:{ Exception -> 0x0073, all -> 0x0089 }
                org.jboss.netty.util.internal.IoWorkerRunnable r2 = new org.jboss.netty.util.internal.IoWorkerRunnable     // Catch:{ Exception -> 0x0073, all -> 0x0089 }
                org.jboss.netty.util.ThreadRenamingRunnable r3 = new org.jboss.netty.util.ThreadRenamingRunnable     // Catch:{ Exception -> 0x0073, all -> 0x0089 }
                org.jboss.netty.channel.socket.oio.OioWorker r4 = new org.jboss.netty.channel.socket.oio.OioWorker     // Catch:{ Exception -> 0x0073, all -> 0x0089 }
                r4.<init>(r7)     // Catch:{ Exception -> 0x0073, all -> 0x0089 }
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0073, all -> 0x0089 }
                r5.<init>()     // Catch:{ Exception -> 0x0073, all -> 0x0089 }
                java.lang.String r6 = "Old I/O server worker (parentId: "
                r5.append(r6)     // Catch:{ Exception -> 0x0073, all -> 0x0089 }
                org.jboss.netty.channel.socket.oio.OioServerSocketChannel r6 = r8.channel     // Catch:{ Exception -> 0x0073, all -> 0x0089 }
                java.lang.Integer r6 = r6.getId()     // Catch:{ Exception -> 0x0073, all -> 0x0089 }
                r5.append(r6)     // Catch:{ Exception -> 0x0073, all -> 0x0089 }
                java.lang.String r6 = ", "
                r5.append(r6)     // Catch:{ Exception -> 0x0073, all -> 0x0089 }
                org.jboss.netty.channel.socket.oio.OioServerSocketChannel r6 = r8.channel     // Catch:{ Exception -> 0x0073, all -> 0x0089 }
                r5.append(r6)     // Catch:{ Exception -> 0x0073, all -> 0x0089 }
                r6 = 41
                r5.append(r6)     // Catch:{ Exception -> 0x0073, all -> 0x0089 }
                java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0073, all -> 0x0089 }
                r3.<init>(r4, r5)     // Catch:{ Exception -> 0x0073, all -> 0x0089 }
                r2.<init>(r3)     // Catch:{ Exception -> 0x0073, all -> 0x0089 }
                r1.execute(r2)     // Catch:{ Exception -> 0x0073, all -> 0x0089 }
                goto L_0x0007
            L_0x0073:
                r1 = move-exception
                org.jboss.netty.logging.InternalLogger r2 = org.jboss.netty.channel.socket.oio.OioServerSocketPipelineSink.logger     // Catch:{ all -> 0x0089 }
                java.lang.String r3 = "Failed to initialize an accepted socket."
                r2.warn(r3, r1)     // Catch:{ all -> 0x0089 }
                r0.close()     // Catch:{ IOException -> 0x007f, all -> 0x0089 }
                goto L_0x0007
            L_0x007f:
                r0 = move-exception
                org.jboss.netty.logging.InternalLogger r1 = org.jboss.netty.channel.socket.oio.OioServerSocketPipelineSink.logger     // Catch:{ all -> 0x0089 }
                java.lang.String r2 = "Failed to close a partially accepted socket."
                r1.warn(r2, r0)     // Catch:{ all -> 0x0089 }
                goto L_0x0007
            L_0x0089:
                r0 = move-exception
                org.jboss.netty.channel.socket.oio.OioServerSocketChannel r1 = r8.channel     // Catch:{ all -> 0x00b5 }
                java.net.ServerSocket r1 = r1.socket     // Catch:{ all -> 0x00b5 }
                boolean r1 = r1.isBound()     // Catch:{ all -> 0x00b5 }
                if (r1 == 0) goto L_0x00ad
                org.jboss.netty.channel.socket.oio.OioServerSocketChannel r1 = r8.channel     // Catch:{ all -> 0x00b5 }
                java.net.ServerSocket r1 = r1.socket     // Catch:{ all -> 0x00b5 }
                boolean r1 = r1.isClosed()     // Catch:{ all -> 0x00b5 }
                if (r1 == 0) goto L_0x009f
                goto L_0x00ad
            L_0x009f:
                org.jboss.netty.logging.InternalLogger r1 = org.jboss.netty.channel.socket.oio.OioServerSocketPipelineSink.logger     // Catch:{ all -> 0x00b5 }
                java.lang.String r2 = "Failed to accept a connection."
                r1.warn(r2, r0)     // Catch:{ all -> 0x00b5 }
                r0 = 1000(0x3e8, double:4.94E-321)
                java.lang.Thread.sleep(r0)     // Catch:{ SocketTimeoutException -> 0x0007 }
                goto L_0x0007
            L_0x00ad:
                org.jboss.netty.channel.socket.oio.OioServerSocketChannel r0 = r8.channel
                java.util.concurrent.locks.Lock r0 = r0.shutdownLock
                r0.unlock()
                return
            L_0x00b5:
                r0 = move-exception
                org.jboss.netty.channel.socket.oio.OioServerSocketChannel r1 = r8.channel
                java.util.concurrent.locks.Lock r1 = r1.shutdownLock
                r1.unlock()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.channel.socket.oio.OioServerSocketPipelineSink.Boss.run():void");
        }
    }

    public OioServerSocketPipelineSink(Executor executor) {
        this.workerExecutor = executor;
    }

    private void bind(OioServerSocketChannel oioServerSocketChannel, ChannelFuture channelFuture, SocketAddress socketAddress) {
        boolean z = false;
        try {
            oioServerSocketChannel.socket.bind(socketAddress, oioServerSocketChannel.getConfig().getBacklog());
            z = true;
            channelFuture.setSuccess();
            Channels.fireChannelBound((Channel) oioServerSocketChannel, (SocketAddress) oioServerSocketChannel.getLocalAddress());
            Executor executor = ((OioServerSocketChannelFactory) oioServerSocketChannel.getFactory()).bossExecutor;
            Boss boss = new Boss(oioServerSocketChannel);
            executor.execute(new IoWorkerRunnable(new ThreadRenamingRunnable(boss, "Old I/O server boss (" + oioServerSocketChannel + ')')));
        } catch (Throwable th) {
            if (z) {
                close(oioServerSocketChannel, channelFuture);
            }
            throw th;
        }
    }

    private void close(OioServerSocketChannel oioServerSocketChannel, ChannelFuture channelFuture) {
        boolean isBound = oioServerSocketChannel.isBound();
        try {
            oioServerSocketChannel.socket.close();
            oioServerSocketChannel.shutdownLock.lock();
            if (oioServerSocketChannel.setClosed()) {
                channelFuture.setSuccess();
                if (isBound) {
                    Channels.fireChannelUnbound((Channel) oioServerSocketChannel);
                }
                Channels.fireChannelClosed((Channel) oioServerSocketChannel);
            } else {
                channelFuture.setSuccess();
            }
            oioServerSocketChannel.shutdownLock.unlock();
        } catch (Throwable th) {
            channelFuture.setFailure(th);
            Channels.fireExceptionCaught((Channel) oioServerSocketChannel, th);
        }
    }

    private void handleAcceptedSocket(ChannelEvent channelEvent) {
        if (channelEvent instanceof ChannelStateEvent) {
            ChannelStateEvent channelStateEvent = (ChannelStateEvent) channelEvent;
            OioAcceptedSocketChannel oioAcceptedSocketChannel = (OioAcceptedSocketChannel) channelStateEvent.getChannel();
            ChannelFuture future = channelStateEvent.getFuture();
            ChannelState state = channelStateEvent.getState();
            Object value = channelStateEvent.getValue();
            int ordinal = state.ordinal();
            if (ordinal != 0) {
                if (ordinal == 1 || ordinal == 2) {
                    if (value == null) {
                        OioWorker.close(oioAcceptedSocketChannel, future);
                    }
                } else if (ordinal == 3) {
                    OioWorker.setInterestOps(oioAcceptedSocketChannel, future, ((Integer) value).intValue());
                }
            } else if (Boolean.FALSE.equals(value)) {
                OioWorker.close(oioAcceptedSocketChannel, future);
            }
        } else if (channelEvent instanceof MessageEvent) {
            MessageEvent messageEvent = (MessageEvent) channelEvent;
            OioWorker.write((OioSocketChannel) messageEvent.getChannel(), messageEvent.getFuture(), messageEvent.getMessage());
        }
    }

    private void handleServerSocket(ChannelEvent channelEvent) {
        if (channelEvent instanceof ChannelStateEvent) {
            ChannelStateEvent channelStateEvent = (ChannelStateEvent) channelEvent;
            OioServerSocketChannel oioServerSocketChannel = (OioServerSocketChannel) channelStateEvent.getChannel();
            ChannelFuture future = channelStateEvent.getFuture();
            ChannelState state = channelStateEvent.getState();
            Object value = channelStateEvent.getValue();
            int ordinal = state.ordinal();
            if (ordinal != 0) {
                if (ordinal == 1) {
                    if (value != null) {
                        bind(oioServerSocketChannel, future, (SocketAddress) value);
                    } else {
                        close(oioServerSocketChannel, future);
                    }
                }
            } else if (Boolean.FALSE.equals(value)) {
                close(oioServerSocketChannel, future);
            }
        }
    }

    public void eventSunk(ChannelPipeline channelPipeline, ChannelEvent channelEvent) throws Exception {
        Channel channel = channelEvent.getChannel();
        if (channel instanceof OioServerSocketChannel) {
            handleServerSocket(channelEvent);
        } else if (channel instanceof OioAcceptedSocketChannel) {
            handleAcceptedSocket(channelEvent);
        }
    }
}
