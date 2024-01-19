package com.shield.android.c;

import android.content.Context;
import android.database.Cursor;
import android.os.Environment;
import android.provider.MediaStore.Images.Media;
import com.netcore.android.SMTConfigConstants;

public class e extends f {

    /* renamed from: b  reason: collision with root package name */
    public final Context f1516b;

    public e(Context context) {
        this.f1516b = context;
    }

    public String a(Context context) {
        if (!(context.checkCallingOrSelfPermission(SMTConfigConstants.READ_STORAGE_PERMISSION_MF_KEY) == 0)) {
            return "disabled";
        }
        try {
            Cursor query = context.getContentResolver().query(Media.EXTERNAL_CONTENT_URI, new String[]{"_data"}, "bucket_id = ?", new String[]{String.valueOf((Environment.getExternalStorageDirectory().toString() + "/DCIM/Camera").toLowerCase().hashCode())}, null);
            int count = query.getCount();
            query.close();
            return String.valueOf(count);
        } catch (Exception unused) {
            return "error";
        }
    }
}
