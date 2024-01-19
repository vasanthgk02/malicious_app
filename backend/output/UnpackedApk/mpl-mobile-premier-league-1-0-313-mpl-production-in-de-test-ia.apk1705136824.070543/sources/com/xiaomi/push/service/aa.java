package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.cd;
import com.xiaomi.push.dq;
import com.xiaomi.push.service.XMPushService.j;

public final class aa extends j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ dq f4840a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ XMPushService f825a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f826a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f4841b;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public aa(int i, XMPushService xMPushService, dq dqVar, String str, String str2) {
        // this.f825a = xMPushService;
        // this.f4840a = dqVar;
        // this.f826a = str;
        // this.f4841b = str2;
        super(i);
    }

    public String a() {
        return "send wrong message ack for message.";
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m786a() {
        try {
            dq a2 = v.a((Context) this.f825a, this.f4840a);
            a2.f577a.a("error", this.f826a);
            a2.f577a.a("reason", this.f4841b);
            ad.a(this.f825a, a2);
        } catch (cd e2) {
            b.a((Throwable) e2);
            this.f825a.a(10, (Exception) e2);
        }
    }
}
