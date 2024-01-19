package com.mpl.androidapp.react.modules;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = "IronSourceModules")
public class IronSourceModules extends ReactContextBaseJavaModule {
    public static final String TAG = "IronSourceModules";

    public IronSourceModules(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    private void addListener(Promise promise) {
    }

    public String getName() {
        return TAG;
    }

    @ReactMethod
    public void hideAdd() {
    }

    @ReactMethod
    public void hideAddAtScreen(String str, Promise promise) {
    }

    @ReactMethod
    public void showAdd(Promise promise) {
        promise.resolve("onRewardedVideoAdClosed");
    }

    @ReactMethod
    public void showAddAtScreen(String str, Promise promise) {
        promise.resolve("onRewardedVideoAdClosed");
    }
}
