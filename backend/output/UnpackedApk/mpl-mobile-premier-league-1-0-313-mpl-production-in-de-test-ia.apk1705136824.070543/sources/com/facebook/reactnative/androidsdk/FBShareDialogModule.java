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
import com.facebook.share.widget.ShareDialog;
import com.facebook.share.widget.ShareDialog.Mode;
import kotlin.jvm.internal.Intrinsics;

@ReactModule(name = "FBShareDialog")
public class FBShareDialogModule extends FBSDKCallbackManagerBaseJavaModule {
    public static final String NAME = "FBShareDialog";
    public Mode mShareDialogMode;
    public boolean mShouldFailOnError;

    public class ShareDialogCallback extends ReactNativeFacebookSDKCallback<Sharer$Result> {
        public ShareDialogCallback(FBShareDialogModule fBShareDialogModule, Promise promise) {
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

    public FBShareDialogModule(ReactApplicationContext reactApplicationContext, FBActivityEventListener fBActivityEventListener) {
        super(reactApplicationContext, fBActivityEventListener);
    }

    @ReactMethod
    public void canShow(ReadableMap readableMap, Promise promise) {
        boolean z;
        if (getCurrentActivity() != null) {
            ShareDialog shareDialog = new ShareDialog(getCurrentActivity());
            if (this.mShareDialogMode == null) {
                z = shareDialog.canShow(ImageOriginUtils.buildShareContent(readableMap));
            } else {
                ShareContent buildShareContent = ImageOriginUtils.buildShareContent(readableMap);
                Object obj = this.mShareDialogMode;
                Intrinsics.checkNotNullParameter(buildShareContent, "content");
                Intrinsics.checkNotNullParameter(obj, "mode");
                if (obj == Mode.AUTOMATIC) {
                    obj = FacebookDialogBase.BASE_AUTOMATIC_MODE;
                }
                z = shareDialog.canShowImpl(buildShareContent, obj);
            }
            promise.resolve(Boolean.valueOf(z));
            return;
        }
        promise.reject((String) "No current activity.");
    }

    public String getName() {
        return NAME;
    }

    @ReactMethod
    public void setMode(String str) {
        this.mShareDialogMode = Mode.valueOf(str.toUpperCase());
    }

    @ReactMethod
    public void setShouldFailOnError(boolean z) {
        this.mShouldFailOnError = z;
    }

    @ReactMethod
    public void show(ReadableMap readableMap, Promise promise) {
        if (getCurrentActivity() != null) {
            ShareDialog shareDialog = new ShareDialog(getCurrentActivity());
            shareDialog.registerCallback(getCallbackManager(), new ShareDialogCallback(this, promise));
            shareDialog.shouldFailOnDataError = this.mShouldFailOnError;
            if (this.mShareDialogMode != null) {
                shareDialog.show(ImageOriginUtils.buildShareContent(readableMap), this.mShareDialogMode);
            } else {
                shareDialog.showImpl(ImageOriginUtils.buildShareContent(readableMap), FacebookDialogBase.BASE_AUTOMATIC_MODE);
            }
        } else {
            promise.reject((String) "No current activity.");
        }
    }
}
