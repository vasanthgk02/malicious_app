package com.facebook.login;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.facebook.AccessTokenSource;
import com.facebook.CustomTabMainActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.internal.CustomTabUtils;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.login.CustomTabPrefetchHelper.Companion;
import com.facebook.login.LoginClient.Request;
import com.google.firebase.crashlytics.internal.analytics.BreadcrumbAnalyticsEventReceiver;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import com.razorpay.AnalyticsConstants;
import in.juspay.hypersdk.core.Labels.SDK;
import in.juspay.hypersdk.core.PaymentConstants;
import java.math.BigInteger;
import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.pdfbox.pdfparser.BaseParser;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 02\u00020\u0001:\u00010B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0010\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\tH\u0014J\n\u0010\u001a\u001a\u0004\u0018\u00010\tH\u0014J\"\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u00182\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u001a\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\t2\u0006\u0010$\u001a\u00020%H\u0002J\u0010\u0010&\u001a\u00020\"2\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020\u00182\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010*\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020,H\u0002J\u0018\u0010-\u001a\u00020\"2\u0006\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u0018H\u0016R\u0016\u0010\b\u001a\u0004\u0018\u00010\t8BX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\t8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000bR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\tXD¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u0014\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/facebook/login/CustomTabLoginMethodHandler;", "Lcom/facebook/login/WebLoginMethodHandler;", "loginClient", "Lcom/facebook/login/LoginClient;", "(Lcom/facebook/login/LoginClient;)V", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "chromePackage", "", "getChromePackage", "()Ljava/lang/String;", "currentPackage", "developerDefinedRedirectURI", "getDeveloperDefinedRedirectURI", "expectedChallenge", "nameForLogging", "getNameForLogging", "tokenSource", "Lcom/facebook/AccessTokenSource;", "getTokenSource", "()Lcom/facebook/AccessTokenSource;", "validRedirectURI", "describeContents", "", "getRedirectUrl", "getSSODevice", "onActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCustomTabComplete", "", "url", "request", "Lcom/facebook/login/LoginClient$Request;", "putChallengeParam", "param", "Lorg/json/JSONObject;", "tryAuthorize", "validateChallengeParam", "values", "Landroid/os/Bundle;", "writeToParcel", "dest", "flags", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: CustomTabLoginMethodHandler.kt */
public final class CustomTabLoginMethodHandler extends WebLoginMethodHandler {
    public static final Creator<CustomTabLoginMethodHandler> CREATOR = new CustomTabLoginMethodHandler$Companion$CREATOR$1();
    public static boolean calledThroughLoggedOutAppSwitch;
    public String currentPackage;
    public String expectedChallenge;
    public final String nameForLogging = SDK.CUSTOM_TAB;
    public final AccessTokenSource tokenSource = AccessTokenSource.CHROME_CUSTOM_TAB;
    public String validRedirectURI;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public CustomTabLoginMethodHandler(LoginClient loginClient) {
        // Intrinsics.checkNotNullParameter(loginClient, "loginClient");
        super(loginClient);
        String bigInteger = new BigInteger(100, new Random()).toString(32);
        Intrinsics.checkNotNullExpressionValue(bigInteger, "BigInteger(length * 5, r).toString(32)");
        this.expectedChallenge = bigInteger;
        calledThroughLoggedOutAppSwitch = false;
        this.validRedirectURI = CustomTabUtils.getValidRedirectURI(super.getRedirectUrl());
    }

    /* renamed from: onCustomTabComplete$lambda-0  reason: not valid java name */
    public static final void m60onCustomTabComplete$lambda0(CustomTabLoginMethodHandler customTabLoginMethodHandler, Request request, Bundle bundle) {
        Intrinsics.checkNotNullParameter(customTabLoginMethodHandler, "this$0");
        Intrinsics.checkNotNullParameter(request, "$request");
        Intrinsics.checkNotNullParameter(bundle, "$values");
        try {
            customTabLoginMethodHandler.processCodeExchange(request, bundle);
            customTabLoginMethodHandler.onComplete(request, bundle, null);
        } catch (FacebookException e2) {
            customTabLoginMethodHandler.onComplete(request, null, e2);
        }
    }

    public int describeContents() {
        return 0;
    }

    public String getNameForLogging() {
        return this.nameForLogging;
    }

    public String getRedirectUrl() {
        return this.validRedirectURI;
    }

    public AccessTokenSource getTokenSource() {
        return this.tokenSource;
    }

    /* JADX WARNING: Removed duplicated region for block: B:61:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0101  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onActivityResult(int r7, int r8, android.content.Intent r9) {
        /*
            r6 = this;
            r0 = 0
            if (r9 == 0) goto L_0x000c
            java.lang.String r1 = com.facebook.CustomTabMainActivity.NO_ACTIVITY_EXCEPTION
            boolean r1 = r9.getBooleanExtra(r1, r0)
            if (r1 == 0) goto L_0x000c
            return r0
        L_0x000c:
            r1 = 1
            if (r7 == r1) goto L_0x0010
            return r0
        L_0x0010:
            com.facebook.login.LoginClient r7 = r6.getLoginClient()
            com.facebook.login.LoginClient$Request r7 = r7.pendingRequest
            if (r7 != 0) goto L_0x0019
            return r0
        L_0x0019:
            r2 = 0
            r3 = -1
            if (r8 != r3) goto L_0x010f
            if (r9 == 0) goto L_0x0026
            java.lang.String r8 = com.facebook.CustomTabMainActivity.EXTRA_URL
            java.lang.String r8 = r9.getStringExtra(r8)
            goto L_0x0027
        L_0x0026:
            r8 = r2
        L_0x0027:
            if (r8 == 0) goto L_0x010e
            r9 = 2
            java.lang.String r4 = "fbconnect://cct."
            boolean r4 = kotlin.text.CharsKt__CharKt.startsWith$default(r8, r4, r0, r9)
            if (r4 != 0) goto L_0x003c
            java.lang.String r4 = super.getRedirectUrl()
            boolean r9 = kotlin.text.CharsKt__CharKt.startsWith$default(r8, r4, r0, r9)
            if (r9 == 0) goto L_0x010e
        L_0x003c:
            android.net.Uri r8 = android.net.Uri.parse(r8)
            java.lang.String r9 = r8.getQuery()
            android.os.Bundle r9 = com.facebook.internal.Utility.parseUrlQueryString(r9)
            java.lang.String r8 = r8.getFragment()
            android.os.Bundle r8 = com.facebook.internal.Utility.parseUrlQueryString(r8)
            r9.putAll(r8)
            java.lang.String r8 = "state"
            java.lang.String r8 = r9.getString(r8)     // Catch:{ JSONException -> 0x006e }
            if (r8 != 0) goto L_0x005c
            goto L_0x006f
        L_0x005c:
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ JSONException -> 0x006e }
            r4.<init>(r8)     // Catch:{ JSONException -> 0x006e }
            java.lang.String r8 = "7_challenge"
            java.lang.String r8 = r4.getString(r8)     // Catch:{ JSONException -> 0x006e }
            java.lang.String r4 = r6.expectedChallenge     // Catch:{ JSONException -> 0x006e }
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r8, r4)     // Catch:{ JSONException -> 0x006e }
            goto L_0x006f
        L_0x006e:
        L_0x006f:
            if (r0 != 0) goto L_0x007d
            com.facebook.FacebookException r8 = new com.facebook.FacebookException
            java.lang.String r9 = "Invalid state parameter"
            r8.<init>(r9)
            super.onComplete(r7, r2, r8)
            goto L_0x010e
        L_0x007d:
            java.lang.String r8 = "error"
            java.lang.String r8 = r9.getString(r8)
            if (r8 != 0) goto L_0x008b
            java.lang.String r8 = "error_type"
            java.lang.String r8 = r9.getString(r8)
        L_0x008b:
            java.lang.String r0 = "error_msg"
            java.lang.String r0 = r9.getString(r0)
            if (r0 != 0) goto L_0x0099
            java.lang.String r0 = "error_message"
            java.lang.String r0 = r9.getString(r0)
        L_0x0099:
            if (r0 != 0) goto L_0x00a1
            java.lang.String r0 = "error_description"
            java.lang.String r0 = r9.getString(r0)
        L_0x00a1:
            java.lang.String r4 = "error_code"
            java.lang.String r4 = r9.getString(r4)
            if (r4 != 0) goto L_0x00aa
            goto L_0x00af
        L_0x00aa:
            int r4 = java.lang.Integer.parseInt(r4)     // Catch:{ NumberFormatException -> 0x00af }
            goto L_0x00b0
        L_0x00af:
            r4 = -1
        L_0x00b0:
            boolean r5 = com.facebook.internal.Utility.isNullOrEmpty(r8)
            if (r5 == 0) goto L_0x00d9
            boolean r5 = com.facebook.internal.Utility.isNullOrEmpty(r0)
            if (r5 == 0) goto L_0x00d9
            if (r4 != r3) goto L_0x00d9
            java.lang.String r8 = "access_token"
            boolean r8 = r9.containsKey(r8)
            if (r8 == 0) goto L_0x00ca
            super.onComplete(r7, r9, r2)
            goto L_0x010e
        L_0x00ca:
            com.facebook.FacebookSdk r8 = com.facebook.FacebookSdk.INSTANCE
            java.util.concurrent.Executor r8 = com.facebook.FacebookSdk.getExecutor()
            com.facebook.login.-$$Lambda$0BMF4P_RxQCfsUXf0Xd3ErROU8g r0 = new com.facebook.login.-$$Lambda$0BMF4P_RxQCfsUXf0Xd3ErROU8g
            r0.<init>(r7, r9)
            r8.execute(r0)
            goto L_0x010e
        L_0x00d9:
            if (r8 == 0) goto L_0x00f4
            java.lang.String r9 = "access_denied"
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual(r8, r9)
            if (r9 != 0) goto L_0x00eb
            java.lang.String r9 = "OAuthAccessDeniedException"
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual(r8, r9)
            if (r9 == 0) goto L_0x00f4
        L_0x00eb:
            com.facebook.FacebookOperationCanceledException r8 = new com.facebook.FacebookOperationCanceledException
            r8.<init>()
            super.onComplete(r7, r2, r8)
            goto L_0x010e
        L_0x00f4:
            r9 = 4201(0x1069, float:5.887E-42)
            if (r4 != r9) goto L_0x0101
            com.facebook.FacebookOperationCanceledException r8 = new com.facebook.FacebookOperationCanceledException
            r8.<init>()
            super.onComplete(r7, r2, r8)
            goto L_0x010e
        L_0x0101:
            com.facebook.FacebookRequestError r9 = new com.facebook.FacebookRequestError
            r9.<init>(r4, r8, r0)
            com.facebook.FacebookServiceException r8 = new com.facebook.FacebookServiceException
            r8.<init>(r9, r0)
            super.onComplete(r7, r2, r8)
        L_0x010e:
            return r1
        L_0x010f:
            com.facebook.FacebookOperationCanceledException r8 = new com.facebook.FacebookOperationCanceledException
            r8.<init>()
            super.onComplete(r7, r2, r8)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.login.CustomTabLoginMethodHandler.onActivityResult(int, int, android.content.Intent):boolean");
    }

    public void putChallengeParam(JSONObject jSONObject) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject, "param");
        jSONObject.put("7_challenge", this.expectedChallenge);
    }

    public int tryAuthorize(Request request) {
        String str;
        Uri uri;
        Intrinsics.checkNotNullParameter(request, "request");
        LoginClient loginClient = getLoginClient();
        if (this.validRedirectURI.length() == 0) {
            return 0;
        }
        Bundle parameters = getParameters(request);
        Intrinsics.checkNotNullParameter(parameters, BreadcrumbAnalyticsEventReceiver.BREADCRUMB_PARAMS_KEY);
        Intrinsics.checkNotNullParameter(request, "request");
        parameters.putString("redirect_uri", this.validRedirectURI);
        if (request.isInstagramLogin()) {
            parameters.putString("app_id", request.applicationId);
        } else {
            parameters.putString(PaymentConstants.CLIENT_ID, request.applicationId);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(AnalyticsConstants.INIT, System.currentTimeMillis());
        } catch (JSONException unused) {
        }
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "e2e.toString()");
        parameters.putString("e2e", jSONObject2);
        if (request.isInstagramLogin()) {
            parameters.putString("response_type", "token,signed_request,graph_domain,granted_scopes");
        } else {
            if (request.permissions.contains("openid")) {
                parameters.putString("nonce", request.nonce);
            }
            parameters.putString("response_type", "id_token,token,signed_request,graph_domain");
        }
        parameters.putString("code_challenge", request.codeChallenge);
        CodeChallengeMethod codeChallengeMethod = request.codeChallengeMethod;
        if (codeChallengeMethod == null) {
            str = null;
        } else {
            str = codeChallengeMethod.name();
        }
        parameters.putString("code_challenge_method", str);
        parameters.putString("return_scopes", BaseParser.TRUE);
        parameters.putString("auth_type", request.authType);
        parameters.putString("login_behavior", request.loginBehavior.name());
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        parameters.putString("sdk", Intrinsics.stringPlus("android-", "16.0.1"));
        parameters.putString("sso", "chrome_custom_tab");
        String str2 = "0";
        parameters.putString("cct_prefetching", FacebookSdk.hasCustomTabsPrefetching ? "1" : str2);
        if (request.isFamilyLogin) {
            parameters.putString("fx_app", request.loginTargetApp.toString());
        }
        if (request.shouldSkipAccountDeduplication) {
            parameters.putString("skip_dedupe", BaseParser.TRUE);
        }
        String str3 = request.messengerPageId;
        if (str3 != null) {
            parameters.putString("messenger_page_id", str3);
            if (request.resetMessengerState) {
                str2 = "1";
            }
            parameters.putString("reset_messenger_state", str2);
        }
        if (calledThroughLoggedOutAppSwitch) {
            parameters.putString("cct_over_app_switch", "1");
        }
        if (FacebookSdk.hasCustomTabsPrefetching) {
            if (request.isInstagramLogin()) {
                Companion companion = CustomTabPrefetchHelper.Companion;
                Intrinsics.checkNotNullParameter("oauth", "action");
                if (Intrinsics.areEqual("oauth", "oauth")) {
                    uri = Utility.buildUri(ServerProtocol.getInstagramDialogAuthority(), "oauth/authorize", parameters);
                } else {
                    String instagramDialogAuthority = ServerProtocol.getInstagramDialogAuthority();
                    StringBuilder sb = new StringBuilder();
                    FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
                    sb.append(FacebookSdk.getGraphApiVersion());
                    sb.append("/dialog/");
                    sb.append("oauth");
                    uri = Utility.buildUri(instagramDialogAuthority, sb.toString(), parameters);
                }
                companion.mayLaunchUrl(uri);
            } else {
                Companion companion2 = CustomTabPrefetchHelper.Companion;
                Intrinsics.checkNotNullParameter("oauth", "action");
                String dialogAuthority = ServerProtocol.getDialogAuthority();
                StringBuilder sb2 = new StringBuilder();
                FacebookSdk facebookSdk3 = FacebookSdk.INSTANCE;
                sb2.append(FacebookSdk.getGraphApiVersion());
                sb2.append("/dialog/");
                sb2.append("oauth");
                companion2.mayLaunchUrl(Utility.buildUri(dialogAuthority, sb2.toString(), parameters));
            }
        }
        FragmentActivity activity = loginClient.getActivity();
        if (activity == null) {
            return 0;
        }
        Intent intent = new Intent(activity, CustomTabMainActivity.class);
        intent.putExtra(CustomTabMainActivity.EXTRA_ACTION, "oauth");
        intent.putExtra(CustomTabMainActivity.EXTRA_PARAMS, parameters);
        String str4 = CustomTabMainActivity.EXTRA_CHROME_PACKAGE;
        String str5 = this.currentPackage;
        if (str5 == null) {
            str5 = CustomTabUtils.getChromePackage();
            this.currentPackage = str5;
        }
        intent.putExtra(str4, str5);
        intent.putExtra(CustomTabMainActivity.EXTRA_TARGET_APP, request.loginTargetApp.toString());
        Fragment fragment = loginClient.fragment;
        if (fragment != null) {
            fragment.startActivityForResult(intent, 1);
        }
        return 1;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        super.writeToParcel(parcel, i);
        parcel.writeString(this.expectedChallenge);
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public CustomTabLoginMethodHandler(Parcel parcel) {
        // Intrinsics.checkNotNullParameter(parcel, DefaultSettingsSpiCall.SOURCE_PARAM);
        super(parcel);
        this.expectedChallenge = parcel.readString();
        this.validRedirectURI = CustomTabUtils.getValidRedirectURI(super.getRedirectUrl());
    }
}
