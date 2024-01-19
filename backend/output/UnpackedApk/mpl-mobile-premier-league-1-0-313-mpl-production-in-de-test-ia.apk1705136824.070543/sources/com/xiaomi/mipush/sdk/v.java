package com.xiaomi.mipush.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.channel.commonutils.logger.b;

public class v extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NotificationClickedActivity f4382a;

    public v(NotificationClickedActivity notificationClickedActivity) {
        this.f4382a = notificationClickedActivity;
    }

    public void onReceive(Context context, Intent intent) {
        b.b("clicked activity finish by normal.");
        this.f4382a.finish();
    }
}
