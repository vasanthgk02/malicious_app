package org.eclipse.paho.client.mqttv3.internal.wire;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.internal.ClientState;
import org.eclipse.paho.client.mqttv3.internal.ExceptionHelper;
import org.eclipse.paho.client.mqttv3.logging.Logger;
import org.eclipse.paho.client.mqttv3.logging.LoggerFactory;

public class MqttInputStream extends InputStream {
    public static final String CLASS_NAME;
    public static final Logger log;
    public ByteArrayOutputStream bais;
    public ClientState clientState = null;

    /* renamed from: in  reason: collision with root package name */
    public DataInputStream f6153in;
    public byte[] packet;
    public long packetLen;
    public long remLen;

    static {
        String name = MqttInputStream.class.getName();
        CLASS_NAME = name;
        log = LoggerFactory.getLogger(LoggerFactory.MQTT_CLIENT_MSG_CAT, name);
    }

    public MqttInputStream(ClientState clientState2, InputStream inputStream) {
        this.clientState = clientState2;
        this.f6153in = new DataInputStream(inputStream);
        this.bais = new ByteArrayOutputStream();
        this.remLen = -1;
    }

    private void readFully() throws IOException {
        int size = this.bais.size();
        long j = this.packetLen;
        int i = size + ((int) j);
        int i2 = (int) (this.remLen - j);
        if (i2 >= 0) {
            int i3 = 0;
            while (i3 < i2) {
                try {
                    int read = this.f6153in.read(this.packet, i + i3, i2 - i3);
                    this.clientState.notifyReceivedBytes(read);
                    if (read >= 0) {
                        i3 += read;
                    } else {
                        throw new EOFException();
                    }
                } catch (SocketTimeoutException e2) {
                    this.packetLen += (long) i3;
                    throw e2;
                }
            }
            return;
        }
        throw new IndexOutOfBoundsException();
    }

    public int available() throws IOException {
        return this.f6153in.available();
    }

    public void close() throws IOException {
        this.f6153in.close();
    }

    public int read() throws IOException {
        return this.f6153in.read();
    }

    public MqttWireMessage readMqttWireMessage() throws IOException, MqttException {
        try {
            if (this.remLen < 0) {
                this.bais.reset();
                byte readByte = this.f6153in.readByte();
                this.clientState.notifyReceivedBytes(1);
                byte b2 = (byte) ((readByte >>> 4) & 15);
                if (b2 < 1 || b2 > 14) {
                    throw ExceptionHelper.createMqttException(32108);
                }
                this.remLen = MqttWireMessage.readMBI(this.f6153in).getValue();
                this.bais.write(readByte);
                this.bais.write(MqttWireMessage.encodeMBI(this.remLen));
                this.packet = new byte[((int) (((long) this.bais.size()) + this.remLen))];
                this.packetLen = 0;
            }
            if (this.remLen < 0) {
                return null;
            }
            readFully();
            this.remLen = -1;
            byte[] byteArray = this.bais.toByteArray();
            System.arraycopy(byteArray, 0, this.packet, 0, byteArray.length);
            MqttWireMessage createWireMessage = MqttWireMessage.createWireMessage(this.packet);
            log.fine(CLASS_NAME, "readMqttWireMessage", "501", new Object[]{createWireMessage});
            return createWireMessage;
        } catch (SocketTimeoutException unused) {
            return null;
        }
    }
}
