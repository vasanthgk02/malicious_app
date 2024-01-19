package org.spongycastle.bcpg;

import java.io.IOException;

public class RSAPublicBCPGKey extends BCPGObject implements BCPGKey {

    /* renamed from: e  reason: collision with root package name */
    public MPInteger f6251e;
    public MPInteger n;

    public RSAPublicBCPGKey(BCPGInputStream bCPGInputStream) throws IOException {
        this.n = new MPInteger(bCPGInputStream);
        this.f6251e = new MPInteger(bCPGInputStream);
    }

    public void encode(BCPGOutputStream bCPGOutputStream) throws IOException {
        this.n.encode(bCPGOutputStream);
        this.f6251e.encode(bCPGOutputStream);
    }

    public byte[] getEncoded() {
        try {
            return super.getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }
}
