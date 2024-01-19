package org.spongycastle.bcpg.sig;

import org.spongycastle.bcpg.SignatureSubpacket;

public class TrustSignature extends SignatureSubpacket {
    public TrustSignature(boolean z, boolean z2, byte[] bArr) {
        super(5, z, z2, bArr);
    }
}
