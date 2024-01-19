package com.appsflyer.internal;

import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.Purchase.PurchasesResult;
import com.appsflyer.AFLogger;
import java.util.List;

public final class au implements BillingClientStateListener {
    public /* synthetic */ av AFKeystoreWrapper;

    public au(av avVar) {
        this.AFKeystoreWrapper = avVar;
    }

    public final void onBillingServiceDisconnected() {
    }

    public final void onBillingSetupFinished(BillingResult billingResult) {
        av avVar = this.AFKeystoreWrapper;
        avVar.valueOf.submit(new Runnable(billingResult) {
            public /* synthetic */ BillingResult AFKeystoreWrapper;

            {
                this.AFKeystoreWrapper = r2;
            }

            public final void run() {
                try {
                    if (this.AFKeystoreWrapper.getResponseCode() == 0 && !av.this.AFInAppEventParameterName.AFInAppEventParameterName("ars_history_sent")) {
                        PurchasesResult queryPurchases = av.this.values.queryPurchases("subs");
                        List purchasesList = queryPurchases.getPurchasesList();
                        if (queryPurchases.getResponseCode() == 0 && purchasesList != null) {
                            if (!purchasesList.isEmpty()) {
                                av.AFInAppEventType(av.this, true, purchasesList);
                                return;
                            }
                        }
                        AFLogger.AppsFlyer2dXConversionCallback("Failed to query purchases history");
                    }
                } catch (Throwable th) {
                    if ((th instanceof NoSuchMethodError) || (th instanceof NoClassDefFoundError)) {
                        AFLogger.AppsFlyer2dXConversionCallback("It seems your app uses different Play Billing library version than the SDK. Please use v.3.0.3");
                    }
                    AFLogger.AFInAppEventParameterName((String) "Failed to log purchases history", th);
                }
            }
        });
    }
}
