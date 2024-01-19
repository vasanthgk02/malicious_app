package com.google.crypto.tink.prf;

import java.security.GeneralSecurityException;

public interface Prf {
    byte[] compute(byte[] bArr, int i) throws GeneralSecurityException;
}
