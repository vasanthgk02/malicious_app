package org.spongycastle.cert;

public class CertRuntimeException extends RuntimeException {
    public Throwable getCause() {
        return null;
    }
}
