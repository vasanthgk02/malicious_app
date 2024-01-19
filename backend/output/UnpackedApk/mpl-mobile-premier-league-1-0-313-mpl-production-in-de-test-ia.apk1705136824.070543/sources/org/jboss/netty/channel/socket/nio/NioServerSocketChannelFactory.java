package org.jboss.netty.channel.socket.nio;

import java.util.concurrent.Executor;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelSink;
import org.jboss.netty.channel.socket.ServerSocketChannel;
import org.jboss.netty.channel.socket.ServerSocketChannelFactory;
import org.jboss.netty.util.internal.ExecutorUtil;

public class NioServerSocketChannelFactory implements ServerSocketChannelFactory {
    public final Executor bossExecutor;
    public final ChannelSink sink;
    public final Executor workerExecutor;

    public NioServerSocketChannelFactory(Executor executor, Executor executor2) {
        this(executor, executor2, SelectorUtil.DEFAULT_IO_THREADS);
    }

    public void releaseExternalResources() {
        ExecutorUtil.terminate(this.bossExecutor, this.workerExecutor);
    }

    public NioServerSocketChannelFactory(Executor executor, Executor executor2, int i) {
        if (executor == null) {
            throw new NullPointerException("bossExecutor");
        } else if (executor2 == null) {
            throw new NullPointerException("workerExecutor");
        } else if (i > 0) {
            this.bossExecutor = executor;
            this.workerExecutor = executor2;
            this.sink = new NioServerSocketPipelineSink(executor2, i);
        } else {
            throw new IllegalArgumentException("workerCount (" + i + ") " + "must be a positive integer.");
        }
    }

    public ServerSocketChannel newChannel(ChannelPipeline channelPipeline) {
        return new NioServerSocketChannel(this, channelPipeline, this.sink);
    }
}
