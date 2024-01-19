package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.cd;
import com.xiaomi.push.cz;
import com.xiaomi.push.df;
import com.xiaomi.push.dm;
import com.xiaomi.push.dq;
import com.xiaomi.push.dt;
import com.xiaomi.push.service.XMPushService.j;

public final class ab extends j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ dq f4842a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ dt f827a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ XMPushService f828a;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public ab(int i, dt dtVar, dq dqVar, XMPushService xMPushService) {
        // this.f827a = dtVar;
        // this.f4842a = dqVar;
        // this.f828a = xMPushService;
        super(i);
    }

    public String a() {
        return "send ack message for clear push message.";
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m787a() {
        try {
            dm dmVar = new dm();
            dmVar.c(df.CancelPushMessageACK.f458a);
            dmVar.a(this.f827a.a());
            dmVar.a(this.f827a.a());
            dmVar.b(this.f827a.b());
            dmVar.e(this.f827a.c());
            dmVar.a(0);
            dmVar.d("success clear push message.");
            ad.a(this.f828a, ad.b(this.f4842a.b(), this.f4842a.a(), dmVar, cz.Notification));
        } catch (cd e2) {
            b.d("clear push message. " + e2);
            this.f828a.a(10, (Exception) e2);
        }
    }
}
