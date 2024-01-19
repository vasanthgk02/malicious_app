package com.facebook.share;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import com.facebook.FacebookCallback;
import com.facebook.FacebookRequestError;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.CallbackManagerImpl.Callback;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FacebookDialogBase.ModeHandler;
import com.facebook.internal.FragmentWrapper;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphContent;
import java.util.List;

@Deprecated
public class DeviceShareDialog extends FacebookDialogBase<ShareContent, Result> {
    public static final int DEFAULT_REQUEST_CODE = RequestCodeOffset.DeviceShare.toRequestCode();

    public static class Result {
    }

    public DeviceShareDialog(Activity activity) {
        super(activity, DEFAULT_REQUEST_CODE);
    }

    public /* bridge */ /* synthetic */ boolean canShowImpl(Object obj, Object obj2) {
        return canShowImpl((ShareContent) obj);
    }

    public AppCall createBaseAppCall() {
        return null;
    }

    public List<ModeHandler> getOrderedModeHandlers() {
        return null;
    }

    public void registerCallbackImpl(CallbackManagerImpl callbackManagerImpl, final FacebookCallback<Result> facebookCallback) {
        callbackManagerImpl.registerCallback(this.requestCodeField, new Callback(this) {
            public boolean onActivityResult(int i, Intent intent) {
                if (intent.hasExtra("error")) {
                    facebookCallback.onError(((FacebookRequestError) intent.getParcelableExtra("error")).exception);
                    return true;
                }
                facebookCallback.onSuccess(new Result());
                return true;
            }
        });
    }

    public /* bridge */ /* synthetic */ void showImpl(Object obj, Object obj2) {
        showImpl((ShareContent) obj);
    }

    public DeviceShareDialog(Fragment fragment) {
        super(new FragmentWrapper(fragment), DEFAULT_REQUEST_CODE);
    }

    public boolean canShowImpl(ShareContent shareContent) {
        return (shareContent instanceof ShareLinkContent) || (shareContent instanceof ShareOpenGraphContent);
    }

    /* JADX WARNING: type inference failed for: r6v0, types: [android.os.Parcelable, com.facebook.share.model.ShareContent] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void showImpl(com.facebook.share.model.ShareContent r6) {
        /*
            r5 = this;
            java.lang.Class<com.facebook.share.DeviceShareDialog> r0 = com.facebook.share.DeviceShareDialog.class
            if (r6 == 0) goto L_0x0085
            boolean r1 = r6 instanceof com.facebook.share.model.ShareLinkContent
            if (r1 != 0) goto L_0x0028
            boolean r1 = r6 instanceof com.facebook.share.model.ShareOpenGraphContent
            if (r1 == 0) goto L_0x000d
            goto L_0x0028
        L_0x000d:
            com.facebook.FacebookException r6 = new com.facebook.FacebookException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r0 = r0.getSimpleName()
            r1.append(r0)
            java.lang.String r0 = " only supports ShareLinkContent or ShareOpenGraphContent"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r6.<init>(r0)
            throw r6
        L_0x0028:
            android.content.Intent r1 = new android.content.Intent
            r1.<init>()
            android.content.Context r2 = com.facebook.FacebookSdk.getApplicationContext()
            java.lang.Class<com.facebook.FacebookActivity> r3 = com.facebook.FacebookActivity.class
            r1.setClass(r2, r3)
            java.lang.String r2 = "DeviceShareDialogFragment"
            r1.setAction(r2)
            java.lang.String r2 = "content"
            r1.putExtra(r2, r6)
            int r6 = r5.requestCodeField
            java.lang.String r2 = "intent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            android.app.Activity r2 = r5.getActivityContext()
            boolean r3 = r2 instanceof androidx.activity.result.ActivityResultRegistryOwner
            if (r3 == 0) goto L_0x0060
            androidx.activity.result.ActivityResultRegistryOwner r2 = (androidx.activity.result.ActivityResultRegistryOwner) r2
            androidx.activity.result.ActivityResultRegistry r2 = r2.getActivityResultRegistry()
            java.lang.String r3 = "activity as ActivityResultRegistryOwner).activityResultRegistry"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            com.facebook.CallbackManager r3 = r5.callbackManager
            com.facebook.internal.DialogPresenter.startActivityForResultWithAndroidX(r2, r3, r1, r6)
            goto L_0x006d
        L_0x0060:
            if (r2 == 0) goto L_0x0066
            r2.startActivityForResult(r1, r6)
            goto L_0x006d
        L_0x0066:
            com.facebook.internal.FragmentWrapper r2 = r5.fragmentWrapper
            if (r2 == 0) goto L_0x006f
            r2.startActivityForResult(r1, r6)
        L_0x006d:
            r6 = 0
            goto L_0x0071
        L_0x006f:
            java.lang.String r6 = "Failed to find Activity or Fragment to startActivityForResult "
        L_0x0071:
            if (r6 == 0) goto L_0x0084
            com.facebook.internal.Logger$Companion r1 = com.facebook.internal.Logger.Companion
            com.facebook.LoggingBehavior r2 = com.facebook.LoggingBehavior.DEVELOPER_ERRORS
            r3 = 6
            java.lang.String r0 = r0.getName()
            java.lang.String r4 = "this.javaClass.name"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r4)
            r1.log(r2, r3, r0, r6)
        L_0x0084:
            return
        L_0x0085:
            com.facebook.FacebookException r6 = new com.facebook.FacebookException
            java.lang.String r0 = "Must provide non-null content to share"
            r6.<init>(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.share.DeviceShareDialog.showImpl(com.facebook.share.model.ShareContent):void");
    }

    public DeviceShareDialog(androidx.fragment.app.Fragment fragment) {
        super(new FragmentWrapper(fragment), DEFAULT_REQUEST_CODE);
    }
}
