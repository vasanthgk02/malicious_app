package com.nimbusds.jose;

public class JOSEException extends Exception {
    public static final long serialVersionUID = 1;

    public JOSEException(String str) {
        super(str);
    }

    public JOSEException(String str, Throwable th) {
        super(str, th);
    }
}
