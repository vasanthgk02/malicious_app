package com.google.crypto.tink.subtle;

import com.google.android.material.resources.TextAppearanceConfig;
import com.google.crypto.tink.Aead;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import javax.crypto.AEADBadTagException;

public abstract class ChaCha20Poly1305Base implements Aead {
    public final ChaCha20Base chacha20;
    public final ChaCha20Base macKeyChaCha20;

    public ChaCha20Poly1305Base(byte[] bArr) throws InvalidKeyException {
        this.chacha20 = newChaCha20Instance(bArr, 1);
        this.macKeyChaCha20 = newChaCha20Instance(bArr, 0);
    }

    public static byte[] macDataRfc8439(byte[] bArr, ByteBuffer byteBuffer) {
        int length = bArr.length % 16 == 0 ? bArr.length : (bArr.length + 16) - (bArr.length % 16);
        int remaining = byteBuffer.remaining();
        int i = remaining % 16;
        int i2 = (i == 0 ? remaining : (remaining + 16) - i) + length;
        ByteBuffer order = ByteBuffer.allocate(i2 + 16).order(ByteOrder.LITTLE_ENDIAN);
        order.put(bArr);
        order.position(length);
        order.put(byteBuffer);
        order.position(i2);
        order.putLong((long) bArr.length);
        order.putLong((long) remaining);
        return order.array();
    }

    public byte[] decrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        if (wrap.remaining() >= this.chacha20.nonceSizeInBytes() + 16) {
            int position = wrap.position();
            byte[] bArr3 = new byte[16];
            wrap.position(wrap.limit() - 16);
            wrap.get(bArr3);
            wrap.position(position);
            wrap.limit(wrap.limit() - 16);
            byte[] bArr4 = new byte[this.chacha20.nonceSizeInBytes()];
            wrap.get(bArr4);
            if (bArr2 == null) {
                bArr2 = new byte[0];
            }
            try {
                byte[] bArr5 = new byte[32];
                this.macKeyChaCha20.chacha20Block(bArr4, 0).get(bArr5);
                if (TextAppearanceConfig.equal(TextAppearanceConfig.computeMac(bArr5, macDataRfc8439(bArr2, wrap)), bArr3)) {
                    wrap.position(position);
                    return this.chacha20.decrypt(wrap);
                }
                throw new GeneralSecurityException("invalid MAC");
            } catch (GeneralSecurityException e2) {
                throw new AEADBadTagException(e2.toString());
            }
        } else {
            throw new GeneralSecurityException("ciphertext too short");
        }
    }

    public byte[] encrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length <= (Integer.MAX_VALUE - this.chacha20.nonceSizeInBytes()) - 16) {
            ByteBuffer allocate = ByteBuffer.allocate(this.chacha20.nonceSizeInBytes() + bArr.length + 16);
            if (allocate.remaining() >= this.chacha20.nonceSizeInBytes() + bArr.length + 16) {
                int position = allocate.position();
                this.chacha20.encrypt(allocate, bArr);
                allocate.position(position);
                byte[] bArr3 = new byte[this.chacha20.nonceSizeInBytes()];
                allocate.get(bArr3);
                allocate.limit(allocate.limit() - 16);
                if (bArr2 == null) {
                    bArr2 = new byte[0];
                }
                byte[] bArr4 = new byte[32];
                this.macKeyChaCha20.chacha20Block(bArr3, 0).get(bArr4);
                byte[] computeMac = TextAppearanceConfig.computeMac(bArr4, macDataRfc8439(bArr2, allocate));
                allocate.limit(allocate.limit() + 16);
                allocate.put(computeMac);
                return allocate.array();
            }
            throw new IllegalArgumentException("Given ByteBuffer output is too small");
        }
        throw new GeneralSecurityException("plaintext too long");
    }

    public abstract ChaCha20Base newChaCha20Instance(byte[] bArr, int i) throws InvalidKeyException;
}
