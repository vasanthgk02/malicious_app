package com.google.firebase.perf.config;

public final class ConfigurationConstants$NetworkRequestSamplingRate extends ConfigurationFlag<Float> {
    public static ConfigurationConstants$NetworkRequestSamplingRate instance;

    public String getDeviceCacheFlag() {
        return "com.google.firebase.perf.NetworkRequestSamplingRate";
    }

    public String getRemoteConfigFlag() {
        return "fpr_vc_network_request_sampling_rate";
    }
}
