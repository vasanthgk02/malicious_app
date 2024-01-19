package com.facebook.login.widget;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.login.DeviceLoginManager;
import com.facebook.login.LoginBehavior;
import com.facebook.login.LoginManager;
import com.facebook.login.widget.LoginButton.LoginClickListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0015B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\tB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0011\u001a\u00060\u0012R\u00020\u00018TX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/facebook/login/widget/DeviceLoginButton;", "Lcom/facebook/login/widget/LoginButton;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "deviceRedirectUri", "Landroid/net/Uri;", "getDeviceRedirectUri", "()Landroid/net/Uri;", "setDeviceRedirectUri", "(Landroid/net/Uri;)V", "newLoginClickListener", "Lcom/facebook/login/widget/LoginButton$LoginClickListener;", "getNewLoginClickListener", "()Lcom/facebook/login/widget/LoginButton$LoginClickListener;", "DeviceLoginClickListener", "facebook-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: DeviceLoginButton.kt */
public final class DeviceLoginButton extends LoginButton {
    public Uri deviceRedirectUri;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0014¨\u0006\u0006"}, d2 = {"Lcom/facebook/login/widget/DeviceLoginButton$DeviceLoginClickListener;", "Lcom/facebook/login/widget/LoginButton$LoginClickListener;", "Lcom/facebook/login/widget/LoginButton;", "(Lcom/facebook/login/widget/DeviceLoginButton;)V", "getLoginManager", "Lcom/facebook/login/LoginManager;", "facebook-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: DeviceLoginButton.kt */
    public final class DeviceLoginClickListener extends LoginClickListener {
        public final /* synthetic */ DeviceLoginButton this$0;

        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        public DeviceLoginClickListener(DeviceLoginButton deviceLoginButton) {
            // Intrinsics.checkNotNullParameter(deviceLoginButton, "this$0");
            // this.this$0 = deviceLoginButton;
            super(deviceLoginButton);
        }

        public LoginManager getLoginManager() {
            DeviceLoginManager deviceLoginManager;
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return null;
            }
            try {
                if (DeviceLoginManager.Companion != null) {
                    deviceLoginManager = (DeviceLoginManager) DeviceLoginManager.access$getInstance$delegate$cp().getValue();
                    deviceLoginManager.setDefaultAudience(this.this$0.getDefaultAudience());
                    deviceLoginManager.setLoginBehavior(LoginBehavior.DEVICE_AUTH);
                    Uri deviceRedirectUri = this.this$0.getDeviceRedirectUri();
                    if (!CrashShieldHandler.isObjectCrashing(deviceLoginManager)) {
                        deviceLoginManager.deviceRedirectUri = deviceRedirectUri;
                    }
                    return deviceLoginManager;
                }
                throw null;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
                return null;
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public DeviceLoginButton(Context context, AttributeSet attributeSet, int i) {
        // Intrinsics.checkNotNullParameter(context, "context");
        // Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        super(context, attributeSet, i);
    }

    public final Uri getDeviceRedirectUri() {
        return this.deviceRedirectUri;
    }

    public LoginClickListener getNewLoginClickListener() {
        return new DeviceLoginClickListener(this);
    }

    public final void setDeviceRedirectUri(Uri uri) {
        this.deviceRedirectUri = uri;
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public DeviceLoginButton(Context context, AttributeSet attributeSet) {
        // Intrinsics.checkNotNullParameter(context, "context");
        // Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        super(context, attributeSet);
    }
}
