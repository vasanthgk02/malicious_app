package com.facebook.appevents.internal;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysJvmKt;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J4\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/facebook/appevents/internal/AppEventsLoggerUtility;", "", "()V", "API_ACTIVITY_TYPE_TO_STRING", "", "Lcom/facebook/appevents/internal/AppEventsLoggerUtility$GraphAPIActivityType;", "", "getJSONObjectForGraphAPICall", "Lorg/json/JSONObject;", "activityType", "attributionIdentifiers", "Lcom/facebook/internal/AttributionIdentifiers;", "anonymousAppDeviceGUID", "limitEventUsage", "", "context", "Landroid/content/Context;", "GraphAPIActivityType", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: AppEventsLoggerUtility.kt */
public final class AppEventsLoggerUtility {
    public static final Map<GraphAPIActivityType, String> API_ACTIVITY_TYPE_TO_STRING = ArraysKt___ArraysJvmKt.hashMapOf(new Pair(GraphAPIActivityType.MOBILE_INSTALL_EVENT, "MOBILE_APP_INSTALL"), new Pair(GraphAPIActivityType.CUSTOM_APP_EVENTS, "CUSTOM_APP_EVENTS"));
    public static final AppEventsLoggerUtility INSTANCE = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/facebook/appevents/internal/AppEventsLoggerUtility$GraphAPIActivityType;", "", "(Ljava/lang/String;I)V", "MOBILE_INSTALL_EVENT", "CUSTOM_APP_EVENTS", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: AppEventsLoggerUtility.kt */
    public enum GraphAPIActivityType {
        MOBILE_INSTALL_EVENT,
        CUSTOM_APP_EVENTS
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00d7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final org.json.JSONObject getJSONObjectForGraphAPICall(com.facebook.appevents.internal.AppEventsLoggerUtility.GraphAPIActivityType r8, com.facebook.internal.AttributionIdentifiers r9, java.lang.String r10, boolean r11, android.content.Context r12) throws org.json.JSONException {
        /*
            java.lang.String r0 = "activityType"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
            java.util.Map<com.facebook.appevents.internal.AppEventsLoggerUtility$GraphAPIActivityType, java.lang.String> r2 = API_ACTIVITY_TYPE_TO_STRING
            java.lang.Object r8 = r2.get(r8)
            java.lang.String r2 = "event"
            r1.put(r2, r8)
            java.lang.String r8 = com.facebook.appevents.AppEventsLogger.Companion.getUserID()
            if (r8 == 0) goto L_0x0025
            java.lang.String r2 = "app_user_id"
            r1.put(r2, r8)
        L_0x0025:
            java.lang.String r8 = "params"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r8)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            com.facebook.internal.FeatureManager r8 = com.facebook.internal.FeatureManager.INSTANCE
            com.facebook.internal.FeatureManager$Feature r8 = com.facebook.internal.FeatureManager.Feature.ServiceUpdateCompliance
            boolean r8 = com.facebook.internal.FeatureManager.isEnabled(r8)
            java.lang.String r0 = "anon_id"
            if (r8 != 0) goto L_0x003c
            r1.put(r0, r10)
        L_0x003c:
            r8 = 1
            r11 = r11 ^ r8
            java.lang.String r2 = "application_tracking_enabled"
            r1.put(r2, r11)
            com.facebook.FacebookSdk r11 = com.facebook.FacebookSdk.INSTANCE
            com.facebook.UserSettingsManager r11 = com.facebook.UserSettingsManager.INSTANCE
            boolean r11 = com.facebook.UserSettingsManager.getAdvertiserIDCollectionEnabled()
            java.lang.String r2 = "advertiser_id_collection_enabled"
            r1.put(r2, r11)
            r11 = 0
            if (r9 == 0) goto L_0x0154
            com.facebook.internal.FeatureManager r2 = com.facebook.internal.FeatureManager.INSTANCE
            com.facebook.internal.FeatureManager$Feature r2 = com.facebook.internal.FeatureManager.Feature.ServiceUpdateCompliance
            boolean r2 = com.facebook.internal.FeatureManager.isEnabled(r2)
            java.lang.String r3 = "isGooglePlayServicesAvailable"
            java.lang.String r4 = "com.google.android.gms.common.GooglePlayServicesUtil"
            r5 = 31
            r6 = 0
            if (r2 == 0) goto L_0x009b
            int r2 = android.os.Build.VERSION.SDK_INT
            if (r2 < r5) goto L_0x0098
            java.lang.Class[] r2 = new java.lang.Class[r8]
            java.lang.Class<android.content.Context> r7 = android.content.Context.class
            r2[r11] = r7
            java.lang.reflect.Method r2 = com.facebook.internal.Utility.getMethodQuietly(r4, r3, (java.lang.Class<?>[]) r2)
            if (r2 != 0) goto L_0x0075
            goto L_0x008d
        L_0x0075:
            java.lang.Object[] r7 = new java.lang.Object[r8]
            r7[r11] = r12
            java.lang.Object r2 = com.facebook.internal.Utility.invokeMethodQuietly(r6, r2, r7)
            boolean r7 = r2 instanceof java.lang.Integer
            if (r7 == 0) goto L_0x008d
            java.lang.Integer r7 = java.lang.Integer.valueOf(r11)
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r7)
            if (r2 == 0) goto L_0x008d
            r2 = 1
            goto L_0x008e
        L_0x008d:
            r2 = 0
        L_0x008e:
            if (r2 == 0) goto L_0x0098
            boolean r2 = r9.isTrackingLimited
            if (r2 != 0) goto L_0x009b
            r1.put(r0, r10)
            goto L_0x009b
        L_0x0098:
            r1.put(r0, r10)
        L_0x009b:
            java.lang.String r10 = r9.attributionId
            if (r10 == 0) goto L_0x00ec
            com.facebook.internal.FeatureManager r10 = com.facebook.internal.FeatureManager.INSTANCE
            com.facebook.internal.FeatureManager$Feature r10 = com.facebook.internal.FeatureManager.Feature.ServiceUpdateCompliance
            boolean r10 = com.facebook.internal.FeatureManager.isEnabled(r10)
            java.lang.String r0 = "attribution"
            if (r10 == 0) goto L_0x00e7
            int r10 = android.os.Build.VERSION.SDK_INT
            if (r10 < r5) goto L_0x00e1
            java.lang.Class[] r10 = new java.lang.Class[r8]
            java.lang.Class<android.content.Context> r2 = android.content.Context.class
            r10[r11] = r2
            java.lang.reflect.Method r10 = com.facebook.internal.Utility.getMethodQuietly(r4, r3, (java.lang.Class<?>[]) r10)
            if (r10 != 0) goto L_0x00bc
            goto L_0x00d4
        L_0x00bc:
            java.lang.Object[] r2 = new java.lang.Object[r8]
            r2[r11] = r12
            java.lang.Object r10 = com.facebook.internal.Utility.invokeMethodQuietly(r6, r10, r2)
            boolean r2 = r10 instanceof java.lang.Integer
            if (r2 == 0) goto L_0x00d4
            java.lang.Integer r2 = java.lang.Integer.valueOf(r11)
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual(r10, r2)
            if (r10 == 0) goto L_0x00d4
            r10 = 1
            goto L_0x00d5
        L_0x00d4:
            r10 = 0
        L_0x00d5:
            if (r10 == 0) goto L_0x00e1
            boolean r10 = r9.isTrackingLimited
            if (r10 != 0) goto L_0x00ec
            java.lang.String r10 = r9.attributionId
            r1.put(r0, r10)
            goto L_0x00ec
        L_0x00e1:
            java.lang.String r10 = r9.attributionId
            r1.put(r0, r10)
            goto L_0x00ec
        L_0x00e7:
            java.lang.String r10 = r9.attributionId
            r1.put(r0, r10)
        L_0x00ec:
            java.lang.String r10 = r9.getAndroidAdvertiserId()
            if (r10 == 0) goto L_0x0103
            java.lang.String r10 = r9.getAndroidAdvertiserId()
            java.lang.String r0 = "advertiser_id"
            r1.put(r0, r10)
            boolean r10 = r9.isTrackingLimited
            r10 = r10 ^ r8
            java.lang.String r0 = "advertiser_tracking_enabled"
            r1.put(r0, r10)
        L_0x0103:
            boolean r10 = r9.isTrackingLimited
            if (r10 != 0) goto L_0x014b
            com.facebook.appevents.UserDataStore r10 = com.facebook.appevents.UserDataStore.INSTANCE
            java.lang.Class<com.facebook.appevents.UserDataStore> r10 = com.facebook.appevents.UserDataStore.class
            boolean r0 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r10)
            if (r0 == 0) goto L_0x0112
            goto L_0x013b
        L_0x0112:
            java.util.concurrent.atomic.AtomicBoolean r0 = com.facebook.appevents.UserDataStore.initialized     // Catch:{ all -> 0x0137 }
            boolean r0 = r0.get()     // Catch:{ all -> 0x0137 }
            if (r0 != 0) goto L_0x011f
            com.facebook.appevents.UserDataStore r0 = com.facebook.appevents.UserDataStore.INSTANCE     // Catch:{ all -> 0x0137 }
            r0.initAndWait()     // Catch:{ all -> 0x0137 }
        L_0x011f:
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ all -> 0x0137 }
            r0.<init>()     // Catch:{ all -> 0x0137 }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> r2 = com.facebook.appevents.UserDataStore.externalHashedUserData     // Catch:{ all -> 0x0137 }
            r0.putAll(r2)     // Catch:{ all -> 0x0137 }
            com.facebook.appevents.UserDataStore r2 = com.facebook.appevents.UserDataStore.INSTANCE     // Catch:{ all -> 0x0137 }
            java.util.Map r2 = r2.getEnabledInternalUserData()     // Catch:{ all -> 0x0137 }
            r0.putAll(r2)     // Catch:{ all -> 0x0137 }
            java.lang.String r6 = com.facebook.internal.Utility.mapToJsonStr(r0)     // Catch:{ all -> 0x0137 }
            goto L_0x013b
        L_0x0137:
            r0 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r0, r10)
        L_0x013b:
            int r10 = r6.length()
            if (r10 != 0) goto L_0x0143
            r10 = 1
            goto L_0x0144
        L_0x0143:
            r10 = 0
        L_0x0144:
            if (r10 != 0) goto L_0x014b
            java.lang.String r10 = "ud"
            r1.put(r10, r6)
        L_0x014b:
            java.lang.String r9 = r9.androidInstallerPackage
            if (r9 == 0) goto L_0x0154
            java.lang.String r10 = "installer_package"
            r1.put(r10, r9)
        L_0x0154:
            com.facebook.internal.Utility.setAppEventExtendedDeviceInfoParameters(r1, r12)     // Catch:{ Exception -> 0x0158 }
            goto L_0x016c
        L_0x0158:
            r9 = move-exception
            com.facebook.internal.Logger$Companion r10 = com.facebook.internal.Logger.Companion
            com.facebook.LoggingBehavior r0 = com.facebook.LoggingBehavior.APP_EVENTS
            java.lang.Object[] r8 = new java.lang.Object[r8]
            java.lang.String r9 = r9.toString()
            r8[r11] = r9
            java.lang.String r9 = "AppEvents"
            java.lang.String r11 = "Fetching extended device info parameters failed: '%s'"
            r10.log(r0, r9, r11, r8)
        L_0x016c:
            org.json.JSONObject r8 = com.facebook.internal.Utility.getDataProcessingOptions()
            if (r8 == 0) goto L_0x018a
            java.util.Iterator r9 = r8.keys()
        L_0x0176:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L_0x018a
            java.lang.Object r10 = r9.next()
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r11 = r8.get(r10)
            r1.put(r10, r11)
            goto L_0x0176
        L_0x018a:
            java.lang.String r8 = r12.getPackageName()
            java.lang.String r9 = "application_package_name"
            r1.put(r9, r8)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.internal.AppEventsLoggerUtility.getJSONObjectForGraphAPICall(com.facebook.appevents.internal.AppEventsLoggerUtility$GraphAPIActivityType, com.facebook.internal.AttributionIdentifiers, java.lang.String, boolean, android.content.Context):org.json.JSONObject");
    }
}
