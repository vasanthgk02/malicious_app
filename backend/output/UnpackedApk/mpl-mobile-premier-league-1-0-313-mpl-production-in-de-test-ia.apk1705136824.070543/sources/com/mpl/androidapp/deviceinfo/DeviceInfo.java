package com.mpl.androidapp.deviceinfo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.Uri;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.WindowManager;
import androidx.core.content.ContextCompat;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.config.ConfigConstant;
import com.mpl.androidapp.spacemanagment.SpaceUtils;
import com.mpl.androidapp.updater.interactor.DBInteractor;
import com.mpl.androidapp.utils.Constant;
import com.mpl.androidapp.utils.MBuildConfigUtils;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.utils.MSharedPreferencesUtils;
import com.netcore.android.SMTEventParamKeys;
import com.razorpay.AnalyticsConstants;
import com.rudderstack.android.sdk.core.RudderTraits;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.fontbox.cmap.CMap;
import org.apache.fontbox.cmap.CMapParser;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DeviceInfo {
    public static final String TAG = "DeviceInfo";
    public final Context context;
    public TelephonyManager mTelephonyManager;

    @SuppressLint({"MissingPermission"})
    public DeviceInfo(Context context2) {
        this.context = context2;
        if (context2 != null) {
            this.mTelephonyManager = (TelephonyManager) context2.getSystemService("phone");
        }
    }

    private JSONArray arrayToJson(Object obj) throws JSONException {
        if (obj.getClass().isArray()) {
            int length = Array.getLength(obj);
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < length; i++) {
                jSONArray.put(wrap(Array.get(obj, i)));
            }
            return jSONArray;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Not a primitive data: ");
        outline73.append(obj.getClass());
        throw new JSONException(outline73.toString());
    }

    public static String checkValidData(String str) {
        return (str == null || str.length() == 0) ? "Data Not Found" : str;
    }

    private JSONArray collectionToJson(Collection<Object> collection) {
        JSONArray jSONArray = new JSONArray();
        if (collection != null) {
            for (Object wrap : collection) {
                jSONArray.put(wrap(wrap));
            }
        }
        return jSONArray;
    }

    private String getBoard() {
        return checkValidData(Build.BOARD);
    }

    private String getBootloader() {
        return checkValidData(Build.BOOTLOADER);
    }

    private String getBuildHost() {
        return checkValidData(Build.HOST);
    }

    private String getBuildID() {
        return checkValidData(Build.ID);
    }

    private String getBuildTags() {
        return checkValidData(Build.TAGS);
    }

    private long getBuildTime() {
        return Build.TIME;
    }

    private String getBuildUser() {
        return checkValidData(Build.USER);
    }

    private String getBuildVersionCodename() {
        return checkValidData(VERSION.CODENAME);
    }

    private String getBuildVersionIncremental() {
        return checkValidData(VERSION.INCREMENTAL);
    }

    private String getBuildVersionRelease() {
        return checkValidData(VERSION.RELEASE);
    }

    private int getBuildVersionSDK() {
        return VERSION.SDK_INT;
    }

    private String getDevice() {
        return checkValidData(Build.DEVICE);
    }

    private String getDisplayVersion() {
        return checkValidData(Build.DISPLAY);
    }

    private String getFingerprint() {
        return checkValidData(Build.FINGERPRINT);
    }

    private String getHardware() {
        return checkValidData(Build.HARDWARE);
    }

    private String getLanguage() {
        return checkValidData(Locale.getDefault().getLanguage());
    }

    private String getManufacturer() {
        return checkValidData(handleIllegalCharacterInResult(Build.MANUFACTURER));
    }

    private String getOSCodename() {
        switch (VERSION.SDK_INT) {
            case 22:
            case 23:
                return "Lollipop";
            case 24:
            case 25:
                return "Marshmallow";
            case 26:
                return "Nougat";
            default:
                return "Value Not found";
        }
    }

    private String getOSVersion() {
        return checkValidData(VERSION.RELEASE);
    }

    private String getPhoneType() {
        int phoneType = this.mTelephonyManager.getPhoneType();
        if (phoneType != 1) {
            return phoneType != 2 ? "NONE" : "CDMA";
        }
        return "GSM";
    }

    private String getProduct() {
        return checkValidData(Build.PRODUCT);
    }

    private String getRadioVer() {
        return checkValidData(Build.getRadioVersion());
    }

    private String getScreenDisplayID() {
        WindowManager windowManager = (WindowManager) this.context.getSystemService("window");
        if (windowManager != null) {
            return checkValidData(String.valueOf(windowManager.getDefaultDisplay().getDisplayId()));
        }
        return checkValidData("");
    }

    @SuppressLint({"HardwareIds"})
    private String getSerial() {
        String str;
        if (VERSION.SDK_INT < 26) {
            str = Build.SERIAL;
        } else {
            str = ContextCompat.checkSelfPermission(this.context, "android.permission.READ_PHONE_STATE") == 0 ? Build.getSerial() : null;
        }
        return checkValidData(str);
    }

    private String getWifiSSID() {
        WifiManager wifiManager = (WifiManager) this.context.getApplicationContext().getSystemService(AnalyticsConstants.WIFI);
        String str = null;
        WifiInfo connectionInfo = wifiManager != null ? wifiManager.getConnectionInfo() : null;
        if (connectionInfo != null && connectionInfo.getSupplicantState() == SupplicantState.COMPLETED) {
            str = connectionInfo.getSSID();
        }
        return !TextUtils.isEmpty(str) ? str.substring(1, str.length() - 1) : str;
    }

    public static String handleIllegalCharacterInResult(String str) {
        return (str == null || !str.contains(CMap.SPACE)) ? str : str.replaceAll(CMap.SPACE, "_");
    }

    private boolean isConnectedToMobileNetwork(Context context2) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context2.getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
        if (networkInfo == null) {
            return false;
        }
        State state = networkInfo.getState();
        if (state == null || state == State.CONNECTED || state == State.CONNECTING) {
            return true;
        }
        return false;
    }

    public static boolean isConnectedToWiFiNetwork(Context context2) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context2.getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
        if (networkInfo == null) {
            return false;
        }
        State state = networkInfo.getState();
        if (state == State.CONNECTED || state == State.CONNECTING) {
            return true;
        }
        return false;
    }

    private JSONObject mapToJson(Map<?, ?> map) {
        JSONObject jSONObject = new JSONObject();
        for (Entry next : map.entrySet()) {
            String str = (String) next.getKey();
            if (str != null) {
                try {
                    jSONObject.put(str, wrap(next.getValue()));
                } catch (JSONException e2) {
                    MLogger.e("DeviceInfo", "", e2);
                }
            } else {
                throw new NullPointerException("key == null");
            }
        }
        return jSONObject;
    }

    private Object wrap(Object obj) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof JSONArray) || (obj instanceof JSONObject)) {
            return obj;
        }
        try {
            if (obj instanceof Collection) {
                return collectionToJson((Collection) obj);
            }
            if (obj.getClass().isArray()) {
                return arrayToJson(obj);
            }
            if (obj instanceof Map) {
                return mapToJson((Map) obj);
            }
            if (!(obj instanceof Boolean) && !(obj instanceof Byte) && !(obj instanceof Character) && !(obj instanceof Double) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Long) && !(obj instanceof Short)) {
                if (!(obj instanceof String)) {
                    if (obj.getClass().getPackage().getName().startsWith("java.")) {
                        obj = obj.toString();
                    }
                    return null;
                }
            }
            return obj;
        } catch (Exception unused) {
        }
    }

    public JSONArray getAllAppList(Context context2) {
        ArrayList arrayList = new ArrayList();
        for (ApplicationInfo applicationInfo : context2.getPackageManager().getInstalledApplications(128)) {
            arrayList.add(applicationInfo.packageName);
        }
        return collectionToJson(arrayList);
    }

    @SuppressLint({"HardwareIds"})
    public String getAndroidId() {
        return Secure.getString(this.context.getContentResolver(), "android_id");
    }

    public JSONObject getAppInfo(Context context2) {
        JSONObject jSONObject = new JSONObject();
        try {
            PackageManager packageManager = context2.getPackageManager();
            String packageName = this.context.getPackageName();
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
            ApplicationInfo applicationInfo = context2.getApplicationInfo();
            String charSequence = this.context.getApplicationInfo().loadLabel(this.context.getPackageManager()).toString();
            jSONObject.put(SMTEventParamKeys.SMT_APP_VERSION, packageInfo.versionName);
            jSONObject.put("buildNumber", packageInfo.versionCode);
            jSONObject.put("firstInstallTime", packageInfo.firstInstallTime);
            jSONObject.put("adv_id", MSharedPreferencesUtils.getStringInNormalPref(context2.getApplicationContext(), Constant.ADVERTISIING_ID, null));
            jSONObject.put("lastUpdateTime", packageInfo.lastUpdateTime);
            jSONObject.put("appName", charSequence);
            jSONObject.put("packageName", packageName);
            jSONObject.put(ConfigConstant.REACT_VERSION, DBInteractor.getCurrentRNBundleVersionCode());
            jSONObject.put("systemName", "Android");
            jSONObject.put(Constant.HEADER_APK_TYPE, MBuildConfigUtils.getApkType());
            jSONObject.put(Constant.HEADER_APP_TYPE, MBuildConfigUtils.getAppType());
            jSONObject.put(Constant.ISCASHAPP, MBuildConfigUtils.isCashApp());
            if (applicationInfo != null) {
                jSONObject.put("packageNameA", applicationInfo.packageName);
                jSONObject.put("appVersionA", MBuildConfigUtils.getCurrentAppVersionName());
                jSONObject.put("buildNumberA", MBuildConfigUtils.getInstalledAppVersionCode());
                jSONObject.put("applicationId", MBuildConfigUtils.getApplicationId());
            }
        } catch (NameNotFoundException | JSONException e2) {
            MLogger.e("DeviceInfo", "", e2);
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("getAppInfo() called with: context = [");
        outline73.append(jSONObject.toString());
        outline73.append(CMapParser.MARK_END_OF_ARRAY);
        MLogger.d("DeviceInfo", outline73.toString());
        return jSONObject;
    }

    public String getBuildBrand() {
        return checkValidData(handleIllegalCharacterInResult(Build.BRAND));
    }

    public JSONObject getDeviceInfo(Context context2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Constant.HEADER_ANDROID_DEVICE_ID, MSharedPreferencesUtils.getDeviceId());
            jSONObject.put("adv_id", MSharedPreferencesUtils.getStringInNormalPref(context2.getApplicationContext(), Constant.ADVERTISIING_ID, null));
            jSONObject.put("isDeviceRooted", isDeviceRooted());
            jSONObject.put("model", getModel());
            jSONObject.put("osCodeName", getOSCodename());
            jSONObject.put("osVersion", getOSVersion());
            jSONObject.put("manufacturer", getManufacturer());
            jSONObject.put("board", getBoard());
            jSONObject.put("bootloader", getBootloader());
            jSONObject.put("buildBrand", getBuildBrand());
            jSONObject.put("buildHost", getBuildHost());
            jSONObject.put("buildId", getBuildID());
            jSONObject.put("buildTags", getBuildTags());
            jSONObject.put("buildTime", getBuildTime());
            jSONObject.put("buildUser", getBuildUser());
            jSONObject.put("buildVersionCodename", getBuildVersionCodename());
            jSONObject.put("buildVersionIncremental", getBuildVersionIncremental());
            jSONObject.put("buildVersionRelease", getBuildVersionRelease());
            jSONObject.put("buildVersionSdk", getBuildVersionSDK());
            jSONObject.put("device", getDevice());
            jSONObject.put("displayVersion", getDisplayVersion());
            jSONObject.put("fingerprint", getFingerprint());
            jSONObject.put("hardware", getHardware());
            jSONObject.put("language", getLanguage());
            jSONObject.put("product", getProduct());
            jSONObject.put("radioVer", getRadioVer());
            jSONObject.put("screenDisplayId", getScreenDisplayID());
            jSONObject.put("serial", getSerial());
            jSONObject.put("phoneType", getPhoneType());
            jSONObject.put("isInternetAvailable", isInternetAvailable(context2));
            jSONObject.put("isConnectedToMobileNetwork", isConnectedToMobileNetwork(context2));
            jSONObject.put("isConnectedToWiFiNetwork", isConnectedToWiFiNetwork(context2));
            jSONObject.put("wifiSsid", getWifiSSID());
        } catch (Exception e2) {
            MLogger.e("DeviceInfo", "", e2);
        }
        return jSONObject;
    }

    @SuppressLint({"HardwareIds"})
    public final String getIMEI() {
        return checkValidData(ContextCompat.checkSelfPermission(this.context, "android.permission.READ_PHONE_STATE") == 0 ? this.mTelephonyManager.getDeviceId() : null);
    }

    public JSONObject getImeiInfo(Context context2) {
        JSONObject jSONObject = new JSONObject();
        try {
            TelephonyInfo instance = TelephonyInfo.getInstance((TelephonyManager) context2.getSystemService("phone"));
            if (instance != null) {
                jSONObject.put("imei1", instance.getImsiSIM1());
                jSONObject.put("imei2", instance.getImsiSIM2());
            }
        } catch (Exception e2) {
            MLogger.e("DeviceInfo", "", e2);
        }
        return jSONObject;
    }

    public String getModel() {
        return checkValidData(handleIllegalCharacterInResult(Build.MODEL));
    }

    public boolean isDeviceRooted() {
        return RootUtil.isDeviceRooted();
    }

    public boolean isEmulator() {
        return Build.FINGERPRINT.startsWith("generic") || Build.FINGERPRINT.startsWith("unknown") || Build.MODEL.contains("google_sdk") || Build.MODEL.contains("Emulator") || Build.MODEL.contains("Android SDK built for x86") || Build.MANUFACTURER.contains("Genymotion") || (Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic")) || "google_sdk".equals(Build.PRODUCT);
    }

    public boolean isInternetAvailable(Context context2) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context2.getSystemService("connectivity");
        return (connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null) != null;
    }

    public boolean isTablet() {
        int i = this.context.getResources().getConfiguration().screenLayout & 15;
        boolean z = false;
        if (i != 3 && i != 4) {
            return false;
        }
        int i2 = this.context.getResources().getDisplayMetrics().densityDpi;
        if (i2 == 160 || i2 == 240 || i2 == 213 || i2 == 320) {
            z = true;
        }
        return z;
    }

    public boolean isTxnSmsPresent(Context context2, String str) {
        int i;
        if (ContextCompat.checkSelfPermission(context2, "android.permission.READ_SMS") == 0) {
            Cursor query = context2.getContentResolver().query(Uri.parse("content://sms/" + str), new String[]{RudderTraits.ADDRESS_KEY}, "address=?", new String[]{"IX-MPLSMS"}, null);
            if (query != null) {
                try {
                    query.moveToFirst();
                    MLogger.d("SMS COUNT", "" + query.getCount());
                    i = query.getCount();
                } catch (Throwable th) {
                    th.addSuppressed(th);
                }
            } else {
                i = 0;
            }
            if (query != null) {
                query.close();
            }
        } else {
            i = 0;
        }
        if (i > 0) {
            return true;
        }
        return false;
        throw th;
    }

    @SuppressLint({"HardwareIds"})
    public String print() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject deviceInfo = getDeviceInfo(this.context);
            JSONObject appInfo = getAppInfo(this.context);
            JSONArray allAppList = getAllAppList(this.context);
            JSONObject imeiInfo = getImeiInfo(this.context);
            jSONObject.put("deviceInfo", deviceInfo);
            jSONObject.put("mpl", appInfo);
            jSONObject.put(SpaceUtils.INSTALLED_APP_LIST, allAppList);
            jSONObject.put("imei", imeiInfo);
            if (ContextCompat.checkSelfPermission(this.context, "android.permission.READ_SMS") == 0) {
                jSONObject.put("noMplTxn", isTxnSmsPresent(this.context, "inbox"));
            }
            jSONObject.put("isDeviceRooted", isDeviceRooted());
            return jSONObject.toString();
        } catch (JSONException e2) {
            MLogger.e("DeviceInfo", "", e2);
            return null;
        }
    }
}
