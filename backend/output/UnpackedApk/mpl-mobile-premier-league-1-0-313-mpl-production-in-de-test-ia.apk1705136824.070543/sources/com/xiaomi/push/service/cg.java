package com.xiaomi.push.service;

import android.database.ContentObserver;
import android.os.Handler;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.XMPushService.g;
import com.xiaomi.push.service.XMPushService.j;

public class cg extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ XMPushService f4939a;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public cg(XMPushService xMPushService, Handler handler) {
        // this.f4939a = xMPushService;
        super(handler);
    }

    public void onChange(boolean z) {
        super.onChange(z);
        boolean a2 = XMPushService.a(this.f4939a);
        b.a("SuperPowerMode:" + a2);
        XMPushService.a(this.f4939a);
        if (a2) {
            XMPushService xMPushService = this.f4939a;
            xMPushService.a((j) new g(24, null));
            return;
        }
        this.f4939a.a(true);
    }
}
