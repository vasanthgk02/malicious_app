package com.xiaomi.push.service;

import android.app.NotificationChannel;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.SparseArray;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.xiaomi.channel.commonutils.android.f;
import com.xiaomi.channel.commonutils.android.j;
import com.xiaomi.channel.commonutils.android.k;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.ar.a;
import com.xiaomi.push.z;
import in.juspay.hypersdk.core.InflateView;
import java.util.ArrayList;
import java.util.List;

public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final SparseArray<a<String, String, String>> f4946a = new f(5);

    /* renamed from: a  reason: collision with other field name */
    public static final int[] f914a = {1, 2, 4, 8, 16};

    /* renamed from: b  reason: collision with root package name */
    public static final SparseArray<Integer> f4947b = new g(5);

    public static int a(String str, String str2) {
        int i = 8;
        if (!a(str, str2, 8)) {
            i = 0;
        }
        if (a(str, str2, 16)) {
            i |= 16;
        }
        if (a(str, str2, 1)) {
            i |= 1;
        }
        if (a(str, str2, 2)) {
            i |= 2;
        }
        return a(str, str2, 4) ? i | 4 : i;
    }

    public static SharedPreferences a(Context context) {
        return context.getSharedPreferences("ch_permission_cache_file", 0);
    }

    public static void a(Context context, String str) {
        if (f.a(context) && !TextUtils.isEmpty(str)) {
            List<NotificationChannel> a2 = aq.a(context, str).a();
            if (a2 != null) {
                synchronized (e.class) {
                    SharedPreferences a3 = a(context);
                    ArrayList arrayList = new ArrayList();
                    for (NotificationChannel a4 : a2) {
                        String str2 = (String) z.a((Object) a4, (String) "mId");
                        if (!TextUtils.isEmpty(str2) && a3.contains(str2)) {
                            arrayList.add(str2);
                        }
                    }
                    if (arrayList.size() > 0) {
                        a(a3, (List<String>) arrayList);
                    }
                }
            }
        }
    }

    public static void a(Context context, String str, String str2, int i, String str3, boolean z, int i2) {
        Class<e> cls = e.class;
        if (f.a(context) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            int a2 = k.a(str3, 0);
            boolean a3 = a(i, a2);
            if (z) {
                a(str, str2, a2, i2);
                if (a3) {
                    synchronized (cls) {
                        a(a(context), a2, str2);
                    }
                    return;
                }
                return;
            }
            synchronized (cls) {
                SharedPreferences a4 = a(context);
                if (a3 || a4.contains(str2)) {
                    a(a4, a2, str, str2, i2);
                    if (a3) {
                        a(a4, a2, str2);
                    } else {
                        a(a4, str2);
                    }
                }
            }
        } else if (f.a(context)) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("ChannelPC: can`t setup permission with permissionCode:");
            outline73.append(String.valueOf(str3));
            outline73.append(" channelId:");
            outline73.append(String.valueOf(str2));
            outline73.append(" targetPkg:");
            outline73.append(str);
            b.a(outline73.toString());
        }
    }

    public static void a(SharedPreferences sharedPreferences, int i, String str) {
        sharedPreferences.edit().putInt(str, i).commit();
    }

    public static void a(SharedPreferences sharedPreferences, int i, String str, String str2, int i2) {
        if (sharedPreferences.getInt(str2, 0) != i) {
            a(str, str2, i, i2);
        }
    }

    public static void a(SharedPreferences sharedPreferences, String str) {
        a(sharedPreferences, (List<String>) new h<String>(str));
    }

    public static void a(SharedPreferences sharedPreferences, List<String> list) {
        Editor edit = sharedPreferences.edit();
        for (String remove : list) {
            edit.remove(remove);
        }
        edit.commit();
    }

    public static void a(String str, String str2, int i, int i2) {
        for (int i3 : f914a) {
            if ((f4947b.get(i3).intValue() & i2) == 0) {
                a(str, str2, i3, (i & i3) > 0);
            } else {
                StringBuilder outline82 = GeneratedOutlineSupport.outline82("ChannelPermissions.grantPermission:", str, ":", str2, ": <");
                outline82.append(i3);
                outline82.append("> :stoped by userLock");
                b.a(outline82.toString());
            }
        }
    }

    public static void a(String str, String str2, int i, boolean z) {
        boolean a2 = ar.a(j.a(), str, str2, f4946a.get(i), z);
        StringBuilder outline82 = GeneratedOutlineSupport.outline82("ChannelPermissions.grantPermission:", str, ":", str2, ": <");
        outline82.append(i);
        outline82.append(InflateView.SETTER_EQUALS);
        outline82.append(z);
        outline82.append("> :");
        outline82.append(a2);
        b.a(outline82.toString());
    }

    public static boolean a(int i, int i2) {
        return i >= 4 || (i2 & 2) > 0 || (i2 & 1) > 0 || (i2 & 8) > 0 || (i2 & 16) > 0;
    }

    public static boolean a(String str, String str2, int i) {
        boolean z = true;
        if (ar.a(j.a(), str, str2, f4946a.get(i)) != 1) {
            z = false;
        }
        StringBuilder outline82 = GeneratedOutlineSupport.outline82("ChannelPermissions.checkPermission:", str, ":", str2, ": <");
        outline82.append(i);
        outline82.append(InflateView.SETTER_EQUALS);
        outline82.append(z);
        outline82.append(">");
        b.a(outline82.toString());
        return z;
    }
}
