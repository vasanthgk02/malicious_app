package com.google.firebase.perf.config;

public final class ConfigurationConstants$SessionsMemoryCaptureFrequencyForegroundMs extends ConfigurationFlag<Long> {
    public static ConfigurationConstants$SessionsMemoryCaptureFrequencyForegroundMs instance;

    public String getDeviceCacheFlag() {
        return "com.google.firebase.perf.SessionsMemoryCaptureFrequencyForegroundMs";
    }

    public String getMetadataFlag() {
        return "sessions_memory_capture_frequency_fg_ms";
    }

    public String getRemoteConfigFlag() {
        return "fpr_session_gauge_memory_capture_frequency_fg_ms";
    }
}
