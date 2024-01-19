package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService.j;

public class bz extends j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ XMPushService f4931a;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public bz(XMPushService xMPushService, int i) {
        // this.f4931a = xMPushService;
        super(i);
    }

    public String a() {
        return "disconnect for service destroy.";
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m843a() {
        if (XMPushService.a(this.f4931a) != null) {
            XMPushService.a(this.f4931a).b(15, (Exception) null);
            this.f4931a.f793a = null;
        }
    }
}
