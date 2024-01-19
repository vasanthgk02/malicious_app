package com.google.crypto.tink.subtle;

import com.google.android.material.resources.TextAppearanceConfig;
import com.google.crypto.tink.Aead;
import in.juspay.hypersdk.security.EncryptionHelper;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class AesGcmJce implements Aead {
    public static final ThreadLocal<Cipher> localCipher = new ThreadLocal<Cipher>() {
        public Object initialValue() {
            try {
                return (Cipher) EngineFactory.CIPHER.getInstance("AES/GCM/NoPadding");
            } catch (GeneralSecurityException e2) {
                throw new IllegalStateException(e2);
            }
        }
    };
    public final SecretKey keySpec;

    public AesGcmJce(byte[] bArr) throws GeneralSecurityException {
        Validators.validateAesKeySize(bArr.length);
        this.keySpec = new SecretKeySpec(bArr, EncryptionHelper.algorithm);
    }

    public static AlgorithmParameterSpec getParams(byte[] bArr, int i, int i2) throws GeneralSecurityException {
        int i3;
        if (TextAppearanceConfig.isAndroid()) {
            try {
                i3 = Class.forName("android.os.Build$VERSION").getDeclaredField("SDK_INT").getInt(null);
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException unused) {
                i3 = -1;
            }
            if (i3 <= 19) {
                return new IvParameterSpec(bArr, i, i2);
            }
        }
        return new GCMParameterSpec(128, bArr, i, i2);
    }

    public byte[] decrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length >= 28) {
            localCipher.get().init(2, this.keySpec, getParams(bArr, 0, 12));
            if (!(bArr2 == null || bArr2.length == 0)) {
                localCipher.get().updateAAD(bArr2);
            }
            return localCipher.get().doFinal(bArr, 12, bArr.length - 12);
        }
        throw new GeneralSecurityException("ciphertext too short");
    }

    public byte[] encrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length <= 2147483619) {
            byte[] bArr3 = new byte[(bArr.length + 12 + 16)];
            byte[] randBytes = Random.randBytes(12);
            System.arraycopy(randBytes, 0, bArr3, 0, 12);
            localCipher.get().init(1, this.keySpec, getParams(randBytes, 0, randBytes.length));
            if (!(bArr2 == null || bArr2.length == 0)) {
                localCipher.get().updateAAD(bArr2);
            }
            int doFinal = localCipher.get().doFinal(bArr, 0, bArr.length, bArr3, 12);
            if (doFinal == bArr.length + 16) {
                return bArr3;
            }
            throw new GeneralSecurityException(String.format("encryption failed; GCM tag must be %s bytes, but got only %s bytes", new Object[]{Integer.valueOf(16), Integer.valueOf(doFinal - bArr.length)}));
        }
        throw new GeneralSecurityException("plaintext too long");
    }
}
