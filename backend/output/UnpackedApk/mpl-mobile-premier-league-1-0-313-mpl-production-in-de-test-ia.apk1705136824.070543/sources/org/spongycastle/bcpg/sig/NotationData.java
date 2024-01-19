package org.spongycastle.bcpg.sig;

import org.spongycastle.bcpg.SignatureSubpacket;

public class NotationData extends SignatureSubpacket {
    public NotationData(boolean z, boolean z2, byte[] bArr) {
        super(20, z, z2, bArr);
    }
}
