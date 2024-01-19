package com.mpl.androidapp.ads;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = "AdsModule")
public class AdsModule extends ReactContextBaseJavaModule {
    public static final String TAG = "AdsModule";

    public AdsModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public String getName() {
        return TAG;
    }
}
