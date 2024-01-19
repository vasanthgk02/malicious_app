package com.mpl.androidapp.react.modules;

import android.content.Context;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest.Callback;
import com.facebook.GraphRequest.Companion;
import com.facebook.GraphRequest.GraphJSONObjectCallback;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.mpl.androidapp.react.MPLReactContainerActivity;
import java.util.Arrays;
import org.apache.pdfbox.pdfparser.BaseParser;
import org.json.JSONException;
import org.json.JSONObject;
import sfs2x.client.requests.game.QuickGameJoinRequest;

@ReactModule(name = "SocialLoginModule")
public class SocialLoginModule extends ReactContextBaseJavaModule {
    public static final String TAG = "SocialLoginModule";
    public CallbackManager callbackManager;
    public final Context mContext;

    public SocialLoginModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mContext = reactApplicationContext.getBaseContext();
    }

    @ReactMethod
    private void loginInFacebook(Promise promise) {
        loginThroughFacebook(promise);
    }

    private void loginThroughFacebook(final Promise promise) {
        if (getCurrentActivity() instanceof MPLReactContainerActivity) {
            this.callbackManager = ((MPLReactContainerActivity) getCurrentActivity()).getCallbackManager();
        }
        LoginManager instance = LoginManager.getInstance();
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        if (currentAccessToken != null && !currentAccessToken.isExpired()) {
            instance.logOut();
        }
        if (this.callbackManager == null || getCurrentActivity() == null) {
            promise.reject((String) "fail", (String) "Login Failed");
            return;
        }
        instance.logInWithReadPermissions(getCurrentActivity(), Arrays.asList(new String[]{"public_profile", "email"}));
        instance.registerCallback(this.callbackManager, new FacebookCallback<LoginResult>() {
            public void onCancel() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("isCancelled", BaseParser.TRUE);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                promise.reject(jSONObject.toString());
            }

            public void onError(FacebookException facebookException) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("isCancelled", BaseParser.FALSE);
                    jSONObject.put("errorMessage", facebookException.toString());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                promise.reject(jSONObject.toString());
            }

            public void onSuccess(final LoginResult loginResult) {
                AccessToken accessToken = loginResult.accessToken;
                AccessToken.setCurrentAccessToken(accessToken);
                GraphRequest graphRequest = new GraphRequest(accessToken, QuickGameJoinRequest.KEY_MATCH_EXPRESSION, null, null, new Callback() {
                    public final void onCompleted(GraphResponse graphResponse) {
                        Companion.m132newMeRequest$lambda0(GraphJSONObjectCallback.this, graphResponse);
                    }
                }, null, 32);
                Bundle bundle = new Bundle();
                bundle.putString("fields", "email,name,picture.type(large)");
                graphRequest.setParameters(bundle);
                graphRequest.executeAsync();
            }
        });
    }

    public String getName() {
        return TAG;
    }
}
