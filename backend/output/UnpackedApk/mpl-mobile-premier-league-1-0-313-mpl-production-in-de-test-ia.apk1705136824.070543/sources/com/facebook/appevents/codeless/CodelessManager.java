package com.facebook.appevents.codeless;

import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.AttributionIdentifiers.Companion;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.Arrays;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u0013\u001a\u00020\u0011H\u0007J\b\u0010\u0014\u001a\u00020\u0011H\u0007J\r\u0010\u0015\u001a\u00020\u0004H\u0001¢\u0006\u0002\b\u0016J\r\u0010\u0017\u001a\u00020\bH\u0001¢\u0006\u0002\b\u0018J\b\u0010\u0019\u001a\u00020\bH\u0002J\u0010\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u0010\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u0010\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u0015\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\bH\u0001¢\u0006\u0002\b!R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/facebook/appevents/codeless/CodelessManager;", "", "()V", "deviceSessionID", "", "isAppIndexingEnabled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isCheckingSession", "", "isCodelessEnabled", "sensorManager", "Landroid/hardware/SensorManager;", "viewIndexer", "Lcom/facebook/appevents/codeless/ViewIndexer;", "viewIndexingTrigger", "Lcom/facebook/appevents/codeless/ViewIndexingTrigger;", "checkCodelessSession", "", "applicationId", "disable", "enable", "getCurrentDeviceSessionID", "getCurrentDeviceSessionID$facebook_core_release", "getIsAppIndexingEnabled", "getIsAppIndexingEnabled$facebook_core_release", "isDebugOnEmulator", "onActivityDestroyed", "activity", "Landroid/app/Activity;", "onActivityPaused", "onActivityResumed", "updateAppIndexing", "appIndexingEnabled", "updateAppIndexing$facebook_core_release", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: CodelessManager.kt */
public final class CodelessManager {
    public static final CodelessManager INSTANCE = new CodelessManager();
    public static String deviceSessionID;
    public static final AtomicBoolean isAppIndexingEnabled = new AtomicBoolean(false);
    public static volatile boolean isCheckingSession;
    public static final AtomicBoolean isCodelessEnabled = new AtomicBoolean(true);
    public static SensorManager sensorManager;
    public static ViewIndexer viewIndexer;
    public static final ViewIndexingTrigger viewIndexingTrigger = new ViewIndexingTrigger();

    /* renamed from: checkCodelessSession$lambda-1  reason: not valid java name */
    public static final void m161checkCodelessSession$lambda1(String str) {
        String str2;
        String str3 = "0";
        Class<CodelessManager> cls = CodelessManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Bundle bundle = new Bundle();
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                AttributionIdentifiers attributionIdentifiers = Companion.getAttributionIdentifiers(FacebookSdk.getApplicationContext());
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(Build.MODEL != null ? Build.MODEL : "");
                if (attributionIdentifiers == null) {
                    str2 = null;
                } else {
                    str2 = attributionIdentifiers.getAndroidAdvertiserId();
                }
                if (str2 != null) {
                    jSONArray.put(attributionIdentifiers.getAndroidAdvertiserId());
                } else {
                    jSONArray.put("");
                }
                jSONArray.put(str3);
                if (AppEventUtility.isEmulator()) {
                    str3 = "1";
                }
                jSONArray.put(str3);
                Locale resourceLocale = Utility.getResourceLocale();
                if (resourceLocale == null) {
                    resourceLocale = Locale.getDefault();
                    Intrinsics.checkNotNullExpressionValue(resourceLocale, "getDefault()");
                }
                jSONArray.put(resourceLocale.getLanguage() + '_' + resourceLocale.getCountry());
                String jSONArray2 = jSONArray.toString();
                Intrinsics.checkNotNullExpressionValue(jSONArray2, "extInfoArray.toString()");
                bundle.putString("device_session_id", getCurrentDeviceSessionID$facebook_core_release());
                bundle.putString("extinfo", jSONArray2);
                GraphRequest.Companion companion = GraphRequest.Companion;
                boolean z = true;
                String format = String.format(Locale.US, "%s/app_indexing_session", Arrays.copyOf(new Object[]{str}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
                JSONObject jSONObject = companion.newPostRequestWithBundle(null, format, bundle, null).executeAndWait().graphObject;
                AtomicBoolean atomicBoolean = isAppIndexingEnabled;
                if (jSONObject == null || !jSONObject.optBoolean("is_app_indexing_enabled", false)) {
                    z = false;
                }
                atomicBoolean.set(z);
                if (!isAppIndexingEnabled.get()) {
                    deviceSessionID = null;
                } else {
                    ViewIndexer viewIndexer2 = viewIndexer;
                    if (viewIndexer2 != null) {
                        viewIndexer2.schedule();
                    }
                }
                isCheckingSession = false;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public static final String getCurrentDeviceSessionID$facebook_core_release() {
        Class<CodelessManager> cls = CodelessManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            if (deviceSessionID == null) {
                deviceSessionID = UUID.randomUUID().toString();
            }
            String str = deviceSessionID;
            if (str != null) {
                return str;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0039 A[Catch:{ all -> 0x0032, all -> 0x0044 }] */
    /* renamed from: onActivityResumed$lambda-0  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m162onActivityResumed$lambda0(com.facebook.internal.FetchedAppSettings r5, java.lang.String r6) {
        /*
            java.lang.Class<com.facebook.appevents.codeless.CodelessManager> r0 = com.facebook.appevents.codeless.CodelessManager.class
            boolean r1 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r0)
            if (r1 == 0) goto L_0x0009
            return
        L_0x0009:
            java.lang.String r1 = "$appId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r1)     // Catch:{ all -> 0x0044 }
            r1 = 1
            r2 = 0
            if (r5 == 0) goto L_0x0018
            boolean r5 = r5.codelessEventsEnabled     // Catch:{ all -> 0x0044 }
            if (r5 == 0) goto L_0x0018
            r5 = 1
            goto L_0x0019
        L_0x0018:
            r5 = 0
        L_0x0019:
            com.facebook.FacebookSdk r3 = com.facebook.FacebookSdk.INSTANCE     // Catch:{ all -> 0x0044 }
            com.facebook.UserSettingsManager r3 = com.facebook.UserSettingsManager.INSTANCE     // Catch:{ all -> 0x0044 }
            java.lang.Class<com.facebook.UserSettingsManager> r3 = com.facebook.UserSettingsManager.class
            boolean r4 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r3)     // Catch:{ all -> 0x0044 }
            if (r4 == 0) goto L_0x0026
            goto L_0x0036
        L_0x0026:
            com.facebook.UserSettingsManager r4 = com.facebook.UserSettingsManager.INSTANCE     // Catch:{ all -> 0x0032 }
            r4.initializeIfNotInitialized()     // Catch:{ all -> 0x0032 }
            com.facebook.UserSettingsManager$UserSetting r4 = com.facebook.UserSettingsManager.codelessSetupEnabled     // Catch:{ all -> 0x0032 }
            boolean r3 = r4.getValue()     // Catch:{ all -> 0x0032 }
            goto L_0x0037
        L_0x0032:
            r4 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r4, r3)     // Catch:{ all -> 0x0044 }
        L_0x0036:
            r3 = 0
        L_0x0037:
            if (r3 != 0) goto L_0x003a
            r1 = 0
        L_0x003a:
            if (r5 == 0) goto L_0x0043
            if (r1 == 0) goto L_0x0043
            com.facebook.appevents.codeless.CodelessManager r5 = INSTANCE     // Catch:{ all -> 0x0044 }
            r5.checkCodelessSession(r6)     // Catch:{ all -> 0x0044 }
        L_0x0043:
            return
        L_0x0044:
            r5 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r5, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.codeless.CodelessManager.m162onActivityResumed$lambda0(com.facebook.internal.FetchedAppSettings, java.lang.String):void");
    }

    public final void checkCodelessSession(String str) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                if (!isCheckingSession) {
                    isCheckingSession = true;
                    FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                    FacebookSdk.getExecutor().execute(new Runnable(str) {
                        public final /* synthetic */ String f$0;

                        {
                            this.f$0 = r1;
                        }

                        public final void run() {
                            CodelessManager.m161checkCodelessSession$lambda1(this.f$0);
                        }
                    });
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }
}
