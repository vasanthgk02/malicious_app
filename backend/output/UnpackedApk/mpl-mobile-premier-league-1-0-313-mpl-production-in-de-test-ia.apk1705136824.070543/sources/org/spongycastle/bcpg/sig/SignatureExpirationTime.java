package org.spongycastle.bcpg.sig;

import org.spongycastle.bcpg.SignatureSubpacket;

public class SignatureExpirationTime extends SignatureSubpacket {
    public SignatureExpirationTime(boolean z, boolean z2, byte[] bArr) {
        super(3, z, z2, bArr);
    }
}
