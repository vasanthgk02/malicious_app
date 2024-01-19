package com.braintreepayments.api.models;

import android.content.Context;
import com.razorpay.AnalyticsConstants;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class PayPalAccountBuilder extends PaymentMethodBuilder<PayPalAccountBuilder> {
    public String mClientMetadataId;
    public String mIntent;
    public String mMerchantAccountId;
    public JSONObject mOneTouchCoreData = new JSONObject();

    public void build(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        jSONObject2.put("correlationId", this.mClientMetadataId);
        jSONObject2.put(AnalyticsConstants.INTENT, this.mIntent);
        Iterator<String> keys = this.mOneTouchCoreData.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            jSONObject2.put(next, this.mOneTouchCoreData.get(next));
        }
        String str = this.mMerchantAccountId;
        if (str != null) {
            jSONObject.put("merchant_account_id", str);
        }
        jSONObject.put("paypalAccount", jSONObject2);
    }

    public void buildGraphQL(Context context, JSONObject jSONObject, JSONObject jSONObject2) {
    }

    public String getApiPath() {
        return "paypal_accounts";
    }

    public String getResponsePaymentMethodType() {
        return "PayPalAccount";
    }
}
