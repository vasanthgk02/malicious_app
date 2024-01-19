package com.facebook.reactnative.androidsdk;

import android.app.Activity;
import android.content.Intent;
import com.facebook.CallbackManager;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.react.bridge.BaseActivityEventListener;

public class FBActivityEventListener extends BaseActivityEventListener {
    public CallbackManager mCallbackManager = new CallbackManagerImpl();

    public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
        this.mCallbackManager.onActivityResult(i, i2, intent);
    }
}
