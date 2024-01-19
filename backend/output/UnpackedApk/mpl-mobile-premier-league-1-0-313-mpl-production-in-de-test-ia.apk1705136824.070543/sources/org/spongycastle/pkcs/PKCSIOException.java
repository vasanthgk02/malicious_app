package org.spongycastle.pkcs;

import java.io.IOException;

public class PKCSIOException extends IOException {
    public Throwable getCause() {
        return null;
    }
}
