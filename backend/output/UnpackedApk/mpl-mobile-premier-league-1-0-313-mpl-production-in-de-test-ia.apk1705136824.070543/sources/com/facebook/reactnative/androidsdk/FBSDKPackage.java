package com.facebook.reactnative.androidsdk;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import java.util.Arrays;
import java.util.List;

public class FBSDKPackage implements ReactPackage {
    public FBActivityEventListener mActivityEventListener = new FBActivityEventListener();

    public List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        return Arrays.asList(new NativeModule[]{new FBAccessTokenModule(reactApplicationContext), new FBAppEventsLoggerModule(reactApplicationContext), new FBAppLinkModule(reactApplicationContext), new FBGameRequestDialogModule(reactApplicationContext, this.mActivityEventListener), new FBGraphRequestModule(reactApplicationContext), new FBLoginManagerModule(reactApplicationContext, this.mActivityEventListener), new FBMessageDialogModule(reactApplicationContext, this.mActivityEventListener), new FBSettingsModule(), new FBShareDialogModule(reactApplicationContext, this.mActivityEventListener)});
    }

    public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        return Arrays.asList(new ViewManager[]{new FBLoginButtonManager(reactApplicationContext), new FBSendButtonManager(), new FBShareButtonManager()});
    }
}
