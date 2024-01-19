package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.bu;
import com.xiaomi.push.service.XMPushService.j;

public class cj extends j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ XMPushService f4942a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f908a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ boolean f909a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ byte[] f910a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f4943b;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public cj(XMPushService xMPushService, int i, int i2, boolean z, String str, byte[] bArr) {
        // this.f4942a = xMPushService;
        // this.f4943b = i2;
        // this.f909a = z;
        // this.f908a = str;
        // this.f910a = bArr;
        super(i);
    }

    public String a() {
        return "clear account cache.";
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m846a() {
        r.a((Context) this.f4942a);
        az.a().a((String) "5");
        com.xiaomi.push.j.a(this.f4943b);
        if (this.f909a) {
            this.f4942a.a();
        }
        XMPushService.a(this.f4942a).c(bu.a());
        b.a("clear account and start registration. " + this.f908a);
        this.f4942a.a(this.f910a, this.f908a);
    }
}
