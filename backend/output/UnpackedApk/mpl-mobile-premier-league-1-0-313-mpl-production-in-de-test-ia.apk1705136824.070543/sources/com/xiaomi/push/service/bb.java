package com.xiaomi.push.service;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.XMPushService.j;
import com.xiaomi.push.service.az.b.c;

public class bb extends j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c f4896a;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public bb(c cVar, int i) {
        // this.f4896a = cVar;
        super(i);
    }

    public String a() {
        return "clear peer job";
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m830a() {
        c cVar = this.f4896a;
        if (cVar.f4889a == cVar.f876a.f863a) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("clean peer, chid = ");
            outline73.append(this.f4896a.f876a.g);
            b.b(outline73.toString());
            this.f4896a.f876a.f863a = null;
        }
    }
}
