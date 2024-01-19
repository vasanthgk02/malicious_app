package io.sentry;

import com.android.tools.r8.GeneratedOutlineSupport;
import io.sentry.UncaughtExceptionHandler.Adapter;
import io.sentry.exception.ExceptionMechanismException;
import io.sentry.hints.DiskFlushNotification;
import io.sentry.hints.Flushable;
import io.sentry.hints.SessionEnd;
import io.sentry.protocol.Mechanism;
import io.sentry.util.Objects;
import java.io.Closeable;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class UncaughtExceptionHandlerIntegration implements Integration, UncaughtExceptionHandler, Closeable {
    public UncaughtExceptionHandler defaultExceptionHandler;
    public IHub hub;
    public SentryOptions options;
    public boolean registered;
    public final UncaughtExceptionHandler threadAdapter;

    public static final class UncaughtExceptionHint implements DiskFlushNotification, Flushable, SessionEnd {
        public final long flushTimeoutMillis;
        public final CountDownLatch latch = new CountDownLatch(1);
        public final ILogger logger;

        public UncaughtExceptionHint(long j, ILogger iLogger) {
            this.flushTimeoutMillis = j;
            this.logger = iLogger;
        }

        public void markFlushed() {
            this.latch.countDown();
        }

        public boolean waitFlush() {
            try {
                return this.latch.await(this.flushTimeoutMillis, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e2) {
                Thread.currentThread().interrupt();
                this.logger.log(SentryLevel.ERROR, (String) "Exception while awaiting for flush in UncaughtExceptionHint", (Throwable) e2);
                return false;
            }
        }
    }

    public UncaughtExceptionHandlerIntegration() {
        this(Adapter.getInstance());
    }

    public static Throwable getUnhandledThrowable(Thread thread, Throwable th) {
        Mechanism mechanism = new Mechanism();
        mechanism.setHandled(Boolean.FALSE);
        mechanism.setType("UncaughtExceptionHandler");
        return new ExceptionMechanismException(mechanism, th, thread);
    }

    public void close() {
        if (this.defaultExceptionHandler != null && this == this.threadAdapter.getDefaultUncaughtExceptionHandler()) {
            this.threadAdapter.setDefaultUncaughtExceptionHandler(this.defaultExceptionHandler);
            SentryOptions sentryOptions = this.options;
            if (sentryOptions != null) {
                sentryOptions.getLogger().log(SentryLevel.DEBUG, (String) "UncaughtExceptionHandlerIntegration removed.", new Object[0]);
            }
        }
    }

    public final void register(IHub iHub, SentryOptions sentryOptions) {
        if (this.registered) {
            sentryOptions.getLogger().log(SentryLevel.ERROR, (String) "Attempt to register a UncaughtExceptionHandlerIntegration twice.", new Object[0]);
            return;
        }
        this.registered = true;
        this.hub = (IHub) Objects.requireNonNull(iHub, "Hub is required");
        SentryOptions sentryOptions2 = (SentryOptions) Objects.requireNonNull(sentryOptions, "SentryOptions is required");
        this.options = sentryOptions2;
        sentryOptions2.getLogger().log(SentryLevel.DEBUG, (String) "UncaughtExceptionHandlerIntegration enabled: %s", Boolean.valueOf(this.options.isEnableUncaughtExceptionHandler()));
        if (this.options.isEnableUncaughtExceptionHandler()) {
            UncaughtExceptionHandler defaultUncaughtExceptionHandler = this.threadAdapter.getDefaultUncaughtExceptionHandler();
            if (defaultUncaughtExceptionHandler != null) {
                ILogger logger = this.options.getLogger();
                SentryLevel sentryLevel = SentryLevel.DEBUG;
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("default UncaughtExceptionHandler class='");
                outline73.append(defaultUncaughtExceptionHandler.getClass().getName());
                outline73.append("'");
                logger.log(sentryLevel, outline73.toString(), new Object[0]);
                this.defaultExceptionHandler = defaultUncaughtExceptionHandler;
            }
            this.threadAdapter.setDefaultUncaughtExceptionHandler(this);
            this.options.getLogger().log(SentryLevel.DEBUG, (String) "UncaughtExceptionHandlerIntegration installed.", new Object[0]);
        }
    }

    public void uncaughtException(Thread thread, Throwable th) {
        SentryOptions sentryOptions = this.options;
        if (sentryOptions != null && this.hub != null) {
            sentryOptions.getLogger().log(SentryLevel.INFO, (String) "Uncaught exception received.", new Object[0]);
            try {
                UncaughtExceptionHint uncaughtExceptionHint = new UncaughtExceptionHint(this.options.getFlushTimeoutMillis(), this.options.getLogger());
                SentryEvent sentryEvent = new SentryEvent(getUnhandledThrowable(thread, th));
                sentryEvent.setLevel(SentryLevel.FATAL);
                this.hub.captureEvent(sentryEvent, uncaughtExceptionHint);
                if (!uncaughtExceptionHint.waitFlush()) {
                    this.options.getLogger().log(SentryLevel.WARNING, (String) "Timed out waiting to flush event to disk before crashing. Event: %s", sentryEvent.getEventId());
                }
            } catch (Exception e2) {
                this.options.getLogger().log(SentryLevel.ERROR, (String) "Error sending uncaught exception to Sentry.", (Throwable) e2);
            }
            if (this.defaultExceptionHandler != null) {
                this.options.getLogger().log(SentryLevel.INFO, (String) "Invoking inner uncaught exception handler.", new Object[0]);
                this.defaultExceptionHandler.uncaughtException(thread, th);
            }
        }
    }

    public UncaughtExceptionHandlerIntegration(UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.registered = false;
        this.threadAdapter = (UncaughtExceptionHandler) Objects.requireNonNull(uncaughtExceptionHandler, "threadAdapter is required.");
    }
}
