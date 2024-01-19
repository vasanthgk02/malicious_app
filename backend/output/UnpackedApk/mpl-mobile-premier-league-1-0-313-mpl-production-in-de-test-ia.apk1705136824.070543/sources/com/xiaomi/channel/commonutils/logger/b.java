package com.xiaomi.channel.commonutils.logger;

import android.content.Context;
import android.os.Process;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.xiaomi.channel.commonutils.android.f;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public static int f4320a = 2;

    /* renamed from: a  reason: collision with other field name */
    public static Context f179a;

    /* renamed from: a  reason: collision with other field name */
    public static LoggerInterface f180a = new a();

    /* renamed from: a  reason: collision with other field name */
    public static final Integer f181a = Integer.valueOf(-1);

    /* renamed from: a  reason: collision with other field name */
    public static String f182a;

    /* renamed from: a  reason: collision with other field name */
    public static final HashMap<Integer, Long> f183a = new HashMap<>();

    /* renamed from: a  reason: collision with other field name */
    public static AtomicInteger f184a = new AtomicInteger(1);

    /* renamed from: a  reason: collision with other field name */
    public static boolean f185a;

    /* renamed from: b  reason: collision with root package name */
    public static final HashMap<Integer, String> f4321b = new HashMap<>();

    /* renamed from: b  reason: collision with other field name */
    public static boolean f186b;

    public static class a implements LoggerInterface {

        /* renamed from: a  reason: collision with root package name */
        public String f4322a = b.a();

        public void log(String str) {
        }

        public void log(String str, Throwable th) {
        }

        public void setTag(String str) {
            this.f4322a = str;
        }
    }

    static {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("XMPush-");
        outline73.append(Process.myPid());
        f182a = outline73.toString();
    }

    public static int a() {
        return f4320a;
    }

    public static Integer a(String str) {
        if (f4320a > 1) {
            return f181a;
        }
        Integer valueOf = Integer.valueOf(f184a.incrementAndGet());
        f183a.put(valueOf, Long.valueOf(System.currentTimeMillis()));
        f4321b.put(valueOf, str);
        LoggerInterface loggerInterface = f180a;
        loggerInterface.log(str + " starts");
        return valueOf;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m333a(String str) {
        return b() + str;
    }

    public static String a(String str, String str2) {
        return GeneratedOutlineSupport.outline53("[", str, "] ", str2);
    }

    public static void a(int i) {
        if (i < 0 || i > 5) {
            a(2, "set log level as " + i);
        }
        f4320a = i;
    }

    public static void a(int i, String str) {
        if (i >= f4320a) {
            f180a.log(str);
        }
    }

    public static void a(int i, String str, Throwable th) {
        if (i >= f4320a) {
            f180a.log(str, th);
        }
    }

    public static void a(int i, Throwable th) {
        if (i >= f4320a) {
            f180a.log("", th);
        }
    }

    public static void a(Context context) {
        f179a = context;
        if (f.a(context)) {
            f185a = true;
        }
        if (f.a()) {
            f186b = true;
        }
    }

    public static void a(LoggerInterface loggerInterface) {
        f180a = loggerInterface;
    }

    public static void a(Integer num) {
        if (f4320a <= 1 && f183a.containsKey(num)) {
            long currentTimeMillis = System.currentTimeMillis() - f183a.remove(num).longValue();
            LoggerInterface loggerInterface = f180a;
            loggerInterface.log(f4321b.remove(num) + " ends in " + currentTimeMillis + " ms");
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m334a(String str) {
        a(2, a(str));
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m335a(String str, String str2) {
        a(2, b(str, str2));
    }

    public static void a(String str, Throwable th) {
        a(4, a(str), th);
    }

    public static void a(Throwable th) {
        a(4, th);
    }

    public static String b() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("[Tid:");
        outline73.append(Thread.currentThread().getId());
        outline73.append("] ");
        return outline73.toString();
    }

    public static String b(String str, String str2) {
        return b() + a(str, str2);
    }

    public static void b(String str) {
        a(0, a(str));
    }

    public static void c(String str) {
        a(1, a(str));
    }

    public static void d(String str) {
        a(4, a(str));
    }

    public static void e(String str) {
        if (!f185a) {
            a(str);
            if (f186b) {
                return;
            }
        }
        a(str);
    }
}
