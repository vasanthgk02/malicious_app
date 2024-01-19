package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.support.customtabs.ICustomTabsCallback;
import android.support.customtabs.ICustomTabsService;

public final class CustomTabsSession {
    public final ICustomTabsCallback mCallback;
    public final ComponentName mComponentName;
    public final PendingIntent mId;
    public final ICustomTabsService mService;

    public CustomTabsSession(ICustomTabsService iCustomTabsService, ICustomTabsCallback iCustomTabsCallback, ComponentName componentName, PendingIntent pendingIntent) {
        this.mService = iCustomTabsService;
        this.mCallback = iCustomTabsCallback;
        this.mComponentName = componentName;
        this.mId = pendingIntent;
    }
}
