package org.spongycastle.bcpg;

import java.io.IOException;

public class LiteralDataPacket extends InputStreamPacket {
    public byte[] fileName;

    public LiteralDataPacket(BCPGInputStream bCPGInputStream) throws IOException {
        super(bCPGInputStream);
        bCPGInputStream.read();
        this.fileName = new byte[bCPGInputStream.read()];
        int i = 0;
        while (true) {
            byte[] bArr = this.fileName;
            if (i != bArr.length) {
                bArr[i] = (byte) bCPGInputStream.read();
                i++;
            } else {
                bCPGInputStream.read();
                bCPGInputStream.read();
                bCPGInputStream.read();
                bCPGInputStream.read();
                return;
            }
        }
    }
}
