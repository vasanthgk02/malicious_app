package io.sentry.android.core;

import android.annotation.SuppressLint;
import android.content.Context;
import io.sentry.IHub;
import io.sentry.ILogger;
import io.sentry.Integration;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.android.core.ANRWatchDog.ANRListener;
import io.sentry.exception.ExceptionMechanismException;
import io.sentry.protocol.Mechanism;
import io.sentry.util.Objects;
import java.io.Closeable;
import java.io.IOException;

public final class AnrIntegration implements Integration, Closeable {
    @SuppressLint({"StaticFieldLeak"})
    public static ANRWatchDog anrWatchDog;
    public static final Object watchDogLock = new Object();
    public final Context context;
    public SentryOptions options;

    public AnrIntegration(Context context2) {
        this.context = context2;
    }

    public void close() throws IOException {
        synchronized (watchDogLock) {
            if (anrWatchDog != null) {
                anrWatchDog.interrupt();
                anrWatchDog = null;
                if (this.options != null) {
                    this.options.getLogger().log(SentryLevel.DEBUG, (String) "AnrIntegration removed.", new Object[0]);
                }
            }
        }
    }

    public ANRWatchDog getANRWatchDog() {
        return anrWatchDog;
    }

    public /* synthetic */ void lambda$register$0$AnrIntegration(IHub iHub, SentryAndroidOptions sentryAndroidOptions, ApplicationNotResponding applicationNotResponding) {
        reportANR(iHub, sentryAndroidOptions.getLogger(), applicationNotResponding);
    }

    public final void register(IHub iHub, SentryOptions sentryOptions) {
        this.options = (SentryOptions) Objects.requireNonNull(sentryOptions, "SentryOptions is required");
        register(iHub, (SentryAndroidOptions) sentryOptions);
    }

    public void reportANR(IHub iHub, ILogger iLogger, ApplicationNotResponding applicationNotResponding) {
        iLogger.log(SentryLevel.INFO, (String) "ANR triggered with message: %s", applicationNotResponding.getMessage());
        Mechanism mechanism = new Mechanism();
        mechanism.setType("ANR");
        iHub.captureException(new ExceptionMechanismException(mechanism, applicationNotResponding, applicationNotResponding.getThread(), true));
    }

    private void register(IHub iHub, SentryAndroidOptions sentryAndroidOptions) {
        sentryAndroidOptions.getLogger().log(SentryLevel.DEBUG, (String) "AnrIntegration enabled: %s", Boolean.valueOf(sentryAndroidOptions.isAnrEnabled()));
        if (sentryAndroidOptions.isAnrEnabled()) {
            synchronized (watchDogLock) {
                if (anrWatchDog == null) {
                    sentryAndroidOptions.getLogger().log(SentryLevel.DEBUG, (String) "ANR timeout in milliseconds: %d", Long.valueOf(sentryAndroidOptions.getAnrTimeoutIntervalMillis()));
                    ANRWatchDog aNRWatchDog = new ANRWatchDog(sentryAndroidOptions.getAnrTimeoutIntervalMillis(), sentryAndroidOptions.isAnrReportInDebug(), new ANRListener(iHub, sentryAndroidOptions) {
                        public final /* synthetic */ IHub f$1;
                        public final /* synthetic */ SentryAndroidOptions f$2;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                        }

                        public final void onAppNotResponding(ApplicationNotResponding applicationNotResponding) {
                            AnrIntegration.this.lambda$register$0$AnrIntegration(this.f$1, this.f$2, applicationNotResponding);
                        }
                    }, sentryAndroidOptions.getLogger(), this.context);
                    anrWatchDog = aNRWatchDog;
                    aNRWatchDog.start();
                    sentryAndroidOptions.getLogger().log(SentryLevel.DEBUG, (String) "AnrIntegration installed.", new Object[0]);
                }
            }
        }
    }
}
