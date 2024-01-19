package com.facebook.share.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.fragment.app.Fragment;
import com.facebook.common.R$drawable;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FragmentWrapper;
import com.facebook.share.R$style;
import com.facebook.share.Sharer$Result;
import com.facebook.share.model.ShareContent;
import kotlin.jvm.internal.Intrinsics;

public final class ShareButton extends ShareButtonBase {
    public ShareButton(Context context) {
        super(context, null, 0, "fb_share_button_create", "fb_share_button_did_tap");
    }

    public void configureButton(Context context, AttributeSet attributeSet, int i, int i2) {
        super.configureButton(context, attributeSet, i, i2);
        setCompoundDrawablesWithIntrinsicBounds(AppCompatResources.getDrawable(getContext(), R$drawable.com_facebook_button_icon), null, null, null);
    }

    public int getDefaultRequestCode() {
        return RequestCodeOffset.Share.toRequestCode();
    }

    public int getDefaultStyleResource() {
        return R$style.com_facebook_button_share;
    }

    public FacebookDialogBase<ShareContent, Sharer$Result> getDialog() {
        ShareDialog shareDialog;
        if (getFragment() != null) {
            Fragment fragment = getFragment();
            int requestCode = getRequestCode();
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            shareDialog = new ShareDialog(new FragmentWrapper(fragment), requestCode);
        } else if (getNativeFragment() != null) {
            android.app.Fragment nativeFragment = getNativeFragment();
            int requestCode2 = getRequestCode();
            Intrinsics.checkNotNullParameter(nativeFragment, "fragment");
            shareDialog = new ShareDialog(new FragmentWrapper(nativeFragment), requestCode2);
        } else {
            shareDialog = new ShareDialog(getActivity(), getRequestCode());
        }
        shareDialog.callbackManager = getCallbackManager();
        return shareDialog;
    }

    public ShareButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, "fb_share_button_create", "fb_share_button_did_tap");
    }

    public ShareButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, "fb_share_button_create", "fb_share_button_did_tap");
    }
}
