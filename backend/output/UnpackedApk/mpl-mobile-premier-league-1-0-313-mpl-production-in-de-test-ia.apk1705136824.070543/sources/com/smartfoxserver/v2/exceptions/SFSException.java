package com.smartfoxserver.v2.exceptions;

public class SFSException extends Exception {
    public static final long serialVersionUID = 6052949605652105170L;
    public SFSErrorData errorData;

    public SFSException() {
        this.errorData = null;
    }

    public SFSErrorData getErrorData() {
        return this.errorData;
    }

    public SFSException(String str) {
        super(str);
        this.errorData = null;
    }

    public SFSException(String str, SFSErrorData sFSErrorData) {
        super(str);
        this.errorData = sFSErrorData;
    }

    public SFSException(Throwable th) {
        super(th);
        this.errorData = null;
    }
}
