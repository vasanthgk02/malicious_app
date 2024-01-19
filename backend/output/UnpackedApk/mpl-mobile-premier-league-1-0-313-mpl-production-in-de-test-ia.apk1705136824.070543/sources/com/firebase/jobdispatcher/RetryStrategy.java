package com.firebase.jobdispatcher;

import com.google.firebase.crashlytics.internal.settings.SettingsJsonConstants;

public final class RetryStrategy {
    public static final RetryStrategy DEFAULT_EXPONENTIAL = new RetryStrategy(1, 30, SettingsJsonConstants.SETTINGS_CACHE_DURATION_DEFAULT);
    public final int initialBackoff;
    public final int maximumBackoff;
    public final int policy;

    public RetryStrategy(int i, int i2, int i3) {
        this.policy = i;
        this.initialBackoff = i2;
        this.maximumBackoff = i3;
    }
}
