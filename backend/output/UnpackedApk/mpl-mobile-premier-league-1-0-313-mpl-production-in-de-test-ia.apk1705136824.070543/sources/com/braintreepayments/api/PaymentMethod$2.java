package com.braintreepayments.api;

import com.braintreepayments.api.exceptions.PaymentMethodDeleteException;
import com.braintreepayments.api.interfaces.HttpResponseCallback;
import com.braintreepayments.api.interfaces.QueuedCallback;
import com.braintreepayments.api.models.PaymentMethodNonce;

public final class PaymentMethod$2 implements HttpResponseCallback {
    public final /* synthetic */ BraintreeFragment val$fragment;
    public final /* synthetic */ PaymentMethodNonce val$paymentMethodNonce;

    public PaymentMethod$2(BraintreeFragment braintreeFragment, PaymentMethodNonce paymentMethodNonce) {
        this.val$fragment = braintreeFragment;
        this.val$paymentMethodNonce = paymentMethodNonce;
    }

    public void failure(Exception exc) {
        BraintreeFragment braintreeFragment = this.val$fragment;
        braintreeFragment.postOrQueueCallback(new QueuedCallback(new PaymentMethodDeleteException(this.val$paymentMethodNonce, exc)) {
            public void run() {
                BraintreeFragment.this.mErrorListener.onError(r2);
            }

            public boolean shouldRun() {
                return BraintreeFragment.this.mErrorListener != null;
            }
        });
        this.val$fragment.sendAnalyticsEvent("delete-payment-methods.failed");
    }

    public void success(String str) {
        BraintreeFragment braintreeFragment = this.val$fragment;
        braintreeFragment.postOrQueueCallback(new QueuedCallback(this.val$paymentMethodNonce) {
            public final /* synthetic */ PaymentMethodNonce val$paymentMethodNonce;

            {
                this.val$paymentMethodNonce = r2;
            }

            public void run() {
                BraintreeFragment.this.mPaymentMethodNonceDeletedListener.onPaymentMethodNonceDeleted(this.val$paymentMethodNonce);
            }

            public boolean shouldRun() {
                return BraintreeFragment.this.mPaymentMethodNonceDeletedListener != null;
            }
        });
        this.val$fragment.sendAnalyticsEvent("delete-payment-methods.succeeded");
    }
}
