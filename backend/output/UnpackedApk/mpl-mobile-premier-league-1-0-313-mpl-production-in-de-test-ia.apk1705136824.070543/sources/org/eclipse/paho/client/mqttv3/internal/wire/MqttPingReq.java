package org.eclipse.paho.client.mqttv3.internal.wire;

import java.io.IOException;
import org.eclipse.paho.client.mqttv3.MqttException;

public class MqttPingReq extends MqttWireMessage {
    public static final String KEY = "Ping";

    public MqttPingReq() {
        super(MqttWireMessage.MESSAGE_TYPE_PINGREQ);
    }

    public String getKey() {
        return "Ping";
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

    public MqttPingReq(byte b2, byte[] bArr) throws IOException {
        super(MqttWireMessage.MESSAGE_TYPE_PINGREQ);
    }
}
