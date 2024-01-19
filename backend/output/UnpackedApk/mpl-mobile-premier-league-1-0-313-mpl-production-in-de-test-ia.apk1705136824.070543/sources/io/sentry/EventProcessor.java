package io.sentry;

import io.sentry.protocol.SentryTransaction;

public interface EventProcessor {

    /* renamed from: io.sentry.EventProcessor$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static SentryEvent $default$process(EventProcessor eventProcessor, SentryEvent sentryEvent, Object obj) {
            return sentryEvent;
        }

        public static SentryTransaction $default$process(EventProcessor eventProcessor, SentryTransaction sentryTransaction, Object obj) {
            return sentryTransaction;
        }
    }

    SentryEvent process(SentryEvent sentryEvent, Object obj);

    SentryTransaction process(SentryTransaction sentryTransaction, Object obj);
}
