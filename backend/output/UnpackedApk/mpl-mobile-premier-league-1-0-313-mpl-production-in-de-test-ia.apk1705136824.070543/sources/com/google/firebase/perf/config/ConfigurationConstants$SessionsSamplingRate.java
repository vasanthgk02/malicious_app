package com.google.firebase.perf.config;

public final class ConfigurationConstants$SessionsSamplingRate extends ConfigurationFlag<Float> {
    public static ConfigurationConstants$SessionsSamplingRate instance;

    public String getDeviceCacheFlag() {
        return "com.google.firebase.perf.SessionSamplingRate";
    }

    public String getMetadataFlag() {
        return "sessions_sampling_percentage";
    }

    public String getRemoteConfigFlag() {
        return "fpr_vc_session_sampling_rate";
    }
}
