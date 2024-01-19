package org.jboss.netty.handler.codec.http.websocket;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.frame.TooLongFrameException;
import org.jboss.netty.handler.codec.replay.ReplayingDecoder;
import org.jboss.netty.handler.codec.replay.VoidEnum;

public class WebSocketFrameDecoder extends ReplayingDecoder<VoidEnum> {
    public static final int DEFAULT_MAX_FRAME_SIZE = 16384;
    public final int maxFrameSize;
    public boolean receivedClosingHandshake;

    public WebSocketFrameDecoder() {
        this(16384);
    }

    private WebSocketFrame decodeBinaryFrame(int i, ChannelBuffer channelBuffer) throws TooLongFrameException {
        byte readByte;
        int i2 = 0;
        long j = 0;
        do {
            readByte = channelBuffer.readByte();
            j = (j << 7) | ((long) (readByte & Byte.MAX_VALUE));
            if (j <= ((long) this.maxFrameSize)) {
                i2++;
                if (i2 > 8) {
                    throw new TooLongFrameException();
                }
            } else {
                throw new TooLongFrameException();
            }
        } while ((readByte & 128) == 128);
        if (i == 255 && j == 0) {
            this.receivedClosingHandshake = true;
        }
        return new DefaultWebSocketFrame(i, channelBuffer.readBytes((int) j));
    }

    private WebSocketFrame decodeTextFrame(int i, ChannelBuffer channelBuffer) throws TooLongFrameException {
        int readerIndex = channelBuffer.readerIndex();
        int actualReadableBytes = actualReadableBytes();
        int indexOf = channelBuffer.indexOf(readerIndex, readerIndex + actualReadableBytes, -1);
        if (indexOf != -1) {
            int i2 = indexOf - readerIndex;
            if (i2 <= this.maxFrameSize) {
                ChannelBuffer readBytes = channelBuffer.readBytes(i2);
                channelBuffer.skipBytes(1);
                return new DefaultWebSocketFrame(i, readBytes);
            }
            throw new TooLongFrameException();
        } else if (actualReadableBytes <= this.maxFrameSize) {
            return null;
        } else {
            throw new TooLongFrameException();
        }
    }

    public WebSocketFrameDecoder(int i) {
        this.maxFrameSize = i;
    }

    public Object decode(ChannelHandlerContext channelHandlerContext, Channel channel, ChannelBuffer channelBuffer, VoidEnum voidEnum) throws Exception {
        if (this.receivedClosingHandshake) {
            channelBuffer.skipBytes(actualReadableBytes());
            return null;
        }
        byte readByte = channelBuffer.readByte();
        if ((readByte & 128) == 128) {
            return decodeBinaryFrame(readByte, channelBuffer);
        }
        return decodeTextFrame(readByte, channelBuffer);
    }
}
