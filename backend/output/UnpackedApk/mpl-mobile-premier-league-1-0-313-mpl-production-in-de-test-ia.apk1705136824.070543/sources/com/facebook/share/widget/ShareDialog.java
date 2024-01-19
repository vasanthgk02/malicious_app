package com.facebook.share.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLoggerImpl;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.internal.DialogFeature;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FacebookDialogBase.ModeHandler;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.NativeAppCallAttachmentStore;
import com.facebook.internal.NativeAppCallAttachmentStore.Attachment;
import com.facebook.internal.Utility;
import com.facebook.share.Sharer$Result;
import com.facebook.share.internal.CameraEffectFeature;
import com.facebook.share.internal.ShareContentValidation;
import com.facebook.share.internal.ShareDialogFeature;
import com.facebook.share.internal.ShareFeedContent;
import com.facebook.share.internal.ShareInternalUtility;
import com.facebook.share.internal.ShareStoryFeature;
import com.facebook.share.internal.WebDialogParameters;
import com.facebook.share.model.ShareCameraEffectContent;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareHashtag;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.SharePhotoContent.Builder;
import com.facebook.share.model.ShareStoryContent;
import com.facebook.share.model.ShareVideoContent;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000 12\u0016\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u00070123456B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u0011\b\u0016\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nB\u000f\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rB\u000f\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fB\u0017\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\u0010B\u0017\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\u0011B\u0017\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\u000e\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\u0012B\u0019\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\u0015J \u0010\u001e\u001a\u00020\u00172\u000e\u0010\u001f\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00022\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020#H\u0014J\b\u0010$\u001a\u00020\u0017H\u0016J*\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(2\u000e\u0010\u001f\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00022\u0006\u0010 \u001a\u00020!H\u0002J\u001e\u0010)\u001a\u00020&2\u0006\u0010*\u001a\u00020+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00030-H\u0014J\u0010\u0010.\u001a\u00020&2\u0006\u0010\u001d\u001a\u00020\u0017H\u0016J \u0010/\u001a\u00020&2\u000e\u0010\u001f\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00022\u0006\u0010 \u001a\u00020!H\u0016R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R2\u0010\u0018\u001a \u0012\u001c\u0012\u001a0\u001aR\u0016\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u00010\u0019X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/facebook/share/widget/ShareDialog;", "Lcom/facebook/internal/FacebookDialogBase;", "Lcom/facebook/share/model/ShareContent;", "Lcom/facebook/share/Sharer$Result;", "Lcom/facebook/share/Sharer;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "requestCode", "", "(I)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "Landroid/app/Fragment;", "(Landroid/app/Fragment;)V", "(Landroid/app/Activity;I)V", "(Landroidx/fragment/app/Fragment;I)V", "(Landroid/app/Fragment;I)V", "fragmentWrapper", "Lcom/facebook/internal/FragmentWrapper;", "(Lcom/facebook/internal/FragmentWrapper;I)V", "isAutomaticMode", "", "orderedModeHandlers", "", "Lcom/facebook/internal/FacebookDialogBase$ModeHandler;", "getOrderedModeHandlers", "()Ljava/util/List;", "shouldFailOnDataError", "canShow", "content", "mode", "Lcom/facebook/share/widget/ShareDialog$Mode;", "createBaseAppCall", "Lcom/facebook/internal/AppCall;", "getShouldFailOnDataError", "logDialogShare", "", "context", "Landroid/content/Context;", "registerCallbackImpl", "callbackManager", "Lcom/facebook/internal/CallbackManagerImpl;", "callback", "Lcom/facebook/FacebookCallback;", "setShouldFailOnDataError", "show", "CameraEffectHandler", "Companion", "FeedHandler", "Mode", "NativeHandler", "ShareStoryHandler", "WebShareHandler", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ShareDialog.kt */
public class ShareDialog extends FacebookDialogBase<ShareContent<?, ?>, Sharer$Result> {
    public static final Companion Companion = new Companion(null);
    public static final int DEFAULT_REQUEST_CODE = RequestCodeOffset.Share.toRequestCode();
    public boolean isAutomaticMode;
    public final List<ModeHandler> orderedModeHandlers;
    public boolean shouldFailOnDataError;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u001a0\u0001R\u0016\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\u00040\u0002B\u0005¢\u0006\u0002\u0010\u0005J \u0010\f\u001a\u00020\r2\u000e\u0010\u000e\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00032\u0006\u0010\u000f\u001a\u00020\rH\u0016J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u000e\u0010\u000e\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/facebook/share/widget/ShareDialog$CameraEffectHandler;", "Lcom/facebook/internal/FacebookDialogBase$ModeHandler;", "Lcom/facebook/internal/FacebookDialogBase;", "Lcom/facebook/share/model/ShareContent;", "Lcom/facebook/share/Sharer$Result;", "(Lcom/facebook/share/widget/ShareDialog;)V", "mode", "", "getMode", "()Ljava/lang/Object;", "setMode", "(Ljava/lang/Object;)V", "canShow", "", "content", "isBestEffort", "createAppCall", "Lcom/facebook/internal/AppCall;", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: ShareDialog.kt */
    public final class CameraEffectHandler extends ModeHandler {
        public Object mode = Mode.NATIVE;
        public final /* synthetic */ ShareDialog this$0;

        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        public CameraEffectHandler(ShareDialog shareDialog) {
            // Intrinsics.checkNotNullParameter(shareDialog, "this$0");
            // this.this$0 = shareDialog;
            super(shareDialog);
        }

        public boolean canShow(Object obj, boolean z) {
            ShareContent shareContent = (ShareContent) obj;
            Intrinsics.checkNotNullParameter(shareContent, "content");
            return (shareContent instanceof ShareCameraEffectContent) && Companion.access$canShowNative(ShareDialog.Companion, shareContent.getClass());
        }

        public AppCall createAppCall(Object obj) {
            ShareContent shareContent = (ShareContent) obj;
            Intrinsics.checkNotNullParameter(shareContent, "content");
            ShareContentValidation.INSTANCE.validate(shareContent, ShareContentValidation.defaultValidator);
            AppCall createBaseAppCall = this.this$0.createBaseAppCall();
            boolean z = this.this$0.shouldFailOnDataError;
            DialogFeature feature = ShareDialog.Companion.getFeature(shareContent.getClass());
            if (feature == null) {
                return null;
            }
            DialogPresenter.setupAppCallForNativeDialog(createBaseAppCall, new ShareDialog$CameraEffectHandler$createAppCall$1(createBaseAppCall, shareContent, z), feature);
            return createBaseAppCall;
        }

        public Object getMode() {
            return this.mode;
        }
    }

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u000b\u001a\u00020\f2\u0016\u0010\r\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000f0\u000eH\u0017J \u0010\u0010\u001a\u00020\f2\u0016\u0010\r\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000f0\u000eH\u0002J\u0018\u0010\u0011\u001a\u00020\f2\u000e\u0010\u0012\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000fH\u0002J \u0010\u0013\u001a\u00020\f2\u0016\u0010\r\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000f0\u000eH\u0002J\"\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0016\u0010\r\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000f0\u000eH\u0002J \u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u000e\u0010\u001a\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000fH\u0017J \u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001c2\u000e\u0010\u001a\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000fH\u0017J \u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001d2\u000e\u0010\u001a\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000fH\u0017J \u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\u000e\u0010\u001a\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \b*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/facebook/share/widget/ShareDialog$Companion;", "", "()V", "DEFAULT_REQUEST_CODE", "", "FEED_DIALOG", "", "TAG", "kotlin.jvm.PlatformType", "WEB_OG_SHARE_DIALOG", "WEB_SHARE_DIALOG", "canShow", "", "contentType", "Ljava/lang/Class;", "Lcom/facebook/share/model/ShareContent;", "canShowNative", "canShowWebCheck", "content", "canShowWebTypeCheck", "getFeature", "Lcom/facebook/internal/DialogFeature;", "show", "", "activity", "Landroid/app/Activity;", "shareContent", "fragment", "Landroid/app/Fragment;", "Landroidx/fragment/app/Fragment;", "fragmentWrapper", "Lcom/facebook/internal/FragmentWrapper;", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: ShareDialog.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public static final boolean access$canShowNative(Companion companion, Class cls) {
            DialogFeature feature = companion.getFeature(cls);
            return feature != null && DialogPresenter.canPresentNativeDialogWithFeature(feature);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:5:0x0016, code lost:
            if (com.facebook.AccessToken.Companion.isCurrentAccessTokenActive() != false) goto L_0x001b;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean canShowWebTypeCheck(java.lang.Class<? extends com.facebook.share.model.ShareContent<?, ?>> r2) {
            /*
                r1 = this;
                java.lang.Class<com.facebook.share.model.ShareLinkContent> r0 = com.facebook.share.model.ShareLinkContent.class
                boolean r0 = r0.isAssignableFrom(r2)
                if (r0 != 0) goto L_0x001b
                java.lang.Class<com.facebook.share.model.SharePhotoContent> r0 = com.facebook.share.model.SharePhotoContent.class
                boolean r2 = r0.isAssignableFrom(r2)
                if (r2 == 0) goto L_0x0019
                com.facebook.AccessToken$Companion r2 = com.facebook.AccessToken.Companion
                boolean r2 = com.facebook.AccessToken.Companion.isCurrentAccessTokenActive()
                if (r2 == 0) goto L_0x0019
                goto L_0x001b
            L_0x0019:
                r2 = 0
                goto L_0x001c
            L_0x001b:
                r2 = 1
            L_0x001c:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.share.widget.ShareDialog.Companion.canShowWebTypeCheck(java.lang.Class):boolean");
        }

        public final DialogFeature getFeature(Class<? extends ShareContent<?, ?>> cls) {
            if (ShareLinkContent.class.isAssignableFrom(cls)) {
                return ShareDialogFeature.SHARE_DIALOG;
            }
            if (SharePhotoContent.class.isAssignableFrom(cls)) {
                return ShareDialogFeature.PHOTOS;
            }
            if (ShareVideoContent.class.isAssignableFrom(cls)) {
                return ShareDialogFeature.VIDEO;
            }
            if (ShareMediaContent.class.isAssignableFrom(cls)) {
                return ShareDialogFeature.MULTIMEDIA;
            }
            if (ShareCameraEffectContent.class.isAssignableFrom(cls)) {
                return CameraEffectFeature.SHARE_CAMERA_EFFECT;
            }
            if (ShareStoryContent.class.isAssignableFrom(cls)) {
                return ShareStoryFeature.SHARE_STORY_ASSET;
            }
            return null;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u001a0\u0001R\u0016\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\u00040\u0002B\u0005¢\u0006\u0002\u0010\u0005J \u0010\f\u001a\u00020\r2\u000e\u0010\u000e\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00032\u0006\u0010\u000f\u001a\u00020\rH\u0016J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u000e\u0010\u000e\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/facebook/share/widget/ShareDialog$FeedHandler;", "Lcom/facebook/internal/FacebookDialogBase$ModeHandler;", "Lcom/facebook/internal/FacebookDialogBase;", "Lcom/facebook/share/model/ShareContent;", "Lcom/facebook/share/Sharer$Result;", "(Lcom/facebook/share/widget/ShareDialog;)V", "mode", "", "getMode", "()Ljava/lang/Object;", "setMode", "(Ljava/lang/Object;)V", "canShow", "", "content", "isBestEffort", "createAppCall", "Lcom/facebook/internal/AppCall;", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: ShareDialog.kt */
    public final class FeedHandler extends ModeHandler {
        public Object mode = Mode.FEED;
        public final /* synthetic */ ShareDialog this$0;

        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        public FeedHandler(ShareDialog shareDialog) {
            // Intrinsics.checkNotNullParameter(shareDialog, "this$0");
            // this.this$0 = shareDialog;
            super(shareDialog);
        }

        public boolean canShow(Object obj, boolean z) {
            ShareContent shareContent = (ShareContent) obj;
            Intrinsics.checkNotNullParameter(shareContent, "content");
            return (shareContent instanceof ShareLinkContent) || (shareContent instanceof ShareFeedContent);
        }

        public AppCall createAppCall(Object obj) {
            Bundle bundle;
            String str;
            ShareContent shareContent = (ShareContent) obj;
            Intrinsics.checkNotNullParameter(shareContent, "content");
            ShareDialog shareDialog = this.this$0;
            ShareDialog.access$logDialogShare(shareDialog, shareDialog.getActivityContext(), shareContent, Mode.FEED);
            AppCall createBaseAppCall = this.this$0.createBaseAppCall();
            String str2 = null;
            if (shareContent instanceof ShareLinkContent) {
                ShareContentValidation.INSTANCE.validate(shareContent, ShareContentValidation.webShareValidator);
                ShareLinkContent shareLinkContent = (ShareLinkContent) shareContent;
                Intrinsics.checkNotNullParameter(shareLinkContent, "shareLinkContent");
                bundle = new Bundle();
                Uri uri = shareLinkContent.contentUrl;
                if (uri == null) {
                    str = null;
                } else {
                    str = uri.toString();
                }
                Utility.putNonEmptyString(bundle, "link", str);
                Utility.putNonEmptyString(bundle, "quote", shareLinkContent.quote);
                ShareHashtag shareHashtag = shareLinkContent.shareHashtag;
                if (shareHashtag != null) {
                    str2 = shareHashtag.hashtag;
                }
                Utility.putNonEmptyString(bundle, "hashtag", str2);
            } else if (!(shareContent instanceof ShareFeedContent)) {
                return null;
            } else {
                ShareFeedContent shareFeedContent = (ShareFeedContent) shareContent;
                Intrinsics.checkNotNullParameter(shareFeedContent, "shareFeedContent");
                bundle = new Bundle();
                Utility.putNonEmptyString(bundle, "to", shareFeedContent.toId);
                Utility.putNonEmptyString(bundle, "link", shareFeedContent.link);
                Utility.putNonEmptyString(bundle, "picture", shareFeedContent.picture);
                Utility.putNonEmptyString(bundle, DefaultSettingsSpiCall.SOURCE_PARAM, shareFeedContent.mediaSource);
                Utility.putNonEmptyString(bundle, "name", shareFeedContent.linkName);
                Utility.putNonEmptyString(bundle, "caption", shareFeedContent.linkCaption);
                Utility.putNonEmptyString(bundle, "description", shareFeedContent.linkDescription);
            }
            DialogPresenter.setupAppCallForWebDialog(createBaseAppCall, "feed", bundle);
            return createBaseAppCall;
        }

        public Object getMode() {
            return this.mode;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/facebook/share/widget/ShareDialog$Mode;", "", "(Ljava/lang/String;I)V", "AUTOMATIC", "NATIVE", "WEB", "FEED", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: ShareDialog.kt */
    public enum Mode {
        AUTOMATIC,
        NATIVE,
        WEB,
        FEED
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u001a0\u0001R\u0016\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\u00040\u0002B\u0005¢\u0006\u0002\u0010\u0005J \u0010\f\u001a\u00020\r2\u000e\u0010\u000e\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00032\u0006\u0010\u000f\u001a\u00020\rH\u0016J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u000e\u0010\u000e\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/facebook/share/widget/ShareDialog$NativeHandler;", "Lcom/facebook/internal/FacebookDialogBase$ModeHandler;", "Lcom/facebook/internal/FacebookDialogBase;", "Lcom/facebook/share/model/ShareContent;", "Lcom/facebook/share/Sharer$Result;", "(Lcom/facebook/share/widget/ShareDialog;)V", "mode", "", "getMode", "()Ljava/lang/Object;", "setMode", "(Ljava/lang/Object;)V", "canShow", "", "content", "isBestEffort", "createAppCall", "Lcom/facebook/internal/AppCall;", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: ShareDialog.kt */
    public final class NativeHandler extends ModeHandler {
        public Object mode = Mode.NATIVE;
        public final /* synthetic */ ShareDialog this$0;

        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        public NativeHandler(ShareDialog shareDialog) {
            // Intrinsics.checkNotNullParameter(shareDialog, "this$0");
            // this.this$0 = shareDialog;
            super(shareDialog);
        }

        public boolean canShow(Object obj, boolean z) {
            boolean z2;
            ShareContent shareContent = (ShareContent) obj;
            Intrinsics.checkNotNullParameter(shareContent, "content");
            if ((shareContent instanceof ShareCameraEffectContent) || (shareContent instanceof ShareStoryContent)) {
                return false;
            }
            if (!z) {
                z2 = shareContent.shareHashtag != null ? DialogPresenter.canPresentNativeDialogWithFeature(ShareDialogFeature.HASHTAG) : true;
                if (shareContent instanceof ShareLinkContent) {
                    String str = ((ShareLinkContent) shareContent).quote;
                    if (!(str == null || str.length() == 0)) {
                        if (!z2 || !DialogPresenter.canPresentNativeDialogWithFeature(ShareDialogFeature.LINK_SHARE_QUOTES)) {
                            z2 = false;
                        }
                    }
                }
                if (!z2 && Companion.access$canShowNative(ShareDialog.Companion, shareContent.getClass())) {
                    return true;
                }
            }
            z2 = true;
            return !z2 ? false : false;
        }

        public AppCall createAppCall(Object obj) {
            ShareContent shareContent = (ShareContent) obj;
            Intrinsics.checkNotNullParameter(shareContent, "content");
            ShareDialog shareDialog = this.this$0;
            ShareDialog.access$logDialogShare(shareDialog, shareDialog.getActivityContext(), shareContent, Mode.NATIVE);
            ShareContentValidation.INSTANCE.validate(shareContent, ShareContentValidation.defaultValidator);
            AppCall createBaseAppCall = this.this$0.createBaseAppCall();
            boolean z = this.this$0.shouldFailOnDataError;
            DialogFeature feature = ShareDialog.Companion.getFeature(shareContent.getClass());
            if (feature == null) {
                return null;
            }
            DialogPresenter.setupAppCallForNativeDialog(createBaseAppCall, new ShareDialog$NativeHandler$createAppCall$1(createBaseAppCall, shareContent, z), feature);
            return createBaseAppCall;
        }

        public Object getMode() {
            return this.mode;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u001a0\u0001R\u0016\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\u00040\u0002B\u0005¢\u0006\u0002\u0010\u0005J \u0010\f\u001a\u00020\r2\u000e\u0010\u000e\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00032\u0006\u0010\u000f\u001a\u00020\rH\u0016J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u000e\u0010\u000e\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/facebook/share/widget/ShareDialog$ShareStoryHandler;", "Lcom/facebook/internal/FacebookDialogBase$ModeHandler;", "Lcom/facebook/internal/FacebookDialogBase;", "Lcom/facebook/share/model/ShareContent;", "Lcom/facebook/share/Sharer$Result;", "(Lcom/facebook/share/widget/ShareDialog;)V", "mode", "", "getMode", "()Ljava/lang/Object;", "setMode", "(Ljava/lang/Object;)V", "canShow", "", "content", "isBestEffort", "createAppCall", "Lcom/facebook/internal/AppCall;", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: ShareDialog.kt */
    public final class ShareStoryHandler extends ModeHandler {
        public Object mode = Mode.NATIVE;
        public final /* synthetic */ ShareDialog this$0;

        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        public ShareStoryHandler(ShareDialog shareDialog) {
            // Intrinsics.checkNotNullParameter(shareDialog, "this$0");
            // this.this$0 = shareDialog;
            super(shareDialog);
        }

        public boolean canShow(Object obj, boolean z) {
            ShareContent shareContent = (ShareContent) obj;
            Intrinsics.checkNotNullParameter(shareContent, "content");
            return (shareContent instanceof ShareStoryContent) && Companion.access$canShowNative(ShareDialog.Companion, shareContent.getClass());
        }

        public AppCall createAppCall(Object obj) {
            ShareContent shareContent = (ShareContent) obj;
            Intrinsics.checkNotNullParameter(shareContent, "content");
            ShareContentValidation.INSTANCE.validate(shareContent, ShareContentValidation.storyValidator);
            AppCall createBaseAppCall = this.this$0.createBaseAppCall();
            boolean z = this.this$0.shouldFailOnDataError;
            DialogFeature feature = ShareDialog.Companion.getFeature(shareContent.getClass());
            if (feature == null) {
                return null;
            }
            DialogPresenter.setupAppCallForNativeDialog(createBaseAppCall, new ShareDialog$ShareStoryHandler$createAppCall$1(createBaseAppCall, shareContent, z), feature);
            return createBaseAppCall;
        }

        public Object getMode() {
            return this.mode;
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0004\u0018\u00002\u001a0\u0001R\u0016\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\u00040\u0002B\u0005¢\u0006\u0002\u0010\u0005J \u0010\f\u001a\u00020\r2\u000e\u0010\u000e\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00032\u0006\u0010\u000f\u001a\u00020\rH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u000e\u0010\u000e\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003H\u0016J\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u000e\u0010\u0018\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003H\u0002R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/facebook/share/widget/ShareDialog$WebShareHandler;", "Lcom/facebook/internal/FacebookDialogBase$ModeHandler;", "Lcom/facebook/internal/FacebookDialogBase;", "Lcom/facebook/share/model/ShareContent;", "Lcom/facebook/share/Sharer$Result;", "(Lcom/facebook/share/widget/ShareDialog;)V", "mode", "", "getMode", "()Ljava/lang/Object;", "setMode", "(Ljava/lang/Object;)V", "canShow", "", "content", "isBestEffort", "createAndMapAttachments", "Lcom/facebook/share/model/SharePhotoContent;", "callId", "Ljava/util/UUID;", "createAppCall", "Lcom/facebook/internal/AppCall;", "getActionName", "", "shareContent", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: ShareDialog.kt */
    public final class WebShareHandler extends ModeHandler {
        public Object mode = Mode.WEB;
        public final /* synthetic */ ShareDialog this$0;

        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        public WebShareHandler(ShareDialog shareDialog) {
            // Intrinsics.checkNotNullParameter(shareDialog, "this$0");
            // this.this$0 = shareDialog;
            super(shareDialog);
        }

        public boolean canShow(Object obj, boolean z) {
            ShareContent shareContent = (ShareContent) obj;
            Intrinsics.checkNotNullParameter(shareContent, "content");
            return ShareDialog.Companion.canShowWebTypeCheck(shareContent.getClass());
        }

        public AppCall createAppCall(Object obj) {
            Bundle bundle;
            List<T> list;
            ShareContent shareContent = (ShareContent) obj;
            Intrinsics.checkNotNullParameter(shareContent, "content");
            ShareDialog shareDialog = this.this$0;
            ShareDialog.access$logDialogShare(shareDialog, shareDialog.getActivityContext(), shareContent, Mode.WEB);
            AppCall createBaseAppCall = this.this$0.createBaseAppCall();
            ShareContentValidation.INSTANCE.validate(shareContent, ShareContentValidation.webShareValidator);
            boolean z = shareContent instanceof ShareLinkContent;
            String str = null;
            if (z) {
                ShareLinkContent shareLinkContent = (ShareLinkContent) shareContent;
                Intrinsics.checkNotNullParameter(shareLinkContent, "shareLinkContent");
                bundle = WebDialogParameters.createBaseParameters(shareLinkContent);
                Utility.putUri(bundle, "href", shareLinkContent.contentUrl);
                Utility.putNonEmptyString(bundle, "quote", shareLinkContent.quote);
            } else if (!(shareContent instanceof SharePhotoContent)) {
                return null;
            } else {
                SharePhotoContent sharePhotoContent = (SharePhotoContent) shareContent;
                UUID callId = createBaseAppCall.getCallId();
                Builder builder = new Builder();
                builder.contentUrl = sharePhotoContent.contentUrl;
                List<String> list2 = sharePhotoContent.peopleIds;
                if (list2 == null) {
                    list = null;
                } else {
                    list = Collections.unmodifiableList(list2);
                }
                builder.peopleIds = list;
                builder.placeId = sharePhotoContent.placeId;
                builder.pageId = sharePhotoContent.pageId;
                builder.ref = sharePhotoContent.ref;
                builder.hashtag = sharePhotoContent.shareHashtag;
                builder.addPhotos(sharePhotoContent.photos);
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                int size = sharePhotoContent.photos.size() - 1;
                if (size >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i + 1;
                        SharePhoto sharePhoto = sharePhotoContent.photos.get(i);
                        Bitmap bitmap = sharePhoto.bitmap;
                        if (bitmap != null) {
                            Intrinsics.checkNotNullParameter(callId, "callId");
                            Intrinsics.checkNotNullParameter(bitmap, "attachmentBitmap");
                            Attachment attachment = new Attachment(callId, bitmap, null);
                            SharePhoto.Builder readFrom = new SharePhoto.Builder().readFrom(sharePhoto);
                            readFrom.imageUrl = Uri.parse(attachment.attachmentUrl);
                            readFrom.bitmap = null;
                            sharePhoto = readFrom.build();
                            arrayList2.add(attachment);
                        }
                        arrayList.add(sharePhoto);
                        if (i2 > size) {
                            break;
                        }
                        i = i2;
                    }
                }
                builder.photos.clear();
                builder.addPhotos(arrayList);
                NativeAppCallAttachmentStore.addAttachments(arrayList2);
                SharePhotoContent sharePhotoContent2 = new SharePhotoContent(builder, null);
                Intrinsics.checkNotNullParameter(sharePhotoContent2, "sharePhotoContent");
                bundle = WebDialogParameters.createBaseParameters(sharePhotoContent2);
                Iterable<SharePhoto> iterable = sharePhotoContent2.photos;
                if (iterable == null) {
                    iterable = EmptyList.INSTANCE;
                }
                ArrayList arrayList3 = new ArrayList(TweetUtils.collectionSizeOrDefault(iterable, 10));
                for (SharePhoto sharePhoto2 : iterable) {
                    arrayList3.add(String.valueOf(sharePhoto2.imageUrl));
                }
                Object[] array = arrayList3.toArray(new String[0]);
                if (array != null) {
                    bundle.putStringArray("media", (String[]) array);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
            }
            if (z || (shareContent instanceof SharePhotoContent)) {
                str = "share";
            }
            DialogPresenter.setupAppCallForWebDialog(createBaseAppCall, str, bundle);
            return createBaseAppCall;
        }

        public Object getMode() {
            return this.mode;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public ShareDialog(Activity activity) {
        // Intrinsics.checkNotNullParameter(activity, "activity");
        this(activity, DEFAULT_REQUEST_CODE);
    }

    public static final void access$logDialogShare(ShareDialog shareDialog, Context context, ShareContent shareContent, Mode mode) {
        Object obj;
        if (shareDialog.isAutomaticMode) {
            mode = Mode.AUTOMATIC;
        }
        int ordinal = mode.ordinal();
        String str = "unknown";
        String str2 = ordinal != 0 ? ordinal != 1 ? ordinal != 2 ? str : "web" : FileStore.NATIVE_SESSION_SUBDIR : "automatic";
        Class<?> cls = shareContent.getClass();
        if (ShareLinkContent.class.isAssignableFrom(cls)) {
            obj = ShareDialogFeature.SHARE_DIALOG;
        } else if (SharePhotoContent.class.isAssignableFrom(cls)) {
            obj = ShareDialogFeature.PHOTOS;
        } else if (ShareVideoContent.class.isAssignableFrom(cls)) {
            obj = ShareDialogFeature.VIDEO;
        } else if (ShareMediaContent.class.isAssignableFrom(cls)) {
            obj = ShareDialogFeature.MULTIMEDIA;
        } else if (ShareCameraEffectContent.class.isAssignableFrom(cls)) {
            obj = CameraEffectFeature.SHARE_CAMERA_EFFECT;
        } else {
            obj = ShareStoryContent.class.isAssignableFrom(cls) ? ShareStoryFeature.SHARE_STORY_ASSET : null;
        }
        if (obj == ShareDialogFeature.SHARE_DIALOG) {
            str = "status";
        } else if (obj == ShareDialogFeature.PHOTOS) {
            str = "photo";
        } else if (obj == ShareDialogFeature.VIDEO) {
            str = "video";
        }
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        AppEventsLoggerImpl appEventsLoggerImpl = new AppEventsLoggerImpl(context, FacebookSdk.getApplicationId(), (AccessToken) null);
        Intrinsics.checkNotNullParameter(appEventsLoggerImpl, "loggerImpl");
        Bundle bundle = new Bundle();
        bundle.putString("fb_share_dialog_show", str2);
        bundle.putString("fb_share_dialog_content_type", str);
        FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            appEventsLoggerImpl.logEventImplicitly("fb_share_dialog_show", null, bundle);
        }
    }

    public AppCall createBaseAppCall() {
        return new AppCall(this.requestCodeField, null, 2);
    }

    public List<ModeHandler> getOrderedModeHandlers() {
        return this.orderedModeHandlers;
    }

    public void registerCallbackImpl(CallbackManagerImpl callbackManagerImpl, FacebookCallback<Sharer$Result> facebookCallback) {
        Intrinsics.checkNotNullParameter(callbackManagerImpl, "callbackManager");
        Intrinsics.checkNotNullParameter(facebookCallback, "callback");
        ShareInternalUtility.registerSharerCallback(this.requestCodeField, callbackManagerImpl, facebookCallback);
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=com.facebook.share.widget.ShareDialog$Mode, code=java.lang.Object, for r3v0, types: [com.facebook.share.widget.ShareDialog$Mode, java.lang.Object] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void show(com.facebook.share.model.ShareContent<?, ?> r2, java.lang.Object r3) {
        /*
            r1 = this;
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "mode"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            com.facebook.share.widget.ShareDialog$Mode r0 = com.facebook.share.widget.ShareDialog.Mode.AUTOMATIC
            if (r3 != r0) goto L_0x0010
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            r1.isAutomaticMode = r0
            if (r0 == 0) goto L_0x0017
            java.lang.Object r3 = com.facebook.internal.FacebookDialogBase.BASE_AUTOMATIC_MODE
        L_0x0017:
            r1.showImpl(r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.share.widget.ShareDialog.show(com.facebook.share.model.ShareContent, com.facebook.share.widget.ShareDialog$Mode):void");
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public ShareDialog(Activity activity, int i) {
        // Intrinsics.checkNotNullParameter(activity, "activity");
        super(activity, i);
        this.isAutomaticMode = true;
        this.orderedModeHandlers = TweetUtils.arrayListOf(new NativeHandler(this), new FeedHandler(this), new WebShareHandler(this), new CameraEffectHandler(this), new ShareStoryHandler(this));
        ShareInternalUtility.registerStaticShareCallback(i);
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public ShareDialog(FragmentWrapper fragmentWrapper, int i) {
        // Intrinsics.checkNotNullParameter(fragmentWrapper, "fragmentWrapper");
        super(fragmentWrapper, i);
        this.isAutomaticMode = true;
        this.orderedModeHandlers = TweetUtils.arrayListOf(new NativeHandler(this), new FeedHandler(this), new WebShareHandler(this), new CameraEffectHandler(this), new ShareStoryHandler(this));
        ShareInternalUtility.registerStaticShareCallback(i);
    }
}
