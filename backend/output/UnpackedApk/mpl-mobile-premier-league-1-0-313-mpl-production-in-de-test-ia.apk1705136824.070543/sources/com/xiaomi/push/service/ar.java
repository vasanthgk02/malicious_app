package com.xiaomi.push.service;

import android.app.Notification;
import android.app.Notification.Action;
import android.app.Notification.Builder;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.Settings.Global;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.updater.downloadmanager.utils.Constants;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.z;
import java.util.Arrays;
import java.util.Map;
import org.apache.pdfbox.pdfparser.BaseParser;

public class ar {

    /* renamed from: a  reason: collision with root package name */
    public static final a<String, String, String> f4863a = new a<>("setSound", "canSound", "canSound");

    /* renamed from: a  reason: collision with other field name */
    public static String f853a = null;

    /* renamed from: a  reason: collision with other field name */
    public static final String[] f854a = {"com.mi.globalbrowser", "com.android.browser"};

    /* renamed from: b  reason: collision with root package name */
    public static final a<String, String, String> f4864b = new a<>("setVibrate", "canVibrate", "canVibrate");

    /* renamed from: c  reason: collision with root package name */
    public static final a<String, String, String> f4865c = new a<>("setLights", "canLights", "canLights");

    /* renamed from: d  reason: collision with root package name */
    public static final a<String, String, String> f4866d = new a<>("setShowOnKeyguard", "canShowOnKeyguard", "canShowOnKeyguard");

    /* renamed from: e  reason: collision with root package name */
    public static final a<String, String, String> f4867e = new a<>("setFloat", "canFloat", "canShowFloat");

    public static class a<F, S, T> {

        /* renamed from: a  reason: collision with root package name */
        public F f4868a;

        /* renamed from: b  reason: collision with root package name */
        public S f4869b;

        /* renamed from: c  reason: collision with root package name */
        public T f4870c;

        public a(F f2, S s, T t) {
            this.f4868a = f2;
            this.f4869b = s;
            this.f4870c = t;
        }
    }

    public static int a(ContentResolver contentResolver) {
        try {
            return Global.getInt(contentResolver, "user_aggregate", 0);
        } catch (Exception e2) {
            b.a("get user aggregate failed, " + e2);
            return 0;
        }
    }

    public static int a(Context context, String str) {
        return com.xiaomi.channel.commonutils.android.a.b(context, str);
    }

    public static int a(Context context, String str, String str2, a<String, String, String> aVar) {
        if (aVar != null) {
            try {
                Bundle a2 = a(context, (String) aVar.f4869b, str, str2, (Bundle) null);
                if (a2 != null && a2.containsKey((String) aVar.f4870c)) {
                    return a2.getBoolean((String) aVar.f4870c) ? 1 : 0;
                }
            } catch (Exception unused) {
            }
        }
        return -1;
    }

    public static Bundle a(Context context, String str, String str2, String str3, Bundle bundle) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("call notification provider failed!");
        }
        Bundle outline14 = GeneratedOutlineSupport.outline14("package", str2);
        if (!TextUtils.isEmpty(str3)) {
            outline14.putString(Constants.CHANNEL_ID, str3);
        }
        if (bundle != null) {
            outline14.putAll(bundle);
        }
        return context.getContentResolver().call(Uri.parse("content://statusbar.notification"), str, null, outline14);
    }

    public static <T> T a(Notification notification, String str) {
        Bundle bundle = notification.extras;
        if (bundle != null) {
            try {
                return bundle.get(str);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> T a(java.lang.Object r2, java.lang.String r3, T r4) {
        /*
            r0 = 0
            boolean r1 = r2 instanceof android.app.Notification     // Catch:{ Exception -> 0x0038 }
            if (r1 == 0) goto L_0x000d
            android.app.Notification r2 = (android.app.Notification) r2     // Catch:{ Exception -> 0x0038 }
            java.lang.Object r2 = a(r2, r3)     // Catch:{ Exception -> 0x0038 }
        L_0x000b:
            r0 = r2
            goto L_0x004d
        L_0x000d:
            boolean r1 = r2 instanceof java.util.Map     // Catch:{ Exception -> 0x0038 }
            if (r1 == 0) goto L_0x0018
            java.util.Map r2 = (java.util.Map) r2     // Catch:{ Exception -> 0x0038 }
            java.lang.Object r2 = r2.get(r3)     // Catch:{ Exception -> 0x0038 }
            goto L_0x000b
        L_0x0018:
            boolean r1 = r2 instanceof android.os.Bundle     // Catch:{ Exception -> 0x0038 }
            if (r1 == 0) goto L_0x0023
            android.os.Bundle r2 = (android.os.Bundle) r2     // Catch:{ Exception -> 0x0038 }
            java.lang.Object r2 = r2.get(r3)     // Catch:{ Exception -> 0x0038 }
            goto L_0x000b
        L_0x0023:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0038 }
            r3.<init>()     // Catch:{ Exception -> 0x0038 }
            java.lang.String r1 = "not support get value from classType:"
            r3.append(r1)     // Catch:{ Exception -> 0x0038 }
            r3.append(r2)     // Catch:{ Exception -> 0x0038 }
            java.lang.String r2 = r3.toString()     // Catch:{ Exception -> 0x0038 }
            com.xiaomi.channel.commonutils.logger.b.a(r2)     // Catch:{ Exception -> 0x0038 }
            goto L_0x004d
        L_0x0038:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r1 = "get value error "
            r3.append(r1)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            com.xiaomi.channel.commonutils.logger.b.a(r2)
        L_0x004d:
            if (r0 != 0) goto L_0x0050
            goto L_0x0051
        L_0x0050:
            r4 = r0
        L_0x0051:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.ar.a(java.lang.Object, java.lang.String, java.lang.Object):java.lang.Object");
    }

    public static String a(Notification notification) {
        CharSequence charSequence;
        Bundle bundle = notification.extras;
        if (bundle != null) {
            charSequence = bundle.getCharSequence(NotificationCompat.EXTRA_TITLE);
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = notification.extras.getCharSequence(NotificationCompat.EXTRA_TITLE_BIG);
            }
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = notification.extras.getCharSequence("mipush.customTitle");
            }
        } else {
            charSequence = null;
        }
        return charSequence != null ? charSequence.toString() : "";
    }

    public static String a(Object obj) {
        return (String) a(obj, (String) "msg_busi_type", (T) "");
    }

    public static void a(Notification notification, int i) {
        try {
            if (notification.extras != null) {
                notification.extras.putInt("miui.messageCount", i);
            }
            Object a2 = z.a((Object) notification, (String) "extraNotification");
            if (a2 != null) {
                z.a(a2, (String) "setMessageCount", Integer.valueOf(i));
            }
        } catch (Exception unused) {
        }
    }

    public static void a(Notification notification, int i, int i2) {
        if (notification != null) {
            if (notification.extras == null) {
                notification.extras = new Bundle();
            }
            notification.extras.putInt("is_priority", i);
            notification.extras.putInt("mipush_class", i2);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m818a(Notification notification, String str) {
        try {
            if (notification.extras != null) {
                notification.extras.putString("target_package", str);
            }
            Object a2 = z.a((Object) notification, (String) "extraNotification");
            if (a2 != null) {
                z.a(a2, (String) "setTargetPkg", str);
            }
        } catch (Exception unused) {
        }
    }

    public static void a(Notification notification, boolean z) {
        try {
            if (notification.extras != null) {
                notification.extras.putBoolean("miui.enableFloat", z);
            }
            Object a2 = z.a((Object) notification, (String) "extraNotification");
            if (a2 != null) {
                z.a(a2, (String) "setEnableFloat", Boolean.valueOf(z));
            }
        } catch (Exception unused) {
        }
    }

    public static void a(Context context, Intent intent) {
        String str;
        int i = -1;
        while (true) {
            str = i < 0 ? f853a : f854a[i];
            if (!TextUtils.isEmpty(str)) {
                intent.setPackage(str);
                try {
                    if (context.getPackageManager().resolveActivity(intent, 65536) != null) {
                        break;
                    }
                } catch (Exception e2) {
                    b.a("not found xm browser:" + e2);
                }
            }
            i++;
            if (i >= f854a.length) {
                str = null;
                break;
            }
        }
        intent.setPackage(str);
        f853a = str;
    }

    public static void a(Map<String, String> map, Bundle bundle, String str) {
        if (map == null || bundle == null || TextUtils.isEmpty(str)) {
            b.a("cp map to b fail:" + str);
            return;
        }
        if (TextUtils.isEmpty(map.get(str))) {
            bundle.remove(str);
        } else {
            bundle.putString(str, map.get(str));
        }
    }

    public static boolean a(Builder builder, boolean z) {
        if (VERSION.SDK_INT >= 26) {
            builder.setGroupAlertBehavior(z ? 2 : 1);
            return true;
        }
        b.b("not support setGroupAlertBehavior");
        return false;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m819a(ContentResolver contentResolver) {
        int a2 = a(contentResolver);
        return a2 == 1 || a2 == 2;
    }

    public static boolean a(Context context, String str, String str2, a<String, String, String> aVar, boolean z) {
        if (aVar != null) {
            try {
                Bundle bundle = new Bundle();
                bundle.putBoolean((String) aVar.f4870c, z);
                a(context, (String) aVar.f4868a, str, str2, bundle);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static boolean a(Map<String, String> map) {
        return Boolean.parseBoolean((String) a((Object) map, (String) "not_suppress", (T) BaseParser.TRUE));
    }

    /* renamed from: a  reason: collision with other method in class */
    public static Action[] m820a(Notification notification) {
        Action[] actionArr = notification.actions;
        if (actionArr != null) {
            return actionArr;
        }
        Bundle bundle = notification.extras;
        if (bundle != null) {
            Parcelable[] parcelableArray = bundle.getParcelableArray("mipush.customActions");
            if (parcelableArray != null) {
                return (Action[]) Arrays.copyOf(parcelableArray, parcelableArray.length, Action[].class);
            }
        }
        return null;
    }

    public static String b(Notification notification) {
        CharSequence charSequence;
        Bundle bundle = notification.extras;
        if (bundle != null) {
            charSequence = bundle.getCharSequence(NotificationCompat.EXTRA_TEXT);
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = notification.extras.getCharSequence(NotificationCompat.EXTRA_BIG_TEXT);
            }
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = notification.extras.getCharSequence("mipush.customContent");
            }
        } else {
            charSequence = null;
        }
        return charSequence != null ? charSequence.toString() : "";
    }

    public static void b(Notification notification, boolean z) {
        try {
            if (notification.extras != null) {
                notification.extras.putBoolean("miui.enableKeyguard", z);
            }
            Object a2 = z.a((Object) notification, (String) "extraNotification");
            if (a2 != null) {
                z.a(a2, (String) "setEnableKeyguard", Boolean.valueOf(z));
            }
        } catch (Exception unused) {
        }
    }

    public static String c(Notification notification) {
        String str = null;
        try {
            if (notification.extras != null) {
                str = notification.extras.getString("target_package");
            }
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
            Object a2 = z.a((Object) notification, (String) "extraNotification");
            return a2 != null ? (String) z.a(a2, (String) "getTargetPkg", new Object[0]) : str;
        } catch (Exception unused) {
            return null;
        }
    }
}
