package org.jboss.netty.handler.codec.http;

import org.jboss.netty.buffer.ChannelBuffer;

public class DefaultHttpChunk implements HttpChunk {
    public ChannelBuffer content;
    public boolean last;

    public DefaultHttpChunk(ChannelBuffer channelBuffer) {
        setContent(channelBuffer);
    }

    public ChannelBuffer getContent() {
        return this.content;
    }

    public boolean isLast() {
        return this.last;
    }

    public void setContent(ChannelBuffer channelBuffer) {
        if (channelBuffer != null) {
            this.last = !channelBuffer.readable();
            this.content = channelBuffer;
            return;
        }
        throw new NullPointerException("content");
    }
}
