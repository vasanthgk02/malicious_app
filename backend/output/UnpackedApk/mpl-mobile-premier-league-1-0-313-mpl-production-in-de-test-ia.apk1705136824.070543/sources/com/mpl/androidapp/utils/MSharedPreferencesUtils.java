package com.mpl.androidapp.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.gson.Gson;
import com.mpl.androidapp.MPLApplication;
import com.mpl.androidapp.config.ConfigConstant;
import com.mpl.androidapp.config.ConfigManager;
import com.mpl.androidapp.game.AllGame;
import com.mpl.androidapp.imagepicker.HyperVergeKycCapture;
import com.mpl.androidapp.miniprofile.ct.C.Config;
import com.mpl.androidapp.react.MPLReactContainerActivity;
import com.mpl.androidapp.react.UserInfo;
import com.mpl.androidapp.responsiblegaming.RgConfigs;
import com.mpl.androidapp.responsiblegaming.RgSessionInfo;
import com.mpl.androidapp.updater.interactor.DBInteractor;
import com.mpl.androidapp.updater.job.JobSchedulerHelper;
import com.mpl.androidapp.updater.repo.DownloadProgressReceiver;
import com.mpl.androidapp.updater.util.UpdaterConstant;
import com.mpl.androidapp.utils.Constant.EventsConstants;
import com.mpl.securepreferences.MPreferences;
import com.paynimo.android.payment.util.Constant;
import io.hansel.actions.configs.HanselConfigs;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import okhttp3.HttpUrl;
import org.apache.pdfbox.pdfparser.BaseParser;
import org.apache.pdfbox.pdmodel.documentinterchange.taggedpdf.PDLayoutAttributeObject;
import org.joda.time.DateTime;
import org.json.JSONException;
import org.json.JSONObject;

public class MSharedPreferencesUtils {
    public static final String TAG = "MSharedPreferencesUtils";

    public static boolean canSkipPopup() {
        return MPreferences.getBoolean(ConfigConstant.UPDATES2_SKIP_POPUP, false, false);
    }

    public static int challengeContactSyncLimit() {
        String str;
        if (ConfigManager.isSaveAllConfigsToStorage()) {
            str = MPreferences.getString(ConfigConstant.CONFIG_CHALLENGE_CONTACT_SYNC_LIMIT, "1000", true);
        } else {
            str = ConfigManager.getNormalConfig().optString(ConfigConstant.CONFIG_CHALLENGE_CONTACT_SYNC_LIMIT.replaceFirst(ConfigConstant.CONFIG_PREFIX, ""), "1000");
        }
        if (str == null || TextUtils.isEmpty(str)) {
            return 1000;
        }
        return Integer.parseInt(str);
    }

    public static void clearApplicationUserData(Context context) {
        if (context != null) {
            try {
                ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
                if (activityManager != null) {
                    activityManager.clearApplicationUserData();
                }
            } catch (Exception e2) {
                MLogger.e("delete file:", "deleteAllPref: ", e2);
            }
        }
    }

    public static boolean containsKey(String str, boolean z) {
        try {
            return MPreferences.contains(str, z);
        } catch (Exception e2) {
            MLogger.e("containsPref", "containsKey: ", e2);
            return false;
        }
    }

    public static void deleteAllPref(Context context, boolean z) {
        if (context != null) {
            try {
                ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
                if (activityManager != null) {
                    activityManager.clearApplicationUserData();
                    if (z) {
                        CommonUtils.restartApp(context);
                    } else {
                        System.exit(0);
                    }
                }
            } catch (Exception e2) {
                MLogger.e("delete file:", "deleteAllPref: ", e2);
            }
        }
    }

    public static void deleteAllPrefAndRestart(Context context, boolean z) {
        try {
            MLogger.d(TAG, "deleteAllPrefAndRestart:shouldRestart " + z);
            if (context != null) {
                ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
                if (activityManager != null) {
                    activityManager.clearApplicationUserData();
                    if (z) {
                        CommonUtils.restartMPL(context);
                    } else {
                        System.exit(0);
                    }
                }
            }
        } catch (Exception e2) {
            MLogger.e("delete file:", "deleteAllPrefAndRestart: ", e2);
        }
    }

    public static void deleteNormalPref(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constant.SHARED_PREF_NAME, 0);
        if (sharedPreferences != null) {
            GeneratedOutlineSupport.outline93(sharedPreferences, str);
        }
    }

    public static String getAFReferralCode() {
        String str;
        Object e2;
        try {
            str = MPreferences.getString(Constant.AF_REFERRAL_CODE, "", false);
            try {
                if ("null".equalsIgnoreCase(str)) {
                    return "";
                }
            } catch (Exception e3) {
                e2 = e3;
                MLogger.e(Constant.APPS_FLYER_TAG, "getAFReferralCode: ", e2);
                return str;
            }
        } catch (Exception e4) {
            Object obj = e4;
            str = "";
            e2 = obj;
            MLogger.e(Constant.APPS_FLYER_TAG, "getAFReferralCode: ", e2);
            return str;
        }
        return str;
    }

    public static String getAFReferralFeature(Context context, String str, String str2) {
        String stringInNormalPref = getStringInNormalPref(context, str, str2);
        MLogger.d(Constant.APPS_FLYER_TAG, "getAFReferralFeature: ", stringInNormalPref, str, str2);
        return stringInNormalPref;
    }

    public static String getAFReferralSource() {
        try {
            return MPreferences.getString(Constant.AF_REFERRAL_SOURCE, "", false);
        } catch (Exception e2) {
            MLogger.e(Constant.APPS_FLYER_TAG, "getAFReferralSource: ", e2);
            return "";
        }
    }

    public static String getAFSignUpOfferCode() {
        String str;
        Object e2;
        try {
            str = MPreferences.getString(Constant.AF_SIGNUP_CODE, "", false);
            try {
                if ("null".equalsIgnoreCase(str)) {
                    return "";
                }
            } catch (Exception e3) {
                e2 = e3;
                MLogger.e(Constant.APPS_FLYER_TAG, "getAFSignUpOfferCode: ", e2);
                return str;
            }
        } catch (Exception e4) {
            Object obj = e4;
            str = "";
            e2 = obj;
            MLogger.e(Constant.APPS_FLYER_TAG, "getAFSignUpOfferCode: ", e2);
            return str;
        }
        return str;
    }

    public static String getAFSignupSource() {
        try {
            return MPreferences.getString(Constant.AF_SIGNUP_SOURCE, "", false);
        } catch (Exception e2) {
            MLogger.e(Constant.APPS_FLYER_TAG, "getAFSignupSource: ", e2);
            return "";
        }
    }

    public static String getAccessUserToken() {
        return MPreferences.getString("accessToken", null, true);
    }

    public static String getApkUrl() {
        return MPreferences.getString(ConfigConstant.UPDATES2_APK_URL, "", false);
    }

    public static Boolean getAppsFlyerBooleanInNormalPref(String str, boolean z) {
        return Boolean.valueOf(MPreferences.getBoolean(str, z, true));
    }

    public static String getAppsflyerredirectiondata() {
        return MPreferences.getString(Constant.REDIRECTION_DATA, null, true);
    }

    public static long getAssetsDownloadTime(int i) {
        long j = MPreferences.getLong(GeneratedOutlineSupport.outline41(Constant.ASSETS_DOWNLOAD_TIME, i), System.currentTimeMillis(), false);
        MLogger.d(JobSchedulerHelper.TAG, "getAssetsDownloadTime", Long.valueOf(j));
        return j;
    }

    public static boolean getBooleanInNormalPref(Context context, String str, boolean z) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constant.SHARED_PREF_NAME, 0);
        return sharedPreferences != null ? sharedPreferences.getBoolean(str, z) : z;
    }

    public static boolean getBooleanPref(String str, boolean z, boolean z2) {
        try {
            return MPreferences.getBoolean(str, z, z2);
        } catch (Exception e2) {
            MLogger.e(TAG, "", e2);
            return false;
        }
    }

    public static String getCallingCountryConfig() {
        return ConfigManager.getCallingCountryJson() != null ? ConfigManager.getCallingCountryJson().toString() : "{}";
    }

    public static String getChatToken() {
        return MPreferences.getString(Constant.CHAT_TOKEN, null, true);
    }

    public static HashMap<String, String> getCompetitorAppsCheckList() {
        String str;
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            if (ConfigManager.isSaveAllConfigsToStorage()) {
                str = MPreferences.getString(ConfigConstant.GAME_COMPETITOR_APPS_FOR_CHECKLIST, "{}", true);
            } else {
                str = ConfigManager.getNormalConfig().optString(ConfigConstant.GAME_COMPETITOR_APPS_FOR_CHECKLIST.replaceFirst(ConfigConstant.CONFIG_PREFIX, ""), "{}");
            }
            if (str != null && !TextUtils.isEmpty(str) && CommonUtils.isJSONValid(str)) {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.length() > 0) {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        String optString = jSONObject.optString(next);
                        hashMap.put(next, optString);
                        MLogger.d(TAG, "getCompetitorAppsCheckList: ", next, optString);
                    }
                }
            }
        } catch (Exception e2) {
            MLogger.e(TAG, "getTamperedAppsCheckList: ", e2);
        }
        return hashMap;
    }

    public static boolean getCompetitorsAppsListEventCheck() {
        String str;
        if (ConfigManager.isSaveAllConfigsToStorage()) {
            str = MPreferences.getString(Constant.CONFIG_COMPETITOR_APP_CHECK, BaseParser.FALSE, true);
        } else {
            str = ConfigManager.getNormalConfig().optString(Constant.CONFIG_COMPETITOR_APP_CHECK.replaceFirst(ConfigConstant.CONFIG_PREFIX, ""), BaseParser.FALSE);
        }
        if (TextUtils.isEmpty(str) || str == null) {
            return false;
        }
        return Boolean.parseBoolean(str);
    }

    public static String getConfigJson() {
        return ConfigManager.getNormalConfig() != null ? ConfigManager.getNormalConfig().toString() : "";
    }

    public static int getContentObservercount() {
        return MPreferences.getInt(Constant.CONTENT_OBSERVER_COUNT, 0, false);
    }

    public static String getCountryConfig() {
        return ConfigManager.getCountryJson() != null ? ConfigManager.getCountryJson().toString() : "{}";
    }

    public static String getCountryData() {
        return MPreferences.getString(Constant.COUNTRY_DATA, null, true);
    }

    public static String getCountryDataLogin() {
        return CountryUtils.getCountryDataAfterLogin() != null ? CountryUtils.getCountryDataAfterLogin().toString() : "{}";
    }

    public static String getDeepLinkForInstall() {
        try {
            return MPreferences.getString(Constant.AF_INSTALL_DEEP_LINK_DATA, "", false);
        } catch (Exception e2) {
            MLogger.e(TAG, "", e2);
            return "";
        }
    }

    public static String getDeviceId() {
        String stringPref = getStringPref(Constant.DEVICE_ID, "", false);
        return TextUtils.isEmpty(stringPref) ? getStringInNormalPref(MPLApplication.getInstance(), Constant.DEVICE_ID, "") : stringPref;
    }

    public static String getDeviceIdForPreLogin() {
        return getStringInNormalPref(MPLApplication.getInstance(), Constant.DEVICE_ID_CONFIG, "");
    }

    public static int getDownloadedAssetVersion(Context context, int i, int i2) {
        MLogger.d(TAG, AssetsUtils.TAG, "getDownloadedAssetVersion: ", "gameId: ", Integer.valueOf(i), "assetsVersion: ", Integer.valueOf(i2));
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constant.SHARED_PREF_NAME, 0);
        if (sharedPreferences == null) {
            return i2;
        }
        return sharedPreferences.getInt("downloaded_assets_version_" + i, i2);
    }

    public static String getEligibilityCriteria() {
        return MPreferences.getString(ConfigConstant.ELIGIBILITY_CRITERIA, "", false);
    }

    public static String getEntryPoint() {
        return MPreferences.getString("Entry Point", "Splash Screen", true);
    }

    public static float getFloatInNormalPref(Context context, String str, float f2) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constant.SHARED_PREF_NAME, 0);
        return sharedPreferences != null ? sharedPreferences.getFloat(str, f2) : f2;
    }

    public static String getGameHashForGameId(int i) {
        MLogger.d(TAG, Constant.ASSETS_CHECKING, "getGameHashForGameId:1 ", Integer.valueOf(i));
        if (AssetsUtils.isMergedAssetsAreDownloaded(i)) {
            i = CommonUtils.changeToBattleGameId(i);
        }
        MLogger.d(TAG, Constant.ASSETS_CHECKING, "getGameHashForGameId:2 ", Integer.valueOf(i));
        return MPreferences.getString("hash_" + i, "", false);
    }

    public static HashSet<String> getGameIdsListForDebuggingCheck() {
        String str;
        if (ConfigManager.isSaveAllConfigsToStorage()) {
            str = MPreferences.getString(ConfigConstant.GAME_DEBUGGING_OPTION_CHECK_GAME_IDS, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, true);
        } else {
            str = ConfigManager.getNormalConfig().optString(ConfigConstant.GAME_DEBUGGING_OPTION_CHECK_GAME_IDS.replaceFirst(ConfigConstant.CONFIG_PREFIX, ""), HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        }
        HashSet<String> hashSet = new HashSet<>();
        return (str == null || TextUtils.isEmpty(str) || !CommonUtils.isJSONArrayValid(str)) ? hashSet : (HashSet) new Gson().fromJson(str, HashSet.class);
    }

    public static HashSet<String> getGameIdsListForMagnificationCheck() {
        HashSet<String> hashSet = new HashSet<>();
        if (ConfigManager.getNormalConfig() == null || TextUtils.isEmpty(ConfigManager.getNormalConfig().optString(ConfigConstant.GAME_MAGNIFICATION_OPTION_CHECK_GAME_IDS, ""))) {
            return hashSet;
        }
        String optString = ConfigManager.getNormalConfig().optString(ConfigConstant.GAME_MAGNIFICATION_OPTION_CHECK_GAME_IDS, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        return CommonUtils.isJSONArrayValid(optString) ? (HashSet) new Gson().fromJson(optString, HashSet.class) : hashSet;
    }

    public static HashSet<String> getGameIdsListForTamperCheck() {
        String str;
        if (ConfigManager.isSaveAllConfigsToStorage()) {
            str = MPreferences.getString(ConfigConstant.GAME_TAMPER_APPS_CHECK_GAME_IDS, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, true);
        } else {
            str = ConfigManager.getNormalConfig().optString(ConfigConstant.GAME_TAMPER_APPS_CHECK_GAME_IDS.replaceFirst(ConfigConstant.CONFIG_PREFIX, ""), HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        }
        HashSet<String> hashSet = new HashSet<>();
        return (str == null || TextUtils.isEmpty(str) || !CommonUtils.isJSONArrayValid(str)) ? hashSet : (HashSet) new Gson().fromJson(str, HashSet.class);
    }

    public static String getGameListToBlockBasedOnRam() {
        if (ConfigManager.isSaveAllConfigsToStorage()) {
            return MPreferences.getString(ConfigConstant.MIN_GAME_LIST_TO_BLOCK, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, true);
        }
        return ConfigManager.getNormalConfig().optString(ConfigConstant.MIN_GAME_LIST_TO_BLOCK.replaceFirst(ConfigConstant.CONFIG_PREFIX, ""), HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
    }

    public static long getGamePlayedTime(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            currentTimeMillis = MPreferences.getLong(Constant.LAST_PLAYED_TIME + i, currentTimeMillis, false);
            MLogger.d(JobSchedulerHelper.TAG, "getGamePlayedTime", Long.valueOf(currentTimeMillis));
            return currentTimeMillis;
        } catch (Exception e2) {
            MLogger.e(TAG, "getGamePlayedTime: ", e2);
            return currentTimeMillis;
        }
    }

    public static String getGameReminderMessage(Context context) {
        return getStringInNormalPref(context, ConfigConstant.NOTIFICATION_GAME_REMINDER_MESSAGE, "More than Rs.2 Crore worth of prizes daily!");
    }

    public static String getGameReminderTitle(Context context) {
        return getStringInNormalPref(context, ConfigConstant.NOTIFICATION_GAME_REMINDER_TITLE, "Play your first game for FREE");
    }

    public static HashSet<String> getGamesWithoutAssetsDownload() {
        String str;
        if (ConfigManager.isSaveAllConfigsToStorage()) {
            str = MPreferences.getString(ConfigConstant.CONFIG_GAME_THIRD_PARTIES_GAME_IDS, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, true);
        } else {
            str = ConfigManager.getNormalConfig().optString(ConfigConstant.CONFIG_GAME_THIRD_PARTIES_GAME_IDS.replaceFirst(ConfigConstant.CONFIG_PREFIX, ""), HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        }
        HashSet<String> hashSet = new HashSet<>();
        return (str == null || TextUtils.isEmpty(str) || !CommonUtils.isJSONArrayValid(str)) ? hashSet : (HashSet) new Gson().fromJson(str, HashSet.class);
    }

    public static String getGoogleKey() {
        if (ConfigManager.isSaveAllConfigsToStorage()) {
            return MPreferences.getString(ConfigConstant.CONFIG_GOOGLE_YOUTUBE_KEY, MBuildConfigUtils.getGoogleApiKey(), true);
        }
        return ConfigManager.getNormalConfig().optString(ConfigConstant.CONFIG_GOOGLE_YOUTUBE_KEY.replaceFirst(ConfigConstant.CONFIG_PREFIX, ""), MBuildConfigUtils.getGoogleApiKey());
    }

    public static boolean getGuestUserLogin() {
        return MPreferences.getBoolean(ConfigConstant.IS_GUEST_USER_LOGIN, false, false);
    }

    public static String getHanselConfig() {
        return ConfigManager.getHanselConfig() != null ? ConfigManager.getHanselConfig().toString() : "{}";
    }

    public static String getHomeData() {
        return getStringInNormalPref(MPLApplication.getInstance(), "com.mpl.androidapp.home", Constant.HOME_DATA, null);
    }

    public static String getHomeDataAndroid() {
        return getStringInNormalPref(MPLApplication.getInstance(), "com.mpl.androidapp.home.android", "home_data_android", null);
    }

    public static int getIntInNormalPref(Context context, String str, int i) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constant.SHARED_PREF_NAME, 0);
        return sharedPreferences != null ? sharedPreferences.getInt(str, i) : i;
    }

    public static int getIntPref(String str, int i, boolean z) {
        try {
            return MPreferences.getInt(str, i, z);
        } catch (Exception e2) {
            MLogger.e(TAG, "", e2);
            return 0;
        }
    }

    public static long getIntervalTimeForScheduleDeletionFromConfig() {
        String string = MPreferences.getString(ConfigConstant.ASSETS_DELETION_TIME_INTERVAL, "1440", false);
        if (string == null || TextUtils.isEmpty(string)) {
            return TimeUnit.MINUTES.toMillis(1440);
        }
        return TimeUnit.MINUTES.toMillis((long) Integer.parseInt(string));
    }

    public static String getJwtToken() {
        String string = MPreferences.getString(Constant.JWT_TOKEN, "", true);
        if (string == null || TextUtils.isEmpty(string)) {
            return "";
        }
        return string;
    }

    public static String getLastDauEventTime() {
        try {
            return MPreferences.getString(Constant.LAST_DAU_EVENT_TIME, "", false);
        } catch (Exception e2) {
            MLogger.e(TAG, "", e2);
            return "";
        }
    }

    public static String getLastDauEventToClevertapTime() {
        try {
            return MPreferences.getString(Constant.LAST_DAU_EVENT_TIME_TO_CLEVERTAP, "", false);
        } catch (Exception e2) {
            MLogger.e(TAG, "", e2);
            return "";
        }
    }

    public static int getLastInstalledAppVersion() {
        return MPreferences.getInt(Constant.LAST_INSTALLED_ANDROID_VERSION, 0, false);
    }

    public static int getLastInstalledAppVersionForEvent() {
        return MPreferences.getInt(Constant.LAST_INSTALLED_ANDROID_VERSION_V2, 0, false);
    }

    public static int getLastInstalledReactVersion() {
        return MPreferences.getInt(Constant.LAST_INSTALLED_REACT_VERSION, 0, false);
    }

    public static long getLastTimeEventSentTime(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constant.SHARED_PREF_NAME, 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getLong(Constant.COMPETITOR_EVENT_SENT_TIME, 0);
        }
        return 0;
    }

    public static String getLocale() {
        return MPreferences.getString("locale", null, true);
    }

    public static String getLocationProps(Context context) {
        return getStringInNormalPref(context, Constant.DEVICE_LOCATION_PROPS, EventsConstants.PROP_LOCATION_EMPTY);
    }

    public static long getLongInNormalPref(Context context, String str, long j) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constant.SHARED_PREF_NAME, 0);
        return sharedPreferences != null ? sharedPreferences.getLong(str, j) : j;
    }

    public static long getLongPref(String str, long j, boolean z) {
        try {
            return MPreferences.getLong(str, j, z);
        } catch (Exception e2) {
            MLogger.e(TAG, "", e2);
            return 0;
        }
    }

    public static String getMQTTClientPrefix() {
        String str;
        if (ConfigManager.isSaveAllConfigsToStorage()) {
            str = MPreferences.getString(ConfigConstant.CONFIG_MQTT_CLIENT_PREFIX, MBuildConfigUtils.getMQTTClientTopicEntry(), true);
        } else {
            str = ConfigManager.getNormalConfig().optString(ConfigConstant.CONFIG_MQTT_CLIENT_PREFIX.replaceFirst(ConfigConstant.CONFIG_PREFIX, ""), MBuildConfigUtils.getMQTTClientTopicEntry());
        }
        if (str == null || TextUtils.isEmpty(str)) {
            return MBuildConfigUtils.getMQTTClientTopicEntry();
        }
        return str;
    }

    public static String getMQTTServerPrefix() {
        String str;
        if (ConfigManager.isSaveAllConfigsToStorage()) {
            str = MPreferences.getString(ConfigConstant.CONFIG_MQTT_SERVER_PREFIX, MBuildConfigUtils.getMQTTServerTopicEntry(), true);
        } else {
            str = ConfigManager.getNormalConfig().optString(ConfigConstant.CONFIG_MQTT_SERVER_PREFIX.replaceFirst(ConfigConstant.CONFIG_PREFIX, ""), MBuildConfigUtils.getMQTTServerTopicEntry());
        }
        if (str == null || TextUtils.isEmpty(str)) {
            return MBuildConfigUtils.getMQTTServerTopicEntry();
        }
        return str;
    }

    public static long getMQTTTimeEscape() {
        String str;
        if (ConfigManager.isSaveAllConfigsToStorage()) {
            str = MPreferences.getString(ConfigConstant.CONFIG_MQTT_IGNORE_MESSAGE_TIME, Constant.BANKCODE_ICICI, true);
        } else {
            str = ConfigManager.getNormalConfig().optString(ConfigConstant.CONFIG_MQTT_IGNORE_MESSAGE_TIME.replaceFirst(ConfigConstant.CONFIG_PREFIX, ""), Constant.BANKCODE_ICICI);
        }
        if (str == null || TextUtils.isEmpty(str)) {
            return 600000;
        }
        return TimeUnit.MINUTES.toMillis((long) Integer.parseInt(str));
    }

    public static String getMQTTUrl() {
        String str;
        if (ConfigManager.isSaveAllConfigsToStorage()) {
            str = MPreferences.getString(ConfigConstant.CONFIG_MQTT_URL, "ssl://dmqtt.mpl.live:8883", true);
        } else {
            str = ConfigManager.getNormalConfig().optString(ConfigConstant.CONFIG_MQTT_URL.replaceFirst(ConfigConstant.CONFIG_PREFIX, ""), "ssl://dmqtt.mpl.live:8883");
        }
        if (TextUtils.isEmpty(str)) {
            return "ssl://dmqtt.mpl.live:8883";
        }
        return str;
    }

    public static long getMinGamePlayedTimeForDeletionFromConfig() {
        try {
            String string = MPreferences.getString(ConfigConstant.MIN_PLAYED_TIME_FOR_DELETION, Constant.DEFAULT_VALUE_FOR_DELETION, false);
            if (string != null) {
                if (!TextUtils.isEmpty(string)) {
                    return TimeUnit.MINUTES.toMillis((long) Integer.parseInt(string));
                }
            }
            return TimeUnit.MINUTES.toMillis((long) Integer.parseInt(Constant.DEFAULT_VALUE_FOR_DELETION));
        } catch (Exception e2) {
            MLogger.e(TAG, "getMinGamePlayedTimeForDeletionFromConfig: ", e2);
            return TimeUnit.MINUTES.toMillis((long) Integer.parseInt("10080"));
        }
    }

    public static int getMinRamForEnableGameConfig() {
        String str;
        String str2 = "2013";
        if (ConfigManager.isSaveAllConfigsToStorage()) {
            str = MPreferences.getString(ConfigConstant.MIN_RAM_FOR_ENABLE_GAME, str2, true);
        } else {
            str = ConfigManager.getNormalConfig().optString(ConfigConstant.MIN_RAM_FOR_ENABLE_GAME.replaceFirst(ConfigConstant.CONFIG_PREFIX, ""), str2);
        }
        if (str != null) {
            str2 = str;
        }
        return Integer.parseInt(str2);
    }

    public static String getMobileNumberInNormalPref(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constant.SHARED_PREF_NAME, 0);
        String str = "";
        if (sharedPreferences != null && sharedPreferences.contains(Constant.USER_MOBILE_NUMBER_NORMAL)) {
            str = sharedPreferences.getString(Constant.USER_MOBILE_NUMBER_NORMAL, str);
        }
        MLogger.d("mobileNumber", "getMobileNumberInNormalPref", str);
        return str;
    }

    public static int getMqttKeepAliveInterval() {
        String str;
        if (ConfigManager.isSaveAllConfigsToStorage()) {
            str = MPreferences.getString(ConfigConstant.CONFIG_MQTT_KEEP_ALIVE_TIME, "30", true);
        } else {
            str = ConfigManager.getNormalConfig().optString(ConfigConstant.CONFIG_MQTT_KEEP_ALIVE_TIME.replaceFirst(ConfigConstant.CONFIG_PREFIX, ""), "30");
        }
        if (str == null || TextUtils.isEmpty(str)) {
            return 30;
        }
        return Integer.parseInt(str);
    }

    public static String getNetworkProviders(Context context) {
        return getStringInNormalPref(context, Constant.DEVICE_NETWORK_PROVIDERS, EventsConstants.PROP_NETWORK_CARRIER_EMPTY);
    }

    public static int getNoOfGamePlayedForGameID(Context context, int i) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(Constant.SHARED_PREF_NAME, 0);
            if (sharedPreferences != null) {
                return sharedPreferences.getInt(Constant.NO_OF_GAME_PLAYED_FOR_GAME + i, 0);
            }
        } catch (Exception e2) {
            MLogger.e("gamePlay", "getNoOfGamePlayedForGameID: ", e2);
        }
        return 0;
    }

    public static String getNotificationCancelReceiverId() {
        return MPreferences.getString(Constant.GAME_ID_FOR_NOTIFICATION_CANCEL_RECEIVER, null, true);
    }

    public static int getNudgePermissionDialogCount(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constant.SHARED_PREF_NAME, 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("share_nudge_permission_dialog_count", 0);
        }
        return 0;
    }

    public static String getOneSignalId() {
        return MPreferences.getString(Constant.ONE_SIGNAL_ID, "", false);
    }

    public static String getOneSignalPushToken() {
        return MPreferences.getString(Constant.ONE_SIGNAL_PUSH_TOKEN, "", false);
    }

    public static String getPhotonAppId() {
        if (ConfigManager.isSaveAllConfigsToStorage()) {
            return MPreferences.getString(ConfigConstant.PHOTON_APP_ID, "", true);
        }
        return ConfigManager.getNormalConfig().optString(ConfigConstant.PHOTON_APP_ID.replaceFirst(ConfigConstant.CONFIG_PREFIX, ""), "");
    }

    public static String getPlatConfigJson() {
        return ConfigManager.getPlatformConfig() != null ? ConfigManager.getPlatformConfig().toString() : "";
    }

    public static int getPreviousMoneyEvent(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(Constant.SHARED_PREF_NAME, 0);
            if (sharedPreferences != null) {
                return sharedPreferences.getInt(Constant.MONEY_IN_EVENT_COUNT, 0);
            }
        } catch (Exception e2) {
            MLogger.e(Constant.APPS_FLYER_TAG, "getPreviousMoneyEvent: ", e2);
        }
        return 0;
    }

    public static int getPreviousRegistrationEvent(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(Constant.SHARED_PREF_NAME, 0);
            if (sharedPreferences != null) {
                return sharedPreferences.getInt(Constant.REGISTRATION_EVENT_COUNT, 0);
            }
        } catch (Exception e2) {
            MLogger.e(Constant.APPS_FLYER_TAG, "getPreviousMoneyEvent: ", e2);
        }
        return 0;
    }

    public static String getPrivateData() {
        return MPreferences.getString(Constant.PRIVATE_DATA, "", true);
    }

    public static String getProfile() {
        return MPreferences.getString(Constant.PROFILE, null, true);
    }

    public static HashMap<String, String> getRecommendedAppsCheckList() {
        String str;
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            if (ConfigManager.isSaveAllConfigsToStorage()) {
                str = MPreferences.getString(ConfigConstant.GAME_RECOMMENDED_APPS_FOR_CHECKLIST, "{}", true);
            } else {
                str = ConfigManager.getNormalConfig().optString(ConfigConstant.GAME_RECOMMENDED_APPS_FOR_CHECKLIST.replaceFirst(ConfigConstant.CONFIG_PREFIX, ""), "{}");
            }
            if (str != null && !TextUtils.isEmpty(str) && CommonUtils.isJSONValid(str)) {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.length() > 0) {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        String optString = jSONObject.optString(next);
                        hashMap.put(next, optString);
                        MLogger.d(TAG, "getCompetitorAppsCheckList: ", next, optString);
                    }
                }
            }
        } catch (Exception e2) {
            MLogger.e(TAG, "getTamperedAppsCheckList: ", e2);
        }
        return hashMap;
    }

    public static String getReferralBranch() {
        return MPreferences.getString(Constant.REFFERRERAL, "", false);
    }

    public static String getReferralSourceBranch() {
        return MPreferences.getString(Constant.REFERRAL_SOURCE, "", false);
    }

    public static String getReleaseNotesV2() {
        return MPreferences.getString(ConfigConstant.UPDATES2_RELEASE_NOTE, "{}", false);
    }

    public static String getReleasePoints() {
        return MPreferences.getString(ConfigConstant.UPDATES2_RELEASE_POINTS, "", false);
    }

    public static String getRewardbotData() {
        return MPreferences.getString(Constant.IS_REWARDBOT_ENABLED, null, true);
    }

    public static String getRgIsRgOn() {
        return MPreferences.getString(Constant.IS_RG_GAMING_ON, BaseParser.FALSE, false);
    }

    public static long getRgLastWarningDuration() {
        return MPreferences.getLong(Constant.RG_LAST_WARNING_DURATION, 0, false);
    }

    public static int getRgMaxWarningCount() {
        return MPreferences.getInt(Constant.RG_MAX_WARNING_COUNT, 4, false);
    }

    public static int getRgPrimaryWarningIntervalMinutes() {
        return MPreferences.getInt(Constant.RG_PRIMARY_WARNING_INTERVAL_MIN, 300, false);
    }

    public static int getRgSecondaryWarningIntervalMinutes() {
        return MPreferences.getInt(Constant.RG_SECONDARY_WARNING_INTERVAL_MIN, 60, false);
    }

    public static int getRgSessionCount() {
        return MPreferences.getInt(Constant.RG_SESSION_COUNT, 0, false);
    }

    public static long getRgSessionDuration() {
        return MPreferences.getLong(Constant.RG_SESSION_DURATION, 0, false);
    }

    public static long getRgSessionEnd() {
        return MPreferences.getLong(Constant.RG_SESSION_END, 0, false);
    }

    public static String getRgSessionId() {
        return MPreferences.getString(Constant.RG_SESSION_ID, "", false);
    }

    public static int getRgSessionTimeoutMin() {
        return MPreferences.getInt(Constant.RG_SESSION_TIMEOUT_MIN, 15, false);
    }

    public static int getRgWarningCount() {
        return MPreferences.getInt(Constant.RG_WARNING_COUNT, 0, false);
    }

    public static String getRootDownloadUrl() {
        String str = MBuildConfigUtils.getCountryCode().equalsIgnoreCase("in") ? "https://www.mpl.live/download" : "https://id.mpl.live/download";
        try {
            str = MPreferences.getString(ConfigConstant.ROOT_DOWNLOAD_URL, str, true);
        } catch (Exception unused) {
            MLogger.e("mainUrl", "getRootDownloadUrl: ", str);
        }
        MLogger.d("mainUrl", "getRootDownloadUrl: ", str);
        return str;
    }

    public static int getRootMinVersion() {
        return MPreferences.getInt(ConfigConstant.ROOT_MIN_VERSION, 1, true);
    }

    public static String getRootStatusMsg() {
        return MPreferences.getString(ConfigConstant.ROOT_STATUS_MESSAGE, "", true);
    }

    public static String getRootTime() {
        return MPreferences.getString(ConfigConstant.ROOT_TIME, "", true);
    }

    public static long getServerBootUpTimeWhenConfigCall() {
        return MPreferences.getLong(Constant.PHONE_BOOT_UP_TIME, 0, false);
    }

    public static long getServerTime() {
        return MPreferences.getLong(Constant.SERVER_TIME, 0, false);
    }

    public static String getShieldId() {
        return getStringInNormalPref(MPLApplication.getInstance(), Constant.SHIELD_ID, getDeviceId());
    }

    public static boolean getShowPopup() {
        return MPreferences.getBoolean(ConfigConstant.UPDATES2_SHOW_POPUP, false, false);
    }

    public static String getStringInNormalPref(Context context, String str, String str2) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constant.SHARED_PREF_NAME, 0);
        return sharedPreferences != null ? sharedPreferences.getString(str, str2) : str2;
    }

    public static String getStringPref(String str, String str2, boolean z) {
        try {
            return MPreferences.getString(str, str2, z);
        } catch (Exception e2) {
            MLogger.e(TAG, "", e2);
            return "";
        }
    }

    public static Set<String> getStringSet(String str, Set<String> set) {
        SharedPreferences sharedPreferences = MPLApplication.getInstance().getSharedPreferences(Constant.SHARED_PREF_NAME, 0);
        return sharedPreferences != null ? sharedPreferences.getStringSet(str, set) : set;
    }

    public static HashMap<String, String> getTamperedAppsCheckList() {
        String str;
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            if (ConfigManager.isSaveAllConfigsToStorage()) {
                str = MPreferences.getString(ConfigConstant.GAME_TAMPER_APPS_FOR_CHECKLIST, "{}", true);
            } else {
                str = ConfigManager.getNormalConfig().optString(ConfigConstant.GAME_TAMPER_APPS_FOR_CHECKLIST.replaceFirst(ConfigConstant.CONFIG_PREFIX, ""), "{}");
            }
            if (str != null && !TextUtils.isEmpty(str) && CommonUtils.isJSONValid(str)) {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.length() > 0) {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        hashMap.put(next, jSONObject.optString(next));
                    }
                }
            }
        } catch (Exception e2) {
            MLogger.e(TAG, "getTamperedAppsCheckList: ", e2);
        }
        return hashMap;
    }

    public static long getTimeIntervalForCloseNotification() {
        String string = MPreferences.getString(ConfigConstant.BACKGROUND_NOTIFICATION_DELETION_TIME_INTERVAL, "15", false);
        if (string == null || TextUtils.isEmpty(string)) {
            return TimeUnit.SECONDS.toMillis(15);
        }
        return TimeUnit.SECONDS.toMillis((long) Integer.parseInt(string));
    }

    public static long getTimeIntervalForRestartingBackground() {
        String string = MPreferences.getString(ConfigConstant.BACKGROUND_SERVICE_RUNNING_TIME_INTERVAL, PDLayoutAttributeObject.GLYPH_ORIENTATION_VERTICAL_180_DEGREES, false);
        if (string == null || TextUtils.isEmpty(string)) {
            return TimeUnit.MINUTES.toMillis(180);
        }
        return TimeUnit.MINUTES.toMillis((long) Integer.parseInt(string));
    }

    public static long getTimeTakenToDownload() {
        try {
            return MPreferences.getLong(ConfigConstant.TIME_TAKEN_TO_DOWNLOAD, 0, true);
        } catch (Exception unused) {
            return 0;
        }
    }

    public static HashSet<String> getTopicListForMQTTSubscription() {
        String str;
        if (ConfigManager.isSaveAllConfigsToStorage()) {
            str = MPreferences.getString(ConfigConstant.CONFIG_MQTT_SUBSCRIPTION_TOPIC_LIST, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, true);
        } else {
            str = ConfigManager.getNormalConfig().optString(ConfigConstant.CONFIG_MQTT_SUBSCRIPTION_TOPIC_LIST.replaceFirst(ConfigConstant.CONFIG_PREFIX, ""), HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        }
        HashSet<String> hashSet = new HashSet<>();
        return (str == null || TextUtils.isEmpty(str) || !CommonUtils.isJSONArrayValid(str)) ? hashSet : (HashSet) new Gson().fromJson(str, HashSet.class);
    }

    public static int getUpdateApkVersion() {
        return MPreferences.getInt(ConfigConstant.UPDATES_APK_VERSION, MBuildConfigUtils.getInstalledAppVersionCode(), true);
    }

    public static int getUpdateReactVersion() {
        return MPreferences.getInt(ConfigConstant.UPDATES_REACT_VERSION, DBInteractor.getCurrentRNBundleVersionCode(), true);
    }

    public static String getUpdateSha() {
        return MPreferences.getString(ConfigConstant.UPDATES2_SHA, "", false);
    }

    public static int getUpdater2Version() {
        return MPreferences.getInt("version", 0, false);
    }

    public static boolean getUpdaterV2Enabled() {
        boolean z;
        try {
            if (getUpdaterV2MainEnabled() || getUpdaterV2ExperimentalEnabled()) {
                z = true;
                MLogger.d(TAG, Constant.APP_UPDATE_CHECK, "getUpdaterV2Enabled: ", Boolean.valueOf(z));
                return z;
            }
        } catch (Exception unused) {
        }
        z = false;
        MLogger.d(TAG, Constant.APP_UPDATE_CHECK, "getUpdaterV2Enabled: ", Boolean.valueOf(z));
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003f A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:15:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean getUpdaterV2ExperimentalEnabled() {
        /*
            r0 = 0
            boolean r1 = com.mpl.androidapp.utils.MBuildConfigUtils.isUpdateV2ExperimentalEnabledFromGradle()     // Catch:{ Exception -> 0x0012 }
            java.lang.String r2 = "updater.v2.experimental.enabled"
            java.lang.String r3 = "false"
            java.lang.String r2 = com.mpl.securepreferences.MPreferences.getString(r2, r3, r0)     // Catch:{ Exception -> 0x0013 }
            boolean r2 = java.lang.Boolean.parseBoolean(r2)     // Catch:{ Exception -> 0x0013 }
            goto L_0x0014
        L_0x0012:
            r1 = 0
        L_0x0013:
            r2 = 0
        L_0x0014:
            r3 = 6
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r4 = "AppUpdateCheck:"
            r3[r0] = r4
            java.lang.String r4 = "getUpdaterV2ExperimentalEnabled: "
            r5 = 1
            r3[r5] = r4
            r4 = 2
            java.lang.String r6 = "Is Flavour Supported: "
            r3[r4] = r6
            r4 = 3
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r1)
            r3[r4] = r6
            r4 = 4
            java.lang.String r6 = "Is Updater Experimental Enabled: "
            r3[r4] = r6
            r4 = 5
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r2)
            r3[r4] = r6
            java.lang.String r4 = "MSharedPreferencesUtils"
            com.mpl.androidapp.utils.MLogger.d(r4, r3)
            if (r1 == 0) goto L_0x0042
            if (r2 == 0) goto L_0x0042
            r0 = 1
        L_0x0042:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.utils.MSharedPreferencesUtils.getUpdaterV2ExperimentalEnabled():boolean");
    }

    public static boolean getUpdaterV2MainEnabled() {
        boolean z;
        try {
            z = Boolean.parseBoolean(MPreferences.getString(UpdaterConstant.CONFIG_UPDATER_V2_ENABLED, BaseParser.FALSE, false));
        } catch (Exception unused) {
            z = false;
        }
        MLogger.d(TAG, Constant.APP_UPDATE_CHECK, "getUpdaterV2MainEnabled: ", Boolean.valueOf(z));
        return z;
    }

    public static String getUserBalance() {
        String string = MPreferences.getString(Constant.USER_BALANCE, "", true);
        MLogger.d(Constant.USER_BALANCE, "getUserBalance() called", string);
        return string;
    }

    public static String getUserCurrentTier() {
        try {
            return MPreferences.getString(Constant.USER_TIER_PREF, "", false);
        } catch (Exception e2) {
            MLogger.e("UserTier", "getUserCurrentTier: ", e2);
            return null;
        }
    }

    public static String getUserEmail() {
        String string = MPreferences.getString(Constant.USER_EMAIL, "", true);
        if (string == null || TextUtils.isEmpty(string)) {
            return "";
        }
        return string;
    }

    public static String getUserHashedId() {
        return MPreferences.getString(Constant.HASHED_UNIQUE_ID, "", true);
    }

    public static int getUserId() {
        try {
            String userProfile = getUserProfile();
            if (userProfile == null || TextUtils.isEmpty(userProfile)) {
                return 0;
            }
            return new JSONObject(userProfile).optInt("id", 0);
        } catch (Exception e2) {
            MLogger.d("getUserId", "getUserId", e2);
            return 0;
        }
    }

    public static int getUserIdInNormalPref(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constant.SHARED_PREF_NAME, 0);
        int i = (sharedPreferences == null || !sharedPreferences.contains(Constant.USER_ID_NORMAL)) ? 0 : sharedPreferences.getInt(Constant.USER_ID_NORMAL, 0);
        MLogger.d("userId", "getUserIdInNormalPref", Integer.valueOf(i));
        return i;
    }

    public static int getUserIdInNormalPrefV2(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constant.SHARED_PREF_NAME, 0);
        int i = (sharedPreferences == null || !sharedPreferences.contains(Constant.USER_USER_ID_NORMAL_V2)) ? 0 : sharedPreferences.getInt(Constant.USER_USER_ID_NORMAL_V2, 0);
        MLogger.d(TAG, "userId", "getUserIdInNormalPrefV2", Integer.valueOf(i));
        return i;
    }

    public static UserInfo getUserInfo() {
        String userProfile = getUserProfile();
        MLogger.i("userId", "getUserInfo", userProfile);
        UserInfo userInfo = (UserInfo) new Gson().fromJson(userProfile, UserInfo.class);
        if (userInfo == null || userInfo.getId() == 0) {
            return null;
        }
        return userInfo;
    }

    public static String getUserMobileNumber() {
        return MPreferences.getString("mobileNumber", "", true);
    }

    public static String getUserName() {
        try {
            String userProfile = getUserProfile();
            if (userProfile == null || TextUtils.isEmpty(userProfile)) {
                return "";
            }
            JSONObject jSONObject = new JSONObject(userProfile);
            if (ConfigManager.getHanselConfig() == null || !ConfigManager.getHanselConfig().optBoolean(Config.HANSEL_KEY_PROFILE_USERNAME_SURFACE_ENABLED, false)) {
                return jSONObject.optString("displayName", "");
            }
            return jSONObject.optString("userName", "");
        } catch (Exception e2) {
            MLogger.printStackTrace(e2);
            return "";
        }
    }

    public static String getUserNameForUser() {
        String str;
        Throwable e2;
        try {
            String userProfile = getUserProfile();
            if (userProfile == null || TextUtils.isEmpty(userProfile)) {
                return "";
            }
            JSONObject jSONObject = new JSONObject(userProfile);
            str = jSONObject.optString("userName", "");
            try {
                if (TextUtils.isEmpty(str)) {
                    return jSONObject.optString("displayName", "");
                }
            } catch (Exception e3) {
                e2 = e3;
                MLogger.printStackTrace(e2);
                return str;
            }
            return str;
        } catch (Exception e4) {
            Throwable th = e4;
            str = "";
            e2 = th;
            MLogger.printStackTrace(e2);
            return str;
        }
    }

    public static String getUserProfile() {
        try {
            String string = MPreferences.getString(Constant.PROFILE, "", true);
            MLogger.d("userId", "getUserProfile() called", string);
            return string;
        } catch (Exception e2) {
            MLogger.d("userId", "getUserProfile() called", e2);
            return "";
        }
    }

    public static HashMap<String, Object> getUserProfileEventParams() {
        HashMap<String, Object> hashMap = new HashMap<>();
        if (getUserInfo() != null) {
            UserInfo userInfo = getUserInfo();
            hashMap.put("User ID", String.valueOf(userInfo.getId()));
            hashMap.put("User Name", String.valueOf(userInfo.getDisplayName()));
            hashMap.put("User Tier", String.valueOf(userInfo.getTier()));
            hashMap.put("New User", String.valueOf(userInfo.isNewUser()));
            hashMap.put("Is Pro User", String.valueOf(userInfo.isPro()));
        } else {
            hashMap.put("User ID", String.valueOf(getUserId()));
            hashMap.put("User Name", String.valueOf(getUserName()));
            hashMap.put("User Tier", getUserTier());
            hashMap.put("New User", String.valueOf(isNewUser()));
            hashMap.put("Is Pro User", String.valueOf(isProUser()));
        }
        return hashMap;
    }

    public static String getUserReferralCode() {
        try {
            String userProfile = getUserProfile();
            if (userProfile == null || TextUtils.isEmpty(userProfile)) {
                return "";
            }
            return new JSONObject(userProfile).optString("referralCode", "");
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getUserReferralCodeFromPref() {
        try {
            return getStringPref("referralCode", "", true);
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getUserSelectedLangauge() {
        return MPreferences.getString("language", HyperVergeKycCapture.EN, true);
    }

    public static String getUserTier() {
        String userProfile = getUserProfile();
        if (TextUtils.isEmpty(userProfile)) {
            return "";
        }
        try {
            return new JSONObject(userProfile).optString("tier", "");
        } catch (JSONException e2) {
            MLogger.printStackTrace(e2);
            return "";
        }
    }

    public static boolean hasAcceptedGBDisclaimer() {
        return MPreferences.getBoolean(Constant.IS_DISCLAIMER_ACCEPTED, false, false);
    }

    public static boolean hasKeysInNormalPref(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constant.SHARED_PREF_NAME, 0);
        if (sharedPreferences == null || !sharedPreferences.contains(str)) {
            return false;
        }
        return true;
    }

    public static int increaseAndGetMoneyEvent(Context context) {
        try {
            int previousMoneyEvent = getPreviousMoneyEvent(context);
            SharedPreferences sharedPreferences = context.getSharedPreferences(Constant.SHARED_PREF_NAME, 0);
            if (sharedPreferences != null) {
                sharedPreferences.edit().putInt(Constant.MONEY_IN_EVENT_COUNT, previousMoneyEvent + 1).apply();
            }
            return previousMoneyEvent + 1;
        } catch (Exception e2) {
            MLogger.e(Constant.APPS_FLYER_TAG, "increaseAndGetMoneyEvent: ", e2);
            return 0;
        }
    }

    public static int increaseAndGetRegistrationEvent(Context context) {
        try {
            int previousRegistrationEvent = getPreviousRegistrationEvent(context);
            SharedPreferences sharedPreferences = context.getSharedPreferences(Constant.SHARED_PREF_NAME, 0);
            if (sharedPreferences != null) {
                sharedPreferences.edit().putInt(Constant.REGISTRATION_EVENT_COUNT, previousRegistrationEvent + 1).apply();
            }
            return previousRegistrationEvent + 1;
        } catch (Exception e2) {
            MLogger.e(Constant.APPS_FLYER_TAG, "increaseAndGetMoneyEvent: ", e2);
            return 0;
        }
    }

    public static void increaseGamePlayedForGameID(Context context, int i) {
        try {
            int noOfGamePlayedForGameID = getNoOfGamePlayedForGameID(context, i);
            SharedPreferences sharedPreferences = context.getSharedPreferences(Constant.SHARED_PREF_NAME, 0);
            if (sharedPreferences != null) {
                Editor edit = sharedPreferences.edit();
                edit.putInt(Constant.NO_OF_GAME_PLAYED_FOR_GAME + i, noOfGamePlayedForGameID + 1).apply();
            }
        } catch (Exception e2) {
            MLogger.e("gamePlay", "increaseGamePlayedForGameID: ", e2);
        }
    }

    public static void increaseNudgePermissionDialogCount(Context context) {
        int nudgePermissionDialogCount = getNudgePermissionDialogCount(context) + 1;
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constant.SHARED_PREF_NAME, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("share_nudge_permission_dialog_count", nudgePermissionDialogCount).apply();
        }
    }

    public static void incrementSessionCount() {
        MPreferences.getGeneral().edit().putInt(Constant.RG_SESSION_COUNT, getRgSessionCount() + 1).apply();
    }

    public static void initSharedPreferences(Context context, String str) {
        MPreferences.init(context, str);
    }

    public static boolean isAppFirstLaunch(Context context) {
        if (hasKeysInNormalPref(context, Constant.IS_APP_FIRST_LAUNCH)) {
            return getBooleanInNormalPref(context, Constant.IS_APP_FIRST_LAUNCH, false);
        }
        return true;
    }

    public static boolean isBackgroundRunningServiceEnabled() {
        String string = MPreferences.getString(ConfigConstant.CONFIG_BACKGROUND_RUNNING_SERVICE_ENABLED, String.valueOf(false), false);
        if (TextUtils.isEmpty(string) || !Boolean.parseBoolean(string) || !isBackgroundRunningServiceEnabledFromHansel()) {
            return false;
        }
        return true;
    }

    public static boolean isBackgroundRunningServiceEnabledFromHansel() {
        try {
            String hanselConfig = getHanselConfig();
            if (!TextUtils.isEmpty(hanselConfig)) {
                return new JSONObject(hanselConfig).optBoolean("background_running_service_enabled", false);
            }
            return false;
        } catch (Exception unused) {
            return HanselConfigs.getBoolean("background_running_service_enabled", false);
        }
    }

    public static boolean isBranchEventPushed() {
        return MPreferences.getBoolean(Constant.IS_BRANCH_EVENT_PUSHED, false, false);
    }

    public static boolean isBroadcastToolTipShown() {
        return MPreferences.getBoolean(Constant.IS_BROADCAST_TOOL_TIP_SHOWN, false, false);
    }

    public static boolean isBronzeTierUpgradeEventSent() {
        return MPreferences.getBoolean("bronze_event_sent", false, false);
    }

    public static boolean isChallengeContactSyncRequired() {
        String str;
        if (ConfigManager.isSaveAllConfigsToStorage()) {
            str = MPreferences.getString(ConfigConstant.CONFIG_CHALLENGE_CONTACT_SYNC_ENABLED, BaseParser.TRUE, true);
        } else {
            str = ConfigManager.getPlatformConfig().optString(ConfigConstant.CONFIG_CHALLENGE_CONTACT_SYNC_ENABLED.replaceFirst(ConfigConstant.CONFIG_PREFIX, ""), BaseParser.TRUE);
        }
        if (str == null || TextUtils.isEmpty(str)) {
            return true;
        }
        return Boolean.parseBoolean(str);
    }

    public static boolean isChallengeEnabled() {
        String str;
        if (ConfigManager.isSaveAllConfigsToStorage()) {
            str = MPreferences.getString(ConfigConstant.CONFIG_IS_CHALLENGE_ENABLED, BaseParser.FALSE, true);
        } else {
            str = ConfigManager.getPlatformConfig().optString(ConfigConstant.CONFIG_IS_CHALLENGE_ENABLED.replaceFirst(ConfigConstant.CONFIG_PREFIX, ""), BaseParser.FALSE);
        }
        if (str == null || TextUtils.isEmpty(str)) {
            return false;
        }
        return Boolean.parseBoolean(str);
    }

    public static boolean isCriticalUpdate() {
        try {
            return MPreferences.getBoolean(ConfigConstant.UPDATES_APK_CRITICAL, false, true);
        } catch (Exception unused) {
            return false;
        }
    }

    public static Boolean isDailyAppUsageWorkerEnabled(Context context) {
        return Boolean.valueOf(getBooleanInNormalPref(context, Constant.APP_USAGE_WORKER_ENABLED, false));
    }

    public static boolean isDeveloperOptionCheckEnabled() {
        String str;
        if (ConfigManager.isSaveAllConfigsToStorage()) {
            str = MPreferences.getString(ConfigConstant.GAME_DEVELOPER_OPTION_CHECK_ENABLED, BaseParser.FALSE, true);
        } else {
            str = ConfigManager.getPlatformConfig().optString(ConfigConstant.GAME_DEVELOPER_OPTION_CHECK_ENABLED.replaceFirst(ConfigConstant.CONFIG_PREFIX, ""), BaseParser.FALSE);
        }
        if (str == null || TextUtils.isEmpty(str)) {
            return false;
        }
        return Boolean.parseBoolean(str);
    }

    public static boolean isDeviceCheckEnabledForGame() {
        String str;
        try {
            if (ConfigManager.isSaveAllConfigsToStorage()) {
                str = MPreferences.getString(ConfigConstant.IS_DEVICE_CHECK_ENABLED_FOR_GAME, BaseParser.TRUE, true);
            } else {
                str = ConfigManager.getNormalConfig().optString(ConfigConstant.IS_DEVICE_CHECK_ENABLED_FOR_GAME.replaceFirst(ConfigConstant.CONFIG_PREFIX, ""), BaseParser.TRUE);
            }
            if (str != null && !TextUtils.isEmpty(str)) {
                return Boolean.parseBoolean(str);
            }
        } catch (Exception e2) {
            MLogger.e(TAG, "", e2);
        }
        return false;
    }

    public static boolean isEmulator() {
        return MPreferences.getBoolean(Constant.IS_EMULATOR_PREF, false, false);
    }

    public static boolean isGameAudioRecordingFeatureEnabled() {
        if (ConfigManager.isSaveAllConfigsToStorage()) {
            return Boolean.parseBoolean(getStringPref(ConfigConstant.CONFIG_VOICE_CHAT_ENABLED, String.valueOf(false), true));
        }
        return ConfigManager.getPlatformConfig().optBoolean(ConfigConstant.CONFIG_VOICE_CHAT_ENABLED.replaceFirst(ConfigConstant.CONFIG_PREFIX, ""), false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0074, code lost:
        if (r3.contains(android.os.Build.BRAND + org.apache.fontbox.cmap.CMap.SPACE + android.os.Build.MODEL) != false) goto L_0x0078;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isGameEnableForDevice() {
        /*
            java.lang.String r0 = ""
            r1 = 0
            r2 = 1
            boolean r3 = isDeviceCheckEnabledForGame()     // Catch:{ Exception -> 0x007a }
            if (r3 == 0) goto L_0x0077
            com.mpl.androidapp.MPLApplication r3 = com.mpl.androidapp.MPLApplication.getInstance()     // Catch:{ Exception -> 0x007a }
            int r3 = com.mpl.androidapp.utils.VideoRecordingUtils.getYearClass(r3)     // Catch:{ Exception -> 0x007a }
            int r4 = getMinRamForEnableGameConfig()     // Catch:{ Exception -> 0x007a }
            if (r3 <= r4) goto L_0x0078
            boolean r3 = com.mpl.androidapp.config.ConfigManager.isSaveAllConfigsToStorage()     // Catch:{ Exception -> 0x007a }
            java.lang.String r4 = "[]"
            java.lang.String r5 = "config.game.deviceListForGameDisabled"
            if (r3 == 0) goto L_0x0027
            java.lang.String r3 = com.mpl.securepreferences.MPreferences.getString(r5, r4, r2)     // Catch:{ Exception -> 0x007a }
            goto L_0x0035
        L_0x0027:
            org.json.JSONObject r3 = com.mpl.androidapp.config.ConfigManager.getNormalConfig()     // Catch:{ Exception -> 0x007a }
            java.lang.String r6 = "config."
            java.lang.String r5 = r5.replaceFirst(r6, r0)     // Catch:{ Exception -> 0x007a }
            java.lang.String r3 = r3.optString(r5, r4)     // Catch:{ Exception -> 0x007a }
        L_0x0035:
            if (r3 == 0) goto L_0x0077
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x007a }
            if (r4 != 0) goto L_0x0077
            boolean r4 = com.mpl.androidapp.utils.CommonUtils.isJSONArrayValid(r3)     // Catch:{ Exception -> 0x007a }
            if (r4 == 0) goto L_0x0077
            com.google.gson.Gson r4 = new com.google.gson.Gson     // Catch:{ Exception -> 0x007a }
            r4.<init>()     // Catch:{ Exception -> 0x007a }
            java.lang.Class<java.util.HashSet> r5 = java.util.HashSet.class
            java.lang.Object r3 = r4.fromJson(r3, r5)     // Catch:{ Exception -> 0x007a }
            java.util.HashSet r3 = (java.util.HashSet) r3     // Catch:{ Exception -> 0x007a }
            if (r3 == 0) goto L_0x0077
            int r4 = r3.size()     // Catch:{ Exception -> 0x007a }
            if (r4 <= 0) goto L_0x0077
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x007a }
            r4.<init>()     // Catch:{ Exception -> 0x007a }
            java.lang.String r5 = android.os.Build.BRAND     // Catch:{ Exception -> 0x007a }
            r4.append(r5)     // Catch:{ Exception -> 0x007a }
            java.lang.String r5 = " "
            r4.append(r5)     // Catch:{ Exception -> 0x007a }
            java.lang.String r5 = android.os.Build.MODEL     // Catch:{ Exception -> 0x007a }
            r4.append(r5)     // Catch:{ Exception -> 0x007a }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x007a }
            boolean r0 = r3.contains(r4)     // Catch:{ Exception -> 0x007a }
            if (r0 == 0) goto L_0x0077
            goto L_0x0078
        L_0x0077:
            r1 = 1
        L_0x0078:
            r2 = r1
            goto L_0x0087
        L_0x007a:
            r3 = move-exception
            r4 = 2
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r4[r1] = r0
            r4[r2] = r3
            java.lang.String r0 = "MSharedPreferencesUtils"
            com.mpl.androidapp.utils.MLogger.e(r0, r4)
        L_0x0087:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.utils.MSharedPreferencesUtils.isGameEnableForDevice():boolean");
    }

    public static boolean isGamePlayedBranchEventPushed() {
        return MPreferences.getBoolean(Constant.IS_GAME_PLAYED_BRANCH_EVENT_PUSHED, false, true);
    }

    public static boolean isGamePlayedBranchEventPushedV2() {
        return MPreferences.getBoolean(Constant.IS_GAME_PLAYED_BRANCH_EVENT_PUSHED_V2, false, true);
    }

    public static boolean isGameReminderNotifEnabeled(Context context) {
        String stringInNormalPref = getStringInNormalPref(context, ConfigConstant.NOTIFICATION_FIRST_GAME_REMINDER_ENABLED, BaseParser.FALSE);
        if (stringInNormalPref == null || TextUtils.isEmpty(stringInNormalPref)) {
            return false;
        }
        return Boolean.parseBoolean(stringInNormalPref);
    }

    public static boolean isGameRequireForOverlayDetection(int i) {
        String str;
        try {
            if (ConfigManager.isSaveAllConfigsToStorage()) {
                str = MPreferences.getString(ConfigConstant.OVERLAYS_DETECTION_GAME_IDS, "", true);
            } else {
                str = ConfigManager.getNormalConfig().optString(ConfigConstant.OVERLAYS_DETECTION_GAME_IDS.replaceFirst(ConfigConstant.CONFIG_PREFIX, ""), "");
            }
            if (str == null || TextUtils.isEmpty(str)) {
                return false;
            }
            return Arrays.asList(str.split(",")).contains(String.valueOf(i));
        } catch (Exception e2) {
            MLogger.e(TAG, "", e2);
            return false;
        }
    }

    public static boolean isGameTamperedAppPresent() {
        return MPreferences.getBoolean(Constant.EXTRA_GAME_TAMPERED_APPS, false, false);
    }

    public static boolean isGamesIdWithoutAssetsDownload(int i) {
        AllGame gameInfo = CommonUtils.getGameInfo(Integer.valueOf(i));
        if (gameInfo == null || gameInfo.getGameConfigGameInfo() == null || gameInfo.getGameConfigGameInfo().getApkInfo() == null) {
            return false;
        }
        return gameInfo.getGameConfigGameInfo().getApkInfo().isThirdParty();
    }

    public static boolean isIntegrityCheckRequired() {
        return Boolean.parseBoolean(MPreferences.getString(Constant.INTEGRITY_CHECK_REQUIRED, BaseParser.TRUE, false));
    }

    public static boolean isLoginReminderNotifEnabeled(Context context) {
        String stringInNormalPref = getStringInNormalPref(context, ConfigConstant.NOTIFICATION_LOGIN_REMINDER_ENABLED, BaseParser.FALSE);
        if (stringInNormalPref == null || TextUtils.isEmpty(stringInNormalPref)) {
            return false;
        }
        return Boolean.parseBoolean(stringInNormalPref);
    }

    public static boolean isMQTTRequired() {
        String str;
        if (ConfigManager.isSaveAllConfigsToStorage()) {
            str = MPreferences.getString(ConfigConstant.IS_MQTT_REQUIRED, BaseParser.FALSE, true);
        } else {
            str = ConfigManager.getPlatformConfig().optString(ConfigConstant.IS_MQTT_REQUIRED.replaceFirst(ConfigConstant.CONFIG_PREFIX, ""), BaseParser.FALSE);
        }
        if (str == null || TextUtils.isEmpty(str)) {
            return false;
        }
        return Boolean.parseBoolean(str);
    }

    public static boolean isMQTTSubscribeToContactRequired() {
        String str;
        if (ConfigManager.isSaveAllConfigsToStorage()) {
            str = MPreferences.getString(ConfigConstant.CONFIG_MQTT_CONTACT_SUBSCRIPTION_ENABLED, BaseParser.TRUE, true);
        } else {
            str = ConfigManager.getPlatformConfig().optString(ConfigConstant.CONFIG_MQTT_CONTACT_SUBSCRIPTION_ENABLED.replaceFirst(ConfigConstant.CONFIG_PREFIX, ""), BaseParser.TRUE);
        }
        if (str == null || TextUtils.isEmpty(str)) {
            return true;
        }
        return Boolean.parseBoolean(str);
    }

    public static boolean isMQTTSubscribeToFollowingRequired() {
        String str;
        if (ConfigManager.isSaveAllConfigsToStorage()) {
            str = MPreferences.getString(ConfigConstant.CONFIG_MQTT_FOLLOWING_SUBSCRIPTION_ENABLED, BaseParser.TRUE, true);
        } else {
            str = ConfigManager.getPlatformConfig().optString(ConfigConstant.CONFIG_MQTT_FOLLOWING_SUBSCRIPTION_ENABLED.replaceFirst(ConfigConstant.CONFIG_PREFIX, ""), BaseParser.TRUE);
        }
        if (str == null || TextUtils.isEmpty(str)) {
            return true;
        }
        return Boolean.parseBoolean(str);
    }

    public static boolean isMoneyInBranchEventPushed() {
        return MPreferences.getBoolean(Constant.IS_MONEY_IN_BRANCH_EVENT_PUSHED, false, true);
    }

    public static boolean isMoneyOutBranchEventPushed() {
        return MPreferences.getBoolean(Constant.IS_MONEY_OUT_BRANCH_EVENT_PUSHED, false, true);
    }

    public static boolean isNativeSubmitScoreEnabled() {
        String string = MPreferences.getString(ConfigConstant.GAME_NATIVE_SUBMIT_SCORE_ENABLED, BaseParser.FALSE, false);
        if (string == null || TextUtils.isEmpty(string)) {
            return false;
        }
        return Boolean.parseBoolean(string);
    }

    public static boolean isNewUpdaterChangeRequired() {
        try {
            String string = MPreferences.getString(ConfigConstant.CONFIG_UPDATER_NEW_CHANGES_REQUIRED, BaseParser.TRUE, true);
            if (string != null && !TextUtils.isEmpty(string)) {
                return Boolean.parseBoolean(string);
            }
        } catch (Exception e2) {
            MLogger.e(TAG, "", e2);
        }
        return true;
    }

    public static boolean isNewUser() {
        try {
            String userProfile = getUserProfile();
            if (userProfile == null || TextUtils.isEmpty(userProfile) || !new JSONObject(userProfile).optBoolean(Constant.APPSFLYER_IS_NEW_USER, false)) {
                return false;
            }
            return true;
        } catch (Exception e2) {
            MLogger.printStackTrace(e2);
            return false;
        }
    }

    public static boolean isNewUserFromLoginResponse() {
        try {
            String stringPref = getStringPref(Constant.APPSFLYER_IS_NEW_USER, BaseParser.FALSE, true);
            if (stringPref != null && !TextUtils.isEmpty(stringPref)) {
                return Boolean.parseBoolean(stringPref);
            }
        } catch (Exception e2) {
            MLogger.e(TAG, "isNewUserFromLoginResponse: ", e2);
        }
        return false;
    }

    public static boolean isOverlayDetectionRequiredInGame(int i) {
        String str;
        boolean z = true;
        try {
            if (ConfigManager.isSaveAllConfigsToStorage()) {
                str = MPreferences.getString(ConfigConstant.IS_OVERLAY_DETECTION_REQUIRED_GAME, BaseParser.FALSE, true);
            } else {
                str = ConfigManager.getNormalConfig().optString(ConfigConstant.IS_OVERLAY_DETECTION_REQUIRED_GAME.replaceFirst(ConfigConstant.CONFIG_PREFIX, ""), BaseParser.FALSE);
            }
            if (str == null || TextUtils.isEmpty(str)) {
                return false;
            }
            if (!Boolean.parseBoolean(str) || !isGameRequireForOverlayDetection(i) || VERSION.SDK_INT >= 28) {
                z = false;
            }
            return z;
        } catch (Exception e2) {
            MLogger.e(Constant.APPS_FLYER_TAG, "isOverlayDetectionRequiredInGame: ", e2);
            return false;
        }
    }

    public static boolean isOverlayDetectionRequiredInReact() {
        try {
            String string = MPreferences.getString(ConfigConstant.IS_OVERLAY_DETECTION_REQUIRED_REACT, BaseParser.FALSE, false);
            if (string != null && !TextUtils.isEmpty(string)) {
                return Boolean.parseBoolean(string);
            }
        } catch (Exception e2) {
            MLogger.e(Constant.APPS_FLYER_TAG, "isOverlayDetectionRequiredInReact: ", e2);
        }
        return false;
    }

    public static boolean isPhoneRooted() {
        return MPreferences.getBoolean(Constant.IS_PHONE_ROOTED, false, false);
    }

    public static boolean isProAppDownloadRequired() {
        String string = MPreferences.getString(ConfigConstant.CONFIG_IS_PRO_APP_DOWNLOAD_REQUIRED, String.valueOf(false), false);
        if (TextUtils.isEmpty(string)) {
            return false;
        }
        return Boolean.parseBoolean(string);
    }

    public static boolean isProUser() {
        try {
            String userProfile = getUserProfile();
            if (userProfile == null || TextUtils.isEmpty(userProfile)) {
                return false;
            }
            return new JSONObject(userProfile).optBoolean("pro", false);
        } catch (Exception e2) {
            MLogger.printStackTrace(e2);
            return false;
        }
    }

    public static boolean isReferralRedirectEnabled() {
        if (ConfigManager.getPlatformConfig() != null) {
            return ConfigManager.getPlatformConfig().optBoolean("referral.redirect.enabled", false);
        }
        return false;
    }

    public static boolean isSelfReferral() {
        boolean z;
        String str = "";
        try {
            String string = MPreferences.getString(Constant.AF_REFERRAL_CODE, str, false);
            if (!"null".equalsIgnoreCase(string)) {
                str = string;
            }
            String userReferralCode = getUserReferralCode();
            if (!TextUtils.isEmpty(userReferralCode) && userReferralCode.equalsIgnoreCase(str)) {
                z = true;
                MLogger.d(TAG, "isSelfReferral: ", Boolean.valueOf(z));
                return z;
            }
        } catch (Exception e2) {
            MLogger.e(Constant.APPS_FLYER_TAG, "getAFReferralCode: ", e2);
        }
        z = false;
        MLogger.d(TAG, "isSelfReferral: ", Boolean.valueOf(z));
        return z;
    }

    public static boolean isStoriesCleanUpWorkDone() {
        return getBooleanInNormalPref(MPLApplication.getInstance(), "stories_cleanup_work", false);
    }

    public static boolean isTamperedAppsCheckEnabled() {
        String str;
        if (ConfigManager.isSaveAllConfigsToStorage()) {
            str = MPreferences.getString(ConfigConstant.GAME_TAMPER_APPS_CHECK_ENABLED, BaseParser.FALSE, true);
        } else {
            str = ConfigManager.getPlatformConfig().optString(ConfigConstant.GAME_TAMPER_APPS_CHECK_ENABLED.replaceFirst(ConfigConstant.CONFIG_PREFIX, ""), BaseParser.FALSE);
        }
        if (str == null || TextUtils.isEmpty(str)) {
            return false;
        }
        return Boolean.parseBoolean(str);
    }

    public static boolean isTierEnabledForGame() {
        String str;
        if (ConfigManager.isSaveAllConfigsToStorage()) {
            str = MPreferences.getString(ConfigConstant.CONFIG_GAME_SHOW_TIER_ENABLED, BaseParser.TRUE, true);
        } else {
            str = ConfigManager.getPlatformConfig().optString(ConfigConstant.CONFIG_GAME_SHOW_TIER_ENABLED.replaceFirst(ConfigConstant.CONFIG_PREFIX, ""), BaseParser.TRUE);
        }
        if (str == null || TextUtils.isEmpty(str)) {
            return true;
        }
        return Boolean.parseBoolean(str);
    }

    public static boolean isUnityCloseRequired() {
        String str;
        if (ConfigManager.isSaveAllConfigsToStorage()) {
            str = MPreferences.getString(ConfigConstant.CONFIG_ANDROID_KILL_REQUIRED, BaseParser.FALSE, true);
        } else {
            str = ConfigManager.getPlatformConfig().optString(ConfigConstant.CONFIG_ANDROID_KILL_REQUIRED.replaceFirst(ConfigConstant.CONFIG_PREFIX, ""), BaseParser.FALSE);
        }
        if (str == null || TextUtils.isEmpty(str)) {
            return false;
        }
        return Boolean.parseBoolean(str);
    }

    public static boolean isUpdateAvailableInUpdaterV2() {
        return MPreferences.getBoolean(ConfigConstant.UPDATES2_APK_AVAILABLE, false, false);
    }

    public static boolean isUpdateCriticalInUpdaterV2() {
        return MPreferences.getBoolean(ConfigConstant.UPDATES2_APK_CRITICAL_NEW, false, false);
    }

    public static boolean isUsbDebuggingCheckEnabled() {
        String str;
        if (ConfigManager.isSaveAllConfigsToStorage()) {
            str = MPreferences.getString(ConfigConstant.GAME_USB_DEBUGGING_OPTION_CHECK_ENABLED, BaseParser.FALSE, true);
        } else {
            str = ConfigManager.getPlatformConfig().optString(ConfigConstant.GAME_USB_DEBUGGING_OPTION_CHECK_ENABLED.replaceFirst(ConfigConstant.CONFIG_PREFIX, ""), BaseParser.FALSE);
        }
        if (str == null || TextUtils.isEmpty(str)) {
            return false;
        }
        return Boolean.parseBoolean(str);
    }

    public static boolean isUserAudioEnable() {
        String string = MPreferences.getString(Constant.MUTE_AUDIO_GAME, BaseParser.TRUE, true);
        if (string == null || TextUtils.isEmpty(string)) {
            return true;
        }
        return Boolean.parseBoolean(string);
    }

    public static boolean isUserCameFromReferral(Context context) {
        return getBooleanInNormalPref(context, Constant.IS_USER_CAME_FROM_REFERRAL, false);
    }

    public static boolean isUserLoggedIn() {
        return MPreferences.getBoolean(Constant.IS_USER_LOGGED_IN_PREF, false, true);
    }

    public static boolean isUserLoggedInEventSent() {
        return MPreferences.getBoolean(ConfigConstant.IS_USER_LOGGED_IN_EVENT_SENT, false, false);
    }

    public static boolean isUserLoggedInTokenAvailable() {
        return MPreferences.getString("accessToken", null, true) != null;
    }

    public static boolean isUserPlayingGame() {
        try {
            return MPreferences.getBoolean(Constant.IS_GAME_PLAYING, false, false);
        } catch (Exception e2) {
            MLogger.d(TAG, GeneratedOutlineSupport.outline39(e2, GeneratedOutlineSupport.outline73(" exception in isUserPlayingGame get boolean value")));
            return false;
        }
    }

    public static boolean isUserTierUpgraded() {
        boolean z = true;
        try {
            String userTier = getUserTier();
            String userCurrentTier = getUserCurrentTier();
            MLogger.d("UserTier", "isUserTierUpgraded: ", "currentTier: " + userTier, "previousTier: " + userCurrentTier);
            if (userTier == null || userCurrentTier == null || TextUtils.isEmpty(userTier) || TextUtils.isEmpty(userCurrentTier)) {
                return false;
            }
            if (CommonUtils.getTierRank(userTier) <= CommonUtils.getTierRank(userCurrentTier)) {
                z = false;
            }
            return z;
        } catch (Exception e2) {
            MLogger.e("UserTier", "isUserTierUpgraded: ", e2);
            return false;
        }
    }

    public static boolean isVerifiedProfile() {
        return MPreferences.getBoolean("isVerifiedProfile", false, true);
    }

    public static boolean isWTMEventSent() {
        return MPreferences.getBoolean(ConfigConstant.IS_WTM_EVENT_SENT, false, false);
    }

    public static void moveMobileNumberInNormalPref(Context context) {
        String str;
        UserInfo userInfo = getUserInfo();
        if (userInfo == null || TextUtils.isEmpty(userInfo.getMobileNumber())) {
            str = CountryUtils.getUniqueIdForThirdPartySDKs();
        } else {
            str = userInfo.getMobileNumber();
        }
        MLogger.d("mobileNumber", "moveMobileNumberInNormalPref", str);
        if (!TextUtils.isEmpty(str) && !"".equalsIgnoreCase(str)) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(Constant.SHARED_PREF_NAME, 0);
            if (sharedPreferences != null) {
                Editor edit = sharedPreferences.edit();
                if (edit != null) {
                    edit.putString(Constant.USER_MOBILE_NUMBER_NORMAL, str).apply();
                }
            }
        }
    }

    public static void moveUserIdInNormalPref(Context context) {
        int i;
        UserInfo userInfo = getUserInfo();
        if (userInfo == null || userInfo.getId() == 0) {
            i = getUserId();
        } else {
            MLogger.d("userId", "moveUserIdInNormalPref", userInfo.toString());
            i = userInfo.getId();
        }
        MLogger.d("userId", "moveUserIdInNormalPref", Integer.valueOf(i));
        if (i > 0) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(Constant.SHARED_PREF_NAME, 0);
            if (sharedPreferences != null) {
                Editor edit = sharedPreferences.edit();
                if (edit != null) {
                    edit.putInt(Constant.USER_ID_NORMAL, i).apply();
                }
            }
        }
    }

    public static void putAFReferralCode(String str) {
        MPreferences.putString(Constant.AF_REFERRAL_CODE, str, false);
    }

    public static void putAFReferralData(JSONObject jSONObject) {
        MPreferences.putString(Constant.AF_REFERRAL_DATA, jSONObject.toString(), false);
    }

    public static void putAFSignupCode(String str) {
        MPreferences.putString(Constant.AF_SIGNUP_CODE, str, false);
    }

    public static void putAssetsDownloadTime(int i) {
        MPreferences.putLong(GeneratedOutlineSupport.outline41(Constant.ASSETS_DOWNLOAD_TIME, i), System.currentTimeMillis(), false);
    }

    public static void putBooleanPref(String str, boolean z, boolean z2) {
        MPreferences.putBoolean(str, z, z2);
    }

    public static void putBootUpTime(long j) {
        MPreferences.putLong(Constant.PHONE_BOOT_UP_TIME, j, false);
    }

    public static void putGameSponsorConfigJson(String str) {
        MPreferences.putString(GameConstant.GAME_SPONSOR_CONFIG_JSON, str, false);
    }

    public static void putIntPref(String str, int i, boolean z) {
        MPreferences.putInt(str, i, z);
    }

    public static void putLongPref(String str, long j, boolean z) {
        MPreferences.putLong(str, j, z);
    }

    public static void putNotificationCancelReceiverId(String str) {
        MPreferences.putString(Constant.GAME_ID_FOR_NOTIFICATION_CANCEL_RECEIVER, str, true);
    }

    public static void putOneSignalPushToken(String str) {
        MPreferences.putString(Constant.ONE_SIGNAL_PUSH_TOKEN, str, false);
    }

    public static void putOrUpdateGamePlayedTime(int i) {
        MPreferences.putLong(GeneratedOutlineSupport.outline41(Constant.LAST_PLAYED_TIME, i), System.currentTimeMillis(), false);
    }

    public static void putPhoneCurrentTime(long j) {
        MPreferences.putLong(Constant.PHONE_CURRENT_TIME, j, false);
    }

    public static void putRgConfig(RgConfigs rgConfigs) {
        if (MPreferences.getGeneral() != null) {
            MPreferences.getGeneral().edit().putInt(Constant.RG_SESSION_TIMEOUT_MIN, rgConfigs.getSessionTimeOutMinutes()).putInt(Constant.RG_PRIMARY_WARNING_INTERVAL_MIN, rgConfigs.getPrimaryWarningIntervalMinutes()).putInt(Constant.RG_SECONDARY_WARNING_INTERVAL_MIN, rgConfigs.getSecondaryWarningIntervalMinutes()).putInt(Constant.RG_MAX_WARNING_COUNT, rgConfigs.getMaxWarningCount()).putString(Constant.IS_RG_GAMING_ON, rgConfigs.getIsRgGamingOn()).apply();
        }
    }

    public static void putRgSessionInfo(RgSessionInfo rgSessionInfo) {
        MPreferences.getGeneral().edit().putString(Constant.RG_SESSION_ID, rgSessionInfo.getRgSessionId()).putLong(Constant.RG_SESSION_END, rgSessionInfo.getRgSessionEnd()).putLong(Constant.RG_LAST_WARNING_DURATION, rgSessionInfo.getRgLastWarningDuration()).putInt(Constant.RG_WARNING_COUNT, rgSessionInfo.getRgWarningCount()).putLong(Constant.RG_SESSION_DURATION, rgSessionInfo.getRgSessionDuration()).apply();
    }

    public static void putServerTime(long j) {
        MPreferences.putLong(Constant.SERVER_TIME, j, false);
    }

    public static void putStringPref(String str, String str2, boolean z) {
        MPreferences.putString(str, str2, z);
    }

    public static void putStringSet(String str, Set<String> set) {
        SharedPreferences sharedPreferences = MPLApplication.getInstance().getSharedPreferences(Constant.SHARED_PREF_NAME, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putStringSet(str, set).apply();
        }
    }

    public static String referralRedirectUrl() {
        if (ConfigManager.getNormalConfig() != null) {
            return ConfigManager.getNormalConfig().optString("referral.redirect.url", "");
        }
        return "";
    }

    public static void removeBranchReferralData(Context context) {
        MPreferences.remove(Constant.BRANCH_REFFERRERAL_DATA, false);
        MPreferences.remove(Constant.REFFERRERAL, false);
        MPreferences.remove(Constant.REFERRAL_SOURCE, false);
        if (context != null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.mpl.androidapp.v2_pref", 0);
            if (sharedPreferences != null) {
                GeneratedOutlineSupport.outline93(sharedPreferences, "containerReferralCode");
            }
        }
    }

    public static void removeDeepLinkForInstall() {
        try {
            saveDeepLinkForInstall("");
            MPreferences.remove(Constant.AF_INSTALL_DEEP_LINK_DATA, false);
        } catch (Exception e2) {
            MLogger.e(TAG, "", e2);
        }
    }

    public static void removeSecurePref(String str) {
        MPreferences.remove(str, true);
    }

    public static void saveBooleanInNormalPref(Context context, String str, boolean z) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constant.SHARED_PREF_NAME, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(str, z).apply();
        }
    }

    public static void saveDeepLinkForInstall(String str) {
        try {
            MPreferences.putString(Constant.AF_INSTALL_DEEP_LINK_DATA, str, false);
        } catch (Exception e2) {
            MLogger.e(TAG, "", e2);
        }
    }

    public static void saveFloatInNormalPref(Context context, String str, float f2) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constant.SHARED_PREF_NAME, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putFloat(str, f2).apply();
        }
    }

    public static void saveGameHashForGameId(int i, String str) {
        MLogger.d(TAG, Constant.ASSETS_CHECKING, "saveGameHashForGameId: ", Integer.valueOf(i));
        MPreferences.putString("hash_" + i, str, false);
    }

    public static void saveIntInNormalPref(Context context, String str, int i) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constant.SHARED_PREF_NAME, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt(str, i).apply();
        }
    }

    public static void saveLastTimeEventSentTime(Context context, DateTime dateTime) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constant.SHARED_PREF_NAME, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong(Constant.COMPETITOR_EVENT_SENT_TIME, dateTime.iMillis).apply();
        }
    }

    public static void saveLongInNormalPref(Context context, String str, long j) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constant.SHARED_PREF_NAME, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong(str, j).apply();
        }
    }

    public static void saveStringInNormalPref(Context context, String str, String str2) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constant.SHARED_PREF_NAME, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(str, str2).apply();
        }
    }

    public static void saveSubmitScoreData(String str) {
        MPreferences.putString("submitscore_result", str, true);
    }

    public static void saveUserCameFromReferral(Context context, boolean z) {
        saveBooleanInNormalPref(context, Constant.IS_USER_CAME_FROM_REFERRAL, z);
    }

    public static void setAFReferralFeature(Context context, String str, String str2) {
        MLogger.d(Constant.APPS_FLYER_TAG, "setAFReferralFeature: ", str, str2);
        saveStringInNormalPref(context, str, str2);
    }

    public static void setAFReferralSource(String str) {
        MPreferences.putString(Constant.AF_REFERRAL_SOURCE, str, false);
    }

    public static void setApkUrl(String str) {
        MPreferences.putString(ConfigConstant.UPDATES2_APK_URL, str, false);
    }

    public static void setAppFirstLaunch(Context context, boolean z) {
        saveBooleanInNormalPref(context, Constant.IS_APP_FIRST_LAUNCH, z);
    }

    public static void setAppsFlyerBooleanInNormalPref(Boolean bool) {
        try {
            MPreferences.putBoolean(Constant.APPSFLYER_IS_NEW_USER, bool.booleanValue(), true);
        } catch (Exception e2) {
            MLogger.e(TAG, "", e2);
        }
    }

    public static void setAppsflyerredirectiondata(String str) {
        MPreferences.putString(Constant.REDIRECTION_DATA, str, true);
    }

    public static void setBannedAppPresent(boolean z) {
        MPreferences.putBoolean(Constant.EXTRA_BANNED_APPS, z, false);
    }

    public static void setBronzeTierUpgradeEventSent(boolean z) {
        MPreferences.putBoolean("bronze_event_sent", z, false);
    }

    public static void setCompetitorsAppsListEventSend(Context context, boolean z) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constant.SHARED_PREF_NAME, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(Constant.IS_COMPETITOR_LIST_EVENT_SENT, z).apply();
        }
    }

    public static void setContentObservercount(int i) {
        MPreferences.putInt(Constant.CONTENT_OBSERVER_COUNT, i, false);
    }

    public static void setDailyAppUsageWorkerEnabled(Context context, Boolean bool) {
        saveBooleanInNormalPref(context, Constant.APP_USAGE_WORKER_ENABLED, bool.booleanValue());
    }

    public static void setDeviceId(Context context, String str) {
        saveStringInNormalPref(context, Constant.DEVICE_ID, str);
    }

    public static void setDeviceIdForPreLogin(Context context, String str) {
        saveStringInNormalPref(context, Constant.DEVICE_ID_CONFIG, str);
    }

    public static void setDownloadedAssetVersion(Context context, int i, int i2) {
        MLogger.d(TAG, AssetsUtils.TAG, "setDownloadedAssetVersion: ", "gameId: ", Integer.valueOf(i), "assetsVersion: ", Integer.valueOf(i2));
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constant.SHARED_PREF_NAME, 0);
        if (sharedPreferences != null) {
            Editor edit = sharedPreferences.edit();
            edit.putInt("downloaded_assets_version_" + i, i2).apply();
        }
    }

    public static void setEligibilityCriteria(String str) {
        MPreferences.putString(ConfigConstant.ELIGIBILITY_CRITERIA, str, false);
    }

    public static void setEntryPoint(String str) {
        MPreferences.putString("Entry Point", str, true);
    }

    public static void setGamePlayedBranchEventPushed(boolean z) {
        MPreferences.putBoolean(Constant.IS_GAME_PLAYED_BRANCH_EVENT_PUSHED, z, true);
    }

    public static void setGamePlayedBranchEventPushedV2(boolean z) {
        MPreferences.putBoolean(Constant.IS_GAME_PLAYED_BRANCH_EVENT_PUSHED_V2, z, true);
    }

    public static void setGameTamperedAppPresent(boolean z) {
        MPreferences.putBoolean(Constant.EXTRA_GAME_TAMPERED_APPS, z, false);
    }

    public static void setGuestUserLogin(boolean z) {
        MPreferences.putBoolean(ConfigConstant.IS_GUEST_USER_LOGIN, z, false);
    }

    public static void setHomeDataAndroid(String str) {
        saveStringInNormalPref(MPLApplication.getInstance(), "com.mpl.androidapp.home.android", "home_data_android", str);
    }

    public static void setIsBranchEventPushed(boolean z) {
        MPreferences.putBoolean(Constant.IS_BRANCH_EVENT_PUSHED, z, false);
    }

    public static void setIsBroadcastToolTipShown(boolean z) {
        MPreferences.putBoolean(Constant.IS_BROADCAST_TOOL_TIP_SHOWN, z, false);
    }

    public static void setIsEmulator(boolean z) {
        MPreferences.putBoolean(Constant.IS_EMULATOR_PREF, z, false);
    }

    public static void setIsNewUser(Context context, boolean z) {
        saveBooleanInNormalPref(context, "isNewUserAfterLogin", z);
    }

    public static void setIsNewUserValue(Context context) {
        String userProfile = getUserProfile();
        boolean z = false;
        if (userProfile != null && !TextUtils.isEmpty(userProfile)) {
            try {
                z = new JSONObject(userProfile).optBoolean(Constant.APPSFLYER_IS_NEW_USER, false);
            } catch (JSONException e2) {
                MLogger.printStackTrace(e2);
            }
        }
        saveBooleanInNormalPref(context, Constant.IS_NEW_USER, z);
    }

    public static void setIsPhoneRooted(boolean z) {
        MPreferences.putBoolean(Constant.IS_PHONE_ROOTED, z, false);
    }

    public static void setIsUserPlayingGame(boolean z) {
        MPreferences.putBoolean(Constant.IS_GAME_PLAYING, z, false);
    }

    public static void setLastDauEventTime(String str) {
        try {
            MPreferences.putString(Constant.LAST_DAU_EVENT_TIME, str, false);
        } catch (Exception e2) {
            MLogger.e(TAG, "", e2);
        }
    }

    public static void setLastDauEventToClevertapTime(String str) {
        try {
            MPreferences.putString(Constant.LAST_DAU_EVENT_TIME_TO_CLEVERTAP, str, false);
        } catch (Exception e2) {
            MLogger.e(TAG, "", e2);
        }
    }

    public static void setLastInstalledAppVersion(int i) {
        MPreferences.putInt(Constant.LAST_INSTALLED_ANDROID_VERSION, i, false);
    }

    public static void setLastInstalledAppVersionEvent(int i) {
        MPreferences.putInt(Constant.LAST_INSTALLED_ANDROID_VERSION_V2, i, false);
    }

    public static void setLastInstalledReactVersion(int i) {
        MPreferences.putInt(Constant.LAST_INSTALLED_REACT_VERSION, i, false);
    }

    public static void setLocationProps(Context context, String str) {
        saveStringInNormalPref(context, Constant.DEVICE_LOCATION_PROPS, str);
    }

    public static void setLogEnableForPreference() {
        MPreferences.isLoggingEnabled(MBuildConfigUtils.isLogEnabled());
    }

    public static void setMoneyInBranchEventPushed(boolean z) {
        MPreferences.putBoolean(Constant.IS_MONEY_IN_BRANCH_EVENT_PUSHED, z, true);
    }

    public static void setMoneyOutBranchEventPushed(boolean z) {
        MPreferences.putBoolean(Constant.IS_MONEY_OUT_BRANCH_EVENT_PUSHED, z, true);
    }

    public static void setNetworkProviders(Context context, String str) {
        saveStringInNormalPref(context, Constant.DEVICE_NETWORK_PROVIDERS, str);
    }

    public static void setProfile(String str) {
        MPreferences.putString(Constant.PROFILE, str, true);
    }

    public static void setReleaseNotesV2(String str) {
        MPreferences.putString(ConfigConstant.UPDATES2_RELEASE_NOTE, str, false);
    }

    public static void setReleasePoints(String str) {
        MPreferences.putString(ConfigConstant.UPDATES2_RELEASE_POINTS, str, false);
    }

    public static void setRemovedClevertapEvents() {
        String str;
        if (ConfigManager.isSaveAllConfigsToStorage()) {
            str = MPreferences.getString(ConfigConstant.REMOVED_EVENTS_ARRAYS, null, true);
        } else {
            str = ConfigManager.getNormalConfig().optString(ConfigConstant.REMOVED_EVENTS_ARRAYS.replaceFirst(ConfigConstant.CONFIG_PREFIX, ""), null);
        }
        if (str != null && !TextUtils.isEmpty(str) && CommonUtils.isJSONArrayValid(str)) {
            HashSet hashSet = (HashSet) new Gson().fromJson(str, HashSet.class);
            if (hashSet != null && hashSet.size() > 0) {
                CleverTapAnalyticsUtils.setRemovedEvents(hashSet);
            }
        }
    }

    public static void setShieldId(String str) {
        saveStringInNormalPref(MPLApplication.getInstance(), Constant.SHIELD_ID, str);
    }

    public static void setShowPopup(boolean z) {
        MPreferences.putBoolean(ConfigConstant.UPDATES2_SHOW_POPUP, z, false);
    }

    public static void setSkipPopup(boolean z) {
        MPreferences.putBoolean(ConfigConstant.UPDATES2_SKIP_POPUP, z, false);
    }

    public static void setStoriesCleanUpWorkDone(boolean z) {
        saveBooleanInNormalPref(MPLApplication.getInstance(), "stories_cleanup_work", z);
    }

    public static void setTimeTakenToDownload(long j) {
        MPreferences.putLong(ConfigConstant.TIME_TAKEN_TO_DOWNLOAD, j, true);
    }

    public static void setUpdateAvailableInUpdaterV2(boolean z) {
        MPreferences.putBoolean(ConfigConstant.UPDATES2_APK_AVAILABLE, z, false);
    }

    public static void setUpdateCriticalInUpdaterV2(boolean z) {
        MPreferences.putBoolean(ConfigConstant.UPDATES2_APK_CRITICAL_NEW, z, false);
    }

    public static void setUpdateSha(String str) {
        MPreferences.putString(ConfigConstant.UPDATES2_SHA, str, false);
    }

    public static void setUpdater2Version(int i) {
        MPreferences.putInt("version", i, false);
    }

    public static void setUserCurrentTier() {
        try {
            String userTier = getUserTier();
            if (!TextUtils.isEmpty(userTier)) {
                MPreferences.putString(Constant.USER_TIER_PREF, userTier, false);
            }
        } catch (Exception e2) {
            MLogger.e("UserTier", "setUserCurrentTier: ", e2);
        }
    }

    public static void setUserLoggedIn(boolean z) {
        MPreferences.putBoolean(Constant.IS_USER_LOGGED_IN_PREF, z, true);
    }

    public static void setUserLoggedInEventSent(boolean z) {
        MPreferences.putBoolean(ConfigConstant.IS_USER_LOGGED_IN_EVENT_SENT, z, false);
    }

    public static void setWTMEventSent(boolean z) {
        MPreferences.putBoolean(ConfigConstant.IS_WTM_EVENT_SENT, z, false);
    }

    public static boolean shouldCloseFantasyWebViewOnPause() {
        String str;
        try {
            if (ConfigManager.isSaveAllConfigsToStorage()) {
                str = MPreferences.getString(ConfigConstant.CONFIG_FANTASY_WEBVIEW_SHOULD_CLOSE_ON_PAUSE, BaseParser.FALSE, true);
            } else {
                str = ConfigManager.getPlatformConfig().optString(ConfigConstant.CONFIG_FANTASY_WEBVIEW_SHOULD_CLOSE_ON_PAUSE.replaceFirst(ConfigConstant.CONFIG_PREFIX, ""), BaseParser.FALSE);
            }
            if (str == null || TextUtils.isEmpty(str)) {
                return false;
            }
            return Boolean.parseBoolean(str);
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean shouldCloseWebViewOnPause() {
        String str;
        try {
            if (ConfigManager.isSaveAllConfigsToStorage()) {
                str = MPreferences.getString(ConfigConstant.CONFIG_WEBVIEW_SHOULD_CLOSE_ON_PAUSE, BaseParser.TRUE, true);
            } else {
                str = ConfigManager.getPlatformConfig().optString(ConfigConstant.CONFIG_WEBVIEW_SHOULD_CLOSE_ON_PAUSE.replaceFirst(ConfigConstant.CONFIG_PREFIX, ""), BaseParser.TRUE);
            }
            if (str == null || TextUtils.isEmpty(str)) {
                return true;
            }
            return Boolean.parseBoolean(str);
        } catch (Exception unused) {
            return true;
        }
    }

    public static boolean shouldHandleBackButtonFromWebView() {
        String str;
        try {
            if (ConfigManager.isSaveAllConfigsToStorage()) {
                str = MPreferences.getString(ConfigConstant.CONFIG_FANTASY_WEBVIEW_SHOULD_HANDLE_BACK_BUTTON, BaseParser.FALSE, true);
            } else {
                str = ConfigManager.getPlatformConfig().optString(ConfigConstant.CONFIG_FANTASY_WEBVIEW_SHOULD_HANDLE_BACK_BUTTON.replaceFirst(ConfigConstant.CONFIG_PREFIX, ""), BaseParser.FALSE);
            }
            if (str == null || TextUtils.isEmpty(str)) {
                return false;
            }
            return Boolean.parseBoolean(str);
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean shouldSendAppUpdatedEvent() {
        try {
            int lastInstalledAppVersionForEvent = getLastInstalledAppVersionForEvent();
            int installedAppVersionCode = MBuildConfigUtils.getInstalledAppVersionCode();
            MLogger.d(TAG, Constant.APP_UPDATE_CHECK, "shouldSendAppUpdatedEvent: ", "lastInstalledVersion: ", Integer.valueOf(lastInstalledAppVersionForEvent), "installedVersion: ", Integer.valueOf(installedAppVersionCode));
            if (lastInstalledAppVersionForEvent == 0 || lastInstalledAppVersionForEvent >= installedAppVersionCode) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void showLogoutAuthorize() {
        MLogger.d(TAG, "User Logged out from MPL");
        DownloadProgressReceiver downloadProgressReceiver = MPLReactContainerActivity.resultReceiver;
        if (downloadProgressReceiver != null) {
            downloadProgressReceiver.send(17, null);
        }
    }

    public static void hasAcceptedGBDisclaimer(boolean z) {
        MPreferences.putBoolean(Constant.IS_DISCLAIMER_ACCEPTED, z, false);
    }

    public static void deleteNormalPref(Context context, String str, String str2) {
        SharedPreferences sharedPreferences;
        if (!TextUtils.isEmpty(str2)) {
            sharedPreferences = context.getSharedPreferences(str2, 0);
        } else {
            sharedPreferences = context.getSharedPreferences(Constant.SHARED_PREF_NAME, 0);
        }
        if (sharedPreferences != null) {
            GeneratedOutlineSupport.outline93(sharedPreferences, str);
        }
    }

    public static boolean getBooleanInNormalPref(Context context, String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return getBooleanInNormalPref(context, str2, z);
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        return sharedPreferences != null ? sharedPreferences.getBoolean(str2, z) : z;
    }

    public static float getFloatInNormalPref(Context context, String str, String str2, float f2) {
        if (TextUtils.isEmpty(str)) {
            return getFloatInNormalPref(context, str2, f2);
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        return sharedPreferences != null ? sharedPreferences.getFloat(str2, f2) : f2;
    }

    public static int getIntInNormalPref(Context context, String str, String str2, int i) {
        if (TextUtils.isEmpty(str)) {
            return getIntInNormalPref(context, str2, i);
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        return sharedPreferences != null ? sharedPreferences.getInt(str2, i) : i;
    }

    public static long getLongInNormalPref(Context context, String str, String str2, long j) {
        if (TextUtils.isEmpty(str)) {
            return getLongInNormalPref(context, str2, j);
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        return sharedPreferences != null ? sharedPreferences.getLong(str2, j) : j;
    }

    public static String getStringInNormalPref(Context context, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return getStringInNormalPref(context, str2, str3);
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        return sharedPreferences != null ? sharedPreferences.getString(str2, str3) : str3;
    }

    public static void saveBooleanInNormalPref(Context context, String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str)) {
            saveBooleanInNormalPref(context, str2, z);
            return;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(str2, z).apply();
        }
    }

    public static void saveFloatInNormalPref(Context context, String str, String str2, float f2) {
        if (TextUtils.isEmpty(str)) {
            saveFloatInNormalPref(context, str2, f2);
            return;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putFloat(str2, f2).apply();
        }
    }

    public static void saveIntInNormalPref(Context context, String str, String str2, int i) {
        if (TextUtils.isEmpty(str)) {
            saveIntInNormalPref(context, str2, i);
            return;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt(str2, i).apply();
        }
    }

    public static void saveLongInNormalPref(Context context, String str, String str2, long j) {
        if (TextUtils.isEmpty(str)) {
            saveLongInNormalPref(context, str2, j);
            return;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong(str2, j).apply();
        }
    }

    public static void saveStringInNormalPref(Context context, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            saveStringInNormalPref(context, str2, str3);
            return;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(str2, str3).apply();
        }
    }
}
