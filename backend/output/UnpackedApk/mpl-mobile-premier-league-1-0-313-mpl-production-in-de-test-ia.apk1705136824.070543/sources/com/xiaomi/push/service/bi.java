package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.XMPushService.e;
import com.xiaomi.push.service.XMPushService.j;

public class bi {

    /* renamed from: d  reason: collision with root package name */
    public static int f4912d = 300000;

    /* renamed from: a  reason: collision with root package name */
    public int f4913a;

    /* renamed from: a  reason: collision with other field name */
    public long f884a;

    /* renamed from: a  reason: collision with other field name */
    public XMPushService f885a;

    /* renamed from: b  reason: collision with root package name */
    public int f4914b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f4915c = 0;

    public bi(XMPushService xMPushService) {
        this.f885a = xMPushService;
        this.f4913a = 500;
        this.f884a = 0;
    }

    private int a() {
        if (this.f4914b > 8) {
            return 300000;
        }
        double random = (Math.random() * 2.0d) + 1.0d;
        int i = this.f4914b;
        if (i > 4) {
            return (int) (random * 60000.0d);
        }
        if (i > 1) {
            return (int) (random * 10000.0d);
        }
        if (this.f884a == 0) {
            return 0;
        }
        if (System.currentTimeMillis() - this.f884a < 310000) {
            int i2 = this.f4913a;
            int i3 = f4912d;
            if (i2 >= i3) {
                return i2;
            }
            int i4 = this.f4915c + 1;
            this.f4915c = i4;
            if (i4 >= 4) {
                i2 = i3;
            } else {
                this.f4913a = (int) (((double) i2) * 1.5d);
            }
            return i2;
        }
        this.f4913a = 1000;
        this.f4915c = 0;
        return 0;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m835a() {
        this.f884a = System.currentTimeMillis();
        this.f885a.a(1);
        this.f4914b = 0;
    }

    public void a(boolean z) {
        if (!this.f885a.b()) {
            b.c("should not reconnect as no client or network.");
        } else if (z) {
            if (!this.f885a.a(1)) {
                this.f4914b++;
            }
            this.f885a.a(1);
            XMPushService xMPushService = this.f885a;
            xMPushService.getClass();
            xMPushService.a((j) new e());
        } else if (!this.f885a.a(1)) {
            int a2 = a();
            this.f4914b++;
            b.a("schedule reconnect in " + a2 + "ms");
            XMPushService xMPushService2 = this.f885a;
            xMPushService2.getClass();
            xMPushService2.a((j) new e(), (long) a2);
            if (this.f4914b == 2) {
                aj.b();
            }
            if (this.f4914b == 3) {
                aj.a();
            }
        }
    }
}
