package com.google.crypto.tink.subtle;

import java.security.SecureRandom;

public final class Random {
    public static final ThreadLocal<SecureRandom> localRandom = new ThreadLocal<SecureRandom>() {
        public Object initialValue() {
            SecureRandom secureRandom = new SecureRandom();
            secureRandom.nextLong();
            return secureRandom;
        }
    };

    public static byte[] randBytes(int i) {
        byte[] bArr = new byte[i];
        localRandom.get().nextBytes(bArr);
        return bArr;
    }
}
