package com.google.crypto.tink.subtle;

import java.security.InvalidKeyException;

public final class XChaCha20Poly1305 extends ChaCha20Poly1305Base {
    public XChaCha20Poly1305(byte[] bArr) throws InvalidKeyException {
        super(bArr);
    }

    public ChaCha20Base newChaCha20Instance(byte[] bArr, int i) throws InvalidKeyException {
        return new XChaCha20(bArr, i);
    }
}
