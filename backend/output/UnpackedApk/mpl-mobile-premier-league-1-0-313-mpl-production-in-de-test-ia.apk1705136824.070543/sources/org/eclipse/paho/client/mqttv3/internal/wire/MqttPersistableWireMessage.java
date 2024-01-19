package org.eclipse.paho.client.mqttv3.internal.wire;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttPersistable;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;

public abstract class MqttPersistableWireMessage extends MqttWireMessage implements MqttPersistable {
    public MqttPersistableWireMessage(byte b2) {
        super(b2);
    }

    public byte[] getHeaderBytes() throws MqttPersistenceException {
        try {
            return getHeader();
        } catch (MqttException e2) {
            throw new MqttPersistenceException(e2.getCause());
        }
    }

    public int getHeaderLength() throws MqttPersistenceException {
        return getHeaderBytes().length;
    }

    public int getHeaderOffset() throws MqttPersistenceException {
        return 0;
    }

    public byte[] getPayloadBytes() throws MqttPersistenceException {
        try {
            return getPayload();
        } catch (MqttException e2) {
            throw new MqttPersistenceException(e2.getCause());
        }
    }

    public int getPayloadLength() throws MqttPersistenceException {
        return 0;
    }

    public int getPayloadOffset() throws MqttPersistenceException {
        return 0;
    }
}
