package org.spongycastle.openssl;

import java.io.IOException;

public class PEMException extends IOException {
    public Throwable getCause() {
        return null;
    }
}
