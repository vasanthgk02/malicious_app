package com.mpl.androidapp.react.modules;

import android.content.Intent;
import android.net.Uri;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.mpl.androidapp.cleverTap.AssetsAnalytics;
import com.mpl.androidapp.other.appusage.AppUsageWorkRequest;
import com.mpl.androidapp.other.appusage.UserStats;
import com.mpl.androidapp.utils.CleverTapAnalyticsUtils;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.utils.MSharedPreferencesUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\b\u0010\r\u001a\u00020\nH\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/mpl/androidapp/react/modules/SpecialPermissionsModule;", "Lcom/facebook/react/bridge/ReactContextBaseJavaModule;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "getReactContext", "()Lcom/facebook/react/bridge/ReactApplicationContext;", "getName", "", "isPermissionGranted", "", "promise", "Lcom/facebook/react/bridge/Promise;", "requestPermission", "Companion", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@ReactModule(name = "SpecialPermissionsModule")
/* compiled from: SpecialPermissionsModule.kt */
public final class SpecialPermissionsModule extends ReactContextBaseJavaModule {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "SpecialPermissionsModule";
    public final ReactApplicationContext reactContext;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/mpl/androidapp/react/modules/SpecialPermissionsModule$Companion;", "", "()V", "TAG", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SpecialPermissionsModule.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public SpecialPermissionsModule(ReactApplicationContext reactApplicationContext) {
        // Intrinsics.checkNotNullParameter(reactApplicationContext, "reactContext");
        super(reactApplicationContext);
        this.reactContext = reactApplicationContext;
    }

    public String getName() {
        return TAG;
    }

    public final ReactApplicationContext getReactContext() {
        return this.reactContext;
    }

    @ReactMethod
    public final void isPermissionGranted(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        if (UserStats.isPermissionGranted(this.reactContext)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("User ID", MSharedPreferencesUtils.getUserIdInNormalPref(this.reactContext));
                CleverTapAnalyticsUtils.sendEvent((String) AssetsAnalytics.EVENT_GUERRILLA_PERMISSION_GRANTED, jSONObject.toString());
            } catch (JSONException e2) {
                MLogger.e("usageStats", e2.getMessage());
            } catch (Exception e3) {
                MLogger.e("usageStats", e3.getMessage());
            }
            if (!MSharedPreferencesUtils.isDailyAppUsageWorkerEnabled(this.reactContext).booleanValue()) {
                AppUsageWorkRequest.INSTANCE.scheduleAppUsageDataForServer(this.reactContext);
                MSharedPreferencesUtils.setDailyAppUsageWorkerEnabled(this.reactContext, Boolean.TRUE);
            }
            promise.resolve(Boolean.TRUE);
            return;
        }
        promise.resolve(Boolean.FALSE);
    }

    @ReactMethod
    public final void requestPermission() {
        try {
            Intent intent = new Intent("android.settings.USAGE_ACCESS_SETTINGS");
            intent.addFlags(ClientDefaults.MAX_MSG_SIZE);
            intent.setData(Uri.fromParts("package", this.reactContext.getPackageName(), null));
            if (intent.resolveActivity(this.reactContext.getPackageManager()) != null) {
                this.reactContext.startActivity(intent);
                return;
            }
            Intent intent2 = new Intent("android.settings.SETTINGS");
            intent2.addFlags(ClientDefaults.MAX_MSG_SIZE);
            this.reactContext.startActivity(intent2);
        } catch (Exception unused) {
        }
    }
}
