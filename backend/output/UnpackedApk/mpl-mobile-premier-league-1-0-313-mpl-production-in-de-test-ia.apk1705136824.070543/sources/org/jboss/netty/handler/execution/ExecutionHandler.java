package org.jboss.netty.handler.execution;

import java.util.concurrent.Executor;
import org.jboss.netty.channel.ChannelDownstreamHandler;
import org.jboss.netty.channel.ChannelEvent;
import org.jboss.netty.channel.ChannelHandler.Sharable;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelState;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.ChannelUpstreamHandler;
import org.jboss.netty.util.ExternalResourceReleasable;
import org.jboss.netty.util.internal.ExecutorUtil;

@Sharable
public class ExecutionHandler implements ChannelUpstreamHandler, ChannelDownstreamHandler, ExternalResourceReleasable {
    public final Executor executor;

    public ExecutionHandler(Executor executor2) {
        if (executor2 != null) {
            this.executor = executor2;
            return;
        }
        throw new NullPointerException("executor");
    }

    public Executor getExecutor() {
        return this.executor;
    }

    public void handleDownstream(ChannelHandlerContext channelHandlerContext, ChannelEvent channelEvent) throws Exception {
        if (channelEvent instanceof ChannelStateEvent) {
            ChannelStateEvent channelStateEvent = (ChannelStateEvent) channelEvent;
            if (channelStateEvent.getState() == ChannelState.INTEREST_OPS) {
                boolean z = true;
                if ((((Integer) channelStateEvent.getValue()).intValue() & 1) != 0) {
                    if (channelHandlerContext.getAttachment() == null) {
                        z = false;
                    }
                    if (z) {
                        channelEvent.getFuture().setSuccess();
                        return;
                    }
                }
            }
        }
        channelHandlerContext.sendDownstream(channelEvent);
    }

    public void handleUpstream(ChannelHandlerContext channelHandlerContext, ChannelEvent channelEvent) throws Exception {
        this.executor.execute(new ChannelEventRunnable(channelHandlerContext, channelEvent));
    }

    public void releaseExternalResources() {
        ExecutorUtil.terminate(getExecutor());
    }
}
