package com.facebook.login;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.fragment.app.FragmentActivity;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.internal.FacebookDialogFragment;
import com.facebook.internal.Utility;
import com.facebook.internal.WebDialog;
import com.facebook.internal.WebDialog.Builder;
import com.facebook.internal.WebDialog.Companion;
import com.facebook.internal.WebDialog.OnCompleteListener;
import com.facebook.login.LoginClient.Request;
import com.google.firebase.crashlytics.internal.analytics.BreadcrumbAnalyticsEventReceiver;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import com.razorpay.AnalyticsConstants;
import in.juspay.hypersdk.core.PaymentConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.pdfbox.pdfparser.BaseParser;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u0000 ,2\u00020\u0001:\u0002+,B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\"\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&J\u0010\u0010'\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"H\u0016J\u0018\u0010(\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u001dH\u0016R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\tXD¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000bR\u0014\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006-"}, d2 = {"Lcom/facebook/login/WebViewLoginMethodHandler;", "Lcom/facebook/login/WebLoginMethodHandler;", "loginClient", "Lcom/facebook/login/LoginClient;", "(Lcom/facebook/login/LoginClient;)V", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "e2e", "", "getE2e", "()Ljava/lang/String;", "setE2e", "(Ljava/lang/String;)V", "loginDialog", "Lcom/facebook/internal/WebDialog;", "getLoginDialog", "()Lcom/facebook/internal/WebDialog;", "setLoginDialog", "(Lcom/facebook/internal/WebDialog;)V", "nameForLogging", "getNameForLogging", "tokenSource", "Lcom/facebook/AccessTokenSource;", "getTokenSource", "()Lcom/facebook/AccessTokenSource;", "cancel", "", "describeContents", "", "needsInternetPermission", "", "onWebDialogComplete", "request", "Lcom/facebook/login/LoginClient$Request;", "values", "Landroid/os/Bundle;", "error", "Lcom/facebook/FacebookException;", "tryAuthorize", "writeToParcel", "dest", "flags", "AuthDialogBuilder", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: WebViewLoginMethodHandler.kt */
public class WebViewLoginMethodHandler extends WebLoginMethodHandler {
    public static final Creator<WebViewLoginMethodHandler> CREATOR = new WebViewLoginMethodHandler$Companion$CREATOR$1();
    public String e2e;
    public WebDialog loginDialog;
    public final String nameForLogging = "web_view";
    public final AccessTokenSource tokenSource = AccessTokenSource.WEB_VIEW;

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0004\u0018\u00002\u00020\u0001B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0012\u0010\f\u001a\u00060\u0000R\u00020\u001b2\u0006\u0010\t\u001a\u00020\u0005J\u0012\u0010\u001c\u001a\u00060\u0000R\u00020\u001b2\u0006\u0010\u000e\u001a\u00020\u0005J\u0012\u0010\u001d\u001a\u00060\u0000R\u00020\u001b2\u0006\u0010\u0011\u001a\u00020\u0012J\u0012\u0010\u001e\u001a\u00060\u0000R\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u0012J\u0012\u0010 \u001a\u00060\u0000R\u00020\u001b2\u0006\u0010!\u001a\u00020\u0012J\u0012\u0010\"\u001a\u00060\u0000R\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\u0014J\u0012\u0010#\u001a\u00060\u0000R\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\u0018J\u0012\u0010$\u001a\u00060\u0000R\u00020\u001b2\u0006\u0010%\u001a\u00020\u0012R\u001a\u0010\t\u001a\u00020\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/facebook/login/WebViewLoginMethodHandler$AuthDialogBuilder;", "Lcom/facebook/internal/WebDialog$Builder;", "context", "Landroid/content/Context;", "applicationId", "", "parameters", "Landroid/os/Bundle;", "(Lcom/facebook/login/WebViewLoginMethodHandler;Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;)V", "authType", "getAuthType", "()Ljava/lang/String;", "setAuthType", "(Ljava/lang/String;)V", "e2e", "getE2e", "setE2e", "isFamilyLogin", "", "loginBehavior", "Lcom/facebook/login/LoginBehavior;", "redirect_uri", "shouldSkipDedupe", "targetApp", "Lcom/facebook/login/LoginTargetApp;", "build", "Lcom/facebook/internal/WebDialog;", "Lcom/facebook/login/WebViewLoginMethodHandler;", "setE2E", "setFamilyLogin", "setIsChromeOS", "isChromeOS", "setIsRerequest", "isRerequest", "setLoginBehavior", "setLoginTargetApp", "setShouldSkipDedupe", "shouldSkip", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: WebViewLoginMethodHandler.kt */
    public final class AuthDialogBuilder extends Builder {
        public String authType;
        public String e2e;
        public boolean isFamilyLogin;
        public LoginBehavior loginBehavior = LoginBehavior.NATIVE_WITH_FALLBACK;
        public String redirect_uri = "fbconnect://success";
        public boolean shouldSkipDedupe;
        public LoginTargetApp targetApp = LoginTargetApp.FACEBOOK;
        public final /* synthetic */ WebViewLoginMethodHandler this$0;

        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        public AuthDialogBuilder(WebViewLoginMethodHandler webViewLoginMethodHandler, Context context, String str, Bundle bundle) {
            // Intrinsics.checkNotNullParameter(webViewLoginMethodHandler, "this$0");
            // Intrinsics.checkNotNullParameter(context, "context");
            // Intrinsics.checkNotNullParameter(str, "applicationId");
            // Intrinsics.checkNotNullParameter(bundle, BreadcrumbAnalyticsEventReceiver.BREADCRUMB_PARAMS_KEY);
            // this.this$0 = webViewLoginMethodHandler;
            super(context, str, "oauth", bundle);
        }

        public WebDialog build() {
            Bundle bundle = this.parameters;
            if (bundle != null) {
                bundle.putString("redirect_uri", this.redirect_uri);
                bundle.putString(PaymentConstants.CLIENT_ID, this.applicationId);
                String str = this.e2e;
                if (str != null) {
                    bundle.putString("e2e", str);
                    bundle.putString("response_type", this.targetApp == LoginTargetApp.INSTAGRAM ? "token,signed_request,graph_domain,granted_scopes" : "token,signed_request,graph_domain");
                    bundle.putString("return_scopes", BaseParser.TRUE);
                    String str2 = this.authType;
                    if (str2 != null) {
                        bundle.putString("auth_type", str2);
                        bundle.putString("login_behavior", this.loginBehavior.name());
                        if (this.isFamilyLogin) {
                            bundle.putString("fx_app", this.targetApp.toString());
                        }
                        if (this.shouldSkipDedupe) {
                            bundle.putString("skip_dedupe", BaseParser.TRUE);
                        }
                        Companion companion = WebDialog.Companion;
                        Context context = this.context;
                        if (context != null) {
                            LoginTargetApp loginTargetApp = this.targetApp;
                            OnCompleteListener onCompleteListener = this.listener;
                            Intrinsics.checkNotNullParameter(context, "context");
                            Intrinsics.checkNotNullParameter(loginTargetApp, "targetApp");
                            WebDialog.initDefaultTheme(context);
                            WebDialog webDialog = new WebDialog(context, "oauth", bundle, 0, loginTargetApp, onCompleteListener, null);
                            return webDialog;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type android.content.Context");
                    }
                    Intrinsics.throwUninitializedPropertyAccessException("authType");
                    throw null;
                }
                Intrinsics.throwUninitializedPropertyAccessException("e2e");
                throw null;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.os.Bundle");
        }
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public WebViewLoginMethodHandler(LoginClient loginClient) {
        // Intrinsics.checkNotNullParameter(loginClient, "loginClient");
        super(loginClient);
    }

    public void cancel() {
        WebDialog webDialog = this.loginDialog;
        if (webDialog != null) {
            if (webDialog != null) {
                webDialog.cancel();
            }
            this.loginDialog = null;
        }
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

    public boolean needsInternetPermission() {
        return true;
    }

    public final void onWebDialogComplete(Request request, Bundle bundle, FacebookException facebookException) {
        Intrinsics.checkNotNullParameter(request, "request");
        super.onComplete(request, bundle, facebookException);
    }

    public int tryAuthorize(Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        Bundle parameters = getParameters(request);
        WebViewLoginMethodHandler$tryAuthorize$listener$1 webViewLoginMethodHandler$tryAuthorize$listener$1 = new WebViewLoginMethodHandler$tryAuthorize$listener$1(this, request);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(AnalyticsConstants.INIT, System.currentTimeMillis());
        } catch (JSONException unused) {
        }
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "e2e.toString()");
        this.e2e = jSONObject2;
        addLoggingExtra("e2e", jSONObject2);
        FragmentActivity activity = getLoginClient().getActivity();
        if (activity == null) {
            return 0;
        }
        boolean isChromeOS = Utility.isChromeOS(activity);
        AuthDialogBuilder authDialogBuilder = new AuthDialogBuilder(this, activity, request.applicationId, parameters);
        String str = this.e2e;
        if (str != null) {
            Intrinsics.checkNotNullParameter(str, "e2e");
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            authDialogBuilder.e2e = str;
            authDialogBuilder.redirect_uri = isChromeOS ? "fbconnect://chrome_os_success" : "fbconnect://success";
            String str2 = request.authType;
            Intrinsics.checkNotNullParameter(str2, "authType");
            Intrinsics.checkNotNullParameter(str2, "<set-?>");
            authDialogBuilder.authType = str2;
            LoginBehavior loginBehavior = request.loginBehavior;
            Intrinsics.checkNotNullParameter(loginBehavior, "loginBehavior");
            authDialogBuilder.loginBehavior = loginBehavior;
            LoginTargetApp loginTargetApp = request.loginTargetApp;
            Intrinsics.checkNotNullParameter(loginTargetApp, "targetApp");
            authDialogBuilder.targetApp = loginTargetApp;
            authDialogBuilder.isFamilyLogin = request.isFamilyLogin;
            authDialogBuilder.shouldSkipDedupe = request.shouldSkipAccountDeduplication;
            authDialogBuilder.listener = webViewLoginMethodHandler$tryAuthorize$listener$1;
            this.loginDialog = authDialogBuilder.build();
            FacebookDialogFragment facebookDialogFragment = new FacebookDialogFragment();
            facebookDialogFragment.setRetainInstance(true);
            facebookDialogFragment.innerDialog = this.loginDialog;
            facebookDialogFragment.show(activity.getSupportFragmentManager(), (String) "FacebookDialogFragment");
            return 1;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        super.writeToParcel(parcel, i);
        parcel.writeString(this.e2e);
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public WebViewLoginMethodHandler(Parcel parcel) {
        // Intrinsics.checkNotNullParameter(parcel, DefaultSettingsSpiCall.SOURCE_PARAM);
        super(parcel);
        this.e2e = parcel.readString();
    }
}
