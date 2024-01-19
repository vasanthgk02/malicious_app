package org.jboss.netty.handler.codec.compression;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelEvent;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelFutureListener;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.LifeCycleAwareChannelHandler;
import org.jboss.netty.handler.codec.oneone.OneToOneEncoder;
import org.jboss.netty.util.internal.jzlib.JZlib;
import org.jboss.netty.util.internal.jzlib.ZStream;

public class ZlibEncoder extends OneToOneEncoder implements LifeCycleAwareChannelHandler {
    public static final byte[] EMPTY_ARRAY = new byte[0];
    public volatile ChannelHandlerContext ctx;
    public final AtomicBoolean finished;
    public final ZStream z;

    /* renamed from: org.jboss.netty.handler.codec.compression.ZlibEncoder$2  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$org$jboss$netty$channel$ChannelState;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0016 */
        static {
            /*
                org.jboss.netty.channel.ChannelState[] r0 = org.jboss.netty.channel.ChannelState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$jboss$netty$channel$ChannelState = r0
                r1 = 1
                org.jboss.netty.channel.ChannelState r2 = org.jboss.netty.channel.ChannelState.OPEN     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                int[] r0 = $SwitchMap$org$jboss$netty$channel$ChannelState     // Catch:{ NoSuchFieldError -> 0x0016 }
                org.jboss.netty.channel.ChannelState r2 = org.jboss.netty.channel.ChannelState.CONNECTED     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2 = 2
                r0[r2] = r2     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                int[] r0 = $SwitchMap$org$jboss$netty$channel$ChannelState     // Catch:{ NoSuchFieldError -> 0x001d }
                org.jboss.netty.channel.ChannelState r2 = org.jboss.netty.channel.ChannelState.BOUND     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.handler.codec.compression.ZlibEncoder.AnonymousClass2.<clinit>():void");
        }
    }

    public ZlibEncoder() {
        this(6);
    }

    private ChannelFuture finishEncode(final ChannelHandlerContext channelHandlerContext, final ChannelEvent channelEvent) {
        ChannelFuture channelFuture;
        Object obj;
        if (!this.finished.compareAndSet(false, true)) {
            if (channelEvent != null) {
                channelHandlerContext.sendDownstream(channelEvent);
            }
            return Channels.succeededFuture(channelHandlerContext.getChannel());
        }
        synchronized (this.z) {
            try {
                this.z.next_in = EMPTY_ARRAY;
                this.z.next_in_index = 0;
                this.z.avail_in = 0;
                byte[] bArr = new byte[32];
                this.z.next_out = bArr;
                this.z.next_out_index = 0;
                this.z.avail_out = 32;
                int deflate = this.z.deflate(4);
                if (deflate != 0 && deflate != 1) {
                    channelFuture = Channels.failedFuture(channelHandlerContext.getChannel(), ZlibUtil.exception(this.z, "compression failure", deflate));
                    obj = null;
                } else if (this.z.next_out_index != 0) {
                    channelFuture = Channels.future(channelHandlerContext.getChannel());
                    obj = channelHandlerContext.getChannel().getConfig().getBufferFactory().getBuffer(bArr, 0, this.z.next_out_index);
                } else {
                    channelFuture = Channels.future(channelHandlerContext.getChannel());
                    obj = ChannelBuffers.EMPTY_BUFFER;
                }
                this.z.deflateEnd();
                this.z.next_in = null;
                this.z.next_out = null;
            } catch (Throwable th) {
                this.z.deflateEnd();
                this.z.next_in = null;
                this.z.next_out = null;
                throw th;
            }
        }
        if (obj != null) {
            Channels.write(channelHandlerContext, channelFuture, obj);
        }
        if (channelEvent != null) {
            channelFuture.addListener(new ChannelFutureListener() {
                public void operationComplete(ChannelFuture channelFuture) throws Exception {
                    channelHandlerContext.sendDownstream(channelEvent);
                }
            });
        }
        return channelFuture;
    }

    public void afterAdd(ChannelHandlerContext channelHandlerContext) throws Exception {
    }

    public void afterRemove(ChannelHandlerContext channelHandlerContext) throws Exception {
    }

    public void beforeAdd(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.ctx = channelHandlerContext;
    }

    public void beforeRemove(ChannelHandlerContext channelHandlerContext) throws Exception {
    }

    public ChannelFuture close() {
        ChannelHandlerContext channelHandlerContext = this.ctx;
        if (channelHandlerContext != null) {
            return finishEncode(channelHandlerContext, null);
        }
        throw new IllegalStateException("not added to a pipeline");
    }

    public Object encode(ChannelHandlerContext channelHandlerContext, Channel channel, Object obj) throws Exception {
        ChannelBuffer channelBuffer;
        if (!(obj instanceof ChannelBuffer) || this.finished.get()) {
            return obj;
        }
        synchronized (this.z) {
            try {
                ChannelBuffer channelBuffer2 = (ChannelBuffer) obj;
                int readableBytes = channelBuffer2.readableBytes();
                byte[] bArr = new byte[readableBytes];
                channelBuffer2.readBytes(bArr);
                this.z.next_in = bArr;
                this.z.next_in_index = 0;
                this.z.avail_in = readableBytes;
                int ceil = ((int) Math.ceil(((double) readableBytes) * 1.001d)) + 12;
                byte[] bArr2 = new byte[ceil];
                this.z.next_out = bArr2;
                this.z.next_out_index = 0;
                this.z.avail_out = ceil;
                int deflate = this.z.deflate(2);
                if (deflate != 0) {
                    ZlibUtil.fail(this.z, "compression failure", deflate);
                }
                if (this.z.next_out_index != 0) {
                    channelBuffer = channelHandlerContext.getChannel().getConfig().getBufferFactory().getBuffer(channelBuffer2.order(), bArr2, 0, this.z.next_out_index);
                } else {
                    channelBuffer = ChannelBuffers.EMPTY_BUFFER;
                }
                this.z.next_in = null;
                this.z.next_out = null;
            } catch (Throwable th) {
                this.z.next_in = null;
                this.z.next_out = null;
                throw th;
            }
        }
        return channelBuffer;
    }

    public void handleDownstream(ChannelHandlerContext channelHandlerContext, ChannelEvent channelEvent) throws Exception {
        if (channelEvent instanceof ChannelStateEvent) {
            ChannelStateEvent channelStateEvent = (ChannelStateEvent) channelEvent;
            int ordinal = channelStateEvent.getState().ordinal();
            if ((ordinal == 0 || ordinal == 1 || ordinal == 2) && (Boolean.FALSE.equals(channelStateEvent.getValue()) || channelStateEvent.getValue() == null)) {
                finishEncode(channelHandlerContext, channelEvent);
                return;
            }
        }
        super.handleDownstream(channelHandlerContext, channelEvent);
    }

    public boolean isClosed() {
        return this.finished.get();
    }

    public ZlibEncoder(int i) {
        this(ZlibWrapper.ZLIB, i);
    }

    public ZlibEncoder(ZlibWrapper zlibWrapper) {
        this(zlibWrapper, 6);
    }

    public ZlibEncoder(ZlibWrapper zlibWrapper, int i) {
        this.z = new ZStream();
        this.finished = new AtomicBoolean();
        if (i < 0 || i > 9) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline42("compressionLevel: ", i, " (expected: 0-9)"));
        } else if (zlibWrapper != null) {
            synchronized (this.z) {
                int deflateInit = this.z.deflateInit(i, (Enum) ZlibUtil.convertWrapperType(zlibWrapper));
                if (deflateInit != 0) {
                    ZlibUtil.fail(this.z, "initialization failure", deflateInit);
                }
            }
        } else {
            throw new NullPointerException("wrapper");
        }
    }

    public ZlibEncoder(byte[] bArr) {
        this(6, bArr);
    }

    public ZlibEncoder(int i, byte[] bArr) {
        this.z = new ZStream();
        this.finished = new AtomicBoolean();
        if (i < 0 || i > 9) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline42("compressionLevel: ", i, " (expected: 0-9)"));
        } else if (bArr != null) {
            synchronized (this.z) {
                int deflateInit = this.z.deflateInit(i, (Enum) JZlib.W_ZLIB);
                if (deflateInit != 0) {
                    ZlibUtil.fail(this.z, "initialization failure", deflateInit);
                } else {
                    int deflateSetDictionary = this.z.deflateSetDictionary(bArr, bArr.length);
                    if (deflateSetDictionary != 0) {
                        ZlibUtil.fail(this.z, "failed to set the dictionary", deflateSetDictionary);
                    }
                }
            }
        } else {
            throw new NullPointerException("dictionary");
        }
    }
}
