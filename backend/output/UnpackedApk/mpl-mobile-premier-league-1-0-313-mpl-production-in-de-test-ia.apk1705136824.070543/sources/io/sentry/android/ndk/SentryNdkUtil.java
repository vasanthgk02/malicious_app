package io.sentry.android.ndk;

import io.sentry.protocol.SdkVersion;

public final class SentryNdkUtil {
    public static void addPackage(SdkVersion sdkVersion) {
        if (sdkVersion != null) {
            sdkVersion.addPackage("maven:io.sentry:sentry-android-ndk", "5.1.0-beta.2");
        }
    }
}
