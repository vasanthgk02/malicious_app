package org.spongycastle.bcpg;

import java.io.IOException;

public class SymmetricEncIntegrityPacket extends InputStreamPacket {
    public SymmetricEncIntegrityPacket(BCPGInputStream bCPGInputStream) throws IOException {
        super(bCPGInputStream);
        bCPGInputStream.read();
    }
}
