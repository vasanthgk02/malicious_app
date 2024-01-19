package org.jboss.netty.handler.codec.serialization;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.concurrent.atomic.AtomicReference;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBufferOutputStream;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.oneone.OneToOneEncoder;

public class CompatibleObjectEncoder extends OneToOneEncoder {
    public final AtomicReference<ChannelBuffer> buffer;
    public volatile ObjectOutputStream oout;
    public final int resetInterval;
    public int writtenObjects;

    public CompatibleObjectEncoder() {
        this(16);
    }

    private ChannelBuffer buffer(ChannelHandlerContext channelHandlerContext) throws Exception {
        ChannelBuffer channelBuffer = this.buffer.get();
        if (channelBuffer != null) {
            return channelBuffer;
        }
        ChannelBuffer dynamicBuffer = ChannelBuffers.dynamicBuffer(channelHandlerContext.getChannel().getConfig().getBufferFactory());
        ObjectOutputStream objectOutputStream = null;
        if (!this.buffer.compareAndSet(objectOutputStream, dynamicBuffer)) {
            return this.buffer.get();
        }
        try {
            objectOutputStream = newObjectOutputStream(new ChannelBufferOutputStream(dynamicBuffer));
            return dynamicBuffer;
        } finally {
            this.oout = objectOutputStream;
        }
    }

    public Object encode(ChannelHandlerContext channelHandlerContext, Channel channel, Object obj) throws Exception {
        ChannelBuffer buffer2 = buffer(channelHandlerContext);
        ObjectOutputStream objectOutputStream = this.oout;
        int i = this.resetInterval;
        if (i != 0) {
            int i2 = this.writtenObjects + 1;
            this.writtenObjects = i2;
            if (i2 % i == 0) {
                objectOutputStream.reset();
                buffer2.discardReadBytes();
            }
        }
        objectOutputStream.writeObject(obj);
        objectOutputStream.flush();
        return buffer2.readBytes(buffer2.readableBytes());
    }

    public ObjectOutputStream newObjectOutputStream(OutputStream outputStream) throws Exception {
        return new ObjectOutputStream(outputStream);
    }

    public CompatibleObjectEncoder(int i) {
        this.buffer = new AtomicReference<>();
        if (i >= 0) {
            this.resetInterval = i;
            return;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("resetInterval: ", i));
    }
}
