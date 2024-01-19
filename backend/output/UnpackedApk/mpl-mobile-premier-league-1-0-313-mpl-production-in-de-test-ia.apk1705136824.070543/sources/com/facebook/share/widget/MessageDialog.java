package com.facebook.share.widget;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLoggerImpl;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.internal.DialogFeature;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.DialogPresenter.ParameterProvider;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FacebookDialogBase.ModeHandler;
import com.facebook.internal.FragmentWrapper;
import com.facebook.share.Sharer$Result;
import com.facebook.share.internal.LegacyNativeDialogParameters;
import com.facebook.share.internal.MessageDialogFeature;
import com.facebook.share.internal.NativeDialogParameters;
import com.facebook.share.internal.ShareContentValidation;
import com.facebook.share.internal.ShareInternalUtility;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMessengerGenericTemplateContent;
import com.facebook.share.model.ShareMessengerMediaTemplateContent;
import com.facebook.share.model.ShareMessengerOpenGraphMusicTemplateContent;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

@Deprecated
public final class MessageDialog extends FacebookDialogBase<ShareContent, Sharer$Result> {
    public static final int DEFAULT_REQUEST_CODE = RequestCodeOffset.Message.toRequestCode();
    public boolean shouldFailOnDataError = false;

    public class NativeHandler extends ModeHandler {
        public NativeHandler(AnonymousClass1 r2) {
            super(MessageDialog.this);
        }

        public boolean canShow(Object obj, boolean z) {
            ShareContent shareContent = (ShareContent) obj;
            if (shareContent == null) {
                return false;
            }
            DialogFeature feature = MessageDialog.getFeature(shareContent.getClass());
            if (feature != null && DialogPresenter.canPresentNativeDialogWithFeature(feature)) {
                return true;
            }
            return false;
        }

        public AppCall createAppCall(Object obj) {
            String str;
            final ShareContent shareContent = (ShareContent) obj;
            ShareContentValidation.INSTANCE.validate(shareContent, ShareContentValidation.defaultValidator);
            final AppCall createBaseAppCall = MessageDialog.this.createBaseAppCall();
            MessageDialog messageDialog = MessageDialog.this;
            final boolean z = messageDialog.shouldFailOnDataError;
            Activity activityContext = messageDialog.getActivityContext();
            DialogFeature feature = MessageDialog.getFeature(shareContent.getClass());
            if (feature == MessageDialogFeature.MESSAGE_DIALOG) {
                str = "status";
            } else if (feature == MessageDialogFeature.MESSENGER_GENERIC_TEMPLATE) {
                str = "GenericTemplate";
            } else if (feature == MessageDialogFeature.MESSENGER_MEDIA_TEMPLATE) {
                str = "MediaTemplate";
            } else {
                str = feature == MessageDialogFeature.MESSENGER_OPEN_GRAPH_MUSIC_TEMPLATE ? "OpenGraphMusicTemplate" : "unknown";
            }
            AppEventsLoggerImpl appEventsLoggerImpl = new AppEventsLoggerImpl((Context) activityContext, (String) null, (AccessToken) null);
            Intrinsics.checkNotNullParameter(appEventsLoggerImpl, "loggerImpl");
            Bundle outline14 = GeneratedOutlineSupport.outline14("fb_share_dialog_content_type", str);
            outline14.putString("fb_share_dialog_content_uuid", createBaseAppCall.getCallId().toString());
            outline14.putString("fb_share_dialog_content_page_id", shareContent.pageId);
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            if (FacebookSdk.getAutoLogAppEventsEnabled()) {
                appEventsLoggerImpl.logEventImplicitly("fb_messenger_share_dialog_show", null, outline14);
            }
            DialogPresenter.setupAppCallForNativeDialog(createBaseAppCall, new ParameterProvider(this) {
                public Bundle getLegacyParameters() {
                    return LegacyNativeDialogParameters.create(createBaseAppCall.getCallId(), shareContent, z);
                }

                public Bundle getParameters() {
                    return NativeDialogParameters.create(createBaseAppCall.getCallId(), shareContent, z);
                }
            }, MessageDialog.getFeature(shareContent.getClass()));
            return createBaseAppCall;
        }
    }

    public MessageDialog(Activity activity) {
        super(activity, DEFAULT_REQUEST_CODE);
        ShareInternalUtility.registerStaticShareCallback(DEFAULT_REQUEST_CODE);
    }

    public static DialogFeature getFeature(Class<? extends ShareContent> cls) {
        if (ShareLinkContent.class.isAssignableFrom(cls)) {
            return MessageDialogFeature.MESSAGE_DIALOG;
        }
        if (ShareMessengerGenericTemplateContent.class.isAssignableFrom(cls)) {
            return MessageDialogFeature.MESSENGER_GENERIC_TEMPLATE;
        }
        if (ShareMessengerOpenGraphMusicTemplateContent.class.isAssignableFrom(cls)) {
            return MessageDialogFeature.MESSENGER_OPEN_GRAPH_MUSIC_TEMPLATE;
        }
        if (ShareMessengerMediaTemplateContent.class.isAssignableFrom(cls)) {
            return MessageDialogFeature.MESSENGER_MEDIA_TEMPLATE;
        }
        return null;
    }

    public AppCall createBaseAppCall() {
        return new AppCall(this.requestCodeField, null, 2);
    }

    public List<ModeHandler> getOrderedModeHandlers() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new NativeHandler(null));
        return arrayList;
    }

    public void registerCallbackImpl(CallbackManagerImpl callbackManagerImpl, FacebookCallback<Sharer$Result> facebookCallback) {
        ShareInternalUtility.registerSharerCallback(this.requestCodeField, callbackManagerImpl, facebookCallback);
    }

    public MessageDialog(Activity activity, int i) {
        super(activity, i);
        ShareInternalUtility.registerStaticShareCallback(i);
    }

    public MessageDialog(Fragment fragment, int i) {
        super(new FragmentWrapper(fragment), i);
        ShareInternalUtility.registerStaticShareCallback(i);
    }

    public MessageDialog(android.app.Fragment fragment, int i) {
        super(new FragmentWrapper(fragment), i);
        ShareInternalUtility.registerStaticShareCallback(i);
    }
}
