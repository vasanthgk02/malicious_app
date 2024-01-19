package com.google.firebase.perf.config;

public final class ConfigurationConstants$NetworkEventCountBackground extends ConfigurationFlag<Long> {
    public static ConfigurationConstants$NetworkEventCountBackground instance;

    public String getDeviceCacheFlag() {
        return "com.google.firebase.perf.NetworkEventCountBackground";
    }

    public String getRemoteConfigFlag() {
        return "fpr_rl_network_event_count_bg";
    }
}
