package org.apache.commons.net;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.nio.charset.Charset;
import javax.net.ServerSocketFactory;
import javax.net.SocketFactory;

public abstract class SocketClient {
    private static final int DEFAULT_CONNECT_TIMEOUT = 0;
    public static final String NETASCII_EOL = "\r\n";
    private static final ServerSocketFactory __DEFAULT_SERVER_SOCKET_FACTORY = ServerSocketFactory.getDefault();
    private static final SocketFactory __DEFAULT_SOCKET_FACTORY = SocketFactory.getDefault();
    private ProtocolCommandSupport __commandSupport;
    protected int _defaultPort_ = 0;
    protected InputStream _input_ = null;
    protected OutputStream _output_ = null;
    protected ServerSocketFactory _serverSocketFactory_ = __DEFAULT_SERVER_SOCKET_FACTORY;
    protected SocketFactory _socketFactory_ = __DEFAULT_SOCKET_FACTORY;
    protected Socket _socket_ = null;
    protected int _timeout_ = 0;
    private Charset charset = Charset.defaultCharset();
    private Proxy connProxy;
    protected int connectTimeout = 0;
    private int receiveBufferSize = -1;
    private int sendBufferSize = -1;

    /* access modifiers changed from: protected */
    public void _connectAction_() throws IOException {
        this._socket_.setSoTimeout(this._timeout_);
        this._input_ = this._socket_.getInputStream();
        this._output_ = this._socket_.getOutputStream();
    }

    public void connect(InetAddress inetAddress, int i) throws SocketException, IOException {
        this._socket_ = this._socketFactory_.createSocket();
        int i2 = this.receiveBufferSize;
        if (i2 != -1) {
            this._socket_.setReceiveBufferSize(i2);
        }
        int i3 = this.sendBufferSize;
        if (i3 != -1) {
            this._socket_.setSendBufferSize(i3);
        }
        this._socket_.connect(new InetSocketAddress(inetAddress, i), this.connectTimeout);
        _connectAction_();
    }

    public void connect(String str, int i) throws SocketException, IOException {
        connect(InetAddress.getByName(str), i);
    }

    public void connect(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws SocketException, IOException {
        this._socket_ = this._socketFactory_.createSocket();
        int i3 = this.receiveBufferSize;
        if (i3 != -1) {
            this._socket_.setReceiveBufferSize(i3);
        }
        int i4 = this.sendBufferSize;
        if (i4 != -1) {
            this._socket_.setSendBufferSize(i4);
        }
        this._socket_.bind(new InetSocketAddress(inetAddress2, i2));
        this._socket_.connect(new InetSocketAddress(inetAddress, i), this.connectTimeout);
        _connectAction_();
    }

    public void connect(String str, int i, InetAddress inetAddress, int i2) throws SocketException, IOException {
        connect(InetAddress.getByName(str), i, inetAddress, i2);
    }

    public void connect(InetAddress inetAddress) throws SocketException, IOException {
        connect(inetAddress, this._defaultPort_);
    }

    public void connect(String str) throws SocketException, IOException {
        connect(str, this._defaultPort_);
    }

    public void disconnect() throws IOException {
        closeQuietly(this._socket_);
        closeQuietly((Closeable) this._input_);
        closeQuietly((Closeable) this._output_);
        this._socket_ = null;
        this._input_ = null;
        this._output_ = null;
    }

    private void closeQuietly(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException unused) {
            }
        }
    }

    private void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public boolean isConnected() {
        Socket socket = this._socket_;
        if (socket == null) {
            return false;
        }
        return socket.isConnected();
    }

    public boolean isAvailable() {
        if (isConnected()) {
            try {
                if (this._socket_.getInetAddress() == null || this._socket_.getPort() == 0 || this._socket_.getRemoteSocketAddress() == null || this._socket_.isClosed() || this._socket_.isInputShutdown() || this._socket_.isOutputShutdown()) {
                    return false;
                }
                this._socket_.getInputStream();
                this._socket_.getOutputStream();
                return true;
            } catch (IOException unused) {
            }
        }
        return false;
    }

    public void setDefaultPort(int i) {
        this._defaultPort_ = i;
    }

    public int getDefaultPort() {
        return this._defaultPort_;
    }

    public void setDefaultTimeout(int i) {
        this._timeout_ = i;
    }

    public int getDefaultTimeout() {
        return this._timeout_;
    }

    public void setSoTimeout(int i) throws SocketException {
        this._socket_.setSoTimeout(i);
    }

    public void setSendBufferSize(int i) throws SocketException {
        this.sendBufferSize = i;
    }

    /* access modifiers changed from: protected */
    public int getSendBufferSize() {
        return this.sendBufferSize;
    }

    public void setReceiveBufferSize(int i) throws SocketException {
        this.receiveBufferSize = i;
    }

    /* access modifiers changed from: protected */
    public int getReceiveBufferSize() {
        return this.receiveBufferSize;
    }

    public int getSoTimeout() throws SocketException {
        return this._socket_.getSoTimeout();
    }

    public void setTcpNoDelay(boolean z) throws SocketException {
        this._socket_.setTcpNoDelay(z);
    }

    public boolean getTcpNoDelay() throws SocketException {
        return this._socket_.getTcpNoDelay();
    }

    public void setKeepAlive(boolean z) throws SocketException {
        this._socket_.setKeepAlive(z);
    }

    public boolean getKeepAlive() throws SocketException {
        return this._socket_.getKeepAlive();
    }

    public void setSoLinger(boolean z, int i) throws SocketException {
        this._socket_.setSoLinger(z, i);
    }

    public int getSoLinger() throws SocketException {
        return this._socket_.getSoLinger();
    }

    public int getLocalPort() {
        return this._socket_.getLocalPort();
    }

    public InetAddress getLocalAddress() {
        return this._socket_.getLocalAddress();
    }

    public int getRemotePort() {
        return this._socket_.getPort();
    }

    public InetAddress getRemoteAddress() {
        return this._socket_.getInetAddress();
    }

    public boolean verifyRemote(Socket socket) {
        return socket.getInetAddress().equals(getRemoteAddress());
    }

    public void setSocketFactory(SocketFactory socketFactory) {
        if (socketFactory == null) {
            this._socketFactory_ = __DEFAULT_SOCKET_FACTORY;
        } else {
            this._socketFactory_ = socketFactory;
        }
        this.connProxy = null;
    }

    public void setServerSocketFactory(ServerSocketFactory serverSocketFactory) {
        if (serverSocketFactory == null) {
            this._serverSocketFactory_ = __DEFAULT_SERVER_SOCKET_FACTORY;
        } else {
            this._serverSocketFactory_ = serverSocketFactory;
        }
    }

    public void setConnectTimeout(int i) {
        this.connectTimeout = i;
    }

    public int getConnectTimeout() {
        return this.connectTimeout;
    }

    public ServerSocketFactory getServerSocketFactory() {
        return this._serverSocketFactory_;
    }

    public void addProtocolCommandListener(ProtocolCommandListener protocolCommandListener) {
        getCommandSupport().addProtocolCommandListener(protocolCommandListener);
    }

    public void removeProtocolCommandListener(ProtocolCommandListener protocolCommandListener) {
        getCommandSupport().removeProtocolCommandListener(protocolCommandListener);
    }

    /* access modifiers changed from: protected */
    public void fireReplyReceived(int i, String str) {
        if (getCommandSupport().getListenerCount() > 0) {
            getCommandSupport().fireReplyReceived(i, str);
        }
    }

    /* access modifiers changed from: protected */
    public void fireCommandSent(String str, String str2) {
        if (getCommandSupport().getListenerCount() > 0) {
            getCommandSupport().fireCommandSent(str, str2);
        }
    }

    /* access modifiers changed from: protected */
    public void createCommandSupport() {
        this.__commandSupport = new ProtocolCommandSupport(this);
    }

    /* access modifiers changed from: protected */
    public ProtocolCommandSupport getCommandSupport() {
        return this.__commandSupport;
    }

    public void setProxy(Proxy proxy) {
        setSocketFactory(new DefaultSocketFactory(proxy));
        this.connProxy = proxy;
    }

    public Proxy getProxy() {
        return this.connProxy;
    }

    public String getCharsetName() {
        return this.charset.name();
    }

    public Charset getCharset() {
        return this.charset;
    }

    public void setCharset(Charset charset2) {
        this.charset = charset2;
    }
}
