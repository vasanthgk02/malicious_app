package io.sentry.cache;

import io.sentry.SentryEnvelope;

public interface IEnvelopeCache extends Iterable<SentryEnvelope> {

    /* renamed from: io.sentry.cache.IEnvelopeCache$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$store(IEnvelopeCache _this, SentryEnvelope sentryEnvelope) {
            _this.store(sentryEnvelope, null);
        }
    }

    void discard(SentryEnvelope sentryEnvelope);

    void store(SentryEnvelope sentryEnvelope);

    void store(SentryEnvelope sentryEnvelope, Object obj);
}
