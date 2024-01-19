package com.facebook.internal;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002BCB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020%H\u0007J\u0010\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u0004H\u0002J\u0014\u00104\u001a\u0004\u0018\u00010\"2\b\u00103\u001a\u0004\u0018\u00010\u0004H\u0007J\b\u00105\u001a\u00020/H\u0007J\u001d\u00106\u001a\u00020\"2\u0006\u00103\u001a\u00020\u00042\u0006\u00107\u001a\u000202H\u0000¢\u0006\u0002\b8J*\u00109\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020;0!0:2\b\u0010<\u001a\u0004\u0018\u000102H\u0002J\b\u0010=\u001a\u00020/H\u0002J\u001a\u0010>\u001a\u0004\u0018\u00010\"2\u0006\u00103\u001a\u00020\u00042\u0006\u0010?\u001a\u00020'H\u0007J\u0010\u0010@\u001a\u00020/2\u0006\u0010A\u001a\u00020'H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0015XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0015XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u001d\u001a\n \u001e*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0015XT¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\"0!X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010(\u001a\u0010\u0012\f\u0012\n \u001e*\u0004\u0018\u00010*0*0)X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lcom/facebook/internal/FetchedAppSettingsManager;", "", "()V", "APPLICATION_FIELDS", "", "APP_SETTINGS_PREFS_KEY_FORMAT", "APP_SETTINGS_PREFS_STORE", "APP_SETTING_ANDROID_SDK_ERROR_CATEGORIES", "APP_SETTING_APP_EVENTS_AAM_RULE", "APP_SETTING_APP_EVENTS_EVENT_BINDINGS", "APP_SETTING_APP_EVENTS_FEATURE_BITMASK", "APP_SETTING_APP_EVENTS_SESSION_TIMEOUT", "APP_SETTING_DIALOG_CONFIGS", "APP_SETTING_FIELDS", "", "APP_SETTING_NUX_CONTENT", "APP_SETTING_NUX_ENABLED", "APP_SETTING_RESTRICTIVE_EVENT_FILTER_FIELD", "APP_SETTING_SMART_LOGIN_OPTIONS", "APP_SETTING_SUPPORTS_IMPLICIT_SDK_LOGGING", "AUTOMATIC_LOGGING_ENABLED_BITMASK_FIELD", "", "CODELESS_EVENTS_ENABLED_BITMASK_FIELD", "IAP_AUTOMATIC_LOGGING_ENABLED_BITMASK_FIELD", "MONITOR_ENABLED_BITMASK_FIELD", "SDK_UPDATE_MESSAGE", "SMART_LOGIN_BOOKMARK_ICON_URL", "SMART_LOGIN_MENU_ICON_URL", "SUGGESTED_EVENTS_SETTING", "TAG", "kotlin.jvm.PlatformType", "TRACK_UNINSTALL_ENABLED_BITMASK_FIELD", "fetchedAppSettings", "", "Lcom/facebook/internal/FetchedAppSettings;", "fetchedAppSettingsCallbacks", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/facebook/internal/FetchedAppSettingsManager$FetchedAppSettingsCallback;", "isUnityInit", "", "loadingState", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/facebook/internal/FetchedAppSettingsManager$FetchAppSettingState;", "printedSDKUpdatedMessage", "unityEventBindings", "Lorg/json/JSONArray;", "getAppSettingsAsync", "", "callback", "getAppSettingsQueryResponse", "Lorg/json/JSONObject;", "applicationId", "getAppSettingsWithoutQuery", "loadAppSettingsAsync", "parseAppSettingsFromJSON", "settingsJSON", "parseAppSettingsFromJSON$facebook_core_release", "parseDialogConfigurations", "", "Lcom/facebook/internal/FetchedAppSettings$DialogFeatureConfig;", "dialogConfigResponse", "pollCallbacks", "queryAppSettings", "forceRequery", "setIsUnityInit", "flag", "FetchAppSettingState", "FetchedAppSettingsCallback", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: FetchedAppSettingsManager.kt */
public final class FetchedAppSettingsManager {
    public static final List<String> APP_SETTING_FIELDS = TweetUtils.listOf((T[]) new String[]{"supports_implicit_sdk_logging", "gdpv4_nux_content", "gdpv4_nux_enabled", "android_dialog_configs", "android_sdk_error_categories", "app_events_session_timeout", "app_events_feature_bitmask", "auto_event_mapping_android", "seamless_login", "smart_login_bookmark_icon_url", "smart_login_menu_icon_url", "restrictive_data_filter_params", "aam_rules", "suggested_events_setting"});
    public static final FetchedAppSettingsManager INSTANCE = new FetchedAppSettingsManager();
    public static final Map<String, FetchedAppSettings> fetchedAppSettings = new ConcurrentHashMap();
    public static final ConcurrentLinkedQueue<FetchedAppSettingsCallback> fetchedAppSettingsCallbacks = new ConcurrentLinkedQueue<>();
    public static final AtomicReference<FetchAppSettingState> loadingState = new AtomicReference<>(FetchAppSettingState.NOT_LOADED);
    public static boolean printedSDKUpdatedMessage;
    public static JSONArray unityEventBindings;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/facebook/internal/FetchedAppSettingsManager$FetchAppSettingState;", "", "(Ljava/lang/String;I)V", "NOT_LOADED", "LOADING", "SUCCESS", "ERROR", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: FetchedAppSettingsManager.kt */
    public enum FetchAppSettingState {
        NOT_LOADED,
        LOADING,
        SUCCESS,
        ERROR
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/facebook/internal/FetchedAppSettingsManager$FetchedAppSettingsCallback;", "", "onError", "", "onSuccess", "fetchedAppSettings", "Lcom/facebook/internal/FetchedAppSettings;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: FetchedAppSettingsManager.kt */
    public interface FetchedAppSettingsCallback {
        void onError();

        void onSuccess(FetchedAppSettings fetchedAppSettings);
    }

    public static final FetchedAppSettings getAppSettingsWithoutQuery(String str) {
        if (str != null) {
            return fetchedAppSettings.get(str);
        }
        return null;
    }

    public static final void loadAppSettingsAsync() {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        Context applicationContext = FacebookSdk.getApplicationContext();
        FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
        String applicationId = FacebookSdk.getApplicationId();
        if (Utility.isNullOrEmpty(applicationId)) {
            loadingState.set(FetchAppSettingState.ERROR);
            INSTANCE.pollCallbacks();
        } else if (fetchedAppSettings.containsKey(applicationId)) {
            loadingState.set(FetchAppSettingState.SUCCESS);
            INSTANCE.pollCallbacks();
        } else {
            if (!(loadingState.compareAndSet(FetchAppSettingState.NOT_LOADED, FetchAppSettingState.LOADING) || loadingState.compareAndSet(FetchAppSettingState.ERROR, FetchAppSettingState.LOADING))) {
                INSTANCE.pollCallbacks();
                return;
            }
            String outline70 = GeneratedOutlineSupport.outline70(new Object[]{applicationId}, 1, "com.facebook.internal.APP_SETTINGS.%s", "java.lang.String.format(format, *args)");
            FacebookSdk facebookSdk3 = FacebookSdk.INSTANCE;
            FacebookSdk.getExecutor().execute(new Runnable(applicationContext, outline70, applicationId) {
                public final /* synthetic */ Context f$0;
                public final /* synthetic */ String f$1;
                public final /* synthetic */ String f$2;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    FetchedAppSettingsManager.m196loadAppSettingsAsync$lambda0(this.f$0, this.f$1, this.f$2);
                }
            });
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01ea  */
    /* renamed from: loadAppSettingsAsync$lambda-0  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m196loadAppSettingsAsync$lambda0(android.content.Context r8, java.lang.String r9, java.lang.String r10) {
        /*
            java.lang.String r0 = "$context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "$settingsKey"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "$applicationId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "com.facebook.internal.preferences.APP_SETTINGS"
            r1 = 0
            android.content.SharedPreferences r8 = r8.getSharedPreferences(r0, r1)
            r0 = 0
            java.lang.String r2 = r8.getString(r9, r0)
            boolean r3 = com.facebook.internal.Utility.isNullOrEmpty(r2)
            java.lang.String r4 = "Required value was null."
            if (r3 != 0) goto L_0x0045
            if (r2 == 0) goto L_0x003b
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x002b }
            r3.<init>(r2)     // Catch:{ JSONException -> 0x002b }
            goto L_0x0032
        L_0x002b:
            r2 = move-exception
            java.lang.String r3 = "FacebookSDK"
            com.facebook.internal.Utility.logd(r3, r2)
            r3 = r0
        L_0x0032:
            if (r3 == 0) goto L_0x0045
            com.facebook.internal.FetchedAppSettingsManager r2 = INSTANCE
            com.facebook.internal.FetchedAppSettings r2 = r2.parseAppSettingsFromJSON$facebook_core_release(r10, r3)
            goto L_0x0046
        L_0x003b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = r4.toString()
            r8.<init>(r9)
            throw r8
        L_0x0045:
            r2 = r0
        L_0x0046:
            android.os.Bundle r3 = new android.os.Bundle
            r3.<init>()
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.List<java.lang.String> r6 = APP_SETTING_FIELDS
            r5.addAll(r6)
            java.lang.String r6 = ","
            java.lang.String r5 = android.text.TextUtils.join(r6, r5)
            java.lang.String r6 = "fields"
            r3.putString(r6, r5)
            com.facebook.GraphRequest$Companion r5 = com.facebook.GraphRequest.Companion
            java.lang.String r7 = "app"
            com.facebook.GraphRequest r5 = r5.newGraphPathRequest(r0, r7, r0)
            r7 = 1
            r5.forceApplicationRequest = r7
            r5.setParameters(r3)
            com.facebook.GraphResponse r3 = r5.executeAndWait()
            org.json.JSONObject r3 = r3.jsonObject
            if (r3 != 0) goto L_0x007b
            org.json.JSONObject r3 = new org.json.JSONObject
            r3.<init>()
        L_0x007b:
            com.facebook.internal.FetchedAppSettingsManager r5 = INSTANCE
            r5.parseAppSettingsFromJSON$facebook_core_release(r10, r3)
            android.content.SharedPreferences$Editor r8 = r8.edit()
            java.lang.String r3 = r3.toString()
            android.content.SharedPreferences$Editor r8 = r8.putString(r9, r3)
            r8.apply()
            if (r2 == 0) goto L_0x00a1
            java.lang.String r8 = r2.sdkUpdateMessage
            boolean r9 = printedSDKUpdatedMessage
            if (r9 != 0) goto L_0x00a1
            if (r8 == 0) goto L_0x00a1
            int r8 = r8.length()
            if (r8 <= 0) goto L_0x00a1
            printedSDKUpdatedMessage = r7
        L_0x00a1:
            com.facebook.internal.FetchedAppGateKeepersManager r8 = com.facebook.internal.FetchedAppGateKeepersManager.INSTANCE
            java.lang.String r8 = "applicationId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r8)
            android.os.Bundle r9 = new android.os.Bundle
            r9.<init>()
            java.lang.String r2 = "platform"
            java.lang.String r3 = "android"
            r9.putString(r2, r3)
            com.facebook.FacebookSdk r2 = com.facebook.FacebookSdk.INSTANCE
            java.lang.String r2 = "sdk_version"
            java.lang.String r3 = "16.0.1"
            r9.putString(r2, r3)
            java.lang.String r2 = "gatekeepers"
            r9.putString(r6, r2)
            com.facebook.GraphRequest$Companion r2 = com.facebook.GraphRequest.Companion
            java.lang.Object[] r3 = new java.lang.Object[r7]
            java.lang.String r5 = "mobile_sdk_gk"
            r3[r1] = r5
            java.lang.Object[] r3 = java.util.Arrays.copyOf(r3, r7)
            java.lang.String r5 = "app/%s"
            java.lang.String r3 = java.lang.String.format(r5, r3)
            java.lang.String r5 = "java.lang.String.format(format, *args)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)
            com.facebook.GraphRequest r0 = r2.newGraphPathRequest(r0, r3, r0)
            r0.setParameters(r9)
            com.facebook.GraphResponse r9 = r0.executeAndWait()
            org.json.JSONObject r9 = r9.jsonObject
            if (r9 != 0) goto L_0x00ed
            org.json.JSONObject r9 = new org.json.JSONObject
            r9.<init>()
        L_0x00ed:
            com.facebook.FacebookSdk r0 = com.facebook.FacebookSdk.INSTANCE
            android.content.Context r0 = com.facebook.FacebookSdk.getApplicationContext()
            java.lang.Object[] r2 = new java.lang.Object[r7]
            r2[r1] = r10
            java.lang.String r3 = "com.facebook.internal.APP_GATEKEEPERS.%s"
            java.lang.String r2 = com.android.tools.r8.GeneratedOutlineSupport.outline70(r2, r7, r3, r5)
            java.lang.String r3 = "com.facebook.internal.preferences.APP_GATEKEEPERS"
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r3, r1)
            android.content.SharedPreferences$Editor r0 = r0.edit()
            java.lang.String r1 = r9.toString()
            android.content.SharedPreferences$Editor r0 = r0.putString(r2, r1)
            r0.apply()
            com.facebook.internal.FetchedAppGateKeepersManager.parseAppGateKeepersFromJSON$facebook_core_release(r10, r9)
            com.facebook.appevents.internal.AutomaticAnalyticsLogger r9 = com.facebook.appevents.internal.AutomaticAnalyticsLogger.INSTANCE
            com.facebook.FacebookSdk r9 = com.facebook.FacebookSdk.INSTANCE
            android.content.Context r9 = com.facebook.FacebookSdk.getApplicationContext()
            com.facebook.FacebookSdk r0 = com.facebook.FacebookSdk.INSTANCE
            java.lang.String r0 = com.facebook.FacebookSdk.getApplicationId()
            com.facebook.FacebookSdk r1 = com.facebook.FacebookSdk.INSTANCE
            boolean r1 = com.facebook.FacebookSdk.getAutoLogAppEventsEnabled()
            if (r1 == 0) goto L_0x01f2
            boolean r1 = r9 instanceof android.app.Application
            if (r1 == 0) goto L_0x01f2
            android.app.Application r9 = (android.app.Application) r9
            java.lang.String r1 = "application"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r1)
            com.facebook.appevents.AppEventsLoggerImpl$Companion r2 = com.facebook.appevents.AppEventsLoggerImpl.Companion
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r1)
            com.facebook.FacebookSdk r1 = com.facebook.FacebookSdk.INSTANCE
            boolean r1 = com.facebook.FacebookSdk.isInitialized()
            if (r1 == 0) goto L_0x01ea
            com.facebook.appevents.AnalyticsUserIDStore r1 = com.facebook.appevents.AnalyticsUserIDStore.INSTANCE
            boolean r1 = com.facebook.appevents.AnalyticsUserIDStore.initialized
            if (r1 == 0) goto L_0x014a
            goto L_0x0160
        L_0x014a:
            com.facebook.appevents.AppEventsLoggerImpl$Companion r1 = com.facebook.appevents.AppEventsLoggerImpl.Companion
            java.util.concurrent.ScheduledThreadPoolExecutor r2 = com.facebook.appevents.AppEventsLoggerImpl.access$getBackgroundExecutor$cp()
            if (r2 != 0) goto L_0x0155
            r1.initializeTimersIfNeeded()
        L_0x0155:
            java.util.concurrent.ScheduledThreadPoolExecutor r1 = com.facebook.appevents.AppEventsLoggerImpl.access$getBackgroundExecutor$cp()
            if (r1 == 0) goto L_0x01e0
            com.facebook.appevents.-$$Lambda$tbenDbD_e_3vWhw1CCsMI8yNRVU r2 = com.facebook.appevents.$$Lambda$tbenDbD_e_3vWhw1CCsMI8yNRVU.INSTANCE
            r1.execute(r2)
        L_0x0160:
            com.facebook.appevents.UserDataStore r1 = com.facebook.appevents.UserDataStore.INSTANCE
            java.lang.Class<com.facebook.appevents.UserDataStore> r1 = com.facebook.appevents.UserDataStore.class
            boolean r2 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r1)
            if (r2 == 0) goto L_0x016b
            goto L_0x017e
        L_0x016b:
            java.util.concurrent.atomic.AtomicBoolean r2 = com.facebook.appevents.UserDataStore.initialized     // Catch:{ all -> 0x017a }
            boolean r2 = r2.get()     // Catch:{ all -> 0x017a }
            if (r2 == 0) goto L_0x0174
            goto L_0x017e
        L_0x0174:
            com.facebook.appevents.UserDataStore r2 = com.facebook.appevents.UserDataStore.INSTANCE     // Catch:{ all -> 0x017a }
            r2.initAndWait()     // Catch:{ all -> 0x017a }
            goto L_0x017e
        L_0x017a:
            r2 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r2, r1)
        L_0x017e:
            com.facebook.FacebookSdk r1 = com.facebook.FacebookSdk.INSTANCE
            java.lang.Class<com.facebook.FacebookSdk> r1 = com.facebook.FacebookSdk.class
            boolean r2 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r1)
            if (r2 == 0) goto L_0x0189
            goto L_0x01da
        L_0x0189:
            java.lang.String r2 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r2)     // Catch:{ all -> 0x01d6 }
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r8)     // Catch:{ all -> 0x01d6 }
            android.content.Context r8 = r9.getApplicationContext()     // Catch:{ all -> 0x01d6 }
            java.util.concurrent.Executor r2 = com.facebook.FacebookSdk.getExecutor()     // Catch:{ all -> 0x01d6 }
            com.facebook.-$$Lambda$ypYeSdvodRE48bYZoPxnixunOlI r3 = new com.facebook.-$$Lambda$ypYeSdvodRE48bYZoPxnixunOlI     // Catch:{ all -> 0x01d6 }
            r3.<init>(r8, r0)     // Catch:{ all -> 0x01d6 }
            r2.execute(r3)     // Catch:{ all -> 0x01d6 }
            com.facebook.internal.FeatureManager r8 = com.facebook.internal.FeatureManager.INSTANCE     // Catch:{ all -> 0x01d6 }
            com.facebook.internal.FeatureManager$Feature r8 = com.facebook.internal.FeatureManager.Feature.OnDeviceEventProcessing     // Catch:{ all -> 0x01d6 }
            boolean r8 = com.facebook.internal.FeatureManager.isEnabled(r8)     // Catch:{ all -> 0x01d6 }
            if (r8 == 0) goto L_0x01da
            com.facebook.appevents.ondeviceprocessing.OnDeviceProcessingManager r8 = com.facebook.appevents.ondeviceprocessing.OnDeviceProcessingManager.INSTANCE     // Catch:{ all -> 0x01d6 }
            boolean r8 = com.facebook.appevents.ondeviceprocessing.OnDeviceProcessingManager.isOnDeviceProcessingEnabled()     // Catch:{ all -> 0x01d6 }
            if (r8 == 0) goto L_0x01da
            com.facebook.appevents.ondeviceprocessing.OnDeviceProcessingManager r8 = com.facebook.appevents.ondeviceprocessing.OnDeviceProcessingManager.INSTANCE     // Catch:{ all -> 0x01d6 }
            java.lang.String r8 = "com.facebook.sdk.attributionTracking"
            java.lang.Class<com.facebook.appevents.ondeviceprocessing.OnDeviceProcessingManager> r2 = com.facebook.appevents.ondeviceprocessing.OnDeviceProcessingManager.class
            boolean r3 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r2)     // Catch:{ all -> 0x01d6 }
            if (r3 == 0) goto L_0x01c0
            goto L_0x01da
        L_0x01c0:
            android.content.Context r3 = com.facebook.FacebookSdk.getApplicationContext()     // Catch:{ all -> 0x01d1 }
            java.util.concurrent.Executor r4 = com.facebook.FacebookSdk.getExecutor()     // Catch:{ all -> 0x01d1 }
            com.facebook.appevents.ondeviceprocessing.-$$Lambda$KHCL1CriT4yh6K97BX3fXiiTdBk r5 = new com.facebook.appevents.ondeviceprocessing.-$$Lambda$KHCL1CriT4yh6K97BX3fXiiTdBk     // Catch:{ all -> 0x01d1 }
            r5.<init>(r3, r8, r0)     // Catch:{ all -> 0x01d1 }
            r4.execute(r5)     // Catch:{ all -> 0x01d1 }
            goto L_0x01da
        L_0x01d1:
            r8 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r8, r2)     // Catch:{ all -> 0x01d6 }
            goto L_0x01da
        L_0x01d6:
            r8 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r8, r1)
        L_0x01da:
            com.facebook.appevents.internal.ActivityLifecycleTracker r8 = com.facebook.appevents.internal.ActivityLifecycleTracker.INSTANCE
            com.facebook.appevents.internal.ActivityLifecycleTracker.startTracking(r9, r0)
            goto L_0x01f2
        L_0x01e0:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = r4.toString()
            r8.<init>(r9)
            throw r8
        L_0x01ea:
            com.facebook.FacebookException r8 = new com.facebook.FacebookException
            java.lang.String r9 = "The Facebook sdk must be initialized before calling activateApp"
            r8.<init>(r9)
            throw r8
        L_0x01f2:
            java.util.concurrent.atomic.AtomicReference<com.facebook.internal.FetchedAppSettingsManager$FetchAppSettingState> r8 = loadingState
            java.util.Map<java.lang.String, com.facebook.internal.FetchedAppSettings> r9 = fetchedAppSettings
            boolean r9 = r9.containsKey(r10)
            if (r9 == 0) goto L_0x01ff
            com.facebook.internal.FetchedAppSettingsManager$FetchAppSettingState r9 = com.facebook.internal.FetchedAppSettingsManager.FetchAppSettingState.SUCCESS
            goto L_0x0201
        L_0x01ff:
            com.facebook.internal.FetchedAppSettingsManager$FetchAppSettingState r9 = com.facebook.internal.FetchedAppSettingsManager.FetchAppSettingState.ERROR
        L_0x0201:
            r8.set(r9)
            com.facebook.internal.FetchedAppSettingsManager r8 = INSTANCE
            r8.pollCallbacks()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.FetchedAppSettingsManager.m196loadAppSettingsAsync$lambda0(android.content.Context, java.lang.String, java.lang.String):void");
    }

    /* renamed from: pollCallbacks$lambda-1  reason: not valid java name */
    public static final void m197pollCallbacks$lambda1(FetchedAppSettingsCallback fetchedAppSettingsCallback) {
        fetchedAppSettingsCallback.onError();
    }

    /* renamed from: pollCallbacks$lambda-2  reason: not valid java name */
    public static final void m198pollCallbacks$lambda2(FetchedAppSettingsCallback fetchedAppSettingsCallback, FetchedAppSettings fetchedAppSettings2) {
        fetchedAppSettingsCallback.onSuccess(fetchedAppSettings2);
    }

    public static final FetchedAppSettings queryAppSettings(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "applicationId");
        if (!z && fetchedAppSettings.containsKey(str)) {
            return fetchedAppSettings.get(str);
        }
        Bundle bundle = new Bundle();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(APP_SETTING_FIELDS);
        bundle.putString("fields", TextUtils.join(",", arrayList));
        GraphRequest newGraphPathRequest = GraphRequest.Companion.newGraphPathRequest(null, "app", null);
        newGraphPathRequest.forceApplicationRequest = true;
        newGraphPathRequest.setParameters(bundle);
        JSONObject jSONObject = newGraphPathRequest.executeAndWait().jsonObject;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        FetchedAppSettings parseAppSettingsFromJSON$facebook_core_release = INSTANCE.parseAppSettingsFromJSON$facebook_core_release(str, jSONObject);
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        if (Intrinsics.areEqual(str, FacebookSdk.getApplicationId())) {
            loadingState.set(FetchAppSettingState.SUCCESS);
            INSTANCE.pollCallbacks();
        }
        return parseAppSettingsFromJSON$facebook_core_release;
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x022d A[LOOP:1: B:61:0x0158->B:101:0x022d, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x008c A[EDGE_INSN: B:104:0x008c->B:23:0x008c ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0231 A[EDGE_INSN: B:105:0x0231->B:102:0x0231 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0099 A[LOOP:0: B:6:0x002d->B:24:0x0099, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0213  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.facebook.internal.FetchedAppSettings parseAppSettingsFromJSON$facebook_core_release(java.lang.String r40, org.json.JSONObject r41) {
        /*
            r39 = this;
            r1 = r40
            r2 = r41
            java.lang.String r0 = "applicationId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "settingsJSON"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "android_sdk_error_categories"
            org.json.JSONArray r0 = r2.optJSONArray(r0)
            com.facebook.internal.FacebookRequestErrorClassification$Companion r3 = com.facebook.internal.FacebookRequestErrorClassification.Companion
            r4 = 1
            java.lang.String r7 = "name"
            if (r0 != 0) goto L_0x0020
            r0 = 1
            r3 = 0
            r6 = 0
            goto L_0x00b3
        L_0x0020:
            int r8 = r0.length()
            if (r8 <= 0) goto L_0x009e
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
        L_0x002d:
            int r5 = r9 + 1
            org.json.JSONObject r9 = r0.optJSONObject(r9)
            if (r9 != 0) goto L_0x0036
            goto L_0x003c
        L_0x0036:
            java.lang.String r6 = r9.optString(r7)
            if (r6 != 0) goto L_0x0043
        L_0x003c:
            r17 = r0
            r19 = r10
            r0 = 1
        L_0x0041:
            r6 = 0
            goto L_0x0088
        L_0x0043:
            r17 = r0
            java.lang.String r0 = "other"
            boolean r0 = kotlin.text.CharsKt__CharKt.equals(r6, r0, r4)
            java.lang.String r4 = "recovery_message"
            if (r0 == 0) goto L_0x005c
            r10 = 0
            java.lang.String r15 = r9.optString(r4, r10)
            java.util.Map r0 = r3.parseJSONDefinition(r9)
            r6 = r10
            r10 = r0
            r0 = 1
            goto L_0x008a
        L_0x005c:
            r0 = r10
            java.lang.String r10 = "transient"
            r19 = r0
            r0 = 1
            boolean r10 = kotlin.text.CharsKt__CharKt.equals(r6, r10, r0)
            if (r10 == 0) goto L_0x0075
            r10 = 0
            java.lang.String r4 = r9.optString(r4, r10)
            java.util.Map r6 = r3.parseJSONDefinition(r9)
            r13 = r4
            r11 = r6
            r6 = r10
            goto L_0x0088
        L_0x0075:
            java.lang.String r10 = "login_recoverable"
            boolean r6 = kotlin.text.CharsKt__CharKt.equals(r6, r10, r0)
            if (r6 == 0) goto L_0x0041
            r6 = 0
            java.lang.String r4 = r9.optString(r4, r6)
            java.util.Map r9 = r3.parseJSONDefinition(r9)
            r14 = r4
            r12 = r9
        L_0x0088:
            r10 = r19
        L_0x008a:
            if (r5 < r8) goto L_0x0099
            r19 = r10
            r20 = r11
            r21 = r12
            r23 = r13
            r24 = r14
            r22 = r15
            goto L_0x00ac
        L_0x0099:
            r9 = r5
            r0 = r17
            r4 = 1
            goto L_0x002d
        L_0x009e:
            r0 = 1
            r6 = 0
            r19 = r6
            r20 = r19
            r21 = r20
            r22 = r21
            r23 = r22
            r24 = r23
        L_0x00ac:
            com.facebook.internal.FacebookRequestErrorClassification r3 = new com.facebook.internal.FacebookRequestErrorClassification
            r18 = r3
            r18.<init>(r19, r20, r21, r22, r23, r24)
        L_0x00b3:
            if (r3 != 0) goto L_0x00bb
            com.facebook.internal.FacebookRequestErrorClassification$Companion r3 = com.facebook.internal.FacebookRequestErrorClassification.Companion
            com.facebook.internal.FacebookRequestErrorClassification r3 = r3.getDefaultErrorClassification()
        L_0x00bb:
            r24 = r3
            java.lang.String r3 = "app_events_feature_bitmask"
            r4 = 0
            int r3 = r2.optInt(r3, r4)
            r4 = r3 & 8
            if (r4 == 0) goto L_0x00cb
            r23 = 1
            goto L_0x00cd
        L_0x00cb:
            r23 = 0
        L_0x00cd:
            r4 = r3 & 16
            if (r4 == 0) goto L_0x00d4
            r27 = 1
            goto L_0x00d6
        L_0x00d4:
            r27 = 0
        L_0x00d6:
            r4 = r3 & 32
            if (r4 == 0) goto L_0x00dd
            r28 = 1
            goto L_0x00df
        L_0x00dd:
            r28 = 0
        L_0x00df:
            r4 = r3 & 256(0x100, float:3.59E-43)
            if (r4 == 0) goto L_0x00e6
            r31 = 1
            goto L_0x00e8
        L_0x00e6:
            r31 = 0
        L_0x00e8:
            r3 = r3 & 16384(0x4000, float:2.2959E-41)
            if (r3 == 0) goto L_0x00ef
            r32 = 1
            goto L_0x00f1
        L_0x00ef:
            r32 = 0
        L_0x00f1:
            java.lang.String r0 = "auto_event_mapping_android"
            org.json.JSONArray r29 = r2.optJSONArray(r0)
            unityEventBindings = r29
            if (r29 == 0) goto L_0x010c
            boolean r0 = com.facebook.internal.InternalSettings.isUnityApp()
            if (r0 == 0) goto L_0x010c
            java.lang.String r0 = r29.toString()
            java.lang.String r3 = "UnityFacebookSDKPlugin"
            java.lang.String r4 = "OnReceiveMapping"
            com.facebook.appevents.codeless.internal.UnityReflection.sendMessage(r3, r4, r0)
        L_0x010c:
            com.facebook.internal.FetchedAppSettings r3 = new com.facebook.internal.FetchedAppSettings
            java.lang.String r0 = "supports_implicit_sdk_logging"
            r4 = 0
            boolean r17 = r2.optBoolean(r0, r4)
            java.lang.String r0 = "gdpv4_nux_content"
            java.lang.String r5 = ""
            java.lang.String r5 = r2.optString(r0, r5)
            java.lang.String r0 = "settingsJSON.optString(APP_SETTING_NUX_CONTENT, \"\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
            java.lang.String r0 = "gdpv4_nux_enabled"
            boolean r19 = r2.optBoolean(r0, r4)
            r0 = 60
            java.lang.String r4 = "app_events_session_timeout"
            int r20 = r2.optInt(r4, r0)
            com.facebook.internal.SmartLoginOption$Companion r0 = com.facebook.internal.SmartLoginOption.Companion
            java.lang.String r4 = "seamless_login"
            long r8 = r2.optLong(r4)
            java.util.EnumSet r21 = r0.parseOptions(r8)
            java.lang.String r0 = "android_dialog_configs"
            org.json.JSONObject r0 = r2.optJSONObject(r0)
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            if (r0 == 0) goto L_0x0231
            java.lang.String r8 = "data"
            org.json.JSONArray r8 = r0.optJSONArray(r8)
            if (r8 == 0) goto L_0x0231
            int r9 = r8.length()
            if (r9 <= 0) goto L_0x0231
            r0 = 0
        L_0x0158:
            int r10 = r0 + 1
            org.json.JSONObject r0 = r8.optJSONObject(r0)
            java.lang.String r11 = "dialogConfigData.optJSONObject(i)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r11)
            java.lang.String r11 = "dialogConfigJSON"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r11)
            java.lang.String r11 = r0.optString(r7)
            boolean r12 = com.facebook.internal.Utility.isNullOrEmpty(r11)
            if (r12 == 0) goto L_0x0174
            goto L_0x020f
        L_0x0174:
            java.lang.String r12 = "dialogNameWithFeature"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r12)
            java.lang.String r12 = "|"
            java.lang.String[] r12 = new java.lang.String[]{r12}
            r13 = 6
            r14 = 0
            java.util.List r11 = kotlin.text.CharsKt__CharKt.split$default(r11, r12, r14, r14, r13)
            int r12 = r11.size()
            r13 = 2
            if (r12 == r13) goto L_0x018e
            goto L_0x020f
        L_0x018e:
            java.lang.Object r12 = kotlin.collections.ArraysKt___ArraysJvmKt.first(r11)
            r34 = r12
            java.lang.String r34 = (java.lang.String) r34
            java.lang.Object r11 = kotlin.collections.ArraysKt___ArraysJvmKt.last(r11)
            r35 = r11
            java.lang.String r35 = (java.lang.String) r35
            boolean r11 = com.facebook.internal.Utility.isNullOrEmpty(r34)
            if (r11 != 0) goto L_0x020f
            boolean r11 = com.facebook.internal.Utility.isNullOrEmpty(r35)
            if (r11 == 0) goto L_0x01ac
            goto L_0x020f
        L_0x01ac:
            java.lang.String r11 = "url"
            java.lang.String r11 = r0.optString(r11)
            boolean r12 = com.facebook.internal.Utility.isNullOrEmpty(r11)
            if (r12 != 0) goto L_0x01bf
            android.net.Uri r11 = android.net.Uri.parse(r11)
            r36 = r11
            goto L_0x01c1
        L_0x01bf:
            r36 = r6
        L_0x01c1:
            java.lang.String r11 = "versions"
            org.json.JSONArray r11 = r0.optJSONArray(r11)
            if (r11 == 0) goto L_0x0203
            int r12 = r11.length()
            int[] r13 = new int[r12]
            if (r12 <= 0) goto L_0x0200
            r15 = 0
        L_0x01d2:
            int r6 = r15 + 1
            r14 = -1
            int r0 = r11.optInt(r15, r14)
            if (r0 != r14) goto L_0x01f7
            java.lang.String r14 = r11.optString(r15)
            boolean r22 = com.facebook.internal.Utility.isNullOrEmpty(r14)
            if (r22 != 0) goto L_0x01f7
            java.lang.String r0 = "versionString"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r0)     // Catch:{ NumberFormatException -> 0x01ef }
            int r14 = java.lang.Integer.parseInt(r14)     // Catch:{ NumberFormatException -> 0x01ef }
            goto L_0x01f6
        L_0x01ef:
            r0 = move-exception
            java.lang.String r14 = "FacebookSDK"
            com.facebook.internal.Utility.logd(r14, r0)
            r14 = -1
        L_0x01f6:
            r0 = r14
        L_0x01f7:
            r13[r15] = r0
            if (r6 < r12) goto L_0x01fc
            goto L_0x0200
        L_0x01fc:
            r15 = r6
            r6 = 0
            r14 = 0
            goto L_0x01d2
        L_0x0200:
            r37 = r13
            goto L_0x0205
        L_0x0203:
            r37 = 0
        L_0x0205:
            com.facebook.internal.FetchedAppSettings$DialogFeatureConfig r0 = new com.facebook.internal.FetchedAppSettings$DialogFeatureConfig
            r38 = 0
            r33 = r0
            r33.<init>(r34, r35, r36, r37, r38)
            goto L_0x0210
        L_0x020f:
            r0 = 0
        L_0x0210:
            if (r0 != 0) goto L_0x0213
            goto L_0x022a
        L_0x0213:
            java.lang.String r6 = r0.dialogName
            java.lang.Object r11 = r4.get(r6)
            java.util.Map r11 = (java.util.Map) r11
            if (r11 != 0) goto L_0x0225
            java.util.HashMap r11 = new java.util.HashMap
            r11.<init>()
            r4.put(r6, r11)
        L_0x0225:
            java.lang.String r6 = r0.featureName
            r11.put(r6, r0)
        L_0x022a:
            if (r10 < r9) goto L_0x022d
            goto L_0x0231
        L_0x022d:
            r0 = r10
            r6 = 0
            goto L_0x0158
        L_0x0231:
            java.lang.String r0 = "smart_login_bookmark_icon_url"
            java.lang.String r0 = r2.optString(r0)
            r25 = r0
            java.lang.String r6 = "settingsJSON.optString(SMART_LOGIN_BOOKMARK_ICON_URL)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r6)
            java.lang.String r0 = "smart_login_menu_icon_url"
            java.lang.String r0 = r2.optString(r0)
            r26 = r0
            java.lang.String r6 = "settingsJSON.optString(SMART_LOGIN_MENU_ICON_URL)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r6)
            java.lang.String r0 = "sdk_update_message"
            java.lang.String r0 = r2.optString(r0)
            r30 = r0
            java.lang.String r6 = "settingsJSON.optString(SDK_UPDATE_MESSAGE)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r6)
            java.lang.String r0 = "aam_rules"
            java.lang.String r33 = r2.optString(r0)
            java.lang.String r0 = "suggested_events_setting"
            java.lang.String r34 = r2.optString(r0)
            java.lang.String r0 = "restrictive_data_filter_params"
            java.lang.String r35 = r2.optString(r0)
            r16 = r3
            r18 = r5
            r22 = r4
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35)
            java.util.Map<java.lang.String, com.facebook.internal.FetchedAppSettings> r0 = fetchedAppSettings
            r0.put(r1, r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.FetchedAppSettingsManager.parseAppSettingsFromJSON$facebook_core_release(java.lang.String, org.json.JSONObject):com.facebook.internal.FetchedAppSettings");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0064, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void pollCallbacks() {
        /*
            r4 = this;
            monitor-enter(r4)
            java.util.concurrent.atomic.AtomicReference<com.facebook.internal.FetchedAppSettingsManager$FetchAppSettingState> r0 = loadingState     // Catch:{ all -> 0x0065 }
            java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x0065 }
            com.facebook.internal.FetchedAppSettingsManager$FetchAppSettingState r0 = (com.facebook.internal.FetchedAppSettingsManager.FetchAppSettingState) r0     // Catch:{ all -> 0x0065 }
            com.facebook.internal.FetchedAppSettingsManager$FetchAppSettingState r1 = com.facebook.internal.FetchedAppSettingsManager.FetchAppSettingState.NOT_LOADED     // Catch:{ all -> 0x0065 }
            if (r1 == r0) goto L_0x0063
            com.facebook.internal.FetchedAppSettingsManager$FetchAppSettingState r1 = com.facebook.internal.FetchedAppSettingsManager.FetchAppSettingState.LOADING     // Catch:{ all -> 0x0065 }
            if (r1 != r0) goto L_0x0012
            goto L_0x0063
        L_0x0012:
            com.facebook.FacebookSdk r1 = com.facebook.FacebookSdk.INSTANCE     // Catch:{ all -> 0x0065 }
            java.lang.String r1 = com.facebook.FacebookSdk.getApplicationId()     // Catch:{ all -> 0x0065 }
            java.util.Map<java.lang.String, com.facebook.internal.FetchedAppSettings> r2 = fetchedAppSettings     // Catch:{ all -> 0x0065 }
            java.lang.Object r1 = r2.get(r1)     // Catch:{ all -> 0x0065 }
            com.facebook.internal.FetchedAppSettings r1 = (com.facebook.internal.FetchedAppSettings) r1     // Catch:{ all -> 0x0065 }
            android.os.Handler r2 = new android.os.Handler     // Catch:{ all -> 0x0065 }
            android.os.Looper r3 = android.os.Looper.getMainLooper()     // Catch:{ all -> 0x0065 }
            r2.<init>(r3)     // Catch:{ all -> 0x0065 }
            com.facebook.internal.FetchedAppSettingsManager$FetchAppSettingState r3 = com.facebook.internal.FetchedAppSettingsManager.FetchAppSettingState.ERROR     // Catch:{ all -> 0x0065 }
            if (r3 != r0) goto L_0x0048
        L_0x002d:
            java.util.concurrent.ConcurrentLinkedQueue<com.facebook.internal.FetchedAppSettingsManager$FetchedAppSettingsCallback> r0 = fetchedAppSettingsCallbacks     // Catch:{ all -> 0x0065 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0065 }
            if (r0 != 0) goto L_0x0046
            java.util.concurrent.ConcurrentLinkedQueue<com.facebook.internal.FetchedAppSettingsManager$FetchedAppSettingsCallback> r0 = fetchedAppSettingsCallbacks     // Catch:{ all -> 0x0065 }
            java.lang.Object r0 = r0.poll()     // Catch:{ all -> 0x0065 }
            com.facebook.internal.FetchedAppSettingsManager$FetchedAppSettingsCallback r0 = (com.facebook.internal.FetchedAppSettingsManager.FetchedAppSettingsCallback) r0     // Catch:{ all -> 0x0065 }
            com.facebook.internal.-$$Lambda$uQT6TldPL3gwFdZiEmqolV_6Gyc r1 = new com.facebook.internal.-$$Lambda$uQT6TldPL3gwFdZiEmqolV_6Gyc     // Catch:{ all -> 0x0065 }
            r1.<init>()     // Catch:{ all -> 0x0065 }
            r2.post(r1)     // Catch:{ all -> 0x0065 }
            goto L_0x002d
        L_0x0046:
            monitor-exit(r4)
            return
        L_0x0048:
            java.util.concurrent.ConcurrentLinkedQueue<com.facebook.internal.FetchedAppSettingsManager$FetchedAppSettingsCallback> r0 = fetchedAppSettingsCallbacks     // Catch:{ all -> 0x0065 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0065 }
            if (r0 != 0) goto L_0x0061
            java.util.concurrent.ConcurrentLinkedQueue<com.facebook.internal.FetchedAppSettingsManager$FetchedAppSettingsCallback> r0 = fetchedAppSettingsCallbacks     // Catch:{ all -> 0x0065 }
            java.lang.Object r0 = r0.poll()     // Catch:{ all -> 0x0065 }
            com.facebook.internal.FetchedAppSettingsManager$FetchedAppSettingsCallback r0 = (com.facebook.internal.FetchedAppSettingsManager.FetchedAppSettingsCallback) r0     // Catch:{ all -> 0x0065 }
            com.facebook.internal.-$$Lambda$g7wm_6qBdcfxFx1P0VEhJxOu3AI r3 = new com.facebook.internal.-$$Lambda$g7wm_6qBdcfxFx1P0VEhJxOu3AI     // Catch:{ all -> 0x0065 }
            r3.<init>(r1)     // Catch:{ all -> 0x0065 }
            r2.post(r3)     // Catch:{ all -> 0x0065 }
            goto L_0x0048
        L_0x0061:
            monitor-exit(r4)
            return
        L_0x0063:
            monitor-exit(r4)
            return
        L_0x0065:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.FetchedAppSettingsManager.pollCallbacks():void");
    }
}
