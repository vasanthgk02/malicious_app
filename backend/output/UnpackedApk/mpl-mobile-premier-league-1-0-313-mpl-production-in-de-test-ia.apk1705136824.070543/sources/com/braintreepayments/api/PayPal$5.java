package com.braintreepayments.api;

import com.braintreepayments.api.interfaces.PaymentMethodNonceCallback;
import com.braintreepayments.api.interfaces.QueuedCallback;
import com.braintreepayments.api.models.PayPalAccountNonce;
import com.braintreepayments.api.models.PaymentMethodNonce;

public final class PayPal$5 implements PaymentMethodNonceCallback {
    public final /* synthetic */ BraintreeFragment val$fragment;

    public PayPal$5(BraintreeFragment braintreeFragment) {
        this.val$fragment = braintreeFragment;
    }

    public void failure(Exception exc) {
        this.val$fragment.postCallback(exc);
    }

    public void success(PaymentMethodNonce paymentMethodNonce) {
        if ((paymentMethodNonce instanceof PayPalAccountNonce) && ((PayPalAccountNonce) paymentMethodNonce).mCreditFinancing != null) {
            this.val$fragment.sendAnalyticsEvent("paypal.credit.accepted");
        }
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
    }
}
