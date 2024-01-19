package com.mpl.androidapp.config;

import com.mpl.payment.common.config.PaymentConfigProvider;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¨\u0006\u0006"}, d2 = {"Lcom/mpl/androidapp/config/PaymentConfigProviderImpl;", "Lcom/mpl/payment/common/config/PaymentConfigProvider;", "()V", "getAllowedCardTypesForBraintree3ds", "", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentConfigProviderImpl.kt */
public final class PaymentConfigProviderImpl implements PaymentConfigProvider {
    public List<String> getAllowedCardTypesForBraintree3ds() {
        JSONObject normalConfig = ConfigManager.getNormalConfig();
        JSONArray jSONArray = null;
        if (normalConfig != null) {
            JSONObject optJSONObject = normalConfig.optJSONObject("payment.3dsConfig");
            if (optJSONObject != null) {
                jSONArray = optJSONObject.optJSONArray("braintree.allowedCardType");
            }
        }
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            int i = 0;
            int length = jSONArray.length();
            while (i < length) {
                int i2 = i + 1;
                String optString = jSONArray.optString(i, "");
                Intrinsics.checkNotNullExpressionValue(optString, "allowedArray.optString(i, \"\")");
                arrayList.add(optString);
                i = i2;
            }
        }
        return arrayList;
    }
}
