package org.apache.commons.net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.net.SocketFactory;

public class DefaultSocketFactory extends SocketFactory {
    private final Proxy connProxy;

    public DefaultSocketFactory() {
        this(null);
    }

    public DefaultSocketFactory(Proxy proxy) {
        this.connProxy = proxy;
    }

    public Socket createSocket() throws IOException {
        Proxy proxy = this.connProxy;
        if (proxy != null) {
            return new Socket(proxy);
        }
        return new Socket();
    }

    public Socket createSocket(String str, int i) throws UnknownHostException, IOException {
        Proxy proxy = this.connProxy;
        if (proxy == null) {
            return new Socket(str, i);
        }
        Socket socket = new Socket(proxy);
        socket.connect(new InetSocketAddress(str, i));
        return socket;
    }

    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        Proxy proxy = this.connProxy;
        if (proxy == null) {
            return new Socket(inetAddress, i);
        }
        Socket socket = new Socket(proxy);
        socket.connect(new InetSocketAddress(inetAddress, i));
        return socket;
    }

    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws UnknownHostException, IOException {
        Proxy proxy = this.connProxy;
        if (proxy == null) {
            return new Socket(str, i, inetAddress, i2);
        }
        Socket socket = new Socket(proxy);
        socket.bind(new InetSocketAddress(inetAddress, i2));
        socket.connect(new InetSocketAddress(str, i));
        return socket;
    }

    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        Proxy proxy = this.connProxy;
        if (proxy == null) {
            return new Socket(inetAddress, i, inetAddress2, i2);
        }
        Socket socket = new Socket(proxy);
        socket.bind(new InetSocketAddress(inetAddress2, i2));
        socket.connect(new InetSocketAddress(inetAddress, i));
        return socket;
    }

    public ServerSocket createServerSocket(int i) throws IOException {
        return new ServerSocket(i);
    }

    public ServerSocket createServerSocket(int i, int i2) throws IOException {
        return new ServerSocket(i, i2);
    }

    public ServerSocket createServerSocket(int i, int i2, InetAddress inetAddress) throws IOException {
        return new ServerSocket(i, i2, inetAddress);
    }
}
