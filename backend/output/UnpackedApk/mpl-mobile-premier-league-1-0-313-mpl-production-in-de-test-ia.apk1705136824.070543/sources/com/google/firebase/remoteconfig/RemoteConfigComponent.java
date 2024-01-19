package com.google.firebase.remoteconfig;

import android.content.Context;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.BiConsumer;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.abt.FirebaseABTesting;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.remoteconfig.internal.ConfigCacheClient;
import com.google.firebase.remoteconfig.internal.ConfigContainer;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;
import com.google.firebase.remoteconfig.internal.ConfigFetchHttpClient;
import com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler;
import com.google.firebase.remoteconfig.internal.ConfigMetadataClient;
import com.google.firebase.remoteconfig.internal.ConfigStorageClient;
import com.google.firebase.remoteconfig.internal.Personalization;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@KeepForSdk
public class RemoteConfigComponent {
    public static final Clock DEFAULT_CLOCK = DefaultClock.zza;
    public static final Random DEFAULT_RANDOM = new Random();
    public final Provider<AnalyticsConnector> analyticsConnector;
    public final String appId;
    public final Context context;
    public Map<String, String> customHeaders = new HashMap();
    public final ExecutorService executorService;
    public final FirebaseABTesting firebaseAbt;
    public final FirebaseApp firebaseApp;
    public final FirebaseInstallationsApi firebaseInstallations;
    public final Map<String, FirebaseRemoteConfig> frcNamespaceInstances = new HashMap();

    public RemoteConfigComponent(Context context2, FirebaseApp firebaseApp2, FirebaseInstallationsApi firebaseInstallationsApi, FirebaseABTesting firebaseABTesting, Provider<AnalyticsConnector> provider) {
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        this.context = context2;
        this.executorService = newCachedThreadPool;
        this.firebaseApp = firebaseApp2;
        this.firebaseInstallations = firebaseInstallationsApi;
        this.firebaseAbt = firebaseABTesting;
        this.analyticsConnector = provider;
        firebaseApp2.checkNotDeleted();
        this.appId = firebaseApp2.options.applicationId;
        Tasks.call(newCachedThreadPool, new Callable() {
            public final Object call() {
                return RemoteConfigComponent.this.getDefault();
            }
        });
    }

    public static boolean isPrimaryApp(FirebaseApp firebaseApp2) {
        firebaseApp2.checkNotDeleted();
        return firebaseApp2.name.equals("[DEFAULT]");
    }

    public static /* synthetic */ AnalyticsConnector lambda$getFetchHandler$0() {
        return null;
    }

    @KeepForSdk
    public synchronized FirebaseRemoteConfig get(String str) {
        ConfigCacheClient cacheClient;
        ConfigCacheClient cacheClient2;
        ConfigCacheClient cacheClient3;
        ConfigMetadataClient configMetadataClient;
        ConfigGetParameterHandler configGetParameterHandler;
        cacheClient = getCacheClient(str, "fetch");
        cacheClient2 = getCacheClient(str, "activate");
        cacheClient3 = getCacheClient(str, "defaults");
        configMetadataClient = new ConfigMetadataClient(this.context.getSharedPreferences(String.format("%s_%s_%s_%s", new Object[]{"frc", this.appId, str, "settings"}), 0));
        configGetParameterHandler = new ConfigGetParameterHandler(this.executorService, cacheClient2, cacheClient3);
        FirebaseApp firebaseApp2 = this.firebaseApp;
        Provider<AnalyticsConnector> provider = this.analyticsConnector;
        firebaseApp2.checkNotDeleted();
        Personalization personalization = (!firebaseApp2.name.equals("[DEFAULT]") || !str.equals("firebase")) ? null : new Personalization(provider);
        if (personalization != null) {
            $$Lambda$fZenfdMTOgMShU9AwDtWxftE20 r1 = new BiConsumer() {
                public final void accept(Object obj, Object obj2) {
                    Personalization.this.logArmActive((String) obj, (ConfigContainer) obj2);
                }
            };
            synchronized (configGetParameterHandler.listeners) {
                configGetParameterHandler.listeners.add(r1);
            }
        }
        return get(this.firebaseApp, str, this.firebaseInstallations, this.firebaseAbt, this.executorService, cacheClient, cacheClient2, cacheClient3, getFetchHandler(str, cacheClient, configMetadataClient), configGetParameterHandler, configMetadataClient);
    }

    public final ConfigCacheClient getCacheClient(String str, String str2) {
        return ConfigCacheClient.getInstance(Executors.newCachedThreadPool(), ConfigStorageClient.getInstance(this.context, String.format("%s_%s_%s_%s.json", new Object[]{"frc", this.appId, str, str2})));
    }

    public FirebaseRemoteConfig getDefault() {
        return get("firebase");
    }

    public synchronized ConfigFetchHandler getFetchHandler(String str, ConfigCacheClient configCacheClient, ConfigMetadataClient configMetadataClient) {
        ConfigFetchHandler configFetchHandler;
        ConfigMetadataClient configMetadataClient2 = configMetadataClient;
        synchronized (this) {
            FirebaseInstallationsApi firebaseInstallationsApi = this.firebaseInstallations;
            Provider provider = isPrimaryApp(this.firebaseApp) ? this.analyticsConnector : $$Lambda$RemoteConfigComponent$cp8nqbJz8_MPqZ783uRMZsE0Lw4.INSTANCE;
            ExecutorService executorService2 = this.executorService;
            Clock clock = DEFAULT_CLOCK;
            Random random = DEFAULT_RANDOM;
            FirebaseApp firebaseApp2 = this.firebaseApp;
            firebaseApp2.checkNotDeleted();
            String str2 = firebaseApp2.options.apiKey;
            FirebaseApp firebaseApp3 = this.firebaseApp;
            firebaseApp3.checkNotDeleted();
            ConfigFetchHttpClient configFetchHttpClient = new ConfigFetchHttpClient(this.context, firebaseApp3.options.applicationId, str2, str, configMetadataClient2.frcMetadata.getLong("fetch_timeout_in_seconds", 60), configMetadataClient2.frcMetadata.getLong("fetch_timeout_in_seconds", 60));
            configFetchHandler = new ConfigFetchHandler(firebaseInstallationsApi, provider, executorService2, clock, random, configCacheClient, configFetchHttpClient, configMetadataClient, this.customHeaders);
        }
        return configFetchHandler;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0031  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.google.firebase.remoteconfig.FirebaseRemoteConfig get(com.google.firebase.FirebaseApp r16, java.lang.String r17, com.google.firebase.installations.FirebaseInstallationsApi r18, com.google.firebase.abt.FirebaseABTesting r19, java.util.concurrent.Executor r20, com.google.firebase.remoteconfig.internal.ConfigCacheClient r21, com.google.firebase.remoteconfig.internal.ConfigCacheClient r22, com.google.firebase.remoteconfig.internal.ConfigCacheClient r23, com.google.firebase.remoteconfig.internal.ConfigFetchHandler r24, com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler r25, com.google.firebase.remoteconfig.internal.ConfigMetadataClient r26) {
        /*
            r15 = this;
            r1 = r15
            r0 = r17
            monitor-enter(r15)
            java.util.Map<java.lang.String, com.google.firebase.remoteconfig.FirebaseRemoteConfig> r2 = r1.frcNamespaceInstances     // Catch:{ all -> 0x0067 }
            boolean r2 = r2.containsKey(r0)     // Catch:{ all -> 0x0067 }
            if (r2 != 0) goto L_0x005d
            com.google.firebase.remoteconfig.FirebaseRemoteConfig r2 = new com.google.firebase.remoteconfig.FirebaseRemoteConfig     // Catch:{ all -> 0x0067 }
            android.content.Context r4 = r1.context     // Catch:{ all -> 0x0067 }
            java.lang.String r3 = "firebase"
            boolean r3 = r0.equals(r3)     // Catch:{ all -> 0x0067 }
            if (r3 == 0) goto L_0x0029
            r16.checkNotDeleted()     // Catch:{ all -> 0x0067 }
            r5 = r16
            java.lang.String r3 = r5.name     // Catch:{ all -> 0x0067 }
            java.lang.String r6 = "[DEFAULT]"
            boolean r3 = r3.equals(r6)     // Catch:{ all -> 0x0067 }
            if (r3 == 0) goto L_0x002b
            r3 = 1
            goto L_0x002c
        L_0x0029:
            r5 = r16
        L_0x002b:
            r3 = 0
        L_0x002c:
            if (r3 == 0) goto L_0x0031
            r7 = r19
            goto L_0x0033
        L_0x0031:
            r3 = 0
            r7 = r3
        L_0x0033:
            r3 = r2
            r5 = r16
            r6 = r18
            r8 = r20
            r9 = r21
            r10 = r22
            r11 = r23
            r12 = r24
            r13 = r25
            r14 = r26
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)     // Catch:{ all -> 0x0067 }
            com.google.firebase.remoteconfig.internal.ConfigCacheClient r3 = r2.activatedConfigsCache     // Catch:{ all -> 0x0067 }
            r3.get()     // Catch:{ all -> 0x0067 }
            com.google.firebase.remoteconfig.internal.ConfigCacheClient r3 = r2.defaultConfigsCache     // Catch:{ all -> 0x0067 }
            r3.get()     // Catch:{ all -> 0x0067 }
            com.google.firebase.remoteconfig.internal.ConfigCacheClient r3 = r2.fetchedConfigsCache     // Catch:{ all -> 0x0067 }
            r3.get()     // Catch:{ all -> 0x0067 }
            java.util.Map<java.lang.String, com.google.firebase.remoteconfig.FirebaseRemoteConfig> r3 = r1.frcNamespaceInstances     // Catch:{ all -> 0x0067 }
            r3.put(r0, r2)     // Catch:{ all -> 0x0067 }
        L_0x005d:
            java.util.Map<java.lang.String, com.google.firebase.remoteconfig.FirebaseRemoteConfig> r2 = r1.frcNamespaceInstances     // Catch:{ all -> 0x0067 }
            java.lang.Object r0 = r2.get(r0)     // Catch:{ all -> 0x0067 }
            com.google.firebase.remoteconfig.FirebaseRemoteConfig r0 = (com.google.firebase.remoteconfig.FirebaseRemoteConfig) r0     // Catch:{ all -> 0x0067 }
            monitor-exit(r15)
            return r0
        L_0x0067:
            r0 = move-exception
            monitor-exit(r15)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.remoteconfig.RemoteConfigComponent.get(com.google.firebase.FirebaseApp, java.lang.String, com.google.firebase.installations.FirebaseInstallationsApi, com.google.firebase.abt.FirebaseABTesting, java.util.concurrent.Executor, com.google.firebase.remoteconfig.internal.ConfigCacheClient, com.google.firebase.remoteconfig.internal.ConfigCacheClient, com.google.firebase.remoteconfig.internal.ConfigCacheClient, com.google.firebase.remoteconfig.internal.ConfigFetchHandler, com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler, com.google.firebase.remoteconfig.internal.ConfigMetadataClient):com.google.firebase.remoteconfig.FirebaseRemoteConfig");
    }
}
