package org.spongycastle.bcpg.sig;

import org.apache.fontbox.ttf.GlyfDescript;
import org.spongycastle.bcpg.SignatureSubpacket;

public class IssuerKeyID extends SignatureSubpacket {
    public IssuerKeyID(boolean z, boolean z2, byte[] bArr) {
        super(16, z, z2, bArr);
    }

    public long getKeyID() {
        byte[] bArr = this.data;
        return (((long) (bArr[0] & 255)) << 56) | (((long) (bArr[1] & 255)) << 48) | (((long) (bArr[2] & 255)) << 40) | (((long) (bArr[3] & 255)) << 32) | (((long) (bArr[4] & 255)) << 24) | ((long) ((bArr[5] & 255) << GlyfDescript.X_DUAL)) | ((long) ((bArr[6] & 255) << 8)) | ((long) (bArr[7] & 255));
    }
}
