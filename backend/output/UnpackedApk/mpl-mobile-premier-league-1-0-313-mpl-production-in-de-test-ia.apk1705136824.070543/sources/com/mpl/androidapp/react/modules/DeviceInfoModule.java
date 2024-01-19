package com.mpl.androidapp.react.modules;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.google.gson.Gson;
import com.mpl.androidapp.config.ConfigConstant;
import com.mpl.androidapp.deviceinfo.DeviceInfo;
import com.mpl.androidapp.updater.interactor.DBInteractor;
import com.mpl.androidapp.utils.CommonUtils;
import com.mpl.androidapp.utils.Constant;
import com.mpl.androidapp.utils.DeviceUtils;
import com.mpl.androidapp.utils.HashShieldId;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.utils.MSharedPreferencesUtils;
import com.mpl.androidapp.utils.MTimeListener;
import com.mpl.androidapp.utils.Util;
import com.mpl.androidapp.utils.WindowUtil;
import com.paynimo.android.payment.UPIFragment;
import java.io.File;
import java.util.Date;
import org.apache.fontbox.cmap.CMapParser;
import org.json.JSONArray;
import org.json.JSONObject;

@ReactModule(name = "DeviceInfoModule")
public class DeviceInfoModule extends ReactContextBaseJavaModule {
    public static final String TAG = "DeviceInfoModule";
    public final DeviceInfo deviceInfo;
    public final Context mContext;

    public DeviceInfoModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mContext = reactApplicationContext.getApplicationContext();
        DeviceInfo deviceInfo2 = new DeviceInfo(reactApplicationContext.getApplicationContext());
        this.deviceInfo = deviceInfo2;
        if (deviceInfo2 != null) {
            MSharedPreferencesUtils.setIsPhoneRooted(deviceInfo2.isDeviceRooted());
            MSharedPreferencesUtils.setIsEmulator(this.deviceInfo.isEmulator());
            MSharedPreferencesUtils.setDeviceId(this.mContext, this.deviceInfo.getAndroidId());
        }
    }

    private void getApkSize(Context context, Promise promise) {
        try {
            promise.resolve(String.valueOf((new File(context.getPackageManager().getApplicationInfo(this.mContext.getPackageName(), 0).publicSourceDir).length() / 1024) / 1024));
        } catch (NameNotFoundException e2) {
            e2.printStackTrace();
            promise.reject((String) "fail", e2.getMessage());
        }
    }

    @ReactMethod
    public void blackboxkey(Promise promise) {
        promise.resolve("");
    }

    @ReactMethod
    public void fetchLatestDataFromShield() {
        MLogger.d(TAG, "fetchLatestDataFromShield: ");
    }

    @ReactMethod
    public void getAdvertisingId(Promise promise) {
        promise.resolve(MSharedPreferencesUtils.getStringInNormalPref(this.mContext, Constant.ADVERTISIING_ID, null));
    }

    @ReactMethod
    public void getAllDeviceInfo(Promise promise) {
        DeviceInfo deviceInfo2 = this.deviceInfo;
        if (deviceInfo2 != null) {
            promise.resolve(deviceInfo2.print());
        } else {
            promise.reject((String) "fail", (String) "Fail to get App List Info");
        }
    }

    @ReactMethod
    public void getAppInfo(Promise promise) {
        DeviceInfo deviceInfo2 = this.deviceInfo;
        if (deviceInfo2 != null) {
            JSONObject appInfo = deviceInfo2.getAppInfo(this.mContext);
            if (appInfo != null) {
                promise.resolve(appInfo.toString());
            } else {
                promise.reject((String) "Constant.FAIL", (String) "Fail to get App List due to app Info null");
            }
        } else {
            promise.reject((String) "fail", (String) "Fail to get App List due to device Info null");
        }
    }

    @ReactMethod
    public void getAppListInfo(Promise promise) {
        DeviceInfo deviceInfo2 = this.deviceInfo;
        if (deviceInfo2 != null) {
            JSONArray allAppList = deviceInfo2.getAllAppList(this.mContext);
            if (allAppList != null) {
                promise.resolve(allAppList.toString());
            } else {
                promise.reject((String) "fail", (String) "Fail to get App List due to device Info null");
            }
        } else {
            promise.reject((String) "fail", (String) "Fail to get App List Info");
        }
    }

    @ReactMethod
    public void getAppReactVersion(Promise promise) {
        try {
            int currentRNBundleVersionCode = DBInteractor.getCurrentRNBundleVersionCode();
            if (DBInteractor.getCurrentRNBundleVersionCode() > DBInteractor.getCurrentDownloadedRNBundleVersionCode()) {
                currentRNBundleVersionCode = DBInteractor.getCurrentDownloadedRNBundleVersionCode();
            }
            if (this.deviceInfo != null) {
                JSONObject appInfo = this.deviceInfo.getAppInfo(this.mContext);
                appInfo.put(ConfigConstant.REACT_VERSION, currentRNBundleVersionCode);
                promise.resolve(appInfo.toString());
                return;
            }
            promise.reject((String) "fail", (String) "Fail to get App List due to device Info null");
        } catch (Exception unused) {
            promise.reject((String) "fail", (String) "Fail to get App List due to device Info null");
        }
    }

    @ReactMethod
    public void getDeviceDisplayInfo(Promise promise) {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            promise.resolve(WindowUtil.getScreeDisplayMetrics(currentActivity));
        } else {
            promise.reject((String) "fail", (String) "Failed to get display data");
        }
    }

    @ReactMethod
    public void getDeviceFingerPrint(Promise promise) {
        MLogger.d(TAG, "getDeviceFingerPrint: ");
        promise.resolve(DeviceUtils.getShieldId());
    }

    @ReactMethod
    public void getDeviceFingerPrintData(Promise promise) {
        String json = new Gson().toJson((Object) DeviceUtils.getDeviceODNLData());
        MLogger.d(TAG, "getDeviceFingerPrintData: ", json);
        if (TextUtils.isEmpty(json) || "null".equalsIgnoreCase(json)) {
            promise.resolve("");
        } else {
            promise.resolve(json);
        }
    }

    @ReactMethod
    public void getDeviceId(Promise promise) {
        promise.resolve(MSharedPreferencesUtils.getDeviceId());
    }

    @ReactMethod
    public void getDeviceInfo(Promise promise) {
        DeviceInfo deviceInfo2 = this.deviceInfo;
        if (deviceInfo2 != null) {
            JSONObject deviceInfo3 = deviceInfo2.getDeviceInfo(this.mContext);
            if (deviceInfo3 != null) {
                promise.resolve(deviceInfo3.toString());
            } else {
                promise.reject((String) "fail", (String) "Fail to get device Info");
            }
        } else {
            promise.reject((String) "fail", (String) "Fail to get device Info");
        }
    }

    @ReactMethod
    public void getDeviceMemoryDetails(Promise promise) {
        promise.resolve(new JSONObject(CommonUtils.getDeviceMemoryInfo()).toString());
    }

    @ReactMethod
    public void getImeiInfo(Promise promise) {
        DeviceInfo deviceInfo2 = this.deviceInfo;
        if (deviceInfo2 != null) {
            JSONObject imeiInfo = deviceInfo2.getImeiInfo(this.mContext);
            if (imeiInfo != null) {
                promise.resolve(imeiInfo.toString());
            } else {
                promise.reject((String) "fail", (String) "Fail to IMEI device Info");
            }
        } else {
            promise.reject((String) "fail", (String) "Fail to get App List due to device Info null");
        }
    }

    @ReactMethod
    public void getMplApkSize(Promise promise) {
        Context context = this.mContext;
        if (context != null) {
            getApkSize(context, promise);
        } else {
            promise.reject((String) "fail", (String) "Context is null");
        }
    }

    public String getName() {
        return TAG;
    }

    @ReactMethod
    public void getSessionCount(Promise promise) {
        int rgSessionCount = MSharedPreferencesUtils.getRgSessionCount();
        MLogger.d("ResponsibleGamingTimer", GeneratedOutlineSupport.outline41("Current Session count is -->", rgSessionCount));
        promise.resolve(Integer.valueOf(rgSessionCount));
    }

    @ReactMethod
    public void getShieldIdHash(Promise promise) {
        MLogger.d(TAG, "getShieldIdHash: ");
        String generateHash = HashShieldId.generateHash(DeviceUtils.getShieldId());
        if (generateHash != null) {
            promise.resolve(generateHash);
        } else {
            promise.reject((String) "getShieldIdHash", (String) "hash is null");
        }
    }

    @ReactMethod
    public void getSimInformation(Promise promise) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!(getCurrentActivity() == null || getCurrentActivity().getApplicationContext() == null)) {
                SubscriptionManager from = SubscriptionManager.from(getCurrentActivity().getApplicationContext());
                if (from != null) {
                    int i = 1;
                    for (SubscriptionInfo number : from.getActiveSubscriptionInfoList()) {
                        jSONObject.put(UPIFragment.CONFIG_TYPE_NUMBER + i, number.getNumber());
                        i++;
                    }
                }
            }
        } catch (Exception e2) {
            MLogger.e(TAG, "getSimInformation: ", e2);
        }
        promise.resolve(jSONObject);
    }

    @ReactMethod
    public void getTime(final Promise promise) {
        Util.getTimeFromLib(new MTimeListener() {
            public void onFail(Exception exc) {
                MLogger.d(DeviceInfoModule.TAG, "onFail() called with: e = [" + exc + CMapParser.MARK_END_OF_ARRAY);
                if (exc != null) {
                    promise.reject((String) "fail", exc.getMessage());
                } else {
                    promise.reject((String) "fail", (String) "Not Able to fetch time");
                }
            }

            public void onSuccess(Date date) {
                if (date != null) {
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("onSuccess() called with: date = [");
                    outline73.append(date.getTime());
                    outline73.append(CMapParser.MARK_END_OF_ARRAY);
                    MLogger.d(DeviceInfoModule.TAG, outline73.toString());
                    promise.resolve(String.valueOf(date.getTime()));
                    return;
                }
                MLogger.d(DeviceInfoModule.TAG, "onSuccess() called with: date null");
                promise.reject((String) "fail", (String) "Not Able to fetch time");
            }
        });
    }

    @ReactMethod
    public void initShield(boolean z, boolean z2, Promise promise) {
        MLogger.d(TAG, "initShield() called with: isFingerprintingOn = [" + z + "], isGeoSpoofingCheckOn = [" + z2 + CMapParser.MARK_END_OF_ARRAY);
        if (getCurrentActivity() != null) {
            DeviceUtils.initShield(getCurrentActivity(), z, z2);
            promise.resolve(Boolean.TRUE);
            return;
        }
        promise.resolve(Boolean.FALSE);
    }

    @ReactMethod
    public void isMPLTxnPresent(Promise promise) {
        if (ContextCompat.checkSelfPermission(this.mContext, "android.permission.READ_SMS") == 0) {
            DeviceInfo deviceInfo2 = this.deviceInfo;
            if (deviceInfo2 != null) {
                promise.resolve(Boolean.valueOf(deviceInfo2.isTxnSmsPresent(this.mContext, "inbox")));
            } else {
                promise.reject((String) "fail", (String) "Fail to get Translation due to devices info null");
            }
        } else {
            promise.reject((String) "fail", (String) "Fail to get Translation due permission not granted");
        }
    }

    @ReactMethod
    public void isPhoneRooted(Promise promise) {
        DeviceInfo deviceInfo2 = this.deviceInfo;
        if (deviceInfo2 != null) {
            promise.resolve(Boolean.valueOf(deviceInfo2.isDeviceRooted()));
        } else {
            promise.reject((String) "fail", (String) "Fail to get rooted info due to device info null");
        }
    }

    @ReactMethod
    public void setDeviceCustomData(ReadableMap readableMap) {
        MLogger.d(TAG, "setDeviceCustomData: ", readableMap);
    }
}
