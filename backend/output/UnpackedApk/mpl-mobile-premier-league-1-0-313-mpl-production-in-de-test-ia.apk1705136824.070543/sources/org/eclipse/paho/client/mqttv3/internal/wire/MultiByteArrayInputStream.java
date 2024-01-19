package org.eclipse.paho.client.mqttv3.internal.wire;

import java.io.IOException;
import java.io.InputStream;

public class MultiByteArrayInputStream extends InputStream {
    public byte[] bytesA;
    public byte[] bytesB;
    public int lengthA;
    public int lengthB;
    public int offsetA;
    public int offsetB;
    public int pos = 0;

    public MultiByteArrayInputStream(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        this.bytesA = bArr;
        this.bytesB = bArr2;
        this.offsetA = i;
        this.offsetB = i3;
        this.lengthA = i2;
        this.lengthB = i4;
    }

    public int read() throws IOException {
        int i;
        int i2 = this.pos;
        int i3 = this.lengthA;
        if (i2 < i3) {
            i = this.bytesA[this.offsetA + i2];
        } else if (i2 >= this.lengthB + i3) {
            return -1;
        } else {
            i = this.bytesB[(this.offsetB + i2) - i3];
        }
        if (i < 0) {
            i += 256;
        }
        this.pos++;
        return i;
    }
}
