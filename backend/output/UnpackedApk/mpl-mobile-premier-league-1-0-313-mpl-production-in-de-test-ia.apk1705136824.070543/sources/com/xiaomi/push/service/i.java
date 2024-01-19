package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.android.f;
import com.xiaomi.channel.commonutils.android.j;
import com.xiaomi.push.dt;

public class i {

    /* renamed from: a  reason: collision with root package name */
    public static a f4949a;

    /* renamed from: a  reason: collision with other field name */
    public static b f915a;

    public interface a {
        boolean a(dt dtVar);
    }

    public interface b {
    }

    public static void a(b bVar) {
        f915a = bVar;
    }

    public static boolean a(dt dtVar) {
        String str;
        if (f4949a == null || dtVar == null) {
            str = "rc params is null, not cpra";
        } else if (f.a(j.a())) {
            return f4949a.a(dtVar);
        } else {
            str = "rc app not permission to cpra";
        }
        com.xiaomi.channel.commonutils.logger.b.a(str);
        return false;
    }
}
