package io.sentry.transport;

import io.sentry.ISerializer;
import io.sentry.SentryEnvelope;
import io.sentry.transport.ITransport.CC;
import io.sentry.util.Objects;
import java.io.IOException;
import java.io.OutputStream;

public final class StdoutTransport implements ITransport {
    public final ISerializer serializer;

    public StdoutTransport(ISerializer iSerializer) {
        this.serializer = (ISerializer) Objects.requireNonNull(iSerializer, "Serializer is required");
    }

    public void close() {
    }

    public void flush(long j) {
        System.out.println("Flushing");
    }

    public /* synthetic */ void send(SentryEnvelope sentryEnvelope) throws IOException {
        CC.$default$send(this, sentryEnvelope);
    }

    public void send(SentryEnvelope sentryEnvelope, Object obj) throws IOException {
        Objects.requireNonNull(sentryEnvelope, "SentryEnvelope is required");
        try {
            this.serializer.serialize(sentryEnvelope, (OutputStream) System.out);
        } catch (Exception unused) {
        }
    }
}
