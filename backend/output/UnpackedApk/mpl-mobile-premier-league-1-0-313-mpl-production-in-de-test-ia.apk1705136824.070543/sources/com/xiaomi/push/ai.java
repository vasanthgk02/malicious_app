package com.xiaomi.push;

import java.net.InetSocketAddress;

public final class ai {

    /* renamed from: a  reason: collision with root package name */
    public int f4403a;

    /* renamed from: a  reason: collision with other field name */
    public String f246a;

    public ai(String str, int i) {
        this.f246a = str;
        this.f4403a = i;
    }

    public static ai a(String str, int i) {
        int lastIndexOf = str.lastIndexOf(":");
        if (lastIndexOf != -1) {
            String substring = str.substring(0, lastIndexOf);
            try {
                int parseInt = Integer.parseInt(str.substring(lastIndexOf + 1));
                if (parseInt > 0) {
                    i = parseInt;
                }
            } catch (NumberFormatException unused) {
            }
            str = substring;
        }
        return new ai(str, i);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static InetSocketAddress m399a(String str, int i) {
        ai a2 = a(str, i);
        return new InetSocketAddress(a2.a(), a2.a());
    }

    public int a() {
        return this.f4403a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m400a() {
        return this.f246a;
    }

    public String toString() {
        if (this.f4403a <= 0) {
            return this.f246a;
        }
        return this.f246a + ":" + this.f4403a;
    }
}
