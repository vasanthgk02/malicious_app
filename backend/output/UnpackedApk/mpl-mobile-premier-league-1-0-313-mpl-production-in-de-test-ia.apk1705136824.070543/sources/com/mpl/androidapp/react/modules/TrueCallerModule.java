package com.mpl.androidapp.react.modules;

import android.app.Activity;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import com.mpl.androidapp.utils.MLogger;
import org.apache.fontbox.cmap.CMapParser;

@ReactModule(name = "TrueCallerModule")
public class TrueCallerModule extends ReactContextBaseJavaModule {
    public static final String TAG = "TrueCallerModule";

    public TrueCallerModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    private void getUserDetail() {
    }

    private void sendEvent(ReactContext reactContext, String str, WritableMap writableMap) {
        ((RCTDeviceEventEmitter) reactContext.getJSModule(RCTDeviceEventEmitter.class)).emit(str, writableMap);
    }

    @ReactMethod
    public void click(String str, Callback callback, Callback callback2) {
        MLogger.d(TAG, "click() called with: msg = [" + str + "], errorCallback = [" + callback + "], successCallback = [" + callback2 + CMapParser.MARK_END_OF_ARRAY);
    }

    public String getName() {
        return TAG;
    }

    @ReactMethod
    public void initializeClient() {
        Activity currentActivity = getCurrentActivity();
        MLogger.d(TAG, "initializeClient: " + currentActivity);
    }

    @ReactMethod
    public void requestTrueProfile() {
    }
}
