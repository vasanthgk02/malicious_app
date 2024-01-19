package com.facebook.login;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookSdk;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.NativeProtocol.InstagramAppInfo;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.login.LoginClient.Request;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import com.razorpay.AnalyticsConstants;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0011H\u0016R\u0014\u0010\b\u001a\u00020\tXD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/facebook/login/InstagramAppLoginMethodHandler;", "Lcom/facebook/login/NativeAppLoginMethodHandler;", "loginClient", "Lcom/facebook/login/LoginClient;", "(Lcom/facebook/login/LoginClient;)V", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "nameForLogging", "", "getNameForLogging", "()Ljava/lang/String;", "tokenSource", "Lcom/facebook/AccessTokenSource;", "getTokenSource", "()Lcom/facebook/AccessTokenSource;", "describeContents", "", "tryAuthorize", "request", "Lcom/facebook/login/LoginClient$Request;", "writeToParcel", "", "dest", "flags", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: InstagramAppLoginMethodHandler.kt */
public final class InstagramAppLoginMethodHandler extends NativeAppLoginMethodHandler {
    public static final Creator<InstagramAppLoginMethodHandler> CREATOR = new InstagramAppLoginMethodHandler$Companion$CREATOR$1();
    public final String nameForLogging = "instagram_login";
    public final AccessTokenSource tokenSource = AccessTokenSource.INSTAGRAM_APPLICATION_WEB;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public InstagramAppLoginMethodHandler(LoginClient loginClient) {
        // Intrinsics.checkNotNullParameter(loginClient, "loginClient");
        super(loginClient);
    }

    public int describeContents() {
        return 0;
    }

    public String getNameForLogging() {
        return this.nameForLogging;
    }

    public AccessTokenSource getTokenSource() {
        return this.tokenSource;
    }

    public int tryAuthorize(Request request) {
        String str;
        Class<NativeProtocol> cls;
        Request request2 = request;
        Intrinsics.checkNotNullParameter(request2, "request");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(AnalyticsConstants.INIT, System.currentTimeMillis());
        } catch (JSONException unused) {
        }
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "e2e.toString()");
        NativeProtocol nativeProtocol = NativeProtocol.INSTANCE;
        Context activity = getLoginClient().getActivity();
        if (activity == null) {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            activity = FacebookSdk.getApplicationContext();
        }
        String str2 = request2.applicationId;
        Set<String> set = request2.permissions;
        boolean hasPublishPermission = request.hasPublishPermission();
        DefaultAudience defaultAudience = request2.defaultAudience;
        if (defaultAudience == null) {
            defaultAudience = DefaultAudience.NONE;
        }
        DefaultAudience defaultAudience2 = defaultAudience;
        String clientState = getClientState(request2.authId);
        String str3 = request2.authType;
        String str4 = request2.messengerPageId;
        boolean z = request2.resetMessengerState;
        boolean z2 = request2.isFamilyLogin;
        boolean z3 = request2.shouldSkipAccountDeduplication;
        Class<NativeProtocol> cls2 = NativeProtocol.class;
        Intent intent = null;
        if (CrashShieldHandler.isObjectCrashing(cls2)) {
            str = "e2e";
        } else {
            try {
                Intrinsics.checkNotNullParameter(activity, "context");
                Intrinsics.checkNotNullParameter(str2, "applicationId");
                Intrinsics.checkNotNullParameter(set, "permissions");
                Intrinsics.checkNotNullParameter(jSONObject2, "e2e");
                Intrinsics.checkNotNullParameter(defaultAudience2, "defaultAudience");
                Intrinsics.checkNotNullParameter(clientState, "clientState");
                Intrinsics.checkNotNullParameter(str3, "authType");
                str = "e2e";
                cls = cls2;
                try {
                    intent = NativeProtocol.validateActivityIntent(activity, NativeProtocol.INSTANCE.createNativeAppIntent(new InstagramAppInfo(), str2, set, jSONObject2, hasPublishPermission, defaultAudience2, clientState, str3, false, str4, z, LoginTargetApp.INSTAGRAM, z2, z3, ""));
                } catch (Throwable th) {
                    th = th;
                    CrashShieldHandler.handleThrowable(th, cls);
                    addLoggingExtra(str, jSONObject2);
                    RequestCodeOffset.Login.toRequestCode();
                    return tryIntent(intent) ? 1 : 0;
                }
            } catch (Throwable th2) {
                th = th2;
                str = "e2e";
                cls = cls2;
                CrashShieldHandler.handleThrowable(th, cls);
                addLoggingExtra(str, jSONObject2);
                RequestCodeOffset.Login.toRequestCode();
                return tryIntent(intent) ? 1 : 0;
            }
        }
        addLoggingExtra(str, jSONObject2);
        RequestCodeOffset.Login.toRequestCode();
        return tryIntent(intent) ? 1 : 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        super.writeToParcel(parcel, i);
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public InstagramAppLoginMethodHandler(Parcel parcel) {
        // Intrinsics.checkNotNullParameter(parcel, DefaultSettingsSpiCall.SOURCE_PARAM);
        super(parcel);
    }
}
