package com.facebook.appevents.suggestedevents;

import android.content.SharedPreferences;
import com.facebook.FacebookSdk;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0007J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0004H\u0007J\b\u0010\u0014\u001a\u00020\rH\u0002J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/facebook/appevents/suggestedevents/PredictionHistoryManager;", "", "()V", "CLICKED_PATH_STORE", "", "SUGGESTED_EVENTS_HISTORY", "clickedViewPaths", "", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "shardPreferences", "Landroid/content/SharedPreferences;", "addPrediction", "", "pathID", "predictedEvent", "getPathID", "view", "Landroid/view/View;", "text", "initAndWait", "queryEvent", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: PredictionHistoryManager.kt */
public final class PredictionHistoryManager {
    public static final PredictionHistoryManager INSTANCE = new PredictionHistoryManager();
    public static final Map<String, String> clickedViewPaths = new LinkedHashMap();
    public static final AtomicBoolean initialized = new AtomicBoolean(false);
    public static SharedPreferences shardPreferences;

    public static final void addPrediction(String str, String str2) {
        Class<PredictionHistoryManager> cls = PredictionHistoryManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(str, "pathID");
                Intrinsics.checkNotNullParameter(str2, "predictedEvent");
                if (!initialized.get()) {
                    INSTANCE.initAndWait();
                }
                clickedViewPaths.put(str, str2);
                SharedPreferences sharedPreferences = shardPreferences;
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putString("SUGGESTED_EVENTS_HISTORY", Utility.mapToJsonStr(ArraysKt___ArraysJvmKt.toMap(clickedViewPaths))).apply();
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("shardPreferences");
                    throw null;
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:4|5|6|7|(1:9)|17|10|11|12|13) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String getPathID(android.view.View r4, java.lang.String r5) {
        /*
            java.lang.String r0 = "text"
            java.lang.Class<com.facebook.appevents.suggestedevents.PredictionHistoryManager> r1 = com.facebook.appevents.suggestedevents.PredictionHistoryManager.class
            boolean r2 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r1)
            r3 = 0
            if (r2 == 0) goto L_0x000c
            return r3
        L_0x000c:
            java.lang.String r2 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r2)     // Catch:{ all -> 0x0043 }
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)     // Catch:{ all -> 0x0043 }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ all -> 0x0043 }
            r2.<init>()     // Catch:{ all -> 0x0043 }
            r2.put(r0, r5)     // Catch:{ JSONException -> 0x003a }
            org.json.JSONArray r5 = new org.json.JSONArray     // Catch:{ JSONException -> 0x003a }
            r5.<init>()     // Catch:{ JSONException -> 0x003a }
        L_0x0021:
            if (r4 == 0) goto L_0x0035
            java.lang.Class r0 = r4.getClass()     // Catch:{ JSONException -> 0x003a }
            java.lang.String r0 = r0.getSimpleName()     // Catch:{ JSONException -> 0x003a }
            r5.put(r0)     // Catch:{ JSONException -> 0x003a }
            com.facebook.appevents.codeless.internal.ViewHierarchy r0 = com.facebook.appevents.codeless.internal.ViewHierarchy.INSTANCE     // Catch:{ JSONException -> 0x003a }
            android.view.ViewGroup r4 = com.facebook.appevents.codeless.internal.ViewHierarchy.getParentOfView(r4)     // Catch:{ JSONException -> 0x003a }
            goto L_0x0021
        L_0x0035:
            java.lang.String r4 = "classname"
            r2.put(r4, r5)     // Catch:{ JSONException -> 0x003a }
        L_0x003a:
            java.lang.String r4 = r2.toString()     // Catch:{ all -> 0x0043 }
            java.lang.String r4 = com.facebook.internal.Utility.sha256hash(r4)     // Catch:{ all -> 0x0043 }
            return r4
        L_0x0043:
            r4 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r4, r1)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.suggestedevents.PredictionHistoryManager.getPathID(android.view.View, java.lang.String):java.lang.String");
    }

    public final void initAndWait() {
        String str = "";
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                if (!initialized.get()) {
                    FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                    SharedPreferences sharedPreferences = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.internal.SUGGESTED_EVENTS_HISTORY", 0);
                    Intrinsics.checkNotNullExpressionValue(sharedPreferences, "FacebookSdk.getApplicationContext()\n            .getSharedPreferences(CLICKED_PATH_STORE, Context.MODE_PRIVATE)");
                    shardPreferences = sharedPreferences;
                    Map<String, String> map = clickedViewPaths;
                    SharedPreferences sharedPreferences2 = shardPreferences;
                    if (sharedPreferences2 != null) {
                        String string = sharedPreferences2.getString("SUGGESTED_EVENTS_HISTORY", str);
                        if (string != null) {
                            str = string;
                        }
                        map.putAll(Utility.jsonStrToMap(str));
                        initialized.set(true);
                        return;
                    }
                    Intrinsics.throwUninitializedPropertyAccessException("shardPreferences");
                    throw null;
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }
}
