package com.google.firebase.perf.config;

public final class ConfigurationConstants$TraceSamplingRate extends ConfigurationFlag<Float> {
    public static ConfigurationConstants$TraceSamplingRate instance;

    public String getDeviceCacheFlag() {
        return "com.google.firebase.perf.TraceSamplingRate";
    }

    public String getRemoteConfigFlag() {
        return "fpr_vc_trace_sampling_rate";
    }
}
