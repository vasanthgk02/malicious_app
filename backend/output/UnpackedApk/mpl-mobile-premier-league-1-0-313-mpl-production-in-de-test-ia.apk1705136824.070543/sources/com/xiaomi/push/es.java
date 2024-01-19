package com.xiaomi.push;

public class es {

    /* renamed from: a  reason: collision with root package name */
    public static int f4771a = Integer.MAX_VALUE;

    public static void a(ep epVar, byte b2) {
        a(epVar, b2, f4771a);
    }

    public static void a(ep epVar, byte b2, int i) {
        if (i > 0) {
            int i2 = 0;
            switch (b2) {
                case 2:
                    epVar.a();
                    return;
                case 3:
                    epVar.a();
                    return;
                case 4:
                    epVar.a();
                    return;
                case 6:
                    epVar.a();
                    return;
                case 8:
                    epVar.a();
                    return;
                case 10:
                    epVar.a();
                    return;
                case 11:
                    epVar.a();
                    return;
                case 12:
                    epVar.a();
                    while (true) {
                        byte b3 = epVar.a().f4765a;
                        if (b3 == 0) {
                            epVar.f();
                            return;
                        } else {
                            a(epVar, b3, i - 1);
                            epVar.g();
                        }
                    }
                case 13:
                    eo a2 = epVar.a();
                    while (i2 < a2.f757a) {
                        int i3 = i - 1;
                        a(epVar, a2.f4767a, i3);
                        a(epVar, a2.f4768b, i3);
                        i2++;
                    }
                    epVar.h();
                    return;
                case 14:
                    et a3 = epVar.a();
                    while (i2 < a3.f758a) {
                        a(epVar, a3.f4772a, i - 1);
                        i2++;
                    }
                    epVar.j();
                    return;
                case 15:
                    en a4 = epVar.a();
                    while (i2 < a4.f756a) {
                        a(epVar, a4.f4766a, i - 1);
                        i2++;
                    }
                    epVar.i();
                    return;
                default:
                    return;
            }
        } else {
            throw new ej((String) "Maximum skip depth exceeded");
        }
    }
}
