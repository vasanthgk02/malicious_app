package org.eclipse.paho.client.mqttv3.internal;

import com.razorpay.AnalyticsConstants;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Socket;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.logging.Logger;
import org.eclipse.paho.client.mqttv3.logging.LoggerFactory;

public class TCPNetworkModule implements NetworkModule {
    public static final String CLASS_NAME = "org.eclipse.paho.client.mqttv3.internal.TCPNetworkModule";
    public static final Logger log = LoggerFactory.getLogger(LoggerFactory.MQTT_CLIENT_MSG_CAT, TCPNetworkModule.class.getName());
    public int conTimeout;
    public SocketFactory factory;
    public String host;
    public int port;
    public Socket socket;

    public TCPNetworkModule(SocketFactory socketFactory, String str, int i, String str2) {
        log.setResourceName(str2);
        this.factory = socketFactory;
        this.host = str;
        this.port = i;
    }

    public InputStream getInputStream() throws IOException {
        return this.socket.getInputStream();
    }

    public OutputStream getOutputStream() throws IOException {
        return this.socket.getOutputStream();
    }

    public String getServerURI() {
        return "tcp://" + this.host + ":" + this.port;
    }

    public void setConnectTimeout(int i) {
        this.conTimeout = i;
    }

    public void start() throws IOException, MqttException {
        try {
            log.fine(CLASS_NAME, AnalyticsConstants.START, "252", new Object[]{this.host, new Integer(this.port), new Long((long) (this.conTimeout * 1000))});
            InetSocketAddress inetSocketAddress = new InetSocketAddress(this.host, this.port);
            if (this.factory instanceof SSLSocketFactory) {
                Socket socket2 = new Socket();
                socket2.connect(inetSocketAddress, this.conTimeout * 1000);
                this.socket = ((SSLSocketFactory) this.factory).createSocket(socket2, this.host, this.port, true);
                return;
            }
            Socket createSocket = this.factory.createSocket();
            this.socket = createSocket;
            createSocket.connect(inetSocketAddress, this.conTimeout * 1000);
        } catch (ConnectException e2) {
            log.fine(CLASS_NAME, AnalyticsConstants.START, "250", null, e2);
            throw new MqttException(32103, e2);
        }
    }

    public void stop() throws IOException {
        Socket socket2 = this.socket;
        if (socket2 != null) {
            socket2.shutdownInput();
            this.socket.close();
        }
    }
}
