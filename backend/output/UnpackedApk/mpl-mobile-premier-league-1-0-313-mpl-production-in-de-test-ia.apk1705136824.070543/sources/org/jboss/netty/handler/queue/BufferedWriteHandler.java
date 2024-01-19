package org.jboss.netty.handler.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelFutureListener;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;
import org.jboss.netty.util.internal.LinkedTransferQueue;

public class BufferedWriteHandler extends SimpleChannelHandler {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public final boolean consolidateOnFlush;
    public volatile ChannelHandlerContext ctx;
    public final Queue<MessageEvent> queue;

    public BufferedWriteHandler() {
        this(false);
    }

    private List<MessageEvent> consolidatedWrite(final List<MessageEvent> list) {
        int size = list.size();
        if (size == 1) {
            this.ctx.sendDownstream(list.remove(0));
            return list;
        } else if (size == 0) {
            return list;
        } else {
            ChannelBuffer[] channelBufferArr = new ChannelBuffer[size];
            for (int i = 0; i < size; i++) {
                channelBufferArr[i] = (ChannelBuffer) list.get(i).getMessage();
            }
            ChannelBuffer wrappedBuffer = ChannelBuffers.wrappedBuffer(channelBufferArr);
            ChannelFuture future = Channels.future(this.ctx.getChannel());
            future.addListener(new ChannelFutureListener() {
                public void operationComplete(ChannelFuture channelFuture) throws Exception {
                    if (channelFuture.isSuccess()) {
                        for (MessageEvent future : list) {
                            future.getFuture().setSuccess();
                        }
                        return;
                    }
                    Throwable cause = channelFuture.getCause();
                    for (MessageEvent future2 : list) {
                        future2.getFuture().setFailure(cause);
                    }
                }
            });
            Channels.write(this.ctx, future, (Object) wrappedBuffer);
            return null;
        }
    }

    public void closeRequested(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) throws Exception {
        try {
            flush(this.consolidateOnFlush);
        } finally {
            channelHandlerContext.sendDownstream(channelStateEvent);
        }
    }

    public void disconnectRequested(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) throws Exception {
        try {
            flush(this.consolidateOnFlush);
        } finally {
            channelHandlerContext.sendDownstream(channelStateEvent);
        }
    }

    public void flush() {
        flush(this.consolidateOnFlush);
    }

    public Queue<MessageEvent> getQueue() {
        return this.queue;
    }

    public boolean isConsolidateOnFlush() {
        return this.consolidateOnFlush;
    }

    public void writeRequested(ChannelHandlerContext channelHandlerContext, MessageEvent messageEvent) throws Exception {
        if (this.ctx == null) {
            this.ctx = channelHandlerContext;
        }
        getQueue().add(messageEvent);
    }

    public BufferedWriteHandler(Queue<MessageEvent> queue2) {
        this(queue2, false);
    }

    public void flush(boolean z) {
        ChannelHandlerContext channelHandlerContext = this.ctx;
        if (channelHandlerContext != null) {
            Queue<MessageEvent> queue2 = getQueue();
            if (z) {
                if (!queue2.isEmpty()) {
                    List arrayList = new ArrayList();
                    synchronized (this) {
                        while (true) {
                            MessageEvent poll = queue2.poll();
                            if (poll == null) {
                                consolidatedWrite(arrayList);
                            } else if (!(poll.getMessage() instanceof ChannelBuffer)) {
                                arrayList = consolidatedWrite(arrayList);
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                }
                                channelHandlerContext.sendDownstream(poll);
                            } else {
                                arrayList.add(poll);
                            }
                        }
                    }
                    break;
                }
                return;
            }
            synchronized (this) {
                while (true) {
                    MessageEvent poll2 = queue2.poll();
                    if (poll2 == null) {
                        break;
                    }
                    channelHandlerContext.sendDownstream(poll2);
                }
            }
        }
    }

    public BufferedWriteHandler(boolean z) {
        this(new LinkedTransferQueue(), z);
    }

    public BufferedWriteHandler(Queue<MessageEvent> queue2, boolean z) {
        if (queue2 != null) {
            this.queue = queue2;
            this.consolidateOnFlush = z;
            return;
        }
        throw new NullPointerException("queue");
    }
}
