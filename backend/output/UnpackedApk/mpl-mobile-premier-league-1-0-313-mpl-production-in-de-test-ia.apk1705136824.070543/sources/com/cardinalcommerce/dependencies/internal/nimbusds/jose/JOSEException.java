package com.cardinalcommerce.dependencies.internal.nimbusds.jose;

public class JOSEException extends Exception {
    public JOSEException(String str) {
        super(str);
    }

    public JOSEException(String str, Throwable th) {
        super(str, th);
    }
}
