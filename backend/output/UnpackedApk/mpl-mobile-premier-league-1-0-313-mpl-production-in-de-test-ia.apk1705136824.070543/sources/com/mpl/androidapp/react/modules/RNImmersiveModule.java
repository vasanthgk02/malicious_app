package com.mpl.androidapp.react.modules;

import android.annotation.TargetApi;
import android.app.Activity;
import android.view.View.OnSystemUiVisibilityChangeListener;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;

public class RNImmersiveModule extends ReactContextBaseJavaModule {
    public static final String ERROR_NO_ACTIVITY = "E_NO_ACTIVITY";
    public static final String ERROR_NO_ACTIVITY_MESSAGE = "Tried to set immersive while not attached to an Activity";
    public static RNImmersiveModule SINGLETON = null;
    public static final int UI_FLAG_IMMERSIVE = 5894;
    public boolean _isImmersiveOn = false;
    public ReactContext _reactContext = null;

    public RNImmersiveModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this._reactContext = reactApplicationContext;
        SINGLETON = this;
    }

    private void _addImmersiveListener() {
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            UiThreadUtil.runOnUiThread(new Runnable() {
                @TargetApi(19)
                public void run() {
                    currentActivity.getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new OnSystemUiVisibilityChangeListener() {
                        public void onSystemUiVisibilityChange(int i) {
                            if (((i & 5894) != 0) != RNImmersiveModule.this._isImmersiveOn) {
                                RNImmersiveModule.this.emitImmersiveStateChangeEvent();
                            }
                        }
                    });
                }
            });
        }
    }

    private void _getImmersive(final Promise promise) {
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            promise.reject((String) "E_NO_ACTIVITY", (String) ERROR_NO_ACTIVITY_MESSAGE);
        } else {
            UiThreadUtil.runOnUiThread(new Runnable() {
                @TargetApi(19)
                public void run() {
                    boolean z = (currentActivity.getWindow().getDecorView().getSystemUiVisibility() & 5894) != 0;
                    WritableMap createMap = Arguments.createMap();
                    createMap.putBoolean("isImmersiveOn", z);
                    promise.resolve(createMap);
                }
            });
        }
    }

    private void _setImmersive(final boolean z, final Promise promise) {
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            promise.reject((String) "E_NO_ACTIVITY", (String) ERROR_NO_ACTIVITY_MESSAGE);
        } else {
            UiThreadUtil.runOnUiThread(new Runnable() {
                @TargetApi(19)
                public void run() {
                    RNImmersiveModule.this._isImmersiveOn = z;
                    currentActivity.getWindow().getDecorView().setSystemUiVisibility(z ? 5894 : 0);
                    promise.resolve(null);
                }
            });
        }
    }

    public static RNImmersiveModule getInstance() {
        return SINGLETON;
    }

    @ReactMethod
    public void addImmersiveListener() {
        _addImmersiveListener();
    }

    public void emitImmersiveStateChangeEvent() {
        ReactContext reactContext = this._reactContext;
        if (reactContext != null) {
            ((RCTDeviceEventEmitter) reactContext.getJSModule(RCTDeviceEventEmitter.class)).emit("@@IMMERSIVE_STATE_CHANGED", null);
        }
    }

    @ReactMethod
    public void getImmersive(Promise promise) {
        _getImmersive(promise);
    }

    public String getName() {
        return "RNImmersive";
    }

    public void onCatalystInstanceDestroy() {
        this._reactContext = null;
        SINGLETON = null;
    }

    @ReactMethod
    public void setImmersive(boolean z, Promise promise) {
        _setImmersive(z, promise);
    }
}
