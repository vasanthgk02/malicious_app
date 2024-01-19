package com.google.firebase.perf.config;

public final class ConfigurationConstants$SessionsMemoryCaptureFrequencyBackgroundMs extends ConfigurationFlag<Long> {
    public static ConfigurationConstants$SessionsMemoryCaptureFrequencyBackgroundMs instance;

    public String getDeviceCacheFlag() {
        return "com.google.firebase.perf.SessionsMemoryCaptureFrequencyBackgroundMs";
    }

    public String getMetadataFlag() {
        return "sessions_memory_capture_frequency_bg_ms";
    }

    public String getRemoteConfigFlag() {
        return "fpr_session_gauge_memory_capture_frequency_bg_ms";
    }
}
