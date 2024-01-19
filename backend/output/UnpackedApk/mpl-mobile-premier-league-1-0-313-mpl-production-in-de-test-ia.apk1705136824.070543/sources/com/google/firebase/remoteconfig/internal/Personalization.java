package com.google.firebase.remoteconfig.internal;

import android.os.Bundle;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.inject.Provider;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class Personalization {
    public final Provider<AnalyticsConnector> analyticsConnector;
    public final Map<String, String> loggedChoiceIds = Collections.synchronizedMap(new HashMap());

    public Personalization(Provider<AnalyticsConnector> provider) {
        this.analyticsConnector = provider;
    }

    public void logArmActive(String str, ConfigContainer configContainer) {
        AnalyticsConnector analyticsConnector2 = (AnalyticsConnector) this.analyticsConnector.get();
        if (analyticsConnector2 != null) {
            JSONObject jSONObject = configContainer.personalizationMetadata;
            if (jSONObject.length() >= 1) {
                JSONObject jSONObject2 = configContainer.configsJson;
                if (jSONObject2.length() >= 1) {
                    JSONObject optJSONObject = jSONObject.optJSONObject(str);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("choiceId");
                        if (!optString.isEmpty()) {
                            synchronized (this.loggedChoiceIds) {
                                if (!optString.equals(this.loggedChoiceIds.get(str))) {
                                    this.loggedChoiceIds.put(str, optString);
                                    Bundle outline14 = GeneratedOutlineSupport.outline14("arm_key", str);
                                    outline14.putString("arm_value", jSONObject2.optString(str));
                                    outline14.putString("personalization_id", optJSONObject.optString("personalizationId"));
                                    outline14.putInt("arm_index", optJSONObject.optInt("armIndex", -1));
                                    outline14.putString("group", optJSONObject.optString("group"));
                                    analyticsConnector2.logEvent("fp", "personalization_assignment", outline14);
                                    Bundle bundle = new Bundle();
                                    bundle.putString("_fpid", optString);
                                    analyticsConnector2.logEvent("fp", "_fpc", bundle);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
