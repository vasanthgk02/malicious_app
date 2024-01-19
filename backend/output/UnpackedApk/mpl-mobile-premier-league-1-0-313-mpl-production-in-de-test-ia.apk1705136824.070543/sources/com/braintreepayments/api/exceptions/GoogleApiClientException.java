package com.braintreepayments.api.exceptions;

public class GoogleApiClientException extends Exception {
    public int mErrorCode;
    public ErrorType mErrorType;

    public enum ErrorType {
        NotAttachedToActivity,
        ConnectionSuspended,
        ConnectionFailed
    }

    public GoogleApiClientException(ErrorType errorType, int i) {
        this.mErrorType = errorType;
        this.mErrorCode = i;
    }

    public String getMessage() {
        return toString();
    }

    public String toString() {
        return this.mErrorType.name() + ": " + this.mErrorCode;
    }
}
