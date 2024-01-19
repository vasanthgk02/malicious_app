package io.sentry.android.core;

import com.razorpay.AnalyticsConstants;
import io.sentry.IHub;
import io.sentry.Integration;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.util.Objects;
import java.io.Closeable;
import java.io.IOException;

public final class NdkIntegration implements Integration, Closeable {
    public static final String SENTRY_NDK_CLASS_NAME = "io.sentry.android.ndk.SentryNdk";
    public SentryAndroidOptions options;
    public final Class<?> sentryNdkClass;

    public NdkIntegration(Class<?> cls) {
        this.sentryNdkClass = cls;
    }

    public void close() throws IOException {
        SentryAndroidOptions sentryAndroidOptions = this.options;
        if (sentryAndroidOptions != null && sentryAndroidOptions.isEnableNdk()) {
            Class<?> cls = this.sentryNdkClass;
            if (cls != null) {
                try {
                    cls.getMethod("close", new Class[0]).invoke(null, new Object[0]);
                    this.options.getLogger().log(SentryLevel.DEBUG, (String) "NdkIntegration removed.", new Object[0]);
                } catch (NoSuchMethodException e2) {
                    this.options.getLogger().log(SentryLevel.ERROR, (String) "Failed to invoke the SentryNdk.close method.", (Throwable) e2);
                } catch (Throwable th) {
                    this.options.setEnableNdk(false);
                    throw th;
                }
                this.options.setEnableNdk(false);
            }
        }
    }

    public Class<?> getSentryNdkClass() {
        return this.sentryNdkClass;
    }

    public final void register(IHub iHub, SentryOptions sentryOptions) {
        Objects.requireNonNull(iHub, "Hub is required");
        SentryAndroidOptions sentryAndroidOptions = (SentryAndroidOptions) Objects.requireNonNull(sentryOptions instanceof SentryAndroidOptions ? (SentryAndroidOptions) sentryOptions : null, "SentryAndroidOptions is required");
        this.options = sentryAndroidOptions;
        boolean isEnableNdk = sentryAndroidOptions.isEnableNdk();
        this.options.getLogger().log(SentryLevel.DEBUG, (String) "NdkIntegration enabled: %s", Boolean.valueOf(isEnableNdk));
        if (!isEnableNdk || this.sentryNdkClass == null) {
            this.options.setEnableNdk(false);
        } else {
            String cacheDirPath = this.options.getCacheDirPath();
            if (cacheDirPath == null || cacheDirPath.isEmpty()) {
                this.options.getLogger().log(SentryLevel.ERROR, (String) "No cache dir path is defined in options.", new Object[0]);
                this.options.setEnableNdk(false);
                return;
            }
            try {
                this.sentryNdkClass.getMethod(AnalyticsConstants.INIT, new Class[]{SentryAndroidOptions.class}).invoke(null, new Object[]{this.options});
                this.options.getLogger().log(SentryLevel.DEBUG, (String) "NdkIntegration installed.", new Object[0]);
            } catch (NoSuchMethodException e2) {
                this.options.setEnableNdk(false);
                this.options.getLogger().log(SentryLevel.ERROR, (String) "Failed to invoke the SentryNdk.init method.", (Throwable) e2);
            } catch (Throwable th) {
                this.options.setEnableNdk(false);
                this.options.getLogger().log(SentryLevel.ERROR, (String) "Failed to initialize SentryNdk.", th);
            }
        }
    }
}
