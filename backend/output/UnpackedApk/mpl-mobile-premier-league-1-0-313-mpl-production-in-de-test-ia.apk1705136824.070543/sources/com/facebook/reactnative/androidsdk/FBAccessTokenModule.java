package com.facebook.reactnative.androidsdk;

import com.facebook.AccessToken;
import com.facebook.AccessToken.AccessTokenRefreshCallback;
import com.facebook.AccessTokenSource;
import com.facebook.AccessTokenTracker;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import java.util.Date;

@ReactModule(name = "FBAccessToken")
public class FBAccessTokenModule extends ReactContextBaseJavaModule {
    public static final String CHANGE_EVENT_NAME = "fbsdk.accessTokenDidChange";
    public static final String NAME = "FBAccessToken";
    public AccessTokenTracker accessTokenTracker;
    public final ReactApplicationContext mReactContext;

    public FBAccessTokenModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mReactContext = reactApplicationContext;
    }

    @ReactMethod
    public void getCurrentAccessToken(Callback callback) {
        WritableMap writableMap;
        Object[] objArr = new Object[1];
        if (AccessToken.getCurrentAccessToken() == null) {
            writableMap = null;
        } else {
            writableMap = ImageOriginUtils.accessTokenToReactMap(AccessToken.getCurrentAccessToken());
        }
        objArr[0] = writableMap;
        callback.invoke(objArr);
    }

    public String getName() {
        return NAME;
    }

    public void initialize() {
        super.initialize();
        this.accessTokenTracker = new AccessTokenTracker() {
            public void onCurrentAccessTokenChanged(AccessToken accessToken, AccessToken accessToken2) {
                WritableMap writableMap;
                try {
                    RCTDeviceEventEmitter rCTDeviceEventEmitter = (RCTDeviceEventEmitter) FBAccessTokenModule.this.mReactContext.getJSModule(RCTDeviceEventEmitter.class);
                    if (accessToken2 == null) {
                        writableMap = null;
                    } else {
                        writableMap = ImageOriginUtils.accessTokenToReactMap(accessToken2);
                    }
                    rCTDeviceEventEmitter.emit(FBAccessTokenModule.CHANGE_EVENT_NAME, writableMap);
                } catch (RuntimeException unused) {
                }
            }
        };
    }

    public void onCatalystInstanceDestroy() {
        super.onCatalystInstanceDestroy();
        AccessTokenTracker accessTokenTracker2 = this.accessTokenTracker;
        if (accessTokenTracker2.isTracking) {
            accessTokenTracker2.broadcastManager.unregisterReceiver(accessTokenTracker2.receiver);
            accessTokenTracker2.isTracking = false;
        }
    }

    @ReactMethod
    public void refreshCurrentAccessTokenAsync(final Promise promise) {
        AccessToken.refreshCurrentAccessTokenAsync(new AccessTokenRefreshCallback(this) {
        });
    }

    @ReactMethod
    public void setCurrentAccessToken(ReadableMap readableMap) {
        AccessToken accessToken = new AccessToken(readableMap.getString("accessToken"), readableMap.getString("applicationID"), readableMap.getString("userID"), ImageOriginUtils.reactArrayToStringList(readableMap.getArray("permissions")), ImageOriginUtils.reactArrayToStringList(readableMap.getArray("declinedPermissions")), ImageOriginUtils.reactArrayToStringList(readableMap.getArray("expiredPermissions")), AccessTokenSource.valueOf(readableMap.getString("accessTokenSource")), new Date((long) readableMap.getDouble("expirationTime")), new Date((long) readableMap.getDouble("lastRefreshTime")), new Date((long) readableMap.getDouble("dataAccessExpirationTime")));
        AccessToken.setCurrentAccessToken(accessToken);
    }
}
