package io.sentry;

public interface SpanListener {
    void onSpanFinished(Span span);
}
