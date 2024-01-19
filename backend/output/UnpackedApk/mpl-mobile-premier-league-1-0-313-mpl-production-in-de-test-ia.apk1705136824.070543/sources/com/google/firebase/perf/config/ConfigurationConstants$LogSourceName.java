package com.google.firebase.perf.config;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class ConfigurationConstants$LogSourceName extends ConfigurationFlag<String> {
    public static final Map<Long, String> LOG_SOURCE_MAP = Collections.unmodifiableMap(new HashMap<Long, String>() {
        {
            put(Long.valueOf(461), "FIREPERF_AUTOPUSH");
            put(Long.valueOf(462), "FIREPERF");
            put(Long.valueOf(675), "FIREPERF_INTERNAL_LOW");
            put(Long.valueOf(676), "FIREPERF_INTERNAL_HIGH");
        }
    });
    public static ConfigurationConstants$LogSourceName instance;

    public static synchronized ConfigurationConstants$LogSourceName getInstance() {
        ConfigurationConstants$LogSourceName configurationConstants$LogSourceName;
        synchronized (ConfigurationConstants$LogSourceName.class) {
            if (instance == null) {
                instance = new ConfigurationConstants$LogSourceName();
            }
            configurationConstants$LogSourceName = instance;
        }
        return configurationConstants$LogSourceName;
    }

    public String getDeviceCacheFlag() {
        return "com.google.firebase.perf.LogSourceName";
    }

    public String getRemoteConfigFlag() {
        return "fpr_log_source";
    }
}
