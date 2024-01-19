package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.z;

public class cb implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ XMPushService f4934a;

    public cb(XMPushService xMPushService) {
        this.f4934a = xMPushService;
    }

    public void run() {
        this.f4934a.f808a = true;
        try {
            b.a((String) "try to trigger the wifi digest broadcast.");
            Object systemService = this.f4934a.getApplicationContext().getSystemService("MiuiWifiService");
            if (systemService != null) {
                z.b(systemService, (String) "sendCurrentWifiDigestInfo", new Object[0]);
            }
        } catch (Throwable unused) {
        }
    }
}
