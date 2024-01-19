package com.mpl.androidapp.react.modules;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.mpl.androidapp.utils.MLogger;

@ReactModule(name = "CrashLogModule")
public class CrashLogModule extends ReactContextBaseJavaModule {
    public static final String TAG = "CrashLogModule";

    public CrashLogModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public String getName() {
        return TAG;
    }

    @ReactMethod
    public void log(String str, String str2) {
        MLogger.d(TAG, str, str2);
    }

    @ReactMethod
    public void log(String str) {
        log(0, TAG, str);
        MLogger.d(TAG, str);
    }

    @ReactMethod
    public void log(int i, String str, String str2) {
        MLogger.d(TAG, str, str2);
    }
}
