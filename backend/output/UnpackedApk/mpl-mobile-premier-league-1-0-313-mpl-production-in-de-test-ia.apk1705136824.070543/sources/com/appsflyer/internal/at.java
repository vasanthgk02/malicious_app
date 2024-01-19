package com.appsflyer.internal;

import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.android.billingclient.api.SkuDetails;
import com.android.billingclient.api.SkuDetailsParams;
import com.android.billingclient.api.SkuDetailsResponseListener;
import com.appsflyer.AFLogger;
import java.util.ArrayList;
import java.util.List;
import org.apache.fontbox.cmap.CMap;

public final class at implements PurchasesUpdatedListener {
    public /* synthetic */ av values;

    public at(av avVar) {
        this.values = avVar;
    }

    public final void onPurchasesUpdated(BillingResult billingResult, List<Purchase> list) {
        av avVar = this.values;
        try {
            if (billingResult.getResponseCode() == 0) {
                if (list != null) {
                    if (avVar.values == null) {
                        AFLogger.AppsFlyer2dXConversionCallback("Got Ars billing callback but billing client is missing!");
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    for (Purchase sku : list) {
                        arrayList.add(sku.getSku());
                    }
                    avVar.values.querySkuDetailsAsync(SkuDetailsParams.newBuilder().setType("subs").setSkusList(arrayList).build(), new SkuDetailsResponseListener(list) {
                        public /* synthetic */ List AFInAppEventParameterName;

                        {
                            this.AFInAppEventParameterName = r2;
                        }

                        public final void onSkuDetailsResponse(BillingResult billingResult, List<SkuDetails> list) {
                            try {
                                if (billingResult.getResponseCode() == 0) {
                                    if (list != null) {
                                        ArrayList arrayList = new ArrayList();
                                        for (SkuDetails sku : list) {
                                            arrayList.add(sku.getSku());
                                        }
                                        ArrayList arrayList2 = new ArrayList();
                                        for (Purchase purchase : this.AFInAppEventParameterName) {
                                            if (arrayList.contains(purchase.getSku())) {
                                                arrayList2.add(purchase);
                                            }
                                        }
                                        if (!arrayList2.isEmpty()) {
                                            av.AFInAppEventType(av.this, false, arrayList2);
                                        }
                                    }
                                }
                            } catch (Throwable th) {
                                if ((th instanceof NoSuchMethodError) || (th instanceof NoClassDefFoundError)) {
                                    AFLogger.AppsFlyer2dXConversionCallback("It seems your app uses different Play Billing library version than the SDK. Please use v.3.0.3");
                                }
                                AFLogger.AFInAppEventParameterName((String) "Failed to log new purchase", th);
                            }
                        }
                    });
                    return;
                }
            }
            StringBuilder sb = new StringBuilder("Failed to setup Ars Play billing service: ");
            sb.append(billingResult.getResponseCode());
            sb.append(CMap.SPACE);
            sb.append(billingResult.getDebugMessage());
            AFLogger.AppsFlyer2dXConversionCallback(sb.toString());
        } catch (Throwable th) {
            if ((th instanceof NoSuchMethodError) || (th instanceof NoClassDefFoundError)) {
                AFLogger.AppsFlyer2dXConversionCallback("It seems your app uses different Play Billing library version than the SDK. Please use v.3.0.3");
            }
            AFLogger.AFInAppEventParameterName((String) "Failed to query new purchase details", th);
        }
    }
}
