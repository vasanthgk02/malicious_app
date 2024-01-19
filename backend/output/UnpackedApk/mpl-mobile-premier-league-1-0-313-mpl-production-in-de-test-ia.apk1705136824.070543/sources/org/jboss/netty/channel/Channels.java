package org.jboss.netty.channel;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.net.SocketAddress;
import java.util.Map.Entry;
import org.jboss.netty.util.internal.ConversionUtil;

public class Channels {
    public static ChannelFuture bind(Channel channel, SocketAddress socketAddress) {
        if (socketAddress != null) {
            ChannelFuture future = future(channel);
            channel.getPipeline().sendDownstream(new DownstreamChannelStateEvent(channel, future, ChannelState.BOUND, socketAddress));
            return future;
        }
        throw new NullPointerException("localAddress");
    }

    public static ChannelFuture close(Channel channel) {
        ChannelFuture closeFuture = channel.getCloseFuture();
        channel.getPipeline().sendDownstream(new DownstreamChannelStateEvent(channel, closeFuture, ChannelState.OPEN, Boolean.FALSE));
        return closeFuture;
    }

    public static ChannelFuture connect(Channel channel, SocketAddress socketAddress) {
        if (socketAddress != null) {
            ChannelFuture future = future(channel, true);
            channel.getPipeline().sendDownstream(new DownstreamChannelStateEvent(channel, future, ChannelState.CONNECTED, socketAddress));
            return future;
        }
        throw new NullPointerException("remoteAddress");
    }

    public static ChannelFuture disconnect(Channel channel) {
        ChannelFuture future = future(channel);
        channel.getPipeline().sendDownstream(new DownstreamChannelStateEvent(channel, future, ChannelState.CONNECTED, null));
        return future;
    }

    public static ChannelFuture failedFuture(Channel channel, Throwable th) {
        return new FailedChannelFuture(channel, th);
    }

    public static int filterDownstreamInterestOps(int i) {
        return i & -5;
    }

    public static void fireChannelBound(Channel channel, SocketAddress socketAddress) {
        channel.getPipeline().sendUpstream(new UpstreamChannelStateEvent(channel, ChannelState.BOUND, socketAddress));
    }

    public static void fireChannelClosed(Channel channel) {
        channel.getPipeline().sendUpstream(new UpstreamChannelStateEvent(channel, ChannelState.OPEN, Boolean.FALSE));
        if (channel.getParent() != null) {
            fireChildChannelStateChanged(channel.getParent(), channel);
        }
    }

    public static void fireChannelConnected(Channel channel, SocketAddress socketAddress) {
        channel.getPipeline().sendUpstream(new UpstreamChannelStateEvent(channel, ChannelState.CONNECTED, socketAddress));
    }

    public static void fireChannelDisconnected(Channel channel) {
        channel.getPipeline().sendUpstream(new UpstreamChannelStateEvent(channel, ChannelState.CONNECTED, null));
    }

    public static void fireChannelInterestChanged(Channel channel) {
        channel.getPipeline().sendUpstream(new UpstreamChannelStateEvent(channel, ChannelState.INTEREST_OPS, Integer.valueOf(1)));
    }

    public static void fireChannelOpen(Channel channel) {
        if (channel.getParent() != null) {
            fireChildChannelStateChanged(channel.getParent(), channel);
        }
        channel.getPipeline().sendUpstream(new UpstreamChannelStateEvent(channel, ChannelState.OPEN, Boolean.TRUE));
    }

    public static void fireChannelUnbound(Channel channel) {
        channel.getPipeline().sendUpstream(new UpstreamChannelStateEvent(channel, ChannelState.BOUND, null));
    }

    public static void fireChildChannelStateChanged(Channel channel, Channel channel2) {
        channel.getPipeline().sendUpstream(new DefaultChildChannelStateEvent(channel, channel2));
    }

    public static void fireExceptionCaught(Channel channel, Throwable th) {
        channel.getPipeline().sendUpstream(new DefaultExceptionEvent(channel, th));
    }

    public static void fireMessageReceived(Channel channel, Object obj) {
        fireMessageReceived(channel, obj, (SocketAddress) null);
    }

    public static void fireWriteComplete(Channel channel, long j) {
        if (j != 0) {
            channel.getPipeline().sendUpstream(new DefaultWriteCompletionEvent(channel, j));
        }
    }

    public static ChannelFuture future(Channel channel) {
        return future(channel, false);
    }

    public static ChannelPipeline pipeline() {
        return new DefaultChannelPipeline();
    }

    public static ChannelPipelineFactory pipelineFactory(final ChannelPipeline channelPipeline) {
        return new ChannelPipelineFactory() {
            public ChannelPipeline getPipeline() {
                return Channels.pipeline(channelPipeline);
            }
        };
    }

    public static ChannelFuture setInterestOps(Channel channel, int i) {
        validateInterestOps(i);
        int filterDownstreamInterestOps = filterDownstreamInterestOps(i);
        ChannelFuture future = future(channel);
        channel.getPipeline().sendDownstream(new DownstreamChannelStateEvent(channel, future, ChannelState.INTEREST_OPS, Integer.valueOf(filterDownstreamInterestOps)));
        return future;
    }

    public static ChannelFuture succeededFuture(Channel channel) {
        if (channel instanceof AbstractChannel) {
            return ((AbstractChannel) channel).getSucceededFuture();
        }
        return new SucceededChannelFuture(channel);
    }

    public static void unbind(ChannelHandlerContext channelHandlerContext, ChannelFuture channelFuture) {
        channelHandlerContext.sendDownstream(new DownstreamChannelStateEvent(channelHandlerContext.getChannel(), channelFuture, ChannelState.BOUND, null));
    }

    public static void validateInterestOps(int i) {
        if (i != 0 && i != 1 && i != 4 && i != 5) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("Invalid interestOps: ", i));
        }
    }

    public static ChannelFuture write(Channel channel, Object obj) {
        return write(channel, obj, (SocketAddress) null);
    }

    public static void fireChannelBound(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress) {
        channelHandlerContext.sendUpstream(new UpstreamChannelStateEvent(channelHandlerContext.getChannel(), ChannelState.BOUND, socketAddress));
    }

    public static void fireChannelConnected(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress) {
        channelHandlerContext.sendUpstream(new UpstreamChannelStateEvent(channelHandlerContext.getChannel(), ChannelState.CONNECTED, socketAddress));
    }

    public static void fireChannelDisconnected(ChannelHandlerContext channelHandlerContext) {
        channelHandlerContext.sendUpstream(new UpstreamChannelStateEvent(channelHandlerContext.getChannel(), ChannelState.CONNECTED, null));
    }

    public static void fireChannelInterestChanged(ChannelHandlerContext channelHandlerContext) {
        channelHandlerContext.sendUpstream(new UpstreamChannelStateEvent(channelHandlerContext.getChannel(), ChannelState.INTEREST_OPS, Integer.valueOf(1)));
    }

    public static void fireChannelUnbound(ChannelHandlerContext channelHandlerContext) {
        channelHandlerContext.sendUpstream(new UpstreamChannelStateEvent(channelHandlerContext.getChannel(), ChannelState.BOUND, null));
    }

    public static void fireExceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) {
        channelHandlerContext.sendUpstream(new DefaultExceptionEvent(channelHandlerContext.getChannel(), th));
    }

    public static void fireMessageReceived(Channel channel, Object obj, SocketAddress socketAddress) {
        channel.getPipeline().sendUpstream(new UpstreamMessageEvent(channel, obj, socketAddress));
    }

    public static void fireWriteComplete(ChannelHandlerContext channelHandlerContext, long j) {
        channelHandlerContext.sendUpstream(new DefaultWriteCompletionEvent(channelHandlerContext.getChannel(), j));
    }

    public static ChannelFuture future(Channel channel, boolean z) {
        return new DefaultChannelFuture(channel, z);
    }

    public static ChannelPipeline pipeline(ChannelHandler... channelHandlerArr) {
        if (channelHandlerArr != null) {
            ChannelPipeline pipeline = pipeline();
            for (int i = 0; i < channelHandlerArr.length; i++) {
                ChannelHandler channelHandler = channelHandlerArr[i];
                if (channelHandler == null) {
                    break;
                }
                pipeline.addLast(ConversionUtil.toString(i), channelHandler);
            }
            return pipeline;
        }
        throw new NullPointerException("handlers");
    }

    public static ChannelFuture unbind(Channel channel) {
        ChannelFuture future = future(channel);
        channel.getPipeline().sendDownstream(new DownstreamChannelStateEvent(channel, future, ChannelState.BOUND, null));
        return future;
    }

    public static void write(ChannelHandlerContext channelHandlerContext, ChannelFuture channelFuture, Object obj) {
        write(channelHandlerContext, channelFuture, obj, null);
    }

    public static void close(ChannelHandlerContext channelHandlerContext, ChannelFuture channelFuture) {
        channelHandlerContext.sendDownstream(new DownstreamChannelStateEvent(channelHandlerContext.getChannel(), channelFuture, ChannelState.OPEN, Boolean.FALSE));
    }

    public static void disconnect(ChannelHandlerContext channelHandlerContext, ChannelFuture channelFuture) {
        channelHandlerContext.sendDownstream(new DownstreamChannelStateEvent(channelHandlerContext.getChannel(), channelFuture, ChannelState.CONNECTED, null));
    }

    public static void fireMessageReceived(ChannelHandlerContext channelHandlerContext, Object obj) {
        channelHandlerContext.sendUpstream(new UpstreamMessageEvent(channelHandlerContext.getChannel(), obj, null));
    }

    public static ChannelFuture write(Channel channel, Object obj, SocketAddress socketAddress) {
        ChannelFuture future = future(channel);
        channel.getPipeline().sendDownstream(new DownstreamMessageEvent(channel, future, obj, socketAddress));
        return future;
    }

    public static void bind(ChannelHandlerContext channelHandlerContext, ChannelFuture channelFuture, SocketAddress socketAddress) {
        if (socketAddress != null) {
            channelHandlerContext.sendDownstream(new DownstreamChannelStateEvent(channelHandlerContext.getChannel(), channelFuture, ChannelState.BOUND, socketAddress));
            return;
        }
        throw new NullPointerException("localAddress");
    }

    public static void connect(ChannelHandlerContext channelHandlerContext, ChannelFuture channelFuture, SocketAddress socketAddress) {
        if (socketAddress != null) {
            channelHandlerContext.sendDownstream(new DownstreamChannelStateEvent(channelHandlerContext.getChannel(), channelFuture, ChannelState.CONNECTED, socketAddress));
            return;
        }
        throw new NullPointerException("remoteAddress");
    }

    public static void fireChannelClosed(ChannelHandlerContext channelHandlerContext) {
        channelHandlerContext.sendUpstream(new UpstreamChannelStateEvent(channelHandlerContext.getChannel(), ChannelState.OPEN, Boolean.FALSE));
    }

    public static void fireChannelOpen(ChannelHandlerContext channelHandlerContext) {
        channelHandlerContext.sendUpstream(new UpstreamChannelStateEvent(channelHandlerContext.getChannel(), ChannelState.OPEN, Boolean.TRUE));
    }

    public static void fireMessageReceived(ChannelHandlerContext channelHandlerContext, Object obj, SocketAddress socketAddress) {
        channelHandlerContext.sendUpstream(new UpstreamMessageEvent(channelHandlerContext.getChannel(), obj, socketAddress));
    }

    public static void setInterestOps(ChannelHandlerContext channelHandlerContext, ChannelFuture channelFuture, int i) {
        validateInterestOps(i);
        channelHandlerContext.sendDownstream(new DownstreamChannelStateEvent(channelHandlerContext.getChannel(), channelFuture, ChannelState.INTEREST_OPS, Integer.valueOf(filterDownstreamInterestOps(i))));
    }

    public static void write(ChannelHandlerContext channelHandlerContext, ChannelFuture channelFuture, Object obj, SocketAddress socketAddress) {
        channelHandlerContext.sendDownstream(new DownstreamMessageEvent(channelHandlerContext.getChannel(), channelFuture, obj, socketAddress));
    }

    public static ChannelPipeline pipeline(ChannelPipeline channelPipeline) {
        ChannelPipeline pipeline = pipeline();
        for (Entry next : channelPipeline.toMap().entrySet()) {
            pipeline.addLast((String) next.getKey(), (ChannelHandler) next.getValue());
        }
        return pipeline;
    }
}
