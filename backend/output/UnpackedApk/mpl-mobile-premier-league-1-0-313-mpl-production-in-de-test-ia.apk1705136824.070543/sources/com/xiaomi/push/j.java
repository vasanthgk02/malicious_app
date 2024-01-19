package com.xiaomi.push;

public class j {

    /* renamed from: a  reason: collision with root package name */
    public static int f4789a;

    /* renamed from: a  reason: collision with other field name */
    public static final String f761a;

    /* renamed from: a  reason: collision with other field name */
    public static final boolean f762a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f4790b;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f4791c = "LOGABLE".equalsIgnoreCase(f761a);

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f4792d = f761a.contains("YY");

    /* renamed from: e  reason: collision with root package name */
    public static boolean f4793e = f761a.equalsIgnoreCase("TEST");

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f4794f = "BETA".equalsIgnoreCase(f761a);
    public static final boolean g;

    static {
        int i;
        String str = l.f763a ? "ONEBOX" : "@SHIP.TO.2A2FE0D7@";
        f761a = str;
        boolean contains = str.contains("2A2FE0D7");
        f762a = contains;
        boolean z = false;
        f4790b = contains || "DEBUG".equalsIgnoreCase(f761a);
        String str2 = f761a;
        if (str2 != null && str2.startsWith("RC")) {
            z = true;
        }
        g = z;
        f4789a = 1;
        if (f761a.equalsIgnoreCase("SANDBOX")) {
            i = 2;
        } else if (f761a.equalsIgnoreCase("ONEBOX")) {
            i = 3;
        } else {
            f4789a = 1;
            return;
        }
        f4789a = i;
    }

    public static int a() {
        return f4789a;
    }

    public static void a(int i) {
        f4789a = i;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m749a() {
        return f4789a == 2;
    }

    public static boolean b() {
        return f4789a == 3;
    }
}
