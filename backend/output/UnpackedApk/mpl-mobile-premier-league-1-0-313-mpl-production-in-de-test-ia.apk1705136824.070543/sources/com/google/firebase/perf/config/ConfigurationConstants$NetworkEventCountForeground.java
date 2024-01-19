package com.google.firebase.perf.config;

public final class ConfigurationConstants$NetworkEventCountForeground extends ConfigurationFlag<Long> {
    public static ConfigurationConstants$NetworkEventCountForeground instance;

    public String getDeviceCacheFlag() {
        return "com.google.firebase.perf.NetworkEventCountForeground";
    }

    public String getRemoteConfigFlag() {
        return "fpr_rl_network_event_count_fg";
    }
}
