package org.jboss.netty.channel.socket.nio;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.AbstractChannel;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelSink;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.socket.SocketChannel;
import org.jboss.netty.channel.socket.nio.SocketSendBufferPool.SendBuffer;
import org.jboss.netty.util.internal.LinkedTransferQueue;
import org.jboss.netty.util.internal.ThreadLocalBoolean;

public class NioSocketChannel extends AbstractChannel implements SocketChannel {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int ST_BOUND = 1;
    public static final int ST_CLOSED = -1;
    public static final int ST_CONNECTED = 2;
    public static final int ST_OPEN = 0;
    public final NioSocketChannelConfig config;
    public SendBuffer currentWriteBuffer;
    public MessageEvent currentWriteEvent;
    public final AtomicInteger highWaterMarkCounter = new AtomicInteger();
    public boolean inWriteNowLoop;
    public final Object interestOpsLock = new Object();
    public volatile InetSocketAddress localAddress;
    public volatile InetSocketAddress remoteAddress;
    public final java.nio.channels.SocketChannel socket;
    public volatile int state = 0;
    public final NioWorker worker;
    public final Queue<MessageEvent> writeBuffer = new WriteRequestQueue();
    public final AtomicInteger writeBufferSize = new AtomicInteger();
    public final Object writeLock = new Object();
    public boolean writeSuspended;
    public final Runnable writeTask = new WriteTask();
    public final AtomicBoolean writeTaskInTaskQueue = new AtomicBoolean();

    public final class WriteRequestQueue extends LinkedTransferQueue<MessageEvent> {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        public static final long serialVersionUID = -246694024103520626L;
        public final ThreadLocalBoolean notifying = new ThreadLocalBoolean();

        static {
            Class<NioSocketChannel> cls = NioSocketChannel.class;
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
            int addAndGet = NioSocketChannel.this.writeBufferSize.addAndGet(messageSize);
            int writeBufferHighWaterMark = NioSocketChannel.this.getConfig().getWriteBufferHighWaterMark();
            if (addAndGet >= writeBufferHighWaterMark && addAndGet - messageSize < writeBufferHighWaterMark) {
                NioSocketChannel.this.highWaterMarkCounter.incrementAndGet();
                if (!((Boolean) this.notifying.get()).booleanValue()) {
                    this.notifying.set(Boolean.TRUE);
                    Channels.fireChannelInterestChanged((Channel) NioSocketChannel.this);
                    this.notifying.set(Boolean.FALSE);
                }
            }
            return true;
        }

        public MessageEvent poll() {
            MessageEvent messageEvent = (MessageEvent) super.poll();
            if (messageEvent != null) {
                int messageSize = getMessageSize(messageEvent);
                int addAndGet = NioSocketChannel.this.writeBufferSize.addAndGet(-messageSize);
                int writeBufferLowWaterMark = NioSocketChannel.this.getConfig().getWriteBufferLowWaterMark();
                if ((addAndGet == 0 || addAndGet < writeBufferLowWaterMark) && addAndGet + messageSize >= writeBufferLowWaterMark) {
                    NioSocketChannel.this.highWaterMarkCounter.decrementAndGet();
                    if (!((Boolean) this.notifying.get()).booleanValue()) {
                        this.notifying.set(Boolean.TRUE);
                        Channels.fireChannelInterestChanged((Channel) NioSocketChannel.this);
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
            NioSocketChannel.this.writeTaskInTaskQueue.set(false);
            NioSocketChannel nioSocketChannel = NioSocketChannel.this;
            nioSocketChannel.worker.writeFromTaskLoop(nioSocketChannel);
        }
    }

    static {
        Class<NioSocketChannel> cls = NioSocketChannel.class;
    }

    public NioSocketChannel(Channel channel, ChannelFactory channelFactory, ChannelPipeline channelPipeline, ChannelSink channelSink, java.nio.channels.SocketChannel socketChannel, NioWorker nioWorker) {
        super(channel, channelFactory, channelPipeline, channelSink);
        this.socket = socketChannel;
        this.worker = nioWorker;
        this.config = new DefaultNioSocketChannelConfig(socketChannel.socket());
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
        return this.state >= 1;
    }

    public boolean isConnected() {
        return this.state == 2;
    }

    public boolean isOpen() {
        return this.state >= 0;
    }

    public final void setBound() {
        this.state = 1;
    }

    public boolean setClosed() {
        this.state = -1;
        return super.setClosed();
    }

    public final void setConnected() {
        if (this.state != -1) {
            this.state = 2;
        }
    }

    public void setRawInterestOpsNow(int i) {
        super.setInterestOpsNow(i);
    }

    public ChannelFuture write(Object obj, SocketAddress socketAddress) {
        if (socketAddress == null || socketAddress.equals(getRemoteAddress())) {
            return super.write(obj, null);
        }
        return getUnsupportedOperationFuture();
    }

    public InetSocketAddress getLocalAddress() {
        InetSocketAddress inetSocketAddress = this.localAddress;
        if (inetSocketAddress != null) {
            return inetSocketAddress;
        }
        try {
            InetSocketAddress inetSocketAddress2 = (InetSocketAddress) this.socket.socket().getLocalSocketAddress();
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
            InetSocketAddress inetSocketAddress2 = (InetSocketAddress) this.socket.socket().getRemoteSocketAddress();
            this.remoteAddress = inetSocketAddress2;
            return inetSocketAddress2;
        } catch (Throwable unused) {
            return null;
        }
    }

    public NioSocketChannelConfig getConfig() {
        return this.config;
    }
}
