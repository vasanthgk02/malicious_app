package org.jboss.netty.handler.codec.frame;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.net.SocketAddress;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelUpstreamHandler;

public abstract class FrameDecoder extends SimpleChannelUpstreamHandler {
    public ChannelBuffer cumulation;
    public final boolean unfold;

    public FrameDecoder() {
        this(false);
    }

    private void callDecode(ChannelHandlerContext channelHandlerContext, Channel channel, ChannelBuffer channelBuffer, SocketAddress socketAddress) throws Exception {
        while (channelBuffer.readable()) {
            int readerIndex = channelBuffer.readerIndex();
            Object decode = decode(channelHandlerContext, channel, channelBuffer);
            if (decode == null) {
                if (readerIndex == channelBuffer.readerIndex()) {
                    return;
                }
            } else if (readerIndex != channelBuffer.readerIndex()) {
                unfoldAndFireMessageReceived(channelHandlerContext, socketAddress, decode);
            } else {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("decode() method must read at least one byte if it returned a frame (caused by: ");
                outline73.append(getClass());
                outline73.append(")");
                throw new IllegalStateException(outline73.toString());
            }
        }
    }

    private void cleanup(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) throws Exception {
        try {
            ChannelBuffer channelBuffer = this.cumulation;
            if (channelBuffer != null) {
                this.cumulation = null;
                if (channelBuffer.readable()) {
                    callDecode(channelHandlerContext, channelHandlerContext.getChannel(), channelBuffer, null);
                }
                Object decodeLast = decodeLast(channelHandlerContext, channelHandlerContext.getChannel(), channelBuffer);
                if (decodeLast != null) {
                    unfoldAndFireMessageReceived(channelHandlerContext, null, decodeLast);
                }
                channelHandlerContext.sendUpstream(channelStateEvent);
            }
        } finally {
            channelHandlerContext.sendUpstream(channelStateEvent);
        }
    }

    private ChannelBuffer cumulation(ChannelHandlerContext channelHandlerContext) {
        ChannelBuffer channelBuffer = this.cumulation;
        if (channelBuffer != null) {
            return channelBuffer;
        }
        ChannelBuffer dynamicBuffer = ChannelBuffers.dynamicBuffer(channelHandlerContext.getChannel().getConfig().getBufferFactory());
        this.cumulation = dynamicBuffer;
        return dynamicBuffer;
    }

    private void unfoldAndFireMessageReceived(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, Object obj) {
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

    public void channelClosed(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) throws Exception {
        cleanup(channelHandlerContext, channelStateEvent);
    }

    public void channelDisconnected(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) throws Exception {
        cleanup(channelHandlerContext, channelStateEvent);
    }

    public abstract Object decode(ChannelHandlerContext channelHandlerContext, Channel channel, ChannelBuffer channelBuffer) throws Exception;

    public Object decodeLast(ChannelHandlerContext channelHandlerContext, Channel channel, ChannelBuffer channelBuffer) throws Exception {
        return decode(channelHandlerContext, channel, channelBuffer);
    }

    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, ExceptionEvent exceptionEvent) throws Exception {
        channelHandlerContext.sendUpstream(exceptionEvent);
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
            if (cumulation2.readable()) {
                cumulation2.discardReadBytes();
                cumulation2.writeBytes(channelBuffer);
                callDecode(channelHandlerContext, messageEvent.getChannel(), cumulation2, messageEvent.getRemoteAddress());
            } else {
                callDecode(channelHandlerContext, messageEvent.getChannel(), channelBuffer, messageEvent.getRemoteAddress());
                if (channelBuffer.readable()) {
                    cumulation2.writeBytes(channelBuffer);
                }
            }
        }
    }

    public FrameDecoder(boolean z) {
        this.unfold = z;
    }
}
