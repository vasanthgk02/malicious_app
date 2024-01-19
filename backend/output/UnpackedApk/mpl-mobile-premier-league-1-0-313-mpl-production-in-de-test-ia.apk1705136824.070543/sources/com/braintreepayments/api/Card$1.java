package com.braintreepayments.api;

import com.braintreepayments.api.interfaces.PaymentMethodNonceCallback;
import com.braintreepayments.api.interfaces.QueuedCallback;
import com.braintreepayments.api.models.PaymentMethodNonce;

public final class Card$1 implements PaymentMethodNonceCallback {
    public final /* synthetic */ BraintreeFragment val$fragment;

    public Card$1(BraintreeFragment braintreeFragment) {
        this.val$fragment = braintreeFragment;
    }

    public void failure(Exception exc) {
        this.val$fragment.postCallback(exc);
        this.val$fragment.sendAnalyticsEvent("card.nonce-failed");
    }

    public void success(PaymentMethodNonce paymentMethodNonce) {
        BraintreeFragment braintreeFragment = this.val$fragment;
        DataCollector$3 dataCollector$3 = new DataCollector$3(braintreeFragment, paymentMethodNonce);
        braintreeFragment.fetchConfiguration();
        braintreeFragment.postOrQueueCallback(new QueuedCallback(dataCollector$3) {
            public void run() {
                r5.onConfigurationFetched(BraintreeFragment.this.mConfiguration);
            }

            public boolean shouldRun() {
                BraintreeFragment braintreeFragment = BraintreeFragment.this;
                return braintreeFragment.mConfiguration != null && braintreeFragment.isAdded();
            }
        });
        BraintreeFragment braintreeFragment2 = this.val$fragment;
        braintreeFragment2.mCachedPaymentMethodNonces.add(0, paymentMethodNonce);
        braintreeFragment2.postOrQueueCallback(new QueuedCallback(paymentMethodNonce) {
            public void run() {
                BraintreeFragment.this.mPaymentMethodNonceCreatedListener.onPaymentMethodNonceCreated(r4);
            }

            public boolean shouldRun() {
                return BraintreeFragment.this.mPaymentMethodNonceCreatedListener != null;
            }
        });
        this.val$fragment.sendAnalyticsEvent("card.nonce-received");
    }
}
