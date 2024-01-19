package defpackage;

import android.content.Context;
import android.net.Uri;
import com.amazon.identity.auth.device.interactive.InteractiveRequestRecord;

/* renamed from: bo  reason: default package */
public interface bo {
    void onRequestCompletion(Context context, InteractiveRequestRecord interactiveRequestRecord, Uri uri);
}
