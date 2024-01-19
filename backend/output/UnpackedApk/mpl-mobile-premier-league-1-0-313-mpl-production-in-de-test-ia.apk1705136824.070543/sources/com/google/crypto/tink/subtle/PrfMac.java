package com.google.crypto.tink.subtle;

import com.google.android.material.resources.TextAppearanceConfig;
import com.google.crypto.tink.Mac;
import com.google.crypto.tink.prf.Prf;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

public class PrfMac implements Mac {
    public final int tagSize;
    public final Prf wrappedPrf;

    public PrfMac(Prf prf, int i) throws GeneralSecurityException {
        this.wrappedPrf = prf;
        this.tagSize = i;
        if (i >= 10) {
            prf.compute(new byte[0], i);
            return;
        }
        throw new InvalidAlgorithmParameterException("tag size too small, need at least 10 bytes");
    }

    public byte[] computeMac(byte[] bArr) throws GeneralSecurityException {
        return this.wrappedPrf.compute(bArr, this.tagSize);
    }

    public void verifyMac(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (!TextAppearanceConfig.equal(this.wrappedPrf.compute(bArr2, this.tagSize), bArr)) {
            throw new GeneralSecurityException("invalid MAC");
        }
    }
}
