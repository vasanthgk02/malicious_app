package com.mpl.androidapp.react.modules;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = "AddsModule")
public class AddsModule extends ReactContextBaseJavaModule {
    public static final String TAG = "AddsModule";

    public AddsModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    private void showAddsFromNative() {
    }

    public String getName() {
        return TAG;
    }

    @ReactMethod
    public void showAdd(Promise promise) {
    }
}
