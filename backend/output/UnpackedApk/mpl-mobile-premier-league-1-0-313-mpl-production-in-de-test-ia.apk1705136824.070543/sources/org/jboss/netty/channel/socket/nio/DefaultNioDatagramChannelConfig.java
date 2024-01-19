package org.jboss.netty.channel.socket.nio;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.net.DatagramSocket;
import java.util.Map;
import org.jboss.netty.channel.socket.DefaultDatagramChannelConfig;
import org.jboss.netty.logging.InternalLogger;
import org.jboss.netty.logging.InternalLoggerFactory;
import org.jboss.netty.util.internal.ConversionUtil;

public class DefaultNioDatagramChannelConfig extends DefaultDatagramChannelConfig implements NioDatagramChannelConfig {
    public static final InternalLogger logger = InternalLoggerFactory.getInstance(DefaultNioDatagramChannelConfig.class);
    public volatile int writeBufferHighWaterMark = 65536;
    public volatile int writeBufferLowWaterMark = 32768;
    public volatile int writeSpinCount = 16;

    public DefaultNioDatagramChannelConfig(DatagramSocket datagramSocket) {
        super(datagramSocket);
    }

    private void setWriteBufferHighWaterMark0(int i) {
        if (i >= 0) {
            this.writeBufferHighWaterMark = i;
            return;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("writeBufferHighWaterMark: ", i));
    }

    private void setWriteBufferLowWaterMark0(int i) {
        if (i >= 0) {
            this.writeBufferLowWaterMark = i;
            return;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("writeBufferLowWaterMark: ", i));
    }

    public int getWriteBufferHighWaterMark() {
        return this.writeBufferHighWaterMark;
    }

    public int getWriteBufferLowWaterMark() {
        return this.writeBufferLowWaterMark;
    }

    public int getWriteSpinCount() {
        return this.writeSpinCount;
    }

    public boolean setOption(String str, Object obj) {
        if (super.setOption(str, obj)) {
            return true;
        }
        if (str.equals("writeBufferHighWaterMark")) {
            setWriteBufferHighWaterMark0(ConversionUtil.toInt(obj));
        } else if (str.equals("writeBufferLowWaterMark")) {
            setWriteBufferLowWaterMark0(ConversionUtil.toInt(obj));
        } else if (!str.equals("writeSpinCount")) {
            return false;
        } else {
            setWriteSpinCount(ConversionUtil.toInt(obj));
        }
        return true;
    }

    public void setOptions(Map<String, Object> map) {
        super.setOptions(map);
        if (getWriteBufferHighWaterMark() < getWriteBufferLowWaterMark()) {
            setWriteBufferLowWaterMark0(getWriteBufferHighWaterMark() >>> 1);
            logger.warn("writeBufferLowWaterMark cannot be greater than writeBufferHighWaterMark; setting to the half of the writeBufferHighWaterMark.");
        }
    }

    public void setWriteBufferHighWaterMark(int i) {
        if (i >= getWriteBufferLowWaterMark()) {
            setWriteBufferHighWaterMark0(i);
            return;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("writeBufferHighWaterMark cannot be less than writeBufferLowWaterMark (");
        outline73.append(getWriteBufferLowWaterMark());
        outline73.append("): ");
        outline73.append(i);
        throw new IllegalArgumentException(outline73.toString());
    }

    public void setWriteBufferLowWaterMark(int i) {
        if (i <= getWriteBufferHighWaterMark()) {
            setWriteBufferLowWaterMark0(i);
            return;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("writeBufferLowWaterMark cannot be greater than writeBufferHighWaterMark (");
        outline73.append(getWriteBufferHighWaterMark());
        outline73.append("): ");
        outline73.append(i);
        throw new IllegalArgumentException(outline73.toString());
    }

    public void setWriteSpinCount(int i) {
        if (i > 0) {
            this.writeSpinCount = i;
            return;
        }
        throw new IllegalArgumentException("writeSpinCount must be a positive integer.");
    }
}
