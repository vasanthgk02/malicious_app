package org.jboss.netty.channel;

import com.android.tools.r8.GeneratedOutlineSupport;

public class DefaultWriteCompletionEvent implements WriteCompletionEvent {
    public final Channel channel;
    public final long writtenAmount;

    public DefaultWriteCompletionEvent(Channel channel2, long j) {
        if (channel2 == null) {
            throw new NullPointerException("channel");
        } else if (j > 0) {
            this.channel = channel2;
            this.writtenAmount = j;
        } else {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline45("writtenAmount must be a positive integer: ", j));
        }
    }

    public Channel getChannel() {
        return this.channel;
    }

    public ChannelFuture getFuture() {
        return Channels.succeededFuture(getChannel());
    }

    public long getWrittenAmount() {
        return this.writtenAmount;
    }

    public String toString() {
        String obj = getChannel().toString();
        StringBuilder sb = new StringBuilder(obj.length() + 32);
        sb.append(obj);
        sb.append(" WRITTEN_AMOUNT: ");
        sb.append(getWrittenAmount());
        return sb.toString();
    }
}
