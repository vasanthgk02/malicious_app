package org.spongycastle.openpgp;

public class PGPRuntimeOperationException extends RuntimeException {
    public final Throwable cause;

    public PGPRuntimeOperationException(String str, Throwable th) {
        super(str);
        this.cause = th;
    }

    public Throwable getCause() {
        return this.cause;
    }
}
