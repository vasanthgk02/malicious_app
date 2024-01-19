package com.paypal.android.sdk.onetouch.core.config;

import com.paypal.android.sdk.onetouch.core.enums.Protocol;
import com.paypal.android.sdk.onetouch.core.enums.RequestTarget;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ConfigFileParser {
    public final void addEnvironment(OAuth2Recipe oAuth2Recipe, String str, JSONObject jSONObject) throws JSONException {
        oAuth2Recipe.mEndpoints.put(str, new ConfigEndpoint(str, jSONObject.getString("url"), jSONObject.getString("certificate")));
    }

    public final void populateCommonData(Recipe<?> recipe, JSONObject jSONObject) throws JSONException {
        recipe.mTarget = RequestTarget.valueOf(jSONObject.getString("target"));
        Recipe recipe2 = recipe.getThis();
        String string = jSONObject.getString("protocol");
        if (recipe2 != null) {
            recipe2.mProtocol = Protocol.getProtocol(string);
            recipe2.getThis();
            if (jSONObject.has("intent_action")) {
                recipe.mTargetIntentAction = jSONObject.getString("intent_action");
                recipe.getThis();
            }
            JSONArray jSONArray = jSONObject.getJSONArray("packages");
            for (int i = 0; i < jSONArray.length(); i++) {
                recipe.mTargetPackagesInReversePriorityOrder.add(jSONArray.getString(i));
                recipe.getThis();
            }
            if (jSONObject.has("supported_locales")) {
                JSONArray jSONArray2 = jSONObject.getJSONArray("supported_locales");
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    recipe.mSupportedLocales.add(jSONArray2.getString(i2));
                    recipe.getThis();
                }
                return;
            }
            return;
        }
        throw null;
    }
}
