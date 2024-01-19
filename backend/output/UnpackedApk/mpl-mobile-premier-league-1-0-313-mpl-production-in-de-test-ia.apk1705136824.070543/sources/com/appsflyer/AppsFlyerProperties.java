package com.appsflyer;

import android.content.Context;
import android.content.SharedPreferences;
import com.appsflyer.AFLogger.LogLevel;
import com.appsflyer.internal.ac;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class AppsFlyerProperties {
    public static final String ADDITIONAL_CUSTOM_DATA = "additionalCustomData";
    public static final AppsFlyerProperties AFInAppEventType = new AppsFlyerProperties();
    public static final String AF_WAITFOR_CUSTOMERID = "waitForCustomerId";
    public static final String APP_ID = "appid";
    public static final String APP_USER_ID = "AppUserId";
    public static final String CHANNEL = "channel";
    public static final String COLLECT_ANDROID_ID = "collectAndroidId";
    public static final String COLLECT_ANDROID_ID_FORCE_BY_USER = "collectAndroidIdForceByUser";
    public static final String COLLECT_FACEBOOK_ATTR_ID = "collectFacebookAttrId";
    public static final String COLLECT_IMEI = "collectIMEI";
    public static final String COLLECT_IMEI_FORCE_BY_USER = "collectIMEIForceByUser";
    public static final String COLLECT_OAID = "collectOAID";
    public static final String CURRENCY_CODE = "currencyCode";
    public static final String DEVICE_TRACKING_DISABLED = "deviceTrackingDisabled";
    public static final String DISABLE_KEYSTORE = "keyPropDisableAFKeystore";
    public static final String DISABLE_LOGS_COMPLETELY = "disableLogs";
    public static final String DISABLE_OTHER_SDK = "disableOtherSdk";
    public static final String DPM = "disableProxy";
    public static final String EMAIL_CRYPT_TYPE = "userEmailsCryptType";
    public static final String ENABLE_GPS_FALLBACK = "enableGpsFallback";
    public static final String EXTENSION = "sdkExtension";
    public static final String HTTP_CACHE = "http_cache";
    public static final String IS_UPDATE = "IS_UPDATE";
    public static final String LAUNCH_PROTECT_ENABLED = "launchProtectEnabled";
    public static final String NEW_REFERRER_SENT = "newGPReferrerSent";
    public static final String ONELINK_DOMAIN = "onelinkDomain";
    public static final String ONELINK_ID = "oneLinkSlug";
    public static final String ONELINK_SCHEME = "onelinkScheme";
    public static final String USER_EMAIL = "userEmail";
    public static final String USER_EMAILS = "userEmails";
    public static final String USE_HTTP_FALLBACK = "useHttpFallback";
    public boolean AFInAppEventParameterName;
    public String AFKeystoreWrapper;
    public boolean AFLogger$LogLevel = false;
    public String valueOf;
    public final Map<String, Object> values = new HashMap();

    public enum EmailsCryptType {
        NONE(0),
        SHA256(3);
        
        public final int AFInAppEventType;

        /* access modifiers changed from: public */
        EmailsCryptType(int i) {
            this.AFInAppEventType = i;
        }

        public final int getValue() {
            return this.AFInAppEventType;
        }
    }

    public static AppsFlyerProperties getInstance() {
        return AFInAppEventType;
    }

    private boolean valueOf() {
        return this.AFLogger$LogLevel;
    }

    public boolean getBoolean(String str, boolean z) {
        String string = getString(str);
        if (string == null) {
            return z;
        }
        return Boolean.parseBoolean(string);
    }

    public String getDevKey() {
        return this.AFKeystoreWrapper;
    }

    public int getInt(String str, int i) {
        String string = getString(str);
        if (string == null) {
            return i;
        }
        return Integer.parseInt(string);
    }

    public long getLong(String str, long j) {
        String string = getString(str);
        if (string == null) {
            return j;
        }
        return Long.parseLong(string);
    }

    public synchronized Object getObject(String str) {
        return this.values.get(str);
    }

    public String getReferrer(Context context) {
        String str = this.valueOf;
        if (str != null) {
            return str;
        }
        if (getString("AF_REFERRER") != null) {
            return getString("AF_REFERRER");
        }
        if (context == null) {
            return null;
        }
        return ac.AFInAppEventType(context).getString("referrer", null);
    }

    public synchronized String getString(String str) {
        try {
        }
        return (String) this.values.get(str);
    }

    public boolean isEnableLog() {
        return getInt("logLevel", LogLevel.NONE.getLevel()) > LogLevel.NONE.getLevel();
    }

    public boolean isLogsDisabledCompletely() {
        return getBoolean(DISABLE_LOGS_COMPLETELY, false);
    }

    public boolean isOtherSdkStringDisabled() {
        return getBoolean(DISABLE_OTHER_SDK, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0074, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void loadProperties(android.content.Context r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            boolean r0 = r5.valueOf()     // Catch:{ all -> 0x0075 }
            if (r0 == 0) goto L_0x0009
            monitor-exit(r5)
            return
        L_0x0009:
            android.content.SharedPreferences r6 = com.appsflyer.internal.ac.AFInAppEventType(r6)     // Catch:{ all -> 0x0075 }
            java.lang.String r0 = "savedProperties"
            r1 = 0
            java.lang.String r0 = r6.getString(r0, r1)     // Catch:{ all -> 0x0075 }
            if (r0 == 0) goto L_0x0073
            java.lang.String r1 = "Loading properties.."
            com.appsflyer.AFLogger.AFInAppEventParameterName(r1)     // Catch:{ all -> 0x0075 }
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x005a }
            r1.<init>(r0)     // Catch:{ JSONException -> 0x005a }
            java.util.Iterator r0 = r1.keys()     // Catch:{ JSONException -> 0x005a }
        L_0x0024:
            boolean r2 = r0.hasNext()     // Catch:{ JSONException -> 0x005a }
            if (r2 == 0) goto L_0x0042
            java.lang.Object r2 = r0.next()     // Catch:{ JSONException -> 0x005a }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ JSONException -> 0x005a }
            java.util.Map<java.lang.String, java.lang.Object> r3 = r5.values     // Catch:{ JSONException -> 0x005a }
            java.lang.Object r3 = r3.get(r2)     // Catch:{ JSONException -> 0x005a }
            if (r3 != 0) goto L_0x0024
            java.util.Map<java.lang.String, java.lang.Object> r3 = r5.values     // Catch:{ JSONException -> 0x005a }
            java.lang.String r4 = r1.getString(r2)     // Catch:{ JSONException -> 0x005a }
            r3.put(r2, r4)     // Catch:{ JSONException -> 0x005a }
            goto L_0x0024
        L_0x0042:
            java.util.Map<java.lang.String, java.lang.Object> r0 = r5.values     // Catch:{ JSONException -> 0x005a }
            java.lang.String r1 = "AppsFlyerKey"
            boolean r0 = r0.containsKey(r1)     // Catch:{ JSONException -> 0x005a }
            if (r0 == 0) goto L_0x0056
            java.util.Map<java.lang.String, java.lang.Object> r0 = r5.values     // Catch:{ JSONException -> 0x005a }
            java.lang.String r1 = "AppsFlyerKey"
            r0.remove(r1)     // Catch:{ JSONException -> 0x005a }
            r5.saveProperties(r6)     // Catch:{ JSONException -> 0x005a }
        L_0x0056:
            r6 = 1
            r5.AFLogger$LogLevel = r6     // Catch:{ JSONException -> 0x005a }
            goto L_0x0060
        L_0x005a:
            r6 = move-exception
            java.lang.String r0 = "Failed loading properties"
            com.appsflyer.AFLogger.valueOf(r0, r6)     // Catch:{ all -> 0x0075 }
        L_0x0060:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0075 }
            java.lang.String r0 = "Done loading properties: "
            r6.<init>(r0)     // Catch:{ all -> 0x0075 }
            boolean r0 = r5.AFLogger$LogLevel     // Catch:{ all -> 0x0075 }
            r6.append(r0)     // Catch:{ all -> 0x0075 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0075 }
            com.appsflyer.AFLogger.AFInAppEventParameterName(r6)     // Catch:{ all -> 0x0075 }
        L_0x0073:
            monitor-exit(r5)
            return
        L_0x0075:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.AppsFlyerProperties.loadProperties(android.content.Context):void");
    }

    public synchronized void remove(String str) {
        this.values.remove(str);
    }

    public synchronized void saveProperties(SharedPreferences sharedPreferences) {
        this.values.remove("AppsFlyerKey");
        sharedPreferences.edit().putString("savedProperties", new JSONObject(this.values).toString()).apply();
    }

    public synchronized void set(String str, String str2) {
        this.values.put(str, str2);
    }

    public synchronized void setCustomData(String str) {
        this.values.put(ADDITIONAL_CUSTOM_DATA, str);
    }

    public void setDevKey(String str) {
        this.AFKeystoreWrapper = str;
    }

    public synchronized void setUserEmails(String str) {
        this.values.put(USER_EMAILS, str);
    }

    public final boolean values() {
        return this.AFInAppEventParameterName;
    }

    public synchronized void set(String str, String[] strArr) {
        this.values.put(str, strArr);
    }

    public synchronized void set(String str, int i) {
        this.values.put(str, Integer.toString(i));
    }

    public synchronized void set(String str, long j) {
        this.values.put(str, Long.toString(j));
    }

    public synchronized void set(String str, boolean z) {
        this.values.put(str, Boolean.toString(z));
    }
}
