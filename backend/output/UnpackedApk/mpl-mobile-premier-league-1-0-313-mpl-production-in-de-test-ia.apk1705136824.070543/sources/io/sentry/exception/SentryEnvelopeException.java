package io.sentry.exception;

public final class SentryEnvelopeException extends Exception {
    public static final long serialVersionUID = -8307801916948173232L;

    public SentryEnvelopeException(String str) {
        super(str);
    }
}
