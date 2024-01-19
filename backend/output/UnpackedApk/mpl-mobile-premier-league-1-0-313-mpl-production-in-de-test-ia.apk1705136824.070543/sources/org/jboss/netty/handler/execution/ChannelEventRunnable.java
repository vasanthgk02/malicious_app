package org.jboss.netty.handler.execution;

import org.jboss.netty.channel.ChannelEvent;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.util.EstimatableObjectWrapper;

public class ChannelEventRunnable implements Runnable, EstimatableObjectWrapper {
    public final ChannelHandlerContext ctx;

    /* renamed from: e  reason: collision with root package name */
    public final ChannelEvent f6169e;
    public int estimatedSize;

    public ChannelEventRunnable(ChannelHandlerContext channelHandlerContext, ChannelEvent channelEvent) {
        this.ctx = channelHandlerContext;
        this.f6169e = channelEvent;
    }

    public ChannelHandlerContext getContext() {
        return this.ctx;
    }

    public ChannelEvent getEvent() {
        return this.f6169e;
    }

    public void run() {
        this.ctx.sendUpstream(this.f6169e);
    }

    public Object unwrap() {
        return this.f6169e;
    }
}
