package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.service.XMPushService.j;
import com.xiaomi.push.y;

public class ch extends j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ XMPushService f4940a;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public ch(XMPushService xMPushService, int i) {
        // this.f4940a = xMPushService;
        super(i);
    }

    public String a() {
        return "prepare the mi push account.";
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m845a() {
        ad.a(this.f4940a);
        if (y.a((Context) this.f4940a)) {
            this.f4940a.a(true);
        }
    }
}
