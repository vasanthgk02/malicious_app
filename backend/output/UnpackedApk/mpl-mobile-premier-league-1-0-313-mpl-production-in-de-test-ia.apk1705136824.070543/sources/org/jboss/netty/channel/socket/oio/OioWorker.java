package org.jboss.netty.channel.socket.oio;

import java.io.OutputStream;
import java.net.SocketException;
import java.nio.channels.ClosedChannelException;
import java.util.regex.Pattern;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.Channels;

public class OioWorker implements Runnable {
    public static final Pattern SOCKET_CLOSED_MESSAGE = Pattern.compile("^.*(?:Socket.*closed).*$", 2);
    public final OioSocketChannel channel;

    public OioWorker(OioSocketChannel oioSocketChannel) {
        this.channel = oioSocketChannel;
    }

    public static void close(OioSocketChannel oioSocketChannel, ChannelFuture channelFuture) {
        boolean isConnected = oioSocketChannel.isConnected();
        boolean isBound = oioSocketChannel.isBound();
        try {
            oioSocketChannel.socket.close();
            if (oioSocketChannel.setClosed()) {
                channelFuture.setSuccess();
                if (isConnected) {
                    Thread currentThread = Thread.currentThread();
                    Thread thread = oioSocketChannel.workerThread;
                    if (!(thread == null || currentThread == thread)) {
                        thread.interrupt();
                    }
                    Channels.fireChannelDisconnected((Channel) oioSocketChannel);
                }
                if (isBound) {
                    Channels.fireChannelUnbound((Channel) oioSocketChannel);
                }
                Channels.fireChannelClosed((Channel) oioSocketChannel);
                return;
            }
            channelFuture.setSuccess();
        } catch (Throwable th) {
            channelFuture.setFailure(th);
            Channels.fireExceptionCaught((Channel) oioSocketChannel, th);
        }
    }

    public static void setInterestOps(OioSocketChannel oioSocketChannel, ChannelFuture channelFuture, int i) {
        int interestOps = (i & -5) | (oioSocketChannel.getInterestOps() & 4);
        try {
            boolean z = false;
            if (oioSocketChannel.getInterestOps() != interestOps) {
                if ((interestOps & 1) != 0) {
                    oioSocketChannel.setInterestOpsNow(1);
                } else {
                    oioSocketChannel.setInterestOpsNow(0);
                }
                z = true;
            }
            channelFuture.setSuccess();
            if (z) {
                synchronized (oioSocketChannel.interestOpsLock) {
                    oioSocketChannel.setInterestOpsNow(interestOps);
                    Thread currentThread = Thread.currentThread();
                    Thread thread = oioSocketChannel.workerThread;
                    if (!(thread == null || currentThread == thread)) {
                        thread.interrupt();
                    }
                }
                Channels.fireChannelInterestChanged((Channel) oioSocketChannel);
            }
        } catch (Throwable th) {
            channelFuture.setFailure(th);
            Channels.fireExceptionCaught((Channel) oioSocketChannel, th);
        }
    }

    public static void write(OioSocketChannel oioSocketChannel, ChannelFuture channelFuture, Object obj) {
        OutputStream outputStream = oioSocketChannel.getOutputStream();
        if (outputStream == null) {
            ClosedChannelException closedChannelException = new ClosedChannelException();
            channelFuture.setFailure(closedChannelException);
            Channels.fireExceptionCaught((Channel) oioSocketChannel, (Throwable) closedChannelException);
            return;
        }
        try {
            ChannelBuffer channelBuffer = (ChannelBuffer) obj;
            int readableBytes = channelBuffer.readableBytes();
            synchronized (outputStream) {
                channelBuffer.getBytes(channelBuffer.readerIndex(), outputStream, readableBytes);
            }
            Channels.fireWriteComplete((Channel) oioSocketChannel, (long) readableBytes);
            channelFuture.setSuccess();
        } catch (Throwable th) {
            th = th;
            if ((th instanceof SocketException) && SOCKET_CLOSED_MESSAGE.matcher(String.valueOf(th.getMessage())).matches()) {
                th = new ClosedChannelException();
            }
            channelFuture.setFailure(th);
            Channels.fireExceptionCaught((Channel) oioSocketChannel, (Throwable) th);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:8|9|10|11|(1:41)(2:43|39)|6|5) */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x001b, code lost:
        continue;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x002b */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0033 A[EDGE_INSN: B:41:0x0033->B:13:0x0033 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x001b A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r6 = this;
            org.jboss.netty.channel.socket.oio.OioSocketChannel r0 = r6.channel
            java.lang.Thread r1 = java.lang.Thread.currentThread()
            r0.workerThread = r1
            org.jboss.netty.channel.socket.oio.OioSocketChannel r0 = r6.channel
            java.io.PushbackInputStream r0 = r0.getInputStream()
        L_0x000e:
            org.jboss.netty.channel.socket.oio.OioSocketChannel r1 = r6.channel
            boolean r1 = r1.isOpen()
            if (r1 == 0) goto L_0x0072
            org.jboss.netty.channel.socket.oio.OioSocketChannel r1 = r6.channel
            java.lang.Object r1 = r1.interestOpsLock
            monitor-enter(r1)
        L_0x001b:
            org.jboss.netty.channel.socket.oio.OioSocketChannel r2 = r6.channel     // Catch:{ all -> 0x006f }
            boolean r2 = r2.isReadable()     // Catch:{ all -> 0x006f }
            if (r2 != 0) goto L_0x0033
            org.jboss.netty.channel.socket.oio.OioSocketChannel r2 = r6.channel     // Catch:{ InterruptedException -> 0x002b }
            java.lang.Object r2 = r2.interestOpsLock     // Catch:{ InterruptedException -> 0x002b }
            r2.wait()     // Catch:{ InterruptedException -> 0x002b }
            goto L_0x001b
        L_0x002b:
            org.jboss.netty.channel.socket.oio.OioSocketChannel r2 = r6.channel     // Catch:{ all -> 0x006f }
            boolean r2 = r2.isOpen()     // Catch:{ all -> 0x006f }
            if (r2 != 0) goto L_0x001b
        L_0x0033:
            monitor-exit(r1)     // Catch:{ all -> 0x006f }
            int r1 = r0.available()     // Catch:{ all -> 0x005e }
            if (r1 <= 0) goto L_0x0053
            byte[] r1 = new byte[r1]     // Catch:{ all -> 0x005e }
            int r2 = r0.read(r1)     // Catch:{ all -> 0x005e }
            org.jboss.netty.channel.socket.oio.OioSocketChannel r3 = r6.channel
            org.jboss.netty.channel.socket.SocketChannelConfig r4 = r3.getConfig()
            org.jboss.netty.buffer.ChannelBufferFactory r4 = r4.getBufferFactory()
            r5 = 0
            org.jboss.netty.buffer.ChannelBuffer r1 = r4.getBuffer(r1, r5, r2)
            org.jboss.netty.channel.Channels.fireMessageReceived(r3, r1)
            goto L_0x000e
        L_0x0053:
            int r1 = r0.read()     // Catch:{ all -> 0x005e }
            if (r1 >= 0) goto L_0x005a
            goto L_0x0072
        L_0x005a:
            r0.unread(r1)     // Catch:{ all -> 0x005e }
            goto L_0x000e
        L_0x005e:
            r0 = move-exception
            org.jboss.netty.channel.socket.oio.OioSocketChannel r1 = r6.channel
            java.net.Socket r1 = r1.socket
            boolean r1 = r1.isClosed()
            if (r1 != 0) goto L_0x0072
            org.jboss.netty.channel.socket.oio.OioSocketChannel r1 = r6.channel
            org.jboss.netty.channel.Channels.fireExceptionCaught(r1, r0)
            goto L_0x0072
        L_0x006f:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x006f }
            throw r0
        L_0x0072:
            org.jboss.netty.channel.socket.oio.OioSocketChannel r0 = r6.channel
            r1 = 0
            r0.workerThread = r1
            org.jboss.netty.channel.socket.oio.OioSocketChannel r0 = r6.channel
            org.jboss.netty.channel.ChannelFuture r1 = org.jboss.netty.channel.Channels.succeededFuture(r0)
            close(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.channel.socket.oio.OioWorker.run():void");
    }
}
