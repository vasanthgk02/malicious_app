package com.clevertap.android.sdk.response;

import android.content.Context;
import com.clevertap.android.sdk.CallbackManager;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.ControllerManager;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.featureFlags.CTFeatureFlagsController;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FeatureFlagResponse extends CleverTapResponseDecorator {
    public final CleverTapResponse cleverTapResponse;
    public final CleverTapInstanceConfig config;
    public final ControllerManager controllerManager;
    public final Logger logger;

    public FeatureFlagResponse(CleverTapResponse cleverTapResponse2, CleverTapInstanceConfig cleverTapInstanceConfig, ControllerManager controllerManager2) {
        this.cleverTapResponse = cleverTapResponse2;
        this.config = cleverTapInstanceConfig;
        this.logger = cleverTapInstanceConfig.getLogger();
        this.controllerManager = controllerManager2;
    }

    public final void parseFeatureFlags(JSONObject jSONObject) throws JSONException {
        if (jSONObject.getJSONArray("kv") != null) {
            CTFeatureFlagsController cTFeatureFlagsController = this.controllerManager.ctFeatureFlagsController;
            if (cTFeatureFlagsController != null) {
                synchronized (cTFeatureFlagsController) {
                    JSONArray jSONArray = jSONObject.getJSONArray("kv");
                    int i = 0;
                    while (i < jSONArray.length()) {
                        try {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                            cTFeatureFlagsController.store.put(jSONObject2.getString("n"), Boolean.valueOf(jSONObject2.getBoolean("v")));
                            i++;
                        } catch (JSONException e2) {
                            Logger configLogger = cTFeatureFlagsController.getConfigLogger();
                            String logTag = cTFeatureFlagsController.getLogTag();
                            configLogger.verbose(logTag, "Error parsing Feature Flag array " + e2.getLocalizedMessage());
                        }
                    }
                    Logger configLogger2 = cTFeatureFlagsController.getConfigLogger();
                    String logTag2 = cTFeatureFlagsController.getLogTag();
                    configLogger2.verbose(logTag2, "Updating feature flags..." + cTFeatureFlagsController.store);
                    cTFeatureFlagsController.archiveData(jSONObject);
                    if (((CallbackManager) cTFeatureFlagsController.mCallbackManager) == null) {
                        throw null;
                    }
                }
                return;
            }
        }
        this.config.getLogger().verbose(this.config.accountId, (String) "Feature Flag : Can't parse feature flags, CTFeatureFlagsController is null");
    }

    public void processResponse(JSONObject jSONObject, String str, Context context) {
        this.logger.verbose(this.config.accountId, (String) "Processing Feature Flags response...");
        CleverTapInstanceConfig cleverTapInstanceConfig = this.config;
        if (cleverTapInstanceConfig.analyticsOnly) {
            this.logger.verbose(cleverTapInstanceConfig.accountId, (String) "CleverTap instance is configured to analytics only, not processing Feature Flags response");
            this.cleverTapResponse.processResponse(jSONObject, str, context);
        } else if (jSONObject == null) {
            this.logger.verbose(cleverTapInstanceConfig.accountId, (String) "Feature Flag : Can't parse Feature Flags Response, JSON response object is null");
        } else if (!jSONObject.has("ff_notifs")) {
            this.logger.verbose(this.config.accountId, (String) "Feature Flag : JSON object doesn't contain the Feature Flags key");
            this.cleverTapResponse.processResponse(jSONObject, str, context);
        } else {
            try {
                this.logger.verbose(this.config.accountId, (String) "Feature Flag : Processing Feature Flags response");
                parseFeatureFlags(jSONObject.getJSONObject("ff_notifs"));
            } catch (Throwable th) {
                this.logger.verbose(this.config.accountId, "Feature Flag : Failed to parse response", th);
            }
            this.cleverTapResponse.processResponse(jSONObject, str, context);
        }
    }
}
