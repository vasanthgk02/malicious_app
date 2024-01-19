package com.facebook.share.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.share.R$style;
import com.facebook.share.Sharer$Result;
import com.facebook.share.model.ShareContent;

@Deprecated
public final class SendButton extends ShareButtonBase {
    public SendButton(Context context) {
        super(context, null, 0, "fb_send_button_create", "fb_send_button_did_tap");
    }

    public int getDefaultRequestCode() {
        return RequestCodeOffset.Message.toRequestCode();
    }

    public int getDefaultStyleResource() {
        return R$style.com_facebook_button_send;
    }

    public FacebookDialogBase<ShareContent, Sharer$Result> getDialog() {
        MessageDialog messageDialog;
        if (getFragment() != null) {
            messageDialog = new MessageDialog(getFragment(), getRequestCode());
        } else if (getNativeFragment() != null) {
            messageDialog = new MessageDialog(getNativeFragment(), getRequestCode());
        } else {
            messageDialog = new MessageDialog(getActivity(), getRequestCode());
        }
        messageDialog.callbackManager = getCallbackManager();
        return messageDialog;
    }

    public SendButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, "fb_send_button_create", "fb_send_button_did_tap");
    }

    public SendButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, "fb_send_button_create", "fb_send_button_did_tap");
    }
}
