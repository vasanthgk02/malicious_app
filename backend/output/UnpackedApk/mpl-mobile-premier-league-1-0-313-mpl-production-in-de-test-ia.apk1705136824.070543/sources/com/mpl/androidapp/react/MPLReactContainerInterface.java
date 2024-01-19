package com.mpl.androidapp.react;

import com.facebook.react.ReactInstanceManager.ReactInstanceEventListener;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.modules.core.PermissionAwareActivity;
import com.facebook.react.modules.core.PermissionListener;
import com.mpl.analytics.MPLCTInAppNotificationButtonListener;
import com.mpl.androidapp.react.modules.SharedPrefModule.onSharePrefInteraction;
import com.mpl.androidapp.updater.repo.DownloadProgressReceiver.Receiver;
import java.util.HashMap;

public interface MPLReactContainerInterface extends DefaultHardwareBackBtnHandler, ReactInstanceEventListener, PermissionAwareActivity, Receiver, RNListener, MqttListener, onSharePrefInteraction, MPLCTInAppNotificationButtonListener {
    /* synthetic */ int checkPermission(String str, int i, int i2);

    /* synthetic */ int checkSelfPermission(String str);

    /* synthetic */ void invokeDefaultOnBackPressed();

    /* synthetic */ void onInAppButtonClick(HashMap<String, String> hashMap);

    /* synthetic */ void onReactContextInitialized(ReactContext reactContext);

    /* synthetic */ void requestPermissions(String[] strArr, int i, PermissionListener permissionListener);

    /* synthetic */ boolean shouldShowRequestPermissionRationale(String str);
}
