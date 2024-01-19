package com.facebook.internal;

import android.net.Uri;
import android.os.Bundle;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.FacebookSdk;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/facebook/internal/CustomTab;", "", "action", "", "parameters", "Landroid/os/Bundle;", "(Ljava/lang/String;Landroid/os/Bundle;)V", "uri", "Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", "setUri", "(Landroid/net/Uri;)V", "openCustomTab", "", "activity", "Landroid/app/Activity;", "packageName", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: CustomTab.kt */
public class CustomTab {
    public Uri uri;

    public CustomTab(String str, Bundle bundle) {
        Uri uri2;
        Intrinsics.checkNotNullParameter(str, "action");
        bundle = bundle == null ? new Bundle() : bundle;
        GamingAction[] values = GamingAction.values();
        ArrayList arrayList = new ArrayList(values.length);
        for (GamingAction rawValue : values) {
            arrayList.add(rawValue.getRawValue());
        }
        if (arrayList.contains(str)) {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            uri2 = Utility.buildUri(GeneratedOutlineSupport.outline70(new Object[]{"fb.gg"}, 1, "%s", "java.lang.String.format(format, *args)"), Intrinsics.stringPlus("/dialog/", str), bundle);
        } else {
            Intrinsics.checkNotNullParameter(str, "action");
            String dialogAuthority = ServerProtocol.getDialogAuthority();
            StringBuilder sb = new StringBuilder();
            FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
            sb.append(FacebookSdk.getGraphApiVersion());
            sb.append("/dialog/");
            sb.append(str);
            uri2 = Utility.buildUri(dialogAuthority, sb.toString(), bundle);
        }
        this.uri = uri2;
    }
}
