package org.eclipse.paho.client.mqttv3.internal.wire;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.internal.ClientState;
import org.eclipse.paho.client.mqttv3.logging.Logger;
import org.eclipse.paho.client.mqttv3.logging.LoggerFactory;

public class MqttOutputStream extends OutputStream {
    public static final String CLASS_NAME;
    public static final Logger log;
    public ClientState clientState = null;
    public BufferedOutputStream out;

    static {
        String name = MqttOutputStream.class.getName();
        CLASS_NAME = name;
        log = LoggerFactory.getLogger(LoggerFactory.MQTT_CLIENT_MSG_CAT, name);
    }

    public MqttOutputStream(ClientState clientState2, OutputStream outputStream) {
        this.clientState = clientState2;
        this.out = new BufferedOutputStream(outputStream);
    }

    public void close() throws IOException {
        this.out.close();
    }

    public void flush() throws IOException {
        this.out.flush();
    }

    public void write(byte[] bArr) throws IOException {
        this.out.write(bArr);
        this.clientState.notifySentBytes(bArr.length);
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.out.write(bArr, i, i2);
        this.clientState.notifySentBytes(i2);
    }

    public void write(int i) throws IOException {
        this.out.write(i);
    }

    public void write(MqttWireMessage mqttWireMessage) throws IOException, MqttException {
        byte[] header = mqttWireMessage.getHeader();
        byte[] payload = mqttWireMessage.getPayload();
        this.out.write(header, 0, header.length);
        this.clientState.notifySentBytes(header.length);
        int i = 0;
        while (i < payload.length) {
            int min = Math.min(1024, payload.length - i);
            this.out.write(payload, i, min);
            i += 1024;
            this.clientState.notifySentBytes(min);
        }
        log.fine(CLASS_NAME, "write", "529", new Object[]{mqttWireMessage});
    }
}
