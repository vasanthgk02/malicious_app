package org.spongycastle.bcpg;

import java.io.IOException;

public class ElGamalPublicBCPGKey extends BCPGObject implements BCPGKey {
    public MPInteger g;
    public MPInteger p;
    public MPInteger y;

    public ElGamalPublicBCPGKey(BCPGInputStream bCPGInputStream) throws IOException {
        this.p = new MPInteger(bCPGInputStream);
        this.g = new MPInteger(bCPGInputStream);
        this.y = new MPInteger(bCPGInputStream);
    }

    public void encode(BCPGOutputStream bCPGOutputStream) throws IOException {
        this.p.encode(bCPGOutputStream);
        this.g.encode(bCPGOutputStream);
        this.y.encode(bCPGOutputStream);
    }

    public byte[] getEncoded() {
        try {
            return super.getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }
}
