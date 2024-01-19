package org.apache.pdfbox.exceptions;

import java.io.IOException;

public class WrappedIOException extends IOException {
    public WrappedIOException(Throwable th) {
        initCause(th);
    }

    public WrappedIOException(String str, Throwable th) {
        super(str);
        initCause(th);
    }
}
