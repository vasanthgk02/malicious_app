package com.cardinalcommerce.shared.models.exceptions;

public class SDKRuntimeException extends RuntimeException {
    public Throwable getCause() {
        return null;
    }

    public String getMessage() {
        return null;
    }
}
