package org.spongycastle.jce.provider;

public class AnnotatedException extends Exception {
    public Throwable getCause() {
        return null;
    }
}
