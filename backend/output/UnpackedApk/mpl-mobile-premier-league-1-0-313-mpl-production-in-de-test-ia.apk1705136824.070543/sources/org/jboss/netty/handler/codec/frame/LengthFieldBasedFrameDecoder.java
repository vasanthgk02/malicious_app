package org.jboss.netty.handler.codec.frame;

import com.android.tools.r8.GeneratedOutlineSupport;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.Channels;

public class LengthFieldBasedFrameDecoder extends FrameDecoder {
    public long bytesToDiscard;
    public boolean discardingTooLongFrame;
    public final int initialBytesToStrip;
    public final int lengthAdjustment;
    public final int lengthFieldEndOffset;
    public final int lengthFieldLength;
    public final int lengthFieldOffset;
    public final int maxFrameLength;
    public long tooLongFrameLength;

    public LengthFieldBasedFrameDecoder(int i, int i2, int i3) {
        this(i, i2, i3, 0, 0);
    }

    private void fail(ChannelHandlerContext channelHandlerContext, long j) {
        if (j > 0) {
            Channel channel = channelHandlerContext.getChannel();
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Adjusted frame length exceeds ");
            outline73.append(this.maxFrameLength);
            outline73.append(": ");
            outline73.append(j);
            outline73.append(" - discarded");
            Channels.fireExceptionCaught(channel, (Throwable) new TooLongFrameException(outline73.toString()));
            return;
        }
        Channels.fireExceptionCaught(channelHandlerContext.getChannel(), (Throwable) new TooLongFrameException(GeneratedOutlineSupport.outline57(GeneratedOutlineSupport.outline73("Adjusted frame length exceeds "), this.maxFrameLength, " - discarding")));
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0103  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object decode(org.jboss.netty.channel.ChannelHandlerContext r9, org.jboss.netty.channel.Channel r10, org.jboss.netty.buffer.ChannelBuffer r11) throws java.lang.Exception {
        /*
            r8 = this;
            boolean r10 = r8.discardingTooLongFrame
            r0 = 0
            r2 = 0
            if (r10 == 0) goto L_0x0026
            long r3 = r8.bytesToDiscard
            int r10 = r11.readableBytes()
            long r5 = (long) r10
            long r5 = java.lang.Math.min(r3, r5)
            int r10 = (int) r5
            r11.skipBytes(r10)
            long r10 = (long) r10
            long r3 = r3 - r10
            r8.bytesToDiscard = r3
            int r10 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r10 != 0) goto L_0x0025
            long r10 = r8.tooLongFrameLength
            r8.tooLongFrameLength = r0
            r8.fail(r9, r10)
        L_0x0025:
            return r2
        L_0x0026:
            int r9 = r11.readableBytes()
            int r10 = r8.lengthFieldEndOffset
            if (r9 >= r10) goto L_0x002f
            return r2
        L_0x002f:
            int r9 = r11.readerIndex()
            int r10 = r8.lengthFieldOffset
            int r9 = r9 + r10
            int r10 = r8.lengthFieldLength
            r3 = 1
            if (r10 == r3) goto L_0x0064
            r4 = 2
            if (r10 == r4) goto L_0x005f
            r4 = 3
            if (r10 == r4) goto L_0x005a
            r4 = 4
            if (r10 == r4) goto L_0x0055
            r4 = 8
            if (r10 != r4) goto L_0x004d
            long r9 = r11.getLong(r9)
            goto L_0x0069
        L_0x004d:
            java.lang.Error r9 = new java.lang.Error
            java.lang.String r10 = "should not reach here"
            r9.<init>(r10)
            throw r9
        L_0x0055:
            long r9 = r11.getUnsignedInt(r9)
            goto L_0x0069
        L_0x005a:
            int r9 = r11.getUnsignedMedium(r9)
            goto L_0x0068
        L_0x005f:
            int r9 = r11.getUnsignedShort(r9)
            goto L_0x0068
        L_0x0064:
            short r9 = r11.getUnsignedByte(r9)
        L_0x0068:
            long r9 = (long) r9
        L_0x0069:
            int r4 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r4 < 0) goto L_0x0103
            int r0 = r8.lengthAdjustment
            int r1 = r8.lengthFieldEndOffset
            int r0 = r0 + r1
            long r4 = (long) r0
            long r9 = r9 + r4
            long r4 = (long) r1
            java.lang.String r0 = ") is less "
            java.lang.String r6 = "Adjusted frame length ("
            int r7 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r7 < 0) goto L_0x00dd
            int r1 = r8.maxFrameLength
            long r4 = (long) r1
            int r1 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r1 <= 0) goto L_0x0098
            r8.discardingTooLongFrame = r3
            r8.tooLongFrameLength = r9
            int r0 = r11.readableBytes()
            long r0 = (long) r0
            long r9 = r9 - r0
            r8.bytesToDiscard = r9
            int r9 = r11.readableBytes()
            r11.skipBytes(r9)
            return r2
        L_0x0098:
            int r1 = (int) r9
            int r3 = r11.readableBytes()
            if (r3 >= r1) goto L_0x00a0
            return r2
        L_0x00a0:
            int r2 = r8.initialBytesToStrip
            if (r2 > r1) goto L_0x00b7
            r11.skipBytes(r2)
            int r9 = r11.readerIndex()
            int r10 = r8.initialBytesToStrip
            int r1 = r1 - r10
            org.jboss.netty.buffer.ChannelBuffer r10 = r8.extractFrame(r11, r9, r1)
            int r9 = r9 + r1
            r11.readerIndex(r9)
            return r10
        L_0x00b7:
            r11.skipBytes(r1)
            org.jboss.netty.handler.codec.frame.CorruptedFrameException r11 = new org.jboss.netty.handler.codec.frame.CorruptedFrameException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r6)
            r1.append(r9)
            r1.append(r0)
            java.lang.String r9 = "than initialBytesToStrip: "
            r1.append(r9)
            int r9 = r8.initialBytesToStrip
            r1.append(r9)
            java.lang.String r9 = r1.toString()
            r11.<init>(r9)
            throw r11
        L_0x00dd:
            r11.skipBytes(r1)
            org.jboss.netty.handler.codec.frame.CorruptedFrameException r11 = new org.jboss.netty.handler.codec.frame.CorruptedFrameException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r6)
            r1.append(r9)
            r1.append(r0)
            java.lang.String r9 = "than lengthFieldEndOffset: "
            r1.append(r9)
            int r9 = r8.lengthFieldEndOffset
            r1.append(r9)
            java.lang.String r9 = r1.toString()
            r11.<init>(r9)
            throw r11
        L_0x0103:
            int r0 = r8.lengthFieldEndOffset
            r11.skipBytes(r0)
            org.jboss.netty.handler.codec.frame.CorruptedFrameException r11 = new org.jboss.netty.handler.codec.frame.CorruptedFrameException
            java.lang.String r0 = "negative pre-adjustment length field: "
            java.lang.String r9 = com.android.tools.r8.GeneratedOutlineSupport.outline45(r0, r9)
            r11.<init>(r9)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.handler.codec.frame.LengthFieldBasedFrameDecoder.decode(org.jboss.netty.channel.ChannelHandlerContext, org.jboss.netty.channel.Channel, org.jboss.netty.buffer.ChannelBuffer):java.lang.Object");
    }

    public ChannelBuffer extractFrame(ChannelBuffer channelBuffer, int i, int i2) {
        ChannelBuffer buffer = channelBuffer.factory().getBuffer(i2);
        buffer.writeBytes(channelBuffer, i, i2);
        return buffer;
    }

    public LengthFieldBasedFrameDecoder(int i, int i2, int i3, int i4, int i5) {
        if (i <= 0) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("maxFrameLength must be a positive integer: ", i));
        } else if (i2 < 0) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("lengthFieldOffset must be a non-negative integer: ", i2));
        } else if (i5 < 0) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("initialBytesToStrip must be a non-negative integer: ", i5));
        } else if (i3 != 1 && i3 != 2 && i3 != 3 && i3 != 4 && i3 != 8) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("lengthFieldLength must be either 1, 2, 3, 4, or 8: ", i3));
        } else if (i2 <= i - i3) {
            this.maxFrameLength = i;
            this.lengthFieldOffset = i2;
            this.lengthFieldLength = i3;
            this.lengthAdjustment = i4;
            this.lengthFieldEndOffset = i2 + i3;
            this.initialBytesToStrip = i5;
        } else {
            throw new IllegalArgumentException("maxFrameLength (" + i + ") " + "must be equal to or greater than " + "lengthFieldOffset (" + i2 + ") + " + "lengthFieldLength (" + i3 + ").");
        }
    }
}
