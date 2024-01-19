package org.spongycastle.crypto.io;

import java.io.IOException;

public class CipherIOException extends IOException {
    public static final long serialVersionUID = 1;

    public Throwable getCause() {
        return null;
    }
}
