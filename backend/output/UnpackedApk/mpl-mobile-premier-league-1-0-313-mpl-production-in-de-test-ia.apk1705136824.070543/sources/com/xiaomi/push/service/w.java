package com.xiaomi.push.service;

import com.xiaomi.push.dq;
import com.xiaomi.push.service.XMPushService.j;

public final class w extends j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ dq f4984a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ XMPushService f944a;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public w(int i, XMPushService xMPushService, dq dqVar) {
        // this.f944a = xMPushService;
        // this.f4984a = dqVar;
        super(i);
    }

    public String a() {
        return "send ack message for message.";
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:1|2|(2:4|5)|6|7|11) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0011 */
    /* renamed from: a  reason: collision with other method in class */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m875a() {
        /*
            r3 = this;
            r0 = 0
            com.xiaomi.push.service.XMPushService r1 = r3.f944a     // Catch:{ cd -> 0x001f }
            boolean r1 = com.xiaomi.channel.commonutils.android.f.a(r1)     // Catch:{ cd -> 0x001f }
            if (r1 == 0) goto L_0x0011
            com.xiaomi.push.service.XMPushService r1 = r3.f944a     // Catch:{ all -> 0x0011 }
            com.xiaomi.push.dq r2 = r3.f4984a     // Catch:{ all -> 0x0011 }
            java.util.Map r0 = com.xiaomi.push.service.ac.a(r1, r2)     // Catch:{ all -> 0x0011 }
        L_0x0011:
            com.xiaomi.push.service.XMPushService r1 = r3.f944a     // Catch:{ cd -> 0x001f }
            com.xiaomi.push.dq r2 = r3.f4984a     // Catch:{ cd -> 0x001f }
            com.xiaomi.push.dq r0 = com.xiaomi.push.service.v.a(r1, r2, r0)     // Catch:{ cd -> 0x001f }
            com.xiaomi.push.service.XMPushService r1 = r3.f944a     // Catch:{ cd -> 0x001f }
            com.xiaomi.push.service.ad.a(r1, r0)     // Catch:{ cd -> 0x001f }
            goto L_0x002a
        L_0x001f:
            r0 = move-exception
            com.xiaomi.channel.commonutils.logger.b.a(r0)
            com.xiaomi.push.service.XMPushService r1 = r3.f944a
            r2 = 10
            r1.a(r2, r0)
        L_0x002a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.w.m875a():void");
    }
}
