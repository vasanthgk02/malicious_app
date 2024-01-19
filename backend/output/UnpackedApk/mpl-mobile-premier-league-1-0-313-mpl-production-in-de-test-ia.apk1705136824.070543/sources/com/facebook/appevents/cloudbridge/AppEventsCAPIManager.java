package com.facebook.appevents.cloudbridge;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import com.facebook.internal.Logger;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0007J\u0015\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0000¢\u0006\u0002\b\u0019R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0006*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR@\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e2\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e8A@@X\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001a"}, d2 = {"Lcom/facebook/appevents/cloudbridge/AppEventsCAPIManager;", "", "()V", "SETTINGS_PATH", "", "TAG", "kotlin.jvm.PlatformType", "isEnabled", "", "isEnabled$facebook_core_release", "()Z", "setEnabled$facebook_core_release", "(Z)V", "valuesToSave", "", "savedCloudBridgeCredentials", "getSavedCloudBridgeCredentials$facebook_core_release", "()Ljava/util/Map;", "setSavedCloudBridgeCredentials$facebook_core_release", "(Ljava/util/Map;)V", "enable", "", "getCAPIGSettingsFromGraphResponse", "response", "Lcom/facebook/GraphResponse;", "getCAPIGSettingsFromGraphResponse$facebook_core_release", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: AppEventsCAPIManager.kt */
public final class AppEventsCAPIManager {
    public static boolean isEnabled;

    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r1v14, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r1v15, types: [java.util.Map] */
    /* JADX WARNING: type inference failed for: r8v10, types: [java.util.LinkedHashMap, java.util.HashMap] */
    /* JADX WARNING: type inference failed for: r1v18 */
    /* JADX WARNING: type inference failed for: r1v19 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r1v0
      assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], ?[OBJECT, ARRAY], java.lang.Object]
      uses: [?[int, boolean, OBJECT, ARRAY, byte, short, char], ?[OBJECT, ARRAY], java.util.Map]
      mth insns count: 189
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0073 A[Catch:{ all -> 0x00c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0081 A[Catch:{ all -> 0x00c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x008f A[Catch:{ all -> 0x00c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0090 A[Catch:{ all -> 0x00c4 }] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* renamed from: enable$lambda-0  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m157enable$lambda0(com.facebook.GraphResponse r13) {
        /*
            java.lang.String r0 = "response"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            com.facebook.FacebookRequestError r0 = r13.error
            r1 = 0
            java.lang.String r2 = "com.facebook.appevents.cloudbridge.AppEventsCAPIManager"
            r3 = 1
            r4 = 0
            if (r0 == 0) goto L_0x011e
            com.facebook.internal.Logger$Companion r5 = com.facebook.internal.Logger.Companion
            com.facebook.LoggingBehavior r6 = com.facebook.LoggingBehavior.APP_EVENTS
            r7 = 2
            java.lang.Object[] r8 = new java.lang.Object[r7]
            java.lang.String r0 = r0.toString()
            r8[r4] = r0
            com.facebook.FacebookRequestError r13 = r13.error
            com.facebook.FacebookException r13 = r13.exception
            java.lang.String r13 = java.lang.String.valueOf(r13)
            r8[r3] = r13
            java.lang.String r13 = " \n\nGraph Response Error: \n================\nResponse Error: %s\nResponse Error Exception: %s\n\n "
            r5.log(r6, r2, r13, r8)
            java.lang.Class<com.facebook.appevents.cloudbridge.AppEventsCAPIManager> r13 = com.facebook.appevents.cloudbridge.AppEventsCAPIManager.class
            boolean r0 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r13)
            if (r0 == 0) goto L_0x0037
            goto L_0x00c8
        L_0x0037:
            com.facebook.FacebookSdk r0 = com.facebook.FacebookSdk.INSTANCE     // Catch:{ all -> 0x00c4 }
            android.content.Context r0 = com.facebook.FacebookSdk.getApplicationContext()     // Catch:{ all -> 0x00c4 }
            java.lang.String r5 = "com.facebook.sdk.CloudBridgeSavedCredentials"
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r5, r4)     // Catch:{ all -> 0x00c4 }
            if (r0 != 0) goto L_0x0047
            goto L_0x00c8
        L_0x0047:
            com.facebook.appevents.cloudbridge.SettingsAPIFields r5 = com.facebook.appevents.cloudbridge.SettingsAPIFields.DATASETID     // Catch:{ all -> 0x00c4 }
            java.lang.String r5 = r5.getRawValue()     // Catch:{ all -> 0x00c4 }
            java.lang.String r5 = r0.getString(r5, r1)     // Catch:{ all -> 0x00c4 }
            com.facebook.appevents.cloudbridge.SettingsAPIFields r6 = com.facebook.appevents.cloudbridge.SettingsAPIFields.URL     // Catch:{ all -> 0x00c4 }
            java.lang.String r6 = r6.getRawValue()     // Catch:{ all -> 0x00c4 }
            java.lang.String r6 = r0.getString(r6, r1)     // Catch:{ all -> 0x00c4 }
            com.facebook.appevents.cloudbridge.SettingsAPIFields r8 = com.facebook.appevents.cloudbridge.SettingsAPIFields.ACCESSKEY     // Catch:{ all -> 0x00c4 }
            java.lang.String r8 = r8.getRawValue()     // Catch:{ all -> 0x00c4 }
            java.lang.String r0 = r0.getString(r8, r1)     // Catch:{ all -> 0x00c4 }
            if (r5 == 0) goto L_0x0070
            boolean r8 = kotlin.text.CharsKt__CharKt.isBlank(r5)     // Catch:{ all -> 0x00c4 }
            if (r8 == 0) goto L_0x006e
            goto L_0x0070
        L_0x006e:
            r8 = 0
            goto L_0x0071
        L_0x0070:
            r8 = 1
        L_0x0071:
            if (r8 != 0) goto L_0x00c8
            if (r6 == 0) goto L_0x007e
            boolean r8 = kotlin.text.CharsKt__CharKt.isBlank(r6)     // Catch:{ all -> 0x00c4 }
            if (r8 == 0) goto L_0x007c
            goto L_0x007e
        L_0x007c:
            r8 = 0
            goto L_0x007f
        L_0x007e:
            r8 = 1
        L_0x007f:
            if (r8 != 0) goto L_0x00c8
            if (r0 == 0) goto L_0x008c
            boolean r8 = kotlin.text.CharsKt__CharKt.isBlank(r0)     // Catch:{ all -> 0x00c4 }
            if (r8 == 0) goto L_0x008a
            goto L_0x008c
        L_0x008a:
            r8 = 0
            goto L_0x008d
        L_0x008c:
            r8 = 1
        L_0x008d:
            if (r8 == 0) goto L_0x0090
            goto L_0x00c8
        L_0x0090:
            java.util.LinkedHashMap r8 = new java.util.LinkedHashMap     // Catch:{ all -> 0x00c4 }
            r8.<init>()     // Catch:{ all -> 0x00c4 }
            com.facebook.appevents.cloudbridge.SettingsAPIFields r9 = com.facebook.appevents.cloudbridge.SettingsAPIFields.URL     // Catch:{ all -> 0x00c4 }
            java.lang.String r9 = r9.getRawValue()     // Catch:{ all -> 0x00c4 }
            r8.put(r9, r6)     // Catch:{ all -> 0x00c4 }
            com.facebook.appevents.cloudbridge.SettingsAPIFields r9 = com.facebook.appevents.cloudbridge.SettingsAPIFields.DATASETID     // Catch:{ all -> 0x00c4 }
            java.lang.String r9 = r9.getRawValue()     // Catch:{ all -> 0x00c4 }
            r8.put(r9, r5)     // Catch:{ all -> 0x00c4 }
            com.facebook.appevents.cloudbridge.SettingsAPIFields r9 = com.facebook.appevents.cloudbridge.SettingsAPIFields.ACCESSKEY     // Catch:{ all -> 0x00c4 }
            java.lang.String r9 = r9.getRawValue()     // Catch:{ all -> 0x00c4 }
            r8.put(r9, r0)     // Catch:{ all -> 0x00c4 }
            com.facebook.internal.Logger$Companion r9 = com.facebook.internal.Logger.Companion     // Catch:{ all -> 0x00c4 }
            com.facebook.LoggingBehavior r10 = com.facebook.LoggingBehavior.APP_EVENTS     // Catch:{ all -> 0x00c4 }
            java.lang.String r11 = " \n\nLoading Cloudbridge settings from saved Prefs: \n================\n DATASETID: %s\n URL: %s \n ACCESSKEY: %s \n\n "
            r12 = 3
            java.lang.Object[] r12 = new java.lang.Object[r12]     // Catch:{ all -> 0x00c4 }
            r12[r4] = r5     // Catch:{ all -> 0x00c4 }
            r12[r3] = r6     // Catch:{ all -> 0x00c4 }
            r12[r7] = r0     // Catch:{ all -> 0x00c4 }
            r9.log(r10, r2, r11, r12)     // Catch:{ all -> 0x00c4 }
            r1 = r8
            goto L_0x00c8
        L_0x00c4:
            r0 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r0, r13)
        L_0x00c8:
            if (r1 == 0) goto L_0x0203
            java.net.URL r13 = new java.net.URL
            com.facebook.appevents.cloudbridge.SettingsAPIFields r0 = com.facebook.appevents.cloudbridge.SettingsAPIFields.URL
            java.lang.String r0 = r0.getRawValue()
            java.lang.Object r0 = r1.get(r0)
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r13.<init>(r0)
            com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformerWebRequests r0 = com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformerWebRequests.INSTANCE
            com.facebook.appevents.cloudbridge.SettingsAPIFields r0 = com.facebook.appevents.cloudbridge.SettingsAPIFields.DATASETID
            java.lang.String r0 = r0.getRawValue()
            java.lang.Object r0 = r1.get(r0)
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = r13.getProtocol()
            r2.append(r4)
            java.lang.String r4 = "://"
            r2.append(r4)
            java.lang.String r13 = r13.getHost()
            r2.append(r13)
            java.lang.String r13 = r2.toString()
            com.facebook.appevents.cloudbridge.SettingsAPIFields r2 = com.facebook.appevents.cloudbridge.SettingsAPIFields.ACCESSKEY
            java.lang.String r2 = r2.getRawValue()
            java.lang.Object r1 = r1.get(r2)
            java.lang.String r1 = java.lang.String.valueOf(r1)
            com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformerWebRequests.configure(r0, r13, r1)
            isEnabled = r3
            goto L_0x0203
        L_0x011e:
            com.facebook.internal.Logger$Companion r0 = com.facebook.internal.Logger.Companion
            com.facebook.LoggingBehavior r5 = com.facebook.LoggingBehavior.APP_EVENTS
            java.lang.Object[] r6 = new java.lang.Object[r3]
            r6[r4] = r13
            java.lang.String r7 = " \n\nGraph Response Received: \n================\n%s\n\n "
            r0.log(r5, r2, r7, r6)
            org.json.JSONObject r13 = r13.graphObject
            java.lang.String r0 = "CloudBridge Settings API response is not a valid json: \n%s "
            java.lang.String r5 = "TAG"
            if (r13 != 0) goto L_0x0134
            goto L_0x013a
        L_0x0134:
            java.lang.String r1 = "data"
            java.lang.Object r1 = r13.get(r1)     // Catch:{ JSONException -> 0x01f0, NullPointerException -> 0x01dc }
        L_0x013a:
            if (r1 == 0) goto L_0x01d4
            org.json.JSONArray r1 = (org.json.JSONArray) r1     // Catch:{ JSONException -> 0x01f0, NullPointerException -> 0x01dc }
            java.util.List r13 = com.facebook.internal.Utility.convertJSONArrayToList(r1)     // Catch:{ JSONException -> 0x01f0, NullPointerException -> 0x01dc }
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x01f0, NullPointerException -> 0x01dc }
            java.lang.Object r13 = kotlin.collections.ArraysKt___ArraysJvmKt.firstOrNull(r13)     // Catch:{ JSONException -> 0x01f0, NullPointerException -> 0x01dc }
            java.lang.String r13 = (java.lang.String) r13     // Catch:{ JSONException -> 0x01f0, NullPointerException -> 0x01dc }
            r1.<init>(r13)     // Catch:{ JSONException -> 0x01f0, NullPointerException -> 0x01dc }
            java.util.Map r13 = com.facebook.internal.Utility.convertJSONObjectToHashMap(r1)     // Catch:{ JSONException -> 0x01f0, NullPointerException -> 0x01dc }
            com.facebook.appevents.cloudbridge.SettingsAPIFields r1 = com.facebook.appevents.cloudbridge.SettingsAPIFields.URL     // Catch:{ JSONException -> 0x01f0, NullPointerException -> 0x01dc }
            java.lang.String r1 = r1.getRawValue()     // Catch:{ JSONException -> 0x01f0, NullPointerException -> 0x01dc }
            r6 = r13
            java.util.HashMap r6 = (java.util.HashMap) r6
            java.lang.Object r1 = r6.get(r1)     // Catch:{ JSONException -> 0x01f0, NullPointerException -> 0x01dc }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ JSONException -> 0x01f0, NullPointerException -> 0x01dc }
            com.facebook.appevents.cloudbridge.SettingsAPIFields r7 = com.facebook.appevents.cloudbridge.SettingsAPIFields.DATASETID     // Catch:{ JSONException -> 0x01f0, NullPointerException -> 0x01dc }
            java.lang.String r7 = r7.getRawValue()     // Catch:{ JSONException -> 0x01f0, NullPointerException -> 0x01dc }
            java.lang.Object r7 = r6.get(r7)     // Catch:{ JSONException -> 0x01f0, NullPointerException -> 0x01dc }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ JSONException -> 0x01f0, NullPointerException -> 0x01dc }
            com.facebook.appevents.cloudbridge.SettingsAPIFields r8 = com.facebook.appevents.cloudbridge.SettingsAPIFields.ACCESSKEY     // Catch:{ JSONException -> 0x01f0, NullPointerException -> 0x01dc }
            java.lang.String r8 = r8.getRawValue()     // Catch:{ JSONException -> 0x01f0, NullPointerException -> 0x01dc }
            java.lang.Object r8 = r6.get(r8)     // Catch:{ JSONException -> 0x01f0, NullPointerException -> 0x01dc }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ JSONException -> 0x01f0, NullPointerException -> 0x01dc }
            if (r1 == 0) goto L_0x01c7
            if (r7 == 0) goto L_0x01c7
            if (r8 != 0) goto L_0x017f
            goto L_0x01c7
        L_0x017f:
            com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformerWebRequests r0 = com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformerWebRequests.INSTANCE     // Catch:{ MalformedURLException -> 0x01b1 }
            com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformerWebRequests.configure(r7, r1, r8)     // Catch:{ MalformedURLException -> 0x01b1 }
            setSavedCloudBridgeCredentials$facebook_core_release(r13)     // Catch:{ MalformedURLException -> 0x01b1 }
            com.facebook.appevents.cloudbridge.SettingsAPIFields r13 = com.facebook.appevents.cloudbridge.SettingsAPIFields.ENABLED
            java.lang.String r13 = r13.getRawValue()
            java.lang.Object r13 = r6.get(r13)
            if (r13 == 0) goto L_0x01ae
            com.facebook.appevents.cloudbridge.SettingsAPIFields r13 = com.facebook.appevents.cloudbridge.SettingsAPIFields.ENABLED
            java.lang.String r13 = r13.getRawValue()
            java.lang.Object r13 = r6.get(r13)
            if (r13 == 0) goto L_0x01a6
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r4 = r13.booleanValue()
            goto L_0x01ae
        L_0x01a6:
            java.lang.NullPointerException r13 = new java.lang.NullPointerException
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.Boolean"
            r13.<init>(r0)
            throw r13
        L_0x01ae:
            isEnabled = r4
            goto L_0x0203
        L_0x01b1:
            r13 = move-exception
            com.facebook.internal.Logger$Companion r0 = com.facebook.internal.Logger.Companion
            com.facebook.LoggingBehavior r1 = com.facebook.LoggingBehavior.APP_EVENTS
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r13 = com.twitter.sdk.android.tweetui.TweetUtils.stackTraceToString(r13)
            r3[r4] = r13
            java.lang.String r13 = "CloudBridge Settings API response doesn't have valid url\n %s "
            r0.log(r1, r2, r13, r3)
            goto L_0x0203
        L_0x01c7:
            com.facebook.internal.Logger$Companion r13 = com.facebook.internal.Logger.Companion
            com.facebook.LoggingBehavior r0 = com.facebook.LoggingBehavior.APP_EVENTS
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            java.lang.String r1 = "CloudBridge Settings API response doesn't have valid data"
            r13.log(r0, r2, r1)
            goto L_0x0203
        L_0x01d4:
            java.lang.NullPointerException r13 = new java.lang.NullPointerException     // Catch:{ JSONException -> 0x01f0, NullPointerException -> 0x01dc }
            java.lang.String r1 = "null cannot be cast to non-null type org.json.JSONArray"
            r13.<init>(r1)     // Catch:{ JSONException -> 0x01f0, NullPointerException -> 0x01dc }
            throw r13     // Catch:{ JSONException -> 0x01f0, NullPointerException -> 0x01dc }
        L_0x01dc:
            r13 = move-exception
            com.facebook.internal.Logger$Companion r1 = com.facebook.internal.Logger.Companion
            com.facebook.LoggingBehavior r6 = com.facebook.LoggingBehavior.APP_EVENTS
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r13 = com.twitter.sdk.android.tweetui.TweetUtils.stackTraceToString(r13)
            r3[r4] = r13
            r1.log(r6, r2, r0, r3)
            goto L_0x0203
        L_0x01f0:
            r13 = move-exception
            com.facebook.internal.Logger$Companion r1 = com.facebook.internal.Logger.Companion
            com.facebook.LoggingBehavior r6 = com.facebook.LoggingBehavior.APP_EVENTS
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r13 = com.twitter.sdk.android.tweetui.TweetUtils.stackTraceToString(r13)
            r3[r4] = r13
            r1.log(r6, r2, r0, r3)
        L_0x0203:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.cloudbridge.AppEventsCAPIManager.m157enable$lambda0(com.facebook.GraphResponse):void");
    }

    public static final void setSavedCloudBridgeCredentials$facebook_core_release(Map<String, ? extends Object> map) {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        SharedPreferences sharedPreferences = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.sdk.CloudBridgeSavedCredentials", 0);
        if (sharedPreferences != null) {
            Object obj = map.get(SettingsAPIFields.DATASETID.getRawValue());
            Object obj2 = map.get(SettingsAPIFields.URL.getRawValue());
            Object obj3 = map.get(SettingsAPIFields.ACCESSKEY.getRawValue());
            if (!(obj == null || obj2 == null || obj3 == null)) {
                Editor edit = sharedPreferences.edit();
                edit.putString(SettingsAPIFields.DATASETID.getRawValue(), obj.toString());
                edit.putString(SettingsAPIFields.URL.getRawValue(), obj2.toString());
                edit.putString(SettingsAPIFields.ACCESSKEY.getRawValue(), obj3.toString());
                edit.apply();
                Logger.Companion.log(LoggingBehavior.APP_EVENTS, (String) "com.facebook.appevents.cloudbridge.AppEventsCAPIManager", (String) " \n\nSaving Cloudbridge settings from saved Prefs: \n================\n DATASETID: %s\n URL: %s \n ACCESSKEY: %s \n\n ", obj, obj2, obj3);
            }
        }
    }
}
