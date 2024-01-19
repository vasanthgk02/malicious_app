package org.jboss.netty.channel.socket.nio;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.net.Socket;
import java.util.Map;
import org.jboss.netty.channel.AdaptiveReceiveBufferSizePredictorFactory;
import org.jboss.netty.channel.ChannelException;
import org.jboss.netty.channel.ReceiveBufferSizePredictor;
import org.jboss.netty.channel.ReceiveBufferSizePredictorFactory;
import org.jboss.netty.channel.socket.DefaultSocketChannelConfig;
import org.jboss.netty.logging.InternalLogger;
import org.jboss.netty.logging.InternalLoggerFactory;
import org.jboss.netty.util.internal.ConversionUtil;

public class DefaultNioSocketChannelConfig extends DefaultSocketChannelConfig implements NioSocketChannelConfig {
    public static final ReceiveBufferSizePredictorFactory DEFAULT_PREDICTOR_FACTORY = new AdaptiveReceiveBufferSizePredictorFactory();
    public static final InternalLogger logger = InternalLoggerFactory.getInstance(DefaultNioSocketChannelConfig.class);
    public volatile ReceiveBufferSizePredictor predictor;
    public volatile ReceiveBufferSizePredictorFactory predictorFactory = DEFAULT_PREDICTOR_FACTORY;
    public volatile int writeBufferHighWaterMark = 65536;
    public volatile int writeBufferLowWaterMark = 32768;
    public volatile int writeSpinCount = 16;

    public DefaultNioSocketChannelConfig(Socket socket) {
        super(socket);
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

    public ReceiveBufferSizePredictor getReceiveBufferSizePredictor() {
        ReceiveBufferSizePredictor receiveBufferSizePredictor = this.predictor;
        if (receiveBufferSizePredictor != null) {
            return receiveBufferSizePredictor;
        }
        try {
            ReceiveBufferSizePredictor predictor2 = getReceiveBufferSizePredictorFactory().getPredictor();
            this.predictor = predictor2;
            return predictor2;
        } catch (Exception e2) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Failed to create a new ");
            outline73.append(ReceiveBufferSizePredictor.class.getSimpleName());
            outline73.append('.');
            throw new ChannelException(outline73.toString(), e2);
        }
    }

    public ReceiveBufferSizePredictorFactory getReceiveBufferSizePredictorFactory() {
        return this.predictorFactory;
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
        } else if (str.equals("writeSpinCount")) {
            setWriteSpinCount(ConversionUtil.toInt(obj));
        } else if (str.equals("receiveBufferSizePredictorFactory")) {
            setReceiveBufferSizePredictorFactory((ReceiveBufferSizePredictorFactory) obj);
        } else if (!str.equals("receiveBufferSizePredictor")) {
            return false;
        } else {
            setReceiveBufferSizePredictor((ReceiveBufferSizePredictor) obj);
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

    public void setReceiveBufferSizePredictor(ReceiveBufferSizePredictor receiveBufferSizePredictor) {
        if (receiveBufferSizePredictor != null) {
            this.predictor = receiveBufferSizePredictor;
            return;
        }
        throw new NullPointerException("predictor");
    }

    public void setReceiveBufferSizePredictorFactory(ReceiveBufferSizePredictorFactory receiveBufferSizePredictorFactory) {
        if (receiveBufferSizePredictorFactory != null) {
            this.predictorFactory = receiveBufferSizePredictorFactory;
            return;
        }
        throw new NullPointerException("predictorFactory");
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
