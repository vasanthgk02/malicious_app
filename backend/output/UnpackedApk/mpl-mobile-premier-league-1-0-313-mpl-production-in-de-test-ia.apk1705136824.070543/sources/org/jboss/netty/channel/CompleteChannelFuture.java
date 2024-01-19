package org.jboss.netty.channel;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.concurrent.TimeUnit;
import org.jboss.netty.logging.InternalLogger;
import org.jboss.netty.logging.InternalLoggerFactory;

public abstract class CompleteChannelFuture implements ChannelFuture {
    public static final InternalLogger logger = InternalLoggerFactory.getInstance(CompleteChannelFuture.class);
    public final Channel channel;

    public CompleteChannelFuture(Channel channel2) {
        if (channel2 != null) {
            this.channel = channel2;
            return;
        }
        throw new NullPointerException("channel");
    }

    public void addListener(ChannelFutureListener channelFutureListener) {
        try {
            channelFutureListener.operationComplete(this);
        } catch (Throwable th) {
            InternalLogger internalLogger = logger;
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("An exception was thrown by ");
            outline73.append(ChannelFutureListener.class.getSimpleName());
            outline73.append(".");
            internalLogger.warn(outline73.toString(), th);
        }
    }

    public ChannelFuture await() throws InterruptedException {
        if (!Thread.interrupted()) {
            return this;
        }
        throw new InterruptedException();
    }

    public ChannelFuture awaitUninterruptibly() {
        return this;
    }

    public boolean awaitUninterruptibly(long j) {
        return true;
    }

    public boolean awaitUninterruptibly(long j, TimeUnit timeUnit) {
        return true;
    }

    public boolean cancel() {
        return false;
    }

    public Channel getChannel() {
        return this.channel;
    }

    public boolean isCancelled() {
        return false;
    }

    public boolean isDone() {
        return true;
    }

    public void removeListener(ChannelFutureListener channelFutureListener) {
    }

    public boolean setFailure(Throwable th) {
        return false;
    }

    public boolean setProgress(long j, long j2, long j3) {
        return false;
    }

    public boolean setSuccess() {
        return false;
    }

    public boolean await(long j, TimeUnit timeUnit) throws InterruptedException {
        if (!Thread.interrupted()) {
            return true;
        }
        throw new InterruptedException();
    }

    public boolean await(long j) throws InterruptedException {
        if (!Thread.interrupted()) {
            return true;
        }
        throw new InterruptedException();
    }
}
