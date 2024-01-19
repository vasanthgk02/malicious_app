package org.jboss.netty.handler.codec.frame;

import com.android.tools.r8.GeneratedOutlineSupport;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.Channels;

public class DelimiterBasedFrameDecoder extends FrameDecoder {
    public final ChannelBuffer[] delimiters;
    public boolean discardingTooLongFrame;
    public final int maxFrameLength;
    public final boolean stripDelimiter;
    public int tooLongFrameLength;

    public DelimiterBasedFrameDecoder(int i, ChannelBuffer channelBuffer) {
        this(i, true, channelBuffer);
    }

    private void fail(ChannelHandlerContext channelHandlerContext, long j) {
        if (j > 0) {
            Channel channel = channelHandlerContext.getChannel();
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("frame length exceeds ");
            outline73.append(this.maxFrameLength);
            outline73.append(": ");
            outline73.append(j);
            outline73.append(" - discarded");
            Channels.fireExceptionCaught(channel, (Throwable) new TooLongFrameException(outline73.toString()));
            return;
        }
        Channels.fireExceptionCaught(channelHandlerContext.getChannel(), (Throwable) new TooLongFrameException(GeneratedOutlineSupport.outline57(GeneratedOutlineSupport.outline73("frame length exceeds "), this.maxFrameLength, " - discarding")));
    }

    public static int indexOf(ChannelBuffer channelBuffer, ChannelBuffer channelBuffer2) {
        for (int readerIndex = channelBuffer.readerIndex(); readerIndex < channelBuffer.writerIndex(); readerIndex++) {
            int i = 0;
            int i2 = readerIndex;
            while (i < channelBuffer2.capacity() && channelBuffer.getByte(i2) == channelBuffer2.getByte(i)) {
                i2++;
                if (i2 == channelBuffer.writerIndex() && i != channelBuffer2.capacity() - 1) {
                    return -1;
                }
                i++;
            }
            if (i == channelBuffer2.capacity()) {
                return readerIndex - channelBuffer.readerIndex();
            }
        }
        return -1;
    }

    public static void validateDelimiter(ChannelBuffer channelBuffer) {
        if (channelBuffer == null) {
            throw new NullPointerException("delimiter");
        } else if (!channelBuffer.readable()) {
            throw new IllegalArgumentException("empty delimiter");
        }
    }

    public static void validateMaxFrameLength(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("maxFrameLength must be a positive integer: ", i));
        }
    }

    public Object decode(ChannelHandlerContext channelHandlerContext, Channel channel, ChannelBuffer channelBuffer) throws Exception {
        ChannelBuffer channelBuffer2;
        int i = Integer.MAX_VALUE;
        ChannelBuffer channelBuffer3 = null;
        for (ChannelBuffer channelBuffer4 : this.delimiters) {
            int indexOf = indexOf(channelBuffer, channelBuffer4);
            if (indexOf >= 0 && indexOf < i) {
                channelBuffer3 = channelBuffer4;
                i = indexOf;
            }
        }
        if (channelBuffer3 != null) {
            int capacity = channelBuffer3.capacity();
            if (this.discardingTooLongFrame) {
                this.discardingTooLongFrame = false;
                channelBuffer.skipBytes(i + capacity);
                int i2 = this.tooLongFrameLength;
                this.tooLongFrameLength = 0;
                fail(channelHandlerContext, (long) i2);
                return null;
            } else if (i > this.maxFrameLength) {
                channelBuffer.skipBytes(capacity + i);
                fail(channelHandlerContext, (long) i);
                return null;
            } else {
                if (this.stripDelimiter) {
                    channelBuffer2 = channelBuffer.readBytes(i);
                    channelBuffer.skipBytes(capacity);
                } else {
                    channelBuffer2 = channelBuffer.readBytes(i + capacity);
                }
                return channelBuffer2;
            }
        } else {
            if (this.discardingTooLongFrame) {
                this.tooLongFrameLength = channelBuffer.readableBytes() + this.tooLongFrameLength;
                channelBuffer.skipBytes(channelBuffer.readableBytes());
            } else if (channelBuffer.readableBytes() > this.maxFrameLength) {
                this.tooLongFrameLength = channelBuffer.readableBytes();
                channelBuffer.skipBytes(channelBuffer.readableBytes());
                this.discardingTooLongFrame = true;
            }
            return null;
        }
    }

    public DelimiterBasedFrameDecoder(int i, boolean z, ChannelBuffer channelBuffer) {
        validateMaxFrameLength(i);
        validateDelimiter(channelBuffer);
        this.delimiters = new ChannelBuffer[]{channelBuffer.slice(channelBuffer.readerIndex(), channelBuffer.readableBytes())};
        this.maxFrameLength = i;
        this.stripDelimiter = z;
    }

    public DelimiterBasedFrameDecoder(int i, ChannelBuffer... channelBufferArr) {
        this(i, true, channelBufferArr);
    }

    public DelimiterBasedFrameDecoder(int i, boolean z, ChannelBuffer... channelBufferArr) {
        validateMaxFrameLength(i);
        if (channelBufferArr == null) {
            throw new NullPointerException("delimiters");
        } else if (channelBufferArr.length != 0) {
            this.delimiters = new ChannelBuffer[channelBufferArr.length];
            for (int i2 = 0; i2 < channelBufferArr.length; i2++) {
                ChannelBuffer channelBuffer = channelBufferArr[i2];
                validateDelimiter(channelBuffer);
                this.delimiters[i2] = channelBuffer.slice(channelBuffer.readerIndex(), channelBuffer.readableBytes());
            }
            this.maxFrameLength = i;
            this.stripDelimiter = z;
        } else {
            throw new IllegalArgumentException("empty delimiters");
        }
    }
}
