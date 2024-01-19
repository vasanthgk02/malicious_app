package com.facebook.appevents.iap;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u000f"}, d2 = {"com/facebook/appevents/iap/InAppPurchaseActivityLifecycleTracker$initializeIfNotInitialized$2", "Landroid/app/Application$ActivityLifecycleCallbacks;", "onActivityCreated", "", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivitySaveInstanceState", "outState", "onActivityStarted", "onActivityStopped", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: InAppPurchaseActivityLifecycleTracker.kt */
public final class InAppPurchaseActivityLifecycleTracker$initializeIfNotInitialized$2 implements ActivityLifecycleCallbacks {
    /* renamed from: onActivityResumed$lambda-0  reason: not valid java name */
    public static final void m167onActivityResumed$lambda0() {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        Context applicationContext = FacebookSdk.getApplicationContext();
        InAppPurchaseEventManager inAppPurchaseEventManager = InAppPurchaseEventManager.INSTANCE;
        InAppPurchaseActivityLifecycleTracker.access$logPurchase(InAppPurchaseActivityLifecycleTracker.INSTANCE, applicationContext, InAppPurchaseEventManager.getPurchasesInapp(applicationContext, InAppPurchaseActivityLifecycleTracker.inAppBillingObj), false);
        InAppPurchaseEventManager inAppPurchaseEventManager2 = InAppPurchaseEventManager.INSTANCE;
        Object obj = InAppPurchaseActivityLifecycleTracker.inAppBillingObj;
        Class<InAppPurchaseEventManager> cls = InAppPurchaseEventManager.class;
        ArrayList<String> arrayList = null;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(applicationContext, "context");
                arrayList = InAppPurchaseEventManager.INSTANCE.filterPurchases(InAppPurchaseEventManager.INSTANCE.getPurchases(applicationContext, obj, "subs"));
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
        InAppPurchaseActivityLifecycleTracker.access$logPurchase(InAppPurchaseActivityLifecycleTracker.INSTANCE, applicationContext, arrayList, true);
    }

    /* renamed from: onActivityStopped$lambda-1  reason: not valid java name */
    public static final void m168onActivityStopped$lambda1() {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        Context applicationContext = FacebookSdk.getApplicationContext();
        InAppPurchaseEventManager inAppPurchaseEventManager = InAppPurchaseEventManager.INSTANCE;
        ArrayList<String> purchasesInapp = InAppPurchaseEventManager.getPurchasesInapp(applicationContext, InAppPurchaseActivityLifecycleTracker.inAppBillingObj);
        if (purchasesInapp.isEmpty()) {
            InAppPurchaseEventManager inAppPurchaseEventManager2 = InAppPurchaseEventManager.INSTANCE;
            Object obj = InAppPurchaseActivityLifecycleTracker.inAppBillingObj;
            Class<InAppPurchaseEventManager> cls = InAppPurchaseEventManager.class;
            if (!CrashShieldHandler.isObjectCrashing(cls)) {
                try {
                    Intrinsics.checkNotNullParameter(applicationContext, "context");
                    ArrayList<String> arrayList = new ArrayList<>();
                    if (obj != null) {
                        Class<?> cls2 = InAppPurchaseEventManager.INSTANCE.getClass(applicationContext, "com.android.vending.billing.IInAppBillingService");
                        if (cls2 != null) {
                            if (InAppPurchaseEventManager.INSTANCE.getMethod(cls2, "getPurchaseHistory") != null) {
                                purchasesInapp = InAppPurchaseEventManager.INSTANCE.filterPurchases(InAppPurchaseEventManager.INSTANCE.getPurchaseHistory(applicationContext, obj, "inapp"));
                            }
                        }
                    }
                    purchasesInapp = arrayList;
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, cls);
                }
            }
            purchasesInapp = null;
        }
        InAppPurchaseActivityLifecycleTracker.access$logPurchase(InAppPurchaseActivityLifecycleTracker.INSTANCE, applicationContext, purchasesInapp, false);
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public void onActivityDestroyed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public void onActivityPaused(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public void onActivityResumed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        try {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            FacebookSdk.getExecutor().execute($$Lambda$txKW7GZ_xQvVk15ewp7rPbvZVIE.INSTANCE);
        } catch (Exception unused) {
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(bundle, "outState");
    }

    public void onActivityStarted(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public void onActivityStopped(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        try {
            if (Intrinsics.areEqual(InAppPurchaseActivityLifecycleTracker.hasBillingActivity, Boolean.TRUE) && Intrinsics.areEqual(activity.getLocalClassName(), "com.android.billingclient.api.ProxyBillingActivity")) {
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                FacebookSdk.getExecutor().execute($$Lambda$VOCg5vmp12MmgjbBZ82voq3Jbbk.INSTANCE);
            }
        } catch (Exception unused) {
        }
    }
}
