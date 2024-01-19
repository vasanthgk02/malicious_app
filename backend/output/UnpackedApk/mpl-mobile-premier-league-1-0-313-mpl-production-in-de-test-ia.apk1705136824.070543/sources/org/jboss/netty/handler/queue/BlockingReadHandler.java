package org.jboss.netty.handler.queue;

import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import org.jboss.netty.channel.ChannelEvent;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelUpstreamHandler;
import org.jboss.netty.util.internal.IoWorkerRunnable;
import org.jboss.netty.util.internal.LinkedTransferQueue;

public class BlockingReadHandler<E> extends SimpleChannelUpstreamHandler {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public volatile boolean closed;
    public final BlockingQueue<ChannelEvent> queue;

    public BlockingReadHandler() {
        this(new LinkedTransferQueue());
    }

    private void detectDeadLock() {
        if (IoWorkerRunnable.IN_IO_THREAD.get().booleanValue()) {
            throw new IllegalStateException("read*(...) in I/O thread causes a dead lock or sudden performance drop. Implement a state machine or call read*() from a different thread.");
        }
    }

    private E getMessage(MessageEvent messageEvent) {
        return messageEvent.getMessage();
    }

    public void channelClosed(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) throws Exception {
        this.closed = true;
        getQueue().put(channelStateEvent);
    }

    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, ExceptionEvent exceptionEvent) throws Exception {
        getQueue().put(exceptionEvent);
    }

    public BlockingQueue<ChannelEvent> getQueue() {
        return this.queue;
    }

    public boolean isClosed() {
        return this.closed;
    }

    public void messageReceived(ChannelHandlerContext channelHandlerContext, MessageEvent messageEvent) throws Exception {
        getQueue().put(messageEvent);
    }

    public E read() throws IOException, InterruptedException {
        ChannelEvent readEvent = readEvent();
        if (readEvent == null) {
            return null;
        }
        if (readEvent instanceof MessageEvent) {
            return getMessage((MessageEvent) readEvent);
        }
        if (readEvent instanceof ExceptionEvent) {
            throw ((IOException) new IOException().initCause(((ExceptionEvent) readEvent).getCause()));
        }
        throw new IllegalStateException();
    }

    public ChannelEvent readEvent() throws InterruptedException {
        detectDeadLock();
        if (isClosed() && getQueue().isEmpty()) {
            return null;
        }
        ChannelEvent take = getQueue().take();
        if (take instanceof ChannelStateEvent) {
            return null;
        }
        return take;
    }

    public BlockingReadHandler(BlockingQueue<ChannelEvent> blockingQueue) {
        if (blockingQueue != null) {
            this.queue = blockingQueue;
            return;
        }
        throw new NullPointerException("queue");
    }

    public ChannelEvent readEvent(long j, TimeUnit timeUnit) throws InterruptedException, BlockingReadTimeoutException {
        detectDeadLock();
        if (isClosed() && getQueue().isEmpty()) {
            return null;
        }
        ChannelEvent poll = getQueue().poll(j, timeUnit);
        if (poll == null) {
            throw new BlockingReadTimeoutException();
        } else if (poll instanceof ChannelStateEvent) {
            return null;
        } else {
            return poll;
        }
    }

    public E read(long j, TimeUnit timeUnit) throws IOException, InterruptedException {
        ChannelEvent readEvent = readEvent(j, timeUnit);
        if (readEvent == null) {
            return null;
        }
        if (readEvent instanceof MessageEvent) {
            return getMessage((MessageEvent) readEvent);
        }
        if (readEvent instanceof ExceptionEvent) {
            throw ((IOException) new IOException().initCause(((ExceptionEvent) readEvent).getCause()));
        }
        throw new IllegalStateException();
    }
}
