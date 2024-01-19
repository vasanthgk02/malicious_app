package com.xiaomi.push.service;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build.VERSION;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.xiaomi.channel.commonutils.android.c;
import com.xiaomi.channel.commonutils.android.f;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.db;
import com.xiaomi.push.z;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.WeakHashMap;

public class aq {

    /* renamed from: a  reason: collision with root package name */
    public static Context f4861a;

    /* renamed from: a  reason: collision with other field name */
    public static Object f849a;

    /* renamed from: a  reason: collision with other field name */
    public static WeakHashMap<Integer, aq> f850a = new WeakHashMap<>();

    /* renamed from: a  reason: collision with other field name */
    public static boolean f851a;

    /* renamed from: a  reason: collision with other field name */
    public String f852a;

    /* renamed from: b  reason: collision with root package name */
    public String f4862b;

    public aq(String str) {
        this.f852a = str;
    }

    public static int a(String str) {
        if (VERSION.SDK_INT >= 24) {
            try {
                return f4861a.getPackageManager().getPackageUid(str, 0);
            } catch (Exception unused) {
            }
        }
        return -1;
    }

    public static NotificationManager a() {
        return (NotificationManager) f4861a.getSystemService("notification");
    }

    public static aq a(Context context, String str) {
        a(context);
        int hashCode = str.hashCode();
        aq aqVar = f850a.get(Integer.valueOf(hashCode));
        if (aqVar != null) {
            return aqVar;
        }
        aq aqVar2 = new aq(str);
        f850a.put(Integer.valueOf(hashCode), aqVar2);
        return aqVar2;
    }

    public static <T> T a(Object obj) {
        if (obj != null) {
            try {
                return obj.getClass().getMethod("getList", new Class[0]).invoke(obj, new Object[0]);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static Object a(List list) {
        return Class.forName("android.content.pm.ParceledListSlice").getConstructor(new Class[]{List.class}).newInstance(new Object[]{list});
    }

    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String a2 = a("mipush|%s|%s", str2, "");
        return str.startsWith(a2) ? a("mipush_%s_%s", str2, str.replace(a2, "")) : str;
    }

    public static String a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return String.format(str, new Object[]{str2, str3});
    }

    public static void a(Context context) {
        if (f4861a == null) {
            f4861a = context.getApplicationContext();
            NotificationManager a2 = a();
            Boolean bool = (Boolean) z.a((Object) a2, (String) "isSystemConditionProviderEnabled", "xmsf_fake_condition_provider_path");
            a("fwk is support.init:" + bool);
            boolean booleanValue = bool != null ? bool.booleanValue() : false;
            f851a = booleanValue;
            if (booleanValue) {
                f849a = z.a((Object) a2, (String) "getService", new Object[0]);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m807a(String str) {
        b.a("NMHelper:" + str);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m808a() {
        if (f.a() && at.a(f4861a).a(db.NotificationBelongToAppSwitch.a(), true)) {
            return f851a;
        }
        return false;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m809a(Context context) {
        a(context);
        return a();
    }

    /* renamed from: a  reason: collision with other method in class */
    private StatusBarNotification[] m810a() {
        if (!f.a(a())) {
            return null;
        }
        try {
            String packageName = a().getPackageName();
            Object a2 = z.a(f849a, (String) "getActiveNotifications", packageName);
            if (a2 instanceof StatusBarNotification[]) {
                return (StatusBarNotification[]) a2;
            }
            return null;
        } catch (Throwable th) {
            a("getAllNotifications error " + th);
            return null;
        }
    }

    private String b(String str) {
        return a(a() ? "mipush|%s|%s" : "mipush_%s_%s", this.f852a, str);
    }

    @TargetApi(26)
    /* renamed from: a  reason: collision with other method in class */
    public NotificationChannel m811a(String str) {
        try {
            if (!a()) {
                return a().getNotificationChannel(str);
            }
            List<NotificationChannel> a2 = a();
            if (a2 == null) {
                return null;
            }
            for (NotificationChannel notificationChannel : a2) {
                if (str.equals(notificationChannel.getId())) {
                    return notificationChannel;
                }
            }
            return null;
        } catch (Exception e2) {
            a("getNotificationChannel error" + e2);
            return null;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public Context m812a() {
        return f4861a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m813a() {
        return this.f852a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m814a(String str) {
        return TextUtils.isEmpty(str) ? b() : f.a(a()) ? b(str) : str;
    }

    @TargetApi(26)
    /* renamed from: a  reason: collision with other method in class */
    public List<NotificationChannel> m815a() {
        String str;
        String str2 = this.f852a;
        List<NotificationChannel> list = null;
        try {
            if (a()) {
                int a2 = a(str2);
                if (a2 != -1) {
                    str = "mipush|%s|%s";
                    list = (List) a(z.a(f849a, (String) "getNotificationChannelsForPackage", str2, Integer.valueOf(a2), Boolean.FALSE));
                } else {
                    str = null;
                }
            } else {
                list = a().getNotificationChannels();
                str = "mipush_%s_%s";
            }
            if (!f.a() || list == null) {
                return list;
            }
            ArrayList arrayList = new ArrayList();
            String a3 = a(str, str2, "");
            for (NotificationChannel next : list) {
                if (next.getId().startsWith(a3)) {
                    arrayList.add(next);
                }
            }
            return arrayList;
        } catch (Exception e2) {
            a("getNotificationChannels error " + e2);
            return null;
        }
    }

    public void a(int i) {
        String str = this.f852a;
        try {
            if (a()) {
                int a2 = c.a();
                String packageName = a().getPackageName();
                if (VERSION.SDK_INT >= 30) {
                    z.b(f849a, (String) "cancelNotificationWithTag", str, packageName, null, Integer.valueOf(i), Integer.valueOf(a2));
                } else {
                    z.b(f849a, (String) "cancelNotificationWithTag", str, null, Integer.valueOf(i), Integer.valueOf(a2));
                }
                a("cancel succ:" + i);
                return;
            }
            a().cancel(i);
        } catch (Exception e2) {
            a("cancel error" + e2);
        }
    }

    public void a(int i, Notification notification) {
        String str = this.f852a;
        NotificationManager a2 = a();
        try {
            int i2 = VERSION.SDK_INT;
            if (a()) {
                notification.extras.putString("xmsf_target_package", str);
                if (i2 >= 29) {
                    a2.notifyAsPackage(str, null, i, notification);
                    return;
                }
            }
            a2.notify(i, notification);
        } catch (Exception unused) {
        }
    }

    @TargetApi(26)
    public void a(NotificationChannel notificationChannel) {
        String str = this.f852a;
        try {
            if (a()) {
                int a2 = a(str);
                if (a2 != -1) {
                    Object a3 = a(Arrays.asList(new NotificationChannel[]{notificationChannel}));
                    z.b(f849a, (String) "createNotificationChannelsForPackage", str, Integer.valueOf(a2), a3);
                    return;
                }
                return;
            }
            a().createNotificationChannel(notificationChannel);
        } catch (Exception e2) {
            a("createNotificationChannel error" + e2);
        }
    }

    public void a(NotificationChannel notificationChannel, boolean z) {
        String str = this.f852a;
        if (z) {
            try {
                int a2 = a(str);
                if (a2 != -1) {
                    z.b(f849a, (String) "updateNotificationChannelForPackage", str, Integer.valueOf(a2), notificationChannel);
                }
            } catch (Exception e2) {
                a("updateNotificationChannel error " + e2);
            }
        } else {
            a(notificationChannel);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m816a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.startsWith(b(""));
        }
        return false;
    }

    public String b() {
        if (TextUtils.isEmpty(this.f4862b)) {
            this.f4862b = b("default");
        }
        return this.f4862b;
    }

    public String b(String str, String str2) {
        return a() ? str : str2;
    }

    /* renamed from: b  reason: collision with other method in class */
    public List<StatusBarNotification> m817b() {
        String str = this.f852a;
        NotificationManager a2 = a();
        ArrayList arrayList = null;
        try {
            if (a()) {
                int a3 = c.a();
                if (a3 == -1) {
                    return null;
                }
                return (List) a(z.a(f849a, (String) "getAppActiveNotifications", str, Integer.valueOf(a3)));
            }
            StatusBarNotification[] activeNotifications = VERSION.SDK_INT >= 23 ? a2.getActiveNotifications() : a();
            if (activeNotifications == null || activeNotifications.length <= 0) {
                return null;
            }
            ArrayList arrayList2 = new ArrayList();
            try {
                for (StatusBarNotification statusBarNotification : activeNotifications) {
                    if (str.equals(ar.c(statusBarNotification.getNotification()))) {
                        arrayList2.add(statusBarNotification);
                    }
                }
                return arrayList2;
            } catch (Throwable th) {
                th = th;
                arrayList = arrayList2;
                a("getActiveNotifications error " + th);
                return arrayList;
            }
        } catch (Throwable th2) {
            th = th2;
            a("getActiveNotifications error " + th);
            return arrayList;
        }
    }

    public String toString() {
        return GeneratedOutlineSupport.outline62(GeneratedOutlineSupport.outline73("NotificationManagerHelper{"), this.f852a, "}");
    }
}
