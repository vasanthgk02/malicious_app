package io.sentry.protocol;

import io.sentry.DateUtils;
import io.sentry.SentryBaseEvent;
import io.sentry.SentryTracer;
import io.sentry.Span;
import io.sentry.SpanContext;
import io.sentry.SpanStatus;
import io.sentry.util.Objects;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.jetbrains.annotations.ApiStatus.Internal;

@Internal
public final class SentryTransaction extends SentryBaseEvent {
    public final Map<String, MeasurementValue> measurements = new HashMap();
    public final List<SentrySpan> spans = new ArrayList();
    public final Date startTimestamp;
    public Date timestamp;
    public String transaction;
    public final String type = "transaction";

    public SentryTransaction(SentryTracer sentryTracer) {
        super(sentryTracer.getEventId());
        Objects.requireNonNull(sentryTracer, "sentryTracer is required");
        this.startTimestamp = sentryTracer.getStartTimestamp();
        this.timestamp = DateUtils.getCurrentDateTime();
        this.transaction = sentryTracer.getName();
        for (Span sentrySpan : sentryTracer.getChildren()) {
            this.spans.add(new SentrySpan(sentrySpan));
        }
        Contexts contexts = getContexts();
        for (Entry entry : sentryTracer.getContexts().entrySet()) {
            contexts.put((String) entry.getKey(), entry.getValue());
        }
        contexts.setTrace(sentryTracer.getSpanContext());
        setRequest(sentryTracer.getRequest());
    }

    public Map<String, MeasurementValue> getMeasurements() {
        return this.measurements;
    }

    public List<SentrySpan> getSpans() {
        return this.spans;
    }

    public Date getStartTimestamp() {
        return this.startTimestamp;
    }

    public SpanStatus getStatus() {
        SpanContext trace = getContexts().getTrace();
        if (trace != null) {
            return trace.getStatus();
        }
        return null;
    }

    public Date getTimestamp() {
        return this.timestamp;
    }

    public String getTransaction() {
        return this.transaction;
    }

    public String getType() {
        return "transaction";
    }

    public boolean isFinished() {
        return this.timestamp != null;
    }

    public boolean isSampled() {
        SpanContext trace = getContexts().getTrace();
        return trace != null && Boolean.TRUE.equals(trace.getSampled());
    }
}
