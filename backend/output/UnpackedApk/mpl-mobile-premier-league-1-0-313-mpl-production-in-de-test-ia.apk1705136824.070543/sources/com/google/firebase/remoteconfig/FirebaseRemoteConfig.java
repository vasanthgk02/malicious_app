package com.google.firebase.remoteconfig;

import android.content.Context;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.abt.AbtException;
import com.google.firebase.abt.FirebaseABTesting;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.remoteconfig.internal.ConfigCacheClient;
import com.google.firebase.remoteconfig.internal.ConfigContainer;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;
import com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler;
import com.google.firebase.remoteconfig.internal.ConfigMetadataClient;
import com.google.firebase.remoteconfig.internal.ConfigStorageClient;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FirebaseRemoteConfig {
    public final ConfigCacheClient activatedConfigsCache;
    public final Context context;
    public final ConfigCacheClient defaultConfigsCache;
    public final Executor executor;
    public final ConfigFetchHandler fetchHandler;
    public final ConfigCacheClient fetchedConfigsCache;
    public final FirebaseABTesting firebaseAbt;
    public final ConfigMetadataClient frcMetadata;
    public final ConfigGetParameterHandler getHandler;

    public FirebaseRemoteConfig(Context context2, FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi, FirebaseABTesting firebaseABTesting, Executor executor2, ConfigCacheClient configCacheClient, ConfigCacheClient configCacheClient2, ConfigCacheClient configCacheClient3, ConfigFetchHandler configFetchHandler, ConfigGetParameterHandler configGetParameterHandler, ConfigMetadataClient configMetadataClient) {
        this.context = context2;
        this.firebaseAbt = firebaseABTesting;
        this.executor = executor2;
        this.fetchedConfigsCache = configCacheClient;
        this.activatedConfigsCache = configCacheClient2;
        this.defaultConfigsCache = configCacheClient3;
        this.fetchHandler = configFetchHandler;
        this.getHandler = configGetParameterHandler;
        this.frcMetadata = configMetadataClient;
    }

    public static List<Map<String, String>> toExperimentInfoMaps(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.getString(next));
            }
            arrayList.add(hashMap);
        }
        return arrayList;
    }

    public Task<Boolean> activate() {
        Task<ConfigContainer> task = this.fetchedConfigsCache.get();
        Task<ConfigContainer> task2 = this.activatedConfigsCache.get();
        return Tasks.whenAllComplete(task, task2).continueWithTask(this.executor, new Continuation(task, task2) {
            public final /* synthetic */ Task f$1;
            public final /* synthetic */ Task f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final Object then(Task task) {
                return FirebaseRemoteConfig.this.lambda$activate$2$FirebaseRemoteConfig(this.f$1, this.f$2, task);
            }
        });
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0093  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Map<java.lang.String, com.google.firebase.remoteconfig.FirebaseRemoteConfigValue> getAll() {
        /*
            r13 = this;
            com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler r0 = r13.getHandler
            r1 = 0
            if (r0 == 0) goto L_0x00ae
            java.util.HashSet r2 = new java.util.HashSet
            r2.<init>()
            com.google.firebase.remoteconfig.internal.ConfigCacheClient r3 = r0.activatedConfigsCache
            java.util.Set r3 = com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler.getKeySetFromCache(r3)
            r2.addAll(r3)
            com.google.firebase.remoteconfig.internal.ConfigCacheClient r3 = r0.defaultConfigsCache
            java.util.Set r3 = com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler.getKeySetFromCache(r3)
            r2.addAll(r3)
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            java.util.Iterator r2 = r2.iterator()
        L_0x0025:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x00ad
            java.lang.Object r4 = r2.next()
            java.lang.String r4 = (java.lang.String) r4
            com.google.firebase.remoteconfig.internal.ConfigCacheClient r5 = r0.activatedConfigsCache
            com.google.firebase.remoteconfig.internal.ConfigContainer r5 = com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler.getConfigsFromCache(r5)
            if (r5 != 0) goto L_0x003a
            goto L_0x0041
        L_0x003a:
            org.json.JSONObject r5 = r5.configsJson     // Catch:{ JSONException -> 0x0041 }
            java.lang.String r5 = r5.getString(r4)     // Catch:{ JSONException -> 0x0041 }
            goto L_0x0042
        L_0x0041:
            r5 = r1
        L_0x0042:
            r6 = 2
            if (r5 == 0) goto L_0x0078
            com.google.firebase.remoteconfig.internal.ConfigCacheClient r7 = r0.activatedConfigsCache
            com.google.firebase.remoteconfig.internal.ConfigContainer r7 = com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler.getConfigsFromCache(r7)
            if (r7 != 0) goto L_0x004e
            goto L_0x006f
        L_0x004e:
            java.util.Set<com.google.android.gms.common.util.BiConsumer<java.lang.String, com.google.firebase.remoteconfig.internal.ConfigContainer>> r8 = r0.listeners
            monitor-enter(r8)
            java.util.Set<com.google.android.gms.common.util.BiConsumer<java.lang.String, com.google.firebase.remoteconfig.internal.ConfigContainer>> r9 = r0.listeners     // Catch:{ all -> 0x0075 }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ all -> 0x0075 }
        L_0x0057:
            boolean r10 = r9.hasNext()     // Catch:{ all -> 0x0075 }
            if (r10 == 0) goto L_0x006e
            java.lang.Object r10 = r9.next()     // Catch:{ all -> 0x0075 }
            com.google.android.gms.common.util.BiConsumer r10 = (com.google.android.gms.common.util.BiConsumer) r10     // Catch:{ all -> 0x0075 }
            java.util.concurrent.Executor r11 = r0.executor     // Catch:{ all -> 0x0075 }
            com.google.firebase.remoteconfig.internal.-$$Lambda$ConfigGetParameterHandler$6dwbZAbkpuGCV2-3cgdO7F5z0QQ r12 = new com.google.firebase.remoteconfig.internal.-$$Lambda$ConfigGetParameterHandler$6dwbZAbkpuGCV2-3cgdO7F5z0QQ     // Catch:{ all -> 0x0075 }
            r12.<init>(r4, r7)     // Catch:{ all -> 0x0075 }
            r11.execute(r12)     // Catch:{ all -> 0x0075 }
            goto L_0x0057
        L_0x006e:
            monitor-exit(r8)     // Catch:{ all -> 0x0075 }
        L_0x006f:
            com.google.firebase.remoteconfig.internal.FirebaseRemoteConfigValueImpl r7 = new com.google.firebase.remoteconfig.internal.FirebaseRemoteConfigValueImpl
            r7.<init>(r5, r6)
            goto L_0x00a8
        L_0x0075:
            r0 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x0075 }
            throw r0
        L_0x0078:
            com.google.firebase.remoteconfig.internal.ConfigCacheClient r5 = r0.defaultConfigsCache
            com.google.firebase.remoteconfig.internal.ConfigContainer r5 = com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler.getConfigsFromCache(r5)
            if (r5 != 0) goto L_0x0081
            goto L_0x0088
        L_0x0081:
            org.json.JSONObject r5 = r5.configsJson     // Catch:{ JSONException -> 0x0088 }
            java.lang.String r5 = r5.getString(r4)     // Catch:{ JSONException -> 0x0088 }
            goto L_0x0089
        L_0x0088:
            r5 = r1
        L_0x0089:
            r7 = 1
            if (r5 == 0) goto L_0x0093
            com.google.firebase.remoteconfig.internal.FirebaseRemoteConfigValueImpl r6 = new com.google.firebase.remoteconfig.internal.FirebaseRemoteConfigValueImpl
            r6.<init>(r5, r7)
            r7 = r6
            goto L_0x00a8
        L_0x0093:
            java.lang.String r5 = "FirebaseRemoteConfigValue"
            java.lang.Object[] r6 = new java.lang.Object[r6]
            r8 = 0
            r6[r8] = r5
            r6[r7] = r4
            java.lang.String r5 = "No value of type '%s' exists for parameter key '%s'."
            java.lang.String.format(r5, r6)
            com.google.firebase.remoteconfig.internal.FirebaseRemoteConfigValueImpl r7 = new com.google.firebase.remoteconfig.internal.FirebaseRemoteConfigValueImpl
            java.lang.String r5 = ""
            r7.<init>(r5, r8)
        L_0x00a8:
            r3.put(r4, r7)
            goto L_0x0025
        L_0x00ad:
            return r3
        L_0x00ae:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.remoteconfig.FirebaseRemoteConfig.getAll():java.util.Map");
    }

    public Task lambda$activate$2$FirebaseRemoteConfig(Task task, Task task2, Task task3) throws Exception {
        if (!task.isSuccessful() || task.getResult() == null) {
            return Tasks.forResult(Boolean.FALSE);
        }
        ConfigContainer configContainer = (ConfigContainer) task.getResult();
        if (task2.isSuccessful()) {
            ConfigContainer configContainer2 = (ConfigContainer) task2.getResult();
            if (!(configContainer2 == null || !configContainer.fetchTime.equals(configContainer2.fetchTime))) {
                return Tasks.forResult(Boolean.FALSE);
            }
        }
        return this.activatedConfigsCache.put(configContainer).continueWith(this.executor, new Continuation() {
            public final Object then(Task task) {
                return Boolean.valueOf(FirebaseRemoteConfig.this.processActivatePutTask(task));
            }
        });
    }

    public /* synthetic */ Task lambda$fetchAndActivate$1$FirebaseRemoteConfig(Void voidR) throws Exception {
        return activate();
    }

    public final boolean processActivatePutTask(Task<ConfigContainer> task) {
        if (!task.isSuccessful()) {
            return false;
        }
        ConfigCacheClient configCacheClient = this.fetchedConfigsCache;
        synchronized (configCacheClient) {
            configCacheClient.cachedContainerTask = Tasks.forResult(null);
        }
        ConfigStorageClient configStorageClient = configCacheClient.storageClient;
        synchronized (configStorageClient) {
            configStorageClient.context.deleteFile(configStorageClient.fileName);
        }
        if (task.getResult() != null) {
            JSONArray jSONArray = ((ConfigContainer) task.getResult()).abtExperiments;
            if (this.firebaseAbt != null) {
                try {
                    this.firebaseAbt.replaceAllExperiments(toExperimentInfoMaps(jSONArray));
                } catch (AbtException | JSONException unused) {
                }
            }
        }
        return true;
    }
}
