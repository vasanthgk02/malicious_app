package com.google.firebase.perf.config;

public final class ConfigurationConstants$TraceEventCountBackground extends ConfigurationFlag<Long> {
    public static ConfigurationConstants$TraceEventCountBackground instance;

    public String getDeviceCacheFlag() {
        return "com.google.firebase.perf.TraceEventCountBackground";
    }

    public String getRemoteConfigFlag() {
        return "fpr_rl_trace_event_count_bg";
    }
}
