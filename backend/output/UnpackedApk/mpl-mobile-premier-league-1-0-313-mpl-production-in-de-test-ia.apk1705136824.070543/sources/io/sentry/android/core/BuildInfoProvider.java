package io.sentry.android.core;

import android.os.Build;
import android.os.Build.VERSION;
import org.jetbrains.annotations.ApiStatus.Internal;

@Internal
public final class BuildInfoProvider implements IBuildInfoProvider {
    public String getBuildTags() {
        return Build.TAGS;
    }

    public int getSdkInfoVersion() {
        return VERSION.SDK_INT;
    }
}
