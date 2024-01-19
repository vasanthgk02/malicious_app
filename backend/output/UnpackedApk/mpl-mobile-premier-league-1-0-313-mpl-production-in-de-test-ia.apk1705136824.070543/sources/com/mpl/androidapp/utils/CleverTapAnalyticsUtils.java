package com.mpl.androidapp.utils;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.appsflyer.AFInAppEventParameterName;
import com.appsflyer.AFInAppEventType;
import com.appsflyer.AppsFlyerLib;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mpl.androidapp.MPLApplication;
import com.mpl.androidapp.MPLLibInitContentProvider;
import com.mpl.androidapp.analytics.ExternalAnalytics;
import com.mpl.androidapp.cleverTap.MplCtEventConstants.CtNativeLaunchInitiated;
import com.mpl.androidapp.config.ConfigManager;
import com.mpl.androidapp.config.UpdaterAnalytics;
import com.mpl.androidapp.database.entity.Contact;
import com.mpl.androidapp.miniprofile.ct.C.PlaybackWatched;
import com.mpl.androidapp.miniprofile.ct.C.ProfileFollowed;
import com.mpl.androidapp.updater.interactor.DBInteractor;
import com.mpl.androidapp.utils.Constant.ApiEndPoints;
import com.mpl.androidapp.utils.Constant.EventsConstants;
import com.mpl.androidapp.utils.Constant.HanselEventConstant;
import com.mpl.network.modules.listeners.IResponseListener;
import io.hansel.actions.configs.HanselConfigs;
import io.hansel.hanselsdk.Hansel;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TimeZone;
import org.apache.fontbox.cmap.CMap;
import org.apache.pdfbox.pdfparser.BaseParser;
import org.json.JSONException;
import org.json.JSONObject;

public class CleverTapAnalyticsUtils {
    public static int FlagAll = 1;
    public static int FlagFantasy = 1;
    public static int FlagGames = 1;
    public static final String TAG = "CleverTapAnalyticsUtils";
    public static HashSet<String> removedEvents;

    @Deprecated
    public static void addKafkaEvent(String str, HashMap<String, Object> hashMap) {
        if (!hashMap.containsKey("Is New User")) {
            hashMap.put("Is New User", Boolean.valueOf(MSharedPreferencesUtils.isNewUser()));
        }
        hashMap.put("First Session", MSharedPreferencesUtils.getStringInNormalPref(MPLApplication.getInstance(), Constant.IS_FIRST_LAUNCH_INSTRUMENTAION, BaseParser.TRUE));
        ExternalAnalytics.INSTANCE.sendKafkaEvent(str, hashMap);
    }

    public static void addNetworkCarrierInEvents(HashMap<String, Object> hashMap) {
        String[] split = MSharedPreferencesUtils.getNetworkProviders(MPLApplication.getInstance()).split(",");
        for (int i = 0; i < split.length; i++) {
            if (!TextUtils.isEmpty(split[i])) {
                hashMap.put(GeneratedOutlineSupport.outline41("MPL Network Carrier ", i + 1), split[i]);
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(13:1|2|(1:4)(1:5)|6|(1:11)(1:10)|12|(1:14)|15|16|(1:18)|19|20|21) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0287 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.HashMap<java.lang.String, java.lang.Object> commonPropertiesForEvents(boolean r12) {
        /*
            java.lang.String r0 = "CURRENT_CODEPUSH_VERSION_LABEL"
            java.lang.String r1 = "priority.segment.id"
            java.lang.String r2 = "Country Code"
            java.lang.String r3 = "advertising_id"
            java.lang.String r4 = ""
            r5 = 2
            java.lang.Object[] r6 = new java.lang.Object[r5]
            java.lang.String r7 = "commonPropertiesForEvents:isTriggeredFromGame"
            r8 = 0
            r6[r8] = r7
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r12)
            r9 = 1
            r6[r9] = r7
            java.lang.String r7 = "CleverTapAnalyticsUtils"
            com.mpl.androidapp.utils.MLogger.d(r7, r6)
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>()
            java.lang.String r10 = "App Version Code"
            int r11 = com.mpl.androidapp.utils.MBuildConfigUtils.getInstalledAppVersionCode()     // Catch:{ Exception -> 0x0291 }
            java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch:{ Exception -> 0x0291 }
            r6.put(r10, r11)     // Catch:{ Exception -> 0x0291 }
            java.lang.String r10 = "App Version Name"
            java.lang.String r11 = com.mpl.androidapp.utils.MBuildConfigUtils.getCurrentAppVersionName()     // Catch:{ Exception -> 0x0291 }
            java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch:{ Exception -> 0x0291 }
            r6.put(r10, r11)     // Catch:{ Exception -> 0x0291 }
            java.lang.String r10 = "App Version Code Gradle"
            int r11 = com.mpl.androidapp.utils.MBuildConfigUtils.getInstalledAppVersionCodeGradle()     // Catch:{ Exception -> 0x0291 }
            java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch:{ Exception -> 0x0291 }
            r6.put(r10, r11)     // Catch:{ Exception -> 0x0291 }
            java.lang.String r10 = "App Version Name Gradle"
            java.lang.String r11 = com.mpl.androidapp.utils.MBuildConfigUtils.getInstalledAppVersionNameGradle()     // Catch:{ Exception -> 0x0291 }
            java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch:{ Exception -> 0x0291 }
            r6.put(r10, r11)     // Catch:{ Exception -> 0x0291 }
            com.mpl.androidapp.MPLApplication r10 = com.mpl.androidapp.MPLApplication.getInstance()     // Catch:{ Exception -> 0x0291 }
            r11 = 0
            java.lang.String r10 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getStringInNormalPref(r10, r3, r11)     // Catch:{ Exception -> 0x0291 }
            r6.put(r3, r10)     // Catch:{ Exception -> 0x0291 }
            java.lang.String r3 = "Apk Type"
            java.lang.String r10 = com.mpl.androidapp.utils.MBuildConfigUtils.getApkType()     // Catch:{ Exception -> 0x0291 }
            r6.put(r3, r10)     // Catch:{ Exception -> 0x0291 }
            java.lang.String r3 = "App Type"
            java.lang.String r10 = com.mpl.androidapp.utils.MBuildConfigUtils.getAppType()     // Catch:{ Exception -> 0x0291 }
            r6.put(r3, r10)     // Catch:{ Exception -> 0x0291 }
            java.lang.String r3 = "Last Logged In App"
            java.lang.String r10 = com.mpl.androidapp.utils.MBuildConfigUtils.getAppType()     // Catch:{ Exception -> 0x0291 }
            r6.put(r3, r10)     // Catch:{ Exception -> 0x0291 }
            java.lang.String r3 = "MPL Build Number"
            int r10 = com.mpl.androidapp.utils.MBuildConfigUtils.getBuildNumber()     // Catch:{ Exception -> 0x0291 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ Exception -> 0x0291 }
            r6.put(r3, r10)     // Catch:{ Exception -> 0x0291 }
            boolean r3 = com.mpl.androidapp.utils.MBuildConfigUtils.isCashApp()     // Catch:{ Exception -> 0x0291 }
            if (r3 == 0) goto L_0x0099
            java.lang.String r3 = "Is Cash App"
            java.lang.Boolean r10 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x0291 }
            r6.put(r3, r10)     // Catch:{ Exception -> 0x0291 }
            goto L_0x00a0
        L_0x0099:
            java.lang.String r3 = "Is Non Cash App"
            java.lang.Boolean r10 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x0291 }
            r6.put(r3, r10)     // Catch:{ Exception -> 0x0291 }
        L_0x00a0:
            java.lang.String r3 = com.mpl.androidapp.utils.MBuildConfigUtils.getCountryCode()     // Catch:{ Exception -> 0x0291 }
            java.lang.String r3 = r3.toUpperCase()     // Catch:{ Exception -> 0x0291 }
            r6.put(r2, r3)     // Catch:{ Exception -> 0x0291 }
            java.lang.String r3 = "Phone Model"
            java.lang.String r10 = android.os.Build.MODEL     // Catch:{ Exception -> 0x0291 }
            r6.put(r3, r10)     // Catch:{ Exception -> 0x0291 }
            java.lang.String r3 = "Phone Make"
            java.lang.String r10 = android.os.Build.BRAND     // Catch:{ Exception -> 0x0291 }
            r6.put(r3, r10)     // Catch:{ Exception -> 0x0291 }
            java.lang.String r3 = "OS Version"
            int r10 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0291 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ Exception -> 0x0291 }
            r6.put(r3, r10)     // Catch:{ Exception -> 0x0291 }
            java.lang.String r3 = "Phone Manufacturer"
            java.lang.String r10 = android.os.Build.MANUFACTURER     // Catch:{ Exception -> 0x0291 }
            r6.put(r3, r10)     // Catch:{ Exception -> 0x0291 }
            java.lang.String r3 = "Device Fingerprint"
            java.lang.String r10 = android.os.Build.FINGERPRINT     // Catch:{ Exception -> 0x0291 }
            r6.put(r3, r10)     // Catch:{ Exception -> 0x0291 }
            java.lang.String r3 = "Device Build Type"
            java.lang.String r10 = android.os.Build.TYPE     // Catch:{ Exception -> 0x0291 }
            r6.put(r3, r10)     // Catch:{ Exception -> 0x0291 }
            java.lang.String r3 = "Display"
            java.lang.String r10 = android.os.Build.DISPLAY     // Catch:{ Exception -> 0x0291 }
            r6.put(r3, r10)     // Catch:{ Exception -> 0x0291 }
            java.lang.String r3 = "Device Architecture"
            java.lang.String r10 = com.mpl.androidapp.utils.CommonUtils.getDeviceArch()     // Catch:{ Exception -> 0x0291 }
            r6.put(r3, r10)     // Catch:{ Exception -> 0x0291 }
            java.lang.String r3 = "Is iOS App"
            java.lang.Boolean r10 = java.lang.Boolean.FALSE     // Catch:{ Exception -> 0x0291 }
            r6.put(r3, r10)     // Catch:{ Exception -> 0x0291 }
            java.lang.String r3 = "CleverTap Id"
            com.mpl.analytics.MPLAnalytics r10 = com.mpl.androidapp.MPLApplication.getMplAnalytics()     // Catch:{ Exception -> 0x0291 }
            java.lang.String r10 = r10.getCleverTapId()     // Catch:{ Exception -> 0x0291 }
            r6.put(r3, r10)     // Catch:{ Exception -> 0x0291 }
            org.json.JSONObject r3 = com.mpl.androidapp.config.ConfigManager.getNormalConfig()     // Catch:{ Exception -> 0x0291 }
            if (r3 == 0) goto L_0x011b
            org.json.JSONObject r3 = com.mpl.androidapp.config.ConfigManager.getNormalConfig()     // Catch:{ Exception -> 0x0291 }
            boolean r3 = r3.has(r1)     // Catch:{ Exception -> 0x0291 }
            if (r3 == 0) goto L_0x011b
            java.lang.String r3 = "Segment Id"
            org.json.JSONObject r10 = com.mpl.androidapp.config.ConfigManager.getNormalConfig()     // Catch:{ Exception -> 0x0291 }
            java.lang.String r1 = r10.optString(r1)     // Catch:{ Exception -> 0x0291 }
            r6.put(r3, r1)     // Catch:{ Exception -> 0x0291 }
            goto L_0x0124
        L_0x011b:
            java.lang.Object[] r1 = new java.lang.Object[r9]     // Catch:{ Exception -> 0x0291 }
            java.lang.String r3 = "commonPropertiesForEvents: Segment id not present"
            r1[r8] = r3     // Catch:{ Exception -> 0x0291 }
            com.mpl.androidapp.utils.MLogger.d(r7, r1)     // Catch:{ Exception -> 0x0291 }
        L_0x0124:
            java.util.HashMap r1 = com.mpl.androidapp.utils.CommonUtils.getDeviceMemoryInfo()     // Catch:{ Exception -> 0x0291 }
            r6.putAll(r1)     // Catch:{ Exception -> 0x0291 }
            java.lang.String r1 = "Screen Size"
            com.mpl.androidapp.MPLApplication r3 = com.mpl.androidapp.MPLApplication.getInstance()     // Catch:{ Exception -> 0x0291 }
            java.lang.String r3 = com.mpl.androidapp.utils.CommonUtils.getScreenSize(r3)     // Catch:{ Exception -> 0x0291 }
            r6.put(r1, r3)     // Catch:{ Exception -> 0x0291 }
            java.lang.String r1 = "Screen Density"
            com.mpl.androidapp.MPLApplication r3 = com.mpl.androidapp.MPLApplication.getInstance()     // Catch:{ Exception -> 0x0291 }
            java.lang.String r3 = com.mpl.androidapp.utils.WindowUtil.getScreenDensity(r3)     // Catch:{ Exception -> 0x0291 }
            r6.put(r1, r3)     // Catch:{ Exception -> 0x0291 }
            java.lang.String r1 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getStringPref(r0, r4, r8)     // Catch:{ Exception -> 0x0291 }
            boolean r1 = r1.isEmpty()     // Catch:{ Exception -> 0x0291 }
            if (r1 != 0) goto L_0x0158
            java.lang.String r1 = "Codepush_Version"
            java.lang.String r0 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getStringPref(r0, r4, r8)     // Catch:{ Exception -> 0x0291 }
            r6.put(r1, r0)     // Catch:{ Exception -> 0x0291 }
        L_0x0158:
            java.lang.String r0 = com.mpl.androidapp.utils.MBuildConfigUtils.getCountryCode()     // Catch:{ Exception -> 0x0287 }
            java.lang.String r0 = r0.toUpperCase()     // Catch:{ Exception -> 0x0287 }
            r6.put(r2, r0)     // Catch:{ Exception -> 0x0287 }
            java.lang.String r0 = "React Version"
            int r1 = com.mpl.androidapp.updater.interactor.DBInteractor.getCurrentRNBundleVersionCode()     // Catch:{ Exception -> 0x0287 }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ Exception -> 0x0287 }
            r6.put(r0, r1)     // Catch:{ Exception -> 0x0287 }
            java.lang.String r0 = "Is Phone Rooted"
            boolean r1 = com.mpl.androidapp.utils.MSharedPreferencesUtils.isPhoneRooted()     // Catch:{ Exception -> 0x0287 }
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch:{ Exception -> 0x0287 }
            r6.put(r0, r1)     // Catch:{ Exception -> 0x0287 }
            java.lang.String r0 = "Profile Tier"
            java.lang.String r1 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getUserTier()     // Catch:{ Exception -> 0x0287 }
            r6.put(r0, r1)     // Catch:{ Exception -> 0x0287 }
            java.lang.String r0 = "Is Emulator"
            boolean r1 = com.mpl.androidapp.utils.MSharedPreferencesUtils.isEmulator()     // Catch:{ Exception -> 0x0287 }
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch:{ Exception -> 0x0287 }
            r6.put(r0, r1)     // Catch:{ Exception -> 0x0287 }
            java.lang.String r0 = "User ID"
            com.mpl.androidapp.MPLApplication r1 = com.mpl.androidapp.MPLApplication.getInstance()     // Catch:{ Exception -> 0x0287 }
            int r1 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getUserIdInNormalPref(r1)     // Catch:{ Exception -> 0x0287 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception -> 0x0287 }
            r6.put(r0, r1)     // Catch:{ Exception -> 0x0287 }
            java.lang.String r0 = "MPL User ID"
            com.mpl.androidapp.MPLApplication r1 = com.mpl.androidapp.MPLApplication.getInstance()     // Catch:{ Exception -> 0x0287 }
            int r1 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getUserIdInNormalPref(r1)     // Catch:{ Exception -> 0x0287 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception -> 0x0287 }
            r6.put(r0, r1)     // Catch:{ Exception -> 0x0287 }
            com.mpl.androidapp.MPLApplication r0 = com.mpl.androidapp.MPLApplication.getInstance()     // Catch:{ Exception -> 0x0287 }
            java.lang.String r1 = "random_session_string"
            java.lang.String r0 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getStringInNormalPref(r0, r1, r4)     // Catch:{ Exception -> 0x0287 }
            java.lang.String r1 = "App Session ID"
            r6.put(r1, r0)     // Catch:{ Exception -> 0x0287 }
            java.lang.Object[] r1 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x0287 }
            java.lang.String r2 = "commonPropertiesForEvents:1 "
            r1[r8] = r2     // Catch:{ Exception -> 0x0287 }
            r1[r9] = r0     // Catch:{ Exception -> 0x0287 }
            com.mpl.androidapp.utils.MLogger.d(r7, r1)     // Catch:{ Exception -> 0x0287 }
            java.lang.String r0 = "App Launch TS"
            com.mpl.androidapp.MPLApplication r1 = com.mpl.androidapp.MPLApplication.getInstance()     // Catch:{ Exception -> 0x0287 }
            java.lang.String r2 = "app_launch_loading_time"
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0287 }
            long r1 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getLongInNormalPref(r1, r2, r3)     // Catch:{ Exception -> 0x0287 }
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch:{ Exception -> 0x0287 }
            r6.put(r0, r1)     // Catch:{ Exception -> 0x0287 }
            java.lang.String r0 = "Device ID"
            java.lang.String r1 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getDeviceId()     // Catch:{ Exception -> 0x0287 }
            r6.put(r0, r1)     // Catch:{ Exception -> 0x0287 }
            java.lang.String r0 = "Device Name"
            java.lang.String r1 = com.mpl.androidapp.utils.CommonUtils.captureDeviceName()     // Catch:{ Exception -> 0x0287 }
            r6.put(r0, r1)     // Catch:{ Exception -> 0x0287 }
            java.lang.String r0 = "Unique Event Id"
            java.util.UUID r1 = java.util.UUID.randomUUID()     // Catch:{ Exception -> 0x0287 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0287 }
            r6.put(r0, r1)     // Catch:{ Exception -> 0x0287 }
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x0287 }
            java.lang.String r1 = "yyyy-MM-dd HH:mm:ss.SSS"
            r0.<init>(r1)     // Catch:{ Exception -> 0x0287 }
            java.util.Date r1 = com.mpl.androidapp.utils.Util.getCurrentTime()     // Catch:{ Exception -> 0x0287 }
            java.lang.String r2 = "Sending Event Time Stamp"
            long r3 = r1.getTime()     // Catch:{ Exception -> 0x0287 }
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ Exception -> 0x0287 }
            r6.put(r2, r3)     // Catch:{ Exception -> 0x0287 }
            java.lang.String r2 = "Sending Event Formatted Time"
            java.lang.String r0 = r0.format(r1)     // Catch:{ Exception -> 0x0287 }
            r6.put(r2, r0)     // Catch:{ Exception -> 0x0287 }
            java.lang.String r0 = "Network Type"
            com.mpl.androidapp.MPLApplication r1 = com.mpl.androidapp.MPLApplication.getInstance()     // Catch:{ Exception -> 0x0287 }
            java.lang.String r1 = com.mpl.androidapp.utils.NetworkUtils.getNetworkClass(r1)     // Catch:{ Exception -> 0x0287 }
            r6.put(r0, r1)     // Catch:{ Exception -> 0x0287 }
            java.lang.String r0 = com.mpl.androidapp.utils.CountryUtils.getUniqueIdForThirdPartySDKs()     // Catch:{ Exception -> 0x0287 }
            java.lang.String r1 = "Mobile Number"
            r6.put(r1, r0)     // Catch:{ Exception -> 0x0287 }
            java.lang.String r0 = "Language Selected"
            java.lang.String r1 = com.mpl.androidapp.utils.LocaleHelper.getSelectedLanguage()     // Catch:{ Exception -> 0x0287 }
            r6.put(r0, r1)     // Catch:{ Exception -> 0x0287 }
            java.lang.String r0 = "Native State"
            java.util.HashMap r1 = com.mpl.androidapp.utils.CommonUtils.getLocationMap()     // Catch:{ Exception -> 0x0287 }
            java.lang.String r2 = "state"
            java.lang.Object r1 = r1.get(r2)     // Catch:{ Exception -> 0x0287 }
            r6.put(r0, r1)     // Catch:{ Exception -> 0x0287 }
            java.lang.String r0 = "Native Country"
            java.util.HashMap r1 = com.mpl.androidapp.utils.CommonUtils.getLocationMap()     // Catch:{ Exception -> 0x0287 }
            java.lang.String r2 = "country"
            java.lang.Object r1 = r1.get(r2)     // Catch:{ Exception -> 0x0287 }
            r6.put(r0, r1)     // Catch:{ Exception -> 0x0287 }
            java.lang.String r0 = "Location Permission"
            java.lang.String r1 = com.mpl.androidapp.utils.CommonUtils.checkLocationPermissions()     // Catch:{ Exception -> 0x0287 }
            r6.put(r0, r1)     // Catch:{ Exception -> 0x0287 }
            if (r12 != 0) goto L_0x027b
            java.lang.String r12 = "Is Internal User"
            boolean r0 = com.mpl.androidapp.utils.CommonUtils.isInternalUser()     // Catch:{ Exception -> 0x0287 }
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch:{ Exception -> 0x0287 }
            r6.put(r12, r0)     // Catch:{ Exception -> 0x0287 }
        L_0x027b:
            java.lang.String r12 = "Wifi IP Address"
            java.lang.String r0 = com.mpl.androidapp.utils.CommonUtils.getIpAddress()     // Catch:{ Exception -> 0x0287 }
            r6.put(r12, r0)     // Catch:{ Exception -> 0x0287 }
            addNetworkCarrierInEvents(r6)     // Catch:{ Exception -> 0x0287 }
        L_0x0287:
            java.lang.Object[] r12 = new java.lang.Object[r9]     // Catch:{ Exception -> 0x0291 }
            java.lang.String r0 = "commonPropertiesForEvents:2 "
            r12[r8] = r0     // Catch:{ Exception -> 0x0291 }
            com.mpl.androidapp.utils.MLogger.d(r7, r12)     // Catch:{ Exception -> 0x0291 }
            goto L_0x029d
        L_0x0291:
            r12 = move-exception
            java.lang.Object[] r0 = new java.lang.Object[r5]
            java.lang.String r1 = "commonPropertiesForEvents:3 "
            r0[r8] = r1
            r0[r9] = r12
            com.mpl.androidapp.utils.MLogger.e(r7, r0)
        L_0x029d:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.utils.CleverTapAnalyticsUtils.commonPropertiesForEvents(boolean):java.util.HashMap");
    }

    public static HashMap<String, Object> commonPropertiesForFireBaseEvents() {
        HashMap<String, Object> hashMap = new HashMap<>();
        try {
            hashMap.put(EventsConstants.APP_VERSION_CODE, String.valueOf(MBuildConfigUtils.getInstalledAppVersionCode()));
            hashMap.put(EventsConstants.APP_VERSION_NAME, String.valueOf(MBuildConfigUtils.getCurrentAppVersionName()));
            hashMap.put(EventsConstants.PROP_APK_TYPE, MBuildConfigUtils.getApkType());
            hashMap.put(EventsConstants.ANDROID_APP_TYPE, MBuildConfigUtils.getAppType());
            if (MBuildConfigUtils.isCashApp()) {
                hashMap.put(EventsConstants.IS_CASH_APP, Boolean.TRUE);
            } else {
                hashMap.put(EventsConstants.IS_NON_CASH_APP, Boolean.TRUE);
            }
            hashMap.put(EventsConstants.USER_CLEVERTAP_ID, MPLApplication.getMplAnalytics().getCleverTapId());
            hashMap.put(EventsConstants.REACT_VERSION, String.valueOf(DBInteractor.getCurrentRNBundleVersionCode()));
            hashMap.put("User ID", Integer.valueOf(MSharedPreferencesUtils.getUserIdInNormalPref(MPLApplication.getInstance())));
            hashMap.put("MPL User ID", Integer.valueOf(MSharedPreferencesUtils.getUserIdInNormalPref(MPLApplication.getInstance())));
            MLogger.d(TAG, "commonPropertiesForFireBaseEvents:2 ");
        } catch (Exception e2) {
            MLogger.e(TAG, "commonPropertiesForFireBaseEvents:3 ", e2);
        }
        return hashMap;
    }

    public static JSONObject getAllHanselConfigData(HashMap<String, String> hashMap) {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Entry next : hashMap.entrySet()) {
                String str = (String) next.getKey();
                String str2 = (String) next.getValue();
                if (HanselEventConstant.DATA_TYPE_STRING.equals(str2)) {
                    jSONObject.put(str, HanselConfigs.getString(str, ""));
                } else if (HanselEventConstant.DATA_TYPE_BOOLEAN.equals(str2)) {
                    if (!"challenge_enabled".equalsIgnoreCase(str) && ((!"rewardbot_enabled".equalsIgnoreCase(str) || MBuildConfigUtils.isCashApp()) && !"is_ml_enabled".equalsIgnoreCase(str))) {
                        if (!"show_payment_popup".equalsIgnoreCase(str)) {
                            jSONObject.put(str, HanselConfigs.getBoolean(str, false));
                        }
                    }
                    jSONObject.put(str, HanselConfigs.getBoolean(str, true));
                } else if (HanselEventConstant.DATA_TYPE_INTEGER.equals(str2)) {
                    jSONObject.put(str, HanselConfigs.getInteger(str, "home_format_layout".equalsIgnoreCase(str) ? 4 : isDeActiveKeyOnHansel(str) ? 1 : 0));
                } else if ("Double".equals(str2)) {
                    jSONObject.put(str, HanselConfigs.getDouble(str, 0.0d));
                } else if (HanselEventConstant.DATA_TYPE_JSON.equals(str2)) {
                    jSONObject.put(str, HanselConfigs.getJSONObject(str, new JSONObject()));
                }
            }
        } catch (JSONException e2) {
            MLogger.e("Hansel", "getAllHanselConfigData: ", e2);
        }
        MLogger.d("Hansel", "getAllHanselConfigData: ", jSONObject.toString());
        return jSONObject;
    }

    public static HashSet<String> getRemovedEvents() {
        return removedEvents;
    }

    public static HashMap<String, Object> getTimeZoneParams() {
        TimeZone timeZone = TimeZone.getDefault();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("Timezone Id", timeZone.getID());
        hashMap.put("Timezone Abbreviation", timeZone.getDisplayName(false, 0));
        return hashMap;
    }

    public static boolean isAppsFlyerEvent(String str, HashMap<String, Object> hashMap) {
        boolean z = false;
        if (!EventsConstants.EVENT_APP_SCREEN_VIEWED.equalsIgnoreCase(str) || hashMap == null) {
            if (!EventsConstants.POP_UP_SHOWN.equalsIgnoreCase(str) || hashMap == null) {
                if (EventsConstants.EVENT_LOGIN_IN_SUCCESS.equalsIgnoreCase(str) || "Game Changed".equalsIgnoreCase(str) || "Battle Room Selected".equalsIgnoreCase(str) || "Registration Initiated".equalsIgnoreCase(str) || "Share Initiated".equalsIgnoreCase(str) || "Tournament Selected".equalsIgnoreCase(str) || "Add Money Initiated".equalsIgnoreCase(str) || "Web App Started".equalsIgnoreCase(str) || "Story Viewed".equalsIgnoreCase(str) || "Story Posted".equalsIgnoreCase(str) || "Story Action Taken".equalsIgnoreCase(str) || ProfileFollowed.EVENT_NAME.equalsIgnoreCase(str) || EventsConstants.EVENT_GAME_PLAY_INITIATED.equalsIgnoreCase(str) || EventsConstants.MONEY_IN_EVENT.equalsIgnoreCase(str) || EventsConstants.RANKED_FETCHED.equalsIgnoreCase(str) || EventsConstants.MONEY_OUT_EVENT.equalsIgnoreCase(str) || EventsConstants.USER_TOURNAMENT_REGISTRATION_SUCCESS.equalsIgnoreCase(str) || EventsConstants.EVENT_ROUND_STARTED.equalsIgnoreCase(str) || EventsConstants.EVENT_BUY_IN_SUCCESS.equalsIgnoreCase(str) || EventsConstants.USER_BATTLE_STARTED.equalsIgnoreCase(str) || EventsConstants.USER_BATTLE_ENDED.equalsIgnoreCase(str) || EventsConstants.USER_BATTLE_REGISTRATION_SUCCESS.equalsIgnoreCase(str) || EventsConstants.USER_TEAM_REGISTRATION_SUCCESS.equalsIgnoreCase(str) || GameConstant.EVENT_GAME_STARTED.equalsIgnoreCase(str)) {
                    z = true;
                }
                return z;
            } else if (hashMap.containsKey(EventsConstants.POP_UP_NAME)) {
                return "important_terms".equalsIgnoreCase((String) hashMap.get(EventsConstants.POP_UP_NAME));
            }
        } else if (hashMap.containsKey("Screen Name")) {
            return "Login".equalsIgnoreCase((String) hashMap.get("Screen Name"));
        }
        return false;
    }

    public static boolean isBranchEvents(String str) {
        return EventsConstants.USER_PLAYED_GAME.equalsIgnoreCase(str) || EventsConstants.USER_LOGGED_ID.equalsIgnoreCase(str) || EventsConstants.MONEY_IN_EVENT.equalsIgnoreCase(str) || EventsConstants.MONEY_OUT_EVENT.equalsIgnoreCase(str) || EventsConstants.USER_TOURNAMENT_REGISTRATION_SUCCESS.equalsIgnoreCase(str) || "Share Initiated".equalsIgnoreCase(str) || EventsConstants.RANKED_FETCHED.equalsIgnoreCase(str);
    }

    public static boolean isDeActiveKeyOnHansel(String str) {
        return str.equalsIgnoreCase("home_game_layout") || str.equalsIgnoreCase("home_game_order") || str.equalsIgnoreCase("game_show_pool");
    }

    public static boolean isFacebookEvents(String str) {
        return GameConstant.EVENT_GAME_STARTED.equalsIgnoreCase(str) || EventsConstants.USER_BATTLE_STARTED.equalsIgnoreCase(str) || EventsConstants.USER_TEAM_REGISTRATION_SUCCESS.equalsIgnoreCase(str) || EventsConstants.USER_TOURNAMENT_REGISTRATION_SUCCESS.equalsIgnoreCase(str) || "App Launched".equalsIgnoreCase(str) || EventsConstants.MONEY_OUT_EVENT.equalsIgnoreCase(str) || EventsConstants.MONEY_IN_EVENT.equalsIgnoreCase(str);
    }

    public static boolean isGMVEvent(String str) {
        return str.equalsIgnoreCase(EventsConstants.USER_TOURNAMENT_REGISTRATION_SUCCESS) || str.equalsIgnoreCase(EventsConstants.USER_BATTLE_STARTED) || str.equalsIgnoreCase(EventsConstants.USER_TEAM_REGISTRATION_SUCCESS) || str.equalsIgnoreCase("Rummy Registration Success") || str.equalsIgnoreCase("Auction Played") || str.equalsIgnoreCase("Show Gift Sent") || str.equalsIgnoreCase("Round Ended") || str.equalsIgnoreCase("Gift Purchased");
    }

    public static boolean isRemoveMobileFromParamsEvent(String str) {
        return EventsConstants.EVENT_LOGIN_IN_SUCCESS.equalsIgnoreCase(str) || EventsConstants.USER_LOGGED_ID.equalsIgnoreCase(str) || Constant.ATTRIBUTION_DETECTED.equalsIgnoreCase(str);
    }

    public static boolean isRemovedEvents(String str) {
        if (!TextUtils.isEmpty(str) && !str.equalsIgnoreCase(PlaybackWatched.TRIGGER_MODE_APP_CLOSED) && !str.equalsIgnoreCase("Battle Creation Started") && !str.equalsIgnoreCase("Tournament Loaded") && !str.equalsIgnoreCase("Battle Exited") && !str.equalsIgnoreCase("Game Assets Downloaded") && !str.equalsIgnoreCase("Field Inputted") && !str.equalsIgnoreCase("Field Input Selected") && !str.equalsIgnoreCase("Failed To Grant Link Rewards") && !str.equalsIgnoreCase("Game Preview Viewed") && !str.equalsIgnoreCase("WebPage Viewed") && !str.equalsIgnoreCase("Web Download Link Clicked") && !str.equalsIgnoreCase("Friend List Refreshed") && !str.equalsIgnoreCase("Video Toggled") && !str.equalsIgnoreCase("Web Incoming Source") && !str.equalsIgnoreCase("Video Toggle Shown") && !str.equalsIgnoreCase("Video Deleted") && !str.equalsIgnoreCase(UpdaterAnalytics.REACT_UPDATE_DOWNLOADED) && !str.equalsIgnoreCase("App not Update Available") && !str.equalsIgnoreCase("Web Download SMS Requested") && !str.equalsIgnoreCase(EventsConstants.USER_BATTLE_REGISTRATION_SUCCESS)) {
            HashSet<String> hashSet = removedEvents;
            if (hashSet == null || !hashSet.contains(str)) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(72:5|(1:7)|(1:9)|10|(1:14)|15|16|(4:18|19|20|(2:28|(1:30)(26:31|84|85|(3:87|88|(4:90|(1:96)|97|(1:103)))|104|(1:108)|109|(1:127)|128|(1:134)|135|(1:137)|138|(1:140)|141|(1:143)|144|145|146|(1:148)|149|150|(2:152|(1:160))(1:161)|162|(9:166|(1:170)|171|(1:175)|176|(1:180)|181|(1:185)|186)|195)))|32|(1:34)|35|(2:37|(56:39|41|(1:45)|(1:49)|(1:53)|(3:55|(1:57)(1:58)|59)|60|61|(47:65|(2:67|(3:71|72|73))(1:74)|76|(1:80)|81|(1:83)|84|85|(0)|104|106|108|109|111|127|128|130|132|134|135|(0)|138|(0)|141|(0)|144|145|146|(0)|149|150|(0)(0)|162|166|168|170|171|173|175|176|178|180|181|183|185|186|195)|75|76|78|80|81|(0)|84|85|(0)|104|106|108|109|111|127|128|130|132|134|135|(0)|138|(0)|141|(0)|144|145|146|(0)|149|150|(0)(0)|162|166|168|170|171|173|175|176|178|180|181|183|185|186|195))|40|41|43|45|47|49|51|53|(0)|60|61|63|65|(0)(0)|76|78|80|81|(0)|84|85|(0)|104|106|108|109|111|127|128|130|132|134|135|(0)|138|(0)|141|(0)|144|145|146|(0)|149|150|(0)(0)|162|166|168|170|171|173|175|176|178|180|181|183|185|186|195) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:149:0x035f */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0324 A[Catch:{ Exception -> 0x041e }] */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x032d A[Catch:{ Exception -> 0x041e }] */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x033a A[Catch:{ Exception -> 0x041e }] */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x0349 A[Catch:{ Exception -> 0x035f }] */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x0377 A[Catch:{ Exception -> 0x041e }] */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x03a2 A[Catch:{ Exception -> 0x041e }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0186 A[Catch:{ Exception -> 0x041e }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01ab  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01b9 A[Catch:{ Exception -> 0x041e }] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0205 A[Catch:{ Exception -> 0x041e }] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x021d A[SYNTHETIC, Splitter:B:87:0x021d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void push(java.lang.String r26, java.util.HashMap<java.lang.String, java.lang.Object> r27, boolean r28) {
        /*
            r1 = r26
            r2 = r27
            java.lang.String r0 = "groupFtueUrl"
            java.lang.String r3 = "App Screen Viewed"
            java.lang.String r4 = "Feature"
            java.lang.String r5 = "Login Initiated"
            java.lang.String r6 = "Is Game Event"
            java.lang.String r7 = "Game Session ID"
            java.lang.String r8 = "Game Config Name"
            java.lang.String r9 = "Game ID"
            java.lang.String r10 = "Screen Name"
            java.lang.String r11 = ""
            r12 = 2
            java.lang.Object[] r13 = new java.lang.Object[r12]
            java.lang.String r14 = "push:1 "
            r15 = 0
            r13[r15] = r14
            r14 = 1
            r13[r14] = r1
            java.lang.String r12 = "CleverTapAnalyticsUtils"
            com.mpl.androidapp.utils.MLogger.d(r12, r13)
            boolean r13 = isRemovedEvents(r26)     // Catch:{ Exception -> 0x041e }
            if (r13 == 0) goto L_0x002f
            return
        L_0x002f:
            java.lang.String r13 = "ctp"
            java.util.HashMap r13 = io.hansel.ujmtracker.HanselTracker.logEvent(r1, r13, r2)     // Catch:{ Exception -> 0x041e }
            if (r2 != 0) goto L_0x003e
            java.util.HashMap r17 = new java.util.HashMap     // Catch:{ Exception -> 0x041e }
            r17.<init>()     // Catch:{ Exception -> 0x041e }
            r2 = r17
        L_0x003e:
            if (r13 == 0) goto L_0x0043
            r2.putAll(r13)     // Catch:{ Exception -> 0x041e }
        L_0x0043:
            java.lang.String r13 = "Rank Fetched"
            boolean r13 = r1.equalsIgnoreCase(r13)     // Catch:{ Exception -> 0x041e }
            if (r13 == 0) goto L_0x0064
            org.json.JSONObject r13 = com.mpl.androidapp.config.ConfigManager.getPlatformConfig()     // Catch:{ Exception -> 0x041e }
            if (r13 == 0) goto L_0x0064
            java.lang.String r13 = "Native Submit Score Enabled"
            org.json.JSONObject r14 = com.mpl.androidapp.config.ConfigManager.getPlatformConfig()     // Catch:{ Exception -> 0x041e }
            java.lang.String r15 = "nativeSubmitScore.enabled"
            boolean r14 = r14.optBoolean(r15)     // Catch:{ Exception -> 0x041e }
            java.lang.Boolean r14 = java.lang.Boolean.valueOf(r14)     // Catch:{ Exception -> 0x041e }
            r2.put(r13, r14)     // Catch:{ Exception -> 0x041e }
        L_0x0064:
            boolean r13 = r1.equalsIgnoreCase(r5)     // Catch:{ Exception -> 0x041e }
            java.lang.String r14 = "Login Success"
            if (r13 != 0) goto L_0x009f
            java.lang.String r13 = "Login Initiation Failed"
            boolean r13 = r1.equalsIgnoreCase(r13)     // Catch:{ Exception -> 0x041e }
            if (r13 != 0) goto L_0x009f
            boolean r13 = r1.equalsIgnoreCase(r14)     // Catch:{ Exception -> 0x041e }
            if (r13 != 0) goto L_0x009f
            java.lang.String r13 = "Referral Success"
            boolean r13 = r1.equalsIgnoreCase(r13)     // Catch:{ Exception -> 0x041e }
            if (r13 != 0) goto L_0x009f
            java.lang.String r13 = "Game Started"
            boolean r13 = r1.equalsIgnoreCase(r13)     // Catch:{ Exception -> 0x041e }
            if (r13 != 0) goto L_0x009f
            java.lang.String r13 = "Game Ended"
            boolean r13 = r1.equalsIgnoreCase(r13)     // Catch:{ Exception -> 0x041e }
            if (r13 == 0) goto L_0x0093
            goto L_0x009f
        L_0x0093:
            r24 = r3
            r19 = r7
            r20 = r8
            r21 = r9
            r22 = r10
            goto L_0x020c
        L_0x009f:
            com.mpl.androidapp.MPLApplication r13 = com.mpl.androidapp.MPLApplication.getInstance()     // Catch:{ Exception -> 0x041e }
            java.lang.String r13 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getAFReferralFeature(r13, r4, r11)     // Catch:{ Exception -> 0x041e }
            com.mpl.androidapp.MPLApplication r15 = com.mpl.androidapp.MPLApplication.getInstance()     // Catch:{ Exception -> 0x041e }
            r19 = r7
            java.lang.String r7 = "appFlyerEntryPoint"
            java.lang.String r7 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getStringInNormalPref(r15, r7, r11)     // Catch:{ Exception -> 0x041e }
            com.mpl.androidapp.MPLApplication r15 = com.mpl.androidapp.MPLApplication.getInstance()     // Catch:{ Exception -> 0x041e }
            r20 = r8
            java.lang.String r8 = "pwf_group_name"
            java.lang.String r8 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getStringInNormalPref(r15, r8, r11)     // Catch:{ Exception -> 0x041e }
            com.mpl.androidapp.MPLApplication r15 = com.mpl.androidapp.MPLApplication.getInstance()     // Catch:{ Exception -> 0x041e }
            r21 = r9
            java.lang.String r9 = "pwf_group_id"
            java.lang.String r9 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getStringInNormalPref(r15, r9, r11)     // Catch:{ Exception -> 0x041e }
            com.mpl.androidapp.MPLApplication r15 = com.mpl.androidapp.MPLApplication.getInstance()     // Catch:{ Exception -> 0x041e }
            r22 = r10
            java.lang.String r10 = "pwf_challenge_id"
            java.lang.String r10 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getStringInNormalPref(r15, r10, r11)     // Catch:{ Exception -> 0x041e }
            r15 = 13
            java.lang.Object[] r15 = new java.lang.Object[r15]     // Catch:{ Exception -> 0x041e }
            java.lang.String r23 = "push:2"
            r18 = 0
            r15[r18] = r23     // Catch:{ Exception -> 0x041e }
            java.lang.String r23 = "feature "
            r17 = 1
            r15[r17] = r23     // Catch:{ Exception -> 0x041e }
            r16 = 2
            r15[r16] = r13     // Catch:{ Exception -> 0x041e }
            java.lang.String r23 = "eventName: "
            r24 = r3
            r3 = 3
            r15[r3] = r23     // Catch:{ Exception -> 0x041e }
            r23 = 4
            r15[r23] = r1     // Catch:{ Exception -> 0x041e }
            r23 = 5
            java.lang.String r25 = "entryPoint: "
            r15[r23] = r25     // Catch:{ Exception -> 0x041e }
            r23 = 6
            r15[r23] = r7     // Catch:{ Exception -> 0x041e }
            r23 = 7
            java.lang.String r25 = "pwfGroupName: "
            r15[r23] = r25     // Catch:{ Exception -> 0x041e }
            r23 = 8
            r15[r23] = r8     // Catch:{ Exception -> 0x041e }
            r23 = 9
            java.lang.String r25 = "pwfGroupId: "
            r15[r23] = r25     // Catch:{ Exception -> 0x041e }
            r23 = 10
            r15[r23] = r9     // Catch:{ Exception -> 0x041e }
            r23 = 11
            java.lang.String r25 = "pwfChallengeId: "
            r15[r23] = r25     // Catch:{ Exception -> 0x041e }
            r23 = 12
            r15[r23] = r10     // Catch:{ Exception -> 0x041e }
            com.mpl.androidapp.utils.MLogger.d(r12, r15)     // Catch:{ Exception -> 0x041e }
            boolean r15 = android.text.TextUtils.isEmpty(r13)     // Catch:{ Exception -> 0x041e }
            if (r15 != 0) goto L_0x012a
            r2.put(r4, r13)     // Catch:{ Exception -> 0x041e }
        L_0x012a:
            boolean r4 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x041e }
            if (r4 != 0) goto L_0x0146
            java.lang.String r4 = "Entry Point"
            r2.put(r4, r7)     // Catch:{ Exception -> 0x041e }
            java.lang.String r4 = "PWF"
            boolean r4 = r4.equalsIgnoreCase(r7)     // Catch:{ Exception -> 0x041e }
            if (r4 == 0) goto L_0x0146
            java.lang.String r4 = "Is PWF"
            java.lang.Boolean r7 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x041e }
            r2.put(r4, r7)     // Catch:{ Exception -> 0x041e }
            r4 = 1
            goto L_0x0147
        L_0x0146:
            r4 = 0
        L_0x0147:
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x041e }
            java.lang.String r7 = "push: "
            r13 = 0
            r3[r13] = r7     // Catch:{ Exception -> 0x041e }
            java.lang.String r7 = "isPWF"
            r13 = 1
            r3[r13] = r7     // Catch:{ Exception -> 0x041e }
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r4)     // Catch:{ Exception -> 0x041e }
            r13 = 2
            r3[r13] = r7     // Catch:{ Exception -> 0x041e }
            com.mpl.androidapp.utils.MLogger.d(r12, r3)     // Catch:{ Exception -> 0x041e }
            if (r4 == 0) goto L_0x016a
            boolean r3 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x041e }
            if (r3 != 0) goto L_0x016a
            java.lang.String r3 = "PWF Group Name"
            r2.put(r3, r8)     // Catch:{ Exception -> 0x041e }
        L_0x016a:
            if (r4 == 0) goto L_0x0177
            boolean r3 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x041e }
            if (r3 != 0) goto L_0x0177
            java.lang.String r3 = "PWF Group Id"
            r2.put(r3, r9)     // Catch:{ Exception -> 0x041e }
        L_0x0177:
            if (r4 == 0) goto L_0x0184
            boolean r3 = android.text.TextUtils.isEmpty(r10)     // Catch:{ Exception -> 0x041e }
            if (r3 != 0) goto L_0x0184
            java.lang.String r3 = "PWF Challenge Id"
            r2.put(r3, r10)     // Catch:{ Exception -> 0x041e }
        L_0x0184:
            if (r4 == 0) goto L_0x0198
            java.lang.String r3 = "Is Creator"
            boolean r4 = com.mpl.androidapp.utils.MSharedPreferencesUtils.isSelfReferral()     // Catch:{ Exception -> 0x041e }
            if (r4 == 0) goto L_0x0190
            r4 = 1
            goto L_0x0191
        L_0x0190:
            r4 = 0
        L_0x0191:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x041e }
            r2.put(r3, r4)     // Catch:{ Exception -> 0x041e }
        L_0x0198:
            int r3 = com.mpl.androidapp.utils.MBuildConfigUtils.getLaunchingGameId()     // Catch:{ Exception -> 0x041e }
            r4 = 770(0x302, float:1.079E-42)
            java.lang.String r7 = "FTUE Type"
            if (r3 == r4) goto L_0x01bf
            r4 = 775(0x307, float:1.086E-42)
            if (r3 == r4) goto L_0x01bf
            r4 = 1000044(0xf426c, float:1.40136E-39)
            if (r3 == r4) goto L_0x01b9
            r4 = 777(0x309, float:1.089E-42)
            if (r3 == r4) goto L_0x01bf
            r4 = 778(0x30a, float:1.09E-42)
            if (r3 == r4) goto L_0x01bf
            java.lang.String r4 = "Games"
            r2.put(r7, r4)     // Catch:{ Exception -> 0x041e }
            goto L_0x01c4
        L_0x01b9:
            java.lang.String r4 = "Rummy"
            r2.put(r7, r4)     // Catch:{ Exception -> 0x041e }
            goto L_0x01c4
        L_0x01bf:
            java.lang.String r4 = "Fantasy"
            r2.put(r7, r4)     // Catch:{ Exception -> 0x041e }
        L_0x01c4:
            java.lang.String r4 = "Game Name"
            java.lang.String r3 = com.mpl.androidapp.utils.CommonUtils.getGameNameForID(r3)     // Catch:{ Exception -> 0x041e }
            r2.put(r4, r3)     // Catch:{ Exception -> 0x041e }
            com.mpl.androidapp.MPLApplication r3 = com.mpl.androidapp.MPLApplication.getInstance()     // Catch:{ Exception -> 0x041e }
            java.lang.String r3 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getStringInNormalPref(r3, r0, r11)     // Catch:{ Exception -> 0x041e }
            r4 = 2
            java.lang.Object[] r8 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x041e }
            java.lang.String r4 = "push:2 groupFtueUrl "
            r9 = 0
            r8[r9] = r4     // Catch:{ Exception -> 0x041e }
            r4 = 1
            r8[r4] = r3     // Catch:{ Exception -> 0x041e }
            com.mpl.androidapp.utils.MLogger.d(r12, r8)     // Catch:{ Exception -> 0x041e }
            if (r3 == 0) goto L_0x01ff
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x041e }
            if (r4 != 0) goto L_0x01ff
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x041e }
            r4.<init>()     // Catch:{ Exception -> 0x041e }
            java.lang.String r8 = "GroupsInvite"
            r4.append(r8)     // Catch:{ Exception -> 0x041e }
            r4.append(r3)     // Catch:{ Exception -> 0x041e }
            java.lang.String r3 = r4.toString()     // Catch:{ Exception -> 0x041e }
            r2.put(r7, r3)     // Catch:{ Exception -> 0x041e }
        L_0x01ff:
            boolean r3 = r1.equalsIgnoreCase(r14)     // Catch:{ Exception -> 0x041e }
            if (r3 == 0) goto L_0x020c
            com.mpl.androidapp.MPLApplication r3 = com.mpl.androidapp.MPLApplication.getInstance()     // Catch:{ Exception -> 0x041e }
            com.mpl.androidapp.utils.MSharedPreferencesUtils.deleteNormalPref(r3, r0)     // Catch:{ Exception -> 0x041e }
        L_0x020c:
            java.util.HashMap r0 = commonPropertiesForEvents(r28)     // Catch:{ Exception -> 0x041e }
            r2.putAll(r0)     // Catch:{ Exception -> 0x041e }
            boolean r0 = r1.equalsIgnoreCase(r14)     // Catch:{ Exception -> 0x041e }
            java.lang.String r3 = "MPL User ID"
            java.lang.String r4 = "User ID"
            if (r0 == 0) goto L_0x0279
            com.mpl.androidapp.MPLApplication r0 = com.mpl.androidapp.MPLApplication.getInstance()     // Catch:{ Exception -> 0x041e }
            int r0 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getUserIdInNormalPrefV2(r0)     // Catch:{ Exception -> 0x041e }
            if (r0 == 0) goto L_0x0279
            java.lang.Object r7 = r2.get(r4)     // Catch:{ Exception -> 0x041e }
            if (r7 == 0) goto L_0x0250
            java.lang.Object r7 = r2.get(r4)     // Catch:{ Exception -> 0x041e }
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ Exception -> 0x041e }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x041e }
            if (r7 != 0) goto L_0x0250
            java.lang.Object r7 = r2.get(r4)     // Catch:{ Exception -> 0x041e }
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ Exception -> 0x041e }
            int r7 = java.lang.Integer.parseInt(r7)     // Catch:{ Exception -> 0x041e }
            if (r7 != 0) goto L_0x0250
            java.lang.Integer r7 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x041e }
            r2.put(r4, r7)     // Catch:{ Exception -> 0x041e }
        L_0x0250:
            java.lang.Object r7 = r2.get(r3)     // Catch:{ Exception -> 0x041e }
            if (r7 == 0) goto L_0x0279
            java.lang.Object r7 = r2.get(r3)     // Catch:{ Exception -> 0x041e }
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ Exception -> 0x041e }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x041e }
            if (r7 != 0) goto L_0x0279
            java.lang.Object r7 = r2.get(r3)     // Catch:{ Exception -> 0x041e }
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ Exception -> 0x041e }
            int r7 = java.lang.Integer.parseInt(r7)     // Catch:{ Exception -> 0x041e }
            if (r7 != 0) goto L_0x0279
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x041e }
            r2.put(r3, r0)     // Catch:{ Exception -> 0x041e }
        L_0x0279:
            boolean r0 = r1.equalsIgnoreCase(r5)     // Catch:{ Exception -> 0x041e }
            if (r0 == 0) goto L_0x028b
            boolean r0 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getGuestUserLogin()     // Catch:{ Exception -> 0x041e }
            if (r0 == 0) goto L_0x028b
            r2.remove(r4)     // Catch:{ Exception -> 0x041e }
            r2.remove(r3)     // Catch:{ Exception -> 0x041e }
        L_0x028b:
            r3 = 1
            java.lang.Object[] r0 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x041e }
            java.lang.String r3 = "push:3 feature "
            r4 = 0
            r0[r4] = r3     // Catch:{ Exception -> 0x041e }
            com.mpl.androidapp.utils.MLogger.d(r12, r0)     // Catch:{ Exception -> 0x041e }
            boolean r0 = com.mpl.androidapp.config.ConfigManager.isIpToAddressConvEnabled()     // Catch:{ Exception -> 0x041e }
            if (r0 == 0) goto L_0x02f0
            boolean r0 = r1.equalsIgnoreCase(r14)     // Catch:{ Exception -> 0x041e }
            if (r0 != 0) goto L_0x02da
            java.lang.String r0 = "MQTT Connection"
            boolean r0 = r1.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x041e }
            if (r0 != 0) goto L_0x02da
            java.lang.String r0 = "Add Amount initiated"
            boolean r0 = r1.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x041e }
            if (r0 != 0) goto L_0x02da
            java.lang.String r0 = "Tile selected"
            boolean r0 = r1.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x041e }
            if (r0 != 0) goto L_0x02da
            java.lang.String r0 = "Game View Quick Battles"
            boolean r0 = r1.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x041e }
            if (r0 != 0) goto L_0x02da
            java.lang.String r0 = "Tournament Selected"
            boolean r0 = r1.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x041e }
            if (r0 != 0) goto L_0x02da
            java.lang.String r0 = "KYC initiated"
            boolean r0 = r1.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x041e }
            if (r0 != 0) goto L_0x02da
            java.lang.String r0 = "Withdraw mode selected"
            boolean r0 = r1.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x041e }
            if (r0 == 0) goto L_0x02f0
        L_0x02da:
            java.lang.String r0 = "Network State"
            com.mpl.androidapp.utils.IPAddressConversion r3 = com.mpl.androidapp.utils.IPAddressConversion.INSTANCE     // Catch:{ Exception -> 0x041e }
            java.lang.String r3 = r3.getState()     // Catch:{ Exception -> 0x041e }
            r2.put(r0, r3)     // Catch:{ Exception -> 0x041e }
            java.lang.String r0 = "Network Country"
            com.mpl.androidapp.utils.IPAddressConversion r3 = com.mpl.androidapp.utils.IPAddressConversion.INSTANCE     // Catch:{ Exception -> 0x041e }
            java.lang.String r3 = r3.getCountry()     // Catch:{ Exception -> 0x041e }
            r2.put(r0, r3)     // Catch:{ Exception -> 0x041e }
        L_0x02f0:
            boolean r0 = r2.containsKey(r6)     // Catch:{ Exception -> 0x041e }
            if (r0 == 0) goto L_0x031e
            java.lang.Object r0 = r2.get(r6)     // Catch:{ Exception -> 0x041e }
            if (r0 == 0) goto L_0x031e
            java.lang.Object r0 = r2.get(r6)     // Catch:{ Exception -> 0x041e }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x041e }
            boolean r0 = java.lang.Boolean.parseBoolean(r0)     // Catch:{ Exception -> 0x041e }
            if (r0 == 0) goto L_0x031e
            r3 = 1
            java.lang.Object[] r0 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x041e }
            java.lang.String r3 = "push: Adding country code again for game"
            r4 = 0
            r0[r4] = r3     // Catch:{ Exception -> 0x041e }
            com.mpl.androidapp.utils.MLogger.d(r12, r0)     // Catch:{ Exception -> 0x041e }
            java.lang.String r0 = "Country Code"
            java.lang.String r3 = com.mpl.androidapp.utils.CountryUtils.getCountryCodeForUnity()     // Catch:{ Exception -> 0x041e }
            r2.put(r0, r3)     // Catch:{ Exception -> 0x041e }
        L_0x031e:
            boolean r0 = isFacebookEvents(r26)     // Catch:{ Exception -> 0x041e }
            if (r0 == 0) goto L_0x0327
            com.mpl.androidapp.utils.Util.pushFacebookEventWithProp(r1, r2)     // Catch:{ Exception -> 0x041e }
        L_0x0327:
            boolean r0 = isAppsFlyerEvent(r1, r2)     // Catch:{ Exception -> 0x041e }
            if (r0 == 0) goto L_0x0334
            com.mpl.androidapp.MPLApplication r0 = com.mpl.androidapp.MPLApplication.getInstance()     // Catch:{ Exception -> 0x041e }
            sendAppsFlyerEvent(r0, r1, r2)     // Catch:{ Exception -> 0x041e }
        L_0x0334:
            boolean r0 = isGMVEvent(r26)     // Catch:{ Exception -> 0x041e }
            if (r0 == 0) goto L_0x0341
            com.mpl.androidapp.MPLApplication r0 = com.mpl.androidapp.MPLApplication.getInstance()     // Catch:{ Exception -> 0x041e }
            sendGMVEvent(r0, r1, r2)     // Catch:{ Exception -> 0x041e }
        L_0x0341:
            r0 = r24
            boolean r3 = r1.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x035f }
            if (r3 == 0) goto L_0x035f
            r3 = 1
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x035f }
            java.lang.String r3 = "push: Removing all unwanted params"
            r5 = 0
            r4[r5] = r3     // Catch:{ Exception -> 0x035f }
            com.mpl.androidapp.utils.MLogger.d(r12, r4)     // Catch:{ Exception -> 0x035f }
            java.util.Set r3 = r2.keySet()     // Catch:{ Exception -> 0x035f }
            java.util.HashSet r4 = com.mpl.androidapp.utils.CommonUtils.getCtRemovedParams()     // Catch:{ Exception -> 0x035f }
            r3.removeAll(r4)     // Catch:{ Exception -> 0x035f }
        L_0x035f:
            com.mpl.androidapp.MPLApplication r3 = com.mpl.androidapp.MPLApplication.getInstance()     // Catch:{ Exception -> 0x041e }
            android.content.Context r3 = r3.getApplicationContext()     // Catch:{ Exception -> 0x041e }
            java.lang.String r4 = "ctEventFilteringEnabled"
            java.lang.String r5 = "false"
            java.lang.String r3 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getStringInNormalPref(r3, r4, r5)     // Catch:{ Exception -> 0x041e }
            java.lang.String r4 = "true"
            boolean r3 = r3.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x041e }
            if (r3 == 0) goto L_0x03a2
            com.mpl.androidapp.updater.repo.DownloadHelper r3 = com.mpl.androidapp.updater.repo.DownloadHelper.getInstance()     // Catch:{ Exception -> 0x041e }
            java.util.ArrayList r3 = r3.sendData()     // Catch:{ Exception -> 0x041e }
            if (r3 == 0) goto L_0x0397
            boolean r4 = r3.isEmpty()     // Catch:{ Exception -> 0x041e }
            if (r4 != 0) goto L_0x0397
            boolean r4 = android.text.TextUtils.isEmpty(r26)     // Catch:{ Exception -> 0x041e }
            if (r4 != 0) goto L_0x03ac
            java.lang.String r4 = r26.toLowerCase()     // Catch:{ Exception -> 0x041e }
            boolean r3 = r3.contains(r4)     // Catch:{ Exception -> 0x041e }
            if (r3 == 0) goto L_0x03ac
        L_0x0397:
            com.mpl.analytics.MPLAnalytics r3 = com.mpl.androidapp.MPLApplication.getMplAnalytics()     // Catch:{ Exception -> 0x041e }
            r3.pushEventV2(r1, r2)     // Catch:{ Exception -> 0x041e }
            sendEventThroughSecondaryCTAccount(r1, r2)     // Catch:{ Exception -> 0x041e }
            goto L_0x03ac
        L_0x03a2:
            com.mpl.analytics.MPLAnalytics r3 = com.mpl.androidapp.MPLApplication.getMplAnalytics()     // Catch:{ Exception -> 0x041e }
            r3.pushEventV2(r1, r2)     // Catch:{ Exception -> 0x041e }
            sendEventThroughSecondaryCTAccount(r1, r2)     // Catch:{ Exception -> 0x041e }
        L_0x03ac:
            addKafkaEvent(r1, r2)     // Catch:{ Exception -> 0x041e }
            boolean r0 = r1.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x041e }
            if (r0 != 0) goto L_0x03bd
            java.lang.String r0 = "Game Play Initiated"
            boolean r0 = r1.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x041e }
            if (r0 == 0) goto L_0x045c
        L_0x03bd:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x041e }
            r0.<init>()     // Catch:{ Exception -> 0x041e }
            r3 = r22
            boolean r4 = r2.containsKey(r3)     // Catch:{ Exception -> 0x041e }
            if (r4 == 0) goto L_0x03d7
            java.lang.Object r4 = r2.get(r3)     // Catch:{ Exception -> 0x041e }
            if (r4 == 0) goto L_0x03d7
            java.lang.Object r4 = r2.get(r3)     // Catch:{ Exception -> 0x041e }
            r0.put(r3, r4)     // Catch:{ Exception -> 0x041e }
        L_0x03d7:
            r3 = r21
            boolean r4 = r2.containsKey(r3)     // Catch:{ Exception -> 0x041e }
            if (r4 == 0) goto L_0x03ec
            java.lang.Object r4 = r2.get(r3)     // Catch:{ Exception -> 0x041e }
            if (r4 == 0) goto L_0x03ec
            java.lang.Object r4 = r2.get(r3)     // Catch:{ Exception -> 0x041e }
            r0.put(r3, r4)     // Catch:{ Exception -> 0x041e }
        L_0x03ec:
            r3 = r20
            boolean r4 = r2.containsKey(r3)     // Catch:{ Exception -> 0x041e }
            if (r4 == 0) goto L_0x0401
            java.lang.Object r4 = r2.get(r3)     // Catch:{ Exception -> 0x041e }
            if (r4 == 0) goto L_0x0401
            java.lang.Object r4 = r2.get(r3)     // Catch:{ Exception -> 0x041e }
            r0.put(r3, r4)     // Catch:{ Exception -> 0x041e }
        L_0x0401:
            r3 = r19
            boolean r4 = r2.containsKey(r3)     // Catch:{ Exception -> 0x041e }
            if (r4 == 0) goto L_0x0416
            java.lang.Object r4 = r2.get(r3)     // Catch:{ Exception -> 0x041e }
            if (r4 == 0) goto L_0x0416
            java.lang.Object r4 = r2.get(r3)     // Catch:{ Exception -> 0x041e }
            r0.put(r3, r4)     // Catch:{ Exception -> 0x041e }
        L_0x0416:
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x041e }
            pushFireBaseEvents(r1, r0)     // Catch:{ Exception -> 0x041e }
            goto L_0x045c
        L_0x041e:
            r0 = move-exception
            r3 = 2
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r4 = "push:4 "
            r5 = 0
            r3[r5] = r4
            r4 = 1
            r3[r4] = r0
            com.mpl.androidapp.utils.MLogger.e(r12, r3)
            boolean r0 = isFacebookEvents(r26)
            if (r0 == 0) goto L_0x043b
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            com.mpl.androidapp.utils.Util.pushFacebookEventWithProp(r1, r0)
        L_0x043b:
            boolean r0 = isAppsFlyerEvent(r1, r2)
            if (r0 == 0) goto L_0x044d
            com.mpl.androidapp.MPLApplication r0 = com.mpl.androidapp.MPLApplication.getInstance()
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            sendAppsFlyerEvent(r0, r1, r3)
        L_0x044d:
            com.mpl.analytics.MPLAnalytics r0 = com.mpl.androidapp.MPLApplication.getMplAnalytics()
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            r0.pushEventV2(r1, r3)
            sendEventThroughSecondaryCTAccount(r1, r2)
        L_0x045c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.utils.CleverTapAnalyticsUtils.push(java.lang.String, java.util.HashMap, boolean):void");
    }

    public static void pushFacebookEventWithProp(String str, HashMap<String, Object> hashMap) {
        try {
            MLogger.d("FacebookEvents", "pushFacebookEventWithProp: ", str, hashMap);
            hashMap.put("fb_description", MBuildConfigUtils.getApplicationId());
            JSONObject jSONObject = new JSONObject(hashMap);
            Bundle bundle = new Bundle();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                bundle.putString(next, jSONObject.optString(next));
            }
            if (bundle.containsKey(EventsConstants.USER_MOBILE_NUMBER)) {
                bundle.remove(EventsConstants.USER_MOBILE_NUMBER);
                MLogger.v(TAG, "pushFacebookEventWithProp: ", "Mobile number removed from props");
            }
            if (bundle.containsKey(EventsConstants.PROP_IP_ADDRESS)) {
                bundle.remove(EventsConstants.PROP_IP_ADDRESS);
                MLogger.v(TAG, "pushFacebookEventWithProp: ", "Wifi IP Address removed from props");
            }
            if (bundle.containsKey("Total RAM GB")) {
                bundle.remove("Total RAM GB");
                MLogger.v(TAG, "sendFacebookEvents: ", "Wifi IP Address removed from props");
            }
            if (MPLLibInitContentProvider.getLibInitContentProvider() != null) {
                MPLLibInitContentProvider.getLibInitContentProvider().getFacebookAppEventsLogger().loggerImpl.logEvent(str, bundle);
            }
        } catch (Exception e2) {
            MLogger.e(TAG, "pushFacebookEventWithProp: ", e2);
        }
    }

    public static void pushFireBaseEvents(String str, String str2) {
        if (str2 != null) {
            try {
                if (!TextUtils.isEmpty(str2)) {
                    JSONObject jSONObject = new JSONObject(str2);
                    String replace = str.replace(CMap.SPACE, "_");
                    FirebaseAnalytics firebaseAnalytics = MPLLibInitContentProvider.getLibInitContentProvider().getFirebaseAnalytics();
                    firebaseAnalytics.zzb.zzx(replace, Util.jsonToBundleForFireBase(jSONObject));
                    return;
                }
            } catch (Exception e2) {
                MLogger.e(TAG, "pushFireBaseEvents: ", e2);
                return;
            }
        }
        pushFireBaseEvents(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x02a8, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x02aa, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x02ab, code lost:
        r20 = "pushOnUserLoginEvent: ";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x02ad, code lost:
        r4 = r16;
        r3 = r17;
        r2 = r18;
        r1 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x02b6, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x02b7, code lost:
        r4 = r16;
        r3 = r17;
        r2 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x02be, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x02bf, code lost:
        r20 = "pushOnUserLoginEvent: ";
        r1 = TAG;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x02b6 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:5:0x0069] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void pushOnUserLoginEvent(java.util.HashMap<java.lang.String, java.lang.Object> r22) {
        /*
            java.lang.String r0 = "Mobile Number"
            java.lang.String r1 = "Profile Tier"
            java.lang.String r2 = "Is Emulator"
            java.lang.String r3 = "Is Phone Rooted"
            java.lang.String r4 = "Is iOS App"
            java.lang.String r5 = "Last Logged In App"
            java.lang.String r6 = "App Type"
            java.lang.String r7 = "React Version"
            java.lang.String r8 = "App Version Name"
            java.lang.String r9 = "pushOnUserLoginEvent: "
            java.lang.String r10 = "CleverTapAnalyticsUtils"
            java.lang.String r11 = "App Version Code"
            java.lang.String r12 = "Identity Set System"
            java.lang.String r13 = "MPL User ID"
            java.lang.String r14 = "Unique Event Id"
            java.util.HashMap r15 = new java.util.HashMap
            r16 = r12
            r12 = r22
            r15.<init>(r12)
            int r17 = com.mpl.androidapp.utils.MBuildConfigUtils.getInstalledAppVersionCode()     // Catch:{ Exception -> 0x02cf, all -> 0x02c9 }
            java.lang.String r12 = java.lang.String.valueOf(r17)     // Catch:{ Exception -> 0x02cf, all -> 0x02c9 }
            r15.put(r11, r12)     // Catch:{ Exception -> 0x02cf, all -> 0x02c9 }
            java.lang.String r12 = com.mpl.androidapp.utils.MBuildConfigUtils.getCurrentAppVersionName()     // Catch:{ Exception -> 0x02cf, all -> 0x02c9 }
            java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch:{ Exception -> 0x02cf, all -> 0x02c9 }
            r15.put(r8, r12)     // Catch:{ Exception -> 0x02cf, all -> 0x02c9 }
            int r12 = com.mpl.androidapp.updater.interactor.DBInteractor.getCurrentRNBundleVersionCode()     // Catch:{ Exception -> 0x02cf, all -> 0x02c9 }
            java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch:{ Exception -> 0x02cf, all -> 0x02c9 }
            r15.put(r7, r12)     // Catch:{ Exception -> 0x02cf, all -> 0x02c9 }
            java.lang.String r12 = com.mpl.androidapp.utils.MBuildConfigUtils.getAppType()     // Catch:{ Exception -> 0x02cf, all -> 0x02c9 }
            r15.put(r6, r12)     // Catch:{ Exception -> 0x02cf, all -> 0x02c9 }
            java.lang.String r12 = com.mpl.androidapp.utils.MBuildConfigUtils.getAppType()     // Catch:{ Exception -> 0x02cf, all -> 0x02c9 }
            r15.put(r5, r12)     // Catch:{ Exception -> 0x02cf, all -> 0x02c9 }
            java.lang.Boolean r12 = java.lang.Boolean.FALSE     // Catch:{ Exception -> 0x02cf, all -> 0x02c9 }
            r15.put(r4, r12)     // Catch:{ Exception -> 0x02cf, all -> 0x02c9 }
            boolean r12 = com.mpl.androidapp.utils.MBuildConfigUtils.isCashApp()     // Catch:{ Exception -> 0x02cf, all -> 0x02c9 }
            r17 = r13
            java.lang.String r13 = "Is Cash App"
            r18 = r14
            java.lang.String r14 = "Is Non Cash App"
            if (r12 == 0) goto L_0x006f
            java.lang.Boolean r12 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x02be, all -> 0x02b6 }
            r15.put(r13, r12)     // Catch:{ Exception -> 0x02be, all -> 0x02b6 }
            goto L_0x0074
        L_0x006f:
            java.lang.Boolean r12 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x02be, all -> 0x02b6 }
            r15.put(r14, r12)     // Catch:{ Exception -> 0x02be, all -> 0x02b6 }
        L_0x0074:
            boolean r12 = com.mpl.androidapp.utils.MSharedPreferencesUtils.isPhoneRooted()     // Catch:{ Exception -> 0x02be, all -> 0x02b6 }
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r12)     // Catch:{ Exception -> 0x02be, all -> 0x02b6 }
            r15.put(r3, r12)     // Catch:{ Exception -> 0x02be, all -> 0x02b6 }
            boolean r12 = com.mpl.androidapp.utils.MSharedPreferencesUtils.isEmulator()     // Catch:{ Exception -> 0x02be, all -> 0x02b6 }
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r12)     // Catch:{ Exception -> 0x02be, all -> 0x02b6 }
            r15.put(r2, r12)     // Catch:{ Exception -> 0x02be, all -> 0x02b6 }
            java.lang.String r12 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getUserTier()     // Catch:{ Exception -> 0x02be, all -> 0x02b6 }
            r15.put(r1, r12)     // Catch:{ Exception -> 0x02be, all -> 0x02b6 }
            java.lang.String r12 = com.mpl.androidapp.utils.CountryUtils.getUniqueIdForThirdPartySDKs()     // Catch:{ Exception -> 0x02be, all -> 0x02b6 }
            r15.put(r0, r12)     // Catch:{ Exception -> 0x02be, all -> 0x02b6 }
            r19 = r10
            java.lang.String r10 = "Identity"
            r15.put(r10, r12)     // Catch:{ Exception -> 0x02aa, all -> 0x02b6 }
            java.lang.String r10 = "Phone"
            r15.put(r10, r12)     // Catch:{ Exception -> 0x02aa, all -> 0x02b6 }
            java.lang.String r10 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getUserEmail()     // Catch:{ Exception -> 0x02aa, all -> 0x02b6 }
            boolean r20 = android.text.TextUtils.isEmpty(r10)     // Catch:{ Exception -> 0x02aa, all -> 0x02b6 }
            if (r20 != 0) goto L_0x00bb
            r20 = r9
            java.lang.String r9 = "Email"
            r15.put(r9, r10)     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            java.lang.String r9 = "Email ID"
            r15.put(r9, r10)     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            goto L_0x00bd
        L_0x00bb:
            r20 = r9
        L_0x00bd:
            java.lang.String r9 = "MSG-email"
            java.lang.Boolean r10 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            r15.put(r9, r10)     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            java.lang.String r9 = "MSG-push"
            java.lang.Boolean r10 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            r15.put(r9, r10)     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            java.lang.String r9 = "MSG-sms"
            java.lang.Boolean r10 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            r15.put(r9, r10)     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            java.lang.String r9 = "Hansel Experiment"
            java.lang.String r10 = com.mpl.androidapp.config.ConfigManager.getHanselExperience()     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            r15.put(r9, r10)     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            java.lang.String r9 = "Hansel Experiment Variant"
            java.lang.String r10 = com.mpl.androidapp.config.ConfigManager.getHanselExperienceVariantData()     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            r15.put(r9, r10)     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            java.lang.String r9 = "Hansel Dummy Flag"
            java.lang.String r10 = "Hansel_Dummy_Flag"
            r21 = r5
            r5 = 0
            boolean r10 = io.hansel.actions.configs.HanselConfigs.getBoolean(r10, r5)     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r10)     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            r15.put(r9, r5)     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            java.lang.String r5 = "Country Code"
            java.lang.String r9 = com.mpl.androidapp.utils.MBuildConfigUtils.getCountryCode()     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            r15.put(r5, r9)     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            io.hansel.hanselsdk.HanselUser r5 = io.hansel.hanselsdk.Hansel.getUser()     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            r5.setUserId(r12)     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            io.hansel.hanselsdk.HanselUser r5 = io.hansel.hanselsdk.Hansel.getUser()     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            int r9 = com.mpl.androidapp.utils.MBuildConfigUtils.getInstalledAppVersionCode()     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            r5.putAttribute(r11, r9)     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            io.hansel.hanselsdk.HanselUser r5 = io.hansel.hanselsdk.Hansel.getUser()     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            java.lang.String r9 = com.mpl.androidapp.utils.MBuildConfigUtils.getCurrentAppVersionName()     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            r5.putAttribute(r8, r9)     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            io.hansel.hanselsdk.HanselUser r5 = io.hansel.hanselsdk.Hansel.getUser()     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            int r8 = com.mpl.androidapp.updater.interactor.DBInteractor.getCurrentRNBundleVersionCode()     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            r5.putAttribute(r7, r8)     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            io.hansel.hanselsdk.HanselUser r5 = io.hansel.hanselsdk.Hansel.getUser()     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            java.lang.String r7 = com.mpl.androidapp.utils.MBuildConfigUtils.getAppType()     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            r5.putAttribute(r6, r7)     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            io.hansel.hanselsdk.HanselUser r5 = io.hansel.hanselsdk.Hansel.getUser()     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            boolean r6 = com.mpl.androidapp.utils.MSharedPreferencesUtils.isPhoneRooted()     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            r5.putAttribute(r3, r6)     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            io.hansel.hanselsdk.HanselUser r3 = io.hansel.hanselsdk.Hansel.getUser()     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            java.lang.String r5 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getUserTier()     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            r3.putAttribute(r1, r5)     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            io.hansel.hanselsdk.HanselUser r1 = io.hansel.hanselsdk.Hansel.getUser()     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            java.lang.String r3 = "Hansel Dummy Flag"
            java.lang.String r5 = "Hansel_Dummy_Flag"
            r6 = 0
            boolean r5 = io.hansel.actions.configs.HanselConfigs.getBoolean(r5, r6)     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            r1.putAttribute(r3, r5)     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            io.hansel.hanselsdk.HanselUser r1 = io.hansel.hanselsdk.Hansel.getUser()     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            r1.putAttribute(r4, r6)     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            boolean r1 = com.mpl.androidapp.utils.MBuildConfigUtils.isCashApp()     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            if (r1 == 0) goto L_0x017a
            io.hansel.hanselsdk.HanselUser r1 = io.hansel.hanselsdk.Hansel.getUser()     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            r3 = 1
            r1.putAttribute(r13, r3)     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            goto L_0x0182
        L_0x017a:
            io.hansel.hanselsdk.HanselUser r1 = io.hansel.hanselsdk.Hansel.getUser()     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            r3 = 1
            r1.putAttribute(r14, r3)     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
        L_0x0182:
            io.hansel.hanselsdk.HanselUser r1 = io.hansel.hanselsdk.Hansel.getUser()     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            boolean r3 = com.mpl.androidapp.utils.MSharedPreferencesUtils.isEmulator()     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            r1.putAttribute(r2, r3)     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            io.hansel.hanselsdk.HanselUser r1 = io.hansel.hanselsdk.Hansel.getUser()     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            r1.putAttribute(r0, r12)     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            io.hansel.hanselsdk.HanselUser r0 = io.hansel.hanselsdk.Hansel.getUser()     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            java.lang.String r1 = com.mpl.androidapp.utils.MBuildConfigUtils.getAppType()     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            r2 = r21
            r0.putAttribute(r2, r1)     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            io.hansel.hanselsdk.HanselUser r0 = io.hansel.hanselsdk.Hansel.getUser()     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            java.lang.String r1 = "Phone Model"
            java.lang.String r2 = android.os.Build.MODEL     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            r0.putAttribute(r1, r2)     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            io.hansel.hanselsdk.HanselUser r0 = io.hansel.hanselsdk.Hansel.getUser()     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            java.lang.String r1 = "Phone Make"
            java.lang.String r2 = android.os.Build.BRAND     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            r0.putAttribute(r1, r2)     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            io.hansel.hanselsdk.HanselUser r0 = io.hansel.hanselsdk.Hansel.getUser()     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            java.lang.String r1 = "OS Version"
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            double r2 = (double) r2     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            r0.putAttribute(r1, r2)     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            io.hansel.hanselsdk.HanselUser r0 = io.hansel.hanselsdk.Hansel.getUser()     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            java.lang.String r1 = "Phone Manufacturer"
            java.lang.String r2 = android.os.Build.MANUFACTURER     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            r0.putAttribute(r1, r2)     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            io.hansel.hanselsdk.HanselUser r0 = io.hansel.hanselsdk.Hansel.getUser()     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            java.lang.String r1 = "Country Code"
            java.lang.String r2 = com.mpl.androidapp.utils.MBuildConfigUtils.getCountryCode()     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            java.lang.String r2 = r2.toUpperCase()     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            r0.putAttribute(r1, r2)     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            java.util.HashMap r0 = com.mpl.androidapp.utils.CommonUtils.getDeviceMemoryInfo()     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            r2 = 24
            java.lang.String r3 = "Total RAM"
            if (r1 < r2) goto L_0x0205
            io.hansel.hanselsdk.HanselUser r1 = io.hansel.hanselsdk.Hansel.getUser()     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            r2 = 0
            java.lang.Integer r4 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            java.lang.Object r2 = r0.getOrDefault(r3, r4)     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            long r4 = java.lang.Long.parseLong(r2)     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            double r4 = (double) r4     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            r1.putAttribute(r3, r4)     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            goto L_0x0229
        L_0x0205:
            java.lang.Object r1 = r0.get(r3)     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            if (r1 == 0) goto L_0x0220
            io.hansel.hanselsdk.HanselUser r1 = io.hansel.hanselsdk.Hansel.getUser()     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            java.lang.Object r2 = r0.get(r3)     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            long r4 = java.lang.Long.parseLong(r2)     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            double r4 = (double) r4     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            r1.putAttribute(r3, r4)     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            goto L_0x0229
        L_0x0220:
            io.hansel.hanselsdk.HanselUser r1 = io.hansel.hanselsdk.Hansel.getUser()     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            r4 = 0
            r1.putAttribute(r3, r4)     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
        L_0x0229:
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            r2 = 24
            java.lang.String r3 = "Available RAM"
            if (r1 < r2) goto L_0x024b
            io.hansel.hanselsdk.HanselUser r1 = io.hansel.hanselsdk.Hansel.getUser()     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            r2 = 0
            java.lang.Integer r4 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            java.lang.Object r0 = r0.getOrDefault(r3, r4)     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            long r4 = java.lang.Long.parseLong(r0)     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            double r4 = (double) r4     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            r1.putAttribute(r3, r4)     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            goto L_0x026f
        L_0x024b:
            java.lang.Object r1 = r0.get(r3)     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            if (r1 == 0) goto L_0x0266
            io.hansel.hanselsdk.HanselUser r1 = io.hansel.hanselsdk.Hansel.getUser()     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            java.lang.Object r0 = r0.get(r3)     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            long r4 = java.lang.Long.parseLong(r0)     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            double r4 = (double) r4     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            r1.putAttribute(r3, r4)     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            goto L_0x026f
        L_0x0266:
            io.hansel.hanselsdk.HanselUser r0 = io.hansel.hanselsdk.Hansel.getUser()     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            r1 = 0
            r0.putAttribute(r3, r1)     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
        L_0x026f:
            r1 = 2
            java.lang.Object[] r0 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            r1 = 0
            r0[r1] = r20     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            r1 = 1
            r0[r1] = r12     // Catch:{ Exception -> 0x02a8, all -> 0x02b6 }
            r1 = r19
            com.mpl.androidapp.utils.MLogger.d(r1, r0)     // Catch:{ Exception -> 0x02a6, all -> 0x02b6 }
            com.mpl.analytics.MPLAnalytics r0 = com.mpl.androidapp.MPLApplication.getMplAnalytics()
            r0.pushOnUserLoginEvent(r15)
            java.util.UUID r0 = java.util.UUID.randomUUID()
            java.lang.String r0 = r0.toString()
            r2 = r18
            r15.put(r2, r0)
            com.mpl.androidapp.MPLApplication r0 = com.mpl.androidapp.MPLApplication.getInstance()
            int r0 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getUserIdInNormalPrefV2(r0)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r3 = r17
            r15.put(r3, r0)
            r4 = r16
            goto L_0x0304
        L_0x02a6:
            r0 = move-exception
            goto L_0x02c2
        L_0x02a8:
            r0 = move-exception
            goto L_0x02ad
        L_0x02aa:
            r0 = move-exception
            r20 = r9
        L_0x02ad:
            r4 = r16
            r3 = r17
            r2 = r18
            r1 = r19
            goto L_0x02d7
        L_0x02b6:
            r0 = move-exception
            r4 = r16
            r3 = r17
            r2 = r18
            goto L_0x0309
        L_0x02be:
            r0 = move-exception
            r20 = r9
            r1 = r10
        L_0x02c2:
            r4 = r16
            r3 = r17
            r2 = r18
            goto L_0x02d7
        L_0x02c9:
            r0 = move-exception
            r3 = r13
            r2 = r14
            r4 = r16
            goto L_0x0309
        L_0x02cf:
            r0 = move-exception
            r20 = r9
            r1 = r10
            r3 = r13
            r2 = r14
            r4 = r16
        L_0x02d7:
            r5 = 2
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x0308 }
            r6 = 0
            r5[r6] = r20     // Catch:{ all -> 0x0308 }
            r6 = 1
            r5[r6] = r0     // Catch:{ all -> 0x0308 }
            com.mpl.androidapp.utils.MLogger.e(r1, r5)     // Catch:{ all -> 0x0308 }
            com.mpl.analytics.MPLAnalytics r0 = com.mpl.androidapp.MPLApplication.getMplAnalytics()
            r0.pushOnUserLoginEvent(r15)
            java.util.UUID r0 = java.util.UUID.randomUUID()
            java.lang.String r0 = r0.toString()
            r15.put(r2, r0)
            com.mpl.androidapp.MPLApplication r0 = com.mpl.androidapp.MPLApplication.getInstance()
            int r0 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getUserIdInNormalPrefV2(r0)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r15.put(r3, r0)
        L_0x0304:
            addKafkaEvent(r4, r15)
            return
        L_0x0308:
            r0 = move-exception
        L_0x0309:
            com.mpl.analytics.MPLAnalytics r1 = com.mpl.androidapp.MPLApplication.getMplAnalytics()
            r1.pushOnUserLoginEvent(r15)
            java.util.UUID r1 = java.util.UUID.randomUUID()
            java.lang.String r1 = r1.toString()
            r15.put(r2, r1)
            com.mpl.androidapp.MPLApplication r1 = com.mpl.androidapp.MPLApplication.getInstance()
            int r1 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getUserIdInNormalPrefV2(r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r15.put(r3, r1)
            addKafkaEvent(r4, r15)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.utils.CleverTapAnalyticsUtils.pushOnUserLoginEvent(java.util.HashMap):void");
    }

    public static void pushProfileEvent(HashMap<String, Object> hashMap) {
        Object obj;
        String str;
        String str2;
        HashMap<String, Object> hashMap2 = hashMap;
        try {
            hashMap2.put(EventsConstants.APP_VERSION_CODE, String.valueOf(MBuildConfigUtils.getInstalledAppVersionCode()));
            hashMap2.put(EventsConstants.APP_VERSION_NAME, String.valueOf(MBuildConfigUtils.getCurrentAppVersionName()));
            hashMap2.put(EventsConstants.REACT_VERSION, String.valueOf(DBInteractor.getCurrentRNBundleVersionCode()));
            hashMap2.put(EventsConstants.ANDROID_APP_TYPE, MBuildConfigUtils.getAppType());
            String uniqueIdForThirdPartySDKs = CountryUtils.getUniqueIdForThirdPartySDKs();
            if (!TextUtils.isEmpty(uniqueIdForThirdPartySDKs)) {
                hashMap2.put(EventsConstants.USER_MOBILE_NUMBER, uniqueIdForThirdPartySDKs);
                str2 = TAG;
                try {
                    hashMap2.put(EventsConstants.USER_PHONE_CLEVER_TAP, uniqueIdForThirdPartySDKs);
                } catch (Exception e2) {
                    e = e2;
                    obj = "pushProfileEvent: ";
                    str = str2;
                    try {
                        MLogger.e(str, obj, e);
                        MPLApplication.getMplAnalytics().pushProfileEventV2(hashMap2);
                    } catch (Throwable th) {
                        MPLApplication.getMplAnalytics().pushProfileEventV2(hashMap2);
                        throw th;
                    }
                }
            } else {
                str2 = TAG;
            }
            String userEmail = MSharedPreferencesUtils.getUserEmail();
            if (!TextUtils.isEmpty(userEmail)) {
                obj = "pushProfileEvent: ";
                try {
                    hashMap2.put(EventsConstants.USER_EMAIL_CLEVER_TAP, userEmail);
                    hashMap2.put(EventsConstants.USER_EMAIL_ID, userEmail);
                } catch (Exception e3) {
                    e = e3;
                    str = str2;
                    MLogger.e(str, obj, e);
                    MPLApplication.getMplAnalytics().pushProfileEventV2(hashMap2);
                }
            } else {
                obj = "pushProfileEvent: ";
            }
            hashMap2.put(EventsConstants.IS_USER_PHONE_ROOTED, Boolean.valueOf(MSharedPreferencesUtils.isPhoneRooted()));
            hashMap2.put(EventsConstants.LAST_LOGGED_IN_APP, MBuildConfigUtils.getAppType());
            hashMap2.put(EventsConstants.USER_TIER, MSharedPreferencesUtils.getUserTier());
            if (MBuildConfigUtils.isCashApp()) {
                hashMap2.put(EventsConstants.IS_CASH_APP, Boolean.TRUE);
            } else {
                hashMap2.put(EventsConstants.IS_NON_CASH_APP, Boolean.TRUE);
            }
            hashMap2.put(EventsConstants.IS_EMULATOR, Boolean.valueOf(MSharedPreferencesUtils.isEmulator()));
            hashMap2.put(EventsConstants.IS_IOS_APP, Boolean.FALSE);
            String str3 = EventsConstants.LAST_LOGGED_IN_APP;
            hashMap2.put(EventsConstants.HANSEL_EXPERIMENT, MSharedPreferencesUtils.getStringPref(EventsConstants.HANSEL_EXPERIMENT_PREF, "", false));
            hashMap2.put(EventsConstants.HANSEL_EXPERIMENT_VARIANT, MSharedPreferencesUtils.getStringPref(Constant.HANSEL_EXPERIMENT_VARIANT_PREF, "", false));
            hashMap2.put(HanselEventConstant.PROP_HANSEL_DUMMY_FLAG, Boolean.valueOf(HanselConfigs.getBoolean(HanselEventConstant.KEY_HANSEL_DUMMY_FLAG, false)));
            hashMap2.put("Country Code", MBuildConfigUtils.getCountryCode().toUpperCase());
            Hansel.getUser().setUserId(uniqueIdForThirdPartySDKs);
            Hansel.getUser().putAttribute((String) EventsConstants.APP_VERSION_CODE, String.valueOf(MBuildConfigUtils.getInstalledAppVersionCode()));
            Hansel.getUser().putAttribute((String) EventsConstants.APP_VERSION_NAME, String.valueOf(MBuildConfigUtils.getCurrentAppVersionName()));
            Hansel.getUser().putAttribute((String) EventsConstants.REACT_VERSION, String.valueOf(DBInteractor.getCurrentRNBundleVersionCode()));
            Hansel.getUser().putAttribute((String) EventsConstants.ANDROID_APP_TYPE, MBuildConfigUtils.getAppType());
            Hansel.getUser().putAttribute((String) EventsConstants.IS_USER_PHONE_ROOTED, MSharedPreferencesUtils.isPhoneRooted());
            Hansel.getUser().putAttribute((String) EventsConstants.USER_TIER, MSharedPreferencesUtils.getUserTier());
            Hansel.getUser().putAttribute((String) EventsConstants.USER_MOBILE_NUMBER, uniqueIdForThirdPartySDKs);
            Hansel.getUser().putAttribute(str3, MBuildConfigUtils.getAppType());
            Hansel.getUser().putAttribute((String) HanselEventConstant.PROP_HANSEL_DUMMY_FLAG, HanselConfigs.getBoolean(HanselEventConstant.KEY_HANSEL_DUMMY_FLAG, false));
            Hansel.getUser().putAttribute((String) EventsConstants.PROP_PHONE_MODEL, Build.MODEL);
            Hansel.getUser().putAttribute((String) EventsConstants.PROP_PHONE_MAKE, Build.BRAND);
            Hansel.getUser().putAttribute((String) EventsConstants.PROP_PHONE_OS_VERSION, (double) VERSION.SDK_INT);
            Hansel.getUser().putAttribute((String) EventsConstants.PROP_PHONE_MANUFACTURER, Build.MANUFACTURER);
            Hansel.getUser().putAttribute((String) "Country Code", MBuildConfigUtils.getCountryCode().toUpperCase());
            HashMap<String, Object> deviceMemoryInfo = CommonUtils.getDeviceMemoryInfo();
            if (VERSION.SDK_INT >= 24) {
                Hansel.getUser().putAttribute((String) EventsConstants.PROP_PHONE_TOTAL_RAM, (double) Long.parseLong(String.valueOf(deviceMemoryInfo.getOrDefault(EventsConstants.PROP_PHONE_TOTAL_RAM, Integer.valueOf(0)))));
            } else if (deviceMemoryInfo.get(EventsConstants.PROP_PHONE_TOTAL_RAM) != null) {
                Hansel.getUser().putAttribute((String) EventsConstants.PROP_PHONE_TOTAL_RAM, (double) Long.parseLong(String.valueOf(deviceMemoryInfo.get(EventsConstants.PROP_PHONE_TOTAL_RAM))));
            } else {
                Hansel.getUser().putAttribute((String) EventsConstants.PROP_PHONE_TOTAL_RAM, 0.0d);
            }
            if (VERSION.SDK_INT >= 24) {
                Hansel.getUser().putAttribute((String) EventsConstants.PROP_PHONE_AVAILABLE_RAM, (double) Long.parseLong(String.valueOf(deviceMemoryInfo.getOrDefault(EventsConstants.PROP_PHONE_AVAILABLE_RAM, Integer.valueOf(0)))));
            } else if (deviceMemoryInfo.get(EventsConstants.PROP_PHONE_AVAILABLE_RAM) != null) {
                Hansel.getUser().putAttribute((String) EventsConstants.PROP_PHONE_AVAILABLE_RAM, (double) Long.parseLong(String.valueOf(deviceMemoryInfo.get(EventsConstants.PROP_PHONE_AVAILABLE_RAM))));
            } else {
                Hansel.getUser().putAttribute((String) EventsConstants.PROP_PHONE_AVAILABLE_RAM, 0.0d);
            }
            str = str2;
            try {
                MLogger.d(str, obj, uniqueIdForThirdPartySDKs);
            } catch (Exception e4) {
                e = e4;
            }
        } catch (Exception e5) {
            e = e5;
            obj = "pushProfileEvent: ";
            str = TAG;
            MLogger.e(str, obj, e);
            MPLApplication.getMplAnalytics().pushProfileEventV2(hashMap2);
        }
        MPLApplication.getMplAnalytics().pushProfileEventV2(hashMap2);
    }

    public static void saveHanselExperienceData() {
        String str;
        StringBuilder sb = new StringBuilder();
        HashMap<String, String> interactionMaps = Hansel.getInteractionMaps();
        if (interactionMaps == null || interactionMaps.size() <= 0) {
            str = "";
        } else {
            for (String append : interactionMaps.keySet()) {
                sb.append(append);
                sb.append(",");
            }
            str = sb.toString();
            if (str != null && str.length() > 0 && str.endsWith(",")) {
                str = str.substring(0, str.length() - 1);
            }
        }
        ConfigManager.setHanselExperience(str);
        MLogger.d("Hansel", "saveHanselExperienceData: ", str);
    }

    public static void saveHanselExperienceVariantData() {
        String str;
        StringBuilder sb = new StringBuilder();
        HashMap<String, String> interactionMaps = Hansel.getInteractionMaps();
        if (interactionMaps == null || interactionMaps.size() <= 0) {
            str = "";
        } else {
            for (String append : interactionMaps.values()) {
                sb.append(append);
                sb.append(",");
            }
            str = sb.toString();
            if (str != null && str.length() > 0 && str.endsWith(",")) {
                str = str.substring(0, str.length() - 1);
            }
        }
        ConfigManager.setHanselExperienceVariantData(str);
        MLogger.d("Hansel", "saveHanselExperienceVariantData: ", str);
    }

    public static void saveRandomString(Context context) {
        MSharedPreferencesUtils.saveStringInNormalPref(context, "random_session_string", Util.getRandomSessionString());
    }

    public static void sendAppsFlyerEvent(Context context, String str, HashMap<String, Object> hashMap) {
        HashMap<String, Object> hashMap2;
        Context context2 = context;
        String str2 = str;
        MLogger.d(Constant.APPS_FLYER_TAG, "sendAppsFlyerEvent: ", str2);
        if (hashMap == null) {
            try {
                hashMap2 = new HashMap<>();
            } catch (Exception e2) {
                MLogger.e(TAG, "sendAppsFlyerEvent: ", e2);
            }
        } else {
            hashMap2 = hashMap;
        }
        if (str2.equalsIgnoreCase(EventsConstants.EVENT_ROUND_STARTED)) {
            if (hashMap2.containsKey("Point Value")) {
                String str3 = (String) hashMap2.get("Point Value");
                double d2 = 0.0d;
                if (str3 != null) {
                    d2 = Double.parseDouble(str3);
                }
                if (d2 > 0.2d && d2 <= 0.75d) {
                    sendEventsToAppsFlyer(context2, "af_rummy_midroller", hashMap2);
                } else if (d2 > 0.75d) {
                    sendEventsToAppsFlyer(context2, "af_rummy_highroller", hashMap2);
                }
            }
            sendEventsToAppsFlyer(context2, "af_rummy_played", hashMap2);
        } else if (str2.equalsIgnoreCase(EventsConstants.EVENT_GAME_PLAY_INITIATED) || str2.equalsIgnoreCase(EventsConstants.USER_TEAM_REGISTRATION_SUCCESS)) {
            int increaseAndGetRegistrationEvent = MSharedPreferencesUtils.increaseAndGetRegistrationEvent(context);
            hashMap2.put("registrationCount", Integer.valueOf(increaseAndGetRegistrationEvent));
            sendEventsToAppsFlyer(context2, str2, hashMap2);
            MLogger.d(TAG, "sendAppsFlyerEvent: registration count: ", Integer.valueOf(increaseAndGetRegistrationEvent));
            if (increaseAndGetRegistrationEvent == 1) {
                sendEventsToAppsFlyer(context2, "af_active1", hashMap2);
            } else if (increaseAndGetRegistrationEvent != 3) {
                sendEventsToAppsFlyer(context2, "af_active", hashMap2);
            } else {
                sendEventsToAppsFlyer(context2, "af_active3", hashMap2);
            }
        }
        if (EventsConstants.EVENT_APP_SCREEN_VIEWED.equalsIgnoreCase(str2)) {
            if (hashMap2.containsKey("Screen Name") && "Login".equalsIgnoreCase((String) hashMap2.get("Screen Name"))) {
                hashMap2.put(AFInAppEventParameterName.CONTENT_TYPE, (String) hashMap2.get("Screen Name"));
                hashMap2.put("fb_content_type", (String) hashMap2.get("Screen Name"));
                sendEventsToAppsFlyer(context2, "af_registration_step1", hashMap2);
                pushFacebookEventWithProp("Subscribe", hashMap2);
            }
        }
        if (EventsConstants.POP_UP_SHOWN.equalsIgnoreCase(str2)) {
            if (hashMap2.containsKey(EventsConstants.POP_UP_NAME) && "important_terms".equalsIgnoreCase((String) hashMap2.get(EventsConstants.POP_UP_NAME))) {
                hashMap2.put(AFInAppEventParameterName.CONTENT_TYPE, (String) hashMap2.get(EventsConstants.POP_UP_NAME));
                hashMap2.put("fb_content_type", (String) hashMap2.get(EventsConstants.POP_UP_NAME));
                sendEventsToAppsFlyer(context2, "af_registration_step2", hashMap2);
                pushFacebookEventWithProp("SubmitApplication", hashMap2);
            }
        } else if (EventsConstants.EVENT_LOGIN_IN_SUCCESS.equalsIgnoreCase(str2)) {
            if (hashMap2.containsKey("Is New User") && String.valueOf(hashMap2.get("Is New User")).equalsIgnoreCase(BaseParser.TRUE)) {
                hashMap2.put(AFInAppEventParameterName.CONTENT_TYPE, String.valueOf(hashMap2.get("Login Method")));
                hashMap2.put("fb_content_type", String.valueOf(hashMap2.get("Login Method")));
                hashMap2.put(AFInAppEventParameterName.CONTENT, String.valueOf(hashMap2.get("Is WTM Registered")));
                hashMap2.put("fb_content", String.valueOf(hashMap2.get("Is WTM Registered")));
                hashMap2.put(AFInAppEventParameterName.REGSITRATION_METHOD, "OTP");
                hashMap2.put("fb_registration_method", "OTP");
                sendEventsToAppsFlyer(context2, AFInAppEventType.LOGIN, hashMap2);
                sendEventsToAppsFlyer(context2, AFInAppEventType.COMPLETE_REGISTRATION, hashMap2);
                pushFacebookEventWithProp("fb_mobile_complete_registration", hashMap2);
                if (hashMap2.containsKey("Is Referral") && String.valueOf(hashMap2.get("Is Referral")).equalsIgnoreCase(BaseParser.TRUE)) {
                    sendEventsToAppsFlyer(context2, "af_referral_login", hashMap2);
                }
            }
            if (MSharedPreferencesUtils.isUserCameFromReferral(context)) {
                sendEventsToAppsFlyer(context2, "af_user_got_referred", hashMap2);
                MSharedPreferencesUtils.saveUserCameFromReferral(context2, false);
            }
        } else if ("Game Changed".equalsIgnoreCase(str2)) {
            if (hashMap2.containsKey("Game Name")) {
                String valueOf = String.valueOf(hashMap2.get("Game Name"));
                hashMap2.put(AFInAppEventParameterName.CONTENT, valueOf);
                hashMap2.put("fb_content", valueOf);
                hashMap2.put(AFInAppEventParameterName.CONTENT_TYPE, String.valueOf(hashMap2.get("Game Position")));
                hashMap2.put("fb_content_type", String.valueOf(hashMap2.get("Game Position")));
                sendEventsToAppsFlyer(context2, "af_gameSelectClick_" + valueOf, hashMap2);
                pushFacebookEventWithProp("gameSelectClick_" + valueOf, hashMap2);
                pushFacebookEventWithProp("fb_mobile_rate", hashMap2);
            }
        } else if (EventsConstants.RANKED_FETCHED.equalsIgnoreCase(str2)) {
            int totalUserPlayedGame = VideoRecordingUtils.getTotalUserPlayedGame(context);
            if (hashMap2.containsKey("Game Name")) {
                hashMap2.put(AFInAppEventParameterName.CONTENT, String.valueOf(hashMap2.get("Game Name")));
                hashMap2.put("fb_content", String.valueOf(hashMap2.get("Game Name")));
            }
            if (hashMap2.containsKey("Tournament ID")) {
                hashMap2.put(AFInAppEventParameterName.CONTENT_ID, String.valueOf(hashMap2.get("Tournament ID")));
                hashMap2.put("fb_content_id", String.valueOf(hashMap2.get("Tournament ID")));
            }
            hashMap2.put("Game Played Count", Integer.valueOf(totalUserPlayedGame));
            if (hashMap2.containsKey(EventsConstants.USER_TIER)) {
                hashMap2.put(AFInAppEventParameterName.LEVEL, hashMap2.get(EventsConstants.USER_TIER));
                hashMap2.put("fb_level", hashMap2.get(EventsConstants.USER_TIER));
            }
            sendEventsToAppsFlyer(context2, "af_gamePlayed", hashMap2);
            sendEventsToAppsFlyer(context2, AFInAppEventType.CONTENT_VIEW, hashMap2);
            pushFacebookEventWithProp("fb_mobile_content_view", hashMap2);
            MLogger.d(Constant.APPS_FLYER_TAG, "sendAppsFlyerEvent: playedGame ", Integer.valueOf(totalUserPlayedGame));
            if (totalUserPlayedGame == 1) {
                boolean booleanInNormalPref = MSharedPreferencesUtils.getBooleanInNormalPref(context2, Constant.IS_NEW_USER, false);
                MLogger.d(Constant.APPS_FLYER_TAG, "sendAppsFlyerEvent: isNewUser ", Boolean.valueOf(booleanInNormalPref));
                if (booleanInNormalPref) {
                    sendEventsToAppsFlyer(context2, AFInAppEventType.TUTORIAL_COMPLETION, hashMap2);
                    sendEventsToAppsFlyer(context2, "af_gamePlayed_First", hashMap2);
                    pushFacebookEventWithProp("fb_mobile_tutorial_completion", hashMap2);
                    MSharedPreferencesUtils.saveBooleanInNormalPref(context2, Constant.IS_NEW_USER, false);
                }
            } else if (totalUserPlayedGame == 3) {
                sendEventsToAppsFlyer(context2, "af_gamePlayed_threeTimes", hashMap2);
                pushFacebookEventWithProp("fb_mobile_level_achieved", hashMap2);
            }
        } else {
            boolean equalsIgnoreCase = "Battle Room Selected".equalsIgnoreCase(str2);
            Object obj = EventsConstants.USER_TIER;
            if (equalsIgnoreCase) {
                if (hashMap2.containsKey("Game Name")) {
                    hashMap2.put(AFInAppEventParameterName.CONTENT, String.valueOf(hashMap2.get("Game Name")));
                    hashMap2.put("fb_content", String.valueOf(hashMap2.get("Game Name")));
                }
                if (hashMap2.containsKey("Tournament ID")) {
                    hashMap2.put(AFInAppEventParameterName.CONTENT_ID, String.valueOf(hashMap2.get("Tournament ID")));
                    hashMap2.put("fb_content_id", String.valueOf(hashMap2.get("Tournament ID")));
                }
                if (hashMap2.containsKey("Game Name")) {
                    sendEventsToAppsFlyer(context2, "af_" + hashMap2.get("Game Name") + "_battle", hashMap2);
                    pushFacebookEventWithProp(str2, hashMap2);
                    pushFacebookEventWithProp("AdClick", hashMap2);
                }
            } else if ("Tournament Selected".equalsIgnoreCase(str2)) {
                if (hashMap2.containsKey("Game Name")) {
                    hashMap2.put(AFInAppEventParameterName.CONTENT, String.valueOf(hashMap2.get("Game Name")));
                    hashMap2.put("fb_content", String.valueOf(hashMap2.get("Game Name")));
                }
                if (hashMap2.containsKey("Tournament ID")) {
                    hashMap2.put(AFInAppEventParameterName.CONTENT_ID, String.valueOf(hashMap2.get("Tournament ID")));
                    hashMap2.put("fb_content_id", String.valueOf(hashMap2.get("Tournament ID")));
                }
                if (hashMap2.containsKey("Game Name")) {
                    sendEventsToAppsFlyer(context2, "af_" + hashMap2.get("Game Name") + "_tournament", hashMap2);
                    pushFacebookEventWithProp(str2, hashMap2);
                    pushFacebookEventWithProp("AdImpression", hashMap2);
                }
            } else {
                boolean equalsIgnoreCase2 = EventsConstants.USER_TOURNAMENT_REGISTRATION_SUCCESS.equalsIgnoreCase(str2);
                String str4 = Constant.APPS_FLYER_TAG;
                Object obj2 = AFInAppEventParameterName.CONTENT_TYPE;
                if (equalsIgnoreCase2) {
                    if (hashMap2.containsKey("Game Name")) {
                        hashMap2.put(AFInAppEventParameterName.CONTENT, String.valueOf(hashMap2.get("Game Name")));
                        hashMap2.put("fb_content", String.valueOf(hashMap2.get("Game Name")));
                    }
                    if (hashMap2.containsKey("Tournament ID")) {
                        hashMap2.put(AFInAppEventParameterName.CONTENT_ID, String.valueOf(hashMap2.get("Tournament ID")));
                        hashMap2.put("fb_content_id", String.valueOf(hashMap2.get("Tournament ID")));
                    }
                    if (hashMap2.containsKey(CtNativeLaunchInitiated.PROPERTY_CURRENCY) && ("TOKEN".equalsIgnoreCase(String.valueOf(hashMap2.get(CtNativeLaunchInitiated.PROPERTY_CURRENCY))) || "CASH".equalsIgnoreCase(String.valueOf(hashMap2.get(CtNativeLaunchInitiated.PROPERTY_CURRENCY))))) {
                        String valueOf2 = String.valueOf(hashMap2.get(CtNativeLaunchInitiated.PROPERTY_CURRENCY));
                        String valueOf3 = String.valueOf(hashMap2.get("Game Name"));
                        hashMap2.put(AFInAppEventParameterName.CONTENT, valueOf2);
                        hashMap2.put("fb_content", valueOf2);
                        if ("TOKEN".equalsIgnoreCase(valueOf2)) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("af_");
                            if (TextUtils.isEmpty(valueOf3)) {
                                valueOf3 = "";
                            }
                            sb.append(valueOf3);
                            sb.append("_tokensPaid");
                            sendEventsToAppsFlyer(context2, sb.toString(), hashMap2);
                        } else {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("af_");
                            if (TextUtils.isEmpty(valueOf3)) {
                                valueOf3 = "";
                            }
                            sb2.append(valueOf3);
                            sb2.append("_cashPaid");
                            sendEventsToAppsFlyer(context2, sb2.toString(), hashMap2);
                            sendEventsToAppsFlyer(context2, "af_cpdau_all", hashMap2);
                            hashMap2.put("gmv_amount", String.valueOf(hashMap2.get("Entry Fee")));
                            boolean booleanValue = MSharedPreferencesUtils.getAppsFlyerBooleanInNormalPref(Constant.APPSFLYER_IS_NEW_USER, false).booleanValue();
                            if ((FlagGames == 1 || FlagAll == 1) && booleanValue) {
                                sendEventsToAppsFlyer(context2, "All_CPDAU_Games", hashMap2);
                                sendEventsToAppsFlyer(context2, "new_CPDAU_games", hashMap2);
                                FlagGames++;
                                sendEventsToAppsFlyer(context2, "new_CPDAU_all", hashMap2);
                                FlagAll++;
                                MSharedPreferencesUtils.setAppsFlyerBooleanInNormalPref(Boolean.FALSE);
                            } else {
                                sendEventsToAppsFlyer(context2, "All_CPDAU_Games", hashMap2);
                            }
                        }
                    }
                    pushFacebookEventWithProp("Tournament Registration", hashMap2);
                    pushFacebookEventWithProp("FindLocation", hashMap2);
                } else if ("Add Money Initiated".equalsIgnoreCase(str2)) {
                    sendEventsToAppsFlyer(context2, "af_add_money_initiated", hashMap2);
                    pushFacebookEventWithProp("Search", hashMap2);
                } else if (!EventsConstants.MONEY_IN_EVENT.equalsIgnoreCase(str2)) {
                    Object obj3 = obj2;
                    if (EventsConstants.MONEY_OUT_EVENT.equalsIgnoreCase(str2)) {
                        if (hashMap2.containsKey("Withdraw Method")) {
                            hashMap2.put("fb_content_type", hashMap2.get("Withdraw Method"));
                            hashMap2.put(obj3, hashMap2.get("Withdraw Method"));
                        }
                        if (hashMap2.containsKey("Amount")) {
                            int parseInt = Integer.parseInt(String.valueOf(hashMap2.get("Amount")));
                            MLogger.d(str4, "sendAppsFlyerEvent:amount ", Integer.valueOf(parseInt));
                            int i = parseInt * -1;
                            hashMap2.put("_valueToSum", Integer.valueOf(i));
                            hashMap2.put(AFInAppEventParameterName.REVENUE, Integer.valueOf(i));
                            hashMap2.put(AFInAppEventParameterName.CURRENCY, MBuildConfigUtils.getCurrencyCode());
                        }
                        Object obj4 = obj;
                        if (hashMap2.containsKey(obj4)) {
                            hashMap2.put("fb_content_id", hashMap2.get(obj4));
                            hashMap2.put(AFInAppEventParameterName.CONTENT_ID, hashMap2.get(obj4));
                        }
                        sendEventsToAppsFlyer(context2, "af_withdrawal", hashMap2);
                        pushFacebookEventWithProp("fb_mobile_spent_credits", hashMap2);
                    } else if (EventsConstants.USER_BATTLE_REGISTRATION_SUCCESS.equalsIgnoreCase(str2)) {
                        if (hashMap2.containsKey(CtNativeLaunchInitiated.PROPERTY_CURRENCY) && ((String) hashMap2.get(CtNativeLaunchInitiated.PROPERTY_CURRENCY)).equalsIgnoreCase("CASH")) {
                            sendEventsToAppsFlyer(context2, "af_cpdau_battle", hashMap2);
                            sendEventsToAppsFlyer(context2, "af_cpdau_all", hashMap2);
                            hashMap2.put("gmv_amount", String.valueOf(hashMap2.get("Entry Fee")));
                            boolean booleanValue2 = MSharedPreferencesUtils.getAppsFlyerBooleanInNormalPref(Constant.APPSFLYER_IS_NEW_USER, false).booleanValue();
                            if ((FlagGames == 1 || FlagAll == 1) && booleanValue2) {
                                sendEventsToAppsFlyer(context2, "All_CPDAU_Games", hashMap2);
                                sendEventsToAppsFlyer(context2, "new_CPDAU_games", hashMap2);
                                FlagGames++;
                                sendEventsToAppsFlyer(context2, "new_CPDAU_all", hashMap2);
                                FlagAll++;
                                MSharedPreferencesUtils.setAppsFlyerBooleanInNormalPref(Boolean.FALSE);
                            } else {
                                sendEventsToAppsFlyer(context2, "All_CPDAU_Games", hashMap2);
                            }
                        }
                    } else if ("Share Initiated".equalsIgnoreCase(str2)) {
                        sendEventsToAppsFlyer(context2, "af_share_initiated", hashMap2);
                        pushFacebookEventWithProp(Contact.TAG, hashMap2);
                    } else if (EventsConstants.USER_TEAM_REGISTRATION_SUCCESS.equalsIgnoreCase(str2)) {
                        sendEventsToAppsFlyer(context2, "af_team_reg_success", hashMap2);
                        hashMap2.put("gmv_amount", String.valueOf(hashMap2.get("Entry Fee")));
                        boolean booleanValue3 = MSharedPreferencesUtils.getAppsFlyerBooleanInNormalPref(Constant.APPSFLYER_IS_NEW_USER, false).booleanValue();
                        if ((FlagFantasy == 1 || FlagAll == 1) && booleanValue3) {
                            sendEventsToAppsFlyer(context2, "All_CPDAU_Fantasy", hashMap2);
                            sendEventsToAppsFlyer(context2, "new_CPDAU_Fantasy", hashMap2);
                            FlagFantasy++;
                            sendEventsToAppsFlyer(context2, "new_CPDAU_all", hashMap2);
                            FlagAll++;
                            MSharedPreferencesUtils.setAppsFlyerBooleanInNormalPref(Boolean.FALSE);
                        } else {
                            sendEventsToAppsFlyer(context2, "All_CPDAU_Fantasy", hashMap2);
                        }
                        pushFacebookEventWithProp("Schedule", hashMap2);
                        if (hashMap2.containsKey(CtNativeLaunchInitiated.PROPERTY_CURRENCY) && !TextUtils.isEmpty(String.valueOf(hashMap2.get(CtNativeLaunchInitiated.PROPERTY_CURRENCY))) && "CASH".equalsIgnoreCase(String.valueOf(hashMap2.get(CtNativeLaunchInitiated.PROPERTY_CURRENCY)))) {
                            sendEventsToAppsFlyer(context2, "af_team_reg_success_cash", hashMap2);
                        }
                    } else {
                        sendEventsToAppsFlyer(context2, str2, hashMap2);
                    }
                } else if (!hashMap2.containsKey("Is Success") || !BaseParser.FALSE.equalsIgnoreCase(hashMap2.get("Is Success").toString())) {
                    if (hashMap2.containsKey("Amount")) {
                        int parseInt2 = Integer.parseInt(String.valueOf(hashMap2.get("Amount")));
                        hashMap2.put("_valueToSum", Integer.valueOf(parseInt2));
                        hashMap2.put(AFInAppEventParameterName.REVENUE, Integer.valueOf(parseInt2));
                    }
                    if (hashMap2.containsKey("Deposit Method")) {
                        hashMap2.put("fb_content_type", hashMap2.get("Deposit Method"));
                        hashMap2.put(obj2, hashMap2.get("Deposit Method"));
                    }
                    hashMap2.put("fb_currency", MBuildConfigUtils.getCurrencyCode());
                    hashMap2.put(AFInAppEventParameterName.CURRENCY, MBuildConfigUtils.getCurrencyCode());
                    sendEventsToAppsFlyer(context2, "af_purchase_all", hashMap2);
                    pushFacebookEventWithProp("Add Payment Info", hashMap2);
                    sendMoneyInEventToCleverTap(hashMap2);
                    int increaseAndGetMoneyEvent = MSharedPreferencesUtils.increaseAndGetMoneyEvent(context);
                    if (increaseAndGetMoneyEvent == 1) {
                        hashMap2.put("First Time", Boolean.TRUE);
                        sendEventsToAppsFlyer(context2, AFInAppEventType.PURCHASE, hashMap2);
                        sendEventsToAppsFlyer(context2, EventsConstants.MONEY_IN_EVENT, hashMap2);
                        pushFacebookEventWithProp("fb_mobile_initiated_checkout", hashMap2);
                    } else if (increaseAndGetMoneyEvent == 3) {
                        hashMap2.put("First Time", Boolean.FALSE);
                        sendEventsToAppsFlyer(context2, "af_purchase_thirdTime", hashMap2);
                        pushFacebookEventWithProp("fb_mobile_add_to_cart", hashMap2);
                    } else if (increaseAndGetMoneyEvent != 5) {
                        hashMap2.put("First Time", Boolean.FALSE);
                        sendEventsToAppsFlyer(context2, EventsConstants.MONEY_IN_EVENT, hashMap2);
                    } else {
                        hashMap2.put("First Time", Boolean.FALSE);
                        sendEventsToAppsFlyer(context2, "af_purchase_fifthTime", hashMap2);
                        pushFacebookEventWithProp("fb_mobile_add_to_wishlist", hashMap2);
                    }
                }
            }
        }
    }

    public static void sendClevertapIDToFirebase() {
        if (MPLApplication.getMplAnalytics() != null && !TextUtils.isEmpty(MPLApplication.getMplAnalytics().getCleverTapId())) {
            setFireBaseUserProperty("ct_objectId", MPLApplication.getMplAnalytics().getCleverTapId());
        }
    }

    public static void sendEvent(String str, String str2) {
        try {
            sendEvent(str, Util.jsonToMap(new JSONObject(str2)));
        } catch (Exception e2) {
            MLogger.e(TAG, "sendEvent: ", e2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00aa  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void sendEventFromGame(java.lang.String r8, java.lang.String r9, java.lang.String r10, boolean r11, boolean r12) {
        /*
            java.lang.String r0 = "IsKafkaEnabled"
            java.lang.String r1 = "sendEventFromGame:3 "
            r2 = 3
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r3 = "sendEventFromGame:1 "
            r4 = 0
            r2[r4] = r3
            r3 = 1
            r2[r3] = r8
            r5 = 2
            r2[r5] = r9
            java.lang.String r6 = "CleverTapAnalyticsUtils"
            com.mpl.androidapp.utils.MLogger.d(r6, r2)
            r2 = 0
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ Exception -> 0x007a }
            r7.<init>(r9)     // Catch:{ Exception -> 0x007a }
            java.lang.String r9 = "App Version Code"
            int r2 = com.mpl.androidapp.utils.MBuildConfigUtils.getInstalledAppVersionCode()     // Catch:{ Exception -> 0x0075, all -> 0x0072 }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x0075, all -> 0x0072 }
            r7.put(r9, r2)     // Catch:{ Exception -> 0x0075, all -> 0x0072 }
            java.lang.String r9 = "App Version Name"
            java.lang.String r2 = com.mpl.androidapp.utils.MBuildConfigUtils.getCurrentAppVersionName()     // Catch:{ Exception -> 0x0075, all -> 0x0072 }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x0075, all -> 0x0072 }
            r7.put(r9, r2)     // Catch:{ Exception -> 0x0075, all -> 0x0072 }
            java.lang.String r9 = "App Type"
            java.lang.String r2 = com.mpl.androidapp.utils.MBuildConfigUtils.getAppType()     // Catch:{ Exception -> 0x0075, all -> 0x0072 }
            r7.put(r9, r2)     // Catch:{ Exception -> 0x0075, all -> 0x0072 }
            java.lang.String r9 = "Is Game Event"
            java.lang.String r2 = java.lang.String.valueOf(r3)     // Catch:{ Exception -> 0x0075, all -> 0x0072 }
            r7.put(r9, r2)     // Catch:{ Exception -> 0x0075, all -> 0x0072 }
            java.lang.String r9 = "Is Internal User"
            r7.put(r9, r12)     // Catch:{ Exception -> 0x0075, all -> 0x0072 }
            boolean r9 = r7.has(r0)     // Catch:{ Exception -> 0x0075, all -> 0x0072 }
            if (r9 != 0) goto L_0x0057
            r7.put(r0, r11)     // Catch:{ Exception -> 0x0075, all -> 0x0072 }
        L_0x0057:
            com.mpl.androidapp.utils.CountryUtils.setCountryCodeForUnity(r10)     // Catch:{ Exception -> 0x0075, all -> 0x0072 }
            java.util.HashMap r9 = com.mpl.androidapp.utils.Util.jsonToMap(r7)     // Catch:{ JSONException -> 0x0062 }
            push(r8, r9, r3)     // Catch:{ JSONException -> 0x0062 }
            goto L_0x00a7
        L_0x0062:
            r9 = move-exception
            java.lang.Object[] r10 = new java.lang.Object[r5]
            r10[r4] = r1
            r10[r3] = r9
            com.mpl.androidapp.utils.MLogger.e(r6, r10)
            java.util.HashMap r9 = new java.util.HashMap
            r9.<init>()
            goto L_0x00a4
        L_0x0072:
            r9 = move-exception
            r2 = r7
            goto L_0x00a8
        L_0x0075:
            r9 = move-exception
            r2 = r7
            goto L_0x007b
        L_0x0078:
            r9 = move-exception
            goto L_0x00a8
        L_0x007a:
            r9 = move-exception
        L_0x007b:
            java.lang.Object[] r10 = new java.lang.Object[r5]     // Catch:{ all -> 0x0078 }
            java.lang.String r11 = "sendEventFromGame:2 "
            r10[r4] = r11     // Catch:{ all -> 0x0078 }
            r10[r3] = r9     // Catch:{ all -> 0x0078 }
            com.mpl.androidapp.utils.MLogger.e(r6, r10)     // Catch:{ all -> 0x0078 }
            if (r2 != 0) goto L_0x008d
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
        L_0x008d:
            java.util.HashMap r9 = com.mpl.androidapp.utils.Util.jsonToMap(r2)     // Catch:{ JSONException -> 0x0095 }
            push(r8, r9, r3)     // Catch:{ JSONException -> 0x0095 }
            goto L_0x00a7
        L_0x0095:
            r9 = move-exception
            java.lang.Object[] r10 = new java.lang.Object[r5]
            r10[r4] = r1
            r10[r3] = r9
            com.mpl.androidapp.utils.MLogger.e(r6, r10)
            java.util.HashMap r9 = new java.util.HashMap
            r9.<init>()
        L_0x00a4:
            push(r8, r9, r3)
        L_0x00a7:
            return
        L_0x00a8:
            if (r2 != 0) goto L_0x00af
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
        L_0x00af:
            java.util.HashMap r10 = com.mpl.androidapp.utils.Util.jsonToMap(r2)     // Catch:{ JSONException -> 0x00b7 }
            push(r8, r10, r3)     // Catch:{ JSONException -> 0x00b7 }
            goto L_0x00c9
        L_0x00b7:
            r10 = move-exception
            java.lang.Object[] r11 = new java.lang.Object[r5]
            r11[r4] = r1
            r11[r3] = r10
            com.mpl.androidapp.utils.MLogger.e(r6, r11)
            java.util.HashMap r10 = new java.util.HashMap
            r10.<init>()
            push(r8, r10, r3)
        L_0x00c9:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.utils.CleverTapAnalyticsUtils.sendEventFromGame(java.lang.String, java.lang.String, java.lang.String, boolean, boolean):void");
    }

    public static void sendEventThroughSecondaryCTAccount(String str, HashMap<String, Object> hashMap) {
    }

    public static void sendEventToKafka(String str, HashMap<String, Object> hashMap) {
        hashMap.putAll(commonPropertiesForEvents(false));
        if (!hashMap.containsKey("Is New User")) {
            hashMap.put("Is New User", Boolean.valueOf(MSharedPreferencesUtils.isNewUser()));
        }
        hashMap.put("First Session", MSharedPreferencesUtils.getStringInNormalPref(MPLApplication.getInstance(), Constant.IS_FIRST_LAUNCH_INSTRUMENTAION, BaseParser.TRUE));
        ExternalAnalytics.INSTANCE.sendKafkaEvent(str, hashMap);
    }

    public static void sendEventsToAppsFlyer(Context context, String str, HashMap<String, Object> hashMap) {
        if (hashMap == null) {
            try {
                hashMap = new HashMap<>();
            } catch (Exception unused) {
                return;
            }
        }
        MLogger.d("AppsFlyerEvents", "sendEventsToAppsFlyer: ", str);
        hashMap.put(AFInAppEventParameterName.DESCRIPTION, MBuildConfigUtils.getApplicationId());
        MLogger.d("AppsFlyerEvents", "mAppsflyerEventFilteringEnabled: ", Boolean.valueOf(AppsflyerUtils.mAppsflyerEventFilteringEnabled));
        MLogger.d("AppsFlyerEvents", "mAppsflyerWhitelistedEvents: ", Integer.valueOf(AppsflyerUtils.mAppsflyerWhitelistedEvents.size()));
        if (!AppsflyerUtils.mAppsflyerEventFilteringEnabled || AppsflyerUtils.mAppsflyerWhitelistedEvents == null || AppsflyerUtils.mAppsflyerWhitelistedEvents.size() <= 0) {
            AppsFlyerLib.getInstance().logEvent(context, str, hashMap);
        } else {
            MLogger.d("AppsFlyerEvents", "sendEventsToAppsFlyer: ", "checking events filter");
            if (AppsflyerUtils.mAppsflyerWhitelistedEvents.contains(str.toLowerCase())) {
                MLogger.d("AppsFlyerEvents", "sendEventsToAppsFlyer: ", str + " event exist in whitelist");
                AppsFlyerLib.getInstance().logEvent(context, str, hashMap);
            }
        }
        pushFireBaseEvents(str);
    }

    public static void sendGMVEvent(Context context, String str, HashMap<String, Object> hashMap) {
        String str2;
        Context context2 = context;
        String str3 = str;
        HashMap<String, Object> hashMap2 = hashMap;
        HashMap hashMap3 = new HashMap();
        Object obj = "Cash Price";
        if (str3.equalsIgnoreCase(EventsConstants.USER_TOURNAMENT_REGISTRATION_SUCCESS) && hashMap2.containsKey(CtNativeLaunchInitiated.PROPERTY_CURRENCY) && hashMap2.get(CtNativeLaunchInitiated.PROPERTY_CURRENCY) != null && "CASH".equalsIgnoreCase(String.valueOf(hashMap2.get(CtNativeLaunchInitiated.PROPERTY_CURRENCY)))) {
            hashMap3.put("Business Name", "Games");
            hashMap3.put("Category Name", "Tournaments");
            try {
                hashMap3.put("GMV", Double.valueOf(Double.parseDouble(String.valueOf(hashMap2.get("Entry Fee")))));
            } catch (Exception unused) {
                hashMap3.put("GMV", String.valueOf(hashMap2.get("Entry Fee")));
            }
            hashMap3.put(AFInAppEventParameterName.REVENUE, hashMap2.get("Entry Fee"));
            hashMap3.put(AFInAppEventParameterName.CURRENCY, MBuildConfigUtils.getCurrencyCode());
            sendEventsToAppsFlyer(context2, "GMV Generated", hashMap3);
            sendEventsToAppsFlyer(context2, "CPDAU-Games", hashMap3);
            hashMap3.putAll(commonPropertiesForEvents(false));
            MPLApplication.getMplAnalytics().pushEventV2("GMV Generated", hashMap3);
            MPLApplication.getMplAnalytics().pushEventV2("CPDAU-Games", hashMap3);
            sendEventThroughSecondaryCTAccount("GMV Generated", hashMap3);
            sendEventThroughSecondaryCTAccount("CPDAU-Games", hashMap3);
        } else if (str3.equalsIgnoreCase(EventsConstants.USER_BATTLE_STARTED) && hashMap2.containsKey("Is Success") && Boolean.parseBoolean(String.valueOf(hashMap2.get("Is Success"))) && hashMap2.containsKey(CtNativeLaunchInitiated.PROPERTY_CURRENCY) && hashMap2.get(CtNativeLaunchInitiated.PROPERTY_CURRENCY) != null && "CASH".equalsIgnoreCase(String.valueOf(hashMap2.get(CtNativeLaunchInitiated.PROPERTY_CURRENCY)))) {
            hashMap3.put("Business Name", "Games");
            hashMap3.put("Category Name", "Battles");
            try {
                hashMap3.put("GMV", Double.valueOf(Double.parseDouble(String.valueOf(hashMap2.get("Entry Fee")))));
            } catch (Exception unused2) {
                hashMap3.put("GMV", String.valueOf(hashMap2.get("Entry Fee")));
            }
            hashMap3.put(AFInAppEventParameterName.REVENUE, hashMap2.get("Entry Fee"));
            hashMap3.put(AFInAppEventParameterName.CURRENCY, MBuildConfigUtils.getCurrencyCode());
            sendEventsToAppsFlyer(context2, "GMV Generated", hashMap3);
            hashMap3.putAll(commonPropertiesForEvents(false));
            MPLApplication.getMplAnalytics().pushEventV2("GMV Generated", hashMap3);
            sendEventThroughSecondaryCTAccount("GMV Generated", hashMap3);
        } else if (str3.equalsIgnoreCase(EventsConstants.USER_TEAM_REGISTRATION_SUCCESS) && hashMap2.containsKey(CtNativeLaunchInitiated.PROPERTY_CURRENCY) && hashMap2.get(CtNativeLaunchInitiated.PROPERTY_CURRENCY) != null && "CASH".equalsIgnoreCase(String.valueOf(hashMap2.get(CtNativeLaunchInitiated.PROPERTY_CURRENCY)))) {
            hashMap3.put("Business Name", "Fantasy");
            hashMap3.put("Category Name", "Contest");
            try {
                hashMap3.put("GMV", Double.valueOf(Double.parseDouble(String.valueOf(hashMap2.get("Entry Fee")))));
            } catch (Exception unused3) {
                hashMap3.put("GMV", String.valueOf(hashMap2.get("Entry Fee")));
            }
            hashMap3.put(AFInAppEventParameterName.REVENUE, hashMap2.get("Entry Fee"));
            hashMap3.put(AFInAppEventParameterName.CURRENCY, MBuildConfigUtils.getCurrencyCode());
            sendEventsToAppsFlyer(context2, "GMV Generated", hashMap3);
            sendEventsToAppsFlyer(context2, "CPDAU-Fantasy", hashMap3);
            hashMap3.putAll(commonPropertiesForEvents(false));
            MPLApplication.getMplAnalytics().pushEventV2("GMV Generated", hashMap3);
            MPLApplication.getMplAnalytics().pushEventV2("CPDAU-Fantasy", hashMap3);
            sendEventThroughSecondaryCTAccount("GMV Generated", hashMap3);
            sendEventThroughSecondaryCTAccount("CPDAU-Fantasy", hashMap3);
        } else if (str3.equalsIgnoreCase("Auction Played") && hashMap2.containsKey(CtNativeLaunchInitiated.PROPERTY_CURRENCY) && hashMap2.get(CtNativeLaunchInitiated.PROPERTY_CURRENCY) != null && "CASH".equalsIgnoreCase(String.valueOf(hashMap2.get(CtNativeLaunchInitiated.PROPERTY_CURRENCY)))) {
            hashMap3.put("Business Name", "Games");
            hashMap3.put("Category Name", "Auctions");
            try {
                hashMap3.put("GMV", Double.valueOf(Double.parseDouble(String.valueOf(hashMap2.get("Entry Fee")))));
            } catch (Exception unused4) {
                hashMap3.put("GMV", String.valueOf(hashMap2.get("Entry Fee")));
            }
            hashMap3.put(AFInAppEventParameterName.REVENUE, hashMap2.get("Entry Fee"));
            hashMap3.put(AFInAppEventParameterName.CURRENCY, MBuildConfigUtils.getCurrencyCode());
            sendEventsToAppsFlyer(context2, "GMV Generated", hashMap3);
            hashMap3.putAll(commonPropertiesForEvents(false));
            MPLApplication.getMplAnalytics().pushEventV2("GMV Generated", hashMap3);
            sendEventThroughSecondaryCTAccount("GMV Generated", hashMap3);
        } else if (!str3.equalsIgnoreCase("Show Gift Sent") || !hashMap2.containsKey("Cash Gift Amount") || !(hashMap2.get("Cash Gift Amount") instanceof Integer) || ((Integer) hashMap2.get("Cash Gift Amount")).intValue() <= 0) {
            Object obj2 = "Entry Fee";
            if (!str3.equalsIgnoreCase("Round Ended") || !hashMap2.containsKey(CtNativeLaunchInitiated.PROPERTY_GAME_FORMAT) || !hashMap2.containsKey("Is Won")) {
                str2 = "CASH";
            } else {
                str2 = "CASH";
                if (String.valueOf(hashMap2.get("Is Won")).equalsIgnoreCase(BaseParser.FALSE) && hashMap2.get(CtNativeLaunchInitiated.PROPERTY_GAME_FORMAT) != null && String.valueOf(hashMap2.get(CtNativeLaunchInitiated.PROPERTY_GAME_FORMAT)).equalsIgnoreCase("Points Rummy")) {
                    hashMap3.put("Business Name", "Rummy");
                    hashMap3.put("Category Name", "Points Rummy");
                    try {
                        hashMap3.put("GMV", Double.valueOf(Double.parseDouble(String.valueOf(hashMap2.get("Amount")))));
                    } catch (Exception unused5) {
                        hashMap3.put("GMV", String.valueOf(hashMap2.get("Amount")));
                    }
                    hashMap3.put(AFInAppEventParameterName.REVENUE, hashMap2.get("Amount"));
                    hashMap3.put(AFInAppEventParameterName.CURRENCY, MBuildConfigUtils.getCurrencyCode());
                    sendEventsToAppsFlyer(context2, "GMV Generated", hashMap3);
                    hashMap3.putAll(commonPropertiesForEvents(false));
                    MPLApplication.getMplAnalytics().pushEventV2("GMV Generated", hashMap3);
                    sendEventThroughSecondaryCTAccount("GMV Generated", hashMap3);
                    return;
                }
            }
            if (str3.equalsIgnoreCase("Gift Purchased")) {
                hashMap3.put("Business Name", "Rummy");
                hashMap3.put("Category Name", "Gifting");
                Object obj3 = obj;
                try {
                    hashMap3.put("GMV", Double.valueOf(Double.parseDouble(String.valueOf(hashMap2.get(obj3)))));
                } catch (Exception unused6) {
                    hashMap3.put("GMV", String.valueOf(hashMap2.get(obj3)));
                }
                hashMap3.put(AFInAppEventParameterName.REVENUE, hashMap2.get(obj3));
                hashMap3.put(AFInAppEventParameterName.CURRENCY, MBuildConfigUtils.getCurrencyCode());
                sendEventsToAppsFlyer(context2, "GMV Generated", hashMap3);
                hashMap3.putAll(commonPropertiesForEvents(false));
                MPLApplication.getMplAnalytics().pushEventV2("GMV Generated", hashMap3);
                sendEventThroughSecondaryCTAccount("GMV Generated", hashMap3);
            } else if (str3.equalsIgnoreCase("Rummy Registration Success") && hashMap2.containsKey(CtNativeLaunchInitiated.PROPERTY_GAME_FORMAT) && hashMap2.containsKey("Game Name") && String.valueOf(hashMap2.get(CtNativeLaunchInitiated.PROPERTY_GAME_FORMAT)).equalsIgnoreCase("Pool Rummy") && String.valueOf(hashMap2.get("Game Name")).equalsIgnoreCase("Rummy") && hashMap2.containsKey(CtNativeLaunchInitiated.PROPERTY_CURRENCY) && hashMap2.get(CtNativeLaunchInitiated.PROPERTY_CURRENCY) != null) {
                if (str2.equalsIgnoreCase(String.valueOf(hashMap2.get(CtNativeLaunchInitiated.PROPERTY_CURRENCY)))) {
                    hashMap3.put("Business Name", "Rummy");
                    hashMap3.put("Category Name", "Pool Rummy");
                    Object obj4 = obj2;
                    try {
                        hashMap3.put("GMV", Double.valueOf(Double.parseDouble(String.valueOf(hashMap2.get(obj4)))));
                    } catch (Exception unused7) {
                        hashMap3.put("GMV", String.valueOf(hashMap2.get(obj4)));
                    }
                    hashMap3.put(AFInAppEventParameterName.REVENUE, hashMap2.get(obj4));
                    hashMap3.put(AFInAppEventParameterName.CURRENCY, MBuildConfigUtils.getCurrencyCode());
                    sendEventsToAppsFlyer(context2, "GMV Generated", hashMap3);
                    sendEventsToAppsFlyer(context2, "CPDAU-Cards", hashMap3);
                    hashMap3.putAll(commonPropertiesForEvents(false));
                    MPLApplication.getMplAnalytics().pushEventV2("GMV Generated", hashMap3);
                    sendEventThroughSecondaryCTAccount("GMV Generated", hashMap3);
                    MPLApplication.getMplAnalytics().pushEventV2("CPDAU-Cards", hashMap3);
                    sendEventThroughSecondaryCTAccount("CPDAU-Cards", hashMap3);
                }
            }
        } else {
            hashMap3.put("Business Name", "Social");
            hashMap3.put("Category Name", "Audio");
            try {
                hashMap3.put("GMV", Double.valueOf(Double.parseDouble(String.valueOf(hashMap2.get("Cash Gift Amount")))));
            } catch (Exception unused8) {
                hashMap3.put("GMV", String.valueOf(hashMap2.get("Cash Gift Amount")));
            }
            hashMap3.put(AFInAppEventParameterName.REVENUE, hashMap2.get("Cash Gift Amount"));
            hashMap3.put(AFInAppEventParameterName.CURRENCY, MBuildConfigUtils.getCurrencyCode());
            sendEventsToAppsFlyer(context2, "GMV Generated", hashMap3);
            sendEventsToAppsFlyer(context2, "All_CPDAU_audio_shows", hashMap3);
            hashMap3.putAll(commonPropertiesForEvents(false));
            MPLApplication.getMplAnalytics().pushEventV2("GMV Generated", hashMap3);
            sendEventThroughSecondaryCTAccount("GMV Generated", hashMap3);
        }
    }

    public static void sendLocalNotificationClickEvent(JSONObject jSONObject) {
        try {
            sendEvent((String) "Local Notification Clicked", Util.jsonToMap(jSONObject));
        } catch (Exception e2) {
            MLogger.e(TAG, "sendNotificationClickEvent: ", e2);
        }
    }

    public static void sendLocalNotificationDeliverEvent(JSONObject jSONObject) {
        try {
            sendEvent((String) "Local Notification Delivered", Util.jsonToMap(jSONObject));
        } catch (Exception e2) {
            MLogger.e(TAG, "sendNotificationClickEvent: ", e2);
        }
    }

    public static void sendMQTTConnectionEvent(final HashMap<String, Object> hashMap) {
        if (CommonUtils.isInternalUserAPICallDone()) {
            MLogger.d(TAG, "Internal user call already happened");
            sendMQTTEvent(hashMap);
            return;
        }
        MLogger.d(TAG, "Internal user call not happened, Calling now");
        NetworkUtils.isInternalUser(new IResponseListener<String>() {
            public void onResponseFail(Exception exc) {
                CommonUtils.setInternalUser(false);
                CommonUtils.setInternalUserAPICallDone(true);
                CleverTapAnalyticsUtils.sendMQTTEvent(hashMap);
            }

            public void progressResponse(long j, long j2, boolean z) {
            }

            public void onResponseSuccess(String str) {
                JSONObject apiResponse = NetworkUtils.getApiResponse(str);
                boolean z = false;
                if (apiResponse != null && apiResponse.optBoolean("internalUser", false)) {
                    z = true;
                }
                CommonUtils.setInternalUser(z);
                CommonUtils.setInternalUserAPICallDone(true);
                CleverTapAnalyticsUtils.sendMQTTEvent(hashMap);
            }
        });
    }

    public static void sendMQTTEvent(HashMap<String, Object> hashMap) {
        hashMap.putAll(getTimeZoneParams());
        sendEvent((String) "MQTT Connection", hashMap);
    }

    public static void sendMoneyInEventToCleverTap(final HashMap<String, Object> hashMap) {
        if (!MSharedPreferencesUtils.getBooleanInNormalPref(MPLApplication.getInstance(), "moneyInEventSentV2", false)) {
            NetworkUtils.doGetRequest(NetworkUtils.getDefaultNetworkParams(ApiEndPoints.MONEY_IN_FIRST_TIME_CHECK).build(), new IResponseListener<String>() {
                public void onResponseFail(Exception exc) {
                    MLogger.e(IResponseListener.TAG, "onResponseFail:sendMoneyInEventToCleverTap ", exc);
                }

                public void progressResponse(long j, long j2, boolean z) {
                }

                public void onResponseSuccess(String str) {
                    MLogger.d(IResponseListener.TAG, "onResponseSuccess:sendMoneyInEventToCleverTap ", str);
                    JSONObject apiResponse = NetworkUtils.getApiResponse(str);
                    if (apiResponse == null || !apiResponse.optBoolean("userFirstTimeDepositor", false)) {
                        MLogger.d(IResponseListener.TAG, "onResponseSuccess:sendMoneyInEventToCleverTap: Response is not success ");
                    } else {
                        CleverTapAnalyticsUtils.sendEventsToAppsFlyer(MPLApplication.getInstance(), "af_ftd", hashMap);
                    }
                    MSharedPreferencesUtils.saveBooleanInNormalPref(MPLApplication.getInstance(), "moneyInEventSentV2", true);
                }
            }, "moneyInCheck");
            return;
        }
        MLogger.d(TAG, "sendMoneyInEventToCleverTap: MoneyInEventAlreadySent");
    }

    public static void sendNotificationClickEvent(JSONObject jSONObject) {
        HashMap<String, Object> hashMap = new HashMap<>();
        try {
            if (jSONObject.has("eventProps") && CommonUtils.isJSONValid(jSONObject.optString("eventProps", "{}"))) {
                JSONObject jSONObject2 = new JSONObject(jSONObject.optString("eventProps", "{}"));
                MLogger.d(TAG, "sendNotificationClickEvent:eventProps ", jSONObject2);
                jSONObject = CommonUtils.mergeJSON(jSONObject, jSONObject2);
            }
            hashMap = Util.jsonToMap(jSONObject);
            hashMap.put("Notif Category", jSONObject.optString("category", ""));
            hashMap.put("Notification Name", jSONObject.optString("Notification Name", "default"));
            hashMap.put("Notif Subcategory", jSONObject.optString("subCategory", ""));
        } catch (Exception e2) {
            MLogger.e(TAG, "sendNotificationClickEvent: ", e2);
        }
        sendEvent((String) "MPL Notification Clicked", hashMap);
    }

    public static void sendNotificationReceivedEvent(JSONObject jSONObject) {
        HashMap<String, Object> hashMap = new HashMap<>();
        try {
            hashMap = Util.jsonToMap(jSONObject);
        } catch (Exception e2) {
            MLogger.e(TAG, "sendNotificationReceivedEvent: ", e2);
        }
        sendEvent((String) "MPL Notification Received", hashMap);
    }

    public static void sendUnityEventToAppsFlyer(String str, String str2) {
        try {
            sendEventsToAppsFlyer(MPLApplication.getInstance(), str, Util.jsonToMap(new JSONObject(str2)));
        } catch (Exception unused) {
        }
    }

    public static void sendVideoDeletedEvent(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("Reason", str);
        sendEvent((String) "Video Deleted", hashMap);
    }

    public static void sendWebAppOpenEvent(HashMap<String, Object> hashMap) {
        sendEvent((String) "Web App Started", hashMap);
    }

    public static void sendWebAppOpenFailedEvent(JSONObject jSONObject) {
        sendEvent((String) "Web App Disconnected", jSONObject.toString());
    }

    public static void setFireBaseUserProperty(String str, String str2) {
        if (MPLLibInitContentProvider.getLibInitContentProvider() != null && MPLLibInitContentProvider.getLibInitContentProvider().getFirebaseAnalytics() != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            MPLLibInitContentProvider.getLibInitContentProvider().getFirebaseAnalytics().zzb.zzN(null, str, str2, false);
        }
    }

    public static void setHanselConfig(String str, String str2) {
        if (Hansel.getUser() != null) {
            Hansel.getUser().putAttribute(str, str2);
        }
    }

    public static void setOriginalNotificationEvent(boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("Notification Set", !z);
            jSONObject.put("Notification Dismissed", z);
            sendEvent((String) "Playstore Notification", jSONObject.toString());
        } catch (Exception unused) {
            MLogger.e(TAG, "setOriginalNotificationEvent: ");
        }
    }

    public static void setOriginalPlayStoreRedirectionEvent() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("Redirected", true);
            sendEvent((String) "Playstore Download Initiated", jSONObject.toString());
        } catch (Exception unused) {
            MLogger.e(TAG, "setOriginalNotificationEvent: ");
        }
    }

    public static void setRemovedEvents(HashSet<String> hashSet) {
        removedEvents = hashSet;
    }

    public static boolean shouldRemoveMobileFromParams(String str) {
        return isRemoveMobileFromParamsEvent(str) && !TextUtils.isEmpty(MBuildConfigUtils.getCountryCode()) && "US".equalsIgnoreCase(MBuildConfigUtils.getCountryCode());
    }

    public static void setHanselConfig(String str, Boolean bool) {
        if (Hansel.getUser() != null) {
            Hansel.getUser().putAttribute(str, bool.booleanValue());
        }
    }

    public static void sendEvent(String str, HashMap<String, Object> hashMap) {
        try {
            hashMap.put(EventsConstants.APP_VERSION_CODE, String.valueOf(MBuildConfigUtils.getInstalledAppVersionCode()));
            hashMap.put(EventsConstants.APP_VERSION_NAME, String.valueOf(MBuildConfigUtils.getCurrentAppVersionName()));
            hashMap.put(EventsConstants.REACT_VERSION, String.valueOf(DBInteractor.getCurrentRNBundleVersionCode()));
            hashMap.put(EventsConstants.ANDROID_APP_TYPE, MBuildConfigUtils.getAppType());
            hashMap.put(EventsConstants.IS_USER_PHONE_ROOTED, Boolean.valueOf(MSharedPreferencesUtils.isPhoneRooted()));
            hashMap.put(EventsConstants.USER_MOBILE_NUMBER, CountryUtils.getUniqueIdForThirdPartySDKs());
            hashMap.put(EventsConstants.USER_TIER, MSharedPreferencesUtils.getUserTier());
            hashMap.put(EventsConstants.USER_CLEVERTAP_ID, MPLApplication.getMplAnalytics().getCleverTapId());
            if ("Referral Code Detected".equalsIgnoreCase(str)) {
                hashMap.put(EventsConstants.PARAMS_SOURCE, MSharedPreferencesUtils.getReferralSourceBranch());
            }
        } catch (Exception e2) {
            MLogger.e(TAG, "sendEvent: ", e2);
        } catch (Throwable th) {
            push(str, hashMap, false);
            throw th;
        }
        push(str, hashMap, false);
    }

    public static void setHanselConfig(String str, double d2) {
        if (Hansel.getUser() != null) {
            Hansel.getUser().putAttribute(str, d2);
        }
    }

    public static void setHanselConfig(String str, int i) {
        if (Hansel.getUser() != null) {
            Hansel.getUser().putAttribute(str, (double) i);
        }
    }

    public static void pushFireBaseEvents(String str) {
        if (str != null && !TextUtils.isEmpty(str)) {
            String replace = str.replace(CMap.SPACE, "_");
            FirebaseAnalytics firebaseAnalytics = MPLLibInitContentProvider.getLibInitContentProvider().getFirebaseAnalytics();
            firebaseAnalytics.zzb.zzx(replace, new Bundle());
        }
    }

    public static void sendEvent(String str) {
        try {
            sendEvent(str, Util.jsonToMap(new JSONObject()));
        } catch (Exception e2) {
            MLogger.e(TAG, "sendEvent: ", e2);
        }
    }

    public static void sendEvent(String str, Map<String, String> map) {
        HashMap hashMap = new HashMap();
        for (Entry next : map.entrySet()) {
            hashMap.put((String) next.getKey(), next.getValue());
        }
        sendEvent(str, hashMap);
    }
}
