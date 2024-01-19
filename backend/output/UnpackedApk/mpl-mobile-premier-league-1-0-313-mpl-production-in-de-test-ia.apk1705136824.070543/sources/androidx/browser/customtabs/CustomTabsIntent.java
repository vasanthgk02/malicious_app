package androidx.browser.customtabs;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.core.content.ContextCompat;

public final class CustomTabsIntent {
    public final Intent intent;
    public final Bundle startAnimationBundle = null;

    public CustomTabsIntent(Intent intent2, Bundle bundle) {
        this.intent = intent2;
    }

    public void launchUrl(Context context, Uri uri) {
        this.intent.setData(uri);
        ContextCompat.startActivity(context, this.intent, this.startAnimationBundle);
    }
}
