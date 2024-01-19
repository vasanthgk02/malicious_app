package io.sentry.android.core;

import android.content.Context;
import android.os.SystemClock;
import io.sentry.DateUtils;
import io.sentry.ILogger;
import io.sentry.OptionsContainer;
import io.sentry.Sentry;
import io.sentry.Sentry.OptionsConfiguration;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

public final class SentryAndroid {
    public static final long appStart = SystemClock.uptimeMillis();
    public static final Date appStartTime = DateUtils.getCurrentDateTime();

    public static void init(Context context) {
        init(context, (ILogger) new AndroidLogger());
    }

    public static /* synthetic */ void lambda$init$0(SentryAndroidOptions sentryAndroidOptions) {
    }

    public static /* synthetic */ void lambda$init$1(Context context, ILogger iLogger, OptionsConfiguration optionsConfiguration, SentryAndroidOptions sentryAndroidOptions) {
        AndroidOptionsInitializer.init(sentryAndroidOptions, context, iLogger);
        optionsConfiguration.configure(sentryAndroidOptions);
    }

    public static void init(Context context, ILogger iLogger) {
        init(context, iLogger, $$Lambda$SentryAndroid$1tDpu4BrZ9ZUeZ0tE52kgN3Zx10.INSTANCE);
    }

    public static void init(Context context, OptionsConfiguration<SentryAndroidOptions> optionsConfiguration) {
        init(context, new AndroidLogger(), optionsConfiguration);
    }

    public static synchronized void init(Context context, ILogger iLogger, OptionsConfiguration<SentryAndroidOptions> optionsConfiguration) {
        synchronized (SentryAndroid.class) {
            AppStartState.getInstance().setAppStartTime(appStart, appStartTime);
            try {
                Sentry.init(OptionsContainer.create(SentryAndroidOptions.class), new OptionsConfiguration(context, iLogger, optionsConfiguration) {
                    public final /* synthetic */ Context f$0;
                    public final /* synthetic */ ILogger f$1;
                    public final /* synthetic */ OptionsConfiguration f$2;

                    {
                        this.f$0 = r1;
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void configure(SentryOptions sentryOptions) {
                        SentryAndroid.lambda$init$1(this.f$0, this.f$1, this.f$2, (SentryAndroidOptions) sentryOptions);
                    }
                }, true);
            } catch (IllegalAccessException e2) {
                iLogger.log(SentryLevel.FATAL, (String) "Fatal error during SentryAndroid.init(...)", (Throwable) e2);
                throw new RuntimeException("Failed to initialize Sentry's SDK", e2);
            } catch (InstantiationException e3) {
                iLogger.log(SentryLevel.FATAL, (String) "Fatal error during SentryAndroid.init(...)", (Throwable) e3);
                throw new RuntimeException("Failed to initialize Sentry's SDK", e3);
            } catch (NoSuchMethodException e4) {
                iLogger.log(SentryLevel.FATAL, (String) "Fatal error during SentryAndroid.init(...)", (Throwable) e4);
                throw new RuntimeException("Failed to initialize Sentry's SDK", e4);
            } catch (InvocationTargetException e5) {
                iLogger.log(SentryLevel.FATAL, (String) "Fatal error during SentryAndroid.init(...)", (Throwable) e5);
                throw new RuntimeException("Failed to initialize Sentry's SDK", e5);
            }
        }
    }
}
