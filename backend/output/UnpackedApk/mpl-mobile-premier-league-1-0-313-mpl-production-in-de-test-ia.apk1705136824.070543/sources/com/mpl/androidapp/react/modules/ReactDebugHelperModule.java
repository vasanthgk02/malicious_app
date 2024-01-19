package com.mpl.androidapp.react.modules;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.mpl.androidapp.react.MPLReactContainerActivity;
import com.mpl.androidapp.updater.repo.DownloadProgressReceiver;

@ReactModule(name = "ReactDebugHelperModule")
public class ReactDebugHelperModule extends ReactContextBaseJavaModule {
    public static final String TAG = "ReactDebugHelperModule";

    public ReactDebugHelperModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public String getName() {
        return TAG;
    }

    @ReactMethod
    public void showDebugSetting() {
        DownloadProgressReceiver downloadProgressReceiver = MPLReactContainerActivity.resultReceiver;
        if (downloadProgressReceiver != null) {
            downloadProgressReceiver.send(12, null);
        }
    }
}
