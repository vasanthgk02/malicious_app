package io.sentry;

import io.sentry.protocol.SentryId;
import io.sentry.util.Objects;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jetbrains.annotations.ApiStatus.Internal;
import org.jetbrains.annotations.VisibleForTesting;

@Internal
public final class Span implements ISpan {
    public final SpanContext context;
    public final AtomicBoolean finished;
    public final IHub hub;
    public final SpanListener spanListener;
    public final Date startTimestamp;
    public Throwable throwable;
    public Date timestamp;
    public final SentryTracer transaction;

    public Span(SentryId sentryId, SpanId spanId, SentryTracer sentryTracer, String str, IHub iHub) {
        this(sentryId, spanId, sentryTracer, str, iHub, null, null);
    }

    public void finish() {
        finish(this.context.getStatus());
    }

    public String getDescription() {
        return this.context.getDescription();
    }

    public String getOperation() {
        return this.context.getOperation();
    }

    public SpanId getParentSpanId() {
        return this.context.getParentSpanId();
    }

    public SpanContext getSpanContext() {
        return this.context;
    }

    public SpanId getSpanId() {
        return this.context.getSpanId();
    }

    public Date getStartTimestamp() {
        return this.startTimestamp;
    }

    public SpanStatus getStatus() {
        return this.context.getStatus();
    }

    public String getTag(String str) {
        return this.context.getTags().get(str);
    }

    public Map<String, String> getTags() {
        return this.context.getTags();
    }

    public Throwable getThrowable() {
        return this.throwable;
    }

    public Date getTimestamp() {
        return this.timestamp;
    }

    public SentryId getTraceId() {
        return this.context.getTraceId();
    }

    public boolean isFinished() {
        return this.finished.get();
    }

    public Boolean isSampled() {
        return this.context.getSampled();
    }

    public void setDescription(String str) {
        this.context.setDescription(str);
    }

    public void setOperation(String str) {
        this.context.setOperation(str);
    }

    public void setStatus(SpanStatus spanStatus) {
        this.context.setStatus(spanStatus);
    }

    public void setTag(String str, String str2) {
        this.context.setTag(str, str2);
    }

    public void setThrowable(Throwable th) {
        this.throwable = th;
    }

    public ISpan startChild(String str) {
        return startChild(str, null);
    }

    public SentryTraceHeader toSentryTrace() {
        return new SentryTraceHeader(this.context.getTraceId(), this.context.getSpanId(), this.context.getSampled());
    }

    public Span(SentryId sentryId, SpanId spanId, SentryTracer sentryTracer, String str, IHub iHub, Date date, SpanListener spanListener2) {
        this.finished = new AtomicBoolean(false);
        SpanContext spanContext = new SpanContext(sentryId, new SpanId(), str, spanId, sentryTracer.isSampled());
        this.context = spanContext;
        this.transaction = (SentryTracer) Objects.requireNonNull(sentryTracer, "transaction is required");
        this.startTimestamp = date == null ? DateUtils.getCurrentDateTime() : date;
        this.hub = (IHub) Objects.requireNonNull(iHub, "hub is required");
        this.spanListener = spanListener2;
    }

    public void finish(SpanStatus spanStatus) {
        if (this.finished.compareAndSet(false, true)) {
            this.context.setStatus(spanStatus);
            this.timestamp = DateUtils.getCurrentDateTime();
            Throwable th = this.throwable;
            if (th != null) {
                this.hub.setSpanContext(th, this, this.transaction.getName());
            }
            SpanListener spanListener2 = this.spanListener;
            if (spanListener2 != null) {
                spanListener2.onSpanFinished(this);
            }
        }
    }

    public ISpan startChild(String str, String str2, Date date) {
        return this.transaction.startChild(this.context.getSpanId(), str, str2, date);
    }

    public ISpan startChild(String str, String str2) {
        return this.transaction.startChild(this.context.getSpanId(), str, str2);
    }

    @VisibleForTesting
    public Span(TransactionContext transactionContext, SentryTracer sentryTracer, IHub iHub, Date date) {
        this.finished = new AtomicBoolean(false);
        this.context = (SpanContext) Objects.requireNonNull(transactionContext, "context is required");
        this.transaction = (SentryTracer) Objects.requireNonNull(sentryTracer, "sentryTracer is required");
        this.hub = (IHub) Objects.requireNonNull(iHub, "hub is required");
        this.startTimestamp = date == null ? DateUtils.getCurrentDateTime() : date;
        this.spanListener = null;
    }
}
