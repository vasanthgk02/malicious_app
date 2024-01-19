package com.xiaomi.push.service.receivers;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.channel.commonutils.android.g;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.mipush.sdk.COSPushHelper;
import com.xiaomi.mipush.sdk.FTOSPushHelper;
import com.xiaomi.mipush.sdk.HWPushHelper;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.mipush.sdk.a;
import com.xiaomi.mipush.sdk.ag;
import com.xiaomi.mipush.sdk.am;
import com.xiaomi.mipush.sdk.x;
import com.xiaomi.push.cx;
import com.xiaomi.push.service.ServiceClient;
import com.xiaomi.push.y;

public class NetworkStatusReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f4974a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f4975b;

    public NetworkStatusReceiver() {
        this.f4975b = false;
        this.f4975b = true;
    }

    public NetworkStatusReceiver(Object obj) {
        this.f4975b = false;
        f4974a = true;
    }

    /* access modifiers changed from: private */
    public void a(Context context) {
        if (!ag.a(context).a() && a.a(context).c() && !a.a(context).f()) {
            try {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(context, "com.xiaomi.push.service.XMPushService"));
                intent.setAction("com.xiaomi.push.network_status_changed");
                ServiceClient.getInstance(context).startServiceSafely(intent);
            } catch (Exception e2) {
                b.a((Throwable) e2);
            }
        }
        cx.a(context);
        if (y.a(context) && ag.a(context).b()) {
            ag.a(context).c();
        }
        if (y.a(context)) {
            if ("syncing".equals(x.a(context).a(am.DISABLE_PUSH))) {
                MiPushClient.disablePush(context);
            }
            if ("syncing".equals(x.a(context).a(am.ENABLE_PUSH))) {
                MiPushClient.enablePush(context);
            }
            if ("syncing".equals(x.a(context).a(am.UPLOAD_HUAWEI_TOKEN))) {
                MiPushClient.syncAssemblePushToken(context);
            }
            if ("syncing".equals(x.a(context).a(am.UPLOAD_FCM_TOKEN))) {
                MiPushClient.syncAssembleFCMPushToken(context);
            }
            if ("syncing".equals(x.a(context).a(am.UPLOAD_COS_TOKEN))) {
                MiPushClient.syncAssembleCOSPushToken(context);
            }
            if ("syncing".equals(x.a(context).a(am.UPLOAD_FTOS_TOKEN))) {
                MiPushClient.syncAssembleFTOSPushToken(context);
            }
            if (HWPushHelper.needConnect() && HWPushHelper.shouldTryConnect(context)) {
                HWPushHelper.setConnectTime(context);
                HWPushHelper.registerHuaWeiAssemblePush(context);
            }
            COSPushHelper.doInNetworkChange(context);
            FTOSPushHelper.doInNetworkChange(context);
        }
    }

    public static boolean a() {
        return f4974a;
    }

    public void onReceive(Context context, Intent intent) {
        if (!this.f4975b) {
            g.a().post(new a(this, context));
        }
    }
}
