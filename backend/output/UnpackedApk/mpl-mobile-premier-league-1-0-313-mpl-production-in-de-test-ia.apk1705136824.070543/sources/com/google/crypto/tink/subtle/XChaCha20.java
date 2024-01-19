package com.google.crypto.tink.subtle;

import java.security.InvalidKeyException;
import java.util.Arrays;

public class XChaCha20 extends ChaCha20Base {
    public XChaCha20(byte[] bArr, int i) throws InvalidKeyException {
        super(bArr, i);
    }

    public int[] createInitialState(int[] iArr, int i) {
        if (iArr.length == 6) {
            int[] iArr2 = new int[16];
            int[] iArr3 = new int[16];
            ChaCha20Base.setSigmaAndKey(iArr3, this.key);
            iArr3[12] = iArr[0];
            iArr3[13] = iArr[1];
            iArr3[14] = iArr[2];
            iArr3[15] = iArr[3];
            ChaCha20Base.shuffleState(iArr3);
            iArr3[4] = iArr3[12];
            iArr3[5] = iArr3[13];
            iArr3[6] = iArr3[14];
            iArr3[7] = iArr3[15];
            ChaCha20Base.setSigmaAndKey(iArr2, Arrays.copyOf(iArr3, 8));
            iArr2[12] = i;
            iArr2[13] = 0;
            iArr2[14] = iArr[4];
            iArr2[15] = iArr[5];
            return iArr2;
        }
        throw new IllegalArgumentException(String.format("XChaCha20 uses 192-bit nonces, but got a %d-bit nonce", new Object[]{Integer.valueOf(iArr.length * 32)}));
    }

    public int nonceSizeInBytes() {
        return 24;
    }
}
