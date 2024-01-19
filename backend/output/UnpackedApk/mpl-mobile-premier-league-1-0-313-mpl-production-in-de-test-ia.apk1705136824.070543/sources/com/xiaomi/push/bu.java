package com.xiaomi.push;

import com.xiaomi.channel.commonutils.android.f;
import com.xiaomi.channel.commonutils.android.j;
import java.util.Map;

public class bu implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public static final String f4515a = l.f4795a;

    /* renamed from: b  reason: collision with root package name */
    public static String f4516b;

    /* renamed from: a  reason: collision with other field name */
    public int f398a;

    /* renamed from: a  reason: collision with other field name */
    public bw f399a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f400a = bt.f383a;

    /* renamed from: b  reason: collision with other field name */
    public boolean f401b = true;

    /* renamed from: c  reason: collision with root package name */
    public String f4517c;

    /* renamed from: d  reason: collision with root package name */
    public String f4518d;

    /* renamed from: e  reason: collision with root package name */
    public String f4519e;

    public bu(Map<String, Integer> map, int i, String str, bw bwVar) {
        a(map, i, str, bwVar);
    }

    public static final String a() {
        String str = f4516b;
        return str != null ? str : j.a() ? "" : j.b() ? f4515a : "app.chat.global.xiaomi.net";
    }

    public static final void a(String str) {
        if (!f.a(j.a()) || !j.b()) {
            f4516b = str;
        }
    }

    private void a(Map<String, Integer> map, int i, String str, bw bwVar) {
        this.f398a = i;
        this.f4517c = str;
        this.f399a = bwVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public int m540a() {
        return this.f398a;
    }

    public void a(boolean z) {
        this.f400a = z;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m541a() {
        return this.f400a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m542a() {
        return null;
    }

    public String b() {
        return this.f4519e;
    }

    public void b(String str) {
        this.f4519e = str;
    }

    public String c() {
        if (this.f4518d == null) {
            this.f4518d = a();
        }
        return this.f4518d;
    }

    public void c(String str) {
        this.f4518d = str;
    }
}
