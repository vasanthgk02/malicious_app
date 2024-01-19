package org.jboss.netty.channel;

import com.android.tools.r8.GeneratedOutlineSupport;
import org.jboss.netty.logging.InternalLogger;
import org.jboss.netty.logging.InternalLoggerFactory;

public class SimpleChannelUpstreamHandler implements ChannelUpstreamHandler {
    public static final InternalLogger logger = InternalLoggerFactory.getInstance(SimpleChannelUpstreamHandler.class.getName());

    /* renamed from: org.jboss.netty.channel.SimpleChannelUpstreamHandler$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$org$jboss$netty$channel$ChannelState;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x001d */
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
                r0 = 2
                int[] r2 = $SwitchMap$org$jboss$netty$channel$ChannelState     // Catch:{ NoSuchFieldError -> 0x0016 }
                org.jboss.netty.channel.ChannelState r3 = org.jboss.netty.channel.ChannelState.BOUND     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                r1 = 3
                int[] r2 = $SwitchMap$org$jboss$netty$channel$ChannelState     // Catch:{ NoSuchFieldError -> 0x001d }
                org.jboss.netty.channel.ChannelState r3 = org.jboss.netty.channel.ChannelState.CONNECTED     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$org$jboss$netty$channel$ChannelState     // Catch:{ NoSuchFieldError -> 0x0024 }
                org.jboss.netty.channel.ChannelState r2 = org.jboss.netty.channel.ChannelState.INTEREST_OPS     // Catch:{ NoSuchFieldError -> 0x0024 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0024 }
            L_0x0024:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.channel.SimpleChannelUpstreamHandler.AnonymousClass1.<clinit>():void");
        }
    }

    public void channelBound(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) throws Exception {
        channelHandlerContext.sendUpstream(channelStateEvent);
    }

    public void channelClosed(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) throws Exception {
        channelHandlerContext.sendUpstream(channelStateEvent);
    }

    public void channelConnected(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) throws Exception {
        channelHandlerContext.sendUpstream(channelStateEvent);
    }

    public void channelDisconnected(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) throws Exception {
        channelHandlerContext.sendUpstream(channelStateEvent);
    }

    public void channelInterestChanged(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) throws Exception {
        channelHandlerContext.sendUpstream(channelStateEvent);
    }

    public void channelOpen(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) throws Exception {
        channelHandlerContext.sendUpstream(channelStateEvent);
    }

    public void channelUnbound(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) throws Exception {
        channelHandlerContext.sendUpstream(channelStateEvent);
    }

    public void childChannelClosed(ChannelHandlerContext channelHandlerContext, ChildChannelStateEvent childChannelStateEvent) throws Exception {
        channelHandlerContext.sendUpstream(childChannelStateEvent);
    }

    public void childChannelOpen(ChannelHandlerContext channelHandlerContext, ChildChannelStateEvent childChannelStateEvent) throws Exception {
        channelHandlerContext.sendUpstream(childChannelStateEvent);
    }

    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, ExceptionEvent exceptionEvent) throws Exception {
        if (this == channelHandlerContext.getPipeline().getLast()) {
            InternalLogger internalLogger = logger;
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("EXCEPTION, please implement ");
            outline73.append(getClass().getName());
            outline73.append(".exceptionCaught() for proper handling.");
            internalLogger.warn(outline73.toString(), exceptionEvent.getCause());
        }
        channelHandlerContext.sendUpstream(exceptionEvent);
    }

    public void handleUpstream(ChannelHandlerContext channelHandlerContext, ChannelEvent channelEvent) throws Exception {
        if (channelEvent instanceof MessageEvent) {
            messageReceived(channelHandlerContext, (MessageEvent) channelEvent);
        } else if (channelEvent instanceof WriteCompletionEvent) {
            writeComplete(channelHandlerContext, (WriteCompletionEvent) channelEvent);
        } else if (channelEvent instanceof ChildChannelStateEvent) {
            ChildChannelStateEvent childChannelStateEvent = (ChildChannelStateEvent) channelEvent;
            if (childChannelStateEvent.getChildChannel().isOpen()) {
                childChannelOpen(channelHandlerContext, childChannelStateEvent);
            } else {
                childChannelClosed(channelHandlerContext, childChannelStateEvent);
            }
        } else if (channelEvent instanceof ChannelStateEvent) {
            ChannelStateEvent channelStateEvent = (ChannelStateEvent) channelEvent;
            int ordinal = channelStateEvent.getState().ordinal();
            if (ordinal != 0) {
                if (ordinal != 1) {
                    if (ordinal != 2) {
                        if (ordinal != 3) {
                            channelHandlerContext.sendUpstream(channelEvent);
                        } else {
                            channelInterestChanged(channelHandlerContext, channelStateEvent);
                        }
                    } else if (channelStateEvent.getValue() != null) {
                        channelConnected(channelHandlerContext, channelStateEvent);
                    } else {
                        channelDisconnected(channelHandlerContext, channelStateEvent);
                    }
                } else if (channelStateEvent.getValue() != null) {
                    channelBound(channelHandlerContext, channelStateEvent);
                } else {
                    channelUnbound(channelHandlerContext, channelStateEvent);
                }
            } else if (Boolean.TRUE.equals(channelStateEvent.getValue())) {
                channelOpen(channelHandlerContext, channelStateEvent);
            } else {
                channelClosed(channelHandlerContext, channelStateEvent);
            }
        } else if (channelEvent instanceof ExceptionEvent) {
            exceptionCaught(channelHandlerContext, (ExceptionEvent) channelEvent);
        } else {
            channelHandlerContext.sendUpstream(channelEvent);
        }
    }

    public void messageReceived(ChannelHandlerContext channelHandlerContext, MessageEvent messageEvent) throws Exception {
        channelHandlerContext.sendUpstream(messageEvent);
    }

    public void writeComplete(ChannelHandlerContext channelHandlerContext, WriteCompletionEvent writeCompletionEvent) throws Exception {
        channelHandlerContext.sendUpstream(writeCompletionEvent);
    }
}
