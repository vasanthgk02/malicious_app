package androidx.navigation;

import android.content.Intent;
import android.net.Uri;
import com.android.tools.r8.GeneratedOutlineSupport;

public class NavDeepLinkRequest {
    public final String mAction;
    public final String mMimeType;
    public final Uri mUri;

    public NavDeepLinkRequest(Intent intent) {
        Uri data = intent.getData();
        String action = intent.getAction();
        String type = intent.getType();
        this.mUri = data;
        this.mAction = action;
        this.mMimeType = type;
    }

    public String toString() {
        StringBuilder outline78 = GeneratedOutlineSupport.outline78("NavDeepLinkRequest", "{");
        if (this.mUri != null) {
            outline78.append(" uri=");
            outline78.append(this.mUri.toString());
        }
        if (this.mAction != null) {
            outline78.append(" action=");
            outline78.append(this.mAction);
        }
        if (this.mMimeType != null) {
            outline78.append(" mimetype=");
            outline78.append(this.mMimeType);
        }
        outline78.append(" }");
        return outline78.toString();
    }
}
