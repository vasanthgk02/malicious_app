package com.freshchat.consumer.sdk.e;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class g extends SSLSocketFactory {
    public SSLSocketFactory ku;

    public g(SSLSocketFactory sSLSocketFactory) throws KeyManagementException, NoSuchAlgorithmException {
        this.ku = sSLSocketFactory;
    }

    private Socket a(Socket socket) {
        if (socket != null && (socket instanceof SSLSocket)) {
            ((SSLSocket) socket).setEnabledProtocols(new String[]{"TLSv1.1", "TLSv1.2"});
        }
        return socket;
    }

    public Socket createSocket(String str, int i) throws IOException, UnknownHostException {
        return a(this.ku.createSocket(str, i));
    }

    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException, UnknownHostException {
        return a(this.ku.createSocket(str, i, inetAddress, i2));
    }

    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        return a(this.ku.createSocket(inetAddress, i));
    }

    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        return a(this.ku.createSocket(inetAddress, i, inetAddress2, i2));
    }

    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        return a(this.ku.createSocket(socket, str, i, z));
    }

    public String[] getDefaultCipherSuites() {
        return this.ku.getDefaultCipherSuites();
    }

    public String[] getSupportedCipherSuites() {
        return this.ku.getSupportedCipherSuites();
    }
}
