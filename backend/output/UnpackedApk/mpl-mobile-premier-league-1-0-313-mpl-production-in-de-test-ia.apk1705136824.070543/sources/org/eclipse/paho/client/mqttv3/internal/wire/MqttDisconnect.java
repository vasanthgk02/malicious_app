package org.eclipse.paho.client.mqttv3.internal.wire;

import java.io.IOException;
import org.eclipse.paho.client.mqttv3.MqttException;

public class MqttDisconnect extends MqttWireMessage {
    public static final String KEY = "Disc";

    public MqttDisconnect() {
        super(MqttWireMessage.MESSAGE_TYPE_DISCONNECT);
    }

    public String getKey() {
        return "Disc";
    }

    public byte getMessageInfo() {
        return 0;
    }

    public byte[] getVariableHeader() throws MqttException {
        return new byte[0];
    }

    public boolean isMessageIdRequired() {
        return false;
    }

    public MqttDisconnect(byte b2, byte[] bArr) throws IOException {
        super(MqttWireMessage.MESSAGE_TYPE_DISCONNECT);
    }
}
