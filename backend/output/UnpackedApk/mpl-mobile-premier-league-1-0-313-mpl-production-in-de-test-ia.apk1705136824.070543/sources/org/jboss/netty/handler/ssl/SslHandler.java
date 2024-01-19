package org.jboss.netty.handler.ssl;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLEngineResult.HandshakeStatus;
import javax.net.ssl.SSLException;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelDownstreamHandler;
import org.jboss.netty.channel.ChannelEvent;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelFutureListener;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.LifeCycleAwareChannelHandler;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.handler.codec.frame.FrameDecoder;
import org.jboss.netty.logging.InternalLogger;
import org.jboss.netty.logging.InternalLoggerFactory;
import org.jboss.netty.util.internal.LinkedTransferQueue;
import org.jboss.netty.util.internal.NonReentrantLock;

public class SslHandler extends FrameDecoder implements ChannelDownstreamHandler, LifeCycleAwareChannelHandler {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final ByteBuffer EMPTY_BUFFER = ByteBuffer.allocate(0);
    public static final Pattern IGNORABLE_ERROR_MESSAGE = Pattern.compile("^.*(?:connection.*reset|connection.*closed|broken.*pipe).*$", 2);
    public static SslBufferPool defaultBufferPool;
    public static final InternalLogger logger = InternalLoggerFactory.getInstance(SslHandler.class);
    public final SslBufferPool bufferPool;
    public volatile ChannelHandlerContext ctx;
    public final Executor delegatedTaskExecutor;
    public volatile boolean enableRenegotiation;
    public final SSLEngine engine;
    public volatile ChannelFuture handshakeFuture;
    public final Object handshakeLock;
    public volatile boolean handshaken;
    public boolean handshaking;
    public int ignoreClosedChannelException;
    public final Object ignoreClosedChannelExceptionLock;
    public final Queue<MessageEvent> pendingEncryptedWrites;
    public final NonReentrantLock pendingEncryptedWritesLock;
    public final Queue<PendingWrite> pendingUnencryptedWrites;
    public final AtomicBoolean sentCloseNotify;
    public final AtomicBoolean sentFirstMessage;
    public final boolean startTls;

    /* renamed from: org.jboss.netty.handler.ssl.SslHandler$3  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
        public static final /* synthetic */ int[] $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus;
        public static final /* synthetic */ int[] $SwitchMap$org$jboss$netty$channel$ChannelState;

        /* JADX WARNING: Can't wrap try/catch for region: R(19:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|17|18|19|20|21|22|24) */
        /* JADX WARNING: Can't wrap try/catch for region: R(20:0|(2:1|2)|3|5|6|7|9|10|11|12|13|14|15|17|18|19|20|21|22|24) */
        /* JADX WARNING: Can't wrap try/catch for region: R(21:0|1|2|3|5|6|7|9|10|11|12|13|14|15|17|18|19|20|21|22|24) */
        /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0052 */
        static {
            /*
                javax.net.ssl.SSLEngineResult$HandshakeStatus[] r0 = javax.net.ssl.SSLEngineResult.HandshakeStatus.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus = r0
                r1 = 1
                javax.net.ssl.SSLEngineResult$HandshakeStatus r2 = javax.net.ssl.SSLEngineResult.HandshakeStatus.NEED_WRAP     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus     // Catch:{ NoSuchFieldError -> 0x001d }
                javax.net.ssl.SSLEngineResult$HandshakeStatus r3 = javax.net.ssl.SSLEngineResult.HandshakeStatus.NEED_UNWRAP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus     // Catch:{ NoSuchFieldError -> 0x0028 }
                javax.net.ssl.SSLEngineResult$HandshakeStatus r4 = javax.net.ssl.SSLEngineResult.HandshakeStatus.NEED_TASK     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r3 = $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus     // Catch:{ NoSuchFieldError -> 0x0033 }
                javax.net.ssl.SSLEngineResult$HandshakeStatus r4 = javax.net.ssl.SSLEngineResult.HandshakeStatus.FINISHED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r5 = 4
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r3 = $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus     // Catch:{ NoSuchFieldError -> 0x003e }
                javax.net.ssl.SSLEngineResult$HandshakeStatus r4 = javax.net.ssl.SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING     // Catch:{ NoSuchFieldError -> 0x003e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5 = 5
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                org.jboss.netty.channel.ChannelState[] r3 = org.jboss.netty.channel.ChannelState.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                $SwitchMap$org$jboss$netty$channel$ChannelState = r3
                org.jboss.netty.channel.ChannelState r4 = org.jboss.netty.channel.ChannelState.OPEN     // Catch:{ NoSuchFieldError -> 0x004c }
                r4 = 0
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x004c }
            L_0x004c:
                int[] r3 = $SwitchMap$org$jboss$netty$channel$ChannelState     // Catch:{ NoSuchFieldError -> 0x0052 }
                org.jboss.netty.channel.ChannelState r4 = org.jboss.netty.channel.ChannelState.CONNECTED     // Catch:{ NoSuchFieldError -> 0x0052 }
                r3[r0] = r0     // Catch:{ NoSuchFieldError -> 0x0052 }
            L_0x0052:
                int[] r0 = $SwitchMap$org$jboss$netty$channel$ChannelState     // Catch:{ NoSuchFieldError -> 0x0058 }
                org.jboss.netty.channel.ChannelState r3 = org.jboss.netty.channel.ChannelState.BOUND     // Catch:{ NoSuchFieldError -> 0x0058 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.handler.ssl.SslHandler.AnonymousClass3.<clinit>():void");
        }
    }

    public static final class ClosingChannelFutureListener implements ChannelFutureListener {
        public final ChannelHandlerContext context;

        /* renamed from: e  reason: collision with root package name */
        public final ChannelStateEvent f6170e;

        public ClosingChannelFutureListener(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
            this.context = channelHandlerContext;
            this.f6170e = channelStateEvent;
        }

        public void operationComplete(ChannelFuture channelFuture) throws Exception {
            if (!(channelFuture.getCause() instanceof ClosedChannelException)) {
                Channels.close(this.context, this.f6170e.getFuture());
            }
        }
    }

    public static final class PendingWrite {
        public final ChannelFuture future;
        public final ByteBuffer outAppBuf;

        public PendingWrite(ChannelFuture channelFuture, ByteBuffer byteBuffer) {
            this.future = channelFuture;
            this.outAppBuf = byteBuffer;
        }
    }

    public SslHandler(SSLEngine sSLEngine) {
        this(sSLEngine, getDefaultBufferPool(), (Executor) ImmediateExecutor.INSTANCE);
    }

    private void closeOutboundAndChannel(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) throws SSLException {
        if (!channelStateEvent.getChannel().isConnected()) {
            channelHandlerContext.sendDownstream(channelStateEvent);
            return;
        }
        unwrap(channelHandlerContext, channelStateEvent.getChannel(), ChannelBuffers.EMPTY_BUFFER, 0, 0);
        if (this.engine.isInboundDone() || !this.sentCloseNotify.compareAndSet(false, true)) {
            channelHandlerContext.sendDownstream(channelStateEvent);
            return;
        }
        this.engine.closeOutbound();
        wrapNonAppData(channelHandlerContext, channelStateEvent.getChannel()).addListener(new ClosingChannelFutureListener(channelHandlerContext, channelStateEvent));
    }

    private void flushPendingEncryptedWrites(ChannelHandlerContext channelHandlerContext) {
        if (this.pendingEncryptedWritesLock.tryLock()) {
            while (true) {
                try {
                    MessageEvent poll = this.pendingEncryptedWrites.poll();
                    if (poll != null) {
                        channelHandlerContext.sendDownstream(poll);
                    } else {
                        return;
                    }
                } finally {
                    this.pendingEncryptedWritesLock.unlock();
                }
            }
        }
    }

    public static synchronized SslBufferPool getDefaultBufferPool() {
        SslBufferPool sslBufferPool;
        synchronized (SslHandler.class) {
            if (defaultBufferPool == null) {
                defaultBufferPool = new SslBufferPool();
            }
            sslBufferPool = defaultBufferPool;
        }
        return sslBufferPool;
    }

    private void handleRenegotiation(HandshakeStatus handshakeStatus) {
        if (handshakeStatus != HandshakeStatus.NOT_HANDSHAKING && handshakeStatus != HandshakeStatus.FINISHED && this.handshaken && !this.handshaking && !this.engine.isInboundDone() && !this.engine.isOutboundDone()) {
            if (isEnableRenegotiation()) {
                handshake();
            } else {
                this.handshaking = true;
                Channels.fireExceptionCaught(this.ctx, (Throwable) new SSLException("renegotiation attempted by peer; closing the connection"));
                Channels.close(this.ctx, Channels.succeededFuture(this.ctx.getChannel()));
            }
        }
    }

    private void offerEncryptedWriteRequest(MessageEvent messageEvent) {
        boolean tryLock = this.pendingEncryptedWritesLock.tryLock();
        try {
            this.pendingEncryptedWrites.offer(messageEvent);
        } finally {
            if (tryLock) {
                this.pendingEncryptedWritesLock.unlock();
            }
        }
    }

    private void runDelegatedTasks() {
        final Runnable delegatedTask;
        while (true) {
            synchronized (this.handshakeLock) {
                delegatedTask = this.engine.getDelegatedTask();
            }
            if (delegatedTask != null) {
                this.delegatedTaskExecutor.execute(new Runnable() {
                    public void run() {
                        synchronized (SslHandler.this.handshakeLock) {
                            delegatedTask.run();
                        }
                    }
                });
            } else {
                return;
            }
        }
        while (true) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0019, code lost:
        r2.handshakeFuture.setFailure(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void setHandshakeFailure(org.jboss.netty.channel.Channel r3, javax.net.ssl.SSLException r4) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.handshakeLock
            monitor-enter(r0)
            boolean r1 = r2.handshaking     // Catch:{ all -> 0x001f }
            if (r1 != 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            return
        L_0x0009:
            r1 = 0
            r2.handshaking = r1     // Catch:{ all -> 0x001f }
            r2.handshaken = r1     // Catch:{ all -> 0x001f }
            org.jboss.netty.channel.ChannelFuture r1 = r2.handshakeFuture     // Catch:{ all -> 0x001f }
            if (r1 != 0) goto L_0x0018
            org.jboss.netty.channel.ChannelFuture r3 = org.jboss.netty.channel.Channels.future(r3)     // Catch:{ all -> 0x001f }
            r2.handshakeFuture = r3     // Catch:{ all -> 0x001f }
        L_0x0018:
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            org.jboss.netty.channel.ChannelFuture r3 = r2.handshakeFuture
            r3.setFailure(r4)
            return
        L_0x001f:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.handler.ssl.SslHandler.setHandshakeFailure(org.jboss.netty.channel.Channel, javax.net.ssl.SSLException):void");
    }

    private void setHandshakeSuccess(Channel channel) {
        synchronized (this.handshakeLock) {
            this.handshaking = false;
            this.handshaken = true;
            if (this.handshakeFuture == null) {
                this.handshakeFuture = Channels.future(channel);
            }
        }
        this.handshakeFuture.setSuccess();
    }

    private ChannelBuffer unwrap(ChannelHandlerContext channelHandlerContext, Channel channel, ChannelBuffer channelBuffer, int i, int i2) throws SSLException {
        boolean z;
        ChannelBuffer channelBuffer2;
        ByteBuffer byteBuffer = channelBuffer.toByteBuffer(i, i2);
        ByteBuffer acquire = this.bufferPool.acquire();
        while (true) {
            try {
                synchronized (this.handshakeLock) {
                    if (!this.handshaken && !this.handshaking && !this.engine.getUseClientMode() && !this.engine.isInboundDone() && !this.engine.isOutboundDone()) {
                        handshake();
                    }
                    try {
                        HandshakeStatus handshakeStatus = this.engine.unwrap(byteBuffer, acquire).getHandshakeStatus();
                        handleRenegotiation(handshakeStatus);
                        int i3 = AnonymousClass3.$SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[handshakeStatus.ordinal()];
                        z = true;
                        if (i3 == 1) {
                            wrapNonAppData(channelHandlerContext, channel);
                        } else if (i3 != 2) {
                            if (i3 == 3) {
                                runDelegatedTasks();
                            } else if (i3 == 4) {
                                setHandshakeSuccess(channel);
                            } else if (i3 != 5) {
                                throw new IllegalStateException("Unknown handshake status: " + handshakeStatus);
                            }
                        } else if (!byteBuffer.hasRemaining() || this.engine.isInboundDone()) {
                        }
                    } catch (SSLException e2) {
                        throw e2;
                    }
                }
            } catch (SSLException e3) {
                try {
                    setHandshakeFailure(channel, e3);
                    throw e3;
                } catch (Throwable th) {
                    this.bufferPool.release(acquire);
                    throw th;
                }
            }
        }
        z = false;
        if (z) {
            if (!Thread.holdsLock(this.handshakeLock) && !this.pendingEncryptedWritesLock.isHeldByCurrentThread()) {
                wrap(channelHandlerContext, channel);
            }
        }
        acquire.flip();
        if (acquire.hasRemaining()) {
            channelBuffer2 = ChannelBuffers.buffer(acquire.remaining());
            channelBuffer2.writeBytes(acquire.array(), 0, channelBuffer2.capacity());
        } else {
            channelBuffer2 = null;
        }
        this.bufferPool.release(acquire);
        return channelBuffer2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0137, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:?, code lost:
        setHandshakeFailure(r13, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x013b, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x013c, code lost:
        r13 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0144, code lost:
        flushPendingEncryptedWrites(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0149, code lost:
        r12 = new java.lang.IllegalStateException("SSLEngine already closed");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0152, code lost:
        monitor-enter(r11.pendingUnencryptedWrites);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:?, code lost:
        r1 = r11.pendingUnencryptedWrites.poll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x015b, code lost:
        if (r1 != null) goto L_0x015d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x015e, code lost:
        r1.future.setFailure(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:?, code lost:
        return org.jboss.netty.channel.Channels.succeededFuture(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:?, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00d3, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00df, code lost:
        r11.bufferPool.release(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00e4, code lost:
        if (r3 == false) goto L_0x00e9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00e6, code lost:
        flushPendingEncryptedWrites(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00e9, code lost:
        if (r4 != false) goto L_0x010b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00eb, code lost:
        r0 = new java.lang.IllegalStateException("SSLEngine already closed");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00f2, code lost:
        r3 = r11.pendingUnencryptedWrites;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00f4, code lost:
        monitor-enter(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:?, code lost:
        r4 = r11.pendingUnencryptedWrites.poll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00fd, code lost:
        if (r4 != null) goto L_0x0101;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x00ff, code lost:
        monitor-exit(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0101, code lost:
        monitor-exit(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0102, code lost:
        r4.future.setFailure(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x010b, code lost:
        if (r1 == false) goto L_0x0117;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x010d, code lost:
        unwrap(r12, r13, org.jboss.netty.buffer.ChannelBuffers.EMPTY_BUFFER, 0, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0117, code lost:
        if (r2 != null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0131, code lost:
        r13 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0132, code lost:
        r1 = true;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0137 A[ExcHandler: SSLException (r2v3 'e' javax.net.ssl.SSLException A[CUSTOM_DECLARE]), Splitter:B:2:0x000a] */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0144  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0149  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.jboss.netty.channel.ChannelFuture wrap(org.jboss.netty.channel.ChannelHandlerContext r12, org.jboss.netty.channel.Channel r13) throws javax.net.ssl.SSLException {
        /*
            r11 = this;
            org.jboss.netty.handler.ssl.SslBufferPool r0 = r11.bufferPool
            java.nio.ByteBuffer r0 = r0.acquire()
            r1 = 0
            r2 = 0
            r3 = 0
        L_0x0009:
            r4 = 1
            java.util.Queue<org.jboss.netty.handler.ssl.SslHandler$PendingWrite> r5 = r11.pendingUnencryptedWrites     // Catch:{ SSLException -> 0x0137, all -> 0x0134 }
            monitor-enter(r5)     // Catch:{ SSLException -> 0x0137, all -> 0x0134 }
            java.util.Queue<org.jboss.netty.handler.ssl.SslHandler$PendingWrite> r6 = r11.pendingUnencryptedWrites     // Catch:{ all -> 0x012e }
            java.lang.Object r6 = r6.peek()     // Catch:{ all -> 0x012e }
            org.jboss.netty.handler.ssl.SslHandler$PendingWrite r6 = (org.jboss.netty.handler.ssl.SslHandler.PendingWrite) r6     // Catch:{ all -> 0x012e }
            if (r6 != 0) goto L_0x001a
            monitor-exit(r5)     // Catch:{ all -> 0x012e }
            goto L_0x00df
        L_0x001a:
            java.nio.ByteBuffer r7 = r6.outAppBuf     // Catch:{ all -> 0x012e }
            if (r7 != 0) goto L_0x0036
            java.util.Queue<org.jboss.netty.handler.ssl.SslHandler$PendingWrite> r7 = r11.pendingUnencryptedWrites     // Catch:{ all -> 0x012e }
            r7.remove()     // Catch:{ all -> 0x012e }
            org.jboss.netty.channel.DownstreamMessageEvent r7 = new org.jboss.netty.channel.DownstreamMessageEvent     // Catch:{ all -> 0x012e }
            org.jboss.netty.channel.ChannelFuture r6 = r6.future     // Catch:{ all -> 0x012e }
            org.jboss.netty.buffer.ChannelBuffer r8 = org.jboss.netty.buffer.ChannelBuffers.EMPTY_BUFFER     // Catch:{ all -> 0x012e }
            java.net.SocketAddress r9 = r13.getRemoteAddress()     // Catch:{ all -> 0x012e }
            r7.<init>(r13, r6, r8, r9)     // Catch:{ all -> 0x012e }
            r11.offerEncryptedWriteRequest(r7)     // Catch:{ all -> 0x012e }
        L_0x0033:
            r3 = 1
            goto L_0x00db
        L_0x0036:
            java.lang.Object r8 = r11.handshakeLock     // Catch:{ all -> 0x0121 }
            monitor-enter(r8)     // Catch:{ all -> 0x0121 }
            javax.net.ssl.SSLEngine r9 = r11.engine     // Catch:{ all -> 0x011e }
            javax.net.ssl.SSLEngineResult r9 = r9.wrap(r7, r0)     // Catch:{ all -> 0x011e }
            monitor-exit(r8)     // Catch:{ all -> 0x011e }
            boolean r8 = r7.hasRemaining()     // Catch:{ all -> 0x012e }
            if (r8 != 0) goto L_0x004b
            java.util.Queue<org.jboss.netty.handler.ssl.SslHandler$PendingWrite> r8 = r11.pendingUnencryptedWrites     // Catch:{ all -> 0x012e }
            r8.remove()     // Catch:{ all -> 0x012e }
        L_0x004b:
            int r8 = r9.bytesProduced()     // Catch:{ all -> 0x012e }
            if (r8 <= 0) goto L_0x0087
            r0.flip()     // Catch:{ all -> 0x012e }
            int r2 = r0.remaining()     // Catch:{ all -> 0x012e }
            org.jboss.netty.buffer.ChannelBuffer r2 = org.jboss.netty.buffer.ChannelBuffers.buffer(r2)     // Catch:{ all -> 0x012e }
            byte[] r7 = r0.array()     // Catch:{ all -> 0x012e }
            int r8 = r2.capacity()     // Catch:{ all -> 0x012e }
            r2.writeBytes(r7, r1, r8)     // Catch:{ all -> 0x012e }
            r0.clear()     // Catch:{ all -> 0x012e }
            java.nio.ByteBuffer r7 = r6.outAppBuf     // Catch:{ all -> 0x012e }
            boolean r7 = r7.hasRemaining()     // Catch:{ all -> 0x012e }
            if (r7 == 0) goto L_0x0077
            org.jboss.netty.channel.ChannelFuture r6 = org.jboss.netty.channel.Channels.succeededFuture(r13)     // Catch:{ all -> 0x012e }
            goto L_0x0079
        L_0x0077:
            org.jboss.netty.channel.ChannelFuture r6 = r6.future     // Catch:{ all -> 0x012e }
        L_0x0079:
            org.jboss.netty.channel.DownstreamMessageEvent r7 = new org.jboss.netty.channel.DownstreamMessageEvent     // Catch:{ all -> 0x012e }
            java.net.SocketAddress r8 = r13.getRemoteAddress()     // Catch:{ all -> 0x012e }
            r7.<init>(r13, r6, r2, r8)     // Catch:{ all -> 0x012e }
            r11.offerEncryptedWriteRequest(r7)     // Catch:{ all -> 0x012e }
            r2 = r6
            goto L_0x0033
        L_0x0087:
            javax.net.ssl.SSLEngineResult$HandshakeStatus r6 = r9.getHandshakeStatus()     // Catch:{ all -> 0x012e }
            r11.handleRenegotiation(r6)     // Catch:{ all -> 0x012e }
            int[] r8 = org.jboss.netty.handler.ssl.SslHandler.AnonymousClass3.$SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus     // Catch:{ all -> 0x012e }
            int r10 = r6.ordinal()     // Catch:{ all -> 0x012e }
            r8 = r8[r10]     // Catch:{ all -> 0x012e }
            if (r8 == r4) goto L_0x00d5
            r7 = 2
            if (r8 == r7) goto L_0x00d2
            r7 = 3
            if (r8 == r7) goto L_0x00ce
            r7 = 4
            if (r8 == r7) goto L_0x00bc
            r7 = 5
            if (r8 != r7) goto L_0x00a5
            goto L_0x00bc
        L_0x00a5:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException     // Catch:{ all -> 0x012e }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x012e }
            r7.<init>()     // Catch:{ all -> 0x012e }
            java.lang.String r8 = "Unknown handshake status: "
            r7.append(r8)     // Catch:{ all -> 0x012e }
            r7.append(r6)     // Catch:{ all -> 0x012e }
            java.lang.String r6 = r7.toString()     // Catch:{ all -> 0x012e }
            r2.<init>(r6)     // Catch:{ all -> 0x012e }
            throw r2     // Catch:{ all -> 0x012e }
        L_0x00bc:
            javax.net.ssl.SSLEngineResult$HandshakeStatus r7 = javax.net.ssl.SSLEngineResult.HandshakeStatus.FINISHED     // Catch:{ all -> 0x012e }
            if (r6 != r7) goto L_0x00c3
            r11.setHandshakeSuccess(r13)     // Catch:{ all -> 0x012e }
        L_0x00c3:
            javax.net.ssl.SSLEngineResult$Status r6 = r9.getStatus()     // Catch:{ all -> 0x012e }
            javax.net.ssl.SSLEngineResult$Status r7 = javax.net.ssl.SSLEngineResult.Status.CLOSED     // Catch:{ all -> 0x012e }
            if (r6 != r7) goto L_0x00cc
            r4 = 0
        L_0x00cc:
            monitor-exit(r5)     // Catch:{ all -> 0x012e }
            goto L_0x00df
        L_0x00ce:
            r11.runDelegatedTasks()     // Catch:{ all -> 0x012e }
            goto L_0x00db
        L_0x00d2:
            monitor-exit(r5)     // Catch:{ all -> 0x012e }
            r1 = 1
            goto L_0x00df
        L_0x00d5:
            boolean r6 = r7.hasRemaining()     // Catch:{ all -> 0x012e }
            if (r6 == 0) goto L_0x00de
        L_0x00db:
            monitor-exit(r5)     // Catch:{ all -> 0x012e }
            goto L_0x0009
        L_0x00de:
            monitor-exit(r5)     // Catch:{ all -> 0x012e }
        L_0x00df:
            org.jboss.netty.handler.ssl.SslBufferPool r5 = r11.bufferPool
            r5.release(r0)
            if (r3 == 0) goto L_0x00e9
            r11.flushPendingEncryptedWrites(r12)
        L_0x00e9:
            if (r4 != 0) goto L_0x010b
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r3 = "SSLEngine already closed"
            r0.<init>(r3)
        L_0x00f2:
            java.util.Queue<org.jboss.netty.handler.ssl.SslHandler$PendingWrite> r3 = r11.pendingUnencryptedWrites
            monitor-enter(r3)
            java.util.Queue<org.jboss.netty.handler.ssl.SslHandler$PendingWrite> r4 = r11.pendingUnencryptedWrites     // Catch:{ all -> 0x0108 }
            java.lang.Object r4 = r4.poll()     // Catch:{ all -> 0x0108 }
            org.jboss.netty.handler.ssl.SslHandler$PendingWrite r4 = (org.jboss.netty.handler.ssl.SslHandler.PendingWrite) r4     // Catch:{ all -> 0x0108 }
            if (r4 != 0) goto L_0x0101
            monitor-exit(r3)     // Catch:{ all -> 0x0108 }
            goto L_0x010b
        L_0x0101:
            monitor-exit(r3)     // Catch:{ all -> 0x0108 }
            org.jboss.netty.channel.ChannelFuture r3 = r4.future
            r3.setFailure(r0)
            goto L_0x00f2
        L_0x0108:
            r12 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0108 }
            throw r12
        L_0x010b:
            if (r1 == 0) goto L_0x0117
            org.jboss.netty.buffer.ChannelBuffer r7 = org.jboss.netty.buffer.ChannelBuffers.EMPTY_BUFFER
            r8 = 0
            r9 = 0
            r4 = r11
            r5 = r12
            r6 = r13
            r4.unwrap(r5, r6, r7, r8, r9)
        L_0x0117:
            if (r2 != 0) goto L_0x011d
            org.jboss.netty.channel.ChannelFuture r2 = org.jboss.netty.channel.Channels.succeededFuture(r13)
        L_0x011d:
            return r2
        L_0x011e:
            r2 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x011e }
            throw r2     // Catch:{ all -> 0x0121 }
        L_0x0121:
            r2 = move-exception
            boolean r6 = r7.hasRemaining()     // Catch:{ all -> 0x012e }
            if (r6 != 0) goto L_0x012d
            java.util.Queue<org.jboss.netty.handler.ssl.SslHandler$PendingWrite> r6 = r11.pendingUnencryptedWrites     // Catch:{ all -> 0x012e }
            r6.remove()     // Catch:{ all -> 0x012e }
        L_0x012d:
            throw r2     // Catch:{ all -> 0x012e }
        L_0x012e:
            r2 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x012e }
            throw r2     // Catch:{ SSLException -> 0x0137, all -> 0x0131 }
        L_0x0131:
            r13 = move-exception
            r1 = r4
            goto L_0x013d
        L_0x0134:
            r13 = move-exception
            r1 = 1
            goto L_0x013d
        L_0x0137:
            r2 = move-exception
            r11.setHandshakeFailure(r13, r2)     // Catch:{ all -> 0x013c }
            throw r2     // Catch:{ all -> 0x013c }
        L_0x013c:
            r13 = move-exception
        L_0x013d:
            org.jboss.netty.handler.ssl.SslBufferPool r2 = r11.bufferPool
            r2.release(r0)
            if (r3 == 0) goto L_0x0147
            r11.flushPendingEncryptedWrites(r12)
        L_0x0147:
            if (r1 != 0) goto L_0x0169
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "SSLEngine already closed"
            r12.<init>(r0)
        L_0x0150:
            java.util.Queue<org.jboss.netty.handler.ssl.SslHandler$PendingWrite> r0 = r11.pendingUnencryptedWrites
            monitor-enter(r0)
            java.util.Queue<org.jboss.netty.handler.ssl.SslHandler$PendingWrite> r1 = r11.pendingUnencryptedWrites     // Catch:{ all -> 0x0166 }
            java.lang.Object r1 = r1.poll()     // Catch:{ all -> 0x0166 }
            org.jboss.netty.handler.ssl.SslHandler$PendingWrite r1 = (org.jboss.netty.handler.ssl.SslHandler.PendingWrite) r1     // Catch:{ all -> 0x0166 }
            if (r1 == 0) goto L_0x0164
            monitor-exit(r0)     // Catch:{ all -> 0x0166 }
            org.jboss.netty.channel.ChannelFuture r0 = r1.future
            r0.setFailure(r12)
            goto L_0x0150
        L_0x0164:
            monitor-exit(r0)     // Catch:{ all -> 0x0166 }
            goto L_0x0169
        L_0x0166:
            r12 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0166 }
            throw r12
        L_0x0169:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.handler.ssl.SslHandler.wrap(org.jboss.netty.channel.ChannelHandlerContext, org.jboss.netty.channel.Channel):org.jboss.netty.channel.ChannelFuture");
    }

    private ChannelFuture wrapNonAppData(ChannelHandlerContext channelHandlerContext, Channel channel) throws SSLException {
        SSLEngineResult wrap;
        ByteBuffer acquire = this.bufferPool.acquire();
        ChannelFuture channelFuture = null;
        do {
            try {
                synchronized (this.handshakeLock) {
                    wrap = this.engine.wrap(EMPTY_BUFFER, acquire);
                }
                if (wrap.bytesProduced() > 0) {
                    acquire.flip();
                    ChannelBuffer buffer = ChannelBuffers.buffer(acquire.remaining());
                    buffer.writeBytes(acquire.array(), 0, buffer.capacity());
                    acquire.clear();
                    ChannelFuture future = Channels.future(channel);
                    future.addListener(new ChannelFutureListener() {
                        public void operationComplete(ChannelFuture channelFuture) throws Exception {
                            if (channelFuture.getCause() instanceof ClosedChannelException) {
                                synchronized (SslHandler.this.ignoreClosedChannelExceptionLock) {
                                    SslHandler.this.ignoreClosedChannelException++;
                                }
                            }
                        }
                    });
                    Channels.write(channelHandlerContext, future, (Object) buffer);
                    channelFuture = future;
                }
                HandshakeStatus handshakeStatus = wrap.getHandshakeStatus();
                handleRenegotiation(handshakeStatus);
                int i = AnonymousClass3.$SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[handshakeStatus.ordinal()];
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            runDelegatedTasks();
                        } else if (i == 4) {
                            setHandshakeSuccess(channel);
                            runDelegatedTasks();
                        } else if (i != 5) {
                            throw new IllegalStateException("Unexpected handshake status: " + handshakeStatus);
                        }
                    } else if (!Thread.holdsLock(this.handshakeLock)) {
                        unwrap(channelHandlerContext, channel, ChannelBuffers.EMPTY_BUFFER, 0, 0);
                    }
                }
            } catch (SSLException e2) {
                try {
                    setHandshakeFailure(channel, e2);
                    throw e2;
                } catch (Throwable th) {
                    this.bufferPool.release(acquire);
                    throw th;
                }
            }
        } while (wrap.bytesProduced() != 0);
        this.bufferPool.release(acquire);
        return channelFuture == null ? Channels.succeededFuture(channel) : channelFuture;
    }

    public void afterAdd(ChannelHandlerContext channelHandlerContext) throws Exception {
    }

    public void afterRemove(ChannelHandlerContext channelHandlerContext) throws Exception {
    }

    public void beforeAdd(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.ctx = channelHandlerContext;
    }

    public void beforeRemove(ChannelHandlerContext channelHandlerContext) throws Exception {
    }

    public void channelDisconnected(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) throws Exception {
        String str;
        synchronized (this.handshakeLock) {
            if (this.handshaking) {
                this.handshakeFuture.setFailure(new ClosedChannelException());
            }
        }
        try {
            super.channelDisconnected(channelHandlerContext, channelStateEvent);
        } finally {
            unwrap(channelHandlerContext, channelStateEvent.getChannel(), ChannelBuffers.EMPTY_BUFFER, 0, 0);
            this.engine.closeOutbound();
            if (!this.sentCloseNotify.get() && this.handshaken) {
                try {
                    this.engine.closeInbound();
                } catch (SSLException e2) {
                    str = "Failed to clean up SSLEngine.";
                    logger.debug(str, e2);
                }
            }
        }
    }

    public ChannelFuture close() {
        ChannelHandlerContext channelHandlerContext = this.ctx;
        Channel channel = channelHandlerContext.getChannel();
        try {
            this.engine.closeOutbound();
            return wrapNonAppData(channelHandlerContext, channel);
        } catch (SSLException e2) {
            return Channels.failedFuture(channel, e2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x007a, code lost:
        if (r5 <= r0) goto L_0x007c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a4 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object decode(org.jboss.netty.channel.ChannelHandlerContext r8, org.jboss.netty.channel.Channel r9, org.jboss.netty.buffer.ChannelBuffer r10) throws java.lang.Exception {
        /*
            r7 = this;
            int r0 = r10.readableBytes()
            r1 = 0
            r2 = 5
            if (r0 >= r2) goto L_0x0009
            return r1
        L_0x0009:
            int r0 = r10.readerIndex()
            short r0 = r10.getUnsignedByte(r0)
            r3 = 1
            switch(r0) {
                case 20: goto L_0x0017;
                case 21: goto L_0x0017;
                case 22: goto L_0x0017;
                case 23: goto L_0x0017;
                default: goto L_0x0015;
            }
        L_0x0015:
            r0 = 0
            goto L_0x0018
        L_0x0017:
            r0 = 1
        L_0x0018:
            r4 = 10
            r5 = 3
            if (r0 == 0) goto L_0x003d
            int r6 = r10.readerIndex()
            int r6 = r6 + r3
            short r6 = r10.getUnsignedByte(r6)
            if (r6 < r5) goto L_0x003c
            if (r6 >= r4) goto L_0x003c
            int r6 = r10.readerIndex()
            int r6 = r6 + r5
            short r5 = r10.getShort(r6)
            r6 = 65535(0xffff, float:9.1834E-41)
            r5 = r5 & r6
            int r5 = r5 + r2
            if (r5 > r2) goto L_0x003e
            r0 = 0
            goto L_0x003e
        L_0x003c:
            r0 = 0
        L_0x003d:
            r5 = 0
        L_0x003e:
            if (r0 != 0) goto L_0x009e
            int r0 = r10.readerIndex()
            short r0 = r10.getUnsignedByte(r0)
            r0 = r0 & 128(0x80, float:1.8E-43)
            r2 = 2
            if (r0 == 0) goto L_0x004f
            r0 = 2
            goto L_0x0050
        L_0x004f:
            r0 = 3
        L_0x0050:
            int r6 = r10.readerIndex()
            int r6 = r6 + r0
            int r6 = r6 + r3
            short r6 = r10.getUnsignedByte(r6)
            if (r6 < r2) goto L_0x007c
            if (r6 >= r4) goto L_0x007c
            if (r0 != r2) goto L_0x006d
            int r4 = r10.readerIndex()
            short r4 = r10.getShort(r4)
            r4 = r4 & 32767(0x7fff, float:4.5916E-41)
            int r4 = r4 + r2
            r5 = r4
            goto L_0x007a
        L_0x006d:
            int r2 = r10.readerIndex()
            short r2 = r10.getShort(r2)
            r2 = r2 & 16383(0x3fff, float:2.2957E-41)
            int r2 = r2 + 3
            r5 = r2
        L_0x007a:
            if (r5 > r0) goto L_0x007d
        L_0x007c:
            r3 = 0
        L_0x007d:
            if (r3 == 0) goto L_0x0080
            goto L_0x009e
        L_0x0080:
            javax.net.ssl.SSLException r8 = new javax.net.ssl.SSLException
            java.lang.String r9 = "not an SSL/TLS record: "
            java.lang.StringBuilder r9 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r9)
            java.lang.String r0 = org.jboss.netty.buffer.ChannelBuffers.hexDump(r10)
            r9.append(r0)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            int r9 = r10.readableBytes()
            r10.skipBytes(r9)
            throw r8
        L_0x009e:
            int r0 = r10.readableBytes()
            if (r0 >= r5) goto L_0x00a5
            return r1
        L_0x00a5:
            int r4 = r10.readerIndex()
            r10.skipBytes(r5)
            r0 = r7
            r1 = r8
            r2 = r9
            r3 = r10
            org.jboss.netty.buffer.ChannelBuffer r8 = r0.unwrap(r1, r2, r3, r4, r5)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.handler.ssl.SslHandler.decode(org.jboss.netty.channel.ChannelHandlerContext, org.jboss.netty.channel.Channel, org.jboss.netty.buffer.ChannelBuffer):java.lang.Object");
    }

    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, ExceptionEvent exceptionEvent) throws Exception {
        Throwable cause = exceptionEvent.getCause();
        if (cause instanceof IOException) {
            if (cause instanceof ClosedChannelException) {
                synchronized (this.ignoreClosedChannelExceptionLock) {
                    if (this.ignoreClosedChannelException > 0) {
                        this.ignoreClosedChannelException--;
                        logger.debug("Swallowing an exception raised while writing non-app data", cause);
                        return;
                    }
                }
            } else if (this.engine.isOutboundDone()) {
                if (IGNORABLE_ERROR_MESSAGE.matcher(String.valueOf(cause.getMessage()).toLowerCase()).matches()) {
                    logger.debug("Swallowing a 'connection reset by peer / broken pipe' error occurred while writing 'closure_notify'", cause);
                    Channels.close(channelHandlerContext, Channels.succeededFuture(exceptionEvent.getChannel()));
                    return;
                }
            }
        }
        channelHandlerContext.sendUpstream(exceptionEvent);
    }

    public SSLEngine getEngine() {
        return this.engine;
    }

    public void handleDownstream(ChannelHandlerContext channelHandlerContext, ChannelEvent channelEvent) throws Exception {
        PendingWrite pendingWrite;
        if (channelEvent instanceof ChannelStateEvent) {
            ChannelStateEvent channelStateEvent = (ChannelStateEvent) channelEvent;
            int ordinal = channelStateEvent.getState().ordinal();
            if ((ordinal == 0 || ordinal == 1 || ordinal == 2) && (Boolean.FALSE.equals(channelStateEvent.getValue()) || channelStateEvent.getValue() == null)) {
                closeOutboundAndChannel(channelHandlerContext, channelStateEvent);
                return;
            }
        }
        if (!(channelEvent instanceof MessageEvent)) {
            channelHandlerContext.sendDownstream(channelEvent);
            return;
        }
        MessageEvent messageEvent = (MessageEvent) channelEvent;
        if (!(messageEvent.getMessage() instanceof ChannelBuffer)) {
            channelHandlerContext.sendDownstream(channelEvent);
        } else if (!this.startTls || !this.sentFirstMessage.compareAndSet(false, true)) {
            ChannelBuffer channelBuffer = (ChannelBuffer) messageEvent.getMessage();
            if (channelBuffer.readable()) {
                pendingWrite = new PendingWrite(channelEvent.getFuture(), channelBuffer.toByteBuffer(channelBuffer.readerIndex(), channelBuffer.readableBytes()));
            } else {
                pendingWrite = new PendingWrite(channelEvent.getFuture(), null);
            }
            synchronized (this.pendingUnencryptedWrites) {
                this.pendingUnencryptedWrites.offer(pendingWrite);
            }
            wrap(channelHandlerContext, channelEvent.getChannel());
        } else {
            channelHandlerContext.sendDownstream(channelEvent);
        }
    }

    public ChannelFuture handshake() {
        ChannelHandlerContext channelHandlerContext;
        Channel channel;
        ChannelFuture channelFuture;
        if (!this.handshaken || isEnableRenegotiation()) {
            channelHandlerContext = this.ctx;
            channel = channelHandlerContext.getChannel();
            synchronized (this.handshakeLock) {
                if (this.handshaking) {
                    ChannelFuture channelFuture2 = this.handshakeFuture;
                    return channelFuture2;
                }
                this.handshaking = true;
                try {
                    this.engine.beginHandshake();
                    runDelegatedTasks();
                    channelFuture = Channels.future(channel);
                    this.handshakeFuture = channelFuture;
                } catch (SSLException e2) {
                    channelFuture = Channels.failedFuture(channel, e2);
                    this.handshakeFuture = channelFuture;
                }
            }
        } else {
            throw new IllegalStateException("renegotiation disabled");
        }
        return channelFuture;
        try {
            wrapNonAppData(channelHandlerContext, channel);
        } catch (SSLException e3) {
            channelFuture.setFailure(e3);
        }
        return channelFuture;
    }

    public boolean isEnableRenegotiation() {
        return this.enableRenegotiation;
    }

    public void setEnableRenegotiation(boolean z) {
        this.enableRenegotiation = z;
    }

    public SslHandler(SSLEngine sSLEngine, SslBufferPool sslBufferPool) {
        this(sSLEngine, sslBufferPool, (Executor) ImmediateExecutor.INSTANCE);
    }

    public SslHandler(SSLEngine sSLEngine, boolean z) {
        this(sSLEngine, getDefaultBufferPool(), z);
    }

    public SslHandler(SSLEngine sSLEngine, SslBufferPool sslBufferPool, boolean z) {
        this(sSLEngine, sslBufferPool, z, ImmediateExecutor.INSTANCE);
    }

    public SslHandler(SSLEngine sSLEngine, Executor executor) {
        this(sSLEngine, getDefaultBufferPool(), executor);
    }

    public SslHandler(SSLEngine sSLEngine, SslBufferPool sslBufferPool, Executor executor) {
        this(sSLEngine, sslBufferPool, false, executor);
    }

    @Deprecated
    public ChannelFuture close(Channel channel) {
        return close();
    }

    public SslHandler(SSLEngine sSLEngine, boolean z, Executor executor) {
        this(sSLEngine, getDefaultBufferPool(), z, executor);
    }

    public SslHandler(SSLEngine sSLEngine, SslBufferPool sslBufferPool, boolean z, Executor executor) {
        this.handshakeLock = new Object();
        this.sentFirstMessage = new AtomicBoolean();
        this.sentCloseNotify = new AtomicBoolean();
        this.ignoreClosedChannelExceptionLock = new Object();
        this.pendingUnencryptedWrites = new LinkedList();
        this.pendingEncryptedWrites = new LinkedTransferQueue();
        this.pendingEncryptedWritesLock = new NonReentrantLock();
        if (sSLEngine == null) {
            throw new NullPointerException("engine");
        } else if (sslBufferPool == null) {
            throw new NullPointerException("bufferPool");
        } else if (executor != null) {
            this.engine = sSLEngine;
            this.bufferPool = sslBufferPool;
            this.delegatedTaskExecutor = executor;
            this.startTls = z;
        } else {
            throw new NullPointerException("delegatedTaskExecutor");
        }
    }

    @Deprecated
    public ChannelFuture handshake(Channel channel) {
        return handshake();
    }
}
