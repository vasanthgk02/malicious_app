package com.xiaomi.push.service;

import android.content.ComponentName;
import android.content.pm.PackageManager;
import com.xiaomi.channel.commonutils.logger.b;

public class cc implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ XMPushService f4935a;

    public cc(XMPushService xMPushService) {
        this.f4935a = xMPushService;
    }

    public void run() {
        try {
            PackageManager packageManager = this.f4935a.getApplicationContext().getPackageManager();
            ComponentName componentName = new ComponentName(this.f4935a.getApplicationContext(), "com.xiaomi.push.service.receivers.PingReceiver");
            if (packageManager.getComponentEnabledSetting(componentName) != 2) {
                packageManager.setComponentEnabledSetting(componentName, 2, 1);
            }
        } catch (Throwable th) {
            b.a("[Alarm] disable ping receiver may be failure. " + th);
        }
    }
}
