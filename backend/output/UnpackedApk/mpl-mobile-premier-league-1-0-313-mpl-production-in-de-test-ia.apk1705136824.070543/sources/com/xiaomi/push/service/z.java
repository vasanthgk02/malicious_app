package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.cd;
import com.xiaomi.push.dq;
import com.xiaomi.push.service.XMPushService.j;

public final class z extends j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ dq f4987a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ XMPushService f947a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f948a;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public z(int i, XMPushService xMPushService, dq dqVar, String str) {
        // this.f947a = xMPushService;
        // this.f4987a = dqVar;
        // this.f948a = str;
        super(i);
    }

    public String a() {
        return "send app absent ack message for message.";
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m878a() {
        try {
            dq a2 = v.a((Context) this.f947a, this.f4987a);
            a2.a().a("absent_target_package", this.f948a);
            ad.a(this.f947a, a2);
        } catch (cd e2) {
            b.a((Throwable) e2);
            this.f947a.a(10, (Exception) e2);
        }
    }
}
