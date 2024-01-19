package com.braintreepayments.api;

import com.braintreepayments.api.interfaces.BraintreeResponseListener;
import com.braintreepayments.api.interfaces.ConfigurationListener;

public final class DataCollector$1 implements ConfigurationListener {
    public final /* synthetic */ BraintreeFragment val$fragment;
    public final /* synthetic */ BraintreeResponseListener val$listener;
    public final /* synthetic */ String val$merchantId;

    public DataCollector$1(BraintreeFragment braintreeFragment, String str, BraintreeResponseListener braintreeResponseListener) {
        this.val$fragment = braintreeFragment;
        this.val$merchantId = str;
        this.val$listener = braintreeResponseListener;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:5|6) */
    /* JADX WARNING: Code restructure failed: missing block: B:6:?, code lost:
        r1 = com.paypal.android.sdk.data.collector.PayPalDataCollector.getClientMetadataId(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0013, code lost:
        r1 = "";
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x000e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onConfigurationFetched(com.braintreepayments.api.models.Configuration r5) {
        /*
            r4 = this;
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            com.braintreepayments.api.BraintreeFragment r1 = r4.val$fragment     // Catch:{ JSONException -> 0x0021 }
            android.content.Context r1 = r1.mContext     // Catch:{ JSONException -> 0x0021 }
            java.lang.String r1 = com.paypal.android.sdk.data.collector.PayPalDataCollector.getClientMetadataId(r1)     // Catch:{ NoClassDefFoundError -> 0x000e }
            goto L_0x0015
        L_0x000e:
            java.lang.String r1 = com.paypal.android.sdk.data.collector.PayPalDataCollector.getClientMetadataId(r1)     // Catch:{ NoClassDefFoundError -> 0x0013 }
            goto L_0x0015
        L_0x0013:
            java.lang.String r1 = ""
        L_0x0015:
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ JSONException -> 0x0021 }
            if (r2 != 0) goto L_0x0022
            java.lang.String r2 = "correlation_id"
            r0.put(r2, r1)     // Catch:{ JSONException -> 0x0021 }
            goto L_0x0022
        L_0x0021:
        L_0x0022:
            com.braintreepayments.api.models.KountConfiguration r1 = r5.mKountConfiguration
            java.lang.String r1 = r1.mKountMerchantId
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            r1 = r1 ^ 1
            if (r1 == 0) goto L_0x0050
            java.lang.String r1 = r4.val$merchantId
            if (r1 == 0) goto L_0x0033
            goto L_0x0037
        L_0x0033:
            com.braintreepayments.api.models.KountConfiguration r5 = r5.mKountConfiguration
            java.lang.String r1 = r5.mKountMerchantId
        L_0x0037:
            java.lang.String r5 = com.braintreepayments.api.internal.ManifestValidator.getFormattedUUID()     // Catch:{ ClassNotFoundException | NoClassDefFoundError | NumberFormatException -> 0x0046 }
            com.braintreepayments.api.BraintreeFragment r2 = r4.val$fragment     // Catch:{ ClassNotFoundException | NoClassDefFoundError | NumberFormatException -> 0x0046 }
            com.braintreepayments.api.DataCollector$1$1 r3 = new com.braintreepayments.api.DataCollector$1$1     // Catch:{ ClassNotFoundException | NoClassDefFoundError | NumberFormatException -> 0x0046 }
            r3.<init>(r0, r5, r1)     // Catch:{ ClassNotFoundException | NoClassDefFoundError | NumberFormatException -> 0x0046 }
            co.hyperverge.hypersnapsdk.c.k.startDeviceCollector(r2, r1, r5, r3)     // Catch:{ ClassNotFoundException | NoClassDefFoundError | NumberFormatException -> 0x0046 }
            goto L_0x0059
        L_0x0046:
            com.braintreepayments.api.interfaces.BraintreeResponseListener r5 = r4.val$listener
            java.lang.String r0 = r0.toString()
            r5.onResponse(r0)
            goto L_0x0059
        L_0x0050:
            com.braintreepayments.api.interfaces.BraintreeResponseListener r5 = r4.val$listener
            java.lang.String r0 = r0.toString()
            r5.onResponse(r0)
        L_0x0059:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.braintreepayments.api.DataCollector$1.onConfigurationFetched(com.braintreepayments.api.models.Configuration):void");
    }
}
