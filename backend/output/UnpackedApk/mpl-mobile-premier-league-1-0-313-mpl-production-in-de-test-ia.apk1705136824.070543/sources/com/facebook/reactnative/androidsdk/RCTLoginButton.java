package com.facebook.reactnative.androidsdk;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.facebook.login.widget.LoginButton.ToolTipMode;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.mpl.androidapp.login.LoginReactModule;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

public class RCTLoginButton extends LoginButton {
    public CallbackManager mCallbackManager;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public RCTLoginButton(ThemedReactContext themedReactContext, CallbackManager callbackManager) {
        // Intrinsics.checkNotNullParameter(themedReactContext, "context");
        super(themedReactContext, null, 0, 0, "fb_login_button_create", "fb_login_button_did_tap");
        setToolTipMode(ToolTipMode.NEVER_DISPLAY);
        this.mCallbackManager = callbackManager;
        new AccessTokenTracker() {
            public void onCurrentAccessTokenChanged(AccessToken accessToken, AccessToken accessToken2) {
                if (accessToken2 == null) {
                    WritableMap createMap = Arguments.createMap();
                    createMap.putString("type", "logoutFinished");
                    ((RCTEventEmitter) ((ReactContext) RCTLoginButton.this.getContext()).getJSModule(RCTEventEmitter.class)).receiveEvent(RCTLoginButton.this.getId(), "topChange", createMap);
                }
            }
        };
        CallbackManager callbackManager2 = this.mCallbackManager;
        AnonymousClass2 r10 = new FacebookCallback<LoginResult>() {
            public void onCancel() {
                WritableMap createMap = Arguments.createMap();
                createMap.putString("type", "loginFinished");
                createMap.putString("error", null);
                WritableMap createMap2 = Arguments.createMap();
                createMap2.putBoolean("isCancelled", true);
                createMap.putMap(LoginReactModule.RESULT, createMap2);
                ((RCTEventEmitter) ((ReactContext) RCTLoginButton.this.getContext()).getJSModule(RCTEventEmitter.class)).receiveEvent(RCTLoginButton.this.getId(), "topChange", createMap);
            }

            public void onError(FacebookException facebookException) {
                WritableMap createMap = Arguments.createMap();
                createMap.putString("type", "loginFinished");
                createMap.putString("error", facebookException.toString());
                WritableMap createMap2 = Arguments.createMap();
                createMap2.putBoolean("isCancelled", false);
                createMap.putMap(LoginReactModule.RESULT, createMap2);
                ((RCTEventEmitter) ((ReactContext) RCTLoginButton.this.getContext()).getJSModule(RCTEventEmitter.class)).receiveEvent(RCTLoginButton.this.getId(), "topChange", createMap);
            }

            public void onSuccess(Object obj) {
                LoginResult loginResult = (LoginResult) obj;
                WritableMap createMap = Arguments.createMap();
                createMap.putString("type", "loginFinished");
                createMap.putString("error", null);
                WritableMap createMap2 = Arguments.createMap();
                createMap2.putBoolean("isCancelled", false);
                createMap2.putArray("grantedPermissions", Arguments.fromJavaArgs(RCTLoginButton.access$000(RCTLoginButton.this, loginResult.recentlyGrantedPermissions)));
                createMap2.putArray("declinedPermissions", Arguments.fromJavaArgs(RCTLoginButton.access$000(RCTLoginButton.this, loginResult.recentlyDeniedPermissions)));
                createMap.putMap(LoginReactModule.RESULT, createMap2);
                ((RCTEventEmitter) ((ReactContext) RCTLoginButton.this.getContext()).getJSModule(RCTEventEmitter.class)).receiveEvent(RCTLoginButton.this.getId(), "topChange", createMap);
            }
        };
        Intrinsics.checkNotNullParameter(callbackManager2, "callbackManager");
        Intrinsics.checkNotNullParameter(r10, "callback");
        ((LoginManager) this.loginManagerLazy.getValue()).registerCallback(callbackManager2, r10);
        if (this.callbackManager == null) {
            this.callbackManager = callbackManager2;
        }
    }

    public static String[] access$000(RCTLoginButton rCTLoginButton, Set<String> set) {
        if (rCTLoginButton != null) {
            String[] strArr = new String[set.size()];
            int i = 0;
            for (String str : set) {
                strArr[i] = str;
                i++;
            }
            return strArr;
        }
        throw null;
    }
}
