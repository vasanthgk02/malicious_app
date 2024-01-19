package com.mpl.androidapp.react.modules;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.annotation.Keep;
import com.facebook.FacebookSdk;
import com.facebook.FacebookSdk.InitializeCallback;
import com.facebook.LoggingBehavior;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.BaseActivityEventListener;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import com.mpl.androidapp.react.FacebookShareActivity;
import com.mpl.androidapp.utils.Constant.VideoRecordingConstants;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.utils.Util;
import com.mpl.androidapp.utils.VideoRecordingUtils;
import com.mpl.securepreferences.MPreferences;
import java.io.File;
import org.apache.fontbox.cmap.CMapParser;
import sfs2x.client.core.SFSEvent;

@DoNotStrip
@ReactModule(name = "FacebookHelperModule")
@Keep
public class FacebookHelperModule extends ReactContextBaseJavaModule {
    public static final String TAG = "FacebookHelperModule";
    public final ReactApplicationContext mContext;

    public FacebookHelperModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mContext = reactApplicationContext;
        reactApplicationContext.addActivityEventListener(new BaseActivityEventListener() {
            public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
                MLogger.d(FacebookHelperModule.TAG, "onActivityResult()", Integer.valueOf(i), Boolean.valueOf(FacebookSdk.isFacebookRequestCode(i)));
            }

            public void onNewIntent(Intent intent) {
                super.onNewIntent(intent);
                MLogger.d(FacebookHelperModule.TAG, "onNewIntent() called with: intent = [" + intent + CMapParser.MARK_END_OF_ARRAY);
            }
        });
        new CallbackManagerImpl();
        FacebookSdk.addLoggingBehavior(LoggingBehavior.DEVELOPER_ERRORS);
        reactApplicationContext.addLifecycleEventListener(new LifecycleEventListener() {
            public void onHostDestroy() {
                MLogger.d(FacebookHelperModule.TAG, "onHostDestroy() called");
            }

            public void onHostPause() {
                MLogger.d(FacebookHelperModule.TAG, "onHostPause() called");
                FacebookSdk.sdkInitialize(FacebookHelperModule.this.mContext.getApplicationContext(), new InitializeCallback() {
                    public void onInitialized() {
                        MLogger.d(FacebookHelperModule.TAG, "onHostPause() called");
                    }
                });
            }

            public void onHostResume() {
                MLogger.d(FacebookHelperModule.TAG, "onHostResume() called");
            }
        });
    }

    private void sendEvent(ReactContext reactContext, String str, WritableMap writableMap) {
        ((RCTDeviceEventEmitter) reactContext.getJSModule(RCTDeviceEventEmitter.class)).emit(str, writableMap);
    }

    public String getName() {
        return TAG;
    }

    @ReactMethod
    public void loginFacebook(String str) {
        String string = MPreferences.getString(VideoRecordingConstants.RECORDED_VIDEO_PATH, "", false);
        if (TextUtils.isEmpty(string)) {
            return;
        }
        if (!new File(string).exists()) {
            VideoRecordingUtils.deleteAllRecordingFiles();
            Toast.makeText(getReactApplicationContext(), "File deleted", 0).show();
        } else if (getCurrentActivity() == null) {
            MLogger.d(TAG, "Activity is null");
        } else if (Util.isFacebookPresent(this.mContext)) {
            Intent createIntent = FacebookShareActivity.createIntent(getCurrentActivity().getApplicationContext());
            createIntent.putExtra("flag", "share");
            createIntent.putExtra("entryPoint", str);
            createIntent.putExtra("isFTUEShown", VideoRecordingUtils.isVideoFTUETutorialShown());
            getCurrentActivity().startActivity(createIntent);
        } else {
            Toast.makeText(getReactApplicationContext(), "Facebook App not Present", 0).show();
        }
    }

    @ReactMethod
    public void loginFacebookOnly() {
        if (!TextUtils.isEmpty(VideoRecordingUtils.getFacebookAccessToken())) {
            Toast.makeText(getReactApplicationContext(), "Already Log In", 0).show();
        } else if (getCurrentActivity() == null) {
            MLogger.d(TAG, "Activity is null");
        } else if (Util.isFacebookPresent(this.mContext)) {
            Intent createIntent = FacebookShareActivity.createIntent(getCurrentActivity().getApplicationContext());
            createIntent.putExtra("flag", SFSEvent.LOGIN);
            createIntent.putExtra("entryPoint", "Profile");
            createIntent.putExtra("isFTUEShown", VideoRecordingUtils.isVideoFTUETutorialShown());
            getCurrentActivity().startActivity(createIntent);
        } else {
            Toast.makeText(getReactApplicationContext(), "Facebook App not Present", 0).show();
        }
    }
}
