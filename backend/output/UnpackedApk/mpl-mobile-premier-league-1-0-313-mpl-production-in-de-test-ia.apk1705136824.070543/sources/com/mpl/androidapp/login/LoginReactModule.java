package com.mpl.androidapp.login;

import android.content.Context;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.utils.MSharedPreferencesUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0003J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0003J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0003R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/mpl/androidapp/login/LoginReactModule;", "Lcom/facebook/react/bridge/ReactContextBaseJavaModule;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "context", "Landroid/content/Context;", "promise", "Lcom/facebook/react/bridge/Promise;", "fetchLoginInfo", "", "getAccessUserToken", "getName", "", "login", "Companion", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@ReactModule(name = "LoginReactModule")
/* compiled from: LoginReactModule.kt */
public final class LoginReactModule extends ReactContextBaseJavaModule {
    public static final String CODE = "code";
    public static final Companion Companion = new Companion(null);
    public static final String LOGIN_FAILED = "Login failed";
    public static final String MESSAGE = "message";
    public static final String PAYLOAD = "payload";
    public static final String RESULT = "result";
    public static final String STATUS = "status";
    public static final String SUCCESS = "success";
    public static final String TAG = "LoginReactModule";
    public Context context;
    public Promise promise;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/mpl/androidapp/login/LoginReactModule$Companion;", "", "()V", "CODE", "", "LOGIN_FAILED", "MESSAGE", "PAYLOAD", "RESULT", "STATUS", "SUCCESS", "TAG", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LoginReactModule.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public LoginReactModule(ReactApplicationContext reactApplicationContext) {
        // Intrinsics.checkNotNullParameter(reactApplicationContext, "reactContext");
        super(reactApplicationContext);
        this.context = reactApplicationContext.getApplicationContext();
    }

    @ReactMethod
    private final void fetchLoginInfo(Promise promise2) {
        MLogger.d(TAG, "fetchLoginInfo called");
        promise2.reject((String) LOGIN_FAILED);
    }

    @ReactMethod
    private final void getAccessUserToken(Promise promise2) {
        promise2.resolve(MSharedPreferencesUtils.getAccessUserToken());
    }

    @ReactMethod
    private final void login(Promise promise2) {
        MLogger.d(TAG, "login called");
        this.promise = promise2;
        promise2.reject((String) "1007", (String) "");
    }

    public String getName() {
        return TAG;
    }
}
