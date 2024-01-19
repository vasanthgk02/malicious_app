package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.cd;
import com.xiaomi.push.service.XMPushService.j;
import com.xiaomi.push.service.az.b;
import com.xiaomi.push.service.az.c;
import java.util.Collection;

public class t extends j {

    /* renamed from: a  reason: collision with root package name */
    public XMPushService f4980a;

    /* renamed from: a  reason: collision with other field name */
    public String f941a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f942a;

    /* renamed from: b  reason: collision with root package name */
    public String f4981b;

    /* renamed from: c  reason: collision with root package name */
    public String f4982c;

    public t(XMPushService xMPushService, String str, String str2, String str3, byte[] bArr) {
        super(9);
        this.f4980a = xMPushService;
        this.f941a = str;
        this.f942a = bArr;
        this.f4981b = str2;
        this.f4982c = str3;
    }

    public String a() {
        return "register app";
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m874a() {
        b bVar;
        q a2 = r.a((Context) this.f4980a);
        if (a2 == null) {
            try {
                a2 = r.a(this.f4980a, this.f941a, this.f4981b, this.f4982c);
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.d("fail to register push account. " + e2);
            }
        }
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.d("no account for registration.");
            u.a(this.f4980a, ErrorCode.ERROR_AUTHERICATION_ERROR, "no account.");
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.a((String) "do registration now.");
        Collection a3 = az.a().a((String) "5");
        if (a3.isEmpty()) {
            bVar = a2.a(this.f4980a);
            ad.a(this.f4980a, bVar);
            az.a().a(bVar);
        } else {
            bVar = (b) a3.iterator().next();
        }
        if (this.f4980a.d()) {
            try {
                if (bVar.f867a == c.binded) {
                    ad.a(this.f4980a, this.f941a, this.f942a);
                } else if (bVar.f867a == c.unbind) {
                    u.a(this.f941a, this.f942a);
                    XMPushService xMPushService = this.f4980a;
                    XMPushService xMPushService2 = this.f4980a;
                    xMPushService2.getClass();
                    xMPushService.a((j) new XMPushService.b(bVar));
                }
            } catch (cd e3) {
                com.xiaomi.channel.commonutils.logger.b.d("meet error, disconnect connection. " + e3);
                this.f4980a.a(10, (Exception) e3);
            }
        } else {
            u.a(this.f941a, this.f942a);
            this.f4980a.a(true);
        }
    }
}
