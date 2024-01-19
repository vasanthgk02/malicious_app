package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.bi;
import com.xiaomi.push.cd;
import com.xiaomi.push.service.XMPushService.j;

public class bl extends j {

    /* renamed from: a  reason: collision with root package name */
    public bi f4917a;

    /* renamed from: a  reason: collision with other field name */
    public XMPushService f887a = null;

    public bl(XMPushService xMPushService, bi biVar) {
        super(4);
        this.f887a = xMPushService;
        this.f4917a = biVar;
    }

    public String a() {
        return "send a message.";
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m836a() {
        try {
            if (this.f4917a != null) {
                this.f887a.a(this.f4917a);
            }
        } catch (cd e2) {
            b.a((Throwable) e2);
            this.f887a.a(10, (Exception) e2);
        }
    }
}
