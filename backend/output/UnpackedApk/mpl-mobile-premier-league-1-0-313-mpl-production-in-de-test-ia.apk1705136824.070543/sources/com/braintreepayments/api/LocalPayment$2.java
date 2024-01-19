package com.braintreepayments.api;

import com.braintreepayments.api.interfaces.HttpResponseCallback;
import com.braintreepayments.api.interfaces.QueuedCallback;
import com.braintreepayments.api.models.LocalPaymentResult;
import org.json.JSONException;

public final class LocalPayment$2 implements HttpResponseCallback {
    public final /* synthetic */ BraintreeFragment val$fragment;

    public LocalPayment$2(BraintreeFragment braintreeFragment) {
        this.val$fragment = braintreeFragment;
    }

    public void failure(Exception exc) {
        this.val$fragment.sendAnalyticsEvent("unknown.local-payment.tokenize.failed");
        BraintreeFragment braintreeFragment = this.val$fragment;
        braintreeFragment.postOrQueueCallback(new QueuedCallback(exc) {
            public void run() {
                BraintreeFragment.this.mErrorListener.onError(r2);
            }

            public boolean shouldRun() {
                return BraintreeFragment.this.mErrorListener != null;
            }
        });
    }

    public void success(String str) {
        try {
            LocalPaymentResult fromJson = LocalPaymentResult.fromJson(str);
            this.val$fragment.sendAnalyticsEvent("unknown.local-payment.tokenize.succeeded");
            BraintreeFragment braintreeFragment = this.val$fragment;
            braintreeFragment.mCachedPaymentMethodNonces.add(0, fromJson);
            braintreeFragment.postOrQueueCallback(new QueuedCallback(fromJson) {
                public void run() {
                    BraintreeFragment.this.mPaymentMethodNonceCreatedListener.onPaymentMethodNonceCreated(r4);
                }

                public boolean shouldRun() {
                    return BraintreeFragment.this.mPaymentMethodNonceCreatedListener != null;
                }
            });
        } catch (JSONException e2) {
            this.val$fragment.sendAnalyticsEvent("unknown.local-payment.tokenize.failed");
            BraintreeFragment braintreeFragment2 = this.val$fragment;
            braintreeFragment2.postOrQueueCallback(new QueuedCallback(e2) {
                public void run() {
                    BraintreeFragment.this.mErrorListener.onError(r2);
                }

                public boolean shouldRun() {
                    return BraintreeFragment.this.mErrorListener != null;
                }
            });
        }
    }
}
