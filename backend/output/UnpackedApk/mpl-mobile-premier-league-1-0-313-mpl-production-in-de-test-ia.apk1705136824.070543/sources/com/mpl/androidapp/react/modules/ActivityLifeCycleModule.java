package com.mpl.androidapp.react.modules;

import android.app.Activity;
import android.content.Intent;
import androidx.annotation.Keep;
import com.facebook.FacebookSdk;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.BaseActivityEventListener;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.module.annotations.ReactModule;
import com.mpl.androidapp.utils.MLogger;
import org.apache.fontbox.cmap.CMapParser;

@DoNotStrip
@ReactModule(name = "ActivityLifeCycleModule")
@Keep
public class ActivityLifeCycleModule extends ReactContextBaseJavaModule {
    public static final String TAG = "ActivityLifeCycleModule";

    public ActivityLifeCycleModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        reactApplicationContext.addActivityEventListener(new BaseActivityEventListener() {
            public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
                MLogger.d(ActivityLifeCycleModule.TAG, "onActivityResult()", Integer.valueOf(i), Boolean.valueOf(FacebookSdk.isFacebookRequestCode(i)));
            }

            public void onNewIntent(Intent intent) {
                super.onNewIntent(intent);
                MLogger.d(ActivityLifeCycleModule.TAG, "onNewIntent() called with: intent = [" + intent + CMapParser.MARK_END_OF_ARRAY);
            }
        });
        reactApplicationContext.addLifecycleEventListener(new LifecycleEventListener() {
            public void onHostDestroy() {
                MLogger.d(ActivityLifeCycleModule.TAG, "onHostDestroy() called");
            }

            public void onHostPause() {
                MLogger.d(ActivityLifeCycleModule.TAG, "onHostPause() called");
            }

            public void onHostResume() {
                MLogger.d(ActivityLifeCycleModule.TAG, "onHostResume() called");
            }
        });
    }

    public String getName() {
        return TAG;
    }
}
