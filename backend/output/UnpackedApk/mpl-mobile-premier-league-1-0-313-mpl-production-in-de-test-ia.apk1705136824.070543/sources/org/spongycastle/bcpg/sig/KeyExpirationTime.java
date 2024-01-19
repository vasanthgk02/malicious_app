package org.spongycastle.bcpg.sig;

import org.spongycastle.bcpg.SignatureSubpacket;

public class KeyExpirationTime extends SignatureSubpacket {
    public KeyExpirationTime(boolean z, boolean z2, byte[] bArr) {
        super(9, z, z2, bArr);
    }
}
