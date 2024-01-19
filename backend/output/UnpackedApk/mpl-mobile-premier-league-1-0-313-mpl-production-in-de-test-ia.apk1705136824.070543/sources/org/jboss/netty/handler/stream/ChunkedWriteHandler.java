package org.jboss.netty.handler.stream;

import java.util.Queue;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelDownstreamHandler;
import org.jboss.netty.channel.ChannelEvent;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelFutureListener;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.ChannelUpstreamHandler;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.logging.InternalLogger;
import org.jboss.netty.logging.InternalLoggerFactory;
import org.jboss.netty.util.internal.LinkedTransferQueue;

public class ChunkedWriteHandler implements ChannelUpstreamHandler, ChannelDownstreamHandler {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final InternalLogger logger = InternalLoggerFactory.getInstance(ChunkedWriteHandler.class);
    public ChannelHandlerContext ctx;
    public MessageEvent currentEvent;
    public final Queue<MessageEvent> queue = new LinkedTransferQueue();

    /* renamed from: org.jboss.netty.handler.stream.ChunkedWriteHandler$2  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$org$jboss$netty$channel$ChannelState;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000f */
        static {
            /*
                org.jboss.netty.channel.ChannelState[] r0 = org.jboss.netty.channel.ChannelState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$jboss$netty$channel$ChannelState = r0
                org.jboss.netty.channel.ChannelState r1 = org.jboss.netty.channel.ChannelState.INTEREST_OPS     // Catch:{ NoSuchFieldError -> 0x000f }
                r1 = 3
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                int[] r0 = $SwitchMap$org$jboss$netty$channel$ChannelState     // Catch:{ NoSuchFieldError -> 0x0017 }
                org.jboss.netty.channel.ChannelState r1 = org.jboss.netty.channel.ChannelState.OPEN     // Catch:{ NoSuchFieldError -> 0x0017 }
                r1 = 0
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0017 }
            L_0x0017:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.handler.stream.ChunkedWriteHandler.AnonymousClass2.<clinit>():void");
        }
    }

    public static void closeInput(ChunkedInput chunkedInput) {
        try {
            chunkedInput.close();
        } catch (Throwable th) {
            logger.warn("Failed to close a chunked input.", th);
        }
    }

    private synchronized void discard(ChannelHandlerContext channelHandlerContext) {
        while (true) {
            if (this.currentEvent == null) {
                this.currentEvent = this.queue.poll();
            }
            if (this.currentEvent != null) {
                MessageEvent messageEvent = this.currentEvent;
                this.currentEvent = null;
                Object message = messageEvent.getMessage();
                if (message instanceof ChunkedInput) {
                    closeInput((ChunkedInput) message);
                    Channels.write(channelHandlerContext, messageEvent.getFuture(), ChannelBuffers.EMPTY_BUFFER, messageEvent.getRemoteAddress());
                } else {
                    channelHandlerContext.sendDownstream(messageEvent);
                }
            }
        }
    }

    private synchronized void flush(ChannelHandlerContext channelHandlerContext) throws Exception {
        boolean z;
        ChannelFuture channelFuture;
        Channel channel = channelHandlerContext.getChannel();
        if (!channel.isConnected()) {
            discard(channelHandlerContext);
        }
        while (true) {
            if (channel.isWritable()) {
                if (this.currentEvent == null) {
                    this.currentEvent = this.queue.poll();
                }
                if (this.currentEvent != null) {
                    if (this.currentEvent.getFuture().isDone()) {
                        this.currentEvent = null;
                    } else {
                        Object message = this.currentEvent.getMessage();
                        if (message instanceof ChunkedInput) {
                            ChunkedInput chunkedInput = (ChunkedInput) message;
                            try {
                                Object nextChunk = chunkedInput.nextChunk();
                                if (nextChunk == null) {
                                    nextChunk = ChannelBuffers.EMPTY_BUFFER;
                                    z = true;
                                } else {
                                    z = false;
                                }
                                boolean isEndOfInput = chunkedInput.isEndOfInput();
                                final MessageEvent messageEvent = this.currentEvent;
                                if (isEndOfInput) {
                                    this.currentEvent = null;
                                    closeInput(chunkedInput);
                                    channelFuture = messageEvent.getFuture();
                                } else {
                                    channelFuture = Channels.future(channel);
                                    channelFuture.addListener(new ChannelFutureListener() {
                                        public void operationComplete(ChannelFuture channelFuture) throws Exception {
                                            if (!channelFuture.isSuccess()) {
                                                messageEvent.getFuture().setFailure(channelFuture.getCause());
                                                ChunkedWriteHandler.closeInput((ChunkedInput) messageEvent.getMessage());
                                            }
                                        }
                                    });
                                }
                                Channels.write(channelHandlerContext, channelFuture, nextChunk, messageEvent.getRemoteAddress());
                                if (z) {
                                    break;
                                }
                            } catch (Throwable th) {
                                MessageEvent messageEvent2 = this.currentEvent;
                                this.currentEvent = null;
                                messageEvent2.getFuture().setFailure(th);
                                Channels.fireExceptionCaught(channelHandlerContext, th);
                                closeInput(chunkedInput);
                            }
                        } else {
                            MessageEvent messageEvent3 = this.currentEvent;
                            this.currentEvent = null;
                            channelHandlerContext.sendDownstream(messageEvent3);
                        }
                    }
                    if (!channel.isConnected()) {
                        discard(channelHandlerContext);
                        break;
                    }
                } else {
                    break;
                }
            } else {
                break;
            }
        }
    }

    public void handleDownstream(ChannelHandlerContext channelHandlerContext, ChannelEvent channelEvent) throws Exception {
        if (!(channelEvent instanceof MessageEvent)) {
            channelHandlerContext.sendDownstream(channelEvent);
            return;
        }
        this.queue.offer((MessageEvent) channelEvent);
        if (channelHandlerContext.getChannel().isWritable()) {
            this.ctx = channelHandlerContext;
            flush(channelHandlerContext);
        }
    }

    public void handleUpstream(ChannelHandlerContext channelHandlerContext, ChannelEvent channelEvent) throws Exception {
        if (channelEvent instanceof ChannelStateEvent) {
            ChannelStateEvent channelStateEvent = (ChannelStateEvent) channelEvent;
            int ordinal = channelStateEvent.getState().ordinal();
            if (ordinal != 0) {
                if (ordinal == 3) {
                    flush(channelHandlerContext);
                }
            } else if (!Boolean.TRUE.equals(channelStateEvent.getValue())) {
                discard(channelHandlerContext);
            }
        }
        channelHandlerContext.sendUpstream(channelEvent);
    }

    public void resumeTransfer() {
        ChannelHandlerContext channelHandlerContext = this.ctx;
        if (channelHandlerContext != null) {
            try {
                flush(channelHandlerContext);
            } catch (Exception e2) {
                logger.warn("Unexpected exception while sending chunks.", e2);
            }
        }
    }
}
