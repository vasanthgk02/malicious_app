package org.jboss.netty.channel;

public class FailedChannelFuture extends CompleteChannelFuture {
    public final Throwable cause;

    public FailedChannelFuture(Channel channel, Throwable th) {
        super(channel);
        if (th != null) {
            this.cause = th;
            return;
        }
        throw new NullPointerException("cause");
    }

    public Throwable getCause() {
        return this.cause;
    }

    public boolean isSuccess() {
        return false;
    }
}
