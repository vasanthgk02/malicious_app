package com.facebook.fbreact.specs;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReactModuleWithSpec;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;

public abstract class NativeWebSocketModuleSpec extends ReactContextBaseJavaModule implements ReactModuleWithSpec, TurboModule {
    public NativeWebSocketModuleSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public abstract void addListener(String str);

    @ReactMethod
    public abstract void close(double d2, String str, double d3);

    @ReactMethod
    public abstract void connect(String str, ReadableArray readableArray, ReadableMap readableMap, double d2);

    @ReactMethod
    public abstract void ping(double d2);

    @ReactMethod
    public abstract void removeListeners(double d2);

    @ReactMethod
    public abstract void send(String str, double d2);

    @ReactMethod
    public abstract void sendBinary(String str, double d2);
}
