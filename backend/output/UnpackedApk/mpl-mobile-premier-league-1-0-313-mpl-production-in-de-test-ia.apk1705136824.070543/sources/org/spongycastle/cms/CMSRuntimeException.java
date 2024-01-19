package org.spongycastle.cms;

public class CMSRuntimeException extends RuntimeException {
    public Throwable getCause() {
        return null;
    }
}
