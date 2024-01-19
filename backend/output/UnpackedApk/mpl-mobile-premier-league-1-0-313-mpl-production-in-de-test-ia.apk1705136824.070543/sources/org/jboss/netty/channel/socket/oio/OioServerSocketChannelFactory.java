package org.jboss.netty.channel.socket.oio;

import java.util.concurrent.Executor;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelSink;
import org.jboss.netty.channel.socket.ServerSocketChannel;
import org.jboss.netty.channel.socket.ServerSocketChannelFactory;
import org.jboss.netty.util.internal.ExecutorUtil;

public class OioServerSocketChannelFactory implements ServerSocketChannelFactory {
    public final Executor bossExecutor;
    public final ChannelSink sink;
    public final Executor workerExecutor;

    public OioServerSocketChannelFactory(Executor executor, Executor executor2) {
        if (executor == null) {
            throw new NullPointerException("bossExecutor");
        } else if (executor2 != null) {
            this.bossExecutor = executor;
            this.workerExecutor = executor2;
            this.sink = new OioServerSocketPipelineSink(executor2);
        } else {
            throw new NullPointerException("workerExecutor");
        }
    }

    public void releaseExternalResources() {
        ExecutorUtil.terminate(this.bossExecutor, this.workerExecutor);
    }

    public ServerSocketChannel newChannel(ChannelPipeline channelPipeline) {
        return new OioServerSocketChannel(this, channelPipeline, this.sink);
    }
}
