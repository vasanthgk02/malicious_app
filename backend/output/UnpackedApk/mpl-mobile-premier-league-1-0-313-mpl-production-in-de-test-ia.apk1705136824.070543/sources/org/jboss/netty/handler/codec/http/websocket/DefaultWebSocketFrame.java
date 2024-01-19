package org.jboss.netty.handler.codec.http.websocket;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.util.CharsetUtil;
import sfs2x.client.entities.invitation.InvitationReply;

public class DefaultWebSocketFrame implements WebSocketFrame {
    public ChannelBuffer binaryData;
    public int type;

    public DefaultWebSocketFrame() {
        this(0, ChannelBuffers.EMPTY_BUFFER);
    }

    public ChannelBuffer getBinaryData() {
        return this.binaryData;
    }

    public String getTextData() {
        return getBinaryData().toString(CharsetUtil.UTF_8);
    }

    public int getType() {
        return this.type;
    }

    public boolean isBinary() {
        return !isText();
    }

    public boolean isText() {
        return (getType() & 128) == 0;
    }

    public void setData(int i, ChannelBuffer channelBuffer) {
        if (channelBuffer == null) {
            throw new NullPointerException("binaryData");
        } else if ((i & 128) != 0 || channelBuffer.indexOf(channelBuffer.readerIndex(), channelBuffer.writerIndex(), -1) < 0) {
            this.type = i & InvitationReply.EXPIRED;
            this.binaryData = channelBuffer;
        } else {
            throw new IllegalArgumentException("a text frame should not contain 0xFF.");
        }
    }

    public String toString() {
        return DefaultWebSocketFrame.class.getSimpleName() + "(type: " + getType() + ", " + "data: " + getBinaryData() + ')';
    }

    public DefaultWebSocketFrame(String str) {
        this(0, ChannelBuffers.copiedBuffer((CharSequence) str, CharsetUtil.UTF_8));
    }

    public DefaultWebSocketFrame(int i, ChannelBuffer channelBuffer) {
        setData(i, channelBuffer);
    }
}
