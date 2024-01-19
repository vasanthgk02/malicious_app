package com.mpl.androidapp.react.modules;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = "SendBirdModule")
public class SendBirdModule extends ReactContextBaseJavaModule {
    public static final String TAG = "SendBirdModule";

    public SendBirdModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public void getAllGroupChannelListByLimit(String str, Promise promise) {
    }

    public String getName() {
        return TAG;
    }
}
