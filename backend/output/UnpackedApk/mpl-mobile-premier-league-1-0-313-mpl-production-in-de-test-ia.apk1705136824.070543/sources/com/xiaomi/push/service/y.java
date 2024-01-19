package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.cd;
import com.xiaomi.push.dq;
import com.xiaomi.push.service.XMPushService.j;

public final class y extends j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ dq f4986a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ XMPushService f946a;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public y(int i, XMPushService xMPushService, dq dqVar) {
        // this.f946a = xMPushService;
        // this.f4986a = dqVar;
        super(i);
    }

    public String a() {
        return "send ack message for unrecognized new miui message.";
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m877a() {
        try {
            dq a2 = v.a((Context) this.f946a, this.f4986a);
            a2.a().a("miui_message_unrecognized", "1");
            ad.a(this.f946a, a2);
        } catch (cd e2) {
            b.a((Throwable) e2);
            this.f946a.a(10, (Exception) e2);
        }
    }
}
