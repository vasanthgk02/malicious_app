package com.clevertap.android.sdk;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;

public class ManifestInfo {
    public static String accountId;
    public static String accountRegion;
    public static String accountToken;
    public static boolean appLaunchedDisabled;
    public static boolean backgroundSync;
    public static boolean beta;
    public static String excludedActivitiesForInApps;
    public static String fcmSenderId;
    public static ManifestInfo instance;
    public static String intentServiceName;
    public static String notificationIcon;
    public static String packageName;
    public static boolean sslPinning;
    public static boolean useADID;
    public static boolean useCustomID;
    public static String xiaomiAppID;
    public static String xiaomiAppKey;
    public final String[] profileKeys;

    public ManifestInfo(Context context) {
        Bundle bundle;
        String[] strArr;
        try {
            bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
        } catch (Throwable unused) {
            bundle = null;
        }
        bundle = bundle == null ? new Bundle() : bundle;
        if (accountId == null) {
            accountId = _getManifestStringValueForKey(bundle, "CLEVERTAP_ACCOUNT_ID");
        }
        if (accountToken == null) {
            accountToken = _getManifestStringValueForKey(bundle, "CLEVERTAP_TOKEN");
        }
        if (accountRegion == null) {
            accountRegion = _getManifestStringValueForKey(bundle, "CLEVERTAP_REGION");
        }
        notificationIcon = _getManifestStringValueForKey(bundle, "CLEVERTAP_NOTIFICATION_ICON");
        useADID = "1".equals(_getManifestStringValueForKey(bundle, "CLEVERTAP_USE_GOOGLE_AD_ID"));
        appLaunchedDisabled = "1".equals(_getManifestStringValueForKey(bundle, "CLEVERTAP_DISABLE_APP_LAUNCHED"));
        excludedActivitiesForInApps = _getManifestStringValueForKey(bundle, "CLEVERTAP_INAPP_EXCLUDE");
        sslPinning = "1".equals(_getManifestStringValueForKey(bundle, "CLEVERTAP_SSL_PINNING"));
        backgroundSync = "1".equals(_getManifestStringValueForKey(bundle, "CLEVERTAP_BACKGROUND_SYNC"));
        useCustomID = "1".equals(_getManifestStringValueForKey(bundle, "CLEVERTAP_USE_CUSTOM_ID"));
        String _getManifestStringValueForKey = _getManifestStringValueForKey(bundle, "FCM_SENDER_ID");
        fcmSenderId = _getManifestStringValueForKey;
        if (_getManifestStringValueForKey != null) {
            fcmSenderId = _getManifestStringValueForKey.replace("id:", "");
        }
        packageName = _getManifestStringValueForKey(bundle, "CLEVERTAP_APP_PACKAGE");
        beta = "1".equals(_getManifestStringValueForKey(bundle, "CLEVERTAP_BETA"));
        if (intentServiceName == null) {
            intentServiceName = _getManifestStringValueForKey(bundle, "CLEVERTAP_INTENT_SERVICE");
        }
        if (xiaomiAppKey == null) {
            xiaomiAppKey = _getManifestStringValueForKey(bundle, "CLEVERTAP_XIAOMI_APP_KEY");
        }
        if (xiaomiAppID == null) {
            xiaomiAppID = _getManifestStringValueForKey(bundle, "CLEVERTAP_XIAOMI_APP_ID");
        }
        String _getManifestStringValueForKey2 = _getManifestStringValueForKey(bundle, "CLEVERTAP_IDENTIFIER");
        if (!TextUtils.isEmpty(_getManifestStringValueForKey2)) {
            strArr = _getManifestStringValueForKey2.split(",");
        } else {
            strArr = Constants.NULL_STRING_ARRAY;
        }
        this.profileKeys = strArr;
    }

    public static String _getManifestStringValueForKey(Bundle bundle, String str) {
        try {
            Object obj = bundle.get(str);
            if (obj != null) {
                return obj.toString();
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static synchronized ManifestInfo getInstance(Context context) {
        ManifestInfo manifestInfo;
        synchronized (ManifestInfo.class) {
            try {
                if (instance == null) {
                    instance = new ManifestInfo(context);
                }
                manifestInfo = instance;
            }
        }
        return manifestInfo;
    }

    public String getAccountRegion() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("ManifestInfo: getAccountRegion called, returning region:");
        outline73.append(accountRegion);
        Logger.v(outline73.toString());
        return accountRegion;
    }
}
