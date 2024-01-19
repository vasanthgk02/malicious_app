package com.facebook.share.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.FacebookButtonBase;
import com.facebook.FacebookSdk;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.share.DeviceShareDialog;
import com.facebook.share.R$style;
import com.facebook.share.model.ShareContent;

@Deprecated
public final class DeviceShareButton extends FacebookButtonBase {
    public DeviceShareDialog dialog = null;
    public boolean enabledExplicitlySet = false;
    public int requestCode = 0;
    public ShareContent shareContent;

    public DeviceShareButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, 0, "fb_device_share_button_create", "fb_device_share_button_did_tap");
        this.requestCode = isInEditMode() ? 0 : getDefaultRequestCode();
        setEnabled(false);
        this.enabledExplicitlySet = false;
    }

    /* access modifiers changed from: private */
    public DeviceShareDialog getDialog() {
        DeviceShareDialog deviceShareDialog = this.dialog;
        if (deviceShareDialog != null) {
            return deviceShareDialog;
        }
        if (getFragment() != null) {
            this.dialog = new DeviceShareDialog(getFragment());
        } else if (getNativeFragment() != null) {
            this.dialog = new DeviceShareDialog(getNativeFragment());
        } else {
            this.dialog = new DeviceShareDialog(getActivity());
        }
        return this.dialog;
    }

    private void setRequestCode(int i) {
        if (!FacebookSdk.isFacebookRequestCode(i)) {
            this.requestCode = i;
            return;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline42("Request code ", i, " cannot be within the range reserved by the Facebook SDK."));
    }

    public void configureButton(Context context, AttributeSet attributeSet, int i, int i2) {
        super.configureButton(context, attributeSet, i, i2);
        setInternalOnClickListener(getShareOnClickListener());
    }

    public int getDefaultRequestCode() {
        return RequestCodeOffset.Share.toRequestCode();
    }

    public int getDefaultStyleResource() {
        return R$style.com_facebook_button_share;
    }

    public int getRequestCode() {
        return this.requestCode;
    }

    public ShareContent getShareContent() {
        return this.shareContent;
    }

    public OnClickListener getShareOnClickListener() {
        return new OnClickListener() {
            public void onClick(View view) {
                if (!CrashShieldHandler.isObjectCrashing(this)) {
                    try {
                        DeviceShareButton.this.callExternalOnClickListener(view);
                        DeviceShareButton.this.getDialog().showImpl(DeviceShareButton.this.getShareContent(), FacebookDialogBase.BASE_AUTOMATIC_MODE);
                    } catch (Throwable th) {
                        CrashShieldHandler.handleThrowable(th, this);
                    }
                }
            }
        };
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.enabledExplicitlySet = true;
    }

    public void setShareContent(ShareContent shareContent2) {
        this.shareContent = shareContent2;
        if (!this.enabledExplicitlySet) {
            setEnabled(new DeviceShareDialog(getActivity()).canShow(getShareContent()));
            this.enabledExplicitlySet = false;
        }
    }
}
