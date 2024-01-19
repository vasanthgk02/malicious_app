package com.smartfoxserver.v2.exceptions;

public class SFSRuntimeException extends RuntimeException {
    public SFSRuntimeException() {
    }

    public SFSRuntimeException(String str) {
        super(str);
    }

    public SFSRuntimeException(Throwable th) {
        super(th);
    }
}
