package com.google.firebase.perf.config;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import androidx.annotation.Keep;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.inject.Provider;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.provider.FirebasePerfProvider;
import com.google.firebase.perf.util.Optional;
import com.google.firebase.remoteconfig.$$Lambda$FirebaseRemoteConfig$XUT1Hxsdo0OuL98mLtX2oz2vQ5U;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigValue;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;
import com.google.firebase.remoteconfig.internal.ConfigMetadataClient;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

@Keep
public class RemoteConfigManager {
    public static final long FETCH_NEVER_HAPPENED_TIMESTAMP_MS = 0;
    public static final String FIREPERF_FRC_NAMESPACE_NAME = "fireperf";
    public static final long MIN_APP_START_CONFIG_FETCH_DELAY_MS = 5000;
    public static final int RANDOM_APP_START_CONFIG_FETCH_DELAY_MS = 25000;
    public static final long TIME_AFTER_WHICH_A_FETCH_IS_CONSIDERED_STALE_MS = TimeUnit.HOURS.toMillis(12);
    public static final RemoteConfigManager instance = new RemoteConfigManager();
    public static final AndroidLogger logger = AndroidLogger.getInstance();
    public final ConcurrentHashMap<String, FirebaseRemoteConfigValue> allRcConfigMap;
    public final long appStartConfigFetchDelayInMs;
    public final long appStartTimeInMs;
    public final Executor executor;
    public FirebaseRemoteConfig firebaseRemoteConfig;
    public long firebaseRemoteConfigLastFetchTimestampMs;
    public Provider<RemoteConfigComponent> firebaseRemoteConfigProvider;

    /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public RemoteConfigManager() {
        /*
            r8 = this;
            java.util.concurrent.ThreadPoolExecutor r7 = new java.util.concurrent.ThreadPoolExecutor
            java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.SECONDS
            java.util.concurrent.LinkedBlockingQueue r6 = new java.util.concurrent.LinkedBlockingQueue
            r6.<init>()
            r1 = 0
            r2 = 1
            r3 = 0
            r0 = r7
            r0.<init>(r1, r2, r3, r5, r6)
            r0 = 0
            r8.<init>(r7, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.config.RemoteConfigManager.<init>():void");
    }

    public static RemoteConfigManager getInstance() {
        return instance;
    }

    private FirebaseRemoteConfigValue getRemoteConfigValue(String str) {
        triggerRemoteConfigFetchIfNecessary();
        if (isFirebaseRemoteConfigAvailable() && this.allRcConfigMap.containsKey(str)) {
            FirebaseRemoteConfigValue firebaseRemoteConfigValue = this.allRcConfigMap.get(str);
            if (firebaseRemoteConfigValue.getSource() == 2) {
                logger.debug("Fetched value: '%s' for key: '%s' from Firebase Remote Config.", firebaseRemoteConfigValue.asString(), str);
                return firebaseRemoteConfigValue;
            }
        }
        return null;
    }

    @VisibleForTesting
    public static int getVersionCode(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException unused) {
            return 0;
        }
    }

    private boolean hasAppStartConfigFetchDelayElapsed(long j) {
        return j - this.appStartTimeInMs >= this.appStartConfigFetchDelayInMs;
    }

    private boolean hasLastFetchBecomeStale(long j) {
        return j - this.firebaseRemoteConfigLastFetchTimestampMs > TIME_AFTER_WHICH_A_FETCH_IS_CONSIDERED_STALE_MS;
    }

    private boolean shouldFetchAndActivateRemoteConfigValues() {
        long currentSystemTimeMillis = getCurrentSystemTimeMillis();
        return hasAppStartConfigFetchDelayElapsed(currentSystemTimeMillis) && hasLastFetchBecomeStale(currentSystemTimeMillis);
    }

    private void triggerFirebaseRemoteConfigFetchAndActivateOnSuccessfulFetch() {
        this.firebaseRemoteConfigLastFetchTimestampMs = getCurrentSystemTimeMillis();
        FirebaseRemoteConfig firebaseRemoteConfig2 = this.firebaseRemoteConfig;
        ConfigFetchHandler configFetchHandler = firebaseRemoteConfig2.fetchHandler;
        Task onSuccessTask = configFetchHandler.fetchedConfigsCache.get().continueWithTask(configFetchHandler.executor, new Continuation(configFetchHandler.frcMetadata.frcMetadata.getLong("minimum_fetch_interval_in_seconds", ConfigFetchHandler.DEFAULT_MINIMUM_FETCH_INTERVAL_IN_SECONDS)) {
            public final /* synthetic */ long f$1;

            {
                this.f$1 = r2;
            }

            public final Object then(Task task) {
                return ConfigFetchHandler.this.lambda$fetch$0$ConfigFetchHandler(this.f$1, task);
            }
        }).onSuccessTask($$Lambda$FirebaseRemoteConfig$XUT1Hxsdo0OuL98mLtX2oz2vQ5U.INSTANCE).onSuccessTask(firebaseRemoteConfig2.executor, new SuccessContinuation() {
            public final Task then(Object obj) {
                return FirebaseRemoteConfig.this.lambda$fetchAndActivate$1$FirebaseRemoteConfig((Void) obj);
            }
        });
        onSuccessTask.addOnSuccessListener(this.executor, (OnSuccessListener<? super TResult>) new OnSuccessListener() {
            public final void onSuccess(Object obj) {
                RemoteConfigManager.this.lambda$triggerFirebaseRemoteConfigFetchAndActivateOnSuccessfulFetch$0$RemoteConfigManager((Boolean) obj);
            }
        });
        onSuccessTask.addOnFailureListener(this.executor, new OnFailureListener() {
            public final void onFailure(Exception exc) {
                RemoteConfigManager.this.lambda$triggerFirebaseRemoteConfigFetchAndActivateOnSuccessfulFetch$1$RemoteConfigManager(exc);
            }
        });
    }

    private void triggerRemoteConfigFetchIfNecessary() {
        if (isFirebaseRemoteConfigAvailable()) {
            if (this.allRcConfigMap.isEmpty()) {
                syncConfigValues(this.firebaseRemoteConfig.getAll());
            }
            if (shouldFetchAndActivateRemoteConfigValues()) {
                triggerFirebaseRemoteConfigFetchAndActivateOnSuccessfulFetch();
            }
        }
    }

    public Optional<Boolean> getBoolean(String str) {
        if (str == null) {
            logger.debug("The key to get Remote Config boolean value is null.");
            return new Optional<>();
        }
        FirebaseRemoteConfigValue remoteConfigValue = getRemoteConfigValue(str);
        if (remoteConfigValue != null) {
            try {
                return new Optional<>(Boolean.valueOf(remoteConfigValue.asBoolean()));
            } catch (IllegalArgumentException unused) {
                if (!remoteConfigValue.asString().isEmpty()) {
                    logger.debug("Could not parse value: '%s' for key: '%s'.", remoteConfigValue.asString(), str);
                }
            }
        }
        return new Optional<>();
    }

    @VisibleForTesting
    public long getCurrentSystemTimeMillis() {
        return System.currentTimeMillis();
    }

    public Optional<Float> getFloat(String str) {
        if (str == null) {
            logger.debug("The key to get Remote Config float value is null.");
            return new Optional<>();
        }
        FirebaseRemoteConfigValue remoteConfigValue = getRemoteConfigValue(str);
        if (remoteConfigValue != null) {
            try {
                return new Optional<>(Float.valueOf(Double.valueOf(remoteConfigValue.asDouble()).floatValue()));
            } catch (IllegalArgumentException unused) {
                if (!remoteConfigValue.asString().isEmpty()) {
                    logger.debug("Could not parse value: '%s' for key: '%s'.", remoteConfigValue.asString(), str);
                }
            }
        }
        return new Optional<>();
    }

    public Optional<Long> getLong(String str) {
        if (str == null) {
            logger.debug("The key to get Remote Config long value is null.");
            return new Optional<>();
        }
        FirebaseRemoteConfigValue remoteConfigValue = getRemoteConfigValue(str);
        if (remoteConfigValue != null) {
            try {
                return new Optional<>(Long.valueOf(remoteConfigValue.asLong()));
            } catch (IllegalArgumentException unused) {
                if (!remoteConfigValue.asString().isEmpty()) {
                    logger.debug("Could not parse value: '%s' for key: '%s'.", remoteConfigValue.asString(), str);
                }
            }
        }
        return new Optional<>();
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> T getRemoteConfigValueOrDefault(java.lang.String r8, T r9) {
        /*
            r7 = this;
            com.google.firebase.remoteconfig.FirebaseRemoteConfigValue r0 = r7.getRemoteConfigValue(r8)
            if (r0 == 0) goto L_0x0076
            r1 = 1
            r2 = 0
            boolean r3 = r9 instanceof java.lang.Boolean     // Catch:{ IllegalArgumentException -> 0x0059 }
            if (r3 == 0) goto L_0x0016
            boolean r3 = r0.asBoolean()     // Catch:{ IllegalArgumentException -> 0x0059 }
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r3)     // Catch:{ IllegalArgumentException -> 0x0059 }
        L_0x0014:
            r9 = r8
            goto L_0x0076
        L_0x0016:
            boolean r3 = r9 instanceof java.lang.Float     // Catch:{ IllegalArgumentException -> 0x0059 }
            if (r3 == 0) goto L_0x002b
            double r3 = r0.asDouble()     // Catch:{ IllegalArgumentException -> 0x0059 }
            java.lang.Double r3 = java.lang.Double.valueOf(r3)     // Catch:{ IllegalArgumentException -> 0x0059 }
            float r3 = r3.floatValue()     // Catch:{ IllegalArgumentException -> 0x0059 }
            java.lang.Float r8 = java.lang.Float.valueOf(r3)     // Catch:{ IllegalArgumentException -> 0x0059 }
            goto L_0x0014
        L_0x002b:
            boolean r3 = r9 instanceof java.lang.Long     // Catch:{ IllegalArgumentException -> 0x0059 }
            if (r3 != 0) goto L_0x0050
            boolean r3 = r9 instanceof java.lang.Integer     // Catch:{ IllegalArgumentException -> 0x0059 }
            if (r3 == 0) goto L_0x0034
            goto L_0x0050
        L_0x0034:
            boolean r3 = r9 instanceof java.lang.String     // Catch:{ IllegalArgumentException -> 0x0059 }
            if (r3 == 0) goto L_0x003d
            java.lang.String r8 = r0.asString()     // Catch:{ IllegalArgumentException -> 0x0059 }
            goto L_0x0014
        L_0x003d:
            java.lang.String r3 = r0.asString()     // Catch:{ IllegalArgumentException -> 0x0059 }
            com.google.firebase.perf.logging.AndroidLogger r4 = logger     // Catch:{ IllegalArgumentException -> 0x004e }
            java.lang.String r5 = "No matching type found for the defaultValue: '%s', using String."
            java.lang.Object[] r6 = new java.lang.Object[r1]     // Catch:{ IllegalArgumentException -> 0x004e }
            r6[r2] = r9     // Catch:{ IllegalArgumentException -> 0x004e }
            r4.debug(r5, r6)     // Catch:{ IllegalArgumentException -> 0x004e }
            r9 = r3
            goto L_0x0076
        L_0x004e:
            r9 = r3
            goto L_0x005a
        L_0x0050:
            long r3 = r0.asLong()     // Catch:{ IllegalArgumentException -> 0x0059 }
            java.lang.Long r8 = java.lang.Long.valueOf(r3)     // Catch:{ IllegalArgumentException -> 0x0059 }
            goto L_0x0014
        L_0x0059:
        L_0x005a:
            java.lang.String r3 = r0.asString()
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L_0x0076
            com.google.firebase.perf.logging.AndroidLogger r3 = logger
            r4 = 2
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.String r0 = r0.asString()
            r4[r2] = r0
            r4[r1] = r8
            java.lang.String r8 = "Could not parse value: '%s' for key: '%s'."
            r3.debug(r8, r4)
        L_0x0076:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.config.RemoteConfigManager.getRemoteConfigValueOrDefault(java.lang.String, java.lang.Object):java.lang.Object");
    }

    public Optional<String> getString(String str) {
        if (str == null) {
            logger.debug("The key to get Remote Config String value is null.");
            return new Optional<>();
        }
        FirebaseRemoteConfigValue remoteConfigValue = getRemoteConfigValue(str);
        if (remoteConfigValue != null) {
            return new Optional<>(remoteConfigValue.asString());
        }
        return new Optional<>();
    }

    public boolean isFirebaseRemoteConfigAvailable() {
        if (this.firebaseRemoteConfig == null) {
            Provider<RemoteConfigComponent> provider = this.firebaseRemoteConfigProvider;
            if (provider != null) {
                RemoteConfigComponent remoteConfigComponent = (RemoteConfigComponent) provider.get();
                if (remoteConfigComponent != null) {
                    this.firebaseRemoteConfig = remoteConfigComponent.get(FIREPERF_FRC_NAMESPACE_NAME);
                }
            }
        }
        return this.firebaseRemoteConfig != null;
    }

    public boolean isLastFetchFailed() {
        int i;
        FirebaseRemoteConfig firebaseRemoteConfig2 = this.firebaseRemoteConfig;
        if (firebaseRemoteConfig2 != null) {
            ConfigMetadataClient configMetadataClient = firebaseRemoteConfig2.frcMetadata;
            synchronized (configMetadataClient.frcInfoLock) {
                configMetadataClient.frcMetadata.getLong("last_fetch_time_in_millis", -1);
                i = configMetadataClient.frcMetadata.getInt("last_fetch_status", 0);
                long j = ConfigFetchHandler.DEFAULT_MINIMUM_FETCH_INTERVAL_IN_SECONDS;
                long j2 = configMetadataClient.frcMetadata.getLong("fetch_timeout_in_seconds", 60);
                if (j2 >= 0) {
                    long j3 = configMetadataClient.frcMetadata.getLong("minimum_fetch_interval_in_seconds", ConfigFetchHandler.DEFAULT_MINIMUM_FETCH_INTERVAL_IN_SECONDS);
                    if (j3 < 0) {
                        throw new IllegalArgumentException("Minimum interval between fetches has to be a non-negative number. " + j3 + " is an invalid argument");
                    }
                } else {
                    throw new IllegalArgumentException(String.format("Fetch connection timeout has to be a non-negative number. %d is an invalid argument", new Object[]{Long.valueOf(j2)}));
                }
            }
            if (i != 1) {
                return false;
            }
        }
        return true;
    }

    public /* synthetic */ void lambda$triggerFirebaseRemoteConfigFetchAndActivateOnSuccessfulFetch$0$RemoteConfigManager(Boolean bool) {
        syncConfigValues(this.firebaseRemoteConfig.getAll());
    }

    public /* synthetic */ void lambda$triggerFirebaseRemoteConfigFetchAndActivateOnSuccessfulFetch$1$RemoteConfigManager(Exception exc) {
        this.firebaseRemoteConfigLastFetchTimestampMs = 0;
    }

    public void setFirebaseRemoteConfigProvider(Provider<RemoteConfigComponent> provider) {
        this.firebaseRemoteConfigProvider = provider;
    }

    @VisibleForTesting
    public void syncConfigValues(Map<String, FirebaseRemoteConfigValue> map) {
        this.allRcConfigMap.putAll(map);
        for (String next : this.allRcConfigMap.keySet()) {
            if (!map.containsKey(next)) {
                this.allRcConfigMap.remove(next);
            }
        }
    }

    public RemoteConfigManager(Executor executor2, FirebaseRemoteConfig firebaseRemoteConfig2) {
        this(executor2, firebaseRemoteConfig2, ((long) new Random().nextInt(RANDOM_APP_START_CONFIG_FETCH_DELAY_MS)) + MIN_APP_START_CONFIG_FETCH_DELAY_MS);
    }

    @VisibleForTesting
    public RemoteConfigManager(Executor executor2, FirebaseRemoteConfig firebaseRemoteConfig2, long j) {
        ConcurrentHashMap<String, FirebaseRemoteConfigValue> concurrentHashMap;
        this.firebaseRemoteConfigLastFetchTimestampMs = 0;
        this.executor = executor2;
        this.firebaseRemoteConfig = firebaseRemoteConfig2;
        if (firebaseRemoteConfig2 == null) {
            concurrentHashMap = new ConcurrentHashMap<>();
        } else {
            concurrentHashMap = new ConcurrentHashMap<>(firebaseRemoteConfig2.getAll());
        }
        this.allRcConfigMap = concurrentHashMap;
        this.appStartTimeInMs = TimeUnit.MICROSECONDS.toMillis(FirebasePerfProvider.getAppStartTime().timeInMicros);
        this.appStartConfigFetchDelayInMs = j;
    }
}
