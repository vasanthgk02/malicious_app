package com.braintreepayments.api;

import com.braintreepayments.api.interfaces.PaymentMethodNonceCallback;
import com.braintreepayments.api.interfaces.QueuedCallback;
import com.braintreepayments.api.models.PaymentMethodNonce;

public final class Venmo$2 implements PaymentMethodNonceCallback {
    public final /* synthetic */ BraintreeFragment val$fragment;

    public Venmo$2(BraintreeFragment braintreeFragment) {
        this.val$fragment = braintreeFragment;
    }

    public void failure(Exception exc) {
        this.val$fragment.postCallback(exc);
        this.val$fragment.sendAnalyticsEvent("pay-with-venmo.vault.failed");
    }

    public void success(PaymentMethodNonce paymentMethodNonce) {
        BraintreeFragment braintreeFragment = this.val$fragment;
        braintreeFragment.mCachedPaymentMethodNonces.add(0, paymentMethodNonce);
        braintreeFragment.postOrQueueCallback(new QueuedCallback(paymentMethodNonce) {
            public void run() {
                BraintreeFragment.this.mPaymentMethodNonceCreatedListener.onPaymentMethodNonceCreated(r4);
            }

            public boolean shouldRun() {
                return BraintreeFragment.this.mPaymentMethodNonceCreatedListener != null;
            }
        });
        this.val$fragment.sendAnalyticsEvent("pay-with-venmo.vault.success");
    }
}
