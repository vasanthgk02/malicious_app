package com.google.firebase.remoteconfig.internal;

import com.google.android.gms.common.util.BiConsumer;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;

public class ConfigGetParameterHandler {
    public static final Pattern FALSE_REGEX = Pattern.compile("^(0|false|f|no|n|off|)$", 2);
    public static final Pattern TRUE_REGEX = Pattern.compile("^(1|true|t|yes|y|on)$", 2);
    public final ConfigCacheClient activatedConfigsCache;
    public final ConfigCacheClient defaultConfigsCache;
    public final Executor executor;
    public final Set<BiConsumer<String, ConfigContainer>> listeners = new HashSet();

    static {
        Charset.forName("UTF-8");
    }

    public ConfigGetParameterHandler(Executor executor2, ConfigCacheClient configCacheClient, ConfigCacheClient configCacheClient2) {
        this.executor = executor2;
        this.activatedConfigsCache = configCacheClient;
        this.defaultConfigsCache = configCacheClient2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        return (com.google.firebase.remoteconfig.internal.ConfigContainer) com.google.firebase.remoteconfig.internal.ConfigCacheClient.await(r3.get(), 5, java.util.concurrent.TimeUnit.SECONDS);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.firebase.remoteconfig.internal.ConfigContainer getConfigsFromCache(com.google.firebase.remoteconfig.internal.ConfigCacheClient r3) {
        /*
            monitor-enter(r3)
            com.google.android.gms.tasks.Task<com.google.firebase.remoteconfig.internal.ConfigContainer> r0 = r3.cachedContainerTask     // Catch:{ all -> 0x002a }
            if (r0 == 0) goto L_0x0017
            com.google.android.gms.tasks.Task<com.google.firebase.remoteconfig.internal.ConfigContainer> r0 = r3.cachedContainerTask     // Catch:{ all -> 0x002a }
            boolean r0 = r0.isSuccessful()     // Catch:{ all -> 0x002a }
            if (r0 == 0) goto L_0x0017
            com.google.android.gms.tasks.Task<com.google.firebase.remoteconfig.internal.ConfigContainer> r0 = r3.cachedContainerTask     // Catch:{ all -> 0x002a }
            java.lang.Object r0 = r0.getResult()     // Catch:{ all -> 0x002a }
            com.google.firebase.remoteconfig.internal.ConfigContainer r0 = (com.google.firebase.remoteconfig.internal.ConfigContainer) r0     // Catch:{ all -> 0x002a }
            monitor-exit(r3)     // Catch:{ all -> 0x002a }
            goto L_0x0029
        L_0x0017:
            monitor-exit(r3)     // Catch:{ all -> 0x002a }
            com.google.android.gms.tasks.Task r3 = r3.get()     // Catch:{ InterruptedException | ExecutionException | TimeoutException -> 0x0028 }
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ InterruptedException | ExecutionException | TimeoutException -> 0x0028 }
            r1 = 5
            java.lang.Object r3 = com.google.firebase.remoteconfig.internal.ConfigCacheClient.await(r3, r1, r0)     // Catch:{ InterruptedException | ExecutionException | TimeoutException -> 0x0028 }
            r0 = r3
            com.google.firebase.remoteconfig.internal.ConfigContainer r0 = (com.google.firebase.remoteconfig.internal.ConfigContainer) r0     // Catch:{ InterruptedException | ExecutionException | TimeoutException -> 0x0028 }
            goto L_0x0029
        L_0x0028:
            r0 = 0
        L_0x0029:
            return r0
        L_0x002a:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x002a }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler.getConfigsFromCache(com.google.firebase.remoteconfig.internal.ConfigCacheClient):com.google.firebase.remoteconfig.internal.ConfigContainer");
    }

    public static Set<String> getKeySetFromCache(ConfigCacheClient configCacheClient) {
        HashSet hashSet = new HashSet();
        ConfigContainer configsFromCache = getConfigsFromCache(configCacheClient);
        if (configsFromCache == null) {
            return hashSet;
        }
        Iterator<String> keys = configsFromCache.configsJson.keys();
        while (keys.hasNext()) {
            hashSet.add(keys.next());
        }
        return hashSet;
    }
}
