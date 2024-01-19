package com.braintreepayments.api;

import co.hyperverge.hypersnapsdk.c.k;
import com.braintreepayments.api.interfaces.ThreeDSecureLookupListener;
import com.braintreepayments.api.models.ThreeDSecureLookup;
import com.braintreepayments.api.models.ThreeDSecureRequest;

public final class ThreeDSecure$3 implements ThreeDSecureLookupListener {
    public final /* synthetic */ BraintreeFragment val$fragment;

    public ThreeDSecure$3(BraintreeFragment braintreeFragment) {
        this.val$fragment = braintreeFragment;
    }

    public void onLookupComplete(ThreeDSecureRequest threeDSecureRequest, ThreeDSecureLookup threeDSecureLookup) {
        this.val$fragment.sendAnalyticsEvent("three-d-secure.perform-verification.default-lookup-listener");
        k.continuePerformVerification(this.val$fragment, threeDSecureRequest, threeDSecureLookup);
    }
}
