package org.jboss.netty.handler.timeout;

import com.razorpay.AnalyticsConstants;
import java.util.concurrent.TimeUnit;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelFutureListener;
import org.jboss.netty.channel.ChannelHandler.Sharable;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelDownstreamHandler;
import org.jboss.netty.util.ExternalResourceReleasable;
import org.jboss.netty.util.Timeout;
import org.jboss.netty.util.Timer;
import org.jboss.netty.util.TimerTask;

@Sharable
public class WriteTimeoutHandler extends SimpleChannelDownstreamHandler implements ExternalResourceReleasable {
    public static final WriteTimeoutException EXCEPTION = new WriteTimeoutException();
    public final long timeoutMillis;
    public final Timer timer;

    public static final class TimeoutCanceller implements ChannelFutureListener {
        public final Timeout timeout;

        public TimeoutCanceller(Timeout timeout2) {
            this.timeout = timeout2;
        }

        public void operationComplete(ChannelFuture channelFuture) throws Exception {
            this.timeout.cancel();
        }
    }

    public final class WriteTimeoutTask implements TimerTask {
        public final ChannelHandlerContext ctx;
        public final ChannelFuture future;

        public WriteTimeoutTask(ChannelHandlerContext channelHandlerContext, ChannelFuture channelFuture) {
            this.ctx = channelHandlerContext;
            this.future = channelFuture;
        }

        public void run(Timeout timeout) throws Exception {
            if (!timeout.isCancelled() && this.ctx.getChannel().isOpen() && this.future.setFailure(WriteTimeoutHandler.EXCEPTION)) {
                try {
                    WriteTimeoutHandler.this.writeTimedOut(this.ctx);
                } catch (Throwable th) {
                    Channels.fireExceptionCaught(this.ctx, th);
                }
            }
        }
    }

    public WriteTimeoutHandler(Timer timer2, int i) {
        this(timer2, (long) i, TimeUnit.SECONDS);
    }

    public long getTimeoutMillis(MessageEvent messageEvent) {
        return this.timeoutMillis;
    }

    public void releaseExternalResources() {
        this.timer.stop();
    }

    public void writeRequested(ChannelHandlerContext channelHandlerContext, MessageEvent messageEvent) throws Exception {
        long timeoutMillis2 = getTimeoutMillis(messageEvent);
        if (timeoutMillis2 > 0) {
            ChannelFuture future = messageEvent.getFuture();
            future.addListener(new TimeoutCanceller(this.timer.newTimeout(new WriteTimeoutTask(channelHandlerContext, future), timeoutMillis2, TimeUnit.MILLISECONDS)));
        }
        super.writeRequested(channelHandlerContext, messageEvent);
    }

    public void writeTimedOut(ChannelHandlerContext channelHandlerContext) throws Exception {
        Channels.fireExceptionCaught(channelHandlerContext, (Throwable) EXCEPTION);
    }

    public WriteTimeoutHandler(Timer timer2, long j, TimeUnit timeUnit) {
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
