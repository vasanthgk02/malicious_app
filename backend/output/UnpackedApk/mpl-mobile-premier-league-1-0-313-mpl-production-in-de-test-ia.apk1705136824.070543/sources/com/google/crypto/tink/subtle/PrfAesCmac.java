package com.google.crypto.tink.subtle;

import com.google.android.material.resources.TextAppearanceConfig;
import com.google.crypto.tink.prf.Prf;
import in.juspay.hypersdk.security.EncryptionHelper;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public final class PrfAesCmac implements Prf {
    public final SecretKey keySpec;
    public byte[] subKey1;
    public byte[] subKey2;

    public PrfAesCmac(byte[] bArr) throws GeneralSecurityException {
        Validators.validateAesKeySize(bArr.length);
        this.keySpec = new SecretKeySpec(bArr, EncryptionHelper.algorithm);
        Cipher cipher = (Cipher) EngineFactory.CIPHER.getInstance("AES/ECB/NoPadding");
        cipher.init(1, this.keySpec);
        byte[] dbl = TextAppearanceConfig.dbl(cipher.doFinal(new byte[16]));
        this.subKey1 = dbl;
        this.subKey2 = TextAppearanceConfig.dbl(dbl);
    }

    public byte[] compute(byte[] bArr, int i) throws GeneralSecurityException {
        byte[] bArr2;
        if (i <= 16) {
            Cipher cipher = (Cipher) EngineFactory.CIPHER.getInstance("AES/ECB/NoPadding");
            boolean z = true;
            cipher.init(1, this.keySpec);
            int max = Math.max(1, (int) Math.ceil(((double) bArr.length) / 16.0d));
            if (max * 16 != bArr.length) {
                z = false;
            }
            if (z) {
                bArr2 = TextAppearanceConfig.xor(bArr, (max - 1) * 16, this.subKey1, 0, 16);
            } else {
                bArr2 = TextAppearanceConfig.xor(TextAppearanceConfig.cmacPad(Arrays.copyOfRange(bArr, (max - 1) * 16, bArr.length)), this.subKey2);
            }
            byte[] bArr3 = new byte[16];
            for (int i2 = 0; i2 < max - 1; i2++) {
                bArr3 = cipher.doFinal(TextAppearanceConfig.xor(bArr3, 0, bArr, i2 * 16, 16));
            }
            return Arrays.copyOf(cipher.doFinal(TextAppearanceConfig.xor(bArr2, bArr3)), i);
        }
        throw new InvalidAlgorithmParameterException("outputLength too large, max is 16 bytes");
    }
}
