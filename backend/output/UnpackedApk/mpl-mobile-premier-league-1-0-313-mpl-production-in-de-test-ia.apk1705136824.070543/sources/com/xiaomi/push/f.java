package com.xiaomi.push;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final int f4783a = a(1, 3);

    /* renamed from: b  reason: collision with root package name */
    public static final int f4784b = a(1, 4);

    /* renamed from: c  reason: collision with root package name */
    public static final int f4785c = a(2, 0);

    /* renamed from: d  reason: collision with root package name */
    public static final int f4786d = a(3, 2);

    public static int a(int i) {
        return i & 7;
    }

    public static int a(int i, int i2) {
        return (i << 3) | i2;
    }

    public static int b(int i) {
        return i >>> 3;
    }
}
