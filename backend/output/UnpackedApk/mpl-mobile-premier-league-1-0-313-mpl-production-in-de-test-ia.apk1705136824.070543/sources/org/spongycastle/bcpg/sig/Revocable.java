package org.spongycastle.bcpg.sig;

import org.spongycastle.bcpg.SignatureSubpacket;

public class Revocable extends SignatureSubpacket {
    public Revocable(boolean z, boolean z2, byte[] bArr) {
        super(7, z, z2, bArr);
    }
}
