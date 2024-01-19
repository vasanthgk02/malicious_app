package org.jboss.netty.channel.socket.nio;

import java.io.IOException;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.NotYetConnectedException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelException;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.logging.InternalLogger;
import org.jboss.netty.logging.InternalLoggerFactory;
import org.jboss.netty.util.ThreadRenamingRunnable;
import org.jboss.netty.util.internal.LinkedTransferQueue;

public class NioDatagramWorker implements Runnable {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final InternalLogger logger = InternalLoggerFactory.getInstance(NioDatagramWorker.class);
    public final int bossId;
    public volatile int cancelledKeys;
    public final Executor executor;
    public final int id;
    public final Queue<Runnable> registerTaskQueue = new LinkedTransferQueue();
    public volatile Selector selector;
    public final ReadWriteLock selectorGuard = new ReentrantReadWriteLock();
    public final SocketSendBufferPool sendBufferPool = new SocketSendBufferPool();
    public final Object startStopLock = new Object();
    public boolean started;
    public volatile Thread thread;
    public final AtomicBoolean wakenUp = new AtomicBoolean();
    public final Queue<Runnable> writeTaskQueue = new LinkedTransferQueue();

    public final class ChannelRegistionTask implements Runnable {
        public final NioDatagramChannel channel;
        public final ChannelFuture future;

        public ChannelRegistionTask(NioDatagramChannel nioDatagramChannel, ChannelFuture channelFuture) {
            this.channel = nioDatagramChannel;
            this.future = channelFuture;
        }

        public void run() {
            if (this.channel.getLocalAddress() == null) {
                ChannelFuture channelFuture = this.future;
                if (channelFuture != null) {
                    channelFuture.setFailure(new ClosedChannelException());
                }
                NioDatagramWorker nioDatagramWorker = NioDatagramWorker.this;
                NioDatagramChannel nioDatagramChannel = this.channel;
                nioDatagramWorker.close(nioDatagramChannel, Channels.succeededFuture(nioDatagramChannel));
                return;
            }
            try {
                synchronized (this.channel.interestOpsLock) {
                    this.channel.getDatagramChannel().register(NioDatagramWorker.this.selector, this.channel.getRawInterestOps(), this.channel);
                }
                if (this.future != null) {
                    this.future.setSuccess();
                }
            } catch (ClosedChannelException e2) {
                ChannelFuture channelFuture2 = this.future;
                if (channelFuture2 != null) {
                    channelFuture2.setFailure(e2);
                }
                NioDatagramWorker nioDatagramWorker2 = NioDatagramWorker.this;
                NioDatagramChannel nioDatagramChannel2 = this.channel;
                nioDatagramWorker2.close(nioDatagramChannel2, Channels.succeededFuture(nioDatagramChannel2));
                throw new ChannelException("Failed to register a socket to the selector.", e2);
            }
        }
    }

    static {
        Class<NioDatagramWorker> cls = NioDatagramWorker.class;
    }

    public NioDatagramWorker(int i, int i2, Executor executor2) {
        this.bossId = i;
        this.id = i2;
        this.executor = executor2;
    }

    private boolean cleanUpCancelledKeys() throws IOException {
        if (this.cancelledKeys < 256) {
            return false;
        }
        this.cancelledKeys = 0;
        this.selector.selectNow();
        return true;
    }

    private void cleanUpWriteBuffer(NioDatagramChannel nioDatagramChannel) {
        Throwable th;
        boolean z;
        Throwable th2;
        synchronized (nioDatagramChannel.writeLock) {
            MessageEvent messageEvent = nioDatagramChannel.currentWriteEvent;
            th = null;
            if (messageEvent != null) {
                if (nioDatagramChannel.isOpen()) {
                    th2 = new NotYetConnectedException();
                } else {
                    th2 = new ClosedChannelException();
                }
                ChannelFuture future = messageEvent.getFuture();
                nioDatagramChannel.currentWriteBuffer.release();
                nioDatagramChannel.currentWriteBuffer = null;
                nioDatagramChannel.currentWriteEvent = null;
                future.setFailure(th2);
                th = th2;
                z = true;
            } else {
                z = false;
            }
            Queue<MessageEvent> queue = nioDatagramChannel.writeBufferQueue;
            if (!queue.isEmpty()) {
                if (th == null) {
                    if (nioDatagramChannel.isOpen()) {
                        th = new NotYetConnectedException();
                    } else {
                        th = new ClosedChannelException();
                    }
                }
                while (true) {
                    MessageEvent poll = queue.poll();
                    if (poll == null) {
                        break;
                    }
                    poll.getFuture().setFailure(th);
                    z = true;
                }
            }
        }
        if (z) {
            Channels.fireExceptionCaught((Channel) nioDatagramChannel, th);
        }
    }

    private void clearOpWrite(NioDatagramChannel nioDatagramChannel) {
        int rawInterestOps;
        SelectionKey keyFor = nioDatagramChannel.getDatagramChannel().keyFor(this.selector);
        if (keyFor != null) {
            if (!keyFor.isValid()) {
                close(keyFor);
                return;
            }
            boolean z = false;
            synchronized (nioDatagramChannel.interestOpsLock) {
                rawInterestOps = nioDatagramChannel.getRawInterestOps();
                if ((rawInterestOps & 4) != 0) {
                    rawInterestOps &= -5;
                    keyFor.interestOps(rawInterestOps);
                    z = true;
                }
            }
            if (z) {
                nioDatagramChannel.setRawInterestOpsNow(rawInterestOps);
            }
        }
    }

    private void close(SelectionKey selectionKey) {
        NioDatagramChannel nioDatagramChannel = (NioDatagramChannel) selectionKey.attachment();
        close(nioDatagramChannel, Channels.succeededFuture(nioDatagramChannel));
    }

    public static void disconnect(NioDatagramChannel nioDatagramChannel, ChannelFuture channelFuture) {
        boolean isConnected = nioDatagramChannel.isConnected();
        try {
            nioDatagramChannel.getDatagramChannel().disconnect();
            channelFuture.setSuccess();
            if (isConnected) {
                Channels.fireChannelDisconnected((Channel) nioDatagramChannel);
            }
        } catch (Throwable th) {
            channelFuture.setFailure(th);
            Channels.fireExceptionCaught((Channel) nioDatagramChannel, th);
        }
    }

    private void processRegisterTaskQueue() throws IOException {
        while (true) {
            Runnable poll = this.registerTaskQueue.poll();
            if (poll != null) {
                poll.run();
                cleanUpCancelledKeys();
            } else {
                return;
            }
        }
    }

    private void processSelectedKeys(Set<SelectionKey> set) throws IOException {
        Iterator<SelectionKey> it = set.iterator();
        while (it.hasNext()) {
            SelectionKey next = it.next();
            it.remove();
            try {
                int readyOps = next.readyOps();
                if (((readyOps & 1) == 0 && readyOps != 0) || read(next)) {
                    if ((readyOps & 4) != 0) {
                        writeFromSelectorLoop(next);
                    }
                    if (cleanUpCancelledKeys()) {
                        return;
                    }
                }
            } catch (CancelledKeyException unused) {
                close(next);
            }
        }
    }

    private void processWriteTaskQueue() throws IOException {
        while (true) {
            Runnable poll = this.writeTaskQueue.poll();
            if (poll != null) {
                poll.run();
                cleanUpCancelledKeys();
            } else {
                return;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0059 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x003c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean read(java.nio.channels.SelectionKey r9) {
        /*
            r8 = this;
            java.lang.Object r0 = r9.attachment()
            org.jboss.netty.channel.socket.nio.NioDatagramChannel r0 = (org.jboss.netty.channel.socket.nio.NioDatagramChannel) r0
            org.jboss.netty.channel.socket.nio.NioDatagramChannelConfig r1 = r0.getConfig()
            org.jboss.netty.channel.ReceiveBufferSizePredictor r1 = r1.getReceiveBufferSizePredictor()
            org.jboss.netty.channel.socket.nio.NioDatagramChannelConfig r2 = r0.getConfig()
            org.jboss.netty.buffer.ChannelBufferFactory r2 = r2.getBufferFactory()
            java.nio.channels.SelectableChannel r9 = r9.channel()
            java.nio.channels.DatagramChannel r9 = (java.nio.channels.DatagramChannel) r9
            int r3 = r1.nextReceiveBufferSize()
            java.nio.ByteBuffer r3 = java.nio.ByteBuffer.allocate(r3)
            java.nio.ByteOrder r4 = r2.getDefaultOrder()
            java.nio.ByteBuffer r3 = r3.order(r4)
            r4 = 0
            r5 = 1
            java.net.SocketAddress r9 = r9.receive(r3)     // Catch:{ ClosedChannelException -> 0x0038, all -> 0x0034 }
            r6 = 0
            goto L_0x003a
        L_0x0034:
            r9 = move-exception
            org.jboss.netty.channel.Channels.fireExceptionCaught(r0, r9)
        L_0x0038:
            r9 = 0
            r6 = 1
        L_0x003a:
            if (r9 == 0) goto L_0x004f
            r3.flip()
            int r7 = r3.remaining()
            if (r7 <= 0) goto L_0x004f
            r1.previousReceiveBufferSize(r7)
            org.jboss.netty.buffer.ChannelBuffer r1 = r2.getBuffer(r3)
            org.jboss.netty.channel.Channels.fireMessageReceived(r0, r1, r9)
        L_0x004f:
            if (r6 == 0) goto L_0x0059
            org.jboss.netty.channel.ChannelFuture r9 = org.jboss.netty.channel.Channels.succeededFuture(r0)
            r8.close(r0, r9)
            return r4
        L_0x0059:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.channel.socket.nio.NioDatagramWorker.read(java.nio.channels.SelectionKey):boolean");
    }

    private boolean scheduleWriteIfNecessary(NioDatagramChannel nioDatagramChannel) {
        Thread thread2 = this.thread;
        if (thread2 != null && Thread.currentThread() == thread2) {
            return false;
        }
        if (nioDatagramChannel.writeTaskInTaskQueue.compareAndSet(false, true)) {
            this.writeTaskQueue.offer(nioDatagramChannel.writeTask);
        }
        Selector selector2 = this.selector;
        if (selector2 != null && this.wakenUp.compareAndSet(false, true)) {
            selector2.wakeup();
        }
        return true;
    }

    private void setOpWrite(NioDatagramChannel nioDatagramChannel) {
        int rawInterestOps;
        SelectionKey keyFor = nioDatagramChannel.getDatagramChannel().keyFor(this.selector);
        if (keyFor != null) {
            if (!keyFor.isValid()) {
                close(keyFor);
                return;
            }
            boolean z = false;
            synchronized (nioDatagramChannel.interestOpsLock) {
                rawInterestOps = nioDatagramChannel.getRawInterestOps();
                if ((rawInterestOps & 4) == 0) {
                    rawInterestOps |= 4;
                    keyFor.interestOps(rawInterestOps);
                    z = true;
                }
            }
            if (z) {
                nioDatagramChannel.setRawInterestOpsNow(rawInterestOps);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00ba, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00bb, code lost:
        r9 = null;
        r15 = null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:69:? A[ExcHandler: AsynchronousCloseException (unused java.nio.channels.AsynchronousCloseException), SYNTHETIC, Splitter:B:55:0x00ab] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void write0(org.jboss.netty.channel.socket.nio.NioDatagramChannel r22) {
        /*
            r21 = this;
            r1 = r21
            r2 = r22
            org.jboss.netty.channel.socket.nio.SocketSendBufferPool r3 = r1.sendBufferPool
            java.nio.channels.DatagramChannel r4 = r22.getDatagramChannel()
            java.util.Queue<org.jboss.netty.channel.MessageEvent> r5 = r2.writeBufferQueue
            org.jboss.netty.channel.socket.nio.NioDatagramChannelConfig r0 = r22.getConfig()
            int r6 = r0.getWriteSpinCount()
            java.lang.Object r7 = r2.writeLock
            monitor-enter(r7)
            r8 = 1
            r2.inWriteNowLoop = r8     // Catch:{ all -> 0x00dd }
            r9 = 0
            r10 = 0
            r13 = r10
            r12 = 0
        L_0x001f:
            org.jboss.netty.channel.MessageEvent r0 = r2.currentWriteEvent     // Catch:{ all -> 0x00dd }
            if (r0 != 0) goto L_0x0040
            java.lang.Object r0 = r5.poll()     // Catch:{ all -> 0x00dd }
            org.jboss.netty.channel.MessageEvent r0 = (org.jboss.netty.channel.MessageEvent) r0     // Catch:{ all -> 0x00dd }
            r2.currentWriteEvent = r0     // Catch:{ all -> 0x00dd }
            if (r0 != 0) goto L_0x0035
            r2.writeSuspended = r9     // Catch:{ all -> 0x00dd }
            r8 = r12
            r11 = 0
            r16 = 1
            goto L_0x0090
        L_0x0035:
            java.lang.Object r15 = r0.getMessage()     // Catch:{ all -> 0x00dd }
            org.jboss.netty.channel.socket.nio.SocketSendBufferPool$SendBuffer r15 = r3.acquire(r15)     // Catch:{ all -> 0x00dd }
            r2.currentWriteBuffer = r15     // Catch:{ all -> 0x00dd }
            goto L_0x0042
        L_0x0040:
            org.jboss.netty.channel.socket.nio.SocketSendBufferPool$SendBuffer r15 = r2.currentWriteBuffer     // Catch:{ all -> 0x00dd }
        L_0x0042:
            r9 = r15
            r15 = r0
            r8 = 0
            java.net.SocketAddress r0 = r15.getRemoteAddress()     // Catch:{ AsynchronousCloseException -> 0x00d5, all -> 0x00c0 }
            if (r0 != 0) goto L_0x0063
            r0 = r6
            r17 = r10
        L_0x004e:
            if (r0 <= 0) goto L_0x007e
            long r17 = r9.transferTo(r4)     // Catch:{ AsynchronousCloseException -> 0x00d5, all -> 0x00c0 }
            int r19 = (r17 > r10 ? 1 : (r17 == r10 ? 0 : -1))
            if (r19 == 0) goto L_0x0059
            goto L_0x0071
        L_0x0059:
            boolean r19 = r9.finished()     // Catch:{ AsynchronousCloseException -> 0x00d5, all -> 0x00c0 }
            if (r19 == 0) goto L_0x0060
            goto L_0x007e
        L_0x0060:
            int r0 = r0 + -1
            goto L_0x004e
        L_0x0063:
            r19 = r6
            r17 = r10
        L_0x0067:
            if (r19 <= 0) goto L_0x007e
            long r17 = r9.transferTo(r4, r0)     // Catch:{ AsynchronousCloseException -> 0x00d5, all -> 0x00c0 }
            int r20 = (r17 > r10 ? 1 : (r17 == r10 ? 0 : -1))
            if (r20 == 0) goto L_0x0074
        L_0x0071:
            long r13 = r13 + r17
            goto L_0x007e
        L_0x0074:
            boolean r20 = r9.finished()     // Catch:{ AsynchronousCloseException -> 0x00d5, all -> 0x00c0 }
            if (r20 == 0) goto L_0x007b
            goto L_0x007e
        L_0x007b:
            int r19 = r19 + -1
            goto L_0x0067
        L_0x007e:
            int r0 = (r17 > r10 ? 1 : (r17 == r10 ? 0 : -1))
            if (r0 > 0) goto L_0x00a9
            boolean r0 = r9.finished()     // Catch:{ AsynchronousCloseException -> 0x00d5, all -> 0x00c0 }
            if (r0 == 0) goto L_0x0089
            goto L_0x00a9
        L_0x0089:
            r10 = 1
            r2.writeSuspended = r10     // Catch:{ AsynchronousCloseException -> 0x00a6, all -> 0x00a2 }
            r8 = 1
            r11 = 0
            r16 = 0
        L_0x0090:
            r2.inWriteNowLoop = r11     // Catch:{ all -> 0x00dd }
            monitor-exit(r7)     // Catch:{ all -> 0x00dd }
            org.jboss.netty.channel.Channels.fireWriteComplete(r2, r13)
            if (r8 == 0) goto L_0x009c
            r21.setOpWrite(r22)
            goto L_0x00a1
        L_0x009c:
            if (r16 == 0) goto L_0x00a1
            r21.clearOpWrite(r22)
        L_0x00a1:
            return
        L_0x00a2:
            r0 = move-exception
            r11 = 0
            r12 = 1
            goto L_0x00c3
        L_0x00a6:
            r11 = 0
            r12 = 1
            goto L_0x00d7
        L_0x00a9:
            r10 = 1
            r11 = 0
            r9.release()     // Catch:{ AsynchronousCloseException -> 0x00d7, all -> 0x00be }
            org.jboss.netty.channel.ChannelFuture r0 = r15.getFuture()     // Catch:{ AsynchronousCloseException -> 0x00d7, all -> 0x00be }
            r2.currentWriteEvent = r8     // Catch:{ AsynchronousCloseException -> 0x00d7, all -> 0x00be }
            r2.currentWriteBuffer = r8     // Catch:{ AsynchronousCloseException -> 0x00d7, all -> 0x00be }
            r0.setSuccess()     // Catch:{ AsynchronousCloseException -> 0x00d7, all -> 0x00ba }
            goto L_0x00d7
        L_0x00ba:
            r0 = move-exception
            r9 = r8
            r15 = r9
            goto L_0x00c3
        L_0x00be:
            r0 = move-exception
            goto L_0x00c3
        L_0x00c0:
            r0 = move-exception
            r10 = 1
            r11 = 0
        L_0x00c3:
            r9.release()     // Catch:{ all -> 0x00dd }
            org.jboss.netty.channel.ChannelFuture r9 = r15.getFuture()     // Catch:{ all -> 0x00dd }
            r2.currentWriteEvent = r8     // Catch:{ all -> 0x00dd }
            r2.currentWriteBuffer = r8     // Catch:{ all -> 0x00dd }
            r9.setFailure(r0)     // Catch:{ all -> 0x00dd }
            org.jboss.netty.channel.Channels.fireExceptionCaught(r2, r0)     // Catch:{ all -> 0x00dd }
            goto L_0x00d7
        L_0x00d5:
            r10 = 1
            r11 = 0
        L_0x00d7:
            r8 = 1
            r9 = 0
            r10 = 0
            goto L_0x001f
        L_0x00dd:
            r0 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x00dd }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.channel.socket.nio.NioDatagramWorker.write0(org.jboss.netty.channel.socket.nio.NioDatagramChannel):void");
    }

    public void register(NioDatagramChannel nioDatagramChannel, ChannelFuture channelFuture) {
        Selector selector2;
        ChannelRegistionTask channelRegistionTask = new ChannelRegistionTask(nioDatagramChannel, channelFuture);
        synchronized (this.startStopLock) {
            if (!this.started) {
                try {
                    selector2 = Selector.open();
                    this.selector = selector2;
                    Executor executor2 = this.executor;
                    executor2.execute(new ThreadRenamingRunnable(this, "New I/O datagram worker #" + this.bossId + "'-'" + this.id));
                } catch (Throwable th) {
                    logger.warn("Failed to close a selector.", th);
                }
            } else {
                selector2 = this.selector;
            }
            this.started = true;
            this.registerTaskQueue.offer(channelRegistionTask);
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
        this.thread = Thread.currentThread();
        Selector selector2 = this.selector;
        while (true) {
            boolean z = false;
            while (true) {
                this.wakenUp.set(false);
                if (NioProviderMetadata.CONSTRAINT_LEVEL != 0) {
                    this.selectorGuard.writeLock().lock();
                    this.selectorGuard.writeLock().unlock();
                }
                try {
                    SelectorUtil.select(selector2);
                    if (this.wakenUp.get()) {
                        selector2.wakeup();
                    }
                    this.cancelledKeys = 0;
                    processRegisterTaskQueue();
                    processWriteTaskQueue();
                    processSelectedKeys(selector2.selectedKeys());
                    if (!selector2.keys().isEmpty()) {
                        break;
                    }
                    if (!z) {
                        if (!(this.executor instanceof ExecutorService) || !((ExecutorService) this.executor).isShutdown()) {
                            z = true;
                        }
                    }
                    synchronized (this.startStopLock) {
                        if (!this.registerTaskQueue.isEmpty() || !selector2.keys().isEmpty()) {
                            try {
                            } catch (Throwable th) {
                                th = th;
                                z = false;
                            }
                        } else {
                            this.started = false;
                            try {
                                selector2.close();
                            } catch (IOException e2) {
                                try {
                                    logger.warn("Failed to close a selector.", e2);
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                            }
                            this.selector = null;
                            return;
                        }
                    }
                } catch (Throwable th3) {
                    logger.warn("Unexpected exception in the selector loop.", th3);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }
        throw th;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        r9.setSuccess();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x008d, code lost:
        if (r4 == false) goto L_0x00b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x008f, code lost:
        r8.setRawInterestOpsNow(r10);
        org.jboss.netty.channel.Channels.fireChannelInterestChanged((org.jboss.netty.channel.Channel) r8);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setInterestOps(org.jboss.netty.channel.socket.nio.NioDatagramChannel r8, org.jboss.netty.channel.ChannelFuture r9, int r10) {
        /*
            r7 = this;
            java.lang.Object r0 = r8.interestOpsLock     // Catch:{ CancelledKeyException -> 0x00a6, all -> 0x009e }
            monitor-enter(r0)     // Catch:{ CancelledKeyException -> 0x00a6, all -> 0x009e }
            java.nio.channels.Selector r1 = r7.selector     // Catch:{ all -> 0x009b }
            java.nio.channels.DatagramChannel r2 = r8.getDatagramChannel()     // Catch:{ all -> 0x009b }
            java.nio.channels.SelectionKey r2 = r2.keyFor(r1)     // Catch:{ all -> 0x009b }
            if (r2 == 0) goto L_0x0096
            if (r1 != 0) goto L_0x0013
            goto L_0x0096
        L_0x0013:
            r10 = r10 & -5
            int r3 = r8.getRawInterestOps()     // Catch:{ all -> 0x009b }
            r3 = r3 & 4
            r10 = r10 | r3
            int r3 = org.jboss.netty.channel.socket.nio.NioProviderMetadata.CONSTRAINT_LEVEL     // Catch:{ all -> 0x009b }
            r4 = 0
            r5 = 1
            if (r3 == 0) goto L_0x006c
            if (r3 == r5) goto L_0x002e
            r6 = 2
            if (r3 != r6) goto L_0x0028
            goto L_0x002e
        L_0x0028:
            java.lang.Error r10 = new java.lang.Error     // Catch:{ all -> 0x009b }
            r10.<init>()     // Catch:{ all -> 0x009b }
            throw r10     // Catch:{ all -> 0x009b }
        L_0x002e:
            int r3 = r8.getRawInterestOps()     // Catch:{ all -> 0x009b }
            if (r3 == r10) goto L_0x0089
            java.lang.Thread r3 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x009b }
            java.lang.Thread r6 = r7.thread     // Catch:{ all -> 0x009b }
            if (r3 != r6) goto L_0x0040
            r2.interestOps(r10)     // Catch:{ all -> 0x009b }
            goto L_0x0088
        L_0x0040:
            java.util.concurrent.locks.ReadWriteLock r3 = r7.selectorGuard     // Catch:{ all -> 0x009b }
            java.util.concurrent.locks.Lock r3 = r3.readLock()     // Catch:{ all -> 0x009b }
            r3.lock()     // Catch:{ all -> 0x009b }
            java.util.concurrent.atomic.AtomicBoolean r3 = r7.wakenUp     // Catch:{ all -> 0x0061 }
            boolean r3 = r3.compareAndSet(r4, r5)     // Catch:{ all -> 0x0061 }
            if (r3 == 0) goto L_0x0054
            r1.wakeup()     // Catch:{ all -> 0x0061 }
        L_0x0054:
            r2.interestOps(r10)     // Catch:{ all -> 0x0061 }
            java.util.concurrent.locks.ReadWriteLock r1 = r7.selectorGuard     // Catch:{ all -> 0x009b }
            java.util.concurrent.locks.Lock r1 = r1.readLock()     // Catch:{ all -> 0x009b }
            r1.unlock()     // Catch:{ all -> 0x009b }
            goto L_0x0088
        L_0x0061:
            r10 = move-exception
            java.util.concurrent.locks.ReadWriteLock r1 = r7.selectorGuard     // Catch:{ all -> 0x009b }
            java.util.concurrent.locks.Lock r1 = r1.readLock()     // Catch:{ all -> 0x009b }
            r1.unlock()     // Catch:{ all -> 0x009b }
            throw r10     // Catch:{ all -> 0x009b }
        L_0x006c:
            int r3 = r8.getRawInterestOps()     // Catch:{ all -> 0x009b }
            if (r3 == r10) goto L_0x0089
            r2.interestOps(r10)     // Catch:{ all -> 0x009b }
            java.lang.Thread r2 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x009b }
            java.lang.Thread r3 = r7.thread     // Catch:{ all -> 0x009b }
            if (r2 == r3) goto L_0x0088
            java.util.concurrent.atomic.AtomicBoolean r2 = r7.wakenUp     // Catch:{ all -> 0x009b }
            boolean r2 = r2.compareAndSet(r4, r5)     // Catch:{ all -> 0x009b }
            if (r2 == 0) goto L_0x0088
            r1.wakeup()     // Catch:{ all -> 0x009b }
        L_0x0088:
            r4 = 1
        L_0x0089:
            monitor-exit(r0)     // Catch:{ all -> 0x009b }
            r9.setSuccess()     // Catch:{ CancelledKeyException -> 0x00a6, all -> 0x009e }
            if (r4 == 0) goto L_0x00b1
            r8.setRawInterestOpsNow(r10)     // Catch:{ CancelledKeyException -> 0x00a6, all -> 0x009e }
            org.jboss.netty.channel.Channels.fireChannelInterestChanged(r8)     // Catch:{ CancelledKeyException -> 0x00a6, all -> 0x009e }
            goto L_0x00b1
        L_0x0096:
            r8.setRawInterestOpsNow(r10)     // Catch:{ all -> 0x009b }
            monitor-exit(r0)     // Catch:{ all -> 0x009b }
            return
        L_0x009b:
            r10 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x009b }
            throw r10     // Catch:{ CancelledKeyException -> 0x00a6, all -> 0x009e }
        L_0x009e:
            r10 = move-exception
            r9.setFailure(r10)
            org.jboss.netty.channel.Channels.fireExceptionCaught(r8, r10)
            goto L_0x00b1
        L_0x00a6:
            java.nio.channels.ClosedChannelException r10 = new java.nio.channels.ClosedChannelException
            r10.<init>()
            r9.setFailure(r10)
            org.jboss.netty.channel.Channels.fireExceptionCaught(r8, r10)
        L_0x00b1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.channel.socket.nio.NioDatagramWorker.setInterestOps(org.jboss.netty.channel.socket.nio.NioDatagramChannel, org.jboss.netty.channel.ChannelFuture, int):void");
    }

    public void writeFromSelectorLoop(SelectionKey selectionKey) {
        NioDatagramChannel nioDatagramChannel = (NioDatagramChannel) selectionKey.attachment();
        nioDatagramChannel.writeSuspended = false;
        write0(nioDatagramChannel);
    }

    public void writeFromTaskLoop(NioDatagramChannel nioDatagramChannel) {
        if (!nioDatagramChannel.writeSuspended) {
            write0(nioDatagramChannel);
        }
    }

    public void writeFromUserCode(NioDatagramChannel nioDatagramChannel) {
        if (!nioDatagramChannel.isOpen()) {
            cleanUpWriteBuffer(nioDatagramChannel);
        } else if (!scheduleWriteIfNecessary(nioDatagramChannel) && !nioDatagramChannel.writeSuspended && !nioDatagramChannel.inWriteNowLoop) {
            write0(nioDatagramChannel);
        }
    }

    public void close(NioDatagramChannel nioDatagramChannel, ChannelFuture channelFuture) {
        boolean isConnected = nioDatagramChannel.isConnected();
        boolean isBound = nioDatagramChannel.isBound();
        try {
            nioDatagramChannel.getDatagramChannel().close();
            this.cancelledKeys++;
            if (nioDatagramChannel.setClosed()) {
                channelFuture.setSuccess();
                if (isConnected) {
                    Channels.fireChannelDisconnected((Channel) nioDatagramChannel);
                }
                if (isBound) {
                    Channels.fireChannelUnbound((Channel) nioDatagramChannel);
                }
                cleanUpWriteBuffer(nioDatagramChannel);
                Channels.fireChannelClosed((Channel) nioDatagramChannel);
                return;
            }
            channelFuture.setSuccess();
        } catch (Throwable th) {
            channelFuture.setFailure(th);
            Channels.fireExceptionCaught((Channel) nioDatagramChannel, th);
        }
    }
}
