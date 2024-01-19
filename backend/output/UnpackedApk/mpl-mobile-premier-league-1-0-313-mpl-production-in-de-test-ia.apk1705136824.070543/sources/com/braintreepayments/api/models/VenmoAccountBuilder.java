package com.braintreepayments.api.models;

import android.content.Context;
import org.json.JSONException;
import org.json.JSONObject;

public class VenmoAccountBuilder extends PaymentMethodBuilder<VenmoAccountBuilder> {
    public String mNonce;

    public void build(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        jSONObject2.put("nonce", this.mNonce);
        jSONObject.put("venmoAccount", jSONObject2);
    }

    public void buildGraphQL(Context context, JSONObject jSONObject, JSONObject jSONObject2) {
    }

    public String getApiPath() {
        return "venmo_accounts";
    }

    public String getResponsePaymentMethodType() {
        return "VenmoAccount";
    }
}
