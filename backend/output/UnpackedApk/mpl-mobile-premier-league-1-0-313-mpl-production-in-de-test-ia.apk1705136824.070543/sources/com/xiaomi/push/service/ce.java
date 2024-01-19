package com.xiaomi.push.service;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.xiaomi.push.au.b;
import com.xiaomi.push.bu;
import com.xiaomi.push.bw;
import java.util.Map;

public class ce extends bu {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ XMPushService f4937a;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public ce(XMPushService xMPushService, Map map, int i, String str, bw bwVar) {
        // this.f4937a = xMPushService;
        super(map, i, str, bwVar);
    }

    public byte[] a() {
        try {
            b bVar = new b();
            bVar.a(bn.a().a());
            return bVar.a();
        } catch (Exception e2) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("getOBBString err: ");
            outline73.append(e2.toString());
            com.xiaomi.channel.commonutils.logger.b.a(outline73.toString());
            return null;
        }
    }
}
