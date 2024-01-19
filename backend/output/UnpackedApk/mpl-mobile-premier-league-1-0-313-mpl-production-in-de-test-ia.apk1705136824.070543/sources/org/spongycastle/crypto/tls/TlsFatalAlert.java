package org.spongycastle.crypto.tls;

import java.io.IOException;

public class TlsFatalAlert extends IOException {
    public static final long serialVersionUID = 3584313123679111168L;

    public Throwable getCause() {
        return null;
    }
}
