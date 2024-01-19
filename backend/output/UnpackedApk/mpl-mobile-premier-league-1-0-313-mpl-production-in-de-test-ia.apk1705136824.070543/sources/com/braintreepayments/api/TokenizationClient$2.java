package com.braintreepayments.api;

import com.braintreepayments.api.interfaces.HttpResponseCallback;
import com.braintreepayments.api.interfaces.PaymentMethodNonceCallback;
import com.braintreepayments.api.models.CardBuilder;
import com.braintreepayments.api.models.PaymentMethodNonce;
import org.json.JSONException;
import org.json.JSONObject;

public final class TokenizationClient$2 implements HttpResponseCallback {
    public final /* synthetic */ PaymentMethodNonceCallback val$callback;
    public final /* synthetic */ CardBuilder val$cardBuilder;
    public final /* synthetic */ BraintreeFragment val$fragment;

    public TokenizationClient$2(PaymentMethodNonceCallback paymentMethodNonceCallback, CardBuilder cardBuilder, BraintreeFragment braintreeFragment) {
        this.val$callback = paymentMethodNonceCallback;
        this.val$cardBuilder = cardBuilder;
        this.val$fragment = braintreeFragment;
    }

    public void failure(Exception exc) {
        this.val$fragment.sendAnalyticsEvent("card.graphql.tokenization.failure");
        this.val$callback.failure(exc);
    }

    public void success(String str) {
        try {
            PaymentMethodNonceCallback paymentMethodNonceCallback = this.val$callback;
            if (this.val$cardBuilder != null) {
                paymentMethodNonceCallback.success(PaymentMethodNonce.parsePaymentMethodNonces(new JSONObject(str), "CreditCard"));
                this.val$fragment.sendAnalyticsEvent("card.graphql.tokenization.success");
                return;
            }
            throw null;
        } catch (JSONException e2) {
            this.val$callback.failure(e2);
        }
    }
}
