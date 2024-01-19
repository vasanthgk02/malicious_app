package com.facebook.login;

import android.os.Parcel;
import com.facebook.AccessTokenSource;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u000f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0010\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0014J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0014J\n\u0010\u0014\u001a\u0004\u0018\u00010\tH\u0014J\n\u0010\u0015\u001a\u0004\u0018\u00010\tH\u0002J$\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0017J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\tH\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u001e"}, d2 = {"Lcom/facebook/login/WebLoginMethodHandler;", "Lcom/facebook/login/LoginMethodHandler;", "loginClient", "Lcom/facebook/login/LoginClient;", "(Lcom/facebook/login/LoginClient;)V", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "e2e", "", "tokenSource", "Lcom/facebook/AccessTokenSource;", "getTokenSource", "()Lcom/facebook/AccessTokenSource;", "addExtraParameters", "Landroid/os/Bundle;", "parameters", "request", "Lcom/facebook/login/LoginClient$Request;", "getParameters", "getSSODevice", "loadCookieToken", "onComplete", "", "values", "error", "Lcom/facebook/FacebookException;", "saveCookieToken", "token", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: WebLoginMethodHandler.kt */
public abstract class WebLoginMethodHandler extends LoginMethodHandler {
    public String e2e;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public WebLoginMethodHandler(LoginClient loginClient) {
        // Intrinsics.checkNotNullParameter(loginClient, "loginClient");
        super(loginClient);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.os.Bundle getParameters(com.facebook.login.LoginClient.Request r8) {
        /*
            r7 = this;
            java.lang.String r0 = "request"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            java.util.Set<java.lang.String> r1 = r8.permissions
            boolean r1 = com.facebook.internal.Utility.isNullOrEmpty(r1)
            if (r1 != 0) goto L_0x0022
            java.util.Set<java.lang.String> r1 = r8.permissions
            java.lang.String r2 = ","
            java.lang.String r1 = android.text.TextUtils.join(r2, r1)
            java.lang.String r2 = "scope"
            r0.putString(r2, r1)
            r7.addLoggingExtra(r2, r1)
        L_0x0022:
            com.facebook.login.DefaultAudience r1 = r8.defaultAudience
            if (r1 != 0) goto L_0x0028
            com.facebook.login.DefaultAudience r1 = com.facebook.login.DefaultAudience.NONE
        L_0x0028:
            java.lang.String r1 = r1.getNativeProtocolAudience()
            java.lang.String r2 = "default_audience"
            r0.putString(r2, r1)
            java.lang.String r8 = r8.authId
            java.lang.String r8 = r7.getClientState(r8)
            java.lang.String r1 = "state"
            r0.putString(r1, r8)
            com.facebook.AccessToken$Companion r8 = com.facebook.AccessToken.Companion
            com.facebook.AccessToken r8 = com.facebook.AccessToken.Companion.getCurrentAccessToken()
            if (r8 != 0) goto L_0x0046
            r8 = 0
            goto L_0x0048
        L_0x0046:
            java.lang.String r8 = r8.token
        L_0x0048:
            java.lang.String r1 = "0"
            java.lang.String r2 = "1"
            java.lang.String r3 = "access_token"
            if (r8 == 0) goto L_0x007c
            com.facebook.login.LoginClient r4 = r7.getLoginClient()
            androidx.fragment.app.FragmentActivity r4 = r4.getActivity()
            if (r4 != 0) goto L_0x0060
            com.facebook.FacebookSdk r4 = com.facebook.FacebookSdk.INSTANCE
            android.content.Context r4 = com.facebook.FacebookSdk.getApplicationContext()
        L_0x0060:
            r5 = 0
            java.lang.String r6 = "com.facebook.login.AuthorizationClient.WebViewAuthHandler.TOKEN_STORE_KEY"
            android.content.SharedPreferences r4 = r4.getSharedPreferences(r6, r5)
            java.lang.String r5 = "TOKEN"
            java.lang.String r6 = ""
            java.lang.String r4 = r4.getString(r5, r6)
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r8, r4)
            if (r4 == 0) goto L_0x007c
            r0.putString(r3, r8)
            r7.addLoggingExtra(r3, r2)
            goto L_0x008d
        L_0x007c:
            com.facebook.login.LoginClient r8 = r7.getLoginClient()
            androidx.fragment.app.FragmentActivity r8 = r8.getActivity()
            if (r8 != 0) goto L_0x0087
            goto L_0x008a
        L_0x0087:
            com.facebook.internal.Utility.clearFacebookCookies(r8)
        L_0x008a:
            r7.addLoggingExtra(r3, r1)
        L_0x008d:
            long r3 = java.lang.System.currentTimeMillis()
            java.lang.String r8 = java.lang.String.valueOf(r3)
            java.lang.String r3 = "cbt"
            r0.putString(r3, r8)
            com.facebook.FacebookSdk r8 = com.facebook.FacebookSdk.INSTANCE
            boolean r8 = com.facebook.FacebookSdk.getAutoLogAppEventsEnabled()
            if (r8 == 0) goto L_0x00a3
            r1 = r2
        L_0x00a3:
            java.lang.String r8 = "ies"
            r0.putString(r8, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.login.WebLoginMethodHandler.getParameters(com.facebook.login.LoginClient$Request):android.os.Bundle");
    }

    public abstract AccessTokenSource getTokenSource();

    /* JADX WARNING: type inference failed for: r1v1 */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onComplete(com.facebook.login.LoginClient.Request r13, android.os.Bundle r14, com.facebook.FacebookException r15) {
        /*
            r12 = this;
            java.lang.String r0 = "request"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            com.facebook.login.LoginClient r0 = r12.getLoginClient()
            r1 = 0
            r12.e2e = r1
            java.lang.String r2 = ": "
            if (r14 == 0) goto L_0x00ce
            java.lang.String r15 = "e2e"
            boolean r3 = r14.containsKey(r15)
            if (r3 == 0) goto L_0x001e
            java.lang.String r15 = r14.getString(r15)
            r12.e2e = r15
        L_0x001e:
            java.util.Set<java.lang.String> r15 = r13.permissions     // Catch:{ FacebookException -> 0x00ae }
            com.facebook.AccessTokenSource r3 = r12.getTokenSource()     // Catch:{ FacebookException -> 0x00ae }
            java.lang.String r4 = r13.applicationId     // Catch:{ FacebookException -> 0x00ae }
            com.facebook.AccessToken r15 = com.facebook.login.LoginMethodHandler.createAccessTokenFromWebBundle(r15, r14, r3, r4)     // Catch:{ FacebookException -> 0x00ae }
            java.lang.String r13 = r13.nonce     // Catch:{ FacebookException -> 0x00ae }
            java.lang.String r3 = "bundle"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r3)     // Catch:{ FacebookException -> 0x00ae }
            java.lang.String r3 = "id_token"
            java.lang.String r14 = r14.getString(r3)     // Catch:{ FacebookException -> 0x00ae }
            r3 = 0
            if (r14 == 0) goto L_0x0064
            int r4 = r14.length()     // Catch:{ FacebookException -> 0x00ae }
            r5 = 1
            if (r4 != 0) goto L_0x0043
            r4 = 1
            goto L_0x0044
        L_0x0043:
            r4 = 0
        L_0x0044:
            if (r4 != 0) goto L_0x0064
            if (r13 == 0) goto L_0x0064
            int r4 = r13.length()     // Catch:{ FacebookException -> 0x00ae }
            if (r4 != 0) goto L_0x004f
            goto L_0x0050
        L_0x004f:
            r5 = 0
        L_0x0050:
            if (r5 == 0) goto L_0x0053
            goto L_0x0064
        L_0x0053:
            com.facebook.AuthenticationToken r1 = new com.facebook.AuthenticationToken     // Catch:{ Exception -> 0x0059 }
            r1.<init>(r14, r13)     // Catch:{ Exception -> 0x0059 }
            goto L_0x0064
        L_0x0059:
            r13 = move-exception
            com.facebook.FacebookException r14 = new com.facebook.FacebookException     // Catch:{ FacebookException -> 0x00ae }
            java.lang.String r15 = r13.getMessage()     // Catch:{ FacebookException -> 0x00ae }
            r14.<init>(r15, r13)     // Catch:{ FacebookException -> 0x00ae }
            throw r14     // Catch:{ FacebookException -> 0x00ae }
        L_0x0064:
            r9 = r1
            com.facebook.login.LoginClient$Request r6 = r0.pendingRequest     // Catch:{ FacebookException -> 0x00ae }
            com.facebook.login.LoginClient$Result r13 = new com.facebook.login.LoginClient$Result     // Catch:{ FacebookException -> 0x00ae }
            com.facebook.login.LoginClient$Result$Code r7 = com.facebook.login.LoginClient.Result.Code.SUCCESS     // Catch:{ FacebookException -> 0x00ae }
            r10 = 0
            r11 = 0
            r5 = r13
            r8 = r15
            r5.<init>(r6, r7, r8, r9, r10, r11)     // Catch:{ FacebookException -> 0x00ae }
            androidx.fragment.app.FragmentActivity r14 = r0.getActivity()     // Catch:{ FacebookException -> 0x00ae }
            if (r14 == 0) goto L_0x0117
            androidx.fragment.app.FragmentActivity r14 = r0.getActivity()     // Catch:{ Exception -> 0x0084 }
            android.webkit.CookieSyncManager r14 = android.webkit.CookieSyncManager.createInstance(r14)     // Catch:{ Exception -> 0x0084 }
            r14.sync()     // Catch:{ Exception -> 0x0084 }
            goto L_0x0085
        L_0x0084:
        L_0x0085:
            if (r15 == 0) goto L_0x0117
            java.lang.String r14 = r15.token     // Catch:{ FacebookException -> 0x00ae }
            com.facebook.login.LoginClient r15 = r12.getLoginClient()     // Catch:{ FacebookException -> 0x00ae }
            androidx.fragment.app.FragmentActivity r15 = r15.getActivity()     // Catch:{ FacebookException -> 0x00ae }
            if (r15 != 0) goto L_0x0099
            com.facebook.FacebookSdk r15 = com.facebook.FacebookSdk.INSTANCE     // Catch:{ FacebookException -> 0x00ae }
            android.content.Context r15 = com.facebook.FacebookSdk.getApplicationContext()     // Catch:{ FacebookException -> 0x00ae }
        L_0x0099:
            java.lang.String r1 = "com.facebook.login.AuthorizationClient.WebViewAuthHandler.TOKEN_STORE_KEY"
            android.content.SharedPreferences r15 = r15.getSharedPreferences(r1, r3)     // Catch:{ FacebookException -> 0x00ae }
            android.content.SharedPreferences$Editor r15 = r15.edit()     // Catch:{ FacebookException -> 0x00ae }
            java.lang.String r1 = "TOKEN"
            android.content.SharedPreferences$Editor r14 = r15.putString(r1, r14)     // Catch:{ FacebookException -> 0x00ae }
            r14.apply()     // Catch:{ FacebookException -> 0x00ae }
            goto L_0x0117
        L_0x00ae:
            r13 = move-exception
            com.facebook.login.LoginClient$Request r4 = r0.pendingRequest
            java.lang.String r13 = r13.getMessage()
            r8 = 0
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            if (r13 == 0) goto L_0x00c0
            r14.add(r13)
        L_0x00c0:
            java.lang.String r7 = android.text.TextUtils.join(r2, r14)
            com.facebook.login.LoginClient$Result r13 = new com.facebook.login.LoginClient$Result
            com.facebook.login.LoginClient$Result$Code r5 = com.facebook.login.LoginClient.Result.Code.ERROR
            r6 = 0
            r3 = r13
            r3.<init>(r4, r5, r6, r7, r8)
            goto L_0x0117
        L_0x00ce:
            boolean r13 = r15 instanceof com.facebook.FacebookOperationCanceledException
            if (r13 == 0) goto L_0x00e1
            com.facebook.login.LoginClient$Request r4 = r0.pendingRequest
            com.facebook.login.LoginClient$Result r13 = new com.facebook.login.LoginClient$Result
            com.facebook.login.LoginClient$Result$Code r5 = com.facebook.login.LoginClient.Result.Code.CANCEL
            r6 = 0
            r8 = 0
            java.lang.String r7 = "User canceled log in."
            r3 = r13
            r3.<init>(r4, r5, r6, r7, r8)
            goto L_0x0117
        L_0x00e1:
            r12.e2e = r1
            if (r15 != 0) goto L_0x00e7
            r13 = r1
            goto L_0x00eb
        L_0x00e7:
            java.lang.String r13 = r15.getMessage()
        L_0x00eb:
            boolean r14 = r15 instanceof com.facebook.FacebookServiceException
            if (r14 == 0) goto L_0x00fd
            com.facebook.FacebookServiceException r15 = (com.facebook.FacebookServiceException) r15
            com.facebook.FacebookRequestError r13 = r15.requestError
            int r14 = r13.errorCode
            java.lang.String r1 = java.lang.String.valueOf(r14)
            java.lang.String r13 = r13.toString()
        L_0x00fd:
            r8 = r1
            com.facebook.login.LoginClient$Request r4 = r0.pendingRequest
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            if (r13 == 0) goto L_0x010a
            r14.add(r13)
        L_0x010a:
            java.lang.String r7 = android.text.TextUtils.join(r2, r14)
            com.facebook.login.LoginClient$Result r13 = new com.facebook.login.LoginClient$Result
            com.facebook.login.LoginClient$Result$Code r5 = com.facebook.login.LoginClient.Result.Code.ERROR
            r6 = 0
            r3 = r13
            r3.<init>(r4, r5, r6, r7, r8)
        L_0x0117:
            java.lang.String r14 = r12.e2e
            boolean r14 = com.facebook.internal.Utility.isNullOrEmpty(r14)
            if (r14 != 0) goto L_0x0124
            java.lang.String r14 = r12.e2e
            r12.logWebLoginCompleted(r14)
        L_0x0124:
            r0.completeAndValidate(r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.login.WebLoginMethodHandler.onComplete(com.facebook.login.LoginClient$Request, android.os.Bundle, com.facebook.FacebookException):void");
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public WebLoginMethodHandler(Parcel parcel) {
        // Intrinsics.checkNotNullParameter(parcel, DefaultSettingsSpiCall.SOURCE_PARAM);
        super(parcel);
    }
}
