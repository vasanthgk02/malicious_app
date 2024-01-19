package org.jboss.netty.channel.socket.oio;

import java.util.concurrent.Executor;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.socket.ClientSocketChannelFactory;
import org.jboss.netty.channel.socket.SocketChannel;
import org.jboss.netty.util.internal.ExecutorUtil;

public class OioClientSocketChannelFactory implements ClientSocketChannelFactory {
    public final OioClientSocketPipelineSink sink;
    public final Executor workerExecutor;

    public OioClientSocketChannelFactory(Executor executor) {
        if (executor != null) {
            this.workerExecutor = executor;
            this.sink = new OioClientSocketPipelineSink(executor);
            return;
        }
        throw new NullPointerException("workerExecutor");
    }

    public void releaseExternalResources() {
        ExecutorUtil.terminate(this.workerExecutor);
    }

    public SocketChannel newChannel(ChannelPipeline channelPipeline) {
        return new OioClientSocketChannel(this, channelPipeline, this.sink);
    }
}
