package org.jboss.netty.channel.socket.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
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
import org.jboss.netty.util.internal.IoWorkerRunnable;
import org.jboss.netty.util.internal.LinkedTransferQueue;

public class NioWorker implements Runnable {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int CLEANUP_INTERVAL = 256;
    public static final int CONSTRAINT_LEVEL = NioProviderMetadata.CONSTRAINT_LEVEL;
    public static final InternalLogger logger = InternalLoggerFactory.getInstance(NioWorker.class);
    public final int bossId;
    public volatile int cancelledKeys;
    public final Executor executor;
    public final int id;
    public final SocketReceiveBufferPool recvBufferPool = new SocketReceiveBufferPool();
    public final Queue<Runnable> registerTaskQueue = new LinkedTransferQueue();
    public volatile Selector selector;
    public final ReadWriteLock selectorGuard = new ReentrantReadWriteLock();
    public final SocketSendBufferPool sendBufferPool = new SocketSendBufferPool();
    public final Object startStopLock = new Object();
    public boolean started;
    public volatile Thread thread;
    public final AtomicBoolean wakenUp = new AtomicBoolean();
    public final Queue<Runnable> writeTaskQueue = new LinkedTransferQueue();

    public final class RegisterTask implements Runnable {
        public final NioSocketChannel channel;
        public final ChannelFuture future;
        public final boolean server;

        public RegisterTask(NioSocketChannel nioSocketChannel, ChannelFuture channelFuture, boolean z) {
            this.channel = nioSocketChannel;
            this.future = channelFuture;
            this.server = z;
        }

        public void run() {
            InetSocketAddress localAddress = this.channel.getLocalAddress();
            InetSocketAddress remoteAddress = this.channel.getRemoteAddress();
            if (localAddress == null || remoteAddress == null) {
                ChannelFuture channelFuture = this.future;
                if (channelFuture != null) {
                    channelFuture.setFailure(new ClosedChannelException());
                }
                NioWorker nioWorker = NioWorker.this;
                NioSocketChannel nioSocketChannel = this.channel;
                nioWorker.close(nioSocketChannel, Channels.succeededFuture(nioSocketChannel));
                return;
            }
            try {
                if (this.server) {
                    this.channel.socket.configureBlocking(false);
                }
                synchronized (this.channel.interestOpsLock) {
                    this.channel.socket.register(NioWorker.this.selector, this.channel.getRawInterestOps(), this.channel);
                }
                if (this.future != null) {
                    this.channel.setConnected();
                    this.future.setSuccess();
                }
            } catch (IOException e2) {
                ChannelFuture channelFuture2 = this.future;
                if (channelFuture2 != null) {
                    channelFuture2.setFailure(e2);
                }
                NioWorker nioWorker2 = NioWorker.this;
                NioSocketChannel nioSocketChannel2 = this.channel;
                nioWorker2.close(nioSocketChannel2, Channels.succeededFuture(nioSocketChannel2));
                if (!(e2 instanceof ClosedChannelException)) {
                    throw new ChannelException("Failed to register a socket to the selector.", e2);
                }
            }
            if (!this.server) {
                if (!((NioClientSocketChannel) this.channel).boundManually) {
                    Channels.fireChannelBound((Channel) this.channel, (SocketAddress) localAddress);
                }
                Channels.fireChannelConnected((Channel) this.channel, (SocketAddress) remoteAddress);
            }
        }
    }

    static {
        Class<NioWorker> cls = NioWorker.class;
    }

    public NioWorker(int i, int i2, Executor executor2) {
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

    private void cleanUpWriteBuffer(NioSocketChannel nioSocketChannel) {
        Throwable th;
        boolean z;
        Throwable th2;
        synchronized (nioSocketChannel.writeLock) {
            MessageEvent messageEvent = nioSocketChannel.currentWriteEvent;
            th = null;
            if (messageEvent != null) {
                if (nioSocketChannel.isOpen()) {
                    th2 = new NotYetConnectedException();
                } else {
                    th2 = new ClosedChannelException();
                }
                ChannelFuture future = messageEvent.getFuture();
                nioSocketChannel.currentWriteBuffer.release();
                nioSocketChannel.currentWriteBuffer = null;
                nioSocketChannel.currentWriteEvent = null;
                future.setFailure(th2);
                th = th2;
                z = true;
            } else {
                z = false;
            }
            Queue<MessageEvent> queue = nioSocketChannel.writeBuffer;
            if (!queue.isEmpty()) {
                if (th == null) {
                    if (nioSocketChannel.isOpen()) {
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
            Channels.fireExceptionCaught((Channel) nioSocketChannel, th);
        }
    }

    private void clearOpWrite(NioSocketChannel nioSocketChannel) {
        int rawInterestOps;
        SelectionKey keyFor = nioSocketChannel.socket.keyFor(this.selector);
        if (keyFor != null) {
            if (!keyFor.isValid()) {
                close(keyFor);
                return;
            }
            boolean z = false;
            synchronized (nioSocketChannel.interestOpsLock) {
                rawInterestOps = nioSocketChannel.getRawInterestOps();
                if ((rawInterestOps & 4) != 0) {
                    rawInterestOps &= -5;
                    keyFor.interestOps(rawInterestOps);
                    z = true;
                }
            }
            if (z) {
                nioSocketChannel.setRawInterestOpsNow(rawInterestOps);
            }
        }
    }

    private void close(SelectionKey selectionKey) {
        NioSocketChannel nioSocketChannel = (NioSocketChannel) selectionKey.attachment();
        close(nioSocketChannel, Channels.succeededFuture(nioSocketChannel));
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

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0060 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean read(java.nio.channels.SelectionKey r10) {
        /*
            r9 = this;
            java.nio.channels.SelectableChannel r0 = r10.channel()
            java.nio.channels.SocketChannel r0 = (java.nio.channels.SocketChannel) r0
            java.lang.Object r10 = r10.attachment()
            org.jboss.netty.channel.socket.nio.NioSocketChannel r10 = (org.jboss.netty.channel.socket.nio.NioSocketChannel) r10
            org.jboss.netty.channel.socket.nio.NioSocketChannelConfig r1 = r10.getConfig()
            org.jboss.netty.channel.ReceiveBufferSizePredictor r1 = r1.getReceiveBufferSizePredictor()
            int r2 = r1.nextReceiveBufferSize()
            org.jboss.netty.channel.socket.nio.SocketReceiveBufferPool r3 = r9.recvBufferPool
            java.nio.ByteBuffer r2 = r3.acquire(r2)
            r3 = 0
            r4 = 0
            r5 = 0
        L_0x0021:
            r6 = 1
            int r5 = r0.read(r2)     // Catch:{ ClosedChannelException -> 0x0035, all -> 0x0031 }
            if (r5 <= 0) goto L_0x002f
            int r4 = r4 + r5
            boolean r7 = r2.hasRemaining()     // Catch:{ ClosedChannelException -> 0x0035, all -> 0x0031 }
            if (r7 != 0) goto L_0x0021
        L_0x002f:
            r0 = 0
            goto L_0x0036
        L_0x0031:
            r0 = move-exception
            org.jboss.netty.channel.Channels.fireExceptionCaught(r10, r0)
        L_0x0035:
            r0 = 1
        L_0x0036:
            if (r4 <= 0) goto L_0x0059
            r2.flip()
            org.jboss.netty.channel.socket.nio.NioSocketChannelConfig r7 = r10.getConfig()
            org.jboss.netty.buffer.ChannelBufferFactory r7 = r7.getBufferFactory()
            org.jboss.netty.buffer.ChannelBuffer r7 = r7.getBuffer(r4)
            r7.setBytes(r3, r2)
            r7.writerIndex(r4)
            org.jboss.netty.channel.socket.nio.SocketReceiveBufferPool r8 = r9.recvBufferPool
            r8.release(r2)
            r1.previousReceiveBufferSize(r4)
            org.jboss.netty.channel.Channels.fireMessageReceived(r10, r7)
            goto L_0x005e
        L_0x0059:
            org.jboss.netty.channel.socket.nio.SocketReceiveBufferPool r1 = r9.recvBufferPool
            r1.release(r2)
        L_0x005e:
            if (r5 < 0) goto L_0x0064
            if (r0 == 0) goto L_0x0063
            goto L_0x0064
        L_0x0063:
            return r6
        L_0x0064:
            org.jboss.netty.channel.ChannelFuture r0 = org.jboss.netty.channel.Channels.succeededFuture(r10)
            r9.close(r10, r0)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.channel.socket.nio.NioWorker.read(java.nio.channels.SelectionKey):boolean");
    }

    private boolean scheduleWriteIfNecessary(NioSocketChannel nioSocketChannel) {
        Thread currentThread = Thread.currentThread();
        if (currentThread == this.thread) {
            return false;
        }
        if (nioSocketChannel.writeTaskInTaskQueue.compareAndSet(false, true)) {
            this.writeTaskQueue.offer(nioSocketChannel.writeTask);
        }
        if (!(nioSocketChannel instanceof NioAcceptedSocketChannel) || ((NioAcceptedSocketChannel) nioSocketChannel).bossThread != currentThread) {
            Selector selector2 = this.selector;
            if (selector2 != null && this.wakenUp.compareAndSet(false, true)) {
                selector2.wakeup();
            }
        }
        return true;
    }

    private void setOpWrite(NioSocketChannel nioSocketChannel) {
        int rawInterestOps;
        SelectionKey keyFor = nioSocketChannel.socket.keyFor(this.selector);
        if (keyFor != null) {
            if (!keyFor.isValid()) {
                close(keyFor);
                return;
            }
            boolean z = false;
            synchronized (nioSocketChannel.interestOpsLock) {
                rawInterestOps = nioSocketChannel.getRawInterestOps();
                if ((rawInterestOps & 4) == 0) {
                    rawInterestOps |= 4;
                    keyFor.interestOps(rawInterestOps);
                    z = true;
                }
            }
            if (z) {
                nioSocketChannel.setRawInterestOpsNow(rawInterestOps);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0079, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x007a, code lost:
        r11 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0095, code lost:
        r8 = true;
        r15 = false;
        r16 = false;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:30:? A[ExcHandler: AsynchronousCloseException (unused java.nio.channels.AsynchronousCloseException), PHI: r13 
      PHI: (r13v6 long) = (r13v8 long), (r13v8 long), (r13v1 long) binds: [B:27:0x0070, B:28:?, B:16:0x004a] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC, Splitter:B:16:0x004a] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00d9 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void write0(org.jboss.netty.channel.socket.nio.NioSocketChannel r27) {
        /*
            r26 = this;
            r1 = r26
            r2 = r27
            org.jboss.netty.channel.socket.nio.SocketSendBufferPool r3 = r1.sendBufferPool
            java.nio.channels.SocketChannel r4 = r2.socket
            java.util.Queue<org.jboss.netty.channel.MessageEvent> r5 = r2.writeBuffer
            org.jboss.netty.channel.socket.nio.NioSocketChannelConfig r0 = r27.getConfig()
            int r6 = r0.getWriteSpinCount()
            java.lang.Object r7 = r2.writeLock
            monitor-enter(r7)
            r8 = 1
            r2.inWriteNowLoop = r8     // Catch:{ all -> 0x00dd }
            r11 = 0
            r12 = 1
            r13 = 0
            r15 = 0
        L_0x001d:
            org.jboss.netty.channel.MessageEvent r0 = r2.currentWriteEvent     // Catch:{ all -> 0x00dd }
            if (r0 != 0) goto L_0x003e
            java.lang.Object r0 = r5.poll()     // Catch:{ all -> 0x00dd }
            org.jboss.netty.channel.MessageEvent r0 = (org.jboss.netty.channel.MessageEvent) r0     // Catch:{ all -> 0x00dd }
            r2.currentWriteEvent = r0     // Catch:{ all -> 0x00dd }
            if (r0 != 0) goto L_0x0033
            r2.writeSuspended = r11     // Catch:{ all -> 0x00dd }
            r8 = r15
            r15 = 0
            r16 = 1
            goto L_0x0099
        L_0x0033:
            java.lang.Object r11 = r0.getMessage()     // Catch:{ all -> 0x00dd }
            org.jboss.netty.channel.socket.nio.SocketSendBufferPool$SendBuffer r11 = r3.acquire(r11)     // Catch:{ all -> 0x00dd }
            r2.currentWriteBuffer = r11     // Catch:{ all -> 0x00dd }
            goto L_0x0040
        L_0x003e:
            org.jboss.netty.channel.socket.nio.SocketSendBufferPool$SendBuffer r11 = r2.currentWriteBuffer     // Catch:{ all -> 0x00dd }
        L_0x0040:
            org.jboss.netty.channel.ChannelFuture r8 = r0.getFuture()     // Catch:{ all -> 0x00dd }
            r0 = r6
            r17 = 0
        L_0x0047:
            r9 = 0
            if (r0 <= 0) goto L_0x0061
            long r17 = r11.transferTo(r4)     // Catch:{ AsynchronousCloseException -> 0x0073, all -> 0x00ba }
            r19 = 0
            int r10 = (r17 > r19 ? 1 : (r17 == r19 ? 0 : -1))
            if (r10 == 0) goto L_0x0057
            long r13 = r13 + r17
            goto L_0x0061
        L_0x0057:
            boolean r10 = r11.finished()     // Catch:{ AsynchronousCloseException -> 0x0073, all -> 0x00ba }
            if (r10 == 0) goto L_0x005e
            goto L_0x0061
        L_0x005e:
            int r0 = r0 + -1
            goto L_0x0047
        L_0x0061:
            r18 = r17
            boolean r0 = r11.finished()     // Catch:{ AsynchronousCloseException -> 0x0073, all -> 0x00ba }
            if (r0 == 0) goto L_0x007c
            r11.release()     // Catch:{ AsynchronousCloseException -> 0x0073, all -> 0x00ba }
            r2.currentWriteEvent = r9     // Catch:{ AsynchronousCloseException -> 0x0073, all -> 0x00ba }
            r2.currentWriteBuffer = r9     // Catch:{ AsynchronousCloseException -> 0x0073, all -> 0x00ba }
            r8.setSuccess()     // Catch:{ AsynchronousCloseException -> 0x0073, all -> 0x0079 }
        L_0x0073:
            r10 = 1
            r16 = 0
            r24 = 0
            goto L_0x00d9
        L_0x0079:
            r0 = move-exception
            r11 = r9
            goto L_0x00bb
        L_0x007c:
            r10 = 1
            r2.writeSuspended = r10     // Catch:{ AsynchronousCloseException -> 0x00b4, all -> 0x00ad }
            r24 = 0
            int r0 = (r18 > r24 ? 1 : (r18 == r24 ? 0 : -1))
            if (r0 <= 0) goto L_0x0095
            long r20 = r11.writtenBytes()     // Catch:{ AsynchronousCloseException -> 0x00b6, all -> 0x0093 }
            long r22 = r11.totalBytes()     // Catch:{ AsynchronousCloseException -> 0x00b6, all -> 0x0093 }
            r17 = r8
            r17.setProgress(r18, r20, r22)     // Catch:{ AsynchronousCloseException -> 0x00b6, all -> 0x0093 }
            goto L_0x0095
        L_0x0093:
            r0 = move-exception
            goto L_0x00b0
        L_0x0095:
            r8 = 1
            r15 = 0
            r16 = 0
        L_0x0099:
            r2.inWriteNowLoop = r15     // Catch:{ all -> 0x00dd }
            monitor-exit(r7)     // Catch:{ all -> 0x00dd }
            org.jboss.netty.channel.Channels.fireWriteComplete(r2, r13)
            if (r12 == 0) goto L_0x00ac
            if (r8 == 0) goto L_0x00a7
            r26.setOpWrite(r27)
            goto L_0x00ac
        L_0x00a7:
            if (r16 == 0) goto L_0x00ac
            r26.clearOpWrite(r27)
        L_0x00ac:
            return
        L_0x00ad:
            r0 = move-exception
            r24 = 0
        L_0x00b0:
            r15 = 1
            r16 = 0
            goto L_0x00c0
        L_0x00b4:
            r24 = 0
        L_0x00b6:
            r15 = 1
            r16 = 0
            goto L_0x00d9
        L_0x00ba:
            r0 = move-exception
        L_0x00bb:
            r10 = 1
            r16 = 0
            r24 = 0
        L_0x00c0:
            r11.release()     // Catch:{ all -> 0x00dd }
            r2.currentWriteEvent = r9     // Catch:{ all -> 0x00dd }
            r2.currentWriteBuffer = r9     // Catch:{ all -> 0x00dd }
            r8.setFailure(r0)     // Catch:{ all -> 0x00dd }
            org.jboss.netty.channel.Channels.fireExceptionCaught(r2, r0)     // Catch:{ all -> 0x00dd }
            boolean r0 = r0 instanceof java.io.IOException     // Catch:{ all -> 0x00dd }
            if (r0 == 0) goto L_0x00d9
            org.jboss.netty.channel.ChannelFuture r0 = org.jboss.netty.channel.Channels.succeededFuture(r27)     // Catch:{ all -> 0x00dd }
            r1.close(r2, r0)     // Catch:{ all -> 0x00dd }
            r12 = 0
        L_0x00d9:
            r8 = 1
            r11 = 0
            goto L_0x001d
        L_0x00dd:
            r0 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x00dd }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.channel.socket.nio.NioWorker.write0(org.jboss.netty.channel.socket.nio.NioSocketChannel):void");
    }

    public void register(NioSocketChannel nioSocketChannel, ChannelFuture channelFuture) {
        Selector selector2;
        boolean z = !(nioSocketChannel instanceof NioClientSocketChannel);
        RegisterTask registerTask = new RegisterTask(nioSocketChannel, channelFuture, z);
        synchronized (this.startStopLock) {
            if (!this.started) {
                try {
                    selector2 = Selector.open();
                    this.selector = selector2;
                    StringBuilder sb = new StringBuilder();
                    sb.append(z ? "New I/O server worker #" : "New I/O client worker #");
                    sb.append(this.bossId);
                    sb.append('-');
                    sb.append(this.id);
                    this.executor.execute(new IoWorkerRunnable(new ThreadRenamingRunnable(this, sb.toString())));
                } catch (Throwable th) {
                    logger.warn("Failed to close a selector.", th);
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
        this.thread = Thread.currentThread();
        Selector selector2 = this.selector;
        while (true) {
            boolean z = false;
            while (true) {
                this.wakenUp.set(false);
                if (CONSTRAINT_LEVEL != 0) {
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
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x008b, code lost:
        if (r4 == false) goto L_0x00af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x008d, code lost:
        r8.setRawInterestOpsNow(r10);
        org.jboss.netty.channel.Channels.fireChannelInterestChanged((org.jboss.netty.channel.Channel) r8);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setInterestOps(org.jboss.netty.channel.socket.nio.NioSocketChannel r8, org.jboss.netty.channel.ChannelFuture r9, int r10) {
        /*
            r7 = this;
            java.lang.Object r0 = r8.interestOpsLock     // Catch:{ CancelledKeyException -> 0x00a4, all -> 0x009c }
            monitor-enter(r0)     // Catch:{ CancelledKeyException -> 0x00a4, all -> 0x009c }
            java.nio.channels.Selector r1 = r7.selector     // Catch:{ all -> 0x0099 }
            java.nio.channels.SocketChannel r2 = r8.socket     // Catch:{ all -> 0x0099 }
            java.nio.channels.SelectionKey r2 = r2.keyFor(r1)     // Catch:{ all -> 0x0099 }
            if (r2 == 0) goto L_0x0094
            if (r1 != 0) goto L_0x0011
            goto L_0x0094
        L_0x0011:
            r10 = r10 & -5
            int r3 = r8.getRawInterestOps()     // Catch:{ all -> 0x0099 }
            r3 = r3 & 4
            r10 = r10 | r3
            int r3 = CONSTRAINT_LEVEL     // Catch:{ all -> 0x0099 }
            r4 = 0
            r5 = 1
            if (r3 == 0) goto L_0x006a
            if (r3 == r5) goto L_0x002c
            r6 = 2
            if (r3 != r6) goto L_0x0026
            goto L_0x002c
        L_0x0026:
            java.lang.Error r10 = new java.lang.Error     // Catch:{ all -> 0x0099 }
            r10.<init>()     // Catch:{ all -> 0x0099 }
            throw r10     // Catch:{ all -> 0x0099 }
        L_0x002c:
            int r3 = r8.getRawInterestOps()     // Catch:{ all -> 0x0099 }
            if (r3 == r10) goto L_0x0087
            java.lang.Thread r3 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0099 }
            java.lang.Thread r6 = r7.thread     // Catch:{ all -> 0x0099 }
            if (r3 != r6) goto L_0x003e
            r2.interestOps(r10)     // Catch:{ all -> 0x0099 }
            goto L_0x0086
        L_0x003e:
            java.util.concurrent.locks.ReadWriteLock r3 = r7.selectorGuard     // Catch:{ all -> 0x0099 }
            java.util.concurrent.locks.Lock r3 = r3.readLock()     // Catch:{ all -> 0x0099 }
            r3.lock()     // Catch:{ all -> 0x0099 }
            java.util.concurrent.atomic.AtomicBoolean r3 = r7.wakenUp     // Catch:{ all -> 0x005f }
            boolean r3 = r3.compareAndSet(r4, r5)     // Catch:{ all -> 0x005f }
            if (r3 == 0) goto L_0x0052
            r1.wakeup()     // Catch:{ all -> 0x005f }
        L_0x0052:
            r2.interestOps(r10)     // Catch:{ all -> 0x005f }
            java.util.concurrent.locks.ReadWriteLock r1 = r7.selectorGuard     // Catch:{ all -> 0x0099 }
            java.util.concurrent.locks.Lock r1 = r1.readLock()     // Catch:{ all -> 0x0099 }
            r1.unlock()     // Catch:{ all -> 0x0099 }
            goto L_0x0086
        L_0x005f:
            r10 = move-exception
            java.util.concurrent.locks.ReadWriteLock r1 = r7.selectorGuard     // Catch:{ all -> 0x0099 }
            java.util.concurrent.locks.Lock r1 = r1.readLock()     // Catch:{ all -> 0x0099 }
            r1.unlock()     // Catch:{ all -> 0x0099 }
            throw r10     // Catch:{ all -> 0x0099 }
        L_0x006a:
            int r3 = r8.getRawInterestOps()     // Catch:{ all -> 0x0099 }
            if (r3 == r10) goto L_0x0087
            r2.interestOps(r10)     // Catch:{ all -> 0x0099 }
            java.lang.Thread r2 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0099 }
            java.lang.Thread r3 = r7.thread     // Catch:{ all -> 0x0099 }
            if (r2 == r3) goto L_0x0086
            java.util.concurrent.atomic.AtomicBoolean r2 = r7.wakenUp     // Catch:{ all -> 0x0099 }
            boolean r2 = r2.compareAndSet(r4, r5)     // Catch:{ all -> 0x0099 }
            if (r2 == 0) goto L_0x0086
            r1.wakeup()     // Catch:{ all -> 0x0099 }
        L_0x0086:
            r4 = 1
        L_0x0087:
            monitor-exit(r0)     // Catch:{ all -> 0x0099 }
            r9.setSuccess()     // Catch:{ CancelledKeyException -> 0x00a4, all -> 0x009c }
            if (r4 == 0) goto L_0x00af
            r8.setRawInterestOpsNow(r10)     // Catch:{ CancelledKeyException -> 0x00a4, all -> 0x009c }
            org.jboss.netty.channel.Channels.fireChannelInterestChanged(r8)     // Catch:{ CancelledKeyException -> 0x00a4, all -> 0x009c }
            goto L_0x00af
        L_0x0094:
            r8.setRawInterestOpsNow(r10)     // Catch:{ all -> 0x0099 }
            monitor-exit(r0)     // Catch:{ all -> 0x0099 }
            return
        L_0x0099:
            r10 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0099 }
            throw r10     // Catch:{ CancelledKeyException -> 0x00a4, all -> 0x009c }
        L_0x009c:
            r10 = move-exception
            r9.setFailure(r10)
            org.jboss.netty.channel.Channels.fireExceptionCaught(r8, r10)
            goto L_0x00af
        L_0x00a4:
            java.nio.channels.ClosedChannelException r10 = new java.nio.channels.ClosedChannelException
            r10.<init>()
            r9.setFailure(r10)
            org.jboss.netty.channel.Channels.fireExceptionCaught(r8, r10)
        L_0x00af:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.channel.socket.nio.NioWorker.setInterestOps(org.jboss.netty.channel.socket.nio.NioSocketChannel, org.jboss.netty.channel.ChannelFuture, int):void");
    }

    public void writeFromSelectorLoop(SelectionKey selectionKey) {
        NioSocketChannel nioSocketChannel = (NioSocketChannel) selectionKey.attachment();
        nioSocketChannel.writeSuspended = false;
        write0(nioSocketChannel);
    }

    public void writeFromTaskLoop(NioSocketChannel nioSocketChannel) {
        if (!nioSocketChannel.writeSuspended) {
            write0(nioSocketChannel);
        }
    }

    public void writeFromUserCode(NioSocketChannel nioSocketChannel) {
        if (!nioSocketChannel.isConnected()) {
            cleanUpWriteBuffer(nioSocketChannel);
        } else if (!scheduleWriteIfNecessary(nioSocketChannel) && !nioSocketChannel.writeSuspended && !nioSocketChannel.inWriteNowLoop) {
            write0(nioSocketChannel);
        }
    }

    public void close(NioSocketChannel nioSocketChannel, ChannelFuture channelFuture) {
        boolean isConnected = nioSocketChannel.isConnected();
        boolean isBound = nioSocketChannel.isBound();
        try {
            nioSocketChannel.socket.close();
            this.cancelledKeys++;
            if (nioSocketChannel.setClosed()) {
                channelFuture.setSuccess();
                if (isConnected) {
                    Channels.fireChannelDisconnected((Channel) nioSocketChannel);
                }
                if (isBound) {
                    Channels.fireChannelUnbound((Channel) nioSocketChannel);
                }
                cleanUpWriteBuffer(nioSocketChannel);
                Channels.fireChannelClosed((Channel) nioSocketChannel);
                return;
            }
            channelFuture.setSuccess();
        } catch (Throwable th) {
            channelFuture.setFailure(th);
            Channels.fireExceptionCaught((Channel) nioSocketChannel, th);
        }
    }
}
