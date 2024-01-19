package com.facebook.reactnative.androidsdk;

import com.facebook.CallbackManager;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;

public abstract class FBSDKCallbackManagerBaseJavaModule extends ReactContextBaseJavaModule {
    public final FBActivityEventListener mActivityEventListener;

    public FBSDKCallbackManagerBaseJavaModule(ReactApplicationContext reactApplicationContext, FBActivityEventListener fBActivityEventListener) {
        super(reactApplicationContext);
        this.mActivityEventListener = fBActivityEventListener;
        reactApplicationContext.addActivityEventListener(fBActivityEventListener);
    }

    public CallbackManager getCallbackManager() {
        return this.mActivityEventListener.mCallbackManager;
    }
}
