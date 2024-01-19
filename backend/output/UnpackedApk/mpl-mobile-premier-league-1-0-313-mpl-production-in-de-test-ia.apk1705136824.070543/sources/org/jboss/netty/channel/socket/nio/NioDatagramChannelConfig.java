package org.jboss.netty.channel.socket.nio;

import org.jboss.netty.channel.socket.DatagramChannelConfig;

public interface NioDatagramChannelConfig extends DatagramChannelConfig {
    int getWriteBufferHighWaterMark();

    int getWriteBufferLowWaterMark();

    int getWriteSpinCount();

    void setWriteBufferHighWaterMark(int i);

    void setWriteBufferLowWaterMark(int i);

    void setWriteSpinCount(int i);
}
