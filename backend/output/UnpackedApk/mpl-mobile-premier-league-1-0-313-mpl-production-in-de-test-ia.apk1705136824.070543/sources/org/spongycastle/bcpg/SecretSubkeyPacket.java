package org.spongycastle.bcpg;

import java.io.IOException;

public class SecretSubkeyPacket extends SecretKeyPacket {
    public SecretSubkeyPacket(BCPGInputStream bCPGInputStream) throws IOException {
        super(bCPGInputStream);
    }
}
