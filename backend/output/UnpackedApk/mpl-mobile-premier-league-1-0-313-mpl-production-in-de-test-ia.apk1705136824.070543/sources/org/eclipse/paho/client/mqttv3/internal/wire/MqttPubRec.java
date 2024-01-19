package org.eclipse.paho.client.mqttv3.internal.wire;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import org.eclipse.paho.client.mqttv3.MqttException;

public class MqttPubRec extends MqttAck {
    public MqttPubRec(byte b2, byte[] bArr) throws IOException {
        super(5);
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        this.msgId = dataInputStream.readUnsignedShort();
        dataInputStream.close();
    }

    public byte[] getVariableHeader() throws MqttException {
        return encodeMessageId();
    }

    public MqttPubRec(MqttPublish mqttPublish) {
        super(5);
        this.msgId = mqttPublish.getMessageId();
    }
}
