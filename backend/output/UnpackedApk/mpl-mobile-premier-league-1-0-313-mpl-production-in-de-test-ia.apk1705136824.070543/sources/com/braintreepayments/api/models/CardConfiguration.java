package com.braintreepayments.api.models;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class CardConfiguration {
    public boolean mCollectFraudData = false;
    public final Set<String> mSupportedCardTypes = new HashSet();

    public static CardConfiguration fromJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        CardConfiguration cardConfiguration = new CardConfiguration();
        JSONArray optJSONArray = jSONObject.optJSONArray("supportedCardTypes");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                cardConfiguration.mSupportedCardTypes.add(optJSONArray.optString(i, ""));
            }
        }
        cardConfiguration.mCollectFraudData = jSONObject.optBoolean("collectDeviceData", false);
        return cardConfiguration;
    }

    public Set<String> getSupportedCardTypes() {
        return Collections.unmodifiableSet(this.mSupportedCardTypes);
    }
}
