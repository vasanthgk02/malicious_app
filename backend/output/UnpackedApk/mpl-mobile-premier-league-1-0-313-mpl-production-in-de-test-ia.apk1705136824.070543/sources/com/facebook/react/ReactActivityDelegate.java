package com.facebook.react;

import android.app.Activity;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.react.bridge.Callback;
import com.facebook.react.modules.core.PermissionListener;

public class ReactActivityDelegate {
    public final Activity mActivity;
    public final String mMainComponentName;
    public PermissionListener mPermissionListener;
    public Callback mPermissionsCallback;
    public ReactDelegate mReactDelegate;

    public ReactActivityDelegate(ReactActivity reactActivity, String str) {
        this.mActivity = reactActivity;
        this.mMainComponentName = str;
    }

    public void getReactNativeHost() {
        Activity activity = this.mActivity;
        ImageOriginUtils.assertNotNull(activity);
        ((ReactApplication) activity.getApplication()).getReactNativeHost();
    }
}
