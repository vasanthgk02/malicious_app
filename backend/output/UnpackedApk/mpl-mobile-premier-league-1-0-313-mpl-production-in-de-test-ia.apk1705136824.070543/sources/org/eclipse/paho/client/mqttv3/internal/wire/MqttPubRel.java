package org.eclipse.paho.client.mqttv3.internal.wire;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import org.eclipse.paho.client.mqttv3.MqttException;

public class MqttPubRel extends MqttPersistableWireMessage {
    public MqttPubRel(MqttPubRec mqttPubRec) {
        super(6);
        setMessageId(mqttPubRec.getMessageId());
    }

    public byte getMessageInfo() {
        return (byte) ((this.duplicate ? 8 : 0) | 2);
    }

    public byte[] getVariableHeader() throws MqttException {
        return encodeMessageId();
    }

    public String toString() {
        return String.valueOf(super.toString()) + " msgId " + this.msgId;
    }

    public MqttPubRel(byte b2, byte[] bArr) throws IOException {
        super(6);
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        this.msgId = dataInputStream.readUnsignedShort();
        dataInputStream.close();
    }
}
