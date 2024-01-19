package com.clevertap.android.sdk;

import android.content.Context;
import com.clevertap.android.sdk.inapp.InAppController;
import com.clevertap.android.sdk.login.LoginController;
import com.clevertap.android.sdk.pushnotification.PushProviders;

public class CoreState {
    public ActivityLifeCycleManager activityLifeCycleManager;
    public AnalyticsManager analyticsManager;
    public LocationManager baseLocationManager;
    public BaseCallbackManager callbackManager;
    public CleverTapInstanceConfig config;
    public final Context context;
    public ControllerManager controllerManager;
    public CoreMetaData coreMetaData;
    public CTLockManager ctLockManager;
    public DeviceInfo deviceInfo;
    public InAppController inAppController;
    public LocalDataStore localDataStore;
    public LoginController loginController;
    public PushProviders pushProviders;
    public SessionManager sessionManager;

    public CoreState(Context context2) {
        this.context = context2;
    }
}
