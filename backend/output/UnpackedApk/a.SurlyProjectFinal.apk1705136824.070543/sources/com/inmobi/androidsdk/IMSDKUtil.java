package com.inmobi.androidsdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import com.inmobi.androidsdk.impl.Constants;
import com.inmobi.androidsdk.impl.InMobiAndroidTrackerHTTPRequest;

public class IMSDKUtil {
    public static void setLogLevel(int level) {
        if (level != 0 && level != 1) {
            throw new IllegalArgumentException("Currently, log level can only be 0 or 1");
        } else if (level == 0) {
            Constants.DEBUG = false;
        } else if (level == 1) {
            Constants.DEBUG = true;
        }
    }

    public static String getSDKVersion() {
        return Constants.SDK_VERSION;
    }

    public static synchronized void sendAppTrackerConversion(final Context context, final String advertiserId) {
        synchronized (IMSDKUtil.class) {
            if (context == null || advertiserId == null) {
                throw new NullPointerException("Arguments cannot be null.");
            } else if (advertiserId.trim().equals(Constants.QA_SERVER_URL)) {
                throw new IllegalArgumentException("Advertiser ID cannot be empty.");
            } else {
                SharedPreferences prefs = context.getSharedPreferences("InMobi_Prefs_key", 0);
                final Editor editor = prefs.edit();
                if (prefs.getString("InMobi_Prefs_key", null) == null) {
                    if (Constants.DEBUG) {
                        Log.d(Constants.LOGGING_TAG, "App tracker ping is not sent. Sending now...");
                    }
                    new Thread() {
                        public void run() {
                            boolean success = new InMobiAndroidTrackerHTTPRequest(context, advertiserId).setupConnection();
                            if (Constants.DEBUG) {
                                Log.d(Constants.LOGGING_TAG, "Ping Status: " + success);
                            }
                            if (success) {
                                editor.putString("InMobi_Prefs_key", "InMobiAdCampaign");
                                editor.commit();
                            }
                        }
                    }.start();
                }
            }
        }
    }
}
