package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.cd;
import com.xiaomi.push.service.XMPushService.j;

public class by extends j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ XMPushService f4930a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f904a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ byte[] f905a;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public by(XMPushService xMPushService, int i, String str, byte[] bArr) {
        // this.f4930a = xMPushService;
        // this.f904a = str;
        // this.f905a = bArr;
        super(i);
    }

    public String a() {
        return "send mi push message";
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m842a() {
        try {
            ad.a(this.f4930a, this.f904a, this.f905a);
        } catch (cd e2) {
            b.a((Throwable) e2);
            this.f4930a.a(10, (Exception) e2);
        }
    }
}
