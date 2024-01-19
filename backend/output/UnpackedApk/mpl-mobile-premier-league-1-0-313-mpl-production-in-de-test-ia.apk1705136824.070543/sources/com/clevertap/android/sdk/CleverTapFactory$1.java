package com.clevertap.android.sdk;

import android.content.Context;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.concurrent.Callable;

public class CleverTapFactory$1 implements Callable<Void> {
    public final /* synthetic */ CleverTapInstanceConfig val$config;
    public final /* synthetic */ Context val$context;
    public final /* synthetic */ ControllerManager val$controllerManager;
    public final /* synthetic */ CoreState val$coreState;

    public CleverTapFactory$1(CoreState coreState, ControllerManager controllerManager, CleverTapInstanceConfig cleverTapInstanceConfig, Context context) {
        this.val$coreState = coreState;
        this.val$controllerManager = controllerManager;
        this.val$config = cleverTapInstanceConfig;
        this.val$context = context;
    }

    public Object call() throws Exception {
        DeviceInfo deviceInfo = this.val$coreState.deviceInfo;
        if (!(deviceInfo == null || deviceInfo.getDeviceID() == null || this.val$controllerManager.inAppFCManager != null)) {
            Logger logger = this.val$coreState.config.getLogger();
            String outline62 = GeneratedOutlineSupport.outline62(new StringBuilder(), this.val$config.accountId, ":async_deviceID");
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Initializing InAppFC with device Id = ");
            outline73.append(this.val$coreState.deviceInfo.getDeviceID());
            logger.verbose(outline62, outline73.toString());
            this.val$controllerManager.inAppFCManager = new InAppFCManager(this.val$context, this.val$config, this.val$coreState.deviceInfo.getDeviceID());
        }
        return null;
    }
}
