package org.spongycastle.openpgp;

public class PGPException extends Exception {
    public Exception underlying;

    public PGPException(String str) {
        super(str);
    }

    public Throwable getCause() {
        return this.underlying;
    }

    public PGPException(String str, Exception exc) {
        super(str);
        this.underlying = exc;
    }
}
