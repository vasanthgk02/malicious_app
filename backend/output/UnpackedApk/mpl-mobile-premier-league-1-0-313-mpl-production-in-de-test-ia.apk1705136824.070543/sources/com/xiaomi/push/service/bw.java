package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.cz;
import com.xiaomi.push.dt;
import com.xiaomi.push.ee;

public final class bw implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ dt f4928a;

    public bw(dt dtVar) {
        this.f4928a = dtVar;
    }

    public void run() {
        byte[] a2 = ee.a(ad.a(this.f4928a.c(), this.f4928a.b(), this.f4928a, cz.Notification));
        if (bv.a() instanceof XMPushService) {
            ((XMPushService) bv.a()).a(this.f4928a.c(), a2, true);
        } else {
            b.a((String) "UNDatas UploadNotificationDatas failed because not xmsf");
        }
    }
}
