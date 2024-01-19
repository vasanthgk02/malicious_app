package com.braintreepayments.api;

import com.braintreepayments.api.interfaces.ConfigurationListener;

public final class Venmo$1 implements ConfigurationListener {
    public final /* synthetic */ BraintreeFragment val$fragment;
    public final /* synthetic */ String val$profileId;
    public final /* synthetic */ boolean val$vault;

    public Venmo$1(BraintreeFragment braintreeFragment, String str, boolean z) {
        this.val$fragment = braintreeFragment;
        this.val$profileId = str;
        this.val$vault = z;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x00b6 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00bd */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onConfigurationFetched(com.braintreepayments.api.models.Configuration r7) {
        /*
            r6 = this;
            com.braintreepayments.api.BraintreeFragment r0 = r6.val$fragment
            java.lang.String r1 = "pay-with-venmo.selected"
            r0.sendAnalyticsEvent(r1)
            java.lang.String r0 = r6.val$profileId
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L_0x0013
            com.braintreepayments.api.models.VenmoConfiguration r0 = r7.mVenmoConfiguration
            java.lang.String r0 = r0.mMerchantId
        L_0x0013:
            com.braintreepayments.api.models.VenmoConfiguration r1 = r7.mVenmoConfiguration
            java.lang.String r1 = r1.mAccessToken
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            r2 = 1
            r1 = r1 ^ r2
            if (r1 != 0) goto L_0x0022
            java.lang.String r1 = "Venmo is not enabled"
            goto L_0x0031
        L_0x0022:
            com.braintreepayments.api.BraintreeFragment r1 = r6.val$fragment
            android.content.Context r1 = r1.mContext
            boolean r1 = co.hyperverge.hypersnapsdk.c.k.isVenmoInstalled(r1)
            if (r1 != 0) goto L_0x002f
            java.lang.String r1 = "Venmo is not installed"
            goto L_0x0031
        L_0x002f:
            java.lang.String r1 = ""
        L_0x0031:
            boolean r3 = android.text.TextUtils.isEmpty(r1)
            if (r3 != 0) goto L_0x004f
            com.braintreepayments.api.BraintreeFragment r7 = r6.val$fragment
            com.braintreepayments.api.exceptions.AppSwitchNotAvailableException r0 = new com.braintreepayments.api.exceptions.AppSwitchNotAvailableException
            r0.<init>(r1)
            com.braintreepayments.api.BraintreeFragment$11 r1 = new com.braintreepayments.api.BraintreeFragment$11
            r1.<init>(r0)
            r7.postOrQueueCallback(r1)
            com.braintreepayments.api.BraintreeFragment r7 = r6.val$fragment
            java.lang.String r0 = "pay-with-venmo.app-switch.failed"
            r7.sendAnalyticsEvent(r0)
            goto L_0x00e5
        L_0x004f:
            boolean r1 = r6.val$vault
            r3 = 0
            if (r1 == 0) goto L_0x005d
            com.braintreepayments.api.BraintreeFragment r1 = r6.val$fragment
            com.braintreepayments.api.models.Authorization r1 = r1.mAuthorization
            boolean r1 = r1 instanceof com.braintreepayments.api.models.ClientToken
            if (r1 == 0) goto L_0x005d
            goto L_0x005e
        L_0x005d:
            r2 = 0
        L_0x005e:
            com.braintreepayments.api.BraintreeFragment r1 = r6.val$fragment
            android.content.Context r1 = r1.mContext
            android.content.Context r1 = r1.getApplicationContext()
            java.lang.String r4 = "BraintreeApi"
            android.content.SharedPreferences r1 = r1.getSharedPreferences(r4, r3)
            android.content.SharedPreferences$Editor r1 = r1.edit()
            java.lang.String r3 = "com.braintreepayments.api.Venmo.VAULT_VENMO_KEY"
            android.content.SharedPreferences$Editor r1 = r1.putBoolean(r3, r2)
            r1.apply()
            com.braintreepayments.api.BraintreeFragment r1 = r6.val$fragment
            com.braintreepayments.api.models.VenmoConfiguration r7 = r7.mVenmoConfiguration
            android.content.Intent r2 = new android.content.Intent
            r2.<init>()
            android.content.ComponentName r3 = new android.content.ComponentName
            java.lang.String r4 = "com.venmo"
            java.lang.String r5 = "com.venmo.controller.SetupMerchantActivity"
            r3.<init>(r4, r5)
            android.content.Intent r2 = r2.setComponent(r3)
            java.lang.String r3 = "com.braintreepayments.api.MERCHANT_ID"
            android.content.Intent r0 = r2.putExtra(r3, r0)
            java.lang.String r2 = r7.mAccessToken
            java.lang.String r3 = "com.braintreepayments.api.ACCESS_TOKEN"
            android.content.Intent r0 = r0.putExtra(r3, r2)
            java.lang.String r7 = r7.mEnvironment
            java.lang.String r2 = "com.braintreepayments.api.ENVIRONMENT"
            android.content.Intent r7 = r0.putExtra(r2, r7)
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00d9 }
            r0.<init>()     // Catch:{ JSONException -> 0x00d9 }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00d9 }
            r2.<init>()     // Catch:{ JSONException -> 0x00d9 }
            java.lang.String r3 = "platform"
            java.lang.String r4 = "android"
            r2.put(r3, r4)     // Catch:{ JSONException -> 0x00b6 }
        L_0x00b6:
            java.lang.String r3 = r1.mSessionId     // Catch:{ JSONException -> 0x00d9 }
            java.lang.String r4 = "sessionId"
            r2.put(r4, r3)     // Catch:{ JSONException -> 0x00bd }
        L_0x00bd:
            java.lang.String r3 = r1.mIntegrationType     // Catch:{ JSONException -> 0x00d9 }
            java.lang.String r4 = "integration"
            r2.put(r4, r3)     // Catch:{ JSONException -> 0x00c4 }
        L_0x00c4:
            java.lang.String r3 = "version"
            java.lang.String r4 = "3.17.4"
            r2.put(r3, r4)     // Catch:{ JSONException -> 0x00cb }
        L_0x00cb:
            java.lang.String r3 = "_meta"
            r0.put(r3, r2)     // Catch:{ JSONException -> 0x00d9 }
            java.lang.String r2 = "com.braintreepayments.api.EXTRA_BRAINTREE_DATA"
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x00d9 }
            r7.putExtra(r2, r0)     // Catch:{ JSONException -> 0x00d9 }
        L_0x00d9:
            r0 = 13488(0x34b0, float:1.8901E-41)
            r1.startActivityForResult(r7, r0)
            com.braintreepayments.api.BraintreeFragment r7 = r6.val$fragment
            java.lang.String r0 = "pay-with-venmo.app-switch.started"
            r7.sendAnalyticsEvent(r0)
        L_0x00e5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.braintreepayments.api.Venmo$1.onConfigurationFetched(com.braintreepayments.api.models.Configuration):void");
    }
}
