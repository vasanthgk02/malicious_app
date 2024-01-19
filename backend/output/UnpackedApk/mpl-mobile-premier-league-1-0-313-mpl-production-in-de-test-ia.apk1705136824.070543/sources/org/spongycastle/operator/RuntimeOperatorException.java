package org.spongycastle.operator;

public class RuntimeOperatorException extends RuntimeException {
    public Throwable getCause() {
        return null;
    }
}
