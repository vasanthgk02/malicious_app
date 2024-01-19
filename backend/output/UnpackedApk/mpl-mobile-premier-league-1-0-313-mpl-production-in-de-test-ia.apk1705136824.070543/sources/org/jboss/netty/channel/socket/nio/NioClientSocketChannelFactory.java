package org.jboss.netty.channel.socket.nio;

import java.util.concurrent.Executor;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.socket.ClientSocketChannelFactory;
import org.jboss.netty.channel.socket.SocketChannel;
import org.jboss.netty.util.internal.ExecutorUtil;

public class NioClientSocketChannelFactory implements ClientSocketChannelFactory {
    public final Executor bossExecutor;
    public final NioClientSocketPipelineSink sink;
    public final Executor workerExecutor;

    public NioClientSocketChannelFactory(Executor executor, Executor executor2) {
        this(executor, executor2, SelectorUtil.DEFAULT_IO_THREADS);
    }

    public void releaseExternalResources() {
        ExecutorUtil.terminate(this.bossExecutor, this.workerExecutor);
    }

    public NioClientSocketChannelFactory(Executor executor, Executor executor2, int i) {
        if (executor == null) {
            throw new NullPointerException("bossExecutor");
        } else if (executor2 == null) {
            throw new NullPointerException("workerExecutor");
        } else if (i > 0) {
            this.bossExecutor = executor;
            this.workerExecutor = executor2;
            this.sink = new NioClientSocketPipelineSink(executor, executor2, i);
        } else {
            throw new IllegalArgumentException("workerCount (" + i + ") " + "must be a positive integer.");
        }
    }

    public SocketChannel newChannel(ChannelPipeline channelPipeline) {
        NioClientSocketPipelineSink nioClientSocketPipelineSink = this.sink;
        return new NioClientSocketChannel(this, channelPipeline, nioClientSocketPipelineSink, nioClientSocketPipelineSink.nextWorker());
    }
}
