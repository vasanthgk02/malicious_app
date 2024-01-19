package org.spongycastle.cms;

import java.io.IOException;

public class CMSStreamException extends IOException {
    public Throwable getCause() {
        return null;
    }
}
