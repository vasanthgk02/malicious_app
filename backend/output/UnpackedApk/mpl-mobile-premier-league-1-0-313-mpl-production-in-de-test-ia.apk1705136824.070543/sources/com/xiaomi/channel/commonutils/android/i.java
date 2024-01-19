package com.xiaomi.channel.commonutils.android;

import com.mpl.androidapp.utils.Constant;
import com.xiaomi.channel.commonutils.logger.b;

public class i {
    public static String a(String str, String str2) {
        Class<String> cls = String.class;
        try {
            return (String) j.a(null, "android.os.SystemProperties").getMethod(Constant.GET, new Class[]{cls, cls}).invoke(null, new Object[]{str, str2});
        } catch (Exception e2) {
            b.a("SystemProperties.get: " + e2);
            return str2;
        }
    }
}
