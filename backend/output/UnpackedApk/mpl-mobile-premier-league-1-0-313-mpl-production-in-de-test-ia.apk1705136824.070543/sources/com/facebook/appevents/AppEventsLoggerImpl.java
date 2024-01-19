package com.facebook.appevents;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.ReferrerDetails;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsLogger.FlushBehavior;
import com.facebook.appevents.internal.ActivityLifecycleTracker;
import com.facebook.internal.FetchedAppGateKeepersManager;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.InstallReferrerUtil$tryConnectReferrerInfo$installReferrerStateListener$1;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0001\u0018\u0000 :2\u00020\u0001:\u0001:B%\b\u0010\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB#\b\u0000\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\nJ\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005J\u001c\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0018\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0018\u001a\u00020\u0019J\"\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J;\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001a\u001a\u00020\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\u0002\u0010\u001dJ\u001a\u0010\u001e\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u0005J.\u0010 \u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J)\u0010 \u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0002\u0010%J\u0001\u0010&\u001a\u00020\u00112\b\u0010'\u001a\u0004\u0018\u00010\u00052\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010,\u001a\u0004\u0018\u00010\u00052\b\u0010-\u001a\u0004\u0018\u00010\u00052\b\u0010.\u001a\u0004\u0018\u00010\u00052\b\u0010/\u001a\u0004\u0018\u00010\u00052\b\u00100\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u00101\u001a\u0004\u0018\u00010\u00052\b\u00102\u001a\u0004\u0018\u00010\u00052\b\u00103\u001a\u0004\u0018\u00010\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u001a\u00104\u001a\u00020\u00112\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$J&\u00104\u001a\u00020\u00112\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017J,\u00104\u001a\u00020\u00112\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001a\u001a\u00020\u0013J$\u00105\u001a\u00020\u00112\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0018\u00106\u001a\u00020\u00112\u0006\u00107\u001a\u00020\u00172\b\u00108\u001a\u0004\u0018\u00010\u0005J'\u00109\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0002\u0010%R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/facebook/appevents/AppEventsLoggerImpl;", "", "context", "Landroid/content/Context;", "applicationId", "", "accessToken", "Lcom/facebook/AccessToken;", "(Landroid/content/Context;Ljava/lang/String;Lcom/facebook/AccessToken;)V", "activityName", "(Ljava/lang/String;Ljava/lang/String;Lcom/facebook/AccessToken;)V", "accessTokenAppId", "Lcom/facebook/appevents/AccessTokenAppIdPair;", "getApplicationId", "()Ljava/lang/String;", "contextName", "flush", "", "isValidForAccessToken", "", "logEvent", "eventName", "parameters", "Landroid/os/Bundle;", "valueToSum", "", "isImplicitlyLogged", "currentSessionId", "Ljava/util/UUID;", "(Ljava/lang/String;Ljava/lang/Double;Landroid/os/Bundle;ZLjava/util/UUID;)V", "logEventFromSE", "buttonText", "logEventImplicitly", "purchaseAmount", "Ljava/math/BigDecimal;", "currency", "Ljava/util/Currency;", "(Ljava/lang/String;Ljava/lang/Double;Landroid/os/Bundle;)V", "logProductItem", "itemID", "availability", "Lcom/facebook/appevents/AppEventsLogger$ProductAvailability;", "condition", "Lcom/facebook/appevents/AppEventsLogger$ProductCondition;", "description", "imageLink", "link", "title", "priceAmount", "gtin", "mpn", "brand", "logPurchase", "logPurchaseImplicitly", "logPushNotificationOpen", "payload", "action", "logSdkEvent", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: AppEventsLoggerImpl.kt */
public final class AppEventsLoggerImpl {
    public static final Companion Companion = new Companion(null);
    public static final String TAG;
    public static String anonymousAppDeviceGUID;
    public static ScheduledThreadPoolExecutor backgroundExecutor;
    public static FlushBehavior flushBehaviorField = FlushBehavior.AUTO;
    public static boolean isActivateAppEventRequested;
    public static String pushNotificationsRegistrationIdField;
    public static final Object staticLock = new Object();
    public AccessTokenAppIdPair accessTokenAppId;
    public final String contextName;

    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004H\u0007J\u001a\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0007J\u0006\u0010\"\u001a\u00020\u0019J\u0010\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u0004H\u0007J\b\u0010%\u001a\u00020&H\u0007J\u0010\u0010'\u001a\u00020\u00042\u0006\u0010 \u001a\u00020!H\u0007J\b\u0010(\u001a\u00020\u0013H\u0007J\n\u0010)\u001a\u0004\u0018\u00010\u0004H\u0007J\n\u0010*\u001a\u0004\u0018\u00010\u0004H\u0007J\u001a\u0010+\u001a\u00020\u00192\u0006\u0010 \u001a\u00020!2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004H\u0007J\b\u0010,\u001a\u00020\u0019H\u0002J\u0018\u0010-\u001a\u00020\u00192\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0002J\u0010\u00102\u001a\u00020\u00192\u0006\u00103\u001a\u00020\u0004H\u0002J\b\u00104\u001a\u00020\u0019H\u0007J\u0010\u00105\u001a\u00020\u00192\u0006\u00106\u001a\u00020\u0013H\u0007J\u0012\u00107\u001a\u00020\u00192\b\u00108\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u00109\u001a\u00020\u00192\b\u0010:\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/facebook/appevents/AppEventsLoggerImpl$Companion;", "", "()V", "ACCOUNT_KIT_EVENT_NAME_PREFIX", "", "APP_EVENTS_KILLSWITCH", "APP_EVENT_NAME_PUSH_OPENED", "APP_EVENT_PREFERENCES", "APP_EVENT_PUSH_PARAMETER_ACTION", "APP_EVENT_PUSH_PARAMETER_CAMPAIGN", "APP_SUPPORTS_ATTRIBUTION_ID_RECHECK_PERIOD_IN_SECONDS", "", "PUSH_PAYLOAD_CAMPAIGN_KEY", "PUSH_PAYLOAD_KEY", "TAG", "anonymousAppDeviceGUID", "backgroundExecutor", "Ljava/util/concurrent/ScheduledThreadPoolExecutor;", "flushBehaviorField", "Lcom/facebook/appevents/AppEventsLogger$FlushBehavior;", "isActivateAppEventRequested", "", "pushNotificationsRegistrationIdField", "staticLock", "activateApp", "", "application", "Landroid/app/Application;", "applicationId", "augmentWebView", "webView", "Landroid/webkit/WebView;", "context", "Landroid/content/Context;", "eagerFlush", "functionDEPRECATED", "extraMsg", "getAnalyticsExecutor", "Ljava/util/concurrent/Executor;", "getAnonymousAppDeviceGUID", "getFlushBehavior", "getInstallReferrer", "getPushNotificationsRegistrationId", "initializeLib", "initializeTimersIfNeeded", "logEvent", "event", "Lcom/facebook/appevents/AppEvent;", "accessTokenAppId", "Lcom/facebook/appevents/AccessTokenAppIdPair;", "notifyDeveloperError", "message", "onContextStop", "setFlushBehavior", "flushBehavior", "setInstallReferrer", "referrer", "setPushNotificationsRegistrationId", "registrationId", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: AppEventsLoggerImpl.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* JADX WARNING: Removed duplicated region for block: B:34:0x007b A[Catch:{ all -> 0x0074, all -> 0x008a }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static final void access$logEvent(com.facebook.appevents.AppEventsLoggerImpl.Companion r6, com.facebook.appevents.AppEvent r7, com.facebook.appevents.AccessTokenAppIdPair r8) {
            /*
                java.lang.Class<com.facebook.appevents.AppEventsLoggerImpl> r6 = com.facebook.appevents.AppEventsLoggerImpl.class
                com.facebook.appevents.AppEventQueue r0 = com.facebook.appevents.AppEventQueue.INSTANCE
                java.lang.Class<com.facebook.appevents.AppEventQueue> r0 = com.facebook.appevents.AppEventQueue.class
                boolean r1 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r0)
                if (r1 == 0) goto L_0x000d
                goto L_0x0026
            L_0x000d:
                java.lang.String r1 = "accessTokenAppId"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r1)     // Catch:{ all -> 0x0022 }
                java.lang.String r1 = "appEvent"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r1)     // Catch:{ all -> 0x0022 }
                java.util.concurrent.ScheduledExecutorService r1 = com.facebook.appevents.AppEventQueue.singleThreadExecutor     // Catch:{ all -> 0x0022 }
                com.facebook.appevents.-$$Lambda$NwzIDb30a3_Edt_Ctpc0yU_l8sg r2 = new com.facebook.appevents.-$$Lambda$NwzIDb30a3_Edt_Ctpc0yU_l8sg     // Catch:{ all -> 0x0022 }
                r2.<init>(r7)     // Catch:{ all -> 0x0022 }
                r1.execute(r2)     // Catch:{ all -> 0x0022 }
                goto L_0x0026
            L_0x0022:
                r1 = move-exception
                com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r1, r0)
            L_0x0026:
                com.facebook.internal.FeatureManager r0 = com.facebook.internal.FeatureManager.INSTANCE
                com.facebook.internal.FeatureManager$Feature r0 = com.facebook.internal.FeatureManager.Feature.OnDevicePostInstallEventProcessing
                boolean r0 = com.facebook.internal.FeatureManager.isEnabled(r0)
                r1 = 0
                r2 = 1
                if (r0 == 0) goto L_0x008e
                com.facebook.appevents.ondeviceprocessing.OnDeviceProcessingManager r0 = com.facebook.appevents.ondeviceprocessing.OnDeviceProcessingManager.INSTANCE
                boolean r0 = com.facebook.appevents.ondeviceprocessing.OnDeviceProcessingManager.isOnDeviceProcessingEnabled()
                if (r0 == 0) goto L_0x008e
                com.facebook.appevents.ondeviceprocessing.OnDeviceProcessingManager r0 = com.facebook.appevents.ondeviceprocessing.OnDeviceProcessingManager.INSTANCE
                java.lang.String r8 = r8.applicationId
                java.lang.Class<com.facebook.appevents.ondeviceprocessing.OnDeviceProcessingManager> r0 = com.facebook.appevents.ondeviceprocessing.OnDeviceProcessingManager.class
                boolean r3 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r0)
                if (r3 == 0) goto L_0x0047
                goto L_0x008e
            L_0x0047:
                java.lang.String r3 = "applicationId"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r3)     // Catch:{ all -> 0x008a }
                java.lang.String r3 = "event"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r3)     // Catch:{ all -> 0x008a }
                com.facebook.appevents.ondeviceprocessing.OnDeviceProcessingManager r3 = com.facebook.appevents.ondeviceprocessing.OnDeviceProcessingManager.INSTANCE     // Catch:{ all -> 0x008a }
                boolean r4 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r3)     // Catch:{ all -> 0x008a }
                if (r4 == 0) goto L_0x005a
                goto L_0x0078
            L_0x005a:
                boolean r4 = r7.isImplicit     // Catch:{ all -> 0x0074 }
                if (r4 == 0) goto L_0x006a
                java.util.Set<java.lang.String> r4 = com.facebook.appevents.ondeviceprocessing.OnDeviceProcessingManager.ALLOWED_IMPLICIT_EVENTS     // Catch:{ all -> 0x0074 }
                java.lang.String r5 = r7.name     // Catch:{ all -> 0x0074 }
                boolean r4 = r4.contains(r5)     // Catch:{ all -> 0x0074 }
                if (r4 == 0) goto L_0x006a
                r4 = 1
                goto L_0x006b
            L_0x006a:
                r4 = 0
            L_0x006b:
                boolean r3 = r7.isImplicit     // Catch:{ all -> 0x0074 }
                r3 = r3 ^ r2
                if (r3 != 0) goto L_0x0072
                if (r4 == 0) goto L_0x0078
            L_0x0072:
                r3 = 1
                goto L_0x0079
            L_0x0074:
                r4 = move-exception
                com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r4, r3)     // Catch:{ all -> 0x008a }
            L_0x0078:
                r3 = 0
            L_0x0079:
                if (r3 == 0) goto L_0x008e
                com.facebook.FacebookSdk r3 = com.facebook.FacebookSdk.INSTANCE     // Catch:{ all -> 0x008a }
                java.util.concurrent.Executor r3 = com.facebook.FacebookSdk.getExecutor()     // Catch:{ all -> 0x008a }
                com.facebook.appevents.ondeviceprocessing.-$$Lambda$6zAc79UpPGdEEZiXgVsq7HYMOsM r4 = new com.facebook.appevents.ondeviceprocessing.-$$Lambda$6zAc79UpPGdEEZiXgVsq7HYMOsM     // Catch:{ all -> 0x008a }
                r4.<init>(r8, r7)     // Catch:{ all -> 0x008a }
                r3.execute(r4)     // Catch:{ all -> 0x008a }
                goto L_0x008e
            L_0x008a:
                r8 = move-exception
                com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r8, r0)
            L_0x008e:
                boolean r8 = r7.isImplicit
                if (r8 != 0) goto L_0x00c6
                boolean r8 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r6)
                if (r8 == 0) goto L_0x0099
                goto L_0x00a0
            L_0x0099:
                boolean r1 = com.facebook.appevents.AppEventsLoggerImpl.isActivateAppEventRequested     // Catch:{ all -> 0x009c }
                goto L_0x00a0
            L_0x009c:
                r8 = move-exception
                com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r8, r6)
            L_0x00a0:
                if (r1 != 0) goto L_0x00c6
                java.lang.String r7 = r7.name
                java.lang.String r8 = "fb_mobile_activate_app"
                boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual(r7, r8)
                if (r7 == 0) goto L_0x00bb
                boolean r7 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r6)
                if (r7 == 0) goto L_0x00b3
                goto L_0x00c6
            L_0x00b3:
                com.facebook.appevents.AppEventsLoggerImpl.isActivateAppEventRequested = r2     // Catch:{ all -> 0x00b6 }
                goto L_0x00c6
            L_0x00b6:
                r7 = move-exception
                com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r7, r6)
                goto L_0x00c6
            L_0x00bb:
                com.facebook.internal.Logger$Companion r6 = com.facebook.internal.Logger.Companion
                com.facebook.LoggingBehavior r7 = com.facebook.LoggingBehavior.APP_EVENTS
                java.lang.String r8 = "AppEvents"
                java.lang.String r0 = "Warning: Please call AppEventsLogger.activateApp(...)from the long-lived activity's onResume() methodbefore logging other app events."
                r6.log(r7, r8, r0)
            L_0x00c6:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.AppEventsLoggerImpl.Companion.access$logEvent(com.facebook.appevents.AppEventsLoggerImpl$Companion, com.facebook.appevents.AppEvent, com.facebook.appevents.AccessTokenAppIdPair):void");
        }

        /* renamed from: initializeLib$lambda-4  reason: not valid java name */
        public static final void m145initializeLib$lambda4(Context context, AppEventsLoggerImpl appEventsLoggerImpl) {
            Intrinsics.checkNotNullParameter(context, "$context");
            Intrinsics.checkNotNullParameter(appEventsLoggerImpl, "$logger");
            Bundle bundle = new Bundle();
            String[] strArr = {"com.facebook.core.Core", "com.facebook.login.Login", "com.facebook.share.Share", "com.facebook.places.Places", "com.facebook.messenger.Messenger", "com.facebook.applinks.AppLinks", "com.facebook.marketing.Marketing", "com.facebook.gamingservices.GamingServices", "com.facebook.all.All", "com.android.billingclient.api.BillingClient", "com.android.vending.billing.IInAppBillingService"};
            String[] strArr2 = {"core_lib_included", "login_lib_included", "share_lib_included", "places_lib_included", "messenger_lib_included", "applinks_lib_included", "marketing_lib_included", "gamingservices_lib_included", "all_lib_included", "billing_client_lib_included", "billing_service_lib_included"};
            int i = 0;
            int i2 = 0;
            while (true) {
                int i3 = i + 1;
                String str = strArr[i];
                String str2 = strArr2[i];
                try {
                    Class.forName(str);
                    bundle.putInt(str2, 1);
                    i2 |= 1 << i;
                } catch (ClassNotFoundException unused) {
                }
                if (i3 > 10) {
                    break;
                }
                i = i3;
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0);
            if (sharedPreferences.getInt("kitsBitmask", 0) != i2) {
                sharedPreferences.edit().putInt("kitsBitmask", i2).apply();
                appEventsLoggerImpl.logEventImplicitly("fb_sdk_initialize", null, bundle);
            }
        }

        /* renamed from: initializeTimersIfNeeded$lambda-6  reason: not valid java name */
        public static final void m146initializeTimersIfNeeded$lambda6() {
            HashSet<String> hashSet = new HashSet<>();
            AppEventQueue appEventQueue = AppEventQueue.INSTANCE;
            Class<AppEventQueue> cls = AppEventQueue.class;
            Set<AccessTokenAppIdPair> set = null;
            if (!CrashShieldHandler.isObjectCrashing(cls)) {
                try {
                    set = AppEventQueue.appEventCollection.keySet();
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, cls);
                }
            }
            for (AccessTokenAppIdPair accessTokenAppIdPair : set) {
                hashSet.add(accessTokenAppIdPair.applicationId);
            }
            for (String queryAppSettings : hashSet) {
                FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
                FetchedAppSettingsManager.queryAppSettings(queryAppSettings, true);
            }
        }

        public final FlushBehavior getFlushBehavior() {
            FlushBehavior flushBehavior;
            synchronized (AppEventsLoggerImpl.access$getStaticLock$cp()) {
                Class<AppEventsLoggerImpl> cls = AppEventsLoggerImpl.class;
                flushBehavior = null;
                if (!CrashShieldHandler.isObjectCrashing(cls)) {
                    try {
                        flushBehavior = AppEventsLoggerImpl.flushBehaviorField;
                    } catch (Throwable th) {
                        CrashShieldHandler.handleThrowable(th, cls);
                    }
                }
            }
            return flushBehavior;
        }

        public final String getInstallReferrer() {
            AppEventsLoggerImpl$Companion$getInstallReferrer$1 appEventsLoggerImpl$Companion$getInstallReferrer$1 = new AppEventsLoggerImpl$Companion$getInstallReferrer$1();
            Intrinsics.checkNotNullParameter(appEventsLoggerImpl$Companion$getInstallReferrer$1, "callback");
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            if (!FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).getBoolean("is_referrer_updated", false)) {
                FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
                InstallReferrerClient build = InstallReferrerClient.newBuilder(FacebookSdk.getApplicationContext()).build();
                try {
                    build.startConnection(new InstallReferrerUtil$tryConnectReferrerInfo$installReferrerStateListener$1(build, appEventsLoggerImpl$Companion$getInstallReferrer$1));
                } catch (Exception unused) {
                }
            }
            FacebookSdk facebookSdk3 = FacebookSdk.INSTANCE;
            return FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).getString(ReferrerDetails.KEY_INSTALL_REFERRER, null);
        }

        public final void initializeTimersIfNeeded() {
            synchronized (AppEventsLoggerImpl.access$getStaticLock$cp()) {
                if (AppEventsLoggerImpl.access$getBackgroundExecutor$cp() == null) {
                    Companion companion = AppEventsLoggerImpl.Companion;
                    ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
                    Class<AppEventsLoggerImpl> cls = AppEventsLoggerImpl.class;
                    if (!CrashShieldHandler.isObjectCrashing(cls)) {
                        try {
                            AppEventsLoggerImpl.backgroundExecutor = scheduledThreadPoolExecutor;
                        } catch (Throwable th) {
                            CrashShieldHandler.handleThrowable(th, cls);
                        }
                    }
                } else {
                    return;
                }
            }
            $$Lambda$BVyOVuKsFeL5r9hStsFJI8nPs r4 = $$Lambda$BVyOVuKsFeL5r9hStsFJI8nPs.INSTANCE;
            ScheduledThreadPoolExecutor access$getBackgroundExecutor$cp = AppEventsLoggerImpl.access$getBackgroundExecutor$cp();
            if (access$getBackgroundExecutor$cp != null) {
                access$getBackgroundExecutor$cp.scheduleAtFixedRate(r4, 0, 86400, TimeUnit.SECONDS);
                return;
            }
            throw new IllegalStateException("Required value was null.".toString());
        }
    }

    static {
        String canonicalName = AppEventsLoggerImpl.class.getCanonicalName();
        if (canonicalName == null) {
            canonicalName = "com.facebook.appevents.AppEventsLoggerImpl";
        }
        TAG = canonicalName;
    }

    public AppEventsLoggerImpl(String str, String str2, AccessToken accessToken) {
        Intrinsics.checkNotNullParameter(str, "activityName");
        Validate.sdkInitialized();
        this.contextName = str;
        if (accessToken == null) {
            com.facebook.AccessToken.Companion companion = AccessToken.Companion;
            accessToken = com.facebook.AccessToken.Companion.getCurrentAccessToken();
        }
        if (accessToken == null || accessToken.isExpired() || (str2 != null && !Intrinsics.areEqual(str2, accessToken.applicationId))) {
            if (str2 == null) {
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                str2 = Utility.getMetadataApplicationId(FacebookSdk.getApplicationContext());
            }
            this.accessTokenAppId = new AccessTokenAppIdPair(null, str2);
        } else {
            Intrinsics.checkNotNullParameter(accessToken, "accessToken");
            String str3 = accessToken.token;
            FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
            this.accessTokenAppId = new AccessTokenAppIdPair(str3, FacebookSdk.getApplicationId());
        }
        synchronized (access$getStaticLock$cp()) {
            if (access$getBackgroundExecutor$cp() == null) {
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
                Class<AppEventsLoggerImpl> cls = AppEventsLoggerImpl.class;
                if (!CrashShieldHandler.isObjectCrashing(cls)) {
                    try {
                        backgroundExecutor = scheduledThreadPoolExecutor;
                    } catch (Throwable th) {
                        CrashShieldHandler.handleThrowable(th, cls);
                    }
                }
            } else {
                return;
            }
        }
        $$Lambda$BVyOVuKsFeL5r9hStsFJI8nPs r1 = $$Lambda$BVyOVuKsFeL5r9hStsFJI8nPs.INSTANCE;
        ScheduledThreadPoolExecutor access$getBackgroundExecutor$cp = access$getBackgroundExecutor$cp();
        if (access$getBackgroundExecutor$cp != null) {
            access$getBackgroundExecutor$cp.scheduleAtFixedRate(r1, 0, 86400, TimeUnit.SECONDS);
            return;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public static final /* synthetic */ String access$getAnonymousAppDeviceGUID$cp() {
        Class<AppEventsLoggerImpl> cls = AppEventsLoggerImpl.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return anonymousAppDeviceGUID;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ ScheduledThreadPoolExecutor access$getBackgroundExecutor$cp() {
        Class<AppEventsLoggerImpl> cls = AppEventsLoggerImpl.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return backgroundExecutor;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ String access$getPushNotificationsRegistrationIdField$cp() {
        Class<AppEventsLoggerImpl> cls = AppEventsLoggerImpl.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return pushNotificationsRegistrationIdField;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ Object access$getStaticLock$cp() {
        Class<AppEventsLoggerImpl> cls = AppEventsLoggerImpl.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return staticLock;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public final void flush() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                AppEventQueue appEventQueue = AppEventQueue.INSTANCE;
                AppEventQueue.flush(FlushReason.EXPLICIT);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public final void logEvent(String str, Bundle bundle) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                ActivityLifecycleTracker activityLifecycleTracker = ActivityLifecycleTracker.INSTANCE;
                logEvent(str, null, bundle, false, ActivityLifecycleTracker.getCurrentSessionGuid());
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public final void logEventImplicitly(String str, Double d2, Bundle bundle) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                ActivityLifecycleTracker activityLifecycleTracker = ActivityLifecycleTracker.INSTANCE;
                logEvent(str, d2, bundle, true, ActivityLifecycleTracker.getCurrentSessionGuid());
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public final void logPurchase(BigDecimal bigDecimal, Currency currency, Bundle bundle, boolean z) {
        FlushBehavior flushBehavior;
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            if (bigDecimal == null) {
                try {
                    Logger.Companion.log(LoggingBehavior.DEVELOPER_ERRORS, "AppEvents", "purchaseAmount cannot be null");
                    return;
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, this);
                    return;
                }
            } else if (currency == null) {
                Logger.Companion.log(LoggingBehavior.DEVELOPER_ERRORS, "AppEvents", "currency cannot be null");
                return;
            } else {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                Bundle bundle2 = bundle;
                bundle2.putString("fb_currency", currency.getCurrencyCode());
                Double valueOf = Double.valueOf(bigDecimal.doubleValue());
                ActivityLifecycleTracker activityLifecycleTracker = ActivityLifecycleTracker.INSTANCE;
                logEvent("fb_mobile_purchase", valueOf, bundle2, z, ActivityLifecycleTracker.getCurrentSessionGuid());
                synchronized (access$getStaticLock$cp()) {
                    Class<AppEventsLoggerImpl> cls = AppEventsLoggerImpl.class;
                    flushBehavior = null;
                    if (!CrashShieldHandler.isObjectCrashing(cls)) {
                        try {
                            flushBehavior = flushBehaviorField;
                        } catch (Throwable th2) {
                            CrashShieldHandler.handleThrowable(th2, cls);
                        }
                    }
                }
                if (flushBehavior != FlushBehavior.EXPLICIT_ONLY) {
                    AppEventQueue appEventQueue = AppEventQueue.INSTANCE;
                    AppEventQueue.flush(FlushReason.EAGER_FLUSHING_EVENT);
                }
                return;
            }
        } else {
            return;
        }
    }

    public final void logEvent(String str, double d2, Bundle bundle) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Double valueOf = Double.valueOf(d2);
                ActivityLifecycleTracker activityLifecycleTracker = ActivityLifecycleTracker.INSTANCE;
                logEvent(str, valueOf, bundle, false, ActivityLifecycleTracker.getCurrentSessionGuid());
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public final void logEvent(String str, Double d2, Bundle bundle, boolean z, UUID uuid) {
        if (!CrashShieldHandler.isObjectCrashing(this) && str != null) {
            try {
                if (!(str.length() == 0)) {
                    FetchedAppGateKeepersManager fetchedAppGateKeepersManager = FetchedAppGateKeepersManager.INSTANCE;
                    FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                    if (FetchedAppGateKeepersManager.getGateKeeperForKey("app_events_killswitch", FacebookSdk.getApplicationId(), false)) {
                        Logger.Companion.log(LoggingBehavior.APP_EVENTS, (String) "AppEvents", (String) "KillSwitch is enabled and fail to log app event: %s", str);
                        return;
                    }
                    String str2 = this.contextName;
                    ActivityLifecycleTracker activityLifecycleTracker = ActivityLifecycleTracker.INSTANCE;
                    AppEvent appEvent = new AppEvent(str2, str, d2, bundle, z, ActivityLifecycleTracker.activityReferences == 0, uuid);
                    Companion.access$logEvent(Companion, appEvent, this.accessTokenAppId);
                }
            } catch (JSONException e2) {
                Logger.Companion.log(LoggingBehavior.APP_EVENTS, (String) "AppEvents", (String) "JSON encoding for app event failed: '%s'", e2.toString());
            } catch (FacebookException e3) {
                Logger.Companion.log(LoggingBehavior.APP_EVENTS, (String) "AppEvents", (String) "Invalid app event: %s", e3.toString());
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public AppEventsLoggerImpl(Context context, String str, AccessToken accessToken) {
        this(Utility.getActivityName(context), str, accessToken);
    }
}
