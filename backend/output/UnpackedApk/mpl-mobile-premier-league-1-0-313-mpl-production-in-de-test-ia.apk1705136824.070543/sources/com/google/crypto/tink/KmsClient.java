package com.google.crypto.tink;

import java.security.GeneralSecurityException;

public interface KmsClient {
    boolean doesSupport(String str);

    Aead getAead(String str) throws GeneralSecurityException;
}
