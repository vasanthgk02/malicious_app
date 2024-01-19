package io.sentry;

import io.sentry.transport.ITransport;
import io.sentry.transport.NoOpTransport;
import org.jetbrains.annotations.ApiStatus.Internal;

@Internal
public final class NoOpTransportFactory implements ITransportFactory {
    public static final NoOpTransportFactory instance = new NoOpTransportFactory();

    public static NoOpTransportFactory getInstance() {
        return instance;
    }

    public ITransport create(SentryOptions sentryOptions, RequestDetails requestDetails) {
        return NoOpTransport.getInstance();
    }
}
