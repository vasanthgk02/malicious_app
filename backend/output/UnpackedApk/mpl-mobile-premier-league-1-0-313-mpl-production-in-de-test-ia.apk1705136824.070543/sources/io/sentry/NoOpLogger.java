package io.sentry;

public final class NoOpLogger implements ILogger {
    public static final NoOpLogger instance = new NoOpLogger();

    public static NoOpLogger getInstance() {
        return instance;
    }

    public boolean isEnabled(SentryLevel sentryLevel) {
        return false;
    }

    public void log(SentryLevel sentryLevel, String str, Throwable th) {
    }

    public void log(SentryLevel sentryLevel, String str, Object... objArr) {
    }

    public void log(SentryLevel sentryLevel, Throwable th, String str, Object... objArr) {
    }
}
