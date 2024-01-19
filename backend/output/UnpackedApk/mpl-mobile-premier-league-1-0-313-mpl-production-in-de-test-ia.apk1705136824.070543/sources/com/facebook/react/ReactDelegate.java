package com.facebook.react;

import android.app.Activity;
import android.os.Bundle;
import com.facebook.react.devsupport.DoubleTapReloadRecognizer;

public class ReactDelegate {
    public final Activity mActivity;
    public DoubleTapReloadRecognizer mDoubleTapReloadRecognizer = new DoubleTapReloadRecognizer();
    public Bundle mLaunchOptions;
    public ReactNativeHost mReactNativeHost = null;
    public ReactRootView mReactRootView;

    public ReactDelegate(Activity activity, String str, Bundle bundle) {
        this.mActivity = activity;
        this.mLaunchOptions = bundle;
    }

    public abstract ReactRootView createRootView();
}
