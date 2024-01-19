package org.eclipse.paho.client.mqttv3;

import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

public class BufferedMessage {
    public MqttWireMessage message;
    public MqttToken token;

    public BufferedMessage(MqttWireMessage mqttWireMessage, MqttToken mqttToken) {
        this.message = mqttWireMessage;
        this.token = mqttToken;
    }

    public MqttWireMessage getMessage() {
        return this.message;
    }

    public MqttToken getToken() {
        return this.token;
    }
}
