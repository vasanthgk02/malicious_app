package com.facebook.reactnative.androidsdk;

import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.share.Sharer$Result;
import com.facebook.share.model.ShareContent;
import com.facebook.share.widget.MessageDialog;

@ReactModule(name = "FBMessageDialog")
public class FBMessageDialogModule extends FBSDKCallbackManagerBaseJavaModule {
    public static final String NAME = "FBMessageDialog";
    public boolean mShouldFailOnDataError;

    public class MessageDialogCallback extends ReactNativeFacebookSDKCallback<Sharer$Result> {
        public MessageDialogCallback(FBMessageDialogModule fBMessageDialogModule, Promise promise) {
            super(promise);
        }

        public void onSuccess(Object obj) {
            Sharer$Result sharer$Result = (Sharer$Result) obj;
            if (this.mPromise != null) {
                WritableMap createMap = Arguments.createMap();
                createMap.putString("postId", sharer$Result.postId);
                this.mPromise.resolve(createMap);
                this.mPromise = null;
            }
        }
    }

    public FBMessageDialogModule(ReactApplicationContext reactApplicationContext, FBActivityEventListener fBActivityEventListener) {
        super(reactApplicationContext, fBActivityEventListener);
    }

    @ReactMethod
    public void canShow(ReadableMap readableMap, Promise promise) {
        if (getCurrentActivity() != null) {
            promise.resolve(Boolean.valueOf(new MessageDialog(getCurrentActivity()).canShow(ImageOriginUtils.buildShareContent(readableMap))));
            return;
        }
        promise.reject((String) "No current activity.");
    }

    public String getName() {
        return NAME;
    }

    @ReactMethod
    public void setShouldFailOnDataError(boolean z) {
        this.mShouldFailOnDataError = z;
    }

    @ReactMethod
    public void show(ReadableMap readableMap, Promise promise) {
        if (getCurrentActivity() != null) {
            ShareContent buildShareContent = ImageOriginUtils.buildShareContent(readableMap);
            MessageDialog messageDialog = new MessageDialog(getCurrentActivity());
            messageDialog.shouldFailOnDataError = this.mShouldFailOnDataError;
            messageDialog.registerCallback(getCallbackManager(), new MessageDialogCallback(this, promise));
            messageDialog.showImpl(buildShareContent, FacebookDialogBase.BASE_AUTOMATIC_MODE);
            return;
        }
        promise.reject((String) "No current activity.");
    }
}
