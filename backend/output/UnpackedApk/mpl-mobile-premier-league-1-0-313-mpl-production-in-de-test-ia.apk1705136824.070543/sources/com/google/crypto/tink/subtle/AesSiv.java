package com.google.crypto.tink.subtle;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.material.resources.TextAppearanceConfig;
import com.google.crypto.tink.DeterministicAead;
import in.juspay.hypersdk.security.EncryptionHelper;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.util.Arrays;
import java.util.Collection;
import javax.crypto.AEADBadTagException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class AesSiv implements DeterministicAead {
    public static final byte[] BLOCK_ONE = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};
    public static final byte[] BLOCK_ZERO = new byte[16];
    public static final Collection<Integer> KEY_SIZES = Arrays.asList(new Integer[]{Integer.valueOf(64)});
    public final byte[] aesCtrKey;
    public final PrfAesCmac cmacForS2V;

    public AesSiv(byte[] bArr) throws GeneralSecurityException {
        if (KEY_SIZES.contains(Integer.valueOf(bArr.length))) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, bArr.length / 2);
            this.aesCtrKey = Arrays.copyOfRange(bArr, bArr.length / 2, bArr.length);
            this.cmacForS2V = new PrfAesCmac(copyOfRange);
            return;
        }
        throw new InvalidKeyException(GeneratedOutlineSupport.outline57(GeneratedOutlineSupport.outline73("invalid key size: "), bArr.length, " bytes; key must have 64 bytes"));
    }

    public byte[] decryptDeterministically(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length >= 16) {
            Cipher cipher = (Cipher) EngineFactory.CIPHER.getInstance("AES/CTR/NoPadding");
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, 16);
            byte[] bArr3 = (byte[]) copyOfRange.clone();
            bArr3[8] = (byte) (bArr3[8] & Byte.MAX_VALUE);
            bArr3[12] = (byte) (bArr3[12] & Byte.MAX_VALUE);
            cipher.init(2, new SecretKeySpec(this.aesCtrKey, EncryptionHelper.algorithm), new IvParameterSpec(bArr3));
            byte[] copyOfRange2 = Arrays.copyOfRange(bArr, 16, bArr.length);
            byte[] doFinal = cipher.doFinal(copyOfRange2);
            if (copyOfRange2.length == 0 && doFinal == null && TextAppearanceConfig.isAndroid()) {
                doFinal = new byte[0];
            }
            if (TextAppearanceConfig.equal(copyOfRange, s2v(bArr2, doFinal))) {
                return doFinal;
            }
            throw new AEADBadTagException("Integrity check failed.");
        }
        throw new GeneralSecurityException("Ciphertext too short.");
    }

    public byte[] encryptDeterministically(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length <= 2147483631) {
            Cipher cipher = (Cipher) EngineFactory.CIPHER.getInstance("AES/CTR/NoPadding");
            byte[] s2v = s2v(bArr2, bArr);
            byte[] bArr3 = (byte[]) s2v.clone();
            bArr3[8] = (byte) (bArr3[8] & Byte.MAX_VALUE);
            bArr3[12] = (byte) (bArr3[12] & Byte.MAX_VALUE);
            cipher.init(1, new SecretKeySpec(this.aesCtrKey, EncryptionHelper.algorithm), new IvParameterSpec(bArr3));
            return TextAppearanceConfig.concat(s2v, cipher.doFinal(bArr));
        }
        throw new GeneralSecurityException("plaintext too long");
    }

    public final byte[] s2v(byte[]... bArr) throws GeneralSecurityException {
        byte[] bArr2;
        byte[] bArr3;
        if (bArr.length == 0) {
            return this.cmacForS2V.compute(BLOCK_ONE, 16);
        }
        byte[] compute = this.cmacForS2V.compute(BLOCK_ZERO, 16);
        for (int i = 0; i < bArr.length - 1; i++) {
            if (bArr[i] == null) {
                bArr3 = new byte[0];
            } else {
                bArr3 = bArr[i];
            }
            compute = TextAppearanceConfig.xor(TextAppearanceConfig.dbl(compute), this.cmacForS2V.compute(bArr3, 16));
        }
        byte[] bArr4 = bArr[bArr.length - 1];
        if (bArr4.length < 16) {
            bArr2 = TextAppearanceConfig.xor(TextAppearanceConfig.cmacPad(bArr4), TextAppearanceConfig.dbl(compute));
        } else if (bArr4.length >= compute.length) {
            int length = bArr4.length - compute.length;
            bArr2 = Arrays.copyOf(bArr4, bArr4.length);
            for (int i2 = 0; i2 < compute.length; i2++) {
                int i3 = length + i2;
                bArr2[i3] = (byte) (bArr2[i3] ^ compute[i2]);
            }
        } else {
            throw new IllegalArgumentException("xorEnd requires a.length >= b.length");
        }
        return this.cmacForS2V.compute(bArr2, 16);
    }
}
