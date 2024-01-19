package com.facebook.share.internal;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest.Callback;
import com.facebook.GraphRequest.ParcelableResourceWithMimeType;
import com.facebook.HttpMethod;
import com.facebook.appevents.AppEventsLoggerImpl;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.NativeAppCallAttachmentStore;
import com.facebook.internal.NativeAppCallAttachmentStore.Attachment;
import com.facebook.internal.Utility;
import com.facebook.share.Sharer$Result;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.twitter.sdk.android.tweetui.TweetUtils;
import com.xiaomi.mipush.sdk.PushMessageHelper;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

@Metadata(d1 = {"\u0000î\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J&\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\"\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u000e\u0010\u0015\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0016H\u0002J\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u0010H\u0007J\u001e\u0010\u001c\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00040\u001d2\u0006\u0010\u001e\u001a\u00020\u0004H\u0007J\"\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010\u001b\u001a\u00020\u0010H\u0007J\u0012\u0010#\u001a\u0004\u0018\u00010\u00042\u0006\u0010$\u001a\u00020\u0018H\u0007J\"\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010 2\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010\u001b\u001a\u00020\u0010H\u0007J\u0012\u0010(\u001a\u0004\u0018\u00010\u00042\u0006\u0010$\u001a\u00020\u0018H\u0007J\u0018\u0010)\u001a\u00020*2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,H\u0007J\u001c\u0010.\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u0010H\u0007J\u001c\u0010/\u001a\u0004\u0018\u00010\u00182\b\u00100\u001a\u0004\u0018\u0001012\u0006\u0010\u001b\u001a\u00020\u0010H\u0007J\u0014\u00102\u001a\u0004\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J\u001c\u00103\u001a\u0004\u0018\u00010\u00042\b\u00104\u001a\u0004\u0018\u0001052\u0006\u0010\u001b\u001a\u00020\u0010H\u0007J,\u00106\u001a\u0002072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u00108\u001a\u0004\u0018\u00010*H\u0007J\"\u00109\u001a\u00020:2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,2\b\u0010;\u001a\u0004\u0018\u00010\u0004H\u0007J \u0010<\u001a\u00020:2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,2\u0006\u0010=\u001a\u00020>H\u0007J*\u0010?\u001a\u00020:2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,2\b\u0010@\u001a\u0004\u0018\u00010\u00042\u0006\u0010A\u001a\u00020BH\u0007J\u0018\u0010C\u001a\u00020:2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,H\u0007J \u0010D\u001a\u00020:2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,2\u0006\u0010E\u001a\u00020FH\u0007J,\u0010D\u001a\u00020:2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,2\b\u0010G\u001a\u0004\u0018\u00010B2\b\u0010H\u001a\u0004\u0018\u00010\u0004H\u0007J\"\u0010D\u001a\u00020:2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,2\b\u0010H\u001a\u0004\u0018\u00010\u0004H\u0007J\"\u0010I\u001a\u00020:2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,2\b\u0010@\u001a\u0004\u0018\u00010\u0004H\u0007J\u001a\u0010J\u001a\u00020:2\u0006\u0010K\u001a\u00020\u00042\b\u0010L\u001a\u0004\u0018\u00010\u0004H\u0002J&\u0010M\u001a\u00020N2\b\u0010O\u001a\u0004\u0018\u00010P2\b\u0010Q\u001a\u0004\u0018\u00010\u00142\b\u0010+\u001a\u0004\u0018\u00010RH\u0007J$\u0010M\u001a\u00020N2\b\u0010O\u001a\u0004\u0018\u00010P2\u0006\u0010S\u001a\u00020\u00122\b\u0010+\u001a\u0004\u0018\u00010RH\u0007J&\u0010M\u001a\u00020N2\b\u0010O\u001a\u0004\u0018\u00010P2\b\u0010T\u001a\u0004\u0018\u00010U2\b\u0010+\u001a\u0004\u0018\u00010RH\u0007J*\u0010V\u001a\u00020:2\u0006\u0010\b\u001a\u00020\t2\b\u0010W\u001a\u0004\u0018\u00010X2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,H\u0007J\u0010\u0010Y\u001a\u00020:2\u0006\u0010\b\u001a\u00020\tH\u0007J\u0018\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020[2\u0006\u0010]\u001a\u000207H\u0007J\u001c\u0010^\u001a\u0004\u0018\u00010_2\b\u0010`\u001a\u0004\u0018\u00010_2\u0006\u0010]\u001a\u000207H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006a"}, d2 = {"Lcom/facebook/share/internal/ShareInternalUtility;", "", "()V", "MY_STAGING_RESOURCES", "", "STAGING_PARAM", "getAppCallFromActivityResult", "Lcom/facebook/internal/AppCall;", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "getAttachment", "Lcom/facebook/internal/NativeAppCallAttachmentStore$Attachment;", "callId", "Ljava/util/UUID;", "uri", "Landroid/net/Uri;", "bitmap", "Landroid/graphics/Bitmap;", "medium", "Lcom/facebook/share/model/ShareMedia;", "getBackgroundAssetMediaInfo", "Landroid/os/Bundle;", "storyContent", "Lcom/facebook/share/model/ShareStoryContent;", "appCallId", "getFieldNameAndNamespaceFromFullName", "Landroid/util/Pair;", "fullName", "getMediaInfos", "", "mediaContent", "Lcom/facebook/share/model/ShareMediaContent;", "getNativeDialogCompletionGesture", "result", "getPhotoUrls", "photoContent", "Lcom/facebook/share/model/SharePhotoContent;", "getShareDialogPostId", "getShareResultProcessor", "Lcom/facebook/share/internal/ResultProcessor;", "callback", "Lcom/facebook/FacebookCallback;", "Lcom/facebook/share/Sharer$Result;", "getStickerUrl", "getTextureUrlBundle", "cameraEffectContent", "Lcom/facebook/share/model/ShareCameraEffectContent;", "getUriExtension", "getVideoUrl", "videoContent", "Lcom/facebook/share/model/ShareVideoContent;", "handleActivityResult", "", "resultProcessor", "invokeCallbackWithError", "", "error", "invokeCallbackWithException", "exception", "Ljava/lang/Exception;", "invokeCallbackWithResults", "postId", "graphResponse", "Lcom/facebook/GraphResponse;", "invokeOnCancelCallback", "invokeOnErrorCallback", "ex", "Lcom/facebook/FacebookException;", "response", "message", "invokeOnSuccessCallback", "logShareResult", "shareOutcome", "errorMessage", "newUploadStagingResourceWithImageRequest", "Lcom/facebook/GraphRequest;", "accessToken", "Lcom/facebook/AccessToken;", "image", "Lcom/facebook/GraphRequest$Callback;", "imageUri", "file", "Ljava/io/File;", "registerSharerCallback", "callbackManager", "Lcom/facebook/CallbackManager;", "registerStaticShareCallback", "removeNamespacesFromOGJsonArray", "Lorg/json/JSONArray;", "jsonArray", "requireNamespace", "removeNamespacesFromOGJsonObject", "Lorg/json/JSONObject;", "jsonObject", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ShareInternalUtility.kt */
public final class ShareInternalUtility {
    public static final Attachment getAttachment(UUID uuid, Uri uri, Bitmap bitmap) {
        if (bitmap != null) {
            Intrinsics.checkNotNullParameter(uuid, "callId");
            Intrinsics.checkNotNullParameter(bitmap, "attachmentBitmap");
            return new Attachment(uuid, bitmap, null);
        } else if (uri == null) {
            return null;
        } else {
            Intrinsics.checkNotNullParameter(uuid, "callId");
            Intrinsics.checkNotNullParameter(uri, "attachmentUri");
            return new Attachment(uuid, null, uri);
        }
    }

    public static final List<String> getPhotoUrls(SharePhotoContent sharePhotoContent, UUID uuid) {
        Intrinsics.checkNotNullParameter(uuid, "appCallId");
        List<SharePhoto> list = sharePhotoContent.photos;
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (SharePhoto attachment : list) {
            Attachment attachment2 = getAttachment(uuid, attachment);
            if (attachment2 != null) {
                arrayList.add(attachment2);
            }
        }
        ArrayList arrayList2 = new ArrayList(TweetUtils.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((Attachment) it.next()).attachmentUrl);
        }
        NativeAppCallAttachmentStore.addAttachments(arrayList);
        return arrayList2;
    }

    public static final String getUriExtension(Uri uri) {
        String str = null;
        if (uri == null) {
            return null;
        }
        String uri2 = uri.toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "uri.toString()");
        int lastIndexOf$default = CharsKt__CharKt.lastIndexOf$default((CharSequence) uri2, '.', 0, false, 6);
        if (lastIndexOf$default != -1) {
            str = uri2.substring(lastIndexOf$default);
            Intrinsics.checkNotNullExpressionValue(str, "(this as java.lang.String).substring(startIndex)");
        }
        return str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0035 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0036  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean handleActivityResult(int r5, int r6, android.content.Intent r7, com.facebook.share.internal.ResultProcessor r8) {
        /*
            java.lang.Class<com.facebook.internal.NativeProtocol> r6 = com.facebook.internal.NativeProtocol.class
            com.facebook.internal.NativeProtocol r0 = com.facebook.internal.NativeProtocol.INSTANCE
            java.util.UUID r0 = com.facebook.internal.NativeProtocol.getCallIdFromIntent(r7)
            r1 = 0
            if (r0 != 0) goto L_0x000c
            goto L_0x0031
        L_0x000c:
            com.facebook.internal.AppCall$Companion r2 = com.facebook.internal.AppCall.Companion
            monitor-enter(r2)
            java.lang.String r3 = "callId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)     // Catch:{ all -> 0x00c1 }
            com.facebook.internal.AppCall r3 = r2.getCurrentPendingCall()     // Catch:{ all -> 0x00c1 }
            if (r3 == 0) goto L_0x0030
            java.util.UUID r4 = r3.getCallId()     // Catch:{ all -> 0x00c1 }
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r0)     // Catch:{ all -> 0x00c1 }
            if (r0 == 0) goto L_0x0030
            int r0 = r3.getRequestCode()     // Catch:{ all -> 0x00c1 }
            if (r0 == r5) goto L_0x002b
            goto L_0x0030
        L_0x002b:
            r2.setCurrentPendingCall(r1)     // Catch:{ all -> 0x00c1 }
            monitor-exit(r2)
            goto L_0x0032
        L_0x0030:
            monitor-exit(r2)
        L_0x0031:
            r3 = r1
        L_0x0032:
            r5 = 0
            if (r3 != 0) goto L_0x0036
            return r5
        L_0x0036:
            java.util.UUID r0 = r3.getCallId()
            java.lang.String r2 = "callId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)
            java.io.File r5 = com.facebook.internal.NativeAppCallAttachmentStore.getAttachmentsDirectoryForCall(r0, r5)
            if (r5 != 0) goto L_0x0046
            goto L_0x0049
        L_0x0046:
            kotlin.io.FilesKt__FileReadWriteKt.deleteRecursively(r5)
        L_0x0049:
            r5 = 1
            if (r8 != 0) goto L_0x004d
            return r5
        L_0x004d:
            if (r7 == 0) goto L_0x0081
            com.facebook.internal.NativeProtocol r0 = com.facebook.internal.NativeProtocol.INSTANCE
            boolean r0 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r6)
            if (r0 == 0) goto L_0x0059
        L_0x0057:
            r0 = r1
            goto L_0x007c
        L_0x0059:
            java.lang.String r0 = "resultIntent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)     // Catch:{ all -> 0x0077 }
            boolean r0 = com.facebook.internal.NativeProtocol.isErrorResult(r7)     // Catch:{ all -> 0x0077 }
            if (r0 != 0) goto L_0x0065
            goto L_0x0057
        L_0x0065:
            android.os.Bundle r0 = com.facebook.internal.NativeProtocol.getBridgeArgumentsFromIntent(r7)     // Catch:{ all -> 0x0077 }
            if (r0 == 0) goto L_0x0072
            java.lang.String r2 = "error"
            android.os.Bundle r0 = r0.getBundle(r2)     // Catch:{ all -> 0x0077 }
            goto L_0x007c
        L_0x0072:
            android.os.Bundle r0 = r7.getExtras()     // Catch:{ all -> 0x0077 }
            goto L_0x007c
        L_0x0077:
            r0 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r0, r6)
            goto L_0x0057
        L_0x007c:
            com.facebook.FacebookException r0 = com.facebook.internal.NativeProtocol.getExceptionFromErrorData(r0)
            goto L_0x0082
        L_0x0081:
            r0 = r1
        L_0x0082:
            if (r0 == 0) goto L_0x0090
            boolean r6 = r0 instanceof com.facebook.FacebookOperationCanceledException
            if (r6 == 0) goto L_0x008c
            r8.onCancel(r3)
            goto L_0x00c0
        L_0x008c:
            r8.onError(r3, r0)
            goto L_0x00c0
        L_0x0090:
            if (r7 == 0) goto L_0x00bd
            com.facebook.internal.NativeProtocol r0 = com.facebook.internal.NativeProtocol.INSTANCE
            boolean r0 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r6)
            if (r0 == 0) goto L_0x009b
            goto L_0x00bd
        L_0x009b:
            java.lang.String r0 = "resultIntent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)     // Catch:{ all -> 0x00b9 }
            int r0 = com.facebook.internal.NativeProtocol.getProtocolVersionFromIntent(r7)     // Catch:{ all -> 0x00b9 }
            android.os.Bundle r7 = r7.getExtras()     // Catch:{ all -> 0x00b9 }
            boolean r0 = com.facebook.internal.NativeProtocol.isVersionCompatibleWithBucketedIntent(r0)     // Catch:{ all -> 0x00b9 }
            if (r0 == 0) goto L_0x00b7
            if (r7 != 0) goto L_0x00b1
            goto L_0x00b7
        L_0x00b1:
            java.lang.String r0 = "com.facebook.platform.protocol.RESULT_ARGS"
            android.os.Bundle r7 = r7.getBundle(r0)     // Catch:{ all -> 0x00b9 }
        L_0x00b7:
            r1 = r7
            goto L_0x00bd
        L_0x00b9:
            r7 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r7, r6)
        L_0x00bd:
            r8.onSuccess(r3, r1)
        L_0x00c0:
            return r5
        L_0x00c1:
            r5 = move-exception
            monitor-exit(r2)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.share.internal.ShareInternalUtility.handleActivityResult(int, int, android.content.Intent, com.facebook.share.internal.ResultProcessor):boolean");
    }

    public static final void invokeOnCancelCallback(FacebookCallback<Sharer$Result> facebookCallback) {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        AppEventsLoggerImpl appEventsLoggerImpl = new AppEventsLoggerImpl(FacebookSdk.getApplicationContext(), (String) null, (AccessToken) null);
        Intrinsics.checkNotNullParameter(appEventsLoggerImpl, "loggerImpl");
        Bundle outline14 = GeneratedOutlineSupport.outline14("fb_share_dialog_outcome", "cancelled");
        FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            appEventsLoggerImpl.logEventImplicitly("fb_share_dialog_result", null, outline14);
        }
        if (facebookCallback != null) {
            facebookCallback.onCancel();
        }
    }

    public static final void invokeOnErrorCallback(FacebookCallback<Sharer$Result> facebookCallback, FacebookException facebookException) {
        Intrinsics.checkNotNullParameter(facebookException, "ex");
        String message = facebookException.getMessage();
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        AppEventsLoggerImpl appEventsLoggerImpl = new AppEventsLoggerImpl(FacebookSdk.getApplicationContext(), (String) null, (AccessToken) null);
        Intrinsics.checkNotNullParameter(appEventsLoggerImpl, "loggerImpl");
        Bundle outline14 = GeneratedOutlineSupport.outline14("fb_share_dialog_outcome", "error");
        if (message != null) {
            outline14.putString(PushMessageHelper.ERROR_MESSAGE, message);
        }
        FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            appEventsLoggerImpl.logEventImplicitly("fb_share_dialog_result", null, outline14);
        }
        if (facebookCallback != null) {
            facebookCallback.onError(facebookException);
        }
    }

    public static final GraphRequest newUploadStagingResourceWithImageRequest(AccessToken accessToken, Uri uri, Callback callback) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter(uri, "imageUri");
        String path = uri.getPath();
        if (Utility.isFileUri(uri) && path != null) {
            ParcelableResourceWithMimeType parcelableResourceWithMimeType = new ParcelableResourceWithMimeType(ParcelFileDescriptor.open(new File(path), ClientDefaults.MAX_MSG_SIZE), (String) "image/png");
            Bundle bundle = new Bundle(1);
            bundle.putParcelable("file", parcelableResourceWithMimeType);
            GraphRequest graphRequest = new GraphRequest(accessToken, "me/staging_resources", bundle, HttpMethod.POST, callback, null, 32);
            return graphRequest;
        } else if (Utility.isContentUri(uri)) {
            ParcelableResourceWithMimeType parcelableResourceWithMimeType2 = new ParcelableResourceWithMimeType(uri, (String) "image/png");
            Bundle bundle2 = new Bundle(1);
            bundle2.putParcelable("file", parcelableResourceWithMimeType2);
            GraphRequest graphRequest2 = new GraphRequest(accessToken, "me/staging_resources", bundle2, HttpMethod.POST, callback, null, 32);
            return graphRequest2;
        } else {
            throw new FacebookException((String) "The image Uri must be either a file:// or content:// Uri");
        }
    }

    public static final void registerSharerCallback(int i, CallbackManager callbackManager, FacebookCallback<Sharer$Result> facebookCallback) {
        if (callbackManager instanceof CallbackManagerImpl) {
            ((CallbackManagerImpl) callbackManager).registerCallback(i, new CallbackManagerImpl.Callback(i, facebookCallback) {
                public final /* synthetic */ int f$0;
                public final /* synthetic */ FacebookCallback f$1;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                }

                public final boolean onActivityResult(int i, Intent intent) {
                    return ShareInternalUtility.m83registerSharerCallback$lambda1(this.f$0, this.f$1, i, intent);
                }
            });
            return;
        }
        throw new FacebookException((String) "Unexpected CallbackManager, please use the provided Factory.");
    }

    /* renamed from: registerSharerCallback$lambda-1  reason: not valid java name */
    public static final boolean m83registerSharerCallback$lambda1(int i, FacebookCallback facebookCallback, int i2, Intent intent) {
        return handleActivityResult(i, i2, intent, new ShareInternalUtility$getShareResultProcessor$1(facebookCallback));
    }

    public static final void registerStaticShareCallback(int i) {
        CallbackManagerImpl.Companion.registerStaticCallback(i, new CallbackManagerImpl.Callback(i) {
            public final /* synthetic */ int f$0;

            {
                this.f$0 = r1;
            }

            public final boolean onActivityResult(int i, Intent intent) {
                return ShareInternalUtility.m84registerStaticShareCallback$lambda0(this.f$0, i, intent);
            }
        });
    }

    /* renamed from: registerStaticShareCallback$lambda-0  reason: not valid java name */
    public static final boolean m84registerStaticShareCallback$lambda0(int i, int i2, Intent intent) {
        return handleActivityResult(i, i2, intent, new ShareInternalUtility$getShareResultProcessor$1(null));
    }

    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r4v2 */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r4v6, types: [android.net.Uri] */
    /* JADX WARNING: type inference failed for: r1v4, types: [android.graphics.Bitmap] */
    /* JADX WARNING: type inference failed for: r4v8, types: [android.net.Uri] */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r4v9 */
    /* JADX WARNING: type inference failed for: r1v7 */
    /* JADX WARNING: type inference failed for: r4v10 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 4 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.facebook.internal.NativeAppCallAttachmentStore.Attachment getAttachment(java.util.UUID r3, com.facebook.share.model.ShareMedia<?, ?> r4) {
        /*
            boolean r0 = r4 instanceof com.facebook.share.model.SharePhoto
            r1 = 0
            if (r0 == 0) goto L_0x000c
            com.facebook.share.model.SharePhoto r4 = (com.facebook.share.model.SharePhoto) r4
            android.graphics.Bitmap r1 = r4.bitmap
            android.net.Uri r4 = r4.imageUrl
            goto L_0x0014
        L_0x000c:
            boolean r0 = r4 instanceof com.facebook.share.model.ShareVideo
            if (r0 == 0) goto L_0x0018
            com.facebook.share.model.ShareVideo r4 = (com.facebook.share.model.ShareVideo) r4
            android.net.Uri r4 = r4.localUrl
        L_0x0014:
            r2 = r1
            r1 = r4
            r4 = r2
            goto L_0x0019
        L_0x0018:
            r4 = r1
        L_0x0019:
            com.facebook.internal.NativeAppCallAttachmentStore$Attachment r3 = getAttachment(r3, r1, r4)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.share.internal.ShareInternalUtility.getAttachment(java.util.UUID, com.facebook.share.model.ShareMedia):com.facebook.internal.NativeAppCallAttachmentStore$Attachment");
    }
}
