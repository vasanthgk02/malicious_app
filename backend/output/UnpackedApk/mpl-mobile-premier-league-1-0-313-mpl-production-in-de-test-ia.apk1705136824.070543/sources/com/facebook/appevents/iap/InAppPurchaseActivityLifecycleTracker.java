package com.facebook.appevents.iap;

import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.facebook.FacebookSdk;
import com.facebook.appevents.internal.AutomaticAnalyticsLogger;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.razorpay.AnalyticsConstants;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0002J0\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\u0016\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u001bj\b\u0012\u0004\u0012\u00020\u0004`\u001c2\u0006\u0010\u001d\u001a\u00020\u000bH\u0002J\b\u0010\u001e\u001a\u00020\u0016H\u0007J\b\u0010\u001f\u001a\u00020\u0016H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \u0007*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0004\n\u0002\u0010\fR\u0012\u0010\r\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0004\n\u0002\u0010\fR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseActivityLifecycleTracker;", "", "()V", "BILLING_ACTIVITY_NAME", "", "SERVICE_INTERFACE_NAME", "TAG", "kotlin.jvm.PlatformType", "callbacks", "Landroid/app/Application$ActivityLifecycleCallbacks;", "hasBillingActivity", "", "Ljava/lang/Boolean;", "hasBillingService", "inAppBillingObj", "intent", "Landroid/content/Intent;", "isTracking", "Ljava/util/concurrent/atomic/AtomicBoolean;", "serviceConnection", "Landroid/content/ServiceConnection;", "initializeIfNotInitialized", "", "logPurchase", "context", "Landroid/content/Context;", "purchases", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "isSubscription", "startIapLogging", "startTracking", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: InAppPurchaseActivityLifecycleTracker.kt */
public final class InAppPurchaseActivityLifecycleTracker {
    public static final InAppPurchaseActivityLifecycleTracker INSTANCE = new InAppPurchaseActivityLifecycleTracker();
    public static ActivityLifecycleCallbacks callbacks;
    public static Boolean hasBillingActivity;
    public static Boolean hasBillingService;
    public static Object inAppBillingObj;
    public static Intent intent;
    public static final AtomicBoolean isTracking = new AtomicBoolean(false);
    public static ServiceConnection serviceConnection;

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0099  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void access$logPurchase(com.facebook.appevents.iap.InAppPurchaseActivityLifecycleTracker r6, android.content.Context r7, java.util.ArrayList r8, boolean r9) {
        /*
            boolean r6 = r8.isEmpty()
            if (r6 == 0) goto L_0x0008
            goto L_0x00ba
        L_0x0008:
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r8 = r8.iterator()
        L_0x0016:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto L_0x0040
            java.lang.Object r1 = r8.next()
            java.lang.String r1 = (java.lang.String) r1
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x003e }
            r2.<init>(r1)     // Catch:{ JSONException -> 0x003e }
            java.lang.String r3 = "productId"
            java.lang.String r2 = r2.getString(r3)     // Catch:{ JSONException -> 0x003e }
            java.lang.String r3 = "sku"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)     // Catch:{ JSONException -> 0x003e }
            java.lang.String r3 = "purchase"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)     // Catch:{ JSONException -> 0x003e }
            r6.put(r2, r1)     // Catch:{ JSONException -> 0x003e }
            r0.add(r2)     // Catch:{ JSONException -> 0x003e }
            goto L_0x0016
        L_0x003e:
            goto L_0x0016
        L_0x0040:
            com.facebook.appevents.iap.InAppPurchaseEventManager r8 = com.facebook.appevents.iap.InAppPurchaseEventManager.INSTANCE
            java.lang.Object r8 = inAppBillingObj
            java.lang.Class<com.facebook.appevents.iap.InAppPurchaseEventManager> r1 = com.facebook.appevents.iap.InAppPurchaseEventManager.class
            boolean r2 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r1)
            if (r2 == 0) goto L_0x004d
            goto L_0x008a
        L_0x004d:
            java.lang.String r2 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r2)     // Catch:{ all -> 0x0086 }
            java.lang.String r2 = "skuList"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)     // Catch:{ all -> 0x0086 }
            com.facebook.appevents.iap.InAppPurchaseEventManager r2 = com.facebook.appevents.iap.InAppPurchaseEventManager.INSTANCE     // Catch:{ all -> 0x0086 }
            java.util.Map r2 = r2.readSkuDetailsFromCache(r0)     // Catch:{ all -> 0x0086 }
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x0086 }
            r3.<init>()     // Catch:{ all -> 0x0086 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0086 }
        L_0x0066:
            boolean r4 = r0.hasNext()     // Catch:{ all -> 0x0086 }
            if (r4 == 0) goto L_0x007c
            java.lang.Object r4 = r0.next()     // Catch:{ all -> 0x0086 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x0086 }
            boolean r5 = r2.containsKey(r4)     // Catch:{ all -> 0x0086 }
            if (r5 != 0) goto L_0x0066
            r3.add(r4)     // Catch:{ all -> 0x0086 }
            goto L_0x0066
        L_0x007c:
            com.facebook.appevents.iap.InAppPurchaseEventManager r0 = com.facebook.appevents.iap.InAppPurchaseEventManager.INSTANCE     // Catch:{ all -> 0x0086 }
            java.util.Map r7 = r0.getSkuDetailsFromGoogle(r7, r3, r8, r9)     // Catch:{ all -> 0x0086 }
            r2.putAll(r7)     // Catch:{ all -> 0x0086 }
            goto L_0x008b
        L_0x0086:
            r7 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r7, r1)
        L_0x008a:
            r2 = 0
        L_0x008b:
            java.util.Set r7 = r2.entrySet()
            java.util.Iterator r7 = r7.iterator()
        L_0x0093:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x00ba
            java.lang.Object r8 = r7.next()
            java.util.Map$Entry r8 = (java.util.Map.Entry) r8
            java.lang.Object r0 = r8.getKey()
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r8 = r8.getValue()
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r0 = r6.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x00b4
            goto L_0x0093
        L_0x00b4:
            com.facebook.appevents.internal.AutomaticAnalyticsLogger r1 = com.facebook.appevents.internal.AutomaticAnalyticsLogger.INSTANCE
            com.facebook.appevents.internal.AutomaticAnalyticsLogger.logPurchase(r0, r8, r9)
            goto L_0x0093
        L_0x00ba:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.iap.InAppPurchaseActivityLifecycleTracker.access$logPurchase(com.facebook.appevents.iap.InAppPurchaseActivityLifecycleTracker, android.content.Context, java.util.ArrayList, boolean):void");
    }

    public static final void startIapLogging() {
        if (hasBillingService == null) {
            Boolean valueOf = Boolean.valueOf(InAppPurchaseUtils.getClass("com.android.vending.billing.IInAppBillingService$Stub") != null);
            hasBillingService = valueOf;
            if (!Intrinsics.areEqual(valueOf, Boolean.FALSE)) {
                hasBillingActivity = Boolean.valueOf(InAppPurchaseUtils.getClass("com.android.billingclient.api.ProxyBillingActivity") != null);
                InAppPurchaseEventManager inAppPurchaseEventManager = InAppPurchaseEventManager.INSTANCE;
                Class<InAppPurchaseEventManager> cls = InAppPurchaseEventManager.class;
                if (!CrashShieldHandler.isObjectCrashing(cls)) {
                    try {
                        long currentTimeMillis = System.currentTimeMillis() / 1000;
                        long j = InAppPurchaseEventManager.skuDetailSharedPrefs.getLong("LAST_CLEARED_TIME", 0);
                        if (j == 0) {
                            InAppPurchaseEventManager.skuDetailSharedPrefs.edit().putLong("LAST_CLEARED_TIME", currentTimeMillis).apply();
                        } else if (currentTimeMillis - j > ((long) 604800)) {
                            InAppPurchaseEventManager.skuDetailSharedPrefs.edit().clear().putLong("LAST_CLEARED_TIME", currentTimeMillis).apply();
                        }
                    } catch (Throwable th) {
                        CrashShieldHandler.handleThrowable(th, cls);
                    }
                }
                Intent intent2 = new Intent("com.android.vending.billing.InAppBillingService.BIND").setPackage("com.android.vending");
                Intrinsics.checkNotNullExpressionValue(intent2, "Intent(\"com.android.vending.billing.InAppBillingService.BIND\")\n            .setPackage(\"com.android.vending\")");
                intent = intent2;
                serviceConnection = new InAppPurchaseActivityLifecycleTracker$initializeIfNotInitialized$1();
                callbacks = new InAppPurchaseActivityLifecycleTracker$initializeIfNotInitialized$2();
            }
        }
        if (!Intrinsics.areEqual(hasBillingService, Boolean.FALSE)) {
            AutomaticAnalyticsLogger automaticAnalyticsLogger = AutomaticAnalyticsLogger.INSTANCE;
            if (AutomaticAnalyticsLogger.isImplicitPurchaseLoggingEnabled() && isTracking.compareAndSet(false, true)) {
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                Context applicationContext = FacebookSdk.getApplicationContext();
                if (applicationContext instanceof Application) {
                    Application application = (Application) applicationContext;
                    ActivityLifecycleCallbacks activityLifecycleCallbacks = callbacks;
                    if (activityLifecycleCallbacks != null) {
                        application.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
                        Intent intent3 = intent;
                        if (intent3 != null) {
                            ServiceConnection serviceConnection2 = serviceConnection;
                            if (serviceConnection2 != null) {
                                applicationContext.bindService(intent3, serviceConnection2, 1);
                            } else {
                                Intrinsics.throwUninitializedPropertyAccessException("serviceConnection");
                                throw null;
                            }
                        } else {
                            Intrinsics.throwUninitializedPropertyAccessException(AnalyticsConstants.INTENT);
                            throw null;
                        }
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("callbacks");
                        throw null;
                    }
                }
            }
        }
    }
}
