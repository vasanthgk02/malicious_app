package org.jboss.netty.channel;

public class SucceededChannelFuture extends CompleteChannelFuture {
    public SucceededChannelFuture(Channel channel) {
        super(channel);
    }

    public Throwable getCause() {
        return null;
    }

    public boolean isSuccess() {
        return true;
    }
}
