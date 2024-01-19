package org.spongycastle.util.io.pem;

import java.io.IOException;

public class PemGenerationException extends IOException {
    public Throwable getCause() {
        return null;
    }
}
