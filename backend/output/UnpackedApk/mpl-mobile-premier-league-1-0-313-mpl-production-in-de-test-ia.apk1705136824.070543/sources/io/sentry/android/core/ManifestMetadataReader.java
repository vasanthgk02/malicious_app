package io.sentry.android.core;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import io.sentry.ILogger;
import io.sentry.SentryLevel;
import io.sentry.util.Objects;
import java.util.Locale;

public final class ManifestMetadataReader {
    public static final String ANR_ENABLE = "io.sentry.anr.enable";
    public static final String ANR_REPORT_DEBUG = "io.sentry.anr.report-debug";
    public static final String ANR_TIMEOUT_INTERVAL_MILLIS = "io.sentry.anr.timeout-interval-millis";
    public static final String ATTACH_THREADS = "io.sentry.attach-threads";
    public static final String AUTO_INIT = "io.sentry.auto-init";
    public static final String AUTO_SESSION_TRACKING_ENABLE = "io.sentry.auto-session-tracking.enable";
    public static final String BREADCRUMBS_ACTIVITY_LIFECYCLE_ENABLE = "io.sentry.breadcrumbs.activity-lifecycle";
    public static final String BREADCRUMBS_APP_COMPONENTS_ENABLE = "io.sentry.breadcrumbs.app-components";
    public static final String BREADCRUMBS_APP_LIFECYCLE_ENABLE = "io.sentry.breadcrumbs.app-lifecycle";
    public static final String BREADCRUMBS_SYSTEM_EVENTS_ENABLE = "io.sentry.breadcrumbs.system-events";
    public static final String DEBUG = "io.sentry.debug";
    public static final String DEBUG_LEVEL = "io.sentry.debug.level";
    public static final String DSN = "io.sentry.dsn";
    public static final String ENVIRONMENT = "io.sentry.environment";
    public static final String NDK_ENABLE = "io.sentry.ndk.enable";
    public static final String NDK_SCOPE_SYNC_ENABLE = "io.sentry.ndk.scope-sync.enable";
    public static final String RELEASE = "io.sentry.release";
    public static final String SAMPLE_RATE = "io.sentry.sample-rate";
    public static final String SESSION_TRACKING_ENABLE = "io.sentry.session-tracking.enable";
    public static final String SESSION_TRACKING_TIMEOUT_INTERVAL_MILLIS = "io.sentry.session-tracking.timeout-interval-millis";
    public static final String TRACES_ACTIVITY_AUTO_FINISH_ENABLE = "io.sentry.traces.activity.auto-finish.enable";
    public static final String TRACES_ACTIVITY_ENABLE = "io.sentry.traces.activity.enable";
    public static final String TRACES_SAMPLE_RATE = "io.sentry.traces.sample-rate";
    public static final String UNCAUGHT_EXCEPTION_HANDLER_ENABLE = "io.sentry.uncaught-exception-handler.enable";

    public static void applyMetadata(Context context, SentryAndroidOptions sentryAndroidOptions) {
        Objects.requireNonNull(context, "The application context is required.");
        Objects.requireNonNull(sentryAndroidOptions, "The options object is required.");
        try {
            Bundle metadata = getMetadata(context);
            ILogger logger = sentryAndroidOptions.getLogger();
            if (metadata != null) {
                sentryAndroidOptions.setDebug(Boolean.valueOf(readBool(metadata, logger, DEBUG, sentryAndroidOptions.isDebug())));
                if (sentryAndroidOptions.isDebug()) {
                    String readString = readString(metadata, logger, DEBUG_LEVEL, sentryAndroidOptions.getDiagnosticLevel().name().toLowerCase(Locale.ROOT));
                    if (readString != null) {
                        sentryAndroidOptions.setDiagnosticLevel(SentryLevel.valueOf(readString.toUpperCase(Locale.ROOT)));
                    }
                }
                sentryAndroidOptions.setAnrEnabled(readBool(metadata, logger, ANR_ENABLE, sentryAndroidOptions.isAnrEnabled()));
                sentryAndroidOptions.setEnableAutoSessionTracking(readBool(metadata, logger, AUTO_SESSION_TRACKING_ENABLE, readBool(metadata, logger, SESSION_TRACKING_ENABLE, sentryAndroidOptions.isEnableAutoSessionTracking())));
                if (sentryAndroidOptions.getSampleRate() == null) {
                    Double readDouble = readDouble(metadata, logger, SAMPLE_RATE);
                    if (readDouble.doubleValue() != -1.0d) {
                        sentryAndroidOptions.setSampleRate(readDouble);
                    }
                }
                sentryAndroidOptions.setAnrReportInDebug(readBool(metadata, logger, ANR_REPORT_DEBUG, sentryAndroidOptions.isAnrReportInDebug()));
                sentryAndroidOptions.setAnrTimeoutIntervalMillis(readLong(metadata, logger, ANR_TIMEOUT_INTERVAL_MILLIS, sentryAndroidOptions.getAnrTimeoutIntervalMillis()));
                String readString2 = readString(metadata, logger, DSN, sentryAndroidOptions.getDsn());
                if (readString2 == null) {
                    sentryAndroidOptions.getLogger().log(SentryLevel.FATAL, (String) "DSN is required. Use empty string to disable SDK.", new Object[0]);
                } else if (readString2.isEmpty()) {
                    sentryAndroidOptions.getLogger().log(SentryLevel.DEBUG, (String) "DSN is empty, disabling sentry-android", new Object[0]);
                }
                sentryAndroidOptions.setDsn(readString2);
                sentryAndroidOptions.setEnableNdk(readBool(metadata, logger, NDK_ENABLE, sentryAndroidOptions.isEnableNdk()));
                sentryAndroidOptions.setEnableScopeSync(readBool(metadata, logger, NDK_SCOPE_SYNC_ENABLE, sentryAndroidOptions.isEnableScopeSync()));
                sentryAndroidOptions.setRelease(readString(metadata, logger, RELEASE, sentryAndroidOptions.getRelease()));
                sentryAndroidOptions.setEnvironment(readString(metadata, logger, ENVIRONMENT, sentryAndroidOptions.getEnvironment()));
                sentryAndroidOptions.setSessionTrackingIntervalMillis(readLong(metadata, logger, SESSION_TRACKING_TIMEOUT_INTERVAL_MILLIS, sentryAndroidOptions.getSessionTrackingIntervalMillis()));
                sentryAndroidOptions.setEnableActivityLifecycleBreadcrumbs(readBool(metadata, logger, BREADCRUMBS_ACTIVITY_LIFECYCLE_ENABLE, sentryAndroidOptions.isEnableActivityLifecycleBreadcrumbs()));
                sentryAndroidOptions.setEnableAppLifecycleBreadcrumbs(readBool(metadata, logger, BREADCRUMBS_APP_LIFECYCLE_ENABLE, sentryAndroidOptions.isEnableAppComponentBreadcrumbs()));
                sentryAndroidOptions.setEnableSystemEventBreadcrumbs(readBool(metadata, logger, BREADCRUMBS_SYSTEM_EVENTS_ENABLE, sentryAndroidOptions.isEnableSystemEventBreadcrumbs()));
                sentryAndroidOptions.setEnableAppComponentBreadcrumbs(readBool(metadata, logger, BREADCRUMBS_APP_COMPONENTS_ENABLE, sentryAndroidOptions.isEnableAppComponentBreadcrumbs()));
                sentryAndroidOptions.setEnableUncaughtExceptionHandler(Boolean.valueOf(readBool(metadata, logger, UNCAUGHT_EXCEPTION_HANDLER_ENABLE, sentryAndroidOptions.isEnableUncaughtExceptionHandler())));
                sentryAndroidOptions.setAttachThreads(readBool(metadata, logger, ATTACH_THREADS, sentryAndroidOptions.isAttachThreads()));
                if (sentryAndroidOptions.getTracesSampleRate() == null) {
                    Double readDouble2 = readDouble(metadata, logger, TRACES_SAMPLE_RATE);
                    if (readDouble2.doubleValue() != -1.0d) {
                        sentryAndroidOptions.setTracesSampleRate(readDouble2);
                    }
                }
                sentryAndroidOptions.setEnableAutoActivityLifecycleTracing(readBool(metadata, logger, TRACES_ACTIVITY_ENABLE, sentryAndroidOptions.isEnableAutoActivityLifecycleTracing()));
                sentryAndroidOptions.setEnableActivityLifecycleTracingAutoFinish(readBool(metadata, logger, TRACES_ACTIVITY_AUTO_FINISH_ENABLE, sentryAndroidOptions.isEnableActivityLifecycleTracingAutoFinish()));
            }
            sentryAndroidOptions.getLogger().log(SentryLevel.INFO, (String) "Retrieving configuration from AndroidManifest.xml", new Object[0]);
        } catch (Exception e2) {
            sentryAndroidOptions.getLogger().log(SentryLevel.ERROR, (String) "Failed to read configuration from android manifest metadata.", (Throwable) e2);
        }
    }

    public static Bundle getMetadata(Context context) throws NameNotFoundException {
        return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
    }

    public static boolean isAutoInit(Context context, ILogger iLogger) {
        Objects.requireNonNull(context, "The application context is required.");
        boolean z = true;
        try {
            Bundle metadata = getMetadata(context);
            if (metadata != null) {
                z = readBool(metadata, iLogger, AUTO_INIT, true);
            }
            iLogger.log(SentryLevel.INFO, (String) "Retrieving auto-init from AndroidManifest.xml", new Object[0]);
        } catch (Exception e2) {
            iLogger.log(SentryLevel.ERROR, (String) "Failed to read auto-init from android manifest metadata.", (Throwable) e2);
        }
        return z;
    }

    public static boolean readBool(Bundle bundle, ILogger iLogger, String str, boolean z) {
        boolean z2 = bundle.getBoolean(str, z);
        iLogger.log(SentryLevel.DEBUG, (String) "%s read: %s", str, Boolean.valueOf(z2));
        return z2;
    }

    public static Double readDouble(Bundle bundle, ILogger iLogger, String str) {
        Double valueOf = Double.valueOf(Float.valueOf(bundle.getFloat(str, -1.0f)).doubleValue());
        iLogger.log(SentryLevel.DEBUG, (String) "%s read: %s", str, valueOf);
        return valueOf;
    }

    public static long readLong(Bundle bundle, ILogger iLogger, String str, long j) {
        long j2 = (long) bundle.getInt(str, (int) j);
        iLogger.log(SentryLevel.DEBUG, (String) "%s read: %s", str, Long.valueOf(j2));
        return j2;
    }

    public static String readString(Bundle bundle, ILogger iLogger, String str, String str2) {
        String string = bundle.getString(str, str2);
        iLogger.log(SentryLevel.DEBUG, (String) "%s read: %s", str, string);
        return string;
    }
}
