package com.xiaomi.push.service;

import com.xiaomi.push.bi;
import com.xiaomi.push.cj;
import com.xiaomi.push.service.XMPushService.d;
import com.xiaomi.push.service.XMPushService.j;
import com.xiaomi.push.service.XMPushService.m;

public class bx implements com.xiaomi.push.bx {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ XMPushService f4929a;

    public bx(XMPushService xMPushService) {
        this.f4929a = xMPushService;
    }

    public void a(bi biVar) {
        XMPushService xMPushService = this.f4929a;
        xMPushService.a((j) new d(biVar));
    }

    public void a(cj cjVar) {
        XMPushService xMPushService = this.f4929a;
        xMPushService.a((j) new m(cjVar));
    }
}
