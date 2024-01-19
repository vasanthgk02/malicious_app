package com.freshchat.consumer.sdk.j;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.core.content.FileProvider;
import com.freshchat.consumer.sdk.b.c;
import java.io.File;

public class an {
    public static final String TAG = "com.freshchat.consumer.sdk.j.an";

    public static Intent a(Context context, File file) {
        Intent intent;
        Uri uri;
        if (file == null) {
            try {
                Intent intent2 = new Intent();
                intent2.putExtra("HAS_ERRORS", true);
                intent2.putExtra("ERROR_MESSAGE", c.PICTURE_ATTACHMENT_FAILED_NO_STORAGE_ACCESS.toString());
                return intent2;
            } catch (Exception e2) {
                intent = new Intent();
                intent.putExtra("HAS_ERRORS", true);
                q.a(e2);
            }
        } else {
            if (!aw.fc() || !g.am(context)) {
                uri = Uri.fromFile(file);
            } else if (!g.al(context)) {
                Intent intent3 = new Intent();
                intent3.putExtra("HAS_ERRORS", true);
                intent3.putExtra("ERROR_MESSAGE", c.PICTURE_ATTACHMENT_FAILED_BAD_AUTHORITY.toString());
                return intent3;
            } else {
                uri = FileProvider.getUriForFile(context, g.aj(context), file);
            }
            intent = new Intent("android.media.action.IMAGE_CAPTURE");
            intent.putExtra("output", uri);
            return intent;
        }
    }
}
