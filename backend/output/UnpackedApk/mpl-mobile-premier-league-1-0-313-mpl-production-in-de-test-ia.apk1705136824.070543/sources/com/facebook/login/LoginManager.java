package com.facebook.login;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.AccessToken;
import com.facebook.AuthenticationToken;
import com.facebook.CallbackManager;
import com.facebook.CallbackManager.ActivityResultParameters;
import com.facebook.FacebookActivity;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.CallbackManagerImpl.Callback;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.internal.CustomTabUtils;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.Validate;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.login.LoginClient.Request;
import com.facebook.login.LoginClient.Result.Code;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import com.razorpay.AnalyticsConstants;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000è\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u0000 y2\u00020\u0001:\u0006wxyz{|B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u001e\u001a\u00060\u001fR\u00020\u00002\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0004H\u0007J\u0018\u0010#\u001a\u00020$2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010&H\u0014J\u0010\u0010'\u001a\u00020$2\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u0010*\u001a\u00020$2\u0006\u0010+\u001a\u00020,H\u0014J\b\u0010-\u001a\u00020$H\u0014JH\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u0001012\b\u00102\u001a\u0004\u0018\u0001032\b\u00104\u001a\u0004\u0018\u00010$2\b\u00105\u001a\u0004\u0018\u0001062\u0006\u00107\u001a\u00020\r2\u000e\u00108\u001a\n\u0012\u0004\u0012\u00020:\u0018\u000109H\u0002J\u0010\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020$H\u0014JL\u0010>\u001a\u00020/2\b\u0010?\u001a\u0004\u0018\u00010@2\u0006\u0010A\u001a\u00020B2\u0014\u0010C\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010D2\b\u00105\u001a\u0004\u0018\u00010E2\u0006\u0010F\u001a\u00020\r2\b\u0010=\u001a\u0004\u0018\u00010$H\u0002J\u0016\u0010G\u001a\u00020/2\u0006\u0010H\u001a\u00020I2\u0006\u0010+\u001a\u00020,J\u001e\u0010G\u001a\u00020/2\u0006\u0010H\u001a\u00020I2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010&J(\u0010G\u001a\u00020/2\u0006\u0010H\u001a\u00020I2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010&2\b\u0010\"\u001a\u0004\u0018\u00010\u0004J\u001e\u0010G\u001a\u00020/2\u0006\u0010J\u001a\u00020K2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010&J(\u0010G\u001a\u00020/2\u0006\u0010J\u001a\u00020K2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010&2\b\u0010\"\u001a\u0004\u0018\u00010\u0004J \u0010G\u001a\u00020/2\u0006\u0010L\u001a\u00020M2\u0006\u0010 \u001a\u00020!2\u0006\u0010+\u001a\u00020,H\u0002J$\u0010G\u001a\u00020/2\u0006\u0010L\u001a\u00020M2\u0006\u0010 \u001a\u00020!2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040&J.\u0010G\u001a\u00020/2\u0006\u0010L\u001a\u00020M2\u0006\u0010 \u001a\u00020!2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040&2\b\u0010\"\u001a\u0004\u0018\u00010\u0004J\u001e\u0010G\u001a\u00020/2\u0006\u0010J\u001a\u00020N2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010&J(\u0010G\u001a\u00020/2\u0006\u0010J\u001a\u00020N2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010&2\b\u0010\"\u001a\u0004\u0018\u00010\u0004J\u0016\u0010G\u001a\u00020/2\u0006\u0010J\u001a\u00020O2\u0006\u0010+\u001a\u00020,J\u001e\u0010G\u001a\u00020/2\u0006\u0010J\u001a\u00020O2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010&J(\u0010G\u001a\u00020/2\u0006\u0010J\u001a\u00020O2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010&2\b\u0010\"\u001a\u0004\u0018\u00010\u0004J\u0016\u0010P\u001a\u00020/2\u0006\u0010J\u001a\u00020N2\u0006\u0010+\u001a\u00020,J\u001e\u0010Q\u001a\u00020/2\u0006\u0010H\u001a\u00020I2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010&J\u001c\u0010Q\u001a\u00020/2\u0006\u0010J\u001a\u00020K2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040&J$\u0010Q\u001a\u00020/2\u0006\u0010L\u001a\u00020M2\u0006\u0010 \u001a\u00020!2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040&J$\u0010Q\u001a\u00020/2\u0006\u0010J\u001a\u00020N2\u0006\u0010 \u001a\u00020!2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040&J\u001e\u0010Q\u001a\u00020/2\u0006\u0010J\u001a\u00020N2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040&H\u0007J\u001e\u0010Q\u001a\u00020/2\u0006\u0010J\u001a\u00020O2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040&H\u0002J\u001e\u0010R\u001a\u00020/2\u0006\u0010H\u001a\u00020I2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010&J\u001c\u0010R\u001a\u00020/2\u0006\u0010J\u001a\u00020K2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040&J$\u0010R\u001a\u00020/2\u0006\u0010L\u001a\u00020M2\u0006\u0010 \u001a\u00020!2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040&J$\u0010R\u001a\u00020/2\u0006\u0010J\u001a\u00020N2\u0006\u0010 \u001a\u00020!2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040&J\u001e\u0010R\u001a\u00020/2\u0006\u0010J\u001a\u00020N2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040&H\u0007J\u001e\u0010R\u001a\u00020/2\u0006\u0010J\u001a\u00020O2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040&H\u0002J\b\u0010S\u001a\u00020/H\u0016J\u001c\u0010T\u001a\u00020/2\b\u0010?\u001a\u0004\u0018\u00010@2\b\u0010U\u001a\u0004\u0018\u00010$H\u0002J\u0016\u0010V\u001a\u00020/2\u0006\u0010H\u001a\u00020I2\u0006\u0010+\u001a\u00020,J\u0018\u0010V\u001a\u00020/2\u0006\u0010J\u001a\u00020O2\u0006\u0010+\u001a\u00020,H\u0002J,\u0010W\u001a\u00020\r2\u0006\u0010X\u001a\u00020Y2\b\u0010Z\u001a\u0004\u0018\u00010<2\u0010\b\u0002\u00108\u001a\n\u0012\u0004\u0012\u00020:\u0018\u000109H\u0017J\u000e\u0010[\u001a\u00020/2\u0006\u0010H\u001a\u00020IJ\u000e\u0010[\u001a\u00020/2\u0006\u0010J\u001a\u00020NJ\u0010\u0010[\u001a\u00020/2\u0006\u0010J\u001a\u00020OH\u0002J \u0010\\\u001a\u00020/2\b\u0010 \u001a\u0004\u0018\u00010!2\u000e\u00108\u001a\n\u0012\u0004\u0012\u00020:\u0018\u000109J\u0016\u0010]\u001a\u00020/2\u0006\u0010H\u001a\u00020I2\u0006\u0010(\u001a\u00020)J\u0016\u0010]\u001a\u00020/2\u0006\u0010J\u001a\u00020K2\u0006\u0010(\u001a\u00020)J\u001e\u0010]\u001a\u00020/2\u0006\u0010L\u001a\u00020M2\u0006\u0010 \u001a\u00020!2\u0006\u0010(\u001a\u00020)J\u001e\u0010]\u001a\u00020/2\u0006\u0010J\u001a\u00020N2\u0006\u0010 \u001a\u00020!2\u0006\u0010(\u001a\u00020)J\u0018\u0010]\u001a\u00020/2\u0006\u0010J\u001a\u00020N2\u0006\u0010(\u001a\u00020)H\u0007J\u0018\u0010]\u001a\u00020/2\u0006\u0010J\u001a\u00020O2\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u0010^\u001a\u00020\r2\u0006\u0010_\u001a\u00020<H\u0002J\u0016\u0010`\u001a\u00020/2\u0006\u0010?\u001a\u00020@2\u0006\u0010a\u001a\u00020bJ\u001e\u0010`\u001a\u00020/2\u0006\u0010?\u001a\u00020@2\u0006\u0010c\u001a\u00020d2\u0006\u0010a\u001a\u00020bJ \u0010e\u001a\u00020/2\u0006\u0010?\u001a\u00020@2\u0006\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00020dH\u0002J\u000e\u0010f\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010g\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\bJ\u0010\u0010h\u001a\u00020/2\u0006\u0010\f\u001a\u00020\rH\u0002J\u000e\u0010i\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\rJ\u000e\u0010j\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010k\u001a\u00020\u00002\u0006\u0010l\u001a\u00020\u0014J\u0010\u0010m\u001a\u00020\u00002\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004J\u000e\u0010n\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\rJ\u000e\u0010o\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\rJ\u0018\u0010p\u001a\u00020/2\u0006\u0010q\u001a\u00020r2\u0006\u0010=\u001a\u00020$H\u0002J\u0018\u0010s\u001a\u00020\r2\u0006\u0010q\u001a\u00020r2\u0006\u0010=\u001a\u00020$H\u0002J\u0010\u0010t\u001a\u00020/2\b\u0010 \u001a\u0004\u0018\u00010!J\u0018\u0010u\u001a\u00020/2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010&H\u0002J\u0018\u0010v\u001a\u00020/2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010&H\u0002R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\b@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8BX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u001e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0010@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0014@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u000e¨\u0006}"}, d2 = {"Lcom/facebook/login/LoginManager;", "", "()V", "<set-?>", "", "authType", "getAuthType", "()Ljava/lang/String;", "Lcom/facebook/login/DefaultAudience;", "defaultAudience", "getDefaultAudience", "()Lcom/facebook/login/DefaultAudience;", "isExpressLoginAllowed", "", "()Z", "isFamilyLogin", "Lcom/facebook/login/LoginBehavior;", "loginBehavior", "getLoginBehavior", "()Lcom/facebook/login/LoginBehavior;", "Lcom/facebook/login/LoginTargetApp;", "loginTargetApp", "getLoginTargetApp", "()Lcom/facebook/login/LoginTargetApp;", "messengerPageId", "resetMessengerState", "sharedPreferences", "Landroid/content/SharedPreferences;", "shouldSkipAccountDeduplication", "getShouldSkipAccountDeduplication", "createLogInActivityResultContract", "Lcom/facebook/login/LoginManager$FacebookLoginActivityResultContract;", "callbackManager", "Lcom/facebook/CallbackManager;", "loggerID", "createLoginRequest", "Lcom/facebook/login/LoginClient$Request;", "permissions", "", "createLoginRequestFromResponse", "response", "Lcom/facebook/GraphResponse;", "createLoginRequestWithConfig", "loginConfig", "Lcom/facebook/login/LoginConfiguration;", "createReauthorizeRequest", "finishLogin", "", "newToken", "Lcom/facebook/AccessToken;", "newIdToken", "Lcom/facebook/AuthenticationToken;", "origRequest", "exception", "Lcom/facebook/FacebookException;", "isCanceled", "callback", "Lcom/facebook/FacebookCallback;", "Lcom/facebook/login/LoginResult;", "getFacebookActivityIntent", "Landroid/content/Intent;", "request", "logCompleteLogin", "context", "Landroid/content/Context;", "result", "Lcom/facebook/login/LoginClient$Result$Code;", "resultExtras", "", "Ljava/lang/Exception;", "wasLoginActivityTried", "logIn", "activity", "Landroid/app/Activity;", "fragment", "Landroid/app/Fragment;", "activityResultRegistryOwner", "Landroidx/activity/result/ActivityResultRegistryOwner;", "Landroidx/fragment/app/Fragment;", "Lcom/facebook/internal/FragmentWrapper;", "logInWithConfiguration", "logInWithPublishPermissions", "logInWithReadPermissions", "logOut", "logStartLogin", "loginRequest", "loginWithConfiguration", "onActivityResult", "resultCode", "", "data", "reauthorizeDataAccess", "registerCallback", "resolveError", "resolveIntent", "intent", "retrieveLoginStatus", "responseCallback", "Lcom/facebook/LoginStatusCallback;", "toastDurationMs", "", "retrieveLoginStatusImpl", "setAuthType", "setDefaultAudience", "setExpressLoginStatus", "setFamilyLogin", "setLoginBehavior", "setLoginTargetApp", "targetApp", "setMessengerPageId", "setResetMessengerState", "setShouldSkipAccountDeduplication", "startLogin", "startActivityDelegate", "Lcom/facebook/login/StartActivityDelegate;", "tryFacebookActivity", "unregisterCallback", "validatePublishPermissions", "validateReadPermissions", "ActivityStartActivityDelegate", "AndroidxActivityResultRegistryOwnerStartActivityDelegate", "Companion", "FacebookLoginActivityResultContract", "FragmentStartActivityDelegate", "LoginLoggerHolder", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: LoginManager.kt */
public class LoginManager {
    public static final Companion Companion;
    public static final Set<String> OTHER_PUBLISH_PERMISSIONS = TweetUtils.setOf((T[]) new String[]{"ads_management", "create_event", "rsvp_event"});
    public static final String TAG;
    public static volatile LoginManager instance;
    public String authType = "rerequest";
    public DefaultAudience defaultAudience = DefaultAudience.FRIENDS;
    public boolean isFamilyLogin;
    public LoginBehavior loginBehavior = LoginBehavior.NATIVE_WITH_FALLBACK;
    public LoginTargetApp loginTargetApp = LoginTargetApp.FACEBOOK;
    public String messengerPageId;
    public boolean resetMessengerState;
    public final SharedPreferences sharedPreferences;
    public boolean shouldSkipAccountDeduplication;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/facebook/login/LoginManager$ActivityStartActivityDelegate;", "Lcom/facebook/login/StartActivityDelegate;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "activityContext", "getActivityContext", "()Landroid/app/Activity;", "startActivityForResult", "", "intent", "Landroid/content/Intent;", "requestCode", "", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: LoginManager.kt */
    public static final class ActivityStartActivityDelegate implements StartActivityDelegate {
        public final Activity activityContext;

        public ActivityStartActivityDelegate(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            this.activityContext = activity;
        }

        public Activity getActivityContext() {
            return this.activityContext;
        }

        public void startActivityForResult(Intent intent, int i) {
            Intrinsics.checkNotNullParameter(intent, AnalyticsConstants.INTENT);
            this.activityContext.startActivityForResult(intent, i);
        }
    }

    @Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007J \u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0007J\b\u0010\u001c\u001a\u00020\fH\u0017J2\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0002J\u0012\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u00078BX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006)"}, d2 = {"Lcom/facebook/login/LoginManager$Companion;", "", "()V", "EXPRESS_LOGIN_ALLOWED", "", "MANAGE_PERMISSION_PREFIX", "OTHER_PUBLISH_PERMISSIONS", "", "PREFERENCE_LOGIN_MANAGER", "PUBLISH_PERMISSION_PREFIX", "TAG", "instance", "Lcom/facebook/login/LoginManager;", "otherPublishPermissions", "getOtherPublishPermissions", "()Ljava/util/Set;", "computeLoginResult", "Lcom/facebook/login/LoginResult;", "request", "Lcom/facebook/login/LoginClient$Request;", "newToken", "Lcom/facebook/AccessToken;", "newIdToken", "Lcom/facebook/AuthenticationToken;", "getExtraDataFromIntent", "", "intent", "Landroid/content/Intent;", "getInstance", "handleLoginStatusError", "", "errorType", "errorDescription", "loggerRef", "logger", "Lcom/facebook/login/LoginLogger;", "responseCallback", "Lcom/facebook/LoginStatusCallback;", "isPublishPermission", "", "permission", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: LoginManager.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public LoginManager getInstance() {
            if (LoginManager.instance == null) {
                synchronized (this) {
                    Companion companion = LoginManager.Companion;
                    LoginManager.instance = new LoginManager();
                }
            }
            LoginManager loginManager = LoginManager.instance;
            if (loginManager != null) {
                return loginManager;
            }
            Intrinsics.throwUninitializedPropertyAccessException(DefaultSettingsSpiCall.INSTANCE_PARAM);
            throw null;
        }

        public final boolean isPublishPermission(String str) {
            if (str == null) {
                return false;
            }
            if (CharsKt__CharKt.startsWith$default(str, (String) "publish", false, 2) || CharsKt__CharKt.startsWith$default(str, (String) "manage", false, 2) || LoginManager.OTHER_PUBLISH_PERMISSIONS.contains(str)) {
                return true;
            }
            return false;
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0004\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001B\u001d\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u001e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u001a\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0012H\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/facebook/login/LoginManager$FacebookLoginActivityResultContract;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "", "Lcom/facebook/CallbackManager$ActivityResultParameters;", "callbackManager", "Lcom/facebook/CallbackManager;", "loggerID", "(Lcom/facebook/login/LoginManager;Lcom/facebook/CallbackManager;Ljava/lang/String;)V", "getCallbackManager", "()Lcom/facebook/CallbackManager;", "setCallbackManager", "(Lcom/facebook/CallbackManager;)V", "getLoggerID", "()Ljava/lang/String;", "setLoggerID", "(Ljava/lang/String;)V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "permissions", "parseResult", "resultCode", "", "intent", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: LoginManager.kt */
    public final class FacebookLoginActivityResultContract extends ActivityResultContract<Collection<? extends String>, ActivityResultParameters> {
        public CallbackManager callbackManager;
        public String loggerID;
        public final /* synthetic */ LoginManager this$0;

        public FacebookLoginActivityResultContract(LoginManager loginManager, CallbackManager callbackManager2, String str) {
            Intrinsics.checkNotNullParameter(loginManager, "this$0");
            this.this$0 = loginManager;
            this.callbackManager = callbackManager2;
            this.loggerID = str;
        }

        public Intent createIntent(Context context, Object obj) {
            Collection collection = (Collection) obj;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(collection, "permissions");
            Request createLoginRequestWithConfig = this.this$0.createLoginRequestWithConfig(new LoginConfiguration(collection, null, 2));
            String str = this.loggerID;
            if (str != null) {
                createLoginRequestWithConfig.setAuthId(str);
            }
            this.this$0.logStartLogin(context, createLoginRequestWithConfig);
            Intent facebookActivityIntent = this.this$0.getFacebookActivityIntent(createLoginRequestWithConfig);
            if (this.this$0.resolveIntent(facebookActivityIntent)) {
                return facebookActivityIntent;
            }
            FacebookException facebookException = new FacebookException((String) "Log in attempt failed: FacebookActivity could not be started. Please make sure you added FacebookActivity to the AndroidManifest.");
            this.this$0.logCompleteLogin(context, Code.ERROR, null, facebookException, false, createLoginRequestWithConfig);
            throw facebookException;
        }

        public Object parseResult(int i, Intent intent) {
            LoginManager.onActivityResult$default(this.this$0, i, intent, null, 4, null);
            int requestCode = RequestCodeOffset.Login.toRequestCode();
            CallbackManager callbackManager2 = this.callbackManager;
            if (callbackManager2 != null) {
                callbackManager2.onActivityResult(requestCode, i, intent);
            }
            return new ActivityResultParameters(requestCode, i, intent);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/facebook/login/LoginManager$FragmentStartActivityDelegate;", "Lcom/facebook/login/StartActivityDelegate;", "fragment", "Lcom/facebook/internal/FragmentWrapper;", "(Lcom/facebook/internal/FragmentWrapper;)V", "activityContext", "Landroid/app/Activity;", "getActivityContext", "()Landroid/app/Activity;", "startActivityForResult", "", "intent", "Landroid/content/Intent;", "requestCode", "", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: LoginManager.kt */
    public static final class FragmentStartActivityDelegate implements StartActivityDelegate {
        public final Activity activityContext;
        public final FragmentWrapper fragment;

        public FragmentStartActivityDelegate(FragmentWrapper fragmentWrapper) {
            Intrinsics.checkNotNullParameter(fragmentWrapper, "fragment");
            this.fragment = fragmentWrapper;
            this.activityContext = fragmentWrapper.getActivity();
        }

        public Activity getActivityContext() {
            return this.activityContext;
        }

        public void startActivityForResult(Intent intent, int i) {
            Intrinsics.checkNotNullParameter(intent, AnalyticsConstants.INTENT);
            this.fragment.startActivityForResult(intent, i);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/facebook/login/LoginManager$LoginLoggerHolder;", "", "()V", "logger", "Lcom/facebook/login/LoginLogger;", "getLogger", "context", "Landroid/content/Context;", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: LoginManager.kt */
    public static final class LoginLoggerHolder {
        public static final LoginLoggerHolder INSTANCE = new LoginLoggerHolder();
        public static LoginLogger logger;

        public final synchronized LoginLogger getLogger(Context context) {
            if (context == null) {
                try {
                    FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                    context = FacebookSdk.getApplicationContext();
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (logger == null) {
                FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
                logger = new LoginLogger(context, FacebookSdk.getApplicationId());
            }
            return logger;
        }
    }

    static {
        Companion companion = new Companion(null);
        Companion = companion;
        if (companion != null) {
            String cls = LoginManager.class.toString();
            Intrinsics.checkNotNullExpressionValue(cls, "LoginManager::class.java.toString()");
            TAG = cls;
            return;
        }
        throw null;
    }

    public LoginManager() {
        Validate.sdkInitialized();
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        SharedPreferences sharedPreferences2 = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.loginManager", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences2, "getApplicationContext().getSharedPreferences(PREFERENCE_LOGIN_MANAGER, Context.MODE_PRIVATE)");
        this.sharedPreferences = sharedPreferences2;
        if (FacebookSdk.hasCustomTabsPrefetching && CustomTabUtils.getChromePackage() != null) {
            CustomTabPrefetchHelper customTabPrefetchHelper = new CustomTabPrefetchHelper();
            FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
            CustomTabsClient.bindCustomTabsService(FacebookSdk.getApplicationContext(), "com.android.chrome", customTabPrefetchHelper);
            FacebookSdk facebookSdk3 = FacebookSdk.INSTANCE;
            Context applicationContext = FacebookSdk.getApplicationContext();
            FacebookSdk facebookSdk4 = FacebookSdk.INSTANCE;
            String packageName = FacebookSdk.getApplicationContext().getPackageName();
            if (packageName != null) {
                Context applicationContext2 = applicationContext.getApplicationContext();
                try {
                    CustomTabsClient.bindCustomTabsService(applicationContext2, packageName, new CustomTabsServiceConnection(applicationContext2) {
                        public final /* synthetic */ Context val$applicationContext;

                        {
                            this.val$applicationContext = r1;
                        }

                        public final void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
                            try {
                                customTabsClient.mService.warmup(0);
                            } catch (RemoteException unused) {
                            }
                            this.val$applicationContext.unbindService(this);
                        }

                        public void onServiceDisconnected(ComponentName componentName) {
                        }
                    });
                } catch (SecurityException unused) {
                }
            }
        }
    }

    public static LoginManager getInstance() {
        return Companion.getInstance();
    }

    public static /* synthetic */ boolean onActivityResult$default(LoginManager loginManager, int i, Intent intent, FacebookCallback facebookCallback, int i2, Object obj) {
        int i3 = i2 & 4;
        loginManager.onActivityResult(i, intent, null);
        return true;
    }

    /* renamed from: registerCallback$lambda-0  reason: not valid java name */
    public static final boolean m72registerCallback$lambda0(LoginManager loginManager, FacebookCallback facebookCallback, int i, Intent intent) {
        Intrinsics.checkNotNullParameter(loginManager, "this$0");
        loginManager.onActivityResult(i, intent, facebookCallback);
        return true;
    }

    /* renamed from: startLogin$lambda-1  reason: not valid java name */
    public static final boolean m73startLogin$lambda1(LoginManager loginManager, int i, Intent intent) {
        Intrinsics.checkNotNullParameter(loginManager, "this$0");
        onActivityResult$default(loginManager, i, intent, null, 4, null);
        return true;
    }

    public Request createLoginRequestWithConfig(LoginConfiguration loginConfiguration) {
        String str;
        Intrinsics.checkNotNullParameter(loginConfiguration, "loginConfig");
        CodeChallengeMethod codeChallengeMethod = CodeChallengeMethod.S256;
        try {
            str = PKCEUtil.generateCodeChallenge(loginConfiguration.codeVerifier, codeChallengeMethod);
        } catch (FacebookException unused) {
            codeChallengeMethod = CodeChallengeMethod.PLAIN;
            str = loginConfiguration.codeVerifier;
        }
        String str2 = str;
        LoginBehavior loginBehavior2 = this.loginBehavior;
        Set<T> set = ArraysKt___ArraysJvmKt.toSet(loginConfiguration.permissions);
        DefaultAudience defaultAudience2 = this.defaultAudience;
        String str3 = this.authType;
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        String applicationId = FacebookSdk.getApplicationId();
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        Request request = new Request(loginBehavior2, set, defaultAudience2, str3, applicationId, uuid, this.loginTargetApp, loginConfiguration.nonce, loginConfiguration.codeVerifier, str2, codeChallengeMethod);
        com.facebook.AccessToken.Companion companion = AccessToken.Companion;
        request.isRerequest = com.facebook.AccessToken.Companion.isCurrentAccessTokenActive();
        request.messengerPageId = this.messengerPageId;
        request.resetMessengerState = this.resetMessengerState;
        request.isFamilyLogin = this.isFamilyLogin;
        request.shouldSkipAccountDeduplication = this.shouldSkipAccountDeduplication;
        return request;
    }

    public Intent getFacebookActivityIntent(Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intent intent = new Intent();
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        intent.setClass(FacebookSdk.getApplicationContext(), FacebookActivity.class);
        intent.setAction(request.loginBehavior.toString());
        Bundle bundle = new Bundle();
        bundle.putParcelable("request", request);
        intent.putExtra("com.facebook.LoginFragment:Request", bundle);
        return intent;
    }

    public final void logCompleteLogin(Context context, Code code, Map<String, String> map, Exception exc, boolean z, Request request) {
        String str;
        LoginLogger logger = LoginLoggerHolder.INSTANCE.getLogger(context);
        if (logger != null) {
            JSONObject jSONObject = null;
            String str2 = "fb_mobile_login_complete";
            if (request == null) {
                LoginLogger.logUnexpectedError$default(logger, str2, "Unexpected call to logCompleteLogin with null pendingAuthorizationRequest.", null, 4);
            } else {
                HashMap hashMap = new HashMap();
                hashMap.put("try_login_activity", z ? "1" : "0");
                String str3 = request.authId;
                if (request.isFamilyLogin) {
                    str2 = "foa_mobile_login_complete";
                }
                if (!CrashShieldHandler.isObjectCrashing(logger)) {
                    try {
                        Intrinsics.checkNotNullParameter(hashMap, "loggingExtras");
                        Bundle bundle = new Bundle();
                        bundle.putLong("1_timestamp_ms", System.currentTimeMillis());
                        bundle.putString("0_auth_logger_id", str3);
                        bundle.putString("3_method", "");
                        bundle.putString("2_result", "");
                        bundle.putString("5_error_message", "");
                        bundle.putString("4_error_code", "");
                        bundle.putString("6_extras", "");
                        if (code != null) {
                            bundle.putString("2_result", code.getLoggingValue());
                        }
                        if (exc == null) {
                            str = null;
                        } else {
                            str = exc.getMessage();
                        }
                        if (str != null) {
                            bundle.putString("5_error_message", exc.getMessage());
                        }
                        if (!hashMap.isEmpty()) {
                            jSONObject = new JSONObject(hashMap);
                        }
                        if (map != null) {
                            if (jSONObject == null) {
                                jSONObject = new JSONObject();
                            }
                            try {
                                for (Entry next : map.entrySet()) {
                                    String str4 = (String) next.getKey();
                                    String str5 = (String) next.getValue();
                                    if (str4 != null) {
                                        jSONObject.put(str4, str5);
                                    }
                                }
                            } catch (JSONException unused) {
                            }
                        }
                        if (jSONObject != null) {
                            bundle.putString("6_extras", jSONObject.toString());
                        }
                        logger.logger.logEventImplicitly(str2, bundle);
                        if (code == Code.SUCCESS) {
                            logger.logHeartbeatEvent(str3);
                        }
                    } catch (Throwable th) {
                        CrashShieldHandler.handleThrowable(th, logger);
                    }
                }
            }
        }
    }

    public final void logIn(FragmentWrapper fragmentWrapper, Collection<String> collection, String str) {
        Intrinsics.checkNotNullParameter(fragmentWrapper, "fragment");
        Request createLoginRequestWithConfig = createLoginRequestWithConfig(new LoginConfiguration(collection, null, 2));
        if (str != null) {
            createLoginRequestWithConfig.setAuthId(str);
        }
        startLogin(new FragmentStartActivityDelegate(fragmentWrapper), createLoginRequestWithConfig);
    }

    public final void logInWithReadPermissions(Activity activity, Collection<String> collection) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (collection != null) {
            for (String next : collection) {
                boolean z = false;
                if (next != null && (CharsKt__CharKt.startsWith$default(next, (String) "publish", false, 2) || CharsKt__CharKt.startsWith$default(next, (String) "manage", false, 2) || OTHER_PUBLISH_PERMISSIONS.contains(next))) {
                    z = true;
                    continue;
                }
                if (z) {
                    throw new FacebookException(GeneratedOutlineSupport.outline52("Cannot pass a publish or manage permission (", next, ") to a request for read authorization"));
                }
            }
        }
        logIn(activity, new LoginConfiguration(collection, null, 2));
    }

    public void logOut() {
        com.facebook.AccessToken.Companion companion = AccessToken.Companion;
        com.facebook.AccessToken.Companion.setCurrentAccessToken(null);
        AuthenticationToken.setCurrentAuthenticationToken(null);
        Profile profile = Profile.Companion;
        Profile.setCurrentProfile(null);
        Editor edit = this.sharedPreferences.edit();
        edit.putBoolean("express_login_allowed", false);
        edit.apply();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(11:10|11|12|13|(1:15)|16|(1:18)|19|20|21|28) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x00ab */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void logStartLogin(android.content.Context r8, com.facebook.login.LoginClient.Request r9) {
        /*
            r7 = this;
            com.facebook.login.LoginManager$LoginLoggerHolder r0 = com.facebook.login.LoginManager.LoginLoggerHolder.INSTANCE
            com.facebook.login.LoginLogger r8 = r0.getLogger(r8)
            if (r8 == 0) goto L_0x00b5
            if (r9 == 0) goto L_0x00b5
            boolean r0 = r9.isFamilyLogin
            if (r0 == 0) goto L_0x0011
            java.lang.String r0 = "foa_mobile_login_start"
            goto L_0x0013
        L_0x0011:
            java.lang.String r0 = "fb_mobile_login_start"
        L_0x0013:
            java.lang.String r1 = "6_extras"
            boolean r2 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r8)
            if (r2 == 0) goto L_0x001d
            goto L_0x00b5
        L_0x001d:
            java.lang.String r2 = "pendingLoginRequest"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r2)     // Catch:{ all -> 0x00b1 }
            java.lang.String r2 = r9.authId     // Catch:{ all -> 0x00b1 }
            android.os.Bundle r3 = new android.os.Bundle     // Catch:{ all -> 0x00b1 }
            r3.<init>()     // Catch:{ all -> 0x00b1 }
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00b1 }
            java.lang.String r6 = "1_timestamp_ms"
            r3.putLong(r6, r4)     // Catch:{ all -> 0x00b1 }
            java.lang.String r4 = "0_auth_logger_id"
            r3.putString(r4, r2)     // Catch:{ all -> 0x00b1 }
            java.lang.String r2 = ""
            java.lang.String r4 = "3_method"
            r3.putString(r4, r2)     // Catch:{ all -> 0x00b1 }
            java.lang.String r4 = "2_result"
            r3.putString(r4, r2)     // Catch:{ all -> 0x00b1 }
            java.lang.String r4 = "5_error_message"
            r3.putString(r4, r2)     // Catch:{ all -> 0x00b1 }
            java.lang.String r4 = "4_error_code"
            r3.putString(r4, r2)     // Catch:{ all -> 0x00b1 }
            r3.putString(r1, r2)     // Catch:{ all -> 0x00b1 }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00ab }
            r2.<init>()     // Catch:{ JSONException -> 0x00ab }
            java.lang.String r4 = "login_behavior"
            com.facebook.login.LoginBehavior r5 = r9.loginBehavior     // Catch:{ JSONException -> 0x00ab }
            java.lang.String r5 = r5.toString()     // Catch:{ JSONException -> 0x00ab }
            r2.put(r4, r5)     // Catch:{ JSONException -> 0x00ab }
            java.lang.String r4 = "request_code"
            com.facebook.internal.CallbackManagerImpl$RequestCodeOffset r5 = com.facebook.internal.CallbackManagerImpl.RequestCodeOffset.Login     // Catch:{ JSONException -> 0x00ab }
            int r5 = r5.toRequestCode()     // Catch:{ JSONException -> 0x00ab }
            r2.put(r4, r5)     // Catch:{ JSONException -> 0x00ab }
            java.lang.String r4 = "permissions"
            java.lang.String r5 = ","
            java.util.Set<java.lang.String> r6 = r9.permissions     // Catch:{ JSONException -> 0x00ab }
            java.lang.String r5 = android.text.TextUtils.join(r5, r6)     // Catch:{ JSONException -> 0x00ab }
            r2.put(r4, r5)     // Catch:{ JSONException -> 0x00ab }
            java.lang.String r4 = "default_audience"
            com.facebook.login.DefaultAudience r5 = r9.defaultAudience     // Catch:{ JSONException -> 0x00ab }
            java.lang.String r5 = r5.toString()     // Catch:{ JSONException -> 0x00ab }
            r2.put(r4, r5)     // Catch:{ JSONException -> 0x00ab }
            java.lang.String r4 = "isReauthorize"
            boolean r5 = r9.isRerequest     // Catch:{ JSONException -> 0x00ab }
            r2.put(r4, r5)     // Catch:{ JSONException -> 0x00ab }
            java.lang.String r4 = r8.facebookVersion     // Catch:{ JSONException -> 0x00ab }
            if (r4 == 0) goto L_0x0095
            java.lang.String r4 = "facebookVersion"
            java.lang.String r5 = r8.facebookVersion     // Catch:{ JSONException -> 0x00ab }
            r2.put(r4, r5)     // Catch:{ JSONException -> 0x00ab }
        L_0x0095:
            com.facebook.login.LoginTargetApp r4 = r9.loginTargetApp     // Catch:{ JSONException -> 0x00ab }
            if (r4 == 0) goto L_0x00a4
            java.lang.String r4 = "target_app"
            com.facebook.login.LoginTargetApp r9 = r9.loginTargetApp     // Catch:{ JSONException -> 0x00ab }
            java.lang.String r9 = r9.toString()     // Catch:{ JSONException -> 0x00ab }
            r2.put(r4, r9)     // Catch:{ JSONException -> 0x00ab }
        L_0x00a4:
            java.lang.String r9 = r2.toString()     // Catch:{ JSONException -> 0x00ab }
            r3.putString(r1, r9)     // Catch:{ JSONException -> 0x00ab }
        L_0x00ab:
            com.facebook.appevents.InternalAppEventsLogger r9 = r8.logger     // Catch:{ all -> 0x00b1 }
            r9.logEventImplicitly(r0, r3)     // Catch:{ all -> 0x00b1 }
            goto L_0x00b5
        L_0x00b1:
            r9 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r9, r8)
        L_0x00b5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.login.LoginManager.logStartLogin(android.content.Context, com.facebook.login.LoginClient$Request):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0081 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onActivityResult(int r13, android.content.Intent r14, com.facebook.FacebookCallback<com.facebook.login.LoginResult> r15) {
        /*
            r12 = this;
            com.facebook.login.LoginClient$Result$Code r0 = com.facebook.login.LoginClient.Result.Code.ERROR
            r1 = 1
            r2 = 0
            if (r14 == 0) goto L_0x004a
            java.lang.Class<com.facebook.login.LoginClient$Result> r3 = com.facebook.login.LoginClient.Result.class
            java.lang.ClassLoader r3 = r3.getClassLoader()
            r14.setExtrasClassLoader(r3)
            java.lang.String r3 = "com.facebook.LoginFragment:Result"
            android.os.Parcelable r14 = r14.getParcelableExtra(r3)
            com.facebook.login.LoginClient$Result r14 = (com.facebook.login.LoginClient.Result) r14
            if (r14 == 0) goto L_0x0050
            com.facebook.login.LoginClient$Request r0 = r14.request
            com.facebook.login.LoginClient$Result$Code r3 = r14.code
            r4 = -1
            if (r13 == r4) goto L_0x0029
            if (r13 == 0) goto L_0x0024
            r13 = r2
            goto L_0x003b
        L_0x0024:
            r13 = 1
            r4 = r2
            r5 = r4
            r6 = r5
            goto L_0x0043
        L_0x0029:
            com.facebook.login.LoginClient$Result$Code r13 = com.facebook.login.LoginClient.Result.Code.SUCCESS
            if (r3 != r13) goto L_0x0034
            com.facebook.AccessToken r13 = r14.token
            com.facebook.AuthenticationToken r4 = r14.authenticationToken
            r5 = r4
            r4 = r2
            goto L_0x003e
        L_0x0034:
            com.facebook.FacebookAuthorizationException r13 = new com.facebook.FacebookAuthorizationException
            java.lang.String r4 = r14.errorMessage
            r13.<init>(r4)
        L_0x003b:
            r4 = r13
            r13 = r2
            r5 = r13
        L_0x003e:
            r6 = 0
            r6 = r5
            r5 = r4
            r4 = r13
            r13 = 0
        L_0x0043:
            java.util.Map<java.lang.String, java.lang.String> r14 = r14.loggingExtras
            r7 = r3
            r10 = r6
            r6 = r14
            r14 = r4
            goto L_0x0057
        L_0x004a:
            if (r13 != 0) goto L_0x0050
            com.facebook.login.LoginClient$Result$Code r0 = com.facebook.login.LoginClient.Result.Code.CANCEL
            r13 = 1
            goto L_0x0051
        L_0x0050:
            r13 = 0
        L_0x0051:
            r7 = r0
            r14 = r2
            r0 = r14
            r5 = r0
            r6 = r5
            r10 = r6
        L_0x0057:
            if (r5 != 0) goto L_0x0064
            if (r14 != 0) goto L_0x0064
            if (r13 != 0) goto L_0x0064
            com.facebook.FacebookException r5 = new com.facebook.FacebookException
            java.lang.String r3 = "Unexpected call to LoginManager.onActivityResult"
            r5.<init>(r3)
        L_0x0064:
            r11 = r5
            r8 = 1
            r4 = 0
            r3 = r12
            r5 = r7
            r7 = r11
            r9 = r0
            r3.logCompleteLogin(r4, r5, r6, r7, r8, r9)
            if (r14 == 0) goto L_0x007a
            com.facebook.AccessToken$Companion r3 = com.facebook.AccessToken.Companion
            com.facebook.AccessToken.Companion.setCurrentAccessToken(r14)
            com.facebook.Profile r3 = com.facebook.Profile.Companion
            com.facebook.Profile.fetchProfileForCurrentAccessToken()
        L_0x007a:
            if (r10 == 0) goto L_0x007f
            com.facebook.AuthenticationToken.setCurrentAuthenticationToken(r10)
        L_0x007f:
            if (r15 == 0) goto L_0x00de
            if (r14 == 0) goto L_0x00b2
            if (r0 == 0) goto L_0x00b2
            java.lang.String r2 = "request"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)
            java.lang.String r2 = "newToken"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r2)
            java.util.Set<java.lang.String> r2 = r0.permissions
            java.util.Set<java.lang.String> r3 = r14.permissions
            java.util.List r3 = kotlin.collections.ArraysKt___ArraysJvmKt.filterNotNull(r3)
            java.util.Set r3 = kotlin.collections.ArraysKt___ArraysJvmKt.toMutableSet(r3)
            boolean r0 = r0.isRerequest
            if (r0 == 0) goto L_0x00a2
            r3.retainAll(r2)
        L_0x00a2:
            java.util.List r0 = kotlin.collections.ArraysKt___ArraysJvmKt.filterNotNull(r2)
            java.util.Set r0 = kotlin.collections.ArraysKt___ArraysJvmKt.toMutableSet(r0)
            r0.removeAll(r3)
            com.facebook.login.LoginResult r2 = new com.facebook.login.LoginResult
            r2.<init>(r14, r10, r3, r0)
        L_0x00b2:
            if (r13 != 0) goto L_0x00db
            if (r2 == 0) goto L_0x00bf
            java.util.Set<java.lang.String> r13 = r2.recentlyGrantedPermissions
            boolean r13 = r13.isEmpty()
            if (r13 == 0) goto L_0x00bf
            goto L_0x00db
        L_0x00bf:
            if (r11 == 0) goto L_0x00c5
            r15.onError(r11)
            goto L_0x00de
        L_0x00c5:
            if (r14 == 0) goto L_0x00de
            if (r2 == 0) goto L_0x00de
            android.content.SharedPreferences r13 = r12.sharedPreferences
            android.content.SharedPreferences$Editor r13 = r13.edit()
            java.lang.String r14 = "express_login_allowed"
            r13.putBoolean(r14, r1)
            r13.apply()
            r15.onSuccess(r2)
            goto L_0x00de
        L_0x00db:
            r15.onCancel()
        L_0x00de:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.login.LoginManager.onActivityResult(int, android.content.Intent, com.facebook.FacebookCallback):boolean");
    }

    public final void registerCallback(CallbackManager callbackManager, FacebookCallback<LoginResult> facebookCallback) {
        if (callbackManager instanceof CallbackManagerImpl) {
            ((CallbackManagerImpl) callbackManager).registerCallback(RequestCodeOffset.Login.toRequestCode(), new Callback(facebookCallback) {
                public final /* synthetic */ FacebookCallback f$1;

                {
                    this.f$1 = r2;
                }

                public final boolean onActivityResult(int i, Intent intent) {
                    return LoginManager.m72registerCallback$lambda0(LoginManager.this, this.f$1, i, intent);
                }
            });
            return;
        }
        throw new FacebookException((String) "Unexpected CallbackManager, please use the provided Factory.");
    }

    public final boolean resolveIntent(Intent intent) {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        return FacebookSdk.getApplicationContext().getPackageManager().resolveActivity(intent, 0) != null;
    }

    public final LoginManager setDefaultAudience(DefaultAudience defaultAudience2) {
        Intrinsics.checkNotNullParameter(defaultAudience2, "defaultAudience");
        this.defaultAudience = defaultAudience2;
        return this;
    }

    public final LoginManager setLoginBehavior(LoginBehavior loginBehavior2) {
        Intrinsics.checkNotNullParameter(loginBehavior2, "loginBehavior");
        this.loginBehavior = loginBehavior2;
        return this;
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0030 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0031  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void startLogin(com.facebook.login.StartActivityDelegate r9, com.facebook.login.LoginClient.Request r10) throws com.facebook.FacebookException {
        /*
            r8 = this;
            android.app.Activity r0 = r9.getActivityContext()
            r8.logStartLogin(r0, r10)
            com.facebook.internal.CallbackManagerImpl$Companion r0 = com.facebook.internal.CallbackManagerImpl.Companion
            com.facebook.internal.CallbackManagerImpl$RequestCodeOffset r1 = com.facebook.internal.CallbackManagerImpl.RequestCodeOffset.Login
            int r1 = r1.toRequestCode()
            com.facebook.login.-$$Lambda$kMGR0qOOGjdHDrJWMJLQ-0YFR1Y r2 = new com.facebook.login.-$$Lambda$kMGR0qOOGjdHDrJWMJLQ-0YFR1Y
            r2.<init>()
            r0.registerStaticCallback(r1, r2)
            android.content.Intent r0 = r8.getFacebookActivityIntent(r10)
            boolean r1 = r8.resolveIntent(r0)
            if (r1 != 0) goto L_0x0022
            goto L_0x002d
        L_0x0022:
            com.facebook.internal.CallbackManagerImpl$RequestCodeOffset r1 = com.facebook.internal.CallbackManagerImpl.RequestCodeOffset.Login     // Catch:{ ActivityNotFoundException -> 0x002d }
            int r1 = r1.toRequestCode()     // Catch:{ ActivityNotFoundException -> 0x002d }
            r9.startActivityForResult(r0, r1)     // Catch:{ ActivityNotFoundException -> 0x002d }
            r0 = 1
            goto L_0x002e
        L_0x002d:
            r0 = 0
        L_0x002e:
            if (r0 == 0) goto L_0x0031
            return
        L_0x0031:
            com.facebook.FacebookException r0 = new com.facebook.FacebookException
            java.lang.String r1 = "Log in attempt failed: FacebookActivity could not be started. Please make sure you added FacebookActivity to the AndroidManifest."
            r0.<init>(r1)
            r6 = 0
            android.app.Activity r2 = r9.getActivityContext()
            com.facebook.login.LoginClient$Result$Code r3 = com.facebook.login.LoginClient.Result.Code.ERROR
            r4 = 0
            r1 = r8
            r5 = r0
            r7 = r10
            r1.logCompleteLogin(r2, r3, r4, r5, r6, r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.login.LoginManager.startLogin(com.facebook.login.StartActivityDelegate, com.facebook.login.LoginClient$Request):void");
    }

    public final void logIn(Activity activity, LoginConfiguration loginConfiguration) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(loginConfiguration, "loginConfig");
        boolean z = activity instanceof ActivityResultRegistryOwner;
        startLogin(new ActivityStartActivityDelegate(activity), createLoginRequestWithConfig(loginConfiguration));
    }
}
