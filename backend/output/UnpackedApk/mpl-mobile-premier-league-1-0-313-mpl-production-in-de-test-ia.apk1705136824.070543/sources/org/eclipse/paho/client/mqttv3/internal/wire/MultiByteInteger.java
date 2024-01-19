package org.eclipse.paho.client.mqttv3.internal.wire;

public class MultiByteInteger {
    public int length;
    public long value;

    public MultiByteInteger(long j) {
        this(j, -1);
    }

    public int getEncodedLength() {
        return this.length;
    }

    public long getValue() {
        return this.value;
    }

    public MultiByteInteger(long j, int i) {
        this.value = j;
        this.length = i;
    }
}
