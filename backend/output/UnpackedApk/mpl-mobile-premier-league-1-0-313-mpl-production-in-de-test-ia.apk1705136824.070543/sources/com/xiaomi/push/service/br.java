package com.xiaomi.push.service;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.Notification.Builder;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.android.f;
import com.xiaomi.channel.commonutils.android.k;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ay;
import com.xiaomi.push.o;
import com.xiaomi.push.o.a;
import com.xiaomi.push.z;
import java.util.List;
import java.util.Map;

public class br {
    public static int a(Map<String, String> map) {
        return Math.max(0, k.a(map.get("notification_top_period"), 0));
    }

    @TargetApi(19)
    public static Notification a(Notification notification, int i, String str, aq aqVar) {
        if (notification != null) {
            if (!str.equals(notification.extras.getString("message_id"))) {
                notification = null;
            }
            return notification;
        }
        List<StatusBarNotification> b2 = aqVar.b();
        if (b2 == null) {
            return null;
        }
        for (StatusBarNotification statusBarNotification : b2) {
            Notification notification2 = statusBarNotification.getNotification();
            String string = notification2.extras.getString("message_id");
            if (i == statusBarNotification.getId() && str.equals(string)) {
                return notification2;
            }
        }
        return null;
    }

    public static a a(Context context, String str, int i, String str2, Notification notification) {
        bs bsVar = new bs(i, str2, context, str, notification);
        return bsVar;
    }

    @TargetApi(19)
    /* renamed from: a  reason: collision with other method in class */
    public static void m840a(Context context, String str, int i, String str2, Notification notification) {
        if (f.a(context) && notification != null && notification.extras.getBoolean("mipush_n_top_flag", false)) {
            c(context, str, i, str2, notification);
        }
    }

    public static void a(Context context, Map<String, String> map, ay ayVar, long j) {
        if (map != null && ayVar != null && f.a(context) && a(map)) {
            int a2 = a(map);
            int b2 = b(map);
            if (a2 <= 0 || b2 > a2) {
                b.d("set top notification failed - period:" + a2 + " frequency:" + b2);
                return;
            }
            ayVar.setPriority(2);
            Bundle bundle = new Bundle();
            bundle.putLong("mipush_org_when", j);
            bundle.putBoolean("mipush_n_top_flag", true);
            if (b2 > 0) {
                bundle.putInt("mipush_n_top_fre", b2);
            }
            bundle.putInt("mipush_n_top_prd", a2);
            ayVar.addExtras(bundle);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m841a(Map<String, String> map) {
        String str = map.get("notification_top_repeat");
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        boolean parseBoolean = Boolean.parseBoolean(str);
        b.c("top notification' repeat is " + parseBoolean);
        return parseBoolean;
    }

    public static int b(Map<String, String> map) {
        return Math.max(0, k.a(map.get("notification_top_frequency"), 0));
    }

    public static String b(int i, String str) {
        return "n_top_update_" + i + "_" + str;
    }

    @TargetApi(19)
    public static void c(Context context, String str, int i, String str2, Notification notification) {
        Context context2 = context;
        int i2 = i;
        String str3 = str2;
        Notification notification2 = notification;
        if (context2 != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && VERSION.SDK_INT >= 26) {
            aq a2 = aq.a(context, str);
            Notification a3 = a(notification2, i2, str3, a2);
            if (a3 != null) {
                boolean z = notification2 != null;
                if (a3.getGroupAlertBehavior() != 1) {
                    z.a((Object) a3, (String) "mGroupAlertBehavior", (Object) Integer.valueOf(1));
                }
                long currentTimeMillis = System.currentTimeMillis();
                long j = a3.extras.getLong("mipush_org_when", 0);
                int i3 = a3.extras.getInt("mipush_n_top_fre", 0);
                int i4 = a3.extras.getInt("mipush_n_top_prd", 0);
                if (i4 > 0 && i4 >= i3) {
                    int i5 = i4;
                    String str4 = "mipush_n_top_prd";
                    long j2 = ((long) (i4 * 1000)) + j;
                    int min = (j >= currentTimeMillis || currentTimeMillis >= j2) ? 0 : i3 > 0 ? (int) Math.min((j2 - currentTimeMillis) / 1000, (long) i3) : i5;
                    if (!z) {
                        if (min > 0) {
                            a3.when = currentTimeMillis;
                            b.a("update top notification: " + str3);
                            a2.a(i2, a3);
                        } else {
                            Builder recoverBuilder = Builder.recoverBuilder(context2, a3);
                            recoverBuilder.setPriority(0);
                            recoverBuilder.setWhen(currentTimeMillis);
                            Bundle extras = recoverBuilder.getExtras();
                            if (extras != null) {
                                extras.remove("mipush_n_top_flag");
                                extras.remove("mipush_org_when");
                                extras.remove("mipush_n_top_fre");
                                extras.remove(str4);
                                recoverBuilder.setExtras(extras);
                            }
                            b.a("update top notification to common: " + str3);
                            a2.a(i2, recoverBuilder.build());
                        }
                    }
                    if (min > 0) {
                        b.a("schedule top notification next update delay: " + min);
                        o.a(context).a(b(i, str2));
                        o.a(context).b(a(context2, str, i2, str3, (Notification) null), min);
                    }
                }
            }
        }
    }
}
