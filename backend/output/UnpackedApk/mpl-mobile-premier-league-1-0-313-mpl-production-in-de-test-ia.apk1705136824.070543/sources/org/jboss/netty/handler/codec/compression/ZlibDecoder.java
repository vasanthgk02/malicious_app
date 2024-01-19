package org.jboss.netty.handler.codec.compression;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.oneone.OneToOneDecoder;
import org.jboss.netty.util.internal.jzlib.JZlib;
import org.jboss.netty.util.internal.jzlib.ZStream;

public class ZlibDecoder extends OneToOneDecoder {
    public volatile boolean finished;
    public final ZStream z;

    public ZlibDecoder() {
        this(ZlibWrapper.ZLIB);
    }

    public Object decode(ChannelHandlerContext channelHandlerContext, Channel channel, Object obj) throws Exception {
        if (!(obj instanceof ChannelBuffer) || this.finished) {
            return obj;
        }
        synchronized (this.z) {
            try {
                ChannelBuffer channelBuffer = (ChannelBuffer) obj;
                int readableBytes = channelBuffer.readableBytes();
                byte[] bArr = new byte[readableBytes];
                channelBuffer.readBytes(bArr);
                this.z.next_in = bArr;
                this.z.next_in_index = 0;
                this.z.avail_in = readableBytes;
                int i = readableBytes << 1;
                byte[] bArr2 = new byte[i];
                ChannelBuffer dynamicBuffer = ChannelBuffers.dynamicBuffer(channelBuffer.order(), i, channelHandlerContext.getChannel().getConfig().getBufferFactory());
                this.z.next_out = bArr2;
                this.z.next_out_index = 0;
                this.z.avail_out = i;
                do {
                    int inflate = this.z.inflate(2);
                    if (inflate == -5 || inflate == 0 || inflate == 1) {
                        dynamicBuffer.writeBytes(bArr2, 0, this.z.next_out_index);
                        this.z.next_out_index = 0;
                        this.z.avail_out = i;
                        if (inflate == 1) {
                            this.finished = true;
                            this.z.inflateEnd();
                        }
                    } else {
                        ZlibUtil.fail(this.z, "decompression failure", inflate);
                    }
                } while (this.z.avail_in > 0);
                if (dynamicBuffer.writerIndex() != 0) {
                    this.z.next_in = null;
                    this.z.next_out = null;
                    return dynamicBuffer;
                }
                this.z.next_in = null;
                this.z.next_out = null;
                return null;
            } catch (Throwable th) {
                this.z.next_in = null;
                this.z.next_out = null;
                throw th;
            }
        }
    }

    public boolean isClosed() {
        return this.finished;
    }

    public ZlibDecoder(ZlibWrapper zlibWrapper) {
        ZStream zStream = new ZStream();
        this.z = zStream;
        if (zlibWrapper != null) {
            synchronized (zStream) {
                int inflateInit = this.z.inflateInit(ZlibUtil.convertWrapperType(zlibWrapper));
                if (inflateInit != 0) {
                    ZlibUtil.fail(this.z, "initialization failure", inflateInit);
                }
            }
            return;
        }
        throw new NullPointerException("wrapper");
    }

    public ZlibDecoder(byte[] bArr) {
        ZStream zStream = new ZStream();
        this.z = zStream;
        if (bArr != null) {
            synchronized (zStream) {
                int inflateInit = this.z.inflateInit(JZlib.W_ZLIB);
                if (inflateInit != 0) {
                    ZlibUtil.fail(this.z, "initialization failure", inflateInit);
                } else {
                    int inflateSetDictionary = this.z.inflateSetDictionary(bArr, bArr.length);
                    if (inflateSetDictionary != 0) {
                        ZlibUtil.fail(this.z, "failed to set the dictionary", inflateSetDictionary);
                    }
                }
            }
            return;
        }
        throw new NullPointerException("dictionary");
    }
}
