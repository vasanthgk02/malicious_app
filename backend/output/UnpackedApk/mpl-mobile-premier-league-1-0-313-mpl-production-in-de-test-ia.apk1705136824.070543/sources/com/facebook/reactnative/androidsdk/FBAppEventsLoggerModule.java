package com.facebook.reactnative.androidsdk;

import android.os.Bundle;
import android.preference.PreferenceManager;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AnalyticsUserIDStore;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.AppEventsLogger.Companion;
import com.facebook.appevents.AppEventsLogger.FlushBehavior;
import com.facebook.appevents.AppEventsLoggerImpl;
import com.facebook.appevents.UserDataStore;
import com.facebook.appevents.internal.AutomaticAnalyticsLogger;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.rudderstack.android.sdk.core.RudderTraits;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@ReactModule(name = "FBAppEventsLogger")
public class FBAppEventsLoggerModule extends ReactContextBaseJavaModule {
    public static final String NAME = "FBAppEventsLogger";
    public AppEventsLogger mAppEventLogger;
    public AttributionIdentifiers mAttributionIdentifiers;
    public ReactApplicationContext mReactContext;

    public FBAppEventsLoggerModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mReactContext = reactApplicationContext;
    }

    private String getNullableString(ReadableMap readableMap, String str) {
        if (readableMap.hasKey(str)) {
            return readableMap.getString(str);
        }
        return null;
    }

    @ReactMethod
    public void flush() {
        this.mAppEventLogger.loggerImpl.flush();
    }

    @ReactMethod
    public void getAdvertiserID(Promise promise) {
        try {
            promise.resolve(this.mAttributionIdentifiers.getAndroidAdvertiserId());
        } catch (Exception e2) {
            promise.reject((String) "E_ADVERTISER_ID_ERROR", (String) "Can not get advertiserID", (Throwable) e2);
        }
    }

    @ReactMethod
    public void getAnonymousID(Promise promise) {
        try {
            promise.resolve(Companion.getAnonymousAppDeviceGUID(this.mReactContext));
        } catch (Exception e2) {
            promise.reject((String) "E_ANONYMOUS_ID_ERROR", (String) "Can not get anonymousID", (Throwable) e2);
        }
    }

    @ReactMethod
    public void getAttributionID(Promise promise) {
        try {
            promise.resolve(this.mAttributionIdentifiers.attributionId);
        } catch (Exception e2) {
            promise.reject((String) "E_ATTRIBUTION_ID_ERROR", (String) "Can not get attributionID", (Throwable) e2);
        }
    }

    public String getName() {
        return NAME;
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public String getUserID() {
        return Companion.getUserID();
    }

    public void initialize() {
        ReactApplicationContext reactApplicationContext = this.mReactContext;
        Intrinsics.checkNotNullParameter(reactApplicationContext, "context");
        this.mAppEventLogger = new AppEventsLogger(reactApplicationContext, null, null, null);
        this.mAttributionIdentifiers = AttributionIdentifiers.Companion.getAttributionIdentifiers(this.mReactContext);
    }

    @ReactMethod
    public void logEvent(String str, double d2, ReadableMap readableMap) {
        AppEventsLogger appEventsLogger = this.mAppEventLogger;
        appEventsLogger.loggerImpl.logEvent(str, d2, Arguments.toBundle(readableMap));
    }

    @ReactMethod
    public void logPurchase(double d2, String str, ReadableMap readableMap) {
        AppEventsLogger appEventsLogger = this.mAppEventLogger;
        BigDecimal valueOf = BigDecimal.valueOf(d2);
        Currency instance = Currency.getInstance(str);
        Bundle bundle = Arguments.toBundle(readableMap);
        AppEventsLoggerImpl appEventsLoggerImpl = appEventsLogger.loggerImpl;
        if (appEventsLoggerImpl == null) {
            throw null;
        } else if (!CrashShieldHandler.isObjectCrashing(appEventsLoggerImpl)) {
            try {
                AutomaticAnalyticsLogger automaticAnalyticsLogger = AutomaticAnalyticsLogger.INSTANCE;
                AutomaticAnalyticsLogger.isImplicitPurchaseLoggingEnabled();
                appEventsLoggerImpl.logPurchase(valueOf, instance, bundle, false);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, appEventsLoggerImpl);
            }
        }
    }

    @ReactMethod
    public void logPushNotificationOpen(ReadableMap readableMap) {
        AppEventsLogger appEventsLogger = this.mAppEventLogger;
        Bundle bundle = Arguments.toBundle(readableMap);
        String str = null;
        if (appEventsLogger != null) {
            Intrinsics.checkNotNullParameter(bundle, "payload");
            AppEventsLoggerImpl appEventsLoggerImpl = appEventsLogger.loggerImpl;
            if (appEventsLoggerImpl == null) {
                throw null;
            } else if (!CrashShieldHandler.isObjectCrashing(appEventsLoggerImpl)) {
                try {
                    Intrinsics.checkNotNullParameter(bundle, "payload");
                    try {
                        String string = bundle.getString("fb_push_payload");
                        if (!Utility.isNullOrEmpty(string)) {
                            str = new JSONObject(string).getString("campaign");
                            if (str == null) {
                                Logger.Companion.log(LoggingBehavior.DEVELOPER_ERRORS, AppEventsLoggerImpl.TAG, "Malformed payload specified for logging a push notification open.");
                                return;
                            }
                            Bundle bundle2 = new Bundle();
                            bundle2.putString("fb_push_campaign", str);
                            appEventsLoggerImpl.logEvent("fb_mobile_push_opened", bundle2);
                        }
                    } catch (JSONException unused) {
                    }
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, appEventsLoggerImpl);
                }
            }
        } else {
            throw null;
        }
    }

    @ReactMethod
    public void setFlushBehavior(String str) {
        FlushBehavior valueOf = FlushBehavior.valueOf(str.toUpperCase());
        Intrinsics.checkNotNullParameter(valueOf, "flushBehavior");
        AppEventsLoggerImpl.Companion companion = AppEventsLoggerImpl.Companion;
        Intrinsics.checkNotNullParameter(valueOf, "flushBehavior");
        synchronized (AppEventsLoggerImpl.access$getStaticLock$cp()) {
            AppEventsLoggerImpl.Companion companion2 = AppEventsLoggerImpl.Companion;
            Class<AppEventsLoggerImpl> cls = AppEventsLoggerImpl.class;
            if (!CrashShieldHandler.isObjectCrashing(cls)) {
                try {
                    AppEventsLoggerImpl.flushBehaviorField = valueOf;
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, cls);
                }
            }
        }
        return;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x001b A[Catch:{ all -> 0x0043 }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0027 A[ADDED_TO_REGION, Catch:{ all -> 0x0043 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0035 A[Catch:{ all -> 0x0043 }] */
    @com.facebook.react.bridge.ReactMethod
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setPushNotificationsRegistrationId(java.lang.String r7) {
        /*
            r6 = this;
            com.facebook.appevents.AppEventsLoggerImpl$Companion r0 = com.facebook.appevents.AppEventsLoggerImpl.Companion
            java.lang.Object r0 = com.facebook.appevents.AppEventsLoggerImpl.access$getStaticLock$cp()
            monitor-enter(r0)
            java.lang.String r1 = com.facebook.appevents.AppEventsLoggerImpl.access$getPushNotificationsRegistrationIdField$cp()     // Catch:{ all -> 0x0073 }
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x0018
            int r4 = r1.length()     // Catch:{ all -> 0x0073 }
            if (r4 != 0) goto L_0x0016
            goto L_0x0018
        L_0x0016:
            r4 = 0
            goto L_0x0019
        L_0x0018:
            r4 = 1
        L_0x0019:
            if (r7 == 0) goto L_0x0024
            int r5 = r7.length()     // Catch:{ all -> 0x0073 }
            if (r5 != 0) goto L_0x0022
            goto L_0x0024
        L_0x0022:
            r5 = 0
            goto L_0x0025
        L_0x0024:
            r5 = 1
        L_0x0025:
            if (r4 == 0) goto L_0x002b
            if (r5 == 0) goto L_0x002b
            r2 = 1
            goto L_0x0033
        L_0x002b:
            if (r4 != 0) goto L_0x0033
            if (r5 != 0) goto L_0x0033
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r7)     // Catch:{ all -> 0x0073 }
        L_0x0033:
            if (r2 != 0) goto L_0x0071
            com.facebook.appevents.AppEventsLoggerImpl$Companion r1 = com.facebook.appevents.AppEventsLoggerImpl.Companion     // Catch:{ all -> 0x0073 }
            java.lang.Class<com.facebook.appevents.AppEventsLoggerImpl> r1 = com.facebook.appevents.AppEventsLoggerImpl.class
            boolean r2 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r1)     // Catch:{ all -> 0x0073 }
            if (r2 == 0) goto L_0x0040
            goto L_0x0047
        L_0x0040:
            com.facebook.appevents.AppEventsLoggerImpl.pushNotificationsRegistrationIdField = r7     // Catch:{ all -> 0x0043 }
            goto L_0x0047
        L_0x0043:
            r7 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r7, r1)     // Catch:{ all -> 0x0073 }
        L_0x0047:
            com.facebook.appevents.AppEventsLoggerImpl r7 = new com.facebook.appevents.AppEventsLoggerImpl     // Catch:{ all -> 0x0073 }
            com.facebook.FacebookSdk r1 = com.facebook.FacebookSdk.INSTANCE     // Catch:{ all -> 0x0073 }
            android.content.Context r1 = com.facebook.FacebookSdk.getApplicationContext()     // Catch:{ all -> 0x0073 }
            r2 = 0
            r7.<init>(r1, r2, r2)     // Catch:{ all -> 0x0073 }
            java.lang.String r1 = "fb_mobile_obtain_push_token"
            boolean r3 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r7)     // Catch:{ all -> 0x0073 }
            if (r3 == 0) goto L_0x005c
            goto L_0x0064
        L_0x005c:
            r7.logEvent(r1, r2)     // Catch:{ all -> 0x0060 }
            goto L_0x0064
        L_0x0060:
            r1 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r1, r7)     // Catch:{ all -> 0x0073 }
        L_0x0064:
            com.facebook.appevents.AppEventsLoggerImpl$Companion r1 = com.facebook.appevents.AppEventsLoggerImpl.Companion     // Catch:{ all -> 0x0073 }
            com.facebook.appevents.AppEventsLogger$FlushBehavior r1 = r1.getFlushBehavior()     // Catch:{ all -> 0x0073 }
            com.facebook.appevents.AppEventsLogger$FlushBehavior r2 = com.facebook.appevents.AppEventsLogger.FlushBehavior.EXPLICIT_ONLY     // Catch:{ all -> 0x0073 }
            if (r1 == r2) goto L_0x0071
            r7.flush()     // Catch:{ all -> 0x0073 }
        L_0x0071:
            monitor-exit(r0)
            return
        L_0x0073:
            r7 = move-exception
            monitor-exit(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.reactnative.androidsdk.FBAppEventsLoggerModule.setPushNotificationsRegistrationId(java.lang.String):void");
    }

    @ReactMethod
    public void setUserData(ReadableMap readableMap) {
        String nullableString = getNullableString(readableMap, "email");
        String nullableString2 = getNullableString(readableMap, "firstName");
        String nullableString3 = getNullableString(readableMap, "lastName");
        String nullableString4 = getNullableString(readableMap, "phone");
        String nullableString5 = getNullableString(readableMap, "dateOfBirth");
        String nullableString6 = getNullableString(readableMap, RudderTraits.GENDER_KEY);
        String nullableString7 = getNullableString(readableMap, "city");
        String nullableString8 = getNullableString(readableMap, "state");
        String nullableString9 = getNullableString(readableMap, "zip");
        String nullableString10 = getNullableString(readableMap, "country");
        UserDataStore userDataStore = UserDataStore.INSTANCE;
        Class<UserDataStore> cls = UserDataStore.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Bundle bundle = new Bundle();
                if (nullableString != null) {
                    bundle.putString("em", nullableString);
                }
                if (nullableString2 != null) {
                    bundle.putString("fn", nullableString2);
                }
                if (nullableString3 != null) {
                    bundle.putString("ln", nullableString3);
                }
                if (nullableString4 != null) {
                    bundle.putString("ph", nullableString4);
                }
                if (nullableString5 != null) {
                    bundle.putString("db", nullableString5);
                }
                if (nullableString6 != null) {
                    bundle.putString("ge", nullableString6);
                }
                if (nullableString7 != null) {
                    bundle.putString("ct", nullableString7);
                }
                if (nullableString8 != null) {
                    bundle.putString("st", nullableString8);
                }
                if (nullableString9 != null) {
                    bundle.putString("zp", nullableString9);
                }
                if (nullableString10 != null) {
                    bundle.putString("country", nullableString10);
                }
                UserDataStore.setUserDataAndHash(bundle);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    @ReactMethod
    public void setUserID(String str) {
        AnalyticsUserIDStore analyticsUserIDStore = AnalyticsUserIDStore.INSTANCE;
        if (!AnalyticsUserIDStore.initialized && !AnalyticsUserIDStore.initialized) {
            AnalyticsUserIDStore.lock.writeLock().lock();
            try {
                if (!AnalyticsUserIDStore.initialized) {
                    FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                    AnalyticsUserIDStore.userID = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).getString("com.facebook.appevents.AnalyticsUserIDStore.userID", null);
                    AnalyticsUserIDStore.initialized = true;
                }
            } finally {
                AnalyticsUserIDStore.lock.writeLock().unlock();
            }
        }
        AppEventsLoggerImpl.Companion companion = AppEventsLoggerImpl.Companion;
        if (AppEventsLoggerImpl.access$getBackgroundExecutor$cp() == null) {
            companion.initializeTimersIfNeeded();
        }
        ScheduledThreadPoolExecutor access$getBackgroundExecutor$cp = AppEventsLoggerImpl.access$getBackgroundExecutor$cp();
        if (access$getBackgroundExecutor$cp != null) {
            access$getBackgroundExecutor$cp.execute(new Runnable(str) {
                public final /* synthetic */ String f$0;

                {
                    this.f$0 = r1;
                }

                public final void run() {
                    AnalyticsUserIDStore.m138setUserID$lambda1(this.f$0);
                }
            });
            return;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    @ReactMethod
    public void updateUserProperties(ReadableMap readableMap) {
        AppEventsLogger.updateUserProperties(Arguments.toBundle(readableMap), null);
    }
}
