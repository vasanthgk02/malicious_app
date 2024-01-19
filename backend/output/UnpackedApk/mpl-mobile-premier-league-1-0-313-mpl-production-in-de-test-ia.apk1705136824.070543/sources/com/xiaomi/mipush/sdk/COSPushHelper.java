package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.xiaomi.channel.commonutils.logger.b;

public class COSPushHelper {

    /* renamed from: a  reason: collision with root package name */
    public static long f4325a;

    /* renamed from: a  reason: collision with other field name */
    public static volatile boolean f187a;

    public static void convertMessage(Intent intent) {
        g.a(intent);
    }

    public static void doInNetworkChange(Context context) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (getNeedRegister()) {
            long j = f4325a;
            if (j <= 0 || j + 300000 <= elapsedRealtime) {
                f4325a = elapsedRealtime;
                registerCOSAssemblePush(context);
            }
        }
    }

    public static boolean getNeedRegister() {
        return f187a;
    }

    public static boolean hasNetwork(Context context) {
        return g.a(context);
    }

    public static void onNotificationMessageCome(Context context, String str) {
    }

    public static void onPassThoughMessageCome(Context context, String str) {
    }

    public static void registerCOSAssemblePush(Context context) {
        AbstractPushManager a2 = d.a(context).a(c.ASSEMBLE_PUSH_COS);
        if (a2 != null) {
            b.a((String) "ASSEMBLE_PUSH :  register cos when network change!");
            a2.register();
        }
    }

    public static synchronized void setNeedRegister(boolean z) {
        synchronized (COSPushHelper.class) {
            f187a = z;
        }
    }

    public static void uploadToken(Context context, String str) {
        g.a(context, c.ASSEMBLE_PUSH_COS, str);
    }
}
