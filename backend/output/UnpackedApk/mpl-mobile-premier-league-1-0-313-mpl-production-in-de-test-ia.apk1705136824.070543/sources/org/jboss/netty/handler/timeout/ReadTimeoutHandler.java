package org.jboss.netty.handler.timeout;

import com.razorpay.AnalyticsConstants;
import java.util.concurrent.TimeUnit;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.LifeCycleAwareChannelHandler;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelUpstreamHandler;
import org.jboss.netty.util.ExternalResourceReleasable;
import org.jboss.netty.util.Timeout;
import org.jboss.netty.util.Timer;
import org.jboss.netty.util.TimerTask;

public class ReadTimeoutHandler extends SimpleChannelUpstreamHandler implements LifeCycleAwareChannelHandler, ExternalResourceReleasable {
    public static final ReadTimeoutException EXCEPTION = new ReadTimeoutException();
    public volatile long lastReadTime;
    public volatile ReadTimeoutTask task;
    public volatile Timeout timeout;
    public final long timeoutMillis;
    public final Timer timer;

    public final class ReadTimeoutTask implements TimerTask {
        public final ChannelHandlerContext ctx;

        public ReadTimeoutTask(ChannelHandlerContext channelHandlerContext) {
            this.ctx = channelHandlerContext;
        }

        public void run(Timeout timeout) throws Exception {
            if (!timeout.isCancelled() && this.ctx.getChannel().isOpen()) {
                long currentTimeMillis = System.currentTimeMillis();
                ReadTimeoutHandler readTimeoutHandler = ReadTimeoutHandler.this;
                long j = readTimeoutHandler.timeoutMillis - (currentTimeMillis - readTimeoutHandler.lastReadTime);
                if (j <= 0) {
                    ReadTimeoutHandler readTimeoutHandler2 = ReadTimeoutHandler.this;
                    readTimeoutHandler2.timeout = readTimeoutHandler2.timer.newTimeout(this, readTimeoutHandler2.timeoutMillis, TimeUnit.MILLISECONDS);
                    try {
                        ReadTimeoutHandler.this.readTimedOut(this.ctx);
                    } catch (Throwable th) {
                        Channels.fireExceptionCaught(this.ctx, th);
                    }
                } else {
                    ReadTimeoutHandler readTimeoutHandler3 = ReadTimeoutHandler.this;
                    readTimeoutHandler3.timeout = readTimeoutHandler3.timer.newTimeout(this, j, TimeUnit.MILLISECONDS);
                }
            }
        }
    }

    public ReadTimeoutHandler(Timer timer2, int i) {
        this(timer2, (long) i, TimeUnit.SECONDS);
    }

    private void destroy() {
        if (this.timeout != null) {
            this.timeout.cancel();
        }
        this.timeout = null;
        this.task = null;
    }

    private void initialize(ChannelHandlerContext channelHandlerContext) {
        updateLastReadTime();
        this.task = new ReadTimeoutTask(channelHandlerContext);
        if (this.timeoutMillis > 0) {
            this.timeout = this.timer.newTimeout(this.task, this.timeoutMillis, TimeUnit.MILLISECONDS);
        }
    }

    private void updateLastReadTime() {
        this.lastReadTime = System.currentTimeMillis();
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

    public void channelOpen(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) throws Exception {
        initialize(channelHandlerContext);
        channelHandlerContext.sendUpstream(channelStateEvent);
    }

    public void messageReceived(ChannelHandlerContext channelHandlerContext, MessageEvent messageEvent) throws Exception {
        updateLastReadTime();
        channelHandlerContext.sendUpstream(messageEvent);
    }

    public void readTimedOut(ChannelHandlerContext channelHandlerContext) throws Exception {
        Channels.fireExceptionCaught(channelHandlerContext, (Throwable) EXCEPTION);
    }

    public void releaseExternalResources() {
        this.timer.stop();
    }

    public ReadTimeoutHandler(Timer timer2, long j, TimeUnit timeUnit) {
        if (timer2 == null) {
            throw new NullPointerException(AnalyticsConstants.TIMER);
        } else if (timeUnit != null) {
            this.timer = timer2;
            if (j <= 0) {
                this.timeoutMillis = 0;
            } else {
                this.timeoutMillis = Math.max(timeUnit.toMillis(j), 1);
            }
        } else {
            throw new NullPointerException("unit");
        }
    }
}
