package org.spongycastle.openssl;

public class EncryptionException extends PEMException {
    public Throwable getCause() {
        return null;
    }
}
