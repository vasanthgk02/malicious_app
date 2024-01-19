package io.sentry.android.core;

public interface IBuildInfoProvider {
    String getBuildTags();

    int getSdkInfoVersion();
}
