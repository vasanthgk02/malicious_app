package org.jboss.netty.handler.codec.protobuf;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.CodedOutputStream.OutputStreamEncoder;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBufferOutputStream;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandler.Sharable;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.oneone.OneToOneEncoder;

@Sharable
public class ProtobufVarint32LengthFieldPrepender extends OneToOneEncoder {
    public Object encode(ChannelHandlerContext channelHandlerContext, Channel channel, Object obj) throws Exception {
        if (!(obj instanceof ChannelBuffer)) {
            return obj;
        }
        ChannelBuffer channelBuffer = (ChannelBuffer) obj;
        int readableBytes = channelBuffer.readableBytes();
        ChannelBuffer buffer = channel.getConfig().getBufferFactory().getBuffer(channelBuffer.order(), CodedOutputStream.computeUInt32SizeNoTag(readableBytes));
        OutputStreamEncoder outputStreamEncoder = new OutputStreamEncoder(new ChannelBufferOutputStream(buffer), 4096);
        outputStreamEncoder.writeUInt32NoTag(readableBytes);
        if (outputStreamEncoder.position > 0) {
            outputStreamEncoder.doFlush();
        }
        return ChannelBuffers.wrappedBuffer(buffer, channelBuffer);
    }
}
