package com.facebook.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest.Companion;
import com.facebook.internal.FetchedAppGateKeepersManager.Callback;
import com.facebook.internal.gatekeeper.GateKeeper;
import com.facebook.internal.gatekeeper.GateKeeperRuntimeCache;
import com.netcore.android.SMTEventParamKeys;
import com.netcore.android.preference.SMTPreferenceConstants;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001:\u00013B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0004H\u0002J\"\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u00042\u0006\u0010!\u001a\u00020\u001fH\u0007J\u001c\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001f0#2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0004J\u0017\u0010$\u001a\u00020\u001f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0002\u0010%J\u0006\u0010&\u001a\u00020'J\u0012\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0012H\u0007J\u001f\u0010)\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u00042\b\u0010*\u001a\u0004\u0018\u00010\u0015H\u0001¢\u0006\u0002\b+J\b\u0010,\u001a\u00020'H\u0002J\u0018\u0010-\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u001fH\u0007J\b\u0010/\u001a\u00020'H\u0007J\u001a\u00100\u001a\u00020'2\b\b\u0002\u0010\u001d\u001a\u00020\u00042\u0006\u00101\u001a\u000202H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00150\u0014X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0004\n\u0002\u0010\u001b¨\u00064"}, d2 = {"Lcom/facebook/internal/FetchedAppGateKeepersManager;", "", "()V", "APPLICATION_FIELDS", "", "APPLICATION_GATEKEEPER_CACHE_TIMEOUT", "", "APPLICATION_GATEKEEPER_EDGE", "APPLICATION_GATEKEEPER_FIELD", "APPLICATION_GRAPH_DATA", "APPLICATION_PLATFORM", "APPLICATION_SDK_VERSION", "APP_GATEKEEPERS_PREFS_KEY_FORMAT", "APP_GATEKEEPERS_PREFS_STORE", "APP_PLATFORM", "TAG", "callbacks", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/facebook/internal/FetchedAppGateKeepersManager$Callback;", "fetchedAppGateKeepers", "", "Lorg/json/JSONObject;", "gateKeeperRuntimeCache", "Lcom/facebook/internal/gatekeeper/GateKeeperRuntimeCache;", "isLoading", "Ljava/util/concurrent/atomic/AtomicBoolean;", "timestamp", "Ljava/lang/Long;", "getAppGateKeepersQueryResponse", "applicationId", "getGateKeeperForKey", "", "name", "defaultValue", "getGateKeepersForApplication", "", "isTimestampValid", "(Ljava/lang/Long;)Z", "loadAppGateKeepersAsync", "", "callback", "parseAppGateKeepersFromJSON", "gateKeepersJSON", "parseAppGateKeepersFromJSON$facebook_core_release", "pollCallbacks", "queryAppGateKeepers", "forceRequery", "resetRuntimeGateKeeperCache", "setRuntimeGateKeeper", "gateKeeper", "Lcom/facebook/internal/gatekeeper/GateKeeper;", "Callback", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: FetchedAppGateKeepersManager.kt */
public final class FetchedAppGateKeepersManager {
    public static final FetchedAppGateKeepersManager INSTANCE = null;
    public static final ConcurrentLinkedQueue<Callback> callbacks = new ConcurrentLinkedQueue<>();
    public static final Map<String, JSONObject> fetchedAppGateKeepers = new ConcurrentHashMap();
    public static GateKeeperRuntimeCache gateKeeperRuntimeCache;
    public static final AtomicBoolean isLoading = new AtomicBoolean(false);
    public static Long timestamp;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/facebook/internal/FetchedAppGateKeepersManager$Callback;", "", "onCompleted", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: FetchedAppGateKeepersManager.kt */
    public interface Callback {
        void onCompleted();
    }

    static {
        Reflection.getOrCreateKotlinClass(FetchedAppGateKeepersManager.class).getSimpleName();
    }

    public static final boolean getGateKeeperForKey(String str, String str2, boolean z) {
        HashMap hashMap;
        Intrinsics.checkNotNullParameter(str, "name");
        ArrayList<GateKeeper> arrayList = null;
        loadAppGateKeepersAsync(null);
        if (str2 == null || !fetchedAppGateKeepers.containsKey(str2)) {
            hashMap = new HashMap();
        } else {
            GateKeeperRuntimeCache gateKeeperRuntimeCache2 = gateKeeperRuntimeCache;
            if (gateKeeperRuntimeCache2 != null) {
                Intrinsics.checkNotNullParameter(str2, SMTEventParamKeys.SMT_APP_ID);
                ConcurrentHashMap concurrentHashMap = gateKeeperRuntimeCache2.gateKeepers.get(str2);
                if (concurrentHashMap != null) {
                    arrayList = new ArrayList<>(concurrentHashMap.size());
                    for (Entry value : concurrentHashMap.entrySet()) {
                        arrayList.add((GateKeeper) value.getValue());
                    }
                }
            }
            if (arrayList != null) {
                hashMap = new HashMap();
                for (GateKeeper gateKeeper : arrayList) {
                    hashMap.put(gateKeeper.name, Boolean.valueOf(gateKeeper.value));
                }
            } else {
                HashMap hashMap2 = new HashMap();
                JSONObject jSONObject = fetchedAppGateKeepers.get(str2);
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    Intrinsics.checkNotNullExpressionValue(next, "key");
                    hashMap2.put(next, Boolean.valueOf(jSONObject.optBoolean(next)));
                }
                GateKeeperRuntimeCache gateKeeperRuntimeCache3 = gateKeeperRuntimeCache;
                if (gateKeeperRuntimeCache3 == null) {
                    gateKeeperRuntimeCache3 = new GateKeeperRuntimeCache();
                }
                ArrayList arrayList2 = new ArrayList(hashMap2.size());
                for (Entry entry : hashMap2.entrySet()) {
                    arrayList2.add(new GateKeeper((String) entry.getKey(), ((Boolean) entry.getValue()).booleanValue()));
                }
                Intrinsics.checkNotNullParameter(str2, SMTEventParamKeys.SMT_APP_ID);
                Intrinsics.checkNotNullParameter(arrayList2, "gateKeeperList");
                ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    GateKeeper gateKeeper2 = (GateKeeper) it.next();
                    concurrentHashMap2.put(gateKeeper2.name, gateKeeper2);
                }
                gateKeeperRuntimeCache3.gateKeepers.put(str2, concurrentHashMap2);
                gateKeeperRuntimeCache = gateKeeperRuntimeCache3;
                hashMap = hashMap2;
            }
        }
        if (hashMap.containsKey(str)) {
            Boolean bool = (Boolean) hashMap.get(str);
            if (bool == null) {
                return z;
            }
            z = bool.booleanValue();
        }
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0084 A[SYNTHETIC, Splitter:B:26:0x0084] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a4 A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a6 A[SYNTHETIC, Splitter:B:39:0x00a6] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final synchronized void loadAppGateKeepersAsync(com.facebook.internal.FetchedAppGateKeepersManager.Callback r8) {
        /*
            java.lang.Class<com.facebook.internal.FetchedAppGateKeepersManager> r0 = com.facebook.internal.FetchedAppGateKeepersManager.class
            monitor-enter(r0)
            if (r8 == 0) goto L_0x000a
            java.util.concurrent.ConcurrentLinkedQueue<com.facebook.internal.FetchedAppGateKeepersManager$Callback> r1 = callbacks     // Catch:{ all -> 0x00b0 }
            r1.add(r8)     // Catch:{ all -> 0x00b0 }
        L_0x000a:
            com.facebook.FacebookSdk r8 = com.facebook.FacebookSdk.INSTANCE     // Catch:{ all -> 0x00b0 }
            java.lang.String r8 = com.facebook.FacebookSdk.getApplicationId()     // Catch:{ all -> 0x00b0 }
            java.lang.Long r1 = timestamp     // Catch:{ all -> 0x00b0 }
            r2 = 0
            r3 = 1
            if (r1 != 0) goto L_0x0017
            goto L_0x0029
        L_0x0017:
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00b0 }
            long r6 = r1.longValue()     // Catch:{ all -> 0x00b0 }
            long r4 = r4 - r6
            r6 = 3600000(0x36ee80, double:1.7786363E-317)
            int r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r1 >= 0) goto L_0x0029
            r1 = 1
            goto L_0x002a
        L_0x0029:
            r1 = 0
        L_0x002a:
            if (r1 == 0) goto L_0x005a
            java.util.Map<java.lang.String, org.json.JSONObject> r1 = fetchedAppGateKeepers     // Catch:{ all -> 0x00b0 }
            boolean r1 = r1.containsKey(r8)     // Catch:{ all -> 0x00b0 }
            if (r1 == 0) goto L_0x005a
            android.os.Handler r8 = new android.os.Handler     // Catch:{ all -> 0x00b0 }
            android.os.Looper r1 = android.os.Looper.getMainLooper()     // Catch:{ all -> 0x00b0 }
            r8.<init>(r1)     // Catch:{ all -> 0x00b0 }
        L_0x003d:
            java.util.concurrent.ConcurrentLinkedQueue<com.facebook.internal.FetchedAppGateKeepersManager$Callback> r1 = callbacks     // Catch:{ all -> 0x00b0 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x00b0 }
            if (r1 != 0) goto L_0x0058
            java.util.concurrent.ConcurrentLinkedQueue<com.facebook.internal.FetchedAppGateKeepersManager$Callback> r1 = callbacks     // Catch:{ all -> 0x00b0 }
            java.lang.Object r1 = r1.poll()     // Catch:{ all -> 0x00b0 }
            com.facebook.internal.FetchedAppGateKeepersManager$Callback r1 = (com.facebook.internal.FetchedAppGateKeepersManager.Callback) r1     // Catch:{ all -> 0x00b0 }
            if (r1 == 0) goto L_0x003d
            com.facebook.internal.-$$Lambda$q7A1am-uD9yXyvTYMtFHhc3dm3E r2 = new com.facebook.internal.-$$Lambda$q7A1am-uD9yXyvTYMtFHhc3dm3E     // Catch:{ all -> 0x00b0 }
            r2.<init>()     // Catch:{ all -> 0x00b0 }
            r8.post(r2)     // Catch:{ all -> 0x00b0 }
            goto L_0x003d
        L_0x0058:
            monitor-exit(r0)
            return
        L_0x005a:
            com.facebook.FacebookSdk r1 = com.facebook.FacebookSdk.INSTANCE     // Catch:{ all -> 0x00b0 }
            android.content.Context r1 = com.facebook.FacebookSdk.getApplicationContext()     // Catch:{ all -> 0x00b0 }
            java.lang.String r4 = "com.facebook.internal.APP_GATEKEEPERS.%s"
            java.lang.Object[] r5 = new java.lang.Object[r3]     // Catch:{ all -> 0x00b0 }
            r5[r2] = r8     // Catch:{ all -> 0x00b0 }
            java.lang.Object[] r5 = java.util.Arrays.copyOf(r5, r3)     // Catch:{ all -> 0x00b0 }
            java.lang.String r4 = java.lang.String.format(r4, r5)     // Catch:{ all -> 0x00b0 }
            java.lang.String r5 = "java.lang.String.format(format, *args)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)     // Catch:{ all -> 0x00b0 }
            java.lang.String r5 = "com.facebook.internal.preferences.APP_GATEKEEPERS"
            android.content.SharedPreferences r5 = r1.getSharedPreferences(r5, r2)     // Catch:{ all -> 0x00b0 }
            r6 = 0
            java.lang.String r5 = r5.getString(r4, r6)     // Catch:{ all -> 0x00b0 }
            boolean r7 = com.facebook.internal.Utility.isNullOrEmpty(r5)     // Catch:{ all -> 0x00b0 }
            if (r7 != 0) goto L_0x0096
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ JSONException -> 0x008b }
            r7.<init>(r5)     // Catch:{ JSONException -> 0x008b }
            r6 = r7
            goto L_0x0091
        L_0x008b:
            r5 = move-exception
            java.lang.String r7 = "FacebookSDK"
            com.facebook.internal.Utility.logd(r7, r5)     // Catch:{ all -> 0x00b0 }
        L_0x0091:
            if (r6 == 0) goto L_0x0096
            parseAppGateKeepersFromJSON$facebook_core_release(r8, r6)     // Catch:{ all -> 0x00b0 }
        L_0x0096:
            com.facebook.FacebookSdk r5 = com.facebook.FacebookSdk.INSTANCE     // Catch:{ all -> 0x00b0 }
            java.util.concurrent.Executor r5 = com.facebook.FacebookSdk.getExecutor()     // Catch:{ all -> 0x00b0 }
            java.util.concurrent.atomic.AtomicBoolean r6 = isLoading     // Catch:{ all -> 0x00b0 }
            boolean r2 = r6.compareAndSet(r2, r3)     // Catch:{ all -> 0x00b0 }
            if (r2 != 0) goto L_0x00a6
            monitor-exit(r0)
            return
        L_0x00a6:
            com.facebook.internal.-$$Lambda$HKeHjtqBLX5n5K-8E_A_OLNOasI r2 = new com.facebook.internal.-$$Lambda$HKeHjtqBLX5n5K-8E_A_OLNOasI     // Catch:{ all -> 0x00b0 }
            r2.<init>(r8, r1, r4)     // Catch:{ all -> 0x00b0 }
            r5.execute(r2)     // Catch:{ all -> 0x00b0 }
            monitor-exit(r0)
            return
        L_0x00b0:
            r8 = move-exception
            monitor-exit(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.FetchedAppGateKeepersManager.loadAppGateKeepersAsync(com.facebook.internal.FetchedAppGateKeepersManager$Callback):void");
    }

    /* renamed from: loadAppGateKeepersAsync$lambda-0  reason: not valid java name */
    public static final void m194loadAppGateKeepersAsync$lambda0(String str, Context context, String str2) {
        Intrinsics.checkNotNullParameter(str, "$applicationId");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(str2, "$gateKeepersKey");
        Bundle bundle = new Bundle();
        bundle.putString("platform", "android");
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        bundle.putString(SMTPreferenceConstants.SMT_SDK_VERSION, "16.0.1");
        bundle.putString("fields", "gatekeepers");
        Companion companion = GraphRequest.Companion;
        String format = String.format("app/%s", Arrays.copyOf(new Object[]{"mobile_sdk_gk"}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        GraphRequest newGraphPathRequest = companion.newGraphPathRequest(null, format, null);
        newGraphPathRequest.setParameters(bundle);
        JSONObject jSONObject = newGraphPathRequest.executeAndWait().jsonObject;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (jSONObject.length() != 0) {
            parseAppGateKeepersFromJSON$facebook_core_release(str, jSONObject);
            context.getSharedPreferences("com.facebook.internal.preferences.APP_GATEKEEPERS", 0).edit().putString(str2, jSONObject.toString()).apply();
            timestamp = Long.valueOf(System.currentTimeMillis());
        }
        Handler handler = new Handler(Looper.getMainLooper());
        while (!callbacks.isEmpty()) {
            Callback poll = callbacks.poll();
            if (poll != null) {
                handler.post(new Runnable() {
                    public final void run() {
                        FetchedAppGateKeepersManager.m195pollCallbacks$lambda1(Callback.this);
                    }
                });
            }
        }
        isLoading.set(false);
    }

    public static final synchronized JSONObject parseAppGateKeepersFromJSON$facebook_core_release(String str, JSONObject jSONObject) {
        JSONObject jSONObject2;
        synchronized (FetchedAppGateKeepersManager.class) {
            Intrinsics.checkNotNullParameter(str, "applicationId");
            jSONObject2 = fetchedAppGateKeepers.get(str);
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            int i = 0;
            JSONObject jSONObject3 = null;
            if (jSONObject != null) {
                JSONArray optJSONArray = jSONObject.optJSONArray("data");
                if (optJSONArray != null) {
                    jSONObject3 = optJSONArray.optJSONObject(0);
                }
            }
            if (jSONObject3 == null) {
                jSONObject3 = new JSONObject();
            }
            JSONArray optJSONArray2 = jSONObject3.optJSONArray("gatekeepers");
            if (optJSONArray2 == null) {
                optJSONArray2 = new JSONArray();
            }
            int length = optJSONArray2.length();
            if (length > 0) {
                while (true) {
                    int i2 = i + 1;
                    try {
                        JSONObject jSONObject4 = optJSONArray2.getJSONObject(i);
                        jSONObject2.put(jSONObject4.getString("key"), jSONObject4.getBoolean(HSLCriteriaBuilder.VALUE));
                    } catch (JSONException e2) {
                        Utility.logd("FacebookSDK", e2);
                    }
                    if (i2 >= length) {
                        break;
                    }
                    i = i2;
                }
            }
            fetchedAppGateKeepers.put(str, jSONObject2);
        }
        return jSONObject2;
    }

    /* renamed from: pollCallbacks$lambda-1  reason: not valid java name */
    public static final void m195pollCallbacks$lambda1(Callback callback) {
        callback.onCompleted();
    }
}
