package com.braintreepayments.api;

import com.braintreepayments.api.interfaces.HttpResponseCallback;
import com.braintreepayments.api.interfaces.QueuedCallback;
import com.braintreepayments.api.models.CardNonce;

public final class ThreeDSecure$6 implements HttpResponseCallback {
    public final /* synthetic */ BraintreeFragment val$fragment;
    public final /* synthetic */ CardNonce val$lookupCardNonce;

    public ThreeDSecure$6(CardNonce cardNonce, BraintreeFragment braintreeFragment) {
        this.val$lookupCardNonce = cardNonce;
        this.val$fragment = braintreeFragment;
    }

    public void failure(Exception exc) {
        this.val$fragment.sendAnalyticsEvent("three-d-secure.verification-flow.upgrade-payment-method.errored");
        BraintreeFragment braintreeFragment = this.val$fragment;
        braintreeFragment.postOrQueueCallback(new QueuedCallback(exc) {
            public void run() {
                BraintreeFragment.this.mErrorListener.onError(exc);
            }

            public boolean shouldRun() {
                return BraintreeFragment.this.mErrorListener != null;
            }
        });
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void success(java.lang.String r7) {
        /*
            r6 = this;
            com.braintreepayments.api.models.ThreeDSecureAuthenticationResponse r0 = com.braintreepayments.api.models.ThreeDSecureAuthenticationResponse.fromJson(r7)
            com.braintreepayments.api.models.CardNonce r1 = r6.val$lookupCardNonce
            java.lang.String r2 = "success"
            com.braintreepayments.api.models.ThreeDSecureAuthenticationResponse r3 = new com.braintreepayments.api.models.ThreeDSecureAuthenticationResponse
            r3.<init>()
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0046 }
            r4.<init>(r7)     // Catch:{ JSONException -> 0x0046 }
            boolean r5 = r4.has(r2)     // Catch:{ JSONException -> 0x0046 }
            if (r5 == 0) goto L_0x001f
            boolean r2 = r4.getBoolean(r2)     // Catch:{ JSONException -> 0x0046 }
            r3.mSuccess = r2     // Catch:{ JSONException -> 0x0046 }
            goto L_0x002a
        L_0x001f:
            java.lang.String r2 = "errors"
            boolean r2 = r4.has(r2)     // Catch:{ JSONException -> 0x0046 }
            if (r2 != 0) goto L_0x002a
            r2 = 1
            r3.mSuccess = r2     // Catch:{ JSONException -> 0x0046 }
        L_0x002a:
            boolean r2 = r3.mSuccess     // Catch:{ JSONException -> 0x0046 }
            if (r2 == 0) goto L_0x0043
            java.lang.String r7 = "paymentMethod"
            org.json.JSONObject r7 = r4.optJSONObject(r7)     // Catch:{ JSONException -> 0x0046 }
            if (r7 == 0) goto L_0x0050
            com.braintreepayments.api.models.CardNonce r2 = new com.braintreepayments.api.models.CardNonce     // Catch:{ JSONException -> 0x0046 }
            r2.<init>()     // Catch:{ JSONException -> 0x0046 }
            r2.fromJson(r7)     // Catch:{ JSONException -> 0x0040 }
            r1 = r2
            goto L_0x0050
        L_0x0040:
            r7 = move-exception
            r1 = r2
            goto L_0x0047
        L_0x0043:
            r3.mErrors = r7     // Catch:{ JSONException -> 0x0046 }
            goto L_0x0050
        L_0x0046:
            r7 = move-exception
        L_0x0047:
            r2 = 0
            r3.mSuccess = r2
            java.lang.String r7 = r7.getMessage()
            r3.mException = r7
        L_0x0050:
            com.braintreepayments.api.models.ThreeDSecureInfo r7 = r1.mThreeDSecureInfo
            r7.mThreeDSecureAuthenticationResponse = r3
            java.lang.String r7 = r0.mErrors
            if (r7 == 0) goto L_0x006b
            com.braintreepayments.api.BraintreeFragment r7 = r6.val$fragment
            java.lang.String r0 = "three-d-secure.verification-flow.upgrade-payment-method.failure.returned-lookup-nonce"
            r7.sendAnalyticsEvent(r0)
            com.braintreepayments.api.models.ThreeDSecureInfo r7 = r1.mThreeDSecureInfo
            if (r7 == 0) goto L_0x0069
            com.braintreepayments.api.BraintreeFragment r7 = r6.val$fragment
            co.hyperverge.hypersnapsdk.c.k.completeVerificationFlowWithNoncePayload(r7, r1)
            goto L_0x0077
        L_0x0069:
            r7 = 0
            throw r7
        L_0x006b:
            com.braintreepayments.api.BraintreeFragment r7 = r6.val$fragment
            java.lang.String r0 = "three-d-secure.verification-flow.upgrade-payment-method.succeeded"
            r7.sendAnalyticsEvent(r0)
            com.braintreepayments.api.BraintreeFragment r7 = r6.val$fragment
            co.hyperverge.hypersnapsdk.c.k.completeVerificationFlowWithNoncePayload(r7, r1)
        L_0x0077:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.braintreepayments.api.ThreeDSecure$6.success(java.lang.String):void");
    }
}
