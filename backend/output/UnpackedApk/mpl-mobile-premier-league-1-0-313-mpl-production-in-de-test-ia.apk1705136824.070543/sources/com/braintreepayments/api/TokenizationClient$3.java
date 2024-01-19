package com.braintreepayments.api;

import com.braintreepayments.api.interfaces.HttpResponseCallback;
import com.braintreepayments.api.interfaces.PaymentMethodNonceCallback;
import com.braintreepayments.api.models.PaymentMethodBuilder;
import com.braintreepayments.api.models.PaymentMethodNonce;
import org.json.JSONException;
import org.json.JSONObject;

public final class TokenizationClient$3 implements HttpResponseCallback {
    public final /* synthetic */ PaymentMethodNonceCallback val$callback;
    public final /* synthetic */ PaymentMethodBuilder val$paymentMethodBuilder;

    public TokenizationClient$3(PaymentMethodNonceCallback paymentMethodNonceCallback, PaymentMethodBuilder paymentMethodBuilder) {
        this.val$callback = paymentMethodNonceCallback;
        this.val$paymentMethodBuilder = paymentMethodBuilder;
    }

    public void failure(Exception exc) {
        this.val$callback.failure(exc);
    }

    public void success(String str) {
        try {
            this.val$callback.success(PaymentMethodNonce.parsePaymentMethodNonces(new JSONObject(str), this.val$paymentMethodBuilder.getResponsePaymentMethodType()));
        } catch (JSONException e2) {
            this.val$callback.failure(e2);
        }
    }
}
