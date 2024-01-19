package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService.j;
import com.xiaomi.push.service.az.b;
import com.xiaomi.push.service.az.b.c;

public class bc extends j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c f4897a;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public bc(c cVar, int i) {
        // this.f4897a = cVar;
        super(i);
    }

    public String a() {
        return "check peer job";
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m831a() {
        az a2 = az.a();
        b bVar = this.f4897a.f876a;
        if (a2.a(bVar.g, bVar.f872b).f863a == null) {
            XMPushService a3 = b.a(b.this);
            b bVar2 = this.f4897a.f876a;
            a3.a(bVar2.g, bVar2.f872b, 2, null, null);
        }
    }
}
