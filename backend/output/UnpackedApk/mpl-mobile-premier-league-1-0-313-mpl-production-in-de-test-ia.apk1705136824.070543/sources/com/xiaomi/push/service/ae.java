package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.android.c;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.cz;
import com.xiaomi.push.df;
import com.xiaomi.push.dt;
import com.xiaomi.push.ee;
import com.xiaomi.push.service.bp.a;
import java.util.HashMap;
import java.util.Map;

public final class ae extends a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ XMPushService f4844a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ q f830a;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public ae(String str, long j, XMPushService xMPushService, q qVar) {
        // this.f4844a = xMPushService;
        // this.f830a = qVar;
        super(str, j);
    }

    public void a(bp bpVar) {
        String str;
        String a2 = bpVar.a((String) "GAID", (String) "gaid");
        String b2 = c.b((Context) this.f4844a);
        if (!c.a((Context) this.f4844a) && !TextUtils.isEmpty(a2)) {
            bpVar.a("GAID", "gaid", "");
            dt dtVar = new dt();
            dtVar.b(this.f830a.f4970d);
            dtVar.c(df.ClientInfoUpdate.f458a);
            dtVar.a(aw.a());
            dtVar.a((Map<String, String>) new HashMap<String,String>());
            dtVar.a().put("rm_gpid", "1");
            byte[] a3 = ee.a(ad.a(this.f4844a.getPackageName(), this.f830a.f4970d, dtVar, cz.Notification));
            XMPushService xMPushService = this.f4844a;
            xMPushService.a(xMPushService.getPackageName(), a3, true);
            str = "not low upload gpid";
        } else if (!TextUtils.isEmpty(b2) && !TextUtils.equals(a2, b2)) {
            bpVar.a("GAID", "gaid", b2);
            dt dtVar2 = new dt();
            dtVar2.b(this.f830a.f4970d);
            dtVar2.c(df.ClientInfoUpdate.f458a);
            dtVar2.a(aw.a());
            dtVar2.a((Map<String, String>) new HashMap<String,String>());
            dtVar2.a().put("gaid", b2);
            byte[] a4 = ee.a(ad.a(this.f4844a.getPackageName(), this.f830a.f4970d, dtVar2, cz.Notification));
            XMPushService xMPushService2 = this.f4844a;
            xMPushService2.a(xMPushService2.getPackageName(), a4, true);
            str = "upload gaid. ";
        } else {
            return;
        }
        b.b(str);
    }
}
