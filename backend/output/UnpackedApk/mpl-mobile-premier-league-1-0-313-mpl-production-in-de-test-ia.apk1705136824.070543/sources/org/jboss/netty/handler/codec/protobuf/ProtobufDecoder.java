package org.jboss.netty.handler.codec.protobuf;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLite.Builder;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBufferInputStream;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandler.Sharable;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.oneone.OneToOneDecoder;

@Sharable
public class ProtobufDecoder extends OneToOneDecoder {
    public final ExtensionRegistry extensionRegistry;
    public final MessageLite prototype;

    public ProtobufDecoder(MessageLite messageLite) {
        this(messageLite, null);
    }

    public Object decode(ChannelHandlerContext channelHandlerContext, Channel channel, Object obj) throws Exception {
        if (!(obj instanceof ChannelBuffer)) {
            return obj;
        }
        ChannelBuffer channelBuffer = (ChannelBuffer) obj;
        if (channelBuffer.hasArray()) {
            if (this.extensionRegistry == null) {
                Builder newBuilderForType = this.prototype.newBuilderForType();
                byte[] array = channelBuffer.array();
                int arrayOffset = channelBuffer.arrayOffset();
                int readableBytes = channelBuffer.readableBytes();
                GeneratedMessageLite.Builder builder = (GeneratedMessageLite.Builder) newBuilderForType;
                if (builder != null) {
                    builder.mergeFrom(array, arrayOffset, readableBytes, ExtensionRegistryLite.getEmptyRegistry());
                    return builder.build();
                }
                throw null;
            }
            GeneratedMessageLite.Builder builder2 = (GeneratedMessageLite.Builder) this.prototype.newBuilderForType();
            builder2.mergeFrom(channelBuffer.array(), channelBuffer.arrayOffset(), channelBuffer.readableBytes(), this.extensionRegistry);
            return builder2.build();
        } else if (this.extensionRegistry == null) {
            Builder newBuilderForType2 = this.prototype.newBuilderForType();
            ChannelBufferInputStream channelBufferInputStream = new ChannelBufferInputStream(channelBuffer);
            AbstractMessageLite.Builder builder3 = (AbstractMessageLite.Builder) newBuilderForType2;
            if (builder3 != null) {
                CodedInputStream newInstance = CodedInputStream.newInstance(channelBufferInputStream);
                builder3.mergeFrom(newInstance, ExtensionRegistryLite.getEmptyRegistry());
                newInstance.checkLastTagWas(0);
                return ((GeneratedMessageLite.Builder) builder3).build();
            }
            throw null;
        } else {
            Builder newBuilderForType3 = this.prototype.newBuilderForType();
            ChannelBufferInputStream channelBufferInputStream2 = new ChannelBufferInputStream(channelBuffer);
            ExtensionRegistry extensionRegistry2 = this.extensionRegistry;
            AbstractMessageLite.Builder builder4 = (AbstractMessageLite.Builder) newBuilderForType3;
            if (builder4 != null) {
                CodedInputStream newInstance2 = CodedInputStream.newInstance(channelBufferInputStream2);
                builder4.mergeFrom(newInstance2, extensionRegistry2);
                newInstance2.checkLastTagWas(0);
                return ((GeneratedMessageLite.Builder) builder4).build();
            }
            throw null;
        }
    }

    public ProtobufDecoder(MessageLite messageLite, ExtensionRegistry extensionRegistry2) {
        if (messageLite != null) {
            this.prototype = messageLite.getDefaultInstanceForType();
            this.extensionRegistry = extensionRegistry2;
            return;
        }
        throw new NullPointerException("prototype");
    }
}
