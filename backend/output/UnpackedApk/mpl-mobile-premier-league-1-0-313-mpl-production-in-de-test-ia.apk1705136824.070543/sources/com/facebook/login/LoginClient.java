package com.facebook.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.facebook.AccessToken;
import com.facebook.AccessToken.Companion;
import com.facebook.AuthenticationToken;
import com.facebook.CustomTabMainActivity;
import com.facebook.FacebookException;
import com.facebook.common.R$string;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import in.juspay.hypersdk.core.Labels.System;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0017\u0018\u0000 q2\u00020\u0001:\u0005pqrstB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001e\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u001c2\u0006\u0010H\u001a\u00020\u0013J \u0010I\u001a\u00020F2\u0006\u0010G\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u001c2\u0006\u0010H\u001a\u00020\u0013H\u0002J\u0010\u0010J\u001a\u00020F2\b\u0010K\u001a\u0004\u0018\u00010@J\u0006\u0010L\u001a\u00020FJ\u0006\u0010M\u001a\u00020\u0013J\u000e\u0010N\u001a\u00020\u00192\u0006\u0010O\u001a\u00020\u001cJ\u000e\u0010P\u001a\u00020F2\u0006\u0010Q\u001a\u00020RJ\u000e\u0010S\u001a\u00020F2\u0006\u0010Q\u001a\u00020RJ\b\u0010T\u001a\u00020FH\u0002J\b\u0010U\u001a\u00020\u0019H\u0016J\b\u0010V\u001a\u0004\u0018\u00010'J\u001d\u0010(\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010&2\u0006\u0010K\u001a\u00020@H\u0016¢\u0006\u0002\u0010WJ2\u0010X\u001a\u00020F2\u0006\u0010Y\u001a\u00020\u001c2\u0006\u0010Z\u001a\u00020R2\u0018\u00103\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0018\u00010[H\u0002JF\u0010X\u001a\u00020F2\u0006\u0010Y\u001a\u00020\u001c2\u0006\u0010Z\u001a\u00020\u001c2\b\u0010\\\u001a\u0004\u0018\u00010\u001c2\b\u0010]\u001a\u0004\u0018\u00010\u001c2\u0018\u00103\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0018\u00010[H\u0002J\u0006\u0010^\u001a\u00020FJ\u0006\u0010_\u001a\u00020FJ\u0010\u0010`\u001a\u00020F2\u0006\u0010Q\u001a\u00020RH\u0002J \u0010a\u001a\u00020\u00132\u0006\u0010b\u001a\u00020\u00192\u0006\u0010c\u001a\u00020\u00192\b\u0010d\u001a\u0004\u0018\u00010eJ\u0010\u0010f\u001a\u00020F2\u0006\u0010g\u001a\u00020\u0019H\u0004J\u0010\u0010h\u001a\u00020F2\b\u0010K\u001a\u0004\u0018\u00010@J\u0006\u0010i\u001a\u00020\u0013J\u0006\u0010j\u001a\u00020FJ\u000e\u0010k\u001a\u00020F2\u0006\u0010l\u001a\u00020RJ\u0018\u0010m\u001a\u00020F2\u0006\u0010n\u001a\u00020\u00062\u0006\u0010o\u001a\u00020\u0019H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R(\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R(\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010!\u001a\u0004\u0018\u00010\u0003@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010\u0004R$\u0010%\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010&X\u000e¢\u0006\u0010\n\u0002\u0010,\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0011\u0010-\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b.\u0010\u0015R\u0014\u0010/\u001a\u0002008BX\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R(\u00103\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u001e\"\u0004\b5\u0010 R\u0010\u00106\u001a\u0004\u0018\u000100X\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u001c\u00109\u001a\u0004\u0018\u00010:X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001c\u0010?\u001a\u0004\u0018\u00010@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010D¨\u0006u"}, d2 = {"Lcom/facebook/login/LoginClient;", "Landroid/os/Parcelable;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "activity", "Landroidx/fragment/app/FragmentActivity;", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "backgroundProcessingListener", "Lcom/facebook/login/LoginClient$BackgroundProcessingListener;", "getBackgroundProcessingListener", "()Lcom/facebook/login/LoginClient$BackgroundProcessingListener;", "setBackgroundProcessingListener", "(Lcom/facebook/login/LoginClient$BackgroundProcessingListener;)V", "checkedInternetPermission", "", "getCheckedInternetPermission", "()Z", "setCheckedInternetPermission", "(Z)V", "currentHandler", "", "extraData", "", "", "getExtraData", "()Ljava/util/Map;", "setExtraData", "(Ljava/util/Map;)V", "value", "getFragment", "()Landroidx/fragment/app/Fragment;", "setFragment", "handlersToTry", "", "Lcom/facebook/login/LoginMethodHandler;", "getHandlersToTry", "()[Lcom/facebook/login/LoginMethodHandler;", "setHandlersToTry", "([Lcom/facebook/login/LoginMethodHandler;)V", "[Lcom/facebook/login/LoginMethodHandler;", "inProgress", "getInProgress", "logger", "Lcom/facebook/login/LoginLogger;", "getLogger", "()Lcom/facebook/login/LoginLogger;", "loggingExtras", "getLoggingExtras", "setLoggingExtras", "loginLogger", "numActivitiesReturned", "numTotalIntentsFired", "onCompletedListener", "Lcom/facebook/login/LoginClient$OnCompletedListener;", "getOnCompletedListener", "()Lcom/facebook/login/LoginClient$OnCompletedListener;", "setOnCompletedListener", "(Lcom/facebook/login/LoginClient$OnCompletedListener;)V", "pendingRequest", "Lcom/facebook/login/LoginClient$Request;", "getPendingRequest", "()Lcom/facebook/login/LoginClient$Request;", "setPendingRequest", "(Lcom/facebook/login/LoginClient$Request;)V", "addExtraData", "", "key", "accumulate", "addLoggingExtra", "authorize", "request", "cancelCurrentHandler", "checkInternetPermission", "checkPermission", "permission", "complete", "outcome", "Lcom/facebook/login/LoginClient$Result;", "completeAndValidate", "completeWithFailure", "describeContents", "getCurrentHandler", "(Lcom/facebook/login/LoginClient$Request;)[Lcom/facebook/login/LoginMethodHandler;", "logAuthorizationMethodComplete", "method", "result", "", "errorMessage", "errorCode", "notifyBackgroundProcessingStart", "notifyBackgroundProcessingStop", "notifyOnCompleteListener", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "setCurrentHandlerIndex", "index", "startOrContinueAuth", "tryCurrentHandler", "tryNextHandler", "validateSameFbidAndFinish", "pendingResult", "writeToParcel", "dest", "flags", "BackgroundProcessingListener", "Companion", "OnCompletedListener", "Request", "Result", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: LoginClient.kt */
public class LoginClient implements Parcelable {
    public static final Creator<LoginClient> CREATOR = new LoginClient$Companion$CREATOR$1();
    public BackgroundProcessingListener backgroundProcessingListener;
    public boolean checkedInternetPermission;
    public int currentHandler = -1;
    public Map<String, String> extraData;
    public Fragment fragment;
    public LoginMethodHandler[] handlersToTry;
    public Map<String, String> loggingExtras;
    public LoginLogger loginLogger;
    public int numActivitiesReturned;
    public int numTotalIntentsFired;
    public OnCompletedListener onCompletedListener;
    public Request pendingRequest;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/facebook/login/LoginClient$BackgroundProcessingListener;", "", "onBackgroundProcessingStarted", "", "onBackgroundProcessingStopped", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: LoginClient.kt */
    public interface BackgroundProcessingListener {
        void onBackgroundProcessingStarted();

        void onBackgroundProcessingStopped();
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/facebook/login/LoginClient$OnCompletedListener;", "", "onCompleted", "", "result", "Lcom/facebook/login/LoginClient$Result;", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: LoginClient.kt */
    public interface OnCompletedListener {
        void onCompleted(Result result);
    }

    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 K2\u00020\u0001:\u0001KB{\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013B\u000f\b\u0012\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016J\b\u0010C\u001a\u00020DH\u0016J\u0006\u0010E\u001a\u00020+J\u000e\u0010F\u001a\u00020G2\u0006\u0010B\u001a\u00020+J\u0006\u0010B\u001a\u00020+J\u0018\u0010H\u001a\u00020G2\u0006\u0010I\u001a\u00020\u00152\u0006\u0010J\u001a\u00020DH\u0016R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0018\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\t\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001bR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0018\"\u0004\b&\u0010\u001bR\u001c\u0010'\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0018\"\u0004\b)\u0010\u001bR\u001a\u0010*\u001a\u00020+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010,\"\u0004\b-\u0010.R\u0011\u0010/\u001a\u00020+8F¢\u0006\u0006\u001a\u0004\b/\u0010,R\u001a\u00100\u001a\u00020+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010,\"\u0004\b1\u0010.R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0011\u00104\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u001c\u00107\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0018\"\u0004\b9\u0010\u001bR\u0011\u0010\u000e\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u0018R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001a\u0010?\u001a\u00020+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010,\"\u0004\bA\u0010.R\u000e\u0010B\u001a\u00020+X\u000e¢\u0006\u0002\n\u0000¨\u0006L"}, d2 = {"Lcom/facebook/login/LoginClient$Request;", "Landroid/os/Parcelable;", "loginBehavior", "Lcom/facebook/login/LoginBehavior;", "permissions", "", "", "defaultAudience", "Lcom/facebook/login/DefaultAudience;", "authType", "applicationId", "authId", "targetApp", "Lcom/facebook/login/LoginTargetApp;", "nonce", "codeVerifier", "codeChallenge", "codeChallengeMethod", "Lcom/facebook/login/CodeChallengeMethod;", "(Lcom/facebook/login/LoginBehavior;Ljava/util/Set;Lcom/facebook/login/DefaultAudience;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/facebook/login/LoginTargetApp;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/facebook/login/CodeChallengeMethod;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getApplicationId", "()Ljava/lang/String;", "getAuthId", "setAuthId", "(Ljava/lang/String;)V", "getAuthType", "setAuthType", "getCodeChallenge", "getCodeChallengeMethod", "()Lcom/facebook/login/CodeChallengeMethod;", "getCodeVerifier", "getDefaultAudience", "()Lcom/facebook/login/DefaultAudience;", "deviceAuthTargetUserId", "getDeviceAuthTargetUserId", "setDeviceAuthTargetUserId", "deviceRedirectUriString", "getDeviceRedirectUriString", "setDeviceRedirectUriString", "isFamilyLogin", "", "()Z", "setFamilyLogin", "(Z)V", "isInstagramLogin", "isRerequest", "setRerequest", "getLoginBehavior", "()Lcom/facebook/login/LoginBehavior;", "loginTargetApp", "getLoginTargetApp", "()Lcom/facebook/login/LoginTargetApp;", "messengerPageId", "getMessengerPageId", "setMessengerPageId", "getNonce", "getPermissions", "()Ljava/util/Set;", "setPermissions", "(Ljava/util/Set;)V", "resetMessengerState", "getResetMessengerState", "setResetMessengerState", "shouldSkipAccountDeduplication", "describeContents", "", "hasPublishPermission", "setShouldSkipAccountDeduplication", "", "writeToParcel", "dest", "flags", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: LoginClient.kt */
    public static final class Request implements Parcelable {
        public static final Creator<Request> CREATOR = new LoginClient$Request$Companion$CREATOR$1();
        public final String applicationId;
        public String authId;
        public String authType;
        public final String codeChallenge;
        public final CodeChallengeMethod codeChallengeMethod;
        public final String codeVerifier;
        public final DefaultAudience defaultAudience;
        public String deviceAuthTargetUserId;
        public String deviceRedirectUriString;
        public boolean isFamilyLogin;
        public boolean isRerequest;
        public final LoginBehavior loginBehavior;
        public final LoginTargetApp loginTargetApp;
        public String messengerPageId;
        public final String nonce;
        public Set<String> permissions;
        public boolean resetMessengerState;
        public boolean shouldSkipAccountDeduplication;

        public Request(LoginBehavior loginBehavior2, Set<String> set, DefaultAudience defaultAudience2, String str, String str2, String str3, LoginTargetApp loginTargetApp2, String str4, String str5, String str6, CodeChallengeMethod codeChallengeMethod2) {
            Intrinsics.checkNotNullParameter(loginBehavior2, "loginBehavior");
            Intrinsics.checkNotNullParameter(defaultAudience2, "defaultAudience");
            Intrinsics.checkNotNullParameter(str, "authType");
            Intrinsics.checkNotNullParameter(str2, "applicationId");
            Intrinsics.checkNotNullParameter(str3, "authId");
            this.loginBehavior = loginBehavior2;
            this.permissions = set;
            this.defaultAudience = defaultAudience2;
            this.authType = str;
            this.applicationId = str2;
            this.authId = str3;
            this.loginTargetApp = loginTargetApp2 == null ? LoginTargetApp.FACEBOOK : loginTargetApp2;
            if (str4 != null) {
                if (!(str4.length() == 0)) {
                    this.nonce = str4;
                    this.codeVerifier = str5;
                    this.codeChallenge = str6;
                    this.codeChallengeMethod = codeChallengeMethod2;
                }
            }
            String uuid = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
            this.nonce = uuid;
            this.codeVerifier = str5;
            this.codeChallenge = str6;
            this.codeChallengeMethod = codeChallengeMethod2;
        }

        public int describeContents() {
            return 0;
        }

        public final boolean hasPublishPermission() {
            for (String isPublishPermission : this.permissions) {
                if (LoginManager.Companion.isPublishPermission(isPublishPermission)) {
                    return true;
                }
            }
            return false;
        }

        public final boolean isInstagramLogin() {
            return this.loginTargetApp == LoginTargetApp.INSTAGRAM;
        }

        public final void setAuthId(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.authId = str;
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            parcel.writeString(this.loginBehavior.name());
            parcel.writeStringList(new ArrayList(this.permissions));
            parcel.writeString(this.defaultAudience.name());
            parcel.writeString(this.applicationId);
            parcel.writeString(this.authId);
            parcel.writeByte(this.isRerequest ? (byte) 1 : 0);
            parcel.writeString(this.deviceRedirectUriString);
            parcel.writeString(this.authType);
            parcel.writeString(this.deviceAuthTargetUserId);
            parcel.writeString(this.messengerPageId);
            parcel.writeByte(this.resetMessengerState ? (byte) 1 : 0);
            parcel.writeString(this.loginTargetApp.name());
            parcel.writeByte(this.isFamilyLogin ? (byte) 1 : 0);
            parcel.writeByte(this.shouldSkipAccountDeduplication ? (byte) 1 : 0);
            parcel.writeString(this.nonce);
            parcel.writeString(this.codeVerifier);
            parcel.writeString(this.codeChallenge);
            CodeChallengeMethod codeChallengeMethod2 = this.codeChallengeMethod;
            parcel.writeString(codeChallengeMethod2 == null ? null : codeChallengeMethod2.name());
        }

        public Request(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
            DefaultAudience defaultAudience2;
            LoginTargetApp loginTargetApp2;
            CodeChallengeMethod codeChallengeMethod2;
            String readString = parcel.readString();
            Validate.notNullOrEmpty(readString, "loginBehavior");
            this.loginBehavior = LoginBehavior.valueOf(readString);
            ArrayList arrayList = new ArrayList();
            parcel.readStringList(arrayList);
            this.permissions = new HashSet(arrayList);
            String readString2 = parcel.readString();
            if (readString2 != null) {
                defaultAudience2 = DefaultAudience.valueOf(readString2);
            } else {
                defaultAudience2 = DefaultAudience.NONE;
            }
            this.defaultAudience = defaultAudience2;
            String readString3 = parcel.readString();
            Validate.notNullOrEmpty(readString3, "applicationId");
            this.applicationId = readString3;
            String readString4 = parcel.readString();
            Validate.notNullOrEmpty(readString4, "authId");
            this.authId = readString4;
            boolean z = true;
            this.isRerequest = parcel.readByte() != 0;
            this.deviceRedirectUriString = parcel.readString();
            String readString5 = parcel.readString();
            Validate.notNullOrEmpty(readString5, "authType");
            this.authType = readString5;
            this.deviceAuthTargetUserId = parcel.readString();
            this.messengerPageId = parcel.readString();
            this.resetMessengerState = parcel.readByte() != 0;
            String readString6 = parcel.readString();
            if (readString6 != null) {
                loginTargetApp2 = LoginTargetApp.valueOf(readString6);
            } else {
                loginTargetApp2 = LoginTargetApp.FACEBOOK;
            }
            this.loginTargetApp = loginTargetApp2;
            this.isFamilyLogin = parcel.readByte() != 0;
            this.shouldSkipAccountDeduplication = parcel.readByte() == 0 ? false : z;
            String readString7 = parcel.readString();
            Validate.notNullOrEmpty(readString7, "nonce");
            this.nonce = readString7;
            this.codeVerifier = parcel.readString();
            this.codeChallenge = parcel.readString();
            String readString8 = parcel.readString();
            if (readString8 == null) {
                codeChallengeMethod2 = null;
            } else {
                codeChallengeMethod2 = CodeChallengeMethod.valueOf(readString8);
            }
            this.codeChallengeMethod = codeChallengeMethod2;
        }
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001c\u001dB7\b\u0010\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u000bBA\b\u0010\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u000fB\u000f\b\u0012\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u0017H\u0016R\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0002\n\u0000R \u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u00148\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R \u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u00148\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/facebook/login/LoginClient$Result;", "Landroid/os/Parcelable;", "request", "Lcom/facebook/login/LoginClient$Request;", "code", "Lcom/facebook/login/LoginClient$Result$Code;", "token", "Lcom/facebook/AccessToken;", "errorMessage", "", "errorCode", "(Lcom/facebook/login/LoginClient$Request;Lcom/facebook/login/LoginClient$Result$Code;Lcom/facebook/AccessToken;Ljava/lang/String;Ljava/lang/String;)V", "accessToken", "authenticationToken", "Lcom/facebook/AuthenticationToken;", "(Lcom/facebook/login/LoginClient$Request;Lcom/facebook/login/LoginClient$Result$Code;Lcom/facebook/AccessToken;Lcom/facebook/AuthenticationToken;Ljava/lang/String;Ljava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "extraData", "", "loggingExtras", "describeContents", "", "writeToParcel", "", "dest", "flags", "Code", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: LoginClient.kt */
    public static final class Result implements Parcelable {
        public static final Creator<Result> CREATOR = new LoginClient$Result$Companion$CREATOR$1();
        public static final Companion Companion = new Companion(null);
        public final AuthenticationToken authenticationToken;
        public final Code code;
        public final String errorCode;
        public final String errorMessage;
        public Map<String, String> extraData;
        public Map<String, String> loggingExtras;
        public final Request request;
        public final AccessToken token;

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/facebook/login/LoginClient$Result$Code;", "", "loggingValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getLoggingValue", "()Ljava/lang/String;", "SUCCESS", "CANCEL", "ERROR", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        /* compiled from: LoginClient.kt */
        public enum Code {
            SUCCESS("success"),
            CANCEL("cancel"),
            ERROR("error");
            
            public final String loggingValue;

            /* access modifiers changed from: public */
            Code(String str) {
                this.loggingValue = str;
            }

            public final String getLoggingValue() {
                return this.loggingValue;
            }
        }

        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0007J&\u0010\u000b\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J2\u0010\u0010\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\nH\u0007J\u001a\u0010\u0014\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0015\u001a\u00020\rH\u0007R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/facebook/login/LoginClient$Result$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/login/LoginClient$Result;", "createCancelResult", "request", "Lcom/facebook/login/LoginClient$Request;", "message", "", "createCompositeTokenResult", "accessToken", "Lcom/facebook/AccessToken;", "authenticationToken", "Lcom/facebook/AuthenticationToken;", "createErrorResult", "errorType", "errorDescription", "errorCode", "createTokenResult", "token", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        /* compiled from: LoginClient.kt */
        public static final class Companion {
            public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            }
        }

        public Result(Request request2, Code code2, AccessToken accessToken, String str, String str2) {
            Intrinsics.checkNotNullParameter(code2, "code");
            Intrinsics.checkNotNullParameter(code2, "code");
            this.request = request2;
            this.token = accessToken;
            this.authenticationToken = null;
            this.errorMessage = str;
            this.code = code2;
            this.errorCode = str2;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            parcel.writeString(this.code.name());
            parcel.writeParcelable(this.token, i);
            parcel.writeParcelable(this.authenticationToken, i);
            parcel.writeString(this.errorMessage);
            parcel.writeString(this.errorCode);
            parcel.writeParcelable(this.request, i);
            Utility.writeNonnullStringMapToParcel(parcel, this.loggingExtras);
            Utility.writeNonnullStringMapToParcel(parcel, this.extraData);
        }

        public Result(Request request2, Code code2, AccessToken accessToken, AuthenticationToken authenticationToken2, String str, String str2) {
            Intrinsics.checkNotNullParameter(code2, "code");
            this.request = request2;
            this.token = accessToken;
            this.authenticationToken = authenticationToken2;
            this.errorMessage = null;
            this.code = code2;
            this.errorCode = null;
        }

        public Result(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
            this.code = Code.valueOf(parcel.readString() == null ? "error" : parcel.readString());
            this.token = (AccessToken) parcel.readParcelable(AccessToken.class.getClassLoader());
            this.authenticationToken = (AuthenticationToken) parcel.readParcelable(AuthenticationToken.class.getClassLoader());
            this.errorMessage = parcel.readString();
            this.errorCode = parcel.readString();
            this.request = (Request) parcel.readParcelable(Request.class.getClassLoader());
            this.loggingExtras = Utility.readNonnullStringMapFromParcel(parcel);
            this.extraData = Utility.readNonnullStringMapFromParcel(parcel);
        }
    }

    public LoginClient(Fragment fragment2) {
        Intrinsics.checkNotNullParameter(fragment2, "fragment");
        if (this.fragment == null) {
            this.fragment = fragment2;
            return;
        }
        throw new FacebookException((String) "Can't set fragment once it is already set.");
    }

    public final void addLoggingExtra(String str, String str2, boolean z) {
        Map<String, String> map = this.loggingExtras;
        if (map == null) {
            map = new HashMap<>();
        }
        if (this.loggingExtras == null) {
            this.loggingExtras = map;
        }
        if (map.containsKey(str) && z) {
            str2 = map.get(str) + ',' + str2;
        }
        map.put(str, str2);
    }

    public final boolean checkInternetPermission() {
        Object obj;
        if (this.checkedInternetPermission) {
            return true;
        }
        Intrinsics.checkNotNullParameter("android.permission.INTERNET", System.PERMISSION);
        FragmentActivity activity = getActivity();
        if ((activity == null ? -1 : activity.checkCallingOrSelfPermission("android.permission.INTERNET")) != 0) {
            FragmentActivity activity2 = getActivity();
            String str = null;
            if (activity2 == null) {
                obj = null;
            } else {
                obj = activity2.getString(R$string.com_facebook_internet_permission_error_title);
            }
            if (activity2 != null) {
                str = activity2.getString(R$string.com_facebook_internet_permission_error_message);
            }
            Request request = this.pendingRequest;
            ArrayList arrayList = new ArrayList();
            if (obj != null) {
                arrayList.add(obj);
            }
            if (str != null) {
                arrayList.add(str);
            }
            Result result = new Result(request, Code.ERROR, null, TextUtils.join(": ", arrayList), null);
            complete(result);
            return false;
        }
        this.checkedInternetPermission = true;
        return true;
    }

    public final void complete(Result result) {
        Intrinsics.checkNotNullParameter(result, "outcome");
        LoginMethodHandler currentHandler2 = getCurrentHandler();
        if (currentHandler2 != null) {
            logAuthorizationMethodComplete(currentHandler2.getNameForLogging(), result.code.getLoggingValue(), result.errorMessage, result.errorCode, currentHandler2.methodLoggingExtras);
        }
        Map<String, String> map = this.loggingExtras;
        if (map != null) {
            result.loggingExtras = map;
        }
        Map<String, String> map2 = this.extraData;
        if (map2 != null) {
            result.extraData = map2;
        }
        this.handlersToTry = null;
        this.currentHandler = -1;
        this.pendingRequest = null;
        this.loggingExtras = null;
        this.numActivitiesReturned = 0;
        this.numTotalIntentsFired = 0;
        OnCompletedListener onCompletedListener2 = this.onCompletedListener;
        if (onCompletedListener2 != null) {
            onCompletedListener2.onCompleted(result);
        }
    }

    public final void completeAndValidate(Result result) {
        Result result2;
        Intrinsics.checkNotNullParameter(result, "outcome");
        if (result.token != null) {
            Companion companion = AccessToken.Companion;
            if (Companion.isCurrentAccessTokenActive()) {
                Intrinsics.checkNotNullParameter(result, "pendingResult");
                if (result.token != null) {
                    Companion companion2 = AccessToken.Companion;
                    AccessToken currentAccessToken = Companion.getCurrentAccessToken();
                    AccessToken accessToken = result.token;
                    if (currentAccessToken != null) {
                        try {
                            if (Intrinsics.areEqual(currentAccessToken.userId, accessToken.userId)) {
                                result2 = new Result(this.pendingRequest, Code.SUCCESS, result.token, result.authenticationToken, null, null);
                                complete(result2);
                                return;
                            }
                        } catch (Exception e2) {
                            Request request = this.pendingRequest;
                            String message = e2.getMessage();
                            ArrayList arrayList = new ArrayList();
                            arrayList.add("Caught exception");
                            if (message != null) {
                                arrayList.add(message);
                            }
                            Result result3 = new Result(request, Code.ERROR, null, TextUtils.join(": ", arrayList), null);
                            complete(result3);
                            return;
                        }
                    }
                    Request request2 = this.pendingRequest;
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add("User logged in as different Facebook user.");
                    result2 = new Result(request2, Code.ERROR, null, TextUtils.join(": ", arrayList2), null);
                    complete(result2);
                    return;
                }
                throw new FacebookException((String) "Can't validate without a token");
            }
        }
        complete(result);
    }

    public int describeContents() {
        return 0;
    }

    public final FragmentActivity getActivity() {
        Fragment fragment2 = this.fragment;
        if (fragment2 == null) {
            return null;
        }
        return fragment2.getActivity();
    }

    public final LoginMethodHandler getCurrentHandler() {
        int i = this.currentHandler;
        if (i < 0) {
            return null;
        }
        LoginMethodHandler[] loginMethodHandlerArr = this.handlersToTry;
        if (loginMethodHandlerArr == null) {
            return null;
        }
        return loginMethodHandlerArr[i];
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0020, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r1, r2) != false) goto L_0x0042;
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x001a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.facebook.login.LoginLogger getLogger() {
        /*
            r4 = this;
            com.facebook.login.LoginLogger r0 = r4.loginLogger
            if (r0 == 0) goto L_0x0022
            boolean r1 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r0)
            r2 = 0
            if (r1 == 0) goto L_0x000d
        L_0x000b:
            r1 = r2
            goto L_0x0015
        L_0x000d:
            java.lang.String r1 = r0.applicationId     // Catch:{ all -> 0x0010 }
            goto L_0x0015
        L_0x0010:
            r1 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r1, r0)
            goto L_0x000b
        L_0x0015:
            com.facebook.login.LoginClient$Request r3 = r4.pendingRequest
            if (r3 != 0) goto L_0x001a
            goto L_0x001c
        L_0x001a:
            java.lang.String r2 = r3.applicationId
        L_0x001c:
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r2)
            if (r1 != 0) goto L_0x0042
        L_0x0022:
            com.facebook.login.LoginLogger r0 = new com.facebook.login.LoginLogger
            androidx.fragment.app.FragmentActivity r1 = r4.getActivity()
            if (r1 != 0) goto L_0x0030
            com.facebook.FacebookSdk r1 = com.facebook.FacebookSdk.INSTANCE
            android.content.Context r1 = com.facebook.FacebookSdk.getApplicationContext()
        L_0x0030:
            com.facebook.login.LoginClient$Request r2 = r4.pendingRequest
            if (r2 != 0) goto L_0x003b
            com.facebook.FacebookSdk r2 = com.facebook.FacebookSdk.INSTANCE
            java.lang.String r2 = com.facebook.FacebookSdk.getApplicationId()
            goto L_0x003d
        L_0x003b:
            java.lang.String r2 = r2.applicationId
        L_0x003d:
            r0.<init>(r1, r2)
            r4.loginLogger = r0
        L_0x0042:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.login.LoginClient.getLogger():com.facebook.login.LoginLogger");
    }

    public final void logAuthorizationMethodComplete(String str, String str2, String str3, String str4, Map<String, String> map) {
        String str5 = str;
        String str6 = str2;
        String str7 = str3;
        String str8 = str4;
        Request request = this.pendingRequest;
        String str9 = "fb_mobile_login_method_complete";
        if (request == null) {
            getLogger().logUnexpectedError(str9, "Unexpected call to logCompleteLogin with null pendingAuthorizationRequest.", str5);
            return;
        }
        LoginLogger logger = getLogger();
        String str10 = request.authId;
        if (request.isFamilyLogin) {
            str9 = "foa_mobile_login_method_complete";
        }
        if (!CrashShieldHandler.isObjectCrashing(logger)) {
            try {
                Bundle bundle = new Bundle();
                bundle.putLong("1_timestamp_ms", System.currentTimeMillis());
                bundle.putString("0_auth_logger_id", str10);
                bundle.putString("3_method", "");
                bundle.putString("2_result", "");
                bundle.putString("5_error_message", "");
                bundle.putString("4_error_code", "");
                bundle.putString("6_extras", "");
                if (str6 != null) {
                    bundle.putString("2_result", str6);
                }
                if (str7 != null) {
                    bundle.putString("5_error_message", str7);
                }
                if (str8 != null) {
                    bundle.putString("4_error_code", str8);
                }
                if (map != null && (!map.isEmpty())) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (Entry next : map.entrySet()) {
                        if (((String) next.getKey()) != null) {
                            linkedHashMap.put(next.getKey(), next.getValue());
                        }
                    }
                    bundle.putString("6_extras", new JSONObject(linkedHashMap).toString());
                }
                bundle.putString("3_method", str5);
                logger.logger.logEventImplicitly(str9, bundle);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, logger);
            }
        }
    }

    public final boolean onActivityResult(int i, int i2, Intent intent) {
        this.numActivitiesReturned++;
        if (this.pendingRequest != null) {
            if (intent == null || !intent.getBooleanExtra(CustomTabMainActivity.NO_ACTIVITY_EXCEPTION, false)) {
                LoginMethodHandler currentHandler2 = getCurrentHandler();
                if (currentHandler2 != null && (!currentHandler2.shouldKeepTrackOfMultipleIntents() || intent != null || this.numActivitiesReturned >= this.numTotalIntentsFired)) {
                    return currentHandler2.onActivityResult(i, i2, intent);
                }
            } else {
                tryNextHandler();
                return false;
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x011d A[LOOP:0: B:4:0x0019->B:61:0x011d, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x011c A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void tryNextHandler() {
        /*
            r20 = this;
            r7 = r20
            com.facebook.login.LoginMethodHandler r0 = r20.getCurrentHandler()
            if (r0 == 0) goto L_0x0017
            java.lang.String r2 = r0.getNameForLogging()
            r4 = 0
            r5 = 0
            java.util.Map<java.lang.String, java.lang.String> r6 = r0.methodLoggingExtras
            java.lang.String r3 = "skipped"
            r1 = r20
            r1.logAuthorizationMethodComplete(r2, r3, r4, r5, r6)
        L_0x0017:
            com.facebook.login.LoginMethodHandler[] r1 = r7.handlersToTry
        L_0x0019:
            if (r1 == 0) goto L_0x0121
            int r0 = r7.currentHandler
            int r2 = r1.length
            r3 = 1
            int r2 = r2 - r3
            if (r0 >= r2) goto L_0x0121
            int r0 = r0 + 1
            r7.currentHandler = r0
            com.facebook.login.LoginMethodHandler r2 = r20.getCurrentHandler()
            r4 = 0
            if (r2 != 0) goto L_0x002e
            goto L_0x0046
        L_0x002e:
            boolean r0 = r2.needsInternetPermission()
            if (r0 == 0) goto L_0x0042
            boolean r0 = r20.checkInternetPermission()
            if (r0 != 0) goto L_0x0042
            java.lang.String r0 = "no_internet_permission"
            java.lang.String r2 = "1"
            r7.addLoggingExtra(r0, r2, r4)
            goto L_0x0046
        L_0x0042:
            com.facebook.login.LoginClient$Request r0 = r7.pendingRequest
            if (r0 != 0) goto L_0x004a
        L_0x0046:
            r17 = r1
            goto L_0x011a
        L_0x004a:
            int r5 = r2.tryAuthorize(r0)
            r7.numActivitiesReturned = r4
            java.lang.String r6 = "6_extras"
            java.lang.String r8 = "4_error_code"
            java.lang.String r9 = "5_error_message"
            java.lang.String r10 = "2_result"
            java.lang.String r11 = ""
            java.lang.String r12 = "0_auth_logger_id"
            java.lang.String r13 = "1_timestamp_ms"
            java.lang.String r14 = "3_method"
            if (r5 <= 0) goto L_0x00b7
            com.facebook.login.LoginLogger r15 = r20.getLogger()
            java.lang.String r4 = r0.authId
            java.lang.String r2 = r2.getNameForLogging()
            boolean r0 = r0.isFamilyLogin
            if (r0 == 0) goto L_0x0073
            java.lang.String r0 = "foa_mobile_login_method_start"
            goto L_0x0075
        L_0x0073:
            java.lang.String r0 = "fb_mobile_login_method_start"
        L_0x0075:
            boolean r16 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r15)
            if (r16 == 0) goto L_0x007e
            r17 = r1
            goto L_0x00b3
        L_0x007e:
            android.os.Bundle r3 = new android.os.Bundle     // Catch:{ all -> 0x00ad }
            r3.<init>()     // Catch:{ all -> 0x00ad }
            r18 = r0
            r17 = r1
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00ab }
            r3.putLong(r13, r0)     // Catch:{ all -> 0x00ab }
            r3.putString(r12, r4)     // Catch:{ all -> 0x00ab }
            r3.putString(r14, r11)     // Catch:{ all -> 0x00ab }
            r3.putString(r10, r11)     // Catch:{ all -> 0x00ab }
            r3.putString(r9, r11)     // Catch:{ all -> 0x00ab }
            r3.putString(r8, r11)     // Catch:{ all -> 0x00ab }
            r3.putString(r6, r11)     // Catch:{ all -> 0x00ab }
            r3.putString(r14, r2)     // Catch:{ all -> 0x00ab }
            com.facebook.appevents.InternalAppEventsLogger r0 = r15.logger     // Catch:{ all -> 0x00ab }
            r1 = r18
            r0.logEventImplicitly(r1, r3)     // Catch:{ all -> 0x00ab }
            goto L_0x00b3
        L_0x00ab:
            r0 = move-exception
            goto L_0x00b0
        L_0x00ad:
            r0 = move-exception
            r17 = r1
        L_0x00b0:
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r0, r15)
        L_0x00b3:
            r7.numTotalIntentsFired = r5
            r2 = 1
            goto L_0x0114
        L_0x00b7:
            r17 = r1
            com.facebook.login.LoginLogger r1 = r20.getLogger()
            java.lang.String r3 = r0.authId
            java.lang.String r4 = r2.getNameForLogging()
            boolean r0 = r0.isFamilyLogin
            if (r0 == 0) goto L_0x00ca
            java.lang.String r0 = "foa_mobile_login_method_not_tried"
            goto L_0x00cc
        L_0x00ca:
            java.lang.String r0 = "fb_mobile_login_method_not_tried"
        L_0x00cc:
            boolean r15 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r1)
            if (r15 == 0) goto L_0x00d3
            goto L_0x010a
        L_0x00d3:
            android.os.Bundle r15 = new android.os.Bundle     // Catch:{ all -> 0x0106 }
            r15.<init>()     // Catch:{ all -> 0x0106 }
            r19 = r0
            r18 = r1
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0102 }
            r15.putLong(r13, r0)     // Catch:{ all -> 0x0102 }
            r15.putString(r12, r3)     // Catch:{ all -> 0x0102 }
            r15.putString(r14, r11)     // Catch:{ all -> 0x0102 }
            r15.putString(r10, r11)     // Catch:{ all -> 0x0102 }
            r15.putString(r9, r11)     // Catch:{ all -> 0x0102 }
            r15.putString(r8, r11)     // Catch:{ all -> 0x0102 }
            r15.putString(r6, r11)     // Catch:{ all -> 0x0102 }
            r15.putString(r14, r4)     // Catch:{ all -> 0x0102 }
            r1 = r18
            com.facebook.appevents.InternalAppEventsLogger r0 = r1.logger     // Catch:{ all -> 0x0106 }
            r3 = r19
            r0.logEventImplicitly(r3, r15)     // Catch:{ all -> 0x0106 }
            goto L_0x010a
        L_0x0102:
            r0 = move-exception
            r1 = r18
            goto L_0x0107
        L_0x0106:
            r0 = move-exception
        L_0x0107:
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r0, r1)
        L_0x010a:
            java.lang.String r0 = r2.getNameForLogging()
            java.lang.String r1 = "not_tried"
            r2 = 1
            r7.addLoggingExtra(r1, r0, r2)
        L_0x0114:
            if (r5 <= 0) goto L_0x0118
            r3 = 1
            goto L_0x0119
        L_0x0118:
            r3 = 0
        L_0x0119:
            r4 = r3
        L_0x011a:
            if (r4 == 0) goto L_0x011d
            return
        L_0x011d:
            r1 = r17
            goto L_0x0019
        L_0x0121:
            com.facebook.login.LoginClient$Request r9 = r7.pendingRequest
            if (r9 == 0) goto L_0x0142
            r13 = 0
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.lang.String r1 = "Login attempt failed."
            r0.add(r1)
            java.lang.String r1 = ": "
            java.lang.String r12 = android.text.TextUtils.join(r1, r0)
            com.facebook.login.LoginClient$Result r0 = new com.facebook.login.LoginClient$Result
            com.facebook.login.LoginClient$Result$Code r10 = com.facebook.login.LoginClient.Result.Code.ERROR
            r11 = 0
            r8 = r0
            r8.<init>(r9, r10, r11, r12, r13)
            r7.complete(r0)
        L_0x0142:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.login.LoginClient.tryNextHandler():void");
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeParcelableArray(this.handlersToTry, i);
        parcel.writeInt(this.currentHandler);
        parcel.writeParcelable(this.pendingRequest, i);
        Utility.writeNonnullStringMapToParcel(parcel, this.loggingExtras);
        Utility.writeNonnullStringMapToParcel(parcel, this.extraData);
    }

    /* JADX WARNING: type inference failed for: r5v0 */
    /* JADX WARNING: type inference failed for: r5v1, types: [java.util.Map<java.lang.String, java.lang.String>] */
    /* JADX WARNING: type inference failed for: r5v2, types: [java.util.Map] */
    /* JADX WARNING: type inference failed for: r5v3, types: [java.lang.Object, com.facebook.login.LoginMethodHandler] */
    /* JADX WARNING: type inference failed for: r5v5, types: [com.facebook.login.LoginMethodHandler] */
    /* JADX WARNING: type inference failed for: r5v6 */
    /* JADX WARNING: type inference failed for: r5v7 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r5v0
      assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], com.facebook.login.LoginMethodHandler, java.util.Map]
      uses: [java.util.Map<java.lang.String, java.lang.String>, ?[int, boolean, OBJECT, ARRAY, byte, short, char], java.lang.Object, com.facebook.login.LoginMethodHandler]
      mth insns count: 49
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public LoginClient(android.os.Parcel r9) {
        /*
            r8 = this;
            java.lang.String r0 = "source"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r8.<init>()
            r0 = -1
            r8.currentHandler = r0
            java.lang.Class<com.facebook.login.LoginMethodHandler> r0 = com.facebook.login.LoginMethodHandler.class
            java.lang.ClassLoader r0 = r0.getClassLoader()
            android.os.Parcelable[] r0 = r9.readParcelableArray(r0)
            r1 = 0
            if (r0 != 0) goto L_0x001a
            android.os.Parcelable[] r0 = new android.os.Parcelable[r1]
        L_0x001a:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            int r3 = r0.length
            r4 = 0
        L_0x0021:
            r5 = 0
            if (r4 >= r3) goto L_0x003f
            r6 = r0[r4]
            boolean r7 = r6 instanceof com.facebook.login.LoginMethodHandler
            if (r7 == 0) goto L_0x002d
            r5 = r6
            com.facebook.login.LoginMethodHandler r5 = (com.facebook.login.LoginMethodHandler) r5
        L_0x002d:
            if (r5 != 0) goto L_0x0030
            goto L_0x0037
        L_0x0030:
            java.lang.String r6 = "<set-?>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r6)
            r5.loginClient = r8
        L_0x0037:
            if (r5 == 0) goto L_0x003c
            r2.add(r5)
        L_0x003c:
            int r4 = r4 + 1
            goto L_0x0021
        L_0x003f:
            com.facebook.login.LoginMethodHandler[] r0 = new com.facebook.login.LoginMethodHandler[r1]
            java.lang.Object[] r0 = r2.toArray(r0)
            if (r0 == 0) goto L_0x007b
            com.facebook.login.LoginMethodHandler[] r0 = (com.facebook.login.LoginMethodHandler[]) r0
            r8.handlersToTry = r0
            int r0 = r9.readInt()
            r8.currentHandler = r0
            java.lang.Class<com.facebook.login.LoginClient$Request> r0 = com.facebook.login.LoginClient.Request.class
            java.lang.ClassLoader r0 = r0.getClassLoader()
            android.os.Parcelable r0 = r9.readParcelable(r0)
            com.facebook.login.LoginClient$Request r0 = (com.facebook.login.LoginClient.Request) r0
            r8.pendingRequest = r0
            java.util.Map r0 = com.facebook.internal.Utility.readNonnullStringMapFromParcel(r9)
            if (r0 != 0) goto L_0x0067
            r0 = r5
            goto L_0x006b
        L_0x0067:
            java.util.Map r0 = kotlin.collections.ArraysKt___ArraysJvmKt.toMutableMap(r0)
        L_0x006b:
            r8.loggingExtras = r0
            java.util.Map r9 = com.facebook.internal.Utility.readNonnullStringMapFromParcel(r9)
            if (r9 != 0) goto L_0x0074
            goto L_0x0078
        L_0x0074:
            java.util.Map r5 = kotlin.collections.ArraysKt___ArraysJvmKt.toMutableMap(r9)
        L_0x0078:
            r8.extraData = r5
            return
        L_0x007b:
            java.lang.NullPointerException r9 = new java.lang.NullPointerException
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.Array<T>"
            r9.<init>(r0)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.login.LoginClient.<init>(android.os.Parcel):void");
    }
}
