package com.google.firebase.perf.config;

public final class ConfigurationConstants$SdkDisabledVersions extends ConfigurationFlag<String> {
    public static ConfigurationConstants$SdkDisabledVersions instance;

    public String getDeviceCacheFlag() {
        return "com.google.firebase.perf.SdkDisabledVersions";
    }

    public String getRemoteConfigFlag() {
        return "fpr_disabled_android_versions";
    }
}
