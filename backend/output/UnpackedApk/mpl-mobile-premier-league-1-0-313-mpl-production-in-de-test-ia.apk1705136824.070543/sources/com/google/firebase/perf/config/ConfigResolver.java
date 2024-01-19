package com.google.firebase.perf.config;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.perf.BuildConfig;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.util.ImmutableBundle;
import com.google.firebase.perf.util.Optional;

public class ConfigResolver {
    public static volatile ConfigResolver instance;
    public static final AndroidLogger logger = AndroidLogger.getInstance();
    public DeviceCacheManager deviceCacheManager = DeviceCacheManager.getInstance();
    public ImmutableBundle metadataBundle = new ImmutableBundle();
    public final RemoteConfigManager remoteConfigManager = RemoteConfigManager.getInstance();

    public ConfigResolver(RemoteConfigManager remoteConfigManager2, ImmutableBundle immutableBundle, DeviceCacheManager deviceCacheManager2) {
    }

    public static synchronized ConfigResolver getInstance() {
        ConfigResolver configResolver;
        synchronized (ConfigResolver.class) {
            try {
                if (instance == null) {
                    instance = new ConfigResolver(null, null, null);
                }
                configResolver = instance;
            }
        }
        return configResolver;
    }

    public final Optional<Boolean> getDeviceCacheBoolean(ConfigurationFlag<Boolean> configurationFlag) {
        DeviceCacheManager deviceCacheManager2 = this.deviceCacheManager;
        String deviceCacheFlag = configurationFlag.getDeviceCacheFlag();
        if (deviceCacheManager2 == null) {
            throw null;
        } else if (deviceCacheFlag == null) {
            DeviceCacheManager.logger.debug("Key is null when getting boolean value on device cache.");
            return new Optional<>();
        } else {
            if (deviceCacheManager2.sharedPref == null) {
                deviceCacheManager2.setContext(deviceCacheManager2.getFirebaseApplicationContext());
                if (deviceCacheManager2.sharedPref == null) {
                    return new Optional<>();
                }
            }
            if (!deviceCacheManager2.sharedPref.contains(deviceCacheFlag)) {
                return new Optional<>();
            }
            try {
                return new Optional(Boolean.valueOf(deviceCacheManager2.sharedPref.getBoolean(deviceCacheFlag, false)));
            } catch (ClassCastException e2) {
                DeviceCacheManager.logger.debug("Key %s from sharedPreferences has type other than long: %s", deviceCacheFlag, e2.getMessage());
                return new Optional<>();
            }
        }
    }

    public final Optional<Float> getDeviceCacheFloat(ConfigurationFlag<Float> configurationFlag) {
        DeviceCacheManager deviceCacheManager2 = this.deviceCacheManager;
        String deviceCacheFlag = configurationFlag.getDeviceCacheFlag();
        if (deviceCacheManager2 == null) {
            throw null;
        } else if (deviceCacheFlag == null) {
            DeviceCacheManager.logger.debug("Key is null when getting float value on device cache.");
            return new Optional<>();
        } else {
            if (deviceCacheManager2.sharedPref == null) {
                deviceCacheManager2.setContext(deviceCacheManager2.getFirebaseApplicationContext());
                if (deviceCacheManager2.sharedPref == null) {
                    return new Optional<>();
                }
            }
            if (!deviceCacheManager2.sharedPref.contains(deviceCacheFlag)) {
                return new Optional<>();
            }
            try {
                return new Optional(Float.valueOf(deviceCacheManager2.sharedPref.getFloat(deviceCacheFlag, 0.0f)));
            } catch (ClassCastException e2) {
                DeviceCacheManager.logger.debug("Key %s from sharedPreferences has type other than float: %s", deviceCacheFlag, e2.getMessage());
                return new Optional<>();
            }
        }
    }

    public final Optional<Long> getDeviceCacheLong(ConfigurationFlag<Long> configurationFlag) {
        DeviceCacheManager deviceCacheManager2 = this.deviceCacheManager;
        String deviceCacheFlag = configurationFlag.getDeviceCacheFlag();
        if (deviceCacheManager2 == null) {
            throw null;
        } else if (deviceCacheFlag == null) {
            DeviceCacheManager.logger.debug("Key is null when getting long value on device cache.");
            return new Optional<>();
        } else {
            if (deviceCacheManager2.sharedPref == null) {
                deviceCacheManager2.setContext(deviceCacheManager2.getFirebaseApplicationContext());
                if (deviceCacheManager2.sharedPref == null) {
                    return new Optional<>();
                }
            }
            if (!deviceCacheManager2.sharedPref.contains(deviceCacheFlag)) {
                return new Optional<>();
            }
            try {
                return new Optional(Long.valueOf(deviceCacheManager2.sharedPref.getLong(deviceCacheFlag, 0)));
            } catch (ClassCastException e2) {
                DeviceCacheManager.logger.debug("Key %s from sharedPreferences has type other than long: %s", deviceCacheFlag, e2.getMessage());
                return new Optional<>();
            }
        }
    }

    public final Optional<String> getDeviceCacheString(ConfigurationFlag<String> configurationFlag) {
        DeviceCacheManager deviceCacheManager2 = this.deviceCacheManager;
        String deviceCacheFlag = configurationFlag.getDeviceCacheFlag();
        if (deviceCacheManager2 == null) {
            throw null;
        } else if (deviceCacheFlag == null) {
            DeviceCacheManager.logger.debug("Key is null when getting String value on device cache.");
            return new Optional<>();
        } else {
            if (deviceCacheManager2.sharedPref == null) {
                deviceCacheManager2.setContext(deviceCacheManager2.getFirebaseApplicationContext());
                if (deviceCacheManager2.sharedPref == null) {
                    return new Optional<>();
                }
            }
            if (!deviceCacheManager2.sharedPref.contains(deviceCacheFlag)) {
                return new Optional<>();
            }
            try {
                return new Optional(deviceCacheManager2.sharedPref.getString(deviceCacheFlag, ""));
            } catch (ClassCastException e2) {
                DeviceCacheManager.logger.debug("Key %s from sharedPreferences has type other than String: %s", deviceCacheFlag, e2.getMessage());
                return new Optional<>();
            }
        }
    }

    public Boolean getIsPerformanceCollectionEnabled() {
        ConfigurationConstants$CollectionDeactivated configurationConstants$CollectionDeactivated;
        Boolean bool;
        ConfigurationConstants$CollectionEnabled configurationConstants$CollectionEnabled;
        synchronized (ConfigurationConstants$CollectionDeactivated.class) {
            try {
                if (ConfigurationConstants$CollectionDeactivated.instance == null) {
                    ConfigurationConstants$CollectionDeactivated.instance = new ConfigurationConstants$CollectionDeactivated();
                }
                configurationConstants$CollectionDeactivated = ConfigurationConstants$CollectionDeactivated.instance;
            }
        }
        Optional<Boolean> metadataBoolean = getMetadataBoolean(configurationConstants$CollectionDeactivated);
        if (metadataBoolean.isAvailable()) {
            bool = (Boolean) metadataBoolean.get();
        } else if (configurationConstants$CollectionDeactivated != null) {
            bool = Boolean.FALSE;
        } else {
            throw null;
        }
        if (bool.booleanValue()) {
            return Boolean.FALSE;
        }
        synchronized (ConfigurationConstants$CollectionEnabled.class) {
            try {
                if (ConfigurationConstants$CollectionEnabled.instance == null) {
                    ConfigurationConstants$CollectionEnabled.instance = new ConfigurationConstants$CollectionEnabled();
                }
                configurationConstants$CollectionEnabled = ConfigurationConstants$CollectionEnabled.instance;
            }
        }
        Optional<Boolean> deviceCacheBoolean = getDeviceCacheBoolean(configurationConstants$CollectionEnabled);
        if (deviceCacheBoolean.isAvailable()) {
            return (Boolean) deviceCacheBoolean.get();
        }
        Optional<Boolean> metadataBoolean2 = getMetadataBoolean(configurationConstants$CollectionEnabled);
        if (metadataBoolean2.isAvailable()) {
            return (Boolean) metadataBoolean2.get();
        }
        return null;
    }

    public final Optional<Boolean> getMetadataBoolean(ConfigurationFlag<Boolean> configurationFlag) {
        ImmutableBundle immutableBundle = this.metadataBundle;
        String metadataFlag = configurationFlag.getMetadataFlag();
        if (!immutableBundle.containsKey(metadataFlag)) {
            return new Optional<>();
        }
        try {
            return Optional.fromNullable((Boolean) immutableBundle.bundle.get(metadataFlag));
        } catch (ClassCastException e2) {
            ImmutableBundle.logger.debug("Metadata key %s contains type other than boolean: %s", metadataFlag, e2.getMessage());
            return new Optional<>();
        }
    }

    public final Optional<Long> getMetadataLong(ConfigurationFlag<Long> configurationFlag) {
        Optional optional;
        ImmutableBundle immutableBundle = this.metadataBundle;
        String metadataFlag = configurationFlag.getMetadataFlag();
        if (!immutableBundle.containsKey(metadataFlag)) {
            optional = new Optional();
        } else {
            try {
                optional = Optional.fromNullable((Integer) immutableBundle.bundle.get(metadataFlag));
            } catch (ClassCastException e2) {
                ImmutableBundle.logger.debug("Metadata key %s contains type other than int: %s", metadataFlag, e2.getMessage());
                optional = new Optional();
            }
        }
        if (optional.isAvailable()) {
            return new Optional<>(Long.valueOf((long) ((Integer) optional.get()).intValue()));
        }
        return new Optional<>();
    }

    public long getRateLimitSec() {
        ConfigurationConstants$RateLimitSec configurationConstants$RateLimitSec;
        synchronized (ConfigurationConstants$RateLimitSec.class) {
            if (ConfigurationConstants$RateLimitSec.instance == null) {
                ConfigurationConstants$RateLimitSec.instance = new ConfigurationConstants$RateLimitSec();
            }
            configurationConstants$RateLimitSec = ConfigurationConstants$RateLimitSec.instance;
        }
        Optional<Long> remoteConfigLong = getRemoteConfigLong(configurationConstants$RateLimitSec);
        boolean z = false;
        if (remoteConfigLong.isAvailable()) {
            if (((Long) remoteConfigLong.get()).longValue() > 0) {
                DeviceCacheManager deviceCacheManager2 = this.deviceCacheManager;
                if (configurationConstants$RateLimitSec != null) {
                    return ((Long) GeneratedOutlineSupport.outline28((Long) remoteConfigLong.get(), deviceCacheManager2, "com.google.firebase.perf.TimeLimitSec", remoteConfigLong)).longValue();
                }
                throw null;
            }
        }
        Optional<Long> deviceCacheLong = getDeviceCacheLong(configurationConstants$RateLimitSec);
        if (deviceCacheLong.isAvailable()) {
            if (((Long) deviceCacheLong.get()).longValue() > 0) {
                z = true;
            }
            if (z) {
                return ((Long) deviceCacheLong.get()).longValue();
            }
        }
        if (configurationConstants$RateLimitSec != null) {
            return Long.valueOf(600).longValue();
        }
        throw null;
    }

    public final Optional<Float> getRemoteConfigFloat(ConfigurationFlag<Float> configurationFlag) {
        return this.remoteConfigManager.getFloat(configurationFlag.getRemoteConfigFlag());
    }

    public final Optional<Long> getRemoteConfigLong(ConfigurationFlag<Long> configurationFlag) {
        return this.remoteConfigManager.getLong(configurationFlag.getRemoteConfigFlag());
    }

    public final boolean isEventCountValid(long j) {
        return j >= 0;
    }

    public final boolean isFireperfSdkVersionInList(String str) {
        if (str.trim().isEmpty()) {
            return false;
        }
        for (String trim : str.split(";")) {
            String trim2 = trim.trim();
            String str2 = BuildConfig.FIREPERF_VERSION_NAME;
            if (trim2.equals("20.0.6")) {
                return true;
            }
        }
        return false;
    }

    public final boolean isGaugeCaptureFrequencyMsValid(long j) {
        return j >= 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0056, code lost:
        if (r3.sharedPref == null) goto L_0x0066;
     */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isPerformanceMonitoringEnabled() {
        /*
            r7 = this;
            java.lang.Boolean r0 = r7.getIsPerformanceCollectionEnabled()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x000e
            boolean r0 = r0.booleanValue()
            if (r0 != r2) goto L_0x00ea
        L_0x000e:
            java.lang.Class<com.google.firebase.perf.config.ConfigurationConstants$SdkEnabled> r0 = com.google.firebase.perf.config.ConfigurationConstants$SdkEnabled.class
            monitor-enter(r0)
            com.google.firebase.perf.config.ConfigurationConstants$SdkEnabled r3 = com.google.firebase.perf.config.ConfigurationConstants$SdkEnabled.instance     // Catch:{ all -> 0x00eb }
            if (r3 != 0) goto L_0x001c
            com.google.firebase.perf.config.ConfigurationConstants$SdkEnabled r3 = new com.google.firebase.perf.config.ConfigurationConstants$SdkEnabled     // Catch:{ all -> 0x00eb }
            r3.<init>()     // Catch:{ all -> 0x00eb }
            com.google.firebase.perf.config.ConfigurationConstants$SdkEnabled.instance = r3     // Catch:{ all -> 0x00eb }
        L_0x001c:
            com.google.firebase.perf.config.ConfigurationConstants$SdkEnabled r3 = com.google.firebase.perf.config.ConfigurationConstants$SdkEnabled.instance     // Catch:{ all -> 0x00eb }
            monitor-exit(r0)
            com.google.firebase.perf.config.RemoteConfigManager r0 = r7.remoteConfigManager
            java.lang.String r4 = r3.getRemoteConfigFlag()
            com.google.firebase.perf.util.Optional r0 = r0.getBoolean(r4)
            boolean r4 = r0.isAvailable()
            if (r4 == 0) goto L_0x0073
            com.google.firebase.perf.config.RemoteConfigManager r3 = r7.remoteConfigManager
            boolean r3 = r3.isLastFetchFailed()
            if (r3 == 0) goto L_0x0039
            r0 = 0
            goto L_0x0089
        L_0x0039:
            com.google.firebase.perf.config.DeviceCacheManager r3 = r7.deviceCacheManager
            java.lang.String r4 = "com.google.firebase.perf.SdkEnabled"
            java.lang.Object r5 = r0.get()
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r3 == 0) goto L_0x0071
            android.content.SharedPreferences r6 = r3.sharedPref
            if (r6 != 0) goto L_0x0059
            android.content.Context r6 = r3.getFirebaseApplicationContext()
            r3.setContext(r6)
            android.content.SharedPreferences r6 = r3.sharedPref
            if (r6 != 0) goto L_0x0059
            goto L_0x0066
        L_0x0059:
            android.content.SharedPreferences r3 = r3.sharedPref
            android.content.SharedPreferences$Editor r3 = r3.edit()
            android.content.SharedPreferences$Editor r3 = r3.putBoolean(r4, r5)
            r3.apply()
        L_0x0066:
            java.lang.Object r0 = r0.get()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            goto L_0x0089
        L_0x0071:
            r0 = 0
            throw r0
        L_0x0073:
            com.google.firebase.perf.util.Optional r0 = r7.getDeviceCacheBoolean(r3)
            boolean r3 = r0.isAvailable()
            if (r3 == 0) goto L_0x0088
            java.lang.Object r0 = r0.get()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            goto L_0x0089
        L_0x0088:
            r0 = 1
        L_0x0089:
            if (r0 == 0) goto L_0x00e6
            java.lang.Class<com.google.firebase.perf.config.ConfigurationConstants$SdkDisabledVersions> r0 = com.google.firebase.perf.config.ConfigurationConstants$SdkDisabledVersions.class
            monitor-enter(r0)
            com.google.firebase.perf.config.ConfigurationConstants$SdkDisabledVersions r3 = com.google.firebase.perf.config.ConfigurationConstants$SdkDisabledVersions.instance     // Catch:{ all -> 0x00e3 }
            if (r3 != 0) goto L_0x0099
            com.google.firebase.perf.config.ConfigurationConstants$SdkDisabledVersions r3 = new com.google.firebase.perf.config.ConfigurationConstants$SdkDisabledVersions     // Catch:{ all -> 0x00e3 }
            r3.<init>()     // Catch:{ all -> 0x00e3 }
            com.google.firebase.perf.config.ConfigurationConstants$SdkDisabledVersions.instance = r3     // Catch:{ all -> 0x00e3 }
        L_0x0099:
            com.google.firebase.perf.config.ConfigurationConstants$SdkDisabledVersions r3 = com.google.firebase.perf.config.ConfigurationConstants$SdkDisabledVersions.instance     // Catch:{ all -> 0x00e3 }
            monitor-exit(r0)
            com.google.firebase.perf.config.RemoteConfigManager r0 = r7.remoteConfigManager
            java.lang.String r4 = r3.getRemoteConfigFlag()
            com.google.firebase.perf.util.Optional r0 = r0.getString(r4)
            boolean r4 = r0.isAvailable()
            if (r4 == 0) goto L_0x00c4
            com.google.firebase.perf.config.DeviceCacheManager r3 = r7.deviceCacheManager
            java.lang.String r4 = "com.google.firebase.perf.SdkDisabledVersions"
            java.lang.Object r5 = r0.get()
            java.lang.String r5 = (java.lang.String) r5
            r3.setValue(r4, r5)
            java.lang.Object r0 = r0.get()
            java.lang.String r0 = (java.lang.String) r0
            boolean r0 = r7.isFireperfSdkVersionInList(r0)
            goto L_0x00df
        L_0x00c4:
            com.google.firebase.perf.util.Optional r0 = r7.getDeviceCacheString(r3)
            boolean r3 = r0.isAvailable()
            if (r3 == 0) goto L_0x00d9
            java.lang.Object r0 = r0.get()
            java.lang.String r0 = (java.lang.String) r0
            boolean r0 = r7.isFireperfSdkVersionInList(r0)
            goto L_0x00df
        L_0x00d9:
            java.lang.String r0 = ""
            boolean r0 = r7.isFireperfSdkVersionInList(r0)
        L_0x00df:
            if (r0 != 0) goto L_0x00e6
            r0 = 1
            goto L_0x00e7
        L_0x00e3:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        L_0x00e6:
            r0 = 0
        L_0x00e7:
            if (r0 == 0) goto L_0x00ea
            r1 = 1
        L_0x00ea:
            return r1
        L_0x00eb:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.config.ConfigResolver.isPerformanceMonitoringEnabled():boolean");
    }

    public final boolean isSamplingRateValid(float f2) {
        return 0.0f <= f2 && f2 <= 1.0f;
    }

    public final boolean isSessionsMaxDurationMinutesValid(long j) {
        return j > 0;
    }
}
