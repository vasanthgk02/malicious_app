package com.facebook.appevents.iap;

import android.content.Context;
import com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper.Companion;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseAutoLogger;", "", "()V", "BILLING_CLIENT_PURCHASE_NAME", "", "logPurchase", "", "startIapLogging", "context", "Landroid/content/Context;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: InAppPurchaseAutoLogger.kt */
public final class InAppPurchaseAutoLogger {
    public static final InAppPurchaseAutoLogger INSTANCE = new InAppPurchaseAutoLogger();

    public static final void startIapLogging(Context context) {
        InAppPurchaseBillingClientWrapper inAppPurchaseBillingClientWrapper;
        Class<InAppPurchaseAutoLogger> cls = InAppPurchaseAutoLogger.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(context, "context");
                if (InAppPurchaseUtils.getClass("com.android.billingclient.api.Purchase") != null) {
                    Companion companion = InAppPurchaseBillingClientWrapper.Companion;
                    synchronized (companion) {
                        Intrinsics.checkNotNullParameter(context, "context");
                        if (InAppPurchaseBillingClientWrapper.access$getInitialized$cp().get()) {
                            inAppPurchaseBillingClientWrapper = InAppPurchaseBillingClientWrapper.access$getInstance$cp();
                        } else {
                            companion.createInstance(context);
                            InAppPurchaseBillingClientWrapper.access$getInitialized$cp().set(true);
                            inAppPurchaseBillingClientWrapper = InAppPurchaseBillingClientWrapper.access$getInstance$cp();
                        }
                    }
                    if (inAppPurchaseBillingClientWrapper != null && InAppPurchaseBillingClientWrapper.Companion.isServiceConnected().get()) {
                        InAppPurchaseLoggerManager inAppPurchaseLoggerManager = InAppPurchaseLoggerManager.INSTANCE;
                        if (InAppPurchaseLoggerManager.eligibleQueryPurchaseHistory()) {
                            $$Lambda$687IX7AaP5K7d5ER9XfsPCHYVU r2 = $$Lambda$687IX7AaP5K7d5ER9XfsPCHYVU.INSTANCE;
                            if (!CrashShieldHandler.isObjectCrashing(inAppPurchaseBillingClientWrapper)) {
                                Intrinsics.checkNotNullParameter("inapp", "skuType");
                                Intrinsics.checkNotNullParameter(r2, "queryPurchaseHistoryRunnable");
                                inAppPurchaseBillingClientWrapper.queryPurchaseHistoryAsync("inapp", new Runnable(r2) {
                                    public final /* synthetic */ Runnable f$1;

                                    {
                                        this.f$1 = r2;
                                    }

                                    public final void run() {
                                        InAppPurchaseBillingClientWrapper.m171queryPurchaseHistory$lambda0(InAppPurchaseBillingClientWrapper.this, this.f$1);
                                    }
                                });
                            }
                        } else {
                            inAppPurchaseBillingClientWrapper.queryPurchase("inapp", $$Lambda$Wwi5DeOus3p2VMp5XwmTDyqKUU8.INSTANCE);
                        }
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    /* renamed from: startIapLogging$lambda-0  reason: not valid java name */
    public static final void m169startIapLogging$lambda0() {
        Class<InAppPurchaseAutoLogger> cls = InAppPurchaseAutoLogger.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                INSTANCE.logPurchase();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    /* renamed from: startIapLogging$lambda-1  reason: not valid java name */
    public static final void m170startIapLogging$lambda1() {
        Class<InAppPurchaseAutoLogger> cls = InAppPurchaseAutoLogger.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                INSTANCE.logPurchase();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public final void logPurchase() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                InAppPurchaseLoggerManager inAppPurchaseLoggerManager = InAppPurchaseLoggerManager.INSTANCE;
                InAppPurchaseLoggerManager.filterPurchaseLogging(InAppPurchaseBillingClientWrapper.Companion.getPurchaseDetailsMap(), InAppPurchaseBillingClientWrapper.Companion.getSkuDetailsMap());
                InAppPurchaseBillingClientWrapper.Companion.getPurchaseDetailsMap().clear();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }
}
