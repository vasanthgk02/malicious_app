package com.google.crypto.tink.subtle;

import com.google.crypto.tink.Aead;
import in.juspay.hypersdk.security.EncryptionHelper;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.AEADBadTagException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import sfs2x.client.entities.invitation.InvitationReply;

public final class AesEaxJce implements Aead {
    public static final ThreadLocal<Cipher> localCtrCipher = new ThreadLocal<Cipher>() {
        public Object initialValue() {
            try {
                return (Cipher) EngineFactory.CIPHER.getInstance("AES/CTR/NOPADDING");
            } catch (GeneralSecurityException e2) {
                throw new IllegalStateException(e2);
            }
        }
    };
    public static final ThreadLocal<Cipher> localEcbCipher = new ThreadLocal<Cipher>() {
        public Object initialValue() {
            try {
                return (Cipher) EngineFactory.CIPHER.getInstance("AES/ECB/NOPADDING");
            } catch (GeneralSecurityException e2) {
                throw new IllegalStateException(e2);
            }
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f1718b;
    public final int ivSizeInBytes;
    public final SecretKeySpec keySpec;
    public final byte[] p;

    public AesEaxJce(byte[] bArr, int i) throws GeneralSecurityException {
        if (i == 12 || i == 16) {
            this.ivSizeInBytes = i;
            Validators.validateAesKeySize(bArr.length);
            this.keySpec = new SecretKeySpec(bArr, EncryptionHelper.algorithm);
            Cipher cipher = localEcbCipher.get();
            cipher.init(1, this.keySpec);
            byte[] multiplyByX = multiplyByX(cipher.doFinal(new byte[16]));
            this.f1718b = multiplyByX;
            this.p = multiplyByX(multiplyByX);
            return;
        }
        throw new IllegalArgumentException("IV size should be either 12 or 16 bytes");
    }

    public static byte[] multiplyByX(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        int i = 0;
        int i2 = 0;
        while (i2 < 15) {
            int i3 = i2 + 1;
            bArr2[i2] = (byte) (((bArr[i2] << 1) ^ ((bArr[i3] & 255) >>> 7)) & InvitationReply.EXPIRED);
            i2 = i3;
        }
        int i4 = bArr[15] << 1;
        if ((bArr[0] & 128) != 0) {
            i = 135;
        }
        bArr2[15] = (byte) (i4 ^ i);
        return bArr2;
    }

    public static byte[] xor(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        byte[] bArr3 = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr3[i] = (byte) (bArr[i] ^ bArr2[i]);
        }
        return bArr3;
    }

    public byte[] decrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = (bArr.length - this.ivSizeInBytes) - 16;
        if (length >= 0) {
            Cipher cipher = localEcbCipher.get();
            cipher.init(1, this.keySpec);
            byte[] omac = omac(cipher, 0, bArr, 0, this.ivSizeInBytes);
            if (bArr2 == null) {
                bArr2 = new byte[0];
            }
            byte[] bArr3 = bArr2;
            byte[] omac2 = omac(cipher, 1, bArr3, 0, bArr3.length);
            byte[] omac3 = omac(cipher, 2, bArr, this.ivSizeInBytes, length);
            int length2 = bArr.length - 16;
            byte b2 = 0;
            for (int i = 0; i < 16; i++) {
                b2 = (byte) (b2 | (((bArr[length2 + i] ^ omac2[i]) ^ omac[i]) ^ omac3[i]));
            }
            if (b2 == 0) {
                Cipher cipher2 = localCtrCipher.get();
                cipher2.init(1, this.keySpec, new IvParameterSpec(omac));
                return cipher2.doFinal(bArr, this.ivSizeInBytes, length);
            }
            throw new AEADBadTagException("tag mismatch");
        }
        throw new GeneralSecurityException("ciphertext too short");
    }

    public byte[] encrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = bArr;
        int length = bArr3.length;
        int i = this.ivSizeInBytes;
        if (length <= (Integer.MAX_VALUE - i) - 16) {
            byte[] bArr4 = new byte[(bArr3.length + i + 16)];
            byte[] randBytes = Random.randBytes(i);
            System.arraycopy(randBytes, 0, bArr4, 0, this.ivSizeInBytes);
            Cipher cipher = localEcbCipher.get();
            cipher.init(1, this.keySpec);
            byte[] omac = omac(cipher, 0, randBytes, 0, randBytes.length);
            byte[] bArr5 = bArr2 == null ? new byte[0] : bArr2;
            byte[] omac2 = omac(cipher, 1, bArr5, 0, bArr5.length);
            Cipher cipher2 = localCtrCipher.get();
            cipher2.init(1, this.keySpec, new IvParameterSpec(omac));
            cipher2.doFinal(bArr, 0, bArr3.length, bArr4, this.ivSizeInBytes);
            byte[] omac3 = omac(cipher, 2, bArr4, this.ivSizeInBytes, bArr3.length);
            int length2 = bArr3.length + this.ivSizeInBytes;
            for (int i2 = 0; i2 < 16; i2++) {
                bArr4[length2 + i2] = (byte) ((omac2[i2] ^ omac[i2]) ^ omac3[i2]);
            }
            return bArr4;
        }
        throw new GeneralSecurityException("plaintext too long");
    }

    public final byte[] omac(Cipher cipher, int i, byte[] bArr, int i2, int i3) throws IllegalBlockSizeException, BadPaddingException {
        byte[] bArr2;
        byte[] bArr3 = new byte[16];
        bArr3[15] = (byte) i;
        if (i3 == 0) {
            return cipher.doFinal(xor(bArr3, this.f1718b));
        }
        byte[] doFinal = cipher.doFinal(bArr3);
        int i4 = 0;
        while (i3 - i4 > 16) {
            for (int i5 = 0; i5 < 16; i5++) {
                doFinal[i5] = (byte) (doFinal[i5] ^ bArr[(i2 + i4) + i5]);
            }
            doFinal = cipher.doFinal(doFinal);
            i4 += 16;
        }
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i4 + i2, i2 + i3);
        if (copyOfRange.length == 16) {
            bArr2 = xor(copyOfRange, this.f1718b);
        } else {
            byte[] copyOf = Arrays.copyOf(this.p, 16);
            for (int i6 = 0; i6 < copyOfRange.length; i6++) {
                copyOf[i6] = (byte) (copyOf[i6] ^ copyOfRange[i6]);
            }
            copyOf[copyOfRange.length] = (byte) (copyOf[copyOfRange.length] ^ 128);
            bArr2 = copyOf;
        }
        return cipher.doFinal(xor(doFinal, bArr2));
    }
}
