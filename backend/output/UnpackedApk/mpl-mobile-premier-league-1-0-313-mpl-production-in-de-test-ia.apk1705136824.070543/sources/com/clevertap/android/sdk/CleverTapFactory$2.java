package com.clevertap.android.sdk;

import android.content.Context;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.clevertap.android.sdk.featureFlags.CTFeatureFlagsController;
import com.clevertap.android.sdk.utils.FileUtils;
import java.util.concurrent.Callable;

public class CleverTapFactory$2 implements Callable<Void> {
    public final /* synthetic */ AnalyticsManager val$analyticsManager;
    public final /* synthetic */ BaseCallbackManager val$callbackManager;
    public final /* synthetic */ CleverTapInstanceConfig val$config;
    public final /* synthetic */ Context val$context;
    public final /* synthetic */ ControllerManager val$controllerManager;
    public final /* synthetic */ DeviceInfo val$deviceInfo;

    public CleverTapFactory$2(Context context, ControllerManager controllerManager, CleverTapInstanceConfig cleverTapInstanceConfig, DeviceInfo deviceInfo, BaseCallbackManager baseCallbackManager, AnalyticsManager analyticsManager) {
        this.val$context = context;
        this.val$controllerManager = controllerManager;
        this.val$config = cleverTapInstanceConfig;
        this.val$deviceInfo = deviceInfo;
        this.val$callbackManager = baseCallbackManager;
        this.val$analyticsManager = analyticsManager;
    }

    public Object call() throws Exception {
        Context context = this.val$context;
        ControllerManager controllerManager = this.val$controllerManager;
        CleverTapInstanceConfig cleverTapInstanceConfig = this.val$config;
        DeviceInfo deviceInfo = this.val$deviceInfo;
        BaseCallbackManager baseCallbackManager = this.val$callbackManager;
        AnalyticsManager analyticsManager = this.val$analyticsManager;
        Logger logger = cleverTapInstanceConfig.getLogger();
        String outline62 = GeneratedOutlineSupport.outline62(new StringBuilder(), cleverTapInstanceConfig.accountId, ":async_deviceID");
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Initializing Feature Flags with device Id = ");
        outline73.append(deviceInfo.getDeviceID());
        logger.verbose(outline62, outline73.toString());
        if (cleverTapInstanceConfig.analyticsOnly) {
            cleverTapInstanceConfig.getLogger().debug(cleverTapInstanceConfig.accountId, "Feature Flag is not enabled for this instance");
        } else {
            CTFeatureFlagsController cTFeatureFlagsController = new CTFeatureFlagsController(deviceInfo.getDeviceID(), cleverTapInstanceConfig, baseCallbackManager, analyticsManager, new FileUtils(context, cleverTapInstanceConfig));
            controllerManager.ctFeatureFlagsController = cTFeatureFlagsController;
            GeneratedOutlineSupport.outline101(new StringBuilder(), cleverTapInstanceConfig.accountId, ":async_deviceID", cleverTapInstanceConfig.getLogger(), "Feature Flags initialized");
        }
        return null;
    }
}
