package com.google.crypto.tink.subtle;

import com.google.android.material.resources.TextAppearanceConfig;
import com.google.crypto.tink.Aead;
import com.google.crypto.tink.Mac;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

public final class EncryptThenAuthenticate implements Aead {
    public final IndCpaCipher cipher;
    public final Mac mac;
    public final int macLength;

    public EncryptThenAuthenticate(IndCpaCipher indCpaCipher, Mac mac2, int i) {
        this.cipher = indCpaCipher;
        this.mac = mac2;
        this.macLength = i;
    }

    public byte[] decrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        int i = this.macLength;
        if (length >= i) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, bArr.length - i);
            byte[] copyOfRange2 = Arrays.copyOfRange(bArr, bArr.length - this.macLength, bArr.length);
            if (bArr2 == null) {
                bArr2 = new byte[0];
            }
            byte[] copyOf = Arrays.copyOf(ByteBuffer.allocate(8).putLong(((long) bArr2.length) * 8).array(), 8);
            this.mac.verifyMac(copyOfRange2, TextAppearanceConfig.concat(bArr2, copyOfRange, copyOf));
            return this.cipher.decrypt(copyOfRange);
        }
        throw new GeneralSecurityException("ciphertext too short");
    }

    public byte[] encrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] encrypt = this.cipher.encrypt(bArr);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        byte[] copyOf = Arrays.copyOf(ByteBuffer.allocate(8).putLong(((long) bArr2.length) * 8).array(), 8);
        return TextAppearanceConfig.concat(encrypt, this.mac.computeMac(TextAppearanceConfig.concat(bArr2, encrypt, copyOf)));
    }
}
