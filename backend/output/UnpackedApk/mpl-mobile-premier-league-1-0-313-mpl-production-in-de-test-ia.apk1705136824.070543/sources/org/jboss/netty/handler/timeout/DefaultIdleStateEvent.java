package org.jboss.netty.handler.timeout;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.Channels;

public class DefaultIdleStateEvent implements IdleStateEvent {
    public final Channel channel;
    public final long lastActivityTimeMillis;
    public final IdleState state;

    public DefaultIdleStateEvent(Channel channel2, IdleState idleState, long j) {
        if (channel2 == null) {
            throw new NullPointerException("channel");
        } else if (idleState != null) {
            this.channel = channel2;
            this.state = idleState;
            this.lastActivityTimeMillis = j;
        } else {
            throw new NullPointerException("state");
        }
    }

    public Channel getChannel() {
        return this.channel;
    }

    public ChannelFuture getFuture() {
        return Channels.succeededFuture(getChannel());
    }

    public long getLastActivityTimeMillis() {
        return this.lastActivityTimeMillis;
    }

    public IdleState getState() {
        return this.state;
    }

    public String toString() {
        return getChannel().toString() + ' ' + getState() + " since " + DateFormat.getDateTimeInstance(3, 3, Locale.US).format(new Date(getLastActivityTimeMillis()));
    }
}
