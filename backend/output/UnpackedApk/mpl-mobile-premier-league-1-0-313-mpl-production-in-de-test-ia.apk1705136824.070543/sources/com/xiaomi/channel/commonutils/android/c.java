package com.xiaomi.channel.commonutils.android;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.PowerManager;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ad;
import com.xiaomi.push.z;
import org.apache.pdfbox.pdmodel.interactive.form.PDChoice;
import org.apache.pdfbox.pdmodel.interactive.form.PDTextField;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public static String f4305a;

    /* renamed from: a  reason: collision with other field name */
    public static final String[] f172a = {"--", "a-", "u-", "v-", "o-", "g-"};

    /* renamed from: b  reason: collision with root package name */
    public static String f4306b;

    /* renamed from: c  reason: collision with root package name */
    public static String f4307c;

    @TargetApi(17)
    public static int a() {
        Object a2 = z.a((String) "android.os.UserHandle", (String) "myUserId", new Object[0]);
        if (a2 == null) {
            return -1;
        }
        return Integer.class.cast(a2).intValue();
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m317a() {
        String[] strArr = f172a;
        return 5 >= strArr.length ? strArr[0] : strArr[5];
    }

    public static String a(Context context) {
        if (f4306b == null) {
            String c2 = c(context);
            f4306b = a() + ad.b(c2);
        }
        return f4306b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m318a(Context context) {
        try {
            return !d.a(context).a();
        } catch (Exception e2) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("failure to read gaid limit:");
            outline73.append(e2.getMessage());
            b.a(outline73.toString());
            return true;
        }
    }

    public static boolean a(Context context, String str) {
        PackageInfo packageInfo = (PackageInfo) z.a((Object) context.getPackageManager(), (String) "getPackageInfoAsUser", str, Integer.valueOf(0), Integer.valueOf(999));
        if (packageInfo != null) {
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            if (applicationInfo != null) {
                int i = applicationInfo.flags;
                if ((i & PDChoice.FLAG_MULTI_SELECT) != 2097152 || (i & PDTextField.FLAG_DO_NOT_SCROLL) == 8388608) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (String startsWith : f172a) {
            if (str.startsWith(startsWith)) {
                return true;
            }
        }
        return false;
    }

    public static String b(Context context) {
        if (!a(context)) {
            return null;
        }
        try {
            return d.a(context).a();
        } catch (Exception e2) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("failure to get gaid:");
            outline73.append(e2.getMessage());
            b.a(outline73.toString());
            return null;
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public static boolean m319b(Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return false;
        }
        int intExtra = registerReceiver.getIntExtra("status", -1);
        return intExtra == 2 || intExtra == 5;
    }

    public static String c(Context context) {
        String str = f4305a;
        if (str != null) {
            return str;
        }
        try {
            f4305a = Secure.getString(context.getContentResolver(), "android_id");
        } catch (Throwable th) {
            b.a("failure to get androidId: " + th);
        }
        return f4305a;
    }

    /* renamed from: c  reason: collision with other method in class */
    public static boolean m320c(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        return powerManager == null || powerManager.isScreenOn();
    }

    public static synchronized String d(Context context) {
        synchronized (c.class) {
            if (f4307c != null) {
                String str = f4307c;
                return str;
            }
            String b2 = ad.b(c(context));
            f4307c = b2;
            return b2;
        }
    }

    public static synchronized String e(Context context) {
        String b2;
        synchronized (c.class) {
            b2 = ad.b(c(context));
        }
        return b2;
    }
}
