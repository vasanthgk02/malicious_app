package org.spongycastle.bcpg.sig;

import org.spongycastle.bcpg.SignatureSubpacket;

public class PrimaryUserID extends SignatureSubpacket {
    public PrimaryUserID(boolean z, boolean z2, byte[] bArr) {
        super(25, z, z2, bArr);
    }
}
