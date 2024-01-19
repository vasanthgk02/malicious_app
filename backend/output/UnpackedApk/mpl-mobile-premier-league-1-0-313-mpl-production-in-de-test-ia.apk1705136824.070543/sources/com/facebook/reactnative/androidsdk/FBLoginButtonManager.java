package com.facebook.reactnative.androidsdk;

import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.login.DefaultAudience;
import com.facebook.login.LoginBehavior;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

public class FBLoginButtonManager extends SimpleViewManager<RCTLoginButton> {
    public static final String REACT_CLASS = "RCTFBLoginButton";
    public FBActivityEventListener mActivityEventListener;

    public FBLoginButtonManager(ReactApplicationContext reactApplicationContext) {
        FBActivityEventListener fBActivityEventListener = new FBActivityEventListener();
        this.mActivityEventListener = fBActivityEventListener;
        reactApplicationContext.addActivityEventListener(fBActivityEventListener);
    }

    public String getName() {
        return REACT_CLASS;
    }

    @ReactProp(name = "defaultAudience")
    public void setDefaultAudience(RCTLoginButton rCTLoginButton, String str) {
        rCTLoginButton.setDefaultAudience(DefaultAudience.valueOf(str.toUpperCase()));
    }

    @ReactProp(name = "loginBehaviorAndroid")
    public void setLoginBehavior(RCTLoginButton rCTLoginButton, String str) {
        rCTLoginButton.setLoginBehavior(LoginBehavior.valueOf(str.toUpperCase()));
    }

    @ReactProp(name = "permissions")
    public void setPermissions(RCTLoginButton rCTLoginButton, ReadableArray readableArray) {
        rCTLoginButton.setPermissions(ImageOriginUtils.reactArrayToStringList(readableArray));
    }

    public RCTLoginButton createViewInstance(ThemedReactContext themedReactContext) {
        return new RCTLoginButton(themedReactContext, this.mActivityEventListener.mCallbackManager);
    }
}
