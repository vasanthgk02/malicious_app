package org.jboss.netty.channel.socket.nio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.SocketAddress;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.AbstractChannel;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelException;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelSink;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.socket.DatagramChannel;
import org.jboss.netty.channel.socket.nio.SocketSendBufferPool.SendBuffer;
import org.jboss.netty.util.internal.LinkedTransferQueue;
import org.jboss.netty.util.internal.ThreadLocalBoolean;

public class NioDatagramChannel extends AbstractChannel implements DatagramChannel {
    public final NioDatagramChannelConfig config;
    public SendBuffer currentWriteBuffer;
    public MessageEvent currentWriteEvent;
    public final java.nio.channels.DatagramChannel datagramChannel;
    public final AtomicInteger highWaterMarkCounter = new AtomicInteger();
    public boolean inWriteNowLoop;
    public final Object interestOpsLock = new Object();
    public volatile InetSocketAddress localAddress;
    public volatile InetSocketAddress remoteAddress;
    public final NioDatagramWorker worker;
    public final Queue<MessageEvent> writeBufferQueue = new WriteRequestQueue();
    public final AtomicInteger writeBufferSize = new AtomicInteger();
    public final Object writeLock = new Object();
    public boolean writeSuspended;
    public final Runnable writeTask = new WriteTask();
    public final AtomicBoolean writeTaskInTaskQueue = new AtomicBoolean();

    public final class WriteRequestQueue extends LinkedTransferQueue<MessageEvent> {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        public static final long serialVersionUID = 5057413071460766376L;
        public final ThreadLocalBoolean notifying = new ThreadLocalBoolean();

        static {
            Class<NioDatagramChannel> cls = NioDatagramChannel.class;
        }

        public WriteRequestQueue() {
        }

        private int getMessageSize(MessageEvent messageEvent) {
            Object message = messageEvent.getMessage();
            if (message instanceof ChannelBuffer) {
                return ((ChannelBuffer) message).readableBytes();
            }
            return 0;
        }

        public boolean offer(MessageEvent messageEvent) {
            super.offer(messageEvent);
            int messageSize = getMessageSize(messageEvent);
            int addAndGet = NioDatagramChannel.this.writeBufferSize.addAndGet(messageSize);
            int writeBufferHighWaterMark = NioDatagramChannel.this.getConfig().getWriteBufferHighWaterMark();
            if (addAndGet >= writeBufferHighWaterMark && addAndGet - messageSize < writeBufferHighWaterMark) {
                NioDatagramChannel.this.highWaterMarkCounter.incrementAndGet();
                if (!((Boolean) this.notifying.get()).booleanValue()) {
                    this.notifying.set(Boolean.TRUE);
                    Channels.fireChannelInterestChanged((Channel) NioDatagramChannel.this);
                    this.notifying.set(Boolean.FALSE);
                }
            }
            return true;
        }

        public MessageEvent poll() {
            MessageEvent messageEvent = (MessageEvent) super.poll();
            if (messageEvent != null) {
                int messageSize = getMessageSize(messageEvent);
                int addAndGet = NioDatagramChannel.this.writeBufferSize.addAndGet(-messageSize);
                int writeBufferLowWaterMark = NioDatagramChannel.this.getConfig().getWriteBufferLowWaterMark();
                if ((addAndGet == 0 || addAndGet < writeBufferLowWaterMark) && addAndGet + messageSize >= writeBufferLowWaterMark) {
                    NioDatagramChannel.this.highWaterMarkCounter.decrementAndGet();
                    if (!((Boolean) this.notifying.get()).booleanValue()) {
                        this.notifying.set(Boolean.TRUE);
                        Channels.fireChannelInterestChanged((Channel) NioDatagramChannel.this);
                        this.notifying.set(Boolean.FALSE);
                    }
                }
            }
            return messageEvent;
        }
    }

    public final class WriteTask implements Runnable {
        public WriteTask() {
        }

        public void run() {
            NioDatagramChannel.this.writeTaskInTaskQueue.set(false);
            NioDatagramChannel nioDatagramChannel = NioDatagramChannel.this;
            nioDatagramChannel.worker.writeFromTaskLoop(nioDatagramChannel);
        }
    }

    public NioDatagramChannel(ChannelFactory channelFactory, ChannelPipeline channelPipeline, ChannelSink channelSink, NioDatagramWorker nioDatagramWorker) {
        super(null, channelFactory, channelPipeline, channelSink);
        this.worker = nioDatagramWorker;
        this.datagramChannel = openNonBlockingChannel();
        this.config = new DefaultNioDatagramChannelConfig(this.datagramChannel.socket());
        Channels.fireChannelOpen((Channel) this);
    }

    private java.nio.channels.DatagramChannel openNonBlockingChannel() {
        try {
            java.nio.channels.DatagramChannel open = java.nio.channels.DatagramChannel.open();
            open.configureBlocking(false);
            return open;
        } catch (IOException e2) {
            throw new ChannelException("Failed to open a DatagramChannel.", e2);
        }
    }

    public java.nio.channels.DatagramChannel getDatagramChannel() {
        return this.datagramChannel;
    }

    public int getInterestOps() {
        int i;
        if (!isOpen()) {
            return 4;
        }
        int rawInterestOps = getRawInterestOps();
        int i2 = this.writeBufferSize.get();
        if (i2 == 0 || (this.highWaterMarkCounter.get() <= 0 ? i2 < getConfig().getWriteBufferHighWaterMark() : i2 < getConfig().getWriteBufferLowWaterMark())) {
            i = rawInterestOps & -5;
        } else {
            i = rawInterestOps | 4;
        }
        return i;
    }

    public int getRawInterestOps() {
        return super.getInterestOps();
    }

    public boolean isBound() {
        return isOpen() && this.datagramChannel.socket().isBound();
    }

    public boolean isConnected() {
        return this.datagramChannel.isConnected();
    }

    public void joinGroup(InetAddress inetAddress) {
        throw new UnsupportedOperationException();
    }

    public void leaveGroup(InetAddress inetAddress) {
        throw new UnsupportedOperationException();
    }

    public boolean setClosed() {
        return super.setClosed();
    }

    public void setRawInterestOpsNow(int i) {
        super.setInterestOpsNow(i);
    }

    public ChannelFuture write(Object obj, SocketAddress socketAddress) {
        if (socketAddress == null || socketAddress.equals(getRemoteAddress())) {
            return super.write(obj, null);
        }
        return super.write(obj, socketAddress);
    }

    public InetSocketAddress getLocalAddress() {
        InetSocketAddress inetSocketAddress = this.localAddress;
        if (inetSocketAddress != null) {
            return inetSocketAddress;
        }
        try {
            InetSocketAddress inetSocketAddress2 = (InetSocketAddress) this.datagramChannel.socket().getLocalSocketAddress();
            this.localAddress = inetSocketAddress2;
            return inetSocketAddress2;
        } catch (Throwable unused) {
            return null;
        }
    }

    public InetSocketAddress getRemoteAddress() {
        InetSocketAddress inetSocketAddress = this.remoteAddress;
        if (inetSocketAddress != null) {
            return inetSocketAddress;
        }
        try {
            InetSocketAddress inetSocketAddress2 = (InetSocketAddress) this.datagramChannel.socket().getRemoteSocketAddress();
            this.remoteAddress = inetSocketAddress2;
            return inetSocketAddress2;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void joinGroup(InetSocketAddress inetSocketAddress, NetworkInterface networkInterface) {
        throw new UnsupportedOperationException();
    }

    public void leaveGroup(InetSocketAddress inetSocketAddress, NetworkInterface networkInterface) {
        throw new UnsupportedOperationException();
    }

    public NioDatagramChannelConfig getConfig() {
        return this.config;
    }
}
