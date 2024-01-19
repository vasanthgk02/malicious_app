package com.clevertap.android.sdk.response;

import android.content.Context;
import com.clevertap.android.sdk.BaseCallbackManager;
import com.clevertap.android.sdk.CallbackManager;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.Logger;
import org.json.JSONObject;

public class GeofenceResponse extends CleverTapResponseDecorator {
    public final BaseCallbackManager callbackManager;
    public final CleverTapResponse cleverTapResponse;
    public final CleverTapInstanceConfig config;
    public final Logger logger;

    public GeofenceResponse(CleverTapResponse cleverTapResponse2, CleverTapInstanceConfig cleverTapInstanceConfig, BaseCallbackManager baseCallbackManager) {
        this.cleverTapResponse = cleverTapResponse2;
        this.config = cleverTapInstanceConfig;
        this.logger = cleverTapInstanceConfig.getLogger();
        this.callbackManager = baseCallbackManager;
    }

    public void processResponse(JSONObject jSONObject, String str, Context context) {
        this.logger.verbose(this.config.accountId, (String) "Processing GeoFences response...");
        CleverTapInstanceConfig cleverTapInstanceConfig = this.config;
        if (cleverTapInstanceConfig.analyticsOnly) {
            this.logger.verbose(cleverTapInstanceConfig.accountId, (String) "CleverTap instance is configured to analytics only, not processing geofence response");
            this.cleverTapResponse.processResponse(jSONObject, str, context);
        } else if (jSONObject == null) {
            this.logger.verbose(cleverTapInstanceConfig.accountId, (String) "Geofences : Can't parse Geofences Response, JSON response object is null");
        } else if (!jSONObject.has("geofences")) {
            this.logger.verbose(this.config.accountId, (String) "Geofences : JSON object doesn't contain the Geofences key");
            this.cleverTapResponse.processResponse(jSONObject, str, context);
        } else {
            try {
                if (((CallbackManager) this.callbackManager) != null) {
                    this.logger.debug(this.config.accountId, "Geofences : Geofence SDK has not been initialized to handle the response");
                    this.cleverTapResponse.processResponse(jSONObject, str, context);
                    return;
                }
                throw null;
            } catch (Throwable th) {
                this.logger.verbose(this.config.accountId, "Geofences : Failed to handle Geofences response", th);
            }
        }
    }
}
