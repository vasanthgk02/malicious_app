package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.bi;
import com.xiaomi.push.cd;
import com.xiaomi.push.service.XMPushService.j;

public class c extends j {

    /* renamed from: a  reason: collision with root package name */
    public XMPushService f4932a = null;

    /* renamed from: a  reason: collision with other field name */
    public bi[] f906a;

    public c(XMPushService xMPushService, bi[] biVarArr) {
        super(4);
        this.f4932a = xMPushService;
        this.f906a = biVarArr;
    }

    public String a() {
        return "batch send message.";
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m844a() {
        try {
            if (this.f906a != null) {
                this.f4932a.a(this.f906a);
            }
        } catch (cd e2) {
            b.a((Throwable) e2);
            this.f4932a.a(10, (Exception) e2);
        }
    }
}
