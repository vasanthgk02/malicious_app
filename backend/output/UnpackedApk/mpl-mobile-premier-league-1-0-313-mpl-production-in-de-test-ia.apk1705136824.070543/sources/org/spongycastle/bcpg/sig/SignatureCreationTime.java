package org.spongycastle.bcpg.sig;

import org.spongycastle.bcpg.SignatureSubpacket;

public class SignatureCreationTime extends SignatureSubpacket {
    public SignatureCreationTime(boolean z, boolean z2, byte[] bArr) {
        super(2, z, z2, bArr);
    }
}
