package com.mpl.analytics;

import android.app.Application;
import com.clevertap.android.sdk.CleverTapAPI;
import com.mpl.androidapp.Featurestag;

public class MPLCleverTapInstance {
    public static final String TAG = "MPLCleverTapInstance";
    public static CleverTapAPI mCleverTapAPI;

    public static void createNotificationChannel(Application application) {
        CleverTapAPI.createNotificationChannel(application, "MPL_CT", Featurestag.CLEVERTAP, "This is default channel for Clevertap notification", 3, true);
    }

    public static CleverTapAPI getCleverTapAPI(Application application) {
        initCleverTap(application);
        return mCleverTapAPI;
    }

    public static CleverTapAPI getCleverTapInstance(Application application) {
        return CleverTapAPI.getDefaultInstance(application);
    }

    public static void initCleverTap(Application application) {
        if (mCleverTapAPI == null) {
            synchronized (MPLCleverTapInstance.class) {
                mCleverTapAPI = getCleverTapInstance(application);
            }
        }
    }
}
