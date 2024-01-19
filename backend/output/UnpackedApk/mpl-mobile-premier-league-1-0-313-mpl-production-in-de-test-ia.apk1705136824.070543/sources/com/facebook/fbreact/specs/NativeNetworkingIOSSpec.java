package com.facebook.fbreact.specs;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReactModuleWithSpec;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;

public abstract class NativeNetworkingIOSSpec extends ReactContextBaseJavaModule implements ReactModuleWithSpec, TurboModule {
    public NativeNetworkingIOSSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public abstract void abortRequest(double d2);

    @ReactMethod
    public abstract void addListener(String str);

    @ReactMethod
    public abstract void clearCookies(Callback callback);

    @ReactMethod
    public abstract void removeListeners(double d2);

    @ReactMethod
    public abstract void sendRequest(ReadableMap readableMap, Callback callback);
}
