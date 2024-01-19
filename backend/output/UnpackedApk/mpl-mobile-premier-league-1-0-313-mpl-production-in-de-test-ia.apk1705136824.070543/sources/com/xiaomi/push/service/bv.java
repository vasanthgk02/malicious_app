package com.xiaomi.push.service;

import android.content.Context;
import android.util.Log;
import com.xiaomi.channel.commonutils.android.k;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.df;
import com.xiaomi.push.dt;
import com.xiaomi.push.o;
import com.xiaomi.push.service.XMPushService.n;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class bv implements n {

    /* renamed from: a  reason: collision with root package name */
    public static Context f4927a;

    /* renamed from: a  reason: collision with other field name */
    public static final Map<Integer, Map<String, List<String>>> f902a = new HashMap();

    /* renamed from: a  reason: collision with other field name */
    public static final boolean f903a = Log.isLoggable("UNDatas", 3);

    public bv(Context context) {
        f4927a = context;
    }

    public static dt a(String str, String str2, String str3, String str4) {
        dt dtVar = new dt();
        if (str3 != null) {
            dtVar.c(str3);
        }
        if (str != null) {
            dtVar.b(str);
        }
        if (str2 != null) {
            dtVar.a(str2);
        }
        if (str4 != null) {
            dtVar.d(str4);
        }
        dtVar.a(false);
        return dtVar;
    }

    public static void a(Context context, dt dtVar) {
        if (f903a) {
            b.b("UNDatas upload message notification:" + dtVar);
        }
        o.a(context).a((Runnable) new bw(dtVar));
    }

    public static void b() {
        HashMap hashMap = new HashMap();
        hashMap.putAll(f902a);
        if (hashMap.size() > 0) {
            for (Integer num : hashMap.keySet()) {
                Map map = (Map) hashMap.get(num);
                if (map != null && map.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    for (String str : map.keySet()) {
                        sb.append(str);
                        sb.append(":");
                        List list = (List) map.get(str);
                        if (!k.a(list)) {
                            for (int i = 0; i < list.size(); i++) {
                                if (i != 0) {
                                    sb.append(",");
                                }
                                sb.append((String) list.get(i));
                            }
                        }
                        sb.append(";");
                    }
                    dt a2 = a(null, aw.a(), df.NotificationRemoved.f458a, null);
                    a2.a("removed_reason", String.valueOf(num));
                    a2.a("all_delete_msgId_appId", sb.toString());
                    b.b("UNDatas upload all removed messages reason: " + num + " allIds: " + sb.toString());
                    a(f4927a, a2);
                }
                f902a.remove(num);
            }
        }
    }

    public void a() {
        if (f902a.size() > 0) {
            synchronized (f902a) {
                b();
            }
        }
    }
}
