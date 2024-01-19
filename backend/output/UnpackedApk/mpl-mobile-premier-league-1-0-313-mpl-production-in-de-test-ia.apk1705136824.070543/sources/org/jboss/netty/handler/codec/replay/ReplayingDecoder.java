package org.jboss.netty.handler.codec.replay;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.lang.Enum;
import java.net.SocketAddress;
import java.util.concurrent.atomic.AtomicReference;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelUpstreamHandler;

public abstract class ReplayingDecoder<T extends Enum<T>> extends SimpleChannelUpstreamHandler {
    public int checkpoint;
    public final AtomicReference<ChannelBuffer> cumulation;
    public ReplayingDecoderBuffer replayable;
    public T state;
    public final boolean unfold;

    public ReplayingDecoder() {
        this((T) null);
    }

    private void callDecode(ChannelHandlerContext channelHandlerContext, Channel channel, ChannelBuffer channelBuffer, SocketAddress socketAddress) throws Exception {
        while (channelBuffer.readable()) {
            int readerIndex = channelBuffer.readerIndex();
            this.checkpoint = readerIndex;
            Object obj = null;
            T t = this.state;
            try {
                obj = decode(channelHandlerContext, channel, this.replayable, t);
                if (obj == null) {
                    if (readerIndex != channelBuffer.readerIndex()) {
                        continue;
                    } else if (t == this.state) {
                        throw new IllegalStateException("null cannot be returned if no data is consumed and state didn't change.");
                    }
                }
            } catch (ReplayError unused) {
                int i = this.checkpoint;
                if (i >= 0) {
                    channelBuffer.readerIndex(i);
                }
            }
            if (obj != null) {
                if (readerIndex == channelBuffer.readerIndex() && t == this.state) {
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("decode() method must consume at least one byte if it returned a decoded message (caused by: ");
                    outline73.append(getClass());
                    outline73.append(")");
                    throw new IllegalStateException(outline73.toString());
                }
                unfoldAndfireMessageReceived(channelHandlerContext, obj, socketAddress);
            } else {
                return;
            }
        }
    }

    private void cleanup(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) throws Exception {
        try {
            ChannelBuffer andSet = this.cumulation.getAndSet(null);
            if (andSet == null) {
                channelHandlerContext.sendUpstream(channelStateEvent);
                return;
            }
            this.replayable.terminate();
            if (andSet.readable()) {
                callDecode(channelHandlerContext, channelStateEvent.getChannel(), andSet, null);
            }
            Object decodeLast = decodeLast(channelHandlerContext, channelStateEvent.getChannel(), this.replayable, this.state);
            if (decodeLast != null) {
                unfoldAndfireMessageReceived(channelHandlerContext, decodeLast, null);
            }
            channelHandlerContext.sendUpstream(channelStateEvent);
        } catch (ReplayError unused) {
        } catch (Throwable th) {
            channelHandlerContext.sendUpstream(channelStateEvent);
            throw th;
        }
    }

    private ChannelBuffer cumulation(ChannelHandlerContext channelHandlerContext) {
        ChannelBuffer channelBuffer = this.cumulation.get();
        if (channelBuffer != null) {
            return channelBuffer;
        }
        UnsafeDynamicChannelBuffer unsafeDynamicChannelBuffer = new UnsafeDynamicChannelBuffer(channelHandlerContext.getChannel().getConfig().getBufferFactory());
        if (!this.cumulation.compareAndSet(null, unsafeDynamicChannelBuffer)) {
            return this.cumulation.get();
        }
        this.replayable = new ReplayingDecoderBuffer(unsafeDynamicChannelBuffer);
        return unsafeDynamicChannelBuffer;
    }

    private void unfoldAndfireMessageReceived(ChannelHandlerContext channelHandlerContext, Object obj, SocketAddress socketAddress) {
        if (!this.unfold) {
            Channels.fireMessageReceived(channelHandlerContext, obj, socketAddress);
        } else if (obj instanceof Object[]) {
            for (Object fireMessageReceived : (Object[]) obj) {
                Channels.fireMessageReceived(channelHandlerContext, fireMessageReceived, socketAddress);
            }
        } else if (obj instanceof Iterable) {
            for (Object fireMessageReceived2 : (Iterable) obj) {
                Channels.fireMessageReceived(channelHandlerContext, fireMessageReceived2, socketAddress);
            }
        } else {
            Channels.fireMessageReceived(channelHandlerContext, obj, socketAddress);
        }
    }

    public int actualReadableBytes() {
        return internalBuffer().readableBytes();
    }

    public void channelClosed(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) throws Exception {
        cleanup(channelHandlerContext, channelStateEvent);
    }

    public void channelDisconnected(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) throws Exception {
        cleanup(channelHandlerContext, channelStateEvent);
    }

    public void checkpoint() {
        ChannelBuffer channelBuffer = this.cumulation.get();
        if (channelBuffer != null) {
            this.checkpoint = channelBuffer.readerIndex();
        } else {
            this.checkpoint = -1;
        }
    }

    public abstract Object decode(ChannelHandlerContext channelHandlerContext, Channel channel, ChannelBuffer channelBuffer, T t) throws Exception;

    public Object decodeLast(ChannelHandlerContext channelHandlerContext, Channel channel, ChannelBuffer channelBuffer, T t) throws Exception {
        return decode(channelHandlerContext, channel, channelBuffer, t);
    }

    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, ExceptionEvent exceptionEvent) throws Exception {
        channelHandlerContext.sendUpstream(exceptionEvent);
    }

    public T getState() {
        return this.state;
    }

    public ChannelBuffer internalBuffer() {
        ChannelBuffer channelBuffer = this.cumulation.get();
        return channelBuffer == null ? ChannelBuffers.EMPTY_BUFFER : channelBuffer;
    }

    public void messageReceived(ChannelHandlerContext channelHandlerContext, MessageEvent messageEvent) throws Exception {
        Object message = messageEvent.getMessage();
        if (!(message instanceof ChannelBuffer)) {
            channelHandlerContext.sendUpstream(messageEvent);
            return;
        }
        ChannelBuffer channelBuffer = (ChannelBuffer) message;
        if (channelBuffer.readable()) {
            ChannelBuffer cumulation2 = cumulation(channelHandlerContext);
            cumulation2.discardReadBytes();
            cumulation2.writeBytes(channelBuffer);
            callDecode(channelHandlerContext, messageEvent.getChannel(), cumulation2, messageEvent.getRemoteAddress());
        }
    }

    public T setState(T t) {
        T t2 = this.state;
        this.state = t;
        return t2;
    }

    public ReplayingDecoder(boolean z) {
        this(null, z);
    }

    public ReplayingDecoder(T t) {
        this(t, false);
    }

    public ReplayingDecoder(T t, boolean z) {
        this.cumulation = new AtomicReference<>();
        this.state = t;
        this.unfold = z;
    }

    public void checkpoint(T t) {
        checkpoint();
        setState(t);
    }
}
