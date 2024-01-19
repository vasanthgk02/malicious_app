package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.cd;
import com.xiaomi.push.dq;
import com.xiaomi.push.service.XMPushService.j;

public final class x extends j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ dq f4985a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ XMPushService f945a;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public x(int i, XMPushService xMPushService, dq dqVar) {
        // this.f945a = xMPushService;
        // this.f4985a = dqVar;
        super(i);
    }

    public String a() {
        return "send ack message for obsleted message.";
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m876a() {
        try {
            dq a2 = v.a((Context) this.f945a, this.f4985a);
            a2.a().a("message_obsleted", "1");
            ad.a(this.f945a, a2);
        } catch (cd e2) {
            b.a((Throwable) e2);
            this.f945a.a(10, (Exception) e2);
        }
    }
}
