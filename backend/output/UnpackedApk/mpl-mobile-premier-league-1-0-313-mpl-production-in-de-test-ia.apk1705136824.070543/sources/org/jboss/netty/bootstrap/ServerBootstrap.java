package org.jboss.netty.bootstrap;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.net.SocketAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelException;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelHandler;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.ChildChannelStateEvent;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.ServerChannelFactory;
import org.jboss.netty.channel.SimpleChannelUpstreamHandler;

public class ServerBootstrap extends Bootstrap {
    public volatile ChannelHandler parentHandler;

    public final class Binder extends SimpleChannelUpstreamHandler {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        public final Map<String, Object> childOptions = new HashMap();
        public final BlockingQueue<ChannelFuture> futureQueue;
        public final SocketAddress localAddress;

        public Binder(SocketAddress socketAddress, BlockingQueue<ChannelFuture> blockingQueue) {
            this.localAddress = socketAddress;
            this.futureQueue = blockingQueue;
        }

        /* JADX INFO: finally extract failed */
        public void channelOpen(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
            try {
                channelStateEvent.getChannel().getConfig().setPipelineFactory(ServerBootstrap.this.getPipelineFactory());
                Map<String, Object> options = ServerBootstrap.this.getOptions();
                HashMap hashMap = new HashMap();
                for (Entry next : options.entrySet()) {
                    if (((String) next.getKey()).startsWith("child.")) {
                        this.childOptions.put(((String) next.getKey()).substring(6), next.getValue());
                    } else if (!((String) next.getKey()).equals("pipelineFactory")) {
                        hashMap.put(next.getKey(), next.getValue());
                    }
                }
                channelStateEvent.getChannel().getConfig().setOptions(hashMap);
                channelHandlerContext.sendUpstream(channelStateEvent);
                this.futureQueue.offer(channelStateEvent.getChannel().bind(this.localAddress));
            } catch (Throwable th) {
                channelHandlerContext.sendUpstream(channelStateEvent);
                throw th;
            }
        }

        public void childChannelOpen(ChannelHandlerContext channelHandlerContext, ChildChannelStateEvent childChannelStateEvent) throws Exception {
            childChannelStateEvent.getChildChannel().getConfig().setOptions(this.childOptions);
            channelHandlerContext.sendUpstream(childChannelStateEvent);
        }

        public void exceptionCaught(ChannelHandlerContext channelHandlerContext, ExceptionEvent exceptionEvent) throws Exception {
            this.futureQueue.offer(Channels.failedFuture(exceptionEvent.getChannel(), exceptionEvent.getCause()));
            channelHandlerContext.sendUpstream(exceptionEvent);
        }
    }

    public ServerBootstrap() {
    }

    public Channel bind() {
        SocketAddress socketAddress = (SocketAddress) getOption("localAddress");
        if (socketAddress != null) {
            return bind(socketAddress);
        }
        throw new IllegalStateException("localAddress option is not set.");
    }

    public ChannelHandler getParentHandler() {
        return this.parentHandler;
    }

    public void setFactory(ChannelFactory channelFactory) {
        if (channelFactory == null) {
            throw new NullPointerException("factory");
        } else if (channelFactory instanceof ServerChannelFactory) {
            super.setFactory(channelFactory);
        } else {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("factory must be a ");
            outline73.append(ServerChannelFactory.class.getSimpleName());
            outline73.append(": ");
            outline73.append(channelFactory.getClass());
            throw new IllegalArgumentException(outline73.toString());
        }
    }

    public void setParentHandler(ChannelHandler channelHandler) {
        this.parentHandler = channelHandler;
    }

    public ServerBootstrap(ChannelFactory channelFactory) {
        super(channelFactory);
    }

    public Channel bind(SocketAddress socketAddress) {
        if (socketAddress != null) {
            LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
            Binder binder = new Binder(socketAddress, linkedBlockingQueue);
            ChannelHandler parentHandler2 = getParentHandler();
            ChannelPipeline pipeline = Channels.pipeline();
            pipeline.addLast("binder", binder);
            if (parentHandler2 != null) {
                pipeline.addLast("userHandler", parentHandler2);
            }
            Channel newChannel = getFactory().newChannel(pipeline);
            ChannelFuture channelFuture = null;
            boolean z = false;
            do {
                try {
                    channelFuture = (ChannelFuture) linkedBlockingQueue.poll(2147483647L, TimeUnit.SECONDS);
                    continue;
                } catch (InterruptedException unused) {
                    z = true;
                    continue;
                }
            } while (channelFuture == null);
            if (z) {
                Thread.currentThread().interrupt();
            }
            channelFuture.awaitUninterruptibly();
            if (channelFuture.isSuccess()) {
                return newChannel;
            }
            channelFuture.getChannel().close().awaitUninterruptibly();
            throw new ChannelException("Failed to bind to: " + socketAddress, channelFuture.getCause());
        }
        throw new NullPointerException("localAddress");
    }
}
