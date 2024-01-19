package org.spongycastle.bcpg;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class S2K extends BCPGObject {
    public int algorithm;
    public int itCount = -1;
    public byte[] iv;
    public int protectionMode = -1;
    public int type;

    public S2K(InputStream inputStream) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        this.type = dataInputStream.read();
        this.algorithm = dataInputStream.read();
        int i = this.type;
        if (i == 101) {
            dataInputStream.read();
            dataInputStream.read();
            dataInputStream.read();
            this.protectionMode = dataInputStream.read();
        } else if (i != 0) {
            byte[] bArr = new byte[8];
            this.iv = bArr;
            dataInputStream.readFully(bArr, 0, 8);
            if (this.type == 3) {
                this.itCount = dataInputStream.read();
            }
        }
    }

    public void encode(BCPGOutputStream bCPGOutputStream) throws IOException {
        bCPGOutputStream.write(this.type);
        bCPGOutputStream.write(this.algorithm);
        int i = this.type;
        if (i != 101) {
            if (i != 0) {
                bCPGOutputStream.write(this.iv);
            }
            if (this.type == 3) {
                bCPGOutputStream.write(this.itCount);
                return;
            }
            return;
        }
        bCPGOutputStream.write(71);
        bCPGOutputStream.write(78);
        bCPGOutputStream.write(85);
        bCPGOutputStream.write(this.protectionMode);
    }
}
