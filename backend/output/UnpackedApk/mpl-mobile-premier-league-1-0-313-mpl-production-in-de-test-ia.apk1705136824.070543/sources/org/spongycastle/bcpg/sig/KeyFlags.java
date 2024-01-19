package org.spongycastle.bcpg.sig;

import org.spongycastle.bcpg.SignatureSubpacket;

public class KeyFlags extends SignatureSubpacket {
    public KeyFlags(boolean z, boolean z2, byte[] bArr) {
        super(27, z, z2, bArr);
    }
}
