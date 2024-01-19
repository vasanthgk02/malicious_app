package org.jboss.netty.channel.socket;

import java.net.Socket;
import java.net.SocketException;
import org.jboss.netty.channel.ChannelException;
import org.jboss.netty.channel.DefaultChannelConfig;
import org.jboss.netty.util.internal.ConversionUtil;

public class DefaultSocketChannelConfig extends DefaultChannelConfig implements SocketChannelConfig {
    public final Socket socket;

    public DefaultSocketChannelConfig(Socket socket2) {
        if (socket2 != null) {
            this.socket = socket2;
            return;
        }
        throw new NullPointerException("socket");
    }

    public int getReceiveBufferSize() {
        try {
            return this.socket.getReceiveBufferSize();
        } catch (SocketException e2) {
            throw new ChannelException((Throwable) e2);
        }
    }

    public int getSendBufferSize() {
        try {
            return this.socket.getSendBufferSize();
        } catch (SocketException e2) {
            throw new ChannelException((Throwable) e2);
        }
    }

    public int getSoLinger() {
        try {
            return this.socket.getSoLinger();
        } catch (SocketException e2) {
            throw new ChannelException((Throwable) e2);
        }
    }

    public int getTrafficClass() {
        try {
            return this.socket.getTrafficClass();
        } catch (SocketException e2) {
            throw new ChannelException((Throwable) e2);
        }
    }

    public boolean isKeepAlive() {
        try {
            return this.socket.getKeepAlive();
        } catch (SocketException e2) {
            throw new ChannelException((Throwable) e2);
        }
    }

    public boolean isReuseAddress() {
        try {
            return this.socket.getReuseAddress();
        } catch (SocketException e2) {
            throw new ChannelException((Throwable) e2);
        }
    }

    public boolean isTcpNoDelay() {
        try {
            return this.socket.getTcpNoDelay();
        } catch (SocketException e2) {
            throw new ChannelException((Throwable) e2);
        }
    }

    public void setKeepAlive(boolean z) {
        try {
            this.socket.setKeepAlive(z);
        } catch (SocketException e2) {
            throw new ChannelException((Throwable) e2);
        }
    }

    public boolean setOption(String str, Object obj) {
        if (super.setOption(str, obj)) {
            return true;
        }
        if (str.equals("receiveBufferSize")) {
            setReceiveBufferSize(ConversionUtil.toInt(obj));
        } else if (str.equals("sendBufferSize")) {
            setSendBufferSize(ConversionUtil.toInt(obj));
        } else if (str.equals("tcpNoDelay")) {
            setTcpNoDelay(ConversionUtil.toBoolean(obj));
        } else if (str.equals("keepAlive")) {
            setKeepAlive(ConversionUtil.toBoolean(obj));
        } else if (str.equals("reuseAddress")) {
            setReuseAddress(ConversionUtil.toBoolean(obj));
        } else if (str.equals("soLinger")) {
            setSoLinger(ConversionUtil.toInt(obj));
        } else if (!str.equals("trafficClass")) {
            return false;
        } else {
            setTrafficClass(ConversionUtil.toInt(obj));
        }
        return true;
    }

    public void setPerformancePreferences(int i, int i2, int i3) {
        this.socket.setPerformancePreferences(i, i2, i3);
    }

    public void setReceiveBufferSize(int i) {
        try {
            this.socket.setReceiveBufferSize(i);
        } catch (SocketException e2) {
            throw new ChannelException((Throwable) e2);
        }
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

    public void setSoLinger(int i) {
        if (i < 0) {
            try {
                this.socket.setSoLinger(false, 0);
            } catch (SocketException e2) {
                throw new ChannelException((Throwable) e2);
            }
        } else {
            this.socket.setSoLinger(true, i);
        }
    }

    public void setTcpNoDelay(boolean z) {
        try {
            this.socket.setTcpNoDelay(z);
        } catch (SocketException e2) {
            throw new ChannelException((Throwable) e2);
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
