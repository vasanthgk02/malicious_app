package com.rudderstack.android.sdk.core;

import android.app.Application;
import android.content.SharedPreferences;
import com.android.tools.r8.GeneratedOutlineSupport;

public class RudderPreferenceManager {
    public static final String RUDDER_ANONYMOUS_ID_KEY = "rl_anonymous_id_key";
    public static final String RUDDER_APPLICATION_INFO_KEY = "rl_application_info_key";
    public static final String RUDDER_EXTERNAL_ID_KEY = "rl_external_id";
    public static final String RUDDER_OPT_IN_TIME_KEY = "rl_opt_in_time";
    public static final String RUDDER_OPT_OUT_TIME_KEY = "rl_opt_out_time";
    public static final String RUDDER_OPT_STATUS_KEY = "rl_opt_status";
    public static final String RUDDER_PERIODIC_WORK_REQUEST_ID_KEY = "rl_periodic_work_request_key";
    public static final String RUDDER_PREFS = "rl_prefs";
    public static final String RUDDER_SERVER_CONFIG_KEY = "rl_server_config";
    public static final String RUDDER_SERVER_CONFIG_LAST_UPDATE_KEY = "rl_server_last_updated";
    public static final String RUDDER_TRAITS_KEY = "rl_traits";
    public static RudderPreferenceManager instance;
    public static SharedPreferences preferences;

    public RudderPreferenceManager(Application application) {
        preferences = application.getSharedPreferences(RUDDER_PREFS, 0);
    }

    public static RudderPreferenceManager getInstance(Application application) {
        if (instance == null) {
            instance = new RudderPreferenceManager(application);
        }
        return instance;
    }

    public void clearExternalIds() {
        GeneratedOutlineSupport.outline93(preferences, RUDDER_EXTERNAL_ID_KEY);
    }

    public String getAnonymousId() {
        return preferences.getString(RUDDER_ANONYMOUS_ID_KEY, null);
    }

    public int getBuildVersionCode() {
        return preferences.getInt(RUDDER_APPLICATION_INFO_KEY, -1);
    }

    public String getExternalIds() {
        return preferences.getString(RUDDER_EXTERNAL_ID_KEY, null);
    }

    public long getLastUpdatedTime() {
        return preferences.getLong(RUDDER_SERVER_CONFIG_LAST_UPDATE_KEY, -1);
    }

    public long getOptInTime() {
        return preferences.getLong(RUDDER_OPT_IN_TIME_KEY, -1);
    }

    public long getOptOutTime() {
        return preferences.getLong(RUDDER_OPT_OUT_TIME_KEY, -1);
    }

    public boolean getOptStatus() {
        return preferences.getBoolean(RUDDER_OPT_STATUS_KEY, false);
    }

    public String getPeriodicWorkRequestId() {
        return preferences.getString(RUDDER_PERIODIC_WORK_REQUEST_ID_KEY, null);
    }

    public String getTraits() {
        return preferences.getString(RUDDER_TRAITS_KEY, null);
    }

    public void saveAnonymousId(String str) {
        preferences.edit().putString(RUDDER_ANONYMOUS_ID_KEY, str).apply();
    }

    public void saveBuildVersionCode(int i) {
        preferences.edit().putInt(RUDDER_APPLICATION_INFO_KEY, i).apply();
    }

    public void saveExternalIds(String str) {
        preferences.edit().putString(RUDDER_EXTERNAL_ID_KEY, str).apply();
    }

    public void saveOptStatus(boolean z) {
        preferences.edit().putBoolean(RUDDER_OPT_STATUS_KEY, z).apply();
    }

    public void savePeriodicWorkRequestId(String str) {
        preferences.edit().putString(RUDDER_PERIODIC_WORK_REQUEST_ID_KEY, str).apply();
    }

    public void saveTraits(String str) {
        preferences.edit().putString(RUDDER_TRAITS_KEY, str).apply();
    }

    public void updateLastUpdatedTime() {
        preferences.edit().putLong(RUDDER_SERVER_CONFIG_LAST_UPDATE_KEY, System.currentTimeMillis()).apply();
    }

    public void updateOptInTime() {
        preferences.edit().putLong(RUDDER_OPT_IN_TIME_KEY, System.currentTimeMillis()).apply();
    }

    public void updateOptOutTime() {
        preferences.edit().putLong(RUDDER_OPT_OUT_TIME_KEY, System.currentTimeMillis()).apply();
    }
}
