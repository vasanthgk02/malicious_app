package com.mpl.androidapp.utils;

import android.content.Context;
import com.mpl.analytics.kafka.AnalyticsHelper;
import com.mpl.analytics.kafka.Config;

public class KafkaUtils {
    public static final String TAG = "KafkaUtils";
    public static Config mAnalyticsConfig;
    public static AnalyticsHelper mAnalyticsHelper;

    public static Config getAnalyticsConfig() {
        return mAnalyticsConfig;
    }

    public static AnalyticsHelper getAnalyticsHelper() {
        return mAnalyticsHelper;
    }

    public static void initKafkaAnalytics(Context context) {
        MLogger.d(TAG, "initKafkaAnalytics: ");
        if (mAnalyticsConfig == null) {
            MLogger.d(TAG, "initKafkaAnalytics:Creating Analytics instance ");
            Config config = new Config();
            mAnalyticsConfig = config;
            config.setLogEnabled(MBuildConfigUtils.isLogEnabled());
            mAnalyticsHelper = AnalyticsHelper.getInstance(context.getApplicationContext(), mAnalyticsConfig);
            return;
        }
        MLogger.d(TAG, "initKafkaAnalytics: Already created");
    }
}
