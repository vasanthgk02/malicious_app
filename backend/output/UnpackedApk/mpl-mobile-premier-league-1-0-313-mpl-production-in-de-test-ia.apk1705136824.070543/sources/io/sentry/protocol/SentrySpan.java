package io.sentry.protocol;

import io.sentry.Span;
import io.sentry.SpanId;
import io.sentry.SpanStatus;
import io.sentry.util.CollectionUtils;
import io.sentry.util.Objects;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.ApiStatus.Internal;

@Internal
public final class SentrySpan {
    public final Map<String, Object> data;
    public final String description;
    public final String op;
    public final SpanId parentSpanId;
    public final SpanId spanId;
    public final Date startTimestamp;
    public final SpanStatus status;
    public final Map<String, String> tags;
    public final Date timestamp;
    public final SentryId traceId;

    public SentrySpan(Span span) {
        this(span, null);
    }

    public Map<String, Object> getData() {
        return this.data;
    }

    public String getDescription() {
        return this.description;
    }

    public String getOp() {
        return this.op;
    }

    public SpanId getParentSpanId() {
        return this.parentSpanId;
    }

    public SpanId getSpanId() {
        return this.spanId;
    }

    public Date getStartTimestamp() {
        return this.startTimestamp;
    }

    public SpanStatus getStatus() {
        return this.status;
    }

    public Map<String, String> getTags() {
        return this.tags;
    }

    public Date getTimestamp() {
        return this.timestamp;
    }

    public SentryId getTraceId() {
        return this.traceId;
    }

    public boolean isFinished() {
        return this.timestamp != null;
    }

    @Internal
    public SentrySpan(Span span, Map<String, Object> map) {
        Objects.requireNonNull(span, "span is required");
        this.description = span.getDescription();
        this.op = span.getOperation();
        this.spanId = span.getSpanId();
        this.parentSpanId = span.getParentSpanId();
        this.traceId = span.getTraceId();
        this.status = span.getStatus();
        this.tags = CollectionUtils.newConcurrentHashMap(span.getTags()) == null ? new ConcurrentHashMap<>() : CollectionUtils.newConcurrentHashMap(span.getTags());
        this.timestamp = span.getTimestamp();
        this.startTimestamp = span.getStartTimestamp();
        this.data = map;
    }
}
