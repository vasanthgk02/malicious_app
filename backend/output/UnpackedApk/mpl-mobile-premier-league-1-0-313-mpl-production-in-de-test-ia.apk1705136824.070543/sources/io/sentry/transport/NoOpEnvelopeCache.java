package io.sentry.transport;

import io.sentry.SentryEnvelope;
import io.sentry.cache.IEnvelopeCache;
import io.sentry.cache.IEnvelopeCache.CC;
import java.util.ArrayList;
import java.util.Iterator;

public final class NoOpEnvelopeCache implements IEnvelopeCache {
    public static final NoOpEnvelopeCache instance = new NoOpEnvelopeCache();

    public static NoOpEnvelopeCache getInstance() {
        return instance;
    }

    public void discard(SentryEnvelope sentryEnvelope) {
    }

    public Iterator<SentryEnvelope> iterator() {
        return new ArrayList(0).iterator();
    }

    public /* synthetic */ void store(SentryEnvelope sentryEnvelope) {
        CC.$default$store(this, sentryEnvelope);
    }

    public void store(SentryEnvelope sentryEnvelope, Object obj) {
    }
}
