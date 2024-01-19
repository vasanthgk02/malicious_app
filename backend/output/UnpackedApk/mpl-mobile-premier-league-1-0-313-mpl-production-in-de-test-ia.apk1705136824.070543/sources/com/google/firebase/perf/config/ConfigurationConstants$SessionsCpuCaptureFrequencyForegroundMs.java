package com.google.firebase.perf.config;

public final class ConfigurationConstants$SessionsCpuCaptureFrequencyForegroundMs extends ConfigurationFlag<Long> {
    public static ConfigurationConstants$SessionsCpuCaptureFrequencyForegroundMs instance;

    public String getDeviceCacheFlag() {
        return "com.google.firebase.perf.SessionsCpuCaptureFrequencyForegroundMs";
    }

    public String getMetadataFlag() {
        return "sessions_cpu_capture_frequency_fg_ms";
    }

    public String getRemoteConfigFlag() {
        return "fpr_session_gauge_cpu_capture_frequency_fg_ms";
    }
}
