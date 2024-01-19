package com.facebook.share.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.CustomTabMainActivity;
import com.facebook.FacebookCallback;
import com.facebook.FacebookSdk;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.CallbackManagerImpl.Callback;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.internal.CustomTabUtils;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FacebookDialogBase.ModeHandler;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Validate;
import com.facebook.share.internal.ResultProcessor;
import com.facebook.share.internal.ShareInternalUtility;
import com.facebook.share.internal.WebDialogParameters;
import com.facebook.share.model.GameRequestContent;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

@Deprecated
public class GameRequestDialog extends FacebookDialogBase<GameRequestContent, Result> {
    public static final int DEFAULT_REQUEST_CODE = RequestCodeOffset.GameRequest.toRequestCode();

    public class ChromeCustomTabHandler extends ModeHandler {
        public ChromeCustomTabHandler(AnonymousClass1 r2) {
            super(GameRequestDialog.this);
        }

        public boolean canShow(Object obj, boolean z) {
            GameRequestContent gameRequestContent = (GameRequestContent) obj;
            return CustomTabUtils.getChromePackage() != null && Validate.hasCustomTabRedirectActivity(GameRequestDialog.this.getActivityContext(), CustomTabUtils.getDefaultRedirectURI());
        }

        public AppCall createAppCall(Object obj) {
            GameRequestContent gameRequestContent = (GameRequestContent) obj;
            ImageOriginUtils.validate(gameRequestContent);
            AppCall createBaseAppCall = GameRequestDialog.this.createBaseAppCall();
            Bundle create = WebDialogParameters.create(gameRequestContent);
            AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
            if (currentAccessToken != null) {
                create.putString("app_id", currentAccessToken.applicationId);
            } else {
                create.putString("app_id", FacebookSdk.getApplicationId());
            }
            create.putString("redirect_uri", CustomTabUtils.getDefaultRedirectURI());
            Intrinsics.checkNotNullParameter(createBaseAppCall, "appCall");
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            Validate.hasCustomTabRedirectActivity(FacebookSdk.getApplicationContext(), CustomTabUtils.getDefaultRedirectURI());
            FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
            Context applicationContext = FacebookSdk.getApplicationContext();
            Intrinsics.checkNotNullParameter(applicationContext, "context");
            Validate.hasInternetPermissions(applicationContext, true);
            FacebookSdk facebookSdk3 = FacebookSdk.INSTANCE;
            Intent intent = new Intent(FacebookSdk.getApplicationContext(), CustomTabMainActivity.class);
            intent.putExtra(CustomTabMainActivity.EXTRA_ACTION, "apprequests");
            intent.putExtra(CustomTabMainActivity.EXTRA_PARAMS, create);
            intent.putExtra(CustomTabMainActivity.EXTRA_CHROME_PACKAGE, CustomTabUtils.getChromePackage());
            NativeProtocol nativeProtocol = NativeProtocol.INSTANCE;
            String uuid = createBaseAppCall.getCallId().toString();
            NativeProtocol nativeProtocol2 = NativeProtocol.INSTANCE;
            NativeProtocol.setupProtocolRequestIntent(intent, uuid, "apprequests", NativeProtocol.getLatestKnownVersion(), null);
            createBaseAppCall.setRequestIntent(intent);
            return createBaseAppCall;
        }
    }

    public static final class Result {
        public String requestId;
        public List<String> to = new ArrayList();

        public Result(Bundle bundle, AnonymousClass1 r6) {
            this.requestId = bundle.getString("request");
            while (true) {
                if (bundle.containsKey(String.format("to[%d]", new Object[]{Integer.valueOf(this.to.size())}))) {
                    List<String> list = this.to;
                    list.add(bundle.getString(String.format("to[%d]", new Object[]{Integer.valueOf(list.size())})));
                } else {
                    return;
                }
            }
        }
    }

    public class WebHandler extends ModeHandler {
        public WebHandler(AnonymousClass1 r2) {
            super(GameRequestDialog.this);
        }

        public boolean canShow(Object obj, boolean z) {
            GameRequestContent gameRequestContent = (GameRequestContent) obj;
            return true;
        }

        public AppCall createAppCall(Object obj) {
            GameRequestContent gameRequestContent = (GameRequestContent) obj;
            ImageOriginUtils.validate(gameRequestContent);
            AppCall createBaseAppCall = GameRequestDialog.this.createBaseAppCall();
            DialogPresenter.setupAppCallForWebDialog(createBaseAppCall, "apprequests", WebDialogParameters.create(gameRequestContent));
            return createBaseAppCall;
        }
    }

    public GameRequestDialog(Activity activity) {
        super(activity, DEFAULT_REQUEST_CODE);
    }

    public static boolean canShow() {
        return true;
    }

    public AppCall createBaseAppCall() {
        return new AppCall(this.requestCodeField, null, 2);
    }

    public List<ModeHandler> getOrderedModeHandlers() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ChromeCustomTabHandler(null));
        arrayList.add(new WebHandler(null));
        return arrayList;
    }

    public void registerCallbackImpl(CallbackManagerImpl callbackManagerImpl, final FacebookCallback<Result> facebookCallback) {
        final AnonymousClass1 r0 = new ResultProcessor(this, facebookCallback) {
            public void onSuccess(AppCall appCall, Bundle bundle) {
                if (bundle != null) {
                    facebookCallback.onSuccess(new Result(bundle, null));
                    return;
                }
                Intrinsics.checkNotNullParameter(appCall, "appCall");
                FacebookCallback<?> facebookCallback = this.appCallback;
                if (facebookCallback != null) {
                    facebookCallback.onCancel();
                }
            }
        };
        callbackManagerImpl.registerCallback(this.requestCodeField, new Callback() {
            public boolean onActivityResult(int i, Intent intent) {
                return ShareInternalUtility.handleActivityResult(GameRequestDialog.this.requestCodeField, i, intent, r0);
            }
        });
    }
}
