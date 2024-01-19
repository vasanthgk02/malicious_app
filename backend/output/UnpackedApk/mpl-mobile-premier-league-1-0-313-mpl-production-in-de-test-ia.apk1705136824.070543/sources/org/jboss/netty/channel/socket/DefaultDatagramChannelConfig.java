package org.jboss.netty.channel.socket;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.graphics.GL20;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.net.SocketException;
import org.jboss.netty.channel.ChannelException;
import org.jboss.netty.channel.DefaultChannelConfig;
import org.jboss.netty.channel.FixedReceiveBufferSizePredictorFactory;
import org.jboss.netty.channel.ReceiveBufferSizePredictor;
import org.jboss.netty.channel.ReceiveBufferSizePredictorFactory;
import org.jboss.netty.util.internal.ConversionUtil;

public class DefaultDatagramChannelConfig extends DefaultChannelConfig implements DatagramChannelConfig {
    public static final ReceiveBufferSizePredictorFactory DEFAULT_PREDICTOR_FACTORY = new FixedReceiveBufferSizePredictorFactory(GL20.GL_SRC_COLOR);
    public volatile ReceiveBufferSizePredictor predictor;
    public volatile ReceiveBufferSizePredictorFactory predictorFactory = DEFAULT_PREDICTOR_FACTORY;
    public final DatagramSocket socket;

    public DefaultDatagramChannelConfig(DatagramSocket datagramSocket) {
        if (datagramSocket != null) {
            this.socket = datagramSocket;
            return;
        }
        throw new NullPointerException("socket");
    }

    public InetAddress getInterface() {
        DatagramSocket datagramSocket = this.socket;
        if (datagramSocket instanceof MulticastSocket) {
            try {
                return ((MulticastSocket) datagramSocket).getInterface();
            } catch (SocketException e2) {
                throw new ChannelException((Throwable) e2);
            }
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public NetworkInterface getNetworkInterface() {
        DatagramSocket datagramSocket = this.socket;
        if (datagramSocket instanceof MulticastSocket) {
            try {
                return ((MulticastSocket) datagramSocket).getNetworkInterface();
            } catch (SocketException e2) {
                throw new ChannelException((Throwable) e2);
            }
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public int getReceiveBufferSize() {
        try {
            return this.socket.getReceiveBufferSize();
        } catch (SocketException e2) {
            throw new ChannelException((Throwable) e2);
        }
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

    public int getSendBufferSize() {
        try {
            return this.socket.getSendBufferSize();
        } catch (SocketException e2) {
            throw new ChannelException((Throwable) e2);
        }
    }

    public int getTimeToLive() {
        DatagramSocket datagramSocket = this.socket;
        if (datagramSocket instanceof MulticastSocket) {
            try {
                return ((MulticastSocket) datagramSocket).getTimeToLive();
            } catch (IOException e2) {
                throw new ChannelException((Throwable) e2);
            }
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public int getTrafficClass() {
        try {
            return this.socket.getTrafficClass();
        } catch (SocketException e2) {
            throw new ChannelException((Throwable) e2);
        }
    }

    public boolean isBroadcast() {
        try {
            return this.socket.getBroadcast();
        } catch (SocketException e2) {
            throw new ChannelException((Throwable) e2);
        }
    }

    public boolean isLoopbackModeDisabled() {
        DatagramSocket datagramSocket = this.socket;
        if (datagramSocket instanceof MulticastSocket) {
            try {
                return ((MulticastSocket) datagramSocket).getLoopbackMode();
            } catch (SocketException e2) {
                throw new ChannelException((Throwable) e2);
            }
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public boolean isReuseAddress() {
        try {
            return this.socket.getReuseAddress();
        } catch (SocketException e2) {
            throw new ChannelException((Throwable) e2);
        }
    }

    public void setBroadcast(boolean z) {
        try {
            this.socket.setBroadcast(z);
        } catch (SocketException e2) {
            throw new ChannelException((Throwable) e2);
        }
    }

    public void setInterface(InetAddress inetAddress) {
        DatagramSocket datagramSocket = this.socket;
        if (datagramSocket instanceof MulticastSocket) {
            try {
                ((MulticastSocket) datagramSocket).setInterface(inetAddress);
            } catch (SocketException e2) {
                throw new ChannelException((Throwable) e2);
            }
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public void setLoopbackModeDisabled(boolean z) {
        DatagramSocket datagramSocket = this.socket;
        if (datagramSocket instanceof MulticastSocket) {
            try {
                ((MulticastSocket) datagramSocket).setLoopbackMode(z);
            } catch (SocketException e2) {
                throw new ChannelException((Throwable) e2);
            }
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public void setNetworkInterface(NetworkInterface networkInterface) {
        DatagramSocket datagramSocket = this.socket;
        if (datagramSocket instanceof MulticastSocket) {
            try {
                ((MulticastSocket) datagramSocket).setNetworkInterface(networkInterface);
            } catch (SocketException e2) {
                throw new ChannelException((Throwable) e2);
            }
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public boolean setOption(String str, Object obj) {
        if (super.setOption(str, obj)) {
            return true;
        }
        if (str.equals("broadcast")) {
            setBroadcast(ConversionUtil.toBoolean(obj));
        } else if (str.equals("receiveBufferSize")) {
            setReceiveBufferSize(ConversionUtil.toInt(obj));
        } else if (str.equals("sendBufferSize")) {
            setSendBufferSize(ConversionUtil.toInt(obj));
        } else if (str.equals("receiveBufferSizePredictorFactory")) {
            setReceiveBufferSizePredictorFactory((ReceiveBufferSizePredictorFactory) obj);
        } else if (str.equals("receiveBufferSizePredictor")) {
            setReceiveBufferSizePredictor((ReceiveBufferSizePredictor) obj);
        } else if (str.equals("reuseAddress")) {
            setReuseAddress(ConversionUtil.toBoolean(obj));
        } else if (str.equals("loopbackModeDisabled")) {
            setLoopbackModeDisabled(ConversionUtil.toBoolean(obj));
        } else if (str.equals("interface")) {
            setInterface((InetAddress) obj);
        } else if (str.equals("networkInterface")) {
            setNetworkInterface((NetworkInterface) obj);
        } else if (str.equals("timeToLive")) {
            setTimeToLive(ConversionUtil.toInt(obj));
        } else if (!str.equals("trafficClass")) {
            return false;
        } else {
            setTrafficClass(ConversionUtil.toInt(obj));
        }
        return true;
    }

    public void setReceiveBufferSize(int i) {
        try {
            this.socket.setReceiveBufferSize(i);
        } catch (SocketException e2) {
            throw new ChannelException((Throwable) e2);
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

    public void setReuseAddress(boolean z) {
        try {
            this.socket.setReuseAddress(z);
        } catch (SocketException e2) {
            throw new ChannelException((Throwable) e2);
        }
    }

    public void setSendBufferSize(int i) {
        try {
            this.socket.setSendBufferSize(i);
        } catch (SocketException e2) {
            throw new ChannelException((Throwable) e2);
        }
    }

    public void setTimeToLive(int i) {
        DatagramSocket datagramSocket = this.socket;
        if (datagramSocket instanceof MulticastSocket) {
            try {
                ((MulticastSocket) datagramSocket).setTimeToLive(i);
            } catch (IOException e2) {
                throw new ChannelException((Throwable) e2);
            }
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public void setTrafficClass(int i) {
        try {
            this.socket.setTrafficClass(i);
        } catch (SocketException e2) {
            throw new ChannelException((Throwable) e2);
        }
    }
}
