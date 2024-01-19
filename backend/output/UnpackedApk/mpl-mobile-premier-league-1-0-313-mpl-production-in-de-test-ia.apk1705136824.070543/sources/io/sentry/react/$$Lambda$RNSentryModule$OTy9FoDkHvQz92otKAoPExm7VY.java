package io.sentry.react;

import io.sentry.SentryEvent;
import io.sentry.SentryOptions.BeforeSendCallback;

/* renamed from: io.sentry.react.-$$Lambda$RNSentryModule$OTy9FoDkHvQz92-otKAoPExm7VY  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$RNSentryModule$OTy9FoDkHvQz92otKAoPExm7VY implements BeforeSendCallback {
    public static final /* synthetic */ $$Lambda$RNSentryModule$OTy9FoDkHvQz92otKAoPExm7VY INSTANCE = new $$Lambda$RNSentryModule$OTy9FoDkHvQz92otKAoPExm7VY();

    private /* synthetic */ $$Lambda$RNSentryModule$OTy9FoDkHvQz92otKAoPExm7VY() {
    }

    public final SentryEvent execute(SentryEvent sentryEvent, Object obj) {
        return RNSentryModule.lambda$startWithOptions$0(sentryEvent, obj);
    }
}
