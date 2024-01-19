package com.google.firebase.perf.config;

public final class ConfigurationConstants$TraceEventCountForeground extends ConfigurationFlag<Long> {
    public static ConfigurationConstants$TraceEventCountForeground instance;

    public String getDeviceCacheFlag() {
        return "com.google.firebase.perf.TraceEventCountForeground";
    }

    public String getRemoteConfigFlag() {
        return "fpr_rl_trace_event_count_fg";
    }
}
