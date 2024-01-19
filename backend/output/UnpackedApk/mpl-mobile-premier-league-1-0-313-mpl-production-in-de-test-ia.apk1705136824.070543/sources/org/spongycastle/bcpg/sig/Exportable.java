package org.spongycastle.bcpg.sig;

import org.spongycastle.bcpg.SignatureSubpacket;

public class Exportable extends SignatureSubpacket {
    public Exportable(boolean z, boolean z2, byte[] bArr) {
        super(4, z, z2, bArr);
    }
}
