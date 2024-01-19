package org.eclipse.paho.client.mqttv3.internal.wire;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import org.apache.fontbox.cmap.CMapParser;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class MqttSubscribe extends MqttWireMessage {
    public int count;
    public String[] names;
    public int[] qos;

    public MqttSubscribe(byte b2, byte[] bArr) throws IOException {
        super(8);
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        this.msgId = dataInputStream.readUnsignedShort();
        boolean z = false;
        this.count = 0;
        this.names = new String[10];
        this.qos = new int[10];
        while (!z) {
            try {
                this.names[this.count] = decodeUTF8(dataInputStream);
                int[] iArr = this.qos;
                int i = this.count;
                this.count = i + 1;
                iArr[i] = dataInputStream.readByte();
            } catch (Exception unused) {
                z = true;
            }
        }
        dataInputStream.close();
    }

    public byte getMessageInfo() {
        return (byte) ((this.duplicate ? 8 : 0) | 2);
    }

    public byte[] getPayload() throws MqttException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            for (int i = 0; i < this.names.length; i++) {
                encodeUTF8(dataOutputStream, this.names[i]);
                dataOutputStream.writeByte(this.qos[i]);
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
            dataOutputStream.writeShort(this.msgId);
            dataOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e2) {
            throw new MqttException((Throwable) e2);
        }
    }

    public boolean isRetryable() {
        return true;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(super.toString());
        stringBuffer.append(" names:[");
        for (int i = 0; i < this.count; i++) {
            if (i > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append("\"");
            stringBuffer.append(this.names[i]);
            stringBuffer.append("\"");
        }
        stringBuffer.append("] qos:[");
        for (int i2 = 0; i2 < this.count; i2++) {
            if (i2 > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(this.qos[i2]);
        }
        stringBuffer.append(CMapParser.MARK_END_OF_ARRAY);
        return stringBuffer.toString();
    }

    public MqttSubscribe(String[] strArr, int[] iArr) {
        super(8);
        this.names = strArr;
        this.qos = iArr;
        if (strArr.length == iArr.length) {
            this.count = strArr.length;
            for (int validateQos : iArr) {
                MqttMessage.validateQos(validateQos);
            }
            return;
        }
        throw new IllegalArgumentException();
    }
}
