package org.jboss.netty.channel;

public class DefaultChildChannelStateEvent implements ChildChannelStateEvent {
    public final Channel childChannel;
    public final Channel parentChannel;

    public DefaultChildChannelStateEvent(Channel channel, Channel channel2) {
        if (channel == null) {
            throw new NullPointerException("parentChannel");
        } else if (channel2 != null) {
            this.parentChannel = channel;
            this.childChannel = channel2;
        } else {
            throw new NullPointerException("childChannel");
        }
    }

    public Channel getChannel() {
        return this.parentChannel;
    }

    public Channel getChildChannel() {
        return this.childChannel;
    }

    public ChannelFuture getFuture() {
        return Channels.succeededFuture(getChannel());
    }

    public String toString() {
        String obj = getChannel().toString();
        StringBuilder sb = new StringBuilder(obj.length() + 32);
        sb.append(obj);
        sb.append(getChildChannel().isOpen() ? " CHILD_OPEN: " : " CHILD_CLOSED: ");
        sb.append(getChildChannel().getId());
        return sb.toString();
    }
}
