package org.eclipse.paho.client.mqttv3.internal.wire;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import org.apache.fontbox.cmap.CMap;
import org.eclipse.paho.client.mqttv3.MqttException;

public class MqttSuback extends MqttAck {
    public int[] grantedQos;

    public MqttSuback(byte b2, byte[] bArr) throws IOException {
        super(9);
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        this.msgId = dataInputStream.readUnsignedShort();
        this.grantedQos = new int[(bArr.length - 2)];
        int i = 0;
        for (int read = dataInputStream.read(); read != -1; read = dataInputStream.read()) {
            this.grantedQos[i] = read;
            i++;
        }
        dataInputStream.close();
    }

    public int[] getGrantedQos() {
        return this.grantedQos;
    }

    public byte[] getVariableHeader() throws MqttException {
        return new byte[0];
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(super.toString());
        stringBuffer.append(" granted Qos");
        for (int append : this.grantedQos) {
            stringBuffer.append(CMap.SPACE);
            stringBuffer.append(append);
        }
        return stringBuffer.toString();
    }
}
