package com.google.firebase.perf.config;

public final class ConfigurationConstants$CollectionEnabled extends ConfigurationFlag<Boolean> {
    public static ConfigurationConstants$CollectionEnabled instance;

    public String getDeviceCacheFlag() {
        return "isEnabled";
    }

    public String getMetadataFlag() {
        return "firebase_performance_collection_enabled";
    }
}
