package com.cfg.mendikot.api.d.a.a.a.b.t;

import co.hyperverge.hypersnapsdk.c.k;
import com.cfg.mendikot.api.d.a.a.a.b.n;
import com.cfg.mendikot.api.d.a.a.a.b.p;
import com.cfg.mendikot.api.d.a.a.a.b.w.d;
import java.io.Serializable;

public class e implements p, Cloneable, Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final n f2304a;

    /* renamed from: b  reason: collision with root package name */
    public final int f2305b;

    /* renamed from: c  reason: collision with root package name */
    public final String f2306c;

    public e(n nVar, int i, String str) {
        k.a(nVar, (String) "Version");
        this.f2304a = nVar;
        k.a(i, (String) "Status code");
        this.f2305b = i;
        this.f2306c = str;
    }

    public n a() {
        return this.f2304a;
    }

    public int b() {
        return this.f2305b;
    }

    public String c() {
        return this.f2306c;
    }

    public Object clone() {
        return super.clone();
    }

    public String toString() {
        k.a(this, (String) "Status line");
        d dVar = new d(64);
        int length = a().f2274a.length() + 4 + 1 + 3 + 1;
        String c2 = c();
        if (c2 != null) {
            length += c2.length();
        }
        if (length > 0) {
            int length2 = dVar.f2317a.length;
            int i = dVar.f2318b;
            if (length > length2 - i) {
                dVar.c(i + length);
            }
        }
        n a2 = a();
        k.a(a2, (String) "Protocol version");
        int length3 = a2.f2274a.length() + 4;
        if (length3 > 0) {
            int length4 = dVar.f2317a.length;
            int i2 = dVar.f2318b;
            if (length3 > length4 - i2) {
                dVar.c(i2 + length3);
            }
        }
        dVar.a(a2.f2274a);
        dVar.a('/');
        dVar.a(Integer.toString(a2.f2275b));
        dVar.a('.');
        dVar.a(Integer.toString(a2.f2276c));
        dVar.a(' ');
        dVar.a(Integer.toString(b()));
        dVar.a(' ');
        if (c2 != null) {
            dVar.a(c2);
        }
        return dVar.toString();
    }
}
