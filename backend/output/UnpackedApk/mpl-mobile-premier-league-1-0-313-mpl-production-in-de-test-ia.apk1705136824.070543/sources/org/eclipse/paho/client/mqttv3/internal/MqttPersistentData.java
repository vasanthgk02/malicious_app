package org.eclipse.paho.client.mqttv3.internal;

import org.eclipse.paho.client.mqttv3.MqttPersistable;

public class MqttPersistentData implements MqttPersistable {
    public int hLength = 0;
    public int hOffset = 0;
    public byte[] header = null;
    public String key = null;
    public int pLength = 0;
    public int pOffset = 0;
    public byte[] payload = null;

    public MqttPersistentData(String str, byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        this.key = str;
        this.header = bArr;
        this.hOffset = i;
        this.hLength = i2;
        this.payload = bArr2;
        this.pOffset = i3;
        this.pLength = i4;
    }

    public byte[] getHeaderBytes() {
        return this.header;
    }

    public int getHeaderLength() {
        return this.hLength;
    }

    public int getHeaderOffset() {
        return this.hOffset;
    }

    public String getKey() {
        return this.key;
    }

    public byte[] getPayloadBytes() {
        return this.payload;
    }

    public int getPayloadLength() {
        if (this.payload == null) {
            return 0;
        }
        return this.pLength;
    }

    public int getPayloadOffset() {
        return this.pOffset;
    }
}
