package org.eclipse.paho.client.mqttv3.internal.wire;

import com.facebook.react.bridge.ColorPropConverter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import org.apache.fontbox.cmap.CMapParser;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class MqttPublish extends MqttPersistableWireMessage {
    public byte[] encodedPayload = null;
    public MqttMessage message;
    public String topicName;

    public MqttPublish(String str, MqttMessage mqttMessage) {
        super(3);
        this.topicName = str;
        this.message = mqttMessage;
    }

    public static byte[] encodePayload(MqttMessage mqttMessage) {
        return mqttMessage.getPayload();
    }

    public MqttMessage getMessage() {
        return this.message;
    }

    public byte getMessageInfo() {
        byte qos = (byte) (this.message.getQos() << 1);
        if (this.message.isRetained()) {
            qos = (byte) (qos | 1);
        }
        return (this.message.isDuplicate() || this.duplicate) ? (byte) (qos | 8) : qos;
    }

    public byte[] getPayload() throws MqttException {
        if (this.encodedPayload == null) {
            this.encodedPayload = encodePayload(this.message);
        }
        return this.encodedPayload;
    }

    public int getPayloadLength() {
        try {
            return getPayload().length;
        } catch (MqttException unused) {
            return 0;
        }
    }

    public String getTopicName() {
        return this.topicName;
    }

    public byte[] getVariableHeader() throws MqttException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            encodeUTF8(dataOutputStream, this.topicName);
            if (this.message.getQos() > 0) {
                dataOutputStream.writeShort(this.msgId);
            }
            dataOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e2) {
            throw new MqttException((Throwable) e2);
        }
    }

    public boolean isMessageIdRequired() {
        return true;
    }

    public void setMessageId(int i) {
        super.setMessageId(i);
        MqttMessage mqttMessage = this.message;
        if (mqttMessage instanceof MqttReceivedMessage) {
            ((MqttReceivedMessage) mqttMessage).setMessageId(i);
        }
    }

    public String toString() {
        String str;
        StringBuffer stringBuffer = new StringBuffer();
        byte[] payload = this.message.getPayload();
        int min = Math.min(payload.length, 20);
        for (int i = 0; i < min; i++) {
            String hexString = Integer.toHexString(payload[i]);
            if (hexString.length() == 1) {
                hexString = "0" + hexString;
            }
            stringBuffer.append(hexString);
        }
        try {
            str = new String(payload, 0, min, "UTF-8");
        } catch (Exception unused) {
            str = ColorPropConverter.PREFIX_ATTR;
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append(super.toString());
        stringBuffer2.append(" qos:");
        stringBuffer2.append(this.message.getQos());
        if (this.message.getQos() > 0) {
            stringBuffer2.append(" msgId:");
            stringBuffer2.append(this.msgId);
        }
        stringBuffer2.append(" retained:");
        stringBuffer2.append(this.message.isRetained());
        stringBuffer2.append(" dup:");
        stringBuffer2.append(this.duplicate);
        stringBuffer2.append(" topic:\"");
        stringBuffer2.append(this.topicName);
        stringBuffer2.append("\"");
        stringBuffer2.append(" payload:[hex:");
        stringBuffer2.append(stringBuffer);
        stringBuffer2.append(" utf8:\"");
        stringBuffer2.append(str);
        stringBuffer2.append("\"");
        stringBuffer2.append(" length:");
        stringBuffer2.append(payload.length);
        stringBuffer2.append(CMapParser.MARK_END_OF_ARRAY);
        return stringBuffer2.toString();
    }

    public MqttPublish(byte b2, byte[] bArr) throws MqttException, IOException {
        super(3);
        MqttReceivedMessage mqttReceivedMessage = new MqttReceivedMessage();
        this.message = mqttReceivedMessage;
        mqttReceivedMessage.setQos(3 & (b2 >> 1));
        if ((b2 & 1) == 1) {
            this.message.setRetained(true);
        }
        if ((b2 & 8) == 8) {
            ((MqttReceivedMessage) this.message).setDuplicate(true);
        }
        CountingInputStream countingInputStream = new CountingInputStream(new ByteArrayInputStream(bArr));
        DataInputStream dataInputStream = new DataInputStream(countingInputStream);
        this.topicName = decodeUTF8(dataInputStream);
        if (this.message.getQos() > 0) {
            this.msgId = dataInputStream.readUnsignedShort();
        }
        byte[] bArr2 = new byte[(bArr.length - countingInputStream.getCounter())];
        dataInputStream.readFully(bArr2);
        dataInputStream.close();
        this.message.setPayload(bArr2);
    }
}
