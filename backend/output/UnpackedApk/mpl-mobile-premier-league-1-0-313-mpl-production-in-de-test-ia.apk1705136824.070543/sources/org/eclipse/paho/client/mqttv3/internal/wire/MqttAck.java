package org.eclipse.paho.client.mqttv3.internal.wire;

public abstract class MqttAck extends MqttWireMessage {
    public MqttAck(byte b2) {
        super(b2);
    }

    public byte getMessageInfo() {
        return 0;
    }

    public String toString() {
        return String.valueOf(super.toString()) + " msgId " + this.msgId;
    }
}
