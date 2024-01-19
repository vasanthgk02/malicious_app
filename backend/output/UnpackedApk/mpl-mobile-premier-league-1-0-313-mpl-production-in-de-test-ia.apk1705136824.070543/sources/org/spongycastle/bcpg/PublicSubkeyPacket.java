package org.spongycastle.bcpg;

import java.io.IOException;

public class PublicSubkeyPacket extends PublicKeyPacket {
    public PublicSubkeyPacket(BCPGInputStream bCPGInputStream) throws IOException {
        super(bCPGInputStream);
    }
}
