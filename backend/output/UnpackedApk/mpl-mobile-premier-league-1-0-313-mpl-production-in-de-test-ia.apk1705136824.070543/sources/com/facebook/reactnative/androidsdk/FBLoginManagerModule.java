package com.facebook.reactnative.androidsdk;

import android.app.Activity;
import com.facebook.AccessToken;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.login.DefaultAudience;
import com.facebook.login.LoginBehavior;
import com.facebook.login.LoginConfiguration;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

@ReactModule(name = "FBLoginManager")
public class FBLoginManagerModule extends FBSDKCallbackManagerBaseJavaModule {
    public static final String NAME = "FBLoginManager";

    public class LoginManagerCallback extends ReactNativeFacebookSDKCallback<LoginResult> {
        public LoginManagerCallback(Promise promise) {
            super(promise);
        }

        public void onSuccess(Object obj) {
            LoginResult loginResult = (LoginResult) obj;
            if (this.mPromise != null) {
                AccessToken.setCurrentAccessToken(loginResult.accessToken);
                WritableMap createMap = Arguments.createMap();
                createMap.putBoolean("isCancelled", false);
                createMap.putArray("grantedPermissions", FBLoginManagerModule.this.setToWritableArray(loginResult.recentlyGrantedPermissions));
                createMap.putArray("declinedPermissions", FBLoginManagerModule.this.setToWritableArray(loginResult.recentlyDeniedPermissions));
                this.mPromise.resolve(createMap);
                this.mPromise = null;
            }
        }
    }

    public FBLoginManagerModule(ReactApplicationContext reactApplicationContext, FBActivityEventListener fBActivityEventListener) {
        super(reactApplicationContext, fBActivityEventListener);
    }

    /* access modifiers changed from: private */
    public WritableArray setToWritableArray(Set<String> set) {
        WritableArray createArray = Arguments.createArray();
        for (String pushString : set) {
            createArray.pushString(pushString);
        }
        return createArray;
    }

    @ReactMethod
    public void getDefaultAudience(Promise promise) {
        promise.resolve(LoginManager.getInstance().defaultAudience.name().toLowerCase());
    }

    @ReactMethod
    public void getLoginBehavior(Promise promise) {
        promise.resolve(LoginManager.getInstance().loginBehavior.name().toLowerCase());
    }

    public String getName() {
        return NAME;
    }

    @ReactMethod
    public void logInWithPermissions(ReadableArray readableArray, Promise promise) {
        LoginManager instance = LoginManager.getInstance();
        instance.registerCallback(getCallbackManager(), new LoginManagerCallback(promise));
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            List<String> reactArrayToStringList = ImageOriginUtils.reactArrayToStringList(readableArray);
            Intrinsics.checkNotNullParameter(currentActivity, "activity");
            instance.logIn(currentActivity, new LoginConfiguration(reactArrayToStringList, null, 2));
        }
    }

    @ReactMethod
    public void logOut() {
        LoginManager.getInstance().logOut();
    }

    @ReactMethod
    public void setDefaultAudience(String str) {
        LoginManager.getInstance().setDefaultAudience(DefaultAudience.valueOf(str.toUpperCase()));
    }

    @ReactMethod
    public void setLoginBehavior(String str) {
        LoginManager.getInstance().setLoginBehavior(LoginBehavior.valueOf(str.toUpperCase()));
    }
}
