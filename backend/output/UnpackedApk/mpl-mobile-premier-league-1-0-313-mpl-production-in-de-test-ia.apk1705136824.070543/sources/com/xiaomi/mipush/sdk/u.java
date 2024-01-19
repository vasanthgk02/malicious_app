package com.xiaomi.mipush.sdk;

import com.xiaomi.channel.commonutils.logger.b;

public class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NotificationClickedActivity f4381a;

    public u(NotificationClickedActivity notificationClickedActivity) {
        this.f4381a = notificationClickedActivity;
    }

    public void run() {
        b.e("clicked activity finish by timeout.");
        this.f4381a.finish();
    }
}
