package com.mpl.androidapp.react.modules;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.mpl.androidapp.config.ConfigManager;
import com.mpl.androidapp.utils.CleverTapAnalyticsUtils;
import com.mpl.androidapp.utils.CommonUtils;
import com.mpl.androidapp.utils.MBuildConfigUtils;
import io.hansel.actions.configs.HanselConfigs;
import io.hansel.hanselsdk.Hansel;
import org.json.JSONObject;

@ReactModule(name = "HanselModule")
public class HanselModule extends ReactContextBaseJavaModule {
    public static final String TAG = "HanselModule";

    public HanselModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public static void clear() {
        if (Hansel.getUser() != null) {
            Hansel.getUser().clear();
        }
    }

    @ReactMethod
    public static void clearAttribute(String str) {
        if (Hansel.getUser() != null) {
            Hansel.getUser().clearAttribute(str);
        }
    }

    @ReactMethod
    public static void putBooleanAttribute(String str, boolean z) {
        if (Hansel.getUser() != null) {
            Hansel.getUser().putAttribute(str, z);
        }
    }

    @ReactMethod
    public static void putDoubleAttribute(String str, double d2) {
        if (Hansel.getUser() != null) {
            Hansel.getUser().putAttribute(str, d2);
        }
    }

    @ReactMethod
    public static void putPrivateBooleanAttribute(String str, boolean z) {
        if (Hansel.getUser() != null) {
            Hansel.getUser().putPrivateAttribute(str, z);
        }
    }

    @ReactMethod
    public static void putPrivateDoubleAttribute(String str, double d2) {
        if (Hansel.getUser() != null) {
            Hansel.getUser().putPrivateAttribute(str, d2);
        }
    }

    @ReactMethod
    public static void putPrivateStringAttribute(String str, String str2) {
        if (Hansel.getUser() != null) {
            Hansel.getUser().putPrivateAttribute(str, str2);
        }
    }

    @ReactMethod
    public static void putStringAttribute(String str, String str2) {
        if (Hansel.getUser() != null) {
            Hansel.getUser().putAttribute(str, str2);
        }
    }

    @ReactMethod
    public static void setUserId(String str) {
        if (Hansel.getUser() != null) {
            Hansel.getUser().setUserId(str);
        }
    }

    @ReactMethod
    public void getBoolean(String str, boolean z, Promise promise) {
        boolean z2 = HanselConfigs.getBoolean(str, z);
        if (promise != null) {
            promise.resolve(Boolean.valueOf(z2));
        }
    }

    @ReactMethod
    public void getDouble(String str, double d2, Promise promise) {
        double d3 = HanselConfigs.getDouble(str, d2);
        if (promise != null) {
            promise.resolve(Double.valueOf(d3));
        }
    }

    public String getName() {
        return TAG;
    }

    @ReactMethod
    public void getString(String str, String str2, Promise promise) {
        String string = HanselConfigs.getString(str, str2);
        if (promise != null) {
            promise.resolve(string);
        }
    }

    @ReactMethod
    public void updateHanselConfigs(Promise promise) {
        JSONObject allHanselConfigData = CleverTapAnalyticsUtils.getAllHanselConfigData(MBuildConfigUtils.isCashApp() ? CommonUtils.hanselProConfigs : CommonUtils.hanselPlayStoreConfigs);
        ConfigManager.setHanselConfig(allHanselConfigData);
        promise.resolve(allHanselConfigData.toString());
        CleverTapAnalyticsUtils.saveHanselExperienceData();
        CleverTapAnalyticsUtils.saveHanselExperienceVariantData();
    }
}
