package androidx.browser.customtabs;

import android.net.Uri;
import android.os.Bundle;

public class CustomTabsCallback {
    public abstract void extraCallback(String str, Bundle bundle);

    public abstract Bundle extraCallbackWithResult(String str, Bundle bundle);

    public abstract void onMessageChannelReady(Bundle bundle);

    public abstract void onNavigationEvent(int i, Bundle bundle);

    public abstract void onPostMessage(String str, Bundle bundle);

    public abstract void onRelationshipValidationResult(int i, Uri uri, boolean z, Bundle bundle);
}
