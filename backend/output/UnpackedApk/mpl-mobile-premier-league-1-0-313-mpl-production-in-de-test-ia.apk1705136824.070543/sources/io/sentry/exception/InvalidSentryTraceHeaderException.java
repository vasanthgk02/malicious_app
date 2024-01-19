package io.sentry.exception;

import com.android.tools.r8.GeneratedOutlineSupport;

public final class InvalidSentryTraceHeaderException extends Exception {
    public static final long serialVersionUID = 1;
    public final String sentryTraceHeader;

    public InvalidSentryTraceHeaderException(String str) {
        super(GeneratedOutlineSupport.outline50("sentry-trace header does not conform to expected format: ", str));
        this.sentryTraceHeader = str;
    }

    public String getSentryTraceHeader() {
        return this.sentryTraceHeader;
    }
}
