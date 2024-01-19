package com.google.firebase.perf.config;

public final class ConfigurationConstants$SessionsCpuCaptureFrequencyBackgroundMs extends ConfigurationFlag<Long> {
    public static ConfigurationConstants$SessionsCpuCaptureFrequencyBackgroundMs instance;

    public String getDeviceCacheFlag() {
        return "com.google.firebase.perf.SessionsCpuCaptureFrequencyBackgroundMs";
    }

    public String getMetadataFlag() {
        return "sessions_cpu_capture_frequency_bg_ms";
    }

    public String getRemoteConfigFlag() {
        return "fpr_session_gauge_cpu_capture_frequency_bg_ms";
    }
}
