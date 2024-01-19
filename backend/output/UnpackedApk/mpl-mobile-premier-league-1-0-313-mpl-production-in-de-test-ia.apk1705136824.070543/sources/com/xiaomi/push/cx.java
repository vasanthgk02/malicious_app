package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.google.firebase.perf.config.RemoteConfigManager;
import com.xiaomi.channel.commonutils.android.f;
import com.xiaomi.push.C0097r.b;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class cx {

    /* renamed from: a  reason: collision with root package name */
    public static volatile int f4594a = -1;

    /* renamed from: a  reason: collision with other field name */
    public static long f432a = System.currentTimeMillis();

    /* renamed from: a  reason: collision with other field name */
    public static com.xiaomi.push.providers.a f433a = null;

    /* renamed from: a  reason: collision with other field name */
    public static C0097r f434a = new C0097r(true);

    /* renamed from: a  reason: collision with other field name */
    public static final Object f435a = new Object();

    /* renamed from: a  reason: collision with other field name */
    public static String f436a = "";

    /* renamed from: a  reason: collision with other field name */
    public static List<a> f437a = Collections.synchronizedList(new ArrayList());

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f4595a = -1;

        /* renamed from: a  reason: collision with other field name */
        public long f438a = 0;

        /* renamed from: a  reason: collision with other field name */
        public String f439a = "";

        /* renamed from: b  reason: collision with root package name */
        public int f4596b = -1;

        /* renamed from: b  reason: collision with other field name */
        public long f440b = 0;

        /* renamed from: b  reason: collision with other field name */
        public String f441b = "";

        public a(String str, long j, int i, int i2, String str2, long j2) {
            this.f439a = str;
            this.f438a = j;
            this.f4595a = i;
            this.f4596b = i2;
            this.f441b = str2;
            this.f440b = j2;
        }

        public boolean a(a aVar) {
            return TextUtils.equals(aVar.f439a, this.f439a) && TextUtils.equals(aVar.f441b, this.f441b) && aVar.f4595a == this.f4595a && aVar.f4596b == this.f4596b && Math.abs(aVar.f438a - this.f438a) <= RemoteConfigManager.MIN_APP_START_CONFIG_FETCH_DELAY_MS;
        }
    }

    public static int a(Context context) {
        if (f4594a == -1) {
            f4594a = b(context);
        }
        return f4594a;
    }

    public static int a(String str) {
        try {
            return str.getBytes("UTF-8").length;
        } catch (UnsupportedEncodingException unused) {
            return str.getBytes().length;
        }
    }

    public static long a(int i, long j, boolean z, long j2, boolean z2) {
        if (z && z2) {
            long j3 = f432a;
            f432a = j2;
            if (j2 - j3 > 30000 && j > 1024) {
                return j * 2;
            }
        }
        return (j * ((long) (i == 0 ? 13 : 11))) / 10;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static com.xiaomi.push.providers.a m588a(Context context) {
        com.xiaomi.push.providers.a aVar = f433a;
        if (aVar != null) {
            return aVar;
        }
        com.xiaomi.push.providers.a aVar2 = new com.xiaomi.push.providers.a(context);
        f433a = aVar2;
        return aVar2;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static synchronized String m589a(Context context) {
        synchronized (cx.class) {
            if (TextUtils.isEmpty(f436a)) {
                return "";
            }
            String str = f436a;
            return str;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m590a(Context context) {
        f4594a = b(context);
    }

    public static void a(Context context, String str, long j, boolean z, long j2) {
        boolean isEmpty;
        if (context != null && !TextUtils.isEmpty(str) && "com.xiaomi.xmsf".equals(context.getPackageName())) {
            String str2 = str;
            if (!"com.xiaomi.xmsf".equals(str)) {
                int a2 = a(context);
                if (-1 != a2) {
                    synchronized (f435a) {
                        isEmpty = f437a.isEmpty();
                        a aVar = new a(str, j2, a2, z ? 1 : 0, a2 == 0 ? a(context) : "", j);
                        a(aVar);
                    }
                    if (isEmpty) {
                        f434a.a((b) new cy(context), (long) RemoteConfigManager.MIN_APP_START_CONFIG_FETCH_DELAY_MS);
                    }
                }
            }
        }
    }

    public static void a(Context context, String str, long j, boolean z, boolean z2, long j2) {
        a(context, str, a(a(context), j, z, j2, z2), z, j2);
    }

    public static void a(a aVar) {
        for (a next : f437a) {
            if (next.a(aVar)) {
                next.f440b += aVar.f440b;
                return;
            }
        }
        f437a.add(aVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static synchronized void m591a(String str) {
        synchronized (cx.class) {
            if (!f.c() && !TextUtils.isEmpty(str)) {
                f436a = str;
            }
        }
    }

    public static int b(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return -1;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return -1;
            }
            return activeNetworkInfo.getType();
        } catch (Exception unused) {
            return -1;
        }
    }

    public static void b(Context context, List<a> list) {
        try {
            synchronized (com.xiaomi.push.providers.a.f772a) {
                SQLiteDatabase writableDatabase = a(context).getWritableDatabase();
                writableDatabase.beginTransaction();
                try {
                    for (a next : list) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("package_name", next.f439a);
                        contentValues.put("message_ts", Long.valueOf(next.f438a));
                        contentValues.put("network_type", Integer.valueOf(next.f4595a));
                        contentValues.put("bytes", Long.valueOf(next.f440b));
                        contentValues.put("rcv", Integer.valueOf(next.f4596b));
                        contentValues.put("imsi", next.f441b);
                        writableDatabase.insert("traffic", null, contentValues);
                    }
                    writableDatabase.setTransactionSuccessful();
                } finally {
                    writableDatabase.endTransaction();
                }
            }
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.a(th);
        }
    }
}
