package com.google.firebase.perf.config;

public final class ConfigurationConstants$SessionsMaxDurationMinutes extends ConfigurationFlag<Long> {
    public static ConfigurationConstants$SessionsMaxDurationMinutes instance;

    public String getDeviceCacheFlag() {
        return "com.google.firebase.perf.SessionsMaxDurationMinutes";
    }

    public String getMetadataFlag() {
        return "sessions_max_length_minutes";
    }

    public String getRemoteConfigFlag() {
        return "fpr_session_max_duration_min";
    }
}
