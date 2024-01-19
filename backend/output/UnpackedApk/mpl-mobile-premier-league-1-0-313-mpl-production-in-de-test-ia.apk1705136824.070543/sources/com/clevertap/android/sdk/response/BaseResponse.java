package com.clevertap.android.sdk.response;

import android.content.Context;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.LocalDataStore;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.network.NetworkManager;
import org.json.JSONObject;

public class BaseResponse extends CleverTapResponseDecorator {
    public final CleverTapResponse cleverTapResponse;
    public final CleverTapInstanceConfig config;
    public final LocalDataStore localDataStore;
    public final Logger logger;
    public final NetworkManager networkManager;

    public BaseResponse(CleverTapInstanceConfig cleverTapInstanceConfig, NetworkManager networkManager2, LocalDataStore localDataStore2, CleverTapResponse cleverTapResponse2) {
        this.cleverTapResponse = cleverTapResponse2;
        this.config = cleverTapInstanceConfig;
        this.logger = cleverTapInstanceConfig.getLogger();
        this.networkManager = networkManager2;
        this.localDataStore = localDataStore2;
    }

    public void processResponse(JSONObject jSONObject, String str, Context context) {
        if (str == null) {
            this.logger.verbose(this.config.accountId, (String) "Problem processing queue response, response is null");
            return;
        }
        try {
            this.logger.verbose(this.config.accountId, "Trying to process response: " + str);
            JSONObject jSONObject2 = new JSONObject(str);
            this.cleverTapResponse.processResponse(jSONObject2, str, context);
            this.localDataStore.syncWithUpstream(context, jSONObject2);
        } catch (Throwable th) {
            this.networkManager.responseFailureCount++;
            this.logger.verbose(this.config.accountId, "Problem process send queue response", th);
        }
    }
}
