package io.sentry;

import com.xiaomi.mipush.sdk.Constants;
import io.sentry.exception.InvalidSentryTraceHeaderException;
import io.sentry.protocol.SentryId;

public final class SentryTraceHeader {
    public static final String SENTRY_TRACE_HEADER = "sentry-trace";
    public final Boolean sampled;
    public final SpanId spanId;
    public final SentryId traceId;

    public SentryTraceHeader(SentryId sentryId, SpanId spanId2, Boolean bool) {
        this.traceId = sentryId;
        this.spanId = spanId2;
        this.sampled = bool;
    }

    public String getName() {
        return SENTRY_TRACE_HEADER;
    }

    public SpanId getSpanId() {
        return this.spanId;
    }

    public SentryId getTraceId() {
        return this.traceId;
    }

    public String getValue() {
        Boolean bool = this.sampled;
        if (bool != null) {
            Object[] objArr = new Object[3];
            objArr[0] = this.traceId;
            objArr[1] = this.spanId;
            objArr[2] = bool.booleanValue() ? "1" : "0";
            return String.format("%s-%s-%s", objArr);
        }
        return String.format("%s-%s", new Object[]{this.traceId, this.spanId});
    }

    public Boolean isSampled() {
        return this.sampled;
    }

    public SentryTraceHeader(String str) throws InvalidSentryTraceHeaderException {
        String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER, -1);
        if (split.length >= 2) {
            if (split.length == 3) {
                this.sampled = Boolean.valueOf("1".equals(split[2]));
            } else {
                this.sampled = null;
            }
            this.traceId = new SentryId(split[0]);
            this.spanId = new SpanId(split[1]);
            return;
        }
        throw new InvalidSentryTraceHeaderException(str);
    }
}
