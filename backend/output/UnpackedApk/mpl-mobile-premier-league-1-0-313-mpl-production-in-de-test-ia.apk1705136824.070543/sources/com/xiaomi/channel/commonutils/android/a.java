package com.xiaomi.channel.commonutils.android;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import androidx.core.app.NotificationManagerCompat;
import com.xiaomi.push.z;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static C0066a f4300a;

    /* renamed from: com.xiaomi.channel.commonutils.android.a$a  reason: collision with other inner class name */
    public interface C0066a {
        boolean a(Context context, String str);

        boolean b(Context context, String str);
    }

    public enum b {
        UNKNOWN(0),
        ALLOWED(1),
        NOT_ALLOWED(2);
        

        /* renamed from: a  reason: collision with other field name */
        public final int f171a;

        /* access modifiers changed from: public */
        b(int i) {
            this.f171a = i;
        }

        public int a() {
            return this.f171a;
        }
    }

    public static int a(Context context) {
        if (context != null) {
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo("com.android.systemui", 128);
                if (!(applicationInfo == null || applicationInfo.metaData == null)) {
                    return applicationInfo.metaData.getInt("SupportForPushVersionCode");
                }
            } catch (NameNotFoundException unused) {
            }
        }
        return 0;
    }

    public static int a(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
        } catch (Exception unused) {
            packageInfo = null;
        }
        if (packageInfo != null) {
            return packageInfo.versionCode;
        }
        return 0;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static ApplicationInfo m311a(Context context, String str) {
        if (str.equals(context.getPackageName())) {
            return context.getApplicationInfo();
        }
        try {
            return context.getPackageManager().getApplicationInfo(str, 0);
        } catch (NameNotFoundException unused) {
            com.xiaomi.channel.commonutils.logger.b.a("not found app info " + str);
            return null;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static Drawable m312a(Context context, String str) {
        ApplicationInfo a2 = a(context, str);
        Drawable drawable = null;
        if (a2 != null) {
            try {
                drawable = a2.loadIcon(context.getPackageManager());
                if (drawable == null) {
                    drawable = a2.loadLogo(context.getPackageManager());
                }
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.a("get app icon drawable failed, " + e2);
            }
        }
        return drawable != null ? drawable : new ColorDrawable(0);
    }

    public static b a(Context context, ApplicationInfo applicationInfo) {
        int i = VERSION.SDK_INT;
        if (applicationInfo == null || i < 24) {
            return b.UNKNOWN;
        }
        Boolean bool = null;
        try {
            if (applicationInfo.packageName.equals(context.getPackageName())) {
                bool = Boolean.valueOf(((NotificationManager) context.getSystemService("notification")).areNotificationsEnabled());
            } else {
                Object a2 = i >= 29 ? z.a(context.getSystemService("notification"), (String) "getService", new Object[0]) : context.getSystemService("security");
                if (a2 != null) {
                    bool = (Boolean) z.b(a2, (String) "areNotificationsEnabledForPackage", applicationInfo.packageName, Integer.valueOf(applicationInfo.uid));
                }
            }
            if (bool != null) {
                return bool.booleanValue() ? b.ALLOWED : b.NOT_ALLOWED;
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a("are notifications enabled error " + e2);
        }
        return b.UNKNOWN;
    }

    @TargetApi(19)
    public static b a(Context context, String str, boolean z) {
        if (context == null || TextUtils.isEmpty(str)) {
            return b.UNKNOWN;
        }
        try {
            ApplicationInfo applicationInfo = str.equals(context.getPackageName()) ? context.getApplicationInfo() : context.getPackageManager().getApplicationInfo(str, 0);
            b a2 = a(context, applicationInfo);
            if (a2 != b.UNKNOWN) {
                return a2;
            }
            Integer num = (Integer) z.a(AppOpsManager.class, (String) NotificationManagerCompat.OP_POST_NOTIFICATION);
            if (num == null) {
                return b.UNKNOWN;
            }
            Integer num2 = (Integer) z.a((Object) (AppOpsManager) context.getSystemService("appops"), (String) NotificationManagerCompat.CHECK_OP_NO_THROW, num, Integer.valueOf(applicationInfo.uid), str);
            Integer num3 = (Integer) z.a(AppOpsManager.class, (String) "MODE_ALLOWED");
            Integer num4 = (Integer) z.a(AppOpsManager.class, (String) "MODE_IGNORED");
            com.xiaomi.channel.commonutils.logger.b.b(String.format("get app mode %s|%s|%s", new Object[]{num2, num3, num4}));
            if (num3 == null) {
                num3 = Integer.valueOf(0);
            }
            if (num4 == null) {
                num4 = Integer.valueOf(1);
            }
            if (num2 != null) {
                if (z) {
                    return !num2.equals(num4) ? b.ALLOWED : b.NOT_ALLOWED;
                }
                return num2.equals(num3) ? b.ALLOWED : b.NOT_ALLOWED;
            }
            return b.UNKNOWN;
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.a("get app op error " + th);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m313a(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
        } catch (Exception unused) {
            packageInfo = null;
        }
        return packageInfo != null ? packageInfo.versionName : "1.0";
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m314a(Context context, String str) {
        boolean z = false;
        if (context != null && !TextUtils.isEmpty(str)) {
            if (!f.a()) {
                return context.getPackageName().equals(str);
            }
            C0066a aVar = f4300a;
            if (aVar != null && aVar.a(context, str)) {
                z = true;
            }
        }
        return z;
    }

    public static int b(Context context, String str) {
        ApplicationInfo a2 = a(context, str);
        if (a2 == null) {
            return 0;
        }
        int i = a2.icon;
        return i == 0 ? a2.logo : i;
    }

    /* renamed from: b  reason: collision with other method in class */
    public static String m315b(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo == null) {
                return str;
            }
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            return applicationInfo != null ? packageManager.getApplicationLabel(applicationInfo).toString() : str;
        } catch (NameNotFoundException unused) {
            return str;
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public static boolean m316b(Context context, String str) {
        C0066a aVar = f4300a;
        return aVar != null && aVar.b(context, str);
    }

    public static boolean c(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                if (Secure.getInt(context.getContentResolver(), "freeform_window_state", -1) >= 0) {
                    return str.equals(Secure.getString(context.getContentResolver(), "freeform_package_name"));
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }
}
