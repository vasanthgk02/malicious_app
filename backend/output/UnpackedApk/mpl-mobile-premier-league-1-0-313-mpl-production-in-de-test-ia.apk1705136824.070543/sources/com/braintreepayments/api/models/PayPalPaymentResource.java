package com.braintreepayments.api.models;

import co.hyperverge.hypersnapsdk.c.k;
import org.json.JSONException;
import org.json.JSONObject;

public class PayPalPaymentResource {
    public String mRedirectUrl;

    public static PayPalPaymentResource fromJson(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        PayPalPaymentResource payPalPaymentResource = new PayPalPaymentResource();
        JSONObject optJSONObject = jSONObject.optJSONObject("paymentResource");
        String str2 = "";
        if (optJSONObject != null) {
            if (!optJSONObject.isNull("redirectUrl")) {
                str2 = optJSONObject.optString("redirectUrl", str2);
            }
            payPalPaymentResource.mRedirectUrl = str2;
        } else {
            payPalPaymentResource.mRedirectUrl = k.optString(jSONObject.optJSONObject("agreementSetup"), "approvalUrl", str2);
        }
        return payPalPaymentResource;
    }
}
