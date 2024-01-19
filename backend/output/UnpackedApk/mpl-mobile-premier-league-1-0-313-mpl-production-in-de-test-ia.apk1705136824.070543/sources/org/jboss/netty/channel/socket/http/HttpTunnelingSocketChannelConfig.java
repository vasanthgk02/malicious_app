package org.jboss.netty.channel.socket.http;

import java.util.Map;
import java.util.Map.Entry;
import javax.net.ssl.SSLContext;
import org.jboss.netty.buffer.ChannelBufferFactory;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.socket.SocketChannelConfig;
import org.jboss.netty.util.internal.ConversionUtil;

public final class HttpTunnelingSocketChannelConfig implements SocketChannelConfig {
    public final HttpTunnelingClientSocketChannel channel;
    public volatile boolean enableSslSessionCreation = true;
    public volatile String[] enabledSslCipherSuites;
    public volatile String[] enabledSslProtocols;
    public volatile String serverName;
    public volatile String serverPath = "/netty-tunnel";
    public volatile SSLContext sslContext;

    public HttpTunnelingSocketChannelConfig(HttpTunnelingClientSocketChannel httpTunnelingClientSocketChannel) {
        this.channel = httpTunnelingClientSocketChannel;
    }

    public ChannelBufferFactory getBufferFactory() {
        return this.channel.realChannel.getConfig().getBufferFactory();
    }

    public int getConnectTimeoutMillis() {
        return this.channel.realChannel.getConfig().getConnectTimeoutMillis();
    }

    public String[] getEnabledSslCipherSuites() {
        String[] strArr = this.enabledSslCipherSuites;
        if (strArr == null) {
            return null;
        }
        return (String[]) strArr.clone();
    }

    public String[] getEnabledSslProtocols() {
        String[] strArr = this.enabledSslProtocols;
        if (strArr == null) {
            return null;
        }
        return (String[]) strArr.clone();
    }

    public ChannelPipelineFactory getPipelineFactory() {
        return this.channel.realChannel.getConfig().getPipelineFactory();
    }

    public int getReceiveBufferSize() {
        return this.channel.realChannel.getConfig().getReceiveBufferSize();
    }

    public int getSendBufferSize() {
        return this.channel.realChannel.getConfig().getSendBufferSize();
    }

    public String getServerName() {
        return this.serverName;
    }

    public String getServerPath() {
        return this.serverPath;
    }

    public int getSoLinger() {
        return this.channel.realChannel.getConfig().getSoLinger();
    }

    public SSLContext getSslContext() {
        return this.sslContext;
    }

    public int getTrafficClass() {
        return this.channel.realChannel.getConfig().getTrafficClass();
    }

    public boolean isEnableSslSessionCreation() {
        return this.enableSslSessionCreation;
    }

    public boolean isKeepAlive() {
        return this.channel.realChannel.getConfig().isKeepAlive();
    }

    public boolean isReuseAddress() {
        return this.channel.realChannel.getConfig().isReuseAddress();
    }

    public boolean isTcpNoDelay() {
        return this.channel.realChannel.getConfig().isTcpNoDelay();
    }

    public void setBufferFactory(ChannelBufferFactory channelBufferFactory) {
        this.channel.realChannel.getConfig().setBufferFactory(channelBufferFactory);
    }

    public void setConnectTimeoutMillis(int i) {
        this.channel.realChannel.getConfig().setConnectTimeoutMillis(i);
    }

    public void setEnableSslSessionCreation(boolean z) {
        this.enableSslSessionCreation = z;
    }

    public void setEnabledSslCipherSuites(String[] strArr) {
        if (strArr == null) {
            this.enabledSslCipherSuites = null;
        } else {
            this.enabledSslCipherSuites = (String[]) strArr.clone();
        }
    }

    public void setEnabledSslProtocols(String[] strArr) {
        if (strArr == null) {
            this.enabledSslProtocols = null;
        } else {
            this.enabledSslProtocols = (String[]) strArr.clone();
        }
    }

    public void setKeepAlive(boolean z) {
        this.channel.realChannel.getConfig().setKeepAlive(z);
    }

    public boolean setOption(String str, Object obj) {
        if (this.channel.realChannel.getConfig().setOption(str, obj)) {
            return true;
        }
        if (str.equals("serverName")) {
            setServerName(String.valueOf(obj));
        } else if (str.equals("serverPath")) {
            setServerPath(String.valueOf(obj));
        } else if (str.equals("sslContext")) {
            setSslContext((SSLContext) obj);
        } else if (str.equals("enabledSslCipherSuites")) {
            setEnabledSslCipherSuites(ConversionUtil.toStringArray(obj));
        } else if (str.equals("enabledSslProtocols")) {
            setEnabledSslProtocols(ConversionUtil.toStringArray(obj));
        } else if (!str.equals("enableSslSessionCreation")) {
            return false;
        } else {
            setEnableSslSessionCreation(ConversionUtil.toBoolean(obj));
        }
        return true;
    }

    public void setOptions(Map<String, Object> map) {
        for (Entry next : map.entrySet()) {
            setOption((String) next.getKey(), next.getValue());
        }
    }

    public void setPerformancePreferences(int i, int i2, int i3) {
        this.channel.realChannel.getConfig().setPerformancePreferences(i, i2, i3);
    }

    public void setPipelineFactory(ChannelPipelineFactory channelPipelineFactory) {
        this.channel.realChannel.getConfig().setPipelineFactory(channelPipelineFactory);
    }

    public void setReceiveBufferSize(int i) {
        this.channel.realChannel.getConfig().setReceiveBufferSize(i);
    }

    public void setReuseAddress(boolean z) {
        this.channel.realChannel.getConfig().setReuseAddress(z);
    }

    public void setSendBufferSize(int i) {
        this.channel.realChannel.getConfig().setSendBufferSize(i);
    }

    public void setServerName(String str) {
        this.serverName = str;
    }

    public void setServerPath(String str) {
        if (str != null) {
            this.serverPath = str;
            return;
        }
        throw new NullPointerException("serverPath");
    }

    public void setSoLinger(int i) {
        this.channel.realChannel.getConfig().setSoLinger(i);
    }

    public void setSslContext(SSLContext sSLContext) {
        this.sslContext = sSLContext;
    }

    public void setTcpNoDelay(boolean z) {
        this.channel.realChannel.getConfig().setTcpNoDelay(z);
    }

    public void setTrafficClass(int i) {
        this.channel.realChannel.getConfig().setTrafficClass(i);
    }
}
