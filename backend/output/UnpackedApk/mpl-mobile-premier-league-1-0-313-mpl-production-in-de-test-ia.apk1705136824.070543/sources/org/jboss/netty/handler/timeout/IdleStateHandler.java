package org.jboss.netty.handler.timeout;

import com.razorpay.AnalyticsConstants;
import java.util.concurrent.TimeUnit;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.LifeCycleAwareChannelHandler;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelUpstreamHandler;
import org.jboss.netty.channel.WriteCompletionEvent;
import org.jboss.netty.util.ExternalResourceReleasable;
import org.jboss.netty.util.Timeout;
import org.jboss.netty.util.Timer;
import org.jboss.netty.util.TimerTask;

public class IdleStateHandler extends SimpleChannelUpstreamHandler implements LifeCycleAwareChannelHandler, ExternalResourceReleasable {
    public final long allIdleTimeMillis;
    public volatile Timeout allIdleTimeout;
    public volatile long lastReadTime;
    public volatile long lastWriteTime;
    public final long readerIdleTimeMillis;
    public volatile Timeout readerIdleTimeout;
    public final Timer timer;
    public final long writerIdleTimeMillis;
    public volatile Timeout writerIdleTimeout;

    public final class AllIdleTimeoutTask implements TimerTask {
        public final ChannelHandlerContext ctx;

        public AllIdleTimeoutTask(ChannelHandlerContext channelHandlerContext) {
            this.ctx = channelHandlerContext;
        }

        public void run(Timeout timeout) throws Exception {
            if (!timeout.isCancelled() && this.ctx.getChannel().isOpen()) {
                long currentTimeMillis = System.currentTimeMillis();
                long max = Math.max(IdleStateHandler.this.lastReadTime, IdleStateHandler.this.lastWriteTime);
                IdleStateHandler idleStateHandler = IdleStateHandler.this;
                long j = idleStateHandler.allIdleTimeMillis;
                long j2 = j - (currentTimeMillis - max);
                if (j2 <= 0) {
                    idleStateHandler.allIdleTimeout = idleStateHandler.timer.newTimeout(this, j, TimeUnit.MILLISECONDS);
                    try {
                        IdleStateHandler.this.channelIdle(this.ctx, IdleState.ALL_IDLE, max);
                    } catch (Throwable th) {
                        Channels.fireExceptionCaught(this.ctx, th);
                    }
                } else {
                    idleStateHandler.allIdleTimeout = idleStateHandler.timer.newTimeout(this, j2, TimeUnit.MILLISECONDS);
                }
            }
        }
    }

    public final class ReaderIdleTimeoutTask implements TimerTask {
        public final ChannelHandlerContext ctx;

        public ReaderIdleTimeoutTask(ChannelHandlerContext channelHandlerContext) {
            this.ctx = channelHandlerContext;
        }

        public void run(Timeout timeout) throws Exception {
            if (!timeout.isCancelled() && this.ctx.getChannel().isOpen()) {
                long currentTimeMillis = System.currentTimeMillis();
                long j = IdleStateHandler.this.lastReadTime;
                IdleStateHandler idleStateHandler = IdleStateHandler.this;
                long j2 = idleStateHandler.readerIdleTimeMillis;
                long j3 = j2 - (currentTimeMillis - j);
                if (j3 <= 0) {
                    idleStateHandler.readerIdleTimeout = idleStateHandler.timer.newTimeout(this, j2, TimeUnit.MILLISECONDS);
                    try {
                        IdleStateHandler.this.channelIdle(this.ctx, IdleState.READER_IDLE, j);
                    } catch (Throwable th) {
                        Channels.fireExceptionCaught(this.ctx, th);
                    }
                } else {
                    idleStateHandler.readerIdleTimeout = idleStateHandler.timer.newTimeout(this, j3, TimeUnit.MILLISECONDS);
                }
            }
        }
    }

    public final class WriterIdleTimeoutTask implements TimerTask {
        public final ChannelHandlerContext ctx;

        public WriterIdleTimeoutTask(ChannelHandlerContext channelHandlerContext) {
            this.ctx = channelHandlerContext;
        }

        public void run(Timeout timeout) throws Exception {
            if (!timeout.isCancelled() && this.ctx.getChannel().isOpen()) {
                long currentTimeMillis = System.currentTimeMillis();
                long j = IdleStateHandler.this.lastWriteTime;
                IdleStateHandler idleStateHandler = IdleStateHandler.this;
                long j2 = idleStateHandler.writerIdleTimeMillis;
                long j3 = j2 - (currentTimeMillis - j);
                if (j3 <= 0) {
                    idleStateHandler.writerIdleTimeout = idleStateHandler.timer.newTimeout(this, j2, TimeUnit.MILLISECONDS);
                    try {
                        IdleStateHandler.this.channelIdle(this.ctx, IdleState.WRITER_IDLE, j);
                    } catch (Throwable th) {
                        Channels.fireExceptionCaught(this.ctx, th);
                    }
                } else {
                    idleStateHandler.writerIdleTimeout = idleStateHandler.timer.newTimeout(this, j3, TimeUnit.MILLISECONDS);
                }
            }
        }
    }

    public IdleStateHandler(Timer timer2, int i, int i2, int i3) {
        this(timer2, (long) i, (long) i2, (long) i3, TimeUnit.SECONDS);
    }

    private void destroy() {
        if (this.readerIdleTimeout != null) {
            this.readerIdleTimeout.cancel();
            this.readerIdleTimeout = null;
        }
        if (this.writerIdleTimeout != null) {
            this.writerIdleTimeout.cancel();
            this.writerIdleTimeout = null;
        }
        if (this.allIdleTimeout != null) {
            this.allIdleTimeout.cancel();
            this.allIdleTimeout = null;
        }
    }

    private void initialize(ChannelHandlerContext channelHandlerContext) {
        long currentTimeMillis = System.currentTimeMillis();
        this.lastWriteTime = currentTimeMillis;
        this.lastReadTime = currentTimeMillis;
        if (this.readerIdleTimeMillis > 0) {
            this.readerIdleTimeout = this.timer.newTimeout(new ReaderIdleTimeoutTask(channelHandlerContext), this.readerIdleTimeMillis, TimeUnit.MILLISECONDS);
        }
        if (this.writerIdleTimeMillis > 0) {
            this.writerIdleTimeout = this.timer.newTimeout(new WriterIdleTimeoutTask(channelHandlerContext), this.writerIdleTimeMillis, TimeUnit.MILLISECONDS);
        }
        if (this.allIdleTimeMillis > 0) {
            this.allIdleTimeout = this.timer.newTimeout(new AllIdleTimeoutTask(channelHandlerContext), this.allIdleTimeMillis, TimeUnit.MILLISECONDS);
        }
    }

    public void afterAdd(ChannelHandlerContext channelHandlerContext) throws Exception {
    }

    public void afterRemove(ChannelHandlerContext channelHandlerContext) throws Exception {
    }

    public void beforeAdd(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (channelHandlerContext.getPipeline().isAttached()) {
            initialize(channelHandlerContext);
        }
    }

    public void beforeRemove(ChannelHandlerContext channelHandlerContext) throws Exception {
        destroy();
    }

    public void channelClosed(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) throws Exception {
        destroy();
        channelHandlerContext.sendUpstream(channelStateEvent);
    }

    public void channelIdle(ChannelHandlerContext channelHandlerContext, IdleState idleState, long j) throws Exception {
        channelHandlerContext.sendUpstream(new DefaultIdleStateEvent(channelHandlerContext.getChannel(), idleState, j));
    }

    public void channelOpen(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) throws Exception {
        initialize(channelHandlerContext);
        channelHandlerContext.sendUpstream(channelStateEvent);
    }

    public void messageReceived(ChannelHandlerContext channelHandlerContext, MessageEvent messageEvent) throws Exception {
        this.lastReadTime = System.currentTimeMillis();
        channelHandlerContext.sendUpstream(messageEvent);
    }

    public void releaseExternalResources() {
        this.timer.stop();
    }

    public void writeComplete(ChannelHandlerContext channelHandlerContext, WriteCompletionEvent writeCompletionEvent) throws Exception {
        if (writeCompletionEvent.getWrittenAmount() > 0) {
            this.lastWriteTime = System.currentTimeMillis();
        }
        channelHandlerContext.sendUpstream(writeCompletionEvent);
    }

    public IdleStateHandler(Timer timer2, long j, long j2, long j3, TimeUnit timeUnit) {
        if (timer2 == null) {
            throw new NullPointerException(AnalyticsConstants.TIMER);
        } else if (timeUnit != null) {
            this.timer = timer2;
            if (j <= 0) {
                this.readerIdleTimeMillis = 0;
            } else {
                this.readerIdleTimeMillis = Math.max(timeUnit.toMillis(j), 1);
            }
            if (j2 <= 0) {
                this.writerIdleTimeMillis = 0;
            } else {
                this.writerIdleTimeMillis = Math.max(timeUnit.toMillis(j2), 1);
            }
            if (j3 <= 0) {
                this.allIdleTimeMillis = 0;
            } else {
                this.allIdleTimeMillis = Math.max(timeUnit.toMillis(j3), 1);
            }
        } else {
            throw new NullPointerException("unit");
        }
    }
}
