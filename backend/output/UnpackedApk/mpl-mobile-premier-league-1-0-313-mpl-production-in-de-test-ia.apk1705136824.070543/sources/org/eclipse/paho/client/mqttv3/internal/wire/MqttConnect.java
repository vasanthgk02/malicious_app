package org.eclipse.paho.client.mqttv3.internal.wire;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class MqttConnect extends MqttWireMessage {
    public static final String KEY = "Con";
    public int MqttVersion;
    public boolean cleanSession;
    public String clientId;
    public int keepAliveInterval;
    public char[] password;
    public String userName;
    public String willDestination;
    public MqttMessage willMessage;

    public MqttConnect(byte b2, byte[] bArr) throws IOException, MqttException {
        super(1);
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        decodeUTF8(dataInputStream);
        dataInputStream.readByte();
        dataInputStream.readByte();
        this.keepAliveInterval = dataInputStream.readUnsignedShort();
        this.clientId = decodeUTF8(dataInputStream);
        dataInputStream.close();
    }

    public String getKey() {
        return "Con";
    }

    public byte getMessageInfo() {
        return 0;
    }

    public byte[] getPayload() throws MqttException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            encodeUTF8(dataOutputStream, this.clientId);
            if (this.willMessage != null) {
                encodeUTF8(dataOutputStream, this.willDestination);
                dataOutputStream.writeShort(this.willMessage.getPayload().length);
                dataOutputStream.write(this.willMessage.getPayload());
            }
            if (this.userName != null) {
                encodeUTF8(dataOutputStream, this.userName);
                if (this.password != null) {
                    encodeUTF8(dataOutputStream, new String(this.password));
                }
            }
            dataOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e2) {
            throw new MqttException((Throwable) e2);
        }
    }

    public byte[] getVariableHeader() throws MqttException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            if (this.MqttVersion == 3) {
                encodeUTF8(dataOutputStream, "MQIsdp");
            } else if (this.MqttVersion == 4) {
                encodeUTF8(dataOutputStream, "MQTT");
            }
            dataOutputStream.write(this.MqttVersion);
            byte b2 = 0;
            if (this.cleanSession) {
                b2 = (byte) 2;
            }
            if (this.willMessage != null) {
                b2 = (byte) (((byte) (b2 | 4)) | (this.willMessage.getQos() << 3));
                if (this.willMessage.isRetained()) {
                    b2 = (byte) (b2 | 32);
                }
            }
            if (this.userName != null) {
                b2 = (byte) (b2 | 128);
                if (this.password != null) {
                    b2 = (byte) (b2 | 64);
                }
            }
            dataOutputStream.write(b2);
            dataOutputStream.writeShort(this.keepAliveInterval);
            dataOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e2) {
            throw new MqttException((Throwable) e2);
        }
    }

    public boolean isCleanSession() {
        return this.cleanSession;
    }

    public boolean isMessageIdRequired() {
        return false;
    }

    public String toString() {
        return String.valueOf(super.toString()) + " clientId " + this.clientId + " keepAliveInterval " + this.keepAliveInterval;
    }

    public MqttConnect(String str, int i, boolean z, int i2, String str2, char[] cArr, MqttMessage mqttMessage, String str3) {
        super(1);
        this.clientId = str;
        this.cleanSession = z;
        this.keepAliveInterval = i2;
        this.userName = str2;
        this.password = cArr;
        this.willMessage = mqttMessage;
        this.willDestination = str3;
        this.MqttVersion = i;
    }
}
