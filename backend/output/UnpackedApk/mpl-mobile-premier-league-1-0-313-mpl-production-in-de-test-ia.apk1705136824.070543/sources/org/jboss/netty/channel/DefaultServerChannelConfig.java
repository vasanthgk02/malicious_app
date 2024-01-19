package org.jboss.netty.channel;

import java.util.Map;
import java.util.Map.Entry;
import org.jboss.netty.buffer.ChannelBufferFactory;
import org.jboss.netty.buffer.HeapChannelBufferFactory;

public class DefaultServerChannelConfig implements ChannelConfig {
    public volatile ChannelBufferFactory bufferFactory = HeapChannelBufferFactory.getInstance();
    public volatile ChannelPipelineFactory pipelineFactory;

    public ChannelBufferFactory getBufferFactory() {
        return this.bufferFactory;
    }

    public int getConnectTimeoutMillis() {
        return 0;
    }

    public ChannelPipelineFactory getPipelineFactory() {
        return this.pipelineFactory;
    }

    public void setBufferFactory(ChannelBufferFactory channelBufferFactory) {
        if (channelBufferFactory != null) {
            this.bufferFactory = channelBufferFactory;
            return;
        }
        throw new NullPointerException("bufferFactory");
    }

    public void setConnectTimeoutMillis(int i) {
    }

    public boolean setOption(String str, Object obj) {
        if (str.equals("pipelineFactory")) {
            setPipelineFactory((ChannelPipelineFactory) obj);
        } else if (!str.equals("bufferFactory")) {
            return false;
        } else {
            setBufferFactory((ChannelBufferFactory) obj);
        }
        return true;
    }

    public void setOptions(Map<String, Object> map) {
        for (Entry next : map.entrySet()) {
            setOption((String) next.getKey(), next.getValue());
        }
    }

    public void setPipelineFactory(ChannelPipelineFactory channelPipelineFactory) {
        if (channelPipelineFactory != null) {
            this.pipelineFactory = channelPipelineFactory;
            return;
        }
        throw new NullPointerException("pipelineFactory");
    }
}
