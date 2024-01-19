package com.mpl.androidapp.utils;

import android.text.TextUtils;
import com.midtrans.sdk.gopaycheckout.core.transaction.TransactionRequestKt;
import com.mpl.androidapp.MPLApplication;
import com.mpl.androidapp.config.ConfigManager;
import org.json.JSONArray;
import org.json.JSONObject;

public class CountryUtils {
    public static final String TAG = "CountryUtils";
    public static String sCountryCode;
    public static JSONObject sCountryDataAfterLogin;

    public static int getCountryCallingCode() {
        if (ConfigManager.getCallingCountryJson() != null && ConfigManager.getCallingCountryJson().length() == 1) {
            JSONObject optJSONObject = ConfigManager.getCallingCountryJson().optJSONObject(0);
            if (optJSONObject != null && optJSONObject.has("callingCode")) {
                return optJSONObject.optInt("callingCode");
            }
        }
        return 0;
    }

    public static int getCountryCallingCodeSplash() {
        if (ConfigManager.getCountryJson() == null || !ConfigManager.getCountryJson().has("callingCode")) {
            return 0;
        }
        return ConfigManager.getCountryJson().optInt("callingCode");
    }

    public static String getCountryCodeForUnity() {
        return sCountryCode;
    }

    public static String getCountryCodeInNormalPref() {
        return MSharedPreferencesUtils.getStringInNormalPref(MPLApplication.getInstance(), Constant.COUNTRY_CODE_NORMAL_PREF, "IN");
    }

    public static String getCountryCodeInNormalPrefNew() {
        return MSharedPreferencesUtils.getStringInNormalPref(MPLApplication.getInstance(), Constant.COUNTRY_CODE_NORMAL_PREF, "");
    }

    public static String getCountryCodeSplash() {
        return (ConfigManager.getCountryJson() == null || ConfigManager.getCountryJson().length() <= 0 || TextUtils.isEmpty(ConfigManager.getCountryJson().optString("id"))) ? "" : ConfigManager.getCountryJson().optString("id");
    }

    public static JSONObject getCountryDataAfterLogin() {
        return sCountryDataAfterLogin;
    }

    public static String getCountryName() {
        if (ConfigManager.getCallingCountryJson() != null && ConfigManager.getCallingCountryJson().length() == 1) {
            JSONObject optJSONObject = ConfigManager.getCallingCountryJson().optJSONObject(0);
            if (optJSONObject != null && !TextUtils.isEmpty(optJSONObject.optString("countryName"))) {
                return optJSONObject.optString("countryName");
            }
        }
        return "";
    }

    public static String getCurrencyCode() {
        if (getSavedCountryCode().equalsIgnoreCase("id")) {
            return TransactionRequestKt.DEFAULT_CURRENCY;
        }
        return getSavedCountryCode().equalsIgnoreCase("in") ? "INR" : "";
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0045  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int getSavedCountryCallingCode() {
        /*
            java.lang.String r0 = "callingCode"
            java.lang.String r1 = "getSavedCountryCallingCode: "
            java.lang.String r2 = "CountryUtils"
            r3 = 2
            r4 = 1
            r5 = 0
            java.lang.String r6 = "country_data"
            java.lang.String r7 = ""
            java.lang.String r6 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getStringPref(r6, r7, r4)     // Catch:{ Exception -> 0x0031 }
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x0031 }
            if (r7 != 0) goto L_0x0042
            boolean r7 = com.mpl.androidapp.utils.CommonUtils.isJSONValid(r6)     // Catch:{ Exception -> 0x0031 }
            if (r7 == 0) goto L_0x0042
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ Exception -> 0x0031 }
            r7.<init>(r6)     // Catch:{ Exception -> 0x0031 }
            java.lang.String r6 = r7.optString(r0)     // Catch:{ Exception -> 0x0031 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x0031 }
            if (r6 != 0) goto L_0x0042
            int r0 = r7.optInt(r0)     // Catch:{ Exception -> 0x0031 }
            goto L_0x0043
        L_0x0031:
            r0 = move-exception
            r6 = 3
            java.lang.Object[] r6 = new java.lang.Object[r6]
            r6[r5] = r1
            java.lang.Integer r7 = java.lang.Integer.valueOf(r5)
            r6[r4] = r7
            r6[r3] = r0
            com.mpl.androidapp.utils.MLogger.e(r2, r6)
        L_0x0042:
            r0 = 0
        L_0x0043:
            if (r0 != 0) goto L_0x0049
            int r0 = getCountryCallingCodeSplash()
        L_0x0049:
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r3[r5] = r1
            java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
            r3[r4] = r1
            com.mpl.androidapp.utils.MLogger.d(r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.utils.CountryUtils.getSavedCountryCallingCode():int");
    }

    public static String getSavedCountryCode() {
        String str = "";
        try {
            String stringPref = MSharedPreferencesUtils.getStringPref(Constant.COUNTRY_DATA, str, true);
            if (!TextUtils.isEmpty(stringPref) && CommonUtils.isJSONValid(stringPref)) {
                JSONObject jSONObject = new JSONObject(stringPref);
                if (!TextUtils.isEmpty(jSONObject.optString("countryId"))) {
                    str = jSONObject.optString("countryId");
                    setCountryCodeForUnity(str);
                }
            }
        } catch (Exception e2) {
            MLogger.e(TAG, "getSavedCountryCode: ", str);
            MLogger.e(TAG, e2);
        }
        if (TextUtils.isEmpty(str)) {
            str = getCountryCodeSplash();
        }
        MLogger.d(TAG, "getSavedCountryCode: ", str, getCountryCodeForUnity());
        saveCountryCodeInNormalPref(str);
        return str;
    }

    public static JSONObject getSplashConfig() {
        JSONObject jSONObject;
        try {
            String countryCode = MBuildConfigUtils.getCountryCode();
            JSONArray callingCountryJson = ConfigManager.getCallingCountryJson();
            if (!TextUtils.isEmpty(countryCode) && callingCountryJson != null && callingCountryJson.length() >= 1) {
                int i = 0;
                while (true) {
                    if (i >= callingCountryJson.length()) {
                        jSONObject = null;
                        break;
                    }
                    JSONObject optJSONObject = callingCountryJson.optJSONObject(i).optJSONObject("country");
                    if (optJSONObject != null && optJSONObject.optString("id").equalsIgnoreCase(countryCode)) {
                        jSONObject = callingCountryJson.optJSONObject(i).optJSONObject("config");
                        break;
                    }
                    i++;
                }
                if (jSONObject == null) {
                    jSONObject = ConfigManager.getCallingCountryJson().optJSONObject(0).optJSONObject("config");
                }
                if (jSONObject != null && jSONObject.has(Constant.SPLASH_CONFIG)) {
                    return new JSONObject(jSONObject.optString(Constant.SPLASH_CONFIG));
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static String getSplashImage() {
        JSONArray callingCountryJson = ConfigManager.getCallingCountryJson();
        String savedCountryCode = getSavedCountryCode();
        if (callingCountryJson != null && callingCountryJson.length() >= 1) {
            JSONObject jSONObject = null;
            int i = 0;
            while (true) {
                if (i >= callingCountryJson.length()) {
                    break;
                }
                JSONObject optJSONObject = callingCountryJson.optJSONObject(i).optJSONObject("country");
                if (optJSONObject != null && optJSONObject.optString("id").equalsIgnoreCase(savedCountryCode)) {
                    jSONObject = callingCountryJson.optJSONObject(i).optJSONObject("config");
                    break;
                }
                i++;
            }
            if (jSONObject == null) {
                jSONObject = ConfigManager.getCallingCountryJson().optJSONObject(0).optJSONObject("config");
            }
            if (jSONObject != null && jSONObject.has(Constant.SPLASH_IMAGE)) {
                return jSONObject.optString(Constant.SPLASH_IMAGE);
            }
        }
        return "";
    }

    public static String getUniqueIdForThirdPartySDKs() {
        String str;
        try {
            str = MSharedPreferencesUtils.getUserMobileNumber();
            try {
                if (ConfigManager.isHashedIdEnabled()) {
                    return MSharedPreferencesUtils.getUserHashedId();
                }
                return str;
            } catch (Exception e2) {
                e = e2;
                MLogger.e(TAG, "getUniqueIdForThirdPartySDKs", e);
                return str;
            }
        } catch (Exception e3) {
            e = e3;
            str = "";
            MLogger.e(TAG, "getUniqueIdForThirdPartySDKs", e);
            return str;
        }
    }

    public static boolean isCountrySupported() {
        if (ConfigManager.getCountryJson() != null) {
            return ConfigManager.getCountryJson().optBoolean("countrySupported", false);
        }
        return false;
    }

    public static boolean isLocalizationEnabled(String str) {
        boolean z;
        JSONArray callingCountryJson = ConfigManager.getCallingCountryJson();
        if (callingCountryJson != null && callingCountryJson.length() >= 1) {
            JSONObject jSONObject = null;
            int i = 0;
            while (true) {
                if (i >= callingCountryJson.length()) {
                    break;
                }
                JSONObject optJSONObject = callingCountryJson.optJSONObject(i).optJSONObject("country");
                if (optJSONObject != null && optJSONObject.optString("id").equalsIgnoreCase(ConfigManager.getCountryJson().optString("id"))) {
                    jSONObject = callingCountryJson.optJSONObject(i).optJSONObject("config");
                    break;
                }
                i++;
            }
            if (jSONObject == null) {
                jSONObject = ConfigManager.getCallingCountryJson().optJSONObject(0).optJSONObject("config");
            }
            if (jSONObject != null && jSONObject.has(str)) {
                z = jSONObject.optBoolean(str);
                MLogger.d(TAG, "isLocalizationEnabled: ", Boolean.valueOf(z));
                return z;
            }
        }
        z = false;
        MLogger.d(TAG, "isLocalizationEnabled: ", Boolean.valueOf(z));
        return z;
    }

    public static void saveCountryCodeInNormalPref(String str) {
        if (!TextUtils.isEmpty(str)) {
            MSharedPreferencesUtils.saveStringInNormalPref(MPLApplication.getInstance(), Constant.COUNTRY_CODE_NORMAL_PREF, str);
        }
    }

    public static void saveCountryDataAfterLogin(JSONObject jSONObject) {
        MLogger.d(TAG, "saveCountryDataAfterLogin: ", jSONObject);
        sCountryDataAfterLogin = jSONObject;
    }

    public static void setCountryCodeForUnity(String str) {
        sCountryCode = str;
    }
}
