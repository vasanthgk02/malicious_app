package io.sentry.android.ndk;

import com.razorpay.AnalyticsConstants;
import io.sentry.android.core.SentryAndroidOptions;
import org.jetbrains.annotations.ApiStatus.Internal;

@Internal
public final class SentryNdk {
    static {
        System.loadLibrary(AnalyticsConstants.LOG);
        System.loadLibrary("sentry");
        System.loadLibrary("sentry-android");
    }

    public static void close() {
        shutdown();
    }

    public static void init(SentryAndroidOptions sentryAndroidOptions) {
        SentryNdkUtil.addPackage(sentryAndroidOptions.getSdkVersion());
        initSentryNative(sentryAndroidOptions);
        sentryAndroidOptions.addScopeObserver(new NdkScopeObserver(sentryAndroidOptions));
        sentryAndroidOptions.setDebugImagesLoader(new DebugImagesLoader(sentryAndroidOptions, new NativeModuleListLoader()));
    }

    public static native void initSentryNative(SentryAndroidOptions sentryAndroidOptions);

    public static native void shutdown();
}
