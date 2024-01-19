package org.jboss.netty.channel.socket.oio;

import java.util.concurrent.Executor;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.socket.DatagramChannel;
import org.jboss.netty.channel.socket.DatagramChannelFactory;
import org.jboss.netty.util.internal.ExecutorUtil;

public class OioDatagramChannelFactory implements DatagramChannelFactory {
    public final OioDatagramPipelineSink sink;
    public final Executor workerExecutor;

    public OioDatagramChannelFactory(Executor executor) {
        if (executor != null) {
            this.workerExecutor = executor;
            this.sink = new OioDatagramPipelineSink(executor);
            return;
        }
        throw new NullPointerException("workerExecutor");
    }

    public void releaseExternalResources() {
        ExecutorUtil.terminate(this.workerExecutor);
    }

    public DatagramChannel newChannel(ChannelPipeline channelPipeline) {
        return new OioDatagramChannel(this, channelPipeline, this.sink);
    }
}
