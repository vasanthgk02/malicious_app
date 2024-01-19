package io.hansel.core.base.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.graphics.Point;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.view.WindowManager;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.freshchat.consumer.sdk.beans.config.DefaultRemoteConfig;
import io.hansel.core.HSLBuildConfig;
import io.hansel.core.crash.a;
import io.hansel.core.json.CoreJSONArray;
import io.hansel.core.json.CoreJSONException;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.core.logger.HSLLogger;
import io.hansel.core.logger.LogGroup;
import io.hansel.core.sdkmodels.HSLSDKIdentifiers;
import io.hansel.userjourney.p;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import org.apache.pdfbox.pdfparser.BaseParser;
import org.json.JSONArray;

public class HSLInternalUtils {
    public static final int CRASHLOG_MAX_OFFLINE_COUNT = 20;
    public static final int CRASHLOG_OFFLINE_DELETE_CHUNK = 2;
    public static final String HSL_IN_BACKGROUND = "HSL_IN_BACKGROUND";
    public static final String HSL_IN_FOREGROUND = "HSL_IN_FOREGROUND";
    public static final int INITSDK_MAX_OFFLINE_COUNT = 200;
    public static final int INITSDK_OFFLINE_DELETE_CHUNK = 10;
    public static final String IS_IN_TESTGROUP = "is_in_testgroup";
    public static final String IS_TG_STATUS_KNOWN = "is_tg_status_known";
    public static final String KEY_APPVERSION_OF_PATCHES = "hansel_appversion_of_patchlist";
    public static final String KEY_CRASH_DATA = "CRASH_DATA";
    public static final String KEY_DONT_USE_HANSEL = "USE_HANSEL";
    public static final String KEY_INITSDK_IS_PUSH_INITIATED = "hansel_initsdk_is_push_initiated";
    public static final String KEY_INITSDK_REQUEST_SILENCE_INTERVAL = "hansel_initsdk_request_silence_interval";
    public static final String KEY_INIT_SDK_DATA = "KEY_INIT_SDK_DATA";
    public static final String KEY_LAST_PUSH_REFERENCE_TIME = "hansel_last_push_ref_time";
    public static final String KEY_OLD_SDK_V = "osv";
    public static final String KEY_PATCH_LIST_VERSION = "hansel_patch_list_version";
    public static final String KEY_PREFERENCE_NAME_HANSEL = "PREFERENCE_NAME_HANSEL";
    public static final String KEY_PUSH_TOKEN = "hansel_push_token";
    public static final String KEY_PUSH_TOKEN_NOT_SYNCED = "hansel_push_token_not_synced";
    public static final String KEY_REGISTER_PN_TOKEN_REQUEST_SILENCE_INTERVAL = "hansel_register_pn_token_request_silence_interval";
    public static final String KEY_STATIC_CRITERIA_VERSION = "key_static_criteria_version";
    public static final String TG_AUTH_URL = "tg_auth_url";
    public static List<a> crashDataList;
    public static HSLSDKIdentifiers hslsdkIdentifiers;
    public static boolean sHSLDoNotUseHansel;

    public static void addCrashData(Context context, a aVar) {
        List<a> crashData = getCrashData(context);
        crashData.add(aVar);
        int size = crashData.size();
        if (size > 20 && 2 < size) {
            crashData = crashData.subList(2, size);
        }
        setCrashData(context, crashData);
    }

    public static String addQueryParamsToGetDataUrl(Context context, String str) {
        if (str == null) {
            return null;
        }
        return GeneratedOutlineSupport.outline54(str, "?av=", hslsdkIdentifiers.appVersion.versionName, "&tg=", isInTestGroup(context) ? BaseParser.TRUE : BaseParser.FALSE);
    }

    public static CoreJSONArray appendArray(CoreJSONArray coreJSONArray, CoreJSONArray coreJSONArray2) {
        if (coreJSONArray == null || coreJSONArray.length() == 0) {
            return coreJSONArray2;
        }
        if (!(coreJSONArray2 == null || coreJSONArray2.length() == 0)) {
            int length = coreJSONArray2.length();
            for (int i = 0; i < length; i++) {
                coreJSONArray.put(coreJSONArray2.opt(i));
            }
        }
        return coreJSONArray;
    }

    public static CoreJSONObject appendArray(CoreJSONObject coreJSONObject, CoreJSONObject coreJSONObject2) {
        if (coreJSONObject == null) {
            return coreJSONObject2;
        }
        if (coreJSONObject2 == null) {
            return coreJSONObject;
        }
        ArrayList arrayList = new ArrayList(coreJSONObject.keySet());
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            String str = (String) arrayList.get(i);
            try {
                coreJSONObject2.put(str, coreJSONObject.opt(str));
            } catch (CoreJSONException e2) {
                HSLLogger.printStackTrace(e2);
            }
        }
        return coreJSONObject2;
    }

    public static void appendStringArray(CoreJSONArray coreJSONArray, CoreJSONArray coreJSONArray2) {
        if (coreJSONArray == null) {
            coreJSONArray = new CoreJSONArray();
        }
        if (coreJSONArray2 != null) {
            int length = coreJSONArray2.length();
            for (int i = 0; i < length; i++) {
                coreJSONArray.put((Object) coreJSONArray2.optString(i));
            }
        }
    }

    public static boolean areExperiencesEnabled(Context context) {
        return areExperiencesUJEnabled(context) || areFeaturesEnabled(context);
    }

    public static boolean areExperiencesUJEnabled(Context context) {
        return getBooleanFromSharedPreferences(context, "is_exp_enabled", true);
    }

    public static boolean areFeaturesEnabled(Context context) {
        return getBooleanFromSharedPreferences(context, "is_features_enabled", true);
    }

    public static List<CoreJSONObject> asList(CoreJSONArray coreJSONArray) {
        int length = coreJSONArray.length();
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            CoreJSONObject optJSONObject = coreJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(optJSONObject);
            }
        }
        return arrayList;
    }

    public static void checkSessionEntryTimeAndFreqLimit(Context context, long j) {
        long lastBackgroundTs = getLastBackgroundTs(context);
        if (lastBackgroundTs != 0 && lastBackgroundTs + DefaultRemoteConfig.SESSION_TIMEOUT_DURATION < j) {
            setLongInSharedPreferences(context, "SESSION_ENTRY_TIME", j);
            setIntInSharedPreferences(context, "SESSION_LIMIT_FREQ", (getIntFromSharedPreferences(context, "SESSION_LIMIT_FREQ") + 1) % p.n(context));
        }
    }

    public static void clearKey(Context context, String str) {
        Editor edit = context.getSharedPreferences(KEY_PREFERENCE_NAME_HANSEL, 0).edit();
        edit.remove(str);
        edit.apply();
    }

    public static void clearKeys(Context context, String[] strArr) {
        Editor edit = context.getSharedPreferences(KEY_PREFERENCE_NAME_HANSEL, 0).edit();
        for (String remove : strArr) {
            edit.remove(remove);
        }
        edit.apply();
    }

    public static int compareDouble(double d2, double d3) {
        return Double.compare(d2, d3);
    }

    public static boolean containsObject(CoreJSONArray coreJSONArray, String str, String str2) {
        if (coreJSONArray != null && coreJSONArray.length() != 0 && !isEmpty(str) && !isEmpty(str2)) {
            int length = coreJSONArray.length();
            for (int i = 0; i < length; i++) {
                CoreJSONObject optJSONObject = coreJSONArray.optJSONObject(i);
                if (optJSONObject != null && optJSONObject.optString(str).equalsIgnoreCase(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean containsString(CoreJSONArray coreJSONArray, String str) {
        if (!(coreJSONArray == null || coreJSONArray.length() == 0 || isEmpty(str))) {
            int length = coreJSONArray.length();
            for (int i = 0; i < length; i++) {
                if (str.equalsIgnoreCase(coreJSONArray.optString(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean doNotUseHansel(Context context) {
        return getBooleanFromSharedPreferences(context, KEY_DONT_USE_HANSEL);
    }

    public static boolean equals(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        return str.equals(str2);
    }

    public static String generateRandomString(int i) {
        char[] charArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456879".toCharArray();
        SecureRandom secureRandom = new SecureRandom();
        Random random = new Random();
        char[] cArr = new char[i];
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 % 10 == 0) {
                random.setSeed(secureRandom.nextLong());
            }
            cArr[i2] = charArray[random.nextInt(charArray.length)];
        }
        return new String(cArr);
    }

    public static float getBatteryLevel(Context context) {
        int i;
        int i2;
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            i2 = registerReceiver.getIntExtra("level", -1);
            i = registerReceiver.getIntExtra("scale", -1);
        } else {
            i = -1;
            i2 = -1;
        }
        if (i2 == -1 || i == -1) {
            return 50.0f;
        }
        return (((float) i2) / ((float) i)) * 100.0f;
    }

    public static boolean getBooleanFromSharedPreferences(Context context, String str) {
        return getBooleanFromSharedPreferences(context, str, false);
    }

    public static boolean getBooleanFromSharedPreferences(Context context, String str, boolean z) {
        return context.getSharedPreferences(KEY_PREFERENCE_NAME_HANSEL, 0).getBoolean(str, z);
    }

    public static long getCharacterLimitForVendor(String str) {
        return 100;
    }

    public static List<a> getCrashData(Context context) {
        if (crashDataList == null) {
            crashDataList = new ArrayList();
            String stringFromSharedPreferences = getStringFromSharedPreferences(context, KEY_CRASH_DATA, null);
            if (stringFromSharedPreferences != null && !stringFromSharedPreferences.isEmpty()) {
                try {
                    CoreJSONArray coreJSONArray = new CoreJSONArray(stringFromSharedPreferences);
                    int length = coreJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        crashDataList.add(new a(coreJSONArray.getJSONObject(i).toString()));
                    }
                } catch (Exception e2) {
                    HSLLogger.printStackTrace(e2);
                }
            }
        }
        return crashDataList;
    }

    public static String getDeviceId(ContentResolver contentResolver) {
        return Secure.getString(contentResolver, "android_id");
    }

    public static String getDeviceLanguageCode() {
        return Locale.getDefault().getLanguage();
    }

    public static float getFloatFromSharedPreferences(Context context, String str) {
        return context.getSharedPreferences(KEY_PREFERENCE_NAME_HANSEL, 0).getFloat(str, 0.0f);
    }

    public static long getFreeMemory() {
        StatFs statFs = new StatFs(Environment.getRootDirectory().getAbsolutePath());
        return statFs.getBlockSizeLong() * statFs.getAvailableBlocksLong();
    }

    public static int getIntFromSharedPreferences(Context context, String str) {
        return getIntFromSharedPreferences(context, str, 0);
    }

    public static int getIntFromSharedPreferences(Context context, String str, int i) {
        return context.getSharedPreferences(KEY_PREFERENCE_NAME_HANSEL, 0).getInt(str, i);
    }

    public static long getLastBackgroundTs(Context context) {
        return getLongFromSharedPreferences(context, HSL_IN_BACKGROUND);
    }

    public static long getLastForegroundTs(Context context) {
        return getLongFromSharedPreferences(context, HSL_IN_FOREGROUND);
    }

    public static ArrayList<String> getListFromJSONArray(CoreJSONArray coreJSONArray) {
        if (coreJSONArray == null) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        int length = coreJSONArray.length();
        for (int i = 0; i < length; i++) {
            arrayList.add(coreJSONArray.optString(i));
        }
        return arrayList;
    }

    public static long getLongFromSharedPreferences(Context context, String str) {
        return context.getSharedPreferences(KEY_PREFERENCE_NAME_HANSEL, 0).getLong(str, 0);
    }

    public static int getOrientation(Context context) {
        return context.getResources().getConfiguration().orientation;
    }

    public static long getRequestFailureTTL(Context context) {
        return context.getSharedPreferences(KEY_PREFERENCE_NAME_HANSEL, 0).getLong("hansel_request_failure_ttl", 15);
    }

    public static Point getScreenSize(Context context) {
        Point point = new Point();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getSize(point);
        return point;
    }

    public static String getServerUrlWithPath(String str, Context context) {
        return HSLBuildConfig.getServerBaseUrl(context) + str;
    }

    public static String[] getStringArrayFromJSONArray(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        String[] strArr = new String[jSONArray.length()];
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            strArr[i] = jSONArray.optString(i);
        }
        return strArr;
    }

    public static String getStringFromSharedPreferences(Context context, String str) {
        return getStringFromSharedPreferences(context, str, "");
    }

    public static String getStringFromSharedPreferences(Context context, String str, String str2) {
        return context.getSharedPreferences(KEY_PREFERENCE_NAME_HANSEL, 0).getString(str, str2);
    }

    public static String getTgAuthEndPoint(Context context) {
        return context.getSharedPreferences(KEY_PREFERENCE_NAME_HANSEL, 0).getString(TG_AUTH_URL, null);
    }

    public static long getTotalMemory() {
        StatFs statFs = new StatFs(Environment.getRootDirectory().getAbsolutePath());
        return statFs.getBlockSizeLong() * statFs.getBlockCountLong();
    }

    public static String getUrlFromFormat(Context context, String str, String str2) {
        String[] split = str.split("/");
        int length = split.length;
        String str3 = "";
        for (int i = 0; i < length; i++) {
            String str4 = split[i];
            str4.hashCode();
            char c2 = 65535;
            switch (str4.hashCode()) {
                case 1884397:
                    if (str4.equals("<av>")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 1897758:
                    if (str4.equals("<os>")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 1900734:
                    if (str4.equals("<rv>")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 1901695:
                    if (str4.equals("<sv>")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 1902191:
                    if (str4.equals("<tg>")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 695782313:
                    if (str4.equals("<app_id>")) {
                        c2 = 5;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                str4 = hslsdkIdentifiers.appVersion.versionName;
            } else if (c2 == 1) {
                str4 = "android";
            } else if (c2 == 2) {
                str4 = str2;
            } else if (c2 == 3) {
                str4 = HSLBuildConfig.SDK_VERSION;
            } else if (c2 == 4) {
                str4 = isInTestGroup(context) ? BaseParser.TRUE : BaseParser.FALSE;
            } else if (c2 == 5) {
                str4 = hslsdkIdentifiers.appId;
            }
            if (i > 0) {
                str3 = GeneratedOutlineSupport.outline50(str3, "/");
            }
            str3 = GeneratedOutlineSupport.outline50(str3, str4);
        }
        return GeneratedOutlineSupport.outline50(str3, "/");
    }

    public static String implodeArray(List<String> list, String str) {
        if (list.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(list.get(0));
        int size = list.size();
        for (int i = 1; i < size; i++) {
            sb.append(str);
            sb.append(list.get(i));
        }
        return sb.toString();
    }

    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public static boolean isInTestGroup(Context context) {
        return getBooleanFromSharedPreferences(context, IS_IN_TESTGROUP);
    }

    public static boolean isJourneyEnabled(Context context) {
        return getBooleanFromSharedPreferences(context, "is_journey_enabled", false);
    }

    public static boolean isLocalizationEnabled(Context context) {
        return getBooleanFromSharedPreferences(context, "is_loc_enabled", false);
    }

    public static boolean isStringEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static boolean isTGStatusKnown(Context context) {
        return getBooleanFromSharedPreferences(context, IS_TG_STATUS_KNOWN);
    }

    public static CoreJSONArray mergeJSONObjectArray(CoreJSONArray coreJSONArray, CoreJSONArray coreJSONArray2, String str) {
        if (coreJSONArray == null || coreJSONArray.length() == 0) {
            return coreJSONArray2;
        }
        if (!(coreJSONArray2 == null || coreJSONArray2.length() == 0)) {
            int length = coreJSONArray2.length();
            for (int i = 0; i < length; i++) {
                CoreJSONObject optJSONObject = coreJSONArray2.optJSONObject(i);
                if (optJSONObject != null && !containsObject(coreJSONArray, str, optJSONObject.optString(str))) {
                    coreJSONArray.put((Object) optJSONObject);
                }
            }
        }
        return coreJSONArray;
    }

    public static CoreJSONArray mergeStringArray(CoreJSONArray coreJSONArray, CoreJSONArray coreJSONArray2) {
        if (coreJSONArray == null || coreJSONArray.length() == 0) {
            return coreJSONArray2;
        }
        if (!(coreJSONArray2 == null || coreJSONArray2.length() == 0)) {
            int length = coreJSONArray2.length();
            for (int i = 0; i < length; i++) {
                String optString = coreJSONArray2.optString(i);
                if (!containsString(coreJSONArray, optString)) {
                    coreJSONArray.put((Object) optString);
                }
            }
        }
        return coreJSONArray;
    }

    public static void populateAppVersion(Context context, HSLVersion hSLVersion) {
        if (hSLVersion != null && context != null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                hSLVersion.versionName = packageInfo.versionName;
                hSLVersion.versionCode = packageInfo.versionCode;
                HSLLogger.d("App version:  " + hSLVersion.versionName, LogGroup.DV);
            } catch (Exception e2) {
                HSLLogger.printStackTrace(e2);
            }
        }
    }

    public static CoreJSONArray removeElementFromJsonArrayAtIndex(int i, CoreJSONArray coreJSONArray) {
        List<CoreJSONObject> asList = asList(coreJSONArray);
        if (i >= 0 && i < asList.size()) {
            asList.remove(i);
        }
        CoreJSONArray coreJSONArray2 = new CoreJSONArray();
        int size = asList.size();
        for (int i2 = 0; i2 < size; i2++) {
            coreJSONArray2.put((Object) asList.get(i2));
        }
        return coreJSONArray2;
    }

    public static CoreJSONArray removeElementsFromJsonArrayAtIndex(int i, int i2, CoreJSONArray coreJSONArray) {
        List<CoreJSONObject> asList = asList(coreJSONArray);
        if (i < 0 || i >= asList.size()) {
            return coreJSONArray;
        }
        for (int i3 = 0; i3 < i2 && i < asList.size(); i3++) {
            asList.remove(i);
        }
        CoreJSONArray coreJSONArray2 = new CoreJSONArray();
        int size = asList.size();
        for (int i4 = 0; i4 < size; i4++) {
            coreJSONArray2.put((Object) asList.get(i4));
        }
        return coreJSONArray2;
    }

    public static CoreJSONArray removeStringFromJSONArray(CoreJSONArray coreJSONArray, String str) {
        if (isEmpty(str)) {
            return coreJSONArray;
        }
        if (coreJSONArray != null) {
            CoreJSONArray coreJSONArray2 = new CoreJSONArray();
            int length = coreJSONArray.length();
            for (int i = 0; i < length; i++) {
                String optString = coreJSONArray.optString(i);
                if (!str.equals(optString)) {
                    coreJSONArray2.put((Object) optString);
                }
            }
            coreJSONArray = coreJSONArray2;
        }
        return coreJSONArray;
    }

    public static void saveTgAuthEndPoint(Context context, String str) {
        Editor edit = context.getSharedPreferences(KEY_PREFERENCE_NAME_HANSEL, 0).edit();
        (isEmpty(str) ? edit.remove(TG_AUTH_URL) : edit.putString(TG_AUTH_URL, str)).apply();
        edit.apply();
    }

    public static void setBooleanInSharedPreferences(Context context, String str, boolean z) {
        Editor edit = context.getSharedPreferences(KEY_PREFERENCE_NAME_HANSEL, 0).edit();
        edit.putBoolean(str, z);
        edit.apply();
    }

    public static void setCrashData(Context context, List<a> list) {
        CoreJSONArray coreJSONArray = new CoreJSONArray();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            coreJSONArray.put((Object) list.get(i).b());
        }
        setStringInSharedPreferences(context, KEY_CRASH_DATA, coreJSONArray.toString());
    }

    public static void setFloatInSharedPreferences(Context context, String str, float f2) {
        Editor edit = context.getSharedPreferences(KEY_PREFERENCE_NAME_HANSEL, 0).edit();
        edit.putFloat(str, f2);
        edit.apply();
    }

    public static void setIntInSharedPreferences(Context context, String str, int i) {
        Editor edit = context.getSharedPreferences(KEY_PREFERENCE_NAME_HANSEL, 0).edit();
        edit.putInt(str, i);
        edit.apply();
    }

    public static void setLastBackgroundTs(Context context) {
        setLongInSharedPreferences(context, HSL_IN_BACKGROUND, System.currentTimeMillis());
    }

    public static void setLastForegroundTs(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        setLongInSharedPreferences(context, HSL_IN_FOREGROUND, currentTimeMillis);
        checkSessionEntryTimeAndFreqLimit(context, currentTimeMillis);
    }

    public static void setLongInSharedPreferences(Context context, String str, long j) {
        Editor edit = context.getSharedPreferences(KEY_PREFERENCE_NAME_HANSEL, 0).edit();
        edit.putLong(str, j);
        edit.apply();
    }

    public static void setSDKIdentifiers(HSLSDKIdentifiers hSLSDKIdentifiers) {
        hslsdkIdentifiers = hSLSDKIdentifiers;
    }

    public static void setStringInSharedPreferences(Context context, String str, String str2) {
        context.getSharedPreferences(KEY_PREFERENCE_NAME_HANSEL, 0).edit().putString(str, str2).apply();
    }
}
