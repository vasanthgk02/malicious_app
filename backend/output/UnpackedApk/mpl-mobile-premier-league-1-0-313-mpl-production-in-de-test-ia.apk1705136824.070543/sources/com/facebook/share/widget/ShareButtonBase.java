package com.facebook.share.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.CallbackManager;
import com.facebook.FacebookButtonBase;
import com.facebook.FacebookSdk;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.share.Sharer$Result;
import com.facebook.share.model.ShareContent;

public abstract class ShareButtonBase extends FacebookButtonBase {
    public boolean enabledExplicitlySet = false;
    public int requestCode = 0;
    public ShareContent shareContent;

    public ShareButtonBase(Context context, AttributeSet attributeSet, int i, String str, String str2) {
        super(context, attributeSet, i, 0, str, str2);
        this.requestCode = isInEditMode() ? 0 : getDefaultRequestCode();
        setEnabled(false);
        this.enabledExplicitlySet = false;
    }

    public void configureButton(Context context, AttributeSet attributeSet, int i, int i2) {
        super.configureButton(context, attributeSet, i, i2);
        setInternalOnClickListener(getShareOnClickListener());
    }

    public CallbackManager getCallbackManager() {
        return null;
    }

    public abstract FacebookDialogBase<ShareContent, Sharer$Result> getDialog();

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
                        ShareButtonBase.this.callExternalOnClickListener(view);
                        ShareButtonBase.this.getDialog().showImpl(ShareButtonBase.this.getShareContent(), FacebookDialogBase.BASE_AUTOMATIC_MODE);
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

    public void setRequestCode(int i) {
        if (!FacebookSdk.isFacebookRequestCode(i)) {
            this.requestCode = i;
            return;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline42("Request code ", i, " cannot be within the range reserved by the Facebook SDK."));
    }

    public void setShareContent(ShareContent shareContent2) {
        this.shareContent = shareContent2;
        if (!this.enabledExplicitlySet) {
            setEnabled(getDialog().canShow(getShareContent()));
            this.enabledExplicitlySet = false;
        }
    }
}
