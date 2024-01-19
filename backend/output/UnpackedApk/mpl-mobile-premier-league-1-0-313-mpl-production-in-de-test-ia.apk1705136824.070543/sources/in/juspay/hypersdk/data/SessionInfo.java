package in.juspay.hypersdk.data;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import androidx.annotation.Keep;
import com.mpl.androidapp.config.ConfigConstant;
import com.razorpay.AnalyticsConstants;
import com.xiaomi.mipush.sdk.Constants;
import in.juspay.hypersdk.core.JuspayCoreLib;
import in.juspay.hypersdk.core.JuspayLogger;
import in.juspay.hypersdk.core.JuspayServices;
import in.juspay.hypersdk.core.Labels.Device;
import in.juspay.hypersdk.core.PaymentConstants;
import in.juspay.hypersdk.security.EncryptionHelper;
import in.juspay.hypersdk.utils.Utils;
import java.io.File;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SessionInfo {
    public static final String LOG_TAG = "in.juspay.hypersdk.data.SessionInfo";
    public JSONObject bundleParams;
    public Context context;
    public DisplayMetrics displayMetrics;
    public JuspayServices juspayServices;
    public String sdkName;
    public String sessionId;
    public final JSONObject sessionInfo;

    public SessionInfo(JuspayServices juspayServices2) {
        this(juspayServices2, true);
    }

    public SessionInfo(JuspayServices juspayServices2, boolean z) {
        this.juspayServices = juspayServices2;
        this.context = juspayServices2.getContext().getApplicationContext();
        this.sessionInfo = new JSONObject();
        this.sdkName = juspayServices2.getSdkInfo().getSdkName();
        if (z) {
            setSessionId(UUID.randomUUID().toString());
        }
    }

    public SessionInfo(JSONObject jSONObject, JuspayServices juspayServices2) {
        this(juspayServices2);
        this.bundleParams = jSONObject;
        this.sessionInfo.put("bundleParams", jSONObject);
    }

    private boolean devOptionsEnabled() {
        Context context2 = this.context;
        if (context2 == null) {
            return false;
        }
        try {
            return Secure.getInt(context2.getContentResolver(), "development_settings_enabled", 0) == 1;
        } catch (Exception unused) {
            return false;
        }
    }

    private DisplayMetrics getDisplayMetrics() {
        try {
            if (this.displayMetrics == null) {
                this.displayMetrics = this.context.getResources().getDisplayMetrics();
            }
            return this.displayMetrics;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getNewSessionId() {
        return UUID.randomUUID().toString();
    }

    public static String getOSVersion() {
        return VERSION.RELEASE;
    }

    private String getScreenPpi() {
        DisplayMetrics displayMetrics2 = getDisplayMetrics();
        if (displayMetrics2 != null) {
            return String.valueOf(displayMetrics2.xdpi);
        }
        return null;
    }

    private int getVersionCode() {
        try {
            return this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException unused) {
            return -1;
        }
    }

    private String getVersionName() {
        try {
            return this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 0).versionName;
        } catch (NameNotFoundException unused) {
            return null;
        }
    }

    public static boolean isRooted() {
        String str = Build.TAGS;
        if (str != null && str.contains("test-keys")) {
            return true;
        }
        try {
            if (new File("/system/app/Superuser.apk").exists()) {
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public void createSessionDataMap() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Constants.PHONE_BRAND, Build.BRAND);
            jSONObject.put("model", Build.MODEL);
            jSONObject.put("manufacturer", Build.MANUFACTURER);
            jSONObject.put(ConfigConstant.DEVICE_ID, getDeviceId());
            jSONObject.put("android_id", getAndroidId());
            jSONObject.put("os", "android");
            jSONObject.put("os_version", VERSION.RELEASE);
            jSONObject.put("android_api_level", String.valueOf(VERSION.SDK_INT));
            jSONObject.put("locale", Locale.getDefault().getDisplayLanguage());
            jSONObject.put("app_name", this.context.getApplicationInfo().loadLabel(this.context.getPackageManager()));
            jSONObject.put("app_version", getVersionName());
            jSONObject.put("app_version_code", getVersionCode());
            String clientId = getClientId();
            if (clientId != "") {
                jSONObject.put(PaymentConstants.CLIENT_ID, clientId);
            }
            String merchantId = getMerchantId();
            if (merchantId != "") {
                jSONObject.put(PaymentConstants.MERCHANT_ID, merchantId);
            }
            jSONObject.put("dir_name", this.context.getApplicationInfo().sourceDir);
            jSONObject.put("package_name", this.context.getApplicationInfo().packageName);
            jSONObject.put("network_info", getNetworkInfo());
            jSONObject.put("network_type", String.valueOf(getNetworkType()));
            jSONObject.put("ip_address", Utils.getIPAddress(this.juspayServices));
            jSONObject.put("is_rooted", String.valueOf(isRooted()));
            jSONObject.put("is_dev_enabled", String.valueOf(devOptionsEnabled()));
            jSONObject.put("app_debuggable", JuspayCoreLib.isAppDebuggable());
            jSONObject.put("sdk_debuggable", this.juspayServices.getSdkInfo().isSdkDebuggable());
            jSONObject.put("screen_width", getScreenWidth());
            jSONObject.put("screen_height", getScreenHeight());
            jSONObject.put("screen_ppi", getScreenPpi());
            jSONObject.put("geocode", "");
            jSONObject.put("location", "");
            jSONObject.put("capability", "");
            updateSessionData(jSONObject);
        } catch (Throwable unused) {
        }
    }

    public String get(String str, String str2) {
        return this.sessionInfo.optString(str, str2);
    }

    @SuppressLint({"HardwareIds"})
    @Keep
    public String getAndroidId() {
        return EncryptionHelper.getSHA256Hash(Secure.getString(this.context.getContentResolver(), "android_id"));
    }

    public String getAppName() {
        return this.sessionInfo.has("app_name") ? this.sessionInfo.getString("app_name") : getClientId();
    }

    public JSONObject getBundleParams() {
        return this.bundleParams;
    }

    public String getClientId() {
        JSONObject jSONObject = this.bundleParams;
        if (jSONObject != null && jSONObject.has("payload")) {
            JSONObject jSONObject2 = this.bundleParams.getJSONObject("payload");
            if (jSONObject2 != null) {
                if (jSONObject2.has(PaymentConstants.CLIENT_ID_CAMEL)) {
                    return jSONObject2.getString(PaymentConstants.CLIENT_ID_CAMEL);
                }
                if (jSONObject2.has(PaymentConstants.CLIENT_ID)) {
                    return jSONObject2.getString(PaymentConstants.CLIENT_ID);
                }
            }
        }
        return "";
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    public String getDeviceId() {
        try {
            if (KeyValueStore.contains(this.juspayServices.getContext(), this.sdkName, ConfigConstant.DEVICE_ID)) {
                return KeyValueStore.read(this.juspayServices.getContext(), this.sdkName, ConfigConstant.DEVICE_ID, "");
            }
            if (isPermissionAvailable("android.permission.READ_PHONE_STATE")) {
                TelephonyManager telephonyManager = (TelephonyManager) this.context.getSystemService("phone");
                KeyValueStore.write(this.juspayServices.getContext(), this.sdkName, ConfigConstant.DEVICE_ID, EncryptionHelper.getSHA256Hash(telephonyManager.getDeviceId()));
                return EncryptionHelper.getSHA256Hash(telephonyManager.getDeviceId());
            }
            return null;
        } catch (Exception unused) {
        }
    }

    public String getMerchantId() {
        JSONObject jSONObject = this.bundleParams;
        if (jSONObject != null && jSONObject.has("payload")) {
            JSONObject jSONObject2 = this.bundleParams.getJSONObject("payload");
            if (jSONObject2 != null) {
                if (jSONObject2.has(PaymentConstants.SIGNATURE_PAYLOAD_CAMEL)) {
                    JSONObject jSONObject3 = new JSONObject(jSONObject2.getString(PaymentConstants.SIGNATURE_PAYLOAD_CAMEL));
                    if (jSONObject3.has(PaymentConstants.MERCHANT_ID_CAMEL)) {
                        return jSONObject3.getString(PaymentConstants.MERCHANT_ID_CAMEL);
                    }
                    if (jSONObject3.has(PaymentConstants.MERCHANT_ID)) {
                        return jSONObject3.getString(PaymentConstants.MERCHANT_ID);
                    }
                }
                if (jSONObject2.has(PaymentConstants.MERCHANT_ID_CAMEL)) {
                    return jSONObject2.getString(PaymentConstants.MERCHANT_ID_CAMEL);
                }
                if (jSONObject2.has(PaymentConstants.MERCHANT_ID)) {
                    return jSONObject2.getString(PaymentConstants.MERCHANT_ID);
                }
            }
        }
        return "";
    }

    public String getNetworkInfo() {
        try {
            this.context.getApplicationContext().getSystemService(AnalyticsConstants.WIFI);
            ConnectivityManager connectivityManager = (ConnectivityManager) this.context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return AnalyticsConstants.CELLULAR;
            }
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
            return (networkInfo == null || !networkInfo.isConnected()) ? AnalyticsConstants.CELLULAR : AnalyticsConstants.WIFI;
        } catch (Exception unused) {
            return null;
        }
    }

    public String getNetworkName() {
        if (this.context == null) {
            return "OTHER";
        }
        int networkType = getNetworkType();
        if (AnalyticsConstants.WIFI.equals(getNetworkInfo())) {
            return "WIFI";
        }
        switch (networkType) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return AnalyticsConstants.NETWORK_2G;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return AnalyticsConstants.NETWORK_3G;
            default:
                return "OTHER";
        }
    }

    public int getNetworkType() {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) this.context.getSystemService("phone");
            if (telephonyManager != null) {
                return telephonyManager.getNetworkType();
            }
            return -1;
        } catch (Exception unused) {
            return -1;
        }
    }

    public String getPackageName() {
        return this.context.getPackageName();
    }

    public String getScreenHeight() {
        DisplayMetrics displayMetrics2 = getDisplayMetrics();
        if (displayMetrics2 != null) {
            return String.valueOf(displayMetrics2.heightPixels);
        }
        return null;
    }

    public String getScreenSizeDensity() {
        try {
            DisplayMetrics displayMetrics2 = getDisplayMetrics();
            if (displayMetrics2 != null) {
                float f2 = displayMetrics2.density;
                return (this.context.getResources().getConfiguration().screenLayout & 15) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + f2;
            }
            throw new Exception("display metrics null");
        } catch (Exception unused) {
            return null;
        }
    }

    public String getScreenWidth() {
        DisplayMetrics displayMetrics2 = getDisplayMetrics();
        if (displayMetrics2 != null) {
            return String.valueOf(displayMetrics2.widthPixels);
        }
        return null;
    }

    public JSONObject getSessionData() {
        return this.sessionInfo.optJSONObject("sessionData");
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public boolean isNetworkAvailable() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    public boolean isPermissionAvailable(String str) {
        try {
            if (this.context.getPackageManager().checkPermission(str, this.context.getPackageName()) == 0) {
                return true;
            }
            JuspayServices juspayServices2 = this.juspayServices;
            String str2 = LOG_TAG;
            juspayServices2.sdkDebug(str2, "Permission not found: " + str);
            return false;
        } catch (Throwable unused) {
        }
    }

    public boolean isVerifyAssetsEnabled() {
        return !this.sessionInfo.has(in.juspay.hypersdk.core.Constants.VERIFY_ASSETS) || this.sessionInfo.getBoolean(in.juspay.hypersdk.core.Constants.VERIFY_ASSETS);
    }

    public void logDeviceIdentifiers() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ConfigConstant.DEVICE_ID, getDeviceId());
            jSONObject.put("android_id", getAndroidId());
            this.juspayServices.getSdkTracker().trackContext("device", "info", Device.IDENTIFIERS, jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void logSessionInfo() {
        try {
            this.juspayServices.getSdkTracker().trackContext("device", "info", "session_info", this.sessionInfo);
        } catch (Exception e2) {
            this.juspayServices.getSdkTracker().trackAndLogException(LOG_TAG, "action", "system", "session_info", "Exception while logging ", e2);
        }
    }

    public void removeAttribute(String str) {
        this.sessionInfo.remove(str);
    }

    public void set(String str, String str2) {
        try {
            this.sessionInfo.put(str, str2);
        } catch (Exception unused) {
        }
    }

    public void setBundleParams(JSONObject jSONObject) {
        if (this.bundleParams == null) {
            this.bundleParams = new JSONObject();
        }
        try {
            JSONArray names = this.bundleParams.names();
            if (names != null) {
                for (int i = 0; i < names.length(); i++) {
                    this.bundleParams.remove(names.getString(i));
                }
            }
            JSONArray names2 = jSONObject.names();
            if (names2 != null) {
                for (int i2 = 0; i2 < names2.length(); i2++) {
                    String string = names2.getString(i2);
                    this.bundleParams.put(string, jSONObject.get(string));
                }
            }
            set("bundleParams", this.bundleParams.toString());
        } catch (JSONException unused) {
        }
    }

    public void setSessionId(String str) {
        this.sessionId = str;
        String str2 = LOG_TAG;
        JuspayLogger.d(str2, "Session ID: " + str);
    }

    public void updateSessionData(JSONObject jSONObject) {
        this.sessionInfo.remove("sessionData");
        try {
            this.sessionInfo.put("sessionData", jSONObject);
        } catch (JSONException e2) {
            JuspayServices juspayServices2 = this.juspayServices;
            String str = LOG_TAG;
            juspayServices2.sdkDebug(str, "Unable to update sessionInfo: " + e2);
        }
    }
}
