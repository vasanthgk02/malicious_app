package io.sentry.transport;

import io.sentry.SentryEnvelope;
import java.io.Closeable;
import java.io.IOException;

public interface ITransport extends Closeable {

    /* renamed from: io.sentry.transport.ITransport$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$send(ITransport _this, SentryEnvelope sentryEnvelope) throws IOException {
            _this.send(sentryEnvelope, null);
        }
    }

    void flush(long j);

    void send(SentryEnvelope sentryEnvelope) throws IOException;

    void send(SentryEnvelope sentryEnvelope, Object obj) throws IOException;
}
