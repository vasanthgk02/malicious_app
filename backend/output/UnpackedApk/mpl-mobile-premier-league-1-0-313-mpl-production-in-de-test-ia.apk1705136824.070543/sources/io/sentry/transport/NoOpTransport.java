package io.sentry.transport;

import io.sentry.SentryEnvelope;
import io.sentry.transport.ITransport.CC;
import java.io.IOException;
import org.jetbrains.annotations.ApiStatus.Internal;

@Internal
public final class NoOpTransport implements ITransport {
    public static final NoOpTransport instance = new NoOpTransport();

    public static NoOpTransport getInstance() {
        return instance;
    }

    public void close() throws IOException {
    }

    public void flush(long j) {
    }

    public /* synthetic */ void send(SentryEnvelope sentryEnvelope) throws IOException {
        CC.$default$send(this, sentryEnvelope);
    }

    public void send(SentryEnvelope sentryEnvelope, Object obj) throws IOException {
    }
}
