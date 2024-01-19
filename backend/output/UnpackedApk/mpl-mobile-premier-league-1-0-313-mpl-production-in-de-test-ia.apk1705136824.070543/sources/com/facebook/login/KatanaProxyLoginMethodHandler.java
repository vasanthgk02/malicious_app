package com.facebook.login;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.FacebookSdk;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.internal.CustomTabUtils;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.NativeProtocol.NativeAppInfo;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.login.LoginClient.Request;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import com.razorpay.AnalyticsConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0014\u0010\b\u001a\u00020\tXD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/facebook/login/KatanaProxyLoginMethodHandler;", "Lcom/facebook/login/NativeAppLoginMethodHandler;", "loginClient", "Lcom/facebook/login/LoginClient;", "(Lcom/facebook/login/LoginClient;)V", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "nameForLogging", "", "getNameForLogging", "()Ljava/lang/String;", "describeContents", "", "shouldKeepTrackOfMultipleIntents", "", "tryAuthorize", "request", "Lcom/facebook/login/LoginClient$Request;", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: KatanaProxyLoginMethodHandler.kt */
public final class KatanaProxyLoginMethodHandler extends NativeAppLoginMethodHandler {
    public static final Creator<KatanaProxyLoginMethodHandler> CREATOR = new KatanaProxyLoginMethodHandler$Companion$CREATOR$1();
    public final String nameForLogging = "katana_proxy_auth";

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public KatanaProxyLoginMethodHandler(LoginClient loginClient) {
        // Intrinsics.checkNotNullParameter(loginClient, "loginClient");
        super(loginClient);
    }

    public int describeContents() {
        return 0;
    }

    public String getNameForLogging() {
        return this.nameForLogging;
    }

    public boolean shouldKeepTrackOfMultipleIntents() {
        return true;
    }

    public int tryAuthorize(Request request) {
        Request request2 = request;
        Intrinsics.checkNotNullParameter(request2, "request");
        boolean z = FacebookSdk.ignoreAppSwitchToLoggedOut && CustomTabUtils.getChromePackage() != null && request2.loginBehavior.allowsCustomTabAuth();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(AnalyticsConstants.INIT, System.currentTimeMillis());
        } catch (JSONException unused) {
        }
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "e2e.toString()");
        NativeProtocol nativeProtocol = NativeProtocol.INSTANCE;
        getLoginClient().getActivity();
        String str = request2.applicationId;
        Set<String> set = request2.permissions;
        boolean hasPublishPermission = request.hasPublishPermission();
        DefaultAudience defaultAudience = request2.defaultAudience;
        if (defaultAudience == null) {
            defaultAudience = DefaultAudience.NONE;
        }
        DefaultAudience defaultAudience2 = defaultAudience;
        String clientState = getClientState(request2.authId);
        String str2 = request2.authType;
        String str3 = request2.messengerPageId;
        boolean z2 = request2.resetMessengerState;
        boolean z3 = request2.isFamilyLogin;
        boolean z4 = request2.shouldSkipAccountDeduplication;
        String str4 = request2.nonce;
        CodeChallengeMethod codeChallengeMethod = request2.codeChallengeMethod;
        if (codeChallengeMethod != null) {
            codeChallengeMethod.name();
        }
        Class<NativeProtocol> cls = NativeProtocol.class;
        ArrayList<Intent> arrayList = null;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(str, "applicationId");
                Intrinsics.checkNotNullParameter(set, "permissions");
                Intrinsics.checkNotNullParameter(jSONObject2, "e2e");
                Intrinsics.checkNotNullParameter(defaultAudience2, "defaultAudience");
                Intrinsics.checkNotNullParameter(clientState, "clientState");
                Intrinsics.checkNotNullParameter(str2, "authType");
                List<NativeAppInfo> list = NativeProtocol.facebookAppInfoList;
                ArrayList arrayList2 = new ArrayList();
                for (NativeAppInfo createNativeAppIntent : list) {
                    String str5 = str4;
                    boolean z5 = z4;
                    boolean z6 = z3;
                    boolean z7 = z2;
                    String str6 = str3;
                    String str7 = str2;
                    String str8 = clientState;
                    DefaultAudience defaultAudience3 = defaultAudience2;
                    Set<String> set2 = set;
                    String str9 = str;
                    Intent createNativeAppIntent2 = NativeProtocol.INSTANCE.createNativeAppIntent(createNativeAppIntent, str, set, jSONObject2, hasPublishPermission, defaultAudience2, str8, str7, z, str6, z7, LoginTargetApp.FACEBOOK, z6, z5, str5);
                    if (createNativeAppIntent2 != null) {
                        arrayList2.add(createNativeAppIntent2);
                    }
                    str4 = str5;
                    z4 = z5;
                    z3 = z6;
                    z2 = z7;
                    str3 = str6;
                    str2 = str7;
                    clientState = str8;
                    defaultAudience2 = defaultAudience3;
                    set = set2;
                    str = str9;
                }
                arrayList = arrayList2;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
        addLoggingExtra("e2e", jSONObject2);
        int i = 0;
        for (Intent tryIntent : arrayList) {
            i++;
            RequestCodeOffset.Login.toRequestCode();
            if (tryIntent(tryIntent)) {
                return i;
            }
        }
        return 0;
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public KatanaProxyLoginMethodHandler(Parcel parcel) {
        // Intrinsics.checkNotNullParameter(parcel, DefaultSettingsSpiCall.SOURCE_PARAM);
        super(parcel);
    }
}
