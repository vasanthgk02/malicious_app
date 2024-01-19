package org.eclipse.paho.client.mqttv3.internal.wire;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import org.eclipse.paho.client.mqttv3.MqttException;

public class MqttPubAck extends MqttAck {
    public MqttPubAck(byte b2, byte[] bArr) throws IOException {
        super(4);
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        this.msgId = dataInputStream.readUnsignedShort();
        dataInputStream.close();
    }

    public byte[] getVariableHeader() throws MqttException {
        return encodeMessageId();
    }

    public MqttPubAck(MqttPublish mqttPublish) {
        super(4);
        this.msgId = mqttPublish.getMessageId();
    }

    public MqttPubAck(int i) {
        super(4);
        this.msgId = i;
    }
}
