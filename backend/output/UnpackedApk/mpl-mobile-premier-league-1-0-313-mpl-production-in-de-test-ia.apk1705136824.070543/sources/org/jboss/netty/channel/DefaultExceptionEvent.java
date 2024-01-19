package org.jboss.netty.channel;

import org.jboss.netty.util.internal.StackTraceSimplifier;

public class DefaultExceptionEvent implements ExceptionEvent {
    public final Throwable cause;
    public final Channel channel;

    public DefaultExceptionEvent(Channel channel2, Throwable th) {
        if (channel2 == null) {
            throw new NullPointerException("channel");
        } else if (th != null) {
            this.channel = channel2;
            this.cause = th;
            StackTraceSimplifier.simplify(th);
        } else {
            throw new NullPointerException("cause");
        }
    }

    public Throwable getCause() {
        return this.cause;
    }

    public Channel getChannel() {
        return this.channel;
    }

    public ChannelFuture getFuture() {
        return Channels.succeededFuture(getChannel());
    }

    public String toString() {
        return getChannel().toString() + " EXCEPTION: " + this.cause;
    }
}
