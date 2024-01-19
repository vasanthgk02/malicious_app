package org.spongycastle.bcpg.sig;

import org.spongycastle.bcpg.SignatureSubpacket;

public class SignerUserID extends SignatureSubpacket {
    public SignerUserID(boolean z, boolean z2, byte[] bArr) {
        super(28, z, z2, bArr);
    }
}
