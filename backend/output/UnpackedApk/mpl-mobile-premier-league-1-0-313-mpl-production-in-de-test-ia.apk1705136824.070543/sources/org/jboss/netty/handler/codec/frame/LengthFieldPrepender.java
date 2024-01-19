package org.jboss.netty.handler.codec.frame;

import com.android.tools.r8.GeneratedOutlineSupport;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandler.Sharable;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.oneone.OneToOneEncoder;

@Sharable
public class LengthFieldPrepender extends OneToOneEncoder {
    public final int lengthFieldLength;
    public final boolean lengthIncludesLengthFieldLength;

    public LengthFieldPrepender(int i) {
        this(i, false);
    }

    public Object encode(ChannelHandlerContext channelHandlerContext, Channel channel, Object obj) throws Exception {
        if (!(obj instanceof ChannelBuffer)) {
            return obj;
        }
        ChannelBuffer channelBuffer = (ChannelBuffer) obj;
        ChannelBuffer buffer = channel.getConfig().getBufferFactory().getBuffer(channelBuffer.order(), this.lengthFieldLength);
        int readableBytes = this.lengthIncludesLengthFieldLength ? channelBuffer.readableBytes() + this.lengthFieldLength : channelBuffer.readableBytes();
        int i = this.lengthFieldLength;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        buffer.writeInt(readableBytes);
                    } else if (i == 8) {
                        buffer.writeLong((long) readableBytes);
                    } else {
                        throw new Error("should not reach here");
                    }
                } else if (readableBytes < 16777216) {
                    buffer.writeMedium(readableBytes);
                } else {
                    throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("length does not fit into a medium integer: ", readableBytes));
                }
            } else if (readableBytes < 65536) {
                buffer.writeShort((short) readableBytes);
            } else {
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("length does not fit into a short integer: ", readableBytes));
            }
        } else if (readableBytes < 256) {
            buffer.writeByte((byte) readableBytes);
        } else {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("length does not fit into a byte: ", readableBytes));
        }
        return ChannelBuffers.wrappedBuffer(buffer, channelBuffer);
    }

    public LengthFieldPrepender(int i, boolean z) {
        if (i == 1 || i == 2 || i == 3 || i == 4 || i == 8) {
            this.lengthFieldLength = i;
            this.lengthIncludesLengthFieldLength = z;
            return;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("lengthFieldLength must be either 1, 2, 3, 4, or 8: ", i));
    }
}
