package org.spongycastle.jce.exception;

import java.security.cert.CertPathValidatorException;

public class ExtCertPathValidatorException extends CertPathValidatorException {
    public Throwable getCause() {
        return null;
    }
}
