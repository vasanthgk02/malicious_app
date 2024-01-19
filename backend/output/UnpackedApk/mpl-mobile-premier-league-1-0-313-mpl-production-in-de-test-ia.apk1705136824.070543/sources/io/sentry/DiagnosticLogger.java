package io.sentry;

import io.sentry.util.Objects;
import org.jetbrains.annotations.ApiStatus.Internal;

@Internal
public final class DiagnosticLogger implements ILogger {
    public final ILogger logger;
    public final SentryOptions options;

    public DiagnosticLogger(SentryOptions sentryOptions, ILogger iLogger) {
        this.options = (SentryOptions) Objects.requireNonNull(sentryOptions, "SentryOptions is required.");
        this.logger = iLogger;
    }

    public ILogger getLogger() {
        return this.logger;
    }

    public boolean isEnabled(SentryLevel sentryLevel) {
        SentryLevel diagnosticLevel = this.options.getDiagnosticLevel();
        boolean z = false;
        if (sentryLevel == null) {
            return false;
        }
        if (this.options.isDebug() && sentryLevel.ordinal() >= diagnosticLevel.ordinal()) {
            z = true;
        }
        return z;
    }

    public void log(SentryLevel sentryLevel, String str, Object... objArr) {
        if (this.logger != null && isEnabled(sentryLevel)) {
            this.logger.log(sentryLevel, str, objArr);
        }
    }

    public void log(SentryLevel sentryLevel, String str, Throwable th) {
        if (this.logger != null && isEnabled(sentryLevel)) {
            this.logger.log(sentryLevel, str, th);
        }
    }

    public void log(SentryLevel sentryLevel, Throwable th, String str, Object... objArr) {
        if (this.logger != null && isEnabled(sentryLevel)) {
            this.logger.log(sentryLevel, th, str, objArr);
        }
    }
}
