package org.spongycastle.bcpg;

import java.io.IOException;

public class MarkerPacket extends ContainedPacket {
    public byte[] marker;

    public MarkerPacket(BCPGInputStream bCPGInputStream) throws IOException {
        byte[] bArr = {80, 71, 80};
        this.marker = bArr;
        bCPGInputStream.readFully(bArr);
    }
}
