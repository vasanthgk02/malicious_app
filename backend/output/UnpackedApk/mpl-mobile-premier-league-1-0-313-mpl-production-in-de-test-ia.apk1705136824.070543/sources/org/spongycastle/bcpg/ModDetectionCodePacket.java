package org.spongycastle.bcpg;

import java.io.IOException;

public class ModDetectionCodePacket extends ContainedPacket {
    public byte[] digest;

    public ModDetectionCodePacket(BCPGInputStream bCPGInputStream) throws IOException {
        byte[] bArr = new byte[20];
        this.digest = bArr;
        bCPGInputStream.readFully(bArr);
    }
}
