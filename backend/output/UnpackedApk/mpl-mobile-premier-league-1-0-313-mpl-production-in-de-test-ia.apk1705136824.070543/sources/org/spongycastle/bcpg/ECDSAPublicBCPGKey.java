package org.spongycastle.bcpg;

import java.io.IOException;

public class ECDSAPublicBCPGKey extends ECPublicBCPGKey {
    public ECDSAPublicBCPGKey(BCPGInputStream bCPGInputStream) throws IOException {
        super(bCPGInputStream);
    }
}
