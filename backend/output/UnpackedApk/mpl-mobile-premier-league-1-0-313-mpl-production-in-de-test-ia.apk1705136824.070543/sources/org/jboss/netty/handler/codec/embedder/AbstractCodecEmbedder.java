package org.jboss.netty.handler.codec.embedder;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.lang.reflect.Array;
import java.util.ConcurrentModificationException;
import java.util.LinkedList;
import java.util.Queue;
import org.apache.fontbox.cmap.CMapParser;
import org.jboss.netty.buffer.ChannelBufferFactory;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelEvent;
import org.jboss.netty.channel.ChannelHandler;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineException;
import org.jboss.netty.channel.ChannelSink;
import org.jboss.netty.channel.ChannelUpstreamHandler;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.DefaultChannelPipeline;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;

public abstract class AbstractCodecEmbedder<E> implements CodecEmbedder<E> {
    public final Channel channel;
    public final ChannelPipeline pipeline;
    public final Queue<Object> productQueue;
    public final EmbeddedChannelSink sink;

    public static final class EmbeddedChannelPipeline extends DefaultChannelPipeline {
        public void notifyHandlerException(ChannelEvent channelEvent, Throwable th) {
            while ((th instanceof ChannelPipelineException) && th.getCause() != null) {
                th = th.getCause();
            }
            if (th instanceof CodecEmbedderException) {
                throw ((CodecEmbedderException) th);
            }
            throw new CodecEmbedderException(th);
        }
    }

    public final class EmbeddedChannelSink implements ChannelSink, ChannelUpstreamHandler {
        public static final /* synthetic */ boolean $assertionsDisabled = false;

        public EmbeddedChannelSink() {
        }

        private void handleEvent(ChannelEvent channelEvent) {
            if (channelEvent instanceof MessageEvent) {
                AbstractCodecEmbedder.this.productQueue.offer(((MessageEvent) channelEvent).getMessage());
            } else if (channelEvent instanceof ExceptionEvent) {
                throw new CodecEmbedderException(((ExceptionEvent) channelEvent).getCause());
            }
        }

        public void eventSunk(ChannelPipeline channelPipeline, ChannelEvent channelEvent) {
            handleEvent(channelEvent);
        }

        /* JADX WARNING: type inference failed for: r1v1, types: [java.lang.Throwable] */
        /* JADX WARNING: type inference failed for: r3v1, types: [java.lang.Throwable] */
        /* JADX WARNING: type inference failed for: r3v2 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void exceptionCaught(org.jboss.netty.channel.ChannelPipeline r1, org.jboss.netty.channel.ChannelEvent r2, org.jboss.netty.channel.ChannelPipelineException r3) throws java.lang.Exception {
            /*
                r0 = this;
                java.lang.Throwable r1 = r3.getCause()
                if (r1 != 0) goto L_0x0007
                goto L_0x0008
            L_0x0007:
                r3 = r1
            L_0x0008:
                org.jboss.netty.handler.codec.embedder.CodecEmbedderException r1 = new org.jboss.netty.handler.codec.embedder.CodecEmbedderException
                r1.<init>(r3)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.handler.codec.embedder.AbstractCodecEmbedder.EmbeddedChannelSink.exceptionCaught(org.jboss.netty.channel.ChannelPipeline, org.jboss.netty.channel.ChannelEvent, org.jboss.netty.channel.ChannelPipelineException):void");
        }

        public void handleUpstream(ChannelHandlerContext channelHandlerContext, ChannelEvent channelEvent) {
            handleEvent(channelEvent);
        }
    }

    public AbstractCodecEmbedder(ChannelHandler... channelHandlerArr) {
        this.sink = new EmbeddedChannelSink<>();
        this.productQueue = new LinkedList();
        this.pipeline = new EmbeddedChannelPipeline();
        configurePipeline(channelHandlerArr);
        this.channel = new EmbeddedChannel(this.pipeline, this.sink);
        fireInitialEvents();
    }

    private void configurePipeline(ChannelHandler... channelHandlerArr) {
        if (channelHandlerArr == null) {
            throw new NullPointerException("handlers");
        } else if (channelHandlerArr.length != 0) {
            int i = 0;
            while (i < channelHandlerArr.length) {
                if (channelHandlerArr[i] != null) {
                    this.pipeline.addLast(String.valueOf(i), channelHandlerArr[i]);
                    i++;
                } else {
                    throw new NullPointerException(GeneratedOutlineSupport.outline42("handlers[", i, CMapParser.MARK_END_OF_ARRAY));
                }
            }
            this.pipeline.addLast("SINK", this.sink);
        } else {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("handlers should contain at least one ");
            outline73.append(ChannelHandler.class.getSimpleName());
            outline73.append('.');
            throw new IllegalArgumentException(outline73.toString());
        }
    }

    private void fireInitialEvents() {
        Channels.fireChannelOpen(this.channel);
        Channel channel2 = this.channel;
        Channels.fireChannelBound(channel2, channel2.getLocalAddress());
        Channel channel3 = this.channel;
        Channels.fireChannelConnected(channel3, channel3.getRemoteAddress());
    }

    public boolean finish() {
        Channels.close(this.channel);
        Channels.fireChannelDisconnected(this.channel);
        Channels.fireChannelUnbound(this.channel);
        Channels.fireChannelClosed(this.channel);
        return !this.productQueue.isEmpty();
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final boolean isEmpty() {
        return this.productQueue.isEmpty();
    }

    public final E peek() {
        return this.productQueue.peek();
    }

    public final E poll() {
        return this.productQueue.poll();
    }

    public final Object[] pollAll() {
        int size = size();
        Object[] objArr = new Object[size];
        int i = 0;
        while (i < size) {
            Object poll = poll();
            if (poll != null) {
                objArr[i] = poll;
                i++;
            } else {
                throw new ConcurrentModificationException();
            }
        }
        return objArr;
    }

    public final int size() {
        return this.productQueue.size();
    }

    public final <T> T[] pollAll(T[] tArr) {
        if (tArr != null) {
            int size = size();
            if (tArr.length < size) {
                tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), size);
            }
            int i = 0;
            while (true) {
                T poll = poll();
                if (poll == null) {
                    break;
                }
                tArr[i] = poll;
                i++;
            }
            if (tArr.length > size) {
                tArr[size] = null;
            }
            return tArr;
        }
        throw new NullPointerException("a");
    }

    public AbstractCodecEmbedder(ChannelBufferFactory channelBufferFactory, ChannelHandler... channelHandlerArr) {
        this(channelHandlerArr);
        getChannel().getConfig().setBufferFactory(channelBufferFactory);
    }
}
