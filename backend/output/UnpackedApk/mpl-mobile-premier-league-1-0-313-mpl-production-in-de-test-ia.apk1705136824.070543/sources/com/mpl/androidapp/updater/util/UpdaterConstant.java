package com.mpl.androidapp.updater.util;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.utils.Constant;
import com.mpl.androidapp.utils.MBuildConfigUtils;

public interface UpdaterConstant {
    public static final int APK_MIN_VERSION_CODE_ID = 100000;
    public static final int APK_MIN_VERSION_CODE_IN = 1000000;
    public static final String CONFIG_UPDATER_EXPERIMENTAL_V2_ENABLED = "updater.v2.experimental.enabled";
    public static final String CONFIG_UPDATER_V2_ENABLED = "updater.v2.enabled";
    public static final String FAILURE = "Api request failed";
    public static final String SUCCESS = "Success";
    public static final String UPDATER_ID = "updater_channel";
    public static final String UPDATE_APK_DELAY_TIME = "updates.apk.delay.timeV2";
    public static final String UPDATE_APK_DELAY_TIME_UNIT = "updates.apk.delay.time.unitV2";
    public static final String UPDATE_LOGIN_TIME = "loginTimeUpdaterV2";

    public interface Api {
        public static final String ANDROID = "/android/";
        public static final String ASSETS = "assets";
        public static final String BASE_URL = GeneratedOutlineSupport.outline62(new StringBuilder(), Constant.SET_BASE_URL, "/updates");
        public static final String HEADER_KEY = "Authorization";
        public static final String REACT_BUNDLE = "/react/";
    }

    public interface AppEvents {
        public static final int ACTION_MQTT_MESSAGE_RECEIVED = 4;
        public static final int ACTION_MQTT_SUBSCRIPTION = 3;
        public static final int ACTION_PROCEED_AFTER_LOGIN_DATA = 1;
        public static final int ACTION_PROCEED_HOME_DATA = 2;
        public static final int ACTION_PROCEED_HOME_DATA_LOAD_COMPLETED = 9;
        public static final int BIND_SERVICE_EVENT = 8;
        public static final int DOWNLOAD_ASSETS_BUNDLE = 5;
        public static final int INTEGRITY_EVENT = 7;
        public static final int REACT_BUNDLE_DOWNLOADED = 6;
    }

    public interface Assets {
        public static final String ASSETS_VERSION = "assetVersion";
        public static final String GAME_ID = "game_id";
        public static final String GAME_NAME = "game_name";
        public static final String GAME_VERSION = "gameVersion";
    }

    public interface Event {
        public static final String ACTION_MQTT_MESSAGE_RECEIVED = (MBuildConfigUtils.getApplicationId() + ".action.ACTION_MQTT_MESSAGE_RECEIVED");
        public static final String ACTION_MQTT_SUBSCRIPTION = (MBuildConfigUtils.getApplicationId() + ".action.MQTT_SUBSCRIPTION");
        public static final String ACTION_PROCEED_AFTER_LOGIN_DATA = (MBuildConfigUtils.getApplicationId() + ".action.PROCEED_AFTER_LOGIN_DATA");
        public static final String ACTION_PROCEED_HOME_DATA = (MBuildConfigUtils.getApplicationId() + ".action.PROCEED_HOME_DATA");
        public static final String ACTION_PROCEED_HOME_DATA_LOAD_COMPLETED = (MBuildConfigUtils.getApplicationId() + ".action.PROCEED_HOME_DATA_LOAD_COMPLETED");
        public static final String BIND_SERVICE_EVENT = "com.mpl.androidapp.bindservice";
        public static final String DOWNLOADED_ASSETS_DATA = "assets_data";
        public static final String DOWNLOAD_ASSETS_BUNDLE = "download_assets_bundle";
        public static final String GAME_ASSETS_TAG = "game_assets_tag";
        public static final String INTEGRITY_EVENT = "com.mpl.androidapp.integrity";
        public static final String IS_APP_SERVICE = "is_app_service";
        public static final String REACT_BUNDLE_DOWNLOADED = "react_bundle_downloaded";
        public static final String SET_REACT_CONTENT = "set_react_content";
        public static final String STATUS = "integrity_status";
    }

    public interface GEFile {
        public static final String GAME = "game";
        public static final String GAME_ASSETS_NEW_ZIP = "mplassets.zip";
        public static final String GAME_ASSETS_NEW_ZIP_88 = "mplgameassets.zip";
        public static final String GAME_DIR = "assets";
        public static final String GAME_DIR_NEW = "mplassets";
        public static final String GAME_DIR_NEW_88 = "mplgameassets";
    }

    public interface Response {
        public static final String ASSETS_VERSION = "assetVersion";
        public static final String CRITICAL = "critical";
        public static final String DESCRIPTION = "description";
        public static final String DOWNLOAD_URL = "downloadUrl";
        public static final String GAME_ASSETS_ID = "game_assets_id";
        public static final String GAME_CODE_ID = "game_code_id";
        public static final String GAME_NAME = "gameName";
        public static final String GAME_VERSION = "gameVersion";
        public static final String HASH = "hash";
        public static final String PAYLOAD = "payload";
        public static final String RELEASE_NOTES = "releaseNotes";
        public static final String RELEASE_POINTS = "releasePoints";
        public static final String SHOULD_RELOAD = "installationMode";
        public static final String SIZE = "size";
        public static final String SLIM_APK = "slimApk";
        public static final String URL = "url";
        public static final String VERSION_CODE = "versionCode";
    }

    public interface SharedPref {
        public static final String IS_FIRST_TIME_APP_LAUNCHED_AFTER_INSTALL = "is_first_time_app_launched_after_install";
        public static final String IS_FIRST_TIME_APP_LOAD = "is_first_time_app_load";
        public static final String IS_FIRST_TIME_ASSETS_LOAD = "is_first_time_assets_load";
        public static final String IS_RELEASE_NOTES_SCREEN_REQUIRED = "shared_pref_should_show_release_notes";
        public static final String SHARED_PREF_ACTIVE_ANDROID_VERSION_CODE = "shared_pref_active_android_version_code";
        public static final String SHARED_PREF_ACTIVE_REACT_BUNDLE_VERSION_CODE = "shared_pref_active_react_bundle_version_code";
        public static final String SHARED_PREF_ANDROID_VERSION_CODE = "shared_pref_android_version_code";
        public static final String SHARED_PREF_APP_CRITICAL = "shared_pref_app_critical";
        public static final String SHARED_PREF_APP_DOWNLOADING_HASH = "shared_pref_app_downloading_hash";
        public static final String SHARED_PREF_APP_DOWNLOAD_URL = "shared_pref_app_download_url";
        public static final String SHARED_PREF_APP_HASH = "shared_pref_app_hash";
        public static final String SHARED_PREF_APP_IN_PROGRESS_DOWNLOAD_VERSION_CODE = "shared_pref_app_in_progress_download_code";
        public static final String SHARED_PREF_APP_MIN_VERSION_CODE = "shared_pref_min_app_version_code";
        public static final String SHARED_PREF_CRITICAL_DOWNLOAD_BACKGROUND = "shared_pref_critical_download_background";
        public static final String SHARED_PREF_DOWNLOADED_REACT_BUNDLE_VERSION_CODE = "shared_pref_downloaded_react_bundle_version_code";
        public static final String SHARED_PREF_REACT_BUNDLE_CRITICAL = "shared_pref_react_bundle_critical";
        public static final String SHARED_PREF_REACT_BUNDLE_DOWNLOADING_HASH = "shared_pref_react_bundle_downloading_hash";
        public static final String SHARED_PREF_REACT_BUNDLE_DOWNLOAD_URL = "shared_pref_react_bundle_download_url";
        public static final String SHARED_PREF_REACT_BUNDLE_HASH = "shared_pref_react_bundle_hash";
        public static final String SHARED_PREF_REACT_BUNDLE_IN_PROGRESS_DOWNLOAD_VERSION_CODE = "shared_pref_react_bundle_in_progress_download_code";
        public static final String SHARED_PREF_REACT_BUNDLE_VERSION_CODE = "shared_pref_react_bundle_version_code";
        public static final String SHARED_PREF_REACT_MIN_VERSION_CODE = "shared_pref_min_rn_bundle_version_code";
        public static final String SHARED_PREF_SHOULD_RELOAD_REACT = "shared_pref_should_reload_react";
    }
}
