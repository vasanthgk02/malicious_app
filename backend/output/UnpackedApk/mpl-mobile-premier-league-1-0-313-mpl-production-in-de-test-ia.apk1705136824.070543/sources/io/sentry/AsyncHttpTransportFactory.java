package io.sentry;

import io.sentry.transport.AsyncHttpTransport;
import io.sentry.transport.ITransport;
import io.sentry.transport.RateLimiter;
import io.sentry.util.Objects;
import org.jetbrains.annotations.ApiStatus.Internal;

@Internal
public final class AsyncHttpTransportFactory implements ITransportFactory {
    public ITransport create(SentryOptions sentryOptions, RequestDetails requestDetails) {
        Objects.requireNonNull(sentryOptions, "options is required");
        Objects.requireNonNull(requestDetails, "requestDetails is required");
        return new AsyncHttpTransport(sentryOptions, new RateLimiter(sentryOptions.getLogger()), sentryOptions.getTransportGate(), requestDetails);
    }
}
