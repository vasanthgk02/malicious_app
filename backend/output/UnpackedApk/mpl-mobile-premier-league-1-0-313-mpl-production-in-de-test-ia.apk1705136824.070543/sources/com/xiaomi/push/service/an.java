package com.xiaomi.push.service;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationChannel;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.xiaomi.channel.commonutils.android.f;
import com.xiaomi.push.db;
import com.xiaomi.push.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@TargetApi(24)
public class an {

    /* renamed from: a  reason: collision with root package name */
    public static an f4854a = new an();

    public class a {

        /* renamed from: a  reason: collision with other field name */
        public List<b> f844a;

        /* renamed from: b  reason: collision with root package name */
        public List<b> f4856b;

        public a() {
            this.f844a = new ArrayList();
            this.f4856b = new ArrayList();
        }
    }

    public class b {

        /* renamed from: a  reason: collision with root package name */
        public int f4857a;

        /* renamed from: a  reason: collision with other field name */
        public Notification f845a;

        public b(int i, Notification notification) {
            this.f4857a = i;
            this.f845a = notification;
        }

        public String toString() {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("id:");
            outline73.append(this.f4857a);
            return outline73.toString();
        }
    }

    private int a(String str, String str2) {
        return ("GroupSummary" + str + str2).hashCode();
    }

    public static an a() {
        return f4854a;
    }

    private String a(Notification notification) {
        if (notification != null) {
            Bundle bundle = notification.extras;
            if (bundle != null) {
                return bundle.getString("push_src_group_name");
            }
        }
        return null;
    }

    private List<StatusBarNotification> a(aq aqVar) {
        List<StatusBarNotification> b2 = aqVar != null ? aqVar.b() : null;
        if (b2 == null || b2.size() == 0) {
            return null;
        }
        return b2;
    }

    private void a(Context context, int i, Notification notification, boolean z) {
        String str;
        String c2 = ar.c(notification);
        if (TextUtils.isEmpty(c2)) {
            str = "group auto not extract pkg from notification:" + i;
        } else {
            List<StatusBarNotification> a2 = a(aq.a(context, c2));
            if (a2 == null) {
                str = "group auto not get notifications";
            } else {
                String b2 = b(notification);
                HashMap hashMap = new HashMap();
                for (StatusBarNotification next : a2) {
                    if (!(next.getNotification() == null || next.getId() == i)) {
                        a((Map<String, a>) hashMap, next);
                    }
                }
                for (Entry entry : hashMap.entrySet()) {
                    String str2 = (String) entry.getKey();
                    if (!TextUtils.isEmpty(str2)) {
                        a aVar = (a) entry.getValue();
                        if (z && str2.equals(b2) && !b(notification)) {
                            (a(notification) ? aVar.f4856b : aVar.f844a).add(new b(i, notification));
                        }
                        int size = aVar.f844a.size();
                        if (aVar.f4856b.size() <= 0) {
                            if (z && size >= 2) {
                                a(context, c2, str2, aVar.f844a.get(0).f845a);
                            }
                        } else if (size <= 0) {
                            a(context, c2, str2);
                        }
                    }
                }
                return;
            }
        }
        com.xiaomi.channel.commonutils.logger.b.a(str);
    }

    private void a(Context context, String str, String str2) {
        com.xiaomi.channel.commonutils.logger.b.b("group cancel summary:" + str2);
        aq.a(context, str).a(a(str, str2));
    }

    private void a(Context context, String str, String str2, Notification notification) {
        Builder builder;
        try {
            if (TextUtils.isEmpty(str2)) {
                com.xiaomi.channel.commonutils.logger.b.a((String) "group show summary group is null");
                return;
            }
            int a2 = ar.a(context, str);
            if (a2 == 0) {
                com.xiaomi.channel.commonutils.logger.b.a("group show summary not get icon from " + str);
                return;
            }
            aq a3 = aq.a(context, str);
            if (VERSION.SDK_INT >= 26) {
                String b2 = a3.b(notification.getChannelId(), "groupSummary");
                NotificationChannel a4 = a3.a(b2);
                if ("groupSummary".equals(b2) && a4 == null) {
                    a3.a(new NotificationChannel(b2, "group_summary", 3));
                }
                builder = new Builder(context, b2);
            } else {
                builder = new Builder(context).setPriority(0).setDefaults(-1);
            }
            ar.a(builder, true);
            Notification build = builder.setContentTitle("GroupSummary").setContentText("GroupSummary").setSmallIcon(Icon.createWithResource(str, a2)).setAutoCancel(true).setGroup(str2).setGroupSummary(true).build();
            if (!f.b() && "com.xiaomi.xmsf".equals(context.getPackageName())) {
                ar.a(build, str);
            }
            int a5 = a(str, str2);
            a3.a(a5, build);
            com.xiaomi.channel.commonutils.logger.b.b("group show summary notify:" + a5);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a("group show summary error " + e2);
        }
    }

    private void a(Map<String, a> map, StatusBarNotification statusBarNotification) {
        String b2 = b(statusBarNotification.getNotification());
        a aVar = map.get(b2);
        if (aVar == null) {
            aVar = new a();
            map.put(b2, aVar);
        }
        (a(statusBarNotification.getNotification()) ? aVar.f4856b : aVar.f844a).add(new b(statusBarNotification.getId(), statusBarNotification.getNotification()));
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m804a() {
        return VERSION.SDK_INT >= 24;
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m805a(Notification notification) {
        if (notification != null) {
            Object a2 = z.a((Object) notification, (String) "isGroupSummary", (Object[]) null);
            if (a2 instanceof Boolean) {
                return ((Boolean) a2).booleanValue();
            }
        }
        return false;
    }

    private boolean a(Context context) {
        if (!b(context)) {
            return false;
        }
        boolean a2 = aq.a(context);
        return false;
    }

    private String b(Notification notification) {
        if (notification == null) {
            return null;
        }
        String group = notification.getGroup();
        if (b(notification)) {
            group = a(notification);
        }
        return group;
    }

    private void b(Context context, int i, Notification notification) {
        String str;
        String c2 = ar.c(notification);
        if (TextUtils.isEmpty(c2)) {
            str = "group restore not extract pkg from notification:" + i;
        } else {
            aq a2 = aq.a(context, c2);
            List<StatusBarNotification> a3 = a(a2);
            if (a3 == null) {
                str = "group restore not get notifications";
            } else {
                for (StatusBarNotification next : a3) {
                    Notification notification2 = next.getNotification();
                    if (!(notification2 == null || !b(notification2) || next.getId() == i)) {
                        Builder recoverBuilder = Builder.recoverBuilder(context, next.getNotification());
                        recoverBuilder.setGroup(a(notification2));
                        ar.a(recoverBuilder, a(notification2));
                        a2.a(next.getId(), recoverBuilder.build());
                        com.xiaomi.channel.commonutils.logger.b.b("group restore notification:" + next.getId());
                    }
                }
                return;
            }
        }
        com.xiaomi.channel.commonutils.logger.b.a(str);
    }

    /* renamed from: b  reason: collision with other method in class */
    private boolean m806b(Notification notification) {
        if (!(notification == null || notification.getGroup() == null)) {
            Bundle bundle = notification.extras;
            if (bundle != null) {
                long j = bundle.getLong("push_src_group_time");
                String a2 = a(notification);
                return notification.getGroup().equals(String.format("pushmask_%s_%s", new Object[]{Long.valueOf(j), a2}));
            }
        }
        return false;
    }

    private boolean b(Context context) {
        return at.a(context).a(db.NotificationAutoGroupSwitch.a(), true);
    }

    public String a(Context context, Builder builder, String str) {
        if (!a() || !a(context)) {
            return str;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Bundle extras = builder.getExtras();
        extras.putString("push_src_group_name", str);
        extras.putLong("push_src_group_time", currentTimeMillis);
        return String.format("pushmask_%s_%s", new Object[]{Long.valueOf(currentTimeMillis), str});
    }

    public void a(Context context, int i, Notification notification) {
        if (a()) {
            if (a(context)) {
                try {
                    b(context, i, notification);
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.a("group notify handle restore error " + e2);
                }
            }
            if (b(context)) {
                try {
                    a(context, i, notification, true);
                } catch (Exception e3) {
                    com.xiaomi.channel.commonutils.logger.b.a("group notify handle auto error " + e3);
                }
            }
        }
    }
}
