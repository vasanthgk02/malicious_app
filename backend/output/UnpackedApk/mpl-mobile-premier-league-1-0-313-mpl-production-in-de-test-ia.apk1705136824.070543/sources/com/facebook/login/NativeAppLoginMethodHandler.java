package com.facebook.login;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.Fragment;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.AuthenticationToken;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.FacebookServiceException;
import com.facebook.login.LoginClient.Request;
import com.facebook.login.LoginClient.Result;
import com.facebook.login.LoginClient.Result.Code;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import com.mpl.androidapp.utils.Constant;
import com.twitter.sdk.android.tweetui.TweetUtils;
import com.xiaomi.mipush.sdk.PushMessageHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b'\u0018\u00002\u00020\u0001B\u000f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0010\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\u001a\u0010\u0015\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0014J0\u0010\u001a\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u00112\b\u0010\u001c\u001a\u0004\u0018\u00010\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010\u0011H\u0014J\u0018\u0010\u001e\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u0013H\u0014J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0019H\u0002J\"\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0018\u0010&\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010'\u001a\u00020$2\u0006\u0010\u0016\u001a\u00020\u0017H&J\u001a\u0010(\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u00192\u0006\u0010#\u001a\u00020$H\u0014R\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006)"}, d2 = {"Lcom/facebook/login/NativeAppLoginMethodHandler;", "Lcom/facebook/login/LoginMethodHandler;", "loginClient", "Lcom/facebook/login/LoginClient;", "(Lcom/facebook/login/LoginClient;)V", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "tokenSource", "Lcom/facebook/AccessTokenSource;", "getTokenSource", "()Lcom/facebook/AccessTokenSource;", "completeLogin", "", "outcome", "Lcom/facebook/login/LoginClient$Result;", "getError", "", "extras", "Landroid/os/Bundle;", "getErrorMessage", "handleResultCancel", "request", "Lcom/facebook/login/LoginClient$Request;", "data", "Landroid/content/Intent;", "handleResultError", "error", "errorMessage", "errorCode", "handleResultOk", "isCallable", "", "intent", "onActivityResult", "requestCode", "", "resultCode", "processSuccessResponse", "tryAuthorize", "tryIntent", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: NativeAppLoginMethodHandler.kt */
public abstract class NativeAppLoginMethodHandler extends LoginMethodHandler {
    public final AccessTokenSource tokenSource = AccessTokenSource.FACEBOOK_APPLICATION_WEB;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public NativeAppLoginMethodHandler(LoginClient loginClient) {
        // Intrinsics.checkNotNullParameter(loginClient, "loginClient");
        super(loginClient);
    }

    /* renamed from: processSuccessResponse$lambda-0  reason: not valid java name */
    public static final void m74processSuccessResponse$lambda0(NativeAppLoginMethodHandler nativeAppLoginMethodHandler, Request request, Bundle bundle) {
        Intrinsics.checkNotNullParameter(nativeAppLoginMethodHandler, "this$0");
        Intrinsics.checkNotNullParameter(request, "$request");
        Intrinsics.checkNotNullParameter(bundle, "$extras");
        try {
            nativeAppLoginMethodHandler.processCodeExchange(request, bundle);
            nativeAppLoginMethodHandler.handleResultOk(request, bundle);
        } catch (FacebookServiceException e2) {
            FacebookRequestError facebookRequestError = e2.requestError;
            nativeAppLoginMethodHandler.handleResultError(request, facebookRequestError.errorType, facebookRequestError.getErrorMessage(), String.valueOf(facebookRequestError.errorCode));
        } catch (FacebookException e3) {
            nativeAppLoginMethodHandler.handleResultError(request, null, e3.getMessage(), null);
        }
    }

    public final void completeLogin(Result result) {
        if (result != null) {
            getLoginClient().completeAndValidate(result);
        } else {
            getLoginClient().tryNextHandler();
        }
    }

    public String getError(Bundle bundle) {
        String string = bundle == null ? null : bundle.getString("error");
        if (string != null) {
            return string;
        }
        if (bundle == null) {
            return null;
        }
        return bundle.getString(PushMessageHelper.ERROR_TYPE);
    }

    public String getErrorMessage(Bundle bundle) {
        String string = bundle == null ? null : bundle.getString(PushMessageHelper.ERROR_MESSAGE);
        if (string != null) {
            return string;
        }
        if (bundle == null) {
            return null;
        }
        return bundle.getString("error_description");
    }

    public AccessTokenSource getTokenSource() {
        return this.tokenSource;
    }

    public void handleResultError(Request request, String str, String str2, String str3) {
        if (str != null && Intrinsics.areEqual(str, "logged_out")) {
            CustomTabLoginMethodHandler.calledThroughLoggedOutAppSwitch = true;
            completeLogin(null);
        } else if (ArraysKt___ArraysJvmKt.contains(TweetUtils.listOf((T[]) new String[]{"service_disabled", "AndroidAuthKillSwitchException"}), str)) {
            completeLogin(null);
        } else if (ArraysKt___ArraysJvmKt.contains(TweetUtils.listOf((T[]) new String[]{"access_denied", "OAuthAccessDeniedException"}), str)) {
            Result result = new Result(request, Code.CANCEL, null, null, null);
            completeLogin(result);
        } else {
            ArrayList arrayList = new ArrayList();
            if (str != null) {
                arrayList.add(str);
            }
            if (str2 != null) {
                arrayList.add(str2);
            }
            Request request2 = request;
            Result result2 = new Result(request2, Code.ERROR, null, TextUtils.join(": ", arrayList), str3);
            completeLogin(result2);
        }
    }

    public void handleResultOk(Request request, Bundle bundle) {
        AuthenticationToken authenticationToken;
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(bundle, "extras");
        try {
            AccessToken createAccessTokenFromWebBundle = LoginMethodHandler.createAccessTokenFromWebBundle(request.permissions, bundle, getTokenSource(), request.applicationId);
            String str = request.nonce;
            Intrinsics.checkNotNullParameter(bundle, Constant.BUNDLE_DIR_NAME);
            String string = bundle.getString("id_token");
            if (string != null) {
                boolean z = false;
                if (!(string.length() == 0) && str != null) {
                    if (str.length() == 0) {
                        z = true;
                    }
                    if (!z) {
                        authenticationToken = new AuthenticationToken(string, str);
                        Result result = new Result(request, Code.SUCCESS, createAccessTokenFromWebBundle, authenticationToken, null, null);
                        completeLogin(result);
                    }
                }
            }
            authenticationToken = null;
            Result result2 = new Result(request, Code.SUCCESS, createAccessTokenFromWebBundle, authenticationToken, null, null);
            completeLogin(result2);
        } catch (Exception e2) {
            throw new FacebookException(e2.getMessage(), e2);
        } catch (FacebookException e3) {
            String message = e3.getMessage();
            ArrayList arrayList = new ArrayList();
            if (message != null) {
                arrayList.add(message);
            }
            Result result3 = new Result(request, Code.ERROR, null, TextUtils.join(": ", arrayList), null);
            completeLogin(result3);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x006b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onActivityResult(int r7, int r8, android.content.Intent r9) {
        /*
            r6 = this;
            com.facebook.login.LoginClient r7 = r6.getLoginClient()
            com.facebook.login.LoginClient$Request r1 = r7.pendingRequest
            r7 = 1
            if (r9 != 0) goto L_0x001a
            com.facebook.login.LoginClient$Result r8 = new com.facebook.login.LoginClient$Result
            com.facebook.login.LoginClient$Result$Code r2 = com.facebook.login.LoginClient.Result.Code.CANCEL
            r3 = 0
            r5 = 0
            java.lang.String r4 = "Operation canceled"
            r0 = r8
            r0.<init>(r1, r2, r3, r4, r5)
            r6.completeLogin(r8)
            goto L_0x010e
        L_0x001a:
            java.lang.String r0 = "error_code"
            java.lang.String r2 = ": "
            r3 = 0
            if (r8 != 0) goto L_0x007a
            java.lang.String r8 = "data"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r8)
            android.os.Bundle r8 = r9.getExtras()
            java.lang.String r4 = r6.getError(r8)
            if (r8 != 0) goto L_0x0031
            goto L_0x0037
        L_0x0031:
            java.lang.Object r9 = r8.get(r0)
            if (r9 != 0) goto L_0x0039
        L_0x0037:
            r5 = r3
            goto L_0x003e
        L_0x0039:
            java.lang.String r9 = r9.toString()
            r5 = r9
        L_0x003e:
            java.lang.String r9 = "CONNECTION_FAILURE"
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual(r9, r5)
            if (r9 == 0) goto L_0x006b
            java.lang.String r8 = r6.getErrorMessage(r8)
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            if (r4 == 0) goto L_0x0054
            r9.add(r4)
        L_0x0054:
            if (r8 == 0) goto L_0x0059
            r9.add(r8)
        L_0x0059:
            java.lang.String r4 = android.text.TextUtils.join(r2, r9)
            com.facebook.login.LoginClient$Result r8 = new com.facebook.login.LoginClient$Result
            com.facebook.login.LoginClient$Result$Code r2 = com.facebook.login.LoginClient.Result.Code.ERROR
            r3 = 0
            r0 = r8
            r0.<init>(r1, r2, r3, r4, r5)
            r6.completeLogin(r8)
            goto L_0x010e
        L_0x006b:
            com.facebook.login.LoginClient$Result r8 = new com.facebook.login.LoginClient$Result
            com.facebook.login.LoginClient$Result$Code r2 = com.facebook.login.LoginClient.Result.Code.CANCEL
            r3 = 0
            r5 = 0
            r0 = r8
            r0.<init>(r1, r2, r3, r4, r5)
            r6.completeLogin(r8)
            goto L_0x010e
        L_0x007a:
            r4 = -1
            if (r8 == r4) goto L_0x009a
            r5 = 0
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.lang.String r9 = "Unexpected resultCode from authorization."
            r8.add(r9)
            java.lang.String r4 = android.text.TextUtils.join(r2, r8)
            com.facebook.login.LoginClient$Result r8 = new com.facebook.login.LoginClient$Result
            com.facebook.login.LoginClient$Result$Code r2 = com.facebook.login.LoginClient.Result.Code.ERROR
            r3 = 0
            r0 = r8
            r0.<init>(r1, r2, r3, r4, r5)
            r6.completeLogin(r8)
            goto L_0x010e
        L_0x009a:
            android.os.Bundle r8 = r9.getExtras()
            if (r8 != 0) goto L_0x00bc
            r5 = 0
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.lang.String r9 = "Unexpected null from returned authorization data."
            r8.add(r9)
            java.lang.String r4 = android.text.TextUtils.join(r2, r8)
            com.facebook.login.LoginClient$Result r8 = new com.facebook.login.LoginClient$Result
            com.facebook.login.LoginClient$Result$Code r2 = com.facebook.login.LoginClient.Result.Code.ERROR
            r3 = 0
            r0 = r8
            r0.<init>(r1, r2, r3, r4, r5)
            r6.completeLogin(r8)
            return r7
        L_0x00bc:
            java.lang.String r9 = r6.getError(r8)
            java.lang.Object r0 = r8.get(r0)
            if (r0 != 0) goto L_0x00c7
            goto L_0x00cb
        L_0x00c7:
            java.lang.String r3 = r0.toString()
        L_0x00cb:
            java.lang.String r0 = r6.getErrorMessage(r8)
            java.lang.String r2 = "e2e"
            java.lang.String r2 = r8.getString(r2)
            boolean r4 = com.facebook.internal.Utility.isNullOrEmpty(r2)
            if (r4 != 0) goto L_0x00de
            r6.logWebLoginCompleted(r2)
        L_0x00de:
            if (r9 != 0) goto L_0x010b
            if (r3 != 0) goto L_0x010b
            if (r0 != 0) goto L_0x010b
            if (r1 == 0) goto L_0x010b
            java.lang.String r9 = "code"
            boolean r0 = r8.containsKey(r9)
            if (r0 == 0) goto L_0x0107
            java.lang.String r9 = r8.getString(r9)
            boolean r9 = com.facebook.internal.Utility.isNullOrEmpty(r9)
            if (r9 != 0) goto L_0x0107
            com.facebook.FacebookSdk r9 = com.facebook.FacebookSdk.INSTANCE
            java.util.concurrent.Executor r9 = com.facebook.FacebookSdk.getExecutor()
            com.facebook.login.-$$Lambda$-4r281_oyefK-1ARw81zOtoc6JU r0 = new com.facebook.login.-$$Lambda$-4r281_oyefK-1ARw81zOtoc6JU
            r0.<init>(r1, r8)
            r9.execute(r0)
            goto L_0x010e
        L_0x0107:
            r6.handleResultOk(r1, r8)
            goto L_0x010e
        L_0x010b:
            r6.handleResultError(r1, r9, r0, r3)
        L_0x010e:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.login.NativeAppLoginMethodHandler.onActivityResult(int, int, android.content.Intent):boolean");
    }

    public boolean tryIntent(Intent intent) {
        if (intent != null) {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            List<ResolveInfo> queryIntentActivities = FacebookSdk.getApplicationContext().getPackageManager().queryIntentActivities(intent, 65536);
            Intrinsics.checkNotNullExpressionValue(queryIntentActivities, "FacebookSdk.getApplicationContext()\n            .packageManager\n            .queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY)");
            if (!queryIntentActivities.isEmpty()) {
                Fragment fragment = getLoginClient().fragment;
                Unit unit = null;
                LoginFragment loginFragment = fragment instanceof LoginFragment ? (LoginFragment) fragment : null;
                if (loginFragment != null) {
                    ActivityResultLauncher<Intent> activityResultLauncher = loginFragment.launcher;
                    if (activityResultLauncher != null) {
                        activityResultLauncher.launch(intent);
                        unit = Unit.INSTANCE;
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("launcher");
                        throw null;
                    }
                }
                if (unit == null) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public NativeAppLoginMethodHandler(Parcel parcel) {
        // Intrinsics.checkNotNullParameter(parcel, DefaultSettingsSpiCall.SOURCE_PARAM);
        super(parcel);
    }
}
