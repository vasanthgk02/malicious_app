package org.jboss.netty.channel.socket.oio;

import java.net.DatagramPacket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.Channels;

public class OioDatagramWorker implements Runnable {
    public final OioDatagramChannel channel;

    public OioDatagramWorker(OioDatagramChannel oioDatagramChannel) {
        this.channel = oioDatagramChannel;
    }

    public static void close(OioDatagramChannel oioDatagramChannel, ChannelFuture channelFuture) {
        boolean isConnected = oioDatagramChannel.isConnected();
        boolean isBound = oioDatagramChannel.isBound();
        try {
            oioDatagramChannel.socket.close();
            if (oioDatagramChannel.setClosed()) {
                channelFuture.setSuccess();
                if (isConnected) {
                    Thread currentThread = Thread.currentThread();
                    Thread thread = oioDatagramChannel.workerThread;
                    if (!(thread == null || currentThread == thread)) {
                        thread.interrupt();
                    }
                    Channels.fireChannelDisconnected((Channel) oioDatagramChannel);
                }
                if (isBound) {
                    Channels.fireChannelUnbound((Channel) oioDatagramChannel);
                }
                Channels.fireChannelClosed((Channel) oioDatagramChannel);
                return;
            }
            channelFuture.setSuccess();
        } catch (Throwable th) {
            channelFuture.setFailure(th);
            Channels.fireExceptionCaught((Channel) oioDatagramChannel, th);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:4|(2:6|7)|8|9|14) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x002b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void disconnect(org.jboss.netty.channel.socket.oio.OioDatagramChannel r3, org.jboss.netty.channel.ChannelFuture r4) {
        /*
            boolean r0 = r3.isConnected()
            java.net.MulticastSocket r1 = r3.socket     // Catch:{ all -> 0x002f }
            r1.disconnect()     // Catch:{ all -> 0x002f }
            r4.setSuccess()     // Catch:{ all -> 0x002f }
            if (r0 == 0) goto L_0x0036
            java.lang.Thread r0 = r3.workerThread     // Catch:{ all -> 0x002f }
            if (r0 == 0) goto L_0x002b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ SecurityException -> 0x002b }
            r1.<init>()     // Catch:{ SecurityException -> 0x002b }
            java.lang.String r2 = "Old I/O datagram worker ("
            r1.append(r2)     // Catch:{ SecurityException -> 0x002b }
            r1.append(r3)     // Catch:{ SecurityException -> 0x002b }
            r2 = 41
            r1.append(r2)     // Catch:{ SecurityException -> 0x002b }
            java.lang.String r1 = r1.toString()     // Catch:{ SecurityException -> 0x002b }
            r0.setName(r1)     // Catch:{ SecurityException -> 0x002b }
        L_0x002b:
            org.jboss.netty.channel.Channels.fireChannelDisconnected(r3)     // Catch:{ all -> 0x002f }
            goto L_0x0036
        L_0x002f:
            r0 = move-exception
            r4.setFailure(r0)
            org.jboss.netty.channel.Channels.fireExceptionCaught(r3, r0)
        L_0x0036:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.channel.socket.oio.OioDatagramWorker.disconnect(org.jboss.netty.channel.socket.oio.OioDatagramChannel, org.jboss.netty.channel.ChannelFuture):void");
    }

    public static void setInterestOps(OioDatagramChannel oioDatagramChannel, ChannelFuture channelFuture, int i) {
        int interestOps = (i & -5) | (oioDatagramChannel.getInterestOps() & 4);
        try {
            boolean z = false;
            if (oioDatagramChannel.getInterestOps() != interestOps) {
                if ((interestOps & 1) != 0) {
                    oioDatagramChannel.setInterestOpsNow(1);
                } else {
                    oioDatagramChannel.setInterestOpsNow(0);
                }
                z = true;
            }
            channelFuture.setSuccess();
            if (z) {
                synchronized (oioDatagramChannel.interestOpsLock) {
                    oioDatagramChannel.setInterestOpsNow(interestOps);
                    Thread currentThread = Thread.currentThread();
                    Thread thread = oioDatagramChannel.workerThread;
                    if (!(thread == null || currentThread == thread)) {
                        thread.interrupt();
                    }
                }
                Channels.fireChannelInterestChanged((Channel) oioDatagramChannel);
            }
        } catch (Throwable th) {
            channelFuture.setFailure(th);
            Channels.fireExceptionCaught((Channel) oioDatagramChannel, th);
        }
    }

    public static void write(OioDatagramChannel oioDatagramChannel, ChannelFuture channelFuture, Object obj, SocketAddress socketAddress) {
        DatagramPacket datagramPacket;
        try {
            ChannelBuffer channelBuffer = (ChannelBuffer) obj;
            int readableBytes = channelBuffer.readableBytes();
            ByteBuffer byteBuffer = channelBuffer.toByteBuffer();
            if (byteBuffer.hasArray()) {
                datagramPacket = new DatagramPacket(byteBuffer.array(), byteBuffer.arrayOffset(), readableBytes);
            } else {
                byte[] bArr = new byte[readableBytes];
                channelBuffer.getBytes(0, bArr);
                datagramPacket = new DatagramPacket(bArr, readableBytes);
            }
            if (socketAddress != null) {
                datagramPacket.setSocketAddress(socketAddress);
            }
            oioDatagramChannel.socket.send(datagramPacket);
            Channels.fireWriteComplete((Channel) oioDatagramChannel, (long) readableBytes);
            channelFuture.setSuccess();
        } catch (Throwable th) {
            channelFuture.setFailure(th);
            Channels.fireExceptionCaught((Channel) oioDatagramChannel, th);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:8|9|10|11|(1:34)(2:36|32)|6|5) */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0019, code lost:
        continue;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0029 */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0031 A[EDGE_INSN: B:34:0x0031->B:13:0x0031 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0019 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r7 = this;
            org.jboss.netty.channel.socket.oio.OioDatagramChannel r0 = r7.channel
            java.lang.Thread r1 = java.lang.Thread.currentThread()
            r0.workerThread = r1
            org.jboss.netty.channel.socket.oio.OioDatagramChannel r0 = r7.channel
            java.net.MulticastSocket r0 = r0.socket
        L_0x000c:
            org.jboss.netty.channel.socket.oio.OioDatagramChannel r1 = r7.channel
            boolean r1 = r1.isOpen()
            if (r1 == 0) goto L_0x007b
            org.jboss.netty.channel.socket.oio.OioDatagramChannel r1 = r7.channel
            java.lang.Object r1 = r1.interestOpsLock
            monitor-enter(r1)
        L_0x0019:
            org.jboss.netty.channel.socket.oio.OioDatagramChannel r2 = r7.channel     // Catch:{ all -> 0x0078 }
            boolean r2 = r2.isReadable()     // Catch:{ all -> 0x0078 }
            if (r2 != 0) goto L_0x0031
            org.jboss.netty.channel.socket.oio.OioDatagramChannel r2 = r7.channel     // Catch:{ InterruptedException -> 0x0029 }
            java.lang.Object r2 = r2.interestOpsLock     // Catch:{ InterruptedException -> 0x0029 }
            r2.wait()     // Catch:{ InterruptedException -> 0x0029 }
            goto L_0x0019
        L_0x0029:
            org.jboss.netty.channel.socket.oio.OioDatagramChannel r2 = r7.channel     // Catch:{ all -> 0x0078 }
            boolean r2 = r2.isOpen()     // Catch:{ all -> 0x0078 }
            if (r2 != 0) goto L_0x0019
        L_0x0031:
            monitor-exit(r1)     // Catch:{ all -> 0x0078 }
            org.jboss.netty.channel.socket.oio.OioDatagramChannel r1 = r7.channel
            org.jboss.netty.channel.socket.DatagramChannelConfig r1 = r1.getConfig()
            org.jboss.netty.channel.ReceiveBufferSizePredictor r1 = r1.getReceiveBufferSizePredictor()
            int r1 = r1.nextReceiveBufferSize()
            byte[] r2 = new byte[r1]
            java.net.DatagramPacket r3 = new java.net.DatagramPacket
            r3.<init>(r2, r1)
            r0.receive(r3)     // Catch:{ InterruptedIOException -> 0x0076, all -> 0x0065 }
            org.jboss.netty.channel.socket.oio.OioDatagramChannel r1 = r7.channel
            org.jboss.netty.channel.socket.DatagramChannelConfig r4 = r1.getConfig()
            org.jboss.netty.buffer.ChannelBufferFactory r4 = r4.getBufferFactory()
            r5 = 0
            int r6 = r3.getLength()
            org.jboss.netty.buffer.ChannelBuffer r2 = r4.getBuffer(r2, r5, r6)
            java.net.SocketAddress r3 = r3.getSocketAddress()
            org.jboss.netty.channel.Channels.fireMessageReceived(r1, r2, r3)
            goto L_0x000c
        L_0x0065:
            r0 = move-exception
            org.jboss.netty.channel.socket.oio.OioDatagramChannel r1 = r7.channel
            java.net.MulticastSocket r1 = r1.socket
            boolean r1 = r1.isClosed()
            if (r1 != 0) goto L_0x007b
            org.jboss.netty.channel.socket.oio.OioDatagramChannel r1 = r7.channel
            org.jboss.netty.channel.Channels.fireExceptionCaught(r1, r0)
            goto L_0x007b
        L_0x0076:
            goto L_0x000c
        L_0x0078:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0078 }
            throw r0
        L_0x007b:
            org.jboss.netty.channel.socket.oio.OioDatagramChannel r0 = r7.channel
            r1 = 0
            r0.workerThread = r1
            org.jboss.netty.channel.socket.oio.OioDatagramChannel r0 = r7.channel
            org.jboss.netty.channel.ChannelFuture r1 = org.jboss.netty.channel.Channels.succeededFuture(r0)
            close(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.channel.socket.oio.OioDatagramWorker.run():void");
    }
}
