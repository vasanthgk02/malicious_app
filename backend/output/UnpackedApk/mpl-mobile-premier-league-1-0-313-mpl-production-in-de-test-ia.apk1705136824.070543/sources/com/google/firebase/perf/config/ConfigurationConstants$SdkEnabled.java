package com.google.firebase.perf.config;

public final class ConfigurationConstants$SdkEnabled extends ConfigurationFlag<Boolean> {
    public static ConfigurationConstants$SdkEnabled instance;

    public String getDeviceCacheFlag() {
        return "com.google.firebase.perf.SdkEnabled";
    }

    public String getRemoteConfigFlag() {
        return "fpr_enabled";
    }
}
