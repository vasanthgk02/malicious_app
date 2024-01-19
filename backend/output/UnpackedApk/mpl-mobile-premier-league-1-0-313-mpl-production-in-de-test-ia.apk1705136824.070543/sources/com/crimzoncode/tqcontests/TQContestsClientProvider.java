package com.crimzoncode.tqcontests;

import com.crimzoncode.tqcontests.api.ApiClient;
import com.crimzoncode.tqcontests.api.ServiceGenerator;

public class TQContestsClientProvider {
    public static final String TAG = "APPLICATION_CONTROLLER";
    public static ApiClient client;

    public static ApiClient getApiClient(String str, String str2) {
        if (client == null) {
            client = (ApiClient) ServiceGenerator.createService(ApiClient.class, str, str2, BuildConfig.RESPONSE_LOG_LEVEL);
        }
        return client;
    }
}
