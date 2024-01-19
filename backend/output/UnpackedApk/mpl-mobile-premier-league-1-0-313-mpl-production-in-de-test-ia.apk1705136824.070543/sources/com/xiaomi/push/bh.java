package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.push.au.c;
import com.xiaomi.push.service.az.b;
import java.util.HashMap;
import sfs2x.client.util.ClientDisconnectionReason;

public class bh {
    public static void a(b bVar, String str, bt btVar) {
        String str2;
        c cVar = new c();
        if (!TextUtils.isEmpty(bVar.f4882c)) {
            cVar.a(bVar.f4882c);
        }
        if (!TextUtils.isEmpty(bVar.f4884e)) {
            cVar.d(bVar.f4884e);
        }
        if (!TextUtils.isEmpty(bVar.f4885f)) {
            cVar.e(bVar.f4885f);
        }
        cVar.b(bVar.f871a ? "1" : "0");
        if (!TextUtils.isEmpty(bVar.f4883d)) {
            cVar.c(bVar.f4883d);
        } else {
            cVar.c("XIAOMI-SASL");
        }
        bi biVar = new bi();
        biVar.c(bVar.f872b);
        biVar.a(Integer.parseInt(bVar.g));
        biVar.b(bVar.f869a);
        biVar.a((String) "BIND", (String) null);
        biVar.a(biVar.e());
        com.xiaomi.channel.commonutils.logger.b.a("[Slim]: bind id=" + biVar.e());
        HashMap hashMap = new HashMap();
        hashMap.put("challenge", str);
        hashMap.put("token", bVar.f4882c);
        hashMap.put("chid", bVar.g);
        hashMap.put("from", bVar.f872b);
        hashMap.put("id", biVar.e());
        hashMap.put("to", "xiaomi.com");
        if (bVar.f871a) {
            hashMap.put(ClientDisconnectionReason.KICK, "1");
        } else {
            hashMap.put(ClientDisconnectionReason.KICK, "0");
        }
        if (!TextUtils.isEmpty(bVar.f4884e)) {
            hashMap.put("client_attrs", bVar.f4884e);
        } else {
            hashMap.put("client_attrs", "");
        }
        if (!TextUtils.isEmpty(bVar.f4885f)) {
            hashMap.put("cloud_attrs", bVar.f4885f);
        } else {
            hashMap.put("cloud_attrs", "");
        }
        if (bVar.f4883d.equals("XIAOMI-PASS") || bVar.f4883d.equals("XMPUSH-PASS")) {
            str2 = ab.a(bVar.f4883d, null, hashMap, bVar.h);
        } else {
            bVar.f4883d.equals("XIAOMI-SASL");
            str2 = null;
        }
        cVar.f(str2);
        biVar.a(cVar.a(), (String) null);
        btVar.b(biVar);
    }

    public static void a(String str, String str2, bt btVar) {
        bi biVar = new bi();
        biVar.c(str2);
        biVar.a(Integer.parseInt(str));
        biVar.a((String) "UBND", (String) null);
        btVar.b(biVar);
    }
}
