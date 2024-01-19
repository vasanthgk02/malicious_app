package org.spongycastle.bcpg;

import java.io.IOException;

public class CompressedDataPacket extends InputStreamPacket {
    public CompressedDataPacket(BCPGInputStream bCPGInputStream) throws IOException {
        super(bCPGInputStream);
        bCPGInputStream.read();
    }
}
