package org.jboss.netty.channel;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Map;
import java.util.Map.Entry;
import org.jboss.netty.buffer.ChannelBufferFactory;
import org.jboss.netty.buffer.HeapChannelBufferFactory;
import org.jboss.netty.util.internal.ConversionUtil;

public class DefaultChannelConfig implements ChannelConfig {
    public volatile ChannelBufferFactory bufferFactory = HeapChannelBufferFactory.getInstance();
    public volatile int connectTimeoutMillis = 10000;

    public ChannelBufferFactory getBufferFactory() {
        return this.bufferFactory;
    }

    public int getConnectTimeoutMillis() {
        return this.connectTimeoutMillis;
    }

    public ChannelPipelineFactory getPipelineFactory() {
        return null;
    }

    public void setBufferFactory(ChannelBufferFactory channelBufferFactory) {
        if (channelBufferFactory != null) {
            this.bufferFactory = channelBufferFactory;
            return;
        }
        throw new NullPointerException("bufferFactory");
    }

    public void setConnectTimeoutMillis(int i) {
        if (i >= 0) {
            this.connectTimeoutMillis = i;
            return;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("connectTimeoutMillis: ", i));
    }

    public boolean setOption(String str, Object obj) {
        if (str.equals("pipelineFactory")) {
            setPipelineFactory((ChannelPipelineFactory) obj);
        } else if (str.equals("connectTimeoutMillis")) {
            setConnectTimeoutMillis(ConversionUtil.toInt(obj));
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
    }
}
