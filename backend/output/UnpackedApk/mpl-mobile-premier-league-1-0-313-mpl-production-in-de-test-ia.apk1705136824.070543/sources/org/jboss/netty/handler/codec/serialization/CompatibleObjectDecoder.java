package org.jboss.netty.handler.codec.serialization;

import java.io.InputStream;
import java.io.ObjectInputStream;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBufferInputStream;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.replay.ReplayingDecoder;

@Deprecated
public class CompatibleObjectDecoder extends ReplayingDecoder<CompatibleObjectDecoderState> {
    public final SwitchableInputStream bin = new SwitchableInputStream();
    public ObjectInputStream oin;

    /* renamed from: org.jboss.netty.handler.codec.serialization.CompatibleObjectDecoder$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$org$jboss$netty$handler$codec$serialization$CompatibleObjectDecoderState;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000f */
        static {
            /*
                org.jboss.netty.handler.codec.serialization.CompatibleObjectDecoderState[] r0 = org.jboss.netty.handler.codec.serialization.CompatibleObjectDecoderState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$jboss$netty$handler$codec$serialization$CompatibleObjectDecoderState = r0
                r1 = 1
                org.jboss.netty.handler.codec.serialization.CompatibleObjectDecoderState r2 = org.jboss.netty.handler.codec.serialization.CompatibleObjectDecoderState.READ_HEADER     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                int[] r0 = $SwitchMap$org$jboss$netty$handler$codec$serialization$CompatibleObjectDecoderState     // Catch:{ NoSuchFieldError -> 0x0016 }
                org.jboss.netty.handler.codec.serialization.CompatibleObjectDecoderState r2 = org.jboss.netty.handler.codec.serialization.CompatibleObjectDecoderState.READ_OBJECT     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.handler.codec.serialization.CompatibleObjectDecoder.AnonymousClass1.<clinit>():void");
        }
    }

    public CompatibleObjectDecoder() {
        super(CompatibleObjectDecoderState.READ_HEADER);
    }

    public ObjectInputStream newObjectInputStream(InputStream inputStream) throws Exception {
        return new ObjectInputStream(inputStream);
    }

    public Object decode(ChannelHandlerContext channelHandlerContext, Channel channel, ChannelBuffer channelBuffer, CompatibleObjectDecoderState compatibleObjectDecoderState) throws Exception {
        this.bin.switchStream(new ChannelBufferInputStream(channelBuffer));
        int ordinal = compatibleObjectDecoderState.ordinal();
        if (ordinal == 0) {
            this.oin = newObjectInputStream(this.bin);
            checkpoint(CompatibleObjectDecoderState.READ_OBJECT);
        } else if (ordinal != 1) {
            throw new IllegalStateException("Unknown state: " + compatibleObjectDecoderState);
        }
        return this.oin.readObject();
    }

    public Object decodeLast(ChannelHandlerContext channelHandlerContext, Channel channel, ChannelBuffer channelBuffer, CompatibleObjectDecoderState compatibleObjectDecoderState) throws Exception {
        int readableBytes = channelBuffer.readableBytes();
        if (readableBytes == 0) {
            return null;
        }
        if (readableBytes == 1 && channelBuffer.getByte(channelBuffer.readerIndex()) == 121) {
            channelBuffer.skipBytes(1);
            this.oin.close();
            return null;
        }
        Object decode = decode(channelHandlerContext, channel, channelBuffer, compatibleObjectDecoderState);
        this.oin.close();
        return decode;
    }
}
