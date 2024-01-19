package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import java.util.Map;

public class FTOSPushHelper {

    /* renamed from: a  reason: collision with root package name */
    public static long f4326a;

    /* renamed from: a  reason: collision with other field name */
    public static volatile boolean f188a;

    public static void a(Context context) {
        AbstractPushManager a2 = d.a(context).a(c.ASSEMBLE_PUSH_FTOS);
        if (a2 != null) {
            b.a((String) "ASSEMBLE_PUSH :  register fun touch os when network change!");
            a2.register();
        }
    }

    public static void doInNetworkChange(Context context) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (getNeedRegister()) {
            long j = f4326a;
            if (j <= 0 || j + 300000 <= elapsedRealtime) {
                f4326a = elapsedRealtime;
                a(context);
            }
        }
    }

    public static boolean getNeedRegister() {
        return f188a;
    }

    public static boolean hasNetwork(Context context) {
        return g.a(context);
    }

    public static void notifyFTOSNotificationClicked(Context context, Map<String, String> map) {
        if (map != null && map.containsKey("pushMsg")) {
            String str = map.get("pushMsg");
            if (!TextUtils.isEmpty(str)) {
                PushMessageReceiver a2 = g.a(context);
                if (a2 != null) {
                    MiPushMessage a3 = g.a(str);
                    if (!a3.getExtra().containsKey("notify_effect")) {
                        a2.onNotificationMessageClicked(context, a3);
                    }
                }
            }
        }
    }

    public static void setNeedRegister(boolean z) {
        f188a = z;
    }

    public static void uploadToken(Context context, String str) {
        g.a(context, c.ASSEMBLE_PUSH_FTOS, str);
    }
}
