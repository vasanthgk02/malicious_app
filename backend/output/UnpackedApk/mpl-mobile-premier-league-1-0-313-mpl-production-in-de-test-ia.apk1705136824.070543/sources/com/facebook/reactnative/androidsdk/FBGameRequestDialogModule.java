package com.facebook.reactnative.androidsdk;

import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.share.model.GameRequestContent;
import com.facebook.share.model.GameRequestContent.ActionType;
import com.facebook.share.model.GameRequestContent.Builder;
import com.facebook.share.model.GameRequestContent.Filters;
import com.facebook.share.widget.GameRequestDialog;
import com.facebook.share.widget.GameRequestDialog.Result;
import com.mpl.androidapp.onesignal.OneSingnalConstant;
import com.rudderstack.android.sdk.core.ecomm.ECommerceParamNames;
import in.juspay.services.HyperServices;
import java.util.List;

@ReactModule(name = "FBGameRequestDialog")
public class FBGameRequestDialogModule extends FBSDKCallbackManagerBaseJavaModule {
    public static final String NAME = "FBGameRequestDialog";

    public class GameRequestDialogCallback extends ReactNativeFacebookSDKCallback<Result> {
        public GameRequestDialogCallback(FBGameRequestDialogModule fBGameRequestDialogModule, Promise promise) {
            super(promise);
        }

        public void onSuccess(Object obj) {
            Result result = (Result) obj;
            if (this.mPromise != null) {
                WritableMap createMap = Arguments.createMap();
                createMap.putString(HyperServices.REQUEST_ID, result.requestId);
                List<String> list = result.to;
                WritableArray createArray = Arguments.createArray();
                for (String pushString : list) {
                    createArray.pushString(pushString);
                }
                createMap.putArray("to", createArray);
                this.mPromise.resolve(createMap);
                this.mPromise = null;
            }
        }
    }

    public FBGameRequestDialogModule(ReactApplicationContext reactApplicationContext, FBActivityEventListener fBActivityEventListener) {
        super(reactApplicationContext, fBActivityEventListener);
    }

    @ReactMethod
    public void canShow(Promise promise) {
        GameRequestDialog.canShow();
        promise.resolve(Boolean.TRUE);
    }

    public String getName() {
        return NAME;
    }

    @ReactMethod
    public void show(ReadableMap readableMap, Promise promise) {
        if (getCurrentActivity() != null) {
            GameRequestDialog gameRequestDialog = new GameRequestDialog(getCurrentActivity());
            Builder builder = new Builder();
            String valueOrNull = ImageOriginUtils.getValueOrNull(readableMap, OneSingnalConstant.PARAM_ACTION_TYPE);
            if (valueOrNull != null) {
                builder.actionType = ActionType.valueOf(valueOrNull.toUpperCase());
            }
            String valueOrNull2 = ImageOriginUtils.getValueOrNull(readableMap, ECommerceParamNames.FILTERS);
            if (valueOrNull2 != null) {
                builder.filters = Filters.valueOf(valueOrNull2.toUpperCase());
            }
            builder.message = readableMap.getString("message");
            if (readableMap.hasKey("recipients")) {
                builder.recipients = ImageOriginUtils.reactArrayToStringList(readableMap.getArray("recipients"));
            }
            builder.title = ImageOriginUtils.getValueOrNull(readableMap, "title");
            builder.data = ImageOriginUtils.getValueOrNull(readableMap, "data");
            builder.objectId = ImageOriginUtils.getValueOrNull(readableMap, "objectId");
            if (readableMap.hasKey("suggestions")) {
                builder.suggestions = ImageOriginUtils.reactArrayToStringList(readableMap.getArray("suggestions"));
            }
            GameRequestContent gameRequestContent = new GameRequestContent(builder, null);
            gameRequestDialog.registerCallback(getCallbackManager(), new GameRequestDialogCallback(this, promise));
            gameRequestDialog.showImpl(gameRequestContent, FacebookDialogBase.BASE_AUTOMATIC_MODE);
            return;
        }
        promise.reject((String) "No current activity.");
    }
}
