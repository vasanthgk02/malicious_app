package org.jboss.netty.channel.socket.nio;

import java.util.concurrent.Executor;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.socket.DatagramChannel;
import org.jboss.netty.channel.socket.DatagramChannelFactory;
import org.jboss.netty.util.internal.ExecutorUtil;

public class NioDatagramChannelFactory implements DatagramChannelFactory {
    public final NioDatagramPipelineSink sink;
    public final Executor workerExecutor;

    public NioDatagramChannelFactory(Executor executor) {
        this(executor, SelectorUtil.DEFAULT_IO_THREADS);
    }

    public void releaseExternalResources() {
        ExecutorUtil.terminate(this.workerExecutor);
    }

    public NioDatagramChannelFactory(Executor executor, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException(String.format("workerCount (%s) must be a positive integer.", new Object[]{Integer.valueOf(i)}));
        } else if (executor != null) {
            this.workerExecutor = executor;
            this.sink = new NioDatagramPipelineSink(executor, i);
        } else {
            throw new NullPointerException("workerExecutor argument must not be null");
        }
    }

    public DatagramChannel newChannel(ChannelPipeline channelPipeline) {
        NioDatagramPipelineSink nioDatagramPipelineSink = this.sink;
        return new NioDatagramChannel(this, channelPipeline, nioDatagramPipelineSink, nioDatagramPipelineSink.nextWorker());
    }
}
