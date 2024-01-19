package org.jboss.netty.channel.socket.nio;

import java.io.IOException;
import java.net.SocketAddress;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
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

public class NioServerSocketPipelineSink extends AbstractChannelSink {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final InternalLogger logger = InternalLoggerFactory.getInstance(NioServerSocketPipelineSink.class);
    public static final AtomicInteger nextId = new AtomicInteger();
    public final int id = nextId.incrementAndGet();
    public final AtomicInteger workerIndex = new AtomicInteger();
    public final NioWorker[] workers;

    /* renamed from: org.jboss.netty.channel.socket.nio.NioServerSocketPipelineSink$1  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.channel.socket.nio.NioServerSocketPipelineSink.AnonymousClass1.<clinit>():void");
        }
    }

    public final class Boss implements Runnable {
        public final NioServerSocketChannel channel;
        public final Selector selector;

        public Boss(NioServerSocketChannel nioServerSocketChannel) throws IOException {
            this.channel = nioServerSocketChannel;
            Selector open = Selector.open();
            this.selector = open;
            try {
                nioServerSocketChannel.socket.register(open, 16);
                nioServerSocketChannel.selector = this.selector;
            } catch (Throwable th) {
                closeSelector();
                throw th;
            }
        }

        private void closeSelector() {
            this.channel.selector = null;
            try {
                this.selector.close();
            } catch (Exception e2) {
                NioServerSocketPipelineSink.logger.warn("Failed to close a selector.", e2);
            }
        }

        private void registerAcceptedChannel(SocketChannel socketChannel, Thread thread) {
            try {
                ChannelPipeline pipeline = this.channel.getConfig().getPipelineFactory().getPipeline();
                NioWorker nextWorker = NioServerSocketPipelineSink.this.nextWorker();
                NioAcceptedSocketChannel nioAcceptedSocketChannel = new NioAcceptedSocketChannel(this.channel.getFactory(), pipeline, this.channel, NioServerSocketPipelineSink.this, socketChannel, nextWorker, thread);
                nextWorker.register(nioAcceptedSocketChannel, null);
            } catch (Exception e2) {
                NioServerSocketPipelineSink.logger.warn("Failed to initialize an accepted socket.", e2);
                try {
                    socketChannel.close();
                } catch (IOException e3) {
                    NioServerSocketPipelineSink.logger.warn("Failed to close a partially accepted socket.", e3);
                }
            }
        }

        public void run() {
            Thread currentThread = Thread.currentThread();
            this.channel.shutdownLock.lock();
            while (true) {
                try {
                    if (this.selector.select(1000) > 0) {
                        this.selector.selectedKeys().clear();
                    }
                    SocketChannel accept = this.channel.socket.accept();
                    if (accept != null) {
                        registerAcceptedChannel(accept, currentThread);
                    }
                } catch (ClosedChannelException unused) {
                    this.channel.shutdownLock.unlock();
                    closeSelector();
                    return;
                } catch (Throwable th) {
                    this.channel.shutdownLock.unlock();
                    closeSelector();
                    throw th;
                }
            }
        }
    }

    public NioServerSocketPipelineSink(Executor executor, int i) {
        this.workers = new NioWorker[i];
        int i2 = 0;
        while (true) {
            NioWorker[] nioWorkerArr = this.workers;
            if (i2 < nioWorkerArr.length) {
                int i3 = i2 + 1;
                nioWorkerArr[i2] = new NioWorker(this.id, i3, executor);
                i2 = i3;
            } else {
                return;
            }
        }
    }

    private void bind(NioServerSocketChannel nioServerSocketChannel, ChannelFuture channelFuture, SocketAddress socketAddress) {
        boolean z = false;
        try {
            nioServerSocketChannel.socket.socket().bind(socketAddress, nioServerSocketChannel.getConfig().getBacklog());
            z = true;
            channelFuture.setSuccess();
            Channels.fireChannelBound((Channel) nioServerSocketChannel, (SocketAddress) nioServerSocketChannel.getLocalAddress());
            Executor executor = ((NioServerSocketChannelFactory) nioServerSocketChannel.getFactory()).bossExecutor;
            Boss boss = new Boss(nioServerSocketChannel);
            executor.execute(new IoWorkerRunnable(new ThreadRenamingRunnable(boss, "New I/O server boss #" + this.id + " (" + nioServerSocketChannel + ')')));
        } catch (Throwable th) {
            if (z) {
                close(nioServerSocketChannel, channelFuture);
            }
            throw th;
        }
    }

    private void close(NioServerSocketChannel nioServerSocketChannel, ChannelFuture channelFuture) {
        boolean isBound = nioServerSocketChannel.isBound();
        try {
            if (nioServerSocketChannel.socket.isOpen()) {
                nioServerSocketChannel.socket.close();
                Selector selector = nioServerSocketChannel.selector;
                if (selector != null) {
                    selector.wakeup();
                }
            }
            nioServerSocketChannel.shutdownLock.lock();
            if (nioServerSocketChannel.setClosed()) {
                channelFuture.setSuccess();
                if (isBound) {
                    Channels.fireChannelUnbound((Channel) nioServerSocketChannel);
                }
                Channels.fireChannelClosed((Channel) nioServerSocketChannel);
            } else {
                channelFuture.setSuccess();
            }
            nioServerSocketChannel.shutdownLock.unlock();
        } catch (Throwable th) {
            channelFuture.setFailure(th);
            Channels.fireExceptionCaught((Channel) nioServerSocketChannel, th);
        }
    }

    private void handleAcceptedSocket(ChannelEvent channelEvent) {
        if (channelEvent instanceof ChannelStateEvent) {
            ChannelStateEvent channelStateEvent = (ChannelStateEvent) channelEvent;
            NioSocketChannel nioSocketChannel = (NioSocketChannel) channelStateEvent.getChannel();
            ChannelFuture future = channelStateEvent.getFuture();
            ChannelState state = channelStateEvent.getState();
            Object value = channelStateEvent.getValue();
            int ordinal = state.ordinal();
            if (ordinal != 0) {
                if (ordinal == 1 || ordinal == 2) {
                    if (value == null) {
                        nioSocketChannel.worker.close(nioSocketChannel, future);
                    }
                } else if (ordinal == 3) {
                    nioSocketChannel.worker.setInterestOps(nioSocketChannel, future, ((Integer) value).intValue());
                }
            } else if (Boolean.FALSE.equals(value)) {
                nioSocketChannel.worker.close(nioSocketChannel, future);
            }
        } else if (channelEvent instanceof MessageEvent) {
            MessageEvent messageEvent = (MessageEvent) channelEvent;
            NioSocketChannel nioSocketChannel2 = (NioSocketChannel) messageEvent.getChannel();
            nioSocketChannel2.writeBuffer.offer(messageEvent);
            nioSocketChannel2.worker.writeFromUserCode(nioSocketChannel2);
        }
    }

    private void handleServerSocket(ChannelEvent channelEvent) {
        if (channelEvent instanceof ChannelStateEvent) {
            ChannelStateEvent channelStateEvent = (ChannelStateEvent) channelEvent;
            NioServerSocketChannel nioServerSocketChannel = (NioServerSocketChannel) channelStateEvent.getChannel();
            ChannelFuture future = channelStateEvent.getFuture();
            ChannelState state = channelStateEvent.getState();
            Object value = channelStateEvent.getValue();
            int ordinal = state.ordinal();
            if (ordinal != 0) {
                if (ordinal == 1) {
                    if (value != null) {
                        bind(nioServerSocketChannel, future, (SocketAddress) value);
                    } else {
                        close(nioServerSocketChannel, future);
                    }
                }
            } else if (Boolean.FALSE.equals(value)) {
                close(nioServerSocketChannel, future);
            }
        }
    }

    public void eventSunk(ChannelPipeline channelPipeline, ChannelEvent channelEvent) throws Exception {
        Channel channel = channelEvent.getChannel();
        if (channel instanceof NioServerSocketChannel) {
            handleServerSocket(channelEvent);
        } else if (channel instanceof NioSocketChannel) {
            handleAcceptedSocket(channelEvent);
        }
    }

    public NioWorker nextWorker() {
        return this.workers[Math.abs(this.workerIndex.getAndIncrement() % this.workers.length)];
    }
}
