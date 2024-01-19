package org.spongycastle.jce.exception;

import java.security.cert.CertPathBuilderException;

public class ExtCertPathBuilderException extends CertPathBuilderException {
    public Throwable getCause() {
        return null;
    }
}
