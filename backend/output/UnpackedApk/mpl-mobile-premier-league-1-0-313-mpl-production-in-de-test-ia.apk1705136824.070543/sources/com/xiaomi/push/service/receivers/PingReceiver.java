package com.xiaomi.push.service.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.bc;
import com.xiaomi.push.service.ServiceClient;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.bd;

public class PingReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        b.c(intent.getPackage() + " is the package name");
        if (!XMPushService.f()) {
            if (!bd.q.equals(intent.getAction())) {
                b.a((String) "cancel the old ping timer");
                bc.a();
            } else if (TextUtils.equals(context.getPackageName(), intent.getPackage())) {
                b.c("Ping XMChannelService on timer");
                try {
                    Intent intent2 = new Intent(context, XMPushService.class);
                    intent2.putExtra("time_stamp", System.currentTimeMillis());
                    intent2.setAction("com.xiaomi.push.timer");
                    ServiceClient.getInstance(context).startServiceSafely(intent2);
                } catch (Exception e2) {
                    b.a((Throwable) e2);
                }
            }
        }
    }
}
