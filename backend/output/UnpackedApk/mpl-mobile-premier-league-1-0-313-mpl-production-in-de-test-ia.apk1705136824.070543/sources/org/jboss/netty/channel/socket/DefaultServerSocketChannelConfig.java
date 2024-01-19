package org.jboss.netty.channel.socket;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.net.ServerSocket;
import java.net.SocketException;
import org.jboss.netty.channel.ChannelException;
import org.jboss.netty.channel.DefaultServerChannelConfig;
import org.jboss.netty.util.internal.ConversionUtil;

public class DefaultServerSocketChannelConfig extends DefaultServerChannelConfig implements ServerSocketChannelConfig {
    public volatile int backlog;
    public final ServerSocket socket;

    public DefaultServerSocketChannelConfig(ServerSocket serverSocket) {
        if (serverSocket != null) {
            this.socket = serverSocket;
            return;
        }
        throw new NullPointerException("socket");
    }

    public int getBacklog() {
        return this.backlog;
    }

    public int getReceiveBufferSize() {
        try {
            return this.socket.getReceiveBufferSize();
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

    public void setBacklog(int i) {
        if (i >= 0) {
            this.backlog = i;
            return;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("backlog: ", i));
    }

    public boolean setOption(String str, Object obj) {
        if (super.setOption(str, obj)) {
            return true;
        }
        if (str.equals("receiveBufferSize")) {
            setReceiveBufferSize(ConversionUtil.toInt(obj));
        } else if (str.equals("reuseAddress")) {
            setReuseAddress(ConversionUtil.toBoolean(obj));
        } else if (!str.equals("backlog")) {
            return false;
        } else {
            setBacklog(ConversionUtil.toInt(obj));
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
}
