package org.eclipse.paho.client.mqttv3.internal.websocket;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.nio.ByteBuffer;
import javax.net.SocketFactory;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.internal.TCPNetworkModule;
import org.eclipse.paho.client.mqttv3.logging.Logger;
import org.eclipse.paho.client.mqttv3.logging.LoggerFactory;

public class WebSocketNetworkModule extends TCPNetworkModule {
    public static final String CLASS_NAME = "org.eclipse.paho.client.mqttv3.internal.websocket.WebSocketNetworkModule";
    public static final Logger log = LoggerFactory.getLogger(LoggerFactory.MQTT_CLIENT_MSG_CAT, WebSocketNetworkModule.class.getName());
    public String host;
    public ByteArrayOutputStream outputStream = new ExtendedByteArrayOutputStream(this);
    public PipedInputStream pipedInputStream;
    public int port;
    public ByteBuffer recievedPayload;
    public String uri;
    public WebSocketReceiver webSocketReceiver;

    public WebSocketNetworkModule(SocketFactory socketFactory, String str, String str2, int i, String str3) {
        super(socketFactory, str2, i, str3);
        this.uri = str;
        this.host = str2;
        this.port = i;
        this.pipedInputStream = new PipedInputStream();
        log.setResourceName(str3);
    }

    public InputStream getInputStream() throws IOException {
        return this.pipedInputStream;
    }

    public OutputStream getOutputStream() throws IOException {
        return this.outputStream;
    }

    public String getServerURI() {
        return "ws://" + this.host + ":" + this.port;
    }

    public InputStream getSocketInputStream() throws IOException {
        return super.getInputStream();
    }

    public OutputStream getSocketOutputStream() throws IOException {
        return super.getOutputStream();
    }

    public void start() throws IOException, MqttException {
        super.start();
        WebSocketHandshake webSocketHandshake = new WebSocketHandshake(getSocketInputStream(), getSocketOutputStream(), this.uri, this.host, this.port);
        webSocketHandshake.execute();
        WebSocketReceiver webSocketReceiver2 = new WebSocketReceiver(getSocketInputStream(), this.pipedInputStream);
        this.webSocketReceiver = webSocketReceiver2;
        webSocketReceiver2.start("webSocketReceiver");
    }

    public void stop() throws IOException {
        getSocketOutputStream().write(new WebSocketFrame(8, true, "1000".getBytes()).encodeFrame());
        getSocketOutputStream().flush();
        WebSocketReceiver webSocketReceiver2 = this.webSocketReceiver;
        if (webSocketReceiver2 != null) {
            webSocketReceiver2.stop();
        }
        super.stop();
    }
}
