package com.xiaomi.push.service;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.xiaomi.push.cz;
import com.xiaomi.push.dt;
import com.xiaomi.push.ee;
import com.xiaomi.push.o.a;
import java.lang.ref.WeakReference;

public class b extends a {

    /* renamed from: a  reason: collision with root package name */
    public dt f4894a;

    /* renamed from: a  reason: collision with other field name */
    public WeakReference<XMPushService> f878a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f879a = false;

    public b(dt dtVar, WeakReference<XMPushService> weakReference, boolean z) {
        this.f4894a = dtVar;
        this.f878a = weakReference;
        this.f879a = z;
    }

    public String a() {
        return "22";
    }

    public void run() {
        WeakReference<XMPushService> weakReference = this.f878a;
        if (!(weakReference == null || this.f4894a == null)) {
            XMPushService xMPushService = (XMPushService) weakReference.get();
            if (xMPushService != null) {
                this.f4894a.a(aw.a());
                this.f4894a.a(false);
                com.xiaomi.channel.commonutils.logger.b.c("MoleInfo aw_ping : send aw_Ping msg " + this.f4894a.a());
                try {
                    String c2 = this.f4894a.c();
                    xMPushService.a(c2, ee.a(ad.a(c2, this.f4894a.b(), this.f4894a, cz.Notification)), this.f879a);
                } catch (Exception e2) {
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("MoleInfo aw_ping : send help app ping error");
                    outline73.append(e2.toString());
                    com.xiaomi.channel.commonutils.logger.b.d(outline73.toString());
                }
            }
        }
    }
}
