package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResult;

public final class ActivityResultContracts$StartActivityForResult extends ActivityResultContract<Intent, ActivityResult> {
    public Intent createIntent(Context context, Object obj) {
        return (Intent) obj;
    }

    public Object parseResult(int i, Intent intent) {
        return new ActivityResult(i, intent);
    }
}
