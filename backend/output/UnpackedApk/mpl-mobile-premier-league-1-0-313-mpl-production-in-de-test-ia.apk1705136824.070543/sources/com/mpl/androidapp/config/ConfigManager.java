package com.mpl.androidapp.config;

import android.content.Context;
import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.MPLApplication;
import com.mpl.androidapp.R;
import com.mpl.androidapp.miniprofile.utils.Constants;
import com.mpl.androidapp.okhttp3.MemoryLruCache;
import com.mpl.androidapp.share.utils.Keys.SocialPkgName;
import com.mpl.androidapp.updater.interactor.DBInteractor;
import com.mpl.androidapp.updater.interactor.FileInteractor;
import com.mpl.androidapp.updater.util.UpdaterConstant;
import com.mpl.androidapp.utils.AssetsUtils;
import com.mpl.androidapp.utils.CleverTapAnalyticsUtils;
import com.mpl.androidapp.utils.Constant;
import com.mpl.androidapp.utils.Constant.EventsConstants;
import com.mpl.androidapp.utils.MBuildConfigUtils;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.utils.MSharedPreferencesUtils;
import com.swmansion.gesturehandler.react.RNGestureHandlerModule;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.pdfbox.pdfparser.BaseParser;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ConfigManager {
    public static boolean FREnabledFromHansel = false;
    public static final String TAG = "ConfigManager";
    public static String hanselExperienceVariantData;
    public static boolean isIpAddressConvEnabled = false;
    public static boolean isPostLoginCalledFromReact;
    public static ArrayList<String> mAndroidMatchingGameIdsList;
    public static JSONArray mCallingCountryJson = new JSONArray();
    public static JSONObject mCountryJson = new JSONObject();
    public static JSONObject mHanselConfig = new JSONObject();
    public static String mHanselExperience;
    public static JSONObject mNormalConfig = new JSONObject();
    public static JSONObject mPlatformConfig = new JSONObject();
    public static String mState = null;
    public static JSONObject preLoginConfigResponseJson = null;
    public static ArrayList<String> sParsingResponseGameIds;
    public static HashMap<Integer, JSONObject> sPartnerGames;
    public static boolean saveAllConfigsToStorage = true;

    public static ArrayList<String> getAndroidMatchingGameIdsList() {
        return mAndroidMatchingGameIdsList;
    }

    public static JSONArray getCallingCountryJson() {
        return mCallingCountryJson;
    }

    public static String getConfigUrl() {
        boolean booleanInNormalPref = MSharedPreferencesUtils.getBooleanInNormalPref(MPLApplication.getInstance(), Constant.IS_FIRST_CONFIG_CALL_SUCCESS, false);
        String format = String.format(ConfigConstant.CONFIG_PRE_LOGIN, new Object[]{MemoryLruCache.getDeviceIdForPreferences(MPLApplication.getInstance())});
        if (!booleanInNormalPref) {
            String stringInNormalPref = MSharedPreferencesUtils.getStringInNormalPref(MPLApplication.getInstance(), Constant.USER_UUID, "");
            format = String.format(ConfigConstant.CONFIG_PRE_LOGIN_CAPI, new Object[]{MemoryLruCache.getDeviceIdForPreferences(MPLApplication.getInstance()), stringInNormalPref});
        }
        MLogger.d(TAG, "getConfigUrl: ", format);
        return format;
    }

    public static Object getConfigValue(String str) {
        JSONObject jSONObject = mNormalConfig;
        if (jSONObject == null || !jSONObject.has(str)) {
            return null;
        }
        return mNormalConfig.opt(str);
    }

    public static boolean getCountryConfigBooleanValueOfKey(String str) {
        JSONArray callingCountryJson = getCallingCountryJson();
        if (callingCountryJson != null && callingCountryJson.length() >= 1) {
            JSONObject jSONObject = null;
            int i = 0;
            while (true) {
                if (i >= callingCountryJson.length()) {
                    break;
                }
                JSONObject optJSONObject = callingCountryJson.optJSONObject(i).optJSONObject("country");
                if (optJSONObject != null && optJSONObject.optString("id").equalsIgnoreCase(getCountryJson().optString("id"))) {
                    jSONObject = callingCountryJson.optJSONObject(i).optJSONObject("config");
                    break;
                }
                i++;
            }
            if (jSONObject == null) {
                jSONObject = getCallingCountryJson().optJSONObject(0).optJSONObject("config");
            }
            if (jSONObject != null && jSONObject.has(str)) {
                return jSONObject.optBoolean(str);
            }
        }
        return false;
    }

    public static JSONObject getCountryJson() {
        return mCountryJson;
    }

    public static boolean getFREnabledFromHansel() {
        return FREnabledFromHansel;
    }

    public static JSONObject getHanselConfig() {
        return mHanselConfig;
    }

    public static String getHanselExperience() {
        return mHanselExperience;
    }

    public static String getHanselExperienceVariantData() {
        return hanselExperienceVariantData;
    }

    public static JSONObject getJSONBody(Context context) {
        FileInteractor.isLoadFromAssets(context);
        JSONObject jSONObject = null;
        try {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(ConfigConstant.APK_VERSION, MBuildConfigUtils.getInstalledAppVersionCode());
                jSONObject2.put(ConfigConstant.REACT_VERSION, DBInteractor.getCurrentRNBundleVersionCode());
                jSONObject2.put(ConfigConstant.DEVICE_ID, MemoryLruCache.getDeviceIdForPreferences(context));
                jSONObject2.put(ConfigConstant.NEW_UPDATER, true);
                if (MBuildConfigUtils.isUpdateV2ExperimentalEnabledFromGradle()) {
                    jSONObject2.put(ConfigConstant.NEW_UPDATER_EXPERIMENTAL, true);
                }
                int userIdInNormalPref = MSharedPreferencesUtils.getUserIdInNormalPref(context);
                MLogger.d("userId", "getJSONBody userId", Integer.valueOf(userIdInNormalPref));
                if (userIdInNormalPref == 0) {
                    return jSONObject2;
                }
                jSONObject2.put("userId", userIdInNormalPref);
                return jSONObject2;
            } catch (JSONException e2) {
                e = e2;
                jSONObject = jSONObject2;
                MLogger.e(TAG, "getJSONBody", e);
                return jSONObject;
            }
        } catch (JSONException e3) {
            e = e3;
            MLogger.e(TAG, "getJSONBody", e);
            return jSONObject;
        }
    }

    public static JSONObject getKafkaConfig() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("enabledv1", true);
            jSONObject.put("interval", 2000);
            jSONObject.put("count", 25);
            jSONObject.put("url", "https://aag.mpl.live/k/1");
            jSONObject.put("sendingOnFailure", true);
        } catch (Exception unused) {
        }
        return (getNormalConfig() == null || getNormalConfig().optJSONObject("kafka.analytics.config") == null) ? jSONObject : getNormalConfig().optJSONObject("kafka.analytics.config");
    }

    public static JSONObject getNormalConfig() {
        return mNormalConfig;
    }

    public static JSONObject getPartnerJson(int i) {
        HashMap<Integer, JSONObject> hashMap = sPartnerGames;
        if (hashMap != null) {
            return hashMap.get(Integer.valueOf(i));
        }
        return null;
    }

    public static JSONObject getPlatformConfig() {
        return mPlatformConfig;
    }

    public static Object getPlatformConfigValue(String str) {
        JSONObject jSONObject = mPlatformConfig;
        if (jSONObject == null || !jSONObject.has(str)) {
            return null;
        }
        return mPlatformConfig.opt(str);
    }

    public static JSONObject getPreLoginConfigResponseJson() {
        return preLoginConfigResponseJson;
    }

    public static JSONObject getReferralNudgeConfig() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("permission.count", 3);
            jSONObject.put(RNGestureHandlerModule.KEY_ENABLED, false);
            jSONObject.put("enabledv2", false);
            jSONObject.put("message", MPLApplication.getInstance().getString(R.string.share_default_message));
            jSONObject.put("title", "Share screenshot with friends!");
            jSONObject.put("default.url", "https://referral-mpl-pro.onelink.me/eMpV/6e5f0fa");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("name", "WhatsApp");
            jSONObject2.put("packageName", SocialPkgName.WHATSAPP_PACKAGE_NAME);
            jSONObject.put("default.app", jSONObject2);
        } catch (Exception unused) {
        }
        return (getNormalConfig() == null || getNormalConfig().optJSONObject("referral.share.nudge.config") == null) ? jSONObject : getNormalConfig().optJSONObject("referral.share.nudge.config");
    }

    public static String getState() {
        return mState;
    }

    public static boolean isHashedIdEnabled() {
        if (getPlatformConfig() == null || !getPlatformConfig().optBoolean("hashed.unique.id.enabled", false)) {
            return false;
        }
        return true;
    }

    public static boolean isIpToAddressConvEnabled() {
        return isIpAddressConvEnabled;
    }

    public static boolean isNoCacheKey(String str) {
        return !TextUtils.isEmpty(str) && ("fraud.apps".equalsIgnoreCase(str) || "fraud.apps.message".equalsIgnoreCase(str) || "fraud.apps.title".equalsIgnoreCase(str) || "pooled.tournament.config".equalsIgnoreCase(str) || "podcast.configs".equalsIgnoreCase(str) || "challenge.configs".equalsIgnoreCase(str) || "messages.configs".equalsIgnoreCase(str) || "friends.configs".equalsIgnoreCase(str) || "groups.configs".equalsIgnoreCase(str) || "dealsHome.configs".equalsIgnoreCase(str) || "superTeam.splashLeaders".equalsIgnoreCase(str) || "partnerGameImages".equalsIgnoreCase(str) || "games.blacklist".equalsIgnoreCase(str) || "banned.games".equalsIgnoreCase(str) || "gameHistory.filter.gameTypes".equalsIgnoreCase(str) || "coupon.configs".equalsIgnoreCase(str) || "addmoney.configs".equalsIgnoreCase(str) || "deals.configs".equalsIgnoreCase(str) || "withdrawal.configs".equalsIgnoreCase(str) || "withdrawal.configs".equalsIgnoreCase(str) || str.startsWith("superTeamSports.configs") || str.startsWith("referralV85") || str.startsWith("fantasy") || str.startsWith("juspay") || str.startsWith("referral") || str.startsWith("ui.") || str.startsWith("payments.") || str.startsWith("bb.") || str.startsWith("ugt.") || str.startsWith("search.") || str.startsWith("deals.") || str.startsWith("journey.") || str.startsWith("superteam.") || str.startsWith("rummy."));
    }

    public static boolean isNotificationConfig(String str) {
        return str.equals(ConfigConstant.NOTIFICATION_FIRST_GAME_REMINDER_ENABLED) || str.equals(ConfigConstant.NOTIFICATION_LOGIN_REMINDER_ENABLED) || str.equals(ConfigConstant.NOTIFICATION_GAME_REMINDER_TITLE) || str.equals(ConfigConstant.NOTIFICATION_GAME_REMINDER_MESSAGE) || str.equals("notification.game.reminder.deeplink") || str.equals("notification.daily.spinwheel.enabled");
    }

    public static boolean isPostLoginCalledFromReact() {
        return isPostLoginCalledFromReact;
    }

    public static boolean isSaveAllConfigsToStorage() {
        return saveAllConfigsToStorage;
    }

    public static void prepareAndroidMatchingGameIds() {
        JSONArray optJSONArray = mNormalConfig.optJSONArray("game.should.match.android");
        mAndroidMatchingGameIdsList = new ArrayList<>();
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                if (!TextUtils.isEmpty(optJSONArray.optString(i))) {
                    mAndroidMatchingGameIdsList.add(optJSONArray.optString(i));
                }
            }
        }
    }

    public static void preparePartnerGameJson() {
        sPartnerGames = new HashMap<>();
        if (getNormalConfig() != null && getNormalConfig().has("partnerGameImages")) {
            JSONArray optJSONArray = getNormalConfig().optJSONArray("partnerGameImages");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    if (optJSONArray.optJSONObject(i) != null) {
                        sPartnerGames.put(Integer.valueOf(optJSONArray.optJSONObject(i).optInt("id")), optJSONArray.optJSONObject(i));
                    }
                }
            }
        }
    }

    public static void prepareWebviewParsingResponseGameIdsList() {
        sParsingResponseGameIds = new ArrayList<>();
        if (getNormalConfig() != null && getNormalConfig().has("game.webview.parse.response.gameIds")) {
            JSONArray optJSONArray = getNormalConfig().optJSONArray("game.webview.parse.response.gameIds");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    sParsingResponseGameIds.add(optJSONArray.optString(i, ""));
                }
            }
        }
    }

    public static void processCountryConfig(Object obj, String str) {
        if ("root.country".equalsIgnoreCase(str) && (obj instanceof JSONObject)) {
            mCountryJson = (JSONObject) obj;
        } else if ("login.config".equalsIgnoreCase(str) && (obj instanceof JSONArray)) {
            mCallingCountryJson = (JSONArray) obj;
        }
    }

    public static void saveConfigToSharedPref(JSONObject jSONObject) {
        if (jSONObject.has("updates.apk.critical")) {
            MSharedPreferencesUtils.putStringPref(ConfigConstant.UPDATES_APK_CRITICAL, jSONObject.optString("updates.apk.critical"), true);
        }
        if (jSONObject.has("updates.apk.version")) {
            MSharedPreferencesUtils.putStringPref(ConfigConstant.UPDATES_APK_VERSION, jSONObject.optString("updates.apk.version"), true);
        }
        if (jSONObject.has("updates.react.version")) {
            MSharedPreferencesUtils.putStringPref(ConfigConstant.UPDATES_REACT_VERSION, jSONObject.optString("updates.react.version"), true);
        }
        if (jSONObject.has("updater.critical.download.count")) {
            MSharedPreferencesUtils.putStringPref("config.updater.critical.download.count", jSONObject.optString("updater.critical.download.count"), true);
        }
        if (jSONObject.has("updates2.apk.critical.new")) {
            MSharedPreferencesUtils.putStringPref(ConfigConstant.UPDATES2_APK_CRITICAL_NEW, jSONObject.optString("updates2.apk.critical.new"), true);
        }
        if (jSONObject.has("updates2.apk.available")) {
            MSharedPreferencesUtils.putStringPref(ConfigConstant.UPDATES2_APK_AVAILABLE, jSONObject.optString("updates2.apk.available"), true);
        }
        if (jSONObject.has("root.downloadUrl")) {
            MSharedPreferencesUtils.putStringPref(ConfigConstant.ROOT_DOWNLOAD_URL, jSONObject.optString("root.downloadUrl"), true);
        }
        if (jSONObject.has("root.time")) {
            MSharedPreferencesUtils.putStringPref(ConfigConstant.ROOT_TIME, jSONObject.optString("root.time"), true);
        }
        if (jSONObject.has("root.minVersion")) {
            MSharedPreferencesUtils.putStringPref(ConfigConstant.ROOT_MIN_VERSION, jSONObject.optString("root.minVersion"), true);
        }
        if (jSONObject.has("root.status.message")) {
            MSharedPreferencesUtils.putStringPref(ConfigConstant.ROOT_STATUS_MESSAGE, jSONObject.optString("root.status.message"), true);
        }
        if (jSONObject.has("updater.newChangesEnabled")) {
            MSharedPreferencesUtils.putStringPref(ConfigConstant.CONFIG_UPDATER_NEW_CHANGES_REQUIRED, jSONObject.optString("updater.newChangesEnabled"), true);
        }
        if (jSONObject.has("website.url")) {
            MSharedPreferencesUtils.putStringPref("config.website.url", jSONObject.optString("website.url"), true);
        }
        if (jSONObject.has(Constant.INTEGRITY_CHECK_REQUIRED)) {
            MSharedPreferencesUtils.putStringPref(Constant.INTEGRITY_CHECK_REQUIRED, jSONObject.optString(Constant.INTEGRITY_CHECK_REQUIRED), false);
        }
        if (jSONObject.has(ConfigConstant.MIN_PLAYED_TIME_FOR_DELETION)) {
            MSharedPreferencesUtils.putStringPref(ConfigConstant.MIN_PLAYED_TIME_FOR_DELETION, jSONObject.optString(ConfigConstant.MIN_PLAYED_TIME_FOR_DELETION), false);
        }
        if (jSONObject.has(ConfigConstant.SECURITY_APK_KEY)) {
            MSharedPreferencesUtils.putStringPref(ConfigConstant.SECURITY_APK_KEY, jSONObject.optString(ConfigConstant.SECURITY_APK_KEY), false);
        }
        if (jSONObject.has(ConfigConstant.ASSETS_DELETION_TIME_INTERVAL)) {
            MSharedPreferencesUtils.putStringPref(ConfigConstant.ASSETS_DELETION_TIME_INTERVAL, jSONObject.optString(ConfigConstant.ASSETS_DELETION_TIME_INTERVAL), false);
        }
        if (jSONObject.has(ConfigConstant.CONFIG_IS_PRO_APP_DOWNLOAD_REQUIRED)) {
            MSharedPreferencesUtils.putStringPref(ConfigConstant.CONFIG_IS_PRO_APP_DOWNLOAD_REQUIRED, jSONObject.optString(ConfigConstant.CONFIG_IS_PRO_APP_DOWNLOAD_REQUIRED), false);
        }
        if (jSONObject.has(ConfigConstant.DOWNLOAD_THROUGH_DOWNLOADER)) {
            MSharedPreferencesUtils.putStringPref(ConfigConstant.DOWNLOAD_THROUGH_DOWNLOADER, jSONObject.optString(ConfigConstant.DOWNLOAD_THROUGH_DOWNLOADER), false);
        }
        if (jSONObject.has(ConfigConstant.GAME_NATIVE_SUBMIT_SCORE_ENABLED)) {
            MSharedPreferencesUtils.putStringPref(ConfigConstant.GAME_NATIVE_SUBMIT_SCORE_ENABLED, jSONObject.optString(ConfigConstant.GAME_NATIVE_SUBMIT_SCORE_ENABLED), false);
        }
        if (jSONObject.has(UpdaterConstant.CONFIG_UPDATER_V2_ENABLED)) {
            MSharedPreferencesUtils.putStringPref(UpdaterConstant.CONFIG_UPDATER_V2_ENABLED, jSONObject.optString(UpdaterConstant.CONFIG_UPDATER_V2_ENABLED), false);
        }
        if (jSONObject.has(UpdaterConstant.CONFIG_UPDATER_EXPERIMENTAL_V2_ENABLED)) {
            MSharedPreferencesUtils.putStringPref(UpdaterConstant.CONFIG_UPDATER_EXPERIMENTAL_V2_ENABLED, jSONObject.optString(UpdaterConstant.CONFIG_UPDATER_EXPERIMENTAL_V2_ENABLED), false);
        }
    }

    public static void setCallingCountryJson(JSONArray jSONArray) {
        mCallingCountryJson = jSONArray;
    }

    public static void setConfig(JSONObject jSONObject, JSONObject jSONObject2, boolean z) {
        MLogger.d(TAG, "setConfig:isCalledFromReact ", Boolean.valueOf(z));
        long currentTimeMillis = System.currentTimeMillis();
        if (jSONObject != null) {
            try {
                if (MSharedPreferencesUtils.getBooleanInNormalPref(MPLApplication.getInstance(), "shouldSkipFTUE", false)) {
                    if (jSONObject.has("ftue.show")) {
                        jSONObject.remove("ftue.show");
                        jSONObject.put("ftue.show", BaseParser.FALSE);
                    }
                    if (jSONObject.has("ftue.startScreen")) {
                        jSONObject.remove("ftue.startScreen");
                        jSONObject.put("ftue.startScreen", "0");
                    }
                }
            } catch (Exception unused) {
            }
            mNormalConfig = jSONObject;
            prepareAndroidMatchingGameIds();
            prepareWebviewParsingResponseGameIdsList();
            preparePartnerGameJson();
            AssetsUtils.prepareListForBundleTimeOutChecking();
            boolean optBoolean = jSONObject.optBoolean("save.storage", true);
            saveAllConfigsToStorage = optBoolean;
            MLogger.d(TAG, "setConfig:Config saveAllConfigsToStorage ", Boolean.valueOf(optBoolean));
            if (saveAllConfigsToStorage) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (!isNoCacheKey(next)) {
                        if (isNotificationConfig(next)) {
                            MSharedPreferencesUtils.saveStringInNormalPref(MPLApplication.getInstance(), next, jSONObject.optString(next));
                        } else if (shouldSaveOriginalKey(next)) {
                            MSharedPreferencesUtils.putStringPref(next, jSONObject.optString(next), false);
                        } else {
                            MSharedPreferencesUtils.putStringPref(GeneratedOutlineSupport.outline50(ConfigConstant.CONFIG_PREFIX, next), jSONObject.optString(next), true);
                        }
                    }
                }
            } else {
                saveConfigToSharedPref(jSONObject);
            }
            MSharedPreferencesUtils.setRemovedClevertapEvents();
        }
        MLogger.d(TAG, "setConfig:Config parsing and saving ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        if (jSONObject2 != null) {
            if (saveAllConfigsToStorage) {
                Iterator<String> keys2 = jSONObject2.keys();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    if (!isNoCacheKey(next2)) {
                        if (isNotificationConfig(next2)) {
                            MSharedPreferencesUtils.saveStringInNormalPref(MPLApplication.getInstance(), next2, jSONObject2.optString(next2));
                        } else if (shouldSaveOriginalKey(next2)) {
                            MSharedPreferencesUtils.putStringPref(next2, jSONObject2.optString(next2), false);
                        } else {
                            MSharedPreferencesUtils.putStringPref(GeneratedOutlineSupport.outline50(ConfigConstant.CONFIG_PREFIX, next2), jSONObject2.optString(next2), true);
                        }
                    }
                }
            } else {
                saveConfigToSharedPref(jSONObject2);
            }
            mPlatformConfig = jSONObject2;
            if (z) {
                if (getPlatformConfig().optBoolean("should.send.prelogin.event", false)) {
                    MLogger.d(TAG, "setConfig:1 ", "User Id: ", Integer.valueOf(MSharedPreferencesUtils.getUserIdInNormalPref(MPLApplication.getInstance())), "Country Code: ", MBuildConfigUtils.getCountryCode());
                    MLogger.d(TAG, "setConfig:2 ", "User Id: ", Integer.valueOf(MSharedPreferencesUtils.getUserIdInNormalPrefV2(MPLApplication.getInstance())), "Country Code: ", MBuildConfigUtils.getCountryCode());
                    HashMap hashMap = new HashMap();
                    hashMap.put("Pre Login User Id", Integer.valueOf(MSharedPreferencesUtils.getUserIdInNormalPrefV2(MPLApplication.getInstance())));
                    CleverTapAnalyticsUtils.sendEvent((String) EventsConstants.PRE_LOGIN_SUCCESS, hashMap);
                }
                CleverTapAnalyticsUtils.pushOnUserLoginEvent(new HashMap());
            }
        }
        updateUserIdForIndo();
        MLogger.d(TAG, "setConfig:Platform config parsing and saving ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }

    public static void setFREnabledFromHansel(boolean z) {
        FREnabledFromHansel = z;
    }

    public static void setHanselConfig(JSONObject jSONObject) {
        mHanselConfig = jSONObject;
    }

    public static void setHanselExperience(String str) {
        mHanselExperience = str;
    }

    public static void setHanselExperienceVariantData(String str) {
        hanselExperienceVariantData = str;
    }

    public static void setIpToAddressConvEnabled(boolean z) {
        isIpAddressConvEnabled = z;
    }

    public static void setPostLoginCalledFromReact(boolean z) {
        isPostLoginCalledFromReact = z;
    }

    public static void setPreLoginConfigResponseJson(JSONObject jSONObject) {
        preLoginConfigResponseJson = jSONObject;
    }

    public static void setState(String str) {
        mState = str;
    }

    public static boolean shouldMatchInAndroid(int i) {
        ArrayList<String> arrayList = mAndroidMatchingGameIdsList;
        return arrayList != null && arrayList.contains(String.valueOf(i));
    }

    public static boolean shouldParseResponse(int i) {
        ArrayList<String> arrayList = sParsingResponseGameIds;
        return arrayList != null && arrayList.size() > 0 && sParsingResponseGameIds.contains(String.valueOf(i));
    }

    public static boolean shouldSaveOriginalKey(String str) {
        return str.equals(Constant.INTEGRITY_CHECK_REQUIRED) || str.equals(ConfigConstant.MIN_PLAYED_TIME_FOR_DELETION) || str.equals(ConfigConstant.SECURITY_APK_KEY) || str.equals(ConfigConstant.ASSETS_DELETION_TIME_INTERVAL) || str.equals(ConfigConstant.CONFIG_IS_PRO_APP_DOWNLOAD_REQUIRED) || str.equals(ConfigConstant.DOWNLOAD_THROUGH_DOWNLOADER) || str.equals(ConfigConstant.GAME_NATIVE_SUBMIT_SCORE_ENABLED) || str.equals(UpdaterConstant.CONFIG_UPDATER_V2_ENABLED) || str.equals(UpdaterConstant.CONFIG_UPDATER_EXPERIMENTAL_V2_ENABLED);
    }

    public static void updateUserIdForIndo() {
        try {
            String profile = MSharedPreferencesUtils.getProfile();
            int userIdInNormalPref = MSharedPreferencesUtils.getUserIdInNormalPref(MPLApplication.getInstance());
            if (!TextUtils.isEmpty(profile) && getNormalConfig() != null && getNormalConfig().optInt("minUserID", 0) > 0) {
                int optInt = getNormalConfig().optInt("minUserID", 0);
                if (userIdInNormalPref < optInt) {
                    JSONObject jSONObject = new JSONObject(profile);
                    jSONObject.put("id", optInt + jSONObject.optInt("id", 0));
                    MSharedPreferencesUtils.setProfile(jSONObject.toString());
                    MSharedPreferencesUtils.moveUserIdInNormalPref(MPLApplication.getInstance());
                    MSharedPreferencesUtils.removeSecurePref(Constants.FOLLOW_CACHE_KEY);
                }
            }
        } catch (Exception unused) {
        }
    }

    public static void setConfig(JSONObject jSONObject) {
        if (jSONObject != null) {
            mNormalConfig = jSONObject;
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!isNoCacheKey(next)) {
                    if ("root.country".equalsIgnoreCase(next)) {
                        processCountryConfig(jSONObject.optJSONObject(next), next);
                    } else if ("login.config".equalsIgnoreCase(next)) {
                        processCountryConfig(jSONObject.optJSONArray(next), next);
                    }
                    if (isNotificationConfig(next)) {
                        MSharedPreferencesUtils.saveStringInNormalPref(MPLApplication.getInstance(), next, jSONObject.optString(next));
                    } else if (shouldSaveOriginalKey(next)) {
                        MSharedPreferencesUtils.putStringPref(next, jSONObject.optString(next), false);
                    } else {
                        MSharedPreferencesUtils.putStringPref(GeneratedOutlineSupport.outline50(ConfigConstant.CONFIG_PREFIX, next), jSONObject.optString(next), true);
                    }
                }
            }
            MSharedPreferencesUtils.setRemovedClevertapEvents();
        }
    }
}
