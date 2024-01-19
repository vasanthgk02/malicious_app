package com.google.crypto.tink.subtle;

import java.security.GeneralSecurityException;
import java.security.Provider;
import javax.crypto.Cipher;
import javax.crypto.Mac;

public interface EngineWrapper<T> {

    public static class TCipher implements EngineWrapper<Cipher> {
        public Object getInstance(String str, Provider provider) throws GeneralSecurityException {
            if (provider == null) {
                return Cipher.getInstance(str);
            }
            return Cipher.getInstance(str, provider);
        }
    }

    public static class TMac implements EngineWrapper<Mac> {
        public Object getInstance(String str, Provider provider) throws GeneralSecurityException {
            if (provider == null) {
                return Mac.getInstance(str);
            }
            return Mac.getInstance(str, provider);
        }
    }

    T getInstance(String str, Provider provider) throws GeneralSecurityException;
}
