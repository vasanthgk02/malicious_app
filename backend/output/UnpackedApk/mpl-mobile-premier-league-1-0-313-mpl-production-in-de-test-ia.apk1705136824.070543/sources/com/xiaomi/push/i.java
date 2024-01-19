package com.xiaomi.push;

import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.squareup.picasso.Utils;
import com.xiaomi.channel.commonutils.logger.b;
import java.io.File;

public class i {
    public static long a() {
        if (b()) {
            return 0;
        }
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory != null && !TextUtils.isEmpty(externalStorageDirectory.getPath())) {
            try {
                StatFs statFs = new StatFs(externalStorageDirectory.getPath());
                return (((long) statFs.getAvailableBlocks()) - 4) * ((long) statFs.getBlockSize());
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m748a() {
        try {
            return Environment.getExternalStorageState().equals(Utils.VERB_REMOVED);
        } catch (Exception e2) {
            b.a((Throwable) e2);
            return true;
        }
    }

    public static boolean b() {
        try {
            return true ^ Environment.getExternalStorageState().equals("mounted");
        } catch (Exception e2) {
            "check SDCard is busy: " + e2;
            return true;
        }
    }

    public static boolean c() {
        return a() <= 102400;
    }

    public static boolean d() {
        return !b() && !c() && !a();
    }
}
