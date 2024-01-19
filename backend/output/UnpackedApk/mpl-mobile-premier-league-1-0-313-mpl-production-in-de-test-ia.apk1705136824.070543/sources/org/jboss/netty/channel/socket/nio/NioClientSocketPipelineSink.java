package org.jboss.netty.channel.socket.nio;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketAddress;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
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
import org.jboss.netty.logging.InternalLogger;
import org.jboss.netty.logging.InternalLoggerFactory;
import org.jboss.netty.util.ThreadRenamingRunnable;
import org.jboss.netty.util.internal.IoWorkerRunnable;
import org.jboss.netty.util.internal.LinkedTransferQueue;

public class NioClientSocketPipelineSink extends AbstractChannelSink {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final InternalLogger logger = InternalLoggerFactory.getInstance(NioClientSocketPipelineSink.class);
    public static final AtomicInteger nextId = new AtomicInteger();
    public final Boss boss = new Boss();
    public final Executor bossExecutor;
    public final int id = nextId.incrementAndGet();
    public final AtomicInteger workerIndex = new AtomicInteger();
    public final NioWorker[] workers;

    /* renamed from: org.jboss.netty.channel.socket.nio.NioClientSocketPipelineSink$2  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
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
            throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.channel.socket.nio.NioClientSocketPipelineSink.AnonymousClass2.<clinit>():void");
        }
    }

    public final class Boss implements Runnable {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        public final Queue<Runnable> registerTaskQueue = new LinkedTransferQueue();
        public volatile Selector selector;
        public final Object startStopLock = new Object();
        public boolean started;
        public final AtomicBoolean wakenUp = new AtomicBoolean();

        public Boss() {
        }

        private void close(SelectionKey selectionKey) {
            NioClientSocketChannel nioClientSocketChannel = (NioClientSocketChannel) selectionKey.attachment();
            nioClientSocketChannel.worker.close(nioClientSocketChannel, Channels.succeededFuture(nioClientSocketChannel));
        }

        private void connect(SelectionKey selectionKey) {
            NioClientSocketChannel nioClientSocketChannel = (NioClientSocketChannel) selectionKey.attachment();
            try {
                if (nioClientSocketChannel.socket.finishConnect()) {
                    selectionKey.cancel();
                    nioClientSocketChannel.worker.register(nioClientSocketChannel, nioClientSocketChannel.connectFuture);
                }
            } catch (Throwable th) {
                nioClientSocketChannel.connectFuture.setFailure(th);
                Channels.fireExceptionCaught((Channel) nioClientSocketChannel, th);
                nioClientSocketChannel.worker.close(nioClientSocketChannel, Channels.succeededFuture(nioClientSocketChannel));
            }
        }

        private void processConnectTimeout(Set<SelectionKey> set, long j) {
            ConnectException connectException = null;
            for (SelectionKey next : set) {
                if (next.isValid()) {
                    NioClientSocketChannel nioClientSocketChannel = (NioClientSocketChannel) next.attachment();
                    long j2 = nioClientSocketChannel.connectDeadlineNanos;
                    if (j2 > 0 && j >= j2) {
                        if (connectException == null) {
                            connectException = new ConnectException("connection timed out");
                        }
                        nioClientSocketChannel.connectFuture.setFailure(connectException);
                        Channels.fireExceptionCaught((Channel) nioClientSocketChannel, (Throwable) connectException);
                        nioClientSocketChannel.worker.close(nioClientSocketChannel, Channels.succeededFuture(nioClientSocketChannel));
                    }
                }
            }
        }

        private void processRegisterTaskQueue() {
            while (true) {
                Runnable poll = this.registerTaskQueue.poll();
                if (poll != null) {
                    poll.run();
                } else {
                    return;
                }
            }
        }

        private void processSelectedKeys(Set<SelectionKey> set) {
            Iterator<SelectionKey> it = set.iterator();
            while (it.hasNext()) {
                SelectionKey next = it.next();
                it.remove();
                if (!next.isValid()) {
                    close(next);
                } else if (next.isConnectable()) {
                    connect(next);
                }
            }
        }

        public void register(NioClientSocketChannel nioClientSocketChannel) {
            Selector selector2;
            RegisterTask registerTask = new RegisterTask(this, nioClientSocketChannel);
            synchronized (this.startStopLock) {
                if (!this.started) {
                    try {
                        selector2 = Selector.open();
                        this.selector = selector2;
                        Executor executor = NioClientSocketPipelineSink.this.bossExecutor;
                        executor.execute(new IoWorkerRunnable(new ThreadRenamingRunnable(this, "New I/O client boss #" + NioClientSocketPipelineSink.this.id)));
                    } catch (Throwable th) {
                        NioClientSocketPipelineSink.logger.warn("Failed to close a selector.", th);
                    }
                } else {
                    selector2 = this.selector;
                }
                this.started = true;
                this.registerTaskQueue.offer(registerTask);
            }
            if (this.wakenUp.compareAndSet(false, true)) {
                selector2.wakeup();
                return;
            }
            return;
            this.selector = null;
            throw th;
        }

        public void run() {
            Selector selector2 = this.selector;
            long nanoTime = System.nanoTime();
            while (true) {
                boolean z = false;
                while (true) {
                    this.wakenUp.set(false);
                    try {
                        int select = selector2.select(500);
                        if (this.wakenUp.get()) {
                            selector2.wakeup();
                        }
                        processRegisterTaskQueue();
                        if (select > 0) {
                            processSelectedKeys(selector2.selectedKeys());
                        }
                        long nanoTime2 = System.nanoTime();
                        if (nanoTime2 - nanoTime >= 500000000) {
                            try {
                                processConnectTimeout(selector2.keys(), nanoTime2);
                                nanoTime = nanoTime2;
                            } catch (Throwable th) {
                                long j = nanoTime2;
                                th = th;
                                nanoTime = j;
                                NioClientSocketPipelineSink.logger.warn("Unexpected exception in the selector loop.", th);
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException unused) {
                                }
                            }
                        }
                        if (!selector2.keys().isEmpty()) {
                            break;
                        }
                        if (!z) {
                            if (!(NioClientSocketPipelineSink.this.bossExecutor instanceof ExecutorService) || !((ExecutorService) NioClientSocketPipelineSink.this.bossExecutor).isShutdown()) {
                                z = true;
                            }
                        }
                        synchronized (this.startStopLock) {
                            if (!this.registerTaskQueue.isEmpty() || !selector2.keys().isEmpty()) {
                                try {
                                } catch (Throwable th2) {
                                    th = th2;
                                    z = false;
                                }
                            } else {
                                this.started = false;
                                try {
                                    selector2.close();
                                } catch (IOException e2) {
                                    NioClientSocketPipelineSink.logger.warn("Failed to close a selector.", e2);
                                }
                                try {
                                    this.selector = null;
                                    return;
                                } catch (Throwable th3) {
                                    th = th3;
                                }
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                    }
                }
            }
            throw th;
        }
    }

    public static final class RegisterTask implements Runnable {
        public final Boss boss;
        public final NioClientSocketChannel channel;

        public RegisterTask(Boss boss2, NioClientSocketChannel nioClientSocketChannel) {
            this.boss = boss2;
            this.channel = nioClientSocketChannel;
        }

        public void run() {
            try {
                this.channel.socket.register(this.boss.selector, 8, this.channel);
            } catch (ClosedChannelException unused) {
                NioClientSocketChannel nioClientSocketChannel = this.channel;
                nioClientSocketChannel.worker.close(nioClientSocketChannel, Channels.succeededFuture(nioClientSocketChannel));
            }
            int connectTimeoutMillis = this.channel.getConfig().getConnectTimeoutMillis();
            if (connectTimeoutMillis > 0) {
                this.channel.connectDeadlineNanos = (((long) connectTimeoutMillis) * 1000000) + System.nanoTime();
            }
        }
    }

    public NioClientSocketPipelineSink(Executor executor, Executor executor2, int i) {
        this.bossExecutor = executor;
        this.workers = new NioWorker[i];
        int i2 = 0;
        while (true) {
            NioWorker[] nioWorkerArr = this.workers;
            if (i2 < nioWorkerArr.length) {
                int i3 = i2 + 1;
                nioWorkerArr[i2] = new NioWorker(this.id, i3, executor2);
                i2 = i3;
            } else {
                return;
            }
        }
    }

    private void bind(NioClientSocketChannel nioClientSocketChannel, ChannelFuture channelFuture, SocketAddress socketAddress) {
        try {
            nioClientSocketChannel.socket.socket().bind(socketAddress);
            nioClientSocketChannel.boundManually = true;
            nioClientSocketChannel.setBound();
            channelFuture.setSuccess();
            Channels.fireChannelBound((Channel) nioClientSocketChannel, (SocketAddress) nioClientSocketChannel.getLocalAddress());
        } catch (Throwable th) {
            channelFuture.setFailure(th);
            Channels.fireExceptionCaught((Channel) nioClientSocketChannel, th);
        }
    }

    private void connect(NioClientSocketChannel nioClientSocketChannel, final ChannelFuture channelFuture, SocketAddress socketAddress) {
        try {
            if (nioClientSocketChannel.socket.connect(socketAddress)) {
                nioClientSocketChannel.worker.register(nioClientSocketChannel, channelFuture);
                return;
            }
            nioClientSocketChannel.getCloseFuture().addListener(new ChannelFutureListener() {
                public void operationComplete(ChannelFuture channelFuture) throws Exception {
                    if (!channelFuture.isDone()) {
                        channelFuture.setFailure(new ClosedChannelException());
                    }
                }
            });
            channelFuture.addListener(ChannelFutureListener.CLOSE_ON_FAILURE);
            nioClientSocketChannel.connectFuture = channelFuture;
            this.boss.register(nioClientSocketChannel);
        } catch (Throwable th) {
            channelFuture.setFailure(th);
            Channels.fireExceptionCaught((Channel) nioClientSocketChannel, th);
            nioClientSocketChannel.worker.close(nioClientSocketChannel, Channels.succeededFuture(nioClientSocketChannel));
        }
    }

    public void eventSunk(ChannelPipeline channelPipeline, ChannelEvent channelEvent) throws Exception {
        if (channelEvent instanceof ChannelStateEvent) {
            ChannelStateEvent channelStateEvent = (ChannelStateEvent) channelEvent;
            NioClientSocketChannel nioClientSocketChannel = (NioClientSocketChannel) channelStateEvent.getChannel();
            ChannelFuture future = channelStateEvent.getFuture();
            ChannelState state = channelStateEvent.getState();
            Object value = channelStateEvent.getValue();
            int ordinal = state.ordinal();
            if (ordinal != 0) {
                if (ordinal != 1) {
                    if (ordinal != 2) {
                        if (ordinal == 3) {
                            nioClientSocketChannel.worker.setInterestOps(nioClientSocketChannel, future, ((Integer) value).intValue());
                        }
                    } else if (value != null) {
                        connect(nioClientSocketChannel, future, (SocketAddress) value);
                    } else {
                        nioClientSocketChannel.worker.close(nioClientSocketChannel, future);
                    }
                } else if (value != null) {
                    bind(nioClientSocketChannel, future, (SocketAddress) value);
                } else {
                    nioClientSocketChannel.worker.close(nioClientSocketChannel, future);
                }
            } else if (Boolean.FALSE.equals(value)) {
                nioClientSocketChannel.worker.close(nioClientSocketChannel, future);
            }
        } else if (channelEvent instanceof MessageEvent) {
            MessageEvent messageEvent = (MessageEvent) channelEvent;
            NioSocketChannel nioSocketChannel = (NioSocketChannel) messageEvent.getChannel();
            nioSocketChannel.writeBuffer.offer(messageEvent);
            nioSocketChannel.worker.writeFromUserCode(nioSocketChannel);
        }
    }

    public NioWorker nextWorker() {
        return this.workers[Math.abs(this.workerIndex.getAndIncrement() % this.workers.length)];
    }
}
