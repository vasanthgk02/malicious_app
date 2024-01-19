package com.facebook.internal;

import android.net.Uri;
import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/facebook/internal/InstagramCustomTab;", "Lcom/facebook/internal/CustomTab;", "action", "", "parameters", "Landroid/os/Bundle;", "(Ljava/lang/String;Landroid/os/Bundle;)V", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: InstagramCustomTab.kt */
public final class InstagramCustomTab extends CustomTab {
    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public InstagramCustomTab(String str, Bundle bundle) {
        Uri uri;
        // Intrinsics.checkNotNullParameter(str, "action");
        super(str, bundle);
        bundle = bundle == null ? new Bundle() : bundle;
        Intrinsics.checkNotNullParameter(str, "action");
        if (Intrinsics.areEqual(str, "oauth")) {
            uri = Utility.buildUri(ServerProtocol.getInstagramDialogAuthority(), "oauth/authorize", bundle);
        } else {
            String instagramDialogAuthority = ServerProtocol.getInstagramDialogAuthority();
            StringBuilder sb = new StringBuilder();
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            sb.append(FacebookSdk.getGraphApiVersion());
            sb.append("/dialog/");
            sb.append(str);
            uri = Utility.buildUri(instagramDialogAuthority, sb.toString(), bundle);
        }
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Intrinsics.checkNotNullParameter(uri, "<set-?>");
                this.uri = uri;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }
}
