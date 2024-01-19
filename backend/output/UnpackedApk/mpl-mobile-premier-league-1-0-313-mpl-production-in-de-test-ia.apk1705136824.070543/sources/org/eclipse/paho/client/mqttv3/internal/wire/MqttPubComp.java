package org.eclipse.paho.client.mqttv3.internal.wire;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import org.eclipse.paho.client.mqttv3.MqttException;

public class MqttPubComp extends MqttAck {
    public MqttPubComp(byte b2, byte[] bArr) throws IOException {
        super(7);
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        this.msgId = dataInputStream.readUnsignedShort();
        dataInputStream.close();
    }

    public byte[] getVariableHeader() throws MqttException {
        return encodeMessageId();
    }

    public MqttPubComp(MqttPublish mqttPublish) {
        super(7);
        this.msgId = mqttPublish.getMessageId();
    }

    public MqttPubComp(int i) {
        super(7);
        this.msgId = i;
    }
}
