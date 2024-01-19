package com.facebook.reactnative.androidsdk;

import com.facebook.FacebookSdk;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = "FBSettings")
public class FBSettingsModule extends BaseJavaModule {
    public static final String NAME = "FBSettings";

    @ReactMethod
    public static void setDataProcessingOptionsExtra(String[] strArr, int i, int i2) {
        FacebookSdk.setDataProcessingOptions(strArr, i, i2);
    }

    public String getName() {
        return NAME;
    }

    @ReactMethod
    public void setDataProcessingOptions(String[] strArr) {
        FacebookSdk.setDataProcessingOptions(strArr, 0, 0);
    }
}
