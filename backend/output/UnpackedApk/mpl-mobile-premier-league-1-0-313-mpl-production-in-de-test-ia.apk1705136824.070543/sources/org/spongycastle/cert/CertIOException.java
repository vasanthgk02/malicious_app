package org.spongycastle.cert;

import java.io.IOException;

public class CertIOException extends IOException {
    public Throwable getCause() {
        return null;
    }
}
