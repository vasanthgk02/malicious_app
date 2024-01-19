package io.sentry.android.core;

import io.sentry.IHub;
import io.sentry.ILogger;
import io.sentry.Integration;
import io.sentry.OutboxSender;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.util.Objects;
import java.io.Closeable;

public abstract class EnvelopeFileObserverIntegration implements Integration, Closeable {
    public ILogger logger;
    public EnvelopeFileObserver observer;

    public static final class OutboxEnvelopeFileObserverIntegration extends EnvelopeFileObserverIntegration {
        public OutboxEnvelopeFileObserverIntegration() {
        }

        public String getPath(SentryOptions sentryOptions) {
            return sentryOptions.getOutboxPath();
        }
    }

    public static EnvelopeFileObserverIntegration getOutboxFileObserver() {
        return new OutboxEnvelopeFileObserverIntegration();
    }

    public void close() {
        EnvelopeFileObserver envelopeFileObserver = this.observer;
        if (envelopeFileObserver != null) {
            envelopeFileObserver.stopWatching();
            ILogger iLogger = this.logger;
            if (iLogger != null) {
                iLogger.log(SentryLevel.DEBUG, (String) "EnvelopeFileObserverIntegration removed.", new Object[0]);
            }
        }
    }

    public abstract String getPath(SentryOptions sentryOptions);

    public final void register(IHub iHub, SentryOptions sentryOptions) {
        Objects.requireNonNull(iHub, "Hub is required");
        Objects.requireNonNull(sentryOptions, "SentryOptions is required");
        this.logger = sentryOptions.getLogger();
        String path = getPath(sentryOptions);
        if (path == null) {
            this.logger.log(SentryLevel.WARNING, (String) "Null given as a path to EnvelopeFileObserverIntegration. Nothing will be registered.", new Object[0]);
            return;
        }
        this.logger.log(SentryLevel.DEBUG, (String) "Registering EnvelopeFileObserverIntegration for path: %s", path);
        OutboxSender outboxSender = new OutboxSender(iHub, sentryOptions.getEnvelopeReader(), sentryOptions.getSerializer(), this.logger, sentryOptions.getFlushTimeoutMillis());
        EnvelopeFileObserver envelopeFileObserver = new EnvelopeFileObserver(path, outboxSender, this.logger, sentryOptions.getFlushTimeoutMillis());
        this.observer = envelopeFileObserver;
        envelopeFileObserver.startWatching();
        this.logger.log(SentryLevel.DEBUG, (String) "EnvelopeFileObserverIntegration installed.", new Object[0]);
    }
}
