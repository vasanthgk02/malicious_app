package com.facebook.login;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.AuthenticationToken;
import com.facebook.FacebookException;
import com.facebook.internal.Utility;
import com.facebook.login.LoginClient.BackgroundProcessingListener;
import com.facebook.login.LoginClient.Request;
import com.facebook.login.LoginClient.Result;
import com.facebook.login.LoginClient.Result.Code;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import com.mpl.androidapp.login.LoginReactModule;
import com.mpl.androidapp.utils.Constant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptySet;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0016\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0016\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000bXD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/facebook/login/GetTokenLoginMethodHandler;", "Lcom/facebook/login/LoginMethodHandler;", "loginClient", "Lcom/facebook/login/LoginClient;", "(Lcom/facebook/login/LoginClient;)V", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getTokenClient", "Lcom/facebook/login/GetTokenClient;", "nameForLogging", "", "getNameForLogging", "()Ljava/lang/String;", "cancel", "", "complete", "request", "Lcom/facebook/login/LoginClient$Request;", "result", "Landroid/os/Bundle;", "describeContents", "", "getTokenCompleted", "onComplete", "tryAuthorize", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: GetTokenLoginMethodHandler.kt */
public final class GetTokenLoginMethodHandler extends LoginMethodHandler {
    public static final Creator<GetTokenLoginMethodHandler> CREATOR = new GetTokenLoginMethodHandler$Companion$CREATOR$1();
    public GetTokenClient getTokenClient;
    public final String nameForLogging = "get_token";

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public GetTokenLoginMethodHandler(LoginClient loginClient) {
        // Intrinsics.checkNotNullParameter(loginClient, "loginClient");
        super(loginClient);
    }

    /* renamed from: tryAuthorize$lambda-1  reason: not valid java name */
    public static final void m68tryAuthorize$lambda1(GetTokenLoginMethodHandler getTokenLoginMethodHandler, Request request, Bundle bundle) {
        Intrinsics.checkNotNullParameter(getTokenLoginMethodHandler, "this$0");
        Intrinsics.checkNotNullParameter(request, "$request");
        Intrinsics.checkNotNullParameter(request, "request");
        GetTokenClient getTokenClient2 = getTokenLoginMethodHandler.getTokenClient;
        if (getTokenClient2 != null) {
            getTokenClient2.listener = null;
        }
        getTokenLoginMethodHandler.getTokenClient = null;
        BackgroundProcessingListener backgroundProcessingListener = getTokenLoginMethodHandler.getLoginClient().backgroundProcessingListener;
        if (backgroundProcessingListener != null) {
            backgroundProcessingListener.onBackgroundProcessingStopped();
        }
        if (bundle != null) {
            List stringArrayList = bundle.getStringArrayList("com.facebook.platform.extra.PERMISSIONS");
            if (stringArrayList == null) {
                stringArrayList = EmptyList.INSTANCE;
            }
            Set<String> set = request.permissions;
            if (set == null) {
                set = EmptySet.INSTANCE;
            }
            String string = bundle.getString("com.facebook.platform.extra.ID_TOKEN");
            boolean z = false;
            if (set.contains("openid")) {
                if (string == null || string.length() == 0) {
                    getTokenLoginMethodHandler.getLoginClient().tryNextHandler();
                    return;
                }
            }
            if (stringArrayList.containsAll(set)) {
                Intrinsics.checkNotNullParameter(request, "request");
                Intrinsics.checkNotNullParameter(bundle, LoginReactModule.RESULT);
                String string2 = bundle.getString("com.facebook.platform.extra.USER_ID");
                if (string2 == null || string2.length() == 0) {
                    z = true;
                }
                if (z) {
                    BackgroundProcessingListener backgroundProcessingListener2 = getTokenLoginMethodHandler.getLoginClient().backgroundProcessingListener;
                    if (backgroundProcessingListener2 != null) {
                        backgroundProcessingListener2.onBackgroundProcessingStarted();
                    }
                    String string3 = bundle.getString("com.facebook.platform.extra.ACCESS_TOKEN");
                    if (string3 != null) {
                        Utility.getGraphMeRequestWithCacheAsync(string3, new GetTokenLoginMethodHandler$complete$1(bundle, getTokenLoginMethodHandler, request));
                        return;
                    }
                    throw new IllegalStateException("Required value was null.".toString());
                }
                getTokenLoginMethodHandler.onComplete(request, bundle);
                return;
            }
            HashSet hashSet = new HashSet();
            for (String str : set) {
                if (!stringArrayList.contains(str)) {
                    hashSet.add(str);
                }
            }
            if (!hashSet.isEmpty()) {
                getTokenLoginMethodHandler.addLoggingExtra("new_permissions", TextUtils.join(",", hashSet));
            }
            Intrinsics.checkNotNullParameter(hashSet, "<set-?>");
            request.permissions = hashSet;
        }
        getTokenLoginMethodHandler.getLoginClient().tryNextHandler();
    }

    public void cancel() {
        GetTokenClient getTokenClient2 = this.getTokenClient;
        if (getTokenClient2 != null) {
            getTokenClient2.running = false;
            getTokenClient2.listener = null;
            this.getTokenClient = null;
        }
    }

    public int describeContents() {
        return 0;
    }

    public String getNameForLogging() {
        return this.nameForLogging;
    }

    public final void onComplete(Request request, Bundle bundle) {
        Result result;
        AuthenticationToken authenticationToken;
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(bundle, LoginReactModule.RESULT);
        try {
            AccessToken createAccessTokenFromNativeLogin = LoginMethodHandler.createAccessTokenFromNativeLogin(bundle, AccessTokenSource.FACEBOOK_APPLICATION_SERVICE, request.applicationId);
            String str = request.nonce;
            Intrinsics.checkNotNullParameter(bundle, Constant.BUNDLE_DIR_NAME);
            String string = bundle.getString("com.facebook.platform.extra.ID_TOKEN");
            if (string != null) {
                boolean z = false;
                if (!(string.length() == 0) && str != null) {
                    if (str.length() == 0) {
                        z = true;
                    }
                    if (!z) {
                        authenticationToken = new AuthenticationToken(string, str);
                        result = new Result(request, Code.SUCCESS, createAccessTokenFromNativeLogin, authenticationToken, null, null);
                        getLoginClient().completeAndValidate(result);
                    }
                }
            }
            authenticationToken = null;
            result = new Result(request, Code.SUCCESS, createAccessTokenFromNativeLogin, authenticationToken, null, null);
        } catch (Exception e2) {
            throw new FacebookException(e2.getMessage());
        } catch (FacebookException e3) {
            Request request2 = getLoginClient().pendingRequest;
            String message = e3.getMessage();
            ArrayList arrayList = new ArrayList();
            if (message != null) {
                arrayList.add(message);
            }
            result = new Result(request2, Code.ERROR, null, TextUtils.join(": ", arrayList), null);
        }
        getLoginClient().completeAndValidate(result);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0049 A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x004c A[SYNTHETIC, Splitter:B:23:0x004c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int tryAuthorize(com.facebook.login.LoginClient.Request r9) {
        /*
            r8 = this;
            java.lang.String r0 = "request"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            com.facebook.login.GetTokenClient r0 = new com.facebook.login.GetTokenClient
            com.facebook.login.LoginClient r1 = r8.getLoginClient()
            androidx.fragment.app.FragmentActivity r1 = r1.getActivity()
            if (r1 != 0) goto L_0x0017
            com.facebook.FacebookSdk r1 = com.facebook.FacebookSdk.INSTANCE
            android.content.Context r1 = com.facebook.FacebookSdk.getApplicationContext()
        L_0x0017:
            r0.<init>(r1, r9)
            r8.getTokenClient = r0
            monitor-enter(r0)
            boolean r1 = r0.running     // Catch:{ all -> 0x0087 }
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0025
            monitor-exit(r0)
            goto L_0x004a
        L_0x0025:
            com.facebook.internal.NativeProtocol r1 = com.facebook.internal.NativeProtocol.INSTANCE     // Catch:{ all -> 0x0087 }
            int r1 = r0.protocolVersion     // Catch:{ all -> 0x0087 }
            java.lang.Class<com.facebook.internal.NativeProtocol> r4 = com.facebook.internal.NativeProtocol.class
            boolean r5 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r4)     // Catch:{ all -> 0x0087 }
            if (r5 == 0) goto L_0x0032
            goto L_0x0045
        L_0x0032:
            com.facebook.internal.NativeProtocol r5 = com.facebook.internal.NativeProtocol.INSTANCE     // Catch:{ all -> 0x0041 }
            java.util.List<com.facebook.internal.NativeProtocol$NativeAppInfo> r6 = com.facebook.internal.NativeProtocol.facebookAppInfoList     // Catch:{ all -> 0x0041 }
            int[] r7 = new int[r2]     // Catch:{ all -> 0x0041 }
            r7[r3] = r1     // Catch:{ all -> 0x0041 }
            com.facebook.internal.NativeProtocol$ProtocolVersionQueryResult r1 = r5.getLatestAvailableProtocolVersionForAppInfoList(r6, r7)     // Catch:{ all -> 0x0041 }
            int r1 = r1.protocolVersion     // Catch:{ all -> 0x0041 }
            goto L_0x0046
        L_0x0041:
            r1 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r1, r4)     // Catch:{ all -> 0x0087 }
        L_0x0045:
            r1 = 0
        L_0x0046:
            r4 = -1
            if (r1 != r4) goto L_0x004c
            monitor-exit(r0)
        L_0x004a:
            r1 = 0
            goto L_0x0061
        L_0x004c:
            com.facebook.internal.NativeProtocol r1 = com.facebook.internal.NativeProtocol.INSTANCE     // Catch:{ all -> 0x0087 }
            android.content.Context r1 = r0.context     // Catch:{ all -> 0x0087 }
            android.content.Intent r1 = com.facebook.internal.NativeProtocol.createPlatformServiceIntent(r1)     // Catch:{ all -> 0x0087 }
            if (r1 != 0) goto L_0x0058
            r1 = 0
            goto L_0x0060
        L_0x0058:
            r0.running = r2     // Catch:{ all -> 0x0087 }
            android.content.Context r4 = r0.context     // Catch:{ all -> 0x0087 }
            r4.bindService(r1, r0, r2)     // Catch:{ all -> 0x0087 }
            r1 = 1
        L_0x0060:
            monitor-exit(r0)
        L_0x0061:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r1)
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x006e
            return r3
        L_0x006e:
            com.facebook.login.LoginClient r0 = r8.getLoginClient()
            com.facebook.login.LoginClient$BackgroundProcessingListener r0 = r0.backgroundProcessingListener
            if (r0 != 0) goto L_0x0077
            goto L_0x007a
        L_0x0077:
            r0.onBackgroundProcessingStarted()
        L_0x007a:
            com.facebook.login.-$$Lambda$0nbY_VDDLzAm-aRymMcAzSLWtvA r0 = new com.facebook.login.-$$Lambda$0nbY_VDDLzAm-aRymMcAzSLWtvA
            r0.<init>(r9)
            com.facebook.login.GetTokenClient r9 = r8.getTokenClient
            if (r9 != 0) goto L_0x0084
            goto L_0x0086
        L_0x0084:
            r9.listener = r0
        L_0x0086:
            return r2
        L_0x0087:
            r9 = move-exception
            monitor-exit(r0)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.login.GetTokenLoginMethodHandler.tryAuthorize(com.facebook.login.LoginClient$Request):int");
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public GetTokenLoginMethodHandler(Parcel parcel) {
        // Intrinsics.checkNotNullParameter(parcel, DefaultSettingsSpiCall.SOURCE_PARAM);
        super(parcel);
    }
}
