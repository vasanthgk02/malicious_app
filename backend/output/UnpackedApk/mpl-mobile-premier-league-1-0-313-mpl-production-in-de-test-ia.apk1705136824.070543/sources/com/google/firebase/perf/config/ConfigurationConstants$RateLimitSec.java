package com.google.firebase.perf.config;

public final class ConfigurationConstants$RateLimitSec extends ConfigurationFlag<Long> {
    public static ConfigurationConstants$RateLimitSec instance;

    public String getDeviceCacheFlag() {
        return "com.google.firebase.perf.TimeLimitSec";
    }

    public String getRemoteConfigFlag() {
        return "fpr_rl_time_limit_sec";
    }
}
