package com.mpl.androidapp.react.modules;

import android.app.Activity;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.google.firebase.crashlytics.CrashlyticsAnalyticsListener;
import com.mpl.androidapp.utils.Constant;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.webview.view.activities.WebViewGameActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\nB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0007¨\u0006\u000b"}, d2 = {"Lcom/mpl/androidapp/react/modules/GameLaunchModule;", "Lcom/facebook/react/bridge/ReactContextBaseJavaModule;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "getName", "", "launchWebGame", "", "params", "Companion", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@ReactModule(name = "GameLaunchModule")
/* compiled from: GameLaunchModule.kt */
public final class GameLaunchModule extends ReactContextBaseJavaModule {
    public static final Companion Companion = new Companion(null);

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/mpl/androidapp/react/modules/GameLaunchModule$Companion;", "", "()V", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GameLaunchModule.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public GameLaunchModule(ReactApplicationContext reactApplicationContext) {
        // Intrinsics.checkNotNullParameter(reactApplicationContext, "reactContext");
        super(reactApplicationContext);
    }

    public String getName() {
        return GameLaunchModuleKt.GAME_LAUNCH_MODULE_TAG;
    }

    @ReactMethod
    public final void launchWebGame(String str) {
        Intrinsics.checkNotNullParameter(str, CrashlyticsAnalyticsListener.EVENT_PARAMS_KEY);
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            MLogger.d(GameLaunchModuleKt.GAME_LAUNCH_MODULE_TAG, Intrinsics.stringPlus("Params received from react : ", str));
            currentActivity.startActivityForResult(WebViewGameActivity.Companion.getLaunchingIntent(currentActivity, str), Constant.REQUEST_CODE_WEB_GAME);
        }
    }
}
