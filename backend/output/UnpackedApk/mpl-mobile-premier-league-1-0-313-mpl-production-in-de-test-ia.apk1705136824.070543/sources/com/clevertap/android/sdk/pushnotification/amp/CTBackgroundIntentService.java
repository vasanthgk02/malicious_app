package com.clevertap.android.sdk.pushnotification.amp;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import com.clevertap.android.sdk.CleverTapAPI;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.CoreState;
import com.clevertap.android.sdk.Logger;
import java.util.HashMap;

public class CTBackgroundIntentService extends IntentService {
    public CTBackgroundIntentService() {
        super("CTBackgroundIntentService");
    }

    public void onHandleIntent(Intent intent) {
        Context applicationContext = getApplicationContext();
        HashMap<String, CleverTapAPI> hashMap = CleverTapAPI.instances;
        if (hashMap == null) {
            CleverTapAPI defaultInstance = CleverTapAPI.getDefaultInstance(applicationContext);
            if (defaultInstance != null) {
                CoreState coreState = defaultInstance.coreState;
                if (coreState.config.backgroundSync) {
                    coreState.pushProviders.runInstanceJobWork(applicationContext, null);
                } else {
                    Logger.d("Instance doesn't allow Background sync, not running the Job");
                }
            }
        } else {
            for (String next : hashMap.keySet()) {
                CleverTapAPI cleverTapAPI = CleverTapAPI.instances.get(next);
                if (cleverTapAPI != null) {
                    CoreState coreState2 = cleverTapAPI.coreState;
                    CleverTapInstanceConfig cleverTapInstanceConfig = coreState2.config;
                    if (cleverTapInstanceConfig.analyticsOnly) {
                        Logger.d(next, "Instance is Analytics Only not processing device token");
                    } else if (!cleverTapInstanceConfig.backgroundSync) {
                        Logger.d(next, "Instance doesn't allow Background sync, not running the Job");
                    } else {
                        coreState2.pushProviders.runInstanceJobWork(applicationContext, null);
                    }
                }
            }
        }
    }
}
