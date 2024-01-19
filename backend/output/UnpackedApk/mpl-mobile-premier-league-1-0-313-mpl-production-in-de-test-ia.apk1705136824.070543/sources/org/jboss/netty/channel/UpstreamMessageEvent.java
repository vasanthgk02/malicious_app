package org.jboss.netty.channel;

import java.net.SocketAddress;
import org.jboss.netty.util.internal.StringUtil;

public class UpstreamMessageEvent implements MessageEvent {
    public final Channel channel;
    public final Object message;
    public final SocketAddress remoteAddress;

    public UpstreamMessageEvent(Channel channel2, Object obj, SocketAddress socketAddress) {
        if (channel2 == null) {
            throw new NullPointerException("channel");
        } else if (obj != null) {
            this.channel = channel2;
            this.message = obj;
            if (socketAddress != null) {
                this.remoteAddress = socketAddress;
            } else {
                this.remoteAddress = channel2.getRemoteAddress();
            }
        } else {
            throw new NullPointerException("message");
        }
    }

    public Channel getChannel() {
        return this.channel;
    }

    public ChannelFuture getFuture() {
        return Channels.succeededFuture(getChannel());
    }

    public Object getMessage() {
        return this.message;
    }

    public SocketAddress getRemoteAddress() {
        return this.remoteAddress;
    }

    public String toString() {
        if (getRemoteAddress() == getChannel().getRemoteAddress()) {
            return getChannel().toString() + " RECEIVED: " + StringUtil.stripControlCharacters(getMessage());
        }
        return getChannel().toString() + " RECEIVED: " + StringUtil.stripControlCharacters(getMessage()) + " from " + getRemoteAddress();
    }
}
